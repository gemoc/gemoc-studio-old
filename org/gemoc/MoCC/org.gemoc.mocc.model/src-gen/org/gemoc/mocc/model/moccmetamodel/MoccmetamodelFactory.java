/**
 */
package org.gemoc.mocc.model.moccmetamodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage
 * @generated
 */
public interface MoccmetamodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MoccmetamodelFactory eINSTANCE = org.gemoc.mocc.model.moccmetamodel.impl.MoccmetamodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>State Machine Relation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Machine Relation Definition</em>'.
	 * @generated
	 */
	StateMachineRelationDefinition createStateMachineRelationDefinition();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>State Base Relation Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Base Relation Library</em>'.
	 * @generated
	 */
	StateBaseRelationLibrary createStateBaseRelationLibrary();

	/**
	 * Returns a new object of class '<em>Integer Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Assignment</em>'.
	 * @generated
	 */
	IntegerAssignment createIntegerAssignment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MoccmetamodelPackage getMoccmetamodelPackage();

} //MoccmetamodelFactory
