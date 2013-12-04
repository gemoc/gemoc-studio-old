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
package org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl;

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

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl#getClocks <em>Clocks</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl#getGlobalTimeConstraints <em>Global Time Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeLibraryImpl extends MinimalEObjectImpl.Container implements TimeLibrary {
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
	 * The cached value of the '{@link #getClocks() <em>Clocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClocks()
	 * @generated
	 * @ordered
	 */
	protected EList<ClockAbstraction> clocks;

	/**
	 * The cached value of the '{@link #getGlobalTimeConstraints() <em>Global Time Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalTimeConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConstraint> globalTimeConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometatimePackage.Literals.TIME_LIBRARY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometatimePackage.TIME_LIBRARY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometatimePackage.TIME_LIBRARY__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometatimePackage.TIME_LIBRARY__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClockAbstraction> getClocks() {
		if (clocks == null) {
			clocks = new EObjectContainmentEList<ClockAbstraction>(ClockAbstraction.class, this, CometatimePackage.TIME_LIBRARY__CLOCKS);
		}
		return clocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConstraint> getGlobalTimeConstraints() {
		if (globalTimeConstraints == null) {
			globalTimeConstraints = new EObjectContainmentEList<TimeConstraint>(TimeConstraint.class, this, CometatimePackage.TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS);
		}
		return globalTimeConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometatimePackage.TIME_LIBRARY__CLOCKS:
				return ((InternalEList<?>)getClocks()).basicRemove(otherEnd, msgs);
			case CometatimePackage.TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS:
				return ((InternalEList<?>)getGlobalTimeConstraints()).basicRemove(otherEnd, msgs);
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
			case CometatimePackage.TIME_LIBRARY__NAME:
				return getName();
			case CometatimePackage.TIME_LIBRARY__VERSION:
				return getVersion();
			case CometatimePackage.TIME_LIBRARY__DEFINITION:
				return getDefinition();
			case CometatimePackage.TIME_LIBRARY__CLOCKS:
				return getClocks();
			case CometatimePackage.TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS:
				return getGlobalTimeConstraints();
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
			case CometatimePackage.TIME_LIBRARY__NAME:
				setName((String)newValue);
				return;
			case CometatimePackage.TIME_LIBRARY__VERSION:
				setVersion((String)newValue);
				return;
			case CometatimePackage.TIME_LIBRARY__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometatimePackage.TIME_LIBRARY__CLOCKS:
				getClocks().clear();
				getClocks().addAll((Collection<? extends ClockAbstraction>)newValue);
				return;
			case CometatimePackage.TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS:
				getGlobalTimeConstraints().clear();
				getGlobalTimeConstraints().addAll((Collection<? extends TimeConstraint>)newValue);
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
			case CometatimePackage.TIME_LIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometatimePackage.TIME_LIBRARY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometatimePackage.TIME_LIBRARY__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometatimePackage.TIME_LIBRARY__CLOCKS:
				getClocks().clear();
				return;
			case CometatimePackage.TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS:
				getGlobalTimeConstraints().clear();
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
			case CometatimePackage.TIME_LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometatimePackage.TIME_LIBRARY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometatimePackage.TIME_LIBRARY__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometatimePackage.TIME_LIBRARY__CLOCKS:
				return clocks != null && !clocks.isEmpty();
			case CometatimePackage.TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS:
				return globalTimeConstraints != null && !globalTimeConstraints.isEmpty();
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

} //TimeLibraryImpl
