/**
 */
package newTfsm.util;

import newTfsm.EvaluateGuard;
import newTfsm.EventGuard;
import newTfsm.FSMClock;
import newTfsm.FSMEvent;
import newTfsm.Guard;
import newTfsm.NamedElement;
import newTfsm.NewTfsmPackage;
import newTfsm.State;
import newTfsm.TFSM;
import newTfsm.TemporalGuard;
import newTfsm.Transition;

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
 * @see newTfsm.NewTfsmPackage
 * @generated
 */
public class NewTfsmSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static NewTfsmPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NewTfsmSwitch() {
        if (modelPackage == null) {
            modelPackage = NewTfsmPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
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
            case NewTfsmPackage.TFSM: {
                TFSM tfsm = (TFSM)theEObject;
                T result = caseTFSM(tfsm);
                if (result == null) result = caseNamedElement(tfsm);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.STATE: {
                State state = (State)theEObject;
                T result = caseState(state);
                if (result == null) result = caseNamedElement(state);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.TRANSITION: {
                Transition transition = (Transition)theEObject;
                T result = caseTransition(transition);
                if (result == null) result = caseNamedElement(transition);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.NAMED_ELEMENT: {
                NamedElement namedElement = (NamedElement)theEObject;
                T result = caseNamedElement(namedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.GUARD: {
                Guard guard = (Guard)theEObject;
                T result = caseGuard(guard);
                if (result == null) result = caseNamedElement(guard);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.TEMPORAL_GUARD: {
                TemporalGuard temporalGuard = (TemporalGuard)theEObject;
                T result = caseTemporalGuard(temporalGuard);
                if (result == null) result = caseGuard(temporalGuard);
                if (result == null) result = caseNamedElement(temporalGuard);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.EVENT_GUARD: {
                EventGuard eventGuard = (EventGuard)theEObject;
                T result = caseEventGuard(eventGuard);
                if (result == null) result = caseGuard(eventGuard);
                if (result == null) result = caseNamedElement(eventGuard);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.FSM_EVENT: {
                FSMEvent fsmEvent = (FSMEvent)theEObject;
                T result = caseFSMEvent(fsmEvent);
                if (result == null) result = caseNamedElement(fsmEvent);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.FSM_CLOCK: {
                FSMClock fsmClock = (FSMClock)theEObject;
                T result = caseFSMClock(fsmClock);
                if (result == null) result = caseNamedElement(fsmClock);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.SYSTEM: {
                newTfsm.System system = (newTfsm.System)theEObject;
                T result = caseSystem(system);
                if (result == null) result = caseNamedElement(system);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case NewTfsmPackage.EVALUATE_GUARD: {
                EvaluateGuard evaluateGuard = (EvaluateGuard)theEObject;
                T result = caseEvaluateGuard(evaluateGuard);
                if (result == null) result = caseGuard(evaluateGuard);
                if (result == null) result = caseNamedElement(evaluateGuard);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>TFSM</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>TFSM</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTFSM(TFSM object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTransition(Transition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGuard(Guard object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Temporal Guard</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Temporal Guard</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTemporalGuard(TemporalGuard object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Guard</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Guard</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventGuard(EventGuard object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>FSM Event</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>FSM Event</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFSMEvent(FSMEvent object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>FSM Clock</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>FSM Clock</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFSMClock(FSMClock object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>System</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>System</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSystem(newTfsm.System object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Evaluate Guard</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Evaluate Guard</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEvaluateGuard(EvaluateGuard object) {
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

} //NewTfsmSwitch
