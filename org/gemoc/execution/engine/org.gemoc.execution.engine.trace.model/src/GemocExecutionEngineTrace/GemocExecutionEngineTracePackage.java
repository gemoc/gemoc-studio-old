/**
 */
package GemocExecutionEngineTrace;

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
 * @see GemocExecutionEngineTrace.GemocExecutionEngineTraceFactory
 * @model kind="package"
 * @generated
 */
public interface GemocExecutionEngineTracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "GemocExecutionEngineTrace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/GemocExecutionEngineTrace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "GemocExecutionEngineTrace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GemocExecutionEngineTracePackage eINSTANCE = GemocExecutionEngineTrace.impl.GemocExecutionEngineTracePackageImpl.init();

	/**
	 * The meta object id for the '{@link GemocExecutionEngineTrace.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see GemocExecutionEngineTrace.impl.ChoiceImpl
	 * @see GemocExecutionEngineTrace.impl.GemocExecutionEngineTracePackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 0;

	/**
	 * The feature id for the '<em><b>Next Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__NEXT_CHOICE = 0;

	/**
	 * The feature id for the '<em><b>Possible Logical Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__POSSIBLE_LOGICAL_STEPS = 1;

	/**
	 * The feature id for the '<em><b>Chosen Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__CHOSEN_LOGICAL_STEP = 2;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link GemocExecutionEngineTrace.impl.ExecutionLogicalStepImpl <em>Execution Logical Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see GemocExecutionEngineTrace.impl.ExecutionLogicalStepImpl
	 * @see GemocExecutionEngineTrace.impl.GemocExecutionEngineTracePackageImpl#getExecutionLogicalStep()
	 * @generated
	 */
	int EXECUTION_LOGICAL_STEP = 1;

	/**
	 * The feature id for the '<em><b>Event Occurences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_LOGICAL_STEP__EVENT_OCCURENCES = 0;

	/**
	 * The number of structural features of the '<em>Execution Logical Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_LOGICAL_STEP_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Execution Logical Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_LOGICAL_STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link GemocExecutionEngineTrace.impl.EventOccurenceImpl <em>Event Occurence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see GemocExecutionEngineTrace.impl.EventOccurenceImpl
	 * @see GemocExecutionEngineTrace.impl.GemocExecutionEngineTracePackageImpl#getEventOccurence()
	 * @generated
	 */
	int EVENT_OCCURENCE = 2;

	/**
	 * The number of structural features of the '<em>Event Occurence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OCCURENCE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Event Occurence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OCCURENCE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link GemocExecutionEngineTrace.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see GemocExecutionEngineTrace.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the reference '{@link GemocExecutionEngineTrace.Choice#getNextChoice <em>Next Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Choice</em>'.
	 * @see GemocExecutionEngineTrace.Choice#getNextChoice()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_NextChoice();

	/**
	 * Returns the meta object for the containment reference list '{@link GemocExecutionEngineTrace.Choice#getPossibleLogicalSteps <em>Possible Logical Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possible Logical Steps</em>'.
	 * @see GemocExecutionEngineTrace.Choice#getPossibleLogicalSteps()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_PossibleLogicalSteps();

	/**
	 * Returns the meta object for the reference '{@link GemocExecutionEngineTrace.Choice#getChosenLogicalStep <em>Chosen Logical Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Chosen Logical Step</em>'.
	 * @see GemocExecutionEngineTrace.Choice#getChosenLogicalStep()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_ChosenLogicalStep();

	/**
	 * Returns the meta object for class '{@link GemocExecutionEngineTrace.ExecutionLogicalStep <em>Execution Logical Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Logical Step</em>'.
	 * @see GemocExecutionEngineTrace.ExecutionLogicalStep
	 * @generated
	 */
	EClass getExecutionLogicalStep();

	/**
	 * Returns the meta object for the containment reference list '{@link GemocExecutionEngineTrace.ExecutionLogicalStep#getEventOccurences <em>Event Occurences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event Occurences</em>'.
	 * @see GemocExecutionEngineTrace.ExecutionLogicalStep#getEventOccurences()
	 * @see #getExecutionLogicalStep()
	 * @generated
	 */
	EReference getExecutionLogicalStep_EventOccurences();

	/**
	 * Returns the meta object for class '{@link GemocExecutionEngineTrace.EventOccurence <em>Event Occurence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Occurence</em>'.
	 * @see GemocExecutionEngineTrace.EventOccurence
	 * @generated
	 */
	EClass getEventOccurence();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GemocExecutionEngineTraceFactory getGemocExecutionEngineTraceFactory();

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
		 * The meta object literal for the '{@link GemocExecutionEngineTrace.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see GemocExecutionEngineTrace.impl.ChoiceImpl
		 * @see GemocExecutionEngineTrace.impl.GemocExecutionEngineTracePackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Next Choice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__NEXT_CHOICE = eINSTANCE.getChoice_NextChoice();

		/**
		 * The meta object literal for the '<em><b>Possible Logical Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__POSSIBLE_LOGICAL_STEPS = eINSTANCE.getChoice_PossibleLogicalSteps();

		/**
		 * The meta object literal for the '<em><b>Chosen Logical Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__CHOSEN_LOGICAL_STEP = eINSTANCE.getChoice_ChosenLogicalStep();

		/**
		 * The meta object literal for the '{@link GemocExecutionEngineTrace.impl.ExecutionLogicalStepImpl <em>Execution Logical Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see GemocExecutionEngineTrace.impl.ExecutionLogicalStepImpl
		 * @see GemocExecutionEngineTrace.impl.GemocExecutionEngineTracePackageImpl#getExecutionLogicalStep()
		 * @generated
		 */
		EClass EXECUTION_LOGICAL_STEP = eINSTANCE.getExecutionLogicalStep();

		/**
		 * The meta object literal for the '<em><b>Event Occurences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_LOGICAL_STEP__EVENT_OCCURENCES = eINSTANCE.getExecutionLogicalStep_EventOccurences();

		/**
		 * The meta object literal for the '{@link GemocExecutionEngineTrace.impl.EventOccurenceImpl <em>Event Occurence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see GemocExecutionEngineTrace.impl.EventOccurenceImpl
		 * @see GemocExecutionEngineTrace.impl.GemocExecutionEngineTracePackageImpl#getEventOccurence()
		 * @generated
		 */
		EClass EVENT_OCCURENCE = eINSTANCE.getEventOccurence();

	}

} //GemocExecutionEngineTracePackage
