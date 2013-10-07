/**
 */
package org.gemoc.mocc.model.moccmetamodel.tests;

import junit.textui.TestRunner;

import org.gemoc.mocc.model.moccmetamodel.FinishClock;
import org.gemoc.mocc.model.moccmetamodel.MoccmetamodelFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Finish Clock</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FinishClockTest extends ActionTest {

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
	 * Returns the fixture for this Finish Clock test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected FinishClock getFixture() {
		return (FinishClock)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MoccmetamodelFactory.eINSTANCE.createFinishClock());
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
