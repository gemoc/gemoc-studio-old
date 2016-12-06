/**
 */
package tfsm_plaink3Trace.States;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tfsm_plaink3Trace.States.StatesPackage
 * @generated
 */
public interface StatesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatesFactory eINSTANCE = tfsm_plaink3Trace.States.impl.StatesFactoryImpl.init();

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
	 * Returns a new object of class '<em>TFSM current State Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TFSM current State Value</em>'.
	 * @generated
	 */
	TFSM_currentState_Value createTFSM_currentState_Value();

	/**
	 * Returns a new object of class '<em>TFSM last State Change Step Number Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TFSM last State Change Step Number Value</em>'.
	 * @generated
	 */
	TFSM_lastStateChangeStepNumber_Value createTFSM_lastStateChangeStepNumber_Value();

	/**
	 * Returns a new object of class '<em>TFSM step Number Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TFSM step Number Value</em>'.
	 * @generated
	 */
	TFSM_stepNumber_Value createTFSM_stepNumber_Value();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StatesPackage getStatesPackage();

} //StatesFactory
