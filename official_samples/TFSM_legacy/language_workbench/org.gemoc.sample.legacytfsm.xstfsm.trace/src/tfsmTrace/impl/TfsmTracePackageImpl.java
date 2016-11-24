/**
 */
package tfsmTrace.impl;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage;

import tfsmTrace.SpecificTrace;

import tfsmTrace.States.StatesPackage;

import tfsmTrace.States.impl.StatesPackageImpl;

import tfsmTrace.States.tfsm.impl.TfsmPackageImpl;

import tfsmTrace.Steps.StepsPackage;

import tfsmTrace.Steps.impl.StepsPackageImpl;

import tfsmTrace.TfsmTraceFactory;
import tfsmTrace.TfsmTracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TfsmTracePackageImpl extends EPackageImpl implements TfsmTracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificTraceEClass = null;

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
	 * @see tfsmTrace.TfsmTracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TfsmTracePackageImpl() {
		super(eNS_URI, TfsmTraceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TfsmTracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TfsmTracePackage init() {
		if (isInited) return (TfsmTracePackage)EPackage.Registry.INSTANCE.getEPackage(TfsmTracePackage.eNS_URI);

		// Obtain or create and register package
		TfsmTracePackageImpl theTfsmTracePackage = (TfsmTracePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TfsmTracePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TfsmTracePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TracePackage.eINSTANCE.eClass();
		TfsmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		StepsPackageImpl theStepsPackage = (StepsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) instanceof StepsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) : StepsPackage.eINSTANCE);
		StatesPackageImpl theStatesPackage = (StatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) instanceof StatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) : StatesPackage.eINSTANCE);
		TfsmPackageImpl theTfsmPackage_1 = (TfsmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(tfsmTrace.States.tfsm.TfsmPackage.eNS_URI) instanceof TfsmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(tfsmTrace.States.tfsm.TfsmPackage.eNS_URI) : tfsmTrace.States.tfsm.TfsmPackage.eINSTANCE);

		// Create package meta-data objects
		theTfsmTracePackage.createPackageContents();
		theStepsPackage.createPackageContents();
		theStatesPackage.createPackageContents();
		theTfsmPackage_1.createPackageContents();

		// Initialize created meta-data
		theTfsmTracePackage.initializePackageContents();
		theStepsPackage.initializePackageContents();
		theStatesPackage.initializePackageContents();
		theTfsmPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTfsmTracePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TfsmTracePackage.eNS_URI, theTfsmTracePackage);
		return theTfsmTracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificTrace() {
		return specificTraceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_FSMClock_Ticks_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_FSMEvent_Trigger_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_FSMEvent_UnTrigger_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_State_Visit_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_TimeFSM_Init_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_Transition_Fire_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_Transition_Visit_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_StatesTrace() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedEvaluateGuards() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedEventGuards() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedFSMClocks() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedFSMEvents() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedStates() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedTemporalGuards() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedTimeFSMs() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedTimedSystems() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_tracedTransitions() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TfsmTraceFactory getTfsmTraceFactory() {
		return (TfsmTraceFactory)getEFactoryInstance();
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
		specificTraceEClass = createEClass(SPECIFIC_TRACE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_FSM_CLOCK_TICKS_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_FSM_EVENT_TRIGGER_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_FSM_EVENT_UN_TRIGGER_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_STATE_VISIT_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TIME_FSM_INIT_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRANSITION_FIRE_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRANSITION_VISIT_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__STATES_TRACE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_STATES);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS);
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
		StepsPackage theStepsPackage = (StepsPackage)EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI);
		StatesPackage theStatesPackage = (StatesPackage)EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI);
		TracePackage theTracePackage = (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);
		tfsmTrace.States.tfsm.TfsmPackage theTfsmPackage_1 = (tfsmTrace.States.tfsm.TfsmPackage)EPackage.Registry.INSTANCE.getEPackage(tfsmTrace.States.tfsm.TfsmPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theStepsPackage);
		getESubpackages().add(theStatesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theTracePackage.getTrace());
		EGenericType g2 = createEGenericType(theTracePackage.getSequentialStep());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(theStepsPackage.getSpecificStep());
		g2.getETypeArguments().add(g3);
		specificTraceEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(specificTraceEClass, SpecificTrace.class, "SpecificTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificTrace_Tfsm_FSMClock_Ticks_Sequence(), theStepsPackage.getTfsm_FSMClock_Ticks(), null, "Tfsm_FSMClock_Ticks_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_FSMEvent_Trigger_Sequence(), theStepsPackage.getTfsm_FSMEvent_Trigger(), null, "Tfsm_FSMEvent_Trigger_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_FSMEvent_UnTrigger_Sequence(), theStepsPackage.getTfsm_FSMEvent_UnTrigger(), null, "Tfsm_FSMEvent_UnTrigger_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_State_Visit_Sequence(), theStepsPackage.getTfsm_State_Visit(), null, "Tfsm_State_Visit_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_TimeFSM_Init_Sequence(), theStepsPackage.getTfsm_TimeFSM_Init(), null, "Tfsm_TimeFSM_Init_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_Transition_Fire_Sequence(), theStepsPackage.getTfsm_Transition_Fire(), null, "Tfsm_Transition_Fire_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_Transition_Visit_Sequence(), theStepsPackage.getTfsm_Transition_Visit(), null, "Tfsm_Transition_Visit_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_StatesTrace(), theStatesPackage.getState(), null, "statesTrace", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedEvaluateGuards(), theTfsmPackage_1.getTracedEvaluateGuard(), null, "tfsm_tracedEvaluateGuards", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedEventGuards(), theTfsmPackage_1.getTracedEventGuard(), null, "tfsm_tracedEventGuards", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedFSMClocks(), theTfsmPackage_1.getTracedFSMClock(), null, "tfsm_tracedFSMClocks", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedFSMEvents(), theTfsmPackage_1.getTracedFSMEvent(), null, "tfsm_tracedFSMEvents", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedStates(), theTfsmPackage_1.getTracedState(), null, "tfsm_tracedStates", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedTemporalGuards(), theTfsmPackage_1.getTracedTemporalGuard(), null, "tfsm_tracedTemporalGuards", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedTimeFSMs(), theTfsmPackage_1.getTracedTimeFSM(), null, "tfsm_tracedTimeFSMs", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedTimedSystems(), theTfsmPackage_1.getTracedTimedSystem(), null, "tfsm_tracedTimedSystems", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_tracedTransitions(), theTfsmPackage_1.getTracedTransition(), null, "tfsm_tracedTransitions", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TfsmTracePackageImpl
