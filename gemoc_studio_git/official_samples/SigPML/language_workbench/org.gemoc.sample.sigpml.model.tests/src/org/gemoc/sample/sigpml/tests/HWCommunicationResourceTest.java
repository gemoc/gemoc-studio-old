/**
 */
package org.gemoc.sample.sigpml.tests;

import junit.textui.TestRunner;

import org.gemoc.sample.sigpml.HWCommunicationResource;
import org.gemoc.sample.sigpml.SigpmlFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>HW Communication Resource</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class HWCommunicationResourceTest extends HWRessourceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(HWCommunicationResourceTest.class);
	}

	/**
	 * Constructs a new HW Communication Resource test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWCommunicationResourceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this HW Communication Resource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected HWCommunicationResource getFixture() {
		return (HWCommunicationResource)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SigpmlFactory.eINSTANCE.createHWCommunicationResource());
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

} //HWCommunicationResourceTest
