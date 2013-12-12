/**
 */
package javasolverinput;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bootstrapped Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javasolverinput.BootstrappedConstraint#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.JavasolverinputPackage#getBootstrappedConstraint()
 * @model abstract="true"
 * @generated
 */
public interface BootstrappedConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link javasolverinput.BootStrappedConstraintArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see javasolverinput.JavasolverinputPackage#getBootstrappedConstraint_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<BootStrappedConstraintArgument> getArguments();

} // BootstrappedConstraint
