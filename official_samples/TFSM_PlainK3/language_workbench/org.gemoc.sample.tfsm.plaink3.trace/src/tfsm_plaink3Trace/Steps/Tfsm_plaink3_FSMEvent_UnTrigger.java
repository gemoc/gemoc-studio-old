/**
 */
package tfsm_plaink3Trace.Steps;

import org.gemoc.sample.tfsm_plaink3.FSMEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm plaink3 FSM Event Un Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsm_plaink3Trace.Steps.StepsPackage#getTfsm_plaink3_FSMEvent_UnTrigger()
 * @model
 * @generated
 */
public interface Tfsm_plaink3_FSMEvent_UnTrigger extends SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (FSMEvent) this.getMse().getCaller();\n'"
	 * @generated
	 */
	FSMEvent getCaller();

} // Tfsm_plaink3_FSMEvent_UnTrigger
