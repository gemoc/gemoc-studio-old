/**
 */
package tfsmTrace;

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
 * @see tfsmTrace.TfsmTraceFactory
 * @model kind="package"
 * @generated
 */
public interface TfsmTracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tfsmTrace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tfsmTrace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tfsmTrace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TfsmTracePackage eINSTANCE = tfsmTrace.impl.TfsmTracePackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsmTrace.impl.SpecificTraceImpl <em>Specific Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.impl.SpecificTraceImpl
	 * @see tfsmTrace.impl.TfsmTracePackageImpl#getSpecificTrace()
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
	 * The feature id for the '<em><b>Tfsm FSM Clock Ticks Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_FSM_CLOCK_TICKS_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tfsm FSM Event Trigger Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_FSM_EVENT_TRIGGER_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tfsm FSM Event Un Trigger Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_FSM_EVENT_UN_TRIGGER_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tfsm State Visit Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_STATE_VISIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tfsm Time FSM Init Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TIME_FSM_INIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tfsm Transition Fire Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRANSITION_FIRE_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Tfsm Transition Visit Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRANSITION_VISIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>States Trace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__STATES_TRACE = TracePackage.TRACE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Tfsm traced Evaluate Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Tfsm traced Event Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Tfsm traced FSM Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS = TracePackage.TRACE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Tfsm traced FSM Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS = TracePackage.TRACE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Tfsm traced States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_STATES = TracePackage.TRACE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Tfsm traced Temporal Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Tfsm traced Time FS Ms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS = TracePackage.TRACE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Tfsm traced Timed Systems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS = TracePackage.TRACE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Tfsm traced Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS = TracePackage.TRACE_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Specific Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE_FEATURE_COUNT = TracePackage.TRACE_FEATURE_COUNT + 17;


	/**
	 * Returns the meta object for class '{@link tfsmTrace.SpecificTrace <em>Specific Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Trace</em>'.
	 * @see tfsmTrace.SpecificTrace
	 * @generated
	 */
	EClass getSpecificTrace();

	/**
	 * Returns the meta object for the reference list '{@link tfsmTrace.SpecificTrace#getTfsm_FSMClock_Ticks_Sequence <em>Tfsm FSM Clock Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm FSM Clock Ticks Sequence</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_FSMClock_Ticks_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_FSMClock_Ticks_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsmTrace.SpecificTrace#getTfsm_FSMEvent_Trigger_Sequence <em>Tfsm FSM Event Trigger Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm FSM Event Trigger Sequence</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_FSMEvent_Trigger_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_FSMEvent_Trigger_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsmTrace.SpecificTrace#getTfsm_FSMEvent_UnTrigger_Sequence <em>Tfsm FSM Event Un Trigger Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm FSM Event Un Trigger Sequence</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_FSMEvent_UnTrigger_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_FSMEvent_UnTrigger_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsmTrace.SpecificTrace#getTfsm_State_Visit_Sequence <em>Tfsm State Visit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm State Visit Sequence</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_State_Visit_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_State_Visit_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsmTrace.SpecificTrace#getTfsm_TimeFSM_Init_Sequence <em>Tfsm Time FSM Init Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm Time FSM Init Sequence</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_TimeFSM_Init_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_TimeFSM_Init_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsmTrace.SpecificTrace#getTfsm_Transition_Fire_Sequence <em>Tfsm Transition Fire Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm Transition Fire Sequence</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_Transition_Fire_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_Transition_Fire_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsmTrace.SpecificTrace#getTfsm_Transition_Visit_Sequence <em>Tfsm Transition Visit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm Transition Visit Sequence</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_Transition_Visit_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_Transition_Visit_Sequence();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getStatesTrace <em>States Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States Trace</em>'.
	 * @see tfsmTrace.SpecificTrace#getStatesTrace()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_StatesTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedEvaluateGuards <em>Tfsm traced Evaluate Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced Evaluate Guards</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedEvaluateGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedEvaluateGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedEventGuards <em>Tfsm traced Event Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced Event Guards</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedEventGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedEventGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedFSMClocks <em>Tfsm traced FSM Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced FSM Clocks</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedFSMClocks()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedFSMClocks();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedFSMEvents <em>Tfsm traced FSM Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced FSM Events</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedFSMEvents()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedFSMEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedStates <em>Tfsm traced States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced States</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedStates()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedStates();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedTemporalGuards <em>Tfsm traced Temporal Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced Temporal Guards</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedTemporalGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedTemporalGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedTimeFSMs <em>Tfsm traced Time FS Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced Time FS Ms</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedTimeFSMs()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedTimeFSMs();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedTimedSystems <em>Tfsm traced Timed Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced Timed Systems</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedTimedSystems()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedTimedSystems();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.SpecificTrace#getTfsm_tracedTransitions <em>Tfsm traced Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm traced Transitions</em>'.
	 * @see tfsmTrace.SpecificTrace#getTfsm_tracedTransitions()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_tracedTransitions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TfsmTraceFactory getTfsmTraceFactory();

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
		 * The meta object literal for the '{@link tfsmTrace.impl.SpecificTraceImpl <em>Specific Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.impl.SpecificTraceImpl
		 * @see tfsmTrace.impl.TfsmTracePackageImpl#getSpecificTrace()
		 * @generated
		 */
		EClass SPECIFIC_TRACE = eINSTANCE.getSpecificTrace();

		/**
		 * The meta object literal for the '<em><b>Tfsm FSM Clock Ticks Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_FSM_CLOCK_TICKS_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_FSMClock_Ticks_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm FSM Event Trigger Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_FSM_EVENT_TRIGGER_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_FSMEvent_Trigger_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm FSM Event Un Trigger Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_FSM_EVENT_UN_TRIGGER_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_FSMEvent_UnTrigger_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm State Visit Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_STATE_VISIT_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_State_Visit_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm Time FSM Init Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TIME_FSM_INIT_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_TimeFSM_Init_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm Transition Fire Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRANSITION_FIRE_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_Transition_Fire_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm Transition Visit Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRANSITION_VISIT_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_Transition_Visit_Sequence();

		/**
		 * The meta object literal for the '<em><b>States Trace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__STATES_TRACE = eINSTANCE.getSpecificTrace_StatesTrace();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced Evaluate Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS = eINSTANCE.getSpecificTrace_Tfsm_tracedEvaluateGuards();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced Event Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS = eINSTANCE.getSpecificTrace_Tfsm_tracedEventGuards();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced FSM Clocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS = eINSTANCE.getSpecificTrace_Tfsm_tracedFSMClocks();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced FSM Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS = eINSTANCE.getSpecificTrace_Tfsm_tracedFSMEvents();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_STATES = eINSTANCE.getSpecificTrace_Tfsm_tracedStates();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced Temporal Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS = eINSTANCE.getSpecificTrace_Tfsm_tracedTemporalGuards();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced Time FS Ms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS = eINSTANCE.getSpecificTrace_Tfsm_tracedTimeFSMs();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced Timed Systems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS = eINSTANCE.getSpecificTrace_Tfsm_tracedTimedSystems();

		/**
		 * The meta object literal for the '<em><b>Tfsm traced Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS = eINSTANCE.getSpecificTrace_Tfsm_tracedTransitions();

	}

} //TfsmTracePackage
