/**
 */
package org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.EventState;
import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ExecutionStep;
import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ScenarioPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.impl.ExecutionStepImpl#getEventList <em>Event List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecutionStepImpl extends MinimalEObjectImpl.Container implements ExecutionStep {
	/**
	 * The cached value of the '{@link #getEventList() <em>Event List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventList()
	 * @generated
	 * @ordered
	 */
	protected EList<EventState> eventList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.EXECUTION_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventState> getEventList() {
		if (eventList == null) {
			eventList = new EObjectContainmentEList<EventState>(EventState.class, this, ScenarioPackage.EXECUTION_STEP__EVENT_LIST);
		}
		return eventList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScenarioPackage.EXECUTION_STEP__EVENT_LIST:
				return ((InternalEList<?>)getEventList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScenarioPackage.EXECUTION_STEP__EVENT_LIST:
				return getEventList();
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
			case ScenarioPackage.EXECUTION_STEP__EVENT_LIST:
				getEventList().clear();
				getEventList().addAll((Collection<? extends EventState>)newValue);
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
			case ScenarioPackage.EXECUTION_STEP__EVENT_LIST:
				getEventList().clear();
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
			case ScenarioPackage.EXECUTION_STEP__EVENT_LIST:
				return eventList != null && !eventList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExecutionStepImpl
