/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Mo CRole</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getMoCRole()
 * @model
 * @generated
 */
public enum MoCRole implements Enumerator {
	/**
	 * The '<em><b>Orchestrator</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORCHESTRATOR_VALUE
	 * @generated
	 * @ordered
	 */
	ORCHESTRATOR(0, "Orchestrator", "OrchestratorBehavior"),

	/**
	 * The '<em><b>Port Behavior</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PORT_BEHAVIOR_VALUE
	 * @generated
	 * @ordered
	 */
	PORT_BEHAVIOR(1, "PortBehavior", "PortBehavior"),

	/**
	 * The '<em><b>Connector Behavior</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONNECTOR_BEHAVIOR_VALUE
	 * @generated
	 * @ordered
	 */
	CONNECTOR_BEHAVIOR(2, "ConnectorBehavior", "ConnectorBehavior");

	/**
	 * The '<em><b>Orchestrator</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Orchestrator</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORCHESTRATOR
	 * @model name="Orchestrator" literal="OrchestratorBehavior"
	 * @generated
	 * @ordered
	 */
	public static final int ORCHESTRATOR_VALUE = 0;

	/**
	 * The '<em><b>Port Behavior</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Port Behavior</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PORT_BEHAVIOR
	 * @model name="PortBehavior"
	 * @generated
	 * @ordered
	 */
	public static final int PORT_BEHAVIOR_VALUE = 1;

	/**
	 * The '<em><b>Connector Behavior</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Connector Behavior</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONNECTOR_BEHAVIOR
	 * @model name="ConnectorBehavior"
	 * @generated
	 * @ordered
	 */
	public static final int CONNECTOR_BEHAVIOR_VALUE = 2;

	/**
	 * An array of all the '<em><b>Mo CRole</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final MoCRole[] VALUES_ARRAY =
		new MoCRole[] {
			ORCHESTRATOR,
			PORT_BEHAVIOR,
			CONNECTOR_BEHAVIOR,
		};

	/**
	 * A public read-only list of all the '<em><b>Mo CRole</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<MoCRole> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Mo CRole</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MoCRole get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MoCRole result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mo CRole</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MoCRole getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			MoCRole result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Mo CRole</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MoCRole get(int value) {
		switch (value) {
			case ORCHESTRATOR_VALUE: return ORCHESTRATOR;
			case PORT_BEHAVIOR_VALUE: return PORT_BEHAVIOR;
			case CONNECTOR_BEHAVIOR_VALUE: return CONNECTOR_BEHAVIOR;
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
	private MoCRole(int value, String name, String literal) {
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
	
} //MoCRole
