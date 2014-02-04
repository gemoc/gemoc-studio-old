/**
 */
package glml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.Identity#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getIdentity()
 * @model
 * @generated
 */
public interface Identity extends Pattern {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference.
	 * @see #setArgument(MocEvent)
	 * @see glml.GlmlPackage#getIdentity_Argument()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MocEvent getArgument();

	/**
	 * Sets the value of the '{@link glml.Identity#getArgument <em>Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Argument</em>' containment reference.
	 * @see #getArgument()
	 * @generated
	 */
	void setArgument(MocEvent value);

} // Identity
