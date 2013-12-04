/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl#getMocStructures <em>Moc Structures</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl#getMocInterfaces <em>Moc Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureLibraryImpl extends MinimalEObjectImpl.Container implements StructureLibrary {
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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected String definition = DEFINITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMocStructures() <em>Moc Structures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMocStructures()
	 * @generated
	 * @ordered
	 */
	protected EList<StructureContainer> mocStructures;

	/**
	 * The cached value of the '{@link #getMocInterfaces() <em>Moc Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMocInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCInterface> mocInterfaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometastructurePackage.Literals.STRUCTURE_LIBRARY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.STRUCTURE_LIBRARY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.STRUCTURE_LIBRARY__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(String newDefinition) {
		String oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.STRUCTURE_LIBRARY__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructureContainer> getMocStructures() {
		if (mocStructures == null) {
			mocStructures = new EObjectContainmentEList<StructureContainer>(StructureContainer.class, this, CometastructurePackage.STRUCTURE_LIBRARY__MOC_STRUCTURES);
		}
		return mocStructures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCInterface> getMocInterfaces() {
		if (mocInterfaces == null) {
			mocInterfaces = new EObjectContainmentEList<MoCInterface>(MoCInterface.class, this, CometastructurePackage.STRUCTURE_LIBRARY__MOC_INTERFACES);
		}
		return mocInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_STRUCTURES:
				return ((InternalEList<?>)getMocStructures()).basicRemove(otherEnd, msgs);
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_INTERFACES:
				return ((InternalEList<?>)getMocInterfaces()).basicRemove(otherEnd, msgs);
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
			case CometastructurePackage.STRUCTURE_LIBRARY__NAME:
				return getName();
			case CometastructurePackage.STRUCTURE_LIBRARY__VERSION:
				return getVersion();
			case CometastructurePackage.STRUCTURE_LIBRARY__DEFINITION:
				return getDefinition();
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_STRUCTURES:
				return getMocStructures();
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_INTERFACES:
				return getMocInterfaces();
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
			case CometastructurePackage.STRUCTURE_LIBRARY__NAME:
				setName((String)newValue);
				return;
			case CometastructurePackage.STRUCTURE_LIBRARY__VERSION:
				setVersion((String)newValue);
				return;
			case CometastructurePackage.STRUCTURE_LIBRARY__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_STRUCTURES:
				getMocStructures().clear();
				getMocStructures().addAll((Collection<? extends StructureContainer>)newValue);
				return;
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_INTERFACES:
				getMocInterfaces().clear();
				getMocInterfaces().addAll((Collection<? extends MoCInterface>)newValue);
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
			case CometastructurePackage.STRUCTURE_LIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometastructurePackage.STRUCTURE_LIBRARY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometastructurePackage.STRUCTURE_LIBRARY__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_STRUCTURES:
				getMocStructures().clear();
				return;
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_INTERFACES:
				getMocInterfaces().clear();
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
			case CometastructurePackage.STRUCTURE_LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometastructurePackage.STRUCTURE_LIBRARY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometastructurePackage.STRUCTURE_LIBRARY__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_STRUCTURES:
				return mocStructures != null && !mocStructures.isEmpty();
			case CometastructurePackage.STRUCTURE_LIBRARY__MOC_INTERFACES:
				return mocInterfaces != null && !mocInterfaces.isEmpty();
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
		result.append(", version: ");
		result.append(version);
		result.append(", definition: ");
		result.append(definition);
		result.append(')');
		return result.toString();
	}

} //StructureLibraryImpl
