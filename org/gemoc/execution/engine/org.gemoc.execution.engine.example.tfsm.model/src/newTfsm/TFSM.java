/**
 */
package newTfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TFSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link newTfsm.TFSM#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link newTfsm.TFSM#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link newTfsm.TFSM#getLocalEvents <em>Local Events</em>}</li>
 *   <li>{@link newTfsm.TFSM#getLocalClock <em>Local Clock</em>}</li>
 *   <li>{@link newTfsm.TFSM#getOwnedTransitions <em>Owned Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see newTfsm.NewTfsmPackage#getTFSM()
 * @model
 * @generated
 */
public interface TFSM extends NamedElement {
    /**
     * Returns the value of the '<em><b>Owned States</b></em>' containment reference list.
     * The list contents are of type {@link newTfsm.State}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned States</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owned States</em>' containment reference list.
     * @see newTfsm.NewTfsmPackage#getTFSM_OwnedStates()
     * @model containment="true"
     * @generated
     */
    EList<State> getOwnedStates();

    /**
     * Returns the value of the '<em><b>Initial State</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initial State</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initial State</em>' reference.
     * @see #setInitialState(State)
     * @see newTfsm.NewTfsmPackage#getTFSM_InitialState()
     * @model required="true"
     * @generated
     */
    State getInitialState();

    /**
     * Sets the value of the '{@link newTfsm.TFSM#getInitialState <em>Initial State</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initial State</em>' reference.
     * @see #getInitialState()
     * @generated
     */
    void setInitialState(State value);

    /**
     * Returns the value of the '<em><b>Local Events</b></em>' containment reference list.
     * The list contents are of type {@link newTfsm.FSMEvent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Events</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Events</em>' containment reference list.
     * @see newTfsm.NewTfsmPackage#getTFSM_LocalEvents()
     * @model containment="true"
     * @generated
     */
    EList<FSMEvent> getLocalEvents();

    /**
     * Returns the value of the '<em><b>Local Clock</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Clock</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Clock</em>' containment reference.
     * @see #setLocalClock(FSMClock)
     * @see newTfsm.NewTfsmPackage#getTFSM_LocalClock()
     * @model containment="true" required="true"
     * @generated
     */
    FSMClock getLocalClock();

    /**
     * Sets the value of the '{@link newTfsm.TFSM#getLocalClock <em>Local Clock</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Clock</em>' containment reference.
     * @see #getLocalClock()
     * @generated
     */
    void setLocalClock(FSMClock value);

    /**
     * Returns the value of the '<em><b>Owned Transitions</b></em>' containment reference list.
     * The list contents are of type {@link newTfsm.Transition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Transitions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Transitions</em>' containment reference list.
     * @see newTfsm.NewTfsmPackage#getTFSM_OwnedTransitions()
     * @model containment="true"
     * @generated
     */
    EList<Transition> getOwnedTransitions();

} // TFSM
