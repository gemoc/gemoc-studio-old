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
package org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage;

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
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationFactory
 * @model kind="package"
 * @generated
 */
public interface Ccsl4cometaspecialisationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ccsl4cometaspecialisation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.ccsl4cometaspecialisation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ccsl4cometaccslspecialisation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Ccsl4cometaspecialisationPackage eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaClockImpl <em>CCSL4 Cometa Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaClockImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaClock()
	 * @generated
	 */
	int CCSL4_COMETA_CLOCK = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_CLOCK__CONTENT = CometatimePackage.CLOCK_ABSTRACTION__CONTENT;

	/**
	 * The feature id for the '<em><b>Is Refered In Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_CLOCK__IS_REFERED_IN_CONSTRAINTS = CometatimePackage.CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Is Referedby Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_CLOCK__IS_REFEREDBY_EVENTS = CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS;

	/**
	 * The feature id for the '<em><b>Is Referedby Trigger</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_CLOCK__IS_REFEREDBY_TRIGGER = CometatimePackage.CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER;

	/**
	 * The number of structural features of the '<em>CCSL4 Cometa Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_CLOCK_FEATURE_COUNT = CometatimePackage.CLOCK_ABSTRACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CCSL4 Cometa Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_CLOCK_OPERATION_COUNT = CometatimePackage.CLOCK_ABSTRACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaBlockAbstractionImpl <em>CCSL4 Cometa Block Abstraction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaBlockAbstractionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaBlockAbstraction()
	 * @generated
	 */
	int CCSL4_COMETA_BLOCK_ABSTRACTION = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_BLOCK_ABSTRACTION__CONTENT = CometamocPackage.OPAQUE_BLOCK__CONTENT;

	/**
	 * The feature id for the '<em><b>Rt Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_BLOCK_ABSTRACTION__RT_ELEMENTS = CometamocPackage.OPAQUE_BLOCK__RT_ELEMENTS;

	/**
	 * The number of structural features of the '<em>CCSL4 Cometa Block Abstraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_BLOCK_ABSTRACTION_FEATURE_COUNT = CometamocPackage.OPAQUE_BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CCSL4 Cometa Block Abstraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_BLOCK_ABSTRACTION_OPERATION_COUNT = CometamocPackage.OPAQUE_BLOCK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaTimeConstraintImpl <em>CCSL4 Cometa Time Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaTimeConstraintImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaTimeConstraint()
	 * @generated
	 */
	int CCSL4_COMETA_TIME_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_TIME_CONSTRAINT__CONTENT = CometatimePackage.TIME_CONSTRAINT__CONTENT;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_TIME_CONSTRAINT__USES = CometatimePackage.TIME_CONSTRAINT__USES;

	/**
	 * The number of structural features of the '<em>CCSL4 Cometa Time Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_TIME_CONSTRAINT_FEATURE_COUNT = CometatimePackage.TIME_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CCSL4 Cometa Time Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_TIME_CONSTRAINT_OPERATION_COUNT = CometatimePackage.TIME_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaComplexTriggerImpl <em>CCSL4 Cometa Complex Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaComplexTriggerImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaComplexTrigger()
	 * @generated
	 */
	int CCSL4_COMETA_COMPLEX_TRIGGER = 3;

	/**
	 * The feature id for the '<em><b>True Triggers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMPLEX_TRIGGER__TRUE_TRIGGERS = FsmdefinitionPackage.TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>False Triggers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMPLEX_TRIGGER__FALSE_TRIGGERS = FsmdefinitionPackage.TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CCSL4 Cometa Complex Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMPLEX_TRIGGER_FEATURE_COUNT = FsmdefinitionPackage.TRIGGER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>CCSL4 Cometa Complex Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMPLEX_TRIGGER_OPERATION_COUNT = FsmdefinitionPackage.TRIGGER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaCometaSystemSpecificationImpl <em>CCSL4 Cometa Cometa System Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaCometaSystemSpecificationImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaCometaSystemSpecification()
	 * @generated
	 */
	int CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Moc Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__MOC_LIB = CometaPackage.COMETA_SYSTEM_SPECIFICATION__MOC_LIB;

	/**
	 * The feature id for the '<em><b>Data Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__DATA_LIB = CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB;

	/**
	 * The feature id for the '<em><b>Structure Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB = CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB;

	/**
	 * The feature id for the '<em><b>Time Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__TIME_LIB = CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB;

	/**
	 * The feature id for the '<em><b>Ccsl Lib</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB = CometaPackage.COMETA_SYSTEM_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CCSL4 Cometa Cometa System Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION_FEATURE_COUNT = CometaPackage.COMETA_SYSTEM_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CCSL4 Cometa Cometa System Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION_OPERATION_COUNT = CometaPackage.COMETA_SYSTEM_SPECIFICATION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaGuardImpl <em>CCSL4 Cometa Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaGuardImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaGuard()
	 * @generated
	 */
	int CCSL4_COMETA_GUARD = 5;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_GUARD__CONTENT = CometamocPackage.COMETA_GUARD__CONTENT;

	/**
	 * The feature id for the '<em><b>Rt Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_GUARD__RT_ELEMENTS = CometamocPackage.COMETA_GUARD__RT_ELEMENTS;

	/**
	 * The number of structural features of the '<em>CCSL4 Cometa Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_GUARD_FEATURE_COUNT = CometamocPackage.COMETA_GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CCSL4 Cometa Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_GUARD_OPERATION_COUNT = CometamocPackage.COMETA_GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaActionImpl <em>CCSL4 Cometa Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaActionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaAction()
	 * @generated
	 */
	int CCSL4_COMETA_ACTION = 6;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_ACTION__CONTENT = CometamocPackage.COMETA_ACTION__CONTENT;

	/**
	 * The feature id for the '<em><b>Rt Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_ACTION__RT_ELEMENTS = CometamocPackage.COMETA_ACTION__RT_ELEMENTS;

	/**
	 * The number of structural features of the '<em>CCSL4 Cometa Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_ACTION_FEATURE_COUNT = CometamocPackage.COMETA_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CCSL4 Cometa Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL4_COMETA_ACTION_OPERATION_COUNT = CometamocPackage.COMETA_ACTION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaClock <em>CCSL4 Cometa Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL4 Cometa Clock</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaClock
	 * @generated
	 */
	EClass getCCSL4CometaClock();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaBlockAbstraction <em>CCSL4 Cometa Block Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL4 Cometa Block Abstraction</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaBlockAbstraction
	 * @generated
	 */
	EClass getCCSL4CometaBlockAbstraction();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaTimeConstraint <em>CCSL4 Cometa Time Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL4 Cometa Time Constraint</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaTimeConstraint
	 * @generated
	 */
	EClass getCCSL4CometaTimeConstraint();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger <em>CCSL4 Cometa Complex Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL4 Cometa Complex Trigger</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger
	 * @generated
	 */
	EClass getCCSL4CometaComplexTrigger();

	/**
	 * Returns the meta object for the attribute list '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger#getTrueTriggers <em>True Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>True Triggers</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger#getTrueTriggers()
	 * @see #getCCSL4CometaComplexTrigger()
	 * @generated
	 */
	EAttribute getCCSL4CometaComplexTrigger_TrueTriggers();

	/**
	 * Returns the meta object for the attribute list '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger#getFalseTriggers <em>False Triggers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>False Triggers</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger#getFalseTriggers()
	 * @see #getCCSL4CometaComplexTrigger()
	 * @generated
	 */
	EAttribute getCCSL4CometaComplexTrigger_FalseTriggers();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification <em>CCSL4 Cometa Cometa System Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL4 Cometa Cometa System Specification</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification
	 * @generated
	 */
	EClass getCCSL4CometaCometaSystemSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification#getCcslLib <em>Ccsl Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ccsl Lib</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification#getCcslLib()
	 * @see #getCCSL4CometaCometaSystemSpecification()
	 * @generated
	 */
	EReference getCCSL4CometaCometaSystemSpecification_CcslLib();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaGuard <em>CCSL4 Cometa Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL4 Cometa Guard</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaGuard
	 * @generated
	 */
	EClass getCCSL4CometaGuard();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaAction <em>CCSL4 Cometa Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL4 Cometa Action</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaAction
	 * @generated
	 */
	EClass getCCSL4CometaAction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Ccsl4cometaspecialisationFactory getCcsl4cometaspecialisationFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaClockImpl <em>CCSL4 Cometa Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaClockImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaClock()
		 * @generated
		 */
		EClass CCSL4_COMETA_CLOCK = eINSTANCE.getCCSL4CometaClock();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaBlockAbstractionImpl <em>CCSL4 Cometa Block Abstraction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaBlockAbstractionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaBlockAbstraction()
		 * @generated
		 */
		EClass CCSL4_COMETA_BLOCK_ABSTRACTION = eINSTANCE.getCCSL4CometaBlockAbstraction();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaTimeConstraintImpl <em>CCSL4 Cometa Time Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaTimeConstraintImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaTimeConstraint()
		 * @generated
		 */
		EClass CCSL4_COMETA_TIME_CONSTRAINT = eINSTANCE.getCCSL4CometaTimeConstraint();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaComplexTriggerImpl <em>CCSL4 Cometa Complex Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaComplexTriggerImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaComplexTrigger()
		 * @generated
		 */
		EClass CCSL4_COMETA_COMPLEX_TRIGGER = eINSTANCE.getCCSL4CometaComplexTrigger();

		/**
		 * The meta object literal for the '<em><b>True Triggers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CCSL4_COMETA_COMPLEX_TRIGGER__TRUE_TRIGGERS = eINSTANCE.getCCSL4CometaComplexTrigger_TrueTriggers();

		/**
		 * The meta object literal for the '<em><b>False Triggers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CCSL4_COMETA_COMPLEX_TRIGGER__FALSE_TRIGGERS = eINSTANCE.getCCSL4CometaComplexTrigger_FalseTriggers();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaCometaSystemSpecificationImpl <em>CCSL4 Cometa Cometa System Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaCometaSystemSpecificationImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaCometaSystemSpecification()
		 * @generated
		 */
		EClass CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION = eINSTANCE.getCCSL4CometaCometaSystemSpecification();

		/**
		 * The meta object literal for the '<em><b>Ccsl Lib</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION__CCSL_LIB = eINSTANCE.getCCSL4CometaCometaSystemSpecification_CcslLib();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaGuardImpl <em>CCSL4 Cometa Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaGuardImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaGuard()
		 * @generated
		 */
		EClass CCSL4_COMETA_GUARD = eINSTANCE.getCCSL4CometaGuard();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaActionImpl <em>CCSL4 Cometa Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.CCSL4CometaActionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationPackageImpl#getCCSL4CometaAction()
		 * @generated
		 */
		EClass CCSL4_COMETA_ACTION = eINSTANCE.getCCSL4CometaAction();

	}

} //Ccsl4cometaspecialisationPackage
