/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced Event Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedEventGuard()
 * @model
 * @generated
 */
public interface TracedEventGuard extends TracedGuard {
	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(EventGuard)
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedEventGuard_OriginalObject()
	 * @model
	 * @generated
	 */
	EventGuard getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(EventGuard value);

} // TracedEventGuard
