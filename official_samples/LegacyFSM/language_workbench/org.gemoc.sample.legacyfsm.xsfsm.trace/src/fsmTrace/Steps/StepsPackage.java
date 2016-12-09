/**
 */
package fsmTrace.Steps;

import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fsmTrace.Steps.StepsFactory
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
	String eNS_URI = "fsmTrace_Steps";

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
	StepsPackage eINSTANCE = fsmTrace.Steps.impl.StepsPackageImpl.init();

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.SpecificStep <em>Specific Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.SpecificStep
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getSpecificStep()
	 * @generated
	 */
	int SPECIFIC_STEP = 12;

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
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_FSMClock_TicksImpl <em>Fsm FSM Clock Ticks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_FSMClock_TicksImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_FSMClock_Ticks()
	 * @generated
	 */
	int FSM_FSM_CLOCK_TICKS = 0;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_CLOCK_TICKS__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_CLOCK_TICKS__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_CLOCK_TICKS__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm FSM Clock Ticks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_CLOCK_TICKS_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_FSMEvent_TriggerImpl <em>Fsm FSM Event Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_FSMEvent_TriggerImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_FSMEvent_Trigger()
	 * @generated
	 */
	int FSM_FSM_EVENT_TRIGGER = 1;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_EVENT_TRIGGER__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_EVENT_TRIGGER__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_EVENT_TRIGGER__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm FSM Event Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_EVENT_TRIGGER_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_FSMEvent_UnTriggerImpl <em>Fsm FSM Event Un Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_FSMEvent_UnTriggerImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_FSMEvent_UnTrigger()
	 * @generated
	 */
	int FSM_FSM_EVENT_UN_TRIGGER = 2;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_EVENT_UN_TRIGGER__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_EVENT_UN_TRIGGER__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_EVENT_UN_TRIGGER__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm FSM Event Un Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_FSM_EVENT_UN_TRIGGER_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_State_VisitImpl <em>Fsm State Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_State_VisitImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_State_Visit()
	 * @generated
	 */
	int FSM_STATE_VISIT = 3;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT__SUB_STEPS = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fsm State Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.Fsm_State_Visit_AbstractSubStep <em>Fsm State Visit Abstract Sub Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.Fsm_State_Visit_AbstractSubStep
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_State_Visit_AbstractSubStep()
	 * @generated
	 */
	int FSM_STATE_VISIT_ABSTRACT_SUB_STEP = 4;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm State Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_State_Visit_ImplicitStepImpl <em>Fsm State Visit Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_State_Visit_ImplicitStepImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_State_Visit_ImplicitStep()
	 * @generated
	 */
	int FSM_STATE_VISIT_IMPLICIT_STEP = 5;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_IMPLICIT_STEP__MSEOCCURRENCE = FSM_STATE_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_IMPLICIT_STEP__ENDING_STATE = FSM_STATE_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_IMPLICIT_STEP__STARTING_STATE = FSM_STATE_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm State Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_STATE_VISIT_IMPLICIT_STEP_FEATURE_COUNT = FSM_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_TimeFSM_InitImpl <em>Fsm Time FSM Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_TimeFSM_InitImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_TimeFSM_Init()
	 * @generated
	 */
	int FSM_TIME_FSM_INIT = 6;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TIME_FSM_INIT__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TIME_FSM_INIT__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TIME_FSM_INIT__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm Time FSM Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TIME_FSM_INIT_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.Fsm_Transition_Visit_AbstractSubStep <em>Fsm Transition Visit Abstract Sub Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.Fsm_Transition_Visit_AbstractSubStep
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_Transition_Visit_AbstractSubStep()
	 * @generated
	 */
	int FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP = 9;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm Transition Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_Transition_FireImpl <em>Fsm Transition Fire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_Transition_FireImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_Transition_Fire()
	 * @generated
	 */
	int FSM_TRANSITION_FIRE = 7;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_FIRE__MSEOCCURRENCE = FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_FIRE__ENDING_STATE = FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_FIRE__STARTING_STATE = FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm Transition Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_FIRE_FEATURE_COUNT = FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_Transition_VisitImpl <em>Fsm Transition Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_Transition_VisitImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_Transition_Visit()
	 * @generated
	 */
	int FSM_TRANSITION_VISIT = 8;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT__MSEOCCURRENCE = FSM_STATE_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT__ENDING_STATE = FSM_STATE_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT__STARTING_STATE = FSM_STATE_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT__SUB_STEPS = FSM_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fsm Transition Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_FEATURE_COUNT = FSM_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.Fsm_Transition_Visit_ImplicitStepImpl <em>Fsm Transition Visit Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.Fsm_Transition_Visit_ImplicitStepImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_Transition_Visit_ImplicitStep()
	 * @generated
	 */
	int FSM_TRANSITION_VISIT_IMPLICIT_STEP = 10;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_IMPLICIT_STEP__MSEOCCURRENCE = FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_IMPLICIT_STEP__ENDING_STATE = FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_IMPLICIT_STEP__STARTING_STATE = FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Fsm Transition Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FSM_TRANSITION_VISIT_IMPLICIT_STEP_FEATURE_COUNT = FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fsmTrace.Steps.impl.RootImplicitStepImpl <em>Root Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fsmTrace.Steps.impl.RootImplicitStepImpl
	 * @see fsmTrace.Steps.impl.StepsPackageImpl#getRootImplicitStep()
	 * @generated
	 */
	int ROOT_IMPLICIT_STEP = 11;

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
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_FSMClock_Ticks <em>Fsm FSM Clock Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm FSM Clock Ticks</em>'.
	 * @see fsmTrace.Steps.Fsm_FSMClock_Ticks
	 * @generated
	 */
	EClass getFsm_FSMClock_Ticks();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_FSMEvent_Trigger <em>Fsm FSM Event Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm FSM Event Trigger</em>'.
	 * @see fsmTrace.Steps.Fsm_FSMEvent_Trigger
	 * @generated
	 */
	EClass getFsm_FSMEvent_Trigger();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_FSMEvent_UnTrigger <em>Fsm FSM Event Un Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm FSM Event Un Trigger</em>'.
	 * @see fsmTrace.Steps.Fsm_FSMEvent_UnTrigger
	 * @generated
	 */
	EClass getFsm_FSMEvent_UnTrigger();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_State_Visit <em>Fsm State Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm State Visit</em>'.
	 * @see fsmTrace.Steps.Fsm_State_Visit
	 * @generated
	 */
	EClass getFsm_State_Visit();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_State_Visit_AbstractSubStep <em>Fsm State Visit Abstract Sub Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm State Visit Abstract Sub Step</em>'.
	 * @see fsmTrace.Steps.Fsm_State_Visit_AbstractSubStep
	 * @generated
	 */
	EClass getFsm_State_Visit_AbstractSubStep();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_State_Visit_ImplicitStep <em>Fsm State Visit Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm State Visit Implicit Step</em>'.
	 * @see fsmTrace.Steps.Fsm_State_Visit_ImplicitStep
	 * @generated
	 */
	EClass getFsm_State_Visit_ImplicitStep();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_TimeFSM_Init <em>Fsm Time FSM Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm Time FSM Init</em>'.
	 * @see fsmTrace.Steps.Fsm_TimeFSM_Init
	 * @generated
	 */
	EClass getFsm_TimeFSM_Init();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_Transition_Fire <em>Fsm Transition Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm Transition Fire</em>'.
	 * @see fsmTrace.Steps.Fsm_Transition_Fire
	 * @generated
	 */
	EClass getFsm_Transition_Fire();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_Transition_Visit <em>Fsm Transition Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm Transition Visit</em>'.
	 * @see fsmTrace.Steps.Fsm_Transition_Visit
	 * @generated
	 */
	EClass getFsm_Transition_Visit();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_Transition_Visit_AbstractSubStep <em>Fsm Transition Visit Abstract Sub Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm Transition Visit Abstract Sub Step</em>'.
	 * @see fsmTrace.Steps.Fsm_Transition_Visit_AbstractSubStep
	 * @generated
	 */
	EClass getFsm_Transition_Visit_AbstractSubStep();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.Fsm_Transition_Visit_ImplicitStep <em>Fsm Transition Visit Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fsm Transition Visit Implicit Step</em>'.
	 * @see fsmTrace.Steps.Fsm_Transition_Visit_ImplicitStep
	 * @generated
	 */
	EClass getFsm_Transition_Visit_ImplicitStep();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.RootImplicitStep <em>Root Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Implicit Step</em>'.
	 * @see fsmTrace.Steps.RootImplicitStep
	 * @generated
	 */
	EClass getRootImplicitStep();

	/**
	 * Returns the meta object for class '{@link fsmTrace.Steps.SpecificStep <em>Specific Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Step</em>'.
	 * @see fsmTrace.Steps.SpecificStep
	 * @generated
	 */
	EClass getSpecificStep();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.Steps.SpecificStep#getEndingState <em>Ending State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ending State</em>'.
	 * @see fsmTrace.Steps.SpecificStep#getEndingState()
	 * @see #getSpecificStep()
	 * @generated
	 */
	EReference getSpecificStep_EndingState();

	/**
	 * Returns the meta object for the reference '{@link fsmTrace.Steps.SpecificStep#getStartingState <em>Starting State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Starting State</em>'.
	 * @see fsmTrace.Steps.SpecificStep#getStartingState()
	 * @see #getSpecificStep()
	 * @generated
	 */
	EReference getSpecificStep_StartingState();

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
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_FSMClock_TicksImpl <em>Fsm FSM Clock Ticks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_FSMClock_TicksImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_FSMClock_Ticks()
		 * @generated
		 */
		EClass FSM_FSM_CLOCK_TICKS = eINSTANCE.getFsm_FSMClock_Ticks();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_FSMEvent_TriggerImpl <em>Fsm FSM Event Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_FSMEvent_TriggerImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_FSMEvent_Trigger()
		 * @generated
		 */
		EClass FSM_FSM_EVENT_TRIGGER = eINSTANCE.getFsm_FSMEvent_Trigger();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_FSMEvent_UnTriggerImpl <em>Fsm FSM Event Un Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_FSMEvent_UnTriggerImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_FSMEvent_UnTrigger()
		 * @generated
		 */
		EClass FSM_FSM_EVENT_UN_TRIGGER = eINSTANCE.getFsm_FSMEvent_UnTrigger();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_State_VisitImpl <em>Fsm State Visit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_State_VisitImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_State_Visit()
		 * @generated
		 */
		EClass FSM_STATE_VISIT = eINSTANCE.getFsm_State_Visit();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.Fsm_State_Visit_AbstractSubStep <em>Fsm State Visit Abstract Sub Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.Fsm_State_Visit_AbstractSubStep
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_State_Visit_AbstractSubStep()
		 * @generated
		 */
		EClass FSM_STATE_VISIT_ABSTRACT_SUB_STEP = eINSTANCE.getFsm_State_Visit_AbstractSubStep();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_State_Visit_ImplicitStepImpl <em>Fsm State Visit Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_State_Visit_ImplicitStepImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_State_Visit_ImplicitStep()
		 * @generated
		 */
		EClass FSM_STATE_VISIT_IMPLICIT_STEP = eINSTANCE.getFsm_State_Visit_ImplicitStep();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_TimeFSM_InitImpl <em>Fsm Time FSM Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_TimeFSM_InitImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_TimeFSM_Init()
		 * @generated
		 */
		EClass FSM_TIME_FSM_INIT = eINSTANCE.getFsm_TimeFSM_Init();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_Transition_FireImpl <em>Fsm Transition Fire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_Transition_FireImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_Transition_Fire()
		 * @generated
		 */
		EClass FSM_TRANSITION_FIRE = eINSTANCE.getFsm_Transition_Fire();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_Transition_VisitImpl <em>Fsm Transition Visit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_Transition_VisitImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_Transition_Visit()
		 * @generated
		 */
		EClass FSM_TRANSITION_VISIT = eINSTANCE.getFsm_Transition_Visit();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.Fsm_Transition_Visit_AbstractSubStep <em>Fsm Transition Visit Abstract Sub Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.Fsm_Transition_Visit_AbstractSubStep
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_Transition_Visit_AbstractSubStep()
		 * @generated
		 */
		EClass FSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP = eINSTANCE.getFsm_Transition_Visit_AbstractSubStep();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.Fsm_Transition_Visit_ImplicitStepImpl <em>Fsm Transition Visit Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.Fsm_Transition_Visit_ImplicitStepImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getFsm_Transition_Visit_ImplicitStep()
		 * @generated
		 */
		EClass FSM_TRANSITION_VISIT_IMPLICIT_STEP = eINSTANCE.getFsm_Transition_Visit_ImplicitStep();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.impl.RootImplicitStepImpl <em>Root Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.impl.RootImplicitStepImpl
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getRootImplicitStep()
		 * @generated
		 */
		EClass ROOT_IMPLICIT_STEP = eINSTANCE.getRootImplicitStep();

		/**
		 * The meta object literal for the '{@link fsmTrace.Steps.SpecificStep <em>Specific Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fsmTrace.Steps.SpecificStep
		 * @see fsmTrace.Steps.impl.StepsPackageImpl#getSpecificStep()
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

	}

} //StepsPackage
