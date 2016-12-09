/**
 */
package fsmTrace.Steps;

import fr.inria.diverse.trace.commons.model.trace.SmallStep;

import fsmTrace.States.fsm.TracedFSMClock;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fsm FSM Clock Ticks</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fsmTrace.Steps.StepsPackage#getFsm_FSMClock_Ticks()
 * @model
 * @generated
 */
public interface Fsm_FSMClock_Ticks extends SpecificStep, SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (fsmTrace.States.fsm.TracedFSMClock) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedFSMClock getCaller();

} // Fsm_FSMClock_Ticks
