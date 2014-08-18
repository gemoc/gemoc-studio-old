/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getModelState()
 * @model
 * @generated
 */
public interface ModelState extends EObject {

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(EObject)
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getModelState_Model()
	 * @model required="true"
	 * @generated
	 */
	EObject getModel();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(EObject value);
} // ModelState
