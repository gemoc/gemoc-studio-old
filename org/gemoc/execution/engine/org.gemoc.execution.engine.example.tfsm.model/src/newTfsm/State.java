/**
 */
package newTfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link newTfsm.State#getOwningFSM <em>Owning FSM</em>}</li>
 *   <li>{@link newTfsm.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link newTfsm.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see newTfsm.NewTfsmPackage#getState()
 * @model
 * @generated
 */
public interface State extends NamedElement {
    /**
     * Returns the value of the '<em><b>Owning FSM</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owning FSM</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owning FSM</em>' reference.
     * @see #setOwningFSM(TFSM)
     * @see newTfsm.NewTfsmPackage#getState_OwningFSM()
     * @model required="true"
     * @generated
     */
    TFSM getOwningFSM();

    /**
     * Sets the value of the '{@link newTfsm.State#getOwningFSM <em>Owning FSM</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owning FSM</em>' reference.
     * @see #getOwningFSM()
     * @generated
     */
    void setOwningFSM(TFSM value);

    /**
     * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
     * The list contents are of type {@link newTfsm.Transition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outgoing Transitions</em>' reference list.
     * @see newTfsm.NewTfsmPackage#getState_OutgoingTransitions()
     * @model
     * @generated
     */
    EList<Transition> getOutgoingTransitions();

    /**
     * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
     * The list contents are of type {@link newTfsm.Transition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Incoming Transitions</em>' reference list.
     * @see newTfsm.NewTfsmPackage#getState_IncomingTransitions()
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
