/**
 */
package org.eclipse.gemoc.gexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GRelation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gemoc.gexpressions.GRelationExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gemoc.gexpressions.GexpressionsPackage#getGRelationExpression()
 * @model
 * @generated
 */
public interface GRelationExpression extends GBinaryOperatorExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gemoc.gexpressions.GRelationOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.eclipse.gemoc.gexpressions.GRelationOperator
	 * @see #setOperator(GRelationOperator)
	 * @see org.eclipse.gemoc.gexpressions.GexpressionsPackage#getGRelationExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	GRelationOperator getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.gemoc.gexpressions.GRelationExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.eclipse.gemoc.gexpressions.GRelationOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(GRelationOperator value);

} // GRelationExpression
