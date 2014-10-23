/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.gemoc.gemoc_language_workbench.conf.MoCCProject;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MoCC Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * 
 *
 * @generated
 */
public class MoCCProjectImpl extends ProjectResourceImpl implements MoCCProject {
	/**
	 * The default value of the '{@link #getQvtoURI() <em>Qvto URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtoURI()
	 * @generated
	 * @ordered
	 */
	//protected static final String QVTO_URI_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getQvtoURI() <em>Qvto URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtoURI()
	 * @generated
	 * @ordered
	 */
	//protected String qvtoURI = QVTO_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoCCProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return confPackage.Literals.MO_CC_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			//case confPackage.DSE_PROJECT__QVTO_URI:
				//return getQvtoURI();
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
			//case confPackage.DSE_PROJECT__QVTO_URI:
				//setQvtoURI((String)newValue);
				//return;
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
			//case confPackage.DSE_PROJECT__QVTO_URI:
				//setQvtoURI(QVTO_URI_EDEFAULT);
				//return;
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
			//case confPackage.DSE_PROJECT__QVTO_URI:
				//return QVTO_URI_EDEFAULT == null ? qvtoURI != null : !QVTO_URI_EDEFAULT.equals(qvtoURI);
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
		result.append(" (qvtoURI: ");
		//result.append(qvtoURI);
		result.append(')');
		return result.toString();
	}

} //DSEProjectImpl
