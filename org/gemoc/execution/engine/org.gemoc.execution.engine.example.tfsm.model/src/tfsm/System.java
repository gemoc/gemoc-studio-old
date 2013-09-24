/**
 */
package tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm.System#getTfsms <em>Tfsms</em>}</li>
 *   <li>{@link tfsm.System#getGlobalClocks <em>Global Clocks</em>}</li>
 *   <li>{@link tfsm.System#getGlobalEvents <em>Global Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm.TfsmPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Tfsms</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm.Tfsm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsms</em>' containment reference list.
	 * @see tfsm.TfsmPackage#getSystem_Tfsms()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tfsm> getTfsms();

	/**
	 * Returns the value of the '<em><b>Global Clocks</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm.TfsmClock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Clocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Clocks</em>' containment reference list.
	 * @see tfsm.TfsmPackage#getSystem_GlobalClocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<TfsmClock> getGlobalClocks();

	/**
	 * Returns the value of the '<em><b>Global Events</b></em>' containment reference list.
	 * The list contents are of type {@link tfsm.TfsmEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Events</em>' containment reference list.
	 * @see tfsm.TfsmPackage#getSystem_GlobalEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<TfsmEvent> getGlobalEvents();

} // System
