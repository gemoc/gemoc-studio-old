/**
 */
package gemoc_language_designer_conf.impl;

import gemoc_language_designer_conf.Gemoc_language_designer_confPackage;
import gemoc_language_designer_conf.ODProject;
import gemoc_language_designer_conf.SiriusAnimatorProject;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sirius Animator Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gemoc_language_designer_conf.impl.SiriusAnimatorProjectImpl#getODProject <em>OD Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SiriusAnimatorProjectImpl extends AnimatorProjectImpl implements SiriusAnimatorProject {
	/**
	 * The cached value of the '{@link #getODProject() <em>OD Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getODProject()
	 * @generated
	 * @ordered
	 */
	protected ODProject oDProject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SiriusAnimatorProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gemoc_language_designer_confPackage.Literals.SIRIUS_ANIMATOR_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ODProject getODProject() {
		if (oDProject != null && oDProject.eIsProxy()) {
			InternalEObject oldODProject = (InternalEObject)oDProject;
			oDProject = (ODProject)eResolveProxy(oldODProject);
			if (oDProject != oldODProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gemoc_language_designer_confPackage.SIRIUS_ANIMATOR_PROJECT__OD_PROJECT, oldODProject, oDProject));
			}
		}
		return oDProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ODProject basicGetODProject() {
		return oDProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setODProject(ODProject newODProject) {
		ODProject oldODProject = oDProject;
		oDProject = newODProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_language_designer_confPackage.SIRIUS_ANIMATOR_PROJECT__OD_PROJECT, oldODProject, oDProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Gemoc_language_designer_confPackage.SIRIUS_ANIMATOR_PROJECT__OD_PROJECT:
				if (resolve) return getODProject();
				return basicGetODProject();
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
			case Gemoc_language_designer_confPackage.SIRIUS_ANIMATOR_PROJECT__OD_PROJECT:
				setODProject((ODProject)newValue);
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
			case Gemoc_language_designer_confPackage.SIRIUS_ANIMATOR_PROJECT__OD_PROJECT:
				setODProject((ODProject)null);
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
			case Gemoc_language_designer_confPackage.SIRIUS_ANIMATOR_PROJECT__OD_PROJECT:
				return oDProject != null;
		}
		return super.eIsSet(featureID);
	}

} //SiriusAnimatorProjectImpl
