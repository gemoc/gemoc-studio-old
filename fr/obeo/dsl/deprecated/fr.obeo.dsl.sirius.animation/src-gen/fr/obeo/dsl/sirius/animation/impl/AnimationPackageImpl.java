/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.impl;

import fr.obeo.dsl.sirius.animation.AnimationFactory;
import fr.obeo.dsl.sirius.animation.AnimationPackage;
import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.CurrentSessions;
import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.StackFrameState;
import fr.obeo.dsl.sirius.animation.TargetState;
import fr.obeo.dsl.sirius.animation.Variable;

import fr.obeo.dsl.viewpoint.ViewpointPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimationPackageImpl extends EPackageImpl implements AnimationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animationTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackFrameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass currentSessionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum targetStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stackFrameStateEEnum = null;

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
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnimationPackageImpl() {
		super(eNS_URI, AnimationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AnimationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnimationPackage init() {
		if (isInited) return (AnimationPackage)EPackage.Registry.INSTANCE.getEPackage(AnimationPackage.eNS_URI);

		// Obtain or create and register package
		AnimationPackageImpl theAnimationPackage = (AnimationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AnimationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AnimationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theAnimationPackage.createPackageContents();

		// Initialize created meta-data
		theAnimationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnimationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AnimationPackage.eNS_URI, theAnimationPackage);
		return theAnimationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimationTarget() {
		return animationTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimationTarget_Threads() {
		return (EReference)animationTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimationTarget_Name() {
		return (EAttribute)animationTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnimationTarget_State() {
		return (EAttribute)animationTargetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackFrame() {
		return stackFrameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStackFrame_Variables() {
		return (EReference)stackFrameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackFrame_State() {
		return (EAttribute)stackFrameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStackFrame_Parent() {
		return (EReference)stackFrameEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackFrame_Name() {
		return (EAttribute)stackFrameEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStackFrame_Data() {
		return (EReference)stackFrameEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStackFrame_CurrentInstruction() {
		return (EReference)stackFrameEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStackFrame_ParentStack() {
		return (EReference)stackFrameEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStackFrame_ExecutionEnvironment() {
		return (EReference)stackFrameEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Name() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_Elements() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThread() {
		return threadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThread_StackFrames() {
		return (EReference)threadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThread_TopStackFrame() {
		return (EReference)threadEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThread_Name() {
		return (EAttribute)threadEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThread_Parent() {
		return (EReference)threadEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThread_Data() {
		return (EReference)threadEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCurrentSessions() {
		return currentSessionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCurrentSessions_Targets() {
		return (EReference)currentSessionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTargetState() {
		return targetStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStackFrameState() {
		return stackFrameStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimationFactory getAnimationFactory() {
		return (AnimationFactory)getEFactoryInstance();
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
		animationTargetEClass = createEClass(ANIMATION_TARGET);
		createEReference(animationTargetEClass, ANIMATION_TARGET__THREADS);
		createEAttribute(animationTargetEClass, ANIMATION_TARGET__NAME);
		createEAttribute(animationTargetEClass, ANIMATION_TARGET__STATE);

		stackFrameEClass = createEClass(STACK_FRAME);
		createEReference(stackFrameEClass, STACK_FRAME__VARIABLES);
		createEAttribute(stackFrameEClass, STACK_FRAME__STATE);
		createEReference(stackFrameEClass, STACK_FRAME__PARENT);
		createEAttribute(stackFrameEClass, STACK_FRAME__NAME);
		createEReference(stackFrameEClass, STACK_FRAME__DATA);
		createEReference(stackFrameEClass, STACK_FRAME__CURRENT_INSTRUCTION);
		createEReference(stackFrameEClass, STACK_FRAME__PARENT_STACK);
		createEReference(stackFrameEClass, STACK_FRAME__EXECUTION_ENVIRONMENT);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);
		createEReference(variableEClass, VARIABLE__ELEMENTS);

		threadEClass = createEClass(THREAD);
		createEReference(threadEClass, THREAD__STACK_FRAMES);
		createEReference(threadEClass, THREAD__TOP_STACK_FRAME);
		createEAttribute(threadEClass, THREAD__NAME);
		createEReference(threadEClass, THREAD__PARENT);
		createEReference(threadEClass, THREAD__DATA);

		currentSessionsEClass = createEClass(CURRENT_SESSIONS);
		createEReference(currentSessionsEClass, CURRENT_SESSIONS__TARGETS);

		// Create enums
		targetStateEEnum = createEEnum(TARGET_STATE);
		stackFrameStateEEnum = createEEnum(STACK_FRAME_STATE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(animationTargetEClass, AnimationTarget.class, "AnimationTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnimationTarget_Threads(), this.getThread(), this.getThread_Parent(), "threads", null, 0, -1, AnimationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimationTarget_Name(), ecorePackage.getEString(), "name", null, 1, 1, AnimationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnimationTarget_State(), this.getTargetState(), "state", null, 0, 1, AnimationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stackFrameEClass, StackFrame.class, "StackFrame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStackFrame_Variables(), this.getVariable(), null, "variables", null, 0, -1, StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackFrame_State(), this.getStackFrameState(), "state", null, 0, 1, StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStackFrame_Parent(), this.getThread(), this.getThread_StackFrames(), "parent", null, 0, 1, StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackFrame_Name(), ecorePackage.getEString(), "name", null, 1, 1, StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStackFrame_Data(), ecorePackage.getEObject(), null, "data", null, 0, 1, StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStackFrame_CurrentInstruction(), ecorePackage.getEObject(), null, "currentInstruction", null, 1, 1, StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStackFrame_ParentStack(), this.getStackFrame(), null, "parentStack", null, 0, 1, StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStackFrame_ExecutionEnvironment(), ecorePackage.getEObject(), null, "executionEnvironment", null, 1, 1, StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(stackFrameEClass, this.getVariable(), "getOrCreateVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "varName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(stackFrameEClass, this.getStackFrame(), "newFrame", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "executionEnvironment", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(stackFrameEClass, this.getStackFrame(), "popFrame", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(stackFrameEClass, ecorePackage.getEBoolean(), "is", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTargetState(), "state", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariable_Elements(), ecorePackage.getEObject(), null, "elements", null, 1, -1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threadEClass, fr.obeo.dsl.sirius.animation.Thread.class, "Thread", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThread_StackFrames(), this.getStackFrame(), this.getStackFrame_Parent(), "stackFrames", null, 0, -1, fr.obeo.dsl.sirius.animation.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThread_TopStackFrame(), this.getStackFrame(), null, "topStackFrame", null, 0, 1, fr.obeo.dsl.sirius.animation.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThread_Name(), ecorePackage.getEString(), "name", null, 1, 1, fr.obeo.dsl.sirius.animation.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThread_Parent(), this.getAnimationTarget(), this.getAnimationTarget_Threads(), "parent", null, 0, 1, fr.obeo.dsl.sirius.animation.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThread_Data(), ecorePackage.getEObject(), null, "data", null, 0, 1, fr.obeo.dsl.sirius.animation.Thread.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(currentSessionsEClass, CurrentSessions.class, "CurrentSessions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCurrentSessions_Targets(), this.getAnimationTarget(), null, "targets", null, 0, -1, CurrentSessions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(targetStateEEnum, TargetState.class, "TargetState");
		addEEnumLiteral(targetStateEEnum, TargetState.SUSPENDED);
		addEEnumLiteral(targetStateEEnum, TargetState.DISCONNECTED);
		addEEnumLiteral(targetStateEEnum, TargetState.TERMINATED);
		addEEnumLiteral(targetStateEEnum, TargetState.RUNNING);

		initEEnum(stackFrameStateEEnum, StackFrameState.class, "StackFrameState");
		addEEnumLiteral(stackFrameStateEEnum, StackFrameState.STEPING_RETURN);
		addEEnumLiteral(stackFrameStateEEnum, StackFrameState.STEPING_OVER);
		addEEnumLiteral(stackFrameStateEEnum, StackFrameState.STEPING_INTO);
		addEEnumLiteral(stackFrameStateEEnum, StackFrameState.DONE);

		// Create resource
		createResource(eNS_URI);
	}

} //AnimationPackageImpl
