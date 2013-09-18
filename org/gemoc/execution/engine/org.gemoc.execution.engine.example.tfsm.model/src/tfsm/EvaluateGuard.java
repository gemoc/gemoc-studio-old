/**
 */
package tfsm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluate Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tfsm.EvaluateGuard#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see tfsm.TfsmPackage#getEvaluateGuard()
 * @model
 * @generated
 */
public interface EvaluateGuard extends Guard {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see tfsm.TfsmPackage#getEvaluateGuard_Condition()
	 * @model required="true"
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link tfsm.EvaluateGuard#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean evaluate();

} // EvaluateGuard
