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
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.DSAProject#getEntryPoint <em>Entry Point</em>}</li>
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
	 * <!-- begin-model-doc -->
	 * URI of the class that implement the code excutor required by the engine.
	 * If null or empty, a default K3 code executor will be generated and used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code Executor Class</em>' attribute.
	 * @see #setCodeExecutorClass(String)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getDSAProject_CodeExecutorClass()
	 * @model
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

	/**
	 * Returns the value of the '<em><b>Entry Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Point</em>' attribute.
	 * @see #setEntryPoint(String)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getDSAProject_EntryPoint()
	 * @model
	 * @generated
	 */
	String getEntryPoint();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.DSAProject#getEntryPoint <em>Entry Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Point</em>' attribute.
	 * @see #getEntryPoint()
	 * @generated
	 */
	void setEntryPoint(String value);
} // DSAProject
