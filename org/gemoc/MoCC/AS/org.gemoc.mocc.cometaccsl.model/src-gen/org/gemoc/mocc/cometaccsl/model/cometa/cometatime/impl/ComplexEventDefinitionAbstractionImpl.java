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
package org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction;

import org.gemoc.mocc.cometaccsl.model.cometa.impl.ElementAbstractionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Event Definition Abstraction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ComplexEventDefinitionAbstractionImpl#getUses <em>Uses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComplexEventDefinitionAbstractionImpl extends ElementAbstractionImpl implements ComplexEventDefinitionAbstraction {
	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<ClockAbstraction> uses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexEventDefinitionAbstractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometatimePackage.Literals.COMPLEX_EVENT_DEFINITION_ABSTRACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClockAbstraction> getUses() {
		if (uses == null) {
			uses = new EObjectWithInverseResolvingEList.ManyInverse<ClockAbstraction>(ClockAbstraction.class, this, CometatimePackage.COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES, CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER);
		}
		return uses;
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
			case CometatimePackage.COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUses()).basicAdd(otherEnd, msgs);
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
			case CometatimePackage.COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES:
				return ((InternalEList<?>)getUses()).basicRemove(otherEnd, msgs);
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
			case CometatimePackage.COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES:
				return getUses();
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
			case CometatimePackage.COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends ClockAbstraction>)newValue);
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
			case CometatimePackage.COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES:
				getUses().clear();
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
			case CometatimePackage.COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES:
				return uses != null && !uses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexEventDefinitionAbstractionImpl
