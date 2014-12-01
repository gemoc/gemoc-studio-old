/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState#getModel <em>Model</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState#getSerializableModel <em>Serializable Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getSolverState()
 * @model
 * @generated
 */
public interface SolverState extends EObject {
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
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getSolverState_Model()
	 * @model required="true"
	 * @generated
	 */
	EObject getModel();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(EObject value);

	/**
	 * Returns the value of the '<em><b>Serializable Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializable Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializable Model</em>' attribute.
	 * @see #setSerializableModel(byte[])
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage#getSolverState_SerializableModel()
	 * @model dataType="org.gemoc.execution.engine.trace.gemoc_execution_trace.ISerializable"
	 * @generated
	 */
	byte[] getSerializableModel();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState#getSerializableModel <em>Serializable Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serializable Model</em>' attribute.
	 * @see #getSerializableModel()
	 * @generated
	 */
	void setSerializableModel(byte[] value);

} // SolverState
