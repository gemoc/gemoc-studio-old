/**
 */
package javasolverinput.usage;

import javasolverinput.creation.RelationDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javasolverinput.usage.CustomConstraint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.usage.UsagePackage#getCustomConstraint()
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
	 * @see javasolverinput.usage.UsagePackage#getCustomConstraint_Type()
	 * @model required="true"
	 * @generated
	 */
	RelationDeclaration getType();

	/**
	 * Sets the value of the '{@link javasolverinput.usage.CustomConstraint#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationDeclaration value);

} // CustomConstraint
