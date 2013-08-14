/**
 */
package gemoc_language_designer_conf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gemoc_language_designer_conf.LanguageDefinition#getDsaProjects <em>Dsa Projects</em>}</li>
 *   <li>{@link gemoc_language_designer_conf.LanguageDefinition#getDomainModelProject <em>Domain Model Project</em>}</li>
 *   <li>{@link gemoc_language_designer_conf.LanguageDefinition#getEditorProjects <em>Editor Projects</em>}</li>
 *   <li>{@link gemoc_language_designer_conf.LanguageDefinition#getMoCModelProjects <em>Mo CModel Projects</em>}</li>
 *   <li>{@link gemoc_language_designer_conf.LanguageDefinition#getAnimatorProjects <em>Animator Projects</em>}</li>
 *   <li>{@link gemoc_language_designer_conf.LanguageDefinition#getDSEProjects <em>DSE Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getLanguageDefinition()
 * @model
 * @generated
 */
public interface LanguageDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Dsa Projects</b></em>' containment reference list.
	 * The list contents are of type {@link gemoc_language_designer_conf.DSAProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dsa Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dsa Projects</em>' containment reference list.
	 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getLanguageDefinition_DsaProjects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DSAProject> getDsaProjects();

	/**
	 * Returns the value of the '<em><b>Domain Model Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Model Project</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Model Project</em>' containment reference.
	 * @see #setDomainModelProject(DomainModelProject)
	 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getLanguageDefinition_DomainModelProject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DomainModelProject getDomainModelProject();

	/**
	 * Sets the value of the '{@link gemoc_language_designer_conf.LanguageDefinition#getDomainModelProject <em>Domain Model Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Model Project</em>' containment reference.
	 * @see #getDomainModelProject()
	 * @generated
	 */
	void setDomainModelProject(DomainModelProject value);

	/**
	 * Returns the value of the '<em><b>Editor Projects</b></em>' containment reference list.
	 * The list contents are of type {@link gemoc_language_designer_conf.EditorProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor Projects</em>' containment reference list.
	 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getLanguageDefinition_EditorProjects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EditorProject> getEditorProjects();

	/**
	 * Returns the value of the '<em><b>Mo CModel Projects</b></em>' containment reference list.
	 * The list contents are of type {@link gemoc_language_designer_conf.MoCProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mo CModel Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mo CModel Projects</em>' containment reference list.
	 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getLanguageDefinition_MoCModelProjects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MoCProject> getMoCModelProjects();

	/**
	 * Returns the value of the '<em><b>Animator Projects</b></em>' containment reference list.
	 * The list contents are of type {@link gemoc_language_designer_conf.AnimatorProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animator Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animator Projects</em>' containment reference list.
	 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getLanguageDefinition_AnimatorProjects()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AnimatorProject> getAnimatorProjects();

	/**
	 * Returns the value of the '<em><b>DSE Projects</b></em>' containment reference list.
	 * The list contents are of type {@link gemoc_language_designer_conf.DSEProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSE Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSE Projects</em>' containment reference list.
	 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#getLanguageDefinition_DSEProjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<DSEProject> getDSEProjects();

} // LanguageDefinition
