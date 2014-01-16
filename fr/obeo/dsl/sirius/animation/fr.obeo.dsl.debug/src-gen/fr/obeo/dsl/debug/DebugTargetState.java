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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Target State</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc --> Possible States
 * of a {@link DebugTarget} {@link DebugTarget#getState() state}. <!-- end-model-doc -->
 * 
 * @see fr.obeo.dsl.debug.DebugPackage#getDebugTargetState()
 * @model
 * @generated
 */
public enum DebugTargetState implements Enumerator {
	/**
	 * The '<em><b>CONNECTED</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #CONNECTED_VALUE
	 * @generated
	 * @ordered
	 */
	CONNECTED(0, "CONNECTED", "CONNECTED"), /**
	 * The '<em><b>DISCONNECTED</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #DISCONNECTED_VALUE
	 * @generated
	 * @ordered
	 */
	DISCONNECTED(1, "DISCONNECTED", "DISCONNECTED"),

	/**
	 * The '<em><b>TERMINATING</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TERMINATING_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINATING(2, "TERMINATING", "TERMINATING"), /**
	 * The '<em><b>TERMINATED</b></em>' literal object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #TERMINATED_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINATED(3, "TERMINATED", "TERMINATED");

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013 Obeo. All Rights Reserved.\n\nThis software and the attached documentation are the exclusive ownership\nof its authors and was conceded to the profit of Obeo SARL.\nThis software and the attached documentation are protected under the rights\nof intellectual ownership, including the section \"Titre II  Droits des auteurs (Articles L121-1 L123-12)\"\nBy installing this software, you acknowledge being aware of this rights and\naccept them, and as a consequence you must:\n- be in possession of a valid license of use conceded by Obeo only.\n- agree that you have read, understood, and will comply with the license terms and conditions.\n- agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries\nor the authors of this software\n\nShould you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.";

	/**
	 * The '<em><b>CONNECTED</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link DebugTarget} is connected. <!-- end-model-doc -->
	 * 
	 * @see #CONNECTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTED_VALUE = 0;

	/**
	 * The '<em><b>DISCONNECTED</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link DebugTarget} is disconnected. <!-- end-model-doc -->
	 * 
	 * @see #DISCONNECTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISCONNECTED_VALUE = 1;

	/**
	 * The '<em><b>TERMINATING</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link DebugTarget} is terminating. <!-- end-model-doc -->
	 * 
	 * @see #TERMINATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TERMINATING_VALUE = 2;

	/**
	 * The '<em><b>TERMINATED</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> The {@link DebugTarget} is terminated. <!-- end-model-doc -->
	 * 
	 * @see #TERMINATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TERMINATED_VALUE = 3;

	/**
	 * An array of all the '<em><b>Target State</b></em>' enumerators. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private static final DebugTargetState[] VALUES_ARRAY = new DebugTargetState[] {CONNECTED, DISCONNECTED,
			TERMINATING, TERMINATED, };

	/**
	 * A public read-only list of all the '<em><b>Target State</b></em>' enumerators. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<DebugTargetState> VALUES = Collections.unmodifiableList(Arrays
			.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Target State</b></em>' literal with the specified literal value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DebugTargetState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DebugTargetState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Target State</b></em>' literal with the specified name. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DebugTargetState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DebugTargetState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Target State</b></em>' literal with the specified integer value. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DebugTargetState get(int value) {
		switch (value) {
			case CONNECTED_VALUE:
				return CONNECTED;
			case DISCONNECTED_VALUE:
				return DISCONNECTED;
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
	private DebugTargetState(int value, String name, String literal) {
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

} // DebugTargetState
