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
package org.gemoc.mocc.fsmkernel.model.FSMModel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelFactory;
import org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>State Machine Definition</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class StateMachineDefinitionTest extends TestCase {

	/**
	 * The fixture for this State Machine Definition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineDefinition fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(StateMachineDefinitionTest.class);
	}

	/**
	 * Constructs a new State Machine Definition test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachineDefinitionTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this State Machine Definition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(StateMachineDefinition fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this State Machine Definition test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineDefinition getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(FSMModelFactory.eINSTANCE.createStateMachineDefinition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //StateMachineDefinitionTest
