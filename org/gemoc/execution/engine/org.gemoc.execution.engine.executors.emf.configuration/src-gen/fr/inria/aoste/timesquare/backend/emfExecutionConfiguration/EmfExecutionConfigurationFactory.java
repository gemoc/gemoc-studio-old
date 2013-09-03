/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage
 * @generated
 */
public interface EmfExecutionConfigurationFactory extends EFactory {
    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EmfExecutionConfigurationFactory eINSTANCE = fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationFactoryImpl
            .init();

    /**
     * Returns a new object of class '<em>EMF Execution Configuration</em>'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>EMF Execution Configuration</em>'.
     * @generated
     */
    EMFExecutionConfiguration createEMFExecutionConfiguration();

    /**
     * Returns a new object of class '<em>Forced Clock Mapping</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Forced Clock Mapping</em>'.
     * @generated
     */
    ForcedClockMapping createForcedClockMapping();

    /**
     * Returns a new object of class '<em>Import Statement</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Import Statement</em>'.
     * @generated
     */
    ImportStatement createImportStatement();

    /**
     * Returns a new object of class '<em>Jar Import Statement</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return a new object of class '<em>Jar Import Statement</em>'.
     * @generated
     */
    JarImportStatement createJarImportStatement();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    EmfExecutionConfigurationPackage getEmfExecutionConfigurationPackage();

} // EmfExecutionConfigurationFactory
