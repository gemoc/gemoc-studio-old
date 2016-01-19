/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.tfsm_plaink3.State;
import org.gemoc.sample.tfsm_plaink3.Transition;

import tfsm_plaink3Trace.States.TFSM_currentState_Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced TFSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getCurrentStateSequence <em>Current State Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getLocalClock <em>Local Clock</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getLocalEvents <em>Local Events</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getOwnedTransitions <em>Owned Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM()
 * @model
 * @generated
 */
public interface TracedTFSM extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(State)
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_CurrentState()
	 * @model
	 * @generated
	 */
	State getCurrentState();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(State value);

	/**
	 * Returns the value of the '<em><b>Current State Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.TFSM_currentState_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State Sequence</em>' containment reference list.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_CurrentStateSequence()
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TFSM_currentState_Value> getCurrentStateSequence();

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
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Local Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Clock</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Clock</em>' reference.
	 * @see #setLocalClock(TracedFSMClock)
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_LocalClock()
	 * @model required="true"
	 * @generated
	 */
	TracedFSMClock getLocalClock();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getLocalClock <em>Local Clock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Clock</em>' reference.
	 * @see #getLocalClock()
	 * @generated
	 */
	void setLocalClock(TracedFSMClock value);

	/**
	 * Returns the value of the '<em><b>Local Events</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Events</em>' reference list.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_LocalEvents()
	 * @model
	 * @generated
	 */
	EList<TracedFSMEvent> getLocalEvents();

	/**
	 * Returns the value of the '<em><b>Owned States</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.tfsm_plaink3.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned States</em>' reference list.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_OwnedStates()
	 * @model
	 * @generated
	 */
	EList<State> getOwnedStates();

	/**
	 * Returns the value of the '<em><b>Owned Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.tfsm_plaink3.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Transitions</em>' reference list.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_OwnedTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getOwnedTransitions();

} // TracedTFSM
