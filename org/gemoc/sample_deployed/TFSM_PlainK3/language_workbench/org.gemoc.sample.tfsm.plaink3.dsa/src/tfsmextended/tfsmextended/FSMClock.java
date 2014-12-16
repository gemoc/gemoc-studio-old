/**
 */
package tfsmextended.tfsmextended;

import org.gemoc.sample.tfsm.plaink3.dsa.IVisitor;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Clock</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsmextended.tfsmextended.FSMClock#getNumberOfTicks <em>Number Of Ticks</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsmextended.tfsmextended.TfsmextendedPackage#getFSMClock()
 * @model
 * @generated
 */
public interface FSMClock extends org.gemoc.sample.tfsm.FSMClock {

	/**
	 * Returns the value of the '<em><b>Number Of Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Ticks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Ticks</em>' attribute.
	 * @see #setNumberOfTicks(Integer)
	 * @see tfsmextended.tfsmextended.TfsmextendedPackage#getFSMClock_NumberOfTicks()
	 * @model dataType="tfsmextended.tfsmextended.Integer"
	 * @generated
	 */
	Integer getNumberOfTicks();

	/**
	 * Sets the value of the '{@link tfsmextended.tfsmextended.FSMClock#getNumberOfTicks <em>Number Of Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Ticks</em>' attribute.
	 * @see #getNumberOfTicks()
	 * @generated
	 */
	void setNumberOfTicks(Integer value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="tfsmextended.tfsmextended.Integer"
	 * @generated
	 */
	Integer ticks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model visitorDataType="tfsmextended.tfsmextended.IVisitor"
	 * @generated
	 */
	void accept(IVisitor visitor);
} // FSMClock
