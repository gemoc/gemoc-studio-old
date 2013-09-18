/**
 */
package tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm.State#getOwningTfsm <em>Owning Tfsm</em>}</li>
 *   <li>{@link tfsm.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link tfsm.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm.TfsmPackage#getState()
 * @model
 * @generated
 */
public interface State extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owning Tfsm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Tfsm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Tfsm</em>' reference.
	 * @see #setOwningTfsm(Tfsm)
	 * @see tfsm.TfsmPackage#getState_OwningTfsm()
	 * @model required="true"
	 * @generated
	 */
	Tfsm getOwningTfsm();

	/**
	 * Sets the value of the '{@link tfsm.State#getOwningTfsm <em>Owning Tfsm</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Tfsm</em>' reference.
	 * @see #getOwningTfsm()
	 * @generated
	 */
	void setOwningTfsm(Tfsm value);

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link tfsm.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see tfsm.TfsmPackage#getState_OutgoingTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link tfsm.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see tfsm.TfsmPackage#getState_IncomingTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getIncomingTransitions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String onEnter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String onLeave();

} // State
