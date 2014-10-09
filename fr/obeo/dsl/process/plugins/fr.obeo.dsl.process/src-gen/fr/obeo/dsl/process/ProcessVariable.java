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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variable</b></em>'. <!-- end-user-doc
 * --> <!-- begin-model-doc --> A variable in the Process wich can be produced or consummed by Tasks. <!--
 * end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.ProcessVariable#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getProcessVariable()
 * @model
 * @generated
 */
public interface ProcessVariable extends EObject {
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
	 * @see fr.obeo.dsl.process.ProcessPackage#getProcessVariable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.ProcessVariable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Written By</b></em>' reference list. The list contents are of type
	 * {@link fr.obeo.dsl.process.ActionTask}. It is bidirectional and its opposite is '
	 * {@link fr.obeo.dsl.process.ActionTask#getWrittenVariables <em>Written Variables</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> {@link ActionTask} writing this
	 * variable. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Written By</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getProcessVariable_WrittenBy()
	 * @see fr.obeo.dsl.process.ActionTask#getWrittenVariables
	 * @model opposite="writtenVariables"
	 * @generated
	 */
	EList<ActionTask> getWrittenBy();

	/**
	 * Returns the value of the '<em><b>Observed By</b></em>' reference list. The list contents are of type
	 * {@link fr.obeo.dsl.process.ActionTask}. It is bidirectional and its opposite is '
	 * {@link fr.obeo.dsl.process.ActionTask#getObservedVariables <em>Observed Variables</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> {@link ActionTask} observing this
	 * variable. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Observed By</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getProcessVariable_ObservedBy()
	 * @see fr.obeo.dsl.process.ActionTask#getObservedVariables
	 * @model opposite="observedVariables"
	 * @generated
	 */
	EList<ActionTask> getObservedBy();

} // ProcessVariable
