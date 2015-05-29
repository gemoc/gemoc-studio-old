/**
 */
package org.gemoc.sigpml.tests;

import junit.textui.TestRunner;

import org.gemoc.sigpml.InputPort;
import org.gemoc.sigpml.SigpmlFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Input Port</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InputPortTest extends PortTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InputPortTest.class);
	}

	/**
	 * Constructs a new Input Port test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPortTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Input Port test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InputPort getFixture() {
		return (InputPort)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SigpmlFactory.eINSTANCE.createInputPort());
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

} //InputPortTest
