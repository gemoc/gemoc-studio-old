/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MSE Occurrence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence#getMse <em>Mse</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence#getResult <em>Result</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence#getLogicalstep <em>Logicalstep</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEOccurrence()
 * @model
 * @generated
 */
public interface MSEOccurrence extends EObject {
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
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEOccurrence_Mse()
	 * @model required="true"
	 * @generated
	 */
	ModelSpecificEvent getMse();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence#getMse <em>Mse</em>}' reference.
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
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEOccurrence_Parameters()
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
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEOccurrence_Result()
	 * @model
	 * @generated
	 */
	EList<Object> getResult();

	/**
	 * Returns the value of the '<em><b>Logicalstep</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep#getMseOccurrences <em>Mse Occurrences</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logicalstep</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logicalstep</em>' container reference.
	 * @see #setLogicalstep(LogicalStep)
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getMSEOccurrence_Logicalstep()
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep#getMseOccurrences
	 * @model opposite="mseOccurrences" required="true" transient="false"
	 * @generated
	 */
	LogicalStep getLogicalstep();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence#getLogicalstep <em>Logicalstep</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logicalstep</em>' container reference.
	 * @see #getLogicalstep()
	 * @generated
	 */
	void setLogicalstep(LogicalStep value);

} // MSEOccurrence
