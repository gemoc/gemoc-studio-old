/**
 */
package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed FSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getLocalEvents <em>Local Events</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getLocalClock <em>Local Clock</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getOwnedTransitions <em>Owned Transitions</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getStepNumber <em>Step Number</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getCurrentState <em>Current State</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM()
 * @model
 * @generated
 */
public interface TimedFSM extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned States</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State#getOwningFSM <em>Owning FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned States</em>' containment reference list.
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM_OwnedStates()
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State#getOwningFSM
	 * @model opposite="owningFSM" containment="true"
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
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Local Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Events</em>' containment reference list.
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM_LocalEvents()
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
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM_LocalClock()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FSMClock getLocalClock();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getLocalClock <em>Local Clock</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Clock</em>' containment reference.
	 * @see #getLocalClock()
	 * @generated
	 */
	void setLocalClock(FSMClock value);

	/**
	 * Returns the value of the '<em><b>Owned Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Transitions</em>' containment reference list.
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM_OwnedTransitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getOwnedTransitions();

	/**
	 * Returns the value of the '<em><b>Step Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Number</em>' attribute.
	 * @see #setStepNumber(int)
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM_StepNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getStepNumber();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getStepNumber <em>Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Number</em>' attribute.
	 * @see #getStepNumber()
	 * @generated
	 */
	void setStepNumber(int value);

	/**
	 * Returns the value of the '<em><b>Last State Change Step Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last State Change Step Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last State Change Step Number</em>' attribute.
	 * @see #setLastStateChangeStepNumber(int)
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM_LastStateChangeStepNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getLastStateChangeStepNumber();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last State Change Step Number</em>' attribute.
	 * @see #getLastStateChangeStepNumber()
	 * @generated
	 */
	void setLastStateChangeStepNumber(int value);

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
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage#getTimedFSM_CurrentState()
	 * @model
	 * @generated
	 */
	State getCurrentState();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(State value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visit();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init();

} // TimedFSM
