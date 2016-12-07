/**
 */
package fsmTrace.Steps;

import fr.inria.diverse.trace.commons.model.trace.SmallStep;

import fsmTrace.States.fsm.TracedFSMEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fsm FSM Event Un Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fsmTrace.Steps.StepsPackage#getFsm_FSMEvent_UnTrigger()
 * @model
 * @generated
 */
public interface Fsm_FSMEvent_UnTrigger extends SpecificStep, SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (fsmTrace.States.fsm.TracedFSMEvent) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedFSMEvent getCaller();

} // Fsm_FSMEvent_UnTrigger
