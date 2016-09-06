/**
 */
package tfsm_plaink3Trace.Steps;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

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
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.RootImplicitStepImpl <em>Root Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.RootImplicitStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getRootImplicitStep()
	 * @generated
	 */
	int ROOT_IMPLICIT_STEP = 0;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP__MSEOCCURRENCE = TracePackage.SMALL_STEP__MSEOCCURRENCE;

	/**
	 * The number of structural features of the '<em>Root Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP_FEATURE_COUNT = TracePackage.SMALL_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Root Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_IMPLICIT_STEP_OPERATION_COUNT = TracePackage.SMALL_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.SpecificStep <em>Specific Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.SpecificStep
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getSpecificStep()
	 * @generated
	 */
	int SPECIFIC_STEP = 1;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STEP__MSEOCCURRENCE = TracePackage.STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STEP__ENDING_STATE = TracePackage.STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STEP__STARTING_STATE = TracePackage.STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Specific Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STEP_FEATURE_COUNT = TracePackage.STEP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Specific Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STEP_OPERATION_COUNT = TracePackage.STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMClock_TicksImpl <em>Tfsm plaink3 FSM Clock Ticks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMClock_TicksImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMClock_Ticks()
	 * @generated
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS = 2;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 FSM Clock Ticks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS___GET_CALLER = SPECIFIC_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 FSM Clock Ticks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_CLOCK_TICKS_OPERATION_COUNT = SPECIFIC_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_TriggerImpl <em>Tfsm plaink3 FSM Event Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_TriggerImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMEvent_Trigger()
	 * @generated
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER = 3;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 FSM Event Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER___GET_CALLER = SPECIFIC_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 FSM Event Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_TRIGGER_OPERATION_COUNT = SPECIFIC_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_UnTriggerImpl <em>Tfsm plaink3 FSM Event Un Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_FSMEvent_UnTriggerImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_FSMEvent_UnTrigger()
	 * @generated
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER = 4;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 FSM Event Un Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER___GET_CALLER = SPECIFIC_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 FSM Event Un Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_OPERATION_COUNT = SPECIFIC_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_VisitImpl <em>Tfsm plaink3 State Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_VisitImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit()
	 * @generated
	 */
	int TFSM_PLAINK3_STATE_VISIT = 5;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT__SUB_STEPS = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 State Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT___GET_CALLER = SPECIFIC_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 State Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_OPERATION_COUNT = SPECIFIC_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_AbstractSubStep <em>Tfsm plaink3 State Visit Abstract Sub Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_AbstractSubStep
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit_AbstractSubStep()
	 * @generated
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP = 6;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 State Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 State Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_OPERATION_COUNT = SPECIFIC_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_ImplicitStepImpl <em>Tfsm plaink3 State Visit Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_State_Visit_ImplicitStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_State_Visit_ImplicitStep()
	 * @generated
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP = 7;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__MSEOCCURRENCE = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__ENDING_STATE = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP__STARTING_STATE = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 State Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP_FEATURE_COUNT = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 State Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_STATE_VISIT_IMPLICIT_STEP_OPERATION_COUNT = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_TFSM_InitImpl <em>Tfsm plaink3 TFSM Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_TFSM_InitImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_TFSM_Init()
	 * @generated
	 */
	int TFSM_PLAINK3_TFSM_INIT = 8;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 TFSM Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT___GET_CALLER = SPECIFIC_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 TFSM Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TFSM_INIT_OPERATION_COUNT = SPECIFIC_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_FireImpl <em>Tfsm plaink3 Transition Fire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_FireImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Fire()
	 * @generated
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE = 9;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 Transition Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE___GET_CALLER = SPECIFIC_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 Transition Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_FIRE_OPERATION_COUNT = SPECIFIC_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl <em>Tfsm plaink3 Transition Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit()
	 * @generated
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT = 10;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__MSEOCCURRENCE = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 Transition Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_FEATURE_COUNT = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Caller</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT___GET_CALLER = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 Transition Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_OPERATION_COUNT = TFSM_PLAINK3_STATE_VISIT_ABSTRACT_SUB_STEP_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep <em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit_AbstractSubStep()
	 * @generated
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP = 11;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP_OPERATION_COUNT = SPECIFIC_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_ImplicitStepImpl <em>Tfsm plaink3 Transition Visit Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_Visit_ImplicitStepImpl
	 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getTfsm_plaink3_Transition_Visit_ImplicitStep()
	 * @generated
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP = 12;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__MSEOCCURRENCE = TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__ENDING_STATE = TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP__STARTING_STATE = TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm plaink3 Transition Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP_FEATURE_COUNT = TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tfsm plaink3 Transition Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_PLAINK3_TRANSITION_VISIT_IMPLICIT_STEP_OPERATION_COUNT = TFSM_PLAINK3_TRANSITION_VISIT_ABSTRACT_SUB_STEP_OPERATION_COUNT + 0;


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
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.Steps.SpecificStep <em>Specific Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Step</em>'.
	 * @see tfsm_plaink3Trace.Steps.SpecificStep
	 * @generated
	 */
	EClass getSpecificStep();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.Steps.SpecificStep#getEndingState <em>Ending State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ending State</em>'.
	 * @see tfsm_plaink3Trace.Steps.SpecificStep#getEndingState()
	 * @see #getSpecificStep()
	 * @generated
	 */
	EReference getSpecificStep_EndingState();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.Steps.SpecificStep#getStartingState <em>Starting State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Starting State</em>'.
	 * @see tfsm_plaink3Trace.Steps.SpecificStep#getStartingState()
	 * @see #getSpecificStep()
	 * @generated
	 */
	EReference getSpecificStep_StartingState();

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
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.impl.RootImplicitStepImpl <em>Root Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.impl.RootImplicitStepImpl
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getRootImplicitStep()
		 * @generated
		 */
		EClass ROOT_IMPLICIT_STEP = eINSTANCE.getRootImplicitStep();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.SpecificStep <em>Specific Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.SpecificStep
		 * @see tfsm_plaink3Trace.Steps.impl.StepsPackageImpl#getSpecificStep()
		 * @generated
		 */
		EClass SPECIFIC_STEP = eINSTANCE.getSpecificStep();

		/**
		 * The meta object literal for the '<em><b>Ending State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_STEP__ENDING_STATE = eINSTANCE.getSpecificStep_EndingState();

		/**
		 * The meta object literal for the '<em><b>Starting State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_STEP__STARTING_STATE = eINSTANCE.getSpecificStep_StartingState();

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
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_STATE_VISIT___GET_CALLER = eINSTANCE.getTfsm_plaink3_State_Visit__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_AbstractSubStep <em>Tfsm plaink3 State Visit Abstract Sub Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit_AbstractSubStep
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
		 * The meta object literal for the '<em><b>Get Caller</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TFSM_PLAINK3_TRANSITION_VISIT___GET_CALLER = eINSTANCE.getTfsm_plaink3_Transition_Visit__GetCaller();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep <em>Tfsm plaink3 Transition Visit Abstract Sub Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep
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
