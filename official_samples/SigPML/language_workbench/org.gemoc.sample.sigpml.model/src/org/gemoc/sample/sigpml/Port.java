/**
 */
package org.gemoc.sample.sigpml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.Port#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Port#getRate <em>Rate</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Port#getByteRate <em>Byte Rate</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Port#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.sample.sigpml.SigpmlPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.Agent#getOwnedPorts <em>Owned Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Agent)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getPort_Owner()
	 * @see org.gemoc.sample.sigpml.Agent#getOwnedPorts
	 * @model opposite="ownedPorts" required="true" transient="false"
	 * @generated
	 */
	Agent getOwner();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Port#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Agent value);

	/**
	 * Returns the value of the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate</em>' attribute.
	 * @see #setRate(int)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getPort_Rate()
	 * @model required="true"
	 * @generated
	 */
	int getRate();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Port#getRate <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate</em>' attribute.
	 * @see #getRate()
	 * @generated
	 */
	void setRate(int value);

	/**
	 * Returns the value of the '<em><b>Byte Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Byte Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Byte Rate</em>' attribute.
	 * @see #setByteRate(int)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getPort_ByteRate()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getByteRate();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Port#getByteRate <em>Byte Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Byte Rate</em>' attribute.
	 * @see #getByteRate()
	 * @generated
	 */
	void setByteRate(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.sample.sigpml.sizeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.gemoc.sample.sigpml.sizeType
	 * @see #setType(sizeType)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getPort_Type()
	 * @model required="true"
	 * @generated
	 */
	sizeType getType();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Port#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.gemoc.sample.sigpml.sizeType
	 * @see #getType()
	 * @generated
	 */
	void setType(sizeType value);

} // Port
