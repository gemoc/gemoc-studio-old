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
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getThreads <em>Threads</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getAnimationTarget()
 * @model
 * @generated
 */
public interface AnimationTarget extends EObject {
	/**
	 * Returns the value of the '<em><b>Threads</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.sirius.animation.Thread}.
	 * It is bidirectional and its opposite is '{@link fr.obeo.dsl.sirius.animation.Thread#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threads</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threads</em>' containment reference list.
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getAnimationTarget_Threads()
	 * @see fr.obeo.dsl.sirius.animation.Thread#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<fr.obeo.dsl.sirius.animation.Thread> getThreads();

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
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getAnimationTarget_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.obeo.dsl.sirius.animation.TargetState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see fr.obeo.dsl.sirius.animation.TargetState
	 * @see #setState(TargetState)
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getAnimationTarget_State()
	 * @model
	 * @generated
	 */
	TargetState getState();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.AnimationTarget#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see fr.obeo.dsl.sirius.animation.TargetState
	 * @see #getState()
	 * @generated
	 */
	void setState(TargetState value);

} // AnimationTarget
