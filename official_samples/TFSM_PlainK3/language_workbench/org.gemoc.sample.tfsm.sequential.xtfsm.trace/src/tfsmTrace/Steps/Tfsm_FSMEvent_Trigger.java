/**
 */
package tfsmTrace.Steps;

import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;

import tfsmTrace.States.tfsm.TracedFSMEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm FSM Event Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmTrace.Steps.StepsPackage#getTfsm_FSMEvent_Trigger()
 * @model
 * @generated
 */
public interface Tfsm_FSMEvent_Trigger extends SpecificStep, SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (tfsmTrace.States.tfsm.TracedFSMEvent) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedFSMEvent getCaller();

} // Tfsm_FSMEvent_Trigger
