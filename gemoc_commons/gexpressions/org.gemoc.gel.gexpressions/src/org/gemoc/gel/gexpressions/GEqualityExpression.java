/**
 */
package org.gemoc.gel.gexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GEquality Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gel.gexpressions.GEqualityExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gel.gexpressions.GexpressionsPackage#getGEqualityExpression()
 * @model
 * @generated
 */
public interface GEqualityExpression extends GBinaryOperatorExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.gel.gexpressions.GEqualityOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.gemoc.gel.gexpressions.GEqualityOperator
	 * @see #setOperator(GEqualityOperator)
	 * @see org.gemoc.gel.gexpressions.GexpressionsPackage#getGEqualityExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	GEqualityOperator getOperator();

	/**
	 * Sets the value of the '{@link org.gemoc.gel.gexpressions.GEqualityExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.gemoc.gel.gexpressions.GEqualityOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(GEqualityOperator value);

} // GEqualityExpression
