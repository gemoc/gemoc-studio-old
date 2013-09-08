/**
 */
package org.gemoc.mocc.model.moccmetamodel.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.mocc.model.moccmetamodel.IntegerAssignment;
import org.gemoc.mocc.model.moccmetamodel.MoccmetamodelFactory;
import org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage;
import org.gemoc.mocc.model.moccmetamodel.State;
import org.gemoc.mocc.model.moccmetamodel.StateBaseRelationLibrary;
import org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition;
import org.gemoc.mocc.model.moccmetamodel.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MoccmetamodelPackageImpl extends EPackageImpl implements MoccmetamodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMachineRelationDefinitionEClass = null;

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
	private EClass stateBaseRelationLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerAssignmentEClass = null;

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
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MoccmetamodelPackageImpl() {
		super(eNS_URI, MoccmetamodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MoccmetamodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MoccmetamodelPackage init() {
		if (isInited) return (MoccmetamodelPackage)EPackage.Registry.INSTANCE.getEPackage(MoccmetamodelPackage.eNS_URI);

		// Obtain or create and register package
		MoccmetamodelPackageImpl theMoccmetamodelPackage = (MoccmetamodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MoccmetamodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MoccmetamodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMoccmetamodelPackage.createPackageContents();

		// Initialize created meta-data
		theMoccmetamodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMoccmetamodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MoccmetamodelPackage.eNS_URI, theMoccmetamodelPackage);
		return theMoccmetamodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMachineRelationDefinition() {
		return stateMachineRelationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineRelationDefinition_OwnedStates() {
		return (EReference)stateMachineRelationDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineRelationDefinition_OwnedTransitions() {
		return (EReference)stateMachineRelationDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineRelationDefinition_InitialState() {
		return (EReference)stateMachineRelationDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineRelationDefinition_FinalState() {
		return (EReference)stateMachineRelationDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineRelationDefinition_ClassicalExpressions() {
		return (EReference)stateMachineRelationDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineRelationDefinition_ConcreteEntities() {
		return (EReference)stateMachineRelationDefinitionEClass.getEStructuralFeatures().get(5);
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
	public EReference getState_OutputTransitions() {
		return (EReference)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_InputTransitions() {
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
	public EClass getStateBaseRelationLibrary() {
		return stateBaseRelationLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerAssignment() {
		return integerAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoccmetamodelFactory getMoccmetamodelFactory() {
		return (MoccmetamodelFactory)getEFactoryInstance();
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
		stateMachineRelationDefinitionEClass = createEClass(STATE_MACHINE_RELATION_DEFINITION);
		createEReference(stateMachineRelationDefinitionEClass, STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES);
		createEReference(stateMachineRelationDefinitionEClass, STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS);
		createEReference(stateMachineRelationDefinitionEClass, STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE);
		createEReference(stateMachineRelationDefinitionEClass, STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE);
		createEReference(stateMachineRelationDefinitionEClass, STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS);
		createEReference(stateMachineRelationDefinitionEClass, STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES);

		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__OUTPUT_TRANSITIONS);
		createEReference(stateEClass, STATE__INPUT_TRANSITIONS);

		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__SOURCE);
		createEReference(transitionEClass, TRANSITION__TARGET);
		createEReference(transitionEClass, TRANSITION__GUARD);
		createEReference(transitionEClass, TRANSITION__TRIGGER);
		createEReference(transitionEClass, TRANSITION__ACTIONS);

		stateBaseRelationLibraryEClass = createEClass(STATE_BASE_RELATION_LIBRARY);

		integerAssignmentEClass = createEClass(INTEGER_ASSIGNMENT);
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
		ClockExpressionAndRelationPackage theClockExpressionAndRelationPackage = (ClockExpressionAndRelationPackage)EPackage.Registry.INSTANCE.getEPackage(ClockExpressionAndRelationPackage.eNS_URI);
		ClassicalExpressionPackage theClassicalExpressionPackage = (ClassicalExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ClassicalExpressionPackage.eNS_URI);
		TimeModelPackage theTimeModelPackage = (TimeModelPackage)EPackage.Registry.INSTANCE.getEPackage(TimeModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stateMachineRelationDefinitionEClass.getESuperTypes().add(theClockExpressionAndRelationPackage.getExternalRelationDefinition());
		stateEClass.getESuperTypes().add(theTimeModelPackage.getNamedElement());
		transitionEClass.getESuperTypes().add(theTimeModelPackage.getNamedElement());
		stateBaseRelationLibraryEClass.getESuperTypes().add(theClockExpressionAndRelationPackage.getLibrary());
		integerAssignmentEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryIntegerExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(stateMachineRelationDefinitionEClass, StateMachineRelationDefinition.class, "StateMachineRelationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachineRelationDefinition_OwnedStates(), this.getState(), null, "ownedStates", null, 0, -1, StateMachineRelationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineRelationDefinition_OwnedTransitions(), this.getTransition(), null, "ownedTransitions", null, 0, -1, StateMachineRelationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineRelationDefinition_InitialState(), this.getState(), null, "initialState", null, 1, 1, StateMachineRelationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineRelationDefinition_FinalState(), this.getState(), null, "finalState", null, 0, -1, StateMachineRelationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineRelationDefinition_ClassicalExpressions(), theClassicalExpressionPackage.getClassicalExpression(), null, "classicalExpressions", null, 0, -1, StateMachineRelationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineRelationDefinition_ConcreteEntities(), theClockExpressionAndRelationPackage.getConcreteEntity(), null, "concreteEntities", null, 0, -1, StateMachineRelationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_OutputTransitions(), this.getTransition(), this.getTransition_Source(), "outputTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_InputTransitions(), this.getTransition(), this.getTransition_Target(), "inputTransitions", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_Source(), this.getState(), this.getState_OutputTransitions(), "source", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Target(), this.getState(), this.getState_InputTransitions(), "target", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Guard(), theClassicalExpressionPackage.getBooleanExpression(), null, "guard", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Trigger(), theClockExpressionAndRelationPackage.getBindableEntity(), null, "trigger", null, 1, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_Actions(), this.getIntegerAssignment(), null, "actions", null, 0, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateBaseRelationLibraryEClass, StateBaseRelationLibrary.class, "StateBaseRelationLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerAssignmentEClass, IntegerAssignment.class, "IntegerAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// Comment
		createCommentAnnotations();
	}

	/**
	 * Initializes the annotations for <b>Comment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCommentAnnotations() {
		String source = "Comment";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "multiplicity", "Several Clocks acting as a trigger is a very helpfull syntactic sugar tricks. It means that clocks in this set must coincides/be synchronous to trigger the Transition",
			 "type", "Here, the expect type for the bindable entities here is an abstract entity whose type is Clock"
		   },
		   new URI[] {
			 URI.createURI(eNS_URI).appendFragment("//Transition/trigger")
		   });
	}

} //MoccmetamodelPackageImpl
