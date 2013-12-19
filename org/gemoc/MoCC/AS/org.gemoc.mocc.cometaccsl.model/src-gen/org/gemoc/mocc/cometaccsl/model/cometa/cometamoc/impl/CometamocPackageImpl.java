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
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl;

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

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaAction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaGuard;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocFactory;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.FiniteStateMachineBehavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueKind;

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
public class CometamocPackageImpl extends EPackageImpl implements CometamocPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cometaMoCLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opaqueBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opaqueBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queueInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finiteStateMachineBehaviorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cometaGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cometaActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cometaTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum moCRoleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum queueKindEEnum = null;

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
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CometamocPackageImpl() {
		super(eNS_URI, CometamocFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CometamocPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CometamocPackage init() {
		if (isInited) return (CometamocPackage)EPackage.Registry.INSTANCE.getEPackage(CometamocPackage.eNS_URI);

		// Obtain or create and register package
		CometamocPackageImpl theCometamocPackage = (CometamocPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CometamocPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CometamocPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CometaPackageImpl theCometaPackage = (CometaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) instanceof CometaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI) : CometaPackage.eINSTANCE);
		CometadatatypePackageImpl theCometadatatypePackage = (CometadatatypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) instanceof CometadatatypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometadatatypePackage.eNS_URI) : CometadatatypePackage.eINSTANCE);
		CometastructurePackageImpl theCometastructurePackage = (CometastructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) instanceof CometastructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometastructurePackage.eNS_URI) : CometastructurePackage.eINSTANCE);
		CometatimePackageImpl theCometatimePackage = (CometatimePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) instanceof CometatimePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CometatimePackage.eNS_URI) : CometatimePackage.eINSTANCE);
		Ccsl4cometaspecialisationPackageImpl theCcsl4cometaspecialisationPackage = (Ccsl4cometaspecialisationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) instanceof Ccsl4cometaspecialisationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ccsl4cometaspecialisationPackage.eNS_URI) : Ccsl4cometaspecialisationPackage.eINSTANCE);
		CcslmocPackageImpl theCcslmocPackage = (CcslmocPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) instanceof CcslmocPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CcslmocPackage.eNS_URI) : CcslmocPackage.eINSTANCE);
		FsmdefinitionPackageImpl theFsmdefinitionPackage = (FsmdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) instanceof FsmdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI) : FsmdefinitionPackage.eINSTANCE);

		// Create package meta-data objects
		theCometamocPackage.createPackageContents();
		theCometaPackage.createPackageContents();
		theCometadatatypePackage.createPackageContents();
		theCometastructurePackage.createPackageContents();
		theCometatimePackage.createPackageContents();
		theCcsl4cometaspecialisationPackage.createPackageContents();
		theCcslmocPackage.createPackageContents();
		theFsmdefinitionPackage.createPackageContents();

		// Initialize created meta-data
		theCometamocPackage.initializePackageContents();
		theCometaPackage.initializePackageContents();
		theCometadatatypePackage.initializePackageContents();
		theCometastructurePackage.initializePackageContents();
		theCometatimePackage.initializePackageContents();
		theCcsl4cometaspecialisationPackage.initializePackageContents();
		theCcslmocPackage.initializePackageContents();
		theFsmdefinitionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCometamocPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CometamocPackage.eNS_URI, theCometamocPackage);
		return theCometamocPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueue() {
		return queueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueue_RtInterfaces() {
		return (EReference)queueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueue_Kind() {
		return (EAttribute)queueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueue_Size() {
		return (EAttribute)queueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCometaMoCLibrary() {
		return cometaMoCLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCometaMoCLibrary_MocDomains() {
		return (EReference)cometaMoCLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCometaMoCLibrary_MocEvents() {
		return (EReference)cometaMoCLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCometaMoCLibrary_Queues() {
		return (EReference)cometaMoCLibraryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCDomain() {
		return moCDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoCDomain_MocBehaviors() {
		return (EReference)moCDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMoCDomain_DomainTimeConstraints() {
		return (EReference)moCDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehavior() {
		return behaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBehavior_Roles() {
		return (EAttribute)behaviorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehavior_MocDomain() {
		return (EReference)behaviorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehavior_QueueInstances() {
		return (EReference)behaviorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehavior_RtInterfaces() {
		return (EReference)behaviorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBehavior_BehaviorTimeConstraints() {
		return (EReference)behaviorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpaqueBlock() {
		return opaqueBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOpaqueBlock_RtElements() {
		return (EReference)opaqueBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpaqueBehavior() {
		return opaqueBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOpaqueBehavior_Body() {
		return (EReference)opaqueBehaviorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCEvent() {
		return moCEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueueInstance() {
		return queueInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueueInstance_Type() {
		return (EReference)queueInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFiniteStateMachineBehavior() {
		return finiteStateMachineBehaviorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCometaGuard() {
		return cometaGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCometaAction() {
		return cometaActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCometaTrigger() {
		return cometaTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCometaTrigger_TriggOn() {
		return (EReference)cometaTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMoCRole() {
		return moCRoleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQueueKind() {
		return queueKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometamocFactory getCometamocFactory() {
		return (CometamocFactory)getEFactoryInstance();
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
		queueEClass = createEClass(QUEUE);
		createEReference(queueEClass, QUEUE__RT_INTERFACES);
		createEAttribute(queueEClass, QUEUE__KIND);
		createEAttribute(queueEClass, QUEUE__SIZE);

		cometaMoCLibraryEClass = createEClass(COMETA_MO_CLIBRARY);
		createEReference(cometaMoCLibraryEClass, COMETA_MO_CLIBRARY__MOC_DOMAINS);
		createEReference(cometaMoCLibraryEClass, COMETA_MO_CLIBRARY__MOC_EVENTS);
		createEReference(cometaMoCLibraryEClass, COMETA_MO_CLIBRARY__QUEUES);

		moCDomainEClass = createEClass(MO_CDOMAIN);
		createEReference(moCDomainEClass, MO_CDOMAIN__MOC_BEHAVIORS);
		createEReference(moCDomainEClass, MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS);

		behaviorEClass = createEClass(BEHAVIOR);
		createEAttribute(behaviorEClass, BEHAVIOR__ROLES);
		createEReference(behaviorEClass, BEHAVIOR__MOC_DOMAIN);
		createEReference(behaviorEClass, BEHAVIOR__QUEUE_INSTANCES);
		createEReference(behaviorEClass, BEHAVIOR__RT_INTERFACES);
		createEReference(behaviorEClass, BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS);

		opaqueBlockEClass = createEClass(OPAQUE_BLOCK);
		createEReference(opaqueBlockEClass, OPAQUE_BLOCK__RT_ELEMENTS);

		opaqueBehaviorEClass = createEClass(OPAQUE_BEHAVIOR);
		createEReference(opaqueBehaviorEClass, OPAQUE_BEHAVIOR__BODY);

		moCEventEClass = createEClass(MO_CEVENT);

		queueInstanceEClass = createEClass(QUEUE_INSTANCE);
		createEReference(queueInstanceEClass, QUEUE_INSTANCE__TYPE);

		finiteStateMachineBehaviorEClass = createEClass(FINITE_STATE_MACHINE_BEHAVIOR);

		cometaGuardEClass = createEClass(COMETA_GUARD);

		cometaActionEClass = createEClass(COMETA_ACTION);

		cometaTriggerEClass = createEClass(COMETA_TRIGGER);
		createEReference(cometaTriggerEClass, COMETA_TRIGGER__TRIGG_ON);

		// Create enums
		moCRoleEEnum = createEEnum(MO_CROLE);
		queueKindEEnum = createEEnum(QUEUE_KIND);
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
		CometaPackage theCometaPackage = (CometaPackage)EPackage.Registry.INSTANCE.getEPackage(CometaPackage.eNS_URI);
		FsmdefinitionPackage theFsmdefinitionPackage = (FsmdefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(FsmdefinitionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cometaMoCLibraryEClass.getESuperTypes().add(theCometaPackage.getMoCLibrary());
		cometaMoCLibraryEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		moCDomainEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		behaviorEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		opaqueBlockEClass.getESuperTypes().add(theCometaPackage.getElementAbstraction());
		opaqueBehaviorEClass.getESuperTypes().add(this.getBehavior());
		opaqueBehaviorEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		moCEventEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		moCEventEClass.getESuperTypes().add(theCometatimePackage.getEvent());
		queueInstanceEClass.getESuperTypes().add(theCometaPackage.getNamedElement());
		finiteStateMachineBehaviorEClass.getESuperTypes().add(this.getBehavior());
		finiteStateMachineBehaviorEClass.getESuperTypes().add(theFsmdefinitionPackage.getFiniteStateMachine());
		cometaGuardEClass.getESuperTypes().add(theFsmdefinitionPackage.getGuard());
		cometaGuardEClass.getESuperTypes().add(this.getOpaqueBlock());
		cometaActionEClass.getESuperTypes().add(theFsmdefinitionPackage.getAction());
		cometaActionEClass.getESuperTypes().add(this.getOpaqueBlock());
		cometaTriggerEClass.getESuperTypes().add(theFsmdefinitionPackage.getTrigger());

		// Initialize classes, features, and operations; add parameters
		initEClass(queueEClass, Queue.class, "Queue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueue_RtInterfaces(), theCometatimePackage.getRTInterface(), null, "rtInterfaces", null, 0, -1, Queue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueue_Kind(), this.getQueueKind(), "kind", null, 0, 1, Queue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueue_Size(), ecorePackage.getEString(), "size", null, 0, 1, Queue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cometaMoCLibraryEClass, CometaMoCLibrary.class, "CometaMoCLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCometaMoCLibrary_MocDomains(), this.getMoCDomain(), null, "mocDomains", null, 0, -1, CometaMoCLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCometaMoCLibrary_MocEvents(), this.getMoCEvent(), null, "mocEvents", null, 0, -1, CometaMoCLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCometaMoCLibrary_Queues(), this.getQueue(), null, "queues", null, 0, -1, CometaMoCLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moCDomainEClass, MoCDomain.class, "MoCDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMoCDomain_MocBehaviors(), this.getBehavior(), this.getBehavior_MocDomain(), "mocBehaviors", null, 0, -1, MoCDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMoCDomain_DomainTimeConstraints(), theCometatimePackage.getTimeConstraint(), null, "domainTimeConstraints", null, 0, -1, MoCDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorEClass, Behavior.class, "Behavior", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBehavior_Roles(), this.getMoCRole(), "roles", null, 0, -1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehavior_MocDomain(), this.getMoCDomain(), this.getMoCDomain_MocBehaviors(), "mocDomain", null, 1, 1, Behavior.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getBehavior_QueueInstances(), this.getQueueInstance(), null, "queueInstances", null, 0, -1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehavior_RtInterfaces(), theCometatimePackage.getRTInterface(), null, "rtInterfaces", null, 0, -1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehavior_BehaviorTimeConstraints(), theCometatimePackage.getTimeConstraint(), null, "behaviorTimeConstraints", null, 0, -1, Behavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opaqueBlockEClass, OpaqueBlock.class, "OpaqueBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOpaqueBlock_RtElements(), theCometatimePackage.getRTInterface(), null, "rtElements", null, 0, -1, OpaqueBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(opaqueBehaviorEClass, OpaqueBehavior.class, "OpaqueBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOpaqueBehavior_Body(), this.getOpaqueBlock(), null, "body", null, 1, 1, OpaqueBehavior.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moCEventEClass, MoCEvent.class, "MoCEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(queueInstanceEClass, QueueInstance.class, "QueueInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueueInstance_Type(), this.getQueue(), null, "type", null, 0, 1, QueueInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(finiteStateMachineBehaviorEClass, FiniteStateMachineBehavior.class, "FiniteStateMachineBehavior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cometaGuardEClass, CometaGuard.class, "CometaGuard", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cometaActionEClass, CometaAction.class, "CometaAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cometaTriggerEClass, CometaTrigger.class, "CometaTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCometaTrigger_TriggOn(), theCometatimePackage.getEvent(), null, "triggOn", null, 1, 1, CometaTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(moCRoleEEnum, MoCRole.class, "MoCRole");
		addEEnumLiteral(moCRoleEEnum, MoCRole.ORCHESTRATOR);
		addEEnumLiteral(moCRoleEEnum, MoCRole.PORT_BEHAVIOR);
		addEEnumLiteral(moCRoleEEnum, MoCRole.CONNECTOR_BEHAVIOR);

		initEEnum(queueKindEEnum, QueueKind.class, "QueueKind");
		addEEnumLiteral(queueKindEEnum, QueueKind.FIFO);
		addEEnumLiteral(queueKindEEnum, QueueKind.LIFO);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
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

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";							
		addAnnotation
		  (getBehavior_MocDomain(), 
		   source, 
		   new String[] {
			 "name", "mocDomain"
		   });		
	}

} //CometamocPackageImpl
