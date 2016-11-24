/**
 */
package tfsmTrace.Steps.impl;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage;

import tfsmTrace.States.StatesPackage;

import tfsmTrace.States.impl.StatesPackageImpl;

import tfsmTrace.States.tfsm.impl.TfsmPackageImpl;

import tfsmTrace.Steps.RootImplicitStep;
import tfsmTrace.Steps.SpecificStep;
import tfsmTrace.Steps.StepsFactory;
import tfsmTrace.Steps.StepsPackage;
import tfsmTrace.Steps.Tfsm_FSMClock_Ticks;
import tfsmTrace.Steps.Tfsm_FSMEvent_Trigger;
import tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger;
import tfsmTrace.Steps.Tfsm_State_Visit;
import tfsmTrace.Steps.Tfsm_State_Visit_AbstractSubStep;
import tfsmTrace.Steps.Tfsm_State_Visit_ImplicitStep;
import tfsmTrace.Steps.Tfsm_TFSM_Init;
import tfsmTrace.Steps.Tfsm_Transition_Fire;
import tfsmTrace.Steps.Tfsm_Transition_Visit;
import tfsmTrace.Steps.Tfsm_Transition_Visit_AbstractSubStep;
import tfsmTrace.Steps.Tfsm_Transition_Visit_ImplicitStep;

import tfsmTrace.TfsmTracePackage;

