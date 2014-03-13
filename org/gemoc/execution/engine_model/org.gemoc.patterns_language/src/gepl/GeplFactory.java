/**
 */
package gepl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gepl.GeplPackage
 * @generated
 */
public interface GeplFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeplFactory eINSTANCE = gepl.impl.GeplFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Every</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Every</em>'.
	 * @generated
	 */
	Every createEvery();

	/**
	 * Returns a new object of class '<em>ECL Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ECL Event</em>'.
	 * @generated
	 */
	ECLEvent createECLEvent();

	/**
	 * Returns a new object of class '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference</em>'.
	 * @generated
	 */
	Reference createReference();

	/**
	 * Returns a new object of class '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GeplPackage getGeplPackage();

} //GeplFactory
