/**
 */
package tfsm_plaink3Trace.States.impl;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package;

import tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value;
import tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value;
import tfsm_plaink3Trace.States.State;
import tfsm_plaink3Trace.States.StatesFactory;
import tfsm_plaink3Trace.States.StatesPackage;
import tfsm_plaink3Trace.States.TFSM_currentState_Value;
import tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value;
import tfsm_plaink3Trace.States.TFSM_stepNumber_Value;
import tfsm_plaink3Trace.States.Value;

import tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl;

import tfsm_plaink3Trace.Steps.StepsPackage;

import tfsm_plaink3Trace.Steps.impl.StepsPackageImpl;

import tfsm_plaink3Trace.Tfsm_plaink3TracePackage;

import tfsm_plaink3Trace.impl.Tfsm_plaink3TracePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatesPackageImpl extends EPackageImpl implements StatesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmClock_numberOfTicks_ValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmEvent_isTriggered_ValueEClass = null;

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
	private EClass tfsM_currentState_ValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsM_lastStateChangeStepNumber_ValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsM_stepNumber_ValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

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
	 * @see tfsm_plaink3Trace.States.StatesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StatesPackageImpl() {
		super(eNS_URI, StatesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StatesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StatesPackage init() {
		if (isInited) return (StatesPackage)EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI);

		// Obtain or create and register package
		StatesPackageImpl theStatesPackage = (StatesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StatesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StatesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TracePackage.eINSTANCE.eClass();
		Tfsm_plaink3Package.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Tfsm_plaink3TracePackageImpl theTfsm_plaink3TracePackage = (Tfsm_plaink3TracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3TracePackage.eNS_URI) instanceof Tfsm_plaink3TracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3TracePackage.eNS_URI) : Tfsm_plaink3TracePackage.eINSTANCE);
		StepsPackageImpl theStepsPackage = (StepsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) instanceof StepsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) : StepsPackage.eINSTANCE);
		Tfsm_plaink3PackageImpl theTfsm_plaink3Package_1 = (Tfsm_plaink3PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI) instanceof Tfsm_plaink3PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI) : tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE);

		// Create package meta-data objects
		theStatesPackage.createPackageContents();
		theTfsm_plaink3TracePackage.createPackageContents();
		theStepsPackage.createPackageContents();
		theTfsm_plaink3Package_1.createPackageContents();

		// Initialize created meta-data
		theStatesPackage.initializePackageContents();
		theTfsm_plaink3TracePackage.initializePackageContents();
		theStepsPackage.initializePackageContents();
		theTfsm_plaink3Package_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStatesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StatesPackage.eNS_URI, theStatesPackage);
		return theStatesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMClock_numberOfTicks_Value() {
		return fsmClock_numberOfTicks_ValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMClock_numberOfTicks_Value_NumberOfTicks() {
		return (EAttribute)fsmClock_numberOfTicks_ValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMClock_numberOfTicks_Value_Parent() {
		return (EReference)fsmClock_numberOfTicks_ValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMClock_numberOfTicks_Value_States() {
		return (EReference)fsmClock_numberOfTicks_ValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFSMClock_numberOfTicks_Value__GetStatesNoOpposite() {
		return fsmClock_numberOfTicks_ValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMEvent_isTriggered_Value() {
		return fsmEvent_isTriggered_ValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMEvent_isTriggered_Value_IsTriggered() {
		return (EAttribute)fsmEvent_isTriggered_ValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMEvent_isTriggered_Value_Parent() {
		return (EReference)fsmEvent_isTriggered_ValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFSMEvent_isTriggered_Value_States() {
		return (EReference)fsmEvent_isTriggered_ValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getFSMEvent_isTriggered_Value__GetStatesNoOpposite() {
		return fsmEvent_isTriggered_ValueEClass.getEOperations().get(0);
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
	public EReference getState_EndedSteps() {
		return (EReference)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_FSMClock_numberOfTicks_Values() {
		return (EReference)stateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_FSMEvent_isTriggered_Values() {
		return (EReference)stateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_StartedSteps() {
		return (EReference)stateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_TFSM_currentState_Values() {
		return (EReference)stateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_TFSM_lastStateChangeStepNumber_Values() {
		return (EReference)stateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_TFSM_stepNumber_Values() {
		return (EReference)stateEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFSM_currentState_Value() {
		return tfsM_currentState_ValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFSM_currentState_Value_CurrentState() {
		return (EReference)tfsM_currentState_ValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFSM_currentState_Value_Parent() {
		return (EReference)tfsM_currentState_ValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFSM_currentState_Value_States() {
		return (EReference)tfsM_currentState_ValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTFSM_currentState_Value__GetStatesNoOpposite() {
		return tfsM_currentState_ValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFSM_lastStateChangeStepNumber_Value() {
		return tfsM_lastStateChangeStepNumber_ValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFSM_lastStateChangeStepNumber_Value_LastStateChangeStepNumber() {
		return (EAttribute)tfsM_lastStateChangeStepNumber_ValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFSM_lastStateChangeStepNumber_Value_Parent() {
		return (EReference)tfsM_lastStateChangeStepNumber_ValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFSM_lastStateChangeStepNumber_Value_States() {
		return (EReference)tfsM_lastStateChangeStepNumber_ValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTFSM_lastStateChangeStepNumber_Value__GetStatesNoOpposite() {
		return tfsM_lastStateChangeStepNumber_ValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFSM_stepNumber_Value() {
		return tfsM_stepNumber_ValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFSM_stepNumber_Value_Parent() {
		return (EReference)tfsM_stepNumber_ValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFSM_stepNumber_Value_States() {
		return (EReference)tfsM_stepNumber_ValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFSM_stepNumber_Value_StepNumber() {
		return (EAttribute)tfsM_stepNumber_ValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTFSM_stepNumber_Value__GetStatesNoOpposite() {
		return tfsM_stepNumber_ValueEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValue_StatesNoOpposite() {
		return (EReference)valueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatesFactory getStatesFactory() {
		return (StatesFactory)getEFactoryInstance();
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
		fsmClock_numberOfTicks_ValueEClass = createEClass(FSM_CLOCK_NUMBER_OF_TICKS_VALUE);
		createEAttribute(fsmClock_numberOfTicks_ValueEClass, FSM_CLOCK_NUMBER_OF_TICKS_VALUE__NUMBER_OF_TICKS);
		createEReference(fsmClock_numberOfTicks_ValueEClass, FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT);
		createEReference(fsmClock_numberOfTicks_ValueEClass, FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES);
		createEOperation(fsmClock_numberOfTicks_ValueEClass, FSM_CLOCK_NUMBER_OF_TICKS_VALUE___GET_STATES_NO_OPPOSITE);

		fsmEvent_isTriggered_ValueEClass = createEClass(FSM_EVENT_IS_TRIGGERED_VALUE);
		createEAttribute(fsmEvent_isTriggered_ValueEClass, FSM_EVENT_IS_TRIGGERED_VALUE__IS_TRIGGERED);
		createEReference(fsmEvent_isTriggered_ValueEClass, FSM_EVENT_IS_TRIGGERED_VALUE__PARENT);
		createEReference(fsmEvent_isTriggered_ValueEClass, FSM_EVENT_IS_TRIGGERED_VALUE__STATES);
		createEOperation(fsmEvent_isTriggered_ValueEClass, FSM_EVENT_IS_TRIGGERED_VALUE___GET_STATES_NO_OPPOSITE);

		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__ENDED_STEPS);
		createEReference(stateEClass, STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES);
		createEReference(stateEClass, STATE__FSM_EVENT_IS_TRIGGERED_VALUES);
		createEReference(stateEClass, STATE__STARTED_STEPS);
		createEReference(stateEClass, STATE__TFSM_CURRENT_STATE_VALUES);
		createEReference(stateEClass, STATE__TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES);
		createEReference(stateEClass, STATE__TFSM_STEP_NUMBER_VALUES);

		tfsM_currentState_ValueEClass = createEClass(TFSM_CURRENT_STATE_VALUE);
		createEReference(tfsM_currentState_ValueEClass, TFSM_CURRENT_STATE_VALUE__CURRENT_STATE);
		createEReference(tfsM_currentState_ValueEClass, TFSM_CURRENT_STATE_VALUE__PARENT);
		createEReference(tfsM_currentState_ValueEClass, TFSM_CURRENT_STATE_VALUE__STATES);
		createEOperation(tfsM_currentState_ValueEClass, TFSM_CURRENT_STATE_VALUE___GET_STATES_NO_OPPOSITE);

		tfsM_lastStateChangeStepNumber_ValueEClass = createEClass(TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE);
		createEAttribute(tfsM_lastStateChangeStepNumber_ValueEClass, TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__LAST_STATE_CHANGE_STEP_NUMBER);
		createEReference(tfsM_lastStateChangeStepNumber_ValueEClass, TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__PARENT);
		createEReference(tfsM_lastStateChangeStepNumber_ValueEClass, TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__STATES);
		createEOperation(tfsM_lastStateChangeStepNumber_ValueEClass, TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE___GET_STATES_NO_OPPOSITE);

		tfsM_stepNumber_ValueEClass = createEClass(TFSM_STEP_NUMBER_VALUE);
		createEReference(tfsM_stepNumber_ValueEClass, TFSM_STEP_NUMBER_VALUE__PARENT);
		createEReference(tfsM_stepNumber_ValueEClass, TFSM_STEP_NUMBER_VALUE__STATES);
		createEAttribute(tfsM_stepNumber_ValueEClass, TFSM_STEP_NUMBER_VALUE__STEP_NUMBER);
		createEOperation(tfsM_stepNumber_ValueEClass, TFSM_STEP_NUMBER_VALUE___GET_STATES_NO_OPPOSITE);

		valueEClass = createEClass(VALUE);
		createEReference(valueEClass, VALUE__STATES_NO_OPPOSITE);
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
		tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package theTfsm_plaink3Package_1 = (tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package)EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI);
		StepsPackage theStepsPackage = (StepsPackage)EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theTfsm_plaink3Package_1);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fsmClock_numberOfTicks_ValueEClass.getESuperTypes().add(this.getValue());
		fsmEvent_isTriggered_ValueEClass.getESuperTypes().add(this.getValue());
		tfsM_currentState_ValueEClass.getESuperTypes().add(this.getValue());
		tfsM_lastStateChangeStepNumber_ValueEClass.getESuperTypes().add(this.getValue());
		tfsM_stepNumber_ValueEClass.getESuperTypes().add(this.getValue());

		// Initialize classes, features, and operations; add parameters
		initEClass(fsmClock_numberOfTicks_ValueEClass, FSMClock_numberOfTicks_Value.class, "FSMClock_numberOfTicks_Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMClock_numberOfTicks_Value_NumberOfTicks(), ecorePackage.getEIntegerObject(), "numberOfTicks", null, 0, 1, FSMClock_numberOfTicks_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMClock_numberOfTicks_Value_Parent(), theTfsm_plaink3Package_1.getTracedFSMClock(), theTfsm_plaink3Package_1.getTracedFSMClock_NumberOfTicksSequence(), "parent", null, 1, 1, FSMClock_numberOfTicks_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMClock_numberOfTicks_Value_States(), this.getState(), this.getState_FSMClock_numberOfTicks_Values(), "states", null, 1, -1, FSMClock_numberOfTicks_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getFSMClock_numberOfTicks_Value__GetStatesNoOpposite(), this.getState(), "getStatesNoOpposite", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(fsmEvent_isTriggered_ValueEClass, FSMEvent_isTriggered_Value.class, "FSMEvent_isTriggered_Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMEvent_isTriggered_Value_IsTriggered(), ecorePackage.getEBoolean(), "isTriggered", null, 0, 1, FSMEvent_isTriggered_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMEvent_isTriggered_Value_Parent(), theTfsm_plaink3Package_1.getTracedFSMEvent(), theTfsm_plaink3Package_1.getTracedFSMEvent_IsTriggeredSequence(), "parent", null, 1, 1, FSMEvent_isTriggered_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFSMEvent_isTriggered_Value_States(), this.getState(), this.getState_FSMEvent_isTriggered_Values(), "states", null, 1, -1, FSMEvent_isTriggered_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getFSMEvent_isTriggered_Value__GetStatesNoOpposite(), this.getState(), "getStatesNoOpposite", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_EndedSteps(), theStepsPackage.getSpecificStep(), theStepsPackage.getSpecificStep_EndingState(), "endedSteps", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_FSMClock_numberOfTicks_Values(), this.getFSMClock_numberOfTicks_Value(), this.getFSMClock_numberOfTicks_Value_States(), "fSMClock_numberOfTicks_Values", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getState_FSMEvent_isTriggered_Values(), this.getFSMEvent_isTriggered_Value(), this.getFSMEvent_isTriggered_Value_States(), "fSMEvent_isTriggered_Values", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getState_StartedSteps(), theStepsPackage.getSpecificStep(), theStepsPackage.getSpecificStep_StartingState(), "startedSteps", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_TFSM_currentState_Values(), this.getTFSM_currentState_Value(), this.getTFSM_currentState_Value_States(), "tFSM_currentState_Values", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getState_TFSM_lastStateChangeStepNumber_Values(), this.getTFSM_lastStateChangeStepNumber_Value(), this.getTFSM_lastStateChangeStepNumber_Value_States(), "tFSM_lastStateChangeStepNumber_Values", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getState_TFSM_stepNumber_Values(), this.getTFSM_stepNumber_Value(), this.getTFSM_stepNumber_Value_States(), "tFSM_stepNumber_Values", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tfsM_currentState_ValueEClass, TFSM_currentState_Value.class, "TFSM_currentState_Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTFSM_currentState_Value_CurrentState(), theTfsm_plaink3Package_1.getTracedState(), null, "currentState", null, 0, 1, TFSM_currentState_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTFSM_currentState_Value_Parent(), theTfsm_plaink3Package_1.getTracedTFSM(), theTfsm_plaink3Package_1.getTracedTFSM_CurrentStateSequence(), "parent", null, 1, 1, TFSM_currentState_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTFSM_currentState_Value_States(), this.getState(), this.getState_TFSM_currentState_Values(), "states", null, 1, -1, TFSM_currentState_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTFSM_currentState_Value__GetStatesNoOpposite(), this.getState(), "getStatesNoOpposite", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsM_lastStateChangeStepNumber_ValueEClass, TFSM_lastStateChangeStepNumber_Value.class, "TFSM_lastStateChangeStepNumber_Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTFSM_lastStateChangeStepNumber_Value_LastStateChangeStepNumber(), ecorePackage.getEInt(), "lastStateChangeStepNumber", null, 0, 1, TFSM_lastStateChangeStepNumber_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTFSM_lastStateChangeStepNumber_Value_Parent(), theTfsm_plaink3Package_1.getTracedTFSM(), theTfsm_plaink3Package_1.getTracedTFSM_LastStateChangeStepNumberSequence(), "parent", null, 1, 1, TFSM_lastStateChangeStepNumber_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTFSM_lastStateChangeStepNumber_Value_States(), this.getState(), this.getState_TFSM_lastStateChangeStepNumber_Values(), "states", null, 1, -1, TFSM_lastStateChangeStepNumber_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTFSM_lastStateChangeStepNumber_Value__GetStatesNoOpposite(), this.getState(), "getStatesNoOpposite", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsM_stepNumber_ValueEClass, TFSM_stepNumber_Value.class, "TFSM_stepNumber_Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTFSM_stepNumber_Value_Parent(), theTfsm_plaink3Package_1.getTracedTFSM(), theTfsm_plaink3Package_1.getTracedTFSM_StepNumberSequence(), "parent", null, 1, 1, TFSM_stepNumber_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTFSM_stepNumber_Value_States(), this.getState(), this.getState_TFSM_stepNumber_Values(), "states", null, 1, -1, TFSM_stepNumber_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFSM_stepNumber_Value_StepNumber(), ecorePackage.getEInt(), "stepNumber", null, 0, 1, TFSM_stepNumber_Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTFSM_stepNumber_Value__GetStatesNoOpposite(), this.getState(), "getStatesNoOpposite", 1, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValue_StatesNoOpposite(), this.getState(), null, "statesNoOpposite", null, 1, -1, Value.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://www.modelexecution.org/trace/XMOF
		createXMOFAnnotations();
		// aspect
		createAspectAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.modelexecution.org/trace/XMOF</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXMOFAnnotations() {
		String source = "http://www.modelexecution.org/trace/XMOF";	
		addAnnotation
		  (fsmClock_numberOfTicks_ValueEClass, 
		   source, 
		   new String[] {
			 "executionMetamodelElement", null
		   });	
		addAnnotation
		  (fsmEvent_isTriggered_ValueEClass, 
		   source, 
		   new String[] {
			 "executionMetamodelElement", null
		   });	
		addAnnotation
		  (tfsM_currentState_ValueEClass, 
		   source, 
		   new String[] {
			 "executionMetamodelElement", null
		   });	
		addAnnotation
		  (tfsM_lastStateChangeStepNumber_ValueEClass, 
		   source, 
		   new String[] {
			 "executionMetamodelElement", null
		   });	
		addAnnotation
		  (tfsM_stepNumber_ValueEClass, 
		   source, 
		   new String[] {
			 "executionMetamodelElement", null
		   });
	}

	/**
	 * Initializes the annotations for <b>aspect</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createAspectAnnotations() {
		String source = "aspect";	
		addAnnotation
		  (getFSMClock_numberOfTicks_Value_NumberOfTicks(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getFSMEvent_isTriggered_Value_IsTriggered(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTFSM_currentState_Value_CurrentState(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTFSM_lastStateChangeStepNumber_Value_LastStateChangeStepNumber(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTFSM_stepNumber_Value_StepNumber(), 
		   source, 
		   new String[] {
		   });
	}

} //StatesPackageImpl
