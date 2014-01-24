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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Variable</b></em>'. <!-- end-user-doc
 * --> <!-- begin-model-doc --> A {@link Variable} represents a visible data structure in the
 * {@link StackFrame}. <!-- end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.debug.Variable#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.Variable#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.debug.DebugPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2013 Obeo. All Rights Reserved.\n\nThis software and the attached documentation are the exclusive ownership\nof its authors and was conceded to the profit of Obeo SARL.\nThis software and the attached documentation are protected under the rights\nof intellectual ownership, including the section \"Titre II  Droits des auteurs (Articles L121-1 L123-12)\"\nBy installing this software, you acknowledge being aware of this rights and\naccept them, and as a consequence you must:\n- be in possession of a valid license of use conceded by Obeo only.\n- agree that you have read, understood, and will comply with the license terms and conditions.\n- agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries\nor the authors of this software\n\nShould you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc --> The {@link Variable} name. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.debug.DebugPackage#getVariable_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Variable#getName <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc --> The {@link Variable} value. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see fr.obeo.dsl.debug.DebugPackage#getVariable_Value()
	 * @model dataType="fr.obeo.dsl.debug.Object" transient="true"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Variable#getValue <em>Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Value Changed</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Changed</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value Changed</em>' attribute.
	 * @see #setValueChanged(boolean)
	 * @see fr.obeo.dsl.debug.DebugPackage#getVariable_ValueChanged()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isValueChanged();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Variable#isValueChanged <em>Value Changed</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Value Changed</em>' attribute.
	 * @see #isValueChanged()
	 * @generated
	 */
	void setValueChanged(boolean value);

	/**
	 * Returns the value of the '<em><b>Frame</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link fr.obeo.dsl.debug.StackFrame#getVariables <em>Variables</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Frame</em>' container reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Frame</em>' container reference.
	 * @see #setFrame(StackFrame)
	 * @see fr.obeo.dsl.debug.DebugPackage#getVariable_Frame()
	 * @see fr.obeo.dsl.debug.StackFrame#getVariables
	 * @model opposite="variables" transient="false"
	 * @generated
	 */
	StackFrame getFrame();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Variable#getFrame <em>Frame</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Frame</em>' container reference.
	 * @see #getFrame()
	 * @generated
	 */
	void setFrame(StackFrame value);

	/**
	 * Returns the value of the '<em><b>Declaration Type</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The {@link Variable} declaration type. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Declaration Type</em>' attribute.
	 * @see #setDeclarationType(String)
	 * @see fr.obeo.dsl.debug.DebugPackage#getVariable_DeclarationType()
	 * @model required="true"
	 * @generated
	 */
	String getDeclarationType();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Variable#getDeclarationType <em>Declaration Type</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Declaration Type</em>' attribute.
	 * @see #getDeclarationType()
	 * @generated
	 */
	void setDeclarationType(String value);

} // Variable
