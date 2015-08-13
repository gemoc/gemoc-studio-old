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
package org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.tests;

import junit.textui.TestRunner;

import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionFactory;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntegerAssignementBlock;

import org.gemoc.mocc.fsmkernel.model.FSMModel.tests.AbstractActionTest;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Integer Assignement Block</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class IntegerAssignementBlockTest extends AbstractActionTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IntegerAssignementBlockTest.class);
	}

	/**
	 * Constructs a new Integer Assignement Block test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAssignementBlockTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Integer Assignement Block test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected IntegerAssignementBlock getFixture() {
		return (IntegerAssignementBlock)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(EditionExtensionFactory.eINSTANCE.createIntegerAssignementBlock());
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

} //IntegerAssignementBlockTest
