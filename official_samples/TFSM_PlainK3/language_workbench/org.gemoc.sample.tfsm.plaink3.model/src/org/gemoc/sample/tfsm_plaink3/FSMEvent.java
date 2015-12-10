/**
 */
package org.gemoc.sample.tfsm_plaink3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sample.tfsm_plaink3.FSMEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm_plaink3.FSMEvent#isIsTriggered <em>Is Triggered</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.sample.tfsm_plaink3.TfsmPackage#getFSMEvent()
 * @model
 * @generated
 */
public interface FSMEvent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.tfsm_plaink3.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solliciting Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solliciting Transitions</em>' reference list.
	 * @see org.gemoc.sample.tfsm_plaink3.TfsmPackage#getFSMEvent_SollicitingTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getSollicitingTransitions();

	/**
	 * Returns the value of the '<em><b>Is Triggered</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Triggered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Triggered</em>' attribute.
	 * @see #setIsTriggered(boolean)
	 * @see org.gemoc.sample.tfsm_plaink3.TfsmPackage#getFSMEvent_IsTriggered()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsTriggered();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.tfsm_plaink3.FSMEvent#isIsTriggered <em>Is Triggered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Triggered</em>' attribute.
	 * @see #isIsTriggered()
	 * @generated
	 */
	void setIsTriggered(boolean value);

} // FSMEvent
