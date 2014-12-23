/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage
 * @generated
 */
public interface Gemoc_execution_traceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Gemoc_execution_traceFactory eINSTANCE = org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.Gemoc_execution_traceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Execution Trace Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Trace Model</em>'.
	 * @generated
	 */
	ExecutionTraceModel createExecutionTraceModel();

	/**
	 * Returns a new object of class '<em>Solver State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solver State</em>'.
	 * @generated
	 */
	SolverState createSolverState();

	/**
	 * Returns a new object of class '<em>Model State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model State</em>'.
	 * @generated
	 */
	ModelState createModelState();

	/**
	 * Returns a new object of class '<em>Context State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context State</em>'.
	 * @generated
	 */
	ContextState createContextState();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Gemoc_execution_tracePackage getGemoc_execution_tracePackage();

} //Gemoc_execution_traceFactory
