/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationFactory;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class EmfExecutionConfigurationFactoryImpl extends EFactoryImpl implements EmfExecutionConfigurationFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static EmfExecutionConfigurationPackage getPackage() {
        return EmfExecutionConfigurationPackage.eINSTANCE;
    }

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public static EmfExecutionConfigurationFactory init() {
        try {
            EmfExecutionConfigurationFactory theEmfExecutionConfigurationFactory = (EmfExecutionConfigurationFactory) EPackage.Registry.INSTANCE
                    .getEFactory("http://www.inria.fr/aoste/timesquare/backend/EmfExecutionConfiguration");
            if (theEmfExecutionConfigurationFactory != null) {
                return theEmfExecutionConfigurationFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EmfExecutionConfigurationFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public EmfExecutionConfigurationFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION:
                return this.createEMFExecutionConfiguration();
            case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING:
                return this.createForcedClockMapping();
            case EmfExecutionConfigurationPackage.IMPORT_STATEMENT:
                return this.createImportStatement();
            case EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT:
                return this.createJarImportStatement();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EMFExecutionConfiguration createEMFExecutionConfiguration() {
        EMFExecutionConfigurationImpl emfExecutionConfiguration = new EMFExecutionConfigurationImpl();
        return emfExecutionConfiguration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ForcedClockMapping createForcedClockMapping() {
        ForcedClockMappingImpl forcedClockMapping = new ForcedClockMappingImpl();
        return forcedClockMapping;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ImportStatement createImportStatement() {
        ImportStatementImpl importStatement = new ImportStatementImpl();
        return importStatement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public JarImportStatement createJarImportStatement() {
        JarImportStatementImpl jarImportStatement = new JarImportStatementImpl();
        return jarImportStatement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EmfExecutionConfigurationPackage getEmfExecutionConfigurationPackage() {
        return (EmfExecutionConfigurationPackage) this.getEPackage();
    }

} // EmfExecutionConfigurationFactoryImpl
