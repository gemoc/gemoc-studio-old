/**
 */
package org.gemoc.mocc.model.moccmetamodel.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.gemoc.mocc.model.moccmetamodel.MoccmetamodelFactory;
import org.gemoc.mocc.model.moccmetamodel.Trigger;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Trigger</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TriggerTest extends TestCase {

	/**
	 * The fixture for this Trigger test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Trigger fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TriggerTest.class);
	}

	/**
	 * Constructs a new Trigger test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TriggerTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Trigger test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Trigger fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Trigger test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Trigger getFixture() {
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
		setFixture(MoccmetamodelFactory.eINSTANCE.createTrigger());
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

} //TriggerTest
