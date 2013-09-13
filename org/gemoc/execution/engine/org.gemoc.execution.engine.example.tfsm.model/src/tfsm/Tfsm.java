/**
 */
package tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm.Tfsm#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link tfsm.Tfsm#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link tfsm.Tfsm#getOwnedEvents <em>Owned Events</em>}</li>
 *   <li>{@link tfsm.Tfsm#getOwnedClock <em>Owned Clock</em>}</li>
 *   <li>{@link tfsm.Tfsm#getOwnedTransitions <em>Owned Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm.TfsmPackage#getTfsm()
 * @model
 * @generated
 */
public interface Tfsm extends NamedElement {
    /**
     * Returns the value of the '<em><b>Owned States</b></em>' containment reference list.
     * The list contents are of type {@link tfsm.State}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned States</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owned States</em>' containment reference list.
     * @see tfsm.TfsmPackage#getTfsm_OwnedStates()
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
     * @see tfsm.TfsmPackage#getTfsm_InitialState()
     * @model required="true"
     * @generated
     */
    State getInitialState();

    /**
     * Sets the value of the '{@link tfsm.Tfsm#getInitialState <em>Initial State</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initial State</em>' reference.
     * @see #getInitialState()
     * @generated
     */
    void setInitialState(State value);

    /**
     * Returns the value of the '<em><b>Owned Events</b></em>' containment reference list.
     * The list contents are of type {@link tfsm.TfsmEvent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Events</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Events</em>' containment reference list.
     * @see tfsm.TfsmPackage#getTfsm_OwnedEvents()
     * @model containment="true"
     * @generated
     */
    EList<TfsmEvent> getOwnedEvents();

    /**
     * Returns the value of the '<em><b>Owned Clock</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Clock</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Clock</em>' containment reference.
     * @see #setOwnedClock(TfsmClock)
     * @see tfsm.TfsmPackage#getTfsm_OwnedClock()
     * @model containment="true" required="true"
     * @generated
     */
    TfsmClock getOwnedClock();

    /**
     * Sets the value of the '{@link tfsm.Tfsm#getOwnedClock <em>Owned Clock</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Owned Clock</em>' containment reference.
     * @see #getOwnedClock()
     * @generated
     */
    void setOwnedClock(TfsmClock value);

    /**
     * Returns the value of the '<em><b>Owned Transitions</b></em>' containment reference list.
     * The list contents are of type {@link tfsm.Transition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Transitions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Owned Transitions</em>' containment reference list.
     * @see tfsm.TfsmPackage#getTfsm_OwnedTransitions()
     * @model containment="true"
     * @generated
     */
    EList<Transition> getOwnedTransitions();

} // Tfsm
