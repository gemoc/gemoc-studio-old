/**
 */
package tfsmTrace.Steps;

import org.eclipse.gemoc.trace.commons.model.trace.TracePackage;

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
 * @see tfsmTrace.Steps.StepsFactory
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
	String eNS_URI = "tfsmTrace_Steps";

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
	StepsPackage eINSTANCE = tfsmTrace.Steps.impl.StepsPackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.RootImplicitStepImpl <em>Root Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.RootImplicitStepImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getRootImplicitStep()
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
	 * The meta object id for the '{@link tfsmTrace.Steps.SpecificStep <em>Specific Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.SpecificStep
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getSpecificStep()
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
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_FSMClock_TicksImpl <em>Tfsm FSM Clock Ticks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_FSMClock_TicksImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_FSMClock_Ticks()
	 * @generated
	 */
	int TFSM_FSM_CLOCK_TICKS = 2;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_CLOCK_TICKS__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_CLOCK_TICKS__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_CLOCK_TICKS__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm FSM Clock Ticks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_CLOCK_TICKS_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_FSMEvent_TriggerImpl <em>Tfsm FSM Event Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_FSMEvent_TriggerImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_FSMEvent_Trigger()
	 * @generated
	 */
	int TFSM_FSM_EVENT_TRIGGER = 3;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_EVENT_TRIGGER__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_EVENT_TRIGGER__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_EVENT_TRIGGER__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm FSM Event Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_EVENT_TRIGGER_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_FSMEvent_UnTriggerImpl <em>Tfsm FSM Event Un Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_FSMEvent_UnTriggerImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_FSMEvent_UnTrigger()
	 * @generated
	 */
	int TFSM_FSM_EVENT_UN_TRIGGER = 4;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_EVENT_UN_TRIGGER__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_EVENT_UN_TRIGGER__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_EVENT_UN_TRIGGER__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm FSM Event Un Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_FSM_EVENT_UN_TRIGGER_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_State_VisitImpl <em>Tfsm State Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_State_VisitImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_State_Visit()
	 * @generated
	 */
	int TFSM_STATE_VISIT = 5;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT__SUB_STEPS = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tfsm State Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.Tfsm_State_Visit_AbstractSubStep <em>Tfsm State Visit Abstract Sub Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.Tfsm_State_Visit_AbstractSubStep
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_State_Visit_AbstractSubStep()
	 * @generated
	 */
	int TFSM_STATE_VISIT_ABSTRACT_SUB_STEP = 6;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm State Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_State_Visit_ImplicitStepImpl <em>Tfsm State Visit Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_State_Visit_ImplicitStepImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_State_Visit_ImplicitStep()
	 * @generated
	 */
	int TFSM_STATE_VISIT_IMPLICIT_STEP = 7;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_IMPLICIT_STEP__MSEOCCURRENCE = TFSM_STATE_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_IMPLICIT_STEP__ENDING_STATE = TFSM_STATE_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_IMPLICIT_STEP__STARTING_STATE = TFSM_STATE_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm State Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_STATE_VISIT_IMPLICIT_STEP_FEATURE_COUNT = TFSM_STATE_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_TFSM_InitImpl <em>Tfsm TFSM Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_TFSM_InitImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_TFSM_Init()
	 * @generated
	 */
	int TFSM_TFSM_INIT = 8;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TFSM_INIT__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TFSM_INIT__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TFSM_INIT__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm TFSM Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TFSM_INIT_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.Tfsm_Transition_Visit_AbstractSubStep <em>Tfsm Transition Visit Abstract Sub Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.Tfsm_Transition_Visit_AbstractSubStep
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_Transition_Visit_AbstractSubStep()
	 * @generated
	 */
	int TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP = 11;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm Transition Visit Abstract Sub Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_Transition_FireImpl <em>Tfsm Transition Fire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_Transition_FireImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_Transition_Fire()
	 * @generated
	 */
	int TFSM_TRANSITION_FIRE = 9;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_FIRE__MSEOCCURRENCE = TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_FIRE__ENDING_STATE = TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_FIRE__STARTING_STATE = TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm Transition Fire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_FIRE_FEATURE_COUNT = TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_Transition_VisitImpl <em>Tfsm Transition Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_Transition_VisitImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_Transition_Visit()
	 * @generated
	 */
	int TFSM_TRANSITION_VISIT = 10;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT__MSEOCCURRENCE = SPECIFIC_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT__ENDING_STATE = SPECIFIC_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT__STARTING_STATE = SPECIFIC_STEP__STARTING_STATE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT__SUB_STEPS = SPECIFIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tfsm Transition Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_FEATURE_COUNT = SPECIFIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tfsmTrace.Steps.impl.Tfsm_Transition_Visit_ImplicitStepImpl <em>Tfsm Transition Visit Implicit Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsmTrace.Steps.impl.Tfsm_Transition_Visit_ImplicitStepImpl
	 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_Transition_Visit_ImplicitStep()
	 * @generated
	 */
	int TFSM_TRANSITION_VISIT_IMPLICIT_STEP = 12;

	/**
	 * The feature id for the '<em><b>Mseoccurrence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_IMPLICIT_STEP__MSEOCCURRENCE = TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__MSEOCCURRENCE;

	/**
	 * The feature id for the '<em><b>Ending State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_IMPLICIT_STEP__ENDING_STATE = TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__ENDING_STATE;

	/**
	 * The feature id for the '<em><b>Starting State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_IMPLICIT_STEP__STARTING_STATE = TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP__STARTING_STATE;

	/**
	 * The number of structural features of the '<em>Tfsm Transition Visit Implicit Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFSM_TRANSITION_VISIT_IMPLICIT_STEP_FEATURE_COUNT = TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.RootImplicitStep <em>Root Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Implicit Step</em>'.
	 * @see tfsmTrace.Steps.RootImplicitStep
	 * @generated
	 */
	EClass getRootImplicitStep();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.SpecificStep <em>Specific Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Step</em>'.
	 * @see tfsmTrace.Steps.SpecificStep
	 * @generated
	 */
	EClass getSpecificStep();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.Steps.SpecificStep#getEndingState <em>Ending State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ending State</em>'.
	 * @see tfsmTrace.Steps.SpecificStep#getEndingState()
	 * @see #getSpecificStep()
	 * @generated
	 */
	EReference getSpecificStep_EndingState();

	/**
	 * Returns the meta object for the reference '{@link tfsmTrace.Steps.SpecificStep#getStartingState <em>Starting State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Starting State</em>'.
	 * @see tfsmTrace.Steps.SpecificStep#getStartingState()
	 * @see #getSpecificStep()
	 * @generated
	 */
	EReference getSpecificStep_StartingState();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_FSMClock_Ticks <em>Tfsm FSM Clock Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm FSM Clock Ticks</em>'.
	 * @see tfsmTrace.Steps.Tfsm_FSMClock_Ticks
	 * @generated
	 */
	EClass getTfsm_FSMClock_Ticks();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_FSMEvent_Trigger <em>Tfsm FSM Event Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm FSM Event Trigger</em>'.
	 * @see tfsmTrace.Steps.Tfsm_FSMEvent_Trigger
	 * @generated
	 */
	EClass getTfsm_FSMEvent_Trigger();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger <em>Tfsm FSM Event Un Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm FSM Event Un Trigger</em>'.
	 * @see tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger
	 * @generated
	 */
	EClass getTfsm_FSMEvent_UnTrigger();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_State_Visit <em>Tfsm State Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm State Visit</em>'.
	 * @see tfsmTrace.Steps.Tfsm_State_Visit
	 * @generated
	 */
	EClass getTfsm_State_Visit();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_State_Visit_AbstractSubStep <em>Tfsm State Visit Abstract Sub Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm State Visit Abstract Sub Step</em>'.
	 * @see tfsmTrace.Steps.Tfsm_State_Visit_AbstractSubStep
	 * @generated
	 */
	EClass getTfsm_State_Visit_AbstractSubStep();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_State_Visit_ImplicitStep <em>Tfsm State Visit Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm State Visit Implicit Step</em>'.
	 * @see tfsmTrace.Steps.Tfsm_State_Visit_ImplicitStep
	 * @generated
	 */
	EClass getTfsm_State_Visit_ImplicitStep();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_TFSM_Init <em>Tfsm TFSM Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm TFSM Init</em>'.
	 * @see tfsmTrace.Steps.Tfsm_TFSM_Init
	 * @generated
	 */
	EClass getTfsm_TFSM_Init();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_Transition_Fire <em>Tfsm Transition Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm Transition Fire</em>'.
	 * @see tfsmTrace.Steps.Tfsm_Transition_Fire
	 * @generated
	 */
	EClass getTfsm_Transition_Fire();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_Transition_Visit <em>Tfsm Transition Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm Transition Visit</em>'.
	 * @see tfsmTrace.Steps.Tfsm_Transition_Visit
	 * @generated
	 */
	EClass getTfsm_Transition_Visit();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_Transition_Visit_AbstractSubStep <em>Tfsm Transition Visit Abstract Sub Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm Transition Visit Abstract Sub Step</em>'.
	 * @see tfsmTrace.Steps.Tfsm_Transition_Visit_AbstractSubStep
	 * @generated
	 */
	EClass getTfsm_Transition_Visit_AbstractSubStep();

	/**
	 * Returns the meta object for class '{@link tfsmTrace.Steps.Tfsm_Transition_Visit_ImplicitStep <em>Tfsm Transition Visit Implicit Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tfsm Transition Visit Implicit Step</em>'.
	 * @see tfsmTrace.Steps.Tfsm_Transition_Visit_ImplicitStep
	 * @generated
	 */
	EClass getTfsm_Transition_Visit_ImplicitStep();

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
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.RootImplicitStepImpl <em>Root Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.RootImplicitStepImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getRootImplicitStep()
		 * @generated
		 */
		EClass ROOT_IMPLICIT_STEP = eINSTANCE.getRootImplicitStep();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.SpecificStep <em>Specific Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.SpecificStep
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getSpecificStep()
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
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_FSMClock_TicksImpl <em>Tfsm FSM Clock Ticks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_FSMClock_TicksImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_FSMClock_Ticks()
		 * @generated
		 */
		EClass TFSM_FSM_CLOCK_TICKS = eINSTANCE.getTfsm_FSMClock_Ticks();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_FSMEvent_TriggerImpl <em>Tfsm FSM Event Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_FSMEvent_TriggerImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_FSMEvent_Trigger()
		 * @generated
		 */
		EClass TFSM_FSM_EVENT_TRIGGER = eINSTANCE.getTfsm_FSMEvent_Trigger();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_FSMEvent_UnTriggerImpl <em>Tfsm FSM Event Un Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_FSMEvent_UnTriggerImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_FSMEvent_UnTrigger()
		 * @generated
		 */
		EClass TFSM_FSM_EVENT_UN_TRIGGER = eINSTANCE.getTfsm_FSMEvent_UnTrigger();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_State_VisitImpl <em>Tfsm State Visit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_State_VisitImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_State_Visit()
		 * @generated
		 */
		EClass TFSM_STATE_VISIT = eINSTANCE.getTfsm_State_Visit();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.Tfsm_State_Visit_AbstractSubStep <em>Tfsm State Visit Abstract Sub Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.Tfsm_State_Visit_AbstractSubStep
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_State_Visit_AbstractSubStep()
		 * @generated
		 */
		EClass TFSM_STATE_VISIT_ABSTRACT_SUB_STEP = eINSTANCE.getTfsm_State_Visit_AbstractSubStep();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_State_Visit_ImplicitStepImpl <em>Tfsm State Visit Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_State_Visit_ImplicitStepImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_State_Visit_ImplicitStep()
		 * @generated
		 */
		EClass TFSM_STATE_VISIT_IMPLICIT_STEP = eINSTANCE.getTfsm_State_Visit_ImplicitStep();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_TFSM_InitImpl <em>Tfsm TFSM Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_TFSM_InitImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_TFSM_Init()
		 * @generated
		 */
		EClass TFSM_TFSM_INIT = eINSTANCE.getTfsm_TFSM_Init();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_Transition_FireImpl <em>Tfsm Transition Fire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_Transition_FireImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_Transition_Fire()
		 * @generated
		 */
		EClass TFSM_TRANSITION_FIRE = eINSTANCE.getTfsm_Transition_Fire();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_Transition_VisitImpl <em>Tfsm Transition Visit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_Transition_VisitImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_Transition_Visit()
		 * @generated
		 */
		EClass TFSM_TRANSITION_VISIT = eINSTANCE.getTfsm_Transition_Visit();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.Tfsm_Transition_Visit_AbstractSubStep <em>Tfsm Transition Visit Abstract Sub Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.Tfsm_Transition_Visit_AbstractSubStep
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_Transition_Visit_AbstractSubStep()
		 * @generated
		 */
		EClass TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP = eINSTANCE.getTfsm_Transition_Visit_AbstractSubStep();

		/**
		 * The meta object literal for the '{@link tfsmTrace.Steps.impl.Tfsm_Transition_Visit_ImplicitStepImpl <em>Tfsm Transition Visit Implicit Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsmTrace.Steps.impl.Tfsm_Transition_Visit_ImplicitStepImpl
		 * @see tfsmTrace.Steps.impl.StepsPackageImpl#getTfsm_Transition_Visit_ImplicitStep()
		 * @generated
		 */
		EClass TFSM_TRANSITION_VISIT_IMPLICIT_STEP = eINSTANCE.getTfsm_Transition_Visit_ImplicitStep();

	}

} //StepsPackage
