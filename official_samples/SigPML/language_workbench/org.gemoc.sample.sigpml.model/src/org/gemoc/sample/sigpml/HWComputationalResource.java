/**
 */
package org.gemoc.sample.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Computational Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.HWComputationalResource#isIsUnderPreemptiveManagement <em>Is Under Preemptive Management</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.HWComputationalResource#getAllocatedAgents <em>Allocated Agents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.sample.sigpml.SigpmlPackage#getHWComputationalResource()
 * @model
 * @generated
 */
public interface HWComputationalResource extends HWRessource {
	/**
	 * Returns the value of the '<em><b>Is Under Preemptive Management</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Under Preemptive Management</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Under Preemptive Management</em>' attribute.
	 * @see #setIsUnderPreemptiveManagement(boolean)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getHWComputationalResource_IsUnderPreemptiveManagement()
	 * @model
	 * @generated
	 */
	boolean isIsUnderPreemptiveManagement();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.HWComputationalResource#isIsUnderPreemptiveManagement <em>Is Under Preemptive Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Under Preemptive Management</em>' attribute.
	 * @see #isIsUnderPreemptiveManagement()
	 * @generated
	 */
	void setIsUnderPreemptiveManagement(boolean value);

	/**
	 * Returns the value of the '<em><b>Allocated Agents</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.Agent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated Agents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated Agents</em>' reference list.
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getHWComputationalResource_AllocatedAgents()
	 * @model
	 * @generated
	 */
	EList<Agent> getAllocatedAgents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void incCycle();

} // HWComputationalResource
