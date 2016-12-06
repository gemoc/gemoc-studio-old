/**
 */
package tfsm_plaink3Trace.States;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tfsm_plaink3Trace.States.StatesFactory
 * @model kind="package"
 * @generated
 */
public interface StatesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "States";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tfsm_plaink3Trace_States";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tracedclasses";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatesPackage eINSTANCE = tfsm_plaink3Trace.States.impl.StatesPackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.Value <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.Value
	 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 6;

	/**
	 * The feature id for the '<em><b>States No Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__STATES_NO_OPPOSITE = 0;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.impl.FSMClock_numberOfTicks_ValueImpl <em>FSM Clock number Of Ticks Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.impl.FSMClock_numberOfTicks_ValueImpl
	 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getFSMClock_numberOfTicks_Value()
	 * @generated
	 */
	int FSM_CLOCK_NUMBER_OF_TICKS_VALUE = 0;

	/**
	 * The feature id for the '<em><b>States No Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES_NO_OPPOSITE = VALUE__STATES_NO_OPPOSITE;

	/**
	 * The feature id for the '<em><b>Number Of Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_NUMBER_OF_TICKS_VALUE__NUMBER_OF_TICKS = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>FSM Clock number Of Ticks Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_NUMBER_OF_TICKS_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get States No Opposite</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_NUMBER_OF_TICKS_VALUE___GET_STATES_NO_OPPOSITE = VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>FSM Clock number Of Ticks Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_CLOCK_NUMBER_OF_TICKS_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.impl.FSMEvent_isTriggered_ValueImpl <em>FSM Event is Triggered Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.impl.FSMEvent_isTriggered_ValueImpl
	 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getFSMEvent_isTriggered_Value()
	 * @generated
	 */
	int FSM_EVENT_IS_TRIGGERED_VALUE = 1;

	/**
	 * The feature id for the '<em><b>States No Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_IS_TRIGGERED_VALUE__STATES_NO_OPPOSITE = VALUE__STATES_NO_OPPOSITE;

	/**
	 * The feature id for the '<em><b>Is Triggered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_IS_TRIGGERED_VALUE__IS_TRIGGERED = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_IS_TRIGGERED_VALUE__PARENT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_IS_TRIGGERED_VALUE__STATES = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>FSM Event is Triggered Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_IS_TRIGGERED_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get States No Opposite</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_IS_TRIGGERED_VALUE___GET_STATES_NO_OPPOSITE = VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>FSM Event is Triggered Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_EVENT_IS_TRIGGERED_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.impl.StateImpl
	 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getState()
	 * @generated
	 */
	int STATE = 2;

	/**
	 * The feature id for the '<em><b>Ended Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ENDED_STEPS = 0;

	/**
	 * The feature id for the '<em><b>FSM Clock number Of Ticks Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES = 1;

	/**
	 * The feature id for the '<em><b>FSM Event is Triggered Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__FSM_EVENT_IS_TRIGGERED_VALUES = 2;

	/**
	 * The feature id for the '<em><b>Started Steps</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__STARTED_STEPS = 3;

	/**
	 * The feature id for the '<em><b>TFSM current State Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TFSM_CURRENT_STATE_VALUES = 4;

	/**
	 * The feature id for the '<em><b>TFSM last State Change Step Number Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES = 5;

	/**
	 * The feature id for the '<em><b>TFSM step Number Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TFSM_STEP_NUMBER_VALUES = 6;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.impl.TFSM_currentState_ValueImpl <em>TFSM current State Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.impl.TFSM_currentState_ValueImpl
	 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getTFSM_currentState_Value()
	 * @generated
	 */
	int TFSM_CURRENT_STATE_VALUE = 3;

	/**
	 * The feature id for the '<em><b>States No Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CURRENT_STATE_VALUE__STATES_NO_OPPOSITE = VALUE__STATES_NO_OPPOSITE;

	/**
	 * The feature id for the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CURRENT_STATE_VALUE__CURRENT_STATE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CURRENT_STATE_VALUE__PARENT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CURRENT_STATE_VALUE__STATES = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TFSM current State Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CURRENT_STATE_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get States No Opposite</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CURRENT_STATE_VALUE___GET_STATES_NO_OPPOSITE = VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TFSM current State Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_CURRENT_STATE_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.impl.TFSM_lastStateChangeStepNumber_ValueImpl <em>TFSM last State Change Step Number Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.impl.TFSM_lastStateChangeStepNumber_ValueImpl
	 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getTFSM_lastStateChangeStepNumber_Value()
	 * @generated
	 */
	int TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE = 4;

	/**
	 * The feature id for the '<em><b>States No Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__STATES_NO_OPPOSITE = VALUE__STATES_NO_OPPOSITE;

	/**
	 * The feature id for the '<em><b>Last State Change Step Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__LAST_STATE_CHANGE_STEP_NUMBER = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__PARENT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__STATES = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TFSM last State Change Step Number Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get States No Opposite</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE___GET_STATES_NO_OPPOSITE = VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TFSM last State Change Step Number Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.impl.TFSM_stepNumber_ValueImpl <em>TFSM step Number Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.impl.TFSM_stepNumber_ValueImpl
	 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getTFSM_stepNumber_Value()
	 * @generated
	 */
	int TFSM_STEP_NUMBER_VALUE = 5;

	/**
	 * The feature id for the '<em><b>States No Opposite</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STEP_NUMBER_VALUE__STATES_NO_OPPOSITE = VALUE__STATES_NO_OPPOSITE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STEP_NUMBER_VALUE__PARENT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STEP_NUMBER_VALUE__STATES = VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Step Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STEP_NUMBER_VALUE__STEP_NUMBER = VALUE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TFSM step Number Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STEP_NUMBER_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get States No Opposite</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STEP_NUMBER_VALUE___GET_STATES_NO_OPPOSITE = VALUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>TFSM step Number Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STEP_NUMBER_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value <em>FSM Clock number Of Ticks Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Clock number Of Ticks Value</em>'.
	 * @see tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value
	 * @generated
	 */
	EClass getFSMClock_numberOfTicks_Value();

	/**
	 * Returns the meta object for the attribute '{@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getNumberOfTicks <em>Number Of Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Ticks</em>'.
	 * @see tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getNumberOfTicks()
	 * @see #getFSMClock_numberOfTicks_Value()
	 * @generated
	 */
	EAttribute getFSMClock_numberOfTicks_Value_NumberOfTicks();

	/**
	 * Returns the meta object for the container reference '{@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getParent()
	 * @see #getFSMClock_numberOfTicks_Value()
	 * @generated
	 */
	EReference getFSMClock_numberOfTicks_Value_Parent();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>States</em>'.
	 * @see tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getStates()
	 * @see #getFSMClock_numberOfTicks_Value()
	 * @generated
	 */
	EReference getFSMClock_numberOfTicks_Value_States();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getStatesNoOpposite() <em>Get States No Opposite</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get States No Opposite</em>' operation.
	 * @see tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value#getStatesNoOpposite()
	 * @generated
	 */
	EOperation getFSMClock_numberOfTicks_Value__GetStatesNoOpposite();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value <em>FSM Event is Triggered Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>FSM Event is Triggered Value</em>'.
	 * @see tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value
	 * @generated
	 */
	EClass getFSMEvent_isTriggered_Value();

	/**
	 * Returns the meta object for the attribute '{@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#isIsTriggered <em>Is Triggered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Triggered</em>'.
	 * @see tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#isIsTriggered()
	 * @see #getFSMEvent_isTriggered_Value()
	 * @generated
	 */
	EAttribute getFSMEvent_isTriggered_Value_IsTriggered();

	/**
	 * Returns the meta object for the container reference '{@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getParent()
	 * @see #getFSMEvent_isTriggered_Value()
	 * @generated
	 */
	EReference getFSMEvent_isTriggered_Value_Parent();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>States</em>'.
	 * @see tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getStates()
	 * @see #getFSMEvent_isTriggered_Value()
	 * @generated
	 */
	EReference getFSMEvent_isTriggered_Value_States();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getStatesNoOpposite() <em>Get States No Opposite</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get States No Opposite</em>' operation.
	 * @see tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value#getStatesNoOpposite()
	 * @generated
	 */
	EOperation getFSMEvent_isTriggered_Value__GetStatesNoOpposite();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see tfsm_plaink3Trace.States.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.State#getEndedSteps <em>Ended Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ended Steps</em>'.
	 * @see tfsm_plaink3Trace.States.State#getEndedSteps()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_EndedSteps();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.State#getFSMClock_numberOfTicks_Values <em>FSM Clock number Of Ticks Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>FSM Clock number Of Ticks Values</em>'.
	 * @see tfsm_plaink3Trace.States.State#getFSMClock_numberOfTicks_Values()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_FSMClock_numberOfTicks_Values();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.State#getFSMEvent_isTriggered_Values <em>FSM Event is Triggered Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>FSM Event is Triggered Values</em>'.
	 * @see tfsm_plaink3Trace.States.State#getFSMEvent_isTriggered_Values()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_FSMEvent_isTriggered_Values();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.State#getStartedSteps <em>Started Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Started Steps</em>'.
	 * @see tfsm_plaink3Trace.States.State#getStartedSteps()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_StartedSteps();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.State#getTFSM_currentState_Values <em>TFSM current State Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>TFSM current State Values</em>'.
	 * @see tfsm_plaink3Trace.States.State#getTFSM_currentState_Values()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_TFSM_currentState_Values();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.State#getTFSM_lastStateChangeStepNumber_Values <em>TFSM last State Change Step Number Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>TFSM last State Change Step Number Values</em>'.
	 * @see tfsm_plaink3Trace.States.State#getTFSM_lastStateChangeStepNumber_Values()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_TFSM_lastStateChangeStepNumber_Values();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.State#getTFSM_stepNumber_Values <em>TFSM step Number Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>TFSM step Number Values</em>'.
	 * @see tfsm_plaink3Trace.States.State#getTFSM_stepNumber_Values()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_TFSM_stepNumber_Values();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value <em>TFSM current State Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFSM current State Value</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value
	 * @generated
	 */
	EClass getTFSM_currentState_Value();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value#getCurrentState <em>Current State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current State</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value#getCurrentState()
	 * @see #getTFSM_currentState_Value()
	 * @generated
	 */
	EReference getTFSM_currentState_Value_CurrentState();

	/**
	 * Returns the meta object for the container reference '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value#getParent()
	 * @see #getTFSM_currentState_Value()
	 * @generated
	 */
	EReference getTFSM_currentState_Value_Parent();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>States</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value#getStates()
	 * @see #getTFSM_currentState_Value()
	 * @generated
	 */
	EReference getTFSM_currentState_Value_States();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value#getStatesNoOpposite() <em>Get States No Opposite</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get States No Opposite</em>' operation.
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value#getStatesNoOpposite()
	 * @generated
	 */
	EOperation getTFSM_currentState_Value__GetStatesNoOpposite();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value <em>TFSM last State Change Step Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFSM last State Change Step Number Value</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value
	 * @generated
	 */
	EClass getTFSM_lastStateChangeStepNumber_Value();

	/**
	 * Returns the meta object for the attribute '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last State Change Step Number</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getLastStateChangeStepNumber()
	 * @see #getTFSM_lastStateChangeStepNumber_Value()
	 * @generated
	 */
	EAttribute getTFSM_lastStateChangeStepNumber_Value_LastStateChangeStepNumber();

	/**
	 * Returns the meta object for the container reference '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getParent()
	 * @see #getTFSM_lastStateChangeStepNumber_Value()
	 * @generated
	 */
	EReference getTFSM_lastStateChangeStepNumber_Value_Parent();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>States</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getStates()
	 * @see #getTFSM_lastStateChangeStepNumber_Value()
	 * @generated
	 */
	EReference getTFSM_lastStateChangeStepNumber_Value_States();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getStatesNoOpposite() <em>Get States No Opposite</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get States No Opposite</em>' operation.
	 * @see tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value#getStatesNoOpposite()
	 * @generated
	 */
	EOperation getTFSM_lastStateChangeStepNumber_Value__GetStatesNoOpposite();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.TFSM_stepNumber_Value <em>TFSM step Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFSM step Number Value</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_stepNumber_Value
	 * @generated
	 */
	EClass getTFSM_stepNumber_Value();

	/**
	 * Returns the meta object for the container reference '{@link tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getParent()
	 * @see #getTFSM_stepNumber_Value()
	 * @generated
	 */
	EReference getTFSM_stepNumber_Value_Parent();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>States</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getStates()
	 * @see #getTFSM_stepNumber_Value()
	 * @generated
	 */
	EReference getTFSM_stepNumber_Value_States();

	/**
	 * Returns the meta object for the attribute '{@link tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getStepNumber <em>Step Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Number</em>'.
	 * @see tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getStepNumber()
	 * @see #getTFSM_stepNumber_Value()
	 * @generated
	 */
	EAttribute getTFSM_stepNumber_Value_StepNumber();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getStatesNoOpposite() <em>Get States No Opposite</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get States No Opposite</em>' operation.
	 * @see tfsm_plaink3Trace.States.TFSM_stepNumber_Value#getStatesNoOpposite()
	 * @generated
	 */
	EOperation getTFSM_stepNumber_Value__GetStatesNoOpposite();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see tfsm_plaink3Trace.States.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the reference list '{@link tfsm_plaink3Trace.States.Value#getStatesNoOpposite <em>States No Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>States No Opposite</em>'.
	 * @see tfsm_plaink3Trace.States.Value#getStatesNoOpposite()
	 * @see #getValue()
	 * @generated
	 */
	EReference getValue_StatesNoOpposite();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatesFactory getStatesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.impl.FSMClock_numberOfTicks_ValueImpl <em>FSM Clock number Of Ticks Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.impl.FSMClock_numberOfTicks_ValueImpl
		 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getFSMClock_numberOfTicks_Value()
		 * @generated
		 */
		EClass FSM_CLOCK_NUMBER_OF_TICKS_VALUE = eINSTANCE.getFSMClock_numberOfTicks_Value();

		/**
		 * The meta object literal for the '<em><b>Number Of Ticks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_CLOCK_NUMBER_OF_TICKS_VALUE__NUMBER_OF_TICKS = eINSTANCE.getFSMClock_numberOfTicks_Value_NumberOfTicks();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT = eINSTANCE.getFSMClock_numberOfTicks_Value_Parent();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES = eINSTANCE.getFSMClock_numberOfTicks_Value_States();

		/**
		 * The meta object literal for the '<em><b>Get States No Opposite</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FSM_CLOCK_NUMBER_OF_TICKS_VALUE___GET_STATES_NO_OPPOSITE = eINSTANCE.getFSMClock_numberOfTicks_Value__GetStatesNoOpposite();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.impl.FSMEvent_isTriggered_ValueImpl <em>FSM Event is Triggered Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.impl.FSMEvent_isTriggered_ValueImpl
		 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getFSMEvent_isTriggered_Value()
		 * @generated
		 */
		EClass FSM_EVENT_IS_TRIGGERED_VALUE = eINSTANCE.getFSMEvent_isTriggered_Value();

		/**
		 * The meta object literal for the '<em><b>Is Triggered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FSM_EVENT_IS_TRIGGERED_VALUE__IS_TRIGGERED = eINSTANCE.getFSMEvent_isTriggered_Value_IsTriggered();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_EVENT_IS_TRIGGERED_VALUE__PARENT = eINSTANCE.getFSMEvent_isTriggered_Value_Parent();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FSM_EVENT_IS_TRIGGERED_VALUE__STATES = eINSTANCE.getFSMEvent_isTriggered_Value_States();

		/**
		 * The meta object literal for the '<em><b>Get States No Opposite</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FSM_EVENT_IS_TRIGGERED_VALUE___GET_STATES_NO_OPPOSITE = eINSTANCE.getFSMEvent_isTriggered_Value__GetStatesNoOpposite();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.impl.StateImpl
		 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Ended Steps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ENDED_STEPS = eINSTANCE.getState_EndedSteps();

		/**
		 * The meta object literal for the '<em><b>FSM Clock number Of Ticks Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES = eINSTANCE.getState_FSMClock_numberOfTicks_Values();

		/**
		 * The meta object literal for the '<em><b>FSM Event is Triggered Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__FSM_EVENT_IS_TRIGGERED_VALUES = eINSTANCE.getState_FSMEvent_isTriggered_Values();

		/**
		 * The meta object literal for the '<em><b>Started Steps</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__STARTED_STEPS = eINSTANCE.getState_StartedSteps();

		/**
		 * The meta object literal for the '<em><b>TFSM current State Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__TFSM_CURRENT_STATE_VALUES = eINSTANCE.getState_TFSM_currentState_Values();

		/**
		 * The meta object literal for the '<em><b>TFSM last State Change Step Number Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES = eINSTANCE.getState_TFSM_lastStateChangeStepNumber_Values();

		/**
		 * The meta object literal for the '<em><b>TFSM step Number Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__TFSM_STEP_NUMBER_VALUES = eINSTANCE.getState_TFSM_stepNumber_Values();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.impl.TFSM_currentState_ValueImpl <em>TFSM current State Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.impl.TFSM_currentState_ValueImpl
		 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getTFSM_currentState_Value()
		 * @generated
		 */
		EClass TFSM_CURRENT_STATE_VALUE = eINSTANCE.getTFSM_currentState_Value();

		/**
		 * The meta object literal for the '<em><b>Current State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_CURRENT_STATE_VALUE__CURRENT_STATE = eINSTANCE.getTFSM_currentState_Value_CurrentState();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_CURRENT_STATE_VALUE__PARENT = eINSTANCE.getTFSM_currentState_Value_Parent();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_CURRENT_STATE_VALUE__STATES = eINSTANCE.getTFSM_currentState_Value_States();

		/**
		 * The meta object literal for the '<em><b>Get States No Opposite</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_CURRENT_STATE_VALUE___GET_STATES_NO_OPPOSITE = eINSTANCE.getTFSM_currentState_Value__GetStatesNoOpposite();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.impl.TFSM_lastStateChangeStepNumber_ValueImpl <em>TFSM last State Change Step Number Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.impl.TFSM_lastStateChangeStepNumber_ValueImpl
		 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getTFSM_lastStateChangeStepNumber_Value()
		 * @generated
		 */
		EClass TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE = eINSTANCE.getTFSM_lastStateChangeStepNumber_Value();

		/**
		 * The meta object literal for the '<em><b>Last State Change Step Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__LAST_STATE_CHANGE_STEP_NUMBER = eINSTANCE.getTFSM_lastStateChangeStepNumber_Value_LastStateChangeStepNumber();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__PARENT = eINSTANCE.getTFSM_lastStateChangeStepNumber_Value_Parent();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__STATES = eINSTANCE.getTFSM_lastStateChangeStepNumber_Value_States();

		/**
		 * The meta object literal for the '<em><b>Get States No Opposite</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE___GET_STATES_NO_OPPOSITE = eINSTANCE.getTFSM_lastStateChangeStepNumber_Value__GetStatesNoOpposite();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.impl.TFSM_stepNumber_ValueImpl <em>TFSM step Number Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.impl.TFSM_stepNumber_ValueImpl
		 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getTFSM_stepNumber_Value()
		 * @generated
		 */
		EClass TFSM_STEP_NUMBER_VALUE = eINSTANCE.getTFSM_stepNumber_Value();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_STEP_NUMBER_VALUE__PARENT = eINSTANCE.getTFSM_stepNumber_Value_Parent();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_STEP_NUMBER_VALUE__STATES = eINSTANCE.getTFSM_stepNumber_Value_States();

		/**
		 * The meta object literal for the '<em><b>Step Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFSM_STEP_NUMBER_VALUE__STEP_NUMBER = eINSTANCE.getTFSM_stepNumber_Value_StepNumber();

		/**
		 * The meta object literal for the '<em><b>Get States No Opposite</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_STEP_NUMBER_VALUE___GET_STATES_NO_OPPOSITE = eINSTANCE.getTFSM_stepNumber_Value__GetStatesNoOpposite();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.Value <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.Value
		 * @see tfsm_plaink3Trace.States.impl.StatesPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>States No Opposite</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE__STATES_NO_OPPOSITE = eINSTANCE.getValue_StatesNoOpposite();

	}

} //StatesPackage
