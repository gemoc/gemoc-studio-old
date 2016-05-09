package org.gemoc.sample.tfsm.plaink3.tfsm.trace.tracemanager;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.diverse.trace.gemoc.api.ITraceConstructor;

public class Tfsm_plaink3TraceConstructor implements ITraceConstructor {

	private tfsm_plaink3Trace.Trace traceRoot;
	private org.gemoc.executionframework.engine.mse.MSEModel mseModel;
	private Resource executedModel;
	private Map<EObject, EObject> exeToTraced;

	private tfsm_plaink3Trace.States.State lastState;

	private Resource traceResource;
	private Deque<tfsm_plaink3Trace.Steps.Step> context = new LinkedList<tfsm_plaink3Trace.Steps.Step>();

	public Tfsm_plaink3TraceConstructor(Resource exeModel, Resource traceResource) {
		this.traceResource = traceResource;
		this.executedModel = exeModel;
	}

	private void addInitialState() {
		if (lastState == null) {
			// Creation of the initial state
			Set<Resource> allResources = getAllExecutedModelResources();
			lastState = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE.createState();
			for (Resource r : allResources) {
				for (TreeIterator<EObject> i = r.getAllContents(); i.hasNext();) {
					EObject o = i.next();

					if (o instanceof org.gemoc.sample.tfsm_plaink3.TFSM) {
						org.gemoc.sample.tfsm_plaink3.TFSM o_cast = (org.gemoc.sample.tfsm_plaink3.TFSM) o;
						addNewObjectToState(o_cast, lastState);
					} else

					if (o instanceof org.gemoc.sample.tfsm_plaink3.FSMEvent) {
						org.gemoc.sample.tfsm_plaink3.FSMEvent o_cast = (org.gemoc.sample.tfsm_plaink3.FSMEvent) o;
						addNewObjectToState(o_cast, lastState);
					} else

					if (o instanceof org.gemoc.sample.tfsm_plaink3.FSMClock) {
						org.gemoc.sample.tfsm_plaink3.FSMClock o_cast = (org.gemoc.sample.tfsm_plaink3.FSMClock) o;
						addNewObjectToState(o_cast, lastState);
					}
				}
			}
			this.traceRoot.getStatesTrace().add(lastState);
		}
	}

	private void addNewObjectToState(org.gemoc.sample.tfsm_plaink3.TFSM o_cast,
			tfsm_plaink3Trace.States.State newState) {
		storeAsTracedObject(o_cast);
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM traced = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM) exeToTraced
				.get(o_cast);

