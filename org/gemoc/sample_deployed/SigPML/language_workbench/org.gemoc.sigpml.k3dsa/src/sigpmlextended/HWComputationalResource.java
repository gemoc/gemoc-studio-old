/**
 */
package sigpmlextended;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Computational Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.HWComputationalResource#getCurrentExecCycle <em>Current Exec Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getHWComputationalResource()
 * @model
 * @generated
 */
public interface HWComputationalResource extends org.gemoc.sigpml.HWComputationalResource {
	/**
	 * Returns the value of the '<em><b>Current Exec Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Exec Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Exec Cycle</em>' attribute.
	 * @see #setCurrentExecCycle(int)
	 * @see sigpmlextended.SigpmlextendedPackage#getHWComputationalResource_CurrentExecCycle()
	 * @model
	 * @generated
	 */
	int getCurrentExecCycle();

	/**
	 * Sets the value of the '{@link sigpmlextended.HWComputationalResource#getCurrentExecCycle <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Exec Cycle</em>' attribute.
	 * @see #getCurrentExecCycle()
	 * @generated
	 */
	void setCurrentExecCycle(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void incCycle();

} // HWComputationalResource
