/**
 */
package sigpmlextended;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.OutputPort#getSizeWritten <em>Size Written</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getOutputPort()
 * @model
 * @generated
 */
public interface OutputPort extends org.gemoc.sigpml.OutputPort {
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
	 * @see sigpmlextended.SigpmlextendedPackage#getOutputPort_SizeWritten()
	 * @model
	 * @generated
	 */
	int getSizeWritten();

	/**
	 * Sets the value of the '{@link sigpmlextended.OutputPort#getSizeWritten <em>Size Written</em>}' attribute.
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
