/**
 */
package org.gemoc.sample.legacyfsm.fsm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.legacyfsm.fsm.EventGuard#getTriggeringEvent <em>Triggering Event</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.legacyfsm.fsm.FsmPackage#getEventGuard()
 * @model
 * @generated
 */
public interface EventGuard extends Guard {
	/**
	 * Returns the value of the '<em><b>Triggering Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggering Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggering Event</em>' reference.
	 * @see #setTriggeringEvent(FSMEvent)
	 * @see org.gemoc.sample.legacyfsm.fsm.FsmPackage#getEventGuard_TriggeringEvent()
	 * @model required="true"
	 * @generated
	 */
	FSMEvent getTriggeringEvent();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.legacyfsm.fsm.EventGuard#getTriggeringEvent <em>Triggering Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triggering Event</em>' reference.
	 * @see #getTriggeringEvent()
	 * @generated
	 */
	void setTriggeringEvent(FSMEvent value);

} // EventGuard