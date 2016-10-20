/**
 */
package tfsmTrace.Steps;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tfsmTrace.Steps.StepsPackage
 * @generated
 */
public interface StepsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StepsFactory eINSTANCE = tfsmTrace.Steps.impl.StepsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root Implicit Step</em>'.
	 * @generated
	 */
	RootImplicitStep createRootImplicitStep();

	/**
	 * Returns a new object of class '<em>Tfsm FSM Clock Ticks</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm FSM Clock Ticks</em>'.
	 * @generated
	 */
	Tfsm_FSMClock_Ticks createTfsm_FSMClock_Ticks();

	/**
	 * Returns a new object of class '<em>Tfsm FSM Event Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm FSM Event Trigger</em>'.
	 * @generated
	 */
	Tfsm_FSMEvent_Trigger createTfsm_FSMEvent_Trigger();

	/**
	 * Returns a new object of class '<em>Tfsm FSM Event Un Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm FSM Event Un Trigger</em>'.
	 * @generated
	 */
	Tfsm_FSMEvent_UnTrigger createTfsm_FSMEvent_UnTrigger();

	/**
	 * Returns a new object of class '<em>Tfsm State Visit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm State Visit</em>'.
	 * @generated
	 */
	Tfsm_State_Visit createTfsm_State_Visit();

	/**
	 * Returns a new object of class '<em>Tfsm State Visit Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm State Visit Implicit Step</em>'.
	 * @generated
	 */
	Tfsm_State_Visit_ImplicitStep createTfsm_State_Visit_ImplicitStep();

	/**
	 * Returns a new object of class '<em>Tfsm TFSM Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm TFSM Init</em>'.
	 * @generated
	 */
	Tfsm_TFSM_Init createTfsm_TFSM_Init();

	/**
	 * Returns a new object of class '<em>Tfsm Transition Fire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm Transition Fire</em>'.
	 * @generated
	 */
	Tfsm_Transition_Fire createTfsm_Transition_Fire();

	/**
	 * Returns a new object of class '<em>Tfsm Transition Visit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm Transition Visit</em>'.
	 * @generated
	 */
	Tfsm_Transition_Visit createTfsm_Transition_Visit();

	/**
	 * Returns a new object of class '<em>Tfsm Transition Visit Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tfsm Transition Visit Implicit Step</em>'.
	 * @generated
	 */
	Tfsm_Transition_Visit_ImplicitStep createTfsm_Transition_Visit_ImplicitStep();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StepsPackage getStepsPackage();

} //StepsFactory
