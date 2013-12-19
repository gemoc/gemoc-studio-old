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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaGuard;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.GuardImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cometa Guard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaGuardImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaGuardImpl#getRtElements <em>Rt Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CometaGuardImpl extends GuardImpl implements CometaGuard {
	/**
	 * The default value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected String content = CONTENT_EDEFAULT;

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
	protected CometaGuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometamocPackage.Literals.COMETA_GUARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(String newContent) {
		String oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.COMETA_GUARD__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RTInterface> getRtElements() {
		if (rtElements == null) {
			rtElements = new EObjectResolvingEList<RTInterface>(RTInterface.class, this, CometamocPackage.COMETA_GUARD__RT_ELEMENTS);
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
			case CometamocPackage.COMETA_GUARD__CONTENT:
				return getContent();
			case CometamocPackage.COMETA_GUARD__RT_ELEMENTS:
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
			case CometamocPackage.COMETA_GUARD__CONTENT:
				setContent((String)newValue);
				return;
			case CometamocPackage.COMETA_GUARD__RT_ELEMENTS:
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
			case CometamocPackage.COMETA_GUARD__CONTENT:
				setContent(CONTENT_EDEFAULT);
				return;
			case CometamocPackage.COMETA_GUARD__RT_ELEMENTS:
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
			case CometamocPackage.COMETA_GUARD__CONTENT:
				return CONTENT_EDEFAULT == null ? content != null : !CONTENT_EDEFAULT.equals(content);
			case CometamocPackage.COMETA_GUARD__RT_ELEMENTS:
				return rtElements != null && !rtElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ElementAbstraction.class) {
			switch (derivedFeatureID) {
				case CometamocPackage.COMETA_GUARD__CONTENT: return CometaPackage.ELEMENT_ABSTRACTION__CONTENT;
				default: return -1;
			}
		}
		if (baseClass == OpaqueBlock.class) {
			switch (derivedFeatureID) {
				case CometamocPackage.COMETA_GUARD__RT_ELEMENTS: return CometamocPackage.OPAQUE_BLOCK__RT_ELEMENTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ElementAbstraction.class) {
			switch (baseFeatureID) {
				case CometaPackage.ELEMENT_ABSTRACTION__CONTENT: return CometamocPackage.COMETA_GUARD__CONTENT;
				default: return -1;
			}
		}
		if (baseClass == OpaqueBlock.class) {
			switch (baseFeatureID) {
				case CometamocPackage.OPAQUE_BLOCK__RT_ELEMENTS: return CometamocPackage.COMETA_GUARD__RT_ELEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (content: ");
		result.append(content);
		result.append(')');
		return result.toString();
	}

} //CometaGuardImpl
