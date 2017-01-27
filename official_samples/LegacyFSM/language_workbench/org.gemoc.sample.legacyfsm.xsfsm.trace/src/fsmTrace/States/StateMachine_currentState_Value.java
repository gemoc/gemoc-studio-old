/**
 */
package fsmTrace.States;

import fsmTrace.States.fsm.TracedState;
import fsmTrace.States.fsm.TracedStateMachine;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine current State Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.StateMachine_currentState_Value#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link fsmTrace.States.StateMachine_currentState_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link fsmTrace.States.StateMachine_currentState_Value#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.StatesPackage#getStateMachine_currentState_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface StateMachine_currentState_Value extends Value {
	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(TracedState)
	 * @see fsmTrace.States.StatesPackage#getStateMachine_currentState_Value_CurrentState()
	 * @model
	 * @generated
	 */
	TracedState getCurrentState();

	/**
	 * Sets the value of the '{@link fsmTrace.States.StateMachine_currentState_Value#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(TracedState value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.fsm.TracedStateMachine#getCurrentStateSequence <em>Current State Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedStateMachine)
	 * @see fsmTrace.States.StatesPackage#getStateMachine_currentState_Value_Parent()
	 * @see fsmTrace.States.fsm.TracedStateMachine#getCurrentStateSequence
	 * @model opposite="currentStateSequence" required="true" transient="false"
	 * @generated
	 */
	TracedStateMachine getParent();

	/**
	 * Sets the value of the '{@link fsmTrace.States.StateMachine_currentState_Value#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TracedStateMachine value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.States.State}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.State#getStateMachine_currentState_Values <em>State Machine current State Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getStateMachine_currentState_Value_States()
	 * @see fsmTrace.States.State#getStateMachine_currentState_Values
	 * @model opposite="stateMachine_currentState_Values" required="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getStates();'"
	 * @generated
	 */
	EList<State> getStatesNoOpposite();

} // StateMachine_currentState_Value
