/**
 */
package javasolverinput.usage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see javasolverinput.usage.UsagePackage
 * @generated
 */
public interface UsageFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsageFactory eINSTANCE = javasolverinput.usage.impl.UsageFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock</em>'.
	 * @generated
	 */
	Clock createClock();

	/**
	 * Returns a new object of class '<em>Custom Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Constraint</em>'.
	 * @generated
	 */
	CustomConstraint createCustomConstraint();

	/**
	 * Returns a new object of class '<em>Once</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Once</em>'.
	 * @generated
	 */
	Once createOnce();

	/**
	 * Returns a new object of class '<em>Precedes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Precedes</em>'.
	 * @generated
	 */
	Precedes createPrecedes();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UsagePackage getUsagePackage();

} //UsageFactory
