/**
 *  Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 *  This software and the attached documentation are the exclusive ownership
 *  of its authors and was conceded to the profit of Obeo SARL.
 *  This software and the attached documentation are protected under the rights
 *  of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 *  By installing this software, you acknowledge being aware of this rights and
 *  accept them, and as a consequence you must:
 *  - be in possession of a valid license of use conceded by Obeo only.
 *  - agree that you have read, understood, and will comply with the license terms and conditions.
 *  - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 *  or the authors of this software
 * 
 *  Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * 
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An instance of {@link ProcessVariable}.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.process.ContextVariable#getVariableValue <em>Variable Value</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.ContextVariable#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.process.ProcessPackage#getContextVariable()
 * @model
 * @generated
 */
public interface ContextVariable extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Value</em>' attribute.
	 * @see #setVariableValue(Object)
	 * @see fr.obeo.dsl.process.ProcessPackage#getContextVariable_VariableValue()
	 * @model dataType="fr.obeo.dsl.process.Object" transient="true"
	 * @generated
	 */
	Object getVariableValue();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.ContextVariable#getVariableValue <em>Variable Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Value</em>' attribute.
	 * @see #getVariableValue()
	 * @generated
	 */
	void setVariableValue(Object value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(ProcessVariable)
	 * @see fr.obeo.dsl.process.ProcessPackage#getContextVariable_Definition()
	 * @model required="true"
	 * @generated
	 */
	ProcessVariable getDefinition();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.ContextVariable#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(ProcessVariable value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getName();

} // ContextVariable
