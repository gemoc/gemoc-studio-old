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

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaAction;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaBlockAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaClock;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaGuard;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaTimeConstraint;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationFactory;
import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl;

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
public class Ccsl4cometaspecialisationPackageImpl extends EPackageImpl implements Ccsl4cometaspecialisationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccsl4CometaClockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccsl4CometaBlockAbstractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccsl4CometaTimeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccsl4CometaComplexTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccsl4CometaCometaSystemSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccsl4CometaGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccsl4CometaActionEClass = null;

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
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Ccsl4cometaspecialisationPackageImpl() {
		super(eNS_URI, Ccsl4cometaspecialisationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Ccsl4cometaspecialisationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Ccsl4cometaspecialisationPackage init() {
		if (isInited) return (Ccsl4cometaspecialisationPackage)EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI);

		// Obtain or create and register package
		Ccsl4cometaspecialisationPackageImpl theCcsl4cometaspecialisationPackage = (Ccsl4cometaspecialisationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Ccsl4cometaspecialisationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Ccsl4cometaspecialisationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CometaPackageImpl theCometaPackage = (CometaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) instanceof CometaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) : CometaPackage.eINSTANCE);
		CometadatatypePackageImpl theCometadatatypePackage = (CometadatatypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) instanceof CometadatatypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) : CometadatatypePackage.eINSTANCE);
		CometamocPackageImpl theCometamocPackage = (CometamocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) instanceof CometamocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) : CometamocPackage.eINSTANCE);
		CometastructurePackageImpl theCometastructurePackage = (CometastructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) instanceof CometastructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) : CometastructurePackage.eINSTANCE);
		CometatimePackageImpl theCometatimePackage = (CometatimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) instanceof CometatimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) : CometatimePackage.eINSTANCE);
		CcslmocPackageImpl theCcslmocPackage = (CcslmocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) instanceof CcslmocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) : CcslmocPackage.eINSTANCE);
		FsmdefinitionPackageImpl theFsmdefinitionPackage = (FsmdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) instanceof FsmdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) : FsmdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theCcsl4cometaspecialisationPackage.createPackageContents();
		theCometaPackage.createPackageContents();
		theCometadatatypePackage.createPackageContents();
		theCometamocPackage.createPackageContents();
		theCometastructurePackage.createPackageContents();
		theCometatimePackage.createPackageContents();
		theCcslmocPackage.createPackageContents();
		theFsmdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theCcsl4cometaspecialisationPackage.initializePackageContents();
		theCometaPackage.initializePackageContents();
		theCometadatatypePackage.initializePackageContents();
		theCometamocPackage.initializePackageContents();
		theCometastructurePackage.initializePackageContents();
		theCometatimePackage.initializePackageContents();
		theCcslmocPackage.initializePackageContents();
		theFsmdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCcsl4cometaspecialisationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Ccsl4cometaspecialisationPackage.eNS_URI, theCcsl4cometaspecialisationPackage);
		return theCcsl4cometaspecialisationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSL4CometaClock() {
		return ccsl4CometaClockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSL4CometaBlockAbstraction() {
		return ccsl4CometaBlockAbstractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSL4CometaTimeConstraint() {
		return ccsl4CometaTimeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSL4CometaComplexTrigger() {
		return ccsl4CometaComplexTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCCSL4CometaComplexTrigger_TrueTriggers() {
		return (EAttribute)ccsl4CometaComplexTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCCSL4CometaComplexTrigger_FalseTriggers() {
		return (EAttribute)ccsl4CometaComplexTriggerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSL4CometaCometaSystemSpecification() {
		return ccsl4CometaCometaSystemSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCCSL4CometaCometaSystemSpecification_CcslLib() {
		return (EReference)ccsl4CometaCometaSystemSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSL4CometaGuard() {
		return ccsl4CometaGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSL4CometaAction() {
		return ccsl4CometaActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ccsl4cometaspecialisationFactory getCcsl4cometaspecialisationFactory() {
		return (Ccsl4cometaspecialisationFactory)getEFactoryInstance();
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
		ccsl4CometaClockEClass = createEClass(CCSL4_COMETA_CLOCK);

		ccsl4CometaBlockAbstractionEClass = createEClass(CCSL4_COMETA_BLOCK_ABSTRACTION);

		ccsl4CometaTimeConstraintEClass = createEClass(CCSL4_COMETA_TIME_CONSTRAINT);

		ccsl4CometaComplexTriggerEClass = createEClass(CCSL4_COMETA_COMPLEX_TRIGGER);
		createEAttribute(ccsl4CometaComplexTriggerEClass, CCSL4_COMETA_COMPLEX_TRIGGER__TRUE_TRIGGERS);
		createEAttribute(ccsl4CometaComplexTriggerEClass, CCSL4_COMETA_COMPLEX_TRIGGER__FALSE_TRIGGERS);

		ccsl4CometaCometaSystemSpecificationEClass = createEClass(CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION);
		createEReference(ccsl4CometaCometaSystemSpecificationEClass, CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB);

		ccsl4CometaGuardEClass = createEClass(CCSL4_COMETA_GUARD);

		ccsl4CometaActionEClass = createEClass(CCSL4_COMETA_ACTION);
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
		CometatimePackage theCometatimePackage = (CometatimePackage)EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI);
		CometamocPackage theCometamocPackage = (CometamocPackage)EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI);
		FsmdefinitionPackage theFsmdefinitionPackage = (FsmdefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI);
		CometaPackage theCometaPackage = (CometaPackage)EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI);
		ClockExpressionAndRelationPackage theClockExpressionAndRelationPackage = (ClockExpressionAndRelationPackage)EPackage.Registry.INSTANCE.getEPackage(ClockExpressionAndRelationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		ccsl4CometaClockEClass.getESuperTypes().add(theCometatimePackage.getClockAbstraction());
		ccsl4CometaBlockAbstractionEClass.getESuperTypes().add(theCometamocPackage.getOpaqueBlock());
		ccsl4CometaTimeConstraintEClass.getESuperTypes().add(theCometatimePackage.getTimeConstraint());
		ccsl4CometaComplexTriggerEClass.getESuperTypes().add(theFsmdefinitionPackage.getTrigger());
		ccsl4CometaCometaSystemSpecificationEClass.getESuperTypes().add(theCometaPackage.getCometaSystemSpecification());
		ccsl4CometaGuardEClass.getESuperTypes().add(theCometamocPackage.getCometaGuard());
		ccsl4CometaActionEClass.getESuperTypes().add(theCometamocPackage.getCometaAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(ccsl4CometaClockEClass, CCSL4CometaClock.class, "CCSL4CometaClock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ccsl4CometaBlockAbstractionEClass, CCSL4CometaBlockAbstraction.class, "CCSL4CometaBlockAbstraction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ccsl4CometaTimeConstraintEClass, CCSL4CometaTimeConstraint.class, "CCSL4CometaTimeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ccsl4CometaComplexTriggerEClass, CCSL4CometaComplexTrigger.class, "CCSL4CometaComplexTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCCSL4CometaComplexTrigger_TrueTriggers(), ecorePackage.getEString(), "trueTriggers", null, 0, -1, CCSL4CometaComplexTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCCSL4CometaComplexTrigger_FalseTriggers(), ecorePackage.getEString(), "falseTriggers", null, 0, -1, CCSL4CometaComplexTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ccsl4CometaCometaSystemSpecificationEClass, CCSL4CometaCometaSystemSpecification.class, "CCSL4CometaCometaSystemSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCCSL4CometaCometaSystemSpecification_CcslLib(), theClockExpressionAndRelationPackage.getLibrary(), null, "ccslLib", null, 0, 1, CCSL4CometaCometaSystemSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ccsl4CometaGuardEClass, CCSL4CometaGuard.class, "CCSL4CometaGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ccsl4CometaActionEClass, CCSL4CometaAction.class, "CCSL4CometaAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //Ccsl4cometaspecialisationPackageImpl
