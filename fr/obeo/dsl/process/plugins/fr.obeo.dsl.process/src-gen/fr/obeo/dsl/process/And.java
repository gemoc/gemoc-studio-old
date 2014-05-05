/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>And</b></em>'. <!-- end-user-doc -->
 * <!-- begin-model-doc --> {@link And#check() Checks} returns <code>true</code> if all its
 * {@link And#getExpressions() expressions} are <code>true</code>, <code>false</code> otherwise. <!--
 * end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.And#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getAnd()
 * @model
 * @generated
 */
public interface And extends Expression {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list. The list contents
	 * are of type {@link fr.obeo.dsl.process.Expression}. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> Operands. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getAnd_Expressions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expression> getExpressions();

} // And
