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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Root</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.workbench.WorkbenchRoot#getWindows <em>Windows</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.workbench.WorkbenchRoot#getActiveWindow <em>Active Window</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#getWorkbenchRoot()
 * @model
 * @generated
 */
public interface WorkbenchRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Windows</b></em>' containment reference list. The list contents are of
	 * type {@link fr.obeo.dsl.workspace.workbench.WorkbenchWindow}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Windows</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Windows</em>' containment reference list.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#getWorkbenchRoot_Windows()
	 * @model containment="true"
	 * @generated
	 */
	EList<WorkbenchWindow> getWindows();

	/**
	 * Returns the value of the '<em><b>Active Window</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Window</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Active Window</em>' reference.
	 * @see #setActiveWindow(WorkbenchWindow)
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#getWorkbenchRoot_ActiveWindow()
	 * @model
	 * @generated
	 */
	WorkbenchWindow getActiveWindow();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.workbench.WorkbenchRoot#getActiveWindow
	 * <em>Active Window</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Active Window</em>' reference.
	 * @see #getActiveWindow()
	 * @generated
	 */
	void setActiveWindow(WorkbenchWindow value);

} // WorkbenchRoot
