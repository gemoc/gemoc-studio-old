/**
 */
package fsmTrace.Steps.util;

import fr.inria.diverse.trace.commons.model.trace.BigStep;
import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.SmallStep;
import fr.inria.diverse.trace.commons.model.trace.Step;

import fsmTrace.Steps.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fsmTrace.Steps.StepsPackage
 * @generated
 */
public class StepsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StepsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StepsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepsSwitch<Adapter> modelSwitch =
		new StepsSwitch<Adapter>() {
			@Override
			public Adapter caseFsm_FSMClock_Ticks(Fsm_FSMClock_Ticks object) {
				return createFsm_FSMClock_TicksAdapter();
			}
			@Override
			public Adapter caseFsm_FSMEvent_Trigger(Fsm_FSMEvent_Trigger object) {
				return createFsm_FSMEvent_TriggerAdapter();
			}
			@Override
			public Adapter caseFsm_FSMEvent_UnTrigger(Fsm_FSMEvent_UnTrigger object) {
				return createFsm_FSMEvent_UnTriggerAdapter();
			}
			@Override
			public Adapter caseFsm_State_Visit(Fsm_State_Visit object) {
				return createFsm_State_VisitAdapter();
			}
			@Override
			public Adapter caseFsm_State_Visit_AbstractSubStep(Fsm_State_Visit_AbstractSubStep object) {
				return createFsm_State_Visit_AbstractSubStepAdapter();
			}
			@Override
			public Adapter caseFsm_State_Visit_ImplicitStep(Fsm_State_Visit_ImplicitStep object) {
				return createFsm_State_Visit_ImplicitStepAdapter();
			}
			@Override
			public Adapter caseFsm_TimeFSM_Init(Fsm_TimeFSM_Init object) {
				return createFsm_TimeFSM_InitAdapter();
			}
			@Override
			public Adapter caseFsm_Transition_Fire(Fsm_Transition_Fire object) {
				return createFsm_Transition_FireAdapter();
			}
			@Override
			public Adapter caseFsm_Transition_Visit(Fsm_Transition_Visit object) {
				return createFsm_Transition_VisitAdapter();
			}
			@Override
			public Adapter caseFsm_Transition_Visit_AbstractSubStep(Fsm_Transition_Visit_AbstractSubStep object) {
				return createFsm_Transition_Visit_AbstractSubStepAdapter();
			}
			@Override
			public Adapter caseFsm_Transition_Visit_ImplicitStep(Fsm_Transition_Visit_ImplicitStep object) {
				return createFsm_Transition_Visit_ImplicitStepAdapter();
			}
			@Override
			public Adapter caseRootImplicitStep(RootImplicitStep object) {
				return createRootImplicitStepAdapter();
			}
			@Override
			public Adapter caseSpecificStep(SpecificStep object) {
				return createSpecificStepAdapter();
			}
			@Override
			public Adapter caseStep(Step object) {
				return createStepAdapter();
			}
			@Override
			public Adapter caseSmallStep(SmallStep object) {
				return createSmallStepAdapter();
			}
			@Override
			public <StepSubtype extends Step> Adapter caseBigStep(BigStep<StepSubtype> object) {
				return createBigStepAdapter();
			}
			@Override
			public <StepSubtype extends Step> Adapter caseSequentialStep(SequentialStep<StepSubtype> object) {
				return createSequentialStepAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_FSMClock_Ticks <em>Fsm FSM Clock Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_FSMClock_Ticks
	 * @generated
	 */
	public Adapter createFsm_FSMClock_TicksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_FSMEvent_Trigger <em>Fsm FSM Event Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_FSMEvent_Trigger
	 * @generated
	 */
	public Adapter createFsm_FSMEvent_TriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_FSMEvent_UnTrigger <em>Fsm FSM Event Un Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_FSMEvent_UnTrigger
	 * @generated
	 */
	public Adapter createFsm_FSMEvent_UnTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_State_Visit <em>Fsm State Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_State_Visit
	 * @generated
	 */
	public Adapter createFsm_State_VisitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_State_Visit_AbstractSubStep <em>Fsm State Visit Abstract Sub Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_State_Visit_AbstractSubStep
	 * @generated
	 */
	public Adapter createFsm_State_Visit_AbstractSubStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_State_Visit_ImplicitStep <em>Fsm State Visit Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_State_Visit_ImplicitStep
	 * @generated
	 */
	public Adapter createFsm_State_Visit_ImplicitStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_TimeFSM_Init <em>Fsm Time FSM Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_TimeFSM_Init
	 * @generated
	 */
	public Adapter createFsm_TimeFSM_InitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_Transition_Fire <em>Fsm Transition Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_Transition_Fire
	 * @generated
	 */
	public Adapter createFsm_Transition_FireAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_Transition_Visit <em>Fsm Transition Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_Transition_Visit
	 * @generated
	 */
	public Adapter createFsm_Transition_VisitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_Transition_Visit_AbstractSubStep <em>Fsm Transition Visit Abstract Sub Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_Transition_Visit_AbstractSubStep
	 * @generated
	 */
	public Adapter createFsm_Transition_Visit_AbstractSubStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.Fsm_Transition_Visit_ImplicitStep <em>Fsm Transition Visit Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.Fsm_Transition_Visit_ImplicitStep
	 * @generated
	 */
	public Adapter createFsm_Transition_Visit_ImplicitStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.RootImplicitStep <em>Root Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.RootImplicitStep
	 * @generated
	 */
	public Adapter createRootImplicitStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.Steps.SpecificStep <em>Specific Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.Steps.SpecificStep
	 * @generated
	 */
	public Adapter createSpecificStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.diverse.trace.commons.model.trace.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.diverse.trace.commons.model.trace.Step
	 * @generated
	 */
	public Adapter createStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.diverse.trace.commons.model.trace.SmallStep <em>Small Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.diverse.trace.commons.model.trace.SmallStep
	 * @generated
	 */
	public Adapter createSmallStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.diverse.trace.commons.model.trace.BigStep <em>Big Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.diverse.trace.commons.model.trace.BigStep
	 * @generated
	 */
	public Adapter createBigStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.diverse.trace.commons.model.trace.SequentialStep <em>Sequential Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.diverse.trace.commons.model.trace.SequentialStep
	 * @generated
	 */
	public Adapter createSequentialStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StepsAdapterFactory
