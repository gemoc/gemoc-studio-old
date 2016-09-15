/**
 */
package org.gemoc.gexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GXor Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gexpressions.GXorExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gexpressions.GexpressionsPackage#getGXorExpression()
 * @model
 * @generated
 */
public interface GXorExpression extends GBooleanOperatorExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.gexpressions.GXorOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.gemoc.gexpressions.GXorOperator
	 * @see #setOperator(GXorOperator)
	 * @see org.gemoc.gexpressions.GexpressionsPackage#getGXorExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	GXorOperator getOperator();

	/**
	 * Sets the value of the '{@link org.gemoc.gexpressions.GXorExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.gemoc.gexpressions.GXorOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(GXorOperator value);

} // GXorExpression
