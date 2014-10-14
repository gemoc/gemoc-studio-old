/**
 */
package org.gemoc.gemoc_language_workbench.conf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSA Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.DSAProject#getCodeExecutorClass <em>Code Executor Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getDSAProject()
 * @model
 * @generated
 */
public interface DSAProject extends ProjectResource {

	/**
	 * Returns the value of the '<em><b>Code Executor Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code Executor Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code Executor Class</em>' attribute.
	 * @see #setCodeExecutorClass(String)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getDSAProject_CodeExecutorClass()
	 * @model required="true"
	 * @generated
	 */
	String getCodeExecutorClass();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.DSAProject#getCodeExecutorClass <em>Code Executor Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code Executor Class</em>' attribute.
	 * @see #getCodeExecutorClass()
	 * @generated
	 */
	void setCodeExecutorClass(String value);
} // DSAProject
