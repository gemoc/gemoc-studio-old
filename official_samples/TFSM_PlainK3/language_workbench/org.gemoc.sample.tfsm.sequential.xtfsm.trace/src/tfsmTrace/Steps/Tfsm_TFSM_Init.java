/**
 */
package tfsmTrace.Steps;

import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;

import tfsmTrace.States.tfsm.TracedTFSM;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm TFSM Init</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmTrace.Steps.StepsPackage#getTfsm_TFSM_Init()
 * @model
 * @generated
 */
public interface Tfsm_TFSM_Init extends SpecificStep, SmallStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (tfsmTrace.States.tfsm.TracedTFSM) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedTFSM getCaller();

} // Tfsm_TFSM_Init
