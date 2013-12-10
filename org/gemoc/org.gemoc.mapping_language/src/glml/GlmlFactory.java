/**
 */
package glml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see glml.GlmlPackage
 * @generated
 */
public interface GlmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GlmlFactory eINSTANCE = glml.impl.GlmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Domain Specific Event File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Specific Event File</em>'.
	 * @generated
	 */
	DomainSpecificEventFile createDomainSpecificEventFile();

	/**
	 * Returns a new object of class '<em>Domain Specific Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Specific Event</em>'.
	 * @generated
	 */
	DomainSpecificEvent createDomainSpecificEvent();

	/**
	 * Returns a new object of class '<em>Import Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Statement</em>'.
	 * @generated
	 */
	ImportStatement createImportStatement();

	/**
	 * Returns a new object of class '<em>Extended Ccsl Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Ccsl Relation</em>'.
	 * @generated
	 */
	ExtendedCcslRelation createExtendedCcslRelation();

	/**
	 * Returns a new object of class '<em>Model Specific Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Specific Event</em>'.
	 * @generated
	 */
	ModelSpecificEvent createModelSpecificEvent();

	/**
	 * Returns a new object of class '<em>Java Solver Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Solver Relation</em>'.
	 * @generated
	 */
	JavaSolverRelation createJavaSolverRelation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GlmlPackage getGlmlPackage();

} //GlmlFactory
