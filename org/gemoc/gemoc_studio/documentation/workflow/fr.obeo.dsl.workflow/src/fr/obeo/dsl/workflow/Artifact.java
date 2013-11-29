/**
 */
package fr.obeo.dsl.workflow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.workflow.Artifact#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.obeo.dsl.workflow.Artifact#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.workflow.WorkflowPackage#getArtifact()
 * @model
 * @generated
 */
public interface Artifact extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see fr.obeo.dsl.workflow.WorkflowPackage#getArtifact_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workflow.Artifact#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.obeo.dsl.workflow.UpdateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see fr.obeo.dsl.workflow.UpdateType
	 * @see #setType(UpdateType)
	 * @see fr.obeo.dsl.workflow.WorkflowPackage#getArtifact_Type()
	 * @model
	 * @generated
	 */
	UpdateType getType();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workflow.Artifact#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see fr.obeo.dsl.workflow.UpdateType
	 * @see #getType()
	 * @generated
	 */
	void setType(UpdateType value);

} // Artifact
