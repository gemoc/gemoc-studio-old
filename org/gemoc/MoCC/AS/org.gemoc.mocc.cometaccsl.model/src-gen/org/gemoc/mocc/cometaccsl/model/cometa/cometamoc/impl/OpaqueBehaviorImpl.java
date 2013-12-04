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
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getMocDomain <em>Moc Domain</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getQueueInstances <em>Queue Instances</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getRtInterfaces <em>Rt Interfaces</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getBehaviorTimeConstraints <em>Behavior Time Constraints</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpaqueBehaviorImpl extends MinimalEObjectImpl.Container implements OpaqueBehavior {
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
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCRole> roles;

	/**
	 * The cached value of the '{@link #getQueueInstances() <em>Queue Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueueInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<QueueInstance> queueInstances;

	/**
	 * The cached value of the '{@link #getRtInterfaces() <em>Rt Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<RTInterface> rtInterfaces;

	/**
	 * The cached value of the '{@link #getBehaviorTimeConstraints() <em>Behavior Time Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorTimeConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConstraint> behaviorTimeConstraints;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OpaqueBlock body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometamocPackage.Literals.OPAQUE_BEHAVIOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.OPAQUE_BEHAVIOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.OPAQUE_BEHAVIOR__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.OPAQUE_BEHAVIOR__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCRole> getRoles() {
		if (roles == null) {
			roles = new EDataTypeUniqueEList<MoCRole>(MoCRole.class, this, CometamocPackage.OPAQUE_BEHAVIOR__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCDomain getMocDomain() {
		if (eContainerFeatureID() != CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN) return null;
		return (MoCDomain)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMocDomain(MoCDomain newMocDomain, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMocDomain, CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMocDomain(MoCDomain newMocDomain) {
		if (newMocDomain != eInternalContainer() || (eContainerFeatureID() != CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN && newMocDomain != null)) {
			if (EcoreUtil.isAncestor(this, newMocDomain))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMocDomain != null)
				msgs = ((InternalEObject)newMocDomain).eInverseAdd(this, CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS, MoCDomain.class, msgs);
			msgs = basicSetMocDomain(newMocDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN, newMocDomain, newMocDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QueueInstance> getQueueInstances() {
		if (queueInstances == null) {
			queueInstances = new EObjectContainmentEList<QueueInstance>(QueueInstance.class, this, CometamocPackage.OPAQUE_BEHAVIOR__QUEUE_INSTANCES);
		}
		return queueInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RTInterface> getRtInterfaces() {
		if (rtInterfaces == null) {
			rtInterfaces = new EObjectContainmentEList<RTInterface>(RTInterface.class, this, CometamocPackage.OPAQUE_BEHAVIOR__RT_INTERFACES);
		}
		return rtInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConstraint> getBehaviorTimeConstraints() {
		if (behaviorTimeConstraints == null) {
			behaviorTimeConstraints = new EObjectContainmentEList<TimeConstraint>(TimeConstraint.class, this, CometamocPackage.OPAQUE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS);
		}
		return behaviorTimeConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBlock getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(OpaqueBlock newBody, NotificationChain msgs) {
		OpaqueBlock oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CometamocPackage.OPAQUE_BEHAVIOR__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OpaqueBlock newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CometamocPackage.OPAQUE_BEHAVIOR__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CometamocPackage.OPAQUE_BEHAVIOR__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.OPAQUE_BEHAVIOR__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMocDomain((MoCDomain)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN:
				return basicSetMocDomain(null, msgs);
			case CometamocPackage.OPAQUE_BEHAVIOR__QUEUE_INSTANCES:
				return ((InternalEList<?>)getQueueInstances()).basicRemove(otherEnd, msgs);
			case CometamocPackage.OPAQUE_BEHAVIOR__RT_INTERFACES:
				return ((InternalEList<?>)getRtInterfaces()).basicRemove(otherEnd, msgs);
			case CometamocPackage.OPAQUE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				return ((InternalEList<?>)getBehaviorTimeConstraints()).basicRemove(otherEnd, msgs);
			case CometamocPackage.OPAQUE_BEHAVIOR__BODY:
				return basicSetBody(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN:
				return eInternalContainer().eInverseRemove(this, CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS, MoCDomain.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CometamocPackage.OPAQUE_BEHAVIOR__NAME:
				return getName();
			case CometamocPackage.OPAQUE_BEHAVIOR__VERSION:
				return getVersion();
			case CometamocPackage.OPAQUE_BEHAVIOR__DEFINITION:
				return getDefinition();
			case CometamocPackage.OPAQUE_BEHAVIOR__ROLES:
				return getRoles();
			case CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN:
				return getMocDomain();
			case CometamocPackage.OPAQUE_BEHAVIOR__QUEUE_INSTANCES:
				return getQueueInstances();
			case CometamocPackage.OPAQUE_BEHAVIOR__RT_INTERFACES:
				return getRtInterfaces();
			case CometamocPackage.OPAQUE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				return getBehaviorTimeConstraints();
			case CometamocPackage.OPAQUE_BEHAVIOR__BODY:
				return getBody();
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
			case CometamocPackage.OPAQUE_BEHAVIOR__NAME:
				setName((String)newValue);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__VERSION:
				setVersion((String)newValue);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends MoCRole>)newValue);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN:
				setMocDomain((MoCDomain)newValue);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__QUEUE_INSTANCES:
				getQueueInstances().clear();
				getQueueInstances().addAll((Collection<? extends QueueInstance>)newValue);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__RT_INTERFACES:
				getRtInterfaces().clear();
				getRtInterfaces().addAll((Collection<? extends RTInterface>)newValue);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				getBehaviorTimeConstraints().clear();
				getBehaviorTimeConstraints().addAll((Collection<? extends TimeConstraint>)newValue);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__BODY:
				setBody((OpaqueBlock)newValue);
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
			case CometamocPackage.OPAQUE_BEHAVIOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__ROLES:
				getRoles().clear();
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN:
				setMocDomain((MoCDomain)null);
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__QUEUE_INSTANCES:
				getQueueInstances().clear();
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__RT_INTERFACES:
				getRtInterfaces().clear();
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				getBehaviorTimeConstraints().clear();
				return;
			case CometamocPackage.OPAQUE_BEHAVIOR__BODY:
				setBody((OpaqueBlock)null);
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
			case CometamocPackage.OPAQUE_BEHAVIOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometamocPackage.OPAQUE_BEHAVIOR__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometamocPackage.OPAQUE_BEHAVIOR__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometamocPackage.OPAQUE_BEHAVIOR__ROLES:
				return roles != null && !roles.isEmpty();
			case CometamocPackage.OPAQUE_BEHAVIOR__MOC_DOMAIN:
				return getMocDomain() != null;
			case CometamocPackage.OPAQUE_BEHAVIOR__QUEUE_INSTANCES:
				return queueInstances != null && !queueInstances.isEmpty();
			case CometamocPackage.OPAQUE_BEHAVIOR__RT_INTERFACES:
				return rtInterfaces != null && !rtInterfaces.isEmpty();
			case CometamocPackage.OPAQUE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				return behaviorTimeConstraints != null && !behaviorTimeConstraints.isEmpty();
			case CometamocPackage.OPAQUE_BEHAVIOR__BODY:
				return body != null;
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
		result.append(", roles: ");
		result.append(roles);
		result.append(')');
		return result.toString();
	}

} //OpaqueBehaviorImpl
