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
package org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.RealExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.impl.BooleanExpressionImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSupEqual;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Sup Equal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSupEqualImpl#getLeftValue <em>Left Value</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSupEqualImpl#getRightValue <em>Right Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RealSupEqualImpl extends BooleanExpressionImpl implements RealSupEqual {
	/**
	 * The cached value of the '{@link #getLeftValue() <em>Left Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftValue()
	 * @generated
	 * @ordered
	 */
	protected RealExpression leftValue;

	/**
	 * The cached value of the '{@link #getRightValue() <em>Right Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightValue()
	 * @generated
	 * @ordered
	 */
	protected RealExpression rightValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealSupEqualImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditionExtensionPackage.Literals.REAL_SUP_EQUAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealExpression getLeftValue() {
		return leftValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftValue(RealExpression newLeftValue, NotificationChain msgs) {
		RealExpression oldLeftValue = leftValue;
		leftValue = newLeftValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE, oldLeftValue, newLeftValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftValue(RealExpression newLeftValue) {
		if (newLeftValue != leftValue) {
			NotificationChain msgs = null;
			if (leftValue != null)
				msgs = ((InternalEObject)leftValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE, null, msgs);
			if (newLeftValue != null)
				msgs = ((InternalEObject)newLeftValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE, null, msgs);
			msgs = basicSetLeftValue(newLeftValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE, newLeftValue, newLeftValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealExpression getRightValue() {
		return rightValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightValue(RealExpression newRightValue, NotificationChain msgs) {
		RealExpression oldRightValue = rightValue;
		rightValue = newRightValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE, oldRightValue, newRightValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightValue(RealExpression newRightValue) {
		if (newRightValue != rightValue) {
			NotificationChain msgs = null;
			if (rightValue != null)
				msgs = ((InternalEObject)rightValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE, null, msgs);
			if (newRightValue != null)
				msgs = ((InternalEObject)newRightValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE, null, msgs);
			msgs = basicSetRightValue(newRightValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE, newRightValue, newRightValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE:
				return basicSetLeftValue(null, msgs);
			case EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE:
				return basicSetRightValue(null, msgs);
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
			case EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE:
				return getLeftValue();
			case EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE:
				return getRightValue();
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
			case EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE:
				setLeftValue((RealExpression)newValue);
				return;
			case EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE:
				setRightValue((RealExpression)newValue);
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
			case EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE:
				setLeftValue((RealExpression)null);
				return;
			case EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE:
				setRightValue((RealExpression)null);
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
			case EditionExtensionPackage.REAL_SUP_EQUAL__LEFT_VALUE:
				return leftValue != null;
			case EditionExtensionPackage.REAL_SUP_EQUAL__RIGHT_VALUE:
				return rightValue != null;
		}
		return super.eIsSet(featureID);
	}

} //RealSupEqualImpl
