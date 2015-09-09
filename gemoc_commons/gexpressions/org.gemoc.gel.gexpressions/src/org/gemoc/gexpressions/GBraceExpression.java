/**
 */
package org.gemoc.gexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GBrace Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gexpressions.GBraceExpression#getInnerExpression <em>Inner Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gexpressions.GexpressionsPackage#getGBraceExpression()
 * @model
 * @generated
 */
public interface GBraceExpression extends GPrimaryExpression {
	/**
	 * Returns the value of the '<em><b>Inner Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Expression</em>' containment reference.
	 * @see #setInnerExpression(GExpression)
	 * @see org.gemoc.gexpressions.GexpressionsPackage#getGBraceExpression_InnerExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	GExpression getInnerExpression();

	/**
	 * Sets the value of the '{@link org.gemoc.gexpressions.GBraceExpression#getInnerExpression <em>Inner Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Expression</em>' containment reference.
	 * @see #getInnerExpression()
	 * @generated
	 */
	void setInnerExpression(GExpression value);

} // GBraceExpression
