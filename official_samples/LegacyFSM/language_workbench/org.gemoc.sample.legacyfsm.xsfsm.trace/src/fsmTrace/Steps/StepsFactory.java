/**
 */
package fsmTrace.Steps;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fsmTrace.Steps.StepsPackage
 * @generated
 */
public interface StepsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StepsFactory eINSTANCE = fsmTrace.Steps.impl.StepsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Fsm FSM Clock Ticks</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm FSM Clock Ticks</em>'.
	 * @generated
	 */
	Fsm_FSMClock_Ticks createFsm_FSMClock_Ticks();

	/**
	 * Returns a new object of class '<em>Fsm FSM Event Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm FSM Event Trigger</em>'.
	 * @generated
	 */
	Fsm_FSMEvent_Trigger createFsm_FSMEvent_Trigger();

	/**
	 * Returns a new object of class '<em>Fsm FSM Event Un Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm FSM Event Un Trigger</em>'.
	 * @generated
	 */
	Fsm_FSMEvent_UnTrigger createFsm_FSMEvent_UnTrigger();

	/**
	 * Returns a new object of class '<em>Fsm State Visit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm State Visit</em>'.
	 * @generated
	 */
	Fsm_State_Visit createFsm_State_Visit();

	/**
	 * Returns a new object of class '<em>Fsm State Visit Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm State Visit Implicit Step</em>'.
	 * @generated
	 */
	Fsm_State_Visit_ImplicitStep createFsm_State_Visit_ImplicitStep();

	/**
	 * Returns a new object of class '<em>Fsm Time FSM Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm Time FSM Init</em>'.
	 * @generated
	 */
	Fsm_TimeFSM_Init createFsm_TimeFSM_Init();

	/**
	 * Returns a new object of class '<em>Fsm Transition Fire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm Transition Fire</em>'.
	 * @generated
	 */
	Fsm_Transition_Fire createFsm_Transition_Fire();

	/**
	 * Returns a new object of class '<em>Fsm Transition Visit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm Transition Visit</em>'.
	 * @generated
	 */
	Fsm_Transition_Visit createFsm_Transition_Visit();

	/**
	 * Returns a new object of class '<em>Fsm Transition Visit Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fsm Transition Visit Implicit Step</em>'.
	 * @generated
	 */
	Fsm_Transition_Visit_ImplicitStep createFsm_Transition_Visit_ImplicitStep();

	/**
	 * Returns a new object of class '<em>Root Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Implicit Step</em>'.
	 * @generated
	 */
	RootImplicitStep createRootImplicitStep();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StepsPackage getStepsPackage();

} //StepsFactory
