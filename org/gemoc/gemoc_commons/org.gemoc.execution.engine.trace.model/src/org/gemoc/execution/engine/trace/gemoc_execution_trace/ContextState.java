/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState#getModelState <em>Model State</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState#getSolverState <em>Solver State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getContextState()
 * @model
 * @generated
 */
public interface ContextState extends EObject {
	/**
	 * Returns the value of the '<em><b>Solver State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solver State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solver State</em>' containment reference.
	 * @see #setSolverState(SolverState)
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getContextState_SolverState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SolverState getSolverState();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState#getSolverState <em>Solver State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solver State</em>' containment reference.
	 * @see #getSolverState()
	 * @generated
	 */
	void setSolverState(SolverState value);

	/**
	 * Returns the value of the '<em><b>Model State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model State</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model State</em>' containment reference.
	 * @see #setModelState(ModelState)
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getContextState_ModelState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelState getModelState();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState#getModelState <em>Model State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model State</em>' containment reference.
	 * @see #getModelState()
	 * @generated
	 */
	void setModelState(ModelState value);

} // ContextState
