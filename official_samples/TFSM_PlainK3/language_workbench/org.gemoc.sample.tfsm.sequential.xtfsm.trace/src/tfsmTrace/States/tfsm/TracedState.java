/**
 */
package tfsmTrace.States.tfsm;

import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.tfsm.TracedState#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedState()
 * @model
 * @generated
 */
public interface TracedState extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(State)
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedState_OriginalObject()
	 * @model
	 * @generated
	 */
	State getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.tfsm.TracedState#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(State value);

} // TracedState
