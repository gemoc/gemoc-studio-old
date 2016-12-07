/**
 */
package fsmTrace.States;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fsmTrace.States.StatesPackage
 * @generated
 */
public interface StatesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatesFactory eINSTANCE = fsmTrace.States.impl.StatesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>FSM Clock number Of Ticks Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Clock number Of Ticks Value</em>'.
	 * @generated
	 */
	FSMClock_numberOfTicks_Value createFSMClock_numberOfTicks_Value();

	/**
	 * Returns a new object of class '<em>FSM Event is Triggered Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>FSM Event is Triggered Value</em>'.
	 * @generated
	 */
	FSMEvent_isTriggered_Value createFSMEvent_isTriggered_Value();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Time FSM current State Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time FSM current State Value</em>'.
	 * @generated
	 */
	TimeFSM_currentState_Value createTimeFSM_currentState_Value();

	/**
	 * Returns a new object of class '<em>Time FSM last State Change Step Number Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time FSM last State Change Step Number Value</em>'.
	 * @generated
	 */
	TimeFSM_lastStateChangeStepNumber_Value createTimeFSM_lastStateChangeStepNumber_Value();

	/**
	 * Returns a new object of class '<em>Time FSM step Number Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time FSM step Number Value</em>'.
	 * @generated
	 */
	TimeFSM_stepNumber_Value createTimeFSM_stepNumber_Value();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StatesPackage getStatesPackage();

} //StatesFactory
