/**
 */
package GemocExecutionEngineTrace.impl;

import GemocExecutionEngineTrace.EventOccurence;
import GemocExecutionEngineTrace.ExecutionLogicalStep;
import GemocExecutionEngineTrace.GemocExecutionEngineTracePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Logical Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link GemocExecutionEngineTrace.impl.ExecutionLogicalStepImpl#getEventOccurences <em>Event Occurences</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionLogicalStepImpl extends MinimalEObjectImpl.Container implements ExecutionLogicalStep {
	/**
	 * The cached value of the '{@link #getEventOccurences() <em>Event Occurences</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventOccurences()
	 * @generated
	 * @ordered
	 */
	protected EList<EventOccurence> eventOccurences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionLogicalStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GemocExecutionEngineTracePackage.Literals.EXECUTION_LOGICAL_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventOccurence> getEventOccurences() {
		if (eventOccurences == null) {
			eventOccurences = new EObjectContainmentEList<EventOccurence>(EventOccurence.class, this, GemocExecutionEngineTracePackage.EXECUTION_LOGICAL_STEP__EVENT_OCCURENCES);
		}
		return eventOccurences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.EXECUTION_LOGICAL_STEP__EVENT_OCCURENCES:
				return ((InternalEList<?>)getEventOccurences()).basicRemove(otherEnd, msgs);
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
			case GemocExecutionEngineTracePackage.EXECUTION_LOGICAL_STEP__EVENT_OCCURENCES:
				return getEventOccurences();
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
			case GemocExecutionEngineTracePackage.EXECUTION_LOGICAL_STEP__EVENT_OCCURENCES:
				getEventOccurences().clear();
				getEventOccurences().addAll((Collection<? extends EventOccurence>)newValue);
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
			case GemocExecutionEngineTracePackage.EXECUTION_LOGICAL_STEP__EVENT_OCCURENCES:
				getEventOccurences().clear();
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
			case GemocExecutionEngineTracePackage.EXECUTION_LOGICAL_STEP__EVENT_OCCURENCES:
				return eventOccurences != null && !eventOccurences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExecutionLogicalStepImpl
