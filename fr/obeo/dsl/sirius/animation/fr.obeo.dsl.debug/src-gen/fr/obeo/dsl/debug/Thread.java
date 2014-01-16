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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Thread</b></em>'. <!-- end-user-doc
 * --> <!-- begin-model-doc --> Current {@link Thread threads} running in this {@link DebugerTarget}. <!--
 * end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.debug.Thread#getBottomStackFrame <em>Bottom Stack Frame</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.Thread#getTopStackFrame <em>Top Stack Frame</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.Thread#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.Thread#getParent <em>Parent</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.Thread#getBreakpoints <em>Breakpoints</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.Thread#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.debug.DebugPackage#getThread()
 * @model
 * @generated
 */
public interface Thread extends Contextual {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2013 Obeo. All Rights Reserved.\n\nThis software and the attached documentation are the exclusive ownership\nof its authors and was conceded to the profit of Obeo SARL.\nThis software and the attached documentation are protected under the rights\nof intellectual ownership, including the section \"Titre II  Droits des auteurs (Articles L121-1 L123-12)\"\nBy installing this software, you acknowledge being aware of this rights and\naccept them, and as a consequence you must:\n- be in possession of a valid license of use conceded by Obeo only.\n- agree that you have read, understood, and will comply with the license terms and conditions.\n- agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries\nor the authors of this software\n\nShould you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.";

	/**
	 * Returns the value of the '<em><b>Bottom Stack Frame</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The current bottom {@link StackFrame}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Bottom Stack Frame</em>' reference.
	 * @see #setBottomStackFrame(StackFrame)
	 * @see fr.obeo.dsl.debug.DebugPackage#getThread_BottomStackFrame()
	 * @model required="true"
	 * @generated
	 */
	StackFrame getBottomStackFrame();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Thread#getBottomStackFrame <em>Bottom Stack Frame</em>}
	 * ' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Bottom Stack Frame</em>' containment reference.
	 * @see #getBottomStackFrame()
	 * @generated
	 */
	void setBottomStackFrame(StackFrame value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute. The literals are from the enumeration
	 * {@link fr.obeo.dsl.debug.State}. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * The current {@link Thread} of this {@link StackFrame}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>State</em>' attribute.
	 * @see fr.obeo.dsl.debug.State
	 * @see #setState(State)
	 * @see fr.obeo.dsl.debug.DebugPackage#getThread_State()
	 * @model required="true"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Thread#getState <em>State</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>State</em>' attribute.
	 * @see fr.obeo.dsl.debug.State
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * Returns the value of the '<em><b>Top Stack Frame</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> The curren top {@link StackFrame}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Top Stack Frame</em>' reference.
	 * @see #setTopStackFrame(StackFrame)
	 * @see fr.obeo.dsl.debug.DebugPackage#getThread_TopStackFrame()
	 * @model required="true"
	 * @generated
	 */
	StackFrame getTopStackFrame();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Thread#getTopStackFrame <em>Top Stack Frame</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Top Stack Frame</em>' reference.
	 * @see #getTopStackFrame()
	 * @generated
	 */
	void setTopStackFrame(StackFrame value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * --> <!-- begin-model-doc --> The {@link Thread} name. It must be unique across a {@link DebugTarget}.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.debug.DebugPackage#getThread_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Thread#getName <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Debug Target</b></em>' container reference. It is bidirectional and
	 * its opposite is '{@link fr.obeo.dsl.debug.DebugTarget#getThreads <em>Threads</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The {@link DebugTarget} of this
	 * {@link StackFrame}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Debug Target</em>' container reference.
	 * @see #setDebugTarget(DebugTarget)
	 * @see fr.obeo.dsl.debug.DebugPackage#getThread_DebugTarget()
	 * @see fr.obeo.dsl.debug.DebugTarget#getThreads
	 * @model opposite="threads" transient="false"
	 * @generated
	 */
	DebugTarget getDebugTarget();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Thread#getDebugTarget <em>Debug Target</em>}' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Debug Target</em>' container reference.
	 * @see #getDebugTarget()
	 * @generated
	 */
	void setDebugTarget(DebugTarget value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute. The default value is <code>"0"</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The priority of the given
	 * thread. The meaning is debugger dependant. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see fr.obeo.dsl.debug.DebugPackage#getThread_Priority()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.debug.Thread#getPriority <em>Priority</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

} // Thread
