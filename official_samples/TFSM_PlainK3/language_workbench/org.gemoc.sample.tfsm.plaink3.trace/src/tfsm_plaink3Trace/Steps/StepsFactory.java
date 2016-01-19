/**
 */
package tfsm_plaink3Trace.Steps;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tfsm_plaink3Trace.Steps.StepsPackage
 * @generated
 */
public interface StepsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StepsFactory eINSTANCE = tfsm_plaink3Trace.Steps.impl.StepsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Implicit Step</em>'.
	 * @generated
	 */
	RootImplicitStep createRootImplicitStep();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 FSM Clock Ticks</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 FSM Clock Ticks</em>'.
	 * @generated
	 */
	Tfsm_plaink3_FSMClock_Ticks createTfsm_plaink3_FSMClock_Ticks();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 FSM Event Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 FSM Event Trigger</em>'.
	 * @generated
	 */
	Tfsm_plaink3_FSMEvent_Trigger createTfsm_plaink3_FSMEvent_Trigger();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 FSM Event Un Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 FSM Event Un Trigger</em>'.
	 * @generated
	 */
	Tfsm_plaink3_FSMEvent_UnTrigger createTfsm_plaink3_FSMEvent_UnTrigger();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 State Visit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 State Visit</em>'.
	 * @generated
	 */
	Tfsm_plaink3_State_Visit createTfsm_plaink3_State_Visit();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 State Visit Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 State Visit Implicit Step</em>'.
	 * @generated
	 */
	Tfsm_plaink3_State_Visit_ImplicitStep createTfsm_plaink3_State_Visit_ImplicitStep();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 TFSM Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 TFSM Init</em>'.
	 * @generated
	 */
	Tfsm_plaink3_TFSM_Init createTfsm_plaink3_TFSM_Init();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 Transition Fire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 Transition Fire</em>'.
	 * @generated
	 */
	Tfsm_plaink3_Transition_Fire createTfsm_plaink3_Transition_Fire();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 Transition Visit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 Transition Visit</em>'.
	 * @generated
	 */
	Tfsm_plaink3_Transition_Visit createTfsm_plaink3_Transition_Visit();

	/**
	 * Returns a new object of class '<em>Tfsm plaink3 Transition Visit Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm plaink3 Transition Visit Implicit Step</em>'.
	 * @generated
	 */
	Tfsm_plaink3_Transition_Visit_ImplicitStep createTfsm_plaink3_Transition_Visit_ImplicitStep();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StepsPackage getStepsPackage();

} //StepsFactory
