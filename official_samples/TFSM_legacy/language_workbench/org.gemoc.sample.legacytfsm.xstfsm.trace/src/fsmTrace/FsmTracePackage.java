/**
 */
package fsmTrace;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fsmTrace.FsmTraceFactory
 * @model kind="package"
 * @generated
 */
public interface FsmTracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fsmTrace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "fsmTrace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fsmTrace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmTracePackage eINSTANCE = fsmTrace.impl.FsmTracePackageImpl.init();

	/**
	 * The meta object id for the '{@link fsmTrace.impl.SpecificTraceImpl <em>Specific Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.impl.SpecificTraceImpl
	 * @see fsmTrace.impl.FsmTracePackageImpl#getSpecificTrace()
	 * @generated
	 */
	int SPECIFIC_TRACE = 0;

	/**
	 * The feature id for the '<em><b>Root Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__ROOT_STEP = TracePackage.TRACE__ROOT_STEP;

	/**
	 * The feature id for the '<em><b>Launchconfiguration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__LAUNCHCONFIGURATION = TracePackage.TRACE__LAUNCHCONFIGURATION;

	/**
	 * The feature id for the '<em><b>Fsm FSM Clock Ticks Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_FSM_CLOCK_TICKS_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fsm FSM Event Trigger Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_FSM_EVENT_TRIGGER_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fsm FSM Event Un Trigger Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_FSM_EVENT_UN_TRIGGER_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fsm State Visit Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_STATE_VISIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fsm Time FSM Init Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TIME_FSM_INIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fsm Transition Fire Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Fsm Transition Visit Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRANSITION_VISIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Fsm traced Evaluate Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_EVALUATE_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Fsm traced Event Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_EVENT_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Fsm traced FSM Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_FSM_CLOCKS = TracePackage.TRACE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Fsm traced FSM Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_FSM_EVENTS = TracePackage.TRACE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Fsm traced States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_STATES = TracePackage.TRACE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Fsm traced Temporal Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_TEMPORAL_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Fsm traced Time FS Ms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_TIME_FS_MS = TracePackage.TRACE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Fsm traced Timed Systems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_TIMED_SYSTEMS = TracePackage.TRACE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Fsm traced Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS = TracePackage.TRACE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>States Trace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__STATES_TRACE = TracePackage.TRACE_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Specific Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE_FEATURE_COUNT = TracePackage.TRACE_FEATURE_COUNT + 17;


	/**
	 * Returns the meta object for class '{@link fsmTrace.SpecificTrace <em>Specific Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Trace</em>'.
	 * @see fsmTrace.SpecificTrace
	 * @generated
	 */
	EClass getSpecificTrace();

	/**
	 * Returns the meta object for the reference list '{@link fsmTrace.SpecificTrace#getFsm_FSMClock_Ticks_Sequence <em>Fsm FSM Clock Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fsm FSM Clock Ticks Sequence</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_FSMClock_Ticks_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_FSMClock_Ticks_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link fsmTrace.SpecificTrace#getFsm_FSMEvent_Trigger_Sequence <em>Fsm FSM Event Trigger Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fsm FSM Event Trigger Sequence</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_FSMEvent_Trigger_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_FSMEvent_Trigger_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link fsmTrace.SpecificTrace#getFsm_FSMEvent_UnTrigger_Sequence <em>Fsm FSM Event Un Trigger Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fsm FSM Event Un Trigger Sequence</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_FSMEvent_UnTrigger_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_FSMEvent_UnTrigger_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link fsmTrace.SpecificTrace#getFsm_State_Visit_Sequence <em>Fsm State Visit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fsm State Visit Sequence</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_State_Visit_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_State_Visit_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link fsmTrace.SpecificTrace#getFsm_TimeFSM_Init_Sequence <em>Fsm Time FSM Init Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fsm Time FSM Init Sequence</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_TimeFSM_Init_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_TimeFSM_Init_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link fsmTrace.SpecificTrace#getFsm_Transition_Fire_Sequence <em>Fsm Transition Fire Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fsm Transition Fire Sequence</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_Transition_Fire_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_Transition_Fire_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link fsmTrace.SpecificTrace#getFsm_Transition_Visit_Sequence <em>Fsm Transition Visit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fsm Transition Visit Sequence</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_Transition_Visit_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_Transition_Visit_Sequence();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedEvaluateGuards <em>Fsm traced Evaluate Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced Evaluate Guards</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedEvaluateGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedEvaluateGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedEventGuards <em>Fsm traced Event Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced Event Guards</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedEventGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedEventGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedFSMClocks <em>Fsm traced FSM Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced FSM Clocks</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedFSMClocks()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedFSMClocks();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedFSMEvents <em>Fsm traced FSM Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced FSM Events</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedFSMEvents()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedFSMEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedStates <em>Fsm traced States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced States</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedStates()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedStates();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedTemporalGuards <em>Fsm traced Temporal Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced Temporal Guards</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedTemporalGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedTemporalGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedTimeFSMs <em>Fsm traced Time FS Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced Time FS Ms</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedTimeFSMs()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedTimeFSMs();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedTimedSystems <em>Fsm traced Timed Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced Timed Systems</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedTimedSystems()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedTimedSystems();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getFsm_tracedTransitions <em>Fsm traced Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsm traced Transitions</em>'.
	 * @see fsmTrace.SpecificTrace#getFsm_tracedTransitions()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Fsm_tracedTransitions();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.SpecificTrace#getStatesTrace <em>States Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States Trace</em>'.
	 * @see fsmTrace.SpecificTrace#getStatesTrace()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_StatesTrace();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FsmTraceFactory getFsmTraceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fsmTrace.impl.SpecificTraceImpl <em>Specific Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.impl.SpecificTraceImpl
		 * @see fsmTrace.impl.FsmTracePackageImpl#getSpecificTrace()
		 * @generated
		 */
		EClass SPECIFIC_TRACE = eINSTANCE.getSpecificTrace();

		/**
		 * The meta object literal for the '<em><b>Fsm FSM Clock Ticks Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_FSM_CLOCK_TICKS_SEQUENCE = eINSTANCE.getSpecificTrace_Fsm_FSMClock_Ticks_Sequence();

		/**
		 * The meta object literal for the '<em><b>Fsm FSM Event Trigger Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_FSM_EVENT_TRIGGER_SEQUENCE = eINSTANCE.getSpecificTrace_Fsm_FSMEvent_Trigger_Sequence();

		/**
		 * The meta object literal for the '<em><b>Fsm FSM Event Un Trigger Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_FSM_EVENT_UN_TRIGGER_SEQUENCE = eINSTANCE.getSpecificTrace_Fsm_FSMEvent_UnTrigger_Sequence();

		/**
		 * The meta object literal for the '<em><b>Fsm State Visit Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_STATE_VISIT_SEQUENCE = eINSTANCE.getSpecificTrace_Fsm_State_Visit_Sequence();

		/**
		 * The meta object literal for the '<em><b>Fsm Time FSM Init Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TIME_FSM_INIT_SEQUENCE = eINSTANCE.getSpecificTrace_Fsm_TimeFSM_Init_Sequence();

		/**
		 * The meta object literal for the '<em><b>Fsm Transition Fire Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE = eINSTANCE.getSpecificTrace_Fsm_Transition_Fire_Sequence();

		/**
		 * The meta object literal for the '<em><b>Fsm Transition Visit Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRANSITION_VISIT_SEQUENCE = eINSTANCE.getSpecificTrace_Fsm_Transition_Visit_Sequence();

		/**
		 * The meta object literal for the '<em><b>Fsm traced Evaluate Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_EVALUATE_GUARDS = eINSTANCE.getSpecificTrace_Fsm_tracedEvaluateGuards();

		/**
		 * The meta object literal for the '<em><b>Fsm traced Event Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_EVENT_GUARDS = eINSTANCE.getSpecificTrace_Fsm_tracedEventGuards();

		/**
		 * The meta object literal for the '<em><b>Fsm traced FSM Clocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_FSM_CLOCKS = eINSTANCE.getSpecificTrace_Fsm_tracedFSMClocks();

		/**
		 * The meta object literal for the '<em><b>Fsm traced FSM Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_FSM_EVENTS = eINSTANCE.getSpecificTrace_Fsm_tracedFSMEvents();

		/**
		 * The meta object literal for the '<em><b>Fsm traced States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_STATES = eINSTANCE.getSpecificTrace_Fsm_tracedStates();

		/**
		 * The meta object literal for the '<em><b>Fsm traced Temporal Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_TEMPORAL_GUARDS = eINSTANCE.getSpecificTrace_Fsm_tracedTemporalGuards();

		/**
		 * The meta object literal for the '<em><b>Fsm traced Time FS Ms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_TIME_FS_MS = eINSTANCE.getSpecificTrace_Fsm_tracedTimeFSMs();

		/**
		 * The meta object literal for the '<em><b>Fsm traced Timed Systems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_TIMED_SYSTEMS = eINSTANCE.getSpecificTrace_Fsm_tracedTimedSystems();

		/**
		 * The meta object literal for the '<em><b>Fsm traced Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS = eINSTANCE.getSpecificTrace_Fsm_tracedTransitions();

		/**
		 * The meta object literal for the '<em><b>States Trace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__STATES_TRACE = eINSTANCE.getSpecificTrace_StatesTrace();

	}

} //FsmTracePackage
