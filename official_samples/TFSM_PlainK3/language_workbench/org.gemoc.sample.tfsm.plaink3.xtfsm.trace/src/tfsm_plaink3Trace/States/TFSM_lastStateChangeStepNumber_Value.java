/**
 */
package tfsm_plaink3Trace.States;

import org.eclipse.emf.common.util.EList;

import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TFSM last State Change Step Number Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see tfsm_plaink3Trace.States.StatesPackage#getTFSM_lastStateChangeStepNumber_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface TFSM_lastStateChangeStepNumber_Value extends Value {
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
	 * @see tfsm_plaink3Trace.States.StatesPackage#getTFSM_lastStateChangeStepNumber_Value_LastStateChangeStepNumber()
	 * @model
	 * @generated
	 */
	int getLastStateChangeStepNumber();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last State Change Step Number</em>' attribute.
	 * @see #getLastStateChangeStepNumber()
	 * @generated
	 */
	void setLastStateChangeStepNumber(int value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedTFSM)
	 * @see tfsm_plaink3Trace.States.StatesPackage#getTFSM_lastStateChangeStepNumber_Value_Parent()
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getLastStateChangeStepNumberSequence
	 * @model opposite="lastStateChangeStepNumberSequence" required="true" transient="false"
	 * @generated
	 */
	TracedTFSM getParent();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TracedTFSM value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.State}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.State#getTFSM_lastStateChangeStepNumber_Values <em>TFSM last State Change Step Number Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see tfsm_plaink3Trace.States.StatesPackage#getTFSM_lastStateChangeStepNumber_Value_States()
	 * @see tfsm_plaink3Trace.States.State#getTFSM_lastStateChangeStepNumber_Values
	 * @model opposite="tFSM_lastStateChangeStepNumber_Values" required="true"
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

} // TFSM_lastStateChangeStepNumber_Value
