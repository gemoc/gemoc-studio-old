/**
 */
package javasolverinput.usage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait Until</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javasolverinput.usage.WaitUntil#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.usage.UsagePackage#getWaitUntil()
 * @model
 * @generated
 */
public interface WaitUntil extends BootstrappedConstraint {

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Integer)
	 * @see javasolverinput.usage.UsagePackage#getWaitUntil_Date()
	 * @model required="true"
	 * @generated
	 */
	Integer getDate();

	/**
	 * Sets the value of the '{@link javasolverinput.usage.WaitUntil#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Integer value);
} // WaitUntil
