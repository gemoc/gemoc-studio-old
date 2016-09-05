/**
 */
package tfsm_plaink3Trace.States;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tfsm_plaink3Trace.Steps.SpecificStep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.State#getEndedSteps <em>Ended Steps</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.State#getFSMClock_numberOfTicks_Values <em>FSM Clock number Of Ticks Values</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.State#getFSMEvent_isTriggered_Values <em>FSM Event is Triggered Values</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.State#getStartedSteps <em>Started Steps</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.State#getTFSM_currentState_Values <em>TFSM current State Values</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.State#getTFSM_lastStateChangeStepNumber_Values <em>TFSM last State Change Step Number Values</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.State#getTFSM_stepNumber_Values <em>TFSM step Number Values</em>}</li>
 * </ul>
 *
 * @see tfsm_plaink3Trace.States.StatesPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Ended Steps</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.SpecificStep}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.Steps.SpecificStep#getEndingState <em>Ending State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ended Steps</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ended Steps</em>' reference list.
	 * @see tfsm_plaink3Trace.States.StatesPackage#getState_EndedSteps()
	 * @see tfsm_plaink3Trace.Steps.SpecificStep#getEndingState
	 * @model opposite="endingState"
	 * @generated
	 */
	EList<SpecificStep> getEndedSteps();

	/**
	 * Returns the value of the '<em><b>FSM Clock number Of Ticks Values</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FSM Clock number Of Ticks Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FSM Clock number Of Ticks Values</em>' reference list.
	 * @see tfsm_plaink3Trace.States.StatesPackage#getState_FSMClock_numberOfTicks_Values()
	 * @see tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<FSMClock_numberOfTicks_Value> getFSMClock_numberOfTicks_Values();

	/**
	 * Returns the value of the '<em><b>FSM Event is Triggered Values</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FSM Event is Triggered Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FSM Event is Triggered Values</em>' reference list.
	 * @see tfsm_plaink3Trace.States.StatesPackage#getState_FSMEvent_isTriggered_Values()
	 * @see tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<FSMEvent_isTriggered_Value> getFSMEvent_isTriggered_Values();

	/**
	 * Returns the value of the '<em><b>Started Steps</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.SpecificStep}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.Steps.SpecificStep#getStartingState <em>Starting State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Started Steps</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Started Steps</em>' reference list.
	 * @see tfsm_plaink3Trace.States.StatesPackage#getState_StartedSteps()
	 * @see tfsm_plaink3Trace.Steps.SpecificStep#getStartingState
	 * @model opposite="startingState"
	 * @generated
	 */
	EList<SpecificStep> getStartedSteps();

	/**
	 * Returns the value of the '<em><b>TFSM current State Values</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.TFSM_currentState_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TFSM current State Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TFSM current State Values</em>' reference list.
	 * @see tfsm_plaink3Trace.States.StatesPackage#getState_TFSM_currentState_Values()
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<TFSM_currentState_Value> getTFSM_currentState_Values();

	/**
	 * Returns the value of the '<em><b>TFSM last State Change Step Number Values</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TFSM last State Change Step Number Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TFSM last State Change Step Number Values</em>' reference list.
	 * @see tfsm_plaink3Trace.States.StatesPackage#getState_TFSM_lastStateChangeStepNumber_Values()
	 * @see tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<TFSM_lastStateChangeStepNumber_Value> getTFSM_lastStateChangeStepNumber_Values();

	/**
	 * Returns the value of the '<em><b>TFSM step Number Values</b></em>' reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.States.TFSM_stepNumber_Value}.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>TFSM step Number Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>TFSM step Number Values</em>' reference list.
	 * @see tfsm_plaink3Trace.States.StatesPackage#getState_TFSM_stepNumber_Values()
	 * @see tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<TFSM_stepNumber_Value> getTFSM_stepNumber_Values();

} // State
