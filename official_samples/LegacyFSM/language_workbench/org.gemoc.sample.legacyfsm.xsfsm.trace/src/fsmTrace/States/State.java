/**
 */
package fsmTrace.States;

import fsmTrace.Steps.SpecificStep;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.State#getEndedSteps <em>Ended Steps</em>}</li>
 *   <li>{@link fsmTrace.States.State#getFSMClock_numberOfTicks_Values <em>FSM Clock number Of Ticks Values</em>}</li>
 *   <li>{@link fsmTrace.States.State#getFSMEvent_isTriggered_Values <em>FSM Event is Triggered Values</em>}</li>
 *   <li>{@link fsmTrace.States.State#getStartedSteps <em>Started Steps</em>}</li>
 *   <li>{@link fsmTrace.States.State#getTimeFSM_currentState_Values <em>Time FSM current State Values</em>}</li>
 *   <li>{@link fsmTrace.States.State#getTimeFSM_lastStateChangeStepNumber_Values <em>Time FSM last State Change Step Number Values</em>}</li>
 *   <li>{@link fsmTrace.States.State#getTimeFSM_stepNumber_Values <em>Time FSM step Number Values</em>}</li>
 * </ul>
 *
 * @see fsmTrace.States.StatesPackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Ended Steps</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.SpecificStep}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.Steps.SpecificStep#getEndingState <em>Ending State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ended Steps</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ended Steps</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getState_EndedSteps()
	 * @see fsmTrace.Steps.SpecificStep#getEndingState
	 * @model opposite="endingState"
	 * @generated
	 */
	EList<SpecificStep> getEndedSteps();

	/**
	 * Returns the value of the '<em><b>FSM Clock number Of Ticks Values</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.States.FSMClock_numberOfTicks_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.FSMClock_numberOfTicks_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FSM Clock number Of Ticks Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FSM Clock number Of Ticks Values</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getState_FSMClock_numberOfTicks_Values()
	 * @see fsmTrace.States.FSMClock_numberOfTicks_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<FSMClock_numberOfTicks_Value> getFSMClock_numberOfTicks_Values();

	/**
	 * Returns the value of the '<em><b>FSM Event is Triggered Values</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.States.FSMEvent_isTriggered_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.FSMEvent_isTriggered_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>FSM Event is Triggered Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>FSM Event is Triggered Values</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getState_FSMEvent_isTriggered_Values()
	 * @see fsmTrace.States.FSMEvent_isTriggered_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<FSMEvent_isTriggered_Value> getFSMEvent_isTriggered_Values();

	/**
	 * Returns the value of the '<em><b>Started Steps</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.Steps.SpecificStep}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.Steps.SpecificStep#getStartingState <em>Starting State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Started Steps</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Started Steps</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getState_StartedSteps()
	 * @see fsmTrace.Steps.SpecificStep#getStartingState
	 * @model opposite="startingState"
	 * @generated
	 */
	EList<SpecificStep> getStartedSteps();

	/**
	 * Returns the value of the '<em><b>Time FSM current State Values</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.States.TimeFSM_currentState_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.TimeFSM_currentState_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time FSM current State Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time FSM current State Values</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getState_TimeFSM_currentState_Values()
	 * @see fsmTrace.States.TimeFSM_currentState_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<TimeFSM_currentState_Value> getTimeFSM_currentState_Values();

	/**
	 * Returns the value of the '<em><b>Time FSM last State Change Step Number Values</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time FSM last State Change Step Number Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time FSM last State Change Step Number Values</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getState_TimeFSM_lastStateChangeStepNumber_Values()
	 * @see fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<TimeFSM_lastStateChangeStepNumber_Value> getTimeFSM_lastStateChangeStepNumber_Values();

	/**
	 * Returns the value of the '<em><b>Time FSM step Number Values</b></em>' reference list.
	 * The list contents are of type {@link fsmTrace.States.TimeFSM_stepNumber_Value}.
	 * It is bidirectional and its opposite is '{@link fsmTrace.States.TimeFSM_stepNumber_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time FSM step Number Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time FSM step Number Values</em>' reference list.
	 * @see fsmTrace.States.StatesPackage#getState_TimeFSM_stepNumber_Values()
	 * @see fsmTrace.States.TimeFSM_stepNumber_Value#getStates
	 * @model opposite="states" ordered="false"
	 * @generated
	 */
	EList<TimeFSM_stepNumber_Value> getTimeFSM_stepNumber_Values();

} // State
