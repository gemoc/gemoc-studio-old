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
package org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Ack;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimeFactory;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.InterfaceKind;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Receive;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Send;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Service;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CometatimePackageImpl extends EPackageImpl implements CometatimePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clockAbstractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexEventDefinitionAbstractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sendEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass receiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rtInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum interfaceKindEEnum = null;

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
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CometatimePackageImpl() {
		super(eNS_URI, CometatimeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CometatimePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CometatimePackage init() {
		if (isInited) return (CometatimePackage)EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI);

		// Obtain or create and register package
		CometatimePackageImpl theCometatimePackage = (CometatimePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CometatimePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CometatimePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CometaPackageImpl theCometaPackage = (CometaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) instanceof CometaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) : CometaPackage.eINSTANCE);
		CometadatatypePackageImpl theCometadatatypePackage = (CometadatatypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) instanceof CometadatatypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) : CometadatatypePackage.eINSTANCE);
		CometamocPackageImpl theCometamocPackage = (CometamocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) instanceof CometamocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI) : CometamocPackage.eINSTANCE);
		CometastructurePackageImpl theCometastructurePackage = (CometastructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) instanceof CometastructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) : CometastructurePackage.eINSTANCE);
		Ccsl4cometaspecialisationPackageImpl theCcsl4cometaspecialisationPackage = (Ccsl4cometaspecialisationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) instanceof Ccsl4cometaspecialisationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) : Ccsl4cometaspecialisationPackage.eINSTANCE);
		CcslmocPackageImpl theCcslmocPackage = (CcslmocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) instanceof CcslmocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) : CcslmocPackage.eINSTANCE);
		FsmdefinitionPackageImpl theFsmdefinitionPackage = (FsmdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) instanceof FsmdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) : FsmdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theCometatimePackage.createPackageContents();
		theCometaPackage.createPackageContents();
		theCometadatatypePackage.createPackageContents();
		theCometamocPackage.createPackageContents();
		theCometastructurePackage.createPackageContents();
		theCcsl4cometaspecialisationPackage.createPackageContents();
		theCcslmocPackage.createPackageContents();
		theFsmdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theCometatimePackage.initializePackageContents();
		theCometaPackage.initializePackageContents();
		theCometadatatypePackage.initializePackageContents();
		theCometamocPackage.initializePackageContents();
		theCometastructurePackage.initializePackageContents();
		theCcsl4cometaspecialisationPackage.initializePackageContents();
		theCcslmocPackage.initializePackageContents();
		theFsmdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCometatimePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CometatimePackage.eNS_URI, theCometatimePackage);
		return theCometatimePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeLibrary() {
		return timeLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeLibrary_Clocks() {
		return (EReference)timeLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeLibrary_GlobalTimeConstraints() {
		return (EReference)timeLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeConstraint() {
		return timeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTimeConstraint_Uses() {
		return (EReference)timeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClockAbstraction() {
		return clockAbstractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClockAbstraction_IsReferedInConstraints() {
		return (EReference)clockAbstractionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClockAbstraction_IsReferedbyEvents() {
		return (EReference)clockAbstractionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClockAbstraction_IsReferedbyTrigger() {
		return (EReference)clockAbstractionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexEventDefinitionAbstraction() {
		return complexEventDefinitionAbstractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexEventDefinitionAbstraction_Uses() {
		return (EReference)complexEventDefinitionAbstractionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_ParameterType() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Value() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_EventParameters() {
		return (EReference)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Uses() {
		return (EReference)eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Parameters() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSend() {
		return sendEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReceive() {
		return receiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAck() {
		return ackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_Kind() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCInterface() {
		return moCInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRTInterface() {
		return rtInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInterfaceKind() {
		return interfaceKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometatimeFactory getCometatimeFactory() {
		return (CometatimeFactory)getEFactoryInstance();
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
		timeLibraryEClass = createEClass(TIME_LIBRARY);
		createEReference(timeLibraryEClass, TIME_LIBRARY__CLOCKS);
		createEReference(timeLibraryEClass, TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS);

		timeConstraintEClass = createEClass(TIME_CONSTRAINT);
		createEReference(timeConstraintEClass, TIME_CONSTRAINT__USES);

		clockAbstractionEClass = createEClass(CLOCK_ABSTRACTION);
		createEReference(clockAbstractionEClass, CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS);
		createEReference(clockAbstractionEClass, CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS);
		createEReference(clockAbstractionEClass, CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER);

		complexEventDefinitionAbstractionEClass = createEClass(COMPLEX_EVENT_DEFINITION_ABSTRACTION);
		createEReference(complexEventDefinitionAbstractionEClass, COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__PARAMETER_TYPE);
		createEReference(parameterEClass, PARAMETER__VALUE);

		eventEClass = createEClass(EVENT);
		createEReference(eventEClass, EVENT__EVENT_PARAMETERS);
		createEReference(eventEClass, EVENT__USES);

		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__PARAMETERS);

		sendEClass = createEClass(SEND);

		receiveEClass = createEClass(RECEIVE);

		ackEClass = createEClass(ACK);

		interfaceEClass = createEClass(INTERFACE);
		createEAttribute(interfaceEClass, INTERFACE__KIND);

		moCInterfaceEClass = createEClass(MO_CINTERFACE);

		rtInterfaceEClass = createEClass(RT_INTERFACE);

		// Create enums
		interfaceKindEEnum = createEEnum(INTERFACE_KIND);
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
		CometadatatypePackage theCometadatatypePackage = (CometadatatypePackage)EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI);
		CometamocPackage theCometamocPackage = (CometamocPackage)EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		timeLibraryEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		timeConstraintEClass.getESuperTypes().add(theCometaPackage.getElementAbstraction());
		clockAbstractionEClass.getESuperTypes().add(theCometaPackage.getElementAbstraction());
		complexEventDefinitionAbstractionEClass.getESuperTypes().add(theCometaPackage.getElementAbstraction());
		parameterEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		parameterEClass.getESuperTypes().add(this.getRTInterface());
		serviceEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		serviceEClass.getESuperTypes().add(this.getRTInterface());
		sendEClass.getESuperTypes().add(this.getMoCInterface());
		sendEClass.getESuperTypes().add(this.getEvent());
		receiveEClass.getESuperTypes().add(this.getMoCInterface());
		receiveEClass.getESuperTypes().add(this.getEvent());
		ackEClass.getESuperTypes().add(this.getMoCInterface());
		ackEClass.getESuperTypes().add(this.getEvent());
		interfaceEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		moCInterfaceEClass.getESuperTypes().add(this.getInterface());
		rtInterfaceEClass.getESuperTypes().add(this.getInterface());

		// Initialize classes, features, and operations; add parameters
		initEClass(timeLibraryEClass, TimeLibrary.class, "TimeLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeLibrary_Clocks(), this.getClockAbstraction(), null, "clocks", null, 0, -1, TimeLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimeLibrary_GlobalTimeConstraints(), this.getTimeConstraint(), null, "globalTimeConstraints", null, 0, -1, TimeLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeConstraintEClass, TimeConstraint.class, "TimeConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeConstraint_Uses(), this.getClockAbstraction(), this.getClockAbstraction_IsReferedInConstraints(), "uses", null, 0, -1, TimeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clockAbstractionEClass, ClockAbstraction.class, "ClockAbstraction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClockAbstraction_IsReferedInConstraints(), this.getTimeConstraint(), this.getTimeConstraint_Uses(), "isReferedInConstraints", null, 0, -1, ClockAbstraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClockAbstraction_IsReferedbyEvents(), this.getEvent(), this.getEvent_Uses(), "isReferedbyEvents", null, 0, -1, ClockAbstraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClockAbstraction_IsReferedbyTrigger(), this.getComplexEventDefinitionAbstraction(), this.getComplexEventDefinitionAbstraction_Uses(), "isReferedbyTrigger", null, 0, -1, ClockAbstraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexEventDefinitionAbstractionEClass, ComplexEventDefinitionAbstraction.class, "ComplexEventDefinitionAbstraction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexEventDefinitionAbstraction_Uses(), this.getClockAbstraction(), this.getClockAbstraction_IsReferedbyTrigger(), "uses", null, 0, -1, ComplexEventDefinitionAbstraction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_ParameterType(), theCometadatatypePackage.getTypeDeclaration(), null, "parameterType", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_Value(), theCometamocPackage.getOpaqueBlock(), null, "value", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvent_EventParameters(), this.getParameter(), null, "eventParameters", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Uses(), this.getClockAbstraction(), this.getClockAbstraction_IsReferedbyEvents(), "uses", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sendEClass, Send.class, "Send", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(receiveEClass, Receive.class, "Receive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ackEClass, Ack.class, "Ack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(interfaceEClass, Interface.class, "Interface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterface_Kind(), this.getInterfaceKind(), "kind", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moCInterfaceEClass, MoCInterface.class, "MoCInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rtInterfaceEClass, RTInterface.class, "RTInterface", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(interfaceKindEEnum, InterfaceKind.class, "InterfaceKind");
		addEEnumLiteral(interfaceKindEEnum, InterfaceKind.PROVIDED);
		addEEnumLiteral(interfaceKindEEnum, InterfaceKind.REQUIRED);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (timeConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });		
		addAnnotation
		  (clockAbstractionEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });		
		addAnnotation
		  (complexEventDefinitionAbstractionEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });			
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });		
		addAnnotation
		  (eventEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });			
		addAnnotation
		  (serviceEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });			
		addAnnotation
		  (sendEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });			
		addAnnotation
		  (receiveEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });			
		addAnnotation
		  (ackEClass, 
		   source, 
		   new String[] {
			 "name", "TimeLibrary"
		   });	
	}

} //CometatimePackageImpl
