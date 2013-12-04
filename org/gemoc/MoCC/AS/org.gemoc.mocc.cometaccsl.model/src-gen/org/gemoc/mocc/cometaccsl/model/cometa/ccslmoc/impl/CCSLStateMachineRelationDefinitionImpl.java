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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.impl.ExternalRelationDefinitionImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CCSL State Machine Relation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl#getFinalStates <em>Final States</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl#getConcreteEntities <em>Concrete Entities</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl#getClassicalExpressions <em>Classical Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CCSLStateMachineRelationDefinitionImpl extends ExternalRelationDefinitionImpl implements CCSLStateMachineRelationDefinition {
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
	 * The cached value of the '{@link #getConcreteEntities() <em>Concrete Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteEntity> concreteEntities;

	/**
	 * The cached value of the '{@link #getClassicalExpressions() <em>Classical Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassicalExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassicalExpression> classicalExpressions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CCSLStateMachineRelationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CcslmocPackage.Literals.CCSL_STATE_MACHINE_RELATION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getTransitions() {
		if (transitions == null) {
			transitions = new EObjectContainmentEList<Transition>(Transition.class, this, CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS);
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
			states = new EObjectContainmentEList<State>(State.class, this, CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE, oldInitialState, initialState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getFinalStates() {
		if (finalStates == null) {
			finalStates = new EObjectResolvingEList<State>(State.class, this, CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES);
		}
		return finalStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteEntity> getConcreteEntities() {
		if (concreteEntities == null) {
			concreteEntities = new EObjectContainmentEList<ConcreteEntity>(ConcreteEntity.class, this, CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES);
		}
		return concreteEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassicalExpression> getClassicalExpressions() {
		if (classicalExpressions == null) {
			classicalExpressions = new EObjectContainmentEList<ClassicalExpression>(ClassicalExpression.class, this, CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS);
		}
		return classicalExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS:
				return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				return ((InternalEList<?>)getConcreteEntities()).basicRemove(otherEnd, msgs);
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				return ((InternalEList<?>)getClassicalExpressions()).basicRemove(otherEnd, msgs);
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
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS:
				return getTransitions();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES:
				return getStates();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES:
				return getFinalStates();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				return getConcreteEntities();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				return getClassicalExpressions();
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
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS:
				getTransitions().clear();
				getTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES:
				getFinalStates().clear();
				getFinalStates().addAll((Collection<? extends State>)newValue);
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				getConcreteEntities().clear();
				getConcreteEntities().addAll((Collection<? extends ConcreteEntity>)newValue);
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				getClassicalExpressions().clear();
				getClassicalExpressions().addAll((Collection<? extends ClassicalExpression>)newValue);
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
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS:
				getTransitions().clear();
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES:
				getStates().clear();
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES:
				getFinalStates().clear();
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				getConcreteEntities().clear();
				return;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				getClassicalExpressions().clear();
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
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS:
				return transitions != null && !transitions.isEmpty();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES:
				return states != null && !states.isEmpty();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE:
				return initialState != null;
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES:
				return finalStates != null && !finalStates.isEmpty();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				return concreteEntities != null && !concreteEntities.isEmpty();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				return classicalExpressions != null && !classicalExpressions.isEmpty();
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
				case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS: return FsmdefinitionPackage.FINITE_STATE_MACHINE__TRANSITIONS;
				case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES: return FsmdefinitionPackage.FINITE_STATE_MACHINE__STATES;
				case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE: return FsmdefinitionPackage.FINITE_STATE_MACHINE__INITIAL_STATE;
				case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES: return FsmdefinitionPackage.FINITE_STATE_MACHINE__FINAL_STATES;
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
				case FsmdefinitionPackage.FINITE_STATE_MACHINE__TRANSITIONS: return CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS;
				case FsmdefinitionPackage.FINITE_STATE_MACHINE__STATES: return CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES;
				case FsmdefinitionPackage.FINITE_STATE_MACHINE__INITIAL_STATE: return CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE;
				case FsmdefinitionPackage.FINITE_STATE_MACHINE__FINAL_STATES: return CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CCSLStateMachineRelationDefinitionImpl
