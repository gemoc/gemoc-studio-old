/**
 */
package gepl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gepl.Reference#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see gepl.GeplPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends Atom {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(MocEvent)
	 * @see gepl.GeplPackage#getReference_Event()
	 * @model required="true"
	 * @generated
	 */
	MocEvent getEvent();

	/**
	 * Sets the value of the '{@link gepl.Reference#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(MocEvent value);

} // Reference
