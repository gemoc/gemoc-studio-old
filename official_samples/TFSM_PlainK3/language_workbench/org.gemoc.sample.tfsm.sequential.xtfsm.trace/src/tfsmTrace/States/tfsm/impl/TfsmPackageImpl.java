/**
 */
package tfsmTrace.States.tfsm.impl;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tfsmTrace.States.StatesPackage;

import tfsmTrace.States.impl.StatesPackageImpl;

import tfsmTrace.States.tfsm.TfsmFactory;
import tfsmTrace.States.tfsm.TfsmPackage;
import tfsmTrace.States.tfsm.TracedEvaluateGuard;
import tfsmTrace.States.tfsm.TracedEventGuard;
import tfsmTrace.States.tfsm.TracedFSMClock;
import tfsmTrace.States.tfsm.TracedFSMEvent;
import tfsmTrace.States.tfsm.TracedGuard;
import tfsmTrace.States.tfsm.TracedNamedElement;
import tfsmTrace.States.tfsm.TracedState;
import tfsmTrace.States.tfsm.TracedTFSM;
import tfsmTrace.States.tfsm.TracedTemporalGuard;
import tfsmTrace.States.tfsm.TracedTimedSystem;
import tfsmTrace.States.tfsm.TracedTransition;

import tfsmTrace.Steps.StepsPackage;

import tfsmTrace.Steps.impl.StepsPackageImpl;

import tfsmTrace.TfsmTracePackage;

