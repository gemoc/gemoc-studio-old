/**
 */
package tfsm.tests;

import junit.textui.TestRunner;

import tfsm.TemporalGuard;
import tfsm.TfsmFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Temporal Guard</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TemporalGuardTest extends GuardTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(TemporalGuardTest.class);
	}

	/**
	 * Constructs a new Temporal Guard test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemporalGuardTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Temporal Guard test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected TemporalGuard getFixture() {
		return (TemporalGuard)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TfsmFactory.eINSTANCE.createTemporalGuard());
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

} //TemporalGuardTest
