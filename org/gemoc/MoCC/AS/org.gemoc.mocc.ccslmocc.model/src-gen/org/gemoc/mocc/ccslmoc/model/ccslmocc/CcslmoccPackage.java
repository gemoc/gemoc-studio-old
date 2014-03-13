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
package org.gemoc.mocc.ccslmoc.model.ccslmocc;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage;

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
 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.CcslmoccFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface CcslmoccPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ccslmocc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.ccslmocc/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ccslmocc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CcslmoccPackage eINSTANCE = org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StateRelationBasedLibraryImpl <em>State Relation Based Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StateRelationBasedLibraryImpl
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl#getStateRelationBasedLibrary()
	 * @generated
	 */
	int STATE_RELATION_BASED_LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RELATION_BASED_LIBRARY__NAME = ClockExpressionAndRelationPackage.LIBRARY__NAME;

	/**
	 * The feature id for the '<em><b>Expression Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RELATION_BASED_LIBRARY__EXPRESSION_LIBRARIES = ClockExpressionAndRelationPackage.LIBRARY__EXPRESSION_LIBRARIES;

	/**
	 * The feature id for the '<em><b>Relation Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RELATION_BASED_LIBRARY__RELATION_LIBRARIES = ClockExpressionAndRelationPackage.LIBRARY__RELATION_LIBRARIES;

	/**
	 * The feature id for the '<em><b>Predefined Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RELATION_BASED_LIBRARY__PREDEFINED_TYPES = ClockExpressionAndRelationPackage.LIBRARY__PREDEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RELATION_BASED_LIBRARY__IMPORTS = ClockExpressionAndRelationPackage.LIBRARY__IMPORTS;

	/**
	 * The number of structural features of the '<em>State Relation Based Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_RELATION_BASED_LIBRARY_FEATURE_COUNT = ClockExpressionAndRelationPackage.LIBRARY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>State Relation Based Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int STATE_RELATION_BASED_LIBRARY_OPERATION_COUNT = 0;//ClockExpressionAndRelationPackage.LIBRARY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.FinishClockImpl <em>Finish Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.FinishClockImpl
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl#getFinishClock()
	 * @generated
	 */
	int FINISH_CLOCK = 1;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINISH_CLOCK__CLOCK = CometafsmPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Finish Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINISH_CLOCK_FEATURE_COUNT = CometafsmPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StartClockImpl <em>Start Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StartClockImpl
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl#getStartClock()
	 * @generated
	 */
	int START_CLOCK = 2;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CLOCK__CLOCK = CometafsmPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CLOCK_FEATURE_COUNT = CometafsmPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StateMachineRelationDefinitionImpl <em>State Machine Relation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StateMachineRelationDefinitionImpl
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl#getStateMachineRelationDefinition()
	 * @generated
	 */
	int STATE_MACHINE_RELATION_DEFINITION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__NAME = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__DECLARATION = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION__DECLARATION;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__VERSION = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__DEFINITION = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declaration Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__DECLARATION_BLOCK = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__TRANSITIONS = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__STATES = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Final States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__FINAL_STATES = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>State Machine Relation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION_FEATURE_COUNT = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>State Machine Relation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION_OPERATION_COUNT = 0;//ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.StateRelationBasedLibrary <em>State Relation Based Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Relation Based Library</em>'.
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.StateRelationBasedLibrary
	 * @generated
	 */
	EClass getStateRelationBasedLibrary();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.FinishClock <em>Finish Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finish Clock</em>'.
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.FinishClock
	 * @generated
	 */
	EClass getFinishClock();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.FinishClock#getClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clock</em>'.
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.FinishClock#getClock()
	 * @see #getFinishClock()
	 * @generated
	 */
	EReference getFinishClock_Clock();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.StartClock <em>Start Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Clock</em>'.
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.StartClock
	 * @generated
	 */
	EClass getStartClock();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.StartClock#getClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clock</em>'.
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.StartClock#getClock()
	 * @see #getStartClock()
	 * @generated
	 */
	EReference getStartClock_Clock();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.StateMachineRelationDefinition <em>State Machine Relation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine Relation Definition</em>'.
	 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.StateMachineRelationDefinition
	 * @generated
	 */
	EClass getStateMachineRelationDefinition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CcslmoccFactory getCcslmoccFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StateRelationBasedLibraryImpl <em>State Relation Based Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StateRelationBasedLibraryImpl
		 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl#getStateRelationBasedLibrary()
		 * @generated
		 */
		EClass STATE_RELATION_BASED_LIBRARY = eINSTANCE.getStateRelationBasedLibrary();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.FinishClockImpl <em>Finish Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.FinishClockImpl
		 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl#getFinishClock()
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
		 * The meta object literal for the '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StartClockImpl <em>Start Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StartClockImpl
		 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl#getStartClock()
		 * @generated
		 */
		EClass START_CLOCK = eINSTANCE.getStartClock();

		/**
		 * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference START_CLOCK__CLOCK = eINSTANCE.getStartClock_Clock();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StateMachineRelationDefinitionImpl <em>State Machine Relation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.StateMachineRelationDefinitionImpl
		 * @see org.gemoc.mocc.ccslmoc.model.ccslmocc.impl.CcslmoccPackageImpl#getStateMachineRelationDefinition()
		 * @generated
		 */
		EClass STATE_MACHINE_RELATION_DEFINITION = eINSTANCE.getStateMachineRelationDefinition();

	}

} //CcslmoccPackage
