/**
 */
package org.gemoc.execution.engine.scenario;

import org.eclipse.emf.ecore.EAttribute;
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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gemoc.execution.engine.scenario.ScenarioFactory
 * @model kind="package"
 * @generated
 */
public interface ScenarioPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scenario";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.inira.fr/scenario";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scenario";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScenarioPackage eINSTANCE = org.gemoc.execution.engine.scenario.impl.ScenarioPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.execution.engine.scenario.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.execution.engine.scenario.impl.ScenarioImpl
	 * @see org.gemoc.execution.engine.scenario.impl.ScenarioPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 0;

	/**
	 * The feature id for the '<em><b>Step List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__STEP_LIST = 0;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.execution.engine.scenario.impl.ExecutionStepImpl <em>Execution Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.execution.engine.scenario.impl.ExecutionStepImpl
	 * @see org.gemoc.execution.engine.scenario.impl.ScenarioPackageImpl#getExecutionStep()
	 * @generated
	 */
	int EXECUTION_STEP = 1;

	/**
	 * The feature id for the '<em><b>Event List</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP__EVENT_LIST = 0;

	/**
	 * The number of structural features of the '<em>Execution Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Execution Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.execution.engine.scenario.impl.EventStateImpl <em>Event State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.execution.engine.scenario.impl.EventStateImpl
	 * @see org.gemoc.execution.engine.scenario.impl.ScenarioPackageImpl#getEventState()
	 * @generated
	 */
	int EVENT_STATE = 2;

	/**
	 * The feature id for the '<em><b>Is Forced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_STATE__IS_FORCED = 0;

	/**
	 * The feature id for the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_STATE__CLOCK = 1;

	/**
	 * The number of structural features of the '<em>Event State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_STATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Event State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_STATE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.execution.engine.scenario.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see org.gemoc.execution.engine.scenario.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.execution.engine.scenario.Scenario#getStepList <em>Step List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Step List</em>'.
	 * @see org.gemoc.execution.engine.scenario.Scenario#getStepList()
	 * @see #getScenario()
	 * @generated
	 */
	EReference getScenario_StepList();

	/**
	 * Returns the meta object for class '{@link org.gemoc.execution.engine.scenario.ExecutionStep <em>Execution Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Step</em>'.
	 * @see org.gemoc.execution.engine.scenario.ExecutionStep
	 * @generated
	 */
	EClass getExecutionStep();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.execution.engine.scenario.ExecutionStep#getEventList <em>Event List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event List</em>'.
	 * @see org.gemoc.execution.engine.scenario.ExecutionStep#getEventList()
	 * @see #getExecutionStep()
	 * @generated
	 */
	EReference getExecutionStep_EventList();

	/**
	 * Returns the meta object for class '{@link org.gemoc.execution.engine.scenario.EventState <em>Event State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event State</em>'.
	 * @see org.gemoc.execution.engine.scenario.EventState
	 * @generated
	 */
	EClass getEventState();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.execution.engine.scenario.EventState#isIsForced <em>Is Forced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Forced</em>'.
	 * @see org.gemoc.execution.engine.scenario.EventState#isIsForced()
	 * @see #getEventState()
	 * @generated
	 */
	EAttribute getEventState_IsForced();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.execution.engine.scenario.EventState#getClock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clock</em>'.
	 * @see org.gemoc.execution.engine.scenario.EventState#getClock()
	 * @see #getEventState()
	 * @generated
	 */
	EReference getEventState_Clock();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScenarioFactory getScenarioFactory();

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
		 * The meta object literal for the '{@link org.gemoc.execution.engine.scenario.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.execution.engine.scenario.impl.ScenarioImpl
		 * @see org.gemoc.execution.engine.scenario.impl.ScenarioPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '<em><b>Step List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENARIO__STEP_LIST = eINSTANCE.getScenario_StepList();

		/**
		 * The meta object literal for the '{@link org.gemoc.execution.engine.scenario.impl.ExecutionStepImpl <em>Execution Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.execution.engine.scenario.impl.ExecutionStepImpl
		 * @see org.gemoc.execution.engine.scenario.impl.ScenarioPackageImpl#getExecutionStep()
		 * @generated
		 */
		EClass EXECUTION_STEP = eINSTANCE.getExecutionStep();

		/**
		 * The meta object literal for the '<em><b>Event List</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_STEP__EVENT_LIST = eINSTANCE.getExecutionStep_EventList();

		/**
		 * The meta object literal for the '{@link org.gemoc.execution.engine.scenario.impl.EventStateImpl <em>Event State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.execution.engine.scenario.impl.EventStateImpl
		 * @see org.gemoc.execution.engine.scenario.impl.ScenarioPackageImpl#getEventState()
		 * @generated
		 */
		EClass EVENT_STATE = eINSTANCE.getEventState();

		/**
		 * The meta object literal for the '<em><b>Is Forced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_STATE__IS_FORCED = eINSTANCE.getEventState_IsForced();

		/**
		 * The meta object literal for the '<em><b>Clock</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_STATE__CLOCK = eINSTANCE.getEventState_Clock();

	}

} //ScenarioPackage
