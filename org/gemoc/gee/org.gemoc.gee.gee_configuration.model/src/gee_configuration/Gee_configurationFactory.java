/**
 */
package gee_configuration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gee_configuration.Gee_configurationPackage
 * @generated
 */
public interface Gee_configurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Gee_configurationFactory eINSTANCE = gee_configuration.impl.Gee_configurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Gemoc Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gemoc Configuration</em>'.
	 * @generated
	 */
	GemocConfiguration createGemocConfiguration();

	/**
	 * Returns a new object of class '<em>DSA Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSA Model</em>'.
	 * @generated
	 */
	DSAModel createDSAModel();

	/**
	 * Returns a new object of class '<em>Mocc Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mocc Model</em>'.
	 * @generated
	 */
	MoccModel createMoccModel();

	/**
	 * Returns a new object of class '<em>DSE Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSE Model</em>'.
	 * @generated
	 */
	DSEModel createDSEModel();

	/**
	 * Returns a new object of class '<em>Domain Specific Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Specific Metamodel</em>'.
	 * @generated
	 */
	DomainSpecificMetamodel createDomainSpecificMetamodel();

	/**
	 * Returns a new object of class '<em>Local Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Resource</em>'.
	 * @generated
	 */
	LocalResource createLocalResource();

	/**
	 * Returns a new object of class '<em>Domain Specific Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Specific Editor</em>'.
	 * @generated
	 */
	DomainSpecificEditor createDomainSpecificEditor();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Gee_configurationPackage getGee_configurationPackage();

} //Gee_configurationFactory
