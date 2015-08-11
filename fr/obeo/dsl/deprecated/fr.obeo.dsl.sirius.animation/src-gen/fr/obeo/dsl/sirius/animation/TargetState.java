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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Target State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.sirius.animation.AnimationPackage#getTargetState()
 * @model
 * @generated
 */
public enum TargetState implements Enumerator {
	/**
	 * The '<em><b>Suspended</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENDED_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENDED(3, "suspended", "suspended"),

	/**
	 * The '<em><b>Disconnected</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISCONNECTED_VALUE
	 * @generated
	 * @ordered
	 */
	DISCONNECTED(2, "disconnected", "disconnected"),

	/**
	 * The '<em><b>Terminated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERMINATED_VALUE
	 * @generated
	 * @ordered
	 */
	TERMINATED(1, "terminated", "terminated"),

	/**
	 * The '<em><b>Running</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUNNING_VALUE
	 * @generated
	 * @ordered
	 */
	RUNNING(0, "running", "running");

	/**
	 * The '<em><b>Suspended</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Suspended</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUSPENDED
	 * @model name="suspended"
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENDED_VALUE = 3;

	/**
	 * The '<em><b>Disconnected</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Disconnected</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISCONNECTED
	 * @model name="disconnected"
	 * @generated
	 * @ordered
	 */
	public static final int DISCONNECTED_VALUE = 2;

	/**
	 * The '<em><b>Terminated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Terminated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERMINATED
	 * @model name="terminated"
	 * @generated
	 * @ordered
	 */
	public static final int TERMINATED_VALUE = 1;

	/**
	 * The '<em><b>Running</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Running</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUNNING
	 * @model name="running"
	 * @generated
	 * @ordered
	 */
	public static final int RUNNING_VALUE = 0;

	/**
	 * An array of all the '<em><b>Target State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TargetState[] VALUES_ARRAY =
		new TargetState[] {
			SUSPENDED,
			DISCONNECTED,
			TERMINATED,
			RUNNING,
		};

	/**
	 * A public read-only list of all the '<em><b>Target State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TargetState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Target State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TargetState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TargetState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Target State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TargetState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TargetState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Target State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TargetState get(int value) {
		switch (value) {
			case SUSPENDED_VALUE: return SUSPENDED;
			case DISCONNECTED_VALUE: return DISCONNECTED;
			case TERMINATED_VALUE: return TERMINATED;
			case RUNNING_VALUE: return RUNNING;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TargetState(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TargetState
