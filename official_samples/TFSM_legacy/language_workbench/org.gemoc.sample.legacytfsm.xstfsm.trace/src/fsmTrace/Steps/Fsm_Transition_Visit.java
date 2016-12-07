/**
 */
package fsmTrace.Steps;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;

import fsmTrace.States.fsm.TracedTransition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fsm Transition Visit</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fsmTrace.Steps.StepsPackage#getFsm_Transition_Visit()
 * @model
 * @generated
 */
public interface Fsm_Transition_Visit extends Fsm_State_Visit_AbstractSubStep, SpecificStep, SequentialStep<Fsm_Transition_Visit_AbstractSubStep> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (fsmTrace.States.fsm.TracedTransition) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedTransition getCaller();

} // Fsm_Transition_Visit
