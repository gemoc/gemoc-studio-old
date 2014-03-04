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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Part Reference</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getTitle <em>Title</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getTitleToolTip <em>Title Tool Tip</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getId <em>Id</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#getWorkbenchPartReference()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface WorkbenchPartReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#getWorkbenchPartReference_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getTitle
	 * <em>Title</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Title Tool Tip</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title Tool Tip</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Title Tool Tip</em>' attribute.
	 * @see #setTitleToolTip(String)
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#getWorkbenchPartReference_TitleToolTip()
	 * @model
	 * @generated
	 */
	String getTitleToolTip();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getTitleToolTip
	 * <em>Title Tool Tip</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Title Tool Tip</em>' attribute.
	 * @see #getTitleToolTip()
	 * @generated
	 */
	void setTitleToolTip(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#getWorkbenchPartReference_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getId <em>Id</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#getWorkbenchPartReference_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // WorkbenchPartReference
