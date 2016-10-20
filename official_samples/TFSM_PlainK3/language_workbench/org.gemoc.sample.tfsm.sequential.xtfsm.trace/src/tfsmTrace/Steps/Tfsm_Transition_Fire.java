/**
 */
package tfsmTrace.Steps;

import fr.inria.diverse.trace.commons.model.trace.SmallStep;

import tfsmTrace.States.tfsm.TracedTransition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm Transition Fire</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmTrace.Steps.StepsPackage#getTfsm_Transition_Fire()
 * @model
 * @generated
 */
public interface Tfsm_Transition_Fire extends Tfsm_Transition_Visit_AbstractSubStep, SpecificStep, SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (tfsmTrace.States.tfsm.TracedTransition) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedTransition getCaller();

} // Tfsm_Transition_Fire
