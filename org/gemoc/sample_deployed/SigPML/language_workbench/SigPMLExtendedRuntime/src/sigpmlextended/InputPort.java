/**
 */
package sigpmlextended;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Port</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see sigpmlextended.SigpmlextendedPackage#getInputPort()
 * @model
 * @generated
 */
public interface InputPort extends Port {
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
