/**
 */
package tfsmTrace.Steps;

import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;

import tfsmTrace.States.tfsm.TracedFSMClock;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm FSM Clock Ticks</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmTrace.Steps.StepsPackage#getTfsm_FSMClock_Ticks()
 * @model
 * @generated
 */
public interface Tfsm_FSMClock_Ticks extends SpecificStep, SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (tfsmTrace.States.tfsm.TracedFSMClock) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedFSMClock getCaller();

} // Tfsm_FSMClock_Ticks
