/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.gemoc_language_workbench.conf.AnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.MoCProject;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getDsaProjects <em>Dsa Projects</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getDomainModelProject <em>Domain Model Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getEditorProjects <em>Editor Projects</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getMoCModelProjects <em>Mo CModel Projects</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getAnimatorProjects <em>Animator Projects</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getDSEProjects <em>DSE Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LanguageDefinitionImpl extends EObjectImpl implements LanguageDefinition {
	/**
	 * The cached value of the '{@link #getDsaProjects() <em>Dsa Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDsaProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<DSAProject> dsaProjects;

	/**
	 * The cached value of the '{@link #getDomainModelProject() <em>Domain Model Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModelProject()
	 * @generated
	 * @ordered
	 */
	protected DomainModelProject domainModelProject;

	/**
	 * The cached value of the '{@link #getEditorProjects() <em>Editor Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<EditorProject> editorProjects;

	/**
	 * The cached value of the '{@link #getMoCModelProjects() <em>Mo CModel Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoCModelProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCProject> moCModelProjects;

	/**
	 * The cached value of the '{@link #getAnimatorProjects() <em>Animator Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimatorProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<AnimatorProject> animatorProjects;

	/**
	 * The cached value of the '{@link #getDSEProjects() <em>DSE Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDSEProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<DSEProject> dSEProjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return confPackage.Literals.LANGUAGE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DSAProject> getDsaProjects() {
		if (dsaProjects == null) {
			dsaProjects = new EObjectContainmentEList<DSAProject>(DSAProject.class, this, confPackage.LANGUAGE_DEFINITION__DSA_PROJECTS);
		}
		return dsaProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainModelProject getDomainModelProject() {
		return domainModelProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomainModelProject(DomainModelProject newDomainModelProject, NotificationChain msgs) {
		DomainModelProject oldDomainModelProject = domainModelProject;
		domainModelProject = newDomainModelProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT, oldDomainModelProject, newDomainModelProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainModelProject(DomainModelProject newDomainModelProject) {
		if (newDomainModelProject != domainModelProject) {
			NotificationChain msgs = null;
			if (domainModelProject != null)
				msgs = ((InternalEObject)domainModelProject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT, null, msgs);
			if (newDomainModelProject != null)
				msgs = ((InternalEObject)newDomainModelProject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT, null, msgs);
			msgs = basicSetDomainModelProject(newDomainModelProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT, newDomainModelProject, newDomainModelProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EditorProject> getEditorProjects() {
		if (editorProjects == null) {
			editorProjects = new EObjectContainmentEList<EditorProject>(EditorProject.class, this, confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS);
		}
		return editorProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCProject> getMoCModelProjects() {
		if (moCModelProjects == null) {
			moCModelProjects = new EObjectContainmentEList<MoCProject>(MoCProject.class, this, confPackage.LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS);
		}
		return moCModelProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnimatorProject> getAnimatorProjects() {
		if (animatorProjects == null) {
			animatorProjects = new EObjectContainmentEList<AnimatorProject>(AnimatorProject.class, this, confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS);
		}
		return animatorProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DSEProject> getDSEProjects() {
		if (dSEProjects == null) {
			dSEProjects = new EObjectContainmentEList<DSEProject>(DSEProject.class, this, confPackage.LANGUAGE_DEFINITION__DSE_PROJECTS);
		}
		return dSEProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECTS:
				return ((InternalEList<?>)getDsaProjects()).basicRemove(otherEnd, msgs);
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				return basicSetDomainModelProject(null, msgs);
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				return ((InternalEList<?>)getEditorProjects()).basicRemove(otherEnd, msgs);
			case confPackage.LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS:
				return ((InternalEList<?>)getMoCModelProjects()).basicRemove(otherEnd, msgs);
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				return ((InternalEList<?>)getAnimatorProjects()).basicRemove(otherEnd, msgs);
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECTS:
				return ((InternalEList<?>)getDSEProjects()).basicRemove(otherEnd, msgs);
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
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECTS:
				return getDsaProjects();
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				return getDomainModelProject();
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				return getEditorProjects();
			case confPackage.LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS:
				return getMoCModelProjects();
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				return getAnimatorProjects();
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECTS:
				return getDSEProjects();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECTS:
				getDsaProjects().clear();
				getDsaProjects().addAll((Collection<? extends DSAProject>)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				setDomainModelProject((DomainModelProject)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				getEditorProjects().clear();
				getEditorProjects().addAll((Collection<? extends EditorProject>)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS:
				getMoCModelProjects().clear();
				getMoCModelProjects().addAll((Collection<? extends MoCProject>)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				getAnimatorProjects().clear();
				getAnimatorProjects().addAll((Collection<? extends AnimatorProject>)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECTS:
				getDSEProjects().clear();
				getDSEProjects().addAll((Collection<? extends DSEProject>)newValue);
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
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECTS:
				getDsaProjects().clear();
				return;
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				setDomainModelProject((DomainModelProject)null);
				return;
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				getEditorProjects().clear();
				return;
			case confPackage.LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS:
				getMoCModelProjects().clear();
				return;
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				getAnimatorProjects().clear();
				return;
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECTS:
				getDSEProjects().clear();
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
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECTS:
				return dsaProjects != null && !dsaProjects.isEmpty();
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				return domainModelProject != null;
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				return editorProjects != null && !editorProjects.isEmpty();
			case confPackage.LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS:
				return moCModelProjects != null && !moCModelProjects.isEmpty();
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				return animatorProjects != null && !animatorProjects.isEmpty();
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECTS:
				return dSEProjects != null && !dSEProjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LanguageDefinitionImpl
