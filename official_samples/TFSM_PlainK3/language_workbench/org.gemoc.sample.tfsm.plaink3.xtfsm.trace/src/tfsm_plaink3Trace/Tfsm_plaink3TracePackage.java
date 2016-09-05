/**
 */
package tfsm_plaink3Trace;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tfsm_plaink3Trace.Tfsm_plaink3TraceFactory
 * @model kind="package"
 * @generated
 */
public interface Tfsm_plaink3TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tfsm_plaink3Trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tfsm_plaink3Trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tfsm_plaink3Trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Tfsm_plaink3TracePackage eINSTANCE = tfsm_plaink3Trace.impl.Tfsm_plaink3TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.impl.SpecificTraceImpl <em>Specific Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.impl.SpecificTraceImpl
	 * @see tfsm_plaink3Trace.impl.Tfsm_plaink3TracePackageImpl#getSpecificTrace()
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
	 * The feature id for the '<em><b>Tfsm plaink3 FSM Clock Ticks Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 FSM Event Trigger Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 FSM Event Un Trigger Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 State Visit Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 TFSM Init Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 Transition Fire Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 Transition Visit Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE = TracePackage.TRACE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>States Trace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__STATES_TRACE = TracePackage.TRACE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced Evaluate Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced Event Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced FSM Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS = TracePackage.TRACE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced FSM Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS = TracePackage.TRACE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES = TracePackage.TRACE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced TFS Ms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS = TracePackage.TRACE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced Temporal Guards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS = TracePackage.TRACE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced Timed Systems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS = TracePackage.TRACE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS = TracePackage.TRACE_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Specific Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE_FEATURE_COUNT = TracePackage.TRACE_FEATURE_COUNT + 17;

	/**
	 * The number of operations of the '<em>Specific Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_TRACE_OPERATION_COUNT = TracePackage.TRACE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.SpecificTrace <em>Specific Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Trace</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace
	 * @generated
	 */
	EClass getSpecificTrace();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMClock_Ticks_Sequence <em>Tfsm plaink3 FSM Clock Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 FSM Clock Ticks Sequence</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMClock_Ticks_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMEvent_Trigger_Sequence <em>Tfsm plaink3 FSM Event Trigger Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 FSM Event Trigger Sequence</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMEvent_Trigger_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMEvent_UnTrigger_Sequence <em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMEvent_UnTrigger_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_State_Visit_Sequence <em>Tfsm plaink3 State Visit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 State Visit Sequence</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_State_Visit_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_State_Visit_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_TFSM_Init_Sequence <em>Tfsm plaink3 TFSM Init Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 TFSM Init Sequence</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_TFSM_Init_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_TFSM_Init_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_Transition_Fire_Sequence <em>Tfsm plaink3 Transition Fire Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 Transition Fire Sequence</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_Transition_Fire_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_Transition_Fire_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_Transition_Visit_Sequence <em>Tfsm plaink3 Transition Visit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 Transition Visit Sequence</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_Transition_Visit_Sequence()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_Transition_Visit_Sequence();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getStatesTrace <em>States Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States Trace</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getStatesTrace()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_StatesTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedEvaluateGuards <em>Tfsm plaink3 traced Evaluate Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced Evaluate Guards</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedEvaluateGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedEvaluateGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedEventGuards <em>Tfsm plaink3 traced Event Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced Event Guards</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedEventGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedEventGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedFSMClocks <em>Tfsm plaink3 traced FSM Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced FSM Clocks</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedFSMClocks()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedFSMClocks();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedFSMEvents <em>Tfsm plaink3 traced FSM Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced FSM Events</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedFSMEvents()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedFSMEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedStates <em>Tfsm plaink3 traced States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced States</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedStates()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedStates();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTFSMs <em>Tfsm plaink3 traced TFS Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced TFS Ms</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTFSMs()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedTFSMs();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTemporalGuards <em>Tfsm plaink3 traced Temporal Guards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced Temporal Guards</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTemporalGuards()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedTemporalGuards();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTimedSystems <em>Tfsm plaink3 traced Timed Systems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced Timed Systems</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTimedSystems()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedTimedSystems();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTransitions <em>Tfsm plaink3 traced Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced Transitions</em>'.
	 * @see tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTransitions()
	 * @see #getSpecificTrace()
	 * @generated
	 */
	EReference getSpecificTrace_Tfsm_plaink3_tracedTransitions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Tfsm_plaink3TraceFactory getTfsm_plaink3TraceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.impl.SpecificTraceImpl <em>Specific Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.impl.SpecificTraceImpl
		 * @see tfsm_plaink3Trace.impl.Tfsm_plaink3TracePackageImpl#getSpecificTrace()
		 * @generated
		 */
		EClass SPECIFIC_TRACE = eINSTANCE.getSpecificTrace();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 FSM Clock Ticks Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 FSM Event Trigger Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 FSM Event Un Trigger Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 State Visit Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_plaink3_State_Visit_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 TFSM Init Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_plaink3_TFSM_Init_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 Transition Fire Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_plaink3_Transition_Fire_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 Transition Visit Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE = eINSTANCE.getSpecificTrace_Tfsm_plaink3_Transition_Visit_Sequence();

		/**
		 * The meta object literal for the '<em><b>States Trace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__STATES_TRACE = eINSTANCE.getSpecificTrace_StatesTrace();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced Evaluate Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedEvaluateGuards();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced Event Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedEventGuards();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced FSM Clocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedFSMClocks();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced FSM Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedFSMEvents();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedStates();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced TFS Ms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedTFSMs();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced Temporal Guards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedTemporalGuards();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced Timed Systems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedTimedSystems();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS = eINSTANCE.getSpecificTrace_Tfsm_plaink3_tracedTransitions();

	}

} //Tfsm_plaink3TracePackage
