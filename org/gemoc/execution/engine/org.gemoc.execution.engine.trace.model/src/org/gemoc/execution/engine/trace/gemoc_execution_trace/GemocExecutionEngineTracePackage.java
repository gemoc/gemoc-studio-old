/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

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
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTraceFactory
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
	String eNAME = "gemoc_execution_trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.inira.fr/gemoc_execution_trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gemoc_execution_trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GemocExecutionEngineTracePackage eINSTANCE = org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.GemocExecutionEngineTracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.GemocExecutionEngineTracePackageImpl#getChoice()
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
	 * Returns the meta object for class '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getNextChoice <em>Next Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Choice</em>'.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getNextChoice()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_NextChoice();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getPossibleLogicalSteps <em>Possible Logical Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possible Logical Steps</em>'.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getPossibleLogicalSteps()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_PossibleLogicalSteps();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getChosenLogicalStep <em>Chosen Logical Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Chosen Logical Step</em>'.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getChosenLogicalStep()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_ChosenLogicalStep();

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
		 * The meta object literal for the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl
		 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.GemocExecutionEngineTracePackageImpl#getChoice()
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

	}

} //GemocExecutionEngineTracePackage
