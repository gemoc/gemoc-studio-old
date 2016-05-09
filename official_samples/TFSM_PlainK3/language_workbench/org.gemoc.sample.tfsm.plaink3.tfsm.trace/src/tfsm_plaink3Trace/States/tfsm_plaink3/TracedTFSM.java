/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.tfsm_plaink3.TFSM;

import tfsm_plaink3Trace.States.TFSM_currentState_Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced TFSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getCurrentStateSequence <em>Current State Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM()
 * @model
 * @generated
 */
public interface TracedTFSM extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Current State Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.TFSM_currentState_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State Sequence</em>' containment reference list.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_CurrentStateSequence()
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TFSM_currentState_Value> getCurrentStateSequence();

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
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedTFSM_OriginalObject()
	 * @model
	 * @generated
	 */
	TFSM getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(TFSM value);

} // TracedTFSM
