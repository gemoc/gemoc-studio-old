/**
 */
package tfsm_plaink3Trace.Steps;

import org.eclipse.emf.common.util.EList;

import org.gemoc.sample.tfsm_plaink3.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm plaink3 Transition Visit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit#getSubSteps <em>Sub Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm_plaink3Trace.Steps.StepsPackage#getTfsm_plaink3_Transition_Visit()
 * @model
 * @generated
 */
public interface Tfsm_plaink3_Transition_Visit extends BigStep, Tfsm_plaink3_State_Visit_AbstractSubStep {
	/**
	 * Returns the value of the '<em><b>Sub Steps</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Steps</em>' containment reference list.
	 * @see tfsm_plaink3Trace.Steps.StepsPackage#getTfsm_plaink3_Transition_Visit_SubSteps()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tfsm_plaink3_Transition_Visit_AbstractSubStep> getSubSteps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (Transition) this.getMse().getCaller();\r\n'"
	 * @generated
	 */
	Transition getCaller();

} // Tfsm_plaink3_Transition_Visit
