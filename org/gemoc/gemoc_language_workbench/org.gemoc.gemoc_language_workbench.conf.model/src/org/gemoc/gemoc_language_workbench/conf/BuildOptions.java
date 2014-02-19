/**
 */
package org.gemoc.gemoc_language_workbench.conf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Build Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.BuildOptions#isGenerateModelLoaderService <em>Generate Model Loader Service</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.BuildOptions#isGenerateCodeExecutorService <em>Generate Code Executor Service</em>}</li>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.BuildOptions#isGenerateQVTOFromECL <em>Generate QVTO From ECL</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getBuildOptions()
 * @model
 * @generated
 */
public interface BuildOptions extends EObject {
	/**
	 * Returns the value of the '<em><b>Generate Model Loader Service</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Model Loader Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Model Loader Service</em>' attribute.
	 * @see #setGenerateModelLoaderService(boolean)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getBuildOptions_GenerateModelLoaderService()
	 * @model default="true"
	 * @generated
	 */
	boolean isGenerateModelLoaderService();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.BuildOptions#isGenerateModelLoaderService <em>Generate Model Loader Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Model Loader Service</em>' attribute.
	 * @see #isGenerateModelLoaderService()
	 * @generated
	 */
	void setGenerateModelLoaderService(boolean value);

	/**
	 * Returns the value of the '<em><b>Generate Code Executor Service</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate Code Executor Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Code Executor Service</em>' attribute.
	 * @see #setGenerateCodeExecutorService(boolean)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getBuildOptions_GenerateCodeExecutorService()
	 * @model default="true"
	 * @generated
	 */
	boolean isGenerateCodeExecutorService();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.BuildOptions#isGenerateCodeExecutorService <em>Generate Code Executor Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Code Executor Service</em>' attribute.
	 * @see #isGenerateCodeExecutorService()
	 * @generated
	 */
	void setGenerateCodeExecutorService(boolean value);

	/**
	 * Returns the value of the '<em><b>Generate QVTO From ECL</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generate QVTO From ECL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate QVTO From ECL</em>' attribute.
	 * @see #setGenerateQVTOFromECL(boolean)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getBuildOptions_GenerateQVTOFromECL()
	 * @model default="true"
	 * @generated
	 */
	boolean isGenerateQVTOFromECL();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.BuildOptions#isGenerateQVTOFromECL <em>Generate QVTO From ECL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate QVTO From ECL</em>' attribute.
	 * @see #isGenerateQVTOFromECL()
	 * @generated
	 */
	void setGenerateQVTOFromECL(boolean value);

} // BuildOptions
