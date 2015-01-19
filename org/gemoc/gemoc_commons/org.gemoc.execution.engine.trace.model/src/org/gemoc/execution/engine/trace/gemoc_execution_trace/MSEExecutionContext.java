/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MSE Execution Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext#getMse <em>Mse</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEExecutionContext()
 * @model
 * @generated
 */
public interface MSEExecutionContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mse</em>' reference.
	 * @see #setMse(ModelSpecificEvent)
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEExecutionContext_Mse()
	 * @model required="true"
	 * @generated
	 */
	ModelSpecificEvent getMse();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext#getMse <em>Mse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mse</em>' reference.
	 * @see #getMse()
	 * @generated
	 */
	void setMse(ModelSpecificEvent value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute list.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEExecutionContext_Parameters()
	 * @model
	 * @generated
	 */
	EList<Object> getParameters();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute list.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEExecutionContext_Result()
	 * @model
	 * @generated
	 */
	EList<Object> getResult();

} // MSEExecutionContext
