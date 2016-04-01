/**
 */
package tfsm_plaink3Trace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.executionframework.engine.mse.MsePackage;

import org.gemoc.sample.tfsm_plaink3.TfsmPackage;

import tfsm_plaink3Trace.States.StatesPackage;

import tfsm_plaink3Trace.States.impl.StatesPackageImpl;

import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package;

import tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl;

import tfsm_plaink3Trace.Steps.StepsPackage;

import tfsm_plaink3Trace.Steps.impl.StepsPackageImpl;

import tfsm_plaink3Trace.Tfsm_plaink3TraceFactory;
import tfsm_plaink3Trace.Tfsm_plaink3TracePackage;
import tfsm_plaink3Trace.Trace;

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
	private EClass traceEClass = null;

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
		MsePackage.eINSTANCE.eClass();
		TfsmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		StepsPackageImpl theStepsPackage = (StepsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) instanceof StepsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) : StepsPackage.eINSTANCE);
		StatesPackageImpl theStatesPackage = (StatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) instanceof StatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) : StatesPackage.eINSTANCE);
		Tfsm_plaink3PackageImpl theTfsm_plaink3Package = (Tfsm_plaink3PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3Package.eNS_URI) instanceof Tfsm_plaink3PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3Package.eNS_URI) : Tfsm_plaink3Package.eINSTANCE);

		// Create package meta-data objects
		theTfsm_plaink3TracePackage.createPackageContents();
		theStepsPackage.createPackageContents();
		theStatesPackage.createPackageContents();
		theTfsm_plaink3Package.createPackageContents();

		// Initialize created meta-data
		theTfsm_plaink3TracePackage.initializePackageContents();
		theStepsPackage.initializePackageContents();
		theStatesPackage.initializePackageContents();
		theTfsm_plaink3Package.initializePackageContents();

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
	public EClass getTrace() {
		return traceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence() {
		return (EReference)traceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence() {
		return (EReference)traceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence() {
		return (EReference)traceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_State_Visit_Sequence() {
		return (EReference)traceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_TFSM_Init_Sequence() {
		return (EReference)traceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_Transition_Fire_Sequence() {
		return (EReference)traceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_Transition_Visit_Sequence() {
		return (EReference)traceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_RootSteps() {
		return (EReference)traceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_StatesTrace() {
		return (EReference)traceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_tracedFSMClocks() {
		return (EReference)traceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_tracedFSMEvents() {
		return (EReference)traceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTrace_Tfsm_plaink3_tracedTFSMs() {
		return (EReference)traceEClass.getEStructuralFeatures().get(11);
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
		traceEClass = createEClass(TRACE);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE);
		createEReference(traceEClass, TRACE__ROOT_STEPS);
		createEReference(traceEClass, TRACE__STATES_TRACE);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS);
		createEReference(traceEClass, TRACE__TFSM_PLAINK3_TRACED_TFS_MS);
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
		Tfsm_plaink3Package theTfsm_plaink3Package = (Tfsm_plaink3Package)EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3Package.eNS_URI);

		// Add subpackages
		getESubpackages().add(theStepsPackage);
		getESubpackages().add(theStatesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(traceEClass, Trace.class, "Trace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence(), theStepsPackage.getTfsm_plaink3_FSMClock_Ticks(), null, "Tfsm_plaink3_FSMClock_Ticks_Sequence", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence(), theStepsPackage.getTfsm_plaink3_FSMEvent_Trigger(), null, "Tfsm_plaink3_FSMEvent_Trigger_Sequence", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence(), theStepsPackage.getTfsm_plaink3_FSMEvent_UnTrigger(), null, "Tfsm_plaink3_FSMEvent_UnTrigger_Sequence", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_State_Visit_Sequence(), theStepsPackage.getTfsm_plaink3_State_Visit(), null, "Tfsm_plaink3_State_Visit_Sequence", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_TFSM_Init_Sequence(), theStepsPackage.getTfsm_plaink3_TFSM_Init(), null, "Tfsm_plaink3_TFSM_Init_Sequence", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_Transition_Fire_Sequence(), theStepsPackage.getTfsm_plaink3_Transition_Fire(), null, "Tfsm_plaink3_Transition_Fire_Sequence", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_Transition_Visit_Sequence(), theStepsPackage.getTfsm_plaink3_Transition_Visit(), null, "Tfsm_plaink3_Transition_Visit_Sequence", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_RootSteps(), theStepsPackage.getStep(), null, "rootSteps", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_StatesTrace(), theStatesPackage.getState(), null, "statesTrace", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_tracedFSMClocks(), theTfsm_plaink3Package.getTracedFSMClock(), null, "tfsm_plaink3_tracedFSMClocks", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_tracedFSMEvents(), theTfsm_plaink3Package.getTracedFSMEvent(), null, "tfsm_plaink3_tracedFSMEvents", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTrace_Tfsm_plaink3_tracedTFSMs(), theTfsm_plaink3Package.getTracedTFSM(), null, "tfsm_plaink3_tracedTFSMs", null, 0, -1, Trace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Tfsm_plaink3TracePackageImpl
