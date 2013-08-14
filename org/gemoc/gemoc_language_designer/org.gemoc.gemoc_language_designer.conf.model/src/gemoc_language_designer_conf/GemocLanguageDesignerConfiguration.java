/**
 */
package gemoc_language_designer_conf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gemoc Language Designer Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gemoc_language_designer_conf.GemocLanguageDesignerConfiguration#getLanguageDefinitions <em>Language Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getGemocLanguageDesignerConfiguration()
 * @model
 * @generated
 */
public interface GemocLanguageDesignerConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Language Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link gemoc_language_designer_conf.LanguageDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Definitions</em>' containment reference list.
	 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getGemocLanguageDesignerConfiguration_LanguageDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<LanguageDefinition> getLanguageDefinitions();

} // GemocLanguageDesignerConfiguration
