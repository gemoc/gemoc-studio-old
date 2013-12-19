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
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;

import org.gemoc.mocc.cometaccsl.model.cometa.impl.ElementAbstractionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clock Abstraction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ClockAbstractionImpl#getIsReferedInConstraints <em>Is Refered In Constraints</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ClockAbstractionImpl#getIsReferedbyEvents <em>Is Referedby Events</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ClockAbstractionImpl#getIsReferedbyTrigger <em>Is Referedby Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClockAbstractionImpl extends ElementAbstractionImpl implements ClockAbstraction {
	/**
	 * The cached value of the '{@link #getIsReferedInConstraints() <em>Is Refered In Constraints</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsReferedInConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConstraint> isReferedInConstraints;

	/**
	 * The cached value of the '{@link #getIsReferedbyEvents() <em>Is Referedby Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsReferedbyEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> isReferedbyEvents;

	/**
	 * The cached value of the '{@link #getIsReferedbyTrigger() <em>Is Referedby Trigger</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsReferedbyTrigger()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexEventDefinitionAbstraction> isReferedbyTrigger;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClockAbstractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometatimePackage.Literals.CLOCK_ABSTRACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConstraint> getIsReferedInConstraints() {
		if (isReferedInConstraints == null) {
			isReferedInConstraints = new EObjectWithInverseResolvingEList.ManyInverse<TimeConstraint>(TimeConstraint.class, this, CometatimePackage.CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS, CometatimePackage.TIME_CONSTRAINT__USES);
		}
		return isReferedInConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getIsReferedbyEvents() {
		if (isReferedbyEvents == null) {
			isReferedbyEvents = new EObjectWithInverseResolvingEList.ManyInverse<Event>(Event.class, this, CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS, CometatimePackage.EVENT__USES);
		}
		return isReferedbyEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexEventDefinitionAbstraction> getIsReferedbyTrigger() {
		if (isReferedbyTrigger == null) {
			isReferedbyTrigger = new EObjectWithInverseResolvingEList.ManyInverse<ComplexEventDefinitionAbstraction>(ComplexEventDefinitionAbstraction.class, this, CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER, CometatimePackage.COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES);
		}
		return isReferedbyTrigger;
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
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsReferedInConstraints()).basicAdd(otherEnd, msgs);
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsReferedbyEvents()).basicAdd(otherEnd, msgs);
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsReferedbyTrigger()).basicAdd(otherEnd, msgs);
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
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS:
				return ((InternalEList<?>)getIsReferedInConstraints()).basicRemove(otherEnd, msgs);
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS:
				return ((InternalEList<?>)getIsReferedbyEvents()).basicRemove(otherEnd, msgs);
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER:
				return ((InternalEList<?>)getIsReferedbyTrigger()).basicRemove(otherEnd, msgs);
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
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS:
				return getIsReferedInConstraints();
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS:
				return getIsReferedbyEvents();
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER:
				return getIsReferedbyTrigger();
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
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS:
				getIsReferedInConstraints().clear();
				getIsReferedInConstraints().addAll((Collection<? extends TimeConstraint>)newValue);
				return;
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS:
				getIsReferedbyEvents().clear();
				getIsReferedbyEvents().addAll((Collection<? extends Event>)newValue);
				return;
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER:
				getIsReferedbyTrigger().clear();
				getIsReferedbyTrigger().addAll((Collection<? extends ComplexEventDefinitionAbstraction>)newValue);
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
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS:
				getIsReferedInConstraints().clear();
				return;
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS:
				getIsReferedbyEvents().clear();
				return;
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER:
				getIsReferedbyTrigger().clear();
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
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS:
				return isReferedInConstraints != null && !isReferedInConstraints.isEmpty();
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS:
				return isReferedbyEvents != null && !isReferedbyEvents.isEmpty();
			case CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER:
				return isReferedbyTrigger != null && !isReferedbyTrigger.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClockAbstractionImpl
