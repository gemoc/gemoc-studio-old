/**
 */
package fsmTrace.Steps;

import fr.inria.diverse.trace.commons.model.trace.SmallStep;

import fsmTrace.States.fsm.TracedTimeFSM;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fsm Time FSM Init</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fsmTrace.Steps.StepsPackage#getFsm_TimeFSM_Init()
 * @model
 * @generated
 */
public interface Fsm_TimeFSM_Init extends SpecificStep, SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (fsmTrace.States.fsm.TracedTimeFSM) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedTimeFSM getCaller();

} // Fsm_TimeFSM_Init
