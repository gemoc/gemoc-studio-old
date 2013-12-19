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

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.BasicTypePackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.CCSLModelPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.KernelExpression.KernelExpressionPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.KernelRelation.KernelRelationPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.PrimitivesTypeValue.PrimitivesTypeValuePackage;



import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaFactory;
import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification;
import org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification;
import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CometaPackageImpl extends EPackageImpl implements CometaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCSystemSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cometaSystemSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementAbstractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCLibraryEClass = null;

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
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CometaPackageImpl() {
		super(eNS_URI, CometaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CometaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated NOT
	 */
	public static CometaPackage init() {
		if (isInited) return (CometaPackage)EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI);

		// Obtain or create and register package
		CometaPackageImpl theCometaPackage = (CometaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CometaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CometaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();
		BasicTypePackage.eINSTANCE.eClass();
		CCSLModelPackage.eINSTANCE.eClass();
		ClassicalExpressionPackage.eINSTANCE.eClass();
		ClockExpressionAndRelationPackage.eINSTANCE.eClass();
		KernelExpressionPackage.eINSTANCE.eClass();
		KernelRelationPackage.eINSTANCE.eClass();
		PrimitivesTypeValuePackage.eINSTANCE.eClass();

		

		// Obtain or create and register interdependencies
		CometadatatypePackageImpl theCometadatatypePackage = (CometadatatypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) instanceof CometadatatypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) : CometadatatypePackage.eINSTANCE);
		CometamocPackageImpl theCometamocPackage = (CometamocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) instanceof CometamocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) : CometamocPackage.eINSTANCE);
		CometastructurePackageImpl theCometastructurePackage = (CometastructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) instanceof CometastructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) : CometastructurePackage.eINSTANCE);
		CometatimePackageImpl theCometatimePackage = (CometatimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) instanceof CometatimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) : CometatimePackage.eINSTANCE);
		Ccsl4cometaspecialisationPackageImpl theCcsl4cometaspecialisationPackage = (Ccsl4cometaspecialisationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) instanceof Ccsl4cometaspecialisationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) : Ccsl4cometaspecialisationPackage.eINSTANCE);
		CcslmocPackageImpl theCcslmocPackage = (CcslmocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) instanceof CcslmocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) : CcslmocPackage.eINSTANCE);
		FsmdefinitionPackageImpl theFsmdefinitionPackage = (FsmdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) instanceof FsmdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) : FsmdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theCometaPackage.createPackageContents();
		theCometadatatypePackage.createPackageContents();
		theCometamocPackage.createPackageContents();
		theCometastructurePackage.createPackageContents();
		theCometatimePackage.createPackageContents();
		theCcsl4cometaspecialisationPackage.createPackageContents();
		theCcslmocPackage.createPackageContents();
		theFsmdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theCometaPackage.initializePackageContents();
		theCometadatatypePackage.initializePackageContents();
		theCometamocPackage.initializePackageContents();
		theCometastructurePackage.initializePackageContents();
		theCometatimePackage.initializePackageContents();
		theCcsl4cometaspecialisationPackage.initializePackageContents();
		theCcslmocPackage.initializePackageContents();
		theFsmdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCometaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CometaPackage.eNS_URI, theCometaPackage);
		EPackage.Registry.INSTANCE.put(TimeModelPackage.eNS_URI, TimeModelPackage.eINSTANCE);
		return theCometaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCSystemSpecification() {
		return moCSystemSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoCSystemSpecification_MocLib() {
		return (EReference)moCSystemSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCometaSystemSpecification() {
		return cometaSystemSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCometaSystemSpecification_DataLib() {
		return (EReference)cometaSystemSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCometaSystemSpecification_StructureLib() {
		return (EReference)cometaSystemSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCometaSystemSpecification_TimeLib() {
		return (EReference)cometaSystemSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Version() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Definition() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementAbstraction() {
		return elementAbstractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementAbstraction_Content() {
		return (EAttribute)elementAbstractionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCLibrary() {
		return moCLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometaFactory getCometaFactory() {
		return (CometaFactory)getEFactoryInstance();
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
		moCSystemSpecificationEClass = createEClass(MO_CSYSTEM_SPECIFICATION);
		createEReference(moCSystemSpecificationEClass, MO_CSYSTEM_SPECIFICATION__MOC_LIB);

		cometaSystemSpecificationEClass = createEClass(COMETA_SYSTEM_SPECIFICATION);
		createEReference(cometaSystemSpecificationEClass, COMETA_SYSTEM_SPECIFICATION__DATA_LIB);
		createEReference(cometaSystemSpecificationEClass, COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB);
		createEReference(cometaSystemSpecificationEClass, COMETA_SYSTEM_SPECIFICATION__TIME_LIB);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__VERSION);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__DEFINITION);

		elementAbstractionEClass = createEClass(ELEMENT_ABSTRACTION);
		createEAttribute(elementAbstractionEClass, ELEMENT_ABSTRACTION__CONTENT);

		moCLibraryEClass = createEClass(MO_CLIBRARY);
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
		CometadatatypePackage theCometadatatypePackage = (CometadatatypePackage)EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI);
		CometamocPackage theCometamocPackage = (CometamocPackage)EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI);
		CometastructurePackage theCometastructurePackage = (CometastructurePackage)EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI);
		CometatimePackage theCometatimePackage = (CometatimePackage)EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI);
		Ccsl4cometaspecialisationPackage theCcsl4cometaspecialisationPackage = (Ccsl4cometaspecialisationPackage)EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI);
		CcslmocPackage theCcslmocPackage = (CcslmocPackage)EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI);
		FsmdefinitionPackage theFsmdefinitionPackage = (FsmdefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCometadatatypePackage);
		getESubpackages().add(theCometamocPackage);
		getESubpackages().add(theCometastructurePackage);
		getESubpackages().add(theCometatimePackage);
		getESubpackages().add(theCcsl4cometaspecialisationPackage);
		getESubpackages().add(theCcslmocPackage);
		getESubpackages().add(theFsmdefinitionPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cometaSystemSpecificationEClass.getESuperTypes().add(this.getMoCSystemSpecification());

		// Initialize classes, features, and operations; add parameters
		initEClass(moCSystemSpecificationEClass, MoCSystemSpecification.class, "MoCSystemSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMoCSystemSpecification_MocLib(), this.getMoCLibrary(), null, "mocLib", null, 0, 1, MoCSystemSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cometaSystemSpecificationEClass, CometaSystemSpecification.class, "CometaSystemSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCometaSystemSpecification_DataLib(), theCometadatatypePackage.getDataTypeLibrary(), null, "dataLib", null, 0, 1, CometaSystemSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCometaSystemSpecification_StructureLib(), theCometastructurePackage.getStructureLibrary(), null, "structureLib", null, 0, 1, CometaSystemSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCometaSystemSpecification_TimeLib(), theCometatimePackage.getTimeLibrary(), null, "timeLib", null, 0, 1, CometaSystemSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Version(), ecorePackage.getEString(), "version", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Definition(), ecorePackage.getEString(), "definition", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementAbstractionEClass, ElementAbstraction.class, "ElementAbstraction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementAbstraction_Content(), ecorePackage.getEString(), "content", null, 1, 1, ElementAbstraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moCLibraryEClass, MoCLibrary.class, "MoCLibrary", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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

} //CometaPackageImpl
