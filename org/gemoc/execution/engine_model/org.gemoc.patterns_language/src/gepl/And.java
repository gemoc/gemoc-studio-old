/**
 */
package gepl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gepl.And#getFirstParameter <em>First Parameter</em>}</li>
 *   <li>{@link gepl.And#getSecondParameter <em>Second Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see gepl.GeplPackage#getAnd()
 * @model
 * @generated
 */
public interface And extends Atom {
	/**
	 * Returns the value of the '<em><b>First Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Parameter</em>' containment reference.
	 * @see #setFirstParameter(Atom)
	 * @see gepl.GeplPackage#getAnd_FirstParameter()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Atom getFirstParameter();

	/**
	 * Sets the value of the '{@link gepl.And#getFirstParameter <em>First Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Parameter</em>' containment reference.
	 * @see #getFirstParameter()
	 * @generated
	 */
	void setFirstParameter(Atom value);

	/**
	 * Returns the value of the '<em><b>Second Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Parameter</em>' containment reference.
	 * @see #setSecondParameter(Atom)
	 * @see gepl.GeplPackage#getAnd_SecondParameter()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Atom getSecondParameter();

	/**
	 * Sets the value of the '{@link gepl.And#getSecondParameter <em>Second Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Parameter</em>' containment reference.
	 * @see #getSecondParameter()
	 * @generated
	 */
	void setSecondParameter(Atom value);

} // And
