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
import fr.obeo.dsl.workspace.File;
import fr.obeo.dsl.workspace.WorkspacePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>File</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.impl.FileImpl#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.FileImpl#getFullpath <em>Fullpath</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.FileImpl#getParent <em>Parent</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.FileImpl#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FileImpl extends EObjectImpl implements File {
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
	 * The default value of the '{@link #getExtension() <em>Extension</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected String extension = EXTENSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.FILE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.FILE__NAME, oldName, name));
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
		if (eContainerFeatureID() != WorkspacePackage.FILE__PARENT)
			return null;
		return (Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(Container newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, WorkspacePackage.FILE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParent(Container newParent) {
		if (newParent != eInternalContainer()
				|| (eContainerFeatureID() != WorkspacePackage.FILE__PARENT && newParent != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.FILE__PARENT, newParent,
					newParent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExtension(String newExtension) {
		String oldExtension = extension;
		extension = newExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.FILE__EXTENSION,
					oldExtension, extension));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.FILE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Container)otherEnd, msgs);
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
			case WorkspacePackage.FILE__PARENT:
				return basicSetParent(null, msgs);
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
			case WorkspacePackage.FILE__PARENT:
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
			case WorkspacePackage.FILE__NAME:
				return getName();
			case WorkspacePackage.FILE__FULLPATH:
				return getFullpath();
			case WorkspacePackage.FILE__PARENT:
				return getParent();
			case WorkspacePackage.FILE__EXTENSION:
				return getExtension();
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
			case WorkspacePackage.FILE__NAME:
				setName((String)newValue);
				return;
			case WorkspacePackage.FILE__PARENT:
				setParent((Container)newValue);
				return;
			case WorkspacePackage.FILE__EXTENSION:
				setExtension((String)newValue);
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
			case WorkspacePackage.FILE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorkspacePackage.FILE__PARENT:
				setParent((Container)null);
				return;
			case WorkspacePackage.FILE__EXTENSION:
				setExtension(EXTENSION_EDEFAULT);
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
			case WorkspacePackage.FILE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorkspacePackage.FILE__FULLPATH:
				return FULLPATH_EDEFAULT == null ? fullpath != null : !FULLPATH_EDEFAULT.equals(fullpath);
			case WorkspacePackage.FILE__PARENT:
				return getParent() != null;
			case WorkspacePackage.FILE__EXTENSION:
				return EXTENSION_EDEFAULT == null ? extension != null : !EXTENSION_EDEFAULT.equals(extension);
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
		result.append(", extension: ");
		result.append(extension);
		result.append(')');
		return result.toString();
	}

} // FileImpl
