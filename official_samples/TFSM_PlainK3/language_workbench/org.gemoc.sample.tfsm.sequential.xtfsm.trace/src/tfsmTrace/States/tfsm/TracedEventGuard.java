/**
 */
package tfsmTrace.States.tfsm;

import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EventGuard;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced Event Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.tfsm.TracedEventGuard#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedEventGuard()
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
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedEventGuard_OriginalObject()
	 * @model
	 * @generated
	 */
	EventGuard getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.tfsm.TracedEventGuard#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(EventGuard value);

} // TracedEventGuard
