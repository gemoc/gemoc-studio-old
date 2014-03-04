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

import fr.obeo.dsl.workspace.Container;
import fr.obeo.dsl.workspace.Dependency;
import fr.obeo.dsl.workspace.Project;
import fr.obeo.dsl.workspace.Resource;
import fr.obeo.dsl.workspace.WorkspacePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Project</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.impl.ProjectImpl#getNatureId <em>Nature Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProjectImpl extends EObjectImpl implements Project {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFullpath() <em>Fullpath</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFullpath()
	 * @generated
	 * @ordered
	 */
	protected static final String FULLPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFullpath() <em>Fullpath</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFullpath()
	 * @generated
	 * @ordered
	 */
	protected String fullpath = FULLPATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMembers() <em>Members</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> members;

	/**
	 * The cached value of the '{@link #getNatureId() <em>Nature Id</em>}' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getNatureId()
	 * @generated
	 * @ordered
	 */
	protected EList<String> natureId;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependencies;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFullpath() {
		return fullpath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Container getParent() {
		if (eContainerFeatureID() != WorkspacePackage.PROJECT__PARENT)
			return null;
		return (Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(Container newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, WorkspacePackage.PROJECT__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(Container newParent) {
		if (newParent != eInternalContainer()
				|| (eContainerFeatureID() != WorkspacePackage.PROJECT__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, WorkspacePackage.CONTAINER__MEMBERS,
						Container.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PROJECT__PARENT,
					newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Resource> getMembers() {
		if (members == null) {
			members = new EObjectContainmentWithInverseEList<Resource>(Resource.class, this,
					WorkspacePackage.PROJECT__MEMBERS, WorkspacePackage.RESOURCE__PARENT);
		}
		return members;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getNatureId() {
		if (natureId == null) {
			natureId = new EDataTypeUniqueEList<String>(String.class, this,
					WorkspacePackage.PROJECT__NATURE_ID);
		}
		return natureId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Dependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<Dependency>(Dependency.class, this,
					WorkspacePackage.PROJECT__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.PROJECT__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Container)otherEnd, msgs);
			case WorkspacePackage.PROJECT__MEMBERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMembers()).basicAdd(otherEnd,
						msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.PROJECT__PARENT:
				return basicSetParent(null, msgs);
			case WorkspacePackage.PROJECT__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
			case WorkspacePackage.PROJECT__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case WorkspacePackage.PROJECT__PARENT:
				return eInternalContainer().eInverseRemove(this, WorkspacePackage.CONTAINER__MEMBERS,
						Container.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkspacePackage.PROJECT__NAME:
				return getName();
			case WorkspacePackage.PROJECT__FULLPATH:
				return getFullpath();
			case WorkspacePackage.PROJECT__PARENT:
				return getParent();
			case WorkspacePackage.PROJECT__MEMBERS:
				return getMembers();
			case WorkspacePackage.PROJECT__NATURE_ID:
				return getNatureId();
			case WorkspacePackage.PROJECT__DEPENDENCIES:
				return getDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkspacePackage.PROJECT__NAME:
				setName((String)newValue);
				return;
			case WorkspacePackage.PROJECT__PARENT:
				setParent((Container)newValue);
				return;
			case WorkspacePackage.PROJECT__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends Resource>)newValue);
				return;
			case WorkspacePackage.PROJECT__NATURE_ID:
				getNatureId().clear();
				getNatureId().addAll((Collection<? extends String>)newValue);
				return;
			case WorkspacePackage.PROJECT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Dependency>)newValue);
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
			case WorkspacePackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkspacePackage.PROJECT__PARENT:
				setParent((Container)null);
				return;
			case WorkspacePackage.PROJECT__MEMBERS:
				getMembers().clear();
				return;
			case WorkspacePackage.PROJECT__NATURE_ID:
				getNatureId().clear();
				return;
			case WorkspacePackage.PROJECT__DEPENDENCIES:
				getDependencies().clear();
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
			case WorkspacePackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkspacePackage.PROJECT__FULLPATH:
				return FULLPATH_EDEFAULT == null ? fullpath != null : !FULLPATH_EDEFAULT.equals(fullpath);
			case WorkspacePackage.PROJECT__PARENT:
				return getParent() != null;
			case WorkspacePackage.PROJECT__MEMBERS:
				return members != null && !members.isEmpty();
			case WorkspacePackage.PROJECT__NATURE_ID:
				return natureId != null && !natureId.isEmpty();
			case WorkspacePackage.PROJECT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", fullpath: ");
		result.append(fullpath);
		result.append(", natureId: ");
		result.append(natureId);
		result.append(')');
		return result.toString();
	}

} // ProjectImpl
