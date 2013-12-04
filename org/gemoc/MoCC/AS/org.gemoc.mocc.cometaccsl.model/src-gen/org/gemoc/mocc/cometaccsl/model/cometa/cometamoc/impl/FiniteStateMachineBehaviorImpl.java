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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.FiniteStateMachineBehavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Finite State Machine Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getMocDomain <em>Moc Domain</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getQueueInstances <em>Queue Instances</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getRtInterfaces <em>Rt Interfaces</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getBehaviorTimeConstraints <em>Behavior Time Constraints</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl#getFinalStates <em>Final States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FiniteStateMachineBehaviorImpl extends MinimalEObjectImpl.Container implements FiniteStateMachineBehavior {
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
	 * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitions;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected State initialState;

	/**
	 * The cached value of the '{@link #getFinalStates() <em>Final States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> finalStates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FiniteStateMachineBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometamocPackage.Literals.FINITE_STATE_MACHINE_BEHAVIOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCRole> getRoles() {
		if (roles == null) {
			roles = new EDataTypeUniqueEList<MoCRole>(MoCRole.class, this, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCDomain getMocDomain() {
		if (eContainerFeatureID() != CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN) return null;
		return (MoCDomain)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMocDomain(MoCDomain newMocDomain, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMocDomain, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMocDomain(MoCDomain newMocDomain) {
		if (newMocDomain != eInternalContainer() || (eContainerFeatureID() != CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN && newMocDomain != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN, newMocDomain, newMocDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QueueInstance> getQueueInstances() {
		if (queueInstances == null) {
			queueInstances = new EObjectContainmentEList<QueueInstance>(QueueInstance.class, this, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__QUEUE_INSTANCES);
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
			rtInterfaces = new EObjectContainmentEList<RTInterface>(RTInterface.class, this, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__RT_INTERFACES);
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
			behaviorTimeConstraints = new EObjectContainmentEList<TimeConstraint>(TimeConstraint.class, this, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS);
		}
		return behaviorTimeConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<Transition>(Transition.class, this, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS);
		}
		return transitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject)initialState;
			initialState = (State)eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(State newInitialState) {
		State oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getFinalStates() {
		if (finalStates == null) {
			finalStates = new EObjectResolvingEList<State>(State.class, this, CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__FINAL_STATES);
		}
		return finalStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN:
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
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN:
				return basicSetMocDomain(null, msgs);
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__QUEUE_INSTANCES:
				return ((InternalEList<?>)getQueueInstances()).basicRemove(otherEnd, msgs);
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__RT_INTERFACES:
				return ((InternalEList<?>)getRtInterfaces()).basicRemove(otherEnd, msgs);
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				return ((InternalEList<?>)getBehaviorTimeConstraints()).basicRemove(otherEnd, msgs);
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN:
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
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__NAME:
				return getName();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__VERSION:
				return getVersion();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__DEFINITION:
				return getDefinition();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__ROLES:
				return getRoles();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN:
				return getMocDomain();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__QUEUE_INSTANCES:
				return getQueueInstances();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__RT_INTERFACES:
				return getRtInterfaces();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				return getBehaviorTimeConstraints();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS:
				return getTransitions();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__STATES:
				return getStates();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__FINAL_STATES:
				return getFinalStates();
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
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__NAME:
				setName((String)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__VERSION:
				setVersion((String)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends MoCRole>)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN:
				setMocDomain((MoCDomain)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__QUEUE_INSTANCES:
				getQueueInstances().clear();
				getQueueInstances().addAll((Collection<? extends QueueInstance>)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__RT_INTERFACES:
				getRtInterfaces().clear();
				getRtInterfaces().addAll((Collection<? extends RTInterface>)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				getBehaviorTimeConstraints().clear();
				getBehaviorTimeConstraints().addAll((Collection<? extends TimeConstraint>)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__FINAL_STATES:
				getFinalStates().clear();
				getFinalStates().addAll((Collection<? extends State>)newValue);
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
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__ROLES:
				getRoles().clear();
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN:
				setMocDomain((MoCDomain)null);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__QUEUE_INSTANCES:
				getQueueInstances().clear();
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__RT_INTERFACES:
				getRtInterfaces().clear();
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				getBehaviorTimeConstraints().clear();
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS:
				getTransitions().clear();
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__STATES:
				getStates().clear();
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__FINAL_STATES:
				getFinalStates().clear();
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
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__ROLES:
				return roles != null && !roles.isEmpty();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN:
				return getMocDomain() != null;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__QUEUE_INSTANCES:
				return queueInstances != null && !queueInstances.isEmpty();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__RT_INTERFACES:
				return rtInterfaces != null && !rtInterfaces.isEmpty();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS:
				return behaviorTimeConstraints != null && !behaviorTimeConstraints.isEmpty();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__STATES:
				return states != null && !states.isEmpty();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE:
				return initialState != null;
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__FINAL_STATES:
				return finalStates != null && !finalStates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FiniteStateMachine.class) {
			switch (derivedFeatureID) {
				case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS: return FsmdefinitionPackage.FINITE_STATE_MACHINE__TRANSITIONS;
				case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__STATES: return FsmdefinitionPackage.FINITE_STATE_MACHINE__STATES;
				case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE: return FsmdefinitionPackage.FINITE_STATE_MACHINE__INITIAL_STATE;
				case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__FINAL_STATES: return FsmdefinitionPackage.FINITE_STATE_MACHINE__FINAL_STATES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FiniteStateMachine.class) {
			switch (baseFeatureID) {
				case FsmdefinitionPackage.FINITE_STATE_MACHINE__TRANSITIONS: return CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS;
				case FsmdefinitionPackage.FINITE_STATE_MACHINE__STATES: return CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__STATES;
				case FsmdefinitionPackage.FINITE_STATE_MACHINE__INITIAL_STATE: return CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE;
				case FsmdefinitionPackage.FINITE_STATE_MACHINE__FINAL_STATES: return CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR__FINAL_STATES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //FiniteStateMachineBehaviorImpl
