/**
 */
package tfsm_plaink3Trace.Steps;

import org.gemoc.sample.tfsm_plaink3.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm plaink3 Transition Fire</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsm_plaink3Trace.Steps.StepsPackage#getTfsm_plaink3_Transition_Fire()
 * @model
 * @generated
 */
public interface Tfsm_plaink3_Transition_Fire extends SmallStep, Tfsm_plaink3_Transition_Visit_AbstractSubStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (Transition) this.getMse().getCaller();\r\n'"
	 * @generated
	 */
	Transition getCaller();

} // Tfsm_plaink3_Transition_Fire
