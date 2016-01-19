/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.tfsm_plaink3.Transition;

import tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Traced FSM Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getIsTriggeredSequence <em>Is Triggered Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedFSMEvent()
 * @model
 * @generated
 */
public interface TracedFSMEvent extends TracedNamedElement {
	/**
	 * Returns the value of the '<em><b>Is Triggered Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Triggered Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Triggered Sequence</em>' containment reference list.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedFSMEvent_IsTriggeredSequence()
	 * @see tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<FSMEvent_isTriggered_Value> getIsTriggeredSequence();

	/**
	 * Returns the value of the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.tfsm_plaink3.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solliciting Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solliciting Transitions</em>' reference list.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#getTracedFSMEvent_SollicitingTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getSollicitingTransitions();

} // TracedFSMEvent
