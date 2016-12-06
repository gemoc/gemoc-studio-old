/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;

import tfsm_plaink3Trace.States.StatesPackage;
import tfsm_plaink3Trace.States.TFSM_currentState_Value;
import tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value;
import tfsm_plaink3Trace.States.TFSM_stepNumber_Value;

import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traced TFSM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getCurrentStateSequence <em>Current State Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getOriginalObject <em>Original Object</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getStepNumberSequence <em>Step Number Sequence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TracedTFSMImpl extends TracedNamedElementImpl implements TracedTFSM {
	/**
	 * The cached value of the '{@link #getCurrentStateSequence() <em>Current State Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentStateSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<TFSM_currentState_Value> currentStateSequence;

	/**
	 * The cached value of the '{@link #getLastStateChangeStepNumberSequence() <em>Last State Change Step Number Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastStateChangeStepNumberSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<TFSM_lastStateChangeStepNumber_Value> lastStateChangeStepNumberSequence;

	/**
	 * The cached value of the '{@link #getOriginalObject() <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalObject()
	 * @generated
	 * @ordered
	 */
	protected TFSM originalObject;

	/**
	 * The cached value of the '{@link #getStepNumberSequence() <em>Step Number Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepNumberSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<TFSM_stepNumber_Value> stepNumberSequence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedTFSMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tfsm_plaink3Package.Literals.TRACED_TFSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TFSM_currentState_Value> getCurrentStateSequence() {
		if (currentStateSequence == null) {
			currentStateSequence = new EObjectContainmentWithInverseEList<TFSM_currentState_Value>(TFSM_currentState_Value.class, this, Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE, StatesPackage.TFSM_CURRENT_STATE_VALUE__PARENT);
		}
		return currentStateSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TFSM_lastStateChangeStepNumber_Value> getLastStateChangeStepNumberSequence() {
		if (lastStateChangeStepNumberSequence == null) {
			lastStateChangeStepNumberSequence = new EObjectContainmentWithInverseEList<TFSM_lastStateChangeStepNumber_Value>(TFSM_lastStateChangeStepNumber_Value.class, this, Tfsm_plaink3Package.TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE, StatesPackage.TFSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__PARENT);
		}
		return lastStateChangeStepNumberSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFSM getOriginalObject() {
		if (originalObject != null && originalObject.eIsProxy()) {
			InternalEObject oldOriginalObject = (InternalEObject)originalObject;
			originalObject = (TFSM)eResolveProxy(oldOriginalObject);
			if (originalObject != oldOriginalObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tfsm_plaink3Package.TRACED_TFSM__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
			}
		}
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFSM basicGetOriginalObject() {
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalObject(TFSM newOriginalObject) {
		TFSM oldOriginalObject = originalObject;
		originalObject = newOriginalObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRACED_TFSM__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TFSM_stepNumber_Value> getStepNumberSequence() {
		if (stepNumberSequence == null) {
			stepNumberSequence = new EObjectContainmentWithInverseEList<TFSM_stepNumber_Value>(TFSM_stepNumber_Value.class, this, Tfsm_plaink3Package.TRACED_TFSM__STEP_NUMBER_SEQUENCE, StatesPackage.TFSM_STEP_NUMBER_VALUE__PARENT);
		}
		return stepNumberSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCurrentStateSequence()).basicAdd(otherEnd, msgs);
			case Tfsm_plaink3Package.TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLastStateChangeStepNumberSequence()).basicAdd(otherEnd, msgs);
			case Tfsm_plaink3Package.TRACED_TFSM__STEP_NUMBER_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStepNumberSequence()).basicAdd(otherEnd, msgs);
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				return ((InternalEList<?>)getCurrentStateSequence()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3Package.TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				return ((InternalEList<?>)getLastStateChangeStepNumberSequence()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3Package.TRACED_TFSM__STEP_NUMBER_SEQUENCE:
				return ((InternalEList<?>)getStepNumberSequence()).basicRemove(otherEnd, msgs);
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				return getCurrentStateSequence();
			case Tfsm_plaink3Package.TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				return getLastStateChangeStepNumberSequence();
			case Tfsm_plaink3Package.TRACED_TFSM__ORIGINAL_OBJECT:
				if (resolve) return getOriginalObject();
				return basicGetOriginalObject();
			case Tfsm_plaink3Package.TRACED_TFSM__STEP_NUMBER_SEQUENCE:
				return getStepNumberSequence();
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				getCurrentStateSequence().clear();
				getCurrentStateSequence().addAll((Collection<? extends TFSM_currentState_Value>)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				getLastStateChangeStepNumberSequence().clear();
				getLastStateChangeStepNumberSequence().addAll((Collection<? extends TFSM_lastStateChangeStepNumber_Value>)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__ORIGINAL_OBJECT:
				setOriginalObject((TFSM)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__STEP_NUMBER_SEQUENCE:
				getStepNumberSequence().clear();
				getStepNumberSequence().addAll((Collection<? extends TFSM_stepNumber_Value>)newValue);
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				getCurrentStateSequence().clear();
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				getLastStateChangeStepNumberSequence().clear();
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__ORIGINAL_OBJECT:
				setOriginalObject((TFSM)null);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__STEP_NUMBER_SEQUENCE:
				getStepNumberSequence().clear();
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				return currentStateSequence != null && !currentStateSequence.isEmpty();
			case Tfsm_plaink3Package.TRACED_TFSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				return lastStateChangeStepNumberSequence != null && !lastStateChangeStepNumberSequence.isEmpty();
			case Tfsm_plaink3Package.TRACED_TFSM__ORIGINAL_OBJECT:
				return originalObject != null;
			case Tfsm_plaink3Package.TRACED_TFSM__STEP_NUMBER_SEQUENCE:
				return stepNumberSequence != null && !stepNumberSequence.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TracedTFSMImpl
