/**
 */
package tfsmTrace.Steps;

import org.eclipse.gemoc.trace.commons.model.trace.SequentialStep;

import tfsmTrace.States.tfsm.TracedState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tfsm State Visit</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmTrace.Steps.StepsPackage#getTfsm_State_Visit()
 * @model
 * @generated
 */
public interface Tfsm_State_Visit extends SpecificStep, SequentialStep<Tfsm_State_Visit_AbstractSubStep> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (tfsmTrace.States.tfsm.TracedState) this.getMseoccurrence().getMse().getCaller();'"
	 * @generated
	 */
	TracedState getCaller();

} // Tfsm_State_Visit
