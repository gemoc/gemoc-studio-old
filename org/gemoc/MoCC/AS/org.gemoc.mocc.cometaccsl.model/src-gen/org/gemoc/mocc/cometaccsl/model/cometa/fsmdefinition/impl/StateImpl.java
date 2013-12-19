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
package org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl#getInputTransitions <em>Input Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl#getOutputTransitions <em>Output Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends MinimalEObjectImpl.Container implements State {
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
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * The cached value of the '{@link #getInputTransitions() <em>Input Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> inputTransitions;

	/**
	 * The cached value of the '{@link #getOutputTransitions() <em>Output Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outputTransitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmdefinitionPackage.Literals.STATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FsmdefinitionPackage.STATE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FsmdefinitionPackage.STATE__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FsmdefinitionPackage.STATE__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<Action>(Action.class, this, FsmdefinitionPackage.STATE__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getInputTransitions() {
		if (inputTransitions == null) {
			inputTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FsmdefinitionPackage.STATE__INPUT_TRANSITIONS, FsmdefinitionPackage.TRANSITION__SOURCE);
		}
		return inputTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutputTransitions() {
		if (outputTransitions == null) {
			outputTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FsmdefinitionPackage.STATE__OUTPUT_TRANSITIONS, FsmdefinitionPackage.TRANSITION__TARGET);
		}
		return outputTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmdefinitionPackage.STATE__INPUT_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputTransitions()).basicAdd(otherEnd, msgs);
			case FsmdefinitionPackage.STATE__OUTPUT_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputTransitions()).basicAdd(otherEnd, msgs);
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
			case FsmdefinitionPackage.STATE__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
			case FsmdefinitionPackage.STATE__INPUT_TRANSITIONS:
				return ((InternalEList<?>)getInputTransitions()).basicRemove(otherEnd, msgs);
			case FsmdefinitionPackage.STATE__OUTPUT_TRANSITIONS:
				return ((InternalEList<?>)getOutputTransitions()).basicRemove(otherEnd, msgs);
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
			case FsmdefinitionPackage.STATE__NAME:
				return getName();
			case FsmdefinitionPackage.STATE__VERSION:
				return getVersion();
			case FsmdefinitionPackage.STATE__DEFINITION:
				return getDefinition();
			case FsmdefinitionPackage.STATE__ACTIONS:
				return getActions();
			case FsmdefinitionPackage.STATE__INPUT_TRANSITIONS:
				return getInputTransitions();
			case FsmdefinitionPackage.STATE__OUTPUT_TRANSITIONS:
				return getOutputTransitions();
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
			case FsmdefinitionPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case FsmdefinitionPackage.STATE__VERSION:
				setVersion((String)newValue);
				return;
			case FsmdefinitionPackage.STATE__DEFINITION:
				setDefinition((String)newValue);
				return;
			case FsmdefinitionPackage.STATE__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
				return;
			case FsmdefinitionPackage.STATE__INPUT_TRANSITIONS:
				getInputTransitions().clear();
				getInputTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case FsmdefinitionPackage.STATE__OUTPUT_TRANSITIONS:
				getOutputTransitions().clear();
				getOutputTransitions().addAll((Collection<? extends Transition>)newValue);
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
			case FsmdefinitionPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FsmdefinitionPackage.STATE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case FsmdefinitionPackage.STATE__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case FsmdefinitionPackage.STATE__ACTIONS:
				getActions().clear();
				return;
			case FsmdefinitionPackage.STATE__INPUT_TRANSITIONS:
				getInputTransitions().clear();
				return;
			case FsmdefinitionPackage.STATE__OUTPUT_TRANSITIONS:
				getOutputTransitions().clear();
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
			case FsmdefinitionPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FsmdefinitionPackage.STATE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case FsmdefinitionPackage.STATE__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case FsmdefinitionPackage.STATE__ACTIONS:
				return actions != null && !actions.isEmpty();
			case FsmdefinitionPackage.STATE__INPUT_TRANSITIONS:
				return inputTransitions != null && !inputTransitions.isEmpty();
			case FsmdefinitionPackage.STATE__OUTPUT_TRANSITIONS:
				return outputTransitions != null && !outputTransitions.isEmpty();
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

} //StateImpl
