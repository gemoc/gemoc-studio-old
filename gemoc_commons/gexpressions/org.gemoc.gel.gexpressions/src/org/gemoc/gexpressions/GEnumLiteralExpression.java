/**
 */
package org.gemoc.gexpressions;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GEnum Literal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gexpressions.GEnumLiteralExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gexpressions.GexpressionsPackage#getGEnumLiteralExpression()
 * @model
 * @generated
 */
public interface GEnumLiteralExpression extends GPrimaryExpression {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EEnumLiteral)
	 * @see org.gemoc.gexpressions.GexpressionsPackage#getGEnumLiteralExpression_Value()
	 * @model required="true"
	 * @generated
	 */
	EEnumLiteral getValue();

	/**
	 * Sets the value of the '{@link org.gemoc.gexpressions.GEnumLiteralExpression#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EEnumLiteral value);

} // GEnumLiteralExpression
