/**
 */
package javasolverinput;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see javasolverinput.JavasolverinputPackage
 * @generated
 */
public interface JavasolverinputFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavasolverinputFactory eINSTANCE = javasolverinput.impl.JavasolverinputFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Java Solver Input File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Solver Input File</em>'.
	 * @generated
	 */
	JavaSolverInputFile createJavaSolverInputFile();

	/**
	 * Returns a new object of class '<em>Boot Strapped Constraint Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boot Strapped Constraint Argument</em>'.
	 * @generated
	 */
	BootStrappedConstraintArgument createBootStrappedConstraintArgument();

	/**
	 * Returns a new object of class '<em>Precedes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Precedes</em>'.
	 * @generated
	 */
	Precedes createPrecedes();

	/**
	 * Returns a new object of class '<em>Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock</em>'.
	 * @generated
	 */
	Clock createClock();

	/**
	 * Returns a new object of class '<em>Custom Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Constraint</em>'.
	 * @generated
	 */
	CustomConstraint createCustomConstraint();

	/**
	 * Returns a new object of class '<em>Relation Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Declaration</em>'.
	 * @generated
	 */
	RelationDeclaration createRelationDeclaration();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Relation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Definition</em>'.
	 * @generated
	 */
	RelationDefinition createRelationDefinition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JavasolverinputPackage getJavasolverinputPackage();

} //JavasolverinputFactory
