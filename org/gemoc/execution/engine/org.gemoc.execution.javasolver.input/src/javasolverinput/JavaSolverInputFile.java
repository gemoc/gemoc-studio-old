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
 *   <li>{@link javasolverinput.JavaSolverInputFile#getClockDeclarations <em>Clock Declarations</em>}</li>
 *   <li>{@link javasolverinput.JavaSolverInputFile#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link javasolverinput.JavaSolverInputFile#getRelationDeclarations <em>Relation Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.JavasolverinputPackage#getJavaSolverInputFile()
 * @model
 * @generated
 */
public interface JavaSolverInputFile extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Clock Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link javasolverinput.Clock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock Declarations</em>' containment reference list.
	 * @see javasolverinput.JavasolverinputPackage#getJavaSolverInputFile_ClockDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Clock> getClockDeclarations();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link javasolverinput.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see javasolverinput.JavasolverinputPackage#getJavaSolverInputFile_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * Returns the value of the '<em><b>Relation Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link javasolverinput.RelationDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Declarations</em>' containment reference list.
	 * @see javasolverinput.JavasolverinputPackage#getJavaSolverInputFile_RelationDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<RelationDeclaration> getRelationDeclarations();

} // JavaSolverInputFile
