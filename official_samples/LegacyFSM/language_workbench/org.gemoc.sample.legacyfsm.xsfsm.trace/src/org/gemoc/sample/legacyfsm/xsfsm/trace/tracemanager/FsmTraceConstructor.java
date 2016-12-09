package org.gemoc.sample.legacyfsm.xsfsm.trace.tracemanager;

import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.diverse.trace.commons.model.trace.LaunchConfiguration;
import fr.inria.diverse.trace.commons.model.trace.MSEModel;
import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.gemoc.api.ITraceConstructor;

public class FsmTraceConstructor implements ITraceConstructor {
	private fsmTrace.SpecificTrace traceRoot;
	private MSEModel mseModel;
	private Resource executedModel;
	private final Map<EObject, EObject> exeToTraced;

	private fsmTrace.States.State lastState;

	private Resource traceResource;
	private final Deque<fsmTrace.Steps.SpecificStep> context = new LinkedList<fsmTrace.Steps.SpecificStep>();

	public FsmTraceConstructor(Resource exeModel, Resource traceResource, Map<EObject, EObject> exeToTraced) {
		this.traceResource = traceResource;
		this.executedModel = exeModel;
		this.exeToTraced = exeToTraced;
	}

	private void addInitialState() {
		if (lastState == null) {
			// Creation of the initial state
			Set<Resource> allResources = getAllExecutedModelResources();
			lastState = fsmTrace.States.StatesFactory.eINSTANCE.createState();
			for (Resource r : allResources) {
				for (TreeIterator< EObject>i = r.getAllContents(); i.hasNext();) {
					EObject o = i.next();

					if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.NamedElement) {
						org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.NamedElement o_cast = (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.NamedElement) o;
						addNewObjectToState(o_cast, lastState);
					}
				}
			}
			this.traceRoot.getStatesTrace().add(lastState);
		}
	}

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedEvaluateGuard tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE
					.createTracedEvaluateGuard();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedEvaluateGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedEventGuard tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE
					.createTracedEventGuard();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedEventGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedFSMClock tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE
					.createTracedFSMClock();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedFSMClocks().add(tracedObject);

			// Creation of the first value of the field numberOfTicks
			fsmTrace.States.FSMClock_numberOfTicks_Value firstValue_numberOfTicks = fsmTrace.States.StatesFactory.eINSTANCE
					.createFSMClock_numberOfTicks_Value();

			firstValue_numberOfTicks.setNumberOfTicks((java.lang.Integer) o_cast.getNumberOfTicks());
			tracedObject.getNumberOfTicksSequence().add(firstValue_numberOfTicks);
			newState.getFSMClock_numberOfTicks_Values().add(firstValue_numberOfTicks);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedFSMEvent tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE
					.createTracedFSMEvent();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedFSMEvents().add(tracedObject);

			// Creation of the first value of the field isTriggered
			fsmTrace.States.FSMEvent_isTriggered_Value firstValue_isTriggered = fsmTrace.States.StatesFactory.eINSTANCE
					.createFSMEvent_isTriggered_Value();

			firstValue_isTriggered.setIsTriggered((boolean) o_cast.isIsTriggered());
			tracedObject.getIsTriggeredSequence().add(firstValue_isTriggered);
			newState.getFSMEvent_isTriggered_Values().add(firstValue_isTriggered);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Guard o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;
		if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard) o_cast, newState);
		}

		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.NamedElement o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;
		if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Guard) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Guard) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent) {
			added = addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent) o_cast, newState);
		}

		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedState tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE.createTracedState();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedStates().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedTemporalGuard tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE
					.createTracedTemporalGuard();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedTemporalGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedTimeFSM tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE
					.createTracedTimeFSM();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedTimeFSMs().add(tracedObject);

			// Creation of the first value of the field currentState
			fsmTrace.States.TimeFSM_currentState_Value firstValue_currentState = fsmTrace.States.StatesFactory.eINSTANCE
					.createTimeFSM_currentState_Value();

			if (o_cast.getCurrentState() != null) {
				addNewObjectToState((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State) o_cast.getCurrentState(),
						newState);
				firstValue_currentState.setCurrentState(
						(fsmTrace.States.fsm.TracedState) ((fsmTrace.States.fsm.TracedState) exeToTraced
								.get(o_cast.getCurrentState())));
			} else {
				firstValue_currentState.setCurrentState((fsmTrace.States.fsm.TracedState) null);
			}

			tracedObject.getCurrentStateSequence().add(firstValue_currentState);
			newState.getTimeFSM_currentState_Values().add(firstValue_currentState);

			// Creation of the first value of the field lastStateChangeStepNumber
			fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value firstValue_lastStateChangeStepNumber = fsmTrace.States.StatesFactory.eINSTANCE
					.createTimeFSM_lastStateChangeStepNumber_Value();

			firstValue_lastStateChangeStepNumber
					.setLastStateChangeStepNumber((int) o_cast.getLastStateChangeStepNumber());
			tracedObject.getLastStateChangeStepNumberSequence().add(firstValue_lastStateChangeStepNumber);
			newState.getTimeFSM_lastStateChangeStepNumber_Values().add(firstValue_lastStateChangeStepNumber);

			// Creation of the first value of the field stepNumber
			fsmTrace.States.TimeFSM_stepNumber_Value firstValue_stepNumber = fsmTrace.States.StatesFactory.eINSTANCE
					.createTimeFSM_stepNumber_Value();

			firstValue_stepNumber.setStepNumber((int) o_cast.getStepNumber());
			tracedObject.getStepNumberSequence().add(firstValue_stepNumber);
			newState.getTimeFSM_stepNumber_Values().add(firstValue_stepNumber);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedTimedSystem tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE
					.createTracedTimedSystem();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedTimedSystems().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition o_cast,
			fsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			fsmTrace.States.fsm.TracedTransition tracedObject = fsmTrace.States.fsm.FsmFactory.eINSTANCE
					.createTracedTransition();
			tracedObject.setOriginalObject((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getFsm_tracedTransitions().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean copiedState = false;

	private fsmTrace.States.State copyState(fsmTrace.States.State oldState) {
		fsmTrace.States.State newState = fsmTrace.States.StatesFactory.eINSTANCE.createState();
		newState.getTimeFSM_currentState_Values().addAll(oldState.getTimeFSM_currentState_Values());
		newState.getFSMEvent_isTriggered_Values().addAll(oldState.getFSMEvent_isTriggered_Values());
		newState.getTimeFSM_lastStateChangeStepNumber_Values()
				.addAll(oldState.getTimeFSM_lastStateChangeStepNumber_Values());
		newState.getFSMClock_numberOfTicks_Values().addAll(oldState.getFSMClock_numberOfTicks_Values());
		newState.getTimeFSM_stepNumber_Values().addAll(oldState.getTimeFSM_stepNumber_Values());
		copiedState = true;
		return newState;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addState(List<org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.ModelChange> changes) {
		if (lastState == null) {
			addInitialState();
		}
		if (!changes.isEmpty()) {
			boolean stateChanged = false;
			// We start by a (shallow) copy of the last state
			// But we will have to rollback a little by replacing values that changed
			fsmTrace.States.State newState = copyState(lastState);
			for (org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.ModelChange modelChange : changes) {
				EObject o = modelChange.getChangedObject();
				// Here we must look at non-collection mutable fields
				// We must rollback the last values from the copied state, and add new values as well
				// ie. mix of remove and new
				if (modelChange instanceof org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange) {
					stateChanged = true;

					org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange modelChange_cast = (org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange) modelChange;
					org.eclipse.emf.ecore.EStructuralFeature p = modelChange_cast.getChangedField();

					if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock) {
						org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock o_cast = (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock) o;

						if (p.getFeatureID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
								.getFSMClock_NumberOfTicks().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							fsmTrace.States.fsm.TracedFSMClock traced = (fsmTrace.States.fsm.TracedFSMClock) exeToTraced
									.get(o);
							fsmTrace.States.FSMClock_numberOfTicks_Value lastValue = traced.getNumberOfTicksSequence()
									.get(traced.getNumberOfTicksSequence().size() - 1);
							newState.getFSMClock_numberOfTicks_Values().remove(lastValue);

							// And we create a proper new value
							fsmTrace.States.FSMClock_numberOfTicks_Value newValue = fsmTrace.States.StatesFactory.eINSTANCE
									.createFSMClock_numberOfTicks_Value();

							java.lang.Integer value = o_cast.getNumberOfTicks();

							newValue.setNumberOfTicks((java.lang.Integer) value);

							traced.getNumberOfTicksSequence().add(newValue);
							newState.getFSMClock_numberOfTicks_Values().add(newValue);
						}
					}

					if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM) {
						org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM o_cast = (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM) o;

						if (p.getFeatureID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
								.getTimeFSM_LastStateChangeStepNumber().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							fsmTrace.States.fsm.TracedTimeFSM traced = (fsmTrace.States.fsm.TracedTimeFSM) exeToTraced
									.get(o);
							fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value lastValue = traced
									.getLastStateChangeStepNumberSequence()
									.get(traced.getLastStateChangeStepNumberSequence().size() - 1);
							newState.getTimeFSM_lastStateChangeStepNumber_Values().remove(lastValue);

							// And we create a proper new value
							fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value newValue = fsmTrace.States.StatesFactory.eINSTANCE
									.createTimeFSM_lastStateChangeStepNumber_Value();

							int value = o_cast.getLastStateChangeStepNumber();

							newValue.setLastStateChangeStepNumber((int) value);

							traced.getLastStateChangeStepNumberSequence().add(newValue);
							newState.getTimeFSM_lastStateChangeStepNumber_Values().add(newValue);
						} else

						if (p.getFeatureID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
								.getTimeFSM_CurrentState().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							fsmTrace.States.fsm.TracedTimeFSM traced = (fsmTrace.States.fsm.TracedTimeFSM) exeToTraced
									.get(o);
							fsmTrace.States.TimeFSM_currentState_Value lastValue = traced.getCurrentStateSequence()
									.get(traced.getCurrentStateSequence().size() - 1);
							newState.getTimeFSM_currentState_Values().remove(lastValue);

							// And we create a proper new value
							fsmTrace.States.TimeFSM_currentState_Value newValue = fsmTrace.States.StatesFactory.eINSTANCE
									.createTimeFSM_currentState_Value();

							fsmTrace.States.fsm.TracedState value = null;
							if (o_cast.getCurrentState() != null) {
								value = ((fsmTrace.States.fsm.TracedState) exeToTraced.get(o_cast.getCurrentState()));
							}

							newValue.setCurrentState((fsmTrace.States.fsm.TracedState) value);

							traced.getCurrentStateSequence().add(newValue);
							newState.getTimeFSM_currentState_Values().add(newValue);
						} else

						if (p.getFeatureID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
								.getTimeFSM_StepNumber().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							fsmTrace.States.fsm.TracedTimeFSM traced = (fsmTrace.States.fsm.TracedTimeFSM) exeToTraced
									.get(o);
							fsmTrace.States.TimeFSM_stepNumber_Value lastValue = traced.getStepNumberSequence()
									.get(traced.getStepNumberSequence().size() - 1);
							newState.getTimeFSM_stepNumber_Values().remove(lastValue);

							// And we create a proper new value
							fsmTrace.States.TimeFSM_stepNumber_Value newValue = fsmTrace.States.StatesFactory.eINSTANCE
									.createTimeFSM_stepNumber_Value();

							int value = o_cast.getStepNumber();

							newValue.setStepNumber((int) value);

							traced.getStepNumberSequence().add(newValue);
							newState.getTimeFSM_stepNumber_Values().add(newValue);
						}
					}

					if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent) {
						org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent o_cast = (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent) o;

						if (p.getFeatureID() == org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FsmPackage.eINSTANCE
								.getFSMEvent_IsTriggered().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							fsmTrace.States.fsm.TracedFSMEvent traced = (fsmTrace.States.fsm.TracedFSMEvent) exeToTraced
									.get(o);
							fsmTrace.States.FSMEvent_isTriggered_Value lastValue = traced.getIsTriggeredSequence()
									.get(traced.getIsTriggeredSequence().size() - 1);
							newState.getFSMEvent_isTriggered_Values().remove(lastValue);

							// And we create a proper new value
							fsmTrace.States.FSMEvent_isTriggered_Value newValue = fsmTrace.States.StatesFactory.eINSTANCE
									.createFSMEvent_isTriggered_Value();

							boolean value = o_cast.isIsTriggered();

							newValue.setIsTriggered((boolean) value);

							traced.getIsTriggeredSequence().add(newValue);
							newState.getFSMEvent_isTriggered_Values().add(newValue);
						}
					}
				}
			}
			if (stateChanged) {
				final fsmTrace.Steps.SpecificStep currentStep = context.peekFirst();
				if (currentStep != null && currentStep instanceof fr.inria.diverse.trace.commons.model.trace.BigStep) {
					final fsmTrace.States.State startingState = lastState;
					final fsmTrace.States.State endingState = newState;
					addImplicitStep(currentStep, startingState, endingState);
				}
				lastState = newState;
				traceRoot.getStatesTrace().add(lastState);
			} else if (copiedState) {
				newState.getTimeFSM_currentState_Values().clear();
				newState.getFSMEvent_isTriggered_Values().clear();
				newState.getTimeFSM_lastStateChangeStepNumber_Values().clear();
				newState.getFSMClock_numberOfTicks_Values().clear();
				newState.getTimeFSM_stepNumber_Values().clear();
			}
			copiedState = false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addStep(fr.inria.diverse.trace.commons.model.trace.Step step) {
		fsmTrace.Steps.SpecificStep step_cast = null;
		if (step != null && step instanceof fsmTrace.Steps.SpecificStep) {
			step_cast = (fsmTrace.Steps.SpecificStep) step;
			if (mseModel == null) {
				mseModel = fr.inria.diverse.trace.commons.model.trace.TraceFactory.eINSTANCE.createMSEModel();
				traceResource.getContents().add(mseModel);
			}
			mseModel.getOwnedMSEs().add(step_cast.getMseoccurrence().getMse());

			// Creating generic (or almost generic) links
			fsmTrace.States.State state = traceRoot.getStatesTrace().get(traceRoot.getStatesTrace().size() - 1);
			step_cast.setStartingState(state);
			if (!context.isEmpty() && context.getFirst() != null) {
				((SequentialStep<fsmTrace.Steps.SpecificStep>) context.getFirst()).getSubSteps().add(step_cast);
			} else {
				traceRoot.getRootStep().getSubSteps().add(step_cast);
			}

			// Adding step in its dedicated sequence/dimension
			if (step_cast instanceof fsmTrace.Steps.Fsm_FSMClock_Ticks) {
				fsmTrace.Steps.Fsm_FSMClock_Ticks fsm_FSMClock_TicksInstance = (fsmTrace.Steps.Fsm_FSMClock_Ticks) step_cast;
				traceRoot.getFsm_FSMClock_Ticks_Sequence().add(fsm_FSMClock_TicksInstance);
			} else if (step_cast instanceof fsmTrace.Steps.Fsm_FSMEvent_Trigger) {
				fsmTrace.Steps.Fsm_FSMEvent_Trigger fsm_FSMEvent_TriggerInstance = (fsmTrace.Steps.Fsm_FSMEvent_Trigger) step_cast;
				traceRoot.getFsm_FSMEvent_Trigger_Sequence().add(fsm_FSMEvent_TriggerInstance);
			} else if (step_cast instanceof fsmTrace.Steps.Fsm_FSMEvent_UnTrigger) {
				fsmTrace.Steps.Fsm_FSMEvent_UnTrigger fsm_FSMEvent_UnTriggerInstance = (fsmTrace.Steps.Fsm_FSMEvent_UnTrigger) step_cast;
				traceRoot.getFsm_FSMEvent_UnTrigger_Sequence().add(fsm_FSMEvent_UnTriggerInstance);
			} else if (step_cast instanceof fsmTrace.Steps.Fsm_State_Visit) {
				fsmTrace.Steps.Fsm_State_Visit fsm_State_VisitInstance = (fsmTrace.Steps.Fsm_State_Visit) step_cast;
				traceRoot.getFsm_State_Visit_Sequence().add(fsm_State_VisitInstance);
			} else if (step_cast instanceof fsmTrace.Steps.Fsm_TimeFSM_Init) {
				fsmTrace.Steps.Fsm_TimeFSM_Init fsm_TimeFSM_InitInstance = (fsmTrace.Steps.Fsm_TimeFSM_Init) step_cast;
				traceRoot.getFsm_TimeFSM_Init_Sequence().add(fsm_TimeFSM_InitInstance);
			} else if (step_cast instanceof fsmTrace.Steps.Fsm_Transition_Fire) {
				fsmTrace.Steps.Fsm_Transition_Fire fsm_Transition_FireInstance = (fsmTrace.Steps.Fsm_Transition_Fire) step_cast;
				traceRoot.getFsm_Transition_Fire_Sequence().add(fsm_Transition_FireInstance);
			} else if (step_cast instanceof fsmTrace.Steps.Fsm_Transition_Visit) {
				fsmTrace.Steps.Fsm_Transition_Visit fsm_Transition_VisitInstance = (fsmTrace.Steps.Fsm_Transition_Visit) step_cast;
				traceRoot.getFsm_Transition_Visit_Sequence().add(fsm_Transition_VisitInstance);
			}
		}
		context.push(step_cast);
	}

	@SuppressWarnings("unchecked")
	private void addImplicitStep(fsmTrace.Steps.SpecificStep currentStep, fsmTrace.States.State startingState,
			fsmTrace.States.State endingState) {

		fsmTrace.Steps.SpecificStep implicitStep = null;
		if (currentStep instanceof fsmTrace.Steps.Fsm_State_Visit) {
			implicitStep = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_State_Visit_ImplicitStep();
		} else if (currentStep instanceof fsmTrace.Steps.Fsm_Transition_Visit) {
			implicitStep = fsmTrace.Steps.StepsFactory.eINSTANCE.createFsm_Transition_Visit_ImplicitStep();
		}
		if (implicitStep != null) {
			implicitStep.setStartingState(startingState);
			implicitStep.setEndingState(endingState);
			((SequentialStep<fsmTrace.Steps.SpecificStep>) currentStep).getSubSteps().add(implicitStep);

		}
	}

	@Override
	public void endStep(fr.inria.diverse.trace.commons.model.trace.Step step) {
		fsmTrace.Steps.SpecificStep popped = context.pop();
		if (popped != null)
			popped.setEndingState(lastState);
	}

	@Override
	public EObject initTrace(LaunchConfiguration launchConfiguration) {
		// Create root
		traceRoot = fsmTrace.FsmTraceFactory.eINSTANCE.createSpecificTrace();
		traceRoot.setLaunchconfiguration(launchConfiguration);

		// Create root sequential step
		fr.inria.diverse.trace.commons.model.trace.SequentialStep<fsmTrace.Steps.SpecificStep> rootStep = fr.inria.diverse.trace.commons.model.trace.TraceFactory.eINSTANCE
				.createSequentialStep();
		traceRoot.setRootStep(rootStep);

		// Put in the resource
		traceResource.getContents().add(traceRoot);

		return traceRoot;
	}

	@Override
	public void save() {
		try {
			traceResource.save(null);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(URI uri) {
		try {
			traceResource.setURI(uri);
			traceResource.save(null);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	private Set<Resource> getAllExecutedModelResources() {
		Set<Resource> allResources = new HashSet<>();
		allResources.add(executedModel);
		allResources.addAll(org.gemoc.commons.eclipse.emf.EMFResource.getRelatedResources(executedModel));
		allResources.removeIf(r -> r == null);
		return allResources;
	}

	@Override
	public boolean isPartialTraceConstructor() {
		return false;
	}
}
