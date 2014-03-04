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
import fr.obeo.dsl.workspace.Resource;
import fr.obeo.dsl.workspace.WorkspacePackage;
import fr.obeo.dsl.workspace.WorkspaceRoot;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Root</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.impl.WorkspaceRootImpl#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.WorkspaceRootImpl#getFullpath <em>Fullpath</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.WorkspaceRootImpl#getParent <em>Parent</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.WorkspaceRootImpl#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WorkspaceRootImpl extends EObjectImpl implements WorkspaceRoot {
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected WorkspaceRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WORKSPACE_ROOT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WORKSPACE_ROOT__NAME,
					oldName, name));
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
		if (eContainerFeatureID() != WorkspacePackage.WORKSPACE_ROOT__PARENT)
			return null;
		return (Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(Container newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, WorkspacePackage.WORKSPACE_ROOT__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(Container newParent) {
		if (newParent != eInternalContainer()
				|| (eContainerFeatureID() != WorkspacePackage.WORKSPACE_ROOT__PARENT && newParent != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.WORKSPACE_ROOT__PARENT,
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
					WorkspacePackage.WORKSPACE_ROOT__MEMBERS, WorkspacePackage.RESOURCE__PARENT);
		}
		return members;
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
			case WorkspacePackage.WORKSPACE_ROOT__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Container)otherEnd, msgs);
			case WorkspacePackage.WORKSPACE_ROOT__MEMBERS:
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
			case WorkspacePackage.WORKSPACE_ROOT__PARENT:
				return basicSetParent(null, msgs);
			case WorkspacePackage.WORKSPACE_ROOT__MEMBERS:
				return ((InternalEList<?>)getMembers()).basicRemove(otherEnd, msgs);
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
			case WorkspacePackage.WORKSPACE_ROOT__PARENT:
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
			case WorkspacePackage.WORKSPACE_ROOT__NAME:
				return getName();
			case WorkspacePackage.WORKSPACE_ROOT__FULLPATH:
				return getFullpath();
			case WorkspacePackage.WORKSPACE_ROOT__PARENT:
				return getParent();
			case WorkspacePackage.WORKSPACE_ROOT__MEMBERS:
				return getMembers();
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
			case WorkspacePackage.WORKSPACE_ROOT__NAME:
				setName((String)newValue);
				return;
			case WorkspacePackage.WORKSPACE_ROOT__PARENT:
				setParent((Container)newValue);
				return;
			case WorkspacePackage.WORKSPACE_ROOT__MEMBERS:
				getMembers().clear();
				getMembers().addAll((Collection<? extends Resource>)newValue);
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
			case WorkspacePackage.WORKSPACE_ROOT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkspacePackage.WORKSPACE_ROOT__PARENT:
				setParent((Container)null);
				return;
			case WorkspacePackage.WORKSPACE_ROOT__MEMBERS:
				getMembers().clear();
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
			case WorkspacePackage.WORKSPACE_ROOT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkspacePackage.WORKSPACE_ROOT__FULLPATH:
				return FULLPATH_EDEFAULT == null ? fullpath != null : !FULLPATH_EDEFAULT.equals(fullpath);
			case WorkspacePackage.WORKSPACE_ROOT__PARENT:
				return getParent() != null;
			case WorkspacePackage.WORKSPACE_ROOT__MEMBERS:
				return members != null && !members.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} // WorkspaceRootImpl
