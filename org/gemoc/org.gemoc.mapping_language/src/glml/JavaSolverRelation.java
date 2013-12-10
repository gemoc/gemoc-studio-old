/**
 */
package glml;

import javasolverinput.Relation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Solver Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.JavaSolverRelation#getRelation <em>Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getJavaSolverRelation()
 * @model
 * @generated
 */
public interface JavaSolverRelation extends MocRelation {
	/**
	 * Returns the value of the '<em><b>Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' reference.
	 * @see #setRelation(Relation)
	 * @see glml.GlmlPackage#getJavaSolverRelation_Relation()
	 * @model required="true"
	 * @generated
	 */
	Relation getRelation();

	/**
	 * Sets the value of the '{@link glml.JavaSolverRelation#getRelation <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' reference.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(Relation value);

} // JavaSolverRelation
