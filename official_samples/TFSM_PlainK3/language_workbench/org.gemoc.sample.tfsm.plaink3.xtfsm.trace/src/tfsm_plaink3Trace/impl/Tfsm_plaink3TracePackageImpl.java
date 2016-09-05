/**
 */
package tfsm_plaink3Trace.impl;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package;

import tfsm_plaink3Trace.SpecificTrace;

import tfsm_plaink3Trace.States.StatesPackage;

import tfsm_plaink3Trace.States.impl.StatesPackageImpl;

import tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl;

import tfsm_plaink3Trace.Steps.StepsPackage;

import tfsm_plaink3Trace.Steps.impl.StepsPackageImpl;

import tfsm_plaink3Trace.Tfsm_plaink3TraceFactory;
import tfsm_plaink3Trace.Tfsm_plaink3TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tfsm_plaink3TracePackageImpl extends EPackageImpl implements Tfsm_plaink3TracePackage {
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Tfsm_plaink3TracePackageImpl() {
		super(eNS_URI, Tfsm_plaink3TraceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Tfsm_plaink3TracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Tfsm_plaink3TracePackage init() {
		if (isInited) return (Tfsm_plaink3TracePackage)EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3TracePackage.eNS_URI);

		// Obtain or create and register package
		Tfsm_plaink3TracePackageImpl theTfsm_plaink3TracePackage = (Tfsm_plaink3TracePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Tfsm_plaink3TracePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Tfsm_plaink3TracePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TracePackage.eINSTANCE.eClass();
		Tfsm_plaink3Package.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		StepsPackageImpl theStepsPackage = (StepsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) instanceof StepsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) : StepsPackage.eINSTANCE);
		StatesPackageImpl theStatesPackage = (StatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) instanceof StatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) : StatesPackage.eINSTANCE);
		Tfsm_plaink3PackageImpl theTfsm_plaink3Package_1 = (Tfsm_plaink3PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI) instanceof Tfsm_plaink3PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI) : tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE);

		// Create package meta-data objects
		theTfsm_plaink3TracePackage.createPackageContents();
		theStepsPackage.createPackageContents();
		theStatesPackage.createPackageContents();
		theTfsm_plaink3Package_1.createPackageContents();

		// Initialize created meta-data
		theTfsm_plaink3TracePackage.initializePackageContents();
		theStepsPackage.initializePackageContents();
		theStatesPackage.initializePackageContents();
		theTfsm_plaink3Package_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTfsm_plaink3TracePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Tfsm_plaink3TracePackage.eNS_URI, theTfsm_plaink3TracePackage);
		return theTfsm_plaink3TracePackage;
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
	public EReference getSpecificTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_State_Visit_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_TFSM_Init_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_Transition_Fire_Sequence() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_Transition_Visit_Sequence() {
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
	public EReference getSpecificTrace_Tfsm_plaink3_tracedEvaluateGuards() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_tracedEventGuards() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_tracedFSMClocks() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_tracedFSMEvents() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_tracedStates() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_tracedTFSMs() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_tracedTemporalGuards() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_tracedTimedSystems() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificTrace_Tfsm_plaink3_tracedTransitions() {
		return (EReference)specificTraceEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3TraceFactory getTfsm_plaink3TraceFactory() {
		return (Tfsm_plaink3TraceFactory)getEFactoryInstance();
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
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__STATES_TRACE);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS);
		createEReference(specificTraceEClass, SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS);
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
		tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package theTfsm_plaink3Package_1 = (tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package)EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI);

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

		// Initialize classes, features, and operations; add parameters
		initEClass(specificTraceEClass, SpecificTrace.class, "SpecificTrace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence(), theStepsPackage.getTfsm_plaink3_FSMClock_Ticks(), null, "Tfsm_plaink3_FSMClock_Ticks_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence(), theStepsPackage.getTfsm_plaink3_FSMEvent_Trigger(), null, "Tfsm_plaink3_FSMEvent_Trigger_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence(), theStepsPackage.getTfsm_plaink3_FSMEvent_UnTrigger(), null, "Tfsm_plaink3_FSMEvent_UnTrigger_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_State_Visit_Sequence(), theStepsPackage.getTfsm_plaink3_State_Visit(), null, "Tfsm_plaink3_State_Visit_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_TFSM_Init_Sequence(), theStepsPackage.getTfsm_plaink3_TFSM_Init(), null, "Tfsm_plaink3_TFSM_Init_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_Transition_Fire_Sequence(), theStepsPackage.getTfsm_plaink3_Transition_Fire(), null, "Tfsm_plaink3_Transition_Fire_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_Transition_Visit_Sequence(), theStepsPackage.getTfsm_plaink3_Transition_Visit(), null, "Tfsm_plaink3_Transition_Visit_Sequence", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_StatesTrace(), theStatesPackage.getState(), null, "statesTrace", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedEvaluateGuards(), theTfsm_plaink3Package_1.getTracedEvaluateGuard(), null, "tfsm_plaink3_tracedEvaluateGuards", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedEventGuards(), theTfsm_plaink3Package_1.getTracedEventGuard(), null, "tfsm_plaink3_tracedEventGuards", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedFSMClocks(), theTfsm_plaink3Package_1.getTracedFSMClock(), null, "tfsm_plaink3_tracedFSMClocks", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedFSMEvents(), theTfsm_plaink3Package_1.getTracedFSMEvent(), null, "tfsm_plaink3_tracedFSMEvents", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedStates(), theTfsm_plaink3Package_1.getTracedState(), null, "tfsm_plaink3_tracedStates", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedTFSMs(), theTfsm_plaink3Package_1.getTracedTFSM(), null, "tfsm_plaink3_tracedTFSMs", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedTemporalGuards(), theTfsm_plaink3Package_1.getTracedTemporalGuard(), null, "tfsm_plaink3_tracedTemporalGuards", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedTimedSystems(), theTfsm_plaink3Package_1.getTracedTimedSystem(), null, "tfsm_plaink3_tracedTimedSystems", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSpecificTrace_Tfsm_plaink3_tracedTransitions(), theTfsm_plaink3Package_1.getTracedTransition(), null, "tfsm_plaink3_tracedTransitions", null, 0, -1, SpecificTrace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Tfsm_plaink3TracePackageImpl
