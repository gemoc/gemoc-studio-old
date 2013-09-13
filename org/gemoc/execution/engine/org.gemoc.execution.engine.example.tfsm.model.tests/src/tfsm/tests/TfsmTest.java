/**
 */
package tfsm.tests;

import junit.textui.TestRunner;

import tfsm.Tfsm;
import tfsm.TfsmFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Tfsm</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class TfsmTest extends NamedElementTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(TfsmTest.class);
    }

    /**
     * Constructs a new Tfsm test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TfsmTest(String name) {
        super(name);
    }

    /**
     * Returns the fixture for this Tfsm test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Tfsm getFixture() {
        return (Tfsm)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture(TfsmFactory.eINSTANCE.createTfsm());
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

} //TfsmTest
