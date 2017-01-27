/**
 */
package fsmTrace.States;

import fsmTrace.States.fsm.TracedStateMachine;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine actions To Process Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.StateMachine_actionsToProcess_Value#getActionsToProcess <em>Actions To Process</em>}</li>
 *   <li>{@link fsmTrace.States.StateMachine_actionsToProcess_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link fsmTrace.States.StateMachine_actionsToProcess_Value#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.StatesPackage#getStateMachine_actionsToProcess_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface StateMachine_actionsToProcess_Value extends Value {
	/**
	 * Returns the value of the '<em><b>Actions To Process</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions To Process</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions To Process</em>' attribute list.
	 * @see fsmTrace.States.StatesPackage#getStateMachine_actionsToProcess_Value_ActionsToProcess()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getActionsToProcess();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.fsm.TracedStateMachine#getActionsToProcessSequence <em>Actions To Process Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedStateMachine)
	 * @see fsmTrace.States.StatesPackage#getStateMachine_actionsToProcess_Value_Parent()
	 * @see fsmTrace.States.fsm.TracedStateMachine#getActionsToProcessSequence
	 * @model opposite="actionsToProcessSequence" required="true" transient="false"
	 * @generated
	 */
	TracedStateMachine getParent();

	/**
	 * Sets the value of the '{@link fsmTrace.States.StateMachine_actionsToProcess_Value#getParent <em>Parent</em>}' container reference.
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
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.State#getStateMachine_actionsToProcess_Values <em>State Machine actions To Process Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getStateMachine_actionsToProcess_Value_States()
	 * @see fsmTrace.States.State#getStateMachine_actionsToProcess_Values
	 * @model opposite="stateMachine_actionsToProcess_Values" required="true"
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

} // StateMachine_actionsToProcess_Value
