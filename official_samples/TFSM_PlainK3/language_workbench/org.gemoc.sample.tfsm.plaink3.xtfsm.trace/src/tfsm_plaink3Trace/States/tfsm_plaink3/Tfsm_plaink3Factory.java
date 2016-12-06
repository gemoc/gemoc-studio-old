/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package
 * @generated
 */
public interface Tfsm_plaink3Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Tfsm_plaink3Factory eINSTANCE = tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Traced Evaluate Guard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced Evaluate Guard</em>'.
	 * @generated
	 */
	TracedEvaluateGuard createTracedEvaluateGuard();

	/**
	 * Returns a new object of class '<em>Traced Event Guard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced Event Guard</em>'.
	 * @generated
	 */
	TracedEventGuard createTracedEventGuard();

	/**
	 * Returns a new object of class '<em>Traced FSM Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced FSM Clock</em>'.
	 * @generated
	 */
	TracedFSMClock createTracedFSMClock();

	/**
	 * Returns a new object of class '<em>Traced FSM Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced FSM Event</em>'.
	 * @generated
	 */
	TracedFSMEvent createTracedFSMEvent();

	/**
	 * Returns a new object of class '<em>Traced State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced State</em>'.
	 * @generated
	 */
	TracedState createTracedState();

	/**
	 * Returns a new object of class '<em>Traced TFSM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced TFSM</em>'.
	 * @generated
	 */
	TracedTFSM createTracedTFSM();

	/**
	 * Returns a new object of class '<em>Traced Temporal Guard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced Temporal Guard</em>'.
	 * @generated
	 */
	TracedTemporalGuard createTracedTemporalGuard();

	/**
	 * Returns a new object of class '<em>Traced Timed System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced Timed System</em>'.
	 * @generated
	 */
	TracedTimedSystem createTracedTimedSystem();

	/**
	 * Returns a new object of class '<em>Traced Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced Transition</em>'.
	 * @generated
	 */
	TracedTransition createTracedTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Tfsm_plaink3Package getTfsm_plaink3Package();

} //Tfsm_plaink3Factory
