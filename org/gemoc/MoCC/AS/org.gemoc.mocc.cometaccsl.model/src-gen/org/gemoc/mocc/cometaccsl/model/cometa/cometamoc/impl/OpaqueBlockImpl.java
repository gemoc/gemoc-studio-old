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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface;

import org.gemoc.mocc.cometaccsl.model.cometa.impl.ElementAbstractionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opaque Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBlockImpl#getRtElements <em>Rt Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OpaqueBlockImpl extends ElementAbstractionImpl implements OpaqueBlock {
	/**
	 * The cached value of the '{@link #getRtElements() <em>Rt Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRtElements()
	 * @generated
	 * @ordered
	 */
	protected EList<RTInterface> rtElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpaqueBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometamocPackage.Literals.OPAQUE_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RTInterface> getRtElements() {
		if (rtElements == null) {
			rtElements = new EObjectResolvingEList<RTInterface>(RTInterface.class, this, CometamocPackage.OPAQUE_BLOCK__RT_ELEMENTS);
		}
		return rtElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CometamocPackage.OPAQUE_BLOCK__RT_ELEMENTS:
				return getRtElements();
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
			case CometamocPackage.OPAQUE_BLOCK__RT_ELEMENTS:
				getRtElements().clear();
				getRtElements().addAll((Collection<? extends RTInterface>)newValue);
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
			case CometamocPackage.OPAQUE_BLOCK__RT_ELEMENTS:
				getRtElements().clear();
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
			case CometamocPackage.OPAQUE_BLOCK__RT_ELEMENTS:
				return rtElements != null && !rtElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OpaqueBlockImpl
