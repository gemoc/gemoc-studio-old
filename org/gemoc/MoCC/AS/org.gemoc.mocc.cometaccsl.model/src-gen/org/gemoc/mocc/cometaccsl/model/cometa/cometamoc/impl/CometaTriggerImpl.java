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


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TriggerImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cometa Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaTriggerImpl#getTriggOn <em>Trigg On</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CometaTriggerImpl extends TriggerImpl implements CometaTrigger {
	/**
	 * The cached value of the '{@link #getTriggOn() <em>Trigg On</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggOn()
	 * @generated
	 * @ordered
	 */
	protected Event triggOn;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CometaTriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometamocPackage.Literals.COMETA_TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getTriggOn() {
		if (triggOn != null && triggOn.eIsProxy()) {
			InternalEObject oldTriggOn = (InternalEObject)triggOn;
			triggOn = (Event)eResolveProxy(oldTriggOn);
			if (triggOn != oldTriggOn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CometamocPackage.COMETA_TRIGGER__TRIGG_ON, oldTriggOn, triggOn));
			}
		}
		return triggOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetTriggOn() {
		return triggOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTriggOn(Event newTriggOn) {
		Event oldTriggOn = triggOn;
		triggOn = newTriggOn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.COMETA_TRIGGER__TRIGG_ON, oldTriggOn, triggOn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CometamocPackage.COMETA_TRIGGER__TRIGG_ON:
				if (resolve) return getTriggOn();
				return basicGetTriggOn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CometamocPackage.COMETA_TRIGGER__TRIGG_ON:
				setTriggOn((Event)newValue);
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
			case CometamocPackage.COMETA_TRIGGER__TRIGG_ON:
				setTriggOn((Event)null);
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
			case CometamocPackage.COMETA_TRIGGER__TRIGG_ON:
				return triggOn != null;
		}
		return super.eIsSet(featureID);
	}

} //CometaTriggerImpl
