/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animation.Thread#getStackFrames <em>Stack Frames</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.Thread#getTopStackFrame <em>Top Stack Frame</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.Thread#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.Thread#getParent <em>Parent</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.Thread#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getThread()
 * @model
 * @generated
 */
public interface Thread extends EObject {
	/**
	 * Returns the value of the '<em><b>Stack Frames</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.sirius.animation.StackFrame}.
	 * It is bidirectional and its opposite is '{@link fr.obeo.dsl.sirius.animation.StackFrame#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stack Frames</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stack Frames</em>' containment reference list.
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getThread_StackFrames()
	 * @see fr.obeo.dsl.sirius.animation.StackFrame#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<StackFrame> getStackFrames();

	/**
	 * Returns the value of the '<em><b>Top Stack Frame</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Stack Frame</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Stack Frame</em>' reference.
	 * @see #setTopStackFrame(StackFrame)
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getThread_TopStackFrame()
	 * @model
	 * @generated
	 */
	StackFrame getTopStackFrame();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.Thread#getTopStackFrame <em>Top Stack Frame</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Stack Frame</em>' reference.
	 * @see #getTopStackFrame()
	 * @generated
	 */
	void setTopStackFrame(StackFrame value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getThread_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.Thread#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getThreads <em>Threads</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(AnimationTarget)
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getThread_Parent()
	 * @see fr.obeo.dsl.sirius.animation.AnimationTarget#getThreads
	 * @model opposite="threads" transient="false"
	 * @generated
	 */
	AnimationTarget getParent();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.Thread#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(AnimationTarget value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(EObject)
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getThread_Data()
	 * @model containment="true"
	 * @generated
	 */
	EObject getData();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.Thread#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(EObject value);

} // Thread
