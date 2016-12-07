/**
 */
package fsmTrace.States.fsm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fsmTrace.States.fsm.FsmPackage
 * @generated
 */
public interface FsmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FsmFactory eINSTANCE = fsmTrace.States.fsm.impl.FsmFactoryImpl.init();

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
	 * Returns a new object of class '<em>Traced Temporal Guard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced Temporal Guard</em>'.
	 * @generated
	 */
	TracedTemporalGuard createTracedTemporalGuard();

	/**
	 * Returns a new object of class '<em>Traced Time FSM</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Traced Time FSM</em>'.
	 * @generated
	 */
	TracedTimeFSM createTracedTimeFSM();

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
	FsmPackage getFsmPackage();

} //FsmFactory
