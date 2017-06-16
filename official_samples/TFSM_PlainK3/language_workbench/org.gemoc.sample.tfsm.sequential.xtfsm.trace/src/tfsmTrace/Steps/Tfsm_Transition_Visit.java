/**
 */
package tfsmTrace.Steps;

import org.eclipse.gemoc.trace.commons.model.trace.SequentialStep;

import tfsmTrace.States.tfsm.TracedTransition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm Transition Visit</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmTrace.Steps.StepsPackage#getTfsm_Transition_Visit()
 * @model
 * @generated
 */
public interface Tfsm_Transition_Visit extends SpecificStep, SequentialStep<Tfsm_Transition_Visit_AbstractSubStep>, Tfsm_State_Visit_AbstractSubStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (tfsmTrace.States.tfsm.TracedTransition) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedTransition getCaller();

} // Tfsm_Transition_Visit
