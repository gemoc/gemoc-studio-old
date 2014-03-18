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

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock;
import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declaration Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.DeclarationBlockImpl#getConcreteEntities <em>Concrete Entities</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.DeclarationBlockImpl#getClassicalExpressions <em>Classical Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclarationBlockImpl extends MinimalEObjectImpl.Container implements DeclarationBlock {
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
	protected DeclarationBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FSMModelPackage.Literals.DECLARATION_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteEntity> getConcreteEntities() {
		if (concreteEntities == null) {
			concreteEntities = new EObjectContainmentEList<ConcreteEntity>(ConcreteEntity.class, this, FSMModelPackage.DECLARATION_BLOCK__CONCRETE_ENTITIES);
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
			classicalExpressions = new EObjectContainmentEList<ClassicalExpression>(ClassicalExpression.class, this, FSMModelPackage.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS);
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
			case FSMModelPackage.DECLARATION_BLOCK__CONCRETE_ENTITIES:
				return ((InternalEList<?>)getConcreteEntities()).basicRemove(otherEnd, msgs);
			case FSMModelPackage.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS:
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
			case FSMModelPackage.DECLARATION_BLOCK__CONCRETE_ENTITIES:
				return getConcreteEntities();
			case FSMModelPackage.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS:
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
			case FSMModelPackage.DECLARATION_BLOCK__CONCRETE_ENTITIES:
				getConcreteEntities().clear();
				getConcreteEntities().addAll((Collection<? extends ConcreteEntity>)newValue);
				return;
			case FSMModelPackage.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS:
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
			case FSMModelPackage.DECLARATION_BLOCK__CONCRETE_ENTITIES:
				getConcreteEntities().clear();
				return;
			case FSMModelPackage.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS:
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
			case FSMModelPackage.DECLARATION_BLOCK__CONCRETE_ENTITIES:
				return concreteEntities != null && !concreteEntities.isEmpty();
			case FSMModelPackage.DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS:
				return classicalExpressions != null && !classicalExpressions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DeclarationBlockImpl
