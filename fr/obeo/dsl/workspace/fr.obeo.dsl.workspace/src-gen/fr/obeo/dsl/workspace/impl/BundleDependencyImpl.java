/**
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 */
package fr.obeo.dsl.workspace.impl;

import fr.obeo.dsl.workspace.BundleDependency;
import fr.obeo.dsl.workspace.Project;
import fr.obeo.dsl.workspace.WorkspacePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Bundle Dependency</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl#getProject <em>Project</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl#getId <em>Id</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl#getLowerVersion <em>Lower Version</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl#isLowerVersionIncluded <em>Lower Version
 * Included</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl#getUpperVersion <em>Upper Version</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl#isUpperVersionIncluded <em>Upper Version
 * Included</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl#isExported <em>Exported</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BundleDependencyImpl extends EObjectImpl implements BundleDependency {
	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerVersion() <em>Lower Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLowerVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String LOWER_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLowerVersion() <em>Lower Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLowerVersion()
	 * @generated
	 * @ordered
	 */
	protected String lowerVersion = LOWER_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isLowerVersionIncluded() <em>Lower Version Included</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLowerVersionIncluded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOWER_VERSION_INCLUDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLowerVersionIncluded() <em>Lower Version Included</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLowerVersionIncluded()
	 * @generated
	 * @ordered
	 */
	protected boolean lowerVersionIncluded = LOWER_VERSION_INCLUDED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpperVersion() <em>Upper Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUpperVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String UPPER_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpperVersion() <em>Upper Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUpperVersion()
	 * @generated
	 * @ordered
	 */
	protected String upperVersion = UPPER_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isUpperVersionIncluded() <em>Upper Version Included</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isUpperVersionIncluded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UPPER_VERSION_INCLUDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUpperVersionIncluded() <em>Upper Version Included</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isUpperVersionIncluded()
	 * @generated
	 * @ordered
	 */
	protected boolean upperVersionIncluded = UPPER_VERSION_INCLUDED_EDEFAULT;

	/**
	 * The default value of the '{@link #isExported() <em>Exported</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isExported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExported() <em>Exported</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isExported()
	 * @generated
	 * @ordered
	 */
	protected boolean exported = EXPORTED_EDEFAULT;

	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BundleDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.BUNDLE_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project getProject() {
		if (project != null && project.eIsProxy()) {
			InternalEObject oldProject = (InternalEObject)project;
			project = (Project)eResolveProxy(oldProject);
			if (project != oldProject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkspacePackage.BUNDLE_DEPENDENCY__PROJECT, oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProject(Project newProject) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.BUNDLE_DEPENDENCY__PROJECT, oldProject, project));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.BUNDLE_DEPENDENCY__ID,
					oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLowerVersion() {
		return lowerVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLowerVersion(String newLowerVersion) {
		String oldLowerVersion = lowerVersion;
		lowerVersion = newLowerVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION, oldLowerVersion, lowerVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isLowerVersionIncluded() {
		return lowerVersionIncluded;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLowerVersionIncluded(boolean newLowerVersionIncluded) {
		boolean oldLowerVersionIncluded = lowerVersionIncluded;
		lowerVersionIncluded = newLowerVersionIncluded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION_INCLUDED, oldLowerVersionIncluded,
					lowerVersionIncluded));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getUpperVersion() {
		return upperVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUpperVersion(String newUpperVersion) {
		String oldUpperVersion = upperVersion;
		upperVersion = newUpperVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION, oldUpperVersion, upperVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isUpperVersionIncluded() {
		return upperVersionIncluded;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUpperVersionIncluded(boolean newUpperVersionIncluded) {
		boolean oldUpperVersionIncluded = upperVersionIncluded;
		upperVersionIncluded = newUpperVersionIncluded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION_INCLUDED, oldUpperVersionIncluded,
					upperVersionIncluded));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isExported() {
		return exported;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExported(boolean newExported) {
		boolean oldExported = exported;
		exported = newExported;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.BUNDLE_DEPENDENCY__EXPORTED, oldExported, exported));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.BUNDLE_DEPENDENCY__OPTIONAL, oldOptional, optional));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkspacePackage.BUNDLE_DEPENDENCY__PROJECT:
				if (resolve)
					return getProject();
				return basicGetProject();
			case WorkspacePackage.BUNDLE_DEPENDENCY__ID:
				return getId();
			case WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION:
				return getLowerVersion();
			case WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION_INCLUDED:
				return isLowerVersionIncluded();
			case WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION:
				return getUpperVersion();
			case WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION_INCLUDED:
				return isUpperVersionIncluded();
			case WorkspacePackage.BUNDLE_DEPENDENCY__EXPORTED:
				return isExported();
			case WorkspacePackage.BUNDLE_DEPENDENCY__OPTIONAL:
				return isOptional();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkspacePackage.BUNDLE_DEPENDENCY__PROJECT:
				setProject((Project)newValue);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__ID:
				setId((String)newValue);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION:
				setLowerVersion((String)newValue);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION_INCLUDED:
				setLowerVersionIncluded((Boolean)newValue);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION:
				setUpperVersion((String)newValue);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION_INCLUDED:
				setUpperVersionIncluded((Boolean)newValue);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__EXPORTED:
				setExported((Boolean)newValue);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__OPTIONAL:
				setOptional((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkspacePackage.BUNDLE_DEPENDENCY__PROJECT:
				setProject((Project)null);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__ID:
				setId(ID_EDEFAULT);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION:
				setLowerVersion(LOWER_VERSION_EDEFAULT);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION_INCLUDED:
				setLowerVersionIncluded(LOWER_VERSION_INCLUDED_EDEFAULT);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION:
				setUpperVersion(UPPER_VERSION_EDEFAULT);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION_INCLUDED:
				setUpperVersionIncluded(UPPER_VERSION_INCLUDED_EDEFAULT);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__EXPORTED:
				setExported(EXPORTED_EDEFAULT);
				return;
			case WorkspacePackage.BUNDLE_DEPENDENCY__OPTIONAL:
				setOptional(OPTIONAL_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkspacePackage.BUNDLE_DEPENDENCY__PROJECT:
				return project != null;
			case WorkspacePackage.BUNDLE_DEPENDENCY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION:
				return LOWER_VERSION_EDEFAULT == null ? lowerVersion != null : !LOWER_VERSION_EDEFAULT
						.equals(lowerVersion);
			case WorkspacePackage.BUNDLE_DEPENDENCY__LOWER_VERSION_INCLUDED:
				return lowerVersionIncluded != LOWER_VERSION_INCLUDED_EDEFAULT;
			case WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION:
				return UPPER_VERSION_EDEFAULT == null ? upperVersion != null : !UPPER_VERSION_EDEFAULT
						.equals(upperVersion);
			case WorkspacePackage.BUNDLE_DEPENDENCY__UPPER_VERSION_INCLUDED:
				return upperVersionIncluded != UPPER_VERSION_INCLUDED_EDEFAULT;
			case WorkspacePackage.BUNDLE_DEPENDENCY__EXPORTED:
				return exported != EXPORTED_EDEFAULT;
			case WorkspacePackage.BUNDLE_DEPENDENCY__OPTIONAL:
				return optional != OPTIONAL_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", lowerVersion: ");
		result.append(lowerVersion);
		result.append(", lowerVersionIncluded: ");
		result.append(lowerVersionIncluded);
		result.append(", upperVersion: ");
		result.append(upperVersion);
		result.append(", upperVersionIncluded: ");
		result.append(upperVersionIncluded);
		result.append(", exported: ");
		result.append(exported);
		result.append(", optional: ");
		result.append(optional);
		result.append(')');
		return result.toString();
	}

} // BundleDependencyImpl
