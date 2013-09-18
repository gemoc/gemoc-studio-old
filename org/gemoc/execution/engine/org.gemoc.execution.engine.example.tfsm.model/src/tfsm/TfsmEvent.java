/**
 */
package tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm.TfsmEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm.TfsmPackage#getTfsmEvent()
 * @model
 * @generated
 */
public interface TfsmEvent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Solliciting Transitions</b></em>' reference list.
	 * The list contents are of type {@link tfsm.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solliciting Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solliciting Transitions</em>' reference list.
	 * @see tfsm.TfsmPackage#getTfsmEvent_SollicitingTransitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getSollicitingTransitions();

} // TfsmEvent
