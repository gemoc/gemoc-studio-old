/**
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 */
package fr.obeo.dsl.debug;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>State</b></em>', and
 * utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc --> Possible States of a
 * {@link StackFrame} {@link StackFrame#getState() state}. <!-- end-model-doc -->
 * 
 * @see fr.obeo.dsl.debug.DebugPackage#getState()
 * @model
 * @generated
 */
public enum State implements Enumerator {
	/**
	 * The '<em><b>RUNNING</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #RUNNING_VALUE
	 * @generated
	 * @ordered
	 */
	RUNNING(0, "RUNNING", "RUNNING"),

	/**
	 * The '<em><b>STEPPING INTO</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #STEPPING_INTO_VALUE
	 * @generated
	 * @ordered
	 */
	STEPPING_INTO(1, "STEPPING_INTO", "STEPPING_INTO"), /**
	 * The '<em><b>STEPPING OVER</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #STEPPING_OVER_VALUE
	 * @generated
	 * @ordered
	 */
	STEPPING_OVER(2, "STEPPING_OVER", "STEPPING_OVER"), /**
	 * The '<em><b>STEPPING RETURN</b></em>' literal
	 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #STEPPING_RETURN_VALUE
	 * @generated
	 * @ordered
	 */
	STEPPING_RETURN(3, "STEPPING_RETURN", "STEPPING_RETURN"), /**
	 * The '<em><b>SUSPENDING</b></em>' literal
	 * object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SUSPENDING_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENDING(4, "SUSPENDING", "SUSPENDING"), /**
	 * The '<em><b>SUSPENDED</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #SUSPENDED_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENDED(5, "SUSPENDED", "SUSPENDED"),

	/**
	 * The '<em><b>TERMINATING</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TERMINATING_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINATING(6, "TERMINATING", "TERMINATING"), /**
	 * The '<em><b>TERMINATED</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TERMINATED_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINATED(7, "TERMINATED", "TERMINATED");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013 Obeo. All Rights Reserved.\n\nThis software and the attached documentation are the exclusive ownership\nof its authors and was conceded to the profit of Obeo SARL.\nThis software and the attached documentation are protected under the rights\nof intellectual ownership, including the section \"Titre II  Droits des auteurs (Articles L121-1 L123-12)\"\nBy installing this software, you acknowledge being aware of this rights and\naccept them, and as a consequence you must:\n- be in possession of a valid license of use conceded by Obeo only.\n- agree that you have read, understood, and will comply with the license terms and conditions.\n- agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries\nor the authors of this software\n\nShould you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.";

	/**
	 * The '<em><b>RUNNING</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link StackFrame} is running. <!-- end-model-doc -->
	 * 
	 * @see #RUNNING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUNNING_VALUE = 0;

	/**
	 * The '<em><b>STEPPING INTO</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link StackFrame} is stepping into. <!-- end-model-doc -->
	 * 
	 * @see #STEPPING_INTO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEPPING_INTO_VALUE = 1;

	/**
	 * The '<em><b>STEPPING OVER</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link StackFrame} is stepping over. <!-- end-model-doc -->
	 * 
	 * @see #STEPPING_OVER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEPPING_OVER_VALUE = 2;

	/**
	 * The '<em><b>STEPPING RETURN</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link StackFrame} is stepping return. <!-- end-model-doc -->
	 * 
	 * @see #STEPPING_RETURN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEPPING_RETURN_VALUE = 3;

	/**
	 * The '<em><b>SUSPENDING</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link StackFrame} is stepping over. <!-- end-model-doc -->
	 * 
	 * @see #SUSPENDING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENDING_VALUE = 4;

	/**
	 * The '<em><b>SUSPENDED</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link StackFrame} is suspended. <!-- end-model-doc -->
	 * 
	 * @see #SUSPENDED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENDED_VALUE = 5;

	/**
	 * The '<em><b>TERMINATING</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link StackFrame} is terminated. <!-- end-model-doc -->
	 * 
	 * @see #TERMINATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TERMINATING_VALUE = 6;

	/**
	 * The '<em><b>TERMINATED</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link DebugTarget} is terminated. <!-- end-model-doc -->
	 * 
	 * @see #TERMINATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TERMINATED_VALUE = 7;

	/**
	 * An array of all the '<em><b>State</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final State[] VALUES_ARRAY = new State[] {RUNNING, STEPPING_INTO, STEPPING_OVER,
			STEPPING_RETURN, SUSPENDING, SUSPENDED, TERMINATING, TERMINATED, };

	/**
	 * A public read-only list of all the '<em><b>State</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<State> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified literal value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static State get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			State result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static State getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			State result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified integer value. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static State get(int value) {
		switch (value) {
			case RUNNING_VALUE:
				return RUNNING;
			case STEPPING_INTO_VALUE:
				return STEPPING_INTO;
			case STEPPING_OVER_VALUE:
				return STEPPING_OVER;
			case STEPPING_RETURN_VALUE:
				return STEPPING_RETURN;
			case SUSPENDING_VALUE:
				return SUSPENDING;
			case SUSPENDED_VALUE:
				return SUSPENDED;
			case TERMINATING_VALUE:
				return TERMINATING;
			case TERMINATED_VALUE:
				return TERMINATED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private State(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // State
