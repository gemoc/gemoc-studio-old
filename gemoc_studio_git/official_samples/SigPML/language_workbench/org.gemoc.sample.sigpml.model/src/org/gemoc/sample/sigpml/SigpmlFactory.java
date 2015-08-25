/**
 */
package org.gemoc.sample.sigpml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.sample.sigpml.SigpmlPackage
 * @generated
 */
public interface SigpmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SigpmlFactory eINSTANCE = org.gemoc.sample.sigpml.impl.SigpmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application</em>'.
	 * @generated
	 */
	Application createApplication();

	/**
	 * Returns a new object of class '<em>Agent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Agent</em>'.
	 * @generated
	 */
	Agent createAgent();

	/**
	 * Returns a new object of class '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Port</em>'.
	 * @generated
	 */
	InputPort createInputPort();

	/**
	 * Returns a new object of class '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Port</em>'.
	 * @generated
	 */
	OutputPort createOutputPort();

	/**
	 * Returns a new object of class '<em>Place</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Place</em>'.
	 * @generated
	 */
	Place createPlace();

	/**
	 * Returns a new object of class '<em>HW Computational Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HW Computational Resource</em>'.
	 * @generated
	 */
	HWComputationalResource createHWComputationalResource();

	/**
	 * Returns a new object of class '<em>HW Storage Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HW Storage Resource</em>'.
	 * @generated
	 */
	HWStorageResource createHWStorageResource();

	/**
	 * Returns a new object of class '<em>HW Communication Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HW Communication Resource</em>'.
	 * @generated
	 */
	HWCommunicationResource createHWCommunicationResource();

	/**
	 * Returns a new object of class '<em>HW Platform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>HW Platform</em>'.
	 * @generated
	 */
	HWPlatform createHWPlatform();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SigpmlPackage getSigpmlPackage();

} //SigpmlFactory
