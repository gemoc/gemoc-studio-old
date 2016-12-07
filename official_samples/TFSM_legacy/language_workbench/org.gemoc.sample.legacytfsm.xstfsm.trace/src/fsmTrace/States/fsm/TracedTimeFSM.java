/**
 */
package fsmTrace.States.fsm;

import fsmTrace.States.TimeFSM_currentState_Value;
import fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value;
import fsmTrace.States.TimeFSM_stepNumber_Value;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced Time FSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.fsm.TracedTimeFSM#getCurrentStateSequence <em>Current State Sequence</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.TracedTimeFSM#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.TracedTimeFSM#getOriginalObject <em>Original Object</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.TracedTimeFSM#getStepNumberSequence <em>Step Number Sequence</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.fsm.FsmPackage#getTracedTimeFSM()
 * @model
 * @generated
 */
public interface TracedTimeFSM extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Current State Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.TimeFSM_currentState_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.TimeFSM_currentState_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State Sequence</em>' containment reference list.
	 * @see fsmTrace.States.fsm.FsmPackage#getTracedTimeFSM_CurrentStateSequence()
	 * @see fsmTrace.States.TimeFSM_currentState_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TimeFSM_currentState_Value> getCurrentStateSequence();

	/**
	 * Returns the value of the '<em><b>Last State Change Step Number Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last State Change Step Number Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last State Change Step Number Sequence</em>' containment reference list.
	 * @see fsmTrace.States.fsm.FsmPackage#getTracedTimeFSM_LastStateChangeStepNumberSequence()
	 * @see fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TimeFSM_lastStateChangeStepNumber_Value> getLastStateChangeStepNumberSequence();

	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(TimeFSM)
	 * @see fsmTrace.States.fsm.FsmPackage#getTracedTimeFSM_OriginalObject()
	 * @model
	 * @generated
	 */
	TimeFSM getOriginalObject();

	/**
	 * Sets the value of the '{@link fsmTrace.States.fsm.TracedTimeFSM#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(TimeFSM value);

	/**
	 * Returns the value of the '<em><b>Step Number Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.TimeFSM_stepNumber_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.TimeFSM_stepNumber_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Number Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Number Sequence</em>' containment reference list.
	 * @see fsmTrace.States.fsm.FsmPackage#getTracedTimeFSM_StepNumberSequence()
	 * @see fsmTrace.States.TimeFSM_stepNumber_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TimeFSM_stepNumber_Value> getStepNumberSequence();

} // TracedTimeFSM
