/**
 */
package org.gemoc.gemoc_language_workbench.conf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage
 * @generated
 */
public interface confFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	confFactory eINSTANCE = org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Language Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Language Definition</em>'.
	 * @generated
	 */
	LanguageDefinition createLanguageDefinition();

	/**
	 * Returns a new object of class '<em>DSA Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSA Project</em>'.
	 * @generated
	 */
	DSAProject createDSAProject();

	/**
	 * Returns a new object of class '<em>Domain Model Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Model Project</em>'.
	 * @generated
	 */
	DomainModelProject createDomainModelProject();

	/**
	 * Returns a new object of class '<em>Mo CC Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mo CC Project</em>'.
	 * @generated
	 */
	MoCCProject createMoCCProject();

	/**
	 * Returns a new object of class '<em>DSE Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>DSE Project</em>'.
	 * @generated
	 */
	DSEProject createDSEProject();

	/**
	 * Returns a new object of class '<em>Sirius Editor Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sirius Editor Project</em>'.
	 * @generated
	 */
	SiriusEditorProject createSiriusEditorProject();

	/**
	 * Returns a new object of class '<em>Sirius Animator Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sirius Animator Project</em>'.
	 * @generated
	 */
	SiriusAnimatorProject createSiriusAnimatorProject();

	/**
	 * Returns a new object of class '<em>XText Editor Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XText Editor Project</em>'.
	 * @generated
	 */
	XTextEditorProject createXTextEditorProject();

	/**
	 * Returns a new object of class '<em>Tree Editor Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree Editor Project</em>'.
	 * @generated
	 */
	TreeEditorProject createTreeEditorProject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	confPackage getconfPackage();

} //confFactory
