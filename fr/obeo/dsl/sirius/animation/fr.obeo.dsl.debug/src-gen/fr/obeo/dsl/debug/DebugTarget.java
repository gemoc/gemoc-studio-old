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
package fr.obeo.dsl.debug;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Target</b></em>'. <!-- end-user-doc
 * --> <!-- begin-model-doc --> a {@link DebugTarget} is a debuggable execution context, for instance a
 * debugggable process of a virtual machine. <!-- end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.debug.DebugTarget#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.DebugTarget#getState <em>State</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.DebugTarget#getThreads <em>Threads</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.DebugTarget#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.debug.DebugPackage#getDebugTarget()
 * @model
 * @generated
 */
public interface DebugTarget extends Contextual {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2013 Obeo. All Rights Reserved.\n\nThis software and the attached documentation are the exclusive ownership\nof its authors and was conceded to the profit of Obeo SARL.\nThis software and the attached documentation are protected under the rights\nof intellectual ownership, including the section \"Titre II  Droits des auteurs (Articles L121-1 L123-12)\"\nBy installing this software, you acknowledge being aware of this rights and\naccept them, and as a consequence you must:\n- be in possession of a valid license of use conceded by Obeo only.\n- agree that you have read, understood, and will comply with the license terms and conditions.\n- agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries\nor the authors of this software\n\nShould you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc --> A name of this {@link DebugTarget}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.debug.DebugPackage#getDebugTarget_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.DebugTarget#getName <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute. The literals are from the enumeration
	 * {@link fr.obeo.dsl.debug.DebugTargetState}. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The current {@link TargetState} of this {@link DebugerTarget}. <!-- end-model-doc
	 * -->
	 * 
	 * @return the value of the '<em>State</em>' attribute.
	 * @see fr.obeo.dsl.debug.DebugTargetState
	 * @see #setState(DebugTargetState)
	 * @see fr.obeo.dsl.debug.DebugPackage#getDebugTarget_State()
	 * @model
	 * @generated
	 */
	DebugTargetState getState();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.DebugTarget#getState <em>State</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>State</em>' attribute.
	 * @see fr.obeo.dsl.debug.DebugTargetState
	 * @see #getState()
	 * @generated
	 */
	void setState(DebugTargetState value);

	/**
	 * Returns the value of the '<em><b>Threads</b></em>' containment reference list. The list contents are of
	 * type {@link fr.obeo.dsl.debug.Thread}. It is bidirectional and its opposite is '
	 * {@link fr.obeo.dsl.debug.Thread#getParent <em>Parent</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc --> Current {@link Thread threads} running in this {@link DebugerTarget}. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Threads</em>' containment reference list.
	 * @see fr.obeo.dsl.debug.DebugPackage#getDebugTarget_Threads()
	 * @see fr.obeo.dsl.debug.Thread#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<fr.obeo.dsl.debug.Thread> getThreads();

} // DebugTarget
