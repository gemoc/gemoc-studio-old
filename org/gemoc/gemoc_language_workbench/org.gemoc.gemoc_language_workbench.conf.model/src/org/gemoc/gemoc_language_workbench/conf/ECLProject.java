/**
 */
package org.gemoc.gemoc_language_workbench.conf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ECL Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.ECLProject#getEclFile <em>Ecl File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getECLProject()
 * @model
 * @generated
 */
public interface ECLProject extends DSEProject {

	/**
	 * Returns the value of the '<em><b>Ecl File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecl File</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecl File</em>' containment reference.
	 * @see #setEclFile(ECLFile)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getECLProject_EclFile()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ECLFile getEclFile();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.ECLProject#getEclFile <em>Ecl File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecl File</em>' containment reference.
	 * @see #getEclFile()
	 * @generated
	 */
	void setEclFile(ECLFile value);
} // ECLProject
