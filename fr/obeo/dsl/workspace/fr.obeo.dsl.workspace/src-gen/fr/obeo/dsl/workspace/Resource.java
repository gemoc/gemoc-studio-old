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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Resource</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.Resource#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.Resource#getFullpath <em>Fullpath</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.workspace.WorkspacePackage#getResource()
 * @model abstract="true"
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getResource_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.Resource#getName <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Fullpath</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fullpath</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fullpath</em>' attribute.
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getResource_Fullpath()
	 * @model changeable="false"
	 * @generated
	 */
	String getFullpath();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link fr.obeo.dsl.workspace.Container#getMembers <em>Members</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Container)
	 * @see fr.obeo.dsl.workspace.WorkspacePackage#getResource_Parent()
	 * @see fr.obeo.dsl.workspace.Container#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 */
	Container getParent();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.Resource#getParent <em>Parent</em>}' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Container value);

} // Resource
