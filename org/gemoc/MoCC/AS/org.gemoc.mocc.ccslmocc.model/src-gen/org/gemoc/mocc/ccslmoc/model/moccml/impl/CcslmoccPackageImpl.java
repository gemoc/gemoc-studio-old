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

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.mocc.ccslmoc.model.moccml.CcslmoccFactory;
import org.gemoc.mocc.ccslmoc.model.moccml.CcslmoccPackage;
import org.gemoc.mocc.ccslmoc.model.moccml.FinishClock;
import org.gemoc.mocc.ccslmoc.model.moccml.StartClock;
import org.gemoc.mocc.ccslmoc.model.moccml.StateMachineRelationDefinition;
import org.gemoc.mocc.ccslmoc.model.moccml.StateRelationBasedLibrary;

import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CcslmoccPackageImpl extends EPackageImpl implements CcslmoccPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateRelationBasedLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMachineRelationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finishClockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startClockEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.gemoc.mocc.ccslmoc.model.moccml.CcslmoccPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CcslmoccPackageImpl() {
		super(eNS_URI, CcslmoccFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CcslmoccPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CcslmoccPackage init() {
		if (isInited) return (CcslmoccPackage)EPackage.Registry.INSTANCE.getEPackage(CcslmoccPackage.eNS_URI);

		// Obtain or create and register package
		CcslmoccPackageImpl theCcslmoccPackage = (CcslmoccPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CcslmoccPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CcslmoccPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		FSMModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCcslmoccPackage.createPackageContents();

		// Initialize created meta-data
		theCcslmoccPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCcslmoccPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CcslmoccPackage.eNS_URI, theCcslmoccPackage);
		return theCcslmoccPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateRelationBasedLibrary() {
		return stateRelationBasedLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMachineRelationDefinition() {
		return stateMachineRelationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinishClock() {
		return finishClockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFinishClock_Clock() {
		return (EReference)finishClockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartClock() {
		return startClockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartClock_Clock() {
		return (EReference)startClockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CcslmoccFactory getCcslmoccFactory() {
		return (CcslmoccFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		stateRelationBasedLibraryEClass = createEClass(STATE_RELATION_BASED_LIBRARY);

		stateMachineRelationDefinitionEClass = createEClass(STATE_MACHINE_RELATION_DEFINITION);

		finishClockEClass = createEClass(FINISH_CLOCK);
		createEReference(finishClockEClass, FINISH_CLOCK__CLOCK);

		startClockEClass = createEClass(START_CLOCK);
		createEReference(startClockEClass, START_CLOCK__CLOCK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ClockExpressionAndRelationPackage theClockExpressionAndRelationPackage = (ClockExpressionAndRelationPackage)EPackage.Registry.INSTANCE.getEPackage(ClockExpressionAndRelationPackage.eNS_URI);
		FSMModelPackage theFSMModelPackage = (FSMModelPackage)EPackage.Registry.INSTANCE.getEPackage(FSMModelPackage.eNS_URI);
		TimeModelPackage theTimeModelPackage = (TimeModelPackage)EPackage.Registry.INSTANCE.getEPackage(TimeModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stateRelationBasedLibraryEClass.getESuperTypes().add(theClockExpressionAndRelationPackage.getLibrary());
		stateMachineRelationDefinitionEClass.getESuperTypes().add(theClockExpressionAndRelationPackage.getExternalRelationDefinition());
		stateMachineRelationDefinitionEClass.getESuperTypes().add(theFSMModelPackage.getStateMachineDefinition());
		finishClockEClass.getESuperTypes().add(theFSMModelPackage.getAbstractAction());
		startClockEClass.getESuperTypes().add(theFSMModelPackage.getAbstractAction());

		// Initialize classes and features; add operations and parameters
		initEClass(stateRelationBasedLibraryEClass, StateRelationBasedLibrary.class, "StateRelationBasedLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateMachineRelationDefinitionEClass, StateMachineRelationDefinition.class, "StateMachineRelationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(finishClockEClass, FinishClock.class, "FinishClock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFinishClock_Clock(), theClockExpressionAndRelationPackage.getBindableEntity(), null, "clock", null, 1, 1, FinishClock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFinishClock_Clock().getEKeys().add(theTimeModelPackage.getNamedElement_Name());

		initEClass(startClockEClass, StartClock.class, "StartClock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStartClock_Clock(), theClockExpressionAndRelationPackage.getBindableEntity(), null, "clock", null, 1, 1, StartClock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStartClock_Clock().getEKeys().add(theTimeModelPackage.getNamedElement_Name());

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
	}

} //CcslmoccPackageImpl
