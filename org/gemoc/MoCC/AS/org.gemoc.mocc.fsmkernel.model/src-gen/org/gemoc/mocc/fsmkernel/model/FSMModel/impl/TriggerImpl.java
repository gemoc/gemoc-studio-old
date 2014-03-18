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

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TriggerImpl#getTrueTriggers <em>True Triggers</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TriggerImpl#getFalseTriggers <em>False Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TriggerImpl extends AbstractTriggerImpl implements Trigger {
	/**
	 * The cached value of the '{@link #getTrueTriggers() <em>True Triggers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<BindableEntity> trueTriggers;

	/**
	 * The cached value of the '{@link #getFalseTriggers() <em>False Triggers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<BindableEntity> falseTriggers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FSMModelPackage.Literals.TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BindableEntity> getTrueTriggers() {
		if (trueTriggers == null) {
			trueTriggers = new EObjectResolvingEList<BindableEntity>(BindableEntity.class, this, FSMModelPackage.TRIGGER__TRUE_TRIGGERS);
		}
		return trueTriggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BindableEntity> getFalseTriggers() {
		if (falseTriggers == null) {
			falseTriggers = new EObjectResolvingEList<BindableEntity>(BindableEntity.class, this, FSMModelPackage.TRIGGER__FALSE_TRIGGERS);
		}
		return falseTriggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FSMModelPackage.TRIGGER__TRUE_TRIGGERS:
				return getTrueTriggers();
			case FSMModelPackage.TRIGGER__FALSE_TRIGGERS:
				return getFalseTriggers();
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
			case FSMModelPackage.TRIGGER__TRUE_TRIGGERS:
				getTrueTriggers().clear();
				getTrueTriggers().addAll((Collection<? extends BindableEntity>)newValue);
				return;
			case FSMModelPackage.TRIGGER__FALSE_TRIGGERS:
				getFalseTriggers().clear();
				getFalseTriggers().addAll((Collection<? extends BindableEntity>)newValue);
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
			case FSMModelPackage.TRIGGER__TRUE_TRIGGERS:
				getTrueTriggers().clear();
				return;
			case FSMModelPackage.TRIGGER__FALSE_TRIGGERS:
				getFalseTriggers().clear();
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
			case FSMModelPackage.TRIGGER__TRUE_TRIGGERS:
				return trueTriggers != null && !trueTriggers.isEmpty();
			case FSMModelPackage.TRIGGER__FALSE_TRIGGERS:
				return falseTriggers != null && !falseTriggers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TriggerImpl
