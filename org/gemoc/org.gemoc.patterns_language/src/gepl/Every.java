/**
 */
package gepl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Every</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gepl.Every#getAtom <em>Atom</em>}</li>
 * </ul>
 * </p>
 *
 * @see gepl.GeplPackage#getEvery()
 * @model
 * @generated
 */
public interface Every extends Pattern {
	/**
	 * Returns the value of the '<em><b>Atom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atom</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atom</em>' reference.
	 * @see #setAtom(Atom)
	 * @see gepl.GeplPackage#getEvery_Atom()
	 * @model required="true"
	 * @generated
	 */
	Atom getAtom();

	/**
	 * Sets the value of the '{@link gepl.Every#getAtom <em>Atom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atom</em>' reference.
	 * @see #getAtom()
	 * @generated
	 */
	void setAtom(Atom value);

} // Every
