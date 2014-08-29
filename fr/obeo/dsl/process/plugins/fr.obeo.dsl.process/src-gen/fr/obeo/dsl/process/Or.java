/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Or</b></em>'. <!-- end-user-doc -->
 * <!-- begin-model-doc --> {@link Or#check() Checks} returns <code>true</code> if one of its
 * {@link Or#getExpressions() expressions} is <code>true</code>, <code>false</code> otherwise. <!--
 * end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.Or#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getOr()
 * @model
 * @generated
 */
public interface Or extends Expression {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list. The list contents
	 * are of type {@link fr.obeo.dsl.process.Expression}. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> Operands. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getOr_Expressions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expression> getExpressions();

} // Or
