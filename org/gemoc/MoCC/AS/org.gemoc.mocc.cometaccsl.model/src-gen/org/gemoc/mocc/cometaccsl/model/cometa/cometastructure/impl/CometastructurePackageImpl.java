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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypePackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.CometadatatypePackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructureFactory;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.util.CometastructureValidator;

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
public class CometastructurePackageImpl extends EPackageImpl implements CometastructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structureLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum portKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum moCConnectorKindEEnum = null;

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
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CometastructurePackageImpl() {
		super(eNS_URI, CometastructureFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CometastructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CometastructurePackage init() {
		if (isInited) return (CometastructurePackage)EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI);

		// Obtain or create and register package
		CometastructurePackageImpl theCometastructurePackage = (CometastructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CometastructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CometastructurePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CometaPackageImpl theCometaPackage = (CometaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) instanceof CometaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) : CometaPackage.eINSTANCE);
		CometadatatypePackageImpl theCometadatatypePackage = (CometadatatypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) instanceof CometadatatypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) : CometadatatypePackage.eINSTANCE);
		CometamocPackageImpl theCometamocPackage = (CometamocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) instanceof CometamocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) : CometamocPackage.eINSTANCE);
		CometatimePackageImpl theCometatimePackage = (CometatimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) instanceof CometatimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) : CometatimePackage.eINSTANCE);
		Ccsl4cometaspecialisationPackageImpl theCcsl4cometaspecialisationPackage = (Ccsl4cometaspecialisationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) instanceof Ccsl4cometaspecialisationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) : Ccsl4cometaspecialisationPackage.eINSTANCE);
		CcslmocPackageImpl theCcslmocPackage = (CcslmocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) instanceof CcslmocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) : CcslmocPackage.eINSTANCE);
		FsmdefinitionPackageImpl theFsmdefinitionPackage = (FsmdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) instanceof FsmdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) : FsmdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theCometastructurePackage.createPackageContents();
		theCometaPackage.createPackageContents();
		theCometadatatypePackage.createPackageContents();
		theCometamocPackage.createPackageContents();
		theCometatimePackage.createPackageContents();
		theCcsl4cometaspecialisationPackage.createPackageContents();
		theCcslmocPackage.createPackageContents();
		theFsmdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theCometastructurePackage.initializePackageContents();
		theCometaPackage.initializePackageContents();
		theCometadatatypePackage.initializePackageContents();
		theCometamocPackage.initializePackageContents();
		theCometatimePackage.initializePackageContents();
		theCcsl4cometaspecialisationPackage.initializePackageContents();
		theCcslmocPackage.initializePackageContents();
		theFsmdefinitionPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theCometastructurePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return CometastructureValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theCometastructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CometastructurePackage.eNS_URI, theCometastructurePackage);
		return theCometastructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureContainer() {
		return structureContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureContainer_ConnectorInstances() {
		return (EReference)structureContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureContainer_ComponentInstances() {
		return (EReference)structureContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureContainer_PortInstances() {
		return (EReference)structureContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCConnector() {
		return moCConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoCConnector_Source() {
		return (EReference)moCConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoCConnector_Target() {
		return (EReference)moCConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMoCConnector_Kind() {
		return (EAttribute)moCConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCComponent() {
		return moCComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoCComponent_OwnedPortInstances() {
		return (EReference)moCComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCPort() {
		return moCPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMoCPort_Direction() {
		return (EAttribute)moCPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoCPort_Target() {
		return (EReference)moCPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoCPort_PortInterfaces() {
		return (EReference)moCPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureElement() {
		return structureElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureElement_BehaviorMap() {
		return (EReference)structureElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureElement_MocDomain() {
		return (EReference)structureElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureElement_Parameters() {
		return (EReference)structureElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainer() {
		return containerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_Parts() {
		return (EReference)containerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeComponent() {
		return compositeComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeComponent_Connectors() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeComponent_SubComponents() {
		return (EReference)compositeComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicComponent() {
		return basicComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicComponent_Computation() {
		return (EReference)basicComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructureLibrary() {
		return structureLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureLibrary_MocStructures() {
		return (EReference)structureLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructureLibrary_MocInterfaces() {
		return (EReference)structureLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPart() {
		return partEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPart_ComponentType() {
		return (EReference)partEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPart_Ports() {
		return (EReference)partEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPart_Container() {
		return (EReference)partEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPortKind() {
		return portKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMoCConnectorKind() {
		return moCConnectorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometastructureFactory getCometastructureFactory() {
		return (CometastructureFactory)getEFactoryInstance();
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
		structureContainerEClass = createEClass(STRUCTURE_CONTAINER);
		createEReference(structureContainerEClass, STRUCTURE_CONTAINER__CONNECTOR_INSTANCES);
		createEReference(structureContainerEClass, STRUCTURE_CONTAINER__COMPONENT_INSTANCES);
		createEReference(structureContainerEClass, STRUCTURE_CONTAINER__PORT_INSTANCES);

		moCConnectorEClass = createEClass(MO_CCONNECTOR);
		createEReference(moCConnectorEClass, MO_CCONNECTOR__SOURCE);
		createEReference(moCConnectorEClass, MO_CCONNECTOR__TARGET);
		createEAttribute(moCConnectorEClass, MO_CCONNECTOR__KIND);

		moCComponentEClass = createEClass(MO_CCOMPONENT);
		createEReference(moCComponentEClass, MO_CCOMPONENT__OWNED_PORT_INSTANCES);

		moCPortEClass = createEClass(MO_CPORT);
		createEAttribute(moCPortEClass, MO_CPORT__DIRECTION);
		createEReference(moCPortEClass, MO_CPORT__TARGET);
		createEReference(moCPortEClass, MO_CPORT__PORT_INTERFACES);

		structureElementEClass = createEClass(STRUCTURE_ELEMENT);
		createEReference(structureElementEClass, STRUCTURE_ELEMENT__BEHAVIOR_MAP);
		createEReference(structureElementEClass, STRUCTURE_ELEMENT__MOC_DOMAIN);
		createEReference(structureElementEClass, STRUCTURE_ELEMENT__PARAMETERS);

		containerEClass = createEClass(CONTAINER);
		createEReference(containerEClass, CONTAINER__PARTS);

		compositeComponentEClass = createEClass(COMPOSITE_COMPONENT);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__CONNECTORS);
		createEReference(compositeComponentEClass, COMPOSITE_COMPONENT__SUB_COMPONENTS);

		basicComponentEClass = createEClass(BASIC_COMPONENT);
		createEReference(basicComponentEClass, BASIC_COMPONENT__COMPUTATION);

		structureLibraryEClass = createEClass(STRUCTURE_LIBRARY);
		createEReference(structureLibraryEClass, STRUCTURE_LIBRARY__MOC_STRUCTURES);
		createEReference(structureLibraryEClass, STRUCTURE_LIBRARY__MOC_INTERFACES);

		partEClass = createEClass(PART);
		createEReference(partEClass, PART__COMPONENT_TYPE);
		createEReference(partEClass, PART__PORTS);
		createEReference(partEClass, PART__CONTAINER);

		// Create enums
		portKindEEnum = createEEnum(PORT_KIND);
		moCConnectorKindEEnum = createEEnum(MO_CCONNECTOR_KIND);
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
		CometatimePackage theCometatimePackage = (CometatimePackage)EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI);
		CometamocPackage theCometamocPackage = (CometamocPackage)EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		structureContainerEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		structureContainerEClass.getESuperTypes().add(this.getContainer());
		moCConnectorEClass.getESuperTypes().add(this.getStructureElement());
		moCComponentEClass.getESuperTypes().add(this.getStructureElement());
		moCPortEClass.getESuperTypes().add(this.getStructureElement());
		structureElementEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		compositeComponentEClass.getESuperTypes().add(this.getMoCComponent());
		compositeComponentEClass.getESuperTypes().add(this.getContainer());
		basicComponentEClass.getESuperTypes().add(this.getMoCComponent());
		structureLibraryEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		partEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		partEClass.getESuperTypes().add(this.getContainer());

		// Initialize classes, features, and operations; add parameters
		initEClass(structureContainerEClass, StructureContainer.class, "StructureContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureContainer_ConnectorInstances(), this.getMoCConnector(), null, "connectorInstances", null, 0, -1, StructureContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureContainer_ComponentInstances(), this.getMoCComponent(), null, "componentInstances", null, 0, -1, StructureContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureContainer_PortInstances(), this.getMoCPort(), null, "portInstances", null, 0, -1, StructureContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moCConnectorEClass, MoCConnector.class, "MoCConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMoCConnector_Source(), this.getMoCPort(), null, "source", null, 1, 1, MoCConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMoCConnector_Target(), this.getMoCPort(), null, "target", null, 1, 1, MoCConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMoCConnector_Kind(), this.getMoCConnectorKind(), "kind", null, 1, 1, MoCConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moCComponentEClass, MoCComponent.class, "MoCComponent", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMoCComponent_OwnedPortInstances(), this.getMoCPort(), null, "ownedPortInstances", null, 0, -1, MoCComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moCPortEClass, MoCPort.class, "MoCPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMoCPort_Direction(), this.getPortKind(), "direction", null, 1, 1, MoCPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMoCPort_Target(), this.getMoCPort(), null, "target", null, 0, 1, MoCPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMoCPort_PortInterfaces(), theCometatimePackage.getMoCInterface(), null, "portInterfaces", null, 1, 2, MoCPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureElementEClass, StructureElement.class, "StructureElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureElement_BehaviorMap(), theCometamocPackage.getBehavior(), null, "behaviorMap", null, 0, 1, StructureElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureElement_MocDomain(), theCometamocPackage.getMoCDomain(), null, "mocDomain", null, 0, 1, StructureElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getStructureElement_Parameters(), theCometatimePackage.getParameter(), null, "parameters", null, 0, -1, StructureElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerEClass, org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container.class, "Container", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_Parts(), this.getPart(), this.getPart_Container(), "parts", null, 0, -1, org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeComponentEClass, CompositeComponent.class, "CompositeComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeComponent_Connectors(), this.getMoCConnector(), null, "connectors", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeComponent_SubComponents(), this.getMoCComponent(), null, "subComponents", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicComponentEClass, BasicComponent.class, "BasicComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicComponent_Computation(), theCometamocPackage.getOpaqueBlock(), null, "computation", null, 0, 1, BasicComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureLibraryEClass, StructureLibrary.class, "StructureLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructureLibrary_MocStructures(), this.getStructureContainer(), null, "mocStructures", null, 0, -1, StructureLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructureLibrary_MocInterfaces(), theCometatimePackage.getMoCInterface(), null, "mocInterfaces", null, 0, -1, StructureLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partEClass, Part.class, "Part", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPart_ComponentType(), this.getMoCComponent(), null, "componentType", null, 1, 1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPart_Ports(), this.getMoCPort(), null, "ports", null, 0, -1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPart_Container(), this.getContainer(), this.getContainer_Parts(), "container", null, 0, 1, Part.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(portKindEEnum, PortKind.class, "PortKind");
		addEEnumLiteral(portKindEEnum, PortKind.IN);
		addEEnumLiteral(portKindEEnum, PortKind.OUT);

		initEEnum(moCConnectorKindEEnum, MoCConnectorKind.class, "MoCConnectorKind");
		addEEnumLiteral(moCConnectorKindEEnum, MoCConnectorKind.DELEGATION);
		addEEnumLiteral(moCConnectorKindEEnum, MoCConnectorKind.ASSEMBLY);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
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
		addAnnotation
		  (partEClass, 
		   source, 
		   new String[] {
			 "constraints", "PartHasSameNumberOfPortsThanItsComponent EachPortIsDefinedInComponent NoRedondancyInPortsNames"
		   });	
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";								
		addAnnotation
		  (getStructureElement_MocDomain(), 
		   source, 
		   new String[] {
			 "derivation", "(MoCDomain)((StructureElement)self.eContainer()).behaviorMap().eContainer()"
		   });							
		addAnnotation
		  (partEClass, 
		   source, 
		   new String[] {
			 "PartHasSameNumberOfPortsThanItsComponent", "ports->size()=componentType.ownedPortInstances->size()",
			 "EachPortIsDefinedInComponent", "ports->forAll(self.componentType.ownedPortInstances->collect(name)->includes(name))",
			 "NoRedondancyInPortsNames", "self.ports->forAll(p1, p2 | p1<>p2 implies p1.name<>p2.name)"
		   });
	}

} //CometastructurePackageImpl
