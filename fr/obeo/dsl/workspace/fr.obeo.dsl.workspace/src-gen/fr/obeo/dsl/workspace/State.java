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
package fr.obeo.dsl.workspace;

import fr.obeo.dsl.workspace.workbench.WorkbenchRoot;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>State</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.State#getWorkspace <em>Workspace</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.State#getWorkbench <em>Workbench</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.workspace.WorkspacePackage#getState()
 * @model
 * @generated
 */
public interface State extends EObject {
	/**
	 * Returns the value of the '<em><b>Workspace</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Workspace</em>' containment reference.
	 * @see #setWorkspace(WorkspaceRoot)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getState_Workspace()
	 * @model containment="true"
	 * @generated
	 */
	WorkspaceRoot getWorkspace();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.State#getWorkspace <em>Workspace</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Workspace</em>' containment reference.
	 * @see #getWorkspace()
	 * @generated
	 */
	void setWorkspace(WorkspaceRoot value);

	/**
	 * Returns the value of the '<em><b>Workbench</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workbench</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Workbench</em>' containment reference.
	 * @see #setWorkbench(WorkbenchRoot)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getState_Workbench()
	 * @model containment="true"
	 * @generated
	 */
	WorkbenchRoot getWorkbench();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.State#getWorkbench <em>Workbench</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Workbench</em>' containment reference.
	 * @see #getWorkbench()
	 * @generated
	 */
	void setWorkbench(WorkbenchRoot value);

} // State
