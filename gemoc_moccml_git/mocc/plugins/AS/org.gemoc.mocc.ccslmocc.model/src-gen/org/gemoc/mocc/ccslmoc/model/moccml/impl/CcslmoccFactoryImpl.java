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
package org.gemoc.mocc.ccslmoc.model.moccml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.mocc.ccslmoc.model.moccml.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CcslmoccFactoryImpl extends EFactoryImpl implements CcslmoccFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CcslmoccFactory init() {
		try {
			CcslmoccFactory theCcslmoccFactory = (CcslmoccFactory)EPackage.Registry.INSTANCE.getEFactory(CcslmoccPackage.eNS_URI);
			if (theCcslmoccFactory != null) {
				return theCcslmoccFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CcslmoccFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CcslmoccFactoryImpl() {
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
			case CcslmoccPackage.STATE_RELATION_BASED_LIBRARY: return createStateRelationBasedLibrary();
			case CcslmoccPackage.STATE_MACHINE_RELATION_DEFINITION: return createStateMachineRelationDefinition();
			case CcslmoccPackage.FINISH_CLOCK: return createFinishClock();
			case CcslmoccPackage.START_CLOCK: return createStartClock();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateRelationBasedLibrary createStateRelationBasedLibrary() {
		StateRelationBasedLibraryImpl stateRelationBasedLibrary = new StateRelationBasedLibraryImpl();
		return stateRelationBasedLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachineRelationDefinition createStateMachineRelationDefinition() {
		StateMachineRelationDefinitionImpl stateMachineRelationDefinition = new StateMachineRelationDefinitionImpl();
		return stateMachineRelationDefinition;
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
	public StartClock createStartClock() {
		StartClockImpl startClock = new StartClockImpl();
		return startClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CcslmoccPackage getCcslmoccPackage() {
		return (CcslmoccPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CcslmoccPackage getPackage() {
		return CcslmoccPackage.eINSTANCE;
	}

} //CcslmoccFactoryImpl
