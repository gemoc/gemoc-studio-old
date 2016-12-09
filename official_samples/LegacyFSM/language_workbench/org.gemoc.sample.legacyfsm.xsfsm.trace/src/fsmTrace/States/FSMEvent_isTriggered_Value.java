/**
 */
package fsmTrace.States;

import fsmTrace.States.fsm.TracedFSMEvent;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Event is Triggered Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.FSMEvent_isTriggered_Value#isIsTriggered <em>Is Triggered</em>}</li>
 *   <li>{@link fsmTrace.States.FSMEvent_isTriggered_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link fsmTrace.States.FSMEvent_isTriggered_Value#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.StatesPackage#getFSMEvent_isTriggered_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface FSMEvent_isTriggered_Value extends Value {
	/**
	 * Returns the value of the '<em><b>Is Triggered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Triggered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Triggered</em>' attribute.
	 * @see #setIsTriggered(boolean)
	 * @see fsmTrace.States.StatesPackage#getFSMEvent_isTriggered_Value_IsTriggered()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsTriggered();

	/**
	 * Sets the value of the '{@link fsmTrace.States.FSMEvent_isTriggered_Value#isIsTriggered <em>Is Triggered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Triggered</em>' attribute.
	 * @see #isIsTriggered()
	 * @generated
	 */
	void setIsTriggered(boolean value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.fsm.TracedFSMEvent#getIsTriggeredSequence <em>Is Triggered Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedFSMEvent)
	 * @see fsmTrace.States.StatesPackage#getFSMEvent_isTriggered_Value_Parent()
	 * @see fsmTrace.States.fsm.TracedFSMEvent#getIsTriggeredSequence
	 * @model opposite="isTriggeredSequence" required="true" transient="false"
	 * @generated
	 */
	TracedFSMEvent getParent();

	/**
	 * Sets the value of the '{@link fsmTrace.States.FSMEvent_isTriggered_Value#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TracedFSMEvent value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.States.State}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.State#getFSMEvent_isTriggered_Values <em>FSM Event is Triggered Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getFSMEvent_isTriggered_Value_States()
	 * @see fsmTrace.States.State#getFSMEvent_isTriggered_Values
	 * @model opposite="fSMEvent_isTriggered_Values" required="true"
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

} // FSMEvent_isTriggered_Value
