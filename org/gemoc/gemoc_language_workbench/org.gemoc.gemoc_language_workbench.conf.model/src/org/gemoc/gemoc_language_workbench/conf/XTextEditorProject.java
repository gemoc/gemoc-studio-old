/**
 */
package org.gemoc.gemoc_language_workbench.conf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XText Editor Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.gemoc_language_workbench.conf.XTextEditorProject#getGrammarName <em>Grammar Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getXTextEditorProject()
 * @model
 * @generated
 */
public interface XTextEditorProject extends EditorProject {

	/**
	 * Returns the value of the '<em><b>Grammar Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grammar Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grammar Name</em>' attribute.
	 * @see #setGrammarName(String)
	 * @see org.gemoc.gemoc_language_workbench.conf.confPackage#getXTextEditorProject_GrammarName()
	 * @model required="true"
	 * @generated
	 */
	String getGrammarName();

	/**
	 * Sets the value of the '{@link org.gemoc.gemoc_language_workbench.conf.XTextEditorProject#getGrammarName <em>Grammar Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammar Name</em>' attribute.
	 * @see #getGrammarName()
	 * @generated
	 */
	void setGrammarName(String value);
} // XTextEditorProject
