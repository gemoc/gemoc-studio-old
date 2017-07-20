/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
/**
 */
package org.gemoc.sample.sigpml.xsigpml.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Computational Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource#isIsUnderPreemptiveManagement <em>Is Under Preemptive Management</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource#getAllocatedAgents <em>Allocated Agents</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource#getCurrentExecCycle <em>Current Exec Cycle</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getHWComputationalResource()
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
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getHWComputationalResource_IsUnderPreemptiveManagement()
	 * @model
	 * @generated
	 */
	boolean isIsUnderPreemptiveManagement();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource#isIsUnderPreemptiveManagement <em>Is Under Preemptive Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Under Preemptive Management</em>' attribute.
	 * @see #isIsUnderPreemptiveManagement()
	 * @generated
	 */
	void setIsUnderPreemptiveManagement(boolean value);

	/**
	 * Returns the value of the '<em><b>Allocated Agents</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xsigpml.sigpml.Agent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated Agents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated Agents</em>' reference list.
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getHWComputationalResource_AllocatedAgents()
	 * @model
	 * @generated
	 */
	EList<Agent> getAllocatedAgents();

	/**
	 * Returns the value of the '<em><b>Current Exec Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Exec Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Exec Cycle</em>' attribute.
	 * @see #setCurrentExecCycle(int)
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getHWComputationalResource_CurrentExecCycle()
	 * @model unique="false"
	 * @generated
	 */
	int getCurrentExecCycle();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource#getCurrentExecCycle <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Exec Cycle</em>' attribute.
	 * @see #getCurrentExecCycle()
	 * @generated
	 */
	void setCurrentExecCycle(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void incCycle();

} // HWComputationalResource
