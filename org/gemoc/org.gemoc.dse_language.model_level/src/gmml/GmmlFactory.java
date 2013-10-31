/**
 */
package gmml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gmml.GmmlPackage
 * @generated
 */
public interface GmmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GmmlFactory eINSTANCE = gmml.impl.GmmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Specific Event File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Specific Event File</em>'.
	 * @generated
	 */
	ModelSpecificEventFile createModelSpecificEventFile();

	/**
	 * Returns a new object of class '<em>Model Specific Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Specific Event</em>'.
	 * @generated
	 */
	ModelSpecificEvent createModelSpecificEvent();

	/**
	 * Returns a new object of class '<em>Import Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Statement</em>'.
	 * @generated
	 */
	ImportStatement createImportStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GmmlPackage getGmmlPackage();

} //GmmlFactory
