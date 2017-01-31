/**
 */
package fsmTrace.States;

import fsmTrace.States.fsm.TracedStateMachine;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine consummed String Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.StateMachine_consummedString_Value#getConsummedString <em>Consummed String</em>}</li>
 *   <li>{@link fsmTrace.States.StateMachine_consummedString_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link fsmTrace.States.StateMachine_consummedString_Value#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.StatesPackage#getStateMachine_consummedString_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface StateMachine_consummedString_Value extends Value {
	/**
	 * Returns the value of the '<em><b>Consummed String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consummed String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consummed String</em>' attribute.
	 * @see #setConsummedString(String)
	 * @see fsmTrace.States.StatesPackage#getStateMachine_consummedString_Value_ConsummedString()
	 * @model unique="false"
	 * @generated
	 */
	String getConsummedString();

	/**
	 * Sets the value of the '{@link fsmTrace.States.StateMachine_consummedString_Value#getConsummedString <em>Consummed String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consummed String</em>' attribute.
	 * @see #getConsummedString()
	 * @generated
	 */
	void setConsummedString(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.fsm.TracedStateMachine#getConsummedStringSequence <em>Consummed String Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedStateMachine)
	 * @see fsmTrace.States.StatesPackage#getStateMachine_consummedString_Value_Parent()
	 * @see fsmTrace.States.fsm.TracedStateMachine#getConsummedStringSequence
	 * @model opposite="consummedStringSequence" required="true" transient="false"
	 * @generated
	 */
	TracedStateMachine getParent();

	/**
	 * Sets the value of the '{@link fsmTrace.States.StateMachine_consummedString_Value#getParent <em>Parent</em>}' container reference.
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
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.State#getStateMachine_consummedString_Values <em>State Machine consummed String Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getStateMachine_consummedString_Value_States()
	 * @see fsmTrace.States.State#getStateMachine_consummedString_Values
	 * @model opposite="stateMachine_consummedString_Values" required="true"
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

} // StateMachine_consummedString_Value
