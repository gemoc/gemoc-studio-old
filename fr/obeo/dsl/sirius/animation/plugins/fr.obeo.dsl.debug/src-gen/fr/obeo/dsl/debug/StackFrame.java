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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stack Frame</b></em>'. <!--
 * end-user-doc --> <!-- begin-model-doc --> A {@link StackFrame} represents an execution context in a
 * {@link Thread}. <!-- end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.debug.StackFrame#getVariables <em>Variables</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.StackFrame#getChildFrame <em>Child Frame</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.StackFrame#getState <em>State</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.StackFrame#getParent <em>Parent</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.StackFrame#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.StackFrame#getCurrentInstruction <em>Current Instruction</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.StackFrame#getParentFrame <em>Parent Frame</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.StackFrame#getRegisterGroups <em>Register Groups</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.debug.DebugPackage#getStackFrame()
 * @model
 * @generated
 */
public interface StackFrame extends Contextual {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2013 Obeo. All Rights Reserved.\n\nThis software and the attached documentation are the exclusive ownership\nof its authors and was conceded to the profit of Obeo SARL.\nThis software and the attached documentation are protected under the rights\nof intellectual ownership, including the section \"Titre II  Droits des auteurs (Articles L121-1 L123-12)\"\nBy installing this software, you acknowledge being aware of this rights and\naccept them, and as a consequence you must:\n- be in possession of a valid license of use conceded by Obeo only.\n- agree that you have read, understood, and will comply with the license terms and conditions.\n- agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries\nor the authors of this software\n\nShould you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.";

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list. The list contents are
	 * of type {@link fr.obeo.dsl.debug.Variable}. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> {@link Variable Variables} accessible in this {@link StackFrame}. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see fr.obeo.dsl.debug.DebugPackage#getStackFrame_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Child Frame</b></em>' containment reference. It is bidirectional and
	 * its opposite is '{@link fr.obeo.dsl.debug.StackFrame#getParentFrame <em>Parent Frame</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The current child {@link StackFrame}
	 * of this {@link StackFrame}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Child Frame</em>' containment reference.
	 * @see #setChildFrame(StackFrame)
	 * @see fr.obeo.dsl.debug.DebugPackage#getStackFrame_ChildFrame()
	 * @see fr.obeo.dsl.debug.StackFrame#getParentFrame
	 * @model opposite="parentFrame" containment="true"
	 * @generated
	 */
	StackFrame getChildFrame();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.StackFrame#getChildFrame <em>Child Frame</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Child Frame</em>' containment reference.
	 * @see #getChildFrame()
	 * @generated
	 */
	void setChildFrame(StackFrame value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc --> The {@link StackFrame} name. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.debug.DebugPackage#getStackFrame_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.StackFrame#getName <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Current Instruction</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The {@link EObject} representing the current instruction in
	 * this {@link StackFrame}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Current Instruction</em>' reference.
	 * @see #setCurrentInstruction(EObject)
	 * @see fr.obeo.dsl.debug.DebugPackage#getStackFrame_CurrentInstruction()
	 * @model
	 * @generated
	 */
	EObject getCurrentInstruction();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.StackFrame#getCurrentInstruction
	 * <em>Current Instruction</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Current Instruction</em>' reference.
	 * @see #getCurrentInstruction()
	 * @generated
	 */
	void setCurrentInstruction(EObject value);

	/**
	 * Returns the value of the '<em><b>Can Step Into Current Instruction</b></em>' attribute. The default
	 * value is <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Can Step Into Current Instruction</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Can Step Into Current Instruction</em>' attribute.
	 * @see #setCanStepIntoCurrentInstruction(boolean)
	 * @see fr.obeo.dsl.debug.DebugPackage#getStackFrame_CanStepIntoCurrentInstruction()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isCanStepIntoCurrentInstruction();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.StackFrame#isCanStepIntoCurrentInstruction
	 * <em>Can Step Into Current Instruction</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Can Step Into Current Instruction</em>' attribute.
	 * @see #isCanStepIntoCurrentInstruction()
	 * @generated
	 */
	void setCanStepIntoCurrentInstruction(boolean value);

	/**
	 * Returns the value of the '<em><b>Parent Frame</b></em>' container reference. It is bidirectional and
	 * its opposite is '{@link fr.obeo.dsl.debug.StackFrame#getChildFrame <em>Child Frame</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The current parent {@link StackFrame}
	 * of this {@link StackFrame}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Parent Frame</em>' container reference.
	 * @see #setParentFrame(StackFrame)
	 * @see fr.obeo.dsl.debug.DebugPackage#getStackFrame_ParentFrame()
	 * @see fr.obeo.dsl.debug.StackFrame#getChildFrame
	 * @model opposite="childFrame" transient="false"
	 * @generated
	 */
	StackFrame getParentFrame();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.StackFrame#getParentFrame <em>Parent Frame</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Parent Frame</em>' container reference.
	 * @see #getParentFrame()
	 * @generated
	 */
	void setParentFrame(StackFrame value);

	/**
	 * Returns the value of the '<em><b>Register Groups</b></em>' containment reference list. The list
	 * contents are of type {@link fr.obeo.dsl.debug.RegisterGroup}. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc --> {@link RegisterGroup Register groups} accessible in this
	 * {@link StackFrame}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Register Groups</em>' containment reference list.
	 * @see fr.obeo.dsl.debug.DebugPackage#getStackFrame_RegisterGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<RegisterGroup> getRegisterGroups();

} // StackFrame
