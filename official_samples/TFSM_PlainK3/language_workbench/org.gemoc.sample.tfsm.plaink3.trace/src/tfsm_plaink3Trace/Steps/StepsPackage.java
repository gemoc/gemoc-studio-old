/**
 */
package tfsm_plaink3Trace.Steps;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gemoc.executionframework.engine.mse.MsePackage;

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
 * @see tfsm_plaink3Trace.Steps.StepsFactory
 * @model kind="package"
 * @generated
 */
public interface StepsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Steps";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tfsm_plaink3Trace_Steps";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "events";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StepsPackage eINSTANCE = tfsm_plaink3Trace.Steps.impl.StepsPackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.StepImpl <em>Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.StepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getStep()
	 * @generated
	 */
	int STEP = 3;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__MSE = MsePackage.MSE_OCCURRENCE__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__PARAMETERS = MsePackage.MSE_OCCURRENCE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__RESULT = MsePackage.MSE_OCCURRENCE__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__LOGICAL_STEP = MsePackage.MSE_OCCURRENCE__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__ENDING_STATE = MsePackage.MSE_OCCURRENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP__STARTING_STATE = MsePackage.MSE_OCCURRENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_FEATURE_COUNT = MsePackage.MSE_OCCURRENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_OPERATION_COUNT = MsePackage.MSE_OCCURRENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.BigStepImpl <em>Big Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.BigStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getBigStep()
	 * @generated
	 */
	int BIG_STEP = 0;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_STEP__MSE = STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_STEP__PARAMETERS = STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_STEP__RESULT = STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_STEP__LOGICAL_STEP = STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_STEP__ENDING_STATE = STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_STEP__STARTING_STATE = STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Big Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Big Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIG_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.SmallStepImpl <em>Small Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.SmallStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getSmallStep()
	 * @generated
	 */
	int SMALL_STEP = 2;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_STEP__MSE = STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_STEP__PARAMETERS = STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_STEP__RESULT = STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_STEP__LOGICAL_STEP = STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_STEP__ENDING_STATE = STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_STEP__STARTING_STATE = STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Small Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_STEP_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Small Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMALL_STEP_OPERATION_COUNT = STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.RootImplicitStepImpl <em>Root Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.RootImplicitStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getRootImplicitStep()
	 * @generated
	 */
	int ROOT_IMPLICIT_STEP = 1;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP__MSE = SMALL_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP__PARAMETERS = SMALL_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP__RESULT = SMALL_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP__LOGICAL_STEP = SMALL_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP__ENDING_STATE = SMALL_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP__STARTING_STATE = SMALL_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Root Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP_FEATURE_COUNT = SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Root Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP_OPERATION_COUNT = SMALL_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMClock_TicksImpl <em>Tfsm plaink3 FSM Clock Ticks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMClock_TicksImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMClock_Ticks()
	 * @generated
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS = 4;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__MSE = SMALL_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__PARAMETERS = SMALL_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__RESULT = SMALL_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__LOGICAL_STEP = SMALL_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__ENDING_STATE = SMALL_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__STARTING_STATE = SMALL_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 FSM Clock Ticks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS_FEATURE_COUNT = SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS___GET_CALLER = SMALL_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 FSM Clock Ticks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS_OPERATION_COUNT = SMALL_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_TriggerImpl <em>Tfsm plaink3 FSM Event Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_TriggerImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMEvent_Trigger()
	 * @generated
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER = 5;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__MSE = SMALL_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__PARAMETERS = SMALL_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__RESULT = SMALL_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__LOGICAL_STEP = SMALL_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__ENDING_STATE = SMALL_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__STARTING_STATE = SMALL_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 FSM Event Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER_FEATURE_COUNT = SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER___GET_CALLER = SMALL_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 FSM Event Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER_OPERATION_COUNT = SMALL_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_UnTriggerImpl <em>Tfsm plaink3 FSM Event Un Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_UnTriggerImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMEvent_UnTrigger()
	 * @generated
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER = 6;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__MSE = SMALL_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__PARAMETERS = SMALL_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__RESULT = SMALL_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__LOGICAL_STEP = SMALL_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__ENDING_STATE = SMALL_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__STARTING_STATE = SMALL_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 FSM Event Un Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_FEATURE_COUNT = SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER___GET_CALLER = SMALL_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 FSM Event Un Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_OPERATION_COUNT = SMALL_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_VisitImpl <em>Tfsm plaink3 State Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_VisitImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit()
	 * @generated
	 */
	int TFSM_PLAINK3_STATE_VISIT = 7;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__MSE = BIG_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__PARAMETERS = BIG_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__RESULT = BIG_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__LOGICAL_STEP = BIG_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__ENDING_STATE = BIG_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__STARTING_STATE = BIG_STEP__STARTING_STATE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__SUB_STEPS = BIG_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 State Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_FEATURE_COUNT = BIG_STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT___GET_CALLER = BIG_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 State Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_OPERATION_COUNT = BIG_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_AbstractSubStepImpl <em>Tfsm plaink3 State Visit Abstract Sub Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_AbstractSubStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit_AbstractSubStep()
	 * @generated
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP = 8;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 State Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 State Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_ImplicitStepImpl <em>Tfsm plaink3 State Visit Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_ImplicitStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit_ImplicitStep()
	 * @generated
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP = 9;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__MSE = SMALL_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__PARAMETERS = SMALL_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__RESULT = SMALL_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__LOGICAL_STEP = SMALL_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__ENDING_STATE = SMALL_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__STARTING_STATE = SMALL_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 State Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP_FEATURE_COUNT = SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 State Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP_OPERATION_COUNT = SMALL_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_TFSM_InitImpl <em>Tfsm plaink3 TFSM Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_TFSM_InitImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_TFSM_Init()
	 * @generated
	 */
	int TFSM_PLAINK3_TFSM_INIT = 10;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__MSE = SMALL_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__PARAMETERS = SMALL_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__RESULT = SMALL_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__LOGICAL_STEP = SMALL_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__ENDING_STATE = SMALL_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__STARTING_STATE = SMALL_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 TFSM Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT_FEATURE_COUNT = SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT___GET_CALLER = SMALL_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 TFSM Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT_OPERATION_COUNT = SMALL_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_FireImpl <em>Tfsm plaink3 Transition Fire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_FireImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Fire()
	 * @generated
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE = 11;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__MSE = SMALL_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__PARAMETERS = SMALL_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__RESULT = SMALL_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__LOGICAL_STEP = SMALL_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__ENDING_STATE = SMALL_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__STARTING_STATE = SMALL_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 Transition Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE_FEATURE_COUNT = SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE___GET_CALLER = SMALL_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 Transition Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE_OPERATION_COUNT = SMALL_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl <em>Tfsm plaink3 Transition Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit()
	 * @generated
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT = 12;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__MSE = BIG_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__PARAMETERS = BIG_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__RESULT = BIG_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__LOGICAL_STEP = BIG_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE = BIG_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE = BIG_STEP__STARTING_STATE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS = BIG_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 Transition Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_FEATURE_COUNT = BIG_STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT___GET_CALLER = BIG_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 Transition Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_OPERATION_COUNT = BIG_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_AbstractSubStepImpl <em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_AbstractSubStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit_AbstractSubStep()
	 * @generated
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP = 13;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_ImplicitStepImpl <em>Tfsm plaink3 Transition Visit Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_ImplicitStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit_ImplicitStep()
	 * @generated
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP = 14;

	/**
	 * The feature id for the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__MSE = SMALL_STEP__MSE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__PARAMETERS = SMALL_STEP__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__RESULT = SMALL_STEP__RESULT;

	/**
	 * The feature id for the '<em><b>Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__LOGICAL_STEP = SMALL_STEP__LOGICAL_STEP;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__ENDING_STATE = SMALL_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__STARTING_STATE = SMALL_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 Transition Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP_FEATURE_COUNT = SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 Transition Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP_OPERATION_COUNT = SMALL_STEP_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.BigStep <em>Big Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Big Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.BigStep
	 * @generated
	 */
	EClass getBigStep();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.RootImplicitStep <em>Root Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Implicit Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.RootImplicitStep
	 * @generated
	 */
	EClass getRootImplicitStep();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.SmallStep <em>Small Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Small Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.SmallStep
	 * @generated
	 */
	EClass getSmallStep();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.Step
	 * @generated
	 */
	EClass getStep();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.Steps.Step#getEndingState <em>Ending State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ending State</em>'.
	 * @see tfsm_plaink3Trace.Steps.Step#getEndingState()
	 * @see #getStep()
	 * @generated
	 */
	EReference getStep_EndingState();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.Steps.Step#getStartingState <em>Starting State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Starting State</em>'.
	 * @see tfsm_plaink3Trace.Steps.Step#getStartingState()
	 * @see #getStep()
	 * @generated
	 */
	EReference getStep_StartingState();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks <em>Tfsm plaink3 FSM Clock Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 FSM Clock Ticks</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks
	 * @generated
	 */
	EClass getTfsm_plaink3_FSMClock_Ticks();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks#getCaller() <em>Get Caller</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Caller</em>' operation.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks#getCaller()
	 * @generated
	 */
	EOperation getTfsm_plaink3_FSMClock_Ticks__GetCaller();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger <em>Tfsm plaink3 FSM Event Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 FSM Event Trigger</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger
	 * @generated
	 */
	EClass getTfsm_plaink3_FSMEvent_Trigger();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger#getCaller() <em>Get Caller</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Caller</em>' operation.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger#getCaller()
	 * @generated
	 */
	EOperation getTfsm_plaink3_FSMEvent_Trigger__GetCaller();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger <em>Tfsm plaink3 FSM Event Un Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 FSM Event Un Trigger</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger
	 * @generated
	 */
	EClass getTfsm_plaink3_FSMEvent_UnTrigger();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger#getCaller() <em>Get Caller</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Caller</em>' operation.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger#getCaller()
	 * @generated
	 */
	EOperation getTfsm_plaink3_FSMEvent_UnTrigger__GetCaller();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit <em>Tfsm plaink3 State Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 State Visit</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit
	 * @generated
	 */
	EClass getTfsm_plaink3_State_Visit();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit#getSubSteps <em>Sub Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Steps</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit#getSubSteps()
	 * @see #getTfsm_plaink3_State_Visit()
	 * @generated
	 */
	EReference getTfsm_plaink3_State_Visit_SubSteps();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit#getCaller() <em>Get Caller</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Caller</em>' operation.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit#getCaller()
	 * @generated
	 */
	EOperation getTfsm_plaink3_State_Visit__GetCaller();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_AbstractSubStep <em>Tfsm plaink3 State Visit Abstract Sub Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 State Visit Abstract Sub Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_AbstractSubStep
	 * @generated
	 */
	EClass getTfsm_plaink3_State_Visit_AbstractSubStep();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_ImplicitStep <em>Tfsm plaink3 State Visit Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 State Visit Implicit Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_ImplicitStep
	 * @generated
	 */
	EClass getTfsm_plaink3_State_Visit_ImplicitStep();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init <em>Tfsm plaink3 TFSM Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 TFSM Init</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init
	 * @generated
	 */
	EClass getTfsm_plaink3_TFSM_Init();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init#getCaller() <em>Get Caller</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Caller</em>' operation.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init#getCaller()
	 * @generated
	 */
	EOperation getTfsm_plaink3_TFSM_Init__GetCaller();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire <em>Tfsm plaink3 Transition Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 Transition Fire</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire
	 * @generated
	 */
	EClass getTfsm_plaink3_Transition_Fire();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire#getCaller() <em>Get Caller</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Caller</em>' operation.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire#getCaller()
	 * @generated
	 */
	EOperation getTfsm_plaink3_Transition_Fire__GetCaller();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit <em>Tfsm plaink3 Transition Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 Transition Visit</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit
	 * @generated
	 */
	EClass getTfsm_plaink3_Transition_Visit();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit#getSubSteps <em>Sub Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Steps</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit#getSubSteps()
	 * @see #getTfsm_plaink3_Transition_Visit()
	 * @generated
	 */
	EReference getTfsm_plaink3_Transition_Visit_SubSteps();

	/**
	 * Returns the meta object for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit#getCaller() <em>Get Caller</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Caller</em>' operation.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit#getCaller()
	 * @generated
	 */
	EOperation getTfsm_plaink3_Transition_Visit__GetCaller();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep <em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep
	 * @generated
	 */
	EClass getTfsm_plaink3_Transition_Visit_AbstractSubStep();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_ImplicitStep <em>Tfsm plaink3 Transition Visit Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm plaink3 Transition Visit Implicit Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_ImplicitStep
	 * @generated
	 */
	EClass getTfsm_plaink3_Transition_Visit_ImplicitStep();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StepsFactory getStepsFactory();

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
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.BigStepImpl <em>Big Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.BigStepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getBigStep()
		 * @generated
		 */
		EClass BIG_STEP = eINSTANCE.getBigStep();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.RootImplicitStepImpl <em>Root Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.RootImplicitStepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getRootImplicitStep()
		 * @generated
		 */
		EClass ROOT_IMPLICIT_STEP = eINSTANCE.getRootImplicitStep();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.SmallStepImpl <em>Small Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.SmallStepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getSmallStep()
		 * @generated
		 */
		EClass SMALL_STEP = eINSTANCE.getSmallStep();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.StepImpl <em>Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.StepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getStep()
		 * @generated
		 */
		EClass STEP = eINSTANCE.getStep();

		/**
		 * The meta object literal for the '<em><b>Ending State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP__ENDING_STATE = eINSTANCE.getStep_EndingState();

		/**
		 * The meta object literal for the '<em><b>Starting State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP__STARTING_STATE = eINSTANCE.getStep_StartingState();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMClock_TicksImpl <em>Tfsm plaink3 FSM Clock Ticks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMClock_TicksImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMClock_Ticks()
		 * @generated
		 */
		EClass TFSM_PLAINK3_FSM_CLOCK_TICKS = eINSTANCE.getTfsm_plaink3_FSMClock_Ticks();

		/**
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_FSM_CLOCK_TICKS___GET_CALLER = eINSTANCE.getTfsm_plaink3_FSMClock_Ticks__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_TriggerImpl <em>Tfsm plaink3 FSM Event Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_TriggerImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMEvent_Trigger()
		 * @generated
		 */
		EClass TFSM_PLAINK3_FSM_EVENT_TRIGGER = eINSTANCE.getTfsm_plaink3_FSMEvent_Trigger();

		/**
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_FSM_EVENT_TRIGGER___GET_CALLER = eINSTANCE.getTfsm_plaink3_FSMEvent_Trigger__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_UnTriggerImpl <em>Tfsm plaink3 FSM Event Un Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_UnTriggerImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMEvent_UnTrigger()
		 * @generated
		 */
		EClass TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER = eINSTANCE.getTfsm_plaink3_FSMEvent_UnTrigger();

		/**
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER___GET_CALLER = eINSTANCE.getTfsm_plaink3_FSMEvent_UnTrigger__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_VisitImpl <em>Tfsm plaink3 State Visit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_VisitImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit()
		 * @generated
		 */
		EClass TFSM_PLAINK3_STATE_VISIT = eINSTANCE.getTfsm_plaink3_State_Visit();

		/**
		 * The meta object literal for the '<em><b>Sub Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_PLAINK3_STATE_VISIT__SUB_STEPS = eINSTANCE.getTfsm_plaink3_State_Visit_SubSteps();

		/**
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_STATE_VISIT___GET_CALLER = eINSTANCE.getTfsm_plaink3_State_Visit__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_AbstractSubStepImpl <em>Tfsm plaink3 State Visit Abstract Sub Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_AbstractSubStepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit_AbstractSubStep()
		 * @generated
		 */
		EClass TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP = eINSTANCE.getTfsm_plaink3_State_Visit_AbstractSubStep();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_ImplicitStepImpl <em>Tfsm plaink3 State Visit Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_ImplicitStepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit_ImplicitStep()
		 * @generated
		 */
		EClass TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP = eINSTANCE.getTfsm_plaink3_State_Visit_ImplicitStep();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_TFSM_InitImpl <em>Tfsm plaink3 TFSM Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_TFSM_InitImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_TFSM_Init()
		 * @generated
		 */
		EClass TFSM_PLAINK3_TFSM_INIT = eINSTANCE.getTfsm_plaink3_TFSM_Init();

		/**
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_TFSM_INIT___GET_CALLER = eINSTANCE.getTfsm_plaink3_TFSM_Init__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_FireImpl <em>Tfsm plaink3 Transition Fire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_FireImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Fire()
		 * @generated
		 */
		EClass TFSM_PLAINK3_TRANSITION_FIRE = eINSTANCE.getTfsm_plaink3_Transition_Fire();

		/**
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_TRANSITION_FIRE___GET_CALLER = eINSTANCE.getTfsm_plaink3_Transition_Fire__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl <em>Tfsm plaink3 Transition Visit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit()
		 * @generated
		 */
		EClass TFSM_PLAINK3_TRANSITION_VISIT = eINSTANCE.getTfsm_plaink3_Transition_Visit();

		/**
		 * The meta object literal for the '<em><b>Sub Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS = eINSTANCE.getTfsm_plaink3_Transition_Visit_SubSteps();

		/**
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_TRANSITION_VISIT___GET_CALLER = eINSTANCE.getTfsm_plaink3_Transition_Visit__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_AbstractSubStepImpl <em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_AbstractSubStepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit_AbstractSubStep()
		 * @generated
		 */
		EClass TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP = eINSTANCE.getTfsm_plaink3_Transition_Visit_AbstractSubStep();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_ImplicitStepImpl <em>Tfsm plaink3 Transition Visit Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_ImplicitStepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit_ImplicitStep()
		 * @generated
		 */
		EClass TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP = eINSTANCE.getTfsm_plaink3_Transition_Visit_ImplicitStep();

	}

} //StepsPackage
