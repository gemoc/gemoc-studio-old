/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage
 * @generated
 */
public interface GemocExecutionEngineTraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GemocExecutionEngineTraceFactory eINSTANCE = org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.GemocExecutionEngineTraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GemocExecutionEngineTracePackage getGemocExecutionEngineTracePackage();

} //GemocExecutionEngineTraceFactory
