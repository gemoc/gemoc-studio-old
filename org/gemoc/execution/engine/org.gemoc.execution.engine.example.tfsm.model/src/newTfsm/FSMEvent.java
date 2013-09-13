/**
 */
package newTfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link newTfsm.FSMEvent#getSollicitingTransitions <em>Solliciting Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see newTfsm.NewTfsmPackage#getFSMEvent()
 * @model
 * @generated
 */
public interface FSMEvent extends NamedElement {
    /**
     * Returns the value of the '<em><b>Solliciting Transitions</b></em>' reference list.
     * The list contents are of type {@link newTfsm.Transition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Solliciting Transitions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Solliciting Transitions</em>' reference list.
     * @see newTfsm.NewTfsmPackage#getFSMEvent_SollicitingTransitions()
     * @model
     * @generated
     */
    EList<Transition> getSollicitingTransitions();

} // FSMEvent
