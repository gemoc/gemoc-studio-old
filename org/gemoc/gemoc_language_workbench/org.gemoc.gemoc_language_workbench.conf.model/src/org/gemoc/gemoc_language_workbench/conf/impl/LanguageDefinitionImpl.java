/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.gemoc.gemoc_language_workbench.conf.AnimatorProject;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.MoCCProject;
import org.gemoc.gemoc_language_workbench.conf.confPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getDsaProject <em>Dsa Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getDomainModelProject <em>Domain Model Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getEditorProjects <em>Editor Projects</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getMoCCProject <em>Mo CC Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getAnimatorProjects <em>Animator Projects</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getDSEProject <em>DSE Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LanguageDefinitionImpl extends EObjectImpl implements LanguageDefinition {
	/**
	 * The cached value of the '{@link #getDsaProject() <em>Dsa Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDsaProject()
	 * @generated
	 * @ordered
	 */
	protected DSAProject dsaProject;

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
	 * The cached value of the '{@link #getMoCCProject() <em>Mo CC Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoCCProject()
	 * @generated
	 * @ordered
	 */
	protected MoCCProject moCCProject;

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
	 * The cached value of the '{@link #getDSEProject() <em>DSE Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDSEProject()
	 * @generated
	 * @ordered
	 */
	protected DSEProject dSEProject;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	public DSAProject getDsaProject() {
		return dsaProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDsaProject(DSAProject newDsaProject, NotificationChain msgs) {
		DSAProject oldDsaProject = dsaProject;
		dsaProject = newDsaProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__DSA_PROJECT, oldDsaProject, newDsaProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDsaProject(DSAProject newDsaProject) {
		if (newDsaProject != dsaProject) {
			NotificationChain msgs = null;
			if (dsaProject != null)
				msgs = ((InternalEObject)dsaProject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.LANGUAGE_DEFINITION__DSA_PROJECT, null, msgs);
			if (newDsaProject != null)
				msgs = ((InternalEObject)newDsaProject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.LANGUAGE_DEFINITION__DSA_PROJECT, null, msgs);
			msgs = basicSetDsaProject(newDsaProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__DSA_PROJECT, newDsaProject, newDsaProject));
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
	public MoCCProject getMoCCProject() {
		return moCCProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMoCCProject(MoCCProject newMoCCProject, NotificationChain msgs) {
		MoCCProject oldMoCCProject = moCCProject;
		moCCProject = newMoCCProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT, oldMoCCProject, newMoCCProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoCCProject(MoCCProject newMoCCProject) {
		if (newMoCCProject != moCCProject) {
			NotificationChain msgs = null;
			if (moCCProject != null)
				msgs = ((InternalEObject)moCCProject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT, null, msgs);
			if (newMoCCProject != null)
				msgs = ((InternalEObject)newMoCCProject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT, null, msgs);
			msgs = basicSetMoCCProject(newMoCCProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT, newMoCCProject, newMoCCProject));
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
	public DSEProject getDSEProject() {
		return dSEProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDSEProject(DSEProject newDSEProject, NotificationChain msgs) {
		DSEProject oldDSEProject = dSEProject;
		dSEProject = newDSEProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__DSE_PROJECT, oldDSEProject, newDSEProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDSEProject(DSEProject newDSEProject) {
		if (newDSEProject != dSEProject) {
			NotificationChain msgs = null;
			if (dSEProject != null)
				msgs = ((InternalEObject)dSEProject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - confPackage.LANGUAGE_DEFINITION__DSE_PROJECT, null, msgs);
			if (newDSEProject != null)
				msgs = ((InternalEObject)newDSEProject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - confPackage.LANGUAGE_DEFINITION__DSE_PROJECT, null, msgs);
			msgs = basicSetDSEProject(newDSEProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__DSE_PROJECT, newDSEProject, newDSEProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, confPackage.LANGUAGE_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<String> getFileExtensions() {
		EList<String> result = new BasicEList<String>();
		
		// search for a genmodel and possibly file extension in it
		try{
			DomainModelProject eep = this.getDomainModelProject();
			if (eep != null) {
				GenModel genModel = (GenModel)eep.getGenmodel();
				if (genModel != null) {
					// search extension in direct packages
					for(GenPackage genPackage : genModel.getGenPackages()){
						for(String fileExtension : genPackage.getFileExtensionList()){
							if(!result.contains(fileExtension)){
								result.add(fileExtension);
							}
						}
					}
					// search extension in used packages
					for(GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()){
						for(String fileExtension : genPackage.getFileExtensionList()){
							if(!result.contains(fileExtension)){
								result.add(fileExtension);
							}
						}
					}
				}
			}
		} catch (Throwable e){	}
		// aggregate with the other declared files extensions for the editors
		for(EditorProject editorProject : editorProjects){
			for(String fileExtension : editorProject.getFileExtension()){
				if(!result.contains(fileExtension)){
					result.add(fileExtension);
				}
			}
		}		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECT:
				return basicSetDsaProject(null, msgs);
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				return basicSetDomainModelProject(null, msgs);
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				return ((InternalEList<?>)getEditorProjects()).basicRemove(otherEnd, msgs);
			case confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT:
				return basicSetMoCCProject(null, msgs);
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				return ((InternalEList<?>)getAnimatorProjects()).basicRemove(otherEnd, msgs);
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECT:
				return basicSetDSEProject(null, msgs);
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
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECT:
				return getDsaProject();
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				return getDomainModelProject();
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				return getEditorProjects();
			case confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT:
				return getMoCCProject();
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				return getAnimatorProjects();
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECT:
				return getDSEProject();
			case confPackage.LANGUAGE_DEFINITION__NAME:
				return getName();
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
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECT:
				setDsaProject((DSAProject)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				setDomainModelProject((DomainModelProject)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				getEditorProjects().clear();
				getEditorProjects().addAll((Collection<? extends EditorProject>)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT:
				setMoCCProject((MoCCProject)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				getAnimatorProjects().clear();
				getAnimatorProjects().addAll((Collection<? extends AnimatorProject>)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECT:
				setDSEProject((DSEProject)newValue);
				return;
			case confPackage.LANGUAGE_DEFINITION__NAME:
				setName((String)newValue);
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
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECT:
				setDsaProject((DSAProject)null);
				return;
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				setDomainModelProject((DomainModelProject)null);
				return;
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				getEditorProjects().clear();
				return;
			case confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT:
				setMoCCProject((MoCCProject)null);
				return;
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				getAnimatorProjects().clear();
				return;
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECT:
				setDSEProject((DSEProject)null);
				return;
			case confPackage.LANGUAGE_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
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
			case confPackage.LANGUAGE_DEFINITION__DSA_PROJECT:
				return dsaProject != null;
			case confPackage.LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT:
				return domainModelProject != null;
			case confPackage.LANGUAGE_DEFINITION__EDITOR_PROJECTS:
				return editorProjects != null && !editorProjects.isEmpty();
			case confPackage.LANGUAGE_DEFINITION__MO_CC_PROJECT:
				return moCCProject != null;
			case confPackage.LANGUAGE_DEFINITION__ANIMATOR_PROJECTS:
				return animatorProjects != null && !animatorProjects.isEmpty();
			case confPackage.LANGUAGE_DEFINITION__DSE_PROJECT:
				return dSEProject != null;
			case confPackage.LANGUAGE_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LanguageDefinitionImpl
