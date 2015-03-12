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
package org.gemoc.mocc.fsmkernel.model.FSMModel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import fr.inria.aoste.timemodel='../../fr.inria.aoste.timesquare.ccslkernel.model/model/TimeModel.ecore#/' fr.inria.aoste.timemodel.ccslmodel.clockexpressionandrelation='../../fr.inria.aoste.timesquare.ccslkernel.model/model/TimeModel.ecore#//CCSLModel/ClockExpressionAndRelation' fr.inria.aoste.timemodel.classicalexpression='../../fr.inria.aoste.timesquare.ccslkernel.model/model/TimeModel.ecore#//CCSLModel/ClassicalExpression'"
 * @generated
 */
public interface FSMModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FSMModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.moccml.fsmmodel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.gemoc.moccml.fsmmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FSMModelPackage eINSTANCE = org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getState()
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
	int STATE__NAME = TimeModelPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Input Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INPUT_TRANSITIONS = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTPUT_TRANSITIONS = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = /*TimeModelPackage.NAMED_ELEMENT_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TransitionImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getTransition()
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
	int TRANSITION__NAME = TimeModelPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGER = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTIONS = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = /*TimeModelPackage.NAMED_ELEMENT_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateMachineDefinitionImpl <em>State Machine Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateMachineDefinitionImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getStateMachineDefinition()
	 * @generated
	 */
	int STATE_MACHINE_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_DEFINITION__NAME = TimeModelPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Declaration Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_DEFINITION__DECLARATION_BLOCK = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_DEFINITION__TRANSITIONS = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_DEFINITION__STATES = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initial States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_DEFINITION__INITIAL_STATES = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Final States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_DEFINITION__FINAL_STATES = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>State Machine Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_DEFINITION_FEATURE_COUNT = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>State Machine Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int STATE_MACHINE_DEFINITION_OPERATION_COUNT = /*TimeModelPackage.NAMED_ELEMENT_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractTriggerImpl <em>Abstract Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractTriggerImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getAbstractTrigger()
	 * @generated
	 */
	int ABSTRACT_TRIGGER = 3;

	/**
	 * The number of structural features of the '<em>Abstract Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRIGGER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TRIGGER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractActionImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getAbstractAction()
	 * @generated
	 */
	int ABSTRACT_ACTION = 4;

	/**
	 * The number of structural features of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractGuardImpl <em>Abstract Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractGuardImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getAbstractGuard()
	 * @generated
	 */
	int ABSTRACT_GUARD = 5;

	/**
	 * The number of structural features of the '<em>Abstract Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GUARD_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Abstract Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GUARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.GuardImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__VALUE = ABSTRACT_GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = ABSTRACT_GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_OPERATION_COUNT = ABSTRACT_GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TriggerImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 7;

	/**
	 * The feature id for the '<em><b>True Triggers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__TRUE_TRIGGERS = ABSTRACT_TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>False Triggers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER__FALSE_TRIGGERS = ABSTRACT_TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = ABSTRACT_TRIGGER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_OPERATION_COUNT = ABSTRACT_TRIGGER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.IntegerAssignementImpl <em>Integer Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.IntegerAssignementImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getIntegerAssignement()
	 * @generated
	 */
	int INTEGER_ASSIGNEMENT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT__NAME = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT__TYPE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Integer Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Integer Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT_OPERATION_COUNT = /*ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.DeclarationBlockImpl <em>Declaration Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.DeclarationBlockImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getDeclarationBlock()
	 * @generated
	 */
	int DECLARATION_BLOCK = 9;

	/**
	 * The feature id for the '<em><b>Concrete Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_BLOCK__CONCRETE_ENTITIES = 0;

	/**
	 * The feature id for the '<em><b>Classical Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS = 1;

	/**
	 * The number of structural features of the '<em>Declaration Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_BLOCK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Declaration Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_BLOCK_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.State#getInputTransitions <em>Input Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Transitions</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.State#getInputTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InputTransitions();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.State#getOutputTransitions <em>Output Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Transitions</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.State#getOutputTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutputTransitions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trigger</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getTrigger()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Trigger();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getActions()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Actions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition <em>State Machine Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine Definition</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition
	 * @generated
	 */
	EClass getStateMachineDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getDeclarationBlock <em>Declaration Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declaration Block</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getDeclarationBlock()
	 * @see #getStateMachineDefinition()
	 * @generated
	 */
	EReference getStateMachineDefinition_DeclarationBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transitions</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getTransitions()
	 * @see #getStateMachineDefinition()
	 * @generated
	 */
	EReference getStateMachineDefinition_Transitions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getStates()
	 * @see #getStateMachineDefinition()
	 * @generated
	 */
	EReference getStateMachineDefinition_States();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getInitialStates <em>Initial States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Initial States</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getInitialStates()
	 * @see #getStateMachineDefinition()
	 * @generated
	 */
	EReference getStateMachineDefinition_InitialStates();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getFinalStates <em>Final States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Final States</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getFinalStates()
	 * @see #getStateMachineDefinition()
	 * @generated
	 */
	EReference getStateMachineDefinition_FinalStates();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractTrigger <em>Abstract Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Trigger</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractTrigger
	 * @generated
	 */
	EClass getAbstractTrigger();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Action</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction
	 * @generated
	 */
	EClass getAbstractAction();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractGuard <em>Abstract Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Guard</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractGuard
	 * @generated
	 */
	EClass getAbstractGuard();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Guard#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Guard#getValue()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_Value();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger#getTrueTriggers <em>True Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>True Triggers</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger#getTrueTriggers()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_TrueTriggers();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger#getFalseTriggers <em>False Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>False Triggers</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Trigger#getFalseTriggers()
	 * @see #getTrigger()
	 * @generated
	 */
	EReference getTrigger_FalseTriggers();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignement <em>Integer Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Assignement</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.IntegerAssignement
	 * @generated
	 */
	EClass getIntegerAssignement();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock <em>Declaration Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declaration Block</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock
	 * @generated
	 */
	EClass getDeclarationBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock#getConcreteEntities <em>Concrete Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concrete Entities</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock#getConcreteEntities()
	 * @see #getDeclarationBlock()
	 * @generated
	 */
	EReference getDeclarationBlock_ConcreteEntities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock#getClassicalExpressions <em>Classical Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classical Expressions</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock#getClassicalExpressions()
	 * @see #getDeclarationBlock()
	 * @generated
	 */
	EReference getDeclarationBlock_ClassicalExpressions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FSMModelFactory getFSMModelFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TransitionImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getTransition()
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
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateMachineDefinitionImpl <em>State Machine Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.StateMachineDefinitionImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getStateMachineDefinition()
		 * @generated
		 */
		EClass STATE_MACHINE_DEFINITION = eINSTANCE.getStateMachineDefinition();

		/**
		 * The meta object literal for the '<em><b>Declaration Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_DEFINITION__DECLARATION_BLOCK = eINSTANCE.getStateMachineDefinition_DeclarationBlock();

		/**
		 * The meta object literal for the '<em><b>Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_DEFINITION__TRANSITIONS = eINSTANCE.getStateMachineDefinition_Transitions();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_DEFINITION__STATES = eINSTANCE.getStateMachineDefinition_States();

		/**
		 * The meta object literal for the '<em><b>Initial States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_DEFINITION__INITIAL_STATES = eINSTANCE.getStateMachineDefinition_InitialStates();

		/**
		 * The meta object literal for the '<em><b>Final States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_DEFINITION__FINAL_STATES = eINSTANCE.getStateMachineDefinition_FinalStates();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractTriggerImpl <em>Abstract Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractTriggerImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getAbstractTrigger()
		 * @generated
		 */
		EClass ABSTRACT_TRIGGER = eINSTANCE.getAbstractTrigger();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractActionImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getAbstractAction()
		 * @generated
		 */
		EClass ABSTRACT_ACTION = eINSTANCE.getAbstractAction();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractGuardImpl <em>Abstract Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.AbstractGuardImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getAbstractGuard()
		 * @generated
		 */
		EClass ABSTRACT_GUARD = eINSTANCE.getAbstractGuard();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.GuardImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__VALUE = eINSTANCE.getGuard_Value();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.TriggerImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '<em><b>True Triggers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__TRUE_TRIGGERS = eINSTANCE.getTrigger_TrueTriggers();

		/**
		 * The meta object literal for the '<em><b>False Triggers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRIGGER__FALSE_TRIGGERS = eINSTANCE.getTrigger_FalseTriggers();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.IntegerAssignementImpl <em>Integer Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.IntegerAssignementImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getIntegerAssignement()
		 * @generated
		 */
		EClass INTEGER_ASSIGNEMENT = eINSTANCE.getIntegerAssignement();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.impl.DeclarationBlockImpl <em>Declaration Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.DeclarationBlockImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl#getDeclarationBlock()
		 * @generated
		 */
		EClass DECLARATION_BLOCK = eINSTANCE.getDeclarationBlock();

		/**
		 * The meta object literal for the '<em><b>Concrete Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARATION_BLOCK__CONCRETE_ENTITIES = eINSTANCE.getDeclarationBlock_ConcreteEntities();

		/**
		 * The meta object literal for the '<em><b>Classical Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARATION_BLOCK__CLASSICAL_EXPRESSIONS = eINSTANCE.getDeclarationBlock_ClassicalExpressions();

	}

} //FSMModelPackage
