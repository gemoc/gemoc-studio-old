/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EMFGenmodel;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMF Ecore Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.EMFEcoreProjectImpl#getEmfGenmodel <em>Emf Genmodel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMFEcoreProjectImpl extends DomainModelProjectImpl implements EMFEcoreProject {
	/**
	 * The cached value of the '{@link #getEmfGenmodel() <em>Emf Genmodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmfGenmodel()
	 * @generated
	 * @ordered
	 */
	protected EMFGenmodel emfGenmodel;
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
	public EMFGenmodel getEmfGenmodel() {
		return emfGenmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEmfGenmodel(EMFGenmodel newEmfGenmodel, NotificationChain msgs) {
		EMFGenmodel oldEmfGenmodel = emfGenmodel;
		emfGenmodel = newEmfGenmodel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL, oldEmfGenmodel, newEmfGenmodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmfGenmodel(EMFGenmodel newEmfGenmodel) {
		if (newEmfGenmodel != emfGenmodel) {
			NotificationChain msgs = null;
			if (emfGenmodel != null)
				msgs = ((InternalEObject)emfGenmodel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL, null, msgs);
			if (newEmfGenmodel != null)
				msgs = ((InternalEObject)newEmfGenmodel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL, null, msgs);
			msgs = basicSetEmfGenmodel(newEmfGenmodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL, newEmfGenmodel, newEmfGenmodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL:
				return basicSetEmfGenmodel(null, msgs);
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
			case confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL:
				return getEmfGenmodel();
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
			case confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL:
				setEmfGenmodel((EMFGenmodel)newValue);
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
			case confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL:
				setEmfGenmodel((EMFGenmodel)null);
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
			case confPackage.EMF_ECORE_PROJECT__EMF_GENMODEL:
				return emfGenmodel != null;
		}
		return super.eIsSet(featureID);
	}

} //EMFEcoreProjectImpl
