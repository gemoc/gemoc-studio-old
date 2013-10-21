/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationFactory;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmfExecutionConfigurationPackageImpl extends EPackageImpl implements EmfExecutionConfigurationPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass emfExecutionConfigurationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forcedClockMappingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass jarImportStatementEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EmfExecutionConfigurationPackageImpl()
  {
    super(eNS_URI, EmfExecutionConfigurationFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link EmfExecutionConfigurationPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EmfExecutionConfigurationPackage init()
  {
    if (isInited) return (EmfExecutionConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(EmfExecutionConfigurationPackage.eNS_URI);

    // Obtain or create and register package
    EmfExecutionConfigurationPackageImpl theEmfExecutionConfigurationPackage = (EmfExecutionConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EmfExecutionConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EmfExecutionConfigurationPackageImpl());

    isInited = true;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEMFExecutionConfiguration()
  {
    return emfExecutionConfigurationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMFExecutionConfiguration_Imports()
  {
    return (EReference)emfExecutionConfigurationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMFExecutionConfiguration_JarImportStatement()
  {
    return (EReference)emfExecutionConfigurationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEMFExecutionConfiguration_ForcedClockMappings()
  {
    return (EReference)emfExecutionConfigurationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForcedClockMapping()
  {
    return forcedClockMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForcedClockMapping_Clock()
  {
    return (EReference)forcedClockMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForcedClockMapping_ClockToAvoidWhenTrue()
  {
    return (EReference)forcedClockMappingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImportStatement()
  {
    return importStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImportStatement_ImportURI()
  {
    return (EAttribute)importStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJarImportStatement()
  {
    return jarImportStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJarImportStatement_PathToJar()
  {
    return (EAttribute)jarImportStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmfExecutionConfigurationFactory getEmfExecutionConfigurationFactory()
  {
    return (EmfExecutionConfigurationFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    emfExecutionConfigurationEClass = createEClass(EMF_EXECUTION_CONFIGURATION);
    createEReference(emfExecutionConfigurationEClass, EMF_EXECUTION_CONFIGURATION__IMPORTS);
    createEReference(emfExecutionConfigurationEClass, EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT);
    createEReference(emfExecutionConfigurationEClass, EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS);

    forcedClockMappingEClass = createEClass(FORCED_CLOCK_MAPPING);
    createEReference(forcedClockMappingEClass, FORCED_CLOCK_MAPPING__CLOCK);
    createEReference(forcedClockMappingEClass, FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE);

    importStatementEClass = createEClass(IMPORT_STATEMENT);
    createEAttribute(importStatementEClass, IMPORT_STATEMENT__IMPORT_URI);

    jarImportStatementEClass = createEClass(JAR_IMPORT_STATEMENT);
    createEAttribute(jarImportStatementEClass, JAR_IMPORT_STATEMENT__PATH_TO_JAR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    TimeModelPackage theTimeModelPackage = (TimeModelPackage)EPackage.Registry.INSTANCE.getEPackage(TimeModelPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(emfExecutionConfigurationEClass, EMFExecutionConfiguration.class, "EMFExecutionConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEMFExecutionConfiguration_Imports(), this.getImportStatement(), null, "imports", null, 0, -1, EMFExecutionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMFExecutionConfiguration_JarImportStatement(), this.getJarImportStatement(), null, "jarImportStatement", null, 0, 1, EMFExecutionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEMFExecutionConfiguration_ForcedClockMappings(), this.getForcedClockMapping(), null, "forcedClockMappings", null, 0, -1, EMFExecutionConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forcedClockMappingEClass, ForcedClockMapping.class, "ForcedClockMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForcedClockMapping_Clock(), theTimeModelPackage.getClock(), null, "clock", null, 0, 1, ForcedClockMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForcedClockMapping_ClockToAvoidWhenTrue(), theTimeModelPackage.getClock(), null, "clockToAvoidWhenTrue", null, 0, 1, ForcedClockMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importStatementEClass, ImportStatement.class, "ImportStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImportStatement_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, ImportStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(jarImportStatementEClass, JarImportStatement.class, "JarImportStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJarImportStatement_PathToJar(), ecorePackage.getEString(), "pathToJar", null, 0, 1, JarImportStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //EmfExecutionConfigurationPackageImpl
