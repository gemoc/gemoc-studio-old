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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Project</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.Project#getNatureId <em>Nature Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.workspace.WorkspacePackage#getProject()
 * @model
 * @generated
 */
public interface Project extends Container {
	/**
	 * Returns the value of the '<em><b>Nature Id</b></em>' attribute list. The list contents are of type
	 * {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nature Id</em>' attribute list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Nature Id</em>' attribute list.
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getProject_NatureId()
	 * @model
	 * @generated
	 */
	EList<String> getNatureId();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list. The list contents
	 * are of type {@link fr.obeo.dsl.workspace.Dependency}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getProject_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dependency> getDependencies();

} // Project
