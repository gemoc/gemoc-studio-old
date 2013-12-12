/**
 */
package javasolverinput.creation;

import javasolverinput.usage.Constraint;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javasolverinput.creation.RelationDefinition#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.creation.CreationPackage#getRelationDefinition()
 * @model
 * @generated
 */
public interface RelationDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link javasolverinput.usage.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see javasolverinput.creation.CreationPackage#getRelationDefinition_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

} // RelationDefinition
