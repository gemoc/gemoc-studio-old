/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMF Execution Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getImports <em>Imports</em>}</li>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getJarImportStatement <em>Jar Import Statement</em>}</li>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getForcedClockMappings <em>Forced Clock Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getEMFExecutionConfiguration()
 * @model
 * @generated
 */
public interface EMFExecutionConfiguration extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getEMFExecutionConfiguration_Imports()
   * @model containment="true"
   * @generated
   */
  EList<ImportStatement> getImports();

  /**
   * Returns the value of the '<em><b>Jar Import Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jar Import Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Jar Import Statement</em>' containment reference.
   * @see #setJarImportStatement(JarImportStatement)
   * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getEMFExecutionConfiguration_JarImportStatement()
   * @model containment="true"
   * @generated
   */
  JarImportStatement getJarImportStatement();

  /**
   * Sets the value of the '{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration#getJarImportStatement <em>Jar Import Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Jar Import Statement</em>' containment reference.
   * @see #getJarImportStatement()
   * @generated
   */
  void setJarImportStatement(JarImportStatement value);

  /**
   * Returns the value of the '<em><b>Forced Clock Mappings</b></em>' containment reference list.
   * The list contents are of type {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Forced Clock Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Forced Clock Mappings</em>' containment reference list.
   * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getEMFExecutionConfiguration_ForcedClockMappings()
   * @model containment="true"
   * @generated
   */
  EList<ForcedClockMapping> getForcedClockMappings();

} // EMFExecutionConfiguration
