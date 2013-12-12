/**
 */
package javasolverinput.creation;

import javasolverinput.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javasolverinput.creation.RelationDeclaration#getParameters <em>Parameters</em>}</li>
 *   <li>{@link javasolverinput.creation.RelationDeclaration#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.creation.CreationPackage#getRelationDeclaration()
 * @model
 * @generated
 */
public interface RelationDeclaration extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link javasolverinput.creation.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see javasolverinput.creation.CreationPackage#getRelationDeclaration_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(RelationDefinition)
	 * @see javasolverinput.creation.CreationPackage#getRelationDeclaration_Definition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RelationDefinition getDefinition();

	/**
	 * Sets the value of the '{@link javasolverinput.creation.RelationDeclaration#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(RelationDefinition value);

} // RelationDeclaration
