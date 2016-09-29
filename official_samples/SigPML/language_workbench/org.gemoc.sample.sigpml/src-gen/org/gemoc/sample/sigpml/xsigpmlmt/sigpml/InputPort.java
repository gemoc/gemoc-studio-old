/**
 */
package org.gemoc.sample.sigpml.xsigpmlmt.sigpml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.InputPort#getSizeToread <em>Size Toread</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getInputPort()
 * @model
 * @generated
 */
public interface InputPort extends Port {
	/**
	 * Returns the value of the '<em><b>Size Toread</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size Toread</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Toread</em>' attribute.
	 * @see #setSizeToread(int)
	 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getInputPort_SizeToread()
	 * @model unique="false"
	 * @generated
	 */
	int getSizeToread();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.InputPort#getSizeToread <em>Size Toread</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Toread</em>' attribute.
	 * @see #getSizeToread()
	 * @generated
	 */
	void setSizeToread(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	int read();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void logSizeToReadWhenZero();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void logSizeToReadWhenNotZero();

} // InputPort
