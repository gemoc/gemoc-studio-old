/**
 */
package tfsmextended.tfsmextended;

import org.gemoc.sample.tfsm.plaink3.dsa.IVisitor;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TFSM</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsmextended.tfsmextended.TFSM#getCurrentState <em>Current State</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsmextended.tfsmextended.TfsmextendedPackage#getTFSM()
 * @model
 * @generated
 */
public interface TFSM extends org.gemoc.sample.tfsm.TFSM {

	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(State)
	 * @see tfsmextended.tfsmextended.TfsmextendedPackage#getTFSM_CurrentState()
	 * @model
	 * @generated
	 */
	State getCurrentState();

	/**
	 * Sets the value of the '{@link tfsmextended.tfsmextended.TFSM#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(State value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String Init();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="tfsmextended.tfsmextended.IVisitor"
	 * @generated
	 */
	void accept(IVisitor visitor);
} // TFSM
