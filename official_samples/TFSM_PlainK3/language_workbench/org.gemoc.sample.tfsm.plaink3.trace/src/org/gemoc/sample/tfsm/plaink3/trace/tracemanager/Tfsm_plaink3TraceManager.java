package org.gemoc.sample.tfsm.plaink3.trace.tracemanager;

import fr.inria.diverse.trace.api.IValueTrace;
import fr.inria.diverse.trace.api.impl.GenericValueTrace;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.common.util.TreeIterator;

public class Tfsm_plaink3TraceManager implements fr.inria.diverse.trace.gemoc.api.IGemocTraceManager {

	private tfsm_plaink3Trace.Trace traceRoot;
	private Resource executedModel;

	private Map<EObject, EObject> exeToTraced;

	private tfsm_plaink3Trace.States.State lastState;
	private List<IValueTrace> traces;

	private Resource traceResource;
	private Deque<tfsm_plaink3Trace.Steps.Step> context = new LinkedList<tfsm_plaink3Trace.Steps.Step>();
	private static final List<String> bigSteps = Arrays.asList("Tfsm_plaink3_State_Visit",
			"Tfsm_plaink3_Transition_Visit");

	public Tfsm_plaink3TraceManager(Resource exeModel, Resource traceResource) {
		this.traceResource = traceResource;
		this.executedModel = exeModel;
		this.traces = new ArrayList<IValueTrace>();
	}

	@Override
	public boolean addStateIfChanged() {
		return addState(true);
	}

	@Override
	public void addState() {
		addState(false);
	}

	@SuppressWarnings("unchecked")
	private boolean addState(boolean onlyIfChange) {

		tfsm_plaink3Trace.States.State newState = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE.createState();
		boolean changed = false;

		// We look at each object instance of a class with mutable properties 
		// Each of these objects should eventually become a traced object

		Set<Resource> allResources = new HashSet<>();
		allResources.add(executedModel);
		allResources.addAll(org.gemoc.commons.eclipse.emf.EMFResource.getRelatedResources(executedModel));
		for (Resource r : allResources)
			for (TreeIterator<EObject> i = r.getAllContents(); i.hasNext();) {
				EObject o = i.next();

				/**
				 * Storing the state of a org.gemoc.sample.tfsm_plaink3.TFSM object
				 */
				if (o instanceof org.gemoc.sample.tfsm_plaink3.TFSM) {

					org.gemoc.sample.tfsm_plaink3.TFSM o_cast = (org.gemoc.sample.tfsm_plaink3.TFSM) o;

					storeAsTracedObject(o_cast);

					tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM tracedObject = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) exeToTraced
							.get(o);

					// Then we compare the value of the field with the last stored value
					// If same value, we create no local state and we refer to the previous
					List<tfsm_plaink3Trace.States.TFSM_currentState_Value> localTrace1 = tracedObject
							.getCurrentStateSequence();
					tfsm_plaink3Trace.States.TFSM_currentState_Value previousValue1 = null;
					if (!localTrace1.isEmpty())
						previousValue1 = localTrace1.get(localTrace1.size() - 1);

					org.gemoc.sample.tfsm_plaink3.State content1 = null;
					if (o_cast.getCurrentState() != null)
						content1 = o_cast.getCurrentState();

					boolean noChange1 = previousValue1 != null && previousValue1.getCurrentState() == content1;

					if (noChange1) {
						newState.getTFSM_currentState_Values().add(previousValue1);

					} // Else we create one
					else {
						changed = true;
						tfsm_plaink3Trace.States.TFSM_currentState_Value newValue = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
								.createTFSM_currentState_Value();

						newValue.setCurrentState(content1);

						tracedObject.getCurrentStateSequence().add(newValue);
						newState.getTFSM_currentState_Values().add(newValue);
					}

				} else

				/**
				 * Storing the state of a org.gemoc.sample.tfsm_plaink3.FSMEvent object
				 */
				if (o instanceof org.gemoc.sample.tfsm_plaink3.FSMEvent) {

					org.gemoc.sample.tfsm_plaink3.FSMEvent o_cast = (org.gemoc.sample.tfsm_plaink3.FSMEvent) o;

					storeAsTracedObject(o_cast);

					tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent tracedObject = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent) exeToTraced
							.get(o);

					// Then we compare the value of the field with the last stored value
					// If same value, we create no local state and we refer to the previous
					List<tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value> localTrace2 = tracedObject
							.getIsTriggeredSequence();
					tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value previousValue2 = null;
					if (!localTrace2.isEmpty())
						previousValue2 = localTrace2.get(localTrace2.size() - 1);

					boolean content2 = o_cast.isIsTriggered();

					boolean noChange2 = previousValue2 != null && previousValue2.isIsTriggered() == content2;

					if (noChange2) {
						newState.getFSMEvent_isTriggered_Values().add(previousValue2);

					} // Else we create one
					else {
						changed = true;
						tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value newValue = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
								.createFSMEvent_isTriggered_Value();

						newValue.setIsTriggered(content2);

						tracedObject.getIsTriggeredSequence().add(newValue);
						newState.getFSMEvent_isTriggered_Values().add(newValue);
					}

				} else

