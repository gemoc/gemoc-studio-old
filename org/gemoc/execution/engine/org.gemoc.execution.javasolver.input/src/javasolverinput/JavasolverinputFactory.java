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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JavasolverinputPackage getJavasolverinputPackage();

} //JavasolverinputFactory
