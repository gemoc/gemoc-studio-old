/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmfExecutionConfigurationFactoryImpl extends EFactoryImpl implements EmfExecutionConfigurationFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EmfExecutionConfigurationFactory init()
  {
    try
    {
      EmfExecutionConfigurationFactory theEmfExecutionConfigurationFactory = (EmfExecutionConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(EmfExecutionConfigurationPackage.eNS_URI);
      if (theEmfExecutionConfigurationFactory != null)
      {
        return theEmfExecutionConfigurationFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EmfExecutionConfigurationFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmfExecutionConfigurationFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION: return createEMFExecutionConfiguration();
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING: return createForcedClockMapping();
      case EmfExecutionConfigurationPackage.IMPORT_STATEMENT: return createImportStatement();
      case EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT: return createJarImportStatement();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMFExecutionConfiguration createEMFExecutionConfiguration()
  {
    EMFExecutionConfigurationImpl emfExecutionConfiguration = new EMFExecutionConfigurationImpl();
    return emfExecutionConfiguration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForcedClockMapping createForcedClockMapping()
  {
    ForcedClockMappingImpl forcedClockMapping = new ForcedClockMappingImpl();
    return forcedClockMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportStatement createImportStatement()
  {
    ImportStatementImpl importStatement = new ImportStatementImpl();
    return importStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JarImportStatement createJarImportStatement()
  {
    JarImportStatementImpl jarImportStatement = new JarImportStatementImpl();
    return jarImportStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EmfExecutionConfigurationPackage getEmfExecutionConfigurationPackage()
  {
    return (EmfExecutionConfigurationPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EmfExecutionConfigurationPackage getPackage()
  {
    return EmfExecutionConfigurationPackage.eINSTANCE;
  }

} //EmfExecutionConfigurationFactoryImpl
