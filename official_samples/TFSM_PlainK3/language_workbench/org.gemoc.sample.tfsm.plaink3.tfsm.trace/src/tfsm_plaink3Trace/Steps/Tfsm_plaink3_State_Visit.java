/**
 */
package tfsm_plaink3Trace.Steps;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;

import tfsm_plaink3Trace.States.tfsm_plaink3.TracedState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm plaink3 State Visit</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsm_plaink3Trace.Steps.StepsPackage#getTfsm_plaink3_State_Visit()
 * @model
 * @generated
 */
public interface Tfsm_plaink3_State_Visit extends SpecificStep, SequentialStep<Tfsm_plaink3_State_Visit_AbstractSubStep> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (tfsm_plaink3Trace.States.tfsm_plaink3.TracedState) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedState getCaller();

} // Tfsm_plaink3_State_Visit