import tfsmTrace.impl.TfsmTracePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StepsPackageImpl extends EPackageImpl implements StepsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootImplicitStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_FSMClock_TicksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_FSMEvent_TriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_FSMEvent_UnTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_State_VisitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_State_Visit_AbstractSubStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_State_Visit_ImplicitStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_TFSM_InitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_Transition_FireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_Transition_VisitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_Transition_Visit_AbstractSubStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_Transition_Visit_ImplicitStepEClass = null;

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
	 * @see tfsmTrace.Steps.StepsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StepsPackageImpl() {
		super(eNS_URI, StepsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StepsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StepsPackage init() {
		if (isInited) return (StepsPackage)EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI);

		// Obtain or create and register package
		StepsPackageImpl theStepsPackage = (StepsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StepsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StepsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TracePackage.eINSTANCE.eClass();
		TfsmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TfsmTracePackageImpl theTfsmTracePackage = (TfsmTracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TfsmTracePackage.eNS_URI) instanceof TfsmTracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TfsmTracePackage.eNS_URI) : TfsmTracePackage.eINSTANCE);
		StatesPackageImpl theStatesPackage = (StatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) instanceof StatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) : StatesPackage.eINSTANCE);
		TfsmPackageImpl theTfsmPackage_1 = (TfsmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(tfsmTrace.States.tfsm.TfsmPackage.eNS_URI) instanceof TfsmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(tfsmTrace.States.tfsm.TfsmPackage.eNS_URI) : tfsmTrace.States.tfsm.TfsmPackage.eINSTANCE);

		// Create package meta-data objects
		theStepsPackage.createPackageContents();
		theTfsmTracePackage.createPackageContents();
		theStatesPackage.createPackageContents();
		theTfsmPackage_1.createPackageContents();

		// Initialize created meta-data
		theStepsPackage.initializePackageContents();
		theTfsmTracePackage.initializePackageContents();
		theStatesPackage.initializePackageContents();
		theTfsmPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStepsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StepsPackage.eNS_URI, theStepsPackage);
		return theStepsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootImplicitStep() {
		return rootImplicitStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificStep() {
		return specificStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificStep_EndingState() {
		return (EReference)specificStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificStep_StartingState() {
		return (EReference)specificStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_FSMClock_Ticks() {
		return tfsm_FSMClock_TicksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_FSMEvent_Trigger() {
		return tfsm_FSMEvent_TriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_FSMEvent_UnTrigger() {
		return tfsm_FSMEvent_UnTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_State_Visit() {
		return tfsm_State_VisitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_State_Visit_AbstractSubStep() {
		return tfsm_State_Visit_AbstractSubStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_State_Visit_ImplicitStep() {
		return tfsm_State_Visit_ImplicitStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_TFSM_Init() {
		return tfsm_TFSM_InitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_Transition_Fire() {
		return tfsm_Transition_FireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_Transition_Visit() {
		return tfsm_Transition_VisitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_Transition_Visit_AbstractSubStep() {
		return tfsm_Transition_Visit_AbstractSubStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_Transition_Visit_ImplicitStep() {
		return tfsm_Transition_Visit_ImplicitStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepsFactory getStepsFactory() {
		return (StepsFactory)getEFactoryInstance();
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
		rootImplicitStepEClass = createEClass(ROOT_IMPLICIT_STEP);

		specificStepEClass = createEClass(SPECIFIC_STEP);
		createEReference(specificStepEClass, SPECIFIC_STEP__ENDING_STATE);
		createEReference(specificStepEClass, SPECIFIC_STEP__STARTING_STATE);

		tfsm_FSMClock_TicksEClass = createEClass(TFSM_FSM_CLOCK_TICKS);

		tfsm_FSMEvent_TriggerEClass = createEClass(TFSM_FSM_EVENT_TRIGGER);

		tfsm_FSMEvent_UnTriggerEClass = createEClass(TFSM_FSM_EVENT_UN_TRIGGER);

		tfsm_State_VisitEClass = createEClass(TFSM_STATE_VISIT);

		tfsm_State_Visit_AbstractSubStepEClass = createEClass(TFSM_STATE_VISIT_ABSTRACT_SUB_STEP);

		tfsm_State_Visit_ImplicitStepEClass = createEClass(TFSM_STATE_VISIT_IMPLICIT_STEP);

		tfsm_TFSM_InitEClass = createEClass(TFSM_TFSM_INIT);

		tfsm_Transition_FireEClass = createEClass(TFSM_TRANSITION_FIRE);

		tfsm_Transition_VisitEClass = createEClass(TFSM_TRANSITION_VISIT);

		tfsm_Transition_Visit_AbstractSubStepEClass = createEClass(TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP);

		tfsm_Transition_Visit_ImplicitStepEClass = createEClass(TFSM_TRANSITION_VISIT_IMPLICIT_STEP);
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
		TracePackage theTracePackage = (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);
		StatesPackage theStatesPackage = (StatesPackage)EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI);
		tfsmTrace.States.tfsm.TfsmPackage theTfsmPackage_1 = (tfsmTrace.States.tfsm.TfsmPackage)EPackage.Registry.INSTANCE.getEPackage(tfsmTrace.States.tfsm.TfsmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rootImplicitStepEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		specificStepEClass.getESuperTypes().add(theTracePackage.getStep());
		tfsm_FSMClock_TicksEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_FSMClock_TicksEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_FSMEvent_TriggerEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_FSMEvent_TriggerEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_FSMEvent_UnTriggerEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_FSMEvent_UnTriggerEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		EGenericType g1 = createEGenericType(this.getSpecificStep());
		tfsm_State_VisitEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTracePackage.getSequentialStep());
		EGenericType g2 = createEGenericType(this.getTfsm_State_Visit_AbstractSubStep());
		g1.getETypeArguments().add(g2);
		tfsm_State_VisitEClass.getEGenericSuperTypes().add(g1);
		tfsm_State_Visit_AbstractSubStepEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_State_Visit_ImplicitStepEClass.getESuperTypes().add(this.getTfsm_State_Visit_AbstractSubStep());
		tfsm_State_Visit_ImplicitStepEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_TFSM_InitEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_TFSM_InitEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_Transition_FireEClass.getESuperTypes().add(this.getTfsm_Transition_Visit_AbstractSubStep());
		tfsm_Transition_FireEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_Transition_FireEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		g1 = createEGenericType(this.getSpecificStep());
		tfsm_Transition_VisitEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTracePackage.getSequentialStep());
		g2 = createEGenericType(this.getTfsm_Transition_Visit_AbstractSubStep());
		g1.getETypeArguments().add(g2);
		tfsm_Transition_VisitEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getTfsm_State_Visit_AbstractSubStep());
		tfsm_Transition_VisitEClass.getEGenericSuperTypes().add(g1);
		tfsm_Transition_Visit_AbstractSubStepEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_Transition_Visit_ImplicitStepEClass.getESuperTypes().add(this.getTfsm_Transition_Visit_AbstractSubStep());
		tfsm_Transition_Visit_ImplicitStepEClass.getESuperTypes().add(theTracePackage.getSmallStep());

		// Initialize classes and features; add operations and parameters
		initEClass(rootImplicitStepEClass, RootImplicitStep.class, "RootImplicitStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(specificStepEClass, SpecificStep.class, "SpecificStep", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificStep_EndingState(), theStatesPackage.getState(), theStatesPackage.getState_EndedSteps(), "endingState", null, 0, 1, SpecificStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificStep_StartingState(), theStatesPackage.getState(), theStatesPackage.getState_StartedSteps(), "startingState", null, 1, 1, SpecificStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tfsm_FSMClock_TicksEClass, Tfsm_FSMClock_Ticks.class, "Tfsm_FSMClock_Ticks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(tfsm_FSMClock_TicksEClass, theTfsmPackage_1.getTracedFSMClock(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_FSMEvent_TriggerEClass, Tfsm_FSMEvent_Trigger.class, "Tfsm_FSMEvent_Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(tfsm_FSMEvent_TriggerEClass, theTfsmPackage_1.getTracedFSMEvent(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_FSMEvent_UnTriggerEClass, Tfsm_FSMEvent_UnTrigger.class, "Tfsm_FSMEvent_UnTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(tfsm_FSMEvent_UnTriggerEClass, theTfsmPackage_1.getTracedFSMEvent(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_State_VisitEClass, Tfsm_State_Visit.class, "Tfsm_State_Visit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(tfsm_State_VisitEClass, theTfsmPackage_1.getTracedState(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_State_Visit_AbstractSubStepEClass, Tfsm_State_Visit_AbstractSubStep.class, "Tfsm_State_Visit_AbstractSubStep", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tfsm_State_Visit_ImplicitStepEClass, Tfsm_State_Visit_ImplicitStep.class, "Tfsm_State_Visit_ImplicitStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tfsm_TFSM_InitEClass, Tfsm_TFSM_Init.class, "Tfsm_TFSM_Init", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(tfsm_TFSM_InitEClass, theTfsmPackage_1.getTracedTFSM(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_Transition_FireEClass, Tfsm_Transition_Fire.class, "Tfsm_Transition_Fire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(tfsm_Transition_FireEClass, theTfsmPackage_1.getTracedTransition(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_Transition_VisitEClass, Tfsm_Transition_Visit.class, "Tfsm_Transition_Visit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(tfsm_Transition_VisitEClass, theTfsmPackage_1.getTracedTransition(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_Transition_Visit_AbstractSubStepEClass, Tfsm_Transition_Visit_AbstractSubStep.class, "Tfsm_Transition_Visit_AbstractSubStep", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tfsm_Transition_Visit_ImplicitStepEClass, Tfsm_Transition_Visit_ImplicitStep.class, "Tfsm_Transition_Visit_ImplicitStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //StepsPackageImpl
