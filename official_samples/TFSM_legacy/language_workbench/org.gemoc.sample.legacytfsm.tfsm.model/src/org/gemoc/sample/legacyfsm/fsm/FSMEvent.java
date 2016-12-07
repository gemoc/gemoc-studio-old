/**
 */
package org.gemoc.sample.legacyfsm.fsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.legacyfsm.fsm.FSMEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.legacyfsm.fsm.FsmPackage#getFSMEvent()
 * @model
 * @generated
 */
public interface FSMEvent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.legacyfsm.fsm.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solliciting Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solliciting Transitions</em>' reference list.
	 * @see org.gemoc.sample.legacyfsm.fsm.FsmPackage#getFSMEvent_SollicitingTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getSollicitingTransitions();

} // FSMEvent
