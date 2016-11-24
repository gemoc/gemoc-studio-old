/**
 */
package tfsmTrace.States.tfsm;

import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced Temporal Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.tfsm.TracedTemporalGuard#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTemporalGuard()
 * @model
 * @generated
 */
public interface TracedTemporalGuard extends TracedGuard {
	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(TemporalGuard)
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTemporalGuard_OriginalObject()
	 * @model
	 * @generated
	 */
	TemporalGuard getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.tfsm.TracedTemporalGuard#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(TemporalGuard value);

} // TracedTemporalGuard
