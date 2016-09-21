/**
 */
package org.gemoc.sample.sigpml;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.System#getOwnedApplication <em>Owned Application</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.System#getOwnedHWPlatform <em>Owned HW Platform</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.SigpmlPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Application</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Application</em>' containment reference.
	 * @see #setOwnedApplication(Application)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getSystem_OwnedApplication()
	 * @model containment="true"
	 * @generated
	 */
	Application getOwnedApplication();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.System#getOwnedApplication <em>Owned Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Application</em>' containment reference.
	 * @see #getOwnedApplication()
	 * @generated
	 */
	void setOwnedApplication(Application value);

	/**
	 * Returns the value of the '<em><b>Owned HW Platform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned HW Platform</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned HW Platform</em>' containment reference.
	 * @see #setOwnedHWPlatform(HWPlatform)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getSystem_OwnedHWPlatform()
	 * @model containment="true"
	 * @generated
	 */
	HWPlatform getOwnedHWPlatform();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.System#getOwnedHWPlatform <em>Owned HW Platform</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned HW Platform</em>' containment reference.
	 * @see #getOwnedHWPlatform()
	 * @generated
	 */
	void setOwnedHWPlatform(HWPlatform value);

} // System
