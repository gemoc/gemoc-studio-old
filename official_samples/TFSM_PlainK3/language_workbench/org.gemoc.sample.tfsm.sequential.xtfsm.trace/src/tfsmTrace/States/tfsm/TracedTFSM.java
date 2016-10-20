/**
 */
package tfsmTrace.States.tfsm;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM;

import tfsmTrace.States.TFSM_currentState_Value;
import tfsmTrace.States.TFSM_lastStateChangeStepNumber_Value;
import tfsmTrace.States.TFSM_stepNumber_Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced TFSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.tfsm.TracedTFSM#getCurrentStateSequence <em>Current State Sequence</em>}</li>
 *   <li>{@link tfsmTrace.States.tfsm.TracedTFSM#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}</li>
 *   <li>{@link tfsmTrace.States.tfsm.TracedTFSM#getOriginalObject <em>Original Object</em>}</li>
 *   <li>{@link tfsmTrace.States.tfsm.TracedTFSM#getStepNumberSequence <em>Step Number Sequence</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTFSM()
 * @model
 * @generated
 */
public interface TracedTFSM extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Current State Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.TFSM_currentState_Value}.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.TFSM_currentState_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State Sequence</em>' containment reference list.
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTFSM_CurrentStateSequence()
	 * @see tfsmTrace.States.TFSM_currentState_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TFSM_currentState_Value> getCurrentStateSequence();

	/**
	 * Returns the value of the '<em><b>Last State Change Step Number Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.TFSM_lastStateChangeStepNumber_Value}.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.TFSM_lastStateChangeStepNumber_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last State Change Step Number Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last State Change Step Number Sequence</em>' containment reference list.
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTFSM_LastStateChangeStepNumberSequence()
	 * @see tfsmTrace.States.TFSM_lastStateChangeStepNumber_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TFSM_lastStateChangeStepNumber_Value> getLastStateChangeStepNumberSequence();

	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(TFSM)
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTFSM_OriginalObject()
	 * @model
	 * @generated
	 */
	TFSM getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.tfsm.TracedTFSM#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(TFSM value);

	/**
	 * Returns the value of the '<em><b>Step Number Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.TFSM_stepNumber_Value}.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.TFSM_stepNumber_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Number Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Number Sequence</em>' containment reference list.
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTFSM_StepNumberSequence()
	 * @see tfsmTrace.States.TFSM_stepNumber_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TFSM_stepNumber_Value> getStepNumberSequence();

} // TracedTFSM
