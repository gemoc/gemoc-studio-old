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
package org.gemoc.mocc.ccslmoc.model.moccml.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.gemoc.mocc.ccslmoc.model.moccml.CcslmoccFactory;
import org.gemoc.mocc.ccslmoc.model.moccml.FinishClock;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Finish Clock</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FinishClockTest extends TestCase {

	/**
	 * The fixture for this Finish Clock test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinishClock fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FinishClockTest.class);
	}

	/**
	 * Constructs a new Finish Clock test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinishClockTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Finish Clock test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(FinishClock fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Finish Clock test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinishClock getFixture() {
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
		setFixture(CcslmoccFactory.eINSTANCE.createFinishClock());
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

} //FinishClockTest
