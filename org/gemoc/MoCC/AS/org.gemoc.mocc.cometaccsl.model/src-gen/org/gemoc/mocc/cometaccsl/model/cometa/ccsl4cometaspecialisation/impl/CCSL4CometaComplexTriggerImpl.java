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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TriggerImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CCSL4 Cometa Complex Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaComplexTriggerImpl#getTrueTriggers <em>True Triggers</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaComplexTriggerImpl#getFalseTriggers <em>False Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CCSL4CometaComplexTriggerImpl extends TriggerImpl implements CCSL4CometaComplexTrigger {
	/**
	 * The cached value of the '{@link #getTrueTriggers() <em>True Triggers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> trueTriggers;

	/**
	 * The cached value of the '{@link #getFalseTriggers() <em>False Triggers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseTriggers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> falseTriggers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CCSL4CometaComplexTriggerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ccsl4cometaspecialisationPackage.Literals.CCSL4_COMETA_COMPLEX_TRIGGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTrueTriggers() {
		if (trueTriggers == null) {
			trueTriggers = new EDataTypeUniqueEList<String>(String.class, this, Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__TRUE_TRIGGERS);
		}
		return trueTriggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFalseTriggers() {
		if (falseTriggers == null) {
			falseTriggers = new EDataTypeUniqueEList<String>(String.class, this, Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__FALSE_TRIGGERS);
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
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__TRUE_TRIGGERS:
				return getTrueTriggers();
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__FALSE_TRIGGERS:
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
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__TRUE_TRIGGERS:
				getTrueTriggers().clear();
				getTrueTriggers().addAll((Collection<? extends String>)newValue);
				return;
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__FALSE_TRIGGERS:
				getFalseTriggers().clear();
				getFalseTriggers().addAll((Collection<? extends String>)newValue);
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
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__TRUE_TRIGGERS:
				getTrueTriggers().clear();
				return;
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__FALSE_TRIGGERS:
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
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__TRUE_TRIGGERS:
				return trueTriggers != null && !trueTriggers.isEmpty();
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER__FALSE_TRIGGERS:
				return falseTriggers != null && !falseTriggers.isEmpty();
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
		result.append(" (trueTriggers: ");
		result.append(trueTriggers);
		result.append(", falseTriggers: ");
		result.append(falseTriggers);
		result.append(')');
		return result.toString();
	}

} //CCSL4CometaComplexTriggerImpl
