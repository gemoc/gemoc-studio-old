/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3;

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
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Factory
 * @model kind="package"
 * @generated
 */
public interface Tfsm_plaink3Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tfsm_plaink3";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tfsm_plaink3Trace_tfsm_plaink3";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Tfsm_plaink3Package eINSTANCE = tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl.init();

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl <em>Traced Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedNamedElement()
	 * @generated
	 */
	int TRACED_NAMED_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Traced Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_NAMED_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Traced Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl <em>Traced FSM Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedFSMClock()
	 * @generated
	 */
	int TRACED_FSM_CLOCK = 0;

	/**
	 * The feature id for the '<em><b>Number Of Ticks Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_CLOCK__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Traced FSM Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_CLOCK_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Traced FSM Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_CLOCK_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMEventImpl <em>Traced FSM Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMEventImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedFSMEvent()
	 * @generated
	 */
	int TRACED_FSM_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Is Triggered Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_EVENT__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Traced FSM Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_EVENT_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Traced FSM Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_FSM_EVENT_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl <em>Traced TFSM</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTFSM()
	 * @generated
	 */
	int TRACED_TFSM = 3;

	/**
	 * The feature id for the '<em><b>Current State Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM__CURRENT_STATE_SEQUENCE = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM__ORIGINAL_OBJECT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Traced TFSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM_FEATURE_COUNT = TRACED_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Traced TFSM</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACED_TFSM_OPERATION_COUNT = TRACED_NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock <em>Traced FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced FSM Clock</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock
	 * @generated
	 */
	EClass getTracedFSMClock();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Of Ticks Sequence</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getNumberOfTicksSequence()
	 * @see #getTracedFSMClock()
	 * @generated
	 */
	EReference getTracedFSMClock_NumberOfTicksSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock#getOriginalObject()
	 * @see #getTracedFSMClock()
	 * @generated
	 */
	EReference getTracedFSMClock_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent <em>Traced FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced FSM Event</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent
	 * @generated
	 */
	EClass getTracedFSMEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getIsTriggeredSequence <em>Is Triggered Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Is Triggered Sequence</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getIsTriggeredSequence()
	 * @see #getTracedFSMEvent()
	 * @generated
	 */
	EReference getTracedFSMEvent_IsTriggeredSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent#getOriginalObject()
	 * @see #getTracedFSMEvent()
	 * @generated
	 */
	EReference getTracedFSMEvent_OriginalObject();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement <em>Traced Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced Named Element</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement
	 * @generated
	 */
	EClass getTracedNamedElement();

	/**
	 * Returns the meta object for class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM <em>Traced TFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Traced TFSM</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM
	 * @generated
	 */
	EClass getTracedTFSM();

	/**
	 * Returns the meta object for the containment reference list '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getCurrentStateSequence <em>Current State Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Current State Sequence</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getCurrentStateSequence()
	 * @see #getTracedTFSM()
	 * @generated
	 */
	EReference getTracedTFSM_CurrentStateSequence();

	/**
	 * Returns the meta object for the reference '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getOriginalObject <em>Original Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Original Object</em>'.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM#getOriginalObject()
	 * @see #getTracedTFSM()
	 * @generated
	 */
	EReference getTracedTFSM_OriginalObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Tfsm_plaink3Factory getTfsm_plaink3Factory();

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
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl <em>Traced FSM Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedFSMClock()
		 * @generated
		 */
		EClass TRACED_FSM_CLOCK = eINSTANCE.getTracedFSMClock();

		/**
		 * The meta object literal for the '<em><b>Number Of Ticks Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE = eINSTANCE.getTracedFSMClock_NumberOfTicksSequence();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_FSM_CLOCK__ORIGINAL_OBJECT = eINSTANCE.getTracedFSMClock_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMEventImpl <em>Traced FSM Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMEventImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedFSMEvent()
		 * @generated
		 */
		EClass TRACED_FSM_EVENT = eINSTANCE.getTracedFSMEvent();

		/**
		 * The meta object literal for the '<em><b>Is Triggered Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE = eINSTANCE.getTracedFSMEvent_IsTriggeredSequence();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_FSM_EVENT__ORIGINAL_OBJECT = eINSTANCE.getTracedFSMEvent_OriginalObject();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl <em>Traced Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedNamedElement()
		 * @generated
		 */
		EClass TRACED_NAMED_ELEMENT = eINSTANCE.getTracedNamedElement();

		/**
		 * The meta object literal for the '{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl <em>Traced TFSM</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl
		 * @see tfsm_plaink3Trace.States.tfsm_plaink3.impl.Tfsm_plaink3PackageImpl#getTracedTFSM()
		 * @generated
		 */
		EClass TRACED_TFSM = eINSTANCE.getTracedTFSM();

		/**
		 * The meta object literal for the '<em><b>Current State Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TFSM__CURRENT_STATE_SEQUENCE = eINSTANCE.getTracedTFSM_CurrentStateSequence();

		/**
		 * The meta object literal for the '<em><b>Original Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACED_TFSM__ORIGINAL_OBJECT = eINSTANCE.getTracedTFSM_OriginalObject();

	}

} //Tfsm_plaink3Package
