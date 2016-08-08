/**
 */
package tfsm_plaink3Trace.States.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsm_plaink3Trace.States.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatesFactoryImpl extends EFactoryImpl implements StatesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StatesFactory init() {
		try {
			StatesFactory theStatesFactory = (StatesFactory)EPackage.Registry.INSTANCE.getEFactory(StatesPackage.eNS_URI);
			if (theStatesFactory != null) {
				return theStatesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StatesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatesFactoryImpl() {
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
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE: return createFSMClock_numberOfTicks_Value();
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE: return createFSMEvent_isTriggered_Value();
			case StatesPackage.STATE: return createState();
			case StatesPackage.TFSM_CURRENT_STATE_VALUE: return createTFSM_currentState_Value();
			case StatesPackage.TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE: return createTFSM_lastStateChangeStepNumber_Value();
			case StatesPackage.TFSM_STEP_NUMBER_VALUE: return createTFSM_stepNumber_Value();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMClock_numberOfTicks_Value createFSMClock_numberOfTicks_Value() {
		FSMClock_numberOfTicks_ValueImpl fsmClock_numberOfTicks_Value = new FSMClock_numberOfTicks_ValueImpl();
		return fsmClock_numberOfTicks_Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMEvent_isTriggered_Value createFSMEvent_isTriggered_Value() {
		FSMEvent_isTriggered_ValueImpl fsmEvent_isTriggered_Value = new FSMEvent_isTriggered_ValueImpl();
		return fsmEvent_isTriggered_Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFSM_currentState_Value createTFSM_currentState_Value() {
		TFSM_currentState_ValueImpl tfsM_currentState_Value = new TFSM_currentState_ValueImpl();
		return tfsM_currentState_Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFSM_lastStateChangeStepNumber_Value createTFSM_lastStateChangeStepNumber_Value() {
		TFSM_lastStateChangeStepNumber_ValueImpl tfsM_lastStateChangeStepNumber_Value = new TFSM_lastStateChangeStepNumber_ValueImpl();
		return tfsM_lastStateChangeStepNumber_Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFSM_stepNumber_Value createTFSM_stepNumber_Value() {
		TFSM_stepNumber_ValueImpl tfsM_stepNumber_Value = new TFSM_stepNumber_ValueImpl();
		return tfsM_stepNumber_Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatesPackage getStatesPackage() {
		return (StatesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StatesPackage getPackage() {
		return StatesPackage.eINSTANCE;
	}

} //StatesFactoryImpl
