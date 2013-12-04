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
package org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Library;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaSystemSpecificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CCSL4 Cometa Cometa System Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaCometaSystemSpecificationImpl#getCcslLib <em>Ccsl Lib</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CCSL4CometaCometaSystemSpecificationImpl extends CometaSystemSpecificationImpl implements CCSL4CometaCometaSystemSpecification {
	/**
	 * The cached value of the '{@link #getCcslLib() <em>Ccsl Lib</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCcslLib()
	 * @generated
	 * @ordered
	 */
	protected Library ccslLib;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CCSL4CometaCometaSystemSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ccsl4cometaspecialisationPackage.Literals.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library getCcslLib() {
		if (ccslLib != null && ccslLib.eIsProxy()) {
			InternalEObject oldCcslLib = (InternalEObject)ccslLib;
			ccslLib = (Library)eResolveProxy(oldCcslLib);
			if (ccslLib != oldCcslLib) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB, oldCcslLib, ccslLib));
			}
		}
		return ccslLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library basicGetCcslLib() {
		return ccslLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCcslLib(Library newCcslLib) {
		Library oldCcslLib = ccslLib;
		ccslLib = newCcslLib;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB, oldCcslLib, ccslLib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB:
				if (resolve) return getCcslLib();
				return basicGetCcslLib();
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
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB:
				setCcslLib((Library)newValue);
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
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB:
				setCcslLib((Library)null);
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
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB:
				return ccslLib != null;
		}
		return super.eIsSet(featureID);
	}

} //CCSL4CometaCometaSystemSpecificationImpl
