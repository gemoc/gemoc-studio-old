/**
 */
package GemocExecutionEngineTrace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see GemocExecutionEngineTrace.GemocExecutionEngineTracePackage
 * @generated
 */
public interface GemocExecutionEngineTraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GemocExecutionEngineTraceFactory eINSTANCE = GemocExecutionEngineTrace.impl.GemocExecutionEngineTraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Execution Logical Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Logical Step</em>'.
	 * @generated
	 */
	ExecutionLogicalStep createExecutionLogicalStep();

	/**
	 * Returns a new object of class '<em>Event Occurence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Occurence</em>'.
	 * @generated
	 */
	EventOccurence createEventOccurence();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GemocExecutionEngineTracePackage getGemocExecutionEngineTracePackage();

} //GemocExecutionEngineTraceFactory
