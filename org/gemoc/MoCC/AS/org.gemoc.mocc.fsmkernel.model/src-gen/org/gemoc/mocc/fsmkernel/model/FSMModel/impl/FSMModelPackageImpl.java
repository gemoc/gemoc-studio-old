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
package org.gemoc.mocc.fsmkernel.model.FSMModel.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.BasicTypePackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.CCSLModelPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.KernelExpression.KernelExpressionPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.KernelRelation.KernelRelationPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.PrimitivesTypeValue.PrimitivesTypeValuePackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction;
import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractGuard;
import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractTrigger;
import org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock;
import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelFactory;
import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Guard;
import org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.State;
import org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Transition;
import org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FSMModelPackageImpl extends EPackageImpl implements FSMModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMachineDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerEClass = null;

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
	private EClass declarationBlockEClass = null;

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
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FSMModelPackageImpl() {
		super(eNS_URI, FSMModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FSMModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated NOT
	 */
	public static FSMModelPackage init() {
		if (isInited) return (FSMModelPackage)EPackage.Registry.INSTANCE.getEPackage(FSMModelPackage.eNS_URI);

		// Obtain or create and register package
		FSMModelPackageImpl theFSMModelPackage = (FSMModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FSMModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FSMModelPackageImpl());

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
		EditionExtensionPackageImpl theEditionExtensionPackage = (EditionExtensionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditionExtensionPackage.eNS_URI) instanceof EditionExtensionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditionExtensionPackage.eNS_URI) : EditionExtensionPackage.eINSTANCE);

		// Create package meta-data objects
		theFSMModelPackage.createPackageContents();
		theEditionExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theFSMModelPackage.initializePackageContents();
		theEditionExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFSMModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FSMModelPackage.eNS_URI, theFSMModelPackage);
		return theFSMModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_InputTransitions() {
		return (EReference)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_OutputTransitions() {
		return (EReference)stateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_Source() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_Target() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_Guard() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_Trigger() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_Actions() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMachineDefinition() {
		return stateMachineDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineDefinition_DeclarationBlock() {
		return (EReference)stateMachineDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineDefinition_Transitions() {
		return (EReference)stateMachineDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineDefinition_States() {
		return (EReference)stateMachineDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineDefinition_InitialStates() {
		return (EReference)stateMachineDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineDefinition_FinalStates() {
		return (EReference)stateMachineDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractTrigger() {
		return abstractTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractAction() {
		return abstractActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractGuard() {
		return abstractGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuard() {
		return guardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuard_Value() {
		return (EReference)guardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrigger() {
		return triggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrigger_TrueTriggers() {
		return (EReference)triggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrigger_FalseTriggers() {
		return (EReference)triggerEClass.getEStructuralFeatures().get(1);
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
	public EClass getDeclarationBlock() {
		return declarationBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclarationBlock_ConcreteEntities() {
		return (EReference)declarationBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclarationBlock_ClassicalExpressions() {
		return (EReference)declarationBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMModelFactory getFSMModelFactory() {
		return (FSMModelFactory)getEFactoryInstance();
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
		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__INPUT_TRANSITIONS);
		createEReference(stateEClass, STATE__OUTPUT_TRANSITIONS);

		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__SOURCE);
		createEReference(transitionEClass, TRANSITION__TARGET);
		createEReference(transitionEClass, TRANSITION__GUARD);
		createEReference(transitionEClass, TRANSITION__TRIGGER);
		createEReference(transitionEClass, TRANSITION__ACTIONS);

		stateMachineDefinitionEClass = createEClass(STATE_MACHINE_DEFINITION);
		createEReference(stateMachineDefinitionEClass, STATE_MACHINE_DEFINITION__DECLARATION_BLOCK);
		createEReference(stateMachineDefinitionEClass, STATE_MACHINE_DEFINITION__TRANSITIONS);
		createEReference(stateMachineDefinitionEClass, STATE_MACHINE_DEFINITION__STATES);
		createEReference(stateMachineDefinitionEClass, STATE_MACHINE_DEFINITION__INITIAL_STATES);
		createEReference(stateMachineDefinitionEClass, STATE_MACHINE_DEFINITION__FINAL_STATES);

		abstractTriggerEClass = createEClass(ABSTRACT_TRIGGER);

		abstractActionEClass = createEClass(ABSTRACT_ACTION);

		abstractGuardEClass = createEClass(ABSTRACT_GUARD);

		guardEClass = createEClass(GUARD);
		createEReference(guardEClass, GUARD__VALUE);

		triggerEClass = createEClass(TRIGGER);
		createEReference(triggerEClass, TRIGGER__TRUE_TRIGGERS);
		createEReference(triggerEClass, TRIGGER__FALSE_TRIGGERS);

		integerAssignementEClass = createEClass(INTEGER_ASSIGNEMENT);

		declarationBlockEClass = createEClass(DECLARATION_BLOCK);
		createEReference(declarationBlockEClass, DECLARATION_BLOCK__CONCRETE_ENTITIES);
		createEReference(declarationBlockEClass, DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS);
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
		TimeModelPackage theTimeModelPackage = (TimeModelPackage)EPackage.Registry.INSTANCE.getEPackage(TimeModelPackage.eNS_URI);
		ClassicalExpressionPackage theClassicalExpressionPackage = (ClassicalExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ClassicalExpressionPackage.eNS_URI);
		ClockExpressionAndRelationPackage theClockExpressionAndRelationPackage = (ClockExpressionAndRelationPackage)EPackage.Registry.INSTANCE.getEPackage(ClockExpressionAndRelationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stateEClass.getESuperTypes().add(theTimeModelPackage.getNamedElement());
		transitionEClass.getESuperTypes().add(theTimeModelPackage.getNamedElement());
		stateMachineDefinitionEClass.getESuperTypes().add(theTimeModelPackage.getNamedElement());
		guardEClass.getESuperTypes().add(this.getAbstractGuard());
		triggerEClass.getESuperTypes().add(this.getAbstractTrigger());
		integerAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryIntegerExpression());
		integerAssignementEClass.getESuperTypes().add(this.getAbstractAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_InputTransitions(), this.getTransition(), this.getTransition_Target(), "inputTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_OutputTransitions(), this.getTransition(), this.getTransition_Source(), "outputTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_Source(), this.getState(), this.getState_OutputTransitions(), "source", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getTransition_Source().getEKeys().add(theTimeModelPackage.getNamedElement_Name());
		initEReference(getTransition_Target(), this.getState(), this.getState_InputTransitions(), "target", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getTransition_Target().getEKeys().add(theTimeModelPackage.getNamedElement_Name());
		initEReference(getTransition_Guard(), this.getAbstractGuard(), null, "guard", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Trigger(), this.getAbstractTrigger(), null, "trigger", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Actions(), this.getAbstractAction(), null, "actions", null, 0, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateMachineDefinitionEClass, StateMachineDefinition.class, "StateMachineDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachineDefinition_DeclarationBlock(), this.getDeclarationBlock(), null, "declarationBlock", null, 0, 1, StateMachineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineDefinition_Transitions(), this.getTransition(), null, "transitions", null, 0, -1, StateMachineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStateMachineDefinition_Transitions().getEKeys().add(theTimeModelPackage.getNamedElement_Name());
		initEReference(getStateMachineDefinition_States(), this.getState(), null, "states", null, 1, -1, StateMachineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStateMachineDefinition_States().getEKeys().add(theTimeModelPackage.getNamedElement_Name());
		initEReference(getStateMachineDefinition_InitialStates(), this.getState(), null, "initialStates", null, 1, -1, StateMachineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStateMachineDefinition_InitialStates().getEKeys().add(theTimeModelPackage.getNamedElement_Name());
		initEReference(getStateMachineDefinition_FinalStates(), this.getState(), null, "finalStates", null, 0, -1, StateMachineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStateMachineDefinition_FinalStates().getEKeys().add(theTimeModelPackage.getNamedElement_Name());

		initEClass(abstractTriggerEClass, AbstractTrigger.class, "AbstractTrigger", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractActionEClass, AbstractAction.class, "AbstractAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractGuardEClass, AbstractGuard.class, "AbstractGuard", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuard_Value(), theClassicalExpressionPackage.getBooleanExpression(), null, "value", null, 1, 1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getGuard_Value().getEKeys().add(theTimeModelPackage.getNamedElement_Name());

		initEClass(triggerEClass, Trigger.class, "Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrigger_TrueTriggers(), theClockExpressionAndRelationPackage.getBindableEntity(), null, "trueTriggers", null, 0, -1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getTrigger_TrueTriggers().getEKeys().add(theTimeModelPackage.getNamedElement_Name());
		initEReference(getTrigger_FalseTriggers(), theClockExpressionAndRelationPackage.getBindableEntity(), null, "falseTriggers", null, 0, -1, Trigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getTrigger_FalseTriggers().getEKeys().add(theTimeModelPackage.getNamedElement_Name());

		initEClass(integerAssignementEClass, IntegerAssignement.class, "IntegerAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(declarationBlockEClass, DeclarationBlock.class, "DeclarationBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclarationBlock_ConcreteEntities(), theClockExpressionAndRelationPackage.getConcreteEntity(), null, "concreteEntities", null, 0, -1, DeclarationBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getDeclarationBlock_ConcreteEntities().getEKeys().add(theTimeModelPackage.getNamedElement_Name());
		initEReference(getDeclarationBlock_ClassicalExpressions(), theClassicalExpressionPackage.getClassicalExpression(), null, "classicalExpressions", null, 0, -1, DeclarationBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getDeclarationBlock_ClassicalExpressions().getEKeys().add(theTimeModelPackage.getNamedElement_Name());

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "fr.inria.aoste.timemodel", "../../fr.inria.aoste.timesquare.ccslkernel.model/model/TimeModel.ecore#/",
			 "fr.inria.aoste.timemodel.ccslmodel.clockexpressionandrelation", "../../fr.inria.aoste.timesquare.ccslkernel.model/model/TimeModel.ecore#//CCSLModel/ClockExpressionAndRelation",
			 "fr.inria.aoste.timemodel.classicalexpression", "../../fr.inria.aoste.timesquare.ccslkernel.model/model/TimeModel.ecore#//CCSLModel/ClassicalExpression"
		   });
	}

} //FSMModelPackageImpl
