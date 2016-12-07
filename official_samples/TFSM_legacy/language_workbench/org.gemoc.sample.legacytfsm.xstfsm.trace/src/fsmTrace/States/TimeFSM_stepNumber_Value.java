/**
 */
package fsmTrace.States;

import fsmTrace.States.fsm.TracedTimeFSM;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time FSM step Number Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.TimeFSM_stepNumber_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link fsmTrace.States.TimeFSM_stepNumber_Value#getStates <em>States</em>}</li>
 *   <li>{@link fsmTrace.States.TimeFSM_stepNumber_Value#getStepNumber <em>Step Number</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.StatesPackage#getTimeFSM_stepNumber_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface TimeFSM_stepNumber_Value extends Value {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.fsm.TracedTimeFSM#getStepNumberSequence <em>Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedTimeFSM)
	 * @see fsmTrace.States.StatesPackage#getTimeFSM_stepNumber_Value_Parent()
	 * @see fsmTrace.States.fsm.TracedTimeFSM#getStepNumberSequence
	 * @model opposite="stepNumberSequence" required="true" transient="false"
	 * @generated
	 */
	TracedTimeFSM getParent();

	/**
	 * Sets the value of the '{@link fsmTrace.States.TimeFSM_stepNumber_Value#getParent <em>Parent</em>}' container reference.
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
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.State#getTimeFSM_stepNumber_Values <em>Time FSM step Number Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getTimeFSM_stepNumber_Value_States()
	 * @see fsmTrace.States.State#getTimeFSM_stepNumber_Values
	 * @model opposite="timeFSM_stepNumber_Values" required="true"
	 * @generated
	 */
	EList<State> getStates();

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
	 * @see fsmTrace.States.StatesPackage#getTimeFSM_stepNumber_Value_StepNumber()
	 * @model unique="false"
	 * @generated
	 */
	int getStepNumber();

	/**
	 * Sets the value of the '{@link fsmTrace.States.TimeFSM_stepNumber_Value#getStepNumber <em>Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Number</em>' attribute.
	 * @see #getStepNumber()
	 * @generated
	 */
	void setStepNumber(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getStates();'"
	 * @generated
	 */
	EList<State> getStatesNoOpposite();

} // TimeFSM_stepNumber_Value
