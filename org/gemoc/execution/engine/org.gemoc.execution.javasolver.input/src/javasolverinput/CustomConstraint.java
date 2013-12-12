/**
 */
package javasolverinput;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javasolverinput.CustomConstraint#getType <em>Type</em>}</li>
 *   <li>{@link javasolverinput.CustomConstraint#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.JavasolverinputPackage#getCustomConstraint()
 * @model
 * @generated
 */
public interface CustomConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(RelationDeclaration)
	 * @see javasolverinput.JavasolverinputPackage#getCustomConstraint_Type()
	 * @model required="true"
	 * @generated
	 */
	RelationDeclaration getType();

	/**
	 * Sets the value of the '{@link javasolverinput.CustomConstraint#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationDeclaration value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see javasolverinput.JavasolverinputPackage#getCustomConstraint_Arguments()
	 * @model
	 * @generated
	 */
	EList<EObject> getArguments();

} // CustomConstraint
