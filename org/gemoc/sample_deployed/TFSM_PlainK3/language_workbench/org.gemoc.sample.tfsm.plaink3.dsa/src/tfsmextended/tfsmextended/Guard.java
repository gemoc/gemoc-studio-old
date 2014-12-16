/**
 */
package tfsmextended.tfsmextended;

import org.gemoc.sample.tfsm.plaink3.dsa.IVisitor;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see tfsmextended.tfsmextended.TfsmextendedPackage#getGuard()
 * @model abstract="true"
 * @generated
 */
public interface Guard extends org.gemoc.sample.tfsm.Guard {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="tfsmextended.tfsmextended.IVisitor"
	 * @generated
	 */
	void accept(IVisitor visitor);
} // Guard
