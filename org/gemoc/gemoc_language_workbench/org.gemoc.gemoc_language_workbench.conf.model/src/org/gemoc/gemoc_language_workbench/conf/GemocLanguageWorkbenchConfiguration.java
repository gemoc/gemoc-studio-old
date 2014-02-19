/**
 */
package org.gemoc.gemoc_language_workbench.conf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gemoc Language Workbench Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration#getLanguageDefinition <em>Language Definition</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration#getBuildOptions <em>Build Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getGemocLanguageWorkbenchConfiguration()
 * @model
 * @generated
 */
public interface GemocLanguageWorkbenchConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Language Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Definition</em>' containment reference.
	 * @see #setLanguageDefinition(LanguageDefinition)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getGemocLanguageWorkbenchConfiguration_LanguageDefinition()
	 * @model containment="true"
	 * @generated
	 */
	LanguageDefinition getLanguageDefinition();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration#getLanguageDefinition <em>Language Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Definition</em>' containment reference.
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	void setLanguageDefinition(LanguageDefinition value);

	/**
	 * Returns the value of the '<em><b>Build Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Options</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build Options</em>' containment reference.
	 * @see #setBuildOptions(BuildOptions)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getGemocLanguageWorkbenchConfiguration_BuildOptions()
	 * @model containment="true"
	 * @generated
	 */
	BuildOptions getBuildOptions();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration#getBuildOptions <em>Build Options</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Options</em>' containment reference.
	 * @see #getBuildOptions()
	 * @generated
	 */
	void setBuildOptions(BuildOptions value);

} // GemocLanguageWorkbenchConfiguration
