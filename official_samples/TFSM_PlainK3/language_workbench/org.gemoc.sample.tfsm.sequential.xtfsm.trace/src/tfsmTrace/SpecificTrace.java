/**
 */
package tfsmTrace;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.Trace;

import org.eclipse.emf.common.util.EList;

import tfsmTrace.States.State;

import tfsmTrace.States.tfsm.TracedEvaluateGuard;
import tfsmTrace.States.tfsm.TracedEventGuard;
import tfsmTrace.States.tfsm.TracedFSMClock;
import tfsmTrace.States.tfsm.TracedFSMEvent;
import tfsmTrace.States.tfsm.TracedState;
import tfsmTrace.States.tfsm.TracedTFSM;
import tfsmTrace.States.tfsm.TracedTemporalGuard;
import tfsmTrace.States.tfsm.TracedTimedSystem;
import tfsmTrace.States.tfsm.TracedTransition;

import tfsmTrace.Steps.SpecificStep;
import tfsmTrace.Steps.Tfsm_FSMClock_Ticks;
import tfsmTrace.Steps.Tfsm_FSMEvent_Trigger;
import tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger;
import tfsmTrace.Steps.Tfsm_State_Visit;
import tfsmTrace.Steps.Tfsm_TFSM_Init;
import tfsmTrace.Steps.Tfsm_Transition_Fire;
import tfsmTrace.Steps.Tfsm_Transition_Visit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_FSMClock_Ticks_Sequence <em>Tfsm FSM Clock Ticks Sequence</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_FSMEvent_Trigger_Sequence <em>Tfsm FSM Event Trigger Sequence</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_FSMEvent_UnTrigger_Sequence <em>Tfsm FSM Event Un Trigger Sequence</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_State_Visit_Sequence <em>Tfsm State Visit Sequence</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_TFSM_Init_Sequence <em>Tfsm TFSM Init Sequence</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_Transition_Fire_Sequence <em>Tfsm Transition Fire Sequence</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_Transition_Visit_Sequence <em>Tfsm Transition Visit Sequence</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getStatesTrace <em>States Trace</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedEvaluateGuards <em>Tfsm traced Evaluate Guards</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedEventGuards <em>Tfsm traced Event Guards</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedFSMClocks <em>Tfsm traced FSM Clocks</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedFSMEvents <em>Tfsm traced FSM Events</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedStates <em>Tfsm traced States</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedTFSMs <em>Tfsm traced TFS Ms</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedTemporalGuards <em>Tfsm traced Temporal Guards</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedTimedSystems <em>Tfsm traced Timed Systems</em>}</li>
 *   <li>{@link tfsmTrace.SpecificTrace#getTfsm_tracedTransitions <em>Tfsm traced Transitions</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace()
 * @model
 * @generated
 */
public interface SpecificTrace extends Trace<SequentialStep<SpecificStep>> {
	/**
	 * Returns the value of the '<em><b>Tfsm FSM Clock Ticks Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.Steps.Tfsm_FSMClock_Ticks}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm FSM Clock Ticks Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm FSM Clock Ticks Sequence</em>' reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_FSMClock_Ticks_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_FSMClock_Ticks> getTfsm_FSMClock_Ticks_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm FSM Event Trigger Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.Steps.Tfsm_FSMEvent_Trigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm FSM Event Trigger Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm FSM Event Trigger Sequence</em>' reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_FSMEvent_Trigger_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_FSMEvent_Trigger> getTfsm_FSMEvent_Trigger_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm FSM Event Un Trigger Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm FSM Event Un Trigger Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm FSM Event Un Trigger Sequence</em>' reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_FSMEvent_UnTrigger_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_FSMEvent_UnTrigger> getTfsm_FSMEvent_UnTrigger_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm State Visit Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.Steps.Tfsm_State_Visit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm State Visit Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm State Visit Sequence</em>' reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_State_Visit_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_State_Visit> getTfsm_State_Visit_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm TFSM Init Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.Steps.Tfsm_TFSM_Init}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm TFSM Init Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm TFSM Init Sequence</em>' reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_TFSM_Init_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_TFSM_Init> getTfsm_TFSM_Init_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm Transition Fire Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.Steps.Tfsm_Transition_Fire}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm Transition Fire Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm Transition Fire Sequence</em>' reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_Transition_Fire_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_Transition_Fire> getTfsm_Transition_Fire_Sequence();

	/**
	 * Returns the value of the '<em><b>Tfsm Transition Visit Sequence</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.Steps.Tfsm_Transition_Visit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm Transition Visit Sequence</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm Transition Visit Sequence</em>' reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_Transition_Visit_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_Transition_Visit> getTfsm_Transition_Visit_Sequence();

	/**
	 * Returns the value of the '<em><b>States Trace</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States Trace</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States Trace</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_StatesTrace()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStatesTrace();

	/**
	 * Returns the value of the '<em><b>Tfsm traced Evaluate Guards</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedEvaluateGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced Evaluate Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced Evaluate Guards</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedEvaluateGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedEvaluateGuard> getTfsm_tracedEvaluateGuards();

	/**
	 * Returns the value of the '<em><b>Tfsm traced Event Guards</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedEventGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced Event Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced Event Guards</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedEventGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedEventGuard> getTfsm_tracedEventGuards();

	/**
	 * Returns the value of the '<em><b>Tfsm traced FSM Clocks</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedFSMClock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced FSM Clocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced FSM Clocks</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedFSMClocks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedFSMClock> getTfsm_tracedFSMClocks();

	/**
	 * Returns the value of the '<em><b>Tfsm traced FSM Events</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedFSMEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced FSM Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced FSM Events</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedFSMEvents()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedFSMEvent> getTfsm_tracedFSMEvents();

	/**
	 * Returns the value of the '<em><b>Tfsm traced States</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced States</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedStates()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedState> getTfsm_tracedStates();

	/**
	 * Returns the value of the '<em><b>Tfsm traced TFS Ms</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedTFSM}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced TFS Ms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced TFS Ms</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedTFSMs()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTFSM> getTfsm_tracedTFSMs();

	/**
	 * Returns the value of the '<em><b>Tfsm traced Temporal Guards</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedTemporalGuard}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced Temporal Guards</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced Temporal Guards</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedTemporalGuards()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTemporalGuard> getTfsm_tracedTemporalGuards();

	/**
	 * Returns the value of the '<em><b>Tfsm traced Timed Systems</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedTimedSystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced Timed Systems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced Timed Systems</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedTimedSystems()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTimedSystem> getTfsm_tracedTimedSystems();

	/**
	 * Returns the value of the '<em><b>Tfsm traced Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link tfsmTrace.States.tfsm.TracedTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsm traced Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsm traced Transitions</em>' containment reference list.
	 * @see tfsmTrace.TfsmTracePackage#getSpecificTrace_Tfsm_tracedTransitions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTransition> getTfsm_tracedTransitions();

} // SpecificTrace
