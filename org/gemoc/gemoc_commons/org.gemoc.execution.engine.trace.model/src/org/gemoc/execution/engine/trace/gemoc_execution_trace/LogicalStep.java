/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep#getMseOccurrences <em>Mse Occurrences</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getLogicalStep()
 * @model
 * @generated
 */
public interface LogicalStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Mse Occurrences</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence#getLogicalstep <em>Logicalstep</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mse Occurrences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mse Occurrences</em>' containment reference list.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getLogicalStep_MseOccurrences()
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence#getLogicalstep
	 * @model opposite="logicalstep" containment="true" required="true"
	 * @generated
	 */
	EList<MSEOccurrence> getMseOccurrences();

} // LogicalStep
