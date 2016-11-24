/**
 */
package tfsmTrace.States.tfsm;

import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced Timed System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.tfsm.TracedTimedSystem#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTimedSystem()
 * @model
 * @generated
 */
public interface TracedTimedSystem extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(TimedSystem)
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedTimedSystem_OriginalObject()
	 * @model
	 * @generated
	 */
	TimedSystem getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.tfsm.TracedTimedSystem#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(TimedSystem value);

} // TracedTimedSystem
