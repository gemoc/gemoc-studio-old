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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CcslmocFactoryImpl extends EFactoryImpl implements CcslmocFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CcslmocFactory init() {
		try {
			CcslmocFactory theCcslmocFactory = (CcslmocFactory)EPackage.Registry.INSTANCE.getEFactory(CcslmocPackage.eNS_URI);
			if (theCcslmocFactory != null) {
				return theCcslmocFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CcslmocFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CcslmocFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CcslmocPackage.CCSL_LIBRARY: return createCCSLLibrary();
			case CcslmocPackage.CCSL_STATE_MACHINE_RELATION_DEFINITION: return createCCSLStateMachineRelationDefinition();
			case CcslmocPackage.FINISH_CLOCK: return createFinishClock();
			case CcslmocPackage.INTEGER_ASSIGNEMENT: return createIntegerAssignement();
			case CcslmocPackage.CCSL_GUARD: return createCCSLGuard();
			case CcslmocPackage.CCSL_TRIGGER: return createCCSLTrigger();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSLLibrary createCCSLLibrary() {
		CCSLLibraryImpl ccslLibrary = new CCSLLibraryImpl();
		return ccslLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSLStateMachineRelationDefinition createCCSLStateMachineRelationDefinition() {
		CCSLStateMachineRelationDefinitionImpl ccslStateMachineRelationDefinition = new CCSLStateMachineRelationDefinitionImpl();
		return ccslStateMachineRelationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinishClock createFinishClock() {
		FinishClockImpl finishClock = new FinishClockImpl();
		return finishClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAssignement createIntegerAssignement() {
		IntegerAssignementImpl integerAssignement = new IntegerAssignementImpl();
		return integerAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSLGuard createCCSLGuard() {
		CCSLGuardImpl ccslGuard = new CCSLGuardImpl();
		return ccslGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSLTrigger createCCSLTrigger() {
		CCSLTriggerImpl ccslTrigger = new CCSLTriggerImpl();
		return ccslTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CcslmocPackage getCcslmocPackage() {
		return (CcslmocPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CcslmocPackage getPackage() {
		return CcslmocPackage.eINSTANCE;
	}

} //CcslmocFactoryImpl
