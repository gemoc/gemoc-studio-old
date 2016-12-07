/**
 */
package fsmTrace.States.fsm;

import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced Evaluate Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.fsm.TracedEvaluateGuard#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.fsm.FsmPackage#getTracedEvaluateGuard()
 * @model
 * @generated
 */
public interface TracedEvaluateGuard extends TracedGuard {
	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(EvaluateGuard)
	 * @see fsmTrace.States.fsm.FsmPackage#getTracedEvaluateGuard_OriginalObject()
	 * @model
	 * @generated
	 */
	EvaluateGuard getOriginalObject();

	/**
	 * Sets the value of the '{@link fsmTrace.States.fsm.TracedEvaluateGuard#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(EvaluateGuard value);

} // TracedEvaluateGuard
