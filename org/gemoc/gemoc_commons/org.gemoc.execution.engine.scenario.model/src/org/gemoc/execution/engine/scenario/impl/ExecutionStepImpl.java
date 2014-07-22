/**
 */
package org.gemoc.execution.engine.scenario.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;
import org.gemoc.execution.engine.scenario.ScenarioPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.scenario.impl.ExecutionStepImpl#getEventList <em>Event List</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.scenario.impl.ExecutionStepImpl#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
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
	 * The default value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getStep() <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStep()
	 * @generated
	 * @ordered
	 */
	protected int step = STEP_EDEFAULT;

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
	public int getStep() {
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStep(int newStep) {
		int oldStep = step;
		step = newStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.EXECUTION_STEP__STEP, oldStep, step));
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
			case ScenarioPackage.EXECUTION_STEP__STEP:
				return getStep();
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
			case ScenarioPackage.EXECUTION_STEP__STEP:
				setStep((Integer)newValue);
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
			case ScenarioPackage.EXECUTION_STEP__STEP:
				setStep(STEP_EDEFAULT);
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
			case ScenarioPackage.EXECUTION_STEP__STEP:
				return step != STEP_EDEFAULT;
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
		result.append(" (step: ");
		result.append(step);
		result.append(')');
		return result.toString();
	}

} //ExecutionStepImpl
