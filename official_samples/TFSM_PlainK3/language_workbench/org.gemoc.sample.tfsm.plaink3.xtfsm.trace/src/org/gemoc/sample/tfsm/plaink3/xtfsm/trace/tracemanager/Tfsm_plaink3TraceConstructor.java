package org.gemoc.sample.tfsm.plaink3.xtfsm.trace.tracemanager;

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

public class Tfsm_plaink3TraceConstructor implements ITraceConstructor {
	private tfsm_plaink3Trace.SpecificTrace traceRoot;
	private MSEModel mseModel;
	private Resource executedModel;
	private final Map<EObject, EObject> exeToTraced;

	private tfsm_plaink3Trace.States.State lastState;

	private Resource traceResource;
	private final Deque<tfsm_plaink3Trace.Steps.SpecificStep> context = new LinkedList<tfsm_plaink3Trace.Steps.SpecificStep>();

	public Tfsm_plaink3TraceConstructor(Resource exeModel, Resource traceResource, Map<EObject, EObject> exeToTraced) {
		this.traceResource = traceResource;
		this.executedModel = exeModel;
		this.exeToTraced = exeToTraced;
	}

	private void addInitialState() {
		if (lastState == null) {
			// Creation of the initial state
			Set<Resource> allResources = getAllExecutedModelResources();
			lastState = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE.createState();
			for (Resource r : allResources) {
				for (TreeIterator<EObject> i = r.getAllContents(); i.hasNext();) {
					EObject o = i.next();

					if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.NamedElement) {
						org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.NamedElement o_cast = (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.NamedElement) o;
						addNewObjectToState(o_cast, lastState);
					}
				}
			}
			this.traceRoot.getStatesTrace().add(lastState);
		}
	}

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EvaluateGuard o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedEvaluateGuard();
			tracedObject
					.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EvaluateGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedEvaluateGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedEventGuard();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedEventGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedFSMClock();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedFSMClocks().add(tracedObject);

			// Creation of the first value of the field numberOfTicks
			tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value firstValue_numberOfTicks = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
					.createFSMClock_numberOfTicks_Value();

			firstValue_numberOfTicks.setNumberOfTicks((java.lang.Integer) o_cast.getNumberOfTicks());
			tracedObject.getNumberOfTicksSequence().add(firstValue_numberOfTicks);
			newState.getFSMClock_numberOfTicks_Values().add(firstValue_numberOfTicks);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedFSMEvent();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedFSMEvents().add(tracedObject);

			// Creation of the first value of the field isTriggered
			tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value firstValue_isTriggered = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
					.createFSMEvent_isTriggered_Value();

			firstValue_isTriggered.setIsTriggered((boolean) o_cast.isIsTriggered());
			tracedObject.getIsTriggeredSequence().add(firstValue_isTriggered);
			newState.getFSMEvent_isTriggered_Values().add(firstValue_isTriggered);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;
		if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EvaluateGuard) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EvaluateGuard) o_cast,
					newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard) o_cast,
					newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard) o_cast,
					newState);
		}

		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.NamedElement o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;
		if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition) o_cast,
					newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State) o_cast,
					newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) o_cast, newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem) o_cast,
					newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard) o_cast,
					newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent) o_cast,
					newState);
		} else if (o_cast instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock) {
			added = addNewObjectToState((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock) o_cast,
					newState);
		}

		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedState tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedState();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedStates().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedTFSM();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedTFSMs().add(tracedObject);

			// Creation of the first value of the field currentState
			tfsm_plaink3Trace.States.TFSM_currentState_Value firstValue_currentState = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
					.createTFSM_currentState_Value();

			if (o_cast.getCurrentState() != null) {
				addNewObjectToState(
						(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State) o_cast.getCurrentState(),
						newState);
				firstValue_currentState.setCurrentState(
						(tfsm_plaink3Trace.States.tfsm_plaink3.TracedState) ((tfsm_plaink3Trace.States.tfsm_plaink3.TracedState) exeToTraced
								.get(o_cast.getCurrentState())));
			} else {
				firstValue_currentState.setCurrentState((tfsm_plaink3Trace.States.tfsm_plaink3.TracedState) null);
			}

			tracedObject.getCurrentStateSequence().add(firstValue_currentState);
			newState.getTFSM_currentState_Values().add(firstValue_currentState);

			// Creation of the first value of the field lastStateChangeStepNumber
			tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value firstValue_lastStateChangeStepNumber = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
					.createTFSM_lastStateChangeStepNumber_Value();

			firstValue_lastStateChangeStepNumber
					.setLastStateChangeStepNumber((int) o_cast.getLastStateChangeStepNumber());
			tracedObject.getLastStateChangeStepNumberSequence().add(firstValue_lastStateChangeStepNumber);
			newState.getTFSM_lastStateChangeStepNumber_Values().add(firstValue_lastStateChangeStepNumber);

			// Creation of the first value of the field stepNumber
			tfsm_plaink3Trace.States.TFSM_stepNumber_Value firstValue_stepNumber = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
					.createTFSM_stepNumber_Value();

			firstValue_stepNumber.setStepNumber((int) o_cast.getStepNumber());
			tracedObject.getStepNumberSequence().add(firstValue_stepNumber);
			newState.getTFSM_stepNumber_Values().add(firstValue_stepNumber);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedTemporalGuard();
			tracedObject
					.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedTemporalGuards().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedTimedSystem();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedTimedSystems().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean addNewObjectToState(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition o_cast,
			tfsm_plaink3Trace.States.State newState) {
		boolean added = false;

		if (!added && !exeToTraced.containsKey(o_cast)) {
			tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE
					.createTracedTransition();
			tracedObject.setOriginalObject((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition) o_cast);
			exeToTraced.put(o_cast, tracedObject);
			traceRoot.getTfsm_plaink3_tracedTransitions().add(tracedObject);

		} // end if (!exeToTraced.containsKey
		return added;
	}// end addNewObjectToState

	private boolean copiedState = false;

	private tfsm_plaink3Trace.States.State copyState(tfsm_plaink3Trace.States.State oldState) {
		tfsm_plaink3Trace.States.State newState = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE.createState();
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
			tfsm_plaink3Trace.States.State newState = copyState(lastState);
			for (org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.ModelChange modelChange : changes) {
				EObject o = modelChange.getChangedObject();
				// Here we must look at non-collection mutable fields
				// We must rollback the last values from the copied state, and add new values as well
				// ie. mix of remove and new
				if (modelChange instanceof org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange) {
					stateChanged = true;

					org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange modelChange_cast = (org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.NonCollectionFieldModelChange) modelChange;
					org.eclipse.emf.ecore.EStructuralFeature p = modelChange_cast.getChangedField();

					if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) {
						org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM o_cast = (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
								.getTFSM_StepNumber().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM traced = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) exeToTraced
									.get(o);
							tfsm_plaink3Trace.States.TFSM_stepNumber_Value lastValue = traced.getStepNumberSequence()
									.get(traced.getStepNumberSequence().size() - 1);
							newState.getTFSM_stepNumber_Values().remove(lastValue);

							// And we create a proper new value
							tfsm_plaink3Trace.States.TFSM_stepNumber_Value newValue = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
									.createTFSM_stepNumber_Value();

							int value = o_cast.getStepNumber();

							newValue.setStepNumber((int) value);

							traced.getStepNumberSequence().add(newValue);
							newState.getTFSM_stepNumber_Values().add(newValue);
						} else

						if (p.getFeatureID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
								.getTFSM_LastStateChangeStepNumber().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM traced = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) exeToTraced
									.get(o);
							tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value lastValue = traced
									.getLastStateChangeStepNumberSequence()
									.get(traced.getLastStateChangeStepNumberSequence().size() - 1);
							newState.getTFSM_lastStateChangeStepNumber_Values().remove(lastValue);

							// And we create a proper new value
							tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value newValue = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
									.createTFSM_lastStateChangeStepNumber_Value();

							int value = o_cast.getLastStateChangeStepNumber();

							newValue.setLastStateChangeStepNumber((int) value);

							traced.getLastStateChangeStepNumberSequence().add(newValue);
							newState.getTFSM_lastStateChangeStepNumber_Values().add(newValue);
						} else

						if (p.getFeatureID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
								.getTFSM_CurrentState().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM traced = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) exeToTraced
									.get(o);
							tfsm_plaink3Trace.States.TFSM_currentState_Value lastValue = traced
									.getCurrentStateSequence().get(traced.getCurrentStateSequence().size() - 1);
							newState.getTFSM_currentState_Values().remove(lastValue);

							// And we create a proper new value
							tfsm_plaink3Trace.States.TFSM_currentState_Value newValue = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
									.createTFSM_currentState_Value();

							tfsm_plaink3Trace.States.tfsm_plaink3.TracedState value = null;
							if (o_cast.getCurrentState() != null) {
								value = ((tfsm_plaink3Trace.States.tfsm_plaink3.TracedState) exeToTraced
										.get(o_cast.getCurrentState()));
							}

							newValue.setCurrentState((tfsm_plaink3Trace.States.tfsm_plaink3.TracedState) value);

							traced.getCurrentStateSequence().add(newValue);
							newState.getTFSM_currentState_Values().add(newValue);
						}
					}

					if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent) {
						org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent o_cast = (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
								.getFSMEvent_IsTriggered().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent traced = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent) exeToTraced
									.get(o);
							tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value lastValue = traced
									.getIsTriggeredSequence().get(traced.getIsTriggeredSequence().size() - 1);
							newState.getFSMEvent_isTriggered_Values().remove(lastValue);

							// And we create a proper new value
							tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value newValue = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
									.createFSMEvent_isTriggered_Value();

							boolean value = o_cast.isIsTriggered();

							newValue.setIsTriggered((boolean) value);

							traced.getIsTriggeredSequence().add(newValue);
							newState.getFSMEvent_isTriggered_Values().add(newValue);
						}
					}

					if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock) {
						org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock o_cast = (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
								.getFSMClock_NumberOfTicks().getFeatureID()) {

							// Rollback: we remove the last value of this field from the new state
							tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock traced = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock) exeToTraced
									.get(o);
							tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value lastValue = traced
									.getNumberOfTicksSequence().get(traced.getNumberOfTicksSequence().size() - 1);
							newState.getFSMClock_numberOfTicks_Values().remove(lastValue);

							// And we create a proper new value
							tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value newValue = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
									.createFSMClock_numberOfTicks_Value();

							java.lang.Integer value = o_cast.getNumberOfTicks();

							newValue.setNumberOfTicks((java.lang.Integer) value);

							traced.getNumberOfTicksSequence().add(newValue);
							newState.getFSMClock_numberOfTicks_Values().add(newValue);
						}
					}
				}
			}
			if (stateChanged) {
				final tfsm_plaink3Trace.Steps.SpecificStep currentStep = context.peekFirst();
				if (currentStep != null && currentStep instanceof fr.inria.diverse.trace.commons.model.trace.BigStep) {
					final tfsm_plaink3Trace.States.State startingState = lastState;
					final tfsm_plaink3Trace.States.State endingState = newState;
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
		tfsm_plaink3Trace.Steps.SpecificStep step_cast = null;
		if (step != null && step instanceof tfsm_plaink3Trace.Steps.SpecificStep) {
			step_cast = (tfsm_plaink3Trace.Steps.SpecificStep) step;
			if (mseModel == null) {
				mseModel = fr.inria.diverse.trace.commons.model.trace.TraceFactory.eINSTANCE.createMSEModel();
				traceResource.getContents().add(mseModel);
			}
			mseModel.getOwnedMSEs().add(step_cast.getMseoccurrence().getMse());

			// Creating generic (or almost generic) links
			tfsm_plaink3Trace.States.State state = traceRoot.getStatesTrace()
					.get(traceRoot.getStatesTrace().size() - 1);
			step_cast.setStartingState(state);
			if (!context.isEmpty() && context.getFirst() != null) {
				((SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) context.getFirst()).getSubSteps()
						.add(step_cast);
			} else {
				traceRoot.getRootStep().getSubSteps().add(step_cast);
			}

			// Adding step in its dedicated sequence/dimension
			if (step_cast instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks tfsm_plaink3_FSMClock_TicksInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks) step_cast;
				traceRoot.getTfsm_plaink3_FSMClock_Ticks_Sequence().add(tfsm_plaink3_FSMClock_TicksInstance);
			} else if (step_cast instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger tfsm_plaink3_FSMEvent_TriggerInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger) step_cast;
				traceRoot.getTfsm_plaink3_FSMEvent_Trigger_Sequence().add(tfsm_plaink3_FSMEvent_TriggerInstance);
			} else if (step_cast instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger tfsm_plaink3_FSMEvent_UnTriggerInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger) step_cast;
				traceRoot.getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().add(tfsm_plaink3_FSMEvent_UnTriggerInstance);
			} else if (step_cast instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit tfsm_plaink3_State_VisitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) step_cast;
				traceRoot.getTfsm_plaink3_State_Visit_Sequence().add(tfsm_plaink3_State_VisitInstance);
			} else if (step_cast instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init tfsm_plaink3_TFSM_InitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init) step_cast;
				traceRoot.getTfsm_plaink3_TFSM_Init_Sequence().add(tfsm_plaink3_TFSM_InitInstance);
			} else if (step_cast instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire tfsm_plaink3_Transition_FireInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire) step_cast;
				traceRoot.getTfsm_plaink3_Transition_Fire_Sequence().add(tfsm_plaink3_Transition_FireInstance);
			} else if (step_cast instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit tfsm_plaink3_Transition_VisitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) step_cast;
				traceRoot.getTfsm_plaink3_Transition_Visit_Sequence().add(tfsm_plaink3_Transition_VisitInstance);
			}
		}
		context.push(step_cast);
	}

	@SuppressWarnings("unchecked")
	private void addImplicitStep(tfsm_plaink3Trace.Steps.SpecificStep currentStep,
			tfsm_plaink3Trace.States.State startingState, tfsm_plaink3Trace.States.State endingState) {

		tfsm_plaink3Trace.Steps.SpecificStep implicitStep = null;
		if (currentStep instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) {
			implicitStep = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE.createTfsm_plaink3_State_Visit_ImplicitStep();
		} else if (currentStep instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) {
			implicitStep = tfsm_plaink3Trace.Steps.StepsFactory.eINSTANCE
					.createTfsm_plaink3_Transition_Visit_ImplicitStep();
		}
		if (implicitStep != null) {
			implicitStep.setStartingState(startingState);
			implicitStep.setEndingState(endingState);
			((SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep>) currentStep).getSubSteps().add(implicitStep);

		}
	}

	@Override
	public void endStep(fr.inria.diverse.trace.commons.model.trace.Step step) {
		tfsm_plaink3Trace.Steps.SpecificStep popped = context.pop();
		if (popped != null)
			popped.setEndingState(lastState);
	}

	@Override
	public EObject initTrace(LaunchConfiguration launchConfiguration) {
		// Create root
		traceRoot = tfsm_plaink3Trace.Tfsm_plaink3TraceFactory.eINSTANCE.createSpecificTrace();
		traceRoot.setLaunchconfiguration(launchConfiguration);

		// Create root sequential step
		fr.inria.diverse.trace.commons.model.trace.SequentialStep<tfsm_plaink3Trace.Steps.SpecificStep> rootStep = fr.inria.diverse.trace.commons.model.trace.TraceFactory.eINSTANCE
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
