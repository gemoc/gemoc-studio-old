/**
 */
package javasolverinput;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Solver Input File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javasolverinput.JavaSolverInputFile#getClocks <em>Clocks</em>}</li>
 *   <li>{@link javasolverinput.JavaSolverInputFile#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.JavasolverinputPackage#getJavaSolverInputFile()
 * @model
 * @generated
 */
public interface JavaSolverInputFile extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Clocks</b></em>' containment reference list.
	 * The list contents are of type {@link javasolverinput.Clock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clocks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clocks</em>' containment reference list.
	 * @see javasolverinput.JavasolverinputPackage#getJavaSolverInputFile_Clocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Clock> getClocks();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link javasolverinput.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see javasolverinput.JavasolverinputPackage#getJavaSolverInputFile_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Relation> getConstraints();

} // JavaSolverInputFile
