/**
 */
package fr.obeo.dsl.processworkspace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract
 * class of the model. <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.processworkspace.ProcessworkspacePackage
 * @generated
 */
public interface ProcessworkspaceFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ProcessworkspaceFactory eINSTANCE = fr.obeo.dsl.processworkspace.impl.ProcessworkspaceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>File Variable</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>File Variable</em>'.
	 * @generated
	 */
	FileVariable createFileVariable();

	/**
	 * Returns a new object of class '<em>Folder Variable</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Folder Variable</em>'.
	 * @generated
	 */
	FolderVariable createFolderVariable();

	/**
	 * Returns a new object of class '<em>Project Variable</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Project Variable</em>'.
	 * @generated
	 */
	ProjectVariable createProjectVariable();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProcessworkspacePackage getProcessworkspacePackage();

} // ProcessworkspaceFactory
