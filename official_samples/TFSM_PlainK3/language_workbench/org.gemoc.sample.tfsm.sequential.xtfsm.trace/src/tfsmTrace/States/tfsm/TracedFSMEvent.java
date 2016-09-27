/**
 */
package tfsmTrace.States.tfsm;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent;

import tfsmTrace.States.FSMEvent_isTriggered_Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced FSM Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.tfsm.TracedFSMEvent#getIsTriggeredSequence <em>Is Triggered Sequence</em>}</li>
 *   <li>{@link tfsmTrace.States.tfsm.TracedFSMEvent#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedFSMEvent()
 * @model
 * @generated
 */
public interface TracedFSMEvent extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Is Triggered Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.FSMEvent_isTriggered_Value}.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.FSMEvent_isTriggered_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Triggered Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Triggered Sequence</em>' containment reference list.
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedFSMEvent_IsTriggeredSequence()
	 * @see tfsmTrace.States.FSMEvent_isTriggered_Value#getParent
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
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedFSMEvent_OriginalObject()
	 * @model
	 * @generated
	 */
	FSMEvent getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.tfsm.TracedFSMEvent#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(FSMEvent value);

} // TracedFSMEvent