import tfsmTrace.impl.TfsmTracePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TfsmPackageImpl extends EPackageImpl implements TfsmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedEvaluateGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedEventGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedFSMClockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedFSMEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedTFSMEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedTemporalGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedTimedSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedTransitionEClass = null;

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
	 * @see tfsmTrace.States.tfsm.TfsmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TfsmPackageImpl() {
		super(eNS_URI, TfsmFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TfsmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TfsmPackage init() {
		if (isInited) return (TfsmPackage)EPackage.Registry.INSTANCE.getEPackage(TfsmPackage.eNS_URI);

		// Obtain or create and register package
		TfsmPackageImpl theTfsmPackage = (TfsmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TfsmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TfsmPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TracePackage.eINSTANCE.eClass();
		org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TfsmTracePackageImpl theTfsmTracePackage = (TfsmTracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TfsmTracePackage.eNS_URI) instanceof TfsmTracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TfsmTracePackage.eNS_URI) : TfsmTracePackage.eINSTANCE);
		StepsPackageImpl theStepsPackage = (StepsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) instanceof StepsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) : StepsPackage.eINSTANCE);
		StatesPackageImpl theStatesPackage = (StatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) instanceof StatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) : StatesPackage.eINSTANCE);

		// Create package meta-data objects
		theTfsmPackage.createPackageContents();
		theTfsmTracePackage.createPackageContents();
		theStepsPackage.createPackageContents();
		theStatesPackage.createPackageContents();

		// Initialize created meta-data
		theTfsmPackage.initializePackageContents();
		theTfsmTracePackage.initializePackageContents();
		theStepsPackage.initializePackageContents();
		theStatesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTfsmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TfsmPackage.eNS_URI, theTfsmPackage);
		return theTfsmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedEvaluateGuard() {
		return tracedEvaluateGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedEvaluateGuard_OriginalObject() {
		return (EReference)tracedEvaluateGuardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedEventGuard() {
		return tracedEventGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedEventGuard_OriginalObject() {
		return (EReference)tracedEventGuardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedFSMClock() {
		return tracedFSMClockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedFSMClock_NumberOfTicksSequence() {
		return (EReference)tracedFSMClockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedFSMClock_OriginalObject() {
		return (EReference)tracedFSMClockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedFSMEvent() {
		return tracedFSMEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedFSMEvent_IsTriggeredSequence() {
		return (EReference)tracedFSMEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedFSMEvent_OriginalObject() {
		return (EReference)tracedFSMEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedGuard() {
		return tracedGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedNamedElement() {
		return tracedNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedState() {
		return tracedStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedState_OriginalObject() {
		return (EReference)tracedStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedTFSM() {
		return tracedTFSMEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_CurrentStateSequence() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_LastStateChangeStepNumberSequence() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_OriginalObject() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_StepNumberSequence() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedTemporalGuard() {
		return tracedTemporalGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTemporalGuard_OriginalObject() {
		return (EReference)tracedTemporalGuardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedTimedSystem() {
		return tracedTimedSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTimedSystem_OriginalObject() {
		return (EReference)tracedTimedSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTracedTransition() {
		return tracedTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTransition_OriginalObject() {
		return (EReference)tracedTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TfsmFactory getTfsmFactory() {
		return (TfsmFactory)getEFactoryInstance();
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
		tracedEvaluateGuardEClass = createEClass(TRACED_EVALUATE_GUARD);
		createEReference(tracedEvaluateGuardEClass, TRACED_EVALUATE_GUARD__ORIGINAL_OBJECT);

		tracedEventGuardEClass = createEClass(TRACED_EVENT_GUARD);
		createEReference(tracedEventGuardEClass, TRACED_EVENT_GUARD__ORIGINAL_OBJECT);

		tracedFSMClockEClass = createEClass(TRACED_FSM_CLOCK);
		createEReference(tracedFSMClockEClass, TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE);
		createEReference(tracedFSMClockEClass, TRACED_FSM_CLOCK__ORIGINAL_OBJECT);

		tracedFSMEventEClass = createEClass(TRACED_FSM_EVENT);
		createEReference(tracedFSMEventEClass, TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE);
		createEReference(tracedFSMEventEClass, TRACED_FSM_EVENT__ORIGINAL_OBJECT);

		tracedGuardEClass = createEClass(TRACED_GUARD);

		tracedNamedElementEClass = createEClass(TRACED_NAMED_ELEMENT);

		tracedStateEClass = createEClass(TRACED_STATE);
		createEReference(tracedStateEClass, TRACED_STATE__ORIGINAL_OBJECT);

		tracedTFSMEClass = createEClass(TRACED_TFSM);
		createEReference(tracedTFSMEClass, TRACED_TFSM__CURRENT_STATE_SEQUENCE);
		createEReference(tracedTFSMEClass, TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE);
		createEReference(tracedTFSMEClass, TRACED_TFSM__ORIGINAL_OBJECT);
		createEReference(tracedTFSMEClass, TRACED_TFSM__STEP_NUMBER_SEQUENCE);

		tracedTemporalGuardEClass = createEClass(TRACED_TEMPORAL_GUARD);
		createEReference(tracedTemporalGuardEClass, TRACED_TEMPORAL_GUARD__ORIGINAL_OBJECT);

		tracedTimedSystemEClass = createEClass(TRACED_TIMED_SYSTEM);
		createEReference(tracedTimedSystemEClass, TRACED_TIMED_SYSTEM__ORIGINAL_OBJECT);

		tracedTransitionEClass = createEClass(TRACED_TRANSITION);
		createEReference(tracedTransitionEClass, TRACED_TRANSITION__ORIGINAL_OBJECT);
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
		org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage theTfsmPackage_1 = (org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage)EPackage.Registry.INSTANCE.getEPackage(org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eNS_URI);
		StatesPackage theStatesPackage = (StatesPackage)EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tracedEvaluateGuardEClass.getESuperTypes().add(this.getTracedGuard());
		tracedEventGuardEClass.getESuperTypes().add(this.getTracedGuard());
		tracedFSMClockEClass.getESuperTypes().add(this.getTracedNamedElement());
		tracedFSMEventEClass.getESuperTypes().add(this.getTracedNamedElement());
		tracedGuardEClass.getESuperTypes().add(this.getTracedNamedElement());
		tracedStateEClass.getESuperTypes().add(this.getTracedNamedElement());
		tracedTFSMEClass.getESuperTypes().add(this.getTracedNamedElement());
		tracedTemporalGuardEClass.getESuperTypes().add(this.getTracedGuard());
		tracedTimedSystemEClass.getESuperTypes().add(this.getTracedNamedElement());
		tracedTransitionEClass.getESuperTypes().add(this.getTracedNamedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(tracedEvaluateGuardEClass, TracedEvaluateGuard.class, "TracedEvaluateGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedEvaluateGuard_OriginalObject(), theTfsmPackage_1.getEvaluateGuard(), null, "originalObject", null, 0, 1, TracedEvaluateGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedEventGuardEClass, TracedEventGuard.class, "TracedEventGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedEventGuard_OriginalObject(), theTfsmPackage_1.getEventGuard(), null, "originalObject", null, 0, 1, TracedEventGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedFSMClockEClass, TracedFSMClock.class, "TracedFSMClock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedFSMClock_NumberOfTicksSequence(), theStatesPackage.getFSMClock_numberOfTicks_Value(), theStatesPackage.getFSMClock_numberOfTicks_Value_Parent(), "numberOfTicksSequence", null, 0, -1, TracedFSMClock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedFSMClock_OriginalObject(), theTfsmPackage_1.getFSMClock(), null, "originalObject", null, 0, 1, TracedFSMClock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedFSMEventEClass, TracedFSMEvent.class, "TracedFSMEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedFSMEvent_IsTriggeredSequence(), theStatesPackage.getFSMEvent_isTriggered_Value(), theStatesPackage.getFSMEvent_isTriggered_Value_Parent(), "isTriggeredSequence", null, 0, -1, TracedFSMEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedFSMEvent_OriginalObject(), theTfsmPackage_1.getFSMEvent(), null, "originalObject", null, 0, 1, TracedFSMEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedGuardEClass, TracedGuard.class, "TracedGuard", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tracedNamedElementEClass, TracedNamedElement.class, "TracedNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tracedStateEClass, TracedState.class, "TracedState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedState_OriginalObject(), theTfsmPackage_1.getState(), null, "originalObject", null, 0, 1, TracedState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedTFSMEClass, TracedTFSM.class, "TracedTFSM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedTFSM_CurrentStateSequence(), theStatesPackage.getTFSM_currentState_Value(), theStatesPackage.getTFSM_currentState_Value_Parent(), "currentStateSequence", null, 0, -1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_LastStateChangeStepNumberSequence(), theStatesPackage.getTFSM_lastStateChangeStepNumber_Value(), theStatesPackage.getTFSM_lastStateChangeStepNumber_Value_Parent(), "lastStateChangeStepNumberSequence", null, 0, -1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_OriginalObject(), theTfsmPackage_1.getTFSM(), null, "originalObject", null, 0, 1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_StepNumberSequence(), theStatesPackage.getTFSM_stepNumber_Value(), theStatesPackage.getTFSM_stepNumber_Value_Parent(), "stepNumberSequence", null, 0, -1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedTemporalGuardEClass, TracedTemporalGuard.class, "TracedTemporalGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedTemporalGuard_OriginalObject(), theTfsmPackage_1.getTemporalGuard(), null, "originalObject", null, 0, 1, TracedTemporalGuard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedTimedSystemEClass, TracedTimedSystem.class, "TracedTimedSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedTimedSystem_OriginalObject(), theTfsmPackage_1.getTimedSystem(), null, "originalObject", null, 0, 1, TracedTimedSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedTransitionEClass, TracedTransition.class, "TracedTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedTransition_OriginalObject(), theTfsmPackage_1.getTransition(), null, "originalObject", null, 0, 1, TracedTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //TfsmPackageImpl
