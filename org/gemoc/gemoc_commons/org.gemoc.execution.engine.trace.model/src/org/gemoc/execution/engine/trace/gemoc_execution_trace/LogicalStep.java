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
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep#getEventExecutionContexts <em>Event Execution Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getLogicalStep()
 * @model
 * @generated
 */
public interface LogicalStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Execution Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Execution Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Execution Contexts</em>' containment reference list.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getLogicalStep_EventExecutionContexts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MSEExecutionContext> getEventExecutionContexts();

} // LogicalStep
