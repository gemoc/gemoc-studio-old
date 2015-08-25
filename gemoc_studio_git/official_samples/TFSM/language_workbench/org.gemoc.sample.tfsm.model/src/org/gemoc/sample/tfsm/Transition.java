/**
 */
package org.gemoc.sample.tfsm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sample.tfsm.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.Transition#getOwnedGuard <em>Owned Guard</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.Transition#getGeneratedEvents <em>Generated Events</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.Transition#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.sample.tfsm.TfsmPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.tfsm.State#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(State)
	 * @see org.gemoc.sample.tfsm.TfsmPackage#getTransition_Source()
	 * @see org.gemoc.sample.tfsm.State#getOutgoingTransitions
	 * @model opposite="outgoingTransitions" required="true"
	 * @generated
	 */
	State getSource();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.tfsm.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(State value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.tfsm.State#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see org.gemoc.sample.tfsm.TfsmPackage#getTransition_Target()
	 * @see org.gemoc.sample.tfsm.State#getIncomingTransitions
	 * @model opposite="incomingTransitions" required="true"
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.tfsm.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

	/**
	 * Returns the value of the '<em><b>Owned Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Guard</em>' containment reference.
	 * @see #setOwnedGuard(Guard)
	 * @see org.gemoc.sample.tfsm.TfsmPackage#getTransition_OwnedGuard()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	Guard getOwnedGuard();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.tfsm.Transition#getOwnedGuard <em>Owned Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Guard</em>' containment reference.
	 * @see #getOwnedGuard()
	 * @generated
	 */
	void setOwnedGuard(Guard value);

	/**
	 * Returns the value of the '<em><b>Generated Events</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.tfsm.FSMEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generated Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generated Events</em>' reference list.
	 * @see org.gemoc.sample.tfsm.TfsmPackage#getTransition_GeneratedEvents()
	 * @model
	 * @generated
	 */
	EList<FSMEvent> getGeneratedEvents();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see #setAction(String)
	 * @see org.gemoc.sample.tfsm.TfsmPackage#getTransition_Action()
	 * @model
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.tfsm.Transition#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String fire();

} // Transition
