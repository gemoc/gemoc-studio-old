/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.gemoc.gemoc_language_workbench.conf.ECLFile;
import org.gemoc.gemoc_language_workbench.conf.ECLProject;
import org.gemoc.gemoc_language_workbench.conf.QVToFile;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ECL Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.ECLProjectImpl#getEclFile <em>Ecl File</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.ECLProjectImpl#getQvtoFile <em>Qvto File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ECLProjectImpl extends DSEProjectImpl implements ECLProject {
	/**
	 * The cached value of the '{@link #getEclFile() <em>Ecl File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEclFile()
	 * @generated
	 * @ordered
	 */
	protected ECLFile eclFile;

	/**
	 * The cached value of the '{@link #getQvtoFile() <em>Qvto File</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtoFile()
	 * @generated
	 * @ordered
	 */
	protected QVToFile qvtoFile;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ECLProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return confPackage.Literals.ECL_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECLFile getEclFile() {
		return eclFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEclFile(ECLFile newEclFile, NotificationChain msgs) {
		ECLFile oldEclFile = eclFile;
		eclFile = newEclFile;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.ECL_PROJECT__ECL_FILE, oldEclFile, newEclFile);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEclFile(ECLFile newEclFile) {
		if (newEclFile != eclFile) {
			NotificationChain msgs = null;
			if (eclFile != null)
				msgs = ((InternalEObject)eclFile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.ECL_PROJECT__ECL_FILE, null, msgs);
			if (newEclFile != null)
				msgs = ((InternalEObject)newEclFile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.ECL_PROJECT__ECL_FILE, null, msgs);
			msgs = basicSetEclFile(newEclFile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.ECL_PROJECT__ECL_FILE, newEclFile, newEclFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVToFile getQvtoFile() {
		if (qvtoFile != null && qvtoFile.eIsProxy()) {
			InternalEObject oldQvtoFile = (InternalEObject)qvtoFile;
			qvtoFile = (QVToFile)eResolveProxy(oldQvtoFile);
			if (qvtoFile != oldQvtoFile) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, confPackage.ECL_PROJECT__QVTO_FILE, oldQvtoFile, qvtoFile));
			}
		}
		return qvtoFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVToFile basicGetQvtoFile() {
		return qvtoFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtoFile(QVToFile newQvtoFile) {
		QVToFile oldQvtoFile = qvtoFile;
		qvtoFile = newQvtoFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.ECL_PROJECT__QVTO_FILE, oldQvtoFile, qvtoFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case confPackage.ECL_PROJECT__ECL_FILE:
				return basicSetEclFile(null, msgs);
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
			case confPackage.ECL_PROJECT__ECL_FILE:
				return getEclFile();
			case confPackage.ECL_PROJECT__QVTO_FILE:
				if (resolve) return getQvtoFile();
				return basicGetQvtoFile();
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
			case confPackage.ECL_PROJECT__ECL_FILE:
				setEclFile((ECLFile)newValue);
				return;
			case confPackage.ECL_PROJECT__QVTO_FILE:
				setQvtoFile((QVToFile)newValue);
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
			case confPackage.ECL_PROJECT__ECL_FILE:
				setEclFile((ECLFile)null);
				return;
			case confPackage.ECL_PROJECT__QVTO_FILE:
				setQvtoFile((QVToFile)null);
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
			case confPackage.ECL_PROJECT__ECL_FILE:
				return eclFile != null;
			case confPackage.ECL_PROJECT__QVTO_FILE:
				return qvtoFile != null;
		}
		return super.eIsSet(featureID);
	}

} //ECLProjectImpl
