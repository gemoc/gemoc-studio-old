/**
 */
package fr.obeo.dsl.process;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Not</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * {@link Not#check() Checks} returns <code>true</code> if its {@link Not#getExpression() expression} is <code>false</code>, <code>false</code> otherwise.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.process.Not#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.process.ProcessPackage#getNot()
 * @model
 * @generated
 */
public interface Not extends Expression {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Operand. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see fr.obeo.dsl.process.ProcessPackage#getNot_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.Not#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // Not
