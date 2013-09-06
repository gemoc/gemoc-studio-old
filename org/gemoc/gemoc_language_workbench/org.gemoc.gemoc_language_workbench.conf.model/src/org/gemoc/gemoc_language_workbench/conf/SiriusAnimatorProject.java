/**
 */
package org.gemoc.gemoc_language_workbench.conf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sirius Animator Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject#getODProject <em>OD Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getSiriusAnimatorProject()
 * @model
 * @generated
 */
public interface SiriusAnimatorProject extends AnimatorProject {
	/**
	 * Returns the value of the '<em><b>OD Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>OD Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>OD Project</em>' reference.
	 * @see #setODProject(ODProject)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getSiriusAnimatorProject_ODProject()
	 * @model required="true"
	 * @generated
	 */
	ODProject getODProject();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject#getODProject <em>OD Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>OD Project</em>' reference.
	 * @see #getODProject()
	 * @generated
	 */
	void setODProject(ODProject value);

} // SiriusAnimatorProject
