/**
 */
package tfsm_plaink3Trace.States.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tfsm_plaink3Trace.States.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see tfsm_plaink3Trace.States.StatesPackage
 * @generated
 */
public class StatesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StatesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatesSwitch() {
		if (modelPackage == null) {
			modelPackage = StatesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE: {
				FSMClock_numberOfTicks_Value fsmClock_numberOfTicks_Value = (FSMClock_numberOfTicks_Value)theEObject;
				T result = caseFSMClock_numberOfTicks_Value(fsmClock_numberOfTicks_Value);
				if (result == null) result = caseValue(fsmClock_numberOfTicks_Value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE: {
				FSMEvent_isTriggered_Value fsmEvent_isTriggered_Value = (FSMEvent_isTriggered_Value)theEObject;
				T result = caseFSMEvent_isTriggered_Value(fsmEvent_isTriggered_Value);
				if (result == null) result = caseValue(fsmEvent_isTriggered_Value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatesPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatesPackage.TFSM_CURRENT_STATE_VALUE: {
				TFSM_currentState_Value tfsM_currentState_Value = (TFSM_currentState_Value)theEObject;
				T result = caseTFSM_currentState_Value(tfsM_currentState_Value);
				if (result == null) result = caseValue(tfsM_currentState_Value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatesPackage.TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE: {
				TFSM_lastStateChangeStepNumber_Value tfsM_lastStateChangeStepNumber_Value = (TFSM_lastStateChangeStepNumber_Value)theEObject;
				T result = caseTFSM_lastStateChangeStepNumber_Value(tfsM_lastStateChangeStepNumber_Value);
				if (result == null) result = caseValue(tfsM_lastStateChangeStepNumber_Value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatesPackage.TFSM_STEP_NUMBER_VALUE: {
				TFSM_stepNumber_Value tfsM_stepNumber_Value = (TFSM_stepNumber_Value)theEObject;
				T result = caseTFSM_stepNumber_Value(tfsM_stepNumber_Value);
				if (result == null) result = caseValue(tfsM_stepNumber_Value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatesPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Clock number Of Ticks Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Clock number Of Ticks Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMClock_numberOfTicks_Value(FSMClock_numberOfTicks_Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>FSM Event is Triggered Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>FSM Event is Triggered Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFSMEvent_isTriggered_Value(FSMEvent_isTriggered_Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TFSM current State Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TFSM current State Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTFSM_currentState_Value(TFSM_currentState_Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TFSM last State Change Step Number Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TFSM last State Change Step Number Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTFSM_lastStateChangeStepNumber_Value(TFSM_lastStateChangeStepNumber_Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TFSM step Number Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TFSM step Number Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTFSM_stepNumber_Value(TFSM_stepNumber_Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //StatesSwitch
