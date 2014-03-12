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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Container</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.Container#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.workspace.WorkspacePackage#getContainer()
 * @model abstract="true"
 * @generated
 */
public interface Container extends Resource {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list. The list contents are of
	 * type {@link fr.obeo.dsl.workspace.Resource}. It is bidirectional and its opposite is '
	 * {@link fr.obeo.dsl.workspace.Resource#getParent <em>Parent</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getContainer_Members()
	 * @see fr.obeo.dsl.workspace.Resource#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Resource> getMembers();

} // Container
