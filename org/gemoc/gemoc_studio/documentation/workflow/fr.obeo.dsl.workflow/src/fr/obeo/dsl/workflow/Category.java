/**
 */
package fr.obeo.dsl.workflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.workflow.Category#getSteps <em>Steps</em>}</li>
 *   <li>{@link fr.obeo.dsl.workflow.Category#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.workflow.WorkflowPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.workflow.Step}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see fr.obeo.dsl.workflow.WorkflowPackage#getCategory_Steps()
	 * @model containment="true"
	 * @generated
	 */
	EList<Step> getSteps();

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.workflow.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see fr.obeo.dsl.workflow.WorkflowPackage#getCategory_Categories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Category> getCategories();

} // Category
