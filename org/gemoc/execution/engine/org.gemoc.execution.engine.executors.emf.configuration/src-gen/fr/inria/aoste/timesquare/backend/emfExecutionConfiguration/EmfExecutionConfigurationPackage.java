/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface EmfExecutionConfigurationPackage extends EPackage {
    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that
     * represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '
         * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl
         * <em>EMF Execution Configuration</em>}' class. <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl
         * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl#getEMFExecutionConfiguration()
         * @generated
         */
        EClass EMF_EXECUTION_CONFIGURATION = EmfExecutionConfigurationPackage.eINSTANCE.getEMFExecutionConfiguration();

        /**
         * The meta object literal for the '<em><b>Imports</b></em>' containment
         * reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference EMF_EXECUTION_CONFIGURATION__IMPORTS = EmfExecutionConfigurationPackage.eINSTANCE
                .getEMFExecutionConfiguration_Imports();

        /**
         * The meta object literal for the '<em><b>Jar Import Statement</b></em>
         * ' containment reference feature. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @generated
         */
        EReference EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT = EmfExecutionConfigurationPackage.eINSTANCE
                .getEMFExecutionConfiguration_JarImportStatement();

        /**
         * The meta object literal for the '
         * <em><b>Forced Clock Mappings</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS = EmfExecutionConfigurationPackage.eINSTANCE
                .getEMFExecutionConfiguration_ForcedClockMappings();

        /**
         * The meta object literal for the '
         * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ForcedClockMappingImpl
         * <em>Forced Clock Mapping</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ForcedClockMappingImpl
         * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl#getForcedClockMapping()
         * @generated
         */
        EClass FORCED_CLOCK_MAPPING = EmfExecutionConfigurationPackage.eINSTANCE.getForcedClockMapping();

        /**
         * The meta object literal for the '<em><b>Clock</b></em>' reference
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference FORCED_CLOCK_MAPPING__CLOCK = EmfExecutionConfigurationPackage.eINSTANCE
                .getForcedClockMapping_Clock();

        /**
         * The meta object literal for the '
         * <em><b>Clock To Avoid When True</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE = EmfExecutionConfigurationPackage.eINSTANCE
                .getForcedClockMapping_ClockToAvoidWhenTrue();

        /**
         * The meta object literal for the '
         * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ImportStatementImpl
         * <em>Import Statement</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ImportStatementImpl
         * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl#getImportStatement()
         * @generated
         */
        EClass IMPORT_STATEMENT = EmfExecutionConfigurationPackage.eINSTANCE.getImportStatement();

        /**
         * The meta object literal for the '<em><b>Import URI</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute IMPORT_STATEMENT__IMPORT_URI = EmfExecutionConfigurationPackage.eINSTANCE
                .getImportStatement_ImportURI();

        /**
         * The meta object literal for the '
         * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.JarImportStatementImpl
         * <em>Jar Import Statement</em>}' class. <!-- begin-user-doc --> <!--
         * end-user-doc -->
         * 
         * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.JarImportStatementImpl
         * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl#getJarImportStatement()
         * @generated
         */
        EClass JAR_IMPORT_STATEMENT = EmfExecutionConfigurationPackage.eINSTANCE.getJarImportStatement();

        /**
         * The meta object literal for the '<em><b>Path To Jar</b></em>'
         * attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute JAR_IMPORT_STATEMENT__PATH_TO_JAR = EmfExecutionConfigurationPackage.eINSTANCE
                .getJarImportStatement_PathToJar();

    }

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "emfExecutionConfiguration";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://www.inria.fr/aoste/timesquare/backend/EmfExecutionConfiguration";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "emfExecutionConfiguration";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    EmfExecutionConfigurationPackage eINSTANCE = fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl
            .init();

    /**
     * The meta object id for the '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl
     * <em>EMF Execution Configuration</em>}' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl#getEMFExecutionConfiguration()
     * @generated
     */
    int EMF_EXECUTION_CONFIGURATION = 0;

    /**
     * The feature id for the '<em><b>Imports</b></em>' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EMF_EXECUTION_CONFIGURATION__IMPORTS = 0;

    /**
     * The feature id for the '<em><b>Jar Import Statement</b></em>' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT = 1;

    /**
     * The feature id for the '<em><b>Forced Clock Mappings</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS = 2;

    /**
     * The number of structural features of the '
     * <em>EMF Execution Configuration</em>' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int EMF_EXECUTION_CONFIGURATION_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ForcedClockMappingImpl
     * <em>Forced Clock Mapping</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ForcedClockMappingImpl
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl#getForcedClockMapping()
     * @generated
     */
    int FORCED_CLOCK_MAPPING = 1;

    /**
     * The feature id for the '<em><b>Clock</b></em>' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FORCED_CLOCK_MAPPING__CLOCK = 0;

    /**
     * The feature id for the '<em><b>Clock To Avoid When True</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE = 1;

    /**
     * The number of structural features of the '<em>Forced Clock Mapping</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FORCED_CLOCK_MAPPING_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ImportStatementImpl
     * <em>Import Statement</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ImportStatementImpl
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl#getImportStatement()
     * @generated
     */
    int IMPORT_STATEMENT = 2;

    /**
     * The feature id for the '<em><b>Import URI</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IMPORT_STATEMENT__IMPORT_URI = 0;

    /**
     * The number of structural features of the '<em>Import Statement</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int IMPORT_STATEMENT_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.JarImportStatementImpl
     * <em>Jar Import Statement</em>}' class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.JarImportStatementImpl
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EmfExecutionConfigurationPackageImpl#getJarImportStatement()
     * @generated
     */
    int JAR_IMPORT_STATEMENT = 3;

    /**
     * The feature id for the '<em><b>Path To Jar</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JAR_IMPORT_STATEMENT__PATH_TO_JAR = 0;

    /**
     * The number of structural features of the '<em>Jar Import Statement</em>'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int JAR_IMPORT_STATEMENT_FEATURE_COUNT = 1;

    /**
     * Returns the meta object for class '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration
     * <em>EMF Execution Configuration</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>EMF Execution Configuration</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration
     * @generated
     */
    EClass getEMFExecutionConfiguration();

    /**
     * Returns the meta object for the containment reference list '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getForcedClockMappings
     * <em>Forced Clock Mappings</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Forced Clock Mappings</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getForcedClockMappings()
     * @see #getEMFExecutionConfiguration()
     * @generated
     */
    EReference getEMFExecutionConfiguration_ForcedClockMappings();

    /**
     * Returns the meta object for the containment reference list '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getImports
     * <em>Imports</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Imports</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getImports()
     * @see #getEMFExecutionConfiguration()
     * @generated
     */
    EReference getEMFExecutionConfiguration_Imports();

    /**
     * Returns the meta object for the containment reference '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getJarImportStatement
     * <em>Jar Import Statement</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference '
     *         <em>Jar Import Statement</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getJarImportStatement()
     * @see #getEMFExecutionConfiguration()
     * @generated
     */
    EReference getEMFExecutionConfiguration_JarImportStatement();

    /**
     * Returns the factory that creates the instances of the model. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    EmfExecutionConfigurationFactory getEmfExecutionConfigurationFactory();

    /**
     * Returns the meta object for class '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping
     * <em>Forced Clock Mapping</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Forced Clock Mapping</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping
     * @generated
     */
    EClass getForcedClockMapping();

    /**
     * Returns the meta object for the reference '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping#getClock
     * <em>Clock</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Clock</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping#getClock()
     * @see #getForcedClockMapping()
     * @generated
     */
    EReference getForcedClockMapping_Clock();

    /**
     * Returns the meta object for the reference '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping#getClockToAvoidWhenTrue
     * <em>Clock To Avoid When True</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Clock To Avoid When True</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping#getClockToAvoidWhenTrue()
     * @see #getForcedClockMapping()
     * @generated
     */
    EReference getForcedClockMapping_ClockToAvoidWhenTrue();

    /**
     * Returns the meta object for class '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement
     * <em>Import Statement</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return the meta object for class '<em>Import Statement</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement
     * @generated
     */
    EClass getImportStatement();

    /**
     * Returns the meta object for the attribute '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement#getImportURI
     * <em>Import URI</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Import URI</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement#getImportURI()
     * @see #getImportStatement()
     * @generated
     */
    EAttribute getImportStatement_ImportURI();

    /**
     * Returns the meta object for class '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement
     * <em>Jar Import Statement</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for class '<em>Jar Import Statement</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement
     * @generated
     */
    EClass getJarImportStatement();

    /**
     * Returns the meta object for the attribute '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement#getPathToJar
     * <em>Path To Jar</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Path To Jar</em>'.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement#getPathToJar()
     * @see #getJarImportStatement()
     * @generated
     */
    EAttribute getJarImportStatement_PathToJar();

} // EmfExecutionConfigurationPackage
