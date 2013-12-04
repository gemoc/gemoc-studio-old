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
package org.gemoc.mocc.cometaccsl.model.cometa.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mo CSystem Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCSystemSpecificationImpl#getMocLib <em>Moc Lib</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MoCSystemSpecificationImpl extends MinimalEObjectImpl.Container implements MoCSystemSpecification {
	/**
	 * The cached value of the '{@link #getMocLib() <em>Moc Lib</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMocLib()
	 * @generated
	 * @ordered
	 */
	protected MoCLibrary mocLib;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoCSystemSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometaPackage.Literals.MO_CSYSTEM_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCLibrary getMocLib() {
		return mocLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMocLib(MoCLibrary newMocLib, NotificationChain msgs) {
		MoCLibrary oldMocLib = mocLib;
		mocLib = newMocLib;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB, oldMocLib, newMocLib);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMocLib(MoCLibrary newMocLib) {
		if (newMocLib != mocLib) {
			NotificationChain msgs = null;
			if (mocLib != null)
				msgs = ((InternalEObject)mocLib).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB, null, msgs);
			if (newMocLib != null)
				msgs = ((InternalEObject)newMocLib).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB, null, msgs);
			msgs = basicSetMocLib(newMocLib, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB, newMocLib, newMocLib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB:
				return basicSetMocLib(null, msgs);
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
			case CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB:
				return getMocLib();
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
			case CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB:
				setMocLib((MoCLibrary)newValue);
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
			case CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB:
				setMocLib((MoCLibrary)null);
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
			case CometaPackage.MO_CSYSTEM_SPECIFICATION__MOC_LIB:
				return mocLib != null;
		}
		return super.eIsSet(featureID);
	}

} //MoCSystemSpecificationImpl
