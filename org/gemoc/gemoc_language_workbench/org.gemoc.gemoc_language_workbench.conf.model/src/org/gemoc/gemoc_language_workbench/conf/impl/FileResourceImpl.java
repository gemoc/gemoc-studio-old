/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.gemoc.gemoc_language_workbench.conf.FileResource;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.FileResourceImpl#getLocationURI <em>Location URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FileResourceImpl extends EObjectImpl implements FileResource {
	/**
	 * The default value of the '{@link #getLocationURI() <em>Location URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationURI()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLocationURI() <em>Location URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocationURI()
	 * @generated
	 * @ordered
	 */
	protected String locationURI = LOCATION_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return confPackage.Literals.FILE_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocationURI() {
		return locationURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationURI(String newLocationURI) {
		String oldLocationURI = locationURI;
		locationURI = newLocationURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.FILE_RESOURCE__LOCATION_URI, oldLocationURI, locationURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case confPackage.FILE_RESOURCE__LOCATION_URI:
				return getLocationURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case confPackage.FILE_RESOURCE__LOCATION_URI:
				setLocationURI((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case confPackage.FILE_RESOURCE__LOCATION_URI:
				setLocationURI(LOCATION_URI_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case confPackage.FILE_RESOURCE__LOCATION_URI:
				return LOCATION_URI_EDEFAULT == null ? locationURI != null : !LOCATION_URI_EDEFAULT.equals(locationURI);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (locationURI: ");
		result.append(locationURI);
		result.append(')');
		return result.toString();
	}

} //FileResourceImpl
