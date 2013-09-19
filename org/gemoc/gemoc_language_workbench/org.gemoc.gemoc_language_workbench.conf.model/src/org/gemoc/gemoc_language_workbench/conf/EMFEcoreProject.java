/**
 */
package org.gemoc.gemoc_language_workbench.conf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMF Ecore Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject#getEmfGenmodel <em>Emf Genmodel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getEMFEcoreProject()
 * @model
 * @generated
 */
public interface EMFEcoreProject extends DomainModelProject {
	/**
	 * Returns the value of the '<em><b>Emf Genmodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emf Genmodel</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Emf Genmodel</em>' containment reference.
	 * @see #setEmfGenmodel(EMFGenmodel)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getEMFEcoreProject_EmfGenmodel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EMFGenmodel getEmfGenmodel();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject#getEmfGenmodel <em>Emf Genmodel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emf Genmodel</em>' containment reference.
	 * @see #getEmfGenmodel()
	 * @generated
	 */
	void setEmfGenmodel(EMFGenmodel value);

} // EMFEcoreProject
