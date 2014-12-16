/**
 */
package tfsmextended.tfsmextended.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.gemoc.sample.tfsm.TfsmPackage;

import org.gemoc.sample.tfsm.plaink3.dsa.IVisitor;
import tfsmextended.tfsmextended.EvaluateGuard;
import tfsmextended.tfsmextended.EventGuard;
import tfsmextended.tfsmextended.FSMClock;
import tfsmextended.tfsmextended.FSMEvent;
import tfsmextended.tfsmextended.Guard;
import tfsmextended.tfsmextended.NamedElement;
import tfsmextended.tfsmextended.State;
import tfsmextended.tfsmextended.TemporalGuard;
import tfsmextended.tfsmextended.TfsmextendedFactory;
import tfsmextended.tfsmextended.TfsmextendedPackage;
import tfsmextended.tfsmextended.TimedSystem;
import tfsmextended.tfsmextended.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TfsmextendedPackageImpl extends EPackageImpl implements TfsmextendedPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tfsmEClass = null;

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
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass temporalGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fsmClockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timedSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluateGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iVisitorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

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
	 * @see tfsmextended.tfsmextended.TfsmextendedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TfsmextendedPackageImpl() {
		super(eNS_URI, TfsmextendedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TfsmextendedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TfsmextendedPackage init() {
		if (isInited) return (TfsmextendedPackage)EPackage.Registry.INSTANCE.getEPackage(TfsmextendedPackage.eNS_URI);

		// Obtain or create and register package
		TfsmextendedPackageImpl theTfsmextendedPackage = (TfsmextendedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TfsmextendedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TfsmextendedPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TfsmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTfsmextendedPackage.createPackageContents();

		// Initialize created meta-data
		theTfsmextendedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTfsmextendedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TfsmextendedPackage.eNS_URI, theTfsmextendedPackage);
		return theTfsmextendedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFSM() {
		return tfsmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFSM_CurrentState() {
		return (EReference)tfsmEClass.getEStructuralFeatures().get(0);
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
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuard() {
		return guardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemporalGuard() {
		return temporalGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventGuard() {
		return eventGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMEvent() {
		return fsmEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMEvent_IsTriggered() {
		return (EAttribute)fsmEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFSMClock() {
		return fsmClockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFSMClock_NumberOfTicks() {
		return (EAttribute)fsmClockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimedSystem() {
		return timedSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluateGuard() {
		return evaluateGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIVisitor() {
		return iVisitorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInteger() {
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TfsmextendedFactory getTfsmextendedFactory() {
		return (TfsmextendedFactory)getEFactoryInstance();
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
		tfsmEClass = createEClass(TFSM);
		createEReference(tfsmEClass, TFSM__CURRENT_STATE);

		stateEClass = createEClass(STATE);

		transitionEClass = createEClass(TRANSITION);

		namedElementEClass = createEClass(NAMED_ELEMENT);

		guardEClass = createEClass(GUARD);

		temporalGuardEClass = createEClass(TEMPORAL_GUARD);

		eventGuardEClass = createEClass(EVENT_GUARD);

		fsmEventEClass = createEClass(FSM_EVENT);
		createEAttribute(fsmEventEClass, FSM_EVENT__IS_TRIGGERED);

		fsmClockEClass = createEClass(FSM_CLOCK);
		createEAttribute(fsmClockEClass, FSM_CLOCK__NUMBER_OF_TICKS);

		timedSystemEClass = createEClass(TIMED_SYSTEM);

		evaluateGuardEClass = createEClass(EVALUATE_GUARD);

		// Create data types
		iVisitorEDataType = createEDataType(IVISITOR);
		integerEDataType = createEDataType(INTEGER);
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
		TfsmPackage theTfsmPackage = (TfsmPackage)EPackage.Registry.INSTANCE.getEPackage(TfsmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tfsmEClass.getESuperTypes().add(theTfsmPackage.getTFSM());
		stateEClass.getESuperTypes().add(theTfsmPackage.getState());
		transitionEClass.getESuperTypes().add(theTfsmPackage.getTransition());
		namedElementEClass.getESuperTypes().add(theTfsmPackage.getNamedElement());
		guardEClass.getESuperTypes().add(theTfsmPackage.getGuard());
		temporalGuardEClass.getESuperTypes().add(theTfsmPackage.getTemporalGuard());
		temporalGuardEClass.getESuperTypes().add(this.getGuard());
		eventGuardEClass.getESuperTypes().add(theTfsmPackage.getEventGuard());
		eventGuardEClass.getESuperTypes().add(this.getGuard());
		fsmEventEClass.getESuperTypes().add(theTfsmPackage.getFSMEvent());
		fsmClockEClass.getESuperTypes().add(theTfsmPackage.getFSMClock());
		timedSystemEClass.getESuperTypes().add(theTfsmPackage.getTimedSystem());
		evaluateGuardEClass.getESuperTypes().add(theTfsmPackage.getEvaluateGuard());

		// Initialize classes and features; add operations and parameters
		initEClass(tfsmEClass, tfsmextended.tfsmextended.TFSM.class, "TFSM", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTFSM_CurrentState(), this.getState(), null, "currentState", null, 0, 1, tfsmextended.tfsmextended.TFSM.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(tfsmEClass, ecorePackage.getEString(), "Init", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(tfsmEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(stateEClass, ecorePackage.getEString(), "onEnter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(stateEClass, ecorePackage.getEString(), "onLeave", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(stateEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(transitionEClass, ecorePackage.getEString(), "fire", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(transitionEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(guardEClass, Guard.class, "Guard", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(guardEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(temporalGuardEClass, TemporalGuard.class, "TemporalGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(temporalGuardEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventGuardEClass, EventGuard.class, "EventGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(eventGuardEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fsmEventEClass, FSMEvent.class, "FSMEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMEvent_IsTriggered(), ecorePackage.getEBoolean(), "isTriggered", null, 0, 1, FSMEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fsmClockEClass, FSMClock.class, "FSMClock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFSMClock_NumberOfTicks(), this.getInteger(), "numberOfTicks", null, 0, 1, FSMClock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(fsmClockEClass, this.getInteger(), "ticks", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(fsmClockEClass, null, "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIVisitor(), "visitor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(timedSystemEClass, TimedSystem.class, "TimedSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(evaluateGuardEClass, EvaluateGuard.class, "EvaluateGuard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(iVisitorEDataType, IVisitor.class, "IVisitor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerEDataType, Integer.class, "Integer", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// aspect
		createAspectAnnotations();
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
		  (tfsmEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (tfsmEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getTFSM_CurrentState(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (stateEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (stateEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (stateEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (transitionEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (transitionEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (guardEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (temporalGuardEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (eventGuardEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getFSMEvent_IsTriggered(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (fsmClockEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (fsmClockEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getFSMClock_NumberOfTicks(), 
		   source, 
		   new String[] {
		   });
	}

} //TfsmextendedPackageImpl
