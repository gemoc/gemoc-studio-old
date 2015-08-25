/**
 */
package org.gemoc.sample.sigpml.tests;

import junit.textui.TestRunner;

import org.gemoc.sample.sigpml.HWStorageResource;
import org.gemoc.sample.sigpml.SigpmlFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>HW Storage Resource</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HWStorageResourceTest extends HWRessourceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(HWStorageResourceTest.class);
	}

	/**
	 * Constructs a new HW Storage Resource test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWStorageResourceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this HW Storage Resource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected HWStorageResource getFixture() {
		return (HWStorageResource)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SigpmlFactory.eINSTANCE.createHWStorageResource());
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

} //HWStorageResourceTest
