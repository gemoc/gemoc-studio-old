/**
 */
package fr.obeo.dsl.sirius.animation.uml.umlanimation;

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
 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationFactory
 * @model kind="package"
 * @generated
 */
public interface UmlanimationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "umlanimation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/dsl/sirius/umlanimation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "umlanimation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmlanimationPackage eINSTANCE = fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.UmlanimationPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.StateMachineExecutionImpl <em>State Machine Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.StateMachineExecutionImpl
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.UmlanimationPackageImpl#getStateMachineExecution()
	 * @generated
	 */
	int STATE_MACHINE_EXECUTION = 0;

	/**
	 * The feature id for the '<em><b>Statemachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_EXECUTION__STATEMACHINE = 0;

	/**
	 * The feature id for the '<em><b>Current</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_EXECUTION__CURRENT = 1;

	/**
	 * The feature id for the '<em><b>Candidates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_EXECUTION__CANDIDATES = 2;

	/**
	 * The number of structural features of the '<em>State Machine Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_EXECUTION_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution <em>State Machine Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine Execution</em>'.
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution
	 * @generated
	 */
	EClass getStateMachineExecution();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getStatemachine <em>Statemachine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Statemachine</em>'.
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getStatemachine()
	 * @see #getStateMachineExecution()
	 * @generated
	 */
	EReference getStateMachineExecution_Statemachine();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getCurrent <em>Current</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current</em>'.
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getCurrent()
	 * @see #getStateMachineExecution()
	 * @generated
	 */
	EReference getStateMachineExecution_Current();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getCandidates <em>Candidates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Candidates</em>'.
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getCandidates()
	 * @see #getStateMachineExecution()
	 * @generated
	 */
	EReference getStateMachineExecution_Candidates();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UmlanimationFactory getUmlanimationFactory();

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
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.StateMachineExecutionImpl <em>State Machine Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.StateMachineExecutionImpl
		 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.UmlanimationPackageImpl#getStateMachineExecution()
		 * @generated
		 */
		EClass STATE_MACHINE_EXECUTION = eINSTANCE.getStateMachineExecution();

		/**
		 * The meta object literal for the '<em><b>Statemachine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_EXECUTION__STATEMACHINE = eINSTANCE.getStateMachineExecution_Statemachine();

		/**
		 * The meta object literal for the '<em><b>Current</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_EXECUTION__CURRENT = eINSTANCE.getStateMachineExecution_Current();

		/**
		 * The meta object literal for the '<em><b>Candidates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MACHINE_EXECUTION__CANDIDATES = eINSTANCE.getStateMachineExecution_Candidates();

	}

} //UmlanimationPackage
