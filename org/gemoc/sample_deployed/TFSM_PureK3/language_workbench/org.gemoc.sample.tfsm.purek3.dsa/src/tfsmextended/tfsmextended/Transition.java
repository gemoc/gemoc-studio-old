/**
 */
package tfsmextended.tfsmextended;

import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmextended.tfsmextended.TfsmextendedPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends org.gemoc.sample.tfsm.Transition {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String fire();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="tfsmextended.tfsmextended.IVisitor"
	 * @generated
	 */
	void accept(IVisitor visitor);
} // Transition
