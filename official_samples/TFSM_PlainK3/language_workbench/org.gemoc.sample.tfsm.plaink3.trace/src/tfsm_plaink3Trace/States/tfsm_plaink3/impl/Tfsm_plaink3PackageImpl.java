/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.executionframework.engine.mse.MsePackage;

import org.gemoc.sample.tfsm_plaink3.TfsmPackage;

import tfsm_plaink3Trace.States.StatesPackage;

import tfsm_plaink3Trace.States.impl.StatesPackageImpl;

import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory;
import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM;

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
public class Tfsm_plaink3PackageImpl extends EPackageImpl implements Tfsm_plaink3Package {
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
	private EClass tracedNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracedTFSMEClass = null;

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
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Tfsm_plaink3PackageImpl() {
		super(eNS_URI, Tfsm_plaink3Factory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Tfsm_plaink3Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Tfsm_plaink3Package init() {
		if (isInited) return (Tfsm_plaink3Package)EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3Package.eNS_URI);

		// Obtain or create and register package
		Tfsm_plaink3PackageImpl theTfsm_plaink3Package = (Tfsm_plaink3PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Tfsm_plaink3PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Tfsm_plaink3PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MsePackage.eINSTANCE.eClass();
		TfsmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Tfsm_plaink3TracePackageImpl theTfsm_plaink3TracePackage = (Tfsm_plaink3TracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3TracePackage.eNS_URI) instanceof Tfsm_plaink3TracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tfsm_plaink3TracePackage.eNS_URI) : Tfsm_plaink3TracePackage.eINSTANCE);
		StepsPackageImpl theStepsPackage = (StepsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) instanceof StepsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StepsPackage.eNS_URI) : StepsPackage.eINSTANCE);
		StatesPackageImpl theStatesPackage = (StatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) instanceof StatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI) : StatesPackage.eINSTANCE);

		// Create package meta-data objects
		theTfsm_plaink3Package.createPackageContents();
		theTfsm_plaink3TracePackage.createPackageContents();
		theStepsPackage.createPackageContents();
		theStatesPackage.createPackageContents();

		// Initialize created meta-data
		theTfsm_plaink3Package.initializePackageContents();
		theTfsm_plaink3TracePackage.initializePackageContents();
		theStepsPackage.initializePackageContents();
		theStatesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTfsm_plaink3Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Tfsm_plaink3Package.eNS_URI, theTfsm_plaink3Package);
		return theTfsm_plaink3Package;
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
	public EReference getTracedFSMEvent_SollicitingTransitions() {
		return (EReference)tracedFSMEventEClass.getEStructuralFeatures().get(1);
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
	public EReference getTracedNamedElement_OriginalObject_NamedElement() {
		return (EReference)tracedNamedElementEClass.getEStructuralFeatures().get(0);
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
	public EReference getTracedTFSM_CurrentState() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_CurrentStateSequence() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_InitialState() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_LocalClock() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_LocalEvents() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_OwnedStates() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTracedTFSM_OwnedTransitions() {
		return (EReference)tracedTFSMEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3Factory getTfsm_plaink3Factory() {
		return (Tfsm_plaink3Factory)getEFactoryInstance();
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
		tracedFSMClockEClass = createEClass(TRACED_FSM_CLOCK);
		createEReference(tracedFSMClockEClass, TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE);

		tracedFSMEventEClass = createEClass(TRACED_FSM_EVENT);
		createEReference(tracedFSMEventEClass, TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE);
		createEReference(tracedFSMEventEClass, TRACED_FSM_EVENT__SOLLICITING_TRANSITIONS);

		tracedNamedElementEClass = createEClass(TRACED_NAMED_ELEMENT);
		createEReference(tracedNamedElementEClass, TRACED_NAMED_ELEMENT__ORIGINAL_OBJECT_NAMED_ELEMENT);

		tracedTFSMEClass = createEClass(TRACED_TFSM);
		createEReference(tracedTFSMEClass, TRACED_TFSM__CURRENT_STATE);
		createEReference(tracedTFSMEClass, TRACED_TFSM__CURRENT_STATE_SEQUENCE);
		createEReference(tracedTFSMEClass, TRACED_TFSM__INITIAL_STATE);
		createEReference(tracedTFSMEClass, TRACED_TFSM__LOCAL_CLOCK);
		createEReference(tracedTFSMEClass, TRACED_TFSM__LOCAL_EVENTS);
		createEReference(tracedTFSMEClass, TRACED_TFSM__OWNED_STATES);
		createEReference(tracedTFSMEClass, TRACED_TFSM__OWNED_TRANSITIONS);
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
		StatesPackage theStatesPackage = (StatesPackage)EPackage.Registry.INSTANCE.getEPackage(StatesPackage.eNS_URI);
		TfsmPackage theTfsmPackage = (TfsmPackage)EPackage.Registry.INSTANCE.getEPackage(TfsmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tracedFSMClockEClass.getESuperTypes().add(this.getTracedNamedElement());
		tracedFSMEventEClass.getESuperTypes().add(this.getTracedNamedElement());
		tracedTFSMEClass.getESuperTypes().add(this.getTracedNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(tracedFSMClockEClass, TracedFSMClock.class, "TracedFSMClock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedFSMClock_NumberOfTicksSequence(), theStatesPackage.getFSMClock_numberOfTicks_Value(), theStatesPackage.getFSMClock_numberOfTicks_Value_Parent(), "numberOfTicksSequence", null, 0, -1, TracedFSMClock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedFSMEventEClass, TracedFSMEvent.class, "TracedFSMEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedFSMEvent_IsTriggeredSequence(), theStatesPackage.getFSMEvent_isTriggered_Value(), theStatesPackage.getFSMEvent_isTriggered_Value_Parent(), "isTriggeredSequence", null, 0, -1, TracedFSMEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedFSMEvent_SollicitingTransitions(), theTfsmPackage.getTransition(), null, "sollicitingTransitions", null, 0, -1, TracedFSMEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedNamedElementEClass, TracedNamedElement.class, "TracedNamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedNamedElement_OriginalObject_NamedElement(), theTfsmPackage.getNamedElement(), null, "originalObject_NamedElement", null, 0, 1, TracedNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracedTFSMEClass, TracedTFSM.class, "TracedTFSM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTracedTFSM_CurrentState(), theTfsmPackage.getState(), null, "currentState", null, 0, 1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_CurrentStateSequence(), theStatesPackage.getTFSM_currentState_Value(), theStatesPackage.getTFSM_currentState_Value_Parent(), "currentStateSequence", null, 0, -1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_InitialState(), theTfsmPackage.getState(), null, "initialState", null, 1, 1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_LocalClock(), this.getTracedFSMClock(), null, "localClock", null, 1, 1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_LocalEvents(), this.getTracedFSMEvent(), null, "localEvents", null, 0, -1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_OwnedStates(), theTfsmPackage.getState(), null, "ownedStates", null, 0, -1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTracedTFSM_OwnedTransitions(), theTfsmPackage.getTransition(), null, "ownedTransitions", null, 0, -1, TracedTFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// dynamic
		createDynamicAnnotations();
	}

	/**
	 * Initializes the annotations for <b>dynamic</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDynamicAnnotations() {
		String source = "dynamic";	
		addAnnotation
		  (getTracedTFSM_CurrentState(), 
		   source, 
		   new String[] {
		   });
	}

} //Tfsm_plaink3PackageImpl
