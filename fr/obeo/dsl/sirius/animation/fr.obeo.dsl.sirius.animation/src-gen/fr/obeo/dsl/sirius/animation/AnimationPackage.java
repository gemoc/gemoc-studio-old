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
package fr.obeo.dsl.sirius.animation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.sirius.animation.AnimationFactory
 * @model kind="package"
 * @generated
 */
public interface AnimationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "animation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/dsl/sirius/animation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "animation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnimationPackage eINSTANCE = fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animation.impl.AnimationTargetImpl <em>Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animation.impl.AnimationTargetImpl
	 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getAnimationTarget()
	 * @generated
	 */
	int ANIMATION_TARGET = 0;

	/**
	 * The feature id for the '<em><b>Threads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TARGET__THREADS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TARGET__NAME = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TARGET__STATE = 2;

	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TARGET_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl <em>Stack Frame</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animation.impl.StackFrameImpl
	 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getStackFrame()
	 * @generated
	 */
	int STACK_FRAME = 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__VARIABLES = 0;

	/**
	 * The feature id for the '<em><b>Sub Frames</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__SUB_FRAMES = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__STATE = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__PARENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__NAME = 4;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__DATA = 5;

	/**
	 * The feature id for the '<em><b>Current Instruction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__CURRENT_INSTRUCTION = 6;

	/**
	 * The feature id for the '<em><b>Parent Stack</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__PARENT_STACK = 7;

	/**
	 * The feature id for the '<em><b>Execution Environment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME__EXECUTION_ENVIRONMENT = 8;

	/**
	 * The number of structural features of the '<em>Stack Frame</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_FRAME_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animation.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animation.impl.VariableImpl
	 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animation.impl.ThreadImpl <em>Thread</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animation.impl.ThreadImpl
	 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getThread()
	 * @generated
	 */
	int THREAD = 3;

	/**
	 * The feature id for the '<em><b>Stack Frames</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__STACK_FRAMES = 0;

	/**
	 * The feature id for the '<em><b>Top Stack Frame</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__TOP_STACK_FRAME = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__NAME = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__PARENT = 3;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD__DATA = 4;

	/**
	 * The number of structural features of the '<em>Thread</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animation.impl.CurrentSessionsImpl <em>Current Sessions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animation.impl.CurrentSessionsImpl
	 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getCurrentSessions()
	 * @generated
	 */
	int CURRENT_SESSIONS = 4;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENT_SESSIONS__TARGETS = 0;

	/**
	 * The number of structural features of the '<em>Current Sessions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CURRENT_SESSIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animation.TargetState <em>Target State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animation.TargetState
	 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getTargetState()
	 * @generated
	 */
	int TARGET_STATE = 5;


	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animation.StackFrameState <em>Stack Frame State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animation.StackFrameState
	 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getStackFrameState()
	 * @generated
	 */
	int STACK_FRAME_STATE = 6;


	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animation.AnimationTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target</em>'.
	 * @see fr.obeo.dsl.sirius.animation.AnimationTarget
	 * @generated
	 */
	EClass getAnimationTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getThreads <em>Threads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threads</em>'.
	 * @see fr.obeo.dsl.sirius.animation.AnimationTarget#getThreads()
	 * @see #getAnimationTarget()
	 * @generated
	 */
	EReference getAnimationTarget_Threads();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.sirius.animation.AnimationTarget#getName()
	 * @see #getAnimationTarget()
	 * @generated
	 */
	EAttribute getAnimationTarget_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see fr.obeo.dsl.sirius.animation.AnimationTarget#getState()
	 * @see #getAnimationTarget()
	 * @generated
	 */
	EAttribute getAnimationTarget_State();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animation.StackFrame <em>Stack Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Frame</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame
	 * @generated
	 */
	EClass getStackFrame();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.sirius.animation.StackFrame#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getVariables()
	 * @see #getStackFrame()
	 * @generated
	 */
	EReference getStackFrame_Variables();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.sirius.animation.StackFrame#getSubFrames <em>Sub Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Frames</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getSubFrames()
	 * @see #getStackFrame()
	 * @generated
	 */
	EReference getStackFrame_SubFrames();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.sirius.animation.StackFrame#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getState()
	 * @see #getStackFrame()
	 * @generated
	 */
	EAttribute getStackFrame_State();

	/**
	 * Returns the meta object for the container reference '{@link fr.obeo.dsl.sirius.animation.StackFrame#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getParent()
	 * @see #getStackFrame()
	 * @generated
	 */
	EReference getStackFrame_Parent();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.sirius.animation.StackFrame#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getName()
	 * @see #getStackFrame()
	 * @generated
	 */
	EAttribute getStackFrame_Name();

	/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.dsl.sirius.animation.StackFrame#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getData()
	 * @see #getStackFrame()
	 * @generated
	 */
	EReference getStackFrame_Data();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.sirius.animation.StackFrame#getCurrentInstruction <em>Current Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Instruction</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getCurrentInstruction()
	 * @see #getStackFrame()
	 * @generated
	 */
	EReference getStackFrame_CurrentInstruction();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.sirius.animation.StackFrame#getParentStack <em>Parent Stack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Stack</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getParentStack()
	 * @see #getStackFrame()
	 * @generated
	 */
	EReference getStackFrame_ParentStack();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.sirius.animation.StackFrame#getExecutionEnvironment <em>Execution Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution Environment</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getExecutionEnvironment()
	 * @see #getStackFrame()
	 * @generated
	 */
	EReference getStackFrame_ExecutionEnvironment();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animation.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.sirius.animation.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.sirius.animation.Variable#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Variable#getElements()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Elements();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animation.Thread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thread</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Thread
	 * @generated
	 */
	EClass getThread();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.sirius.animation.Thread#getStackFrames <em>Stack Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stack Frames</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Thread#getStackFrames()
	 * @see #getThread()
	 * @generated
	 */
	EReference getThread_StackFrames();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.sirius.animation.Thread#getTopStackFrame <em>Top Stack Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Stack Frame</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Thread#getTopStackFrame()
	 * @see #getThread()
	 * @generated
	 */
	EReference getThread_TopStackFrame();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.sirius.animation.Thread#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Thread#getName()
	 * @see #getThread()
	 * @generated
	 */
	EAttribute getThread_Name();

	/**
	 * Returns the meta object for the container reference '{@link fr.obeo.dsl.sirius.animation.Thread#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Thread#getParent()
	 * @see #getThread()
	 * @generated
	 */
	EReference getThread_Parent();

	/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.dsl.sirius.animation.Thread#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see fr.obeo.dsl.sirius.animation.Thread#getData()
	 * @see #getThread()
	 * @generated
	 */
	EReference getThread_Data();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animation.CurrentSessions <em>Current Sessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Current Sessions</em>'.
	 * @see fr.obeo.dsl.sirius.animation.CurrentSessions
	 * @generated
	 */
	EClass getCurrentSessions();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.sirius.animation.CurrentSessions#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Targets</em>'.
	 * @see fr.obeo.dsl.sirius.animation.CurrentSessions#getTargets()
	 * @see #getCurrentSessions()
	 * @generated
	 */
	EReference getCurrentSessions_Targets();

	/**
	 * Returns the meta object for enum '{@link fr.obeo.dsl.sirius.animation.TargetState <em>Target State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Target State</em>'.
	 * @see fr.obeo.dsl.sirius.animation.TargetState
	 * @generated
	 */
	EEnum getTargetState();

	/**
	 * Returns the meta object for enum '{@link fr.obeo.dsl.sirius.animation.StackFrameState <em>Stack Frame State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Stack Frame State</em>'.
	 * @see fr.obeo.dsl.sirius.animation.StackFrameState
	 * @generated
	 */
	EEnum getStackFrameState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnimationFactory getAnimationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animation.impl.AnimationTargetImpl <em>Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animation.impl.AnimationTargetImpl
		 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getAnimationTarget()
		 * @generated
		 */
		EClass ANIMATION_TARGET = eINSTANCE.getAnimationTarget();

		/**
		 * The meta object literal for the '<em><b>Threads</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMATION_TARGET__THREADS = eINSTANCE.getAnimationTarget_Threads();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMATION_TARGET__NAME = eINSTANCE.getAnimationTarget_Name();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANIMATION_TARGET__STATE = eINSTANCE.getAnimationTarget_State();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl <em>Stack Frame</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animation.impl.StackFrameImpl
		 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getStackFrame()
		 * @generated
		 */
		EClass STACK_FRAME = eINSTANCE.getStackFrame();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_FRAME__VARIABLES = eINSTANCE.getStackFrame_Variables();

		/**
		 * The meta object literal for the '<em><b>Sub Frames</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_FRAME__SUB_FRAMES = eINSTANCE.getStackFrame_SubFrames();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_FRAME__STATE = eINSTANCE.getStackFrame_State();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_FRAME__PARENT = eINSTANCE.getStackFrame_Parent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_FRAME__NAME = eINSTANCE.getStackFrame_Name();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_FRAME__DATA = eINSTANCE.getStackFrame_Data();

		/**
		 * The meta object literal for the '<em><b>Current Instruction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_FRAME__CURRENT_INSTRUCTION = eINSTANCE.getStackFrame_CurrentInstruction();

		/**
		 * The meta object literal for the '<em><b>Parent Stack</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_FRAME__PARENT_STACK = eINSTANCE.getStackFrame_ParentStack();

		/**
		 * The meta object literal for the '<em><b>Execution Environment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_FRAME__EXECUTION_ENVIRONMENT = eINSTANCE.getStackFrame_ExecutionEnvironment();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animation.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animation.impl.VariableImpl
		 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__ELEMENTS = eINSTANCE.getVariable_Elements();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animation.impl.ThreadImpl <em>Thread</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animation.impl.ThreadImpl
		 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getThread()
		 * @generated
		 */
		EClass THREAD = eINSTANCE.getThread();

		/**
		 * The meta object literal for the '<em><b>Stack Frames</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAD__STACK_FRAMES = eINSTANCE.getThread_StackFrames();

		/**
		 * The meta object literal for the '<em><b>Top Stack Frame</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAD__TOP_STACK_FRAME = eINSTANCE.getThread_TopStackFrame();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THREAD__NAME = eINSTANCE.getThread_Name();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAD__PARENT = eINSTANCE.getThread_Parent();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THREAD__DATA = eINSTANCE.getThread_Data();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animation.impl.CurrentSessionsImpl <em>Current Sessions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animation.impl.CurrentSessionsImpl
		 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getCurrentSessions()
		 * @generated
		 */
		EClass CURRENT_SESSIONS = eINSTANCE.getCurrentSessions();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CURRENT_SESSIONS__TARGETS = eINSTANCE.getCurrentSessions_Targets();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animation.TargetState <em>Target State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animation.TargetState
		 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getTargetState()
		 * @generated
		 */
		EEnum TARGET_STATE = eINSTANCE.getTargetState();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animation.StackFrameState <em>Stack Frame State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animation.StackFrameState
		 * @see fr.obeo.dsl.sirius.animation.impl.AnimationPackageImpl#getStackFrameState()
		 * @generated
		 */
		EEnum STACK_FRAME_STATE = eINSTANCE.getStackFrameState();

	}

} //AnimationPackage
