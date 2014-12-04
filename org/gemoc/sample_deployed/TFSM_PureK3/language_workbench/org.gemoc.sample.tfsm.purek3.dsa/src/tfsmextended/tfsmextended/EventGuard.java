/**
 */
package tfsmextended.tfsmextended;

import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmextended.tfsmextended.TfsmextendedPackage#getEventGuard()
 * @model
 * @generated
 */
public interface EventGuard extends org.gemoc.sample.tfsm.EventGuard, Guard {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="tfsmextended.tfsmextended.IVisitor"
	 * @generated
	 */
	void accept(IVisitor visitor);
} // EventGuard
