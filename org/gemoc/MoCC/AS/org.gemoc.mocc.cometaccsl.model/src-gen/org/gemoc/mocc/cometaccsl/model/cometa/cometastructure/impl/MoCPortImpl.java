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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mo CPort</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getBehaviorMap <em>Behavior Map</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getMocDomain <em>Moc Domain</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl#getPortInterfaces <em>Port Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MoCPortImpl extends MinimalEObjectImpl.Container implements MoCPort {
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
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final PortKind DIRECTION_EDEFAULT = PortKind.IN;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected PortKind direction = DIRECTION_EDEFAULT;

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
	 * The cached value of the '{@link #getPortInterfaces() <em>Port Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCInterface> portInterfaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoCPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometastructurePackage.Literals.MO_CPORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CPORT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CPORT__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CPORT__DEFINITION, oldDefinition, definition));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CometastructurePackage.MO_CPORT__BEHAVIOR_MAP, oldBehaviorMap, behaviorMap));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CPORT__BEHAVIOR_MAP, oldBehaviorMap, behaviorMap));
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
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, CometastructurePackage.MO_CPORT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortKind getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(PortKind newDirection) {
		PortKind oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CPORT__DIRECTION, oldDirection, direction));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CometastructurePackage.MO_CPORT__TARGET, oldTarget, target));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.MO_CPORT__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCInterface> getPortInterfaces() {
		if (portInterfaces == null) {
			portInterfaces = new EObjectResolvingEList<MoCInterface>(MoCInterface.class, this, CometastructurePackage.MO_CPORT__PORT_INTERFACES);
		}
		return portInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometastructurePackage.MO_CPORT__PARAMETERS:
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
			case CometastructurePackage.MO_CPORT__NAME:
				return getName();
			case CometastructurePackage.MO_CPORT__VERSION:
				return getVersion();
			case CometastructurePackage.MO_CPORT__DEFINITION:
				return getDefinition();
			case CometastructurePackage.MO_CPORT__BEHAVIOR_MAP:
				if (resolve) return getBehaviorMap();
				return basicGetBehaviorMap();
			case CometastructurePackage.MO_CPORT__MOC_DOMAIN:
				if (resolve) return getMocDomain();
				return basicGetMocDomain();
			case CometastructurePackage.MO_CPORT__PARAMETERS:
				return getParameters();
			case CometastructurePackage.MO_CPORT__DIRECTION:
				return getDirection();
			case CometastructurePackage.MO_CPORT__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case CometastructurePackage.MO_CPORT__PORT_INTERFACES:
				return getPortInterfaces();
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
			case CometastructurePackage.MO_CPORT__NAME:
				setName((String)newValue);
				return;
			case CometastructurePackage.MO_CPORT__VERSION:
				setVersion((String)newValue);
				return;
			case CometastructurePackage.MO_CPORT__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometastructurePackage.MO_CPORT__BEHAVIOR_MAP:
				setBehaviorMap((Behavior)newValue);
				return;
			case CometastructurePackage.MO_CPORT__MOC_DOMAIN:
				setMocDomain((MoCDomain)newValue);
				return;
			case CometastructurePackage.MO_CPORT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case CometastructurePackage.MO_CPORT__DIRECTION:
				setDirection((PortKind)newValue);
				return;
			case CometastructurePackage.MO_CPORT__TARGET:
				setTarget((MoCPort)newValue);
				return;
			case CometastructurePackage.MO_CPORT__PORT_INTERFACES:
				getPortInterfaces().clear();
				getPortInterfaces().addAll((Collection<? extends MoCInterface>)newValue);
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
			case CometastructurePackage.MO_CPORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometastructurePackage.MO_CPORT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometastructurePackage.MO_CPORT__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometastructurePackage.MO_CPORT__BEHAVIOR_MAP:
				setBehaviorMap((Behavior)null);
				return;
			case CometastructurePackage.MO_CPORT__MOC_DOMAIN:
				setMocDomain((MoCDomain)null);
				return;
			case CometastructurePackage.MO_CPORT__PARAMETERS:
				getParameters().clear();
				return;
			case CometastructurePackage.MO_CPORT__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case CometastructurePackage.MO_CPORT__TARGET:
				setTarget((MoCPort)null);
				return;
			case CometastructurePackage.MO_CPORT__PORT_INTERFACES:
				getPortInterfaces().clear();
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
			case CometastructurePackage.MO_CPORT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometastructurePackage.MO_CPORT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometastructurePackage.MO_CPORT__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometastructurePackage.MO_CPORT__BEHAVIOR_MAP:
				return behaviorMap != null;
			case CometastructurePackage.MO_CPORT__MOC_DOMAIN:
				return MOC_DOMAIN__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case CometastructurePackage.MO_CPORT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case CometastructurePackage.MO_CPORT__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case CometastructurePackage.MO_CPORT__TARGET:
				return target != null;
			case CometastructurePackage.MO_CPORT__PORT_INTERFACES:
				return portInterfaces != null && !portInterfaces.isEmpty();
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
		result.append(", direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //MoCPortImpl
