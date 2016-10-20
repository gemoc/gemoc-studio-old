/**
 */
package org.gemoc.gexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GNegation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gexpressions.GNegationExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gexpressions.GexpressionsPackage#getGNegationExpression()
 * @model
 * @generated
 */
public interface GNegationExpression extends GUnaryOperatorExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.gexpressions.GNegationOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.gemoc.gexpressions.GNegationOperator
	 * @see #setOperator(GNegationOperator)
	 * @see org.gemoc.gexpressions.GexpressionsPackage#getGNegationExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	GNegationOperator getOperator();

	/**
	 * Sets the value of the '{@link org.gemoc.gexpressions.GNegationExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.gemoc.gexpressions.GNegationOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(GNegationOperator value);

} // GNegationExpression
