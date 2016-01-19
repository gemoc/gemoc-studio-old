/**
 */
package tfsm_plaink3Trace.Steps;

import org.gemoc.sample.tfsm_plaink3.FSMClock;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm plaink3 FSM Clock Ticks</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsm_plaink3Trace.Steps.StepsPackage#getTfsm_plaink3_FSMClock_Ticks()
 * @model
 * @generated
 */
public interface Tfsm_plaink3_FSMClock_Ticks extends SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (FSMClock) this.getMse().getCaller();\r\n'"
	 * @generated
	 */
	FSMClock getCaller();

} // Tfsm_plaink3_FSMClock_Ticks
