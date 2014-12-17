/**
 */
package tfsmextended.tfsmextended;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.gemoc.sample.tfsm.TfsmPackage;

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
 * @see tfsmextended.tfsmextended.TfsmextendedFactory
 * @model kind="package"
 * @generated
 */
public interface TfsmextendedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tfsmextended";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.sample.tfsm.plaink3.model/1.0/extended";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tfsmextended";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TfsmextendedPackage eINSTANCE = tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.TFSMImpl <em>TFSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.TFSMImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getTFSM()
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
	int TFSM__NAME = TfsmPackage.TFSM__NAME;

	/**
	 * The feature id for the '<em><b>Owned States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__OWNED_STATES = TfsmPackage.TFSM__OWNED_STATES;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__INITIAL_STATE = TfsmPackage.TFSM__INITIAL_STATE;

	/**
	 * The feature id for the '<em><b>Local Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__LOCAL_EVENTS = TfsmPackage.TFSM__LOCAL_EVENTS;

	/**
	 * The feature id for the '<em><b>Local Clock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__LOCAL_CLOCK = TfsmPackage.TFSM__LOCAL_CLOCK;

	/**
	 * The feature id for the '<em><b>Owned Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__OWNED_TRANSITIONS = TfsmPackage.TFSM__OWNED_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__CURRENT_STATE = TfsmPackage.TFSM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Step Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__STEP_NUMBER = TfsmPackage.TFSM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Last State Change Step Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM__LAST_STATE_CHANGE_STEP_NUMBER = TfsmPackage.TFSM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TFSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FEATURE_COUNT = TfsmPackage.TFSM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.StateImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getState()
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
	int STATE__NAME = TfsmPackage.STATE__NAME;

	/**
	 * The feature id for the '<em><b>Owning FSM</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNING_FSM = TfsmPackage.STATE__OWNING_FSM;

	/**
	 * The feature id for the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING_TRANSITIONS = TfsmPackage.STATE__OUTGOING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Incoming Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING_TRANSITIONS = TfsmPackage.STATE__INCOMING_TRANSITIONS;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = TfsmPackage.STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.TransitionImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getTransition()
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
	int TRANSITION__NAME = TfsmPackage.TRANSITION__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = TfsmPackage.TRANSITION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = TfsmPackage.TRANSITION__TARGET;

	/**
	 * The feature id for the '<em><b>Owned Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__OWNED_GUARD = TfsmPackage.TRANSITION__OWNED_GUARD;

	/**
	 * The feature id for the '<em><b>Generated Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GENERATED_EVENTS = TfsmPackage.TRANSITION__GENERATED_EVENTS;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTION = TfsmPackage.TRANSITION__ACTION;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = TfsmPackage.TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.NamedElementImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getNamedElement()
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
	int NAMED_ELEMENT__NAME = TfsmPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = TfsmPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.GuardImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getGuard()
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
	int GUARD__NAME = TfsmPackage.GUARD__NAME;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = TfsmPackage.GUARD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.TemporalGuardImpl <em>Temporal Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.TemporalGuardImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getTemporalGuard()
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
	int TEMPORAL_GUARD__NAME = TfsmPackage.TEMPORAL_GUARD__NAME;

	/**
	 * The feature id for the '<em><b>On Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_GUARD__ON_CLOCK = TfsmPackage.TEMPORAL_GUARD__ON_CLOCK;

	/**
	 * The feature id for the '<em><b>After Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_GUARD__AFTER_DURATION = TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION;

	/**
	 * The number of structural features of the '<em>Temporal Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_GUARD_FEATURE_COUNT = TfsmPackage.TEMPORAL_GUARD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.EventGuardImpl <em>Event Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.EventGuardImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getEventGuard()
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
	int EVENT_GUARD__NAME = TfsmPackage.EVENT_GUARD__NAME;

	/**
	 * The feature id for the '<em><b>Triggering Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD__TRIGGERING_EVENT = TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT;

	/**
	 * The number of structural features of the '<em>Event Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_GUARD_FEATURE_COUNT = TfsmPackage.EVENT_GUARD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.FSMEventImpl <em>FSM Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.FSMEventImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getFSMEvent()
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
	int FSM_EVENT__NAME = TfsmPackage.FSM_EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT__SOLLICITING_TRANSITIONS = TfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Is Triggered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT__IS_TRIGGERED = TfsmPackage.FSM_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FSM Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_FEATURE_COUNT = TfsmPackage.FSM_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.FSMClockImpl <em>FSM Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.FSMClockImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getFSMClock()
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
	int FSM_CLOCK__NAME = TfsmPackage.FSM_CLOCK__NAME;

	/**
	 * The feature id for the '<em><b>Number Of Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK__NUMBER_OF_TICKS = TfsmPackage.FSM_CLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>FSM Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_FEATURE_COUNT = TfsmPackage.FSM_CLOCK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.TimedSystemImpl <em>Timed System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.TimedSystemImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getTimedSystem()
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
	int TIMED_SYSTEM__NAME = TfsmPackage.TIMED_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Tfsms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM__TFSMS = TfsmPackage.TIMED_SYSTEM__TFSMS;

	/**
	 * The feature id for the '<em><b>Global Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM__GLOBAL_CLOCKS = TfsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS;

	/**
	 * The feature id for the '<em><b>Global Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM__GLOBAL_EVENTS = TfsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS;

	/**
	 * The number of structural features of the '<em>Timed System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_SYSTEM_FEATURE_COUNT = TfsmPackage.TIMED_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmextended.tfsmextended.impl.EvaluateGuardImpl <em>Evaluate Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmextended.tfsmextended.impl.EvaluateGuardImpl
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getEvaluateGuard()
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
	int EVALUATE_GUARD__NAME = TfsmPackage.EVALUATE_GUARD__NAME;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATE_GUARD__CONDITION = TfsmPackage.EVALUATE_GUARD__CONDITION;

	/**
	 * The number of structural features of the '<em>Evaluate Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATE_GUARD_FEATURE_COUNT = TfsmPackage.EVALUATE_GUARD_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '<em>Integer</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Integer
	 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getInteger()
	 * @generated
	 */
	int INTEGER = 11;


	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.TFSM <em>TFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFSM</em>'.
	 * @see tfsmextended.tfsmextended.TFSM
	 * @generated
	 */
	EClass getTFSM();

	/**
	 * Returns the meta object for the reference '{@link tfsmextended.tfsmextended.TFSM#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current State</em>'.
	 * @see tfsmextended.tfsmextended.TFSM#getCurrentState()
	 * @see #getTFSM()
	 * @generated
	 */
	EReference getTFSM_CurrentState();

	/**
	 * Returns the meta object for the attribute '{@link tfsmextended.tfsmextended.TFSM#getStepNumber <em>Step Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Number</em>'.
	 * @see tfsmextended.tfsmextended.TFSM#getStepNumber()
	 * @see #getTFSM()
	 * @generated
	 */
	EAttribute getTFSM_StepNumber();

	/**
	 * Returns the meta object for the attribute '{@link tfsmextended.tfsmextended.TFSM#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last State Change Step Number</em>'.
	 * @see tfsmextended.tfsmextended.TFSM#getLastStateChangeStepNumber()
	 * @see #getTFSM()
	 * @generated
	 */
	EAttribute getTFSM_LastStateChangeStepNumber();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see tfsmextended.tfsmextended.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see tfsmextended.tfsmextended.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see tfsmextended.tfsmextended.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see tfsmextended.tfsmextended.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.TemporalGuard <em>Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporal Guard</em>'.
	 * @see tfsmextended.tfsmextended.TemporalGuard
	 * @generated
	 */
	EClass getTemporalGuard();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.EventGuard <em>Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Guard</em>'.
	 * @see tfsmextended.tfsmextended.EventGuard
	 * @generated
	 */
	EClass getEventGuard();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.FSMEvent <em>FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Event</em>'.
	 * @see tfsmextended.tfsmextended.FSMEvent
	 * @generated
	 */
	EClass getFSMEvent();

	/**
	 * Returns the meta object for the attribute '{@link tfsmextended.tfsmextended.FSMEvent#isIsTriggered <em>Is Triggered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Triggered</em>'.
	 * @see tfsmextended.tfsmextended.FSMEvent#isIsTriggered()
	 * @see #getFSMEvent()
	 * @generated
	 */
	EAttribute getFSMEvent_IsTriggered();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.FSMClock <em>FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Clock</em>'.
	 * @see tfsmextended.tfsmextended.FSMClock
	 * @generated
	 */
	EClass getFSMClock();

	/**
	 * Returns the meta object for the attribute '{@link tfsmextended.tfsmextended.FSMClock#getNumberOfTicks <em>Number Of Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Ticks</em>'.
	 * @see tfsmextended.tfsmextended.FSMClock#getNumberOfTicks()
	 * @see #getFSMClock()
	 * @generated
	 */
	EAttribute getFSMClock_NumberOfTicks();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.TimedSystem <em>Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed System</em>'.
	 * @see tfsmextended.tfsmextended.TimedSystem
	 * @generated
	 */
	EClass getTimedSystem();

	/**
	 * Returns the meta object for class '{@link tfsmextended.tfsmextended.EvaluateGuard <em>Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluate Guard</em>'.
	 * @see tfsmextended.tfsmextended.EvaluateGuard
	 * @generated
	 */
	EClass getEvaluateGuard();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer"
	 * @generated
	 */
	EDataType getInteger();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TfsmextendedFactory getTfsmextendedFactory();

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
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.TFSMImpl <em>TFSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.TFSMImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getTFSM()
		 * @generated
		 */
		EClass TFSM = eINSTANCE.getTFSM();

		/**
		 * The meta object literal for the '<em><b>Current State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM__CURRENT_STATE = eINSTANCE.getTFSM_CurrentState();

		/**
		 * The meta object literal for the '<em><b>Step Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFSM__STEP_NUMBER = eINSTANCE.getTFSM_StepNumber();

		/**
		 * The meta object literal for the '<em><b>Last State Change Step Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFSM__LAST_STATE_CHANGE_STEP_NUMBER = eINSTANCE.getTFSM_LastStateChangeStepNumber();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.StateImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.TransitionImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.NamedElementImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.GuardImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.TemporalGuardImpl <em>Temporal Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.TemporalGuardImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getTemporalGuard()
		 * @generated
		 */
		EClass TEMPORAL_GUARD = eINSTANCE.getTemporalGuard();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.EventGuardImpl <em>Event Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.EventGuardImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getEventGuard()
		 * @generated
		 */
		EClass EVENT_GUARD = eINSTANCE.getEventGuard();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.FSMEventImpl <em>FSM Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.FSMEventImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getFSMEvent()
		 * @generated
		 */
		EClass FSM_EVENT = eINSTANCE.getFSMEvent();

		/**
		 * The meta object literal for the '<em><b>Is Triggered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_EVENT__IS_TRIGGERED = eINSTANCE.getFSMEvent_IsTriggered();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.FSMClockImpl <em>FSM Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.FSMClockImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getFSMClock()
		 * @generated
		 */
		EClass FSM_CLOCK = eINSTANCE.getFSMClock();

		/**
		 * The meta object literal for the '<em><b>Number Of Ticks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_CLOCK__NUMBER_OF_TICKS = eINSTANCE.getFSMClock_NumberOfTicks();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.TimedSystemImpl <em>Timed System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.TimedSystemImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getTimedSystem()
		 * @generated
		 */
		EClass TIMED_SYSTEM = eINSTANCE.getTimedSystem();

		/**
		 * The meta object literal for the '{@link tfsmextended.tfsmextended.impl.EvaluateGuardImpl <em>Evaluate Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmextended.tfsmextended.impl.EvaluateGuardImpl
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getEvaluateGuard()
		 * @generated
		 */
		EClass EVALUATE_GUARD = eINSTANCE.getEvaluateGuard();

		/**
		 * The meta object literal for the '<em>Integer</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Integer
		 * @see tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl#getInteger()
		 * @generated
		 */
		EDataType INTEGER = eINSTANCE.getInteger();

	}

} //TfsmextendedPackage
