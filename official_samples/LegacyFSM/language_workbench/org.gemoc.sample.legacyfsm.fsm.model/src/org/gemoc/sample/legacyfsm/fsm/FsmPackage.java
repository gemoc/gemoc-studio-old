/**
 */
package org.gemoc.sample.legacyfsm.fsm;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.gemoc.sample.legacyfsm.fsm.FsmFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
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
	String eNS_URI = "http://www.gemoc.org/legacyfsm/fsm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fsm";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmPackage eINSTANCE = org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.NamedElementImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.TimeFSMImpl <em>Time FSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.TimeFSMImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getTimeFSM()
	 * @generated
	 */
	int TIME_FSM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FSM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FSM__OWNED_STATES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FSM__INITIAL_STATE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Local Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FSM__LOCAL_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local Clock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FSM__LOCAL_CLOCK = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FSM__OWNED_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Time FSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FSM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Time FSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FSM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.StateImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owning FSM</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNING_FSM = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.TransitionImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OWNED_GUARD = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Generated Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GENERATED_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTION = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.GuardImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.TemporalGuardImpl <em>Temporal Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.TemporalGuardImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getTemporalGuard()
	 * @generated
	 */
	int TEMPORAL_GUARD = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_GUARD__NAME = GUARD__NAME;

	/**
	 * The feature id for the '<em><b>On Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_GUARD__ON_CLOCK = GUARD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>After Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_GUARD__AFTER_DURATION = GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Temporal Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_GUARD_FEATURE_COUNT = GUARD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Temporal Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_GUARD_OPERATION_COUNT = GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.EventGuardImpl <em>Event Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.EventGuardImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getEventGuard()
	 * @generated
	 */
	int EVENT_GUARD = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD__NAME = GUARD__NAME;

	/**
	 * The feature id for the '<em><b>Triggering Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD__TRIGGERING_EVENT = GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD_FEATURE_COUNT = GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Event Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD_OPERATION_COUNT = GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.FSMEventImpl <em>FSM Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FSMEventImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getFSMEvent()
	 * @generated
	 */
	int FSM_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT__SOLLICITING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FSM Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>FSM Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.FSMClockImpl <em>FSM Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FSMClockImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getFSMClock()
	 * @generated
	 */
	int FSM_CLOCK = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>FSM Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>FSM Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.TimedSystemImpl <em>Timed System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.TimedSystemImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getTimedSystem()
	 * @generated
	 */
	int TIMED_SYSTEM = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Fsms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM__FSMS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM__GLOBAL_CLOCKS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Global Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM__GLOBAL_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Timed System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Timed System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.EvaluateGuardImpl <em>Evaluate Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.EvaluateGuardImpl
	 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getEvaluateGuard()
	 * @generated
	 */
	int EVALUATE_GUARD = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATE_GUARD__NAME = GUARD__NAME;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATE_GUARD__CONDITION = GUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Evaluate Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATE_GUARD_FEATURE_COUNT = GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Evaluate Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATE_GUARD_OPERATION_COUNT = GUARD_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.TimeFSM <em>Time FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time FSM</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimeFSM
	 * @generated
	 */
	EClass getTimeFSM();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.sample.legacyfsm.fsm.TimeFSM#getOwnedStates <em>Owned States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned States</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimeFSM#getOwnedStates()
	 * @see #getTimeFSM()
	 * @generated
	 */
	EReference getTimeFSM_OwnedStates();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.sample.legacyfsm.fsm.TimeFSM#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimeFSM#getInitialState()
	 * @see #getTimeFSM()
	 * @generated
	 */
	EReference getTimeFSM_InitialState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.sample.legacyfsm.fsm.TimeFSM#getLocalEvents <em>Local Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Events</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimeFSM#getLocalEvents()
	 * @see #getTimeFSM()
	 * @generated
	 */
	EReference getTimeFSM_LocalEvents();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.sample.legacyfsm.fsm.TimeFSM#getLocalClock <em>Local Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Clock</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimeFSM#getLocalClock()
	 * @see #getTimeFSM()
	 * @generated
	 */
	EReference getTimeFSM_LocalClock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.sample.legacyfsm.fsm.TimeFSM#getOwnedTransitions <em>Owned Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Transitions</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimeFSM#getOwnedTransitions()
	 * @see #getTimeFSM()
	 * @generated
	 */
	EReference getTimeFSM_OwnedTransitions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the container reference '{@link org.gemoc.sample.legacyfsm.fsm.State#getOwningFSM <em>Owning FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning FSM</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.State#getOwningFSM()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwningFSM();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.sample.legacyfsm.fsm.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.State#getOutgoingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutgoingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.sample.legacyfsm.fsm.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.State#getIncomingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_IncomingTransitions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.sample.legacyfsm.fsm.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.sample.legacyfsm.fsm.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.sample.legacyfsm.fsm.Transition#getOwnedGuard <em>Owned Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Guard</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.Transition#getOwnedGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_OwnedGuard();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.sample.legacyfsm.fsm.Transition#getGeneratedEvents <em>Generated Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Generated Events</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.Transition#getGeneratedEvents()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_GeneratedEvents();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.sample.legacyfsm.fsm.Transition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.Transition#getAction()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Action();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.sample.legacyfsm.fsm.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.TemporalGuard <em>Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporal Guard</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TemporalGuard
	 * @generated
	 */
	EClass getTemporalGuard();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.sample.legacyfsm.fsm.TemporalGuard#getOnClock <em>On Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>On Clock</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TemporalGuard#getOnClock()
	 * @see #getTemporalGuard()
	 * @generated
	 */
	EReference getTemporalGuard_OnClock();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.sample.legacyfsm.fsm.TemporalGuard#getAfterDuration <em>After Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>After Duration</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TemporalGuard#getAfterDuration()
	 * @see #getTemporalGuard()
	 * @generated
	 */
	EAttribute getTemporalGuard_AfterDuration();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.EventGuard <em>Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Guard</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.EventGuard
	 * @generated
	 */
	EClass getEventGuard();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.sample.legacyfsm.fsm.EventGuard#getTriggeringEvent <em>Triggering Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Triggering Event</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.EventGuard#getTriggeringEvent()
	 * @see #getEventGuard()
	 * @generated
	 */
	EReference getEventGuard_TriggeringEvent();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.FSMEvent <em>FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Event</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.FSMEvent
	 * @generated
	 */
	EClass getFSMEvent();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.sample.legacyfsm.fsm.FSMEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Solliciting Transitions</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.FSMEvent#getSollicitingTransitions()
	 * @see #getFSMEvent()
	 * @generated
	 */
	EReference getFSMEvent_SollicitingTransitions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.FSMClock <em>FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Clock</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.FSMClock
	 * @generated
	 */
	EClass getFSMClock();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.TimedSystem <em>Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed System</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimedSystem
	 * @generated
	 */
	EClass getTimedSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.sample.legacyfsm.fsm.TimedSystem#getFsms <em>Fsms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fsms</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimedSystem#getFsms()
	 * @see #getTimedSystem()
	 * @generated
	 */
	EReference getTimedSystem_Fsms();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.sample.legacyfsm.fsm.TimedSystem#getGlobalClocks <em>Global Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Clocks</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimedSystem#getGlobalClocks()
	 * @see #getTimedSystem()
	 * @generated
	 */
	EReference getTimedSystem_GlobalClocks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.sample.legacyfsm.fsm.TimedSystem#getGlobalEvents <em>Global Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Events</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.TimedSystem#getGlobalEvents()
	 * @see #getTimedSystem()
	 * @generated
	 */
	EReference getTimedSystem_GlobalEvents();

	/**
	 * Returns the meta object for class '{@link org.gemoc.sample.legacyfsm.fsm.EvaluateGuard <em>Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluate Guard</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.EvaluateGuard
	 * @generated
	 */
	EClass getEvaluateGuard();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.sample.legacyfsm.fsm.EvaluateGuard#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.gemoc.sample.legacyfsm.fsm.EvaluateGuard#getCondition()
	 * @see #getEvaluateGuard()
	 * @generated
	 */
	EAttribute getEvaluateGuard_Condition();

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
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.TimeFSMImpl <em>Time FSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.TimeFSMImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getTimeFSM()
		 * @generated
		 */
		EClass TIME_FSM = eINSTANCE.getTimeFSM();

		/**
		 * The meta object literal for the '<em><b>Owned States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_FSM__OWNED_STATES = eINSTANCE.getTimeFSM_OwnedStates();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_FSM__INITIAL_STATE = eINSTANCE.getTimeFSM_InitialState();

		/**
		 * The meta object literal for the '<em><b>Local Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_FSM__LOCAL_EVENTS = eINSTANCE.getTimeFSM_LocalEvents();

		/**
		 * The meta object literal for the '<em><b>Local Clock</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_FSM__LOCAL_CLOCK = eINSTANCE.getTimeFSM_LocalClock();

		/**
		 * The meta object literal for the '<em><b>Owned Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_FSM__OWNED_TRANSITIONS = eINSTANCE.getTimeFSM_OwnedTransitions();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.StateImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Owning FSM</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNING_FSM = eINSTANCE.getState_OwningFSM();

		/**
		 * The meta object literal for the '<em><b>Outgoing Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTGOING_TRANSITIONS = eINSTANCE.getState_OutgoingTransitions();

		/**
		 * The meta object literal for the '<em><b>Incoming Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INCOMING_TRANSITIONS = eINSTANCE.getState_IncomingTransitions();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.TransitionImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Owned Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__OWNED_GUARD = eINSTANCE.getTransition_OwnedGuard();

		/**
		 * The meta object literal for the '<em><b>Generated Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__GENERATED_EVENTS = eINSTANCE.getTransition_GeneratedEvents();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSITION__ACTION = eINSTANCE.getTransition_Action();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.NamedElementImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.GuardImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.TemporalGuardImpl <em>Temporal Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.TemporalGuardImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getTemporalGuard()
		 * @generated
		 */
		EClass TEMPORAL_GUARD = eINSTANCE.getTemporalGuard();

		/**
		 * The meta object literal for the '<em><b>On Clock</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPORAL_GUARD__ON_CLOCK = eINSTANCE.getTemporalGuard_OnClock();

		/**
		 * The meta object literal for the '<em><b>After Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPORAL_GUARD__AFTER_DURATION = eINSTANCE.getTemporalGuard_AfterDuration();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.EventGuardImpl <em>Event Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.EventGuardImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getEventGuard()
		 * @generated
		 */
		EClass EVENT_GUARD = eINSTANCE.getEventGuard();

		/**
		 * The meta object literal for the '<em><b>Triggering Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_GUARD__TRIGGERING_EVENT = eINSTANCE.getEventGuard_TriggeringEvent();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.FSMEventImpl <em>FSM Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FSMEventImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getFSMEvent()
		 * @generated
		 */
		EClass FSM_EVENT = eINSTANCE.getFSMEvent();

		/**
		 * The meta object literal for the '<em><b>Solliciting Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_EVENT__SOLLICITING_TRANSITIONS = eINSTANCE.getFSMEvent_SollicitingTransitions();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.FSMClockImpl <em>FSM Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FSMClockImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getFSMClock()
		 * @generated
		 */
		EClass FSM_CLOCK = eINSTANCE.getFSMClock();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.TimedSystemImpl <em>Timed System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.TimedSystemImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getTimedSystem()
		 * @generated
		 */
		EClass TIMED_SYSTEM = eINSTANCE.getTimedSystem();

		/**
		 * The meta object literal for the '<em><b>Fsms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_SYSTEM__FSMS = eINSTANCE.getTimedSystem_Fsms();

		/**
		 * The meta object literal for the '<em><b>Global Clocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_SYSTEM__GLOBAL_CLOCKS = eINSTANCE.getTimedSystem_GlobalClocks();

		/**
		 * The meta object literal for the '<em><b>Global Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_SYSTEM__GLOBAL_EVENTS = eINSTANCE.getTimedSystem_GlobalEvents();

		/**
		 * The meta object literal for the '{@link org.gemoc.sample.legacyfsm.fsm.impl.EvaluateGuardImpl <em>Evaluate Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.EvaluateGuardImpl
		 * @see org.gemoc.sample.legacyfsm.fsm.impl.FsmPackageImpl#getEvaluateGuard()
		 * @generated
		 */
		EClass EVALUATE_GUARD = eINSTANCE.getEvaluateGuard();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVALUATE_GUARD__CONDITION = eINSTANCE.getEvaluateGuard_Condition();

	}

} //FsmPackage
