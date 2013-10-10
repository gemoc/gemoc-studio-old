/**
 */
package tfsm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see tfsm.TfsmFactory
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
	String eNS_URI = "http://org.gemoc.execution.engine.example.tfsm";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.gemoc.execution.engine.example";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TfsmPackage eINSTANCE = tfsm.impl.TfsmPackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsm.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.NamedElementImpl
	 * @see tfsm.impl.TfsmPackageImpl#getNamedElement()
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
	 * The meta object id for the '{@link tfsm.impl.TfsmImpl <em>Tfsm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TfsmImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTfsm()
	 * @generated
	 */
	int TFSM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__OWNED_STATES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__INITIAL_STATE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__OWNED_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Clock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__OWNED_CLOCK = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__OWNED_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Tfsm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM___INITIALIZE = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.StateImpl
	 * @see tfsm.impl.TfsmPackageImpl#getState()
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
	 * The feature id for the '<em><b>Owning Tfsm</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNING_TFSM = NAMED_ELEMENT_FEATURE_COUNT + 0;

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
	 * The operation id for the '<em>On Enter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE___ON_ENTER = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>On Leave</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE___ON_LEAVE = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link tfsm.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TransitionImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTransition()
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
	 * The operation id for the '<em>Fire</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION___FIRE = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.GuardImpl
	 * @see tfsm.impl.TfsmPackageImpl#getGuard()
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
	 * The meta object id for the '{@link tfsm.impl.TemporalGuardImpl <em>Temporal Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TemporalGuardImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTemporalGuard()
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
	 * The meta object id for the '{@link tfsm.impl.EventGuardImpl <em>Event Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.EventGuardImpl
	 * @see tfsm.impl.TfsmPackageImpl#getEventGuard()
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
	 * The meta object id for the '{@link tfsm.impl.TfsmEventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TfsmEventImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTfsmEvent()
	 * @generated
	 */
	int TFSM_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_EVENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_EVENT__SOLLICITING_TRANSITIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_EVENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.TfsmClockImpl <em>Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.TfsmClockImpl
	 * @see tfsm.impl.TfsmPackageImpl#getTfsmClock()
	 * @generated
	 */
	int TFSM_CLOCK = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CLOCK__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CLOCK_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Tick</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CLOCK___TICK = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Initialize</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CLOCK___INITIALIZE = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CLOCK_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link tfsm.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.SystemImpl
	 * @see tfsm.impl.TfsmPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tfsms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__TFSMS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__GLOBAL_CLOCKS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Global Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__GLOBAL_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm.impl.EvaluateGuardImpl <em>Evaluate Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm.impl.EvaluateGuardImpl
	 * @see tfsm.impl.TfsmPackageImpl#getEvaluateGuard()
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
	 * The operation id for the '<em>Evaluate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATE_GUARD___EVALUATE = GUARD_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Evaluate Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATE_GUARD_OPERATION_COUNT = GUARD_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link tfsm.Tfsm <em>Tfsm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm</em>'.
	 * @see tfsm.Tfsm
	 * @generated
	 */
	EClass getTfsm();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm.Tfsm#getOwnedStates <em>Owned States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned States</em>'.
	 * @see tfsm.Tfsm#getOwnedStates()
	 * @see #getTfsm()
	 * @generated
	 */
	EReference getTfsm_OwnedStates();

	/**
	 * Returns the meta object for the reference '{@link tfsm.Tfsm#getInitialState <em>Initial State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial State</em>'.
	 * @see tfsm.Tfsm#getInitialState()
	 * @see #getTfsm()
	 * @generated
	 */
	EReference getTfsm_InitialState();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm.Tfsm#getOwnedEvents <em>Owned Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Events</em>'.
	 * @see tfsm.Tfsm#getOwnedEvents()
	 * @see #getTfsm()
	 * @generated
	 */
	EReference getTfsm_OwnedEvents();

	/**
	 * Returns the meta object for the containment reference '{@link tfsm.Tfsm#getOwnedClock <em>Owned Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Clock</em>'.
	 * @see tfsm.Tfsm#getOwnedClock()
	 * @see #getTfsm()
	 * @generated
	 */
	EReference getTfsm_OwnedClock();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm.Tfsm#getOwnedTransitions <em>Owned Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Transitions</em>'.
	 * @see tfsm.Tfsm#getOwnedTransitions()
	 * @see #getTfsm()
	 * @generated
	 */
	EReference getTfsm_OwnedTransitions();

	/**
	 * Returns the meta object for the '{@link tfsm.Tfsm#initialize() <em>Initialize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Initialize</em>' operation.
	 * @see tfsm.Tfsm#initialize()
	 * @generated
	 */
	EOperation getTfsm__Initialize();

	/**
	 * Returns the meta object for class '{@link tfsm.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see tfsm.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference '{@link tfsm.State#getOwningTfsm <em>Owning Tfsm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owning Tfsm</em>'.
	 * @see tfsm.State#getOwningTfsm()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OwningTfsm();

	/**
	 * Returns the meta object for the reference list '{@link tfsm.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Transitions</em>'.
	 * @see tfsm.State#getOutgoingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_OutgoingTransitions();

	/**
	 * Returns the meta object for the reference list '{@link tfsm.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Transitions</em>'.
	 * @see tfsm.State#getIncomingTransitions()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_IncomingTransitions();

	/**
	 * Returns the meta object for the '{@link tfsm.State#onEnter() <em>On Enter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>On Enter</em>' operation.
	 * @see tfsm.State#onEnter()
	 * @generated
	 */
	EOperation getState__OnEnter();

	/**
	 * Returns the meta object for the '{@link tfsm.State#onLeave() <em>On Leave</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>On Leave</em>' operation.
	 * @see tfsm.State#onLeave()
	 * @generated
	 */
	EOperation getState__OnLeave();

	/**
	 * Returns the meta object for class '{@link tfsm.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see tfsm.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link tfsm.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see tfsm.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for the reference '{@link tfsm.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see tfsm.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the containment reference '{@link tfsm.Transition#getOwnedGuard <em>Owned Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Guard</em>'.
	 * @see tfsm.Transition#getOwnedGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_OwnedGuard();

	/**
	 * Returns the meta object for the reference list '{@link tfsm.Transition#getGeneratedEvents <em>Generated Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Generated Events</em>'.
	 * @see tfsm.Transition#getGeneratedEvents()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_GeneratedEvents();

	/**
	 * Returns the meta object for the attribute '{@link tfsm.Transition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see tfsm.Transition#getAction()
	 * @see #getTransition()
	 * @generated
	 */
	EAttribute getTransition_Action();

	/**
	 * Returns the meta object for the '{@link tfsm.Transition#fire() <em>Fire</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Fire</em>' operation.
	 * @see tfsm.Transition#fire()
	 * @generated
	 */
	EOperation getTransition__Fire();

	/**
	 * Returns the meta object for class '{@link tfsm.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see tfsm.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link tfsm.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tfsm.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link tfsm.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see tfsm.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for class '{@link tfsm.TemporalGuard <em>Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporal Guard</em>'.
	 * @see tfsm.TemporalGuard
	 * @generated
	 */
	EClass getTemporalGuard();

	/**
	 * Returns the meta object for the reference '{@link tfsm.TemporalGuard#getOnClock <em>On Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>On Clock</em>'.
	 * @see tfsm.TemporalGuard#getOnClock()
	 * @see #getTemporalGuard()
	 * @generated
	 */
	EReference getTemporalGuard_OnClock();

	/**
	 * Returns the meta object for the attribute '{@link tfsm.TemporalGuard#getAfterDuration <em>After Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>After Duration</em>'.
	 * @see tfsm.TemporalGuard#getAfterDuration()
	 * @see #getTemporalGuard()
	 * @generated
	 */
	EAttribute getTemporalGuard_AfterDuration();

	/**
	 * Returns the meta object for class '{@link tfsm.EventGuard <em>Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Guard</em>'.
	 * @see tfsm.EventGuard
	 * @generated
	 */
	EClass getEventGuard();

	/**
	 * Returns the meta object for the reference '{@link tfsm.EventGuard#getTriggeringEvent <em>Triggering Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Triggering Event</em>'.
	 * @see tfsm.EventGuard#getTriggeringEvent()
	 * @see #getEventGuard()
	 * @generated
	 */
	EReference getEventGuard_TriggeringEvent();

	/**
	 * Returns the meta object for class '{@link tfsm.TfsmEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see tfsm.TfsmEvent
	 * @generated
	 */
	EClass getTfsmEvent();

	/**
	 * Returns the meta object for the reference list '{@link tfsm.TfsmEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Solliciting Transitions</em>'.
	 * @see tfsm.TfsmEvent#getSollicitingTransitions()
	 * @see #getTfsmEvent()
	 * @generated
	 */
	EReference getTfsmEvent_SollicitingTransitions();

	/**
	 * Returns the meta object for class '{@link tfsm.TfsmClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock</em>'.
	 * @see tfsm.TfsmClock
	 * @generated
	 */
	EClass getTfsmClock();

	/**
	 * Returns the meta object for the '{@link tfsm.TfsmClock#tick() <em>Tick</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Tick</em>' operation.
	 * @see tfsm.TfsmClock#tick()
	 * @generated
	 */
	EOperation getTfsmClock__Tick();

	/**
	 * Returns the meta object for the '{@link tfsm.TfsmClock#initialize() <em>Initialize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Initialize</em>' operation.
	 * @see tfsm.TfsmClock#initialize()
	 * @generated
	 */
	EOperation getTfsmClock__Initialize();

	/**
	 * Returns the meta object for class '{@link tfsm.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see tfsm.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm.System#getTfsms <em>Tfsms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tfsms</em>'.
	 * @see tfsm.System#getTfsms()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Tfsms();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm.System#getGlobalClocks <em>Global Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Clocks</em>'.
	 * @see tfsm.System#getGlobalClocks()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_GlobalClocks();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm.System#getGlobalEvents <em>Global Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Events</em>'.
	 * @see tfsm.System#getGlobalEvents()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_GlobalEvents();

	/**
	 * Returns the meta object for class '{@link tfsm.EvaluateGuard <em>Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluate Guard</em>'.
	 * @see tfsm.EvaluateGuard
	 * @generated
	 */
	EClass getEvaluateGuard();

	/**
	 * Returns the meta object for the attribute '{@link tfsm.EvaluateGuard#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see tfsm.EvaluateGuard#getCondition()
	 * @see #getEvaluateGuard()
	 * @generated
	 */
	EAttribute getEvaluateGuard_Condition();

	/**
	 * Returns the meta object for the '{@link tfsm.EvaluateGuard#evaluate() <em>Evaluate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Evaluate</em>' operation.
	 * @see tfsm.EvaluateGuard#evaluate()
	 * @generated
	 */
	EOperation getEvaluateGuard__Evaluate();

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
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tfsm.impl.TfsmImpl <em>Tfsm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TfsmImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTfsm()
		 * @generated
		 */
		EClass TFSM = eINSTANCE.getTfsm();

		/**
		 * The meta object literal for the '<em><b>Owned States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM__OWNED_STATES = eINSTANCE.getTfsm_OwnedStates();

		/**
		 * The meta object literal for the '<em><b>Initial State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM__INITIAL_STATE = eINSTANCE.getTfsm_InitialState();

		/**
		 * The meta object literal for the '<em><b>Owned Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM__OWNED_EVENTS = eINSTANCE.getTfsm_OwnedEvents();

		/**
		 * The meta object literal for the '<em><b>Owned Clock</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM__OWNED_CLOCK = eINSTANCE.getTfsm_OwnedClock();

		/**
		 * The meta object literal for the '<em><b>Owned Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM__OWNED_TRANSITIONS = eINSTANCE.getTfsm_OwnedTransitions();

		/**
		 * The meta object literal for the '<em><b>Initialize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM___INITIALIZE = eINSTANCE.getTfsm__Initialize();

		/**
		 * The meta object literal for the '{@link tfsm.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.StateImpl
		 * @see tfsm.impl.TfsmPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Owning Tfsm</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OWNING_TFSM = eINSTANCE.getState_OwningTfsm();

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
		 * The meta object literal for the '<em><b>On Enter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STATE___ON_ENTER = eINSTANCE.getState__OnEnter();

		/**
		 * The meta object literal for the '<em><b>On Leave</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation STATE___ON_LEAVE = eINSTANCE.getState__OnLeave();

		/**
		 * The meta object literal for the '{@link tfsm.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TransitionImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTransition()
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
		 * The meta object literal for the '<em><b>Fire</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSITION___FIRE = eINSTANCE.getTransition__Fire();

		/**
		 * The meta object literal for the '{@link tfsm.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.NamedElementImpl
		 * @see tfsm.impl.TfsmPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link tfsm.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.GuardImpl
		 * @see tfsm.impl.TfsmPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '{@link tfsm.impl.TemporalGuardImpl <em>Temporal Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TemporalGuardImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTemporalGuard()
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
		 * The meta object literal for the '{@link tfsm.impl.EventGuardImpl <em>Event Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.EventGuardImpl
		 * @see tfsm.impl.TfsmPackageImpl#getEventGuard()
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
		 * The meta object literal for the '{@link tfsm.impl.TfsmEventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TfsmEventImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTfsmEvent()
		 * @generated
		 */
		EClass TFSM_EVENT = eINSTANCE.getTfsmEvent();

		/**
		 * The meta object literal for the '<em><b>Solliciting Transitions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_EVENT__SOLLICITING_TRANSITIONS = eINSTANCE.getTfsmEvent_SollicitingTransitions();

		/**
		 * The meta object literal for the '{@link tfsm.impl.TfsmClockImpl <em>Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.TfsmClockImpl
		 * @see tfsm.impl.TfsmPackageImpl#getTfsmClock()
		 * @generated
		 */
		EClass TFSM_CLOCK = eINSTANCE.getTfsmClock();

		/**
		 * The meta object literal for the '<em><b>Tick</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_CLOCK___TICK = eINSTANCE.getTfsmClock__Tick();

		/**
		 * The meta object literal for the '<em><b>Initialize</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_CLOCK___INITIALIZE = eINSTANCE.getTfsmClock__Initialize();

		/**
		 * The meta object literal for the '{@link tfsm.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.SystemImpl
		 * @see tfsm.impl.TfsmPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Tfsms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__TFSMS = eINSTANCE.getSystem_Tfsms();

		/**
		 * The meta object literal for the '<em><b>Global Clocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__GLOBAL_CLOCKS = eINSTANCE.getSystem_GlobalClocks();

		/**
		 * The meta object literal for the '<em><b>Global Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__GLOBAL_EVENTS = eINSTANCE.getSystem_GlobalEvents();

		/**
		 * The meta object literal for the '{@link tfsm.impl.EvaluateGuardImpl <em>Evaluate Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm.impl.EvaluateGuardImpl
		 * @see tfsm.impl.TfsmPackageImpl#getEvaluateGuard()
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

		/**
		 * The meta object literal for the '<em><b>Evaluate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation EVALUATE_GUARD___EVALUATE = eINSTANCE.getEvaluateGuard__Evaluate();

	}

} //TfsmPackage
