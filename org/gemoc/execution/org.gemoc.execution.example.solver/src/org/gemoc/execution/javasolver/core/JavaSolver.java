package org.gemoc.execution.javasolver.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.commons.utils.TfsmModelLoader;
import org.gemoc.execution.javasolver.Activator;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.sample.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.FSMClock;
import org.gemoc.sample.tfsm.State;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.TimedSystem;
import org.gemoc.sample.tfsm.Transition;
import org.gemoc.sample.tfsm.k3dsa.aspect.TFSMAspect;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;

public class JavaSolver implements Solver {

	private Resource modelOfExecutionResource = null;
	private Resource traceResource = null;
	private TraceFactory myFactory = null;
	private Resource modelResource = null;
	private State currentState = null;
	private State previousState = null;
	private int timer = 0;
	private List<MockEvent> nextEvents;
	private List<MockEvent> forbiddenEvents;

	public JavaSolver() {
		this.nextEvents = new ArrayList<MockEvent>();
		this.forbiddenEvents = new ArrayList<MockEvent>();
		this.myFactory = TraceFactory.eINSTANCE;
	}

	@Override
	public void forbidEventOccurrenceReferencing(EObject target,
			EOperation operation) {
		this.forbiddenEvents
				.add(new MockEvent(target, operation.getName()));
	}

	@Override
	public void forceEventOccurrenceReferencing(EObject target,
			EOperation operation) {
		Activator.getMessagingSystem().debug("forcing some event",
				Activator.PLUGIN_ID);
		this.nextEvents.add(new MockEvent(target, operation.getName()));

	}

	@Override
	public LogicalStep getNextStep() {
		Activator.getMessagingSystem().debug(
				"Using " + this.getClass().getName() + " to retrieve a step",
				Activator.PLUGIN_ID);
		LogicalStep res = myFactory.createLogicalStep();

		// Model Elements...
		TimedSystem modelRoot = (TimedSystem) modelResource.getContents()
				.get(0);
		TFSM tfsm = (TFSM) modelRoot.getTfsms().get(0);
		TFSMAspect.Init(tfsm);
		this.previousState = this.currentState;
		State currentState = TFSMAspect.currentState(tfsm);
		this.currentState = currentState;
		FSMClock clock = (FSMClock) modelRoot.getGlobalClocks().get(0);

		TFSM control = (TFSM) modelRoot.getTfsms().get(0);
		State initControl = (State) control.getOwnedStates().get(0);
		State day = (State) control.getOwnedStates().get(1);
		State night = (State) control.getOwnedStates().get(2);
		Transition initControl_to_day = (Transition) control
				.getOwnedTransitions().get(0);
		TemporalGuard guard_initControl_to_day = (TemporalGuard) initControl_to_day
				.getOwnedGuard();
		Transition night_to_day = (Transition) control.getOwnedTransitions()
				.get(1);
		EvaluateGuard guard_night_to_day = (EvaluateGuard) night_to_day
				.getOwnedGuard();
		Transition day_to_day = (Transition) control.getOwnedTransitions().get(
				2);
		TemporalGuard guard_day_to_day = (TemporalGuard) day_to_day
				.getOwnedGuard();
		Transition day_to_night = (Transition) control.getOwnedTransitions()
				.get(3);
		EvaluateGuard guard_day_to_night = (EvaluateGuard) day_to_night
				.getOwnedGuard();
		Transition night_to_night = (Transition) control.getOwnedTransitions()
				.get(4);
		TemporalGuard guard_night_to_night = (TemporalGuard) night_to_night
				.getOwnedGuard();

		addEvent(res, clock, "ticks");

		// Counting the time we've been in the current state...
		if (this.currentState == this.previousState) {
			this.timer++;
		} else {
			this.timer = 0;
		}

		// Case where the feedback provoked some new events, then first we
		// consider those.
		if (!this.nextEvents.isEmpty()) {
			Activator.getMessagingSystem().info("There are some nextEvents",
					Activator.PLUGIN_ID);
			for (MockEvent constraint : this.nextEvents) {
				addEvent(res, constraint.getTarget(), constraint.getOperation()
						.getName());
			}
			this.nextEvents.clear();
		} else {
			// Runtime evaluation of the dynamic state of the system... manually
			if (currentState.getName().equals("initControl")) {
				if (this.timer == guard_initControl_to_day.getAfterDuration()) {
					addEvent(res, currentState, "onLeave");
					addEvent(res, initControl_to_day, "fire");
					addEvent(res, initControl_to_day.getTarget(), "onEnter");
					this.timer = 0;
				} else {
					// Wait
				}
			} else if (currentState.getName().equals("Day")) {
				if (this.timer == guard_day_to_day.getAfterDuration()) {
					addEvent(res, currentState, "onLeave");
					addEvent(res, day_to_day, "fire");
					addEvent(res, day_to_day.getTarget(), "onEnter");
					this.timer = 0;
				} else {
					addEvent(res, guard_day_to_night, "evaluate");

				}
			} else if (currentState.getName().equals("Night")) {
				if (this.timer == guard_night_to_night.getAfterDuration()) {
					addEvent(res, currentState, "onLeave");
					addEvent(res, night_to_night, "fire");
					addEvent(res, night_to_night.getTarget(), "onEnter");
					this.timer = 0;
				} else {
					addEvent(res, guard_night_to_day, "evaluate");
				}
			}
		}
		return res;
	}

	// Does not add the event if it is in the list of forbidden events
	private void addEvent(LogicalStep res, EObject target, String methodName) {
		MockEvent newConstraint = new MockEvent(target, methodName);
		if (!this.forbiddenEvents.contains(newConstraint)) {
			res.getEventOccurrences().add(
					createEventOccurrenceFromConstraint(newConstraint));
		}
		this.forbiddenEvents.clear();
	}

	private EventOccurrence createEventOccurrenceFromConstraint(
			MockEvent constraint) {
		EventOccurrence eventOccurrence = myFactory.createEventOccurrence();
		eventOccurrence.setFState(FiredStateKind.TICK);

		ModelElementReference targetReference = myFactory
				.createModelElementReference();
		targetReference.getElementRef().add(constraint.getTarget());

		ModelElementReference operationReference = myFactory
				.createModelElementReference();
		operationReference.getElementRef().add(constraint.getOperation());

		eventOccurrence.setContext(targetReference);
		eventOccurrence.setReferedElement(operationReference);

		return eventOccurrence;
	}

	@Override
	public void setModelOfExecutionFile(URI modelOfExecutionURI) {
		this.modelResource = new TfsmModelLoader()
				.loadModel("/org.gemoc.sample.tfsm.instances/TrafficControl/TrafficControl.tfsm");
	}

}