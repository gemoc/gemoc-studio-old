/**
 */
package fsmTrace.States.fsm;

import fsmTrace.States.FSMEvent_isTriggered_Value;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced FSM Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.fsm.TracedFSMEvent#getIsTriggeredSequence <em>Is Triggered Sequence</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.TracedFSMEvent#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.fsm.FsmPackage#getTracedFSMEvent()
 * @model
 * @generated
 */
public interface TracedFSMEvent extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Is Triggered Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.FSMEvent_isTriggered_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.FSMEvent_isTriggered_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Triggered Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Triggered Sequence</em>' containment reference list.
	 * @see fsmTrace.States.fsm.FsmPackage#getTracedFSMEvent_IsTriggeredSequence()
	 * @see fsmTrace.States.FSMEvent_isTriggered_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<FSMEvent_isTriggered_Value> getIsTriggeredSequence();

	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(FSMEvent)
	 * @see fsmTrace.States.fsm.FsmPackage#getTracedFSMEvent_OriginalObject()
	 * @model
	 * @generated
	 */
	FSMEvent getOriginalObject();

	/**
	 * Sets the value of the '{@link fsmTrace.States.fsm.TracedFSMEvent#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(FSMEvent value);

} // TracedFSMEvent
