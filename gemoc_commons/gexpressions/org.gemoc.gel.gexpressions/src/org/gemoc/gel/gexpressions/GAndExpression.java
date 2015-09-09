/**
 */
package org.gemoc.gel.gexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GAnd Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gel.gexpressions.GAndExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gel.gexpressions.GexpressionsPackage#getGAndExpression()
 * @model
 * @generated
 */
public interface GAndExpression extends GBooleanOperatorExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.gel.gexpressions.GAndOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.gemoc.gel.gexpressions.GAndOperator
	 * @see #setOperator(GAndOperator)
	 * @see org.gemoc.gel.gexpressions.GexpressionsPackage#getGAndExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	GAndOperator getOperator();

	/**
	 * Sets the value of the '{@link org.gemoc.gel.gexpressions.GAndExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.gemoc.gel.gexpressions.GAndOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(GAndOperator value);

} // GAndExpression
