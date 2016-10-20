package org.gemoc.sample.tfsm.sequential.xtfsm.trace.tracemanager;

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

public class TfsmTraceConstructor implements ITraceConstructor {
	private tfsmTrace.SpecificTrace traceRoot;
	private MSEModel mseModel;
	private Resource executedModel;
	private final Map<EObject, EObject> exeToTraced;

	private tfsmTrace.States.State lastState;

	private Resource traceResource;
	private final Deque<tfsmTrace.Steps.SpecificStep> context = new LinkedList<tfsmTrace.Steps.SpecificStep>();

	public TfsmTraceConstructor(Resource exeModel, Resource traceResource, Map<EObject, EObject> exeToTraced) {
		this.traceResource = traceResource;
		this.executedModel = exeModel;
		this.exeToTraced = exeToTraced;
	}

	private void addInitialState() {
		if (lastState == null) {
			// Creation of the initial state
			Set<Resource> allResources = getAllExecutedModelResources();
			lastState = tfsmTrace.States.StatesFactory.eINSTANCE.createState();
			for (Resource r : allResources) {
				for (TreeIterator<EObject> i = r.getAllContents(); i.hasNext();) {
					EObject o = i.next();

					if (o instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.NamedElement) {
						org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.NamedElement o_cast = (org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.NamedElement) o;
						addNewObjectToState(o_cast, lastState);
					}
				}
			}
			this.traceRoot.getStatesTrace().add(lastState);
		}
	}

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EvaluateGuard o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedEvaluateGuard tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedEvaluateGuard();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EvaluateGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedEvaluateGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EventGuard o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedEventGuard tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedEventGuard();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EventGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedEventGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedFSMClock tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedFSMClock();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedFSMClocks().add(tracedObject);

			// Creation of the first value of the field numberOfTicks
			tfsmTrace.States.FSMClock_numberOfTicks_Value firstValue_numberOfTicks = tfsmTrace.States.StatesFactory.eINSTANCE
					.createFSMClock_numberOfTicks_Value();

			firstValue_numberOfTicks.setNumberOfTicks((java.lang.Integer) o_cast.getNumberOfTicks());
			tracedObject.getNumberOfTicksSequence().add(firstValue_numberOfTicks);
			newState.getFSMClock_numberOfTicks_Values().add(firstValue_numberOfTicks);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedFSMEvent tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedFSMEvent();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedFSMEvents().add(tracedObject);

			// Creation of the first value of the field isTriggered
			tfsmTrace.States.FSMEvent_isTriggered_Value firstValue_isTriggered = tfsmTrace.States.StatesFactory.eINSTANCE
					.createFSMEvent_isTriggered_Value();

