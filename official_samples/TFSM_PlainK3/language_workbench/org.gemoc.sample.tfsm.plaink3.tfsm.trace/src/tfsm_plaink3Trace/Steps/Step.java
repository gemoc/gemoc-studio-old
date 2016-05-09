/**
 */
package tfsm_plaink3Trace.Steps;

import org.gemoc.executionframework.engine.mse.MSEOccurrence;

import tfsm_plaink3Trace.States.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.Steps.Step#getEndingState <em>Ending State</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Steps.Step#getStartingState <em>Starting State</em>}</li>
 * </ul>
 *
 * @see tfsm_plaink3Trace.Steps.StepsPackage#getStep()
 * @model abstract="true"
 * @generated
 */
public interface Step extends MSEOccurrence {
	/**
	 * Returns the value of the '<em><b>Ending State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.State#getEndedSteps <em>Ended Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ending State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ending State</em>' reference.
	 * @see #setEndingState(State)
	 * @see tfsm_plaink3Trace.Steps.StepsPackage#getStep_EndingState()
	 * @see tfsm_plaink3Trace.States.State#getEndedSteps
	 * @model opposite="endedSteps"
	 * @generated
	 */
	State getEndingState();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.Steps.Step#getEndingState <em>Ending State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ending State</em>' reference.
	 * @see #getEndingState()
	 * @generated
	 */
	void setEndingState(State value);

	/**
	 * Returns the value of the '<em><b>Starting State</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link tfsm_plaink3Trace.States.State#getStartedSteps <em>Started Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starting State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starting State</em>' reference.
	 * @see #setStartingState(State)
	 * @see tfsm_plaink3Trace.Steps.StepsPackage#getStep_StartingState()
	 * @see tfsm_plaink3Trace.States.State#getStartedSteps
	 * @model opposite="startedSteps" required="true"
	 * @generated
	 */
	State getStartingState();

	/**
	 * Sets the value of the '{@link tfsm_plaink3Trace.Steps.Step#getStartingState <em>Starting State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starting State</em>' reference.
	 * @see #getStartingState()
	 * @generated
	 */
	void setStartingState(State value);

} // Step
