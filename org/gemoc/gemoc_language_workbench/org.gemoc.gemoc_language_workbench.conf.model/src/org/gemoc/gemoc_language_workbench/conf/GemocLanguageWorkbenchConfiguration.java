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
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration#getLanguageDefinitions <em>Language Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getGemocLanguageWorkbenchConfiguration()
 * @model
 * @generated
 */
public interface GemocLanguageWorkbenchConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Language Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Definitions</em>' containment reference list.
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getGemocLanguageWorkbenchConfiguration_LanguageDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<LanguageDefinition> getLanguageDefinitions();

} // GemocLanguageWorkbenchConfiguration
