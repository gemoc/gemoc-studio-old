/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getImportStatement()
 * @model
 * @generated
 */
public interface ImportStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getImportStatement_ImportURI()
   * @model
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

} // ImportStatement
