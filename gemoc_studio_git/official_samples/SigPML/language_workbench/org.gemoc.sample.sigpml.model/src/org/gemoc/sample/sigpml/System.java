/**
 */
package org.gemoc.sample.sigpml;

import com.google.common.collect.LinkedListMultimap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.System#getOwnedApplication <em>Owned Application</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.System#getOwnedHWPlatform <em>Owned HW Platform</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.System#getSharedMemory <em>Shared Memory</em>}</li>
 * </ul>
 * </p>
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

	/**
	 * Returns the value of the '<em><b>Shared Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Memory</em>' attribute.
	 * @see #setSharedMemory(LinkedListMultimap)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getSystem_SharedMemory()
	 * @model dataType="org.gemoc.sample.sigpml.LinkedListMultimap"
	 * @generated
	 */
	LinkedListMultimap getSharedMemory();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.System#getSharedMemory <em>Shared Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Memory</em>' attribute.
	 * @see #getSharedMemory()
	 * @generated
	 */
	void setSharedMemory(LinkedListMultimap value);

} // System
