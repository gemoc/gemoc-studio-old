/**
 */
package tfsm_plaink3Trace;

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
	 * The meta object id for the '{@link tfsm_plaink3Trace.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.impl.TraceImpl
	 * @see tfsm_plaink3Trace.impl.Tfsm_plaink3TracePackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 0;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 FSM Clock Ticks Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE = 0;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 FSM Event Trigger Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE = 1;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 FSM Event Un Trigger Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE = 2;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 State Visit Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE = 3;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 TFSM Init Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE = 4;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 Transition Fire Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE = 5;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 Transition Visit Sequence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE = 6;

	/**
	 * The feature id for the '<em><b>Root Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__ROOT_STEPS = 7;

	/**
	 * The feature id for the '<em><b>States Trace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__STATES_TRACE = 8;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced FSM Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS = 9;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced FSM Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS = 10;

	/**
	 * The feature id for the '<em><b>Tfsm plaink3 traced TFS Ms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__TFSM_PLAINK3_TRACED_TFS_MS = 11;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see tfsm_plaink3Trace.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMClock_Ticks_Sequence <em>Tfsm plaink3 FSM Clock Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 FSM Clock Ticks Sequence</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMClock_Ticks_Sequence()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMEvent_Trigger_Sequence <em>Tfsm plaink3 FSM Event Trigger Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 FSM Event Trigger Sequence</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMEvent_Trigger_Sequence()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMEvent_UnTrigger_Sequence <em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMEvent_UnTrigger_Sequence()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_State_Visit_Sequence <em>Tfsm plaink3 State Visit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 State Visit Sequence</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_State_Visit_Sequence()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_State_Visit_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_TFSM_Init_Sequence <em>Tfsm plaink3 TFSM Init Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 TFSM Init Sequence</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_TFSM_Init_Sequence()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_TFSM_Init_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_Transition_Fire_Sequence <em>Tfsm plaink3 Transition Fire Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 Transition Fire Sequence</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_Transition_Fire_Sequence()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_Transition_Fire_Sequence();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_Transition_Visit_Sequence <em>Tfsm plaink3 Transition Visit Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tfsm plaink3 Transition Visit Sequence</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_Transition_Visit_Sequence()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_Transition_Visit_Sequence();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.Trace#getRootSteps <em>Root Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Steps</em>'.
	 * @see tfsm_plaink3Trace.Trace#getRootSteps()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_RootSteps();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.Trace#getStatesTrace <em>States Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States Trace</em>'.
	 * @see tfsm_plaink3Trace.Trace#getStatesTrace()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_StatesTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedFSMClocks <em>Tfsm plaink3 traced FSM Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced FSM Clocks</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedFSMClocks()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_tracedFSMClocks();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedFSMEvents <em>Tfsm plaink3 traced FSM Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced FSM Events</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedFSMEvents()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_tracedFSMEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedTFSMs <em>Tfsm plaink3 traced TFS Ms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsm plaink3 traced TFS Ms</em>'.
	 * @see tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedTFSMs()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Tfsm_plaink3_tracedTFSMs();

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
		 * The meta object literal for the '{@link tfsm_plaink3Trace.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.impl.TraceImpl
		 * @see tfsm_plaink3Trace.impl.Tfsm_plaink3TracePackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 FSM Clock Ticks Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE = eINSTANCE.getTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 FSM Event Trigger Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE = eINSTANCE.getTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 FSM Event Un Trigger Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE = eINSTANCE.getTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 State Visit Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE = eINSTANCE.getTrace_Tfsm_plaink3_State_Visit_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 TFSM Init Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE = eINSTANCE.getTrace_Tfsm_plaink3_TFSM_Init_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 Transition Fire Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE = eINSTANCE.getTrace_Tfsm_plaink3_Transition_Fire_Sequence();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 Transition Visit Sequence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE = eINSTANCE.getTrace_Tfsm_plaink3_Transition_Visit_Sequence();

		/**
		 * The meta object literal for the '<em><b>Root Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__ROOT_STEPS = eINSTANCE.getTrace_RootSteps();

		/**
		 * The meta object literal for the '<em><b>States Trace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__STATES_TRACE = eINSTANCE.getTrace_StatesTrace();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced FSM Clocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS = eINSTANCE.getTrace_Tfsm_plaink3_tracedFSMClocks();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced FSM Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS = eINSTANCE.getTrace_Tfsm_plaink3_tracedFSMEvents();

		/**
		 * The meta object literal for the '<em><b>Tfsm plaink3 traced TFS Ms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__TFSM_PLAINK3_TRACED_TFS_MS = eINSTANCE.getTrace_Tfsm_plaink3_tracedTFSMs();

	}

} //Tfsm_plaink3TracePackage
