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
package org.gemoc.sample.sigpml.xsigpml.sigpml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.gemoc.sample.sigpml.xsigpml.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HW Computational Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.impl.HWComputationalResourceImpl#isIsUnderPreemptiveManagement <em>Is Under Preemptive Management</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.impl.HWComputationalResourceImpl#getAllocatedAgents <em>Allocated Agents</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.impl.HWComputationalResourceImpl#getCurrentExecCycle <em>Current Exec Cycle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HWComputationalResourceImpl extends HWRessourceImpl implements HWComputationalResource {
	/**
	 * The default value of the '{@link #isIsUnderPreemptiveManagement() <em>Is Under Preemptive Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnderPreemptiveManagement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNDER_PREEMPTIVE_MANAGEMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsUnderPreemptiveManagement() <em>Is Under Preemptive Management</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnderPreemptiveManagement()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnderPreemptiveManagement = IS_UNDER_PREEMPTIVE_MANAGEMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAllocatedAgents() <em>Allocated Agents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedAgents()
	 * @generated
	 * @ordered
	 */
	protected EList<Agent> allocatedAgents;

	/**
	 * The default value of the '{@link #getCurrentExecCycle() <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecCycle()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_EXEC_CYCLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentExecCycle() <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecCycle()
	 * @generated
	 * @ordered
	 */
	protected int currentExecCycle = CURRENT_EXEC_CYCLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HWComputationalResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlPackage.Literals.HW_COMPUTATIONAL_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsUnderPreemptiveManagement() {
		return isUnderPreemptiveManagement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnderPreemptiveManagement(boolean newIsUnderPreemptiveManagement) {
		boolean oldIsUnderPreemptiveManagement = isUnderPreemptiveManagement;
		isUnderPreemptiveManagement = newIsUnderPreemptiveManagement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT, oldIsUnderPreemptiveManagement, isUnderPreemptiveManagement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Agent> getAllocatedAgents() {
		if (allocatedAgents == null) {
			allocatedAgents = new EObjectResolvingEList<Agent>(Agent.class, this, SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS);
		}
		return allocatedAgents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentExecCycle() {
		return currentExecCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentExecCycle(int newCurrentExecCycle) {
		int oldCurrentExecCycle = currentExecCycle;
		currentExecCycle = newCurrentExecCycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE, oldCurrentExecCycle, currentExecCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void incCycle() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT:
				return isIsUnderPreemptiveManagement();
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS:
				return getAllocatedAgents();
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
				return getCurrentExecCycle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT:
				setIsUnderPreemptiveManagement((Boolean)newValue);
				return;
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS:
				getAllocatedAgents().clear();
				getAllocatedAgents().addAll((Collection<? extends Agent>)newValue);
				return;
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
				setCurrentExecCycle((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT:
				setIsUnderPreemptiveManagement(IS_UNDER_PREEMPTIVE_MANAGEMENT_EDEFAULT);
				return;
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS:
				getAllocatedAgents().clear();
				return;
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
				setCurrentExecCycle(CURRENT_EXEC_CYCLE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT:
				return isUnderPreemptiveManagement != IS_UNDER_PREEMPTIVE_MANAGEMENT_EDEFAULT;
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS:
				return allocatedAgents != null && !allocatedAgents.isEmpty();
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
				return currentExecCycle != CURRENT_EXEC_CYCLE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isUnderPreemptiveManagement: ");
		result.append(isUnderPreemptiveManagement);
		result.append(", currentExecCycle: ");
		result.append(currentExecCycle);
		result.append(')');
		return result.toString();
	}

} //HWComputationalResourceImpl
