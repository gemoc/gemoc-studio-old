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
package org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;

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
 * <!-- begin-model-doc -->
 * Edition class facilities and syntactic sugar
 * <!-- end-model-doc -->
 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface EditionExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "editionextension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.fsmmodel/editionextension/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.gemoc.mocc.fsmmodel.editionextension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditionExtensionPackage eINSTANCE = org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntegerAssignementBlockImpl <em>Integer Assignement Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntegerAssignementBlockImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntegerAssignementBlock()
	 * @generated
	 */
	int INTEGER_ASSIGNEMENT_BLOCK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT_BLOCK__NAME = FSMModelPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT_BLOCK__ACTIONS = FSMModelPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Assignement Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT_BLOCK_FEATURE_COUNT = FSMModelPackage.ABSTRACT_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Integer Assignement Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNEMENT_BLOCK_OPERATION_COUNT = FSMModelPackage.ABSTRACT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntInfEqualImpl <em>Int Inf Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntInfEqualImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntInfEqual()
	 * @generated
	 */
	int INT_INF_EQUAL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INF_EQUAL__NAME = ClassicalExpressionPackage.BOOLEAN_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INF_EQUAL__TYPE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INF_EQUAL__LEFT_VALUE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INF_EQUAL__RIGHT_VALUE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Int Inf Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_INF_EQUAL_FEATURE_COUNT = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Int Inf Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int INT_INF_EQUAL_OPERATION_COUNT = /*ClassicalExpressionPackage.BOOLEAN_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSupEqualImpl <em>Int Sup Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSupEqualImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSupEqual()
	 * @generated
	 */
	int INT_SUP_EQUAL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SUP_EQUAL__NAME = ClassicalExpressionPackage.BOOLEAN_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SUP_EQUAL__TYPE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SUP_EQUAL__LEFT_VALUE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SUP_EQUAL__RIGHT_VALUE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Int Sup Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SUP_EQUAL_FEATURE_COUNT = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Int Sup Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int INT_SUP_EQUAL_OPERATION_COUNT = /*ClassicalExpressionPackage.BOOLEAN_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealInfEqualImpl <em>Real Inf Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealInfEqualImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealInfEqual()
	 * @generated
	 */
	int REAL_INF_EQUAL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_INF_EQUAL__NAME = ClassicalExpressionPackage.BOOLEAN_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_INF_EQUAL__TYPE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_INF_EQUAL__LEFT_VALUE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_INF_EQUAL__RIGHT_VALUE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Real Inf Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_INF_EQUAL_FEATURE_COUNT = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Real Inf Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int REAL_INF_EQUAL_OPERATION_COUNT = /*ClassicalExpressionPackage.BOOLEAN_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSupEqualImpl <em>Real Sup Equal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSupEqualImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealSupEqual()
	 * @generated
	 */
	int REAL_SUP_EQUAL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SUP_EQUAL__NAME = ClassicalExpressionPackage.BOOLEAN_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SUP_EQUAL__TYPE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SUP_EQUAL__LEFT_VALUE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SUP_EQUAL__RIGHT_VALUE = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Real Sup Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SUP_EQUAL_FEATURE_COUNT = ClassicalExpressionPackage.BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Real Sup Equal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int REAL_SUP_EQUAL_OPERATION_COUNT = /*ClassicalExpressionPackage.BOOLEAN_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfPlusAssignementImpl <em>Int Self Plus Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfPlusAssignementImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSelfPlusAssignement()
	 * @generated
	 */
	int INT_SELF_PLUS_ASSIGNEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_PLUS_ASSIGNEMENT__NAME = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_PLUS_ASSIGNEMENT__TYPE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_PLUS_ASSIGNEMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_PLUS_ASSIGNEMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Int Self Plus Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_PLUS_ASSIGNEMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Int Self Plus Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int INT_SELF_PLUS_ASSIGNEMENT_OPERATION_COUNT = /*ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfMinusAssignementImpl <em>Int Self Minus Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfMinusAssignementImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSelfMinusAssignement()
	 * @generated
	 */
	int INT_SELF_MINUS_ASSIGNEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MINUS_ASSIGNEMENT__NAME = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MINUS_ASSIGNEMENT__TYPE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MINUS_ASSIGNEMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MINUS_ASSIGNEMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Int Self Minus Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MINUS_ASSIGNEMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Int Self Minus Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int INT_SELF_MINUS_ASSIGNEMENT_OPERATION_COUNT = /*ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfMultiplyAssignementImpl <em>Int Self Multiply Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfMultiplyAssignementImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSelfMultiplyAssignement()
	 * @generated
	 */
	int INT_SELF_MULTIPLY_ASSIGNEMENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MULTIPLY_ASSIGNEMENT__NAME = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MULTIPLY_ASSIGNEMENT__TYPE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MULTIPLY_ASSIGNEMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MULTIPLY_ASSIGNEMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Int Self Multiply Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_MULTIPLY_ASSIGNEMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Int Self Multiply Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int INT_SELF_MULTIPLY_ASSIGNEMENT_OPERATION_COUNT = /*ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfDivideAssignementImpl <em>Int Self Divide Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfDivideAssignementImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSelfDivideAssignement()
	 * @generated
	 */
	int INT_SELF_DIVIDE_ASSIGNEMENT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_DIVIDE_ASSIGNEMENT__NAME = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_DIVIDE_ASSIGNEMENT__TYPE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_DIVIDE_ASSIGNEMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_DIVIDE_ASSIGNEMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Int Self Divide Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_SELF_DIVIDE_ASSIGNEMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Int Self Divide Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int INT_SELF_DIVIDE_ASSIGNEMENT_OPERATION_COUNT = /*ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfPlusAssignementImpl <em>Real Self Plus Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfPlusAssignementImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealSelfPlusAssignement()
	 * @generated
	 */
	int REAL_SELF_PLUS_ASSIGNEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_PLUS_ASSIGNEMENT__NAME = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_PLUS_ASSIGNEMENT__TYPE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_PLUS_ASSIGNEMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_PLUS_ASSIGNEMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Real Self Plus Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_PLUS_ASSIGNEMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Real Self Plus Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int REAL_SELF_PLUS_ASSIGNEMENT_OPERATION_COUNT = /*ClassicalExpressionPackage.BINARY_REAL_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfMinusAssignementImpl <em>Real Self Minus Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfMinusAssignementImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealSelfMinusAssignement()
	 * @generated
	 */
	int REAL_SELF_MINUS_ASSIGNEMENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MINUS_ASSIGNEMENT__NAME = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MINUS_ASSIGNEMENT__TYPE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MINUS_ASSIGNEMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MINUS_ASSIGNEMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Real Self Minus Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MINUS_ASSIGNEMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Real Self Minus Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int REAL_SELF_MINUS_ASSIGNEMENT_OPERATION_COUNT = /*ClassicalExpressionPackage.BINARY_REAL_EXPRESSION_OPERATION_COUNT*/ + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfMultiplyAssignementImpl <em>Real Self Multiply Assignement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfMultiplyAssignementImpl
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealSelfMultiplyAssignement()
	 * @generated
	 */
	int REAL_SELF_MULTIPLY_ASSIGNEMENT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MULTIPLY_ASSIGNEMENT__NAME = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MULTIPLY_ASSIGNEMENT__TYPE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MULTIPLY_ASSIGNEMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MULTIPLY_ASSIGNEMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Real Self Multiply Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_SELF_MULTIPLY_ASSIGNEMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_REAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Real Self Multiply Assignement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int REAL_SELF_MULTIPLY_ASSIGNEMENT_OPERATION_COUNT = /*ClassicalExpressionPackage.BINARY_REAL_EXPRESSION_OPERATION_COUNT*/ + 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntegerAssignementBlock <em>Integer Assignement Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Assignement Block</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntegerAssignementBlock
	 * @generated
	 */
	EClass getIntegerAssignementBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntegerAssignementBlock#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntegerAssignementBlock#getActions()
	 * @see #getIntegerAssignementBlock()
	 * @generated
	 */
	EReference getIntegerAssignementBlock_Actions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntInfEqual <em>Int Inf Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Inf Equal</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntInfEqual
	 * @generated
	 */
	EClass getIntInfEqual();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntInfEqual#getLeftValue <em>Left Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntInfEqual#getLeftValue()
	 * @see #getIntInfEqual()
	 * @generated
	 */
	EReference getIntInfEqual_LeftValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntInfEqual#getRightValue <em>Right Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntInfEqual#getRightValue()
	 * @see #getIntInfEqual()
	 * @generated
	 */
	EReference getIntInfEqual_RightValue();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSupEqual <em>Int Sup Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Sup Equal</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSupEqual
	 * @generated
	 */
	EClass getIntSupEqual();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSupEqual#getLeftValue <em>Left Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSupEqual#getLeftValue()
	 * @see #getIntSupEqual()
	 * @generated
	 */
	EReference getIntSupEqual_LeftValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSupEqual#getRightValue <em>Right Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSupEqual#getRightValue()
	 * @see #getIntSupEqual()
	 * @generated
	 */
	EReference getIntSupEqual_RightValue();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual <em>Real Inf Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Inf Equal</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual
	 * @generated
	 */
	EClass getRealInfEqual();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual#getLeftValue <em>Left Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual#getLeftValue()
	 * @see #getRealInfEqual()
	 * @generated
	 */
	EReference getRealInfEqual_LeftValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual#getRightValue <em>Right Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual#getRightValue()
	 * @see #getRealInfEqual()
	 * @generated
	 */
	EReference getRealInfEqual_RightValue();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSupEqual <em>Real Sup Equal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Sup Equal</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSupEqual
	 * @generated
	 */
	EClass getRealSupEqual();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSupEqual#getLeftValue <em>Left Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSupEqual#getLeftValue()
	 * @see #getRealSupEqual()
	 * @generated
	 */
	EReference getRealSupEqual_LeftValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSupEqual#getRightValue <em>Right Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Value</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSupEqual#getRightValue()
	 * @see #getRealSupEqual()
	 * @generated
	 */
	EReference getRealSupEqual_RightValue();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfPlusAssignement <em>Int Self Plus Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Self Plus Assignement</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfPlusAssignement
	 * @generated
	 */
	EClass getIntSelfPlusAssignement();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfMinusAssignement <em>Int Self Minus Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Self Minus Assignement</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfMinusAssignement
	 * @generated
	 */
	EClass getIntSelfMinusAssignement();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfMultiplyAssignement <em>Int Self Multiply Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Self Multiply Assignement</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfMultiplyAssignement
	 * @generated
	 */
	EClass getIntSelfMultiplyAssignement();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfDivideAssignement <em>Int Self Divide Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Self Divide Assignement</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfDivideAssignement
	 * @generated
	 */
	EClass getIntSelfDivideAssignement();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfPlusAssignement <em>Real Self Plus Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Self Plus Assignement</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfPlusAssignement
	 * @generated
	 */
	EClass getRealSelfPlusAssignement();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfMinusAssignement <em>Real Self Minus Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Self Minus Assignement</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfMinusAssignement
	 * @generated
	 */
	EClass getRealSelfMinusAssignement();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfMultiplyAssignement <em>Real Self Multiply Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Self Multiply Assignement</em>'.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfMultiplyAssignement
	 * @generated
	 */
	EClass getRealSelfMultiplyAssignement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EditionExtensionFactory getEditionExtensionFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntegerAssignementBlockImpl <em>Integer Assignement Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntegerAssignementBlockImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntegerAssignementBlock()
		 * @generated
		 */
		EClass INTEGER_ASSIGNEMENT_BLOCK = eINSTANCE.getIntegerAssignementBlock();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER_ASSIGNEMENT_BLOCK__ACTIONS = eINSTANCE.getIntegerAssignementBlock_Actions();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntInfEqualImpl <em>Int Inf Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntInfEqualImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntInfEqual()
		 * @generated
		 */
		EClass INT_INF_EQUAL = eINSTANCE.getIntInfEqual();

		/**
		 * The meta object literal for the '<em><b>Left Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_INF_EQUAL__LEFT_VALUE = eINSTANCE.getIntInfEqual_LeftValue();

		/**
		 * The meta object literal for the '<em><b>Right Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_INF_EQUAL__RIGHT_VALUE = eINSTANCE.getIntInfEqual_RightValue();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSupEqualImpl <em>Int Sup Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSupEqualImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSupEqual()
		 * @generated
		 */
		EClass INT_SUP_EQUAL = eINSTANCE.getIntSupEqual();

		/**
		 * The meta object literal for the '<em><b>Left Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_SUP_EQUAL__LEFT_VALUE = eINSTANCE.getIntSupEqual_LeftValue();

		/**
		 * The meta object literal for the '<em><b>Right Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INT_SUP_EQUAL__RIGHT_VALUE = eINSTANCE.getIntSupEqual_RightValue();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealInfEqualImpl <em>Real Inf Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealInfEqualImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealInfEqual()
		 * @generated
		 */
		EClass REAL_INF_EQUAL = eINSTANCE.getRealInfEqual();

		/**
		 * The meta object literal for the '<em><b>Left Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REAL_INF_EQUAL__LEFT_VALUE = eINSTANCE.getRealInfEqual_LeftValue();

		/**
		 * The meta object literal for the '<em><b>Right Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REAL_INF_EQUAL__RIGHT_VALUE = eINSTANCE.getRealInfEqual_RightValue();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSupEqualImpl <em>Real Sup Equal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSupEqualImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealSupEqual()
		 * @generated
		 */
		EClass REAL_SUP_EQUAL = eINSTANCE.getRealSupEqual();

		/**
		 * The meta object literal for the '<em><b>Left Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REAL_SUP_EQUAL__LEFT_VALUE = eINSTANCE.getRealSupEqual_LeftValue();

		/**
		 * The meta object literal for the '<em><b>Right Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REAL_SUP_EQUAL__RIGHT_VALUE = eINSTANCE.getRealSupEqual_RightValue();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfPlusAssignementImpl <em>Int Self Plus Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfPlusAssignementImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSelfPlusAssignement()
		 * @generated
		 */
		EClass INT_SELF_PLUS_ASSIGNEMENT = eINSTANCE.getIntSelfPlusAssignement();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfMinusAssignementImpl <em>Int Self Minus Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfMinusAssignementImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSelfMinusAssignement()
		 * @generated
		 */
		EClass INT_SELF_MINUS_ASSIGNEMENT = eINSTANCE.getIntSelfMinusAssignement();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfMultiplyAssignementImpl <em>Int Self Multiply Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfMultiplyAssignementImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSelfMultiplyAssignement()
		 * @generated
		 */
		EClass INT_SELF_MULTIPLY_ASSIGNEMENT = eINSTANCE.getIntSelfMultiplyAssignement();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfDivideAssignementImpl <em>Int Self Divide Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.IntSelfDivideAssignementImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getIntSelfDivideAssignement()
		 * @generated
		 */
		EClass INT_SELF_DIVIDE_ASSIGNEMENT = eINSTANCE.getIntSelfDivideAssignement();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfPlusAssignementImpl <em>Real Self Plus Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfPlusAssignementImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealSelfPlusAssignement()
		 * @generated
		 */
		EClass REAL_SELF_PLUS_ASSIGNEMENT = eINSTANCE.getRealSelfPlusAssignement();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfMinusAssignementImpl <em>Real Self Minus Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfMinusAssignementImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealSelfMinusAssignement()
		 * @generated
		 */
		EClass REAL_SELF_MINUS_ASSIGNEMENT = eINSTANCE.getRealSelfMinusAssignement();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfMultiplyAssignementImpl <em>Real Self Multiply Assignement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.RealSelfMultiplyAssignementImpl
		 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionPackageImpl#getRealSelfMultiplyAssignement()
		 * @generated
		 */
		EClass REAL_SELF_MULTIPLY_ASSIGNEMENT = eINSTANCE.getRealSelfMultiplyAssignement();

	}

} //EditionExtensionPackage
