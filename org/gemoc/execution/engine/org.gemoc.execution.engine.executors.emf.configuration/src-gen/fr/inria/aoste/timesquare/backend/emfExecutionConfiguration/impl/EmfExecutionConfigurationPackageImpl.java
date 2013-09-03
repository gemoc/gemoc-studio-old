/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationFactory;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class EmfExecutionConfigurationPackageImpl extends EPackageImpl implements EmfExecutionConfigurationPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass emfExecutionConfigurationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass forcedClockMappingEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass importStatementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass jarImportStatementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * 
     * <p>
     * This method is used to initialize
     * {@link EmfExecutionConfigurationPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should
     * simply access that field to obtain the package. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static EmfExecutionConfigurationPackage init() {
        if (EmfExecutionConfigurationPackageImpl.isInited) {
            return (EmfExecutionConfigurationPackage) EPackage.Registry.INSTANCE
                    .getEPackage(EmfExecutionConfigurationPackage.eNS_URI);
        }

        // Obtain or create and register package
        EmfExecutionConfigurationPackageImpl theEmfExecutionConfigurationPackage = (EmfExecutionConfigurationPackageImpl) (EPackage.Registry.INSTANCE
                .get(EmfExecutionConfigurationPackage.eNS_URI) instanceof EmfExecutionConfigurationPackageImpl ? EPackage.Registry.INSTANCE
                .get(EmfExecutionConfigurationPackage.eNS_URI) : new EmfExecutionConfigurationPackageImpl());

        EmfExecutionConfigurationPackageImpl.isInited = true;

        // Initialize simple dependencies
        TimeModelPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theEmfExecutionConfigurationPackage.createPackageContents();

        // Initialize created meta-data
        theEmfExecutionConfigurationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theEmfExecutionConfigurationPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(EmfExecutionConfigurationPackage.eNS_URI, theEmfExecutionConfigurationPackage);
        return theEmfExecutionConfigurationPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private EmfExecutionConfigurationPackageImpl() {
        super(EmfExecutionConfigurationPackage.eNS_URI, EmfExecutionConfigurationFactory.eINSTANCE);
    }

    /**
     * Creates the meta-model objects for the package. This method is guarded to
     * have no affect on any invocation but its first. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.emfExecutionConfigurationEClass = this
                .createEClass(EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION);
        this.createEReference(this.emfExecutionConfigurationEClass,
                EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS);
        this.createEReference(this.emfExecutionConfigurationEClass,
                EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT);
        this.createEReference(this.emfExecutionConfigurationEClass,
                EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS);

        this.forcedClockMappingEClass = this.createEClass(EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING);
        this.createEReference(this.forcedClockMappingEClass,
                EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK);
        this.createEReference(this.forcedClockMappingEClass,
                EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE);

        this.importStatementEClass = this.createEClass(EmfExecutionConfigurationPackage.IMPORT_STATEMENT);
        this.createEAttribute(this.importStatementEClass, EmfExecutionConfigurationPackage.IMPORT_STATEMENT__IMPORT_URI);

        this.jarImportStatementEClass = this.createEClass(EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT);
        this.createEAttribute(this.jarImportStatementEClass,
                EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT__PATH_TO_JAR);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEMFExecutionConfiguration() {
        return this.emfExecutionConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEMFExecutionConfiguration_ForcedClockMappings() {
        return (EReference) this.emfExecutionConfigurationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEMFExecutionConfiguration_Imports() {
        return (EReference) this.emfExecutionConfigurationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEMFExecutionConfiguration_JarImportStatement() {
        return (EReference) this.emfExecutionConfigurationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EmfExecutionConfigurationFactory getEmfExecutionConfigurationFactory() {
        return (EmfExecutionConfigurationFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getForcedClockMapping() {
        return this.forcedClockMappingEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getForcedClockMapping_Clock() {
        return (EReference) this.forcedClockMappingEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getForcedClockMapping_ClockToAvoidWhenTrue() {
        return (EReference) this.forcedClockMappingEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getImportStatement() {
        return this.importStatementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getImportStatement_ImportURI() {
        return (EAttribute) this.importStatementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getJarImportStatement() {
        return this.jarImportStatementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getJarImportStatement_PathToJar() {
        return (EAttribute) this.jarImportStatementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(EmfExecutionConfigurationPackage.eNAME);
        this.setNsPrefix(EmfExecutionConfigurationPackage.eNS_PREFIX);
        this.setNsURI(EmfExecutionConfigurationPackage.eNS_URI);

        // Obtain other dependent packages
        TimeModelPackage theTimeModelPackage = (TimeModelPackage) EPackage.Registry.INSTANCE
                .getEPackage(TimeModelPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.emfExecutionConfigurationEClass, EMFExecutionConfiguration.class,
                "EMFExecutionConfiguration", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE,
                EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getEMFExecutionConfiguration_Imports(), this.getImportStatement(), null, "imports",
                null, 0, -1, EMFExecutionConfiguration.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE,
                EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES,
                !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
        this.initEReference(this.getEMFExecutionConfiguration_JarImportStatement(), this.getJarImportStatement(), null,
                "jarImportStatement", null, 0, 1, EMFExecutionConfiguration.class, !EPackageImpl.IS_TRANSIENT,
                !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE,
                !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE,
                !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
        this.initEReference(this.getEMFExecutionConfiguration_ForcedClockMappings(), this.getForcedClockMapping(),
                null, "forcedClockMappings", null, 0, -1, EMFExecutionConfiguration.class, !EPackageImpl.IS_TRANSIENT,
                !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE,
                !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE,
                !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

        this.initEClass(this.forcedClockMappingEClass, ForcedClockMapping.class, "ForcedClockMapping",
                !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getForcedClockMapping_Clock(), theTimeModelPackage.getClock(), null, "clock", null, 0,
                1, ForcedClockMapping.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE,
                EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES,
                !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
        this.initEReference(this.getForcedClockMapping_ClockToAvoidWhenTrue(), theTimeModelPackage.getClock(), null,
                "clockToAvoidWhenTrue", null, 0, 1, ForcedClockMapping.class, !EPackageImpl.IS_TRANSIENT,
                !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE,
                EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE,
                !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

        this.initEClass(this.importStatementEClass, ImportStatement.class, "ImportStatement",
                !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getImportStatement_ImportURI(), this.ecorePackage.getEString(), "importURI", null, 0,
                1, ImportStatement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE,
                EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE,
                !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

        this.initEClass(this.jarImportStatementEClass, JarImportStatement.class, "JarImportStatement",
                !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getJarImportStatement_PathToJar(), this.ecorePackage.getEString(), "pathToJar", null,
                0, 1, JarImportStatement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE,
                EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE,
                !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

        // Create resource
        this.createResource(EmfExecutionConfigurationPackage.eNS_URI);
    }

} // EmfExecutionConfigurationPackageImpl
