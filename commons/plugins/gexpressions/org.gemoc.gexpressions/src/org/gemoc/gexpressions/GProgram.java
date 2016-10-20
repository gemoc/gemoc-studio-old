/**
 */
package org.gemoc.gexpressions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GProgram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gexpressions.GProgram#getImports <em>Imports</em>}</li>
 *   <li>{@link org.gemoc.gexpressions.GProgram#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gexpressions.GexpressionsPackage#getGProgram()
 * @model
 * @generated
 */
public interface GProgram extends EObject {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.gexpressions.GImportStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.gemoc.gexpressions.GexpressionsPackage#getGProgram_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<GImportStatement> getImports();

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.gexpressions.GExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.gemoc.gexpressions.GexpressionsPackage#getGProgram_Expressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<GExpression> getExpressions();

} // GProgram
