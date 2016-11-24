/**
 */
package tfsmTrace.Steps;

import fr.inria.diverse.trace.commons.model.trace.SmallStep;

import tfsmTrace.States.tfsm.TracedTimeFSM;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm Time FSM Init</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmTrace.Steps.StepsPackage#getTfsm_TimeFSM_Init()
 * @model
 * @generated
 */
public interface Tfsm_TimeFSM_Init extends SpecificStep, SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (tfsmTrace.States.tfsm.TracedTimeFSM) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedTimeFSM getCaller();

} // Tfsm_TimeFSM_Init
