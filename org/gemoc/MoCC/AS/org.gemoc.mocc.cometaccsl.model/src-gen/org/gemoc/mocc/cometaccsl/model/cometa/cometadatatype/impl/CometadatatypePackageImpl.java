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
package org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypeFactory;
import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.DataTypeLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.TypeDeclaration;

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
public class CometadatatypePackageImpl extends EPackageImpl implements CometadatatypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeLibraryEClass = null;

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
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CometadatatypePackageImpl() {
		super(eNS_URI, CometadatatypeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CometadatatypePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CometadatatypePackage init() {
		if (isInited) return (CometadatatypePackage)EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI);

		// Obtain or create and register package
		CometadatatypePackageImpl theCometadatatypePackage = (CometadatatypePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CometadatatypePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CometadatatypePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CometaPackageImpl theCometaPackage = (CometaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) instanceof CometaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) : CometaPackage.eINSTANCE);
		CometamocPackageImpl theCometamocPackage = (CometamocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) instanceof CometamocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) : CometamocPackage.eINSTANCE);
		CometastructurePackageImpl theCometastructurePackage = (CometastructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) instanceof CometastructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) : CometastructurePackage.eINSTANCE);
		CometatimePackageImpl theCometatimePackage = (CometatimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) instanceof CometatimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) : CometatimePackage.eINSTANCE);
		Ccsl4cometaspecialisationPackageImpl theCcsl4cometaspecialisationPackage = (Ccsl4cometaspecialisationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) instanceof Ccsl4cometaspecialisationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) : Ccsl4cometaspecialisationPackage.eINSTANCE);
		CcslmocPackageImpl theCcslmocPackage = (CcslmocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) instanceof CcslmocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) : CcslmocPackage.eINSTANCE);
		FsmdefinitionPackageImpl theFsmdefinitionPackage = (FsmdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) instanceof FsmdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) : FsmdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theCometadatatypePackage.createPackageContents();
		theCometaPackage.createPackageContents();
		theCometamocPackage.createPackageContents();
		theCometastructurePackage.createPackageContents();
		theCometatimePackage.createPackageContents();
		theCcsl4cometaspecialisationPackage.createPackageContents();
		theCcslmocPackage.createPackageContents();
		theFsmdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theCometadatatypePackage.initializePackageContents();
		theCometaPackage.initializePackageContents();
		theCometamocPackage.initializePackageContents();
		theCometastructurePackage.initializePackageContents();
		theCometatimePackage.initializePackageContents();
		theCcsl4cometaspecialisationPackage.initializePackageContents();
		theCcslmocPackage.initializePackageContents();
		theFsmdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCometadatatypePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CometadatatypePackage.eNS_URI, theCometadatatypePackage);
		return theCometadatatypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeDeclaration() {
		return typeDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeLibrary() {
		return dataTypeLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTypeLibrary_Typedef() {
		return (EReference)dataTypeLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometadatatypeFactory getCometadatatypeFactory() {
		return (CometadatatypeFactory)getEFactoryInstance();
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
		typeDeclarationEClass = createEClass(TYPE_DECLARATION);

		dataTypeLibraryEClass = createEClass(DATA_TYPE_LIBRARY);
		createEReference(dataTypeLibraryEClass, DATA_TYPE_LIBRARY__TYPEDEF);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		typeDeclarationEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		dataTypeLibraryEClass.getESuperTypes().add(theCometaPackage.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(typeDeclarationEClass, TypeDeclaration.class, "TypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeLibraryEClass, DataTypeLibrary.class, "DataTypeLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataTypeLibrary_Typedef(), this.getTypeDeclaration(), null, "typedef", null, 0, -1, DataTypeLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //CometadatatypePackageImpl
