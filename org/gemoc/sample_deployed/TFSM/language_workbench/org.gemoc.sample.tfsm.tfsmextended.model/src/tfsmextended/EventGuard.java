/**
 */
package tfsmextended;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsmextended.EventGuard#getTriggeringEvent <em>Triggering Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsmextended.TfsmextendedPackage#getEventGuard()
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
	 * @see tfsmextended.TfsmextendedPackage#getEventGuard_TriggeringEvent()
	 * @model required="true"
	 * @generated
	 */
	FSMEvent getTriggeringEvent();

	/**
	 * Sets the value of the '{@link tfsmextended.EventGuard#getTriggeringEvent <em>Triggering Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triggering Event</em>' reference.
	 * @see #getTriggeringEvent()
	 * @generated
	 */
	void setTriggeringEvent(FSMEvent value);

} // EventGuard
