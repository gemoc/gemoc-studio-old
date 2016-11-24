/**
 */
package tfsmTrace.States.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsmTrace.States.*;

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
			case StatesPackage.TIME_FSM_CURRENT_STATE_VALUE: return createTimeFSM_currentState_Value();
			case StatesPackage.TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE: return createTimeFSM_lastStateChangeStepNumber_Value();
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE: return createTimeFSM_stepNumber_Value();
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
	public TimeFSM_currentState_Value createTimeFSM_currentState_Value() {
		TimeFSM_currentState_ValueImpl timeFSM_currentState_Value = new TimeFSM_currentState_ValueImpl();
		return timeFSM_currentState_Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeFSM_lastStateChangeStepNumber_Value createTimeFSM_lastStateChangeStepNumber_Value() {
		TimeFSM_lastStateChangeStepNumber_ValueImpl timeFSM_lastStateChangeStepNumber_Value = new TimeFSM_lastStateChangeStepNumber_ValueImpl();
		return timeFSM_lastStateChangeStepNumber_Value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeFSM_stepNumber_Value createTimeFSM_stepNumber_Value() {
		TimeFSM_stepNumber_ValueImpl timeFSM_stepNumber_Value = new TimeFSM_stepNumber_ValueImpl();
		return timeFSM_stepNumber_Value;
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
