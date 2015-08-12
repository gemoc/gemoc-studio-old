/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MSE Occurrence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.MSEOccurrenceImpl#getMse <em>Mse</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.MSEOccurrenceImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.MSEOccurrenceImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.MSEOccurrenceImpl#getLogicalstep <em>Logicalstep</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MSEOccurrenceImpl extends MinimalEObjectImpl.Container implements MSEOccurrence {
	/**
	 * The cached value of the '{@link #getMse() <em>Mse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMse()
	 * @generated
	 * @ordered
	 */
	protected ModelSpecificEvent mse;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> parameters;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MSEOccurrenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gemoc_execution_tracePackage.Literals.MSE_OCCURRENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSpecificEvent getMse() {
		if (mse != null && mse.eIsProxy()) {
			InternalEObject oldMse = (InternalEObject)mse;
			mse = (ModelSpecificEvent)eResolveProxy(oldMse);
			if (mse != oldMse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gemoc_execution_tracePackage.MSE_OCCURRENCE__MSE, oldMse, mse));
			}
		}
		return mse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelSpecificEvent basicGetMse() {
		return mse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMse(ModelSpecificEvent newMse) {
		ModelSpecificEvent oldMse = mse;
		mse = newMse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.MSE_OCCURRENCE__MSE, oldMse, mse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getParameters() {
		if (parameters == null) {
			parameters = new EDataTypeUniqueEList<Object>(Object.class, this, Gemoc_execution_tracePackage.MSE_OCCURRENCE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getResult() {
		if (result == null) {
			result = new EDataTypeUniqueEList<Object>(Object.class, this, Gemoc_execution_tracePackage.MSE_OCCURRENCE__RESULT);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalStep getLogicalstep() {
		if (eContainerFeatureID() != Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP) return null;
		return (LogicalStep)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLogicalstep(LogicalStep newLogicalstep, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newLogicalstep, Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogicalstep(LogicalStep newLogicalstep) {
		if (newLogicalstep != eInternalContainer() || (eContainerFeatureID() != Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP && newLogicalstep != null)) {
			if (EcoreUtil.isAncestor(this, newLogicalstep))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newLogicalstep != null)
				msgs = ((InternalEObject)newLogicalstep).eInverseAdd(this, Gemoc_execution_tracePackage.LOGICAL_STEP__MSE_OCCURRENCES, LogicalStep.class, msgs);
			msgs = basicSetLogicalstep(newLogicalstep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP, newLogicalstep, newLogicalstep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetLogicalstep((LogicalStep)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP:
				return basicSetLogicalstep(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP:
				return eInternalContainer().eInverseRemove(this, Gemoc_execution_tracePackage.LOGICAL_STEP__MSE_OCCURRENCES, LogicalStep.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__MSE:
				if (resolve) return getMse();
				return basicGetMse();
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__PARAMETERS:
				return getParameters();
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__RESULT:
				return getResult();
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP:
				return getLogicalstep();
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
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__MSE:
				setMse((ModelSpecificEvent)newValue);
				return;
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Object>)newValue);
				return;
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__RESULT:
				getResult().clear();
				getResult().addAll((Collection<? extends Object>)newValue);
				return;
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP:
				setLogicalstep((LogicalStep)newValue);
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
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__MSE:
				setMse((ModelSpecificEvent)null);
				return;
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__PARAMETERS:
				getParameters().clear();
				return;
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__RESULT:
				getResult().clear();
				return;
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP:
				setLogicalstep((LogicalStep)null);
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
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__MSE:
				return mse != null;
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__RESULT:
				return result != null && !result.isEmpty();
			case Gemoc_execution_tracePackage.MSE_OCCURRENCE__LOGICALSTEP:
				return getLogicalstep() != null;
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
		result.append(" (parameters: ");
		result.append(parameters);
		result.append(", result: ");
		result.append(result);
		result.append(')');
		return result.toString();
	}

} //MSEOccurrenceImpl
