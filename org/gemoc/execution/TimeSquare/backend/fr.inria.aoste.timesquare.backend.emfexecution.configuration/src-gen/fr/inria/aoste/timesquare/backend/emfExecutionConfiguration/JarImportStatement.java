/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jar Import Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement#getPathToJar <em>Path To Jar</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getJarImportStatement()
 * @model
 * @generated
 */
public interface JarImportStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Path To Jar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path To Jar</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path To Jar</em>' attribute.
   * @see #setPathToJar(String)
   * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getJarImportStatement_PathToJar()
   * @model
   * @generated
   */
  String getPathToJar();

  /**
   * Sets the value of the '{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement#getPathToJar <em>Path To Jar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path To Jar</em>' attribute.
   * @see #getPathToJar()
   * @generated
   */
  void setPathToJar(String value);

} // JarImportStatement
