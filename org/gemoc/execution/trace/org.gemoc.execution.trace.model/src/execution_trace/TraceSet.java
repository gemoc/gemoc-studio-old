/**
 */
package execution_trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link execution_trace.TraceSet#getTraces <em>Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @see execution_trace.Execution_tracePackage#getTraceSet()
 * @model
 * @generated
 */
public interface TraceSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Traces</b></em>' containment reference list.
	 * The list contents are of type {@link execution_trace.Trace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traces</em>' containment reference list.
	 * @see execution_trace.Execution_tracePackage#getTraceSet_Traces()
	 * @model containment="true"
	 * @generated
	 */
	EList<Trace> getTraces();

} // TraceSet
