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
package org.gemoc.mocc.fsmkernel.model.FSMModel.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.impl.NamedElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.State;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateImpl#getInputTransitions <em>Input Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateImpl#getOutputTransitions <em>Output Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends NamedElementImpl implements State {
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
		return FSMModelPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getInputTransitions() {
		if (inputTransitions == null) {
			inputTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FSMModelPackage.STATE__INPUT_TRANSITIONS, FSMModelPackage.TRANSITION__TARGET);
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
			outputTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, FSMModelPackage.STATE__OUTPUT_TRANSITIONS, FSMModelPackage.TRANSITION__SOURCE);
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
			case FSMModelPackage.STATE__INPUT_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputTransitions()).basicAdd(otherEnd, msgs);
			case FSMModelPackage.STATE__OUTPUT_TRANSITIONS:
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
			case FSMModelPackage.STATE__INPUT_TRANSITIONS:
				return ((InternalEList<?>)getInputTransitions()).basicRemove(otherEnd, msgs);
			case FSMModelPackage.STATE__OUTPUT_TRANSITIONS:
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
			case FSMModelPackage.STATE__INPUT_TRANSITIONS:
				return getInputTransitions();
			case FSMModelPackage.STATE__OUTPUT_TRANSITIONS:
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
			case FSMModelPackage.STATE__INPUT_TRANSITIONS:
				getInputTransitions().clear();
				getInputTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case FSMModelPackage.STATE__OUTPUT_TRANSITIONS:
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
			case FSMModelPackage.STATE__INPUT_TRANSITIONS:
				getInputTransitions().clear();
				return;
			case FSMModelPackage.STATE__OUTPUT_TRANSITIONS:
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
			case FSMModelPackage.STATE__INPUT_TRANSITIONS:
				return inputTransitions != null && !inputTransitions.isEmpty();
			case FSMModelPackage.STATE__OUTPUT_TRANSITIONS:
				return outputTransitions != null && !outputTransitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateImpl
