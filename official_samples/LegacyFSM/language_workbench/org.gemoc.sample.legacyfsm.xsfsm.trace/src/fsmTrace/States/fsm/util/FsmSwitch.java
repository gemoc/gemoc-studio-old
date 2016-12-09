/**
 */
package fsmTrace.States.fsm.util;

import fsmTrace.States.fsm.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * @see fsmTrace.States.fsm.FsmPackage
 * @generated
 */
public class FsmSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FsmPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmSwitch() {
		if (modelPackage == null) {
			modelPackage = FsmPackage.eINSTANCE;
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
			case FsmPackage.TRACED_EVALUATE_GUARD: {
				TracedEvaluateGuard tracedEvaluateGuard = (TracedEvaluateGuard)theEObject;
				T result = caseTracedEvaluateGuard(tracedEvaluateGuard);
				if (result == null) result = caseTracedGuard(tracedEvaluateGuard);
				if (result == null) result = caseTracedNamedElement(tracedEvaluateGuard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_EVENT_GUARD: {
				TracedEventGuard tracedEventGuard = (TracedEventGuard)theEObject;
				T result = caseTracedEventGuard(tracedEventGuard);
				if (result == null) result = caseTracedGuard(tracedEventGuard);
				if (result == null) result = caseTracedNamedElement(tracedEventGuard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_FSM_CLOCK: {
				TracedFSMClock tracedFSMClock = (TracedFSMClock)theEObject;
				T result = caseTracedFSMClock(tracedFSMClock);
				if (result == null) result = caseTracedNamedElement(tracedFSMClock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_FSM_EVENT: {
				TracedFSMEvent tracedFSMEvent = (TracedFSMEvent)theEObject;
				T result = caseTracedFSMEvent(tracedFSMEvent);
				if (result == null) result = caseTracedNamedElement(tracedFSMEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_GUARD: {
				TracedGuard tracedGuard = (TracedGuard)theEObject;
				T result = caseTracedGuard(tracedGuard);
				if (result == null) result = caseTracedNamedElement(tracedGuard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_NAMED_ELEMENT: {
				TracedNamedElement tracedNamedElement = (TracedNamedElement)theEObject;
				T result = caseTracedNamedElement(tracedNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_STATE: {
				TracedState tracedState = (TracedState)theEObject;
				T result = caseTracedState(tracedState);
				if (result == null) result = caseTracedNamedElement(tracedState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_TEMPORAL_GUARD: {
				TracedTemporalGuard tracedTemporalGuard = (TracedTemporalGuard)theEObject;
				T result = caseTracedTemporalGuard(tracedTemporalGuard);
				if (result == null) result = caseTracedGuard(tracedTemporalGuard);
				if (result == null) result = caseTracedNamedElement(tracedTemporalGuard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_TIME_FSM: {
				TracedTimeFSM tracedTimeFSM = (TracedTimeFSM)theEObject;
				T result = caseTracedTimeFSM(tracedTimeFSM);
				if (result == null) result = caseTracedNamedElement(tracedTimeFSM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_TIMED_SYSTEM: {
				TracedTimedSystem tracedTimedSystem = (TracedTimedSystem)theEObject;
				T result = caseTracedTimedSystem(tracedTimedSystem);
				if (result == null) result = caseTracedNamedElement(tracedTimedSystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FsmPackage.TRACED_TRANSITION: {
				TracedTransition tracedTransition = (TracedTransition)theEObject;
				T result = caseTracedTransition(tracedTransition);
				if (result == null) result = caseTracedNamedElement(tracedTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced Evaluate Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced Evaluate Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedEvaluateGuard(TracedEvaluateGuard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced Event Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced Event Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedEventGuard(TracedEventGuard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced FSM Clock</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced FSM Clock</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedFSMClock(TracedFSMClock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced FSM Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced FSM Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedFSMEvent(TracedFSMEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedGuard(TracedGuard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedNamedElement(TracedNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedState(TracedState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced Temporal Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced Temporal Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedTemporalGuard(TracedTemporalGuard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced Time FSM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced Time FSM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedTimeFSM(TracedTimeFSM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced Timed System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced Timed System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedTimedSystem(TracedTimedSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traced Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traced Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTracedTransition(TracedTransition object) {
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

} //FsmSwitch
