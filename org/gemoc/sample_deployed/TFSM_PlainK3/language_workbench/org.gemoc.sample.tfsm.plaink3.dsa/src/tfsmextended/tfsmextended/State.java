/**
 */
package tfsmextended.tfsmextended;

import org.gemoc.sample.tfsm.plaink3.dsa.IVisitor;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmextended.tfsmextended.TfsmextendedPackage#getState()
 * @model
 * @generated
 */
public interface State extends org.gemoc.sample.tfsm.State {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String onEnter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String onLeave();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="tfsmextended.tfsmextended.IVisitor"
	 * @generated
	 */
	void accept(IVisitor visitor);
} // State
