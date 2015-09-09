/**
 */
package org.gemoc.gel.gexpressions;

import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GOperation Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gel.gexpressions.GOperationReferenceExpression#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gel.gexpressions.GexpressionsPackage#getGOperationReferenceExpression()
 * @model
 * @generated
 */
public interface GOperationReferenceExpression extends GPrimaryExpression {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(EOperation)
	 * @see org.gemoc.gel.gexpressions.GexpressionsPackage#getGOperationReferenceExpression_Operation()
	 * @model required="true"
	 * @generated
	 */
	EOperation getOperation();

	/**
	 * Sets the value of the '{@link org.gemoc.gel.gexpressions.GOperationReferenceExpression#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(EOperation value);

} // GOperationReferenceExpression
