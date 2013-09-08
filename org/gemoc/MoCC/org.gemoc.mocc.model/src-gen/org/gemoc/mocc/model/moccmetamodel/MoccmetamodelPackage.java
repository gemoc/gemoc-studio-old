/**
 */
package org.gemoc.mocc.model.moccmetamodel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelFactory
 * @model kind="package"
 *        annotation="Comment multiplicity='Several Clocks acting as a trigger is a very helpfull syntactic sugar tricks. It means that clocks in this set must coincides/be synchronous to trigger the Transition' type='Here, the expect type for the bindable entities here is an abstract entity whose type is Clock'"
 * @generated
 */
public interface MoccmetamodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "moccmetamodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.model/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "moccmetamodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MoccmetamodelPackage eINSTANCE = org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl <em>State Machine Relation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getStateMachineRelationDefinition()
	 * @generated
	 */
	int STATE_MACHINE_RELATION_DEFINITION = 0;

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
	 * The feature id for the '<em><b>Owned States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Final State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Classical Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Concrete Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>State Machine Relation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_RELATION_DEFINITION_FEATURE_COUNT = ClockExpressionAndRelationPackage.EXTERNAL_RELATION_DEFINITION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.StateImpl
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = TimeModelPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Output Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTPUT_TRANSITIONS = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INPUT_TRANSITIONS = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.TransitionImpl
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

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
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TRIGGER = TimeModelPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
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
	 * The meta object id for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.StateBaseRelationLibraryImpl <em>State Base Relation Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.StateBaseRelationLibraryImpl
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getStateBaseRelationLibrary()
	 * @generated
	 */
	int STATE_BASE_RELATION_LIBRARY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASE_RELATION_LIBRARY__NAME = ClockExpressionAndRelationPackage.LIBRARY__NAME;

	/**
	 * The feature id for the '<em><b>Expression Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASE_RELATION_LIBRARY__EXPRESSION_LIBRARIES = ClockExpressionAndRelationPackage.LIBRARY__EXPRESSION_LIBRARIES;

	/**
	 * The feature id for the '<em><b>Relation Libraries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASE_RELATION_LIBRARY__RELATION_LIBRARIES = ClockExpressionAndRelationPackage.LIBRARY__RELATION_LIBRARIES;

	/**
	 * The feature id for the '<em><b>Predefined Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASE_RELATION_LIBRARY__PREDEFINED_TYPES = ClockExpressionAndRelationPackage.LIBRARY__PREDEFINED_TYPES;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASE_RELATION_LIBRARY__IMPORTS = ClockExpressionAndRelationPackage.LIBRARY__IMPORTS;

	/**
	 * The number of structural features of the '<em>State Base Relation Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_BASE_RELATION_LIBRARY_FEATURE_COUNT = ClockExpressionAndRelationPackage.LIBRARY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.IntegerAssignmentImpl <em>Integer Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.IntegerAssignmentImpl
	 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getIntegerAssignment()
	 * @generated
	 */
	int INTEGER_ASSIGNMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNMENT__NAME = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNMENT__TYPE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Left Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNMENT__LEFT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__LEFT_VALUE;

	/**
	 * The feature id for the '<em><b>Right Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNMENT__RIGHT_VALUE = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION__RIGHT_VALUE;

	/**
	 * The number of structural features of the '<em>Integer Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ASSIGNMENT_FEATURE_COUNT = ClassicalExpressionPackage.BINARY_INTEGER_EXPRESSION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition <em>State Machine Relation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine Relation Definition</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition
	 * @generated
	 */
	EClass getStateMachineRelationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getOwnedStates <em>Owned States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned States</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getOwnedStates()
	 * @see #getStateMachineRelationDefinition()
	 * @generated
	 */
	EReference getStateMachineRelationDefinition_OwnedStates();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getOwnedTransitions <em>Owned Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Transitions</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getOwnedTransitions()
	 * @see #getStateMachineRelationDefinition()
	 * @generated
	 */
	EReference getStateMachineRelationDefinition_OwnedTransitions();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getInitialState()
	 * @see #getStateMachineRelationDefinition()
	 * @generated
	 */
	EReference getStateMachineRelationDefinition_InitialState();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getFinalState <em>Final State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Final State</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getFinalState()
	 * @see #getStateMachineRelationDefinition()
	 * @generated
	 */
	EReference getStateMachineRelationDefinition_FinalState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getClassicalExpressions <em>Classical Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classical Expressions</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getClassicalExpressions()
	 * @see #getStateMachineRelationDefinition()
	 * @generated
	 */
	EReference getStateMachineRelationDefinition_ClassicalExpressions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getConcreteEntities <em>Concrete Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concrete Entities</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getConcreteEntities()
	 * @see #getStateMachineRelationDefinition()
	 * @generated
	 */
	EReference getStateMachineRelationDefinition_ConcreteEntities();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.model.moccmetamodel.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.model.moccmetamodel.State#getOutputTransitions <em>Output Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Output Transitions</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.State#getOutputTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutputTransitions();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.model.moccmetamodel.State#getInputTransitions <em>Input Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input Transitions</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.State#getInputTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_InputTransitions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.model.moccmetamodel.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guard</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Guard();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trigger</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.Transition#getTrigger()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Trigger();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.Transition#getActions()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Actions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.model.moccmetamodel.StateBaseRelationLibrary <em>State Base Relation Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Base Relation Library</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.StateBaseRelationLibrary
	 * @generated
	 */
	EClass getStateBaseRelationLibrary();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.model.moccmetamodel.IntegerAssignment <em>Integer Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Assignment</em>'.
	 * @see org.gemoc.mocc.model.moccmetamodel.IntegerAssignment
	 * @generated
	 */
	EClass getIntegerAssignment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MoccmetamodelFactory getMoccmetamodelFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl <em>State Machine Relation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getStateMachineRelationDefinition()
		 * @generated
		 */
		EClass STATE_MACHINE_RELATION_DEFINITION = eINSTANCE.getStateMachineRelationDefinition();

		/**
		 * The meta object literal for the '<em><b>Owned States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES = eINSTANCE.getStateMachineRelationDefinition_OwnedStates();

		/**
		 * The meta object literal for the '<em><b>Owned Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS = eINSTANCE.getStateMachineRelationDefinition_OwnedTransitions();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE = eINSTANCE.getStateMachineRelationDefinition_InitialState();

		/**
		 * The meta object literal for the '<em><b>Final State</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE = eINSTANCE.getStateMachineRelationDefinition_FinalState();

		/**
		 * The meta object literal for the '<em><b>Classical Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS = eINSTANCE.getStateMachineRelationDefinition_ClassicalExpressions();

		/**
		 * The meta object literal for the '<em><b>Concrete Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES = eINSTANCE.getStateMachineRelationDefinition_ConcreteEntities();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.StateImpl
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Output Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTPUT_TRANSITIONS = eINSTANCE.getState_OutputTransitions();

		/**
		 * The meta object literal for the '<em><b>Input Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INPUT_TRANSITIONS = eINSTANCE.getState_InputTransitions();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.TransitionImpl
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getTransition()
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
		 * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TRIGGER = eINSTANCE.getTransition_Trigger();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__ACTIONS = eINSTANCE.getTransition_Actions();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.StateBaseRelationLibraryImpl <em>State Base Relation Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.StateBaseRelationLibraryImpl
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getStateBaseRelationLibrary()
		 * @generated
		 */
		EClass STATE_BASE_RELATION_LIBRARY = eINSTANCE.getStateBaseRelationLibrary();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.model.moccmetamodel.impl.IntegerAssignmentImpl <em>Integer Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.IntegerAssignmentImpl
		 * @see org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelPackageImpl#getIntegerAssignment()
		 * @generated
		 */
		EClass INTEGER_ASSIGNMENT = eINSTANCE.getIntegerAssignment();

	}

} //MoccmetamodelPackage