		// Creation of the first value of the field currentState
		tfsm_plaink3Trace.States.TFSM_currentState_Value firstValue_currentState = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
				.createTFSM_currentState_Value();
		firstValue_currentState.setCurrentState(o_cast.getCurrentState());
		traced.getCurrentStateSequence().add(firstValue_currentState);
		newState.getTFSM_currentState_Values().add(firstValue_currentState);
	}

	private void addNewObjectToState(org.gemoc.sample.tfsm_plaink3.FSMEvent o_cast,
			tfsm_plaink3Trace.States.State newState) {
		storeAsTracedObject(o_cast);
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent traced = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent) exeToTraced
				.get(o_cast);

		// Creation of the first value of the field isTriggered
		tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value firstValue_isTriggered = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
				.createFSMEvent_isTriggered_Value();
		firstValue_isTriggered.setIsTriggered(o_cast.isIsTriggered());
		traced.getIsTriggeredSequence().add(firstValue_isTriggered);
		newState.getFSMEvent_isTriggered_Values().add(firstValue_isTriggered);
	}

	private void addNewObjectToState(org.gemoc.sample.tfsm_plaink3.FSMClock o_cast,
			tfsm_plaink3Trace.States.State newState) {
		storeAsTracedObject(o_cast);
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock traced = (tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock) exeToTraced
				.get(o_cast);

		// Creation of the first value of the field numberOfTicks
		tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value firstValue_numberOfTicks = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE
				.createFSMClock_numberOfTicks_Value();
		firstValue_numberOfTicks.setNumberOfTicks(o_cast.getNumberOfTicks());
		traced.getNumberOfTicksSequence().add(firstValue_numberOfTicks);
		newState.getFSMClock_numberOfTicks_Values().add(firstValue_numberOfTicks);
	}

	private tfsm_plaink3Trace.States.State copyState(tfsm_plaink3Trace.States.State oldState) {
		tfsm_plaink3Trace.States.State newState = tfsm_plaink3Trace.States.StatesFactory.eINSTANCE.createState();
		newState.getFSMClock_numberOfTicks_Values().addAll(oldState.getFSMClock_numberOfTicks_Values());
		newState.getFSMEvent_isTriggered_Values().addAll(oldState.getFSMEvent_isTriggered_Values());
		newState.getTFSM_currentState_Values().addAll(oldState.getTFSM_currentState_Values());
		return newState;
	}

	@Override
	public void addState(Set<org.gemoc.xdsmlframework.api.engine_addon.modelchangelistener.ModelChange> changes) {
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

					if (o instanceof org.gemoc.sample.tfsm_plaink3.TFSM) {

						org.gemoc.sample.tfsm_plaink3.TFSM o_cast = (org.gemoc.sample.tfsm_plaink3.TFSM) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm_plaink3.TfsmPackage.eINSTANCE
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
							newValue.setCurrentState(o_cast.getCurrentState());
							traced.getCurrentStateSequence().add(newValue);
							newState.getTFSM_currentState_Values().add(newValue);
						}

					} else

					if (o instanceof org.gemoc.sample.tfsm_plaink3.FSMEvent) {

						org.gemoc.sample.tfsm_plaink3.FSMEvent o_cast = (org.gemoc.sample.tfsm_plaink3.FSMEvent) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm_plaink3.TfsmPackage.eINSTANCE
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
							newValue.setIsTriggered(o_cast.isIsTriggered());
							traced.getIsTriggeredSequence().add(newValue);
							newState.getFSMEvent_isTriggered_Values().add(newValue);
						}

					} else

					if (o instanceof org.gemoc.sample.tfsm_plaink3.FSMClock) {

						org.gemoc.sample.tfsm_plaink3.FSMClock o_cast = (org.gemoc.sample.tfsm_plaink3.FSMClock) o;

						if (p.getFeatureID() == org.gemoc.sample.tfsm_plaink3.TfsmPackage.eINSTANCE
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
							newValue.setNumberOfTicks(o_cast.getNumberOfTicks());
							traced.getNumberOfTicksSequence().add(newValue);
							newState.getFSMClock_numberOfTicks_Values().add(newValue);
						}

					}

				}

			}
			if (stateChanged) {
				final tfsm_plaink3Trace.Steps.Step currentStep = context.peekFirst();
				if (currentStep != null && currentStep instanceof tfsm_plaink3Trace.Steps.BigStep) {
					final tfsm_plaink3Trace.States.State startingState = lastState;
					final tfsm_plaink3Trace.States.State endingState = newState;
					addImplicitStep(currentStep, startingState, endingState);
				}

				lastState = newState;
				traceRoot.getStatesTrace().add(lastState);
			}
		}
	}

	@Override
	public boolean addStep(org.gemoc.executionframework.engine.mse.MSEOccurrence mseOccurrence) {
		tfsm_plaink3Trace.Steps.Step step = null;
		if (mseOccurrence != null && mseOccurrence instanceof tfsm_plaink3Trace.Steps.Step) {
			step = (tfsm_plaink3Trace.Steps.Step) mseOccurrence;
			if (mseModel == null) {
				mseModel = org.gemoc.executionframework.engine.mse.MseFactory.eINSTANCE.createMSEModel();
				traceResource.getContents().add(mseModel);
			}
			mseModel.getOwnedMSEs().add(step.getMse());

			// Creating generic (or almost generic) links
			tfsm_plaink3Trace.States.State state = traceRoot.getStatesTrace()
					.get(traceRoot.getStatesTrace().size() - 1);
			step.setStartingState(state);
			if (!context.isEmpty() && context.getFirst() != null) {
				emfAdd(context.getFirst(), "subSteps", step);
			} else {
				traceRoot.getRootSteps().add(step);
			}

			// Adding step in its dedicated sequence/dimension
			if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks tfsm_plaink3_FSMClock_TicksInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks) step;
				traceRoot.getTfsm_plaink3_FSMClock_Ticks_Sequence().add(tfsm_plaink3_FSMClock_TicksInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger tfsm_plaink3_FSMEvent_TriggerInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger) step;
				traceRoot.getTfsm_plaink3_FSMEvent_Trigger_Sequence().add(tfsm_plaink3_FSMEvent_TriggerInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger tfsm_plaink3_FSMEvent_UnTriggerInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger) step;
				traceRoot.getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().add(tfsm_plaink3_FSMEvent_UnTriggerInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit tfsm_plaink3_State_VisitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit) step;
				traceRoot.getTfsm_plaink3_State_Visit_Sequence().add(tfsm_plaink3_State_VisitInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init tfsm_plaink3_TFSM_InitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init) step;
				traceRoot.getTfsm_plaink3_TFSM_Init_Sequence().add(tfsm_plaink3_TFSM_InitInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire tfsm_plaink3_Transition_FireInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire) step;
				traceRoot.getTfsm_plaink3_Transition_Fire_Sequence().add(tfsm_plaink3_Transition_FireInstance);
			} else if (step instanceof tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) {
				tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit tfsm_plaink3_Transition_VisitInstance = (tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit) step;
				traceRoot.getTfsm_plaink3_Transition_Visit_Sequence().add(tfsm_plaink3_Transition_VisitInstance);
			}
		}
		context.push(step);

		return (step != null);
	}

	private void addImplicitStep(tfsm_plaink3Trace.Steps.Step currentStep, tfsm_plaink3Trace.States.State startingState,
			tfsm_plaink3Trace.States.State endingState) {

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
	public void endStep() {
		tfsm_plaink3Trace.Steps.Step popped = context.pop();
		if (popped != null)
			popped.setEndingState(lastState);
	}

	@Override
	public EObject initTrace() {
		// Create root
		traceRoot = tfsm_plaink3Trace.Tfsm_plaink3TraceFactory.eINSTANCE.createTrace();

		// Put in the resource
		traceResource.getContents().add(traceRoot);

		// Initializing the map exeobject -> tracedobject
		exeToTraced = new HashMap<EObject, EObject>();

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

	private void storeAsTracedObject(org.gemoc.sample.tfsm_plaink3.FSMClock o) {

		// First we find the traced object, and we create it if required
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock tracedObject;
		if (!exeToTraced.containsKey(o)) {
			tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE.createTracedFSMClock();
			tracedObject.setOriginalObject(o);
			exeToTraced.put(o, tracedObject);
			traceRoot.getTfsm_plaink3_tracedFSMClocks().add(tracedObject);
		}
	}

	private void storeAsTracedObject(org.gemoc.sample.tfsm_plaink3.FSMEvent o) {

		// First we find the traced object, and we create it if required
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent tracedObject;
		if (!exeToTraced.containsKey(o)) {
			tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE.createTracedFSMEvent();
			tracedObject.setOriginalObject(o);
			exeToTraced.put(o, tracedObject);
			traceRoot.getTfsm_plaink3_tracedFSMEvents().add(tracedObject);
		}
	}

	private void storeAsTracedObject(org.gemoc.sample.tfsm_plaink3.TFSM o) {

		// First we find the traced object, and we create it if required
		tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM tracedObject;
		if (!exeToTraced.containsKey(o)) {
			tracedObject = tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory.eINSTANCE.createTracedTFSM();
			tracedObject.setOriginalObject(o);
			exeToTraced.put(o, tracedObject);
			traceRoot.getTfsm_plaink3_tracedTFSMs().add(tracedObject);
		}
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

	private Set<Resource> getAllExecutedModelResources() {
		Set<Resource> allResources = new HashSet<>();
		allResources.add(executedModel);
		allResources.addAll(org.gemoc.commons.eclipse.emf.EMFResource.getRelatedResources(executedModel));
		return allResources;
	}
}
