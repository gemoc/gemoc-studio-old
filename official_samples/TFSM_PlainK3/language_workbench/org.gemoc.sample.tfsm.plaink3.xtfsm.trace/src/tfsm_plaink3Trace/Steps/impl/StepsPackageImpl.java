/**
 */
package tfsm_plaink3Trace.Steps.impl;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package;

import tfsm_plaink3Trace.States.StatesPackage;

import tfsm_plaink3Trace.States.impl.StatesPackageImpl;

import tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl;

import tfsm_plaink3Trace.Steps.RootImplicitStep;
import tfsm_plaink3Trace.Steps.SpecificStep;
import tfsm_plaink3Trace.Steps.StepsFactory;
import tfsm_plaink3Trace.Steps.StepsPackage;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_AbstractSubStep;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_ImplicitStep;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_ImplicitStep;

import tfsm_plaink3Trace.Tfsm_plaink3TracePackage;

import tfsm_plaink3Trace.impl.Tfsm_plaink3TracePackageImpl;

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
	private EClass tfsm_plaink3_FSMClock_TicksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_FSMEvent_TriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_FSMEvent_UnTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_State_VisitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_State_Visit_AbstractSubStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_State_Visit_ImplicitStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_TFSM_InitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_Transition_FireEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_Transition_VisitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_Transition_Visit_AbstractSubStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsm_plaink3_Transition_Visit_ImplicitStepEClass = null;

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
	 * @see tfsm_plaink3Trace.Steps.StepsPackage#eNS_URI
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
		Tfsm_plaink3Package.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Tfsm_plaink3TracePackageImpl theTfsm_plaink3TracePackage = (Tfsm_plaink3TracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3TracePackage.eNS_URI) instanceof Tfsm_plaink3TracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3TracePackage.eNS_URI) : Tfsm_plaink3TracePackage.eINSTANCE);
		StatesPackageImpl theStatesPackage = (StatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) instanceof StatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) : StatesPackage.eINSTANCE);
		Tfsm_plaink3PackageImpl theTfsm_plaink3Package_1 = (Tfsm_plaink3PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI) instanceof Tfsm_plaink3PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI) : tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE);

		// Create package meta-data objects
		theStepsPackage.createPackageContents();
		theTfsm_plaink3TracePackage.createPackageContents();
		theStatesPackage.createPackageContents();
		theTfsm_plaink3Package_1.createPackageContents();

		// Initialize created meta-data
		theStepsPackage.initializePackageContents();
		theTfsm_plaink3TracePackage.initializePackageContents();
		theStatesPackage.initializePackageContents();
		theTfsm_plaink3Package_1.initializePackageContents();

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
	public EClass getTfsm_plaink3_FSMClock_Ticks() {
		return tfsm_plaink3_FSMClock_TicksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTfsm_plaink3_FSMClock_Ticks__GetCaller() {
		return tfsm_plaink3_FSMClock_TicksEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_FSMEvent_Trigger() {
		return tfsm_plaink3_FSMEvent_TriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTfsm_plaink3_FSMEvent_Trigger__GetCaller() {
		return tfsm_plaink3_FSMEvent_TriggerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_FSMEvent_UnTrigger() {
		return tfsm_plaink3_FSMEvent_UnTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTfsm_plaink3_FSMEvent_UnTrigger__GetCaller() {
		return tfsm_plaink3_FSMEvent_UnTriggerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_State_Visit() {
		return tfsm_plaink3_State_VisitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTfsm_plaink3_State_Visit__GetCaller() {
		return tfsm_plaink3_State_VisitEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_State_Visit_AbstractSubStep() {
		return tfsm_plaink3_State_Visit_AbstractSubStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_State_Visit_ImplicitStep() {
		return tfsm_plaink3_State_Visit_ImplicitStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_TFSM_Init() {
		return tfsm_plaink3_TFSM_InitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTfsm_plaink3_TFSM_Init__GetCaller() {
		return tfsm_plaink3_TFSM_InitEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_Transition_Fire() {
		return tfsm_plaink3_Transition_FireEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTfsm_plaink3_Transition_Fire__GetCaller() {
		return tfsm_plaink3_Transition_FireEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_Transition_Visit() {
		return tfsm_plaink3_Transition_VisitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTfsm_plaink3_Transition_Visit__GetCaller() {
		return tfsm_plaink3_Transition_VisitEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_Transition_Visit_AbstractSubStep() {
		return tfsm_plaink3_Transition_Visit_AbstractSubStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTfsm_plaink3_Transition_Visit_ImplicitStep() {
		return tfsm_plaink3_Transition_Visit_ImplicitStepEClass;
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

		tfsm_plaink3_FSMClock_TicksEClass = createEClass(TFSM_PLAINK3_FSM_CLOCK_TICKS);
		createEOperation(tfsm_plaink3_FSMClock_TicksEClass, TFSM_PLAINK3_FSM_CLOCK_TICKS___GET_CALLER);

		tfsm_plaink3_FSMEvent_TriggerEClass = createEClass(TFSM_PLAINK3_FSM_EVENT_TRIGGER);
		createEOperation(tfsm_plaink3_FSMEvent_TriggerEClass, TFSM_PLAINK3_FSM_EVENT_TRIGGER___GET_CALLER);

		tfsm_plaink3_FSMEvent_UnTriggerEClass = createEClass(TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER);
		createEOperation(tfsm_plaink3_FSMEvent_UnTriggerEClass, TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER___GET_CALLER);

		tfsm_plaink3_State_VisitEClass = createEClass(TFSM_PLAINK3_STATE_VISIT);
		createEOperation(tfsm_plaink3_State_VisitEClass, TFSM_PLAINK3_STATE_VISIT___GET_CALLER);

		tfsm_plaink3_State_Visit_AbstractSubStepEClass = createEClass(TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP);

		tfsm_plaink3_State_Visit_ImplicitStepEClass = createEClass(TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP);

		tfsm_plaink3_TFSM_InitEClass = createEClass(TFSM_PLAINK3_TFSM_INIT);
		createEOperation(tfsm_plaink3_TFSM_InitEClass, TFSM_PLAINK3_TFSM_INIT___GET_CALLER);

		tfsm_plaink3_Transition_FireEClass = createEClass(TFSM_PLAINK3_TRANSITION_FIRE);
		createEOperation(tfsm_plaink3_Transition_FireEClass, TFSM_PLAINK3_TRANSITION_FIRE___GET_CALLER);

		tfsm_plaink3_Transition_VisitEClass = createEClass(TFSM_PLAINK3_TRANSITION_VISIT);
		createEOperation(tfsm_plaink3_Transition_VisitEClass, TFSM_PLAINK3_TRANSITION_VISIT___GET_CALLER);

		tfsm_plaink3_Transition_Visit_AbstractSubStepEClass = createEClass(TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP);

		tfsm_plaink3_Transition_Visit_ImplicitStepEClass = createEClass(TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP);
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
		tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package theTfsm_plaink3Package_1 = (tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package)EPackage.Registry.INSTANCE.getEPackage(tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rootImplicitStepEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		specificStepEClass.getESuperTypes().add(theTracePackage.getStep());
		tfsm_plaink3_FSMClock_TicksEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_plaink3_FSMClock_TicksEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_plaink3_FSMEvent_TriggerEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_plaink3_FSMEvent_TriggerEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_plaink3_FSMEvent_UnTriggerEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_plaink3_FSMEvent_UnTriggerEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		EGenericType g1 = createEGenericType(this.getSpecificStep());
		tfsm_plaink3_State_VisitEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTracePackage.getSequentialStep());
		EGenericType g2 = createEGenericType(this.getTfsm_plaink3_State_Visit_AbstractSubStep());
		g1.getETypeArguments().add(g2);
		tfsm_plaink3_State_VisitEClass.getEGenericSuperTypes().add(g1);
		tfsm_plaink3_State_Visit_AbstractSubStepEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_plaink3_State_Visit_ImplicitStepEClass.getESuperTypes().add(this.getTfsm_plaink3_State_Visit_AbstractSubStep());
		tfsm_plaink3_State_Visit_ImplicitStepEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_plaink3_TFSM_InitEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_plaink3_TFSM_InitEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_plaink3_Transition_FireEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_plaink3_Transition_FireEClass.getESuperTypes().add(theTracePackage.getSmallStep());
		tfsm_plaink3_Transition_FireEClass.getESuperTypes().add(this.getTfsm_plaink3_Transition_Visit_AbstractSubStep());
		g1 = createEGenericType(this.getTfsm_plaink3_State_Visit_AbstractSubStep());
		tfsm_plaink3_Transition_VisitEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getSpecificStep());
		tfsm_plaink3_Transition_VisitEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTracePackage.getSequentialStep());
		g2 = createEGenericType(this.getTfsm_plaink3_Transition_Visit_AbstractSubStep());
		g1.getETypeArguments().add(g2);
		tfsm_plaink3_Transition_VisitEClass.getEGenericSuperTypes().add(g1);
		tfsm_plaink3_Transition_Visit_AbstractSubStepEClass.getESuperTypes().add(this.getSpecificStep());
		tfsm_plaink3_Transition_Visit_ImplicitStepEClass.getESuperTypes().add(this.getTfsm_plaink3_Transition_Visit_AbstractSubStep());
		tfsm_plaink3_Transition_Visit_ImplicitStepEClass.getESuperTypes().add(theTracePackage.getSmallStep());

		// Initialize classes, features, and operations; add parameters
		initEClass(rootImplicitStepEClass, RootImplicitStep.class, "RootImplicitStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(specificStepEClass, SpecificStep.class, "SpecificStep", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificStep_EndingState(), theStatesPackage.getState(), theStatesPackage.getState_EndedSteps(), "endingState", null, 0, 1, SpecificStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecificStep_StartingState(), theStatesPackage.getState(), theStatesPackage.getState_StartedSteps(), "startingState", null, 1, 1, SpecificStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tfsm_plaink3_FSMClock_TicksEClass, Tfsm_plaink3_FSMClock_Ticks.class, "Tfsm_plaink3_FSMClock_Ticks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTfsm_plaink3_FSMClock_Ticks__GetCaller(), theTfsm_plaink3Package_1.getTracedFSMClock(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_plaink3_FSMEvent_TriggerEClass, Tfsm_plaink3_FSMEvent_Trigger.class, "Tfsm_plaink3_FSMEvent_Trigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTfsm_plaink3_FSMEvent_Trigger__GetCaller(), theTfsm_plaink3Package_1.getTracedFSMEvent(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_plaink3_FSMEvent_UnTriggerEClass, Tfsm_plaink3_FSMEvent_UnTrigger.class, "Tfsm_plaink3_FSMEvent_UnTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTfsm_plaink3_FSMEvent_UnTrigger__GetCaller(), theTfsm_plaink3Package_1.getTracedFSMEvent(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_plaink3_State_VisitEClass, Tfsm_plaink3_State_Visit.class, "Tfsm_plaink3_State_Visit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTfsm_plaink3_State_Visit__GetCaller(), theTfsm_plaink3Package_1.getTracedState(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_plaink3_State_Visit_AbstractSubStepEClass, Tfsm_plaink3_State_Visit_AbstractSubStep.class, "Tfsm_plaink3_State_Visit_AbstractSubStep", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tfsm_plaink3_State_Visit_ImplicitStepEClass, Tfsm_plaink3_State_Visit_ImplicitStep.class, "Tfsm_plaink3_State_Visit_ImplicitStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tfsm_plaink3_TFSM_InitEClass, Tfsm_plaink3_TFSM_Init.class, "Tfsm_plaink3_TFSM_Init", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTfsm_plaink3_TFSM_Init__GetCaller(), theTfsm_plaink3Package_1.getTracedTFSM(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_plaink3_Transition_FireEClass, Tfsm_plaink3_Transition_Fire.class, "Tfsm_plaink3_Transition_Fire", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTfsm_plaink3_Transition_Fire__GetCaller(), theTfsm_plaink3Package_1.getTracedTransition(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_plaink3_Transition_VisitEClass, Tfsm_plaink3_Transition_Visit.class, "Tfsm_plaink3_Transition_Visit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getTfsm_plaink3_Transition_Visit__GetCaller(), theTfsm_plaink3Package_1.getTracedTransition(), "getCaller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tfsm_plaink3_Transition_Visit_AbstractSubStepEClass, Tfsm_plaink3_Transition_Visit_AbstractSubStep.class, "Tfsm_plaink3_Transition_Visit_AbstractSubStep", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tfsm_plaink3_Transition_Visit_ImplicitStepEClass, Tfsm_plaink3_Transition_Visit_ImplicitStep.class, "Tfsm_plaink3_Transition_Visit_ImplicitStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //StepsPackageImpl
