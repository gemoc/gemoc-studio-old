/**
 */
package org.gemoc.gel.gexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GUnary Operator Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gel.gexpressions.GUnaryOperatorExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gel.gexpressions.GexpressionsPackage#getGUnaryOperatorExpression()
 * @model abstract="true"
 * @generated
 */
public interface GUnaryOperatorExpression extends GExpression {
	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(GExpression)
	 * @see org.gemoc.gel.gexpressions.GexpressionsPackage#getGUnaryOperatorExpression_Operand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GExpression getOperand();

	/**
	 * Sets the value of the '{@link org.gemoc.gel.gexpressions.GUnaryOperatorExpression#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(GExpression value);

} // GUnaryOperatorExpression
