/**
 */
package fsmTrace.Steps.impl;

import fsmTrace.Steps.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StepsFactoryImpl extends EFactoryImpl implements StepsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StepsFactory init() {
		try {
			StepsFactory theStepsFactory = (StepsFactory)EPackage.Registry.INSTANCE.getEFactory(StepsPackage.eNS_URI);
			if (theStepsFactory != null) {
				return theStepsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StepsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StepsPackage.FSM_FSM_CLOCK_TICKS: return createFsm_FSMClock_Ticks();
			case StepsPackage.FSM_FSM_EVENT_TRIGGER: return createFsm_FSMEvent_Trigger();
			case StepsPackage.FSM_FSM_EVENT_UN_TRIGGER: return createFsm_FSMEvent_UnTrigger();
			case StepsPackage.FSM_STATE_VISIT: return createFsm_State_Visit();
			case StepsPackage.FSM_STATE_VISIT_IMPLICIT_STEP: return createFsm_State_Visit_ImplicitStep();
			case StepsPackage.FSM_TIME_FSM_INIT: return createFsm_TimeFSM_Init();
			case StepsPackage.FSM_TRANSITION_FIRE: return createFsm_Transition_Fire();
			case StepsPackage.FSM_TRANSITION_VISIT: return createFsm_Transition_Visit();
			case StepsPackage.FSM_TRANSITION_VISIT_IMPLICIT_STEP: return createFsm_Transition_Visit_ImplicitStep();
			case StepsPackage.ROOT_IMPLICIT_STEP: return createRootImplicitStep();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_FSMClock_Ticks createFsm_FSMClock_Ticks() {
		Fsm_FSMClock_TicksImpl fsm_FSMClock_Ticks = new Fsm_FSMClock_TicksImpl();
		return fsm_FSMClock_Ticks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_FSMEvent_Trigger createFsm_FSMEvent_Trigger() {
		Fsm_FSMEvent_TriggerImpl fsm_FSMEvent_Trigger = new Fsm_FSMEvent_TriggerImpl();
		return fsm_FSMEvent_Trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_FSMEvent_UnTrigger createFsm_FSMEvent_UnTrigger() {
		Fsm_FSMEvent_UnTriggerImpl fsm_FSMEvent_UnTrigger = new Fsm_FSMEvent_UnTriggerImpl();
		return fsm_FSMEvent_UnTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_State_Visit createFsm_State_Visit() {
		Fsm_State_VisitImpl fsm_State_Visit = new Fsm_State_VisitImpl();
		return fsm_State_Visit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_State_Visit_ImplicitStep createFsm_State_Visit_ImplicitStep() {
		Fsm_State_Visit_ImplicitStepImpl fsm_State_Visit_ImplicitStep = new Fsm_State_Visit_ImplicitStepImpl();
		return fsm_State_Visit_ImplicitStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_TimeFSM_Init createFsm_TimeFSM_Init() {
		Fsm_TimeFSM_InitImpl fsm_TimeFSM_Init = new Fsm_TimeFSM_InitImpl();
		return fsm_TimeFSM_Init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_Transition_Fire createFsm_Transition_Fire() {
		Fsm_Transition_FireImpl fsm_Transition_Fire = new Fsm_Transition_FireImpl();
		return fsm_Transition_Fire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_Transition_Visit createFsm_Transition_Visit() {
		Fsm_Transition_VisitImpl fsm_Transition_Visit = new Fsm_Transition_VisitImpl();
		return fsm_Transition_Visit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fsm_Transition_Visit_ImplicitStep createFsm_Transition_Visit_ImplicitStep() {
		Fsm_Transition_Visit_ImplicitStepImpl fsm_Transition_Visit_ImplicitStep = new Fsm_Transition_Visit_ImplicitStepImpl();
		return fsm_Transition_Visit_ImplicitStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootImplicitStep createRootImplicitStep() {
		RootImplicitStepImpl rootImplicitStep = new RootImplicitStepImpl();
		return rootImplicitStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepsPackage getStepsPackage() {
		return (StepsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StepsPackage getPackage() {
		return StepsPackage.eINSTANCE;
	}

} //StepsFactoryImpl
