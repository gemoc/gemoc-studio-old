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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl#getBehaviorMap <em>Behavior Map</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl#getMocDomain <em>Moc Domain</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl#getOwnedPortInstances <em>Owned Port Instances</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl#getComputation <em>Computation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicComponentImpl extends MinimalEObjectImpl.Container implements BasicComponent {
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
	 * The cached value of the '{@link #getBehaviorMap() <em>Behavior Map</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorMap()
	 * @generated
	 * @ordered
	 */
	protected Behavior behaviorMap;

	/**
	 * The cached setting delegate for the '{@link #getMocDomain() <em>Moc Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMocDomain()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate MOC_DOMAIN__ESETTING_DELEGATE = ((EStructuralFeature.Internal)CometastructurePackage.Literals.STRUCTURE_ELEMENT__MOC_DOMAIN).getSettingDelegate();

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getOwnedPortInstances() <em>Owned Port Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPortInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCPort> ownedPortInstances;

	/**
	 * The cached value of the '{@link #getComputation() <em>Computation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputation()
	 * @generated
	 * @ordered
	 */
	protected OpaqueBlock computation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometastructurePackage.Literals.BASIC_COMPONENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.BASIC_COMPONENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.BASIC_COMPONENT__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.BASIC_COMPONENT__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getBehaviorMap() {
		if (behaviorMap != null && behaviorMap.eIsProxy()) {
			InternalEObject oldBehaviorMap = (InternalEObject)behaviorMap;
			behaviorMap = (Behavior)eResolveProxy(oldBehaviorMap);
			if (behaviorMap != oldBehaviorMap) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CometastructurePackage.BASIC_COMPONENT__BEHAVIOR_MAP, oldBehaviorMap, behaviorMap));
			}
		}
		return behaviorMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior basicGetBehaviorMap() {
		return behaviorMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorMap(Behavior newBehaviorMap) {
		Behavior oldBehaviorMap = behaviorMap;
		behaviorMap = newBehaviorMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.BASIC_COMPONENT__BEHAVIOR_MAP, oldBehaviorMap, behaviorMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCDomain getMocDomain() {
		return (MoCDomain)MOC_DOMAIN__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCDomain basicGetMocDomain() {
		return (MoCDomain)MOC_DOMAIN__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMocDomain(MoCDomain newMocDomain) {
		MOC_DOMAIN__ESETTING_DELEGATE.dynamicSet(this, null, 0, newMocDomain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, CometastructurePackage.BASIC_COMPONENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCPort> getOwnedPortInstances() {
		if (ownedPortInstances == null) {
			ownedPortInstances = new EObjectContainmentEList<MoCPort>(MoCPort.class, this, CometastructurePackage.BASIC_COMPONENT__OWNED_PORT_INSTANCES);
		}
		return ownedPortInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBlock getComputation() {
		return computation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComputation(OpaqueBlock newComputation, NotificationChain msgs) {
		OpaqueBlock oldComputation = computation;
		computation = newComputation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CometastructurePackage.BASIC_COMPONENT__COMPUTATION, oldComputation, newComputation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComputation(OpaqueBlock newComputation) {
		if (newComputation != computation) {
			NotificationChain msgs = null;
			if (computation != null)
				msgs = ((InternalEObject)computation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CometastructurePackage.BASIC_COMPONENT__COMPUTATION, null, msgs);
			if (newComputation != null)
				msgs = ((InternalEObject)newComputation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CometastructurePackage.BASIC_COMPONENT__COMPUTATION, null, msgs);
			msgs = basicSetComputation(newComputation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.BASIC_COMPONENT__COMPUTATION, newComputation, newComputation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometastructurePackage.BASIC_COMPONENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case CometastructurePackage.BASIC_COMPONENT__OWNED_PORT_INSTANCES:
				return ((InternalEList<?>)getOwnedPortInstances()).basicRemove(otherEnd, msgs);
			case CometastructurePackage.BASIC_COMPONENT__COMPUTATION:
				return basicSetComputation(null, msgs);
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
			case CometastructurePackage.BASIC_COMPONENT__NAME:
				return getName();
			case CometastructurePackage.BASIC_COMPONENT__VERSION:
				return getVersion();
			case CometastructurePackage.BASIC_COMPONENT__DEFINITION:
				return getDefinition();
			case CometastructurePackage.BASIC_COMPONENT__BEHAVIOR_MAP:
				if (resolve) return getBehaviorMap();
				return basicGetBehaviorMap();
			case CometastructurePackage.BASIC_COMPONENT__MOC_DOMAIN:
				if (resolve) return getMocDomain();
				return basicGetMocDomain();
			case CometastructurePackage.BASIC_COMPONENT__PARAMETERS:
				return getParameters();
			case CometastructurePackage.BASIC_COMPONENT__OWNED_PORT_INSTANCES:
				return getOwnedPortInstances();
			case CometastructurePackage.BASIC_COMPONENT__COMPUTATION:
				return getComputation();
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
			case CometastructurePackage.BASIC_COMPONENT__NAME:
				setName((String)newValue);
				return;
			case CometastructurePackage.BASIC_COMPONENT__VERSION:
				setVersion((String)newValue);
				return;
			case CometastructurePackage.BASIC_COMPONENT__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometastructurePackage.BASIC_COMPONENT__BEHAVIOR_MAP:
				setBehaviorMap((Behavior)newValue);
				return;
			case CometastructurePackage.BASIC_COMPONENT__MOC_DOMAIN:
				setMocDomain((MoCDomain)newValue);
				return;
			case CometastructurePackage.BASIC_COMPONENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case CometastructurePackage.BASIC_COMPONENT__OWNED_PORT_INSTANCES:
				getOwnedPortInstances().clear();
				getOwnedPortInstances().addAll((Collection<? extends MoCPort>)newValue);
				return;
			case CometastructurePackage.BASIC_COMPONENT__COMPUTATION:
				setComputation((OpaqueBlock)newValue);
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
			case CometastructurePackage.BASIC_COMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometastructurePackage.BASIC_COMPONENT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometastructurePackage.BASIC_COMPONENT__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometastructurePackage.BASIC_COMPONENT__BEHAVIOR_MAP:
				setBehaviorMap((Behavior)null);
				return;
			case CometastructurePackage.BASIC_COMPONENT__MOC_DOMAIN:
				setMocDomain((MoCDomain)null);
				return;
			case CometastructurePackage.BASIC_COMPONENT__PARAMETERS:
				getParameters().clear();
				return;
			case CometastructurePackage.BASIC_COMPONENT__OWNED_PORT_INSTANCES:
				getOwnedPortInstances().clear();
				return;
			case CometastructurePackage.BASIC_COMPONENT__COMPUTATION:
				setComputation((OpaqueBlock)null);
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
			case CometastructurePackage.BASIC_COMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometastructurePackage.BASIC_COMPONENT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometastructurePackage.BASIC_COMPONENT__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometastructurePackage.BASIC_COMPONENT__BEHAVIOR_MAP:
				return behaviorMap != null;
			case CometastructurePackage.BASIC_COMPONENT__MOC_DOMAIN:
				return MOC_DOMAIN__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case CometastructurePackage.BASIC_COMPONENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CometastructurePackage.BASIC_COMPONENT__OWNED_PORT_INSTANCES:
				return ownedPortInstances != null && !ownedPortInstances.isEmpty();
			case CometastructurePackage.BASIC_COMPONENT__COMPUTATION:
				return computation != null;
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

} //BasicComponentImpl
