/**
 */
package tfsmTrace.States.tfsm;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock;

import tfsmTrace.States.FSMClock_numberOfTicks_Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced FSM Clock</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.tfsm.TracedFSMClock#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}</li>
 *   <li>{@link tfsmTrace.States.tfsm.TracedFSMClock#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedFSMClock()
 * @model
 * @generated
 */
public interface TracedFSMClock extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Number Of Ticks Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.FSMClock_numberOfTicks_Value}.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.FSMClock_numberOfTicks_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Ticks Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Ticks Sequence</em>' containment reference list.
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedFSMClock_NumberOfTicksSequence()
	 * @see tfsmTrace.States.FSMClock_numberOfTicks_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<FSMClock_numberOfTicks_Value> getNumberOfTicksSequence();

	/**
	 * Returns the value of the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original Object</em>' reference.
	 * @see #setOriginalObject(FSMClock)
	 * @see tfsmTrace.States.tfsm.TfsmPackage#getTracedFSMClock_OriginalObject()
	 * @model
	 * @generated
	 */
	FSMClock getOriginalObject();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.tfsm.TracedFSMClock#getOriginalObject <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original Object</em>' reference.
	 * @see #getOriginalObject()
	 * @generated
	 */
	void setOriginalObject(FSMClock value);

} // TracedFSMClock
