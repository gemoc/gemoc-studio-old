/**
 */
package fr.obeo.dsl.sirius.animation.uml.umlanimation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage
 * @generated
 */
public interface UmlanimationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmlanimationFactory eINSTANCE = fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.UmlanimationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>State Machine Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Machine Execution</em>'.
	 * @generated
	 */
	StateMachineExecution createStateMachineExecution();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlanimationPackage getUmlanimationPackage();

} //UmlanimationFactory
