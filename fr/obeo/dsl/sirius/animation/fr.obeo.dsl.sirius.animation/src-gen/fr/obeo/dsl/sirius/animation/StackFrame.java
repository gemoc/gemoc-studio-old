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
 * A representation of the model object '<em><b>Stack Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animation.StackFrame#getVariables <em>Variables</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.StackFrame#getSubFrames <em>Sub Frames</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.StackFrame#getState <em>State</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.StackFrame#getParent <em>Parent</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.StackFrame#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.StackFrame#getData <em>Data</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.StackFrame#getSourceElement <em>Source Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getStackFrame()
 * @model
 * @generated
 */
public interface StackFrame extends EObject {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.sirius.animation.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getStackFrame_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Sub Frames</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.sirius.animation.StackFrame}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Frames</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Frames</em>' containment reference list.
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getStackFrame_SubFrames()
	 * @model containment="true"
	 * @generated
	 */
	EList<StackFrame> getSubFrames();

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.obeo.dsl.sirius.animation.StackFrameState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see fr.obeo.dsl.sirius.animation.StackFrameState
	 * @see #setState(StackFrameState)
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getStackFrame_State()
	 * @model
	 * @generated
	 */
	StackFrameState getState();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.StackFrame#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see fr.obeo.dsl.sirius.animation.StackFrameState
	 * @see #getState()
	 * @generated
	 */
	void setState(StackFrameState value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.obeo.dsl.sirius.animation.Thread#getStackFrames <em>Stack Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(fr.obeo.dsl.sirius.animation.Thread)
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getStackFrame_Parent()
	 * @see fr.obeo.dsl.sirius.animation.Thread#getStackFrames
	 * @model opposite="stackFrames" transient="false"
	 * @generated
	 */
	fr.obeo.dsl.sirius.animation.Thread getParent();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.StackFrame#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(fr.obeo.dsl.sirius.animation.Thread value);

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
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getStackFrame_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.StackFrame#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getStackFrame_Data()
	 * @model containment="true"
	 * @generated
	 */
	EObject getData();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.StackFrame#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(EObject value);

	/**
	 * Returns the value of the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Element</em>' reference.
	 * @see #setSourceElement(EObject)
	 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getStackFrame_SourceElement()
	 * @model
	 * @generated
	 */
	EObject getSourceElement();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.StackFrame#getSourceElement <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Element</em>' reference.
	 * @see #getSourceElement()
	 * @generated
	 */
	void setSourceElement(EObject value);

} // StackFrame
