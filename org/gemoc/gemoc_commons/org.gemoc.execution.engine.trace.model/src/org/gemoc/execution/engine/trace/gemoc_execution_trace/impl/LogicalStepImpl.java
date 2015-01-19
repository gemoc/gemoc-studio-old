/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.LogicalStepImpl#getEventExecutionContexts <em>Event Execution Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogicalStepImpl extends MinimalEObjectImpl.Container implements LogicalStep {
	/**
	 * The cached value of the '{@link #getEventExecutionContexts() <em>Event Execution Contexts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventExecutionContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<MSEExecutionContext> eventExecutionContexts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gemoc_execution_tracePackage.Literals.LOGICAL_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MSEExecutionContext> getEventExecutionContexts() {
		if (eventExecutionContexts == null) {
			eventExecutionContexts = new EObjectContainmentEList<MSEExecutionContext>(MSEExecutionContext.class, this, Gemoc_execution_tracePackage.LOGICAL_STEP__EVENT_EXECUTION_CONTEXTS);
		}
		return eventExecutionContexts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Gemoc_execution_tracePackage.LOGICAL_STEP__EVENT_EXECUTION_CONTEXTS:
				return ((InternalEList<?>)getEventExecutionContexts()).basicRemove(otherEnd, msgs);
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
			case Gemoc_execution_tracePackage.LOGICAL_STEP__EVENT_EXECUTION_CONTEXTS:
				return getEventExecutionContexts();
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
			case Gemoc_execution_tracePackage.LOGICAL_STEP__EVENT_EXECUTION_CONTEXTS:
				getEventExecutionContexts().clear();
				getEventExecutionContexts().addAll((Collection<? extends MSEExecutionContext>)newValue);
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
			case Gemoc_execution_tracePackage.LOGICAL_STEP__EVENT_EXECUTION_CONTEXTS:
				getEventExecutionContexts().clear();
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
			case Gemoc_execution_tracePackage.LOGICAL_STEP__EVENT_EXECUTION_CONTEXTS:
				return eventExecutionContexts != null && !eventExecutionContexts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LogicalStepImpl
