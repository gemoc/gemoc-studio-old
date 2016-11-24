/**
 */
package tfsmTrace.States;

import org.eclipse.emf.common.util.EList;

import tfsmTrace.States.tfsm.TracedState;
import tfsmTrace.States.tfsm.TracedTimeFSM;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time FSM current State Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.TimeFSM_currentState_Value#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link tfsmTrace.States.TimeFSM_currentState_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link tfsmTrace.States.TimeFSM_currentState_Value#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.StatesPackage#getTimeFSM_currentState_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface TimeFSM_currentState_Value extends Value {
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
	 * @see tfsmTrace.States.StatesPackage#getTimeFSM_currentState_Value_CurrentState()
	 * @model
	 * @generated
	 */
	TracedState getCurrentState();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.TimeFSM_currentState_Value#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(TracedState value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.tfsm.TracedTimeFSM#getCurrentStateSequence <em>Current State Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedTimeFSM)
	 * @see tfsmTrace.States.StatesPackage#getTimeFSM_currentState_Value_Parent()
	 * @see tfsmTrace.States.tfsm.TracedTimeFSM#getCurrentStateSequence
	 * @model opposite="currentStateSequence" required="true" transient="false"
	 * @generated
	 */
	TracedTimeFSM getParent();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.TimeFSM_currentState_Value#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TracedTimeFSM value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.States.State}.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.State#getTimeFSM_currentState_Values <em>Time FSM current State Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see tfsmTrace.States.StatesPackage#getTimeFSM_currentState_Value_States()
	 * @see tfsmTrace.States.State#getTimeFSM_currentState_Values
	 * @model opposite="timeFSM_currentState_Values" required="true"
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

} // TimeFSM_currentState_Value
