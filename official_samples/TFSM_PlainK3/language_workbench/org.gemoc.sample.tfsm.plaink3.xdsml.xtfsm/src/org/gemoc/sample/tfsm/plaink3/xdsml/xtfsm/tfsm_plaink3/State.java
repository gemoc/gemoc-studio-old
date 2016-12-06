/**
 */
package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State#getOwningFSM <em>Owning FSM</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package#getState()
 * @model
 * @generated
 */
public interface State extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owning FSM</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM#getOwnedStates <em>Owned States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning FSM</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning FSM</em>' container reference.
	 * @see #setOwningFSM(TFSM)
	 * @see org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package#getState_OwningFSM()
	 * @see org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM#getOwnedStates
	 * @model opposite="ownedStates" required="true" transient="false"
	 * @generated
	 */
	TFSM getOwningFSM();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State#getOwningFSM <em>Owning FSM</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning FSM</em>' container reference.
	 * @see #getOwningFSM()
	 * @generated
	 */
	void setOwningFSM(TFSM value);

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package#getState_OutgoingTransitions()
	 * @see org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package#getState_IncomingTransitions()
	 * @see org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Transition> getIncomingTransitions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void onEnter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void onLeave();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void visit();

} // State
