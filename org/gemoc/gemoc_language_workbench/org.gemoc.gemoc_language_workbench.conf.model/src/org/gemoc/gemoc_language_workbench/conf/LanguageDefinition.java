/**
 */
package org.gemoc.gemoc_language_workbench.conf;

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
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDsaProject <em>Dsa Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDomainModelProject <em>Domain Model Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getEditorProjects <em>Editor Projects</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMoCCProject <em>Mo CC Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getAnimatorProjects <em>Animator Projects</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDSEProject <em>DSE Project</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMelangeURI <em>Melange URI</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#isNeedMelangeSynchronization <em>Need Melange Synchronization</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getLanguageKind <em>Language Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition()
 * @model
 * @generated
 */
public interface LanguageDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Dsa Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dsa Project</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dsa Project</em>' containment reference.
	 * @see #setDsaProject(DSAProject)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_DsaProject()
	 * @model containment="true"
	 * @generated
	 */
	DSAProject getDsaProject();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDsaProject <em>Dsa Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dsa Project</em>' containment reference.
	 * @see #getDsaProject()
	 * @generated
	 */
	void setDsaProject(DSAProject value);

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
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_DomainModelProject()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DomainModelProject getDomainModelProject();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDomainModelProject <em>Domain Model Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Model Project</em>' containment reference.
	 * @see #getDomainModelProject()
	 * @generated
	 */
	void setDomainModelProject(DomainModelProject value);

	/**
	 * Returns the value of the '<em><b>Editor Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.gemoc_language_workbench.conf.EditorProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor Projects</em>' containment reference list.
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_EditorProjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<EditorProject> getEditorProjects();

	/**
	 * Returns the value of the '<em><b>Mo CC Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mo CC Project</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mo CC Project</em>' containment reference.
	 * @see #setMoCCProject(MoCCProject)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_MoCCProject()
	 * @model containment="true"
	 * @generated
	 */
	MoCCProject getMoCCProject();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMoCCProject <em>Mo CC Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mo CC Project</em>' containment reference.
	 * @see #getMoCCProject()
	 * @generated
	 */
	void setMoCCProject(MoCCProject value);

	/**
	 * Returns the value of the '<em><b>Animator Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.gemoc_language_workbench.conf.AnimatorProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animator Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animator Projects</em>' containment reference list.
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_AnimatorProjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnimatorProject> getAnimatorProjects();

	/**
	 * Returns the value of the '<em><b>DSE Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>DSE Project</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>DSE Project</em>' containment reference.
	 * @see #setDSEProject(DSEProject)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_DSEProject()
	 * @model containment="true"
	 * @generated
	 */
	DSEProject getDSEProject();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDSEProject <em>DSE Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DSE Project</em>' containment reference.
	 * @see #getDSEProject()
	 * @generated
	 */
	void setDSEProject(DSEProject value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Melange URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Melange URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Melange URI</em>' attribute.
	 * @see #setMelangeURI(String)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_MelangeURI()
	 * @model
	 * @generated
	 */
	String getMelangeURI();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMelangeURI <em>Melange URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Melange URI</em>' attribute.
	 * @see #getMelangeURI()
	 * @generated
	 */
	void setMelangeURI(String value);

	/**
	 * Returns the value of the '<em><b>Need Melange Synchronization</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Need Melange Synchronization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Need Melange Synchronization</em>' attribute.
	 * @see #setNeedMelangeSynchronization(boolean)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_NeedMelangeSynchronization()
	 * @model default="false"
	 * @generated
	 */
	boolean isNeedMelangeSynchronization();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#isNeedMelangeSynchronization <em>Need Melange Synchronization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Need Melange Synchronization</em>' attribute.
	 * @see #isNeedMelangeSynchronization()
	 * @generated
	 */
	void setNeedMelangeSynchronization(boolean value);

	/**
	 * Returns the value of the '<em><b>Language Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.gemoc_language_workbench.conf.LanguageKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Kind</em>' attribute.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageKind
	 * @see #setLanguageKind(LanguageKind)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getLanguageDefinition_LanguageKind()
	 * @model
	 * @generated
	 */
	LanguageKind getLanguageKind();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getLanguageKind <em>Language Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Kind</em>' attribute.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageKind
	 * @see #getLanguageKind()
	 * @generated
	 */
	void setLanguageKind(LanguageKind value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Provides a convenient access to all file extensions declared. This includes both the files extensions declared in the genmodel of the DomainModelProject and the ones declared in the editors
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<String> getFileExtensions();

} // LanguageDefinition
