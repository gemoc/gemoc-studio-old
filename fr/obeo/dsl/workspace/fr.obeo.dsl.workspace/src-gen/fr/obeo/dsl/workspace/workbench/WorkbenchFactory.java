/**
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 */
package fr.obeo.dsl.workspace.workbench;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract
 * class of the model. <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage
 * @generated
 */
public interface WorkbenchFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	WorkbenchFactory eINSTANCE = fr.obeo.dsl.workspace.workbench.impl.WorkbenchFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	WorkbenchRoot createWorkbenchRoot();

	/**
	 * Returns a new object of class '<em>Window</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Window</em>'.
	 * @generated
	 */
	WorkbenchWindow createWorkbenchWindow();

	/**
	 * Returns a new object of class '<em>Page</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Page</em>'.
	 * @generated
	 */
	WorkbenchPage createWorkbenchPage();

	/**
	 * Returns a new object of class '<em>Editor Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Editor Reference</em>'.
	 * @generated
	 */
	EditorReference createEditorReference();

	/**
	 * Returns a new object of class '<em>View Reference</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>View Reference</em>'.
	 * @generated
	 */
	ViewReference createViewReference();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	WorkbenchPackage getWorkbenchPackage();

} // WorkbenchFactory
