/**
 */
package fsmTrace.States;

import fsmTrace.States.fsm.TracedStateMachine;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine unprocessed String Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.StateMachine_unprocessedString_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link fsmTrace.States.StateMachine_unprocessedString_Value#getStates <em>States</em>}</li>
 *   <li>{@link fsmTrace.States.StateMachine_unprocessedString_Value#getUnprocessedString <em>Unprocessed String</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.StatesPackage#getStateMachine_unprocessedString_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface StateMachine_unprocessedString_Value extends Value {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.fsm.TracedStateMachine#getUnprocessedStringSequence <em>Unprocessed String Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedStateMachine)
	 * @see fsmTrace.States.StatesPackage#getStateMachine_unprocessedString_Value_Parent()
	 * @see fsmTrace.States.fsm.TracedStateMachine#getUnprocessedStringSequence
	 * @model opposite="unprocessedStringSequence" required="true" transient="false"
	 * @generated
	 */
	TracedStateMachine getParent();

	/**
	 * Sets the value of the '{@link fsmTrace.States.StateMachine_unprocessedString_Value#getParent <em>Parent</em>}' container reference.
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
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.State#getStateMachine_unprocessedString_Values <em>State Machine unprocessed String Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getStateMachine_unprocessedString_Value_States()
	 * @see fsmTrace.States.State#getStateMachine_unprocessedString_Values
	 * @model opposite="stateMachine_unprocessedString_Values" required="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Unprocessed String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unprocessed String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unprocessed String</em>' attribute.
	 * @see #setUnprocessedString(String)
	 * @see fsmTrace.States.StatesPackage#getStateMachine_unprocessedString_Value_UnprocessedString()
	 * @model unique="false"
	 * @generated
	 */
	String getUnprocessedString();

	/**
	 * Sets the value of the '{@link fsmTrace.States.StateMachine_unprocessedString_Value#getUnprocessedString <em>Unprocessed String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unprocessed String</em>' attribute.
	 * @see #getUnprocessedString()
	 * @generated
	 */
	void setUnprocessedString(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getStates();'"
	 * @generated
	 */
	EList<State> getStatesNoOpposite();

} // StateMachine_unprocessedString_Value
