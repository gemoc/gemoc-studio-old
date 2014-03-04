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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Dependency</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.Dependency#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.workspace.WorkspacePackage#getDependency()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Dependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project</em>' reference.
	 * @see #setProject(Project)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getDependency_Project()
	 * @model
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.Dependency#getProject <em>Project</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Project</em>' reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

} // Dependency
