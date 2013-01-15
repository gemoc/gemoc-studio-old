/**
 */
package execution_trace;

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
 * @see execution_trace.Execution_traceFactory
 * @model kind="package"
 * @generated
 */
public interface Execution_tracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "execution_trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://gemoc/execution_trace/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "execution_trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Execution_tracePackage eINSTANCE = execution_trace.impl.Execution_tracePackageImpl.init();

	/**
	 * The meta object id for the '{@link execution_trace.impl.TraceSetImpl <em>Trace Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see execution_trace.impl.TraceSetImpl
	 * @see execution_trace.impl.Execution_tracePackageImpl#getTraceSet()
	 * @generated
	 */
	int TRACE_SET = 0;

	/**
	 * The feature id for the '<em><b>Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SET__TRACES = 0;

	/**
	 * The number of structural features of the '<em>Trace Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_SET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link execution_trace.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see execution_trace.impl.TraceImpl
	 * @see execution_trace.impl.Execution_tracePackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 1;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link execution_trace.TraceSet <em>Trace Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Set</em>'.
	 * @see execution_trace.TraceSet
	 * @generated
	 */
	EClass getTraceSet();

	/**
	 * Returns the meta object for the containment reference list '{@link execution_trace.TraceSet#getTraces <em>Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traces</em>'.
	 * @see execution_trace.TraceSet#getTraces()
	 * @see #getTraceSet()
	 * @generated
	 */
	EReference getTraceSet_Traces();

	/**
	 * Returns the meta object for class '{@link execution_trace.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see execution_trace.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Execution_traceFactory getExecution_traceFactory();

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
		 * The meta object literal for the '{@link execution_trace.impl.TraceSetImpl <em>Trace Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see execution_trace.impl.TraceSetImpl
		 * @see execution_trace.impl.Execution_tracePackageImpl#getTraceSet()
		 * @generated
		 */
		EClass TRACE_SET = eINSTANCE.getTraceSet();

		/**
		 * The meta object literal for the '<em><b>Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_SET__TRACES = eINSTANCE.getTraceSet_Traces();

		/**
		 * The meta object literal for the '{@link execution_trace.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see execution_trace.impl.TraceImpl
		 * @see execution_trace.impl.Execution_tracePackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

	}

} //Execution_tracePackage
