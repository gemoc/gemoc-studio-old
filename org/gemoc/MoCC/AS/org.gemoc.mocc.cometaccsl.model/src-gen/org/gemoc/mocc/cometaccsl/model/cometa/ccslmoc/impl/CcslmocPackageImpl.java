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

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLAction;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocFactory;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.FinishClock;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.IntegerAssignement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypePackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.CometadatatypePackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CcslmocPackageImpl extends EPackageImpl implements CcslmocPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccslLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccslStateMachineRelationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccslActionEClass = null;

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
	private EClass integerAssignementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccslGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccslTriggerEClass = null;

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
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CcslmocPackageImpl() {
		super(eNS_URI, CcslmocFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CcslmocPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CcslmocPackage init() {
		if (isInited) return (CcslmocPackage)EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI);

		// Obtain or create and register package
		CcslmocPackageImpl theCcslmocPackage = (CcslmocPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CcslmocPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CcslmocPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CometaPackageImpl theCometaPackage = (CometaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) instanceof CometaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) : CometaPackage.eINSTANCE);
		CometadatatypePackageImpl theCometadatatypePackage = (CometadatatypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) instanceof CometadatatypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) : CometadatatypePackage.eINSTANCE);
		CometamocPackageImpl theCometamocPackage = (CometamocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) instanceof CometamocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) : CometamocPackage.eINSTANCE);
		CometastructurePackageImpl theCometastructurePackage = (CometastructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) instanceof CometastructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) : CometastructurePackage.eINSTANCE);
		CometatimePackageImpl theCometatimePackage = (CometatimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) instanceof CometatimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) : CometatimePackage.eINSTANCE);
		Ccsl4cometaspecialisationPackageImpl theCcsl4cometaspecialisationPackage = (Ccsl4cometaspecialisationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) instanceof Ccsl4cometaspecialisationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) : Ccsl4cometaspecialisationPackage.eINSTANCE);
		FsmdefinitionPackageImpl theFsmdefinitionPackage = (FsmdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) instanceof FsmdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) : FsmdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theCcslmocPackage.createPackageContents();
		theCometaPackage.createPackageContents();
		theCometadatatypePackage.createPackageContents();
		theCometamocPackage.createPackageContents();
		theCometastructurePackage.createPackageContents();
		theCometatimePackage.createPackageContents();
		theCcsl4cometaspecialisationPackage.createPackageContents();
		theFsmdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theCcslmocPackage.initializePackageContents();
		theCometaPackage.initializePackageContents();
		theCometadatatypePackage.initializePackageContents();
		theCometamocPackage.initializePackageContents();
		theCometastructurePackage.initializePackageContents();
		theCometatimePackage.initializePackageContents();
		theCcsl4cometaspecialisationPackage.initializePackageContents();
		theFsmdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCcslmocPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CcslmocPackage.eNS_URI, theCcslmocPackage);
		return theCcslmocPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSLLibrary() {
		return ccslLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSLStateMachineRelationDefinition() {
		return ccslStateMachineRelationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCCSLStateMachineRelationDefinition_ConcreteEntities() {
		return (EReference)ccslStateMachineRelationDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCCSLStateMachineRelationDefinition_ClassicalExpressions() {
		return (EReference)ccslStateMachineRelationDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSLAction() {
		return ccslActionEClass;
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
	public EClass getIntegerAssignement() {
		return integerAssignementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSLGuard() {
		return ccslGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCCSLGuard_Value() {
		return (EReference)ccslGuardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSLTrigger() {
		return ccslTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCCSLTrigger_TrueTriggers() {
		return (EReference)ccslTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCCSLTrigger_FalseTriggers() {
		return (EReference)ccslTriggerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CcslmocFactory getCcslmocFactory() {
		return (CcslmocFactory)getEFactoryInstance();
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
		ccslLibraryEClass = createEClass(CCSL_LIBRARY);

		ccslStateMachineRelationDefinitionEClass = createEClass(CCSL_STATE_MACHINE_RELATION_DEFINITION);
		createEReference(ccslStateMachineRelationDefinitionEClass, CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES);
		createEReference(ccslStateMachineRelationDefinitionEClass, CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS);

		ccslActionEClass = createEClass(CCSL_ACTION);

		finishClockEClass = createEClass(FINISH_CLOCK);
		createEReference(finishClockEClass, FINISH_CLOCK__CLOCK);

		integerAssignementEClass = createEClass(INTEGER_ASSIGNEMENT);

		ccslGuardEClass = createEClass(CCSL_GUARD);
		createEReference(ccslGuardEClass, CCSL_GUARD__VALUE);

		ccslTriggerEClass = createEClass(CCSL_TRIGGER);
		createEReference(ccslTriggerEClass, CCSL_TRIGGER__TRUE_TRIGGERS);
		createEReference(ccslTriggerEClass, CCSL_TRIGGER__FALSE_TRIGGERS);
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
		CometaPackage theCometaPackage = (CometaPackage)EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI);
		ClockExpressionAndRelationPackage theClockExpressionAndRelationPackage = (ClockExpressionAndRelationPackage)EPackage.Registry.INSTANCE.getEPackage(ClockExpressionAndRelationPackage.eNS_URI);
		FsmdefinitionPackage theFsmdefinitionPackage = (FsmdefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI);
		ClassicalExpressionPackage theClassicalExpressionPackage = (ClassicalExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ClassicalExpressionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ccslLibraryEClass.getESuperTypes().add(theCometaPackage.getMoCLibrary());
		ccslLibraryEClass.getESuperTypes().add(theClockExpressionAndRelationPackage.getLibrary());
		ccslStateMachineRelationDefinitionEClass.getESuperTypes().add(theClockExpressionAndRelationPackage.getExternalRelationDefinition());
		ccslStateMachineRelationDefinitionEClass.getESuperTypes().add(theFsmdefinitionPackage.getFiniteStateMachine());
		ccslActionEClass.getESuperTypes().add(theFsmdefinitionPackage.getAction());
		finishClockEClass.getESuperTypes().add(this.getCCSLAction());
		integerAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryIntegerExpression());
		integerAssignementEClass.getESuperTypes().add(this.getCCSLAction());
		ccslGuardEClass.getESuperTypes().add(theFsmdefinitionPackage.getGuard());
		ccslTriggerEClass.getESuperTypes().add(theFsmdefinitionPackage.getTrigger());

		// Initialize classes, features, and operations; add parameters
		initEClass(ccslLibraryEClass, CCSLLibrary.class, "CCSLLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ccslStateMachineRelationDefinitionEClass, CCSLStateMachineRelationDefinition.class, "CCSLStateMachineRelationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCCSLStateMachineRelationDefinition_ConcreteEntities(), theClockExpressionAndRelationPackage.getConcreteEntity(), null, "concreteEntities", null, 0, -1, CCSLStateMachineRelationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCCSLStateMachineRelationDefinition_ClassicalExpressions(), theClassicalExpressionPackage.getClassicalExpression(), null, "classicalExpressions", null, 0, -1, CCSLStateMachineRelationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ccslActionEClass, CCSLAction.class, "CCSLAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(finishClockEClass, FinishClock.class, "FinishClock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFinishClock_Clock(), theClockExpressionAndRelationPackage.getBindableEntity(), null, "clock", null, 0, 1, FinishClock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerAssignementEClass, IntegerAssignement.class, "IntegerAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ccslGuardEClass, CCSLGuard.class, "CCSLGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCCSLGuard_Value(), theClassicalExpressionPackage.getBooleanExpression(), null, "value", null, 0, 1, CCSLGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ccslTriggerEClass, CCSLTrigger.class, "CCSLTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCCSLTrigger_TrueTriggers(), theClockExpressionAndRelationPackage.getBindableEntity(), null, "trueTriggers", null, 0, -1, CCSLTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCCSLTrigger_FalseTriggers(), theClockExpressionAndRelationPackage.getBindableEntity(), null, "falseTriggers", null, 0, -1, CCSLTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //CcslmocPackageImpl
