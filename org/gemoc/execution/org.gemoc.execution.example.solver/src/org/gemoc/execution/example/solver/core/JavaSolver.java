package org.gemoc.execution.example.solver.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.commons.utils.TfsmModelLoader;
import org.gemoc.execution.example.solver.Activator;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.sample.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.FSMClock;
import org.gemoc.sample.tfsm.State;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.TimedSystem;
import org.gemoc.sample.tfsm.Transition;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;

public class JavaSolver implements Solver {

	private Resource modelOfExecutionResource = null;
	private Resource traceResource = null;
	private TraceFactory myFactory = null;
	private List<MockConstraint> constraints = null;
	private int timer = 0;

	@Override
	public void forbidEventOccurrenceReferencing(EObject target,
			EOperation operation) {
		Activator.getMessagingSystem().info(
				"TODO in MockSolver : forbid event occurrence referencing ...",
				Activator.PLUGIN_ID);
	}

	@Override
	public void forceEventOccurrenceReferencing(EObject target,
			EOperation operation) {
		Activator.getMessagingSystem().info(
				"TODO in MockSolver : force event occurrence referencing ...",
				Activator.PLUGIN_ID);
	}

	@Override
	public LogicalStep getNextStep() {
		Activator.getMessagingSystem().debug(
				"Using MockSolver to retrieve a step", Activator.PLUGIN_ID);
		LogicalStep res = myFactory.createLogicalStep();
		while (res.getEventOccurrences().isEmpty() & timer < 100) {
			for (MockConstraint constraint : this.constraints) {
				if (constraint.getTime() == timer) {
					EventOccurrence eventOccurrence = myFactory
							.createEventOccurrence();
					eventOccurrence.setFState(FiredStateKind.TICK);

					ModelElementReference targetReference = myFactory
							.createModelElementReference();
					targetReference.getElementRef().add(constraint.getTarget());

					ModelElementReference operationReference = myFactory
							.createModelElementReference();
					operationReference.getElementRef().add(
							constraint.getOperation());

					eventOccurrence.setContext(targetReference);
					eventOccurrence.setReferedElement(operationReference);

					res.getEventOccurrences().add(eventOccurrence);

				}
			}
			timer++;
		}
		return res;
	}

	@Override
	public void setModelOfExecutionFile(URI modelOfExecutionURI) {
		Resource modelResource = new TfsmModelLoader()
				.loadModel("/org.gemoc.sample.tfsm.instances/TrafficControl/TrafficControl.tfsm");
		// Créer des contraintes ...
		TimedSystem modelRoot = (TimedSystem) modelResource.getContents()
				.get(0);

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

		this.constraints = new ArrayList<MockConstraint>();
		// """Events"""
		int t;

		t = 1;
		MockConstraint fireInitControlToDay = new MockConstraint(
				initControl_to_day, "fire", t);
		this.constraints.add(fireInitControlToDay);

		t = 2;
		MockConstraint fireDayToDay = new MockConstraint(day_to_day, "fire", t);
		this.constraints.add(fireDayToDay);

		t = 3;
		MockConstraint fireDayToNight = new MockConstraint(day_to_night,
				"fire", t);
		this.constraints.add(fireDayToNight);

		t = 4;
		MockConstraint fireNightToNight = new MockConstraint(night_to_night,
				"fire", t);
		this.constraints.add(fireNightToNight);

		t = 5;
		MockConstraint fireNightToDay = new MockConstraint(night_to_day,
				"fire", t);
		this.constraints.add(fireNightToDay);

		// BONUS
		// Actions which are provoked by other actions (lower level actions, or
		// user-independent actions)

		this.constraints.add(new MockConstraint(initControl, "onLeave",
				fireInitControlToDay.getTime()));
		this.constraints.add(new MockConstraint(day, "onEnter",
				fireInitControlToDay.getTime()));
		this.constraints.add(new MockConstraint(day, "onEnter", fireDayToDay
				.getTime()));
		this.constraints.add(new MockConstraint(day, "onEnter", fireNightToDay
				.getTime()));
		this.constraints.add(new MockConstraint(day, "onLeave", fireDayToDay
				.getTime()));
		this.constraints.add(new MockConstraint(day, "onLeave", fireDayToNight
				.getTime()));
		this.constraints.add(new MockConstraint(night, "onLeave",
				fireNightToDay.getTime()));
		this.constraints.add(new MockConstraint(night, "onLeave",
				fireNightToNight.getTime()));
		this.constraints.add(new MockConstraint(night, "onEnter",
				fireDayToNight.getTime()));
		this.constraints.add(new MockConstraint(night, "onEnter",
				fireNightToNight.getTime()));

		for (int i = 0; i < 10; i++) {
			// On à t = 0,1,2,...9
			this.constraints.add(new MockConstraint(clock, "ticks", i));
		}
		// // Créer la trace ...
		// TracePackage packageInstance = TracePackage.eINSTANCE;
		// Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		// Map<String, Object> m = reg.getExtensionToFactoryMap();
		// m.put("xmi", new XMIResourceFactoryImpl());
		// ResourceSet resSet = new ResourceSetImpl();
		//
		// URI modelURI =
		// URI.createURI("models/SimplePDLCreator_Created_Process.xmi");
		// traceResource = resSet.createResource(modelURI);

		// La fabrique pour fabriquer les Ã©lÃ©ments de SimplePDL
		this.myFactory = TraceFactory.eINSTANCE;

	}

}