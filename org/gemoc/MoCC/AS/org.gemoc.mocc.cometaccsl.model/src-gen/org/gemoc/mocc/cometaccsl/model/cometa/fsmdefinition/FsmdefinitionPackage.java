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
package org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionFactory
 * @model kind="package"
 * @generated
 */
public interface FsmdefinitionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fsmdefinition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.fsmdefinition/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fsmdefinition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmdefinitionPackage eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getState()
	 * @generated
	 */
	int STATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ACTIONS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INPUT_TRANSITIONS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Output Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTPUT_TRANSITIONS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TransitionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGER = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTIONS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FiniteStateMachineImpl <em>Finite State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FiniteStateMachineImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getFiniteStateMachine()
	 * @generated
	 */
	int FINITE_STATE_MACHINE = 2;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE__TRANSITIONS = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE__STATES = 1;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE__INITIAL_STATE = 2;

	/**
	 * The feature id for the '<em><b>Final States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE__FINAL_STATES = 3;

	/**
	 * The number of structural features of the '<em>Finite State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Finite State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TriggerImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 3;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.ActionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 4;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.GuardImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 5;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getActions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Actions();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getInputTransitions <em>Input Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Transitions</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getInputTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InputTransitions();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getOutputTransitions <em>Output Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Transitions</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getOutputTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutputTransitions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trigger</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getTrigger()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Trigger();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getActions()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Actions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine <em>Finite State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finite State Machine</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine
	 * @generated
	 */
	EClass getFiniteStateMachine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getTransitions()
	 * @see #getFiniteStateMachine()
	 * @generated
	 */
	EReference getFiniteStateMachine_Transitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getStates()
	 * @see #getFiniteStateMachine()
	 * @generated
	 */
	EReference getFiniteStateMachine_States();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getInitialState()
	 * @see #getFiniteStateMachine()
	 * @generated
	 */
	EReference getFiniteStateMachine_InitialState();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getFinalStates <em>Final States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Final States</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getFinalStates()
	 * @see #getFiniteStateMachine()
	 * @generated
	 */
	EReference getFiniteStateMachine_FinalStates();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FsmdefinitionFactory getFsmdefinitionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.StateImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ACTIONS = eINSTANCE.getState_Actions();

		/**
		 * The meta object literal for the '<em><b>Input Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INPUT_TRANSITIONS = eINSTANCE.getState_InputTransitions();

		/**
		 * The meta object literal for the '<em><b>Output Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTPUT_TRANSITIONS = eINSTANCE.getState_OutputTransitions();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TransitionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TRIGGER = eINSTANCE.getTransition_Trigger();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__ACTIONS = eINSTANCE.getTransition_Actions();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FiniteStateMachineImpl <em>Finite State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FiniteStateMachineImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getFiniteStateMachine()
		 * @generated
		 */
		EClass FINITE_STATE_MACHINE = eINSTANCE.getFiniteStateMachine();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINITE_STATE_MACHINE__TRANSITIONS = eINSTANCE.getFiniteStateMachine_Transitions();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINITE_STATE_MACHINE__STATES = eINSTANCE.getFiniteStateMachine_States();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINITE_STATE_MACHINE__INITIAL_STATE = eINSTANCE.getFiniteStateMachine_InitialState();

		/**
		 * The meta object literal for the '<em><b>Final States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINITE_STATE_MACHINE__FINAL_STATES = eINSTANCE.getFiniteStateMachine_FinalStates();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.TriggerImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.ActionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.GuardImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.impl.FsmdefinitionPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

	}

} //FsmdefinitionPackage
