/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
/**
 */
package org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TfsmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Temporal Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.impl.TemporalGuardImpl#getOnClock <em>On Clock</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.impl.TemporalGuardImpl#getAfterDuration <em>After Duration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemporalGuardImpl extends GuardImpl implements TemporalGuard {
	/**
	 * The cached value of the '{@link #getOnClock() <em>On Clock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnClock()
	 * @generated
	 * @ordered
	 */
	protected FSMClock onClock;

	/**
	 * The default value of the '{@link #getAfterDuration() <em>After Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfterDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int AFTER_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAfterDuration() <em>After Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfterDuration()
	 * @generated
	 * @ordered
	 */
	protected int afterDuration = AFTER_DURATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemporalGuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmPackage.Literals.TEMPORAL_GUARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMClock getOnClock() {
		if (onClock != null && onClock.eIsProxy()) {
			InternalEObject oldOnClock = (InternalEObject)onClock;
			onClock = (FSMClock)eResolveProxy(oldOnClock);
			if (onClock != oldOnClock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TfsmPackage.TEMPORAL_GUARD__ON_CLOCK, oldOnClock, onClock));
			}
		}
		return onClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMClock basicGetOnClock() {
		return onClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnClock(FSMClock newOnClock) {
		FSMClock oldOnClock = onClock;
		onClock = newOnClock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmPackage.TEMPORAL_GUARD__ON_CLOCK, oldOnClock, onClock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAfterDuration() {
		return afterDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAfterDuration(int newAfterDuration) {
		int oldAfterDuration = afterDuration;
		afterDuration = newAfterDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION, oldAfterDuration, afterDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
				if (resolve) return getOnClock();
				return basicGetOnClock();
			case TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
				return getAfterDuration();
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
			case TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
				setOnClock((FSMClock)newValue);
				return;
			case TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
				setAfterDuration((Integer)newValue);
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
			case TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
				setOnClock((FSMClock)null);
				return;
			case TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
				setAfterDuration(AFTER_DURATION_EDEFAULT);
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
			case TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
				return onClock != null;
			case TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
				return afterDuration != AFTER_DURATION_EDEFAULT;
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
		result.append(" (afterDuration: ");
		result.append(afterDuration);
		result.append(')');
		return result.toString();
	}

} //TemporalGuardImpl
