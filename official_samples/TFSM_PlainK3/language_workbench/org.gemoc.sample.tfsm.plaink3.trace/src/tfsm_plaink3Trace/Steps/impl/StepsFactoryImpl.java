/**
 */
package tfsm_plaink3Trace.Steps.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsm_plaink3Trace.Steps.*;

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
			case StepsPackage.TFSM_PLAINK3_FSM_CLOCK_TICKS: return createTfsm_plaink3_FSMClock_Ticks();
			case StepsPackage.TFSM_PLAINK3_FSM_EVENT_TRIGGER: return createTfsm_plaink3_FSMEvent_Trigger();
			case StepsPackage.TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER: return createTfsm_plaink3_FSMEvent_UnTrigger();
			case StepsPackage.TFSM_PLAINK3_STATE_VISIT: return createTfsm_plaink3_State_Visit();
			case StepsPackage.TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP: return createTfsm_plaink3_State_Visit_ImplicitStep();
			case StepsPackage.TFSM_PLAINK3_TFSM_INIT: return createTfsm_plaink3_TFSM_Init();
			case StepsPackage.TFSM_PLAINK3_TRANSITION_FIRE: return createTfsm_plaink3_Transition_Fire();
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT: return createTfsm_plaink3_Transition_Visit();
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP: return createTfsm_plaink3_Transition_Visit_ImplicitStep();
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
	public Tfsm_plaink3_FSMClock_Ticks createTfsm_plaink3_FSMClock_Ticks() {
		Tfsm_plaink3_FSMClock_TicksImpl tfsm_plaink3_FSMClock_Ticks = new Tfsm_plaink3_FSMClock_TicksImpl();
		return tfsm_plaink3_FSMClock_Ticks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3_FSMEvent_Trigger createTfsm_plaink3_FSMEvent_Trigger() {
		Tfsm_plaink3_FSMEvent_TriggerImpl tfsm_plaink3_FSMEvent_Trigger = new Tfsm_plaink3_FSMEvent_TriggerImpl();
		return tfsm_plaink3_FSMEvent_Trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3_FSMEvent_UnTrigger createTfsm_plaink3_FSMEvent_UnTrigger() {
		Tfsm_plaink3_FSMEvent_UnTriggerImpl tfsm_plaink3_FSMEvent_UnTrigger = new Tfsm_plaink3_FSMEvent_UnTriggerImpl();
		return tfsm_plaink3_FSMEvent_UnTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3_State_Visit createTfsm_plaink3_State_Visit() {
		Tfsm_plaink3_State_VisitImpl tfsm_plaink3_State_Visit = new Tfsm_plaink3_State_VisitImpl();
		return tfsm_plaink3_State_Visit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3_State_Visit_ImplicitStep createTfsm_plaink3_State_Visit_ImplicitStep() {
		Tfsm_plaink3_State_Visit_ImplicitStepImpl tfsm_plaink3_State_Visit_ImplicitStep = new Tfsm_plaink3_State_Visit_ImplicitStepImpl();
		return tfsm_plaink3_State_Visit_ImplicitStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3_TFSM_Init createTfsm_plaink3_TFSM_Init() {
		Tfsm_plaink3_TFSM_InitImpl tfsm_plaink3_TFSM_Init = new Tfsm_plaink3_TFSM_InitImpl();
		return tfsm_plaink3_TFSM_Init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3_Transition_Fire createTfsm_plaink3_Transition_Fire() {
		Tfsm_plaink3_Transition_FireImpl tfsm_plaink3_Transition_Fire = new Tfsm_plaink3_Transition_FireImpl();
		return tfsm_plaink3_Transition_Fire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3_Transition_Visit createTfsm_plaink3_Transition_Visit() {
		Tfsm_plaink3_Transition_VisitImpl tfsm_plaink3_Transition_Visit = new Tfsm_plaink3_Transition_VisitImpl();
		return tfsm_plaink3_Transition_Visit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3_Transition_Visit_ImplicitStep createTfsm_plaink3_Transition_Visit_ImplicitStep() {
		Tfsm_plaink3_Transition_Visit_ImplicitStepImpl tfsm_plaink3_Transition_Visit_ImplicitStep = new Tfsm_plaink3_Transition_Visit_ImplicitStepImpl();
		return tfsm_plaink3_Transition_Visit_ImplicitStep;
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