				/**
				 * Storing the state of a org.gemoc.sample.tfsm_plaink3.FSMClock object
				 */
				if (o instanceof org.gemoc.sample.tfsm_plaink3.FSMClock) {

					org.gemoc.sample.tfsm_plaink3.FSMClock o_cast = (org.gemoc.sample.tfsm_plaink3.FSMClock) o;

					storeAsTracedObject(o_cast);

					tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock tracedObject = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock) exeToTraced
							.get(o);

					// Then we compare the value of the field with the last stored value
					// If same value, we create no local state and we refer to the previous
					List<tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value> localTrace3 = tracedObject
							.getNumberOfTicksSequence();
					tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value previousValue3 = null;
					if (!localTrace3.isEmpty())
						previousValue3 = localTrace3.get(localTrace3.size() - 1);

					java.lang.Integer content3 = o_cast.getNumberOfTicks();

					boolean noChange3 = previousValue3 != null && previousValue3.getNumberOfTicks() == content3;

					if (noChange3) {
						newState.getFSMClock_numberOfTicks_Values().add(previousValue3);

					} // Else we create one
					else {
						changed = true;
						tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value newValue = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
								.createFSMClock_numberOfTicks_Value();

						newValue.setNumberOfTicks(content3);

						tracedObject.getNumberOfTicksSequence().add(newValue);
						newState.getFSMClock_numberOfTicks_Values().add(newValue);
					}

				}
			}

		boolean createNewState = lastState == null || (!onlyIfChange || changed);
		if (createNewState) {

			final tfsm_plaink3Trace.Steps.Step currentStep = context.peekFirst();
			if (currentStep != null && currentStep instanceof tfsm_plaink3Trace.Steps.BigStep) {
				final tfsm_plaink3Trace.States.State startingState = lastState;
				final tfsm_plaink3Trace.States.State endingState = newState;
				addImplicitStep(currentStep, startingState, endingState);
			}

			lastState = newState;
			traceRoot.getStatesTrace().add(lastState);
		}

		// Undoing the new state created for nothing
		else {

			newState.getStartedSteps().clear();
			newState.getEndedSteps().clear();

			newState.getTFSM_currentState_Values().clear();
			newState.getFSMEvent_isTriggered_Values().clear();
			newState.getFSMClock_numberOfTicks_Values().clear();
		}

		return createNewState;

	}

	@Override
	public void addStep(String stepRule, Map<String, Object> params) {
		addStep(stepRule, params, this.getTraceSize() - 1);
	}

	private void addStep(String stepRule, Map<String, Object> params, int stateIndex) {

		tfsm_plaink3Trace.Steps.Step toPush = null;

		if (stateIndex >= 0) {

			tfsm_plaink3Trace.States.State state = this.traceRoot.getStatesTrace().get(stateIndex);

			if (stepRule.equalsIgnoreCase("tfsm_plaink3.FSMClock.ticks")) {
				// First we create the step
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks tfsm_plaink3_FSMClock_TicksInstance = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
						.createTfsm_plaink3_FSMClock_Ticks();
				tfsm_plaink3_FSMClock_TicksInstance.setStartingState(state);

				if (!context.isEmpty() && context.getFirst() != null) {
					emfAdd(context.getFirst(), "subSteps", tfsm_plaink3_FSMClock_TicksInstance);
				} else {
					traceRoot.getRootSteps().add(tfsm_plaink3_FSMClock_TicksInstance);
				}
				toPush = tfsm_plaink3_FSMClock_TicksInstance;

				// Then we add it to its trace
				this.traceRoot.getTfsm_plaink3_FSMClock_Ticks_Sequence().add(tfsm_plaink3_FSMClock_TicksInstance);
			} else

			if (stepRule.equalsIgnoreCase("tfsm_plaink3.FSMEvent.trigger")) {
				// First we create the step
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger tfsm_plaink3_FSMEvent_TriggerInstance = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
						.createTfsm_plaink3_FSMEvent_Trigger();
				tfsm_plaink3_FSMEvent_TriggerInstance.setStartingState(state);

				if (!context.isEmpty() && context.getFirst() != null) {
					emfAdd(context.getFirst(), "subSteps", tfsm_plaink3_FSMEvent_TriggerInstance);
				} else {
					traceRoot.getRootSteps().add(tfsm_plaink3_FSMEvent_TriggerInstance);
				}
				toPush = tfsm_plaink3_FSMEvent_TriggerInstance;

				// Then we add it to its trace
				this.traceRoot.getTfsm_plaink3_FSMEvent_Trigger_Sequence().add(tfsm_plaink3_FSMEvent_TriggerInstance);
			} else

			if (stepRule.equalsIgnoreCase("tfsm_plaink3.FSMEvent.unTrigger")) {
				// First we create the step
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger tfsm_plaink3_FSMEvent_UnTriggerInstance = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
						.createTfsm_plaink3_FSMEvent_UnTrigger();
				tfsm_plaink3_FSMEvent_UnTriggerInstance.setStartingState(state);

				if (!context.isEmpty() && context.getFirst() != null) {
					emfAdd(context.getFirst(), "subSteps", tfsm_plaink3_FSMEvent_UnTriggerInstance);
				} else {
					traceRoot.getRootSteps().add(tfsm_plaink3_FSMEvent_UnTriggerInstance);
				}
				toPush = tfsm_plaink3_FSMEvent_UnTriggerInstance;

				// Then we add it to its trace
				this.traceRoot.getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().add(
						tfsm_plaink3_FSMEvent_UnTriggerInstance);
			} else

			if (stepRule.equalsIgnoreCase("tfsm_plaink3.State.visit")) {
				// First we create the step
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit tfsm_plaink3_State_VisitInstance = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
						.createTfsm_plaink3_State_Visit();
				tfsm_plaink3_State_VisitInstance.setStartingState(state);

				if (!context.isEmpty() && context.getFirst() != null) {
					emfAdd(context.getFirst(), "subSteps", tfsm_plaink3_State_VisitInstance);
				} else {
					traceRoot.getRootSteps().add(tfsm_plaink3_State_VisitInstance);
				}
				toPush = tfsm_plaink3_State_VisitInstance;

				// Then we add it to its trace
				this.traceRoot.getTfsm_plaink3_State_Visit_Sequence().add(tfsm_plaink3_State_VisitInstance);
			} else

			if (stepRule.equalsIgnoreCase("tfsm_plaink3.TFSM.init")) {
				// First we create the step
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init tfsm_plaink3_TFSM_InitInstance = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
						.createTfsm_plaink3_TFSM_Init();
				tfsm_plaink3_TFSM_InitInstance.setStartingState(state);

				if (!context.isEmpty() && context.getFirst() != null) {
					emfAdd(context.getFirst(), "subSteps", tfsm_plaink3_TFSM_InitInstance);
				} else {
					traceRoot.getRootSteps().add(tfsm_plaink3_TFSM_InitInstance);
				}
				toPush = tfsm_plaink3_TFSM_InitInstance;

				// Then we add it to its trace
				this.traceRoot.getTfsm_plaink3_TFSM_Init_Sequence().add(tfsm_plaink3_TFSM_InitInstance);
			} else

			if (stepRule.equalsIgnoreCase("tfsm_plaink3.Transition.fire")) {
				// First we create the step
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire tfsm_plaink3_Transition_FireInstance = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
						.createTfsm_plaink3_Transition_Fire();
				tfsm_plaink3_Transition_FireInstance.setStartingState(state);

				if (!context.isEmpty() && context.getFirst() != null) {
					emfAdd(context.getFirst(), "subSteps", tfsm_plaink3_Transition_FireInstance);
				} else {
					traceRoot.getRootSteps().add(tfsm_plaink3_Transition_FireInstance);
				}
				toPush = tfsm_plaink3_Transition_FireInstance;

				// Then we add it to its trace
				this.traceRoot.getTfsm_plaink3_Transition_Fire_Sequence().add(tfsm_plaink3_Transition_FireInstance);
			} else

			if (stepRule.equalsIgnoreCase("tfsm_plaink3.Transition.visit")) {
				// First we create the step
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit tfsm_plaink3_Transition_VisitInstance = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
						.createTfsm_plaink3_Transition_Visit();
				tfsm_plaink3_Transition_VisitInstance.setStartingState(state);

				if (!context.isEmpty() && context.getFirst() != null) {
					emfAdd(context.getFirst(), "subSteps", tfsm_plaink3_Transition_VisitInstance);
				} else {
					traceRoot.getRootSteps().add(tfsm_plaink3_Transition_VisitInstance);
				}
				toPush = tfsm_plaink3_Transition_VisitInstance;

				// Then we add it to its trace
				this.traceRoot.getTfsm_plaink3_Transition_Visit_Sequence().add(tfsm_plaink3_Transition_VisitInstance);
			}

		}

		context.push(toPush);

	}

	private void addImplicitStep(tfsm_plaink3Trace.Steps.Step currentStep,
			tfsm_plaink3Trace.States.State startingState, tfsm_plaink3Trace.States.State endingState) {
		tfsm_plaink3Trace.Steps.Step implicitStep = null;
		if (currentStep instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) {
			implicitStep = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_State_Visit_ImplicitStep();
		} else if (currentStep instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) {
			implicitStep = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
					.createTfsm_plaink3_Transition_Visit_ImplicitStep();
		}
		if (implicitStep != null) {
			implicitStep.setStartingState(startingState);
			implicitStep.setEndingState(endingState);
			emfAdd(currentStep, "subSteps", implicitStep);
		}
	}

	@Override
	public boolean addStep(org.gemoc.executionframework.engine.mse.MSEOccurrence mseOccurrence) {

		tfsm_plaink3Trace.Steps.Step step = null;

		if (mseOccurrence != null && mseOccurrence instanceof tfsm_plaink3Trace.Steps.Step) {

			step = (tfsm_plaink3Trace.Steps.Step) mseOccurrence;

			// Creating generic (or almost generic) links
			tfsm_plaink3Trace.States.State state = this.traceRoot.getStatesTrace().get(this.getTraceSize() - 1);
			step.setStartingState(state);
			if (!context.isEmpty() && context.getFirst() != null) {
				emfAdd(context.getFirst(), "subSteps", step);
			} else {
				traceRoot.getRootSteps().add(step);
			}

			// Adding step in its dedicated sequence/dimension
			if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks tfsm_plaink3_FSMClock_TicksInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks) step;
				this.traceRoot.getTfsm_plaink3_FSMClock_Ticks_Sequence().add(tfsm_plaink3_FSMClock_TicksInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger tfsm_plaink3_FSMEvent_TriggerInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger) step;
				this.traceRoot.getTfsm_plaink3_FSMEvent_Trigger_Sequence().add(tfsm_plaink3_FSMEvent_TriggerInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger tfsm_plaink3_FSMEvent_UnTriggerInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger) step;
				this.traceRoot.getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().add(
						tfsm_plaink3_FSMEvent_UnTriggerInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit tfsm_plaink3_State_VisitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) step;
				this.traceRoot.getTfsm_plaink3_State_Visit_Sequence().add(tfsm_plaink3_State_VisitInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init tfsm_plaink3_TFSM_InitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init) step;
				this.traceRoot.getTfsm_plaink3_TFSM_Init_Sequence().add(tfsm_plaink3_TFSM_InitInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire tfsm_plaink3_Transition_FireInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire) step;
				this.traceRoot.getTfsm_plaink3_Transition_Fire_Sequence().add(tfsm_plaink3_Transition_FireInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit tfsm_plaink3_Transition_VisitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) step;
				this.traceRoot.getTfsm_plaink3_Transition_Visit_Sequence().add(tfsm_plaink3_Transition_VisitInstance);
			}
		}
		context.push(step);

		return (step != null);
	}

	@Override
	public void endStep(String stepRule, Object returnValue) {
		tfsm_plaink3Trace.Steps.Step popped = context.pop();
		if (popped != null)
			popped.setEndingState(lastState);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void goTo(EObject state) {

		if (state instanceof tfsm_plaink3Trace.States.State) {
			tfsm_plaink3Trace.States.State stateToGo = (tfsm_plaink3Trace.States.State) state;

			for (tfsm_plaink3Trace.States.TFSM_currentState_Value value : stateToGo.getTFSM_currentState_Values()) {

				if (value.getParent() instanceof tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) {
					tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM parent_cast = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) value
							.getParent();
					org.gemoc.sample.tfsm_plaink3.State toset = value.getCurrentState();
					org.gemoc.sample.tfsm_plaink3.State current = ((org.gemoc.sample.tfsm_plaink3.TFSM) parent_cast
							.getOriginalObject_NamedElement()).getCurrentState();
					if (current != toset)
						((org.gemoc.sample.tfsm_plaink3.TFSM) parent_cast.getOriginalObject_NamedElement())
								.setCurrentState(toset);

				}

			}

			for (tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value value : stateToGo.getFSMEvent_isTriggered_Values()) {

				if (value.getParent() instanceof tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent) {
					tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent parent_cast = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent) value
							.getParent();
					boolean toset = value.isIsTriggered();
					boolean current = ((org.gemoc.sample.tfsm_plaink3.FSMEvent) parent_cast
							.getOriginalObject_NamedElement()).isIsTriggered();
					if (current != toset)
						((org.gemoc.sample.tfsm_plaink3.FSMEvent) parent_cast.getOriginalObject_NamedElement())
								.setIsTriggered(toset);

				}

			}

			for (tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value value : stateToGo
					.getFSMClock_numberOfTicks_Values()) {

				if (value.getParent() instanceof tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock) {
					tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock parent_cast = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock) value
							.getParent();
					java.lang.Integer toset = value.getNumberOfTicks();
					java.lang.Integer current = ((org.gemoc.sample.tfsm_plaink3.FSMClock) parent_cast
							.getOriginalObject_NamedElement()).getNumberOfTicks();
					if (current != toset)
						((org.gemoc.sample.tfsm_plaink3.FSMClock) parent_cast.getOriginalObject_NamedElement())
								.setNumberOfTicks(toset);

				}

			}

		} else {
			goToValue(state);
		}
	}

	@Override
	public void goTo(int stepNumber) {
		tfsm_plaink3Trace.States.State stateToGo = traceRoot.getStatesTrace().get(stepNumber);
		goTo(stateToGo);
	}

	private void goToValue(EObject value) {
		Object states = emfGet(value, "states");
		if (states != null) {
			if (states instanceof List<?>) {
				// We get the first state in which this value existed
				Object state = ((List<?>) states).get(0);
				if (state instanceof tfsm_plaink3Trace.States.State) {
					goTo((tfsm_plaink3Trace.States.State) state);
				}
			}
		}
	}

	@Override
	public void initTrace() {
		// Create root
		this.traceRoot = tfsm_plaink3Trace.Tfsm_plaink3TraceFactory.eINSTANCE.createTrace();

		// Put in the resource
		traceResource.getContents().add(traceRoot);

		// Initializing the map exeobject -> tracedobject
		this.exeToTraced = new HashMap<EObject, EObject>();
	}

	@Override
	public void save() {
		//try {
		//	traceResource.save(null);
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
	}

	@Override
	public String getDescriptionOfExecutionState(int index) {
		StringBuilder result = new StringBuilder();
		tfsm_plaink3Trace.States.State gs = traceRoot.getStatesTrace().get(index);

		if (!gs.getTFSM_currentState_Values().isEmpty())
			result.append("\nCurrentState values:");
		for (tfsm_plaink3Trace.States.TFSM_currentState_Value currentState : gs.getTFSM_currentState_Values()) {
			result.append("\n\t" + currentState.getCurrentState());
		}

		if (!gs.getFSMEvent_isTriggered_Values().isEmpty())
			result.append("\nIsTriggered values:");
		for (tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value currentState : gs.getFSMEvent_isTriggered_Values()) {
			result.append("\n\t" + currentState.isIsTriggered());
		}

		if (!gs.getFSMClock_numberOfTicks_Values().isEmpty())
			result.append("\nNumberOfTicks values:");
		for (tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value currentState : gs.getFSMClock_numberOfTicks_Values()) {
			result.append("\n\t" + currentState.getNumberOfTicks());
		}

		if (!gs.getStartedSteps().isEmpty()) {
			result.append("\n\nStarting steps: ");
			for (tfsm_plaink3Trace.Steps.Step m : gs.getStartedSteps()) {
				result.append("\n\t" + m.eClass().getName());
				if (m.getEndingState() != null) {
					result.append(" (ends at state " + traceRoot.getStatesTrace().indexOf(m.getEndingState()) + ")");
				}
			}
		}

		result.deleteCharAt(0);
		return result.toString();
	}

	@Override
	public String getDescriptionOfValue(EObject eObject) {
		if (eObject instanceof tfsm_plaink3Trace.States.TFSM_currentState_Value) {
			return "tfsm_plaink3Trace.States.TFSM_currentState_Value: "
					+ ((tfsm_plaink3Trace.States.TFSM_currentState_Value) eObject).getCurrentState();
		} else if (eObject instanceof tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value) {
			return "tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value: "
					+ ((tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value) eObject).isIsTriggered();
		} else if (eObject instanceof tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value) {
			return "tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value: "
					+ ((tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value) eObject).getNumberOfTicks();
		} else
			return "ERROR";
	}

	private void storeAsTracedObject(org.gemoc.sample.tfsm_plaink3.FSMClock o) {

		// First we find the traced object, and we create it if required
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock tracedObject;
		if (!exeToTraced.containsKey(o)) {
			tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE.createTracedFSMClock();
			tracedObject.setOriginalObject_NamedElement(o);
			exeToTraced.put(o, tracedObject);
			traceRoot.getTfsm_plaink3_tracedFSMClocks().add(tracedObject);

			traces.add(new GenericValueTrace(tracedObject.getNumberOfTicksSequence(), this));
		}
	}

	private void storeAsTracedObject(org.gemoc.sample.tfsm_plaink3.FSMEvent o) {

		// First we find the traced object, and we create it if required
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent tracedObject;
		if (!exeToTraced.containsKey(o)) {
			tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE.createTracedFSMEvent();
			tracedObject.setOriginalObject_NamedElement(o);
			exeToTraced.put(o, tracedObject);
			traceRoot.getTfsm_plaink3_tracedFSMEvents().add(tracedObject);

			traces.add(new GenericValueTrace(tracedObject.getIsTriggeredSequence(), this));
		}
	}

	private void storeAsTracedObject(org.gemoc.sample.tfsm_plaink3.NamedElement o) {

		// First we find the traced object, and we create it if required
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement tracedObject;
		if (!exeToTraced.containsKey(o)) {
			tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedNamedElement();
			tracedObject.setOriginalObject_NamedElement(o);
			exeToTraced.put(o, tracedObject);
			traceRoot.getTfsm_plaink3_tracedNamedElements().add(tracedObject);

		}
	}

	private void storeAsTracedObject(org.gemoc.sample.tfsm_plaink3.TFSM o) {

		// First we find the traced object, and we create it if required
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM tracedObject;
		if (!exeToTraced.containsKey(o)) {
			tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE.createTracedTFSM();
			tracedObject.setOriginalObject_NamedElement(o);
			exeToTraced.put(o, tracedObject);
			traceRoot.getTfsm_plaink3_tracedTFSMs().add(tracedObject);

			traces.add(new GenericValueTrace(tracedObject.getCurrentStateSequence(), this));
		}
	}

	private void storeAsTracedObject(EObject o) {
		if (o instanceof org.gemoc.sample.tfsm_plaink3.TFSM) {
			storeAsTracedObject((org.gemoc.sample.tfsm_plaink3.TFSM) o);
		} else if (o instanceof org.gemoc.sample.tfsm_plaink3.FSMEvent) {
			storeAsTracedObject((org.gemoc.sample.tfsm_plaink3.FSMEvent) o);
		} else if (o instanceof org.gemoc.sample.tfsm_plaink3.FSMClock) {
			storeAsTracedObject((org.gemoc.sample.tfsm_plaink3.FSMClock) o);
		} else if (o instanceof org.gemoc.sample.tfsm_plaink3.NamedElement) {
			storeAsTracedObject((org.gemoc.sample.tfsm_plaink3.NamedElement) o);
		}
	}

	private Collection<? extends EObject> getExeToTraced(Collection<? extends EObject> exeObjects) {
		Collection<EObject> result = new ArrayList<EObject>();
		for (EObject exeObject : exeObjects) {
			storeAsTracedObject(exeObject);
			result.add(exeToTraced.get(exeObject));
		}
		return result;
	}

	private Collection<? extends EObject> getTracedToExe(Collection<? extends EObject> tracedObjects) {
		Collection<EObject> result = new ArrayList<EObject>();
		for (EObject tracedObject : tracedObjects) {
			result.add(getTracedToExe(tracedObject));
		}
		return result;
	}

	private EObject getTracedToExe(EObject tracedObject) {
		for (EObject key : exeToTraced.keySet()) {
			if (exeToTraced.get(key) == tracedObject)
				return key;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private static void emfAdd(EObject o, String property, Object value) {
		for (EReference r : o.eClass().getEAllReferences()) {
			if (r.getName().equalsIgnoreCase(property)) {
				Object coll = o.eGet(r);
				if (coll instanceof Collection) {
					((Collection<Object>) coll).add(value);
					return;
				}
			}
		}
	}

	private static Object emfGet(EObject o, String property) {
		for (EReference r : o.eClass().getEAllReferences()) {
			if (r.getName().equalsIgnoreCase(property)) {
				return o.eGet(r);
			}
		}
		return null;
	}

	@Override
	public EObject getExecutionState(int index) {
		return traceRoot.getStatesTrace().get(index);
	}

	@Override
	public int getTraceSize() {
		return traceRoot.getStatesTrace().size();
	}

	@Override
	public int getNumberOfValueTraces() {
		return traces.size();
	}

	@Override
	public Set<EObject> getAllCurrentValues(int stateIndex) {
		tfsm_plaink3Trace.States.State currentState = this.traceRoot.getStatesTrace().get(stateIndex);
		// We find all current values
		Set<EObject> currentValues = new HashSet<EObject>();
		if (currentState != null) {
			currentValues.addAll(currentState.getTFSM_currentState_Values());
			currentValues.addAll(currentState.getFSMEvent_isTriggered_Values());
			currentValues.addAll(currentState.getFSMClock_numberOfTicks_Values());
		}
		return currentValues;
	}

	public List<IValueTrace> getAllValueTraces() {
		return traces;
	}

	@Override
	public int getStateOrValueIndex(EObject stateOrValue) {
		int idx = traceRoot.getStatesTrace().indexOf(stateOrValue);
		if (idx == -1) {
			final Object states = emfGet(stateOrValue, "states");
			if (states != null) {
				if (states instanceof List<?>) {
					// We get the first state in which this value existed
					Object valueState = ((List<?>) states).get(0);
					if (valueState instanceof tfsm_plaink3Trace.States.State) {
						idx = traceRoot.getStatesTrace().indexOf(valueState);
					}
				}
			}
		}
		return idx;
	}

	@Override
	public String currentBigStep() {
		if (!context.isEmpty() && context.getFirst() != null)
			return context.getFirst().eClass().getName();
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<fr.inria.diverse.trace.api.IStep> getStackForwardAfterState(int stateIndex) {
		List<fr.inria.diverse.trace.api.IStep> result = new ArrayList<fr.inria.diverse.trace.api.IStep>();
		tfsm_plaink3Trace.States.State currentState = this.traceRoot.getStatesTrace().get(stateIndex);

		// We start at the top of the forward stack, and we go downward
		tfsm_plaink3Trace.Steps.Step itStep = currentState.getStartedSteps().get(0);
		while (itStep != null) {
			tfsm_plaink3Trace.Steps.Step itStep_prev = itStep;
			if (itStep instanceof tfsm_plaink3Trace.Steps.Step) {
				result.add(createGenericStep((tfsm_plaink3Trace.Steps.Step) itStep));
				List<tfsm_plaink3Trace.Steps.Step> subSteps = (List<tfsm_plaink3Trace.Steps.Step>) emfGet(itStep,
						"subSteps");
				if (subSteps != null) {
					itStep = subSteps.get(0);
				}
			}

			// If we didn't find anything new, we stop
			if (itStep == itStep_prev)
				itStep = null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<fr.inria.diverse.trace.api.IStep> getStackBackward(int stateIndex) {
		List<fr.inria.diverse.trace.api.IStep> result = new ArrayList<fr.inria.diverse.trace.api.IStep>();
		tfsm_plaink3Trace.States.State currentState = this.traceRoot.getStatesTrace().get(stateIndex);

		// We start at the top of the backward stack, and we go downward
		tfsm_plaink3Trace.Steps.Step itStep = currentState.getEndedSteps().get(0);
		while (itStep != null) {
			tfsm_plaink3Trace.Steps.Step itStep_prev = itStep;
			if (itStep instanceof tfsm_plaink3Trace.Steps.Step) {
				result.add(createGenericStep((tfsm_plaink3Trace.Steps.Step) itStep));
				List<tfsm_plaink3Trace.Steps.Step> subSteps = (List<tfsm_plaink3Trace.Steps.Step>) emfGet(itStep,
						"subSteps");
				if (subSteps != null) {
					itStep = subSteps.get(subSteps.size() - 1);
				}
			}

			// If we didn't find anything new, we stop
			if (itStep == itStep_prev)
				itStep = null;
		}
		return result;
	}

	@Override
	public List<fr.inria.diverse.trace.api.IStep> getStackForwardBeforeState(int stateIndex) {
		LinkedList<fr.inria.diverse.trace.api.IStep> result = new LinkedList<fr.inria.diverse.trace.api.IStep>();
		tfsm_plaink3Trace.States.State currentState = this.traceRoot.getStatesTrace().get(stateIndex);
		List<tfsm_plaink3Trace.Steps.Step> endedSteps = currentState.getEndedSteps();

		if (!endedSteps.isEmpty()) {
			final tfsm_plaink3Trace.Steps.Step endedStep = endedSteps.get(0);
			if (endedStep.getStartingState() != currentState) {
				result.addFirst(createGenericStep(endedStep));
			}
			EObject itStep = endedStep.eContainer();
			while (itStep != null) {
				if (itStep instanceof tfsm_plaink3Trace.Steps.Step) {
					tfsm_plaink3Trace.Steps.Step step = (tfsm_plaink3Trace.Steps.Step) itStep;
					if (step.getStartingState() != currentState) {
						result.addFirst(createGenericStep(step));
					}
					itStep = itStep.eContainer();
				} else {
					itStep = null;
				}
			}
		}
		return result;
	}

	@Override
	public List<fr.inria.diverse.trace.api.IStep.StepEvent> getEventsForState(int stateIndex) {
		final Map<tfsm_plaink3Trace.Steps.Step, fr.inria.diverse.trace.api.IStep> step2IStep = new HashMap<>();
	
		final tfsm_plaink3Trace.States.State currentState = this.traceRoot.getStatesTrace().get(stateIndex);
	
		final List<fr.inria.diverse.trace.api.IStep> endedSteps = currentState.getEndedSteps().stream().map(s -> {
			return step2IStep.computeIfAbsent(s, k -> createGenericStep(k));
		}).collect(Collectors.toList());
	
		final List<fr.inria.diverse.trace.api.IStep> startedSteps = currentState.getStartedSteps().stream().map(s -> {
			return step2IStep.computeIfAbsent(s, k -> createGenericStep(k));
		}).collect(Collectors.toList());
	
		final List<fr.inria.diverse.trace.api.IStep.StepEvent> events = new ArrayList<>();
		final LinkedList<fr.inria.diverse.trace.api.IStep> virtualStack = new LinkedList<>();
	
		final Iterator<fr.inria.diverse.trace.api.IStep> itEnding = endedSteps.iterator();
		final Iterator<fr.inria.diverse.trace.api.IStep> itStarting = startedSteps.iterator();
	
		while (itEnding.hasNext()) {
			// As long as we have ending steps
			final fr.inria.diverse.trace.api.IStep endedIStep = itEnding.next();
			if (endedIStep.getStartingIndex() != stateIndex) {
				events.add(new fr.inria.diverse.trace.api.IStep.StepEvent(endedIStep, false));
			} else {
				if (virtualStack.peek() == endedIStep) {
					// A start event on this step has already been treated,
					// we thus can treat this end event.
					events.add(new fr.inria.diverse.trace.api.IStep.StepEvent(endedIStep, false));
					virtualStack.pop();
				} else {
					while (virtualStack.peek() != endedIStep && itStarting.hasNext()) {
						// Pushing steps that start onto the stack until we pushed the one
						// we are trying to pop or we run out of steps.
						final fr.inria.diverse.trace.api.IStep startedIStep = itStarting.next();
						virtualStack.push(startedIStep);
						events.add(new fr.inria.diverse.trace.api.IStep.StepEvent(startedIStep, true));
					}
					if (virtualStack.peek() == endedIStep) {
						// We try again.
						events.add(new fr.inria.diverse.trace.api.IStep.StepEvent(endedIStep, false));
						virtualStack.pop();
					} else {
						// If it failed again, throw an exception. Not supposed to happen.
						throw new IllegalStateException();
					}
				}
			}
		}
		
		while (itStarting.hasNext()) {
			final fr.inria.diverse.trace.api.IStep startedIStep = itStarting.next();
			events.add(new fr.inria.diverse.trace.api.IStep.StepEvent(startedIStep, true));
		}
	
		return events;
	}

	private fr.inria.diverse.trace.api.IStep generateStep(tfsm_plaink3Trace.Steps.Step step) {
		fr.inria.diverse.trace.api.IStep result = null;

		fr.inria.diverse.trace.api.IStep parentStep = null;
		if (step.eContainer() instanceof tfsm_plaink3Trace.Steps.Step) {
			parentStep = createGenericStep((tfsm_plaink3Trace.Steps.Step) step.eContainer());
		}

		if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks) {
			tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks step_cast = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks) step;
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.FSMClock", "ticks",
					startIndex, endIndex, parentStep);
			result.addParameter("caller", (step_cast.getCaller()));
			result.addParameter("this", step);

		} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger) {
			tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger step_cast = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger) step;
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.FSMEvent",
					"trigger", startIndex, endIndex, parentStep);
			result.addParameter("caller", (step_cast.getCaller()));
			result.addParameter("this", step);

		} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger) {
			tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger step_cast = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger) step;
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.FSMEvent",
					"unTrigger", startIndex, endIndex, parentStep);
			result.addParameter("caller", (step_cast.getCaller()));
			result.addParameter("this", step);

		} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) {
			tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit step_cast = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) step;
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.State", "visit",
					startIndex, endIndex, parentStep);
			result.addParameter("caller", (step_cast.getCaller()));
			result.addParameter("this", step);

		} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init) {
			tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init step_cast = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init) step;
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.TFSM", "init",
					startIndex, endIndex, parentStep);
			result.addParameter("caller", (step_cast.getCaller()));
			result.addParameter("this", step);

		} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire) {
			tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire step_cast = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire) step;
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.Transition",
					"fire", startIndex, endIndex, parentStep);
			result.addParameter("caller", (step_cast.getCaller()));
			result.addParameter("this", step);

		} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) {
			tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit step_cast = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) step;
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.Transition",
					"visit", startIndex, endIndex, parentStep);
			result.addParameter("caller", (step_cast.getCaller()));
			result.addParameter("this", step);

		} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_ImplicitStep) {
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.State",
					"implicitStep", startIndex, endIndex, parentStep);
			result.addParameter("this", step);
		} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_ImplicitStep) {
			int startIndex = this.traceRoot.getStatesTrace().indexOf(step.getStartingState());
			int endIndex = this.traceRoot.getStatesTrace().indexOf(step.getEndingState());

			result = new fr.inria.diverse.trace.api.impl.GenericStep("org.gemoc.sample.tfsm_plaink3.Transition",
					"implicitStep", startIndex, endIndex, parentStep);
			result.addParameter("this", step);
		}

		return result;
	}

	private fr.inria.diverse.trace.api.IStep createGenericStep(tfsm_plaink3Trace.Steps.Step step) {
		return new fr.inria.diverse.trace.api.impl.LazyGenericStep(() -> {
			return generateStep(step);
		});
		
	}
}
