/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EcoreModel;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMF Ecore Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.EMFEcoreProjectImpl#getEcoreModel <em>Ecore Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMFEcoreProjectImpl extends DomainModelProjectImpl implements EMFEcoreProject {
	/**
	 * The cached value of the '{@link #getEcoreModel() <em>Ecore Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcoreModel()
	 * @generated
	 * @ordered
	 */
	protected EcoreModel ecoreModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMFEcoreProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return confPackage.Literals.EMF_ECORE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreModel getEcoreModel() {
		return ecoreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEcoreModel(EcoreModel newEcoreModel, NotificationChain msgs) {
		EcoreModel oldEcoreModel = ecoreModel;
		ecoreModel = newEcoreModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.EMF_ECORE_PROJECT__ECORE_MODEL, oldEcoreModel, newEcoreModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEcoreModel(EcoreModel newEcoreModel) {
		if (newEcoreModel != ecoreModel) {
			NotificationChain msgs = null;
			if (ecoreModel != null)
				msgs = ((InternalEObject)ecoreModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.EMF_ECORE_PROJECT__ECORE_MODEL, null, msgs);
			if (newEcoreModel != null)
				msgs = ((InternalEObject)newEcoreModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.EMF_ECORE_PROJECT__ECORE_MODEL, null, msgs);
			msgs = basicSetEcoreModel(newEcoreModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.EMF_ECORE_PROJECT__ECORE_MODEL, newEcoreModel, newEcoreModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case confPackage.EMF_ECORE_PROJECT__ECORE_MODEL:
				return basicSetEcoreModel(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case confPackage.EMF_ECORE_PROJECT__ECORE_MODEL:
				return getEcoreModel();
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
			case confPackage.EMF_ECORE_PROJECT__ECORE_MODEL:
				setEcoreModel((EcoreModel)newValue);
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
			case confPackage.EMF_ECORE_PROJECT__ECORE_MODEL:
				setEcoreModel((EcoreModel)null);
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
			case confPackage.EMF_ECORE_PROJECT__ECORE_MODEL:
				return ecoreModel != null;
		}
		return super.eIsSet(featureID);
	}

} //EMFEcoreProjectImpl
