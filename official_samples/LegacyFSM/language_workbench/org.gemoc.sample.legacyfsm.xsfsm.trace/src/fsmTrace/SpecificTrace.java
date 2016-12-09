/**
 */
package fsmTrace;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.Trace;

import fsmTrace.States.State;

import fsmTrace.States.fsm.TracedEvaluateGuard;
import fsmTrace.States.fsm.TracedEventGuard;
import fsmTrace.States.fsm.TracedFSMClock;
import fsmTrace.States.fsm.TracedFSMEvent;
import fsmTrace.States.fsm.TracedState;
import fsmTrace.States.fsm.TracedTemporalGuard;
import fsmTrace.States.fsm.TracedTimeFSM;
import fsmTrace.States.fsm.TracedTimedSystem;
import fsmTrace.States.fsm.TracedTransition;

import fsmTrace.Steps.Fsm_FSMClock_Ticks;
import fsmTrace.Steps.Fsm_FSMEvent_Trigger;
import fsmTrace.Steps.Fsm_FSMEvent_UnTrigger;
import fsmTrace.Steps.Fsm_State_Visit;
import fsmTrace.Steps.Fsm_TimeFSM_Init;
import fsmTrace.Steps.Fsm_Transition_Fire;
import fsmTrace.Steps.Fsm_Transition_Visit;
import fsmTrace.Steps.SpecificStep;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_FSMClock_Ticks_Sequence <em>Fsm FSM Clock Ticks Sequence</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_FSMEvent_Trigger_Sequence <em>Fsm FSM Event Trigger Sequence</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_FSMEvent_UnTrigger_Sequence <em>Fsm FSM Event Un Trigger Sequence</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_State_Visit_Sequence <em>Fsm State Visit Sequence</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_TimeFSM_Init_Sequence <em>Fsm Time FSM Init Sequence</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_Transition_Fire_Sequence <em>Fsm Transition Fire Sequence</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_Transition_Visit_Sequence <em>Fsm Transition Visit Sequence</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedEvaluateGuards <em>Fsm traced Evaluate Guards</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedEventGuards <em>Fsm traced Event Guards</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedFSMClocks <em>Fsm traced FSM Clocks</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedFSMEvents <em>Fsm traced FSM Events</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedStates <em>Fsm traced States</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedTemporalGuards <em>Fsm traced Temporal Guards</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedTimeFSMs <em>Fsm traced Time FS Ms</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedTimedSystems <em>Fsm traced Timed Systems</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getFsm_tracedTransitions <em>Fsm traced Transitions</em>}</li>
 *   <li>{@link fsmTrace.SpecificTrace#getStatesTrace <em>States Trace</em>}</li>
 * </ul>
 *
 * @see fsmTrace.FsmTracePackage#getSpecificTrace()
 * @model
 * @generated
 */
public interface SpecificTrace extends Trace<SequentialStep<SpecificStep>> {
	/**
	 * Returns the value of the '<em><b>Fsm FSM Clock Ticks Sequence</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.Fsm_FSMClock_Ticks}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm FSM Clock Ticks Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm FSM Clock Ticks Sequence</em>' reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_FSMClock_Ticks_Sequence()
	 * @model
	 * @generated
	 */
	EList<Fsm_FSMClock_Ticks> getFsm_FSMClock_Ticks_Sequence();

	/**
	 * Returns the value of the '<em><b>Fsm FSM Event Trigger Sequence</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.Fsm_FSMEvent_Trigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm FSM Event Trigger Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm FSM Event Trigger Sequence</em>' reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_FSMEvent_Trigger_Sequence()
	 * @model
	 * @generated
	 */
	EList<Fsm_FSMEvent_Trigger> getFsm_FSMEvent_Trigger_Sequence();

	/**
	 * Returns the value of the '<em><b>Fsm FSM Event Un Trigger Sequence</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.Fsm_FSMEvent_UnTrigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm FSM Event Un Trigger Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm FSM Event Un Trigger Sequence</em>' reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_FSMEvent_UnTrigger_Sequence()
	 * @model
	 * @generated
	 */
	EList<Fsm_FSMEvent_UnTrigger> getFsm_FSMEvent_UnTrigger_Sequence();

	/**
	 * Returns the value of the '<em><b>Fsm State Visit Sequence</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.Fsm_State_Visit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm State Visit Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm State Visit Sequence</em>' reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_State_Visit_Sequence()
	 * @model
	 * @generated
	 */
	EList<Fsm_State_Visit> getFsm_State_Visit_Sequence();

	/**
	 * Returns the value of the '<em><b>Fsm Time FSM Init Sequence</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.Fsm_TimeFSM_Init}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm Time FSM Init Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm Time FSM Init Sequence</em>' reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_TimeFSM_Init_Sequence()
	 * @model
	 * @generated
	 */
	EList<Fsm_TimeFSM_Init> getFsm_TimeFSM_Init_Sequence();

	/**
	 * Returns the value of the '<em><b>Fsm Transition Fire Sequence</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.Fsm_Transition_Fire}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm Transition Fire Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm Transition Fire Sequence</em>' reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_Transition_Fire_Sequence()
	 * @model
	 * @generated
	 */
	EList<Fsm_Transition_Fire> getFsm_Transition_Fire_Sequence();

	/**
	 * Returns the value of the '<em><b>Fsm Transition Visit Sequence</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.Fsm_Transition_Visit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm Transition Visit Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm Transition Visit Sequence</em>' reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_Transition_Visit_Sequence()
	 * @model
	 * @generated
	 */
	EList<Fsm_Transition_Visit> getFsm_Transition_Visit_Sequence();

	/**
	 * Returns the value of the '<em><b>Fsm traced Evaluate Guards</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedEvaluateGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced Evaluate Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced Evaluate Guards</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedEvaluateGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedEvaluateGuard> getFsm_tracedEvaluateGuards();

	/**
	 * Returns the value of the '<em><b>Fsm traced Event Guards</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedEventGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced Event Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced Event Guards</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedEventGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedEventGuard> getFsm_tracedEventGuards();

	/**
	 * Returns the value of the '<em><b>Fsm traced FSM Clocks</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedFSMClock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced FSM Clocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced FSM Clocks</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedFSMClocks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedFSMClock> getFsm_tracedFSMClocks();

	/**
	 * Returns the value of the '<em><b>Fsm traced FSM Events</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedFSMEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced FSM Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced FSM Events</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedFSMEvents()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedFSMEvent> getFsm_tracedFSMEvents();

	/**
	 * Returns the value of the '<em><b>Fsm traced States</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced States</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedStates()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedState> getFsm_tracedStates();

	/**
	 * Returns the value of the '<em><b>Fsm traced Temporal Guards</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedTemporalGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced Temporal Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced Temporal Guards</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedTemporalGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTemporalGuard> getFsm_tracedTemporalGuards();

	/**
	 * Returns the value of the '<em><b>Fsm traced Time FS Ms</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedTimeFSM}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced Time FS Ms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced Time FS Ms</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedTimeFSMs()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTimeFSM> getFsm_tracedTimeFSMs();

	/**
	 * Returns the value of the '<em><b>Fsm traced Timed Systems</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedTimedSystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced Timed Systems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced Timed Systems</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedTimedSystems()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTimedSystem> getFsm_tracedTimedSystems();

	/**
	 * Returns the value of the '<em><b>Fsm traced Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.fsm.TracedTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fsm traced Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fsm traced Transitions</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_Fsm_tracedTransitions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTransition> getFsm_tracedTransitions();

	/**
	 * Returns the value of the '<em><b>States Trace</b></em>' containment reference list.
	 * The list contents are of type {@link fsmTrace.States.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States Trace</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States Trace</em>' containment reference list.
	 * @see fsmTrace.FsmTracePackage#getSpecificTrace_StatesTrace()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStatesTrace();

} // SpecificTrace
