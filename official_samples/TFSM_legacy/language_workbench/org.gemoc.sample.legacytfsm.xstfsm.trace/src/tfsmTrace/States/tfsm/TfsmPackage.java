/**
 */
package tfsmTrace.States.tfsm;

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
 * @see tfsmTrace.States.tfsm.TfsmFactory
 * @model kind="package"
 * @generated
 */
public interface TfsmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tfsm";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tfsmTrace_tfsm";

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
	TfsmPackage eINSTANCE = tfsmTrace.States.tfsm.impl.TfsmPackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedNamedElementImpl <em>Traced Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedNamedElementImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedNamedElement()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedGuardImpl <em>Traced Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedGuardImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedGuard()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedEvaluateGuardImpl <em>Traced Evaluate Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedEvaluateGuardImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedEvaluateGuard()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedEventGuardImpl <em>Traced Event Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedEventGuardImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedEventGuard()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedFSMClockImpl <em>Traced FSM Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedFSMClockImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedFSMClock()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedFSMEventImpl <em>Traced FSM Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedFSMEventImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedFSMEvent()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedStateImpl <em>Traced State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedStateImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedState()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedTemporalGuardImpl <em>Traced Temporal Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedTemporalGuardImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedTemporalGuard()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedTimeFSMImpl <em>Traced Time FSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedTimeFSMImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedTimeFSM()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedTimedSystemImpl <em>Traced Timed System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedTimedSystemImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedTimedSystem()
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
	 * The meta object id for the '{@link tfsmTrace.States.tfsm.impl.TracedTransitionImpl <em>Traced Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.States.tfsm.impl.TracedTransitionImpl
	 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedTransition()
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
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedEvaluateGuard <em>Traced Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Evaluate Guard</em>'.
	 * @see tfsmTrace.States.tfsm.TracedEvaluateGuard
	 * @generated
	 */
	EClass getTracedEvaluateGuard();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedEvaluateGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedEvaluateGuard#getOriginalObject()
	 * @see #getTracedEvaluateGuard()
	 * @generated
	 */
	EReference getTracedEvaluateGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedEventGuard <em>Traced Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Event Guard</em>'.
	 * @see tfsmTrace.States.tfsm.TracedEventGuard
	 * @generated
	 */
	EClass getTracedEventGuard();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedEventGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedEventGuard#getOriginalObject()
	 * @see #getTracedEventGuard()
	 * @generated
	 */
	EReference getTracedEventGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedFSMClock <em>Traced FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced FSM Clock</em>'.
	 * @see tfsmTrace.States.tfsm.TracedFSMClock
	 * @generated
	 */
	EClass getTracedFSMClock();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.States.tfsm.TracedFSMClock#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Of Ticks Sequence</em>'.
	 * @see tfsmTrace.States.tfsm.TracedFSMClock#getNumberOfTicksSequence()
	 * @see #getTracedFSMClock()
	 * @generated
	 */
	EReference getTracedFSMClock_NumberOfTicksSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedFSMClock#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedFSMClock#getOriginalObject()
	 * @see #getTracedFSMClock()
	 * @generated
	 */
	EReference getTracedFSMClock_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedFSMEvent <em>Traced FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced FSM Event</em>'.
	 * @see tfsmTrace.States.tfsm.TracedFSMEvent
	 * @generated
	 */
	EClass getTracedFSMEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.States.tfsm.TracedFSMEvent#getIsTriggeredSequence <em>Is Triggered Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Is Triggered Sequence</em>'.
	 * @see tfsmTrace.States.tfsm.TracedFSMEvent#getIsTriggeredSequence()
	 * @see #getTracedFSMEvent()
	 * @generated
	 */
	EReference getTracedFSMEvent_IsTriggeredSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedFSMEvent#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedFSMEvent#getOriginalObject()
	 * @see #getTracedFSMEvent()
	 * @generated
	 */
	EReference getTracedFSMEvent_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedGuard <em>Traced Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Guard</em>'.
	 * @see tfsmTrace.States.tfsm.TracedGuard
	 * @generated
	 */
	EClass getTracedGuard();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedNamedElement <em>Traced Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Named Element</em>'.
	 * @see tfsmTrace.States.tfsm.TracedNamedElement
	 * @generated
	 */
	EClass getTracedNamedElement();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedState <em>Traced State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced State</em>'.
	 * @see tfsmTrace.States.tfsm.TracedState
	 * @generated
	 */
	EClass getTracedState();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedState#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedState#getOriginalObject()
	 * @see #getTracedState()
	 * @generated
	 */
	EReference getTracedState_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedTemporalGuard <em>Traced Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Temporal Guard</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTemporalGuard
	 * @generated
	 */
	EClass getTracedTemporalGuard();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedTemporalGuard#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTemporalGuard#getOriginalObject()
	 * @see #getTracedTemporalGuard()
	 * @generated
	 */
	EReference getTracedTemporalGuard_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedTimeFSM <em>Traced Time FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Time FSM</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTimeFSM
	 * @generated
	 */
	EClass getTracedTimeFSM();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.States.tfsm.TracedTimeFSM#getCurrentStateSequence <em>Current State Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Current State Sequence</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTimeFSM#getCurrentStateSequence()
	 * @see #getTracedTimeFSM()
	 * @generated
	 */
	EReference getTracedTimeFSM_CurrentStateSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.States.tfsm.TracedTimeFSM#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Last State Change Step Number Sequence</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTimeFSM#getLastStateChangeStepNumberSequence()
	 * @see #getTracedTimeFSM()
	 * @generated
	 */
	EReference getTracedTimeFSM_LastStateChangeStepNumberSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedTimeFSM#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTimeFSM#getOriginalObject()
	 * @see #getTracedTimeFSM()
	 * @generated
	 */
	EReference getTracedTimeFSM_OriginalObject();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsmTrace.States.tfsm.TracedTimeFSM#getStepNumberSequence <em>Step Number Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Step Number Sequence</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTimeFSM#getStepNumberSequence()
	 * @see #getTracedTimeFSM()
	 * @generated
	 */
	EReference getTracedTimeFSM_StepNumberSequence();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedTimedSystem <em>Traced Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Timed System</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTimedSystem
	 * @generated
	 */
	EClass getTracedTimedSystem();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedTimedSystem#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTimedSystem#getOriginalObject()
	 * @see #getTracedTimedSystem()
	 * @generated
	 */
	EReference getTracedTimedSystem_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.States.tfsm.TracedTransition <em>Traced Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Transition</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTransition
	 * @generated
	 */
	EClass getTracedTransition();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.States.tfsm.TracedTransition#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsmTrace.States.tfsm.TracedTransition#getOriginalObject()
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
	TfsmFactory getTfsmFactory();

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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedEvaluateGuardImpl <em>Traced Evaluate Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedEvaluateGuardImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedEvaluateGuard()
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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedEventGuardImpl <em>Traced Event Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedEventGuardImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedEventGuard()
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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedFSMClockImpl <em>Traced FSM Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedFSMClockImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedFSMClock()
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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedFSMEventImpl <em>Traced FSM Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedFSMEventImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedFSMEvent()
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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedGuardImpl <em>Traced Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedGuardImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedGuard()
		 * @generated
		 */
		EClass TRACED_GUARD = eINSTANCE.getTracedGuard();

		/**
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedNamedElementImpl <em>Traced Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedNamedElementImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedNamedElement()
		 * @generated
		 */
		EClass TRACED_NAMED_ELEMENT = eINSTANCE.getTracedNamedElement();

		/**
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedStateImpl <em>Traced State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedStateImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedState()
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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedTemporalGuardImpl <em>Traced Temporal Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedTemporalGuardImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedTemporalGuard()
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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedTimeFSMImpl <em>Traced Time FSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedTimeFSMImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedTimeFSM()
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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedTimedSystemImpl <em>Traced Timed System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedTimedSystemImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedTimedSystem()
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
		 * The meta object literal for the '{@link tfsmTrace.States.tfsm.impl.TracedTransitionImpl <em>Traced Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.States.tfsm.impl.TracedTransitionImpl
		 * @see tfsmTrace.States.tfsm.impl.TfsmPackageImpl#getTracedTransition()
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

} //TfsmPackage