			firstValue_isTriggered.setIsTriggered((boolean) o_cast.isIsTriggered());
			tracedObject.getIsTriggeredSequence().add(firstValue_isTriggered);
			newState.getFSMEvent_isTriggered_Values().add(firstValue_isTriggered);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Guard o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;
		if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EvaluateGuard) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EvaluateGuard) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EventGuard) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EventGuard) o_cast, newState);
		}

		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.NamedElement o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;
		if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TimedSystem) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TimedSystem) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Transition) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Transition) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.State) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.State) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Guard) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Guard) o_cast, newState);
		}

		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.State o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedState tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedState();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.State) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedStates().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedTFSM tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedTFSM();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedTFSMs().add(tracedObject);

			// Creation of the first value of the field currentState
			tfsmTrace.States.TFSM_currentState_Value firstValue_currentState = tfsmTrace.States.StatesFactory.eINSTANCE
					.createTFSM_currentState_Value();

			if (o_cast.getCurrentState() != null) {
				addNewObjectToState((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.State) o_cast.getCurrentState(),
						newState);
				firstValue_currentState.setCurrentState(
						(tfsmTrace.States.tfsm.TracedState) ((tfsmTrace.States.tfsm.TracedState) exeToTraced
								.get(o_cast.getCurrentState())));
			} else {
				firstValue_currentState.setCurrentState((tfsmTrace.States.tfsm.TracedState) null);
			}

			tracedObject.getCurrentStateSequence().add(firstValue_currentState);
			newState.getTFSM_currentState_Values().add(firstValue_currentState);

			// Creation of the first value of the field lastStateChangeStepNumber
			tfsmTrace.States.TFSM_lastStateChangeStepNumber_Value firstValue_lastStateChangeStepNumber = tfsmTrace.States.StatesFactory.eINSTANCE
					.createTFSM_lastStateChangeStepNumber_Value();

			firstValue_lastStateChangeStepNumber
					.setLastStateChangeStepNumber((int) o_cast.getLastStateChangeStepNumber());
			tracedObject.getLastStateChangeStepNumberSequence().add(firstValue_lastStateChangeStepNumber);
			newState.getTFSM_lastStateChangeStepNumber_Values().add(firstValue_lastStateChangeStepNumber);

			// Creation of the first value of the field stepNumber
			tfsmTrace.States.TFSM_stepNumber_Value firstValue_stepNumber = tfsmTrace.States.StatesFactory.eINSTANCE
					.createTFSM_stepNumber_Value();

			firstValue_stepNumber.setStepNumber((int) o_cast.getStepNumber());
			tracedObject.getStepNumberSequence().add(firstValue_stepNumber);
			newState.getTFSM_stepNumber_Values().add(firstValue_stepNumber);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedTemporalGuard tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedTemporalGuard();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedTemporalGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TimedSystem o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedTimedSystem tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedTimedSystem();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TimedSystem) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedTimedSystems().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Transition o_cast,
			tfsmTrace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsmTrace.States.tfsm.TracedTransition tracedObject = tfsmTrace.States.tfsm.TfsmFactory.eINSTANCE
					.createTracedTransition();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Transition) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_tracedTransitions().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean copiedState = false;

	private tfsmTrace.States.State copyState(tfsmTrace.States.State oldState) {
		tfsmTrace.States.State newState = tfsmTrace.States.StatesFactory.eINSTANCE.createState();
		newState.getTFSM_currentState_Values().addAll(oldState.getTFSM_currentState_Values());
		newState.getFSMEvent_isTriggered_Values().addAll(oldState.getFSMEvent_isTriggered_Values());
		newState.getTFSM_lastStateChangeStepNumber_Values().addAll(oldState.getTFSM_lastStateChangeStepNumber_Values());
		newState.getFSMClock_numberOfTicks_Values().addAll(oldState.getFSMClock_numberOfTicks_Values());
		newState.getTFSM_stepNumber_Values().addAll(oldState.getTFSM_stepNumber_Values());
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
			tfsmTrace.States.State newState = copyState(lastState);
			for (org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.ModelChange modelChange : changes) {
				EObject o = modelChange.getChangedObject();
				// Here we must look at non-collection mutable fields
				// We must rollback the last values from the copied state, and add new values as well
				// ie. mix of remove and new
				if (modelChange instanceof org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange) {
					stateChanged = true;

					org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange modelChange_cast = (org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange) modelChange;
					org.eclipse.emf.ecore.EStructuralFeature p = modelChange_cast.getChangedField();

					if (o instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM) {
						org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM o_cast = (org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
								.getTFSM_LastStateChangeStepNumber().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsmTrace.States.tfsm.TracedTFSM traced = (tfsmTrace.States.tfsm.TracedTFSM) exeToTraced
									.get(o);
							tfsmTrace.States.TFSM_lastStateChangeStepNumber_Value lastValue = traced
									.getLastStateChangeStepNumberSequence()
									.get(traced.getLastStateChangeStepNumberSequence().size() - 1);
							newState.getTFSM_lastStateChangeStepNumber_Values().remove(lastValue);

							// And we create a proper new value
							tfsmTrace.States.TFSM_lastStateChangeStepNumber_Value newValue = tfsmTrace.States.StatesFactory.eINSTANCE
									.createTFSM_lastStateChangeStepNumber_Value();

							int value = o_cast.getLastStateChangeStepNumber();

							newValue.setLastStateChangeStepNumber((int) value);

							traced.getLastStateChangeStepNumberSequence().add(newValue);
							newState.getTFSM_lastStateChangeStepNumber_Values().add(newValue);
						} else

						if (p.getFeatureID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
								.getTFSM_CurrentState().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsmTrace.States.tfsm.TracedTFSM traced = (tfsmTrace.States.tfsm.TracedTFSM) exeToTraced
									.get(o);
							tfsmTrace.States.TFSM_currentState_Value lastValue = traced.getCurrentStateSequence()
									.get(traced.getCurrentStateSequence().size() - 1);
							newState.getTFSM_currentState_Values().remove(lastValue);

							// And we create a proper new value
							tfsmTrace.States.TFSM_currentState_Value newValue = tfsmTrace.States.StatesFactory.eINSTANCE
									.createTFSM_currentState_Value();

							tfsmTrace.States.tfsm.TracedState value = null;
							if (o_cast.getCurrentState() != null) {
								value = ((tfsmTrace.States.tfsm.TracedState) exeToTraced.get(o_cast.getCurrentState()));
							}

							newValue.setCurrentState((tfsmTrace.States.tfsm.TracedState) value);

							traced.getCurrentStateSequence().add(newValue);
							newState.getTFSM_currentState_Values().add(newValue);
						} else

						if (p.getFeatureID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
								.getTFSM_StepNumber().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsmTrace.States.tfsm.TracedTFSM traced = (tfsmTrace.States.tfsm.TracedTFSM) exeToTraced
									.get(o);
							tfsmTrace.States.TFSM_stepNumber_Value lastValue = traced.getStepNumberSequence()
									.get(traced.getStepNumberSequence().size() - 1);
							newState.getTFSM_stepNumber_Values().remove(lastValue);

							// And we create a proper new value
							tfsmTrace.States.TFSM_stepNumber_Value newValue = tfsmTrace.States.StatesFactory.eINSTANCE
									.createTFSM_stepNumber_Value();

							int value = o_cast.getStepNumber();

							newValue.setStepNumber((int) value);

							traced.getStepNumberSequence().add(newValue);
							newState.getTFSM_stepNumber_Values().add(newValue);
						}
					}

					if (o instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock) {
						org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock o_cast = (org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
								.getFSMClock_NumberOfTicks().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsmTrace.States.tfsm.TracedFSMClock traced = (tfsmTrace.States.tfsm.TracedFSMClock) exeToTraced
									.get(o);
							tfsmTrace.States.FSMClock_numberOfTicks_Value lastValue = traced.getNumberOfTicksSequence()
									.get(traced.getNumberOfTicksSequence().size() - 1);
							newState.getFSMClock_numberOfTicks_Values().remove(lastValue);

							// And we create a proper new value
							tfsmTrace.States.FSMClock_numberOfTicks_Value newValue = tfsmTrace.States.StatesFactory.eINSTANCE
									.createFSMClock_numberOfTicks_Value();

							java.lang.Integer value = o_cast.getNumberOfTicks();

							newValue.setNumberOfTicks((java.lang.Integer) value);

							traced.getNumberOfTicksSequence().add(newValue);
							newState.getFSMClock_numberOfTicks_Values().add(newValue);
						}
					}

					if (o instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent) {
						org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent o_cast = (org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
								.getFSMEvent_IsTriggered().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsmTrace.States.tfsm.TracedFSMEvent traced = (tfsmTrace.States.tfsm.TracedFSMEvent) exeToTraced
									.get(o);
							tfsmTrace.States.FSMEvent_isTriggered_Value lastValue = traced.getIsTriggeredSequence()
									.get(traced.getIsTriggeredSequence().size() - 1);
							newState.getFSMEvent_isTriggered_Values().remove(lastValue);

							// And we create a proper new value
							tfsmTrace.States.FSMEvent_isTriggered_Value newValue = tfsmTrace.States.StatesFactory.eINSTANCE
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
				final tfsmTrace.Steps.SpecificStep currentStep = context.peekFirst();
				if (currentStep != null && currentStep instanceof fr.inria.diverse.trace.commons.model.trace.BigStep) {
					final tfsmTrace.States.State startingState = lastState;
					final tfsmTrace.States.State endingState = newState;
					addImplicitStep(currentStep, startingState, endingState);
				}
				lastState = newState;
				traceRoot.getStatesTrace().add(lastState);
			} else if (copiedState) {
				newState.getTFSM_currentState_Values().clear();
				newState.getFSMEvent_isTriggered_Values().clear();
				newState.getTFSM_lastStateChangeStepNumber_Values().clear();
				newState.getFSMClock_numberOfTicks_Values().clear();
				newState.getTFSM_stepNumber_Values().clear();
			}
			copiedState = false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addStep(fr.inria.diverse.trace.commons.model.trace.Step step) {
		tfsmTrace.Steps.SpecificStep step_cast = null;
		if (step != null && step instanceof tfsmTrace.Steps.SpecificStep) {
			step_cast = (tfsmTrace.Steps.SpecificStep) step;
			if (mseModel == null) {
				mseModel = fr.inria.diverse.trace.commons.model.trace.TraceFactory.eINSTANCE.createMSEModel();
				traceResource.getContents().add(mseModel);
			}
			mseModel.getOwnedMSEs().add(step_cast.getMseoccurrence().getMse());

			// Creating generic (or almost generic) links
			tfsmTrace.States.State state = traceRoot.getStatesTrace().get(traceRoot.getStatesTrace().size() - 1);
			step_cast.setStartingState(state);
			if (!context.isEmpty() && context.getFirst() != null) {
				((SequentialStep<tfsmTrace.Steps.SpecificStep>) context.getFirst()).getSubSteps().add(step_cast);
			} else {
				traceRoot.getRootStep().getSubSteps().add(step_cast);
			}

			// Adding step in its dedicated sequence/dimension
			if (step_cast instanceof tfsmTrace.Steps.Tfsm_FSMClock_Ticks) {
				tfsmTrace.Steps.Tfsm_FSMClock_Ticks tfsm_FSMClock_TicksInstance = (tfsmTrace.Steps.Tfsm_FSMClock_Ticks) step_cast;
				traceRoot.getTfsm_FSMClock_Ticks_Sequence().add(tfsm_FSMClock_TicksInstance);
			} else if (step_cast instanceof tfsmTrace.Steps.Tfsm_FSMEvent_Trigger) {
				tfsmTrace.Steps.Tfsm_FSMEvent_Trigger tfsm_FSMEvent_TriggerInstance = (tfsmTrace.Steps.Tfsm_FSMEvent_Trigger) step_cast;
				traceRoot.getTfsm_FSMEvent_Trigger_Sequence().add(tfsm_FSMEvent_TriggerInstance);
			} else if (step_cast instanceof tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger) {
				tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger tfsm_FSMEvent_UnTriggerInstance = (tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger) step_cast;
				traceRoot.getTfsm_FSMEvent_UnTrigger_Sequence().add(tfsm_FSMEvent_UnTriggerInstance);
			} else if (step_cast instanceof tfsmTrace.Steps.Tfsm_State_Visit) {
				tfsmTrace.Steps.Tfsm_State_Visit tfsm_State_VisitInstance = (tfsmTrace.Steps.Tfsm_State_Visit) step_cast;
				traceRoot.getTfsm_State_Visit_Sequence().add(tfsm_State_VisitInstance);
			} else if (step_cast instanceof tfsmTrace.Steps.Tfsm_TFSM_Init) {
				tfsmTrace.Steps.Tfsm_TFSM_Init tfsm_TFSM_InitInstance = (tfsmTrace.Steps.Tfsm_TFSM_Init) step_cast;
				traceRoot.getTfsm_TFSM_Init_Sequence().add(tfsm_TFSM_InitInstance);
			} else if (step_cast instanceof tfsmTrace.Steps.Tfsm_Transition_Fire) {
				tfsmTrace.Steps.Tfsm_Transition_Fire tfsm_Transition_FireInstance = (tfsmTrace.Steps.Tfsm_Transition_Fire) step_cast;
				traceRoot.getTfsm_Transition_Fire_Sequence().add(tfsm_Transition_FireInstance);
			} else if (step_cast instanceof tfsmTrace.Steps.Tfsm_Transition_Visit) {
				tfsmTrace.Steps.Tfsm_Transition_Visit tfsm_Transition_VisitInstance = (tfsmTrace.Steps.Tfsm_Transition_Visit) step_cast;
				traceRoot.getTfsm_Transition_Visit_Sequence().add(tfsm_Transition_VisitInstance);
			}
		}
		context.push(step_cast);
	}

	@SuppressWarnings("unchecked")
	private void addImplicitStep(tfsmTrace.Steps.SpecificStep currentStep, tfsmTrace.States.State startingState,
			tfsmTrace.States.State endingState) {

		tfsmTrace.Steps.SpecificStep implicitStep = null;
		if (currentStep instanceof tfsmTrace.Steps.Tfsm_State_Visit) {
			implicitStep = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_State_Visit_ImplicitStep();
		} else if (currentStep instanceof tfsmTrace.Steps.Tfsm_Transition_Visit) {
			implicitStep = tfsmTrace.Steps.StepsFactory.eINSTANCE.createTfsm_Transition_Visit_ImplicitStep();
		}
		if (implicitStep != null) {
			implicitStep.setStartingState(startingState);
			implicitStep.setEndingState(endingState);
			((SequentialStep<tfsmTrace.Steps.SpecificStep>) currentStep).getSubSteps().add(implicitStep);

		}
	}

	@Override
	public void endStep(fr.inria.diverse.trace.commons.model.trace.Step step) {
		tfsmTrace.Steps.SpecificStep popped = context.pop();
		if (popped != null)
			popped.setEndingState(lastState);
	}

	@Override
	public EObject initTrace(LaunchConfiguration launchConfiguration) {
		// Create root
		traceRoot = tfsmTrace.TfsmTraceFactory.eINSTANCE.createSpecificTrace();
		traceRoot.setLaunchconfiguration(launchConfiguration);

		// Create root sequential step
		fr.inria.diverse.trace.commons.model.trace.SequentialStep<tfsmTrace.Steps.SpecificStep> rootStep = fr.inria.diverse.trace.commons.model.trace.TraceFactory.eINSTANCE
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
		return allResources;
	}

	@Override
	public boolean isPartialTraceConstructor() {
		return false;
	}
}
