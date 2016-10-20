/**
 */
package tfsmTrace.Steps.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsmTrace.Steps.*;

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
			case StepsPackage.ROOT_IMPLICIT_STEP: return createRootImplicitStep();
			case StepsPackage.TFSM_FSM_CLOCK_TICKS: return createTfsm_FSMClock_Ticks();
			case StepsPackage.TFSM_FSM_EVENT_TRIGGER: return createTfsm_FSMEvent_Trigger();
			case StepsPackage.TFSM_FSM_EVENT_UN_TRIGGER: return createTfsm_FSMEvent_UnTrigger();
			case StepsPackage.TFSM_STATE_VISIT: return createTfsm_State_Visit();
			case StepsPackage.TFSM_STATE_VISIT_IMPLICIT_STEP: return createTfsm_State_Visit_ImplicitStep();
			case StepsPackage.TFSM_TFSM_INIT: return createTfsm_TFSM_Init();
			case StepsPackage.TFSM_TRANSITION_FIRE: return createTfsm_Transition_Fire();
			case StepsPackage.TFSM_TRANSITION_VISIT: return createTfsm_Transition_Visit();
			case StepsPackage.TFSM_TRANSITION_VISIT_IMPLICIT_STEP: return createTfsm_Transition_Visit_ImplicitStep();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public Tfsm_FSMClock_Ticks createTfsm_FSMClock_Ticks() {
		Tfsm_FSMClock_TicksImpl tfsm_FSMClock_Ticks = new Tfsm_FSMClock_TicksImpl();
		return tfsm_FSMClock_Ticks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_FSMEvent_Trigger createTfsm_FSMEvent_Trigger() {
		Tfsm_FSMEvent_TriggerImpl tfsm_FSMEvent_Trigger = new Tfsm_FSMEvent_TriggerImpl();
		return tfsm_FSMEvent_Trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_FSMEvent_UnTrigger createTfsm_FSMEvent_UnTrigger() {
		Tfsm_FSMEvent_UnTriggerImpl tfsm_FSMEvent_UnTrigger = new Tfsm_FSMEvent_UnTriggerImpl();
		return tfsm_FSMEvent_UnTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_State_Visit createTfsm_State_Visit() {
		Tfsm_State_VisitImpl tfsm_State_Visit = new Tfsm_State_VisitImpl();
		return tfsm_State_Visit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_State_Visit_ImplicitStep createTfsm_State_Visit_ImplicitStep() {
		Tfsm_State_Visit_ImplicitStepImpl tfsm_State_Visit_ImplicitStep = new Tfsm_State_Visit_ImplicitStepImpl();
		return tfsm_State_Visit_ImplicitStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_TFSM_Init createTfsm_TFSM_Init() {
		Tfsm_TFSM_InitImpl tfsm_TFSM_Init = new Tfsm_TFSM_InitImpl();
		return tfsm_TFSM_Init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_Transition_Fire createTfsm_Transition_Fire() {
		Tfsm_Transition_FireImpl tfsm_Transition_Fire = new Tfsm_Transition_FireImpl();
		return tfsm_Transition_Fire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_Transition_Visit createTfsm_Transition_Visit() {
		Tfsm_Transition_VisitImpl tfsm_Transition_Visit = new Tfsm_Transition_VisitImpl();
		return tfsm_Transition_Visit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_Transition_Visit_ImplicitStep createTfsm_Transition_Visit_ImplicitStep() {
		Tfsm_Transition_Visit_ImplicitStepImpl tfsm_Transition_Visit_ImplicitStep = new Tfsm_Transition_Visit_ImplicitStepImpl();
		return tfsm_Transition_Visit_ImplicitStep;
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
