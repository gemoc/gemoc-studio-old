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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage;

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
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocFactory
 * @model kind="package"
 * @generated
 */
public interface CcslmocPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ccslmoc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.ccslmoc/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ccslmoc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CcslmocPackage eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl <em>CCSL Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLLibrary()
	 * @generated
	 */
	int CCSL_LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_LIBRARY__NAME = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_LIBRARY__EXPRESSION_LIBRARIES = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Relation Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_LIBRARY__RELATION_LIBRARIES = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Predefined Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_LIBRARY__PREDEFINED_TYPES = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_LIBRARY__IMPORTS = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>CCSL Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_LIBRARY_FEATURE_COUNT = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>CCSL Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_LIBRARY_OPERATION_COUNT = CometaPackage.MO_CLIBRARY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl <em>CCSL State Machine Relation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLStateMachineRelationDefinition()
	 * @generated
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION__NAME = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION__DECLARATION = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION__DECLARATION;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION__STATES = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Final States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Concrete Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Classical Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>CCSL State Machine Relation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION_FEATURE_COUNT = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>CCSL State Machine Relation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int CCSL_STATE_MACHINE_RELATION_DEFINITION_OPERATION_COUNT = 0;//ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLActionImpl <em>CCSL Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLActionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLAction()
	 * @generated
	 */
	int CCSL_ACTION = 2;

	/**
	 * The number of structural features of the '<em>CCSL Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_ACTION_FEATURE_COUNT = FsmdefinitionPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CCSL Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_ACTION_OPERATION_COUNT = FsmdefinitionPackage.ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.FinishClockImpl <em>Finish Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.FinishClockImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getFinishClock()
	 * @generated
	 */
	int FINISH_CLOCK = 3;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINISH_CLOCK__CLOCK = CCSL_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Finish Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINISH_CLOCK_FEATURE_COUNT = CCSL_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Finish Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINISH_CLOCK_OPERATION_COUNT = CCSL_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.IntegerAssignementImpl <em>Integer Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.IntegerAssignementImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getIntegerAssignement()
	 * @generated
	 */
	int INTEGER_ASSIGNEMENT = 4;

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
	int INTEGER_ASSIGNEMENT_OPERATION_COUNT = 0;//ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLGuardImpl <em>CCSL Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLGuardImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLGuard()
	 * @generated
	 */
	int CCSL_GUARD = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_GUARD__VALUE = FsmdefinitionPackage.GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CCSL Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_GUARD_FEATURE_COUNT = FsmdefinitionPackage.GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CCSL Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_GUARD_OPERATION_COUNT = FsmdefinitionPackage.GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLTriggerImpl <em>CCSL Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLTriggerImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLTrigger()
	 * @generated
	 */
	int CCSL_TRIGGER = 6;

	/**
	 * The feature id for the '<em><b>True Triggers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_TRIGGER__TRUE_TRIGGERS = FsmdefinitionPackage.TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>False Triggers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_TRIGGER__FALSE_TRIGGERS = FsmdefinitionPackage.TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CCSL Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_TRIGGER_FEATURE_COUNT = FsmdefinitionPackage.TRIGGER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CCSL Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_TRIGGER_OPERATION_COUNT = FsmdefinitionPackage.TRIGGER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLLibrary <em>CCSL Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL Library</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLLibrary
	 * @generated
	 */
	EClass getCCSLLibrary();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition <em>CCSL State Machine Relation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL State Machine Relation Definition</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition
	 * @generated
	 */
	EClass getCCSLStateMachineRelationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition#getConcreteEntities <em>Concrete Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concrete Entities</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition#getConcreteEntities()
	 * @see #getCCSLStateMachineRelationDefinition()
	 * @generated
	 */
	EReference getCCSLStateMachineRelationDefinition_ConcreteEntities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition#getClassicalExpressions <em>Classical Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classical Expressions</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition#getClassicalExpressions()
	 * @see #getCCSLStateMachineRelationDefinition()
	 * @generated
	 */
	EReference getCCSLStateMachineRelationDefinition_ClassicalExpressions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLAction <em>CCSL Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL Action</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLAction
	 * @generated
	 */
	EClass getCCSLAction();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.FinishClock <em>Finish Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finish Clock</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.FinishClock
	 * @generated
	 */
	EClass getFinishClock();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.FinishClock#getClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clock</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.FinishClock#getClock()
	 * @see #getFinishClock()
	 * @generated
	 */
	EReference getFinishClock_Clock();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.IntegerAssignement <em>Integer Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Assignement</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.IntegerAssignement
	 * @generated
	 */
	EClass getIntegerAssignement();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard <em>CCSL Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL Guard</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard
	 * @generated
	 */
	EClass getCCSLGuard();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard#getValue()
	 * @see #getCCSLGuard()
	 * @generated
	 */
	EReference getCCSLGuard_Value();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger <em>CCSL Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL Trigger</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger
	 * @generated
	 */
	EClass getCCSLTrigger();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger#getTrueTriggers <em>True Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>True Triggers</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger#getTrueTriggers()
	 * @see #getCCSLTrigger()
	 * @generated
	 */
	EReference getCCSLTrigger_TrueTriggers();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger#getFalseTriggers <em>False Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>False Triggers</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger#getFalseTriggers()
	 * @see #getCCSLTrigger()
	 * @generated
	 */
	EReference getCCSLTrigger_FalseTriggers();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CcslmocFactory getCcslmocFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl <em>CCSL Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLLibrary()
		 * @generated
		 */
		EClass CCSL_LIBRARY = eINSTANCE.getCCSLLibrary();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl <em>CCSL State Machine Relation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLStateMachineRelationDefinitionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLStateMachineRelationDefinition()
		 * @generated
		 */
		EClass CCSL_STATE_MACHINE_RELATION_DEFINITION = eINSTANCE.getCCSLStateMachineRelationDefinition();

		/**
		 * The meta object literal for the '<em><b>Concrete Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCSL_STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES = eINSTANCE.getCCSLStateMachineRelationDefinition_ConcreteEntities();

		/**
		 * The meta object literal for the '<em><b>Classical Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCSL_STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS = eINSTANCE.getCCSLStateMachineRelationDefinition_ClassicalExpressions();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLActionImpl <em>CCSL Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLActionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLAction()
		 * @generated
		 */
		EClass CCSL_ACTION = eINSTANCE.getCCSLAction();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.FinishClockImpl <em>Finish Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.FinishClockImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getFinishClock()
		 * @generated
		 */
		EClass FINISH_CLOCK = eINSTANCE.getFinishClock();

		/**
		 * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINISH_CLOCK__CLOCK = eINSTANCE.getFinishClock_Clock();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.IntegerAssignementImpl <em>Integer Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.IntegerAssignementImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getIntegerAssignement()
		 * @generated
		 */
		EClass INTEGER_ASSIGNEMENT = eINSTANCE.getIntegerAssignement();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLGuardImpl <em>CCSL Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLGuardImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLGuard()
		 * @generated
		 */
		EClass CCSL_GUARD = eINSTANCE.getCCSLGuard();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCSL_GUARD__VALUE = eINSTANCE.getCCSLGuard_Value();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLTriggerImpl <em>CCSL Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLTriggerImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocPackageImpl#getCCSLTrigger()
		 * @generated
		 */
		EClass CCSL_TRIGGER = eINSTANCE.getCCSLTrigger();

		/**
		 * The meta object literal for the '<em><b>True Triggers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCSL_TRIGGER__TRUE_TRIGGERS = eINSTANCE.getCCSLTrigger_TrueTriggers();

		/**
		 * The meta object literal for the '<em><b>False Triggers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCSL_TRIGGER__FALSE_TRIGGERS = eINSTANCE.getCCSLTrigger_FalseTriggers();

	}

} //CcslmocPackage
