/**
 */
package org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TimedSystem#getTfsms <em>Tfsms</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TimedSystem#getGlobalClocks <em>Global Clocks</em>}</li>
 *   <li>{@link org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TimedSystem#getGlobalEvents <em>Global Events</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage#getTimedSystem()
 * @model
 * @generated
 */
public interface TimedSystem extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Tfsms</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TimedFSM}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tfsms</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tfsms</em>' containment reference list.
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage#getTimedSystem_Tfsms()
	 * @model containment="true"
	 * @generated
	 */
	EList<TimedFSM> getTfsms();

	/**
	 * Returns the value of the '<em><b>Global Clocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.FSMClock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Clocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Clocks</em>' containment reference list.
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage#getTimedSystem_GlobalClocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<FSMClock> getGlobalClocks();

	/**
	 * Returns the value of the '<em><b>Global Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.FSMEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Events</em>' containment reference list.
	 * @see org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage#getTimedSystem_GlobalEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<FSMEvent> getGlobalEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void main();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model argsMany="true"
	 * @generated
	 */
	void initializeModel(EList<String> args);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visit();

} // TimedSystem
