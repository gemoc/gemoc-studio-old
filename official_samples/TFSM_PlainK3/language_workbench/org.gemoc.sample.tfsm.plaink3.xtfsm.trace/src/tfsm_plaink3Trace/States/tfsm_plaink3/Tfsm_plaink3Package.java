/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3;

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
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory
 * @model kind="package"
 * @generated
 */
public interface Tfsm_plaink3Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tfsm_plaink3";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tfsm_plaink3Trace_tfsm_plaink3";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Tfsm_plaink3Package eINSTANCE = tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl <em>Traced Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedNamedElement()
	 * @generated
	 */
	int TRACED_NAMED_ELEMENT = 5;

	/**
	 * The number of structural features of the '<em>Traced Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_NAMED_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Traced Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedGuardImpl <em>Traced Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedGuardImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedGuard()
	 * @generated
	 */
	int TRACED_GUARD = 4;

	/**
	 * The number of structural features of the '<em>Traced Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_GUARD_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Traced Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_GUARD_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedEvaluateGuardImpl <em>Traced Evaluate Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedEvaluateGuardImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedEvaluateGuard()
	 * @generated
	 */
	int TRACED_EVALUATE_GUARD = 0;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_EVALUATE_GUARD__ORIGINAL_OBJECT = TRACED_GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Traced Evaluate Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_EVALUATE_GUARD_FEATURE_COUNT = TRACED_GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Traced Evaluate Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_EVALUATE_GUARD_OPERATION_COUNT = TRACED_GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedEventGuardImpl <em>Traced Event Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedEventGuardImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedEventGuard()
	 * @generated
	 */
	int TRACED_EVENT_GUARD = 1;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_EVENT_GUARD__ORIGINAL_OBJECT = TRACED_GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Traced Event Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_EVENT_GUARD_FEATURE_COUNT = TRACED_GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Traced Event Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_EVENT_GUARD_OPERATION_COUNT = TRACED_GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl <em>Traced FSM Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedFSMClock()
	 * @generated
	 */
	int TRACED_FSM_CLOCK = 2;

	/**
	 * The feature id for the '<em><b>Number Of Ticks Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_CLOCK__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Traced FSM Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_CLOCK_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Traced FSM Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_CLOCK_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMEventImpl <em>Traced FSM Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMEventImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedFSMEvent()
	 * @generated
	 */
	int TRACED_FSM_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Is Triggered Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_EVENT__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Traced FSM Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_EVENT_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Traced FSM Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_EVENT_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedStateImpl <em>Traced State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedStateImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedState()
	 * @generated
	 */
	int TRACED_STATE = 6;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_STATE__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Traced State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_STATE_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Traced State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_STATE_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl <em>Traced TFSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTFSM()
	 * @generated
	 */
	int TRACED_TFSM = 7;

	/**
	 * The feature id for the '<em><b>Current State Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM__CURRENT_STATE_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last State Change Step Number Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Step Number Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM__STEP_NUMBER_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Traced TFSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Traced TFSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTemporalGuardImpl <em>Traced Temporal Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTemporalGuardImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTemporalGuard()
	 * @generated
	 */
	int TRACED_TEMPORAL_GUARD = 8;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TEMPORAL_GUARD__ORIGINAL_OBJECT = TRACED_GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Traced Temporal Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TEMPORAL_GUARD_FEATURE_COUNT = TRACED_GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Traced Temporal Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TEMPORAL_GUARD_OPERATION_COUNT = TRACED_GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTimedSystemImpl <em>Traced Timed System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTimedSystemImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTimedSystem()
	 * @generated
	 */
	int TRACED_TIMED_SYSTEM = 9;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TIMED_SYSTEM__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Traced Timed System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TIMED_SYSTEM_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Traced Timed System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TIMED_SYSTEM_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTransitionImpl <em>Traced Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTransitionImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTransition()
	 * @generated
	 */
	int TRACED_TRANSITION = 10;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TRANSITION__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Traced Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TRANSITION_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Traced Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TRANSITION_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard <em>Traced Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Evaluate Guard</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard
	 * @generated
	 */
	EClass getTracedEvaluateGuard();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard#getOriginalObject()
	 * @see #getTracedEvaluateGuard()
	 * @generated
	 */
	EReference getTracedEvaluateGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard <em>Traced Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Event Guard</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard
	 * @generated
	 */
	EClass getTracedEventGuard();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard#getOriginalObject()
	 * @see #getTracedEventGuard()
	 * @generated
	 */
	EReference getTracedEventGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock <em>Traced FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced FSM Clock</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock
	 * @generated
	 */
	EClass getTracedFSMClock();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Of Ticks Sequence</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getNumberOfTicksSequence()
	 * @see #getTracedFSMClock()
	 * @generated
	 */
	EReference getTracedFSMClock_NumberOfTicksSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getOriginalObject()
	 * @see #getTracedFSMClock()
	 * @generated
	 */
	EReference getTracedFSMClock_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent <em>Traced FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced FSM Event</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent
	 * @generated
	 */
	EClass getTracedFSMEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getIsTriggeredSequence <em>Is Triggered Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Is Triggered Sequence</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getIsTriggeredSequence()
	 * @see #getTracedFSMEvent()
	 * @generated
	 */
	EReference getTracedFSMEvent_IsTriggeredSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getOriginalObject()
	 * @see #getTracedFSMEvent()
	 * @generated
	 */
	EReference getTracedFSMEvent_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedGuard <em>Traced Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Guard</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedGuard
	 * @generated
	 */
	EClass getTracedGuard();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement <em>Traced Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Named Element</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement
	 * @generated
	 */
	EClass getTracedNamedElement();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedState <em>Traced State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced State</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedState
	 * @generated
	 */
	EClass getTracedState();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedState#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedState#getOriginalObject()
	 * @see #getTracedState()
	 * @generated
	 */
	EReference getTracedState_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM <em>Traced TFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced TFSM</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM
	 * @generated
	 */
	EClass getTracedTFSM();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getCurrentStateSequence <em>Current State Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Current State Sequence</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getCurrentStateSequence()
	 * @see #getTracedTFSM()
	 * @generated
	 */
	EReference getTracedTFSM_CurrentStateSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Last State Change Step Number Sequence</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getLastStateChangeStepNumberSequence()
	 * @see #getTracedTFSM()
	 * @generated
	 */
	EReference getTracedTFSM_LastStateChangeStepNumberSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getOriginalObject()
	 * @see #getTracedTFSM()
	 * @generated
	 */
	EReference getTracedTFSM_OriginalObject();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getStepNumberSequence <em>Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Step Number Sequence</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getStepNumberSequence()
	 * @see #getTracedTFSM()
	 * @generated
	 */
	EReference getTracedTFSM_StepNumberSequence();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard <em>Traced Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Temporal Guard</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard
	 * @generated
	 */
	EClass getTracedTemporalGuard();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard#getOriginalObject()
	 * @see #getTracedTemporalGuard()
	 * @generated
	 */
	EReference getTracedTemporalGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem <em>Traced Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Timed System</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem
	 * @generated
	 */
	EClass getTracedTimedSystem();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem#getOriginalObject()
	 * @see #getTracedTimedSystem()
	 * @generated
	 */
	EReference getTracedTimedSystem_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition <em>Traced Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Transition</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition
	 * @generated
	 */
	EClass getTracedTransition();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition#getOriginalObject()
	 * @see #getTracedTransition()
	 * @generated
	 */
	EReference getTracedTransition_OriginalObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Tfsm_plaink3Factory getTfsm_plaink3Factory();

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
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedEvaluateGuardImpl <em>Traced Evaluate Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedEvaluateGuardImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedEvaluateGuard()
		 * @generated
		 */
		EClass TRACED_EVALUATE_GUARD = eINSTANCE.getTracedEvaluateGuard();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_EVALUATE_GUARD__ORIGINAL_OBJECT = eINSTANCE.getTracedEvaluateGuard_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedEventGuardImpl <em>Traced Event Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedEventGuardImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedEventGuard()
		 * @generated
		 */
		EClass TRACED_EVENT_GUARD = eINSTANCE.getTracedEventGuard();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_EVENT_GUARD__ORIGINAL_OBJECT = eINSTANCE.getTracedEventGuard_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl <em>Traced FSM Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedFSMClock()
		 * @generated
		 */
		EClass TRACED_FSM_CLOCK = eINSTANCE.getTracedFSMClock();

		/**
		 * The meta object literal for the '<em><b>Number Of Ticks Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE = eINSTANCE.getTracedFSMClock_NumberOfTicksSequence();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_FSM_CLOCK__ORIGINAL_OBJECT = eINSTANCE.getTracedFSMClock_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMEventImpl <em>Traced FSM Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMEventImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedFSMEvent()
		 * @generated
		 */
		EClass TRACED_FSM_EVENT = eINSTANCE.getTracedFSMEvent();

		/**
		 * The meta object literal for the '<em><b>Is Triggered Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE = eINSTANCE.getTracedFSMEvent_IsTriggeredSequence();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_FSM_EVENT__ORIGINAL_OBJECT = eINSTANCE.getTracedFSMEvent_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedGuardImpl <em>Traced Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedGuardImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedGuard()
		 * @generated
		 */
		EClass TRACED_GUARD = eINSTANCE.getTracedGuard();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl <em>Traced Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedNamedElement()
		 * @generated
		 */
		EClass TRACED_NAMED_ELEMENT = eINSTANCE.getTracedNamedElement();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedStateImpl <em>Traced State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedStateImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedState()
		 * @generated
		 */
		EClass TRACED_STATE = eINSTANCE.getTracedState();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_STATE__ORIGINAL_OBJECT = eINSTANCE.getTracedState_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl <em>Traced TFSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTFSM()
		 * @generated
		 */
		EClass TRACED_TFSM = eINSTANCE.getTracedTFSM();

		/**
		 * The meta object literal for the '<em><b>Current State Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TFSM__CURRENT_STATE_SEQUENCE = eINSTANCE.getTracedTFSM_CurrentStateSequence();

		/**
		 * The meta object literal for the '<em><b>Last State Change Step Number Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE = eINSTANCE.getTracedTFSM_LastStateChangeStepNumberSequence();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TFSM__ORIGINAL_OBJECT = eINSTANCE.getTracedTFSM_OriginalObject();

		/**
		 * The meta object literal for the '<em><b>Step Number Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TFSM__STEP_NUMBER_SEQUENCE = eINSTANCE.getTracedTFSM_StepNumberSequence();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTemporalGuardImpl <em>Traced Temporal Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTemporalGuardImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTemporalGuard()
		 * @generated
		 */
		EClass TRACED_TEMPORAL_GUARD = eINSTANCE.getTracedTemporalGuard();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TEMPORAL_GUARD__ORIGINAL_OBJECT = eINSTANCE.getTracedTemporalGuard_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTimedSystemImpl <em>Traced Timed System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTimedSystemImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTimedSystem()
		 * @generated
		 */
		EClass TRACED_TIMED_SYSTEM = eINSTANCE.getTracedTimedSystem();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TIMED_SYSTEM__ORIGINAL_OBJECT = eINSTANCE.getTracedTimedSystem_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTransitionImpl <em>Traced Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTransitionImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTransition()
		 * @generated
		 */
		EClass TRACED_TRANSITION = eINSTANCE.getTracedTransition();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TRANSITION__ORIGINAL_OBJECT = eINSTANCE.getTracedTransition_OriginalObject();

	}

} //Tfsm_plaink3Package
