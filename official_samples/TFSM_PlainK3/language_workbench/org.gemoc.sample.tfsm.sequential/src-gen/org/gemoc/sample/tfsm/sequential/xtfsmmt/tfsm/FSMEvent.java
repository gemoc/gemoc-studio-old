/**
 */
package org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.FSMEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.FSMEvent#isIsTriggered <em>Is Triggered</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage#getFSMEvent()
 * @model
 * @generated
 */
public interface FSMEvent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solliciting Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solliciting Transitions</em>' reference list.
	 * @see org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage#getFSMEvent_SollicitingTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getSollicitingTransitions();

	/**
	 * Returns the value of the '<em><b>Is Triggered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Triggered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Triggered</em>' attribute.
	 * @see #setIsTriggered(boolean)
	 * @see org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage#getFSMEvent_IsTriggered()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsTriggered();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.FSMEvent#isIsTriggered <em>Is Triggered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Triggered</em>' attribute.
	 * @see #isIsTriggered()
	 * @generated
	 */
	void setIsTriggered(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void trigger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void unTrigger();

} // FSMEvent
