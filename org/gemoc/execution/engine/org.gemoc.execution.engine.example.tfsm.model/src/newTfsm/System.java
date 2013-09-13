/**
 */
package newTfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link newTfsm.System#getTfsms <em>Tfsms</em>}</li>
 *   <li>{@link newTfsm.System#getGlobalClocks <em>Global Clocks</em>}</li>
 *   <li>{@link newTfsm.System#getGlobalEvents <em>Global Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see newTfsm.NewTfsmPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends NamedElement {
    /**
     * Returns the value of the '<em><b>Tfsms</b></em>' containment reference list.
     * The list contents are of type {@link newTfsm.TFSM}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tfsms</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tfsms</em>' containment reference list.
     * @see newTfsm.NewTfsmPackage#getSystem_Tfsms()
     * @model containment="true"
     * @generated
     */
    EList<TFSM> getTfsms();

    /**
     * Returns the value of the '<em><b>Global Clocks</b></em>' containment reference list.
     * The list contents are of type {@link newTfsm.FSMClock}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Global Clocks</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Global Clocks</em>' containment reference list.
     * @see newTfsm.NewTfsmPackage#getSystem_GlobalClocks()
     * @model containment="true"
     * @generated
     */
    EList<FSMClock> getGlobalClocks();

    /**
     * Returns the value of the '<em><b>Global Events</b></em>' containment reference list.
     * The list contents are of type {@link newTfsm.FSMEvent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Global Events</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Global Events</em>' containment reference list.
     * @see newTfsm.NewTfsmPackage#getSystem_GlobalEvents()
     * @model containment="true"
     * @generated
     */
    EList<FSMEvent> getGlobalEvents();

} // System
