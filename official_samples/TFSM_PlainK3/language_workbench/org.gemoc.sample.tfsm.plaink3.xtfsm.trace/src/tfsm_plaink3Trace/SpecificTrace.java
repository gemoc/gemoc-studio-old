/**
 */
package tfsm_plaink3Trace;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.Trace;

import org.eclipse.emf.common.util.EList;

import tfsm_plaink3Trace.States.State;

import tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedState;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition;

import tfsm_plaink3Trace.Steps.SpecificStep;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMClock_Ticks_Sequence <em>Tfsm plaink3 FSM Clock Ticks Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMEvent_Trigger_Sequence <em>Tfsm plaink3 FSM Event Trigger Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_FSMEvent_UnTrigger_Sequence <em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_State_Visit_Sequence <em>Tfsm plaink3 State Visit Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_TFSM_Init_Sequence <em>Tfsm plaink3 TFSM Init Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_Transition_Fire_Sequence <em>Tfsm plaink3 Transition Fire Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_Transition_Visit_Sequence <em>Tfsm plaink3 Transition Visit Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getStatesTrace <em>States Trace</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedEvaluateGuards <em>Tfsm plaink3 traced Evaluate Guards</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedEventGuards <em>Tfsm plaink3 traced Event Guards</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedFSMClocks <em>Tfsm plaink3 traced FSM Clocks</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedFSMEvents <em>Tfsm plaink3 traced FSM Events</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedStates <em>Tfsm plaink3 traced States</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTFSMs <em>Tfsm plaink3 traced TFS Ms</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTemporalGuards <em>Tfsm plaink3 traced Temporal Guards</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTimedSystems <em>Tfsm plaink3 traced Timed Systems</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.SpecificTrace#getTfsm_plaink3_tracedTransitions <em>Tfsm plaink3 traced Transitions</em>}</li>
 * </ul>
 *
 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace()
 * @model
 * @generated
 */
public interface SpecificTrace extends Trace<SequentialStep<SpecificStep>> {
	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 FSM Clock Ticks Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 FSM Clock Ticks Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 FSM Clock Ticks Sequence</em>' reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_plaink3_FSMClock_Ticks> getTfsm_plaink3_FSMClock_Ticks_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 FSM Event Trigger Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 FSM Event Trigger Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 FSM Event Trigger Sequence</em>' reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_plaink3_FSMEvent_Trigger> getTfsm_plaink3_FSMEvent_Trigger_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 FSM Event Un Trigger Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>' reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_plaink3_FSMEvent_UnTrigger> getTfsm_plaink3_FSMEvent_UnTrigger_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 State Visit Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 State Visit Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 State Visit Sequence</em>' reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_State_Visit_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_plaink3_State_Visit> getTfsm_plaink3_State_Visit_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 TFSM Init Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 TFSM Init Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 TFSM Init Sequence</em>' reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_TFSM_Init_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_plaink3_TFSM_Init> getTfsm_plaink3_TFSM_Init_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 Transition Fire Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 Transition Fire Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 Transition Fire Sequence</em>' reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_Transition_Fire_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_plaink3_Transition_Fire> getTfsm_plaink3_Transition_Fire_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 Transition Visit Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 Transition Visit Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 Transition Visit Sequence</em>' reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_Transition_Visit_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_plaink3_Transition_Visit> getTfsm_plaink3_Transition_Visit_Sequence();

	/**
	 * Returns the value of the '<em><b>States Trace</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States Trace</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States Trace</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_StatesTrace()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStatesTrace();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced Evaluate Guards</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced Evaluate Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced Evaluate Guards</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedEvaluateGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedEvaluateGuard> getTfsm_plaink3_tracedEvaluateGuards();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced Event Guards</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced Event Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced Event Guards</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedEventGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedEventGuard> getTfsm_plaink3_tracedEventGuards();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced FSM Clocks</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced FSM Clocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced FSM Clocks</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedFSMClocks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedFSMClock> getTfsm_plaink3_tracedFSMClocks();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced FSM Events</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced FSM Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced FSM Events</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedFSMEvents()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedFSMEvent> getTfsm_plaink3_tracedFSMEvents();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced States</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced States</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedStates()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedState> getTfsm_plaink3_tracedStates();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced TFS Ms</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced TFS Ms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced TFS Ms</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedTFSMs()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTFSM> getTfsm_plaink3_tracedTFSMs();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced Temporal Guards</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced Temporal Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced Temporal Guards</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedTemporalGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTemporalGuard> getTfsm_plaink3_tracedTemporalGuards();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced Timed Systems</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced Timed Systems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced Timed Systems</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedTimedSystems()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTimedSystem> getTfsm_plaink3_tracedTimedSystems();

	/**
	 * Returns the value of the '<em><b>Tfsm plaink3 traced Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm plaink3 traced Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm plaink3 traced Transitions</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getSpecificTrace_Tfsm_plaink3_tracedTransitions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTransition> getTfsm_plaink3_tracedTransitions();

} // SpecificTrace
