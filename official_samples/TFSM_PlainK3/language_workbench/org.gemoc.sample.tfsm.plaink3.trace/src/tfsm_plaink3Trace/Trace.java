/**
 */
package tfsm_plaink3Trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tfsm_plaink3Trace.States.State;

import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM;

import tfsm_plaink3Trace.Steps.Step;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMClock_Ticks_Sequence <em>Tfsm plaink3 FSM Clock Ticks Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMEvent_Trigger_Sequence <em>Tfsm plaink3 FSM Event Trigger Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_FSMEvent_UnTrigger_Sequence <em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_State_Visit_Sequence <em>Tfsm plaink3 State Visit Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_TFSM_Init_Sequence <em>Tfsm plaink3 TFSM Init Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_Transition_Fire_Sequence <em>Tfsm plaink3 Transition Fire Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_Transition_Visit_Sequence <em>Tfsm plaink3 Transition Visit Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getRootSteps <em>Root Steps</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getStatesTrace <em>States Trace</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedFSMClocks <em>Tfsm plaink3 traced FSM Clocks</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedFSMEvents <em>Tfsm plaink3 traced FSM Events</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Trace#getTfsm_plaink3_tracedTFSMs <em>Tfsm plaink3 traced TFS Ms</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject {
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_FSMClock_Ticks_Sequence()
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_FSMEvent_Trigger_Sequence()
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_FSMEvent_UnTrigger_Sequence()
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_State_Visit_Sequence()
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_TFSM_Init_Sequence()
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_Transition_Fire_Sequence()
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_Transition_Visit_Sequence()
	 * @model
	 * @generated
	 */
	EList<Tfsm_plaink3_Transition_Visit> getTfsm_plaink3_Transition_Visit_Sequence();

	/**
	 * Returns the value of the '<em><b>Root Steps</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Step}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Steps</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_RootSteps()
	 * @model containment="true"
	 * @generated
	 */
	EList<Step> getRootSteps();

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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_StatesTrace()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStatesTrace();

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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_tracedFSMClocks()
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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_tracedFSMEvents()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedFSMEvent> getTfsm_plaink3_tracedFSMEvents();

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
	 * @see tfsm_plaink3Trace.Tfsm_plaink3TracePackage#getTrace_Tfsm_plaink3_tracedTFSMs()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<TracedTFSM> getTfsm_plaink3_tracedTFSMs();

} // Trace
