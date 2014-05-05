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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>One Done</b></em>'. <!-- end-user-doc
 * --> <!-- begin-model-doc --> {@link AnyDone#check() Checks} returns <code>true</code> if one and only one
 * of its {@link AnyDone#getTasks() tasks} is
 * {@link fr.obeo.dsl.process.ProcessUtils#isDone(ProcessContext, Task) done}, <code>false</code> otherwise.
 * <!-- end-model-doc -->
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getOneDone()
 * @model
 * @generated
 */
public interface OneDone extends TasksExpression {
} // OneDone
