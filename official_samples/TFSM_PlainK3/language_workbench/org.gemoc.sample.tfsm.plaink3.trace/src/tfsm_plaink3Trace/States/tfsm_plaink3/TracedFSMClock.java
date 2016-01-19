/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3;

import org.eclipse.emf.common.util.EList;

import tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced FSM Clock</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedFSMClock()
 * @model
 * @generated
 */
public interface TracedFSMClock extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Number Of Ticks Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Ticks Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Ticks Sequence</em>' containment reference list.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedFSMClock_NumberOfTicksSequence()
	 * @see tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<FSMClock_numberOfTicks_Value> getNumberOfTicksSequence();

} // TracedFSMClock
