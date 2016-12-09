/**
 */
package fsmTrace.States.fsm;

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
 * @see fsmTrace.States.fsm.FsmFactory
 * @model kind="package"
 * @generated
 */
public interface FsmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fsm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "fsmTrace_fsm";

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
	FsmPackage eINSTANCE = fsmTrace.States.fsm.impl.FsmPackageImpl.init();

	/**
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedNamedElementImpl <em>Traced Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedNamedElementImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedNamedElement()
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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedGuardImpl <em>Traced Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedGuardImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedGuard()
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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedEvaluateGuardImpl <em>Traced Evaluate Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedEvaluateGuardImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedEvaluateGuard()
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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedEventGuardImpl <em>Traced Event Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedEventGuardImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedEventGuard()
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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedFSMClockImpl <em>Traced FSM Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedFSMClockImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedFSMClock()
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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedFSMEventImpl <em>Traced FSM Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedFSMEventImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedFSMEvent()
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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedStateImpl <em>Traced State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedStateImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedState()
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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedTemporalGuardImpl <em>Traced Temporal Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedTemporalGuardImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedTemporalGuard()
	 * @generated
	 */
	int TRACED_TEMPORAL_GUARD = 7;

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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedTimeFSMImpl <em>Traced Time FSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedTimeFSMImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedTimeFSM()
	 * @generated
	 */
	int TRACED_TIME_FSM = 8;

	/**
	 * The feature id for the '<em><b>Current State Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last State Change Step Number Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TIME_FSM__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Step Number Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Traced Time FSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TIME_FSM_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedTimedSystemImpl <em>Traced Timed System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedTimedSystemImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedTimedSystem()
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
	 * The meta object id for the '{@link fsmTrace.States.fsm.impl.TracedTransitionImpl <em>Traced Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.States.fsm.impl.TracedTransitionImpl
	 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedTransition()
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
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedEvaluateGuard <em>Traced Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Evaluate Guard</em>'.
	 * @see fsmTrace.States.fsm.TracedEvaluateGuard
	 * @generated
	 */
	EClass getTracedEvaluateGuard();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedEvaluateGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedEvaluateGuard#getOriginalObject()
	 * @see #getTracedEvaluateGuard()
	 * @generated
	 */
	EReference getTracedEvaluateGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedEventGuard <em>Traced Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Event Guard</em>'.
	 * @see fsmTrace.States.fsm.TracedEventGuard
	 * @generated
	 */
	EClass getTracedEventGuard();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedEventGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedEventGuard#getOriginalObject()
	 * @see #getTracedEventGuard()
	 * @generated
	 */
	EReference getTracedEventGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedFSMClock <em>Traced FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced FSM Clock</em>'.
	 * @see fsmTrace.States.fsm.TracedFSMClock
	 * @generated
	 */
	EClass getTracedFSMClock();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.States.fsm.TracedFSMClock#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Of Ticks Sequence</em>'.
	 * @see fsmTrace.States.fsm.TracedFSMClock#getNumberOfTicksSequence()
	 * @see #getTracedFSMClock()
	 * @generated
	 */
	EReference getTracedFSMClock_NumberOfTicksSequence();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedFSMClock#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedFSMClock#getOriginalObject()
	 * @see #getTracedFSMClock()
	 * @generated
	 */
	EReference getTracedFSMClock_OriginalObject();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedFSMEvent <em>Traced FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced FSM Event</em>'.
	 * @see fsmTrace.States.fsm.TracedFSMEvent
	 * @generated
	 */
	EClass getTracedFSMEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.States.fsm.TracedFSMEvent#getIsTriggeredSequence <em>Is Triggered Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Is Triggered Sequence</em>'.
	 * @see fsmTrace.States.fsm.TracedFSMEvent#getIsTriggeredSequence()
	 * @see #getTracedFSMEvent()
	 * @generated
	 */
	EReference getTracedFSMEvent_IsTriggeredSequence();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedFSMEvent#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedFSMEvent#getOriginalObject()
	 * @see #getTracedFSMEvent()
	 * @generated
	 */
	EReference getTracedFSMEvent_OriginalObject();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedGuard <em>Traced Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Guard</em>'.
	 * @see fsmTrace.States.fsm.TracedGuard
	 * @generated
	 */
	EClass getTracedGuard();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedNamedElement <em>Traced Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Named Element</em>'.
	 * @see fsmTrace.States.fsm.TracedNamedElement
	 * @generated
	 */
	EClass getTracedNamedElement();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedState <em>Traced State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced State</em>'.
	 * @see fsmTrace.States.fsm.TracedState
	 * @generated
	 */
	EClass getTracedState();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedState#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedState#getOriginalObject()
	 * @see #getTracedState()
	 * @generated
	 */
	EReference getTracedState_OriginalObject();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedTemporalGuard <em>Traced Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Temporal Guard</em>'.
	 * @see fsmTrace.States.fsm.TracedTemporalGuard
	 * @generated
	 */
	EClass getTracedTemporalGuard();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedTemporalGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedTemporalGuard#getOriginalObject()
	 * @see #getTracedTemporalGuard()
	 * @generated
	 */
	EReference getTracedTemporalGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedTimeFSM <em>Traced Time FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Time FSM</em>'.
	 * @see fsmTrace.States.fsm.TracedTimeFSM
	 * @generated
	 */
	EClass getTracedTimeFSM();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.States.fsm.TracedTimeFSM#getCurrentStateSequence <em>Current State Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Current State Sequence</em>'.
	 * @see fsmTrace.States.fsm.TracedTimeFSM#getCurrentStateSequence()
	 * @see #getTracedTimeFSM()
	 * @generated
	 */
	EReference getTracedTimeFSM_CurrentStateSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.States.fsm.TracedTimeFSM#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Last State Change Step Number Sequence</em>'.
	 * @see fsmTrace.States.fsm.TracedTimeFSM#getLastStateChangeStepNumberSequence()
	 * @see #getTracedTimeFSM()
	 * @generated
	 */
	EReference getTracedTimeFSM_LastStateChangeStepNumberSequence();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedTimeFSM#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedTimeFSM#getOriginalObject()
	 * @see #getTracedTimeFSM()
	 * @generated
	 */
	EReference getTracedTimeFSM_OriginalObject();

	/**
	 * Returns the meta object for the containment reference list '{@link fsmTrace.States.fsm.TracedTimeFSM#getStepNumberSequence <em>Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Step Number Sequence</em>'.
	 * @see fsmTrace.States.fsm.TracedTimeFSM#getStepNumberSequence()
	 * @see #getTracedTimeFSM()
	 * @generated
	 */
	EReference getTracedTimeFSM_StepNumberSequence();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedTimedSystem <em>Traced Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Timed System</em>'.
	 * @see fsmTrace.States.fsm.TracedTimedSystem
	 * @generated
	 */
	EClass getTracedTimedSystem();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedTimedSystem#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedTimedSystem#getOriginalObject()
	 * @see #getTracedTimedSystem()
	 * @generated
	 */
	EReference getTracedTimedSystem_OriginalObject();

	/**
	 * Returns the meta object for class '{@link fsmTrace.States.fsm.TracedTransition <em>Traced Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Transition</em>'.
	 * @see fsmTrace.States.fsm.TracedTransition
	 * @generated
	 */
	EClass getTracedTransition();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.States.fsm.TracedTransition#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see fsmTrace.States.fsm.TracedTransition#getOriginalObject()
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
	FsmFactory getFsmFactory();

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
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedEvaluateGuardImpl <em>Traced Evaluate Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedEvaluateGuardImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedEvaluateGuard()
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
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedEventGuardImpl <em>Traced Event Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedEventGuardImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedEventGuard()
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
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedFSMClockImpl <em>Traced FSM Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedFSMClockImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedFSMClock()
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
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedFSMEventImpl <em>Traced FSM Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedFSMEventImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedFSMEvent()
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
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedGuardImpl <em>Traced Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedGuardImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedGuard()
		 * @generated
		 */
		EClass TRACED_GUARD = eINSTANCE.getTracedGuard();

		/**
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedNamedElementImpl <em>Traced Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedNamedElementImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedNamedElement()
		 * @generated
		 */
		EClass TRACED_NAMED_ELEMENT = eINSTANCE.getTracedNamedElement();

		/**
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedStateImpl <em>Traced State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedStateImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedState()
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
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedTemporalGuardImpl <em>Traced Temporal Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedTemporalGuardImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedTemporalGuard()
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
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedTimeFSMImpl <em>Traced Time FSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedTimeFSMImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedTimeFSM()
		 * @generated
		 */
		EClass TRACED_TIME_FSM = eINSTANCE.getTracedTimeFSM();

		/**
		 * The meta object literal for the '<em><b>Current State Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE = eINSTANCE.getTracedTimeFSM_CurrentStateSequence();

		/**
		 * The meta object literal for the '<em><b>Last State Change Step Number Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE = eINSTANCE.getTracedTimeFSM_LastStateChangeStepNumberSequence();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TIME_FSM__ORIGINAL_OBJECT = eINSTANCE.getTracedTimeFSM_OriginalObject();

		/**
		 * The meta object literal for the '<em><b>Step Number Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE = eINSTANCE.getTracedTimeFSM_StepNumberSequence();

		/**
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedTimedSystemImpl <em>Traced Timed System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedTimedSystemImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedTimedSystem()
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
		 * The meta object literal for the '{@link fsmTrace.States.fsm.impl.TracedTransitionImpl <em>Traced Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.States.fsm.impl.TracedTransitionImpl
		 * @see fsmTrace.States.fsm.impl.FsmPackageImpl#getTracedTransition()
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

} //FsmPackage
