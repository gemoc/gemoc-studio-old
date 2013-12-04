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

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mo CConnector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getBehaviorMap <em>Behavior Map</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getMocDomain <em>Moc Domain</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MoCConnectorImpl extends MinimalEObjectImpl.Container implements MoCConnector {
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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected MoCPort source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected MoCPort target;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final MoCConnectorKind KIND_EDEFAULT = MoCConnectorKind.DELEGATION;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected MoCConnectorKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoCConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometastructurePackage.Literals.MO_CCONNECTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CCONNECTOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CCONNECTOR__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CCONNECTOR__DEFINITION, oldDefinition, definition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CometastructurePackage.MO_CCONNECTOR__BEHAVIOR_MAP, oldBehaviorMap, behaviorMap));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CCONNECTOR__BEHAVIOR_MAP, oldBehaviorMap, behaviorMap));
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
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, CometastructurePackage.MO_CCONNECTOR__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCPort getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (MoCPort)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CometastructurePackage.MO_CCONNECTOR__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCPort basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(MoCPort newSource) {
		MoCPort oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CCONNECTOR__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCPort getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (MoCPort)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CometastructurePackage.MO_CCONNECTOR__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCPort basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(MoCPort newTarget) {
		MoCPort oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CCONNECTOR__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCConnectorKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(MoCConnectorKind newKind) {
		MoCConnectorKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CCONNECTOR__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometastructurePackage.MO_CCONNECTOR__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case CometastructurePackage.MO_CCONNECTOR__NAME:
				return getName();
			case CometastructurePackage.MO_CCONNECTOR__VERSION:
				return getVersion();
			case CometastructurePackage.MO_CCONNECTOR__DEFINITION:
				return getDefinition();
			case CometastructurePackage.MO_CCONNECTOR__BEHAVIOR_MAP:
				if (resolve) return getBehaviorMap();
				return basicGetBehaviorMap();
			case CometastructurePackage.MO_CCONNECTOR__MOC_DOMAIN:
				if (resolve) return getMocDomain();
				return basicGetMocDomain();
			case CometastructurePackage.MO_CCONNECTOR__PARAMETERS:
				return getParameters();
			case CometastructurePackage.MO_CCONNECTOR__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case CometastructurePackage.MO_CCONNECTOR__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case CometastructurePackage.MO_CCONNECTOR__KIND:
				return getKind();
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
			case CometastructurePackage.MO_CCONNECTOR__NAME:
				setName((String)newValue);
				return;
			case CometastructurePackage.MO_CCONNECTOR__VERSION:
				setVersion((String)newValue);
				return;
			case CometastructurePackage.MO_CCONNECTOR__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometastructurePackage.MO_CCONNECTOR__BEHAVIOR_MAP:
				setBehaviorMap((Behavior)newValue);
				return;
			case CometastructurePackage.MO_CCONNECTOR__MOC_DOMAIN:
				setMocDomain((MoCDomain)newValue);
				return;
			case CometastructurePackage.MO_CCONNECTOR__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case CometastructurePackage.MO_CCONNECTOR__SOURCE:
				setSource((MoCPort)newValue);
				return;
			case CometastructurePackage.MO_CCONNECTOR__TARGET:
				setTarget((MoCPort)newValue);
				return;
			case CometastructurePackage.MO_CCONNECTOR__KIND:
				setKind((MoCConnectorKind)newValue);
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
			case CometastructurePackage.MO_CCONNECTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometastructurePackage.MO_CCONNECTOR__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometastructurePackage.MO_CCONNECTOR__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometastructurePackage.MO_CCONNECTOR__BEHAVIOR_MAP:
				setBehaviorMap((Behavior)null);
				return;
			case CometastructurePackage.MO_CCONNECTOR__MOC_DOMAIN:
				setMocDomain((MoCDomain)null);
				return;
			case CometastructurePackage.MO_CCONNECTOR__PARAMETERS:
				getParameters().clear();
				return;
			case CometastructurePackage.MO_CCONNECTOR__SOURCE:
				setSource((MoCPort)null);
				return;
			case CometastructurePackage.MO_CCONNECTOR__TARGET:
				setTarget((MoCPort)null);
				return;
			case CometastructurePackage.MO_CCONNECTOR__KIND:
				setKind(KIND_EDEFAULT);
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
			case CometastructurePackage.MO_CCONNECTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometastructurePackage.MO_CCONNECTOR__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometastructurePackage.MO_CCONNECTOR__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometastructurePackage.MO_CCONNECTOR__BEHAVIOR_MAP:
				return behaviorMap != null;
			case CometastructurePackage.MO_CCONNECTOR__MOC_DOMAIN:
				return MOC_DOMAIN__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case CometastructurePackage.MO_CCONNECTOR__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CometastructurePackage.MO_CCONNECTOR__SOURCE:
				return source != null;
			case CometastructurePackage.MO_CCONNECTOR__TARGET:
				return target != null;
			case CometastructurePackage.MO_CCONNECTOR__KIND:
				return kind != KIND_EDEFAULT;
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
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //MoCConnectorImpl
