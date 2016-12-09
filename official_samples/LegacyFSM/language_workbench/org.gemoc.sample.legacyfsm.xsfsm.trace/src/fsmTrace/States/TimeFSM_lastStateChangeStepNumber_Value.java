/**
 */
package fsmTrace.States;

import fsmTrace.States.fsm.TracedTimeFSM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time FSM last State Change Step Number Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}</li>
 *   <li>{@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.StatesPackage#getTimeFSM_lastStateChangeStepNumber_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface TimeFSM_lastStateChangeStepNumber_Value extends Value {
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
	 * @see fsmTrace.States.StatesPackage#getTimeFSM_lastStateChangeStepNumber_Value_LastStateChangeStepNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getLastStateChangeStepNumber();

	/**
	 * Sets the value of the '{@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last State Change Step Number</em>' attribute.
	 * @see #getLastStateChangeStepNumber()
	 * @generated
	 */
	void setLastStateChangeStepNumber(int value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.fsm.TracedTimeFSM#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedTimeFSM)
	 * @see fsmTrace.States.StatesPackage#getTimeFSM_lastStateChangeStepNumber_Value_Parent()
	 * @see fsmTrace.States.fsm.TracedTimeFSM#getLastStateChangeStepNumberSequence
	 * @model opposite="lastStateChangeStepNumberSequence" required="true" transient="false"
	 * @generated
	 */
	TracedTimeFSM getParent();

	/**
	 * Sets the value of the '{@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TracedTimeFSM value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.States.State}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.State#getTimeFSM_lastStateChangeStepNumber_Values <em>Time FSM last State Change Step Number Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getTimeFSM_lastStateChangeStepNumber_Value_States()
	 * @see fsmTrace.States.State#getTimeFSM_lastStateChangeStepNumber_Values
	 * @model opposite="timeFSM_lastStateChangeStepNumber_Values" required="true"
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

} // TimeFSM_lastStateChangeStepNumber_Value
