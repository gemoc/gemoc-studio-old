/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract
 * class of the model. <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.process.ProcessPackage
 * @generated
 */
public interface ProcessFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ProcessFactory eINSTANCE = fr.obeo.dsl.process.impl.ProcessFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Process</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	Process createProcess();

	/**
	 * Returns a new object of class '<em>Variable</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	ProcessVariable createProcessVariable();

	/**
	 * Returns a new object of class '<em>Composed Task</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Composed Task</em>'.
	 * @generated
	 */
	ComposedTask createComposedTask();

	/**
	 * Returns a new object of class '<em>Action Task</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Action Task</em>'.
	 * @generated
	 */
	ActionTask createActionTask();

	/**
	 * Returns a new object of class '<em>All Done</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>All Done</em>'.
	 * @generated
	 */
	AllDone createAllDone();

	/**
	 * Returns a new object of class '<em>Any Done</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Any Done</em>'.
	 * @generated
	 */
	AnyDone createAnyDone();

	/**
	 * Returns a new object of class '<em>One Done</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>One Done</em>'.
	 * @generated
	 */
	OneDone createOneDone();

	/**
	 * Returns a new object of class '<em>Not</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Not</em>'.
	 * @generated
	 */
	Not createNot();

	/**
	 * Returns a new object of class '<em>And</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns a new object of class '<em>Or</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Or</em>'.
	 * @generated
	 */
	Or createOr();

	/**
	 * Returns a new object of class '<em>Context</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	ProcessContext createProcessContext();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProcessPackage getProcessPackage();

} // ProcessFactory
