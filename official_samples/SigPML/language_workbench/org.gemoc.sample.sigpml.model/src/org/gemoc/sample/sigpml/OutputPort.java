/**
 */
package org.gemoc.sample.sigpml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.OutputPort#getSizeWritten <em>Size Written</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.sample.sigpml.SigpmlPackage#getOutputPort()
 * @model
 * @generated
 */
public interface OutputPort extends Port {
	/**
	 * Returns the value of the '<em><b>Size Written</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size Written</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Written</em>' attribute.
	 * @see #setSizeWritten(int)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getOutputPort_SizeWritten()
	 * @model
	 * @generated
	 */
	int getSizeWritten();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.OutputPort#getSizeWritten <em>Size Written</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Written</em>' attribute.
	 * @see #getSizeWritten()
	 * @generated
	 */
	void setSizeWritten(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void write();

} // OutputPort
