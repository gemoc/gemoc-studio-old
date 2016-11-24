/**
 */
package tfsmTrace.States.tfsm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM;

import tfsmTrace.States.StatesPackage;
import tfsmTrace.States.TimeFSM_currentState_Value;
import tfsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value;
import tfsmTrace.States.TimeFSM_stepNumber_Value;

import tfsmTrace.States.tfsm.TfsmPackage;
import tfsmTrace.States.tfsm.TracedTimeFSM;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traced Time FSM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.tfsm.impl.TracedTimeFSMImpl#getCurrentStateSequence <em>Current State Sequence</em>}</li>
 *   <li>{@link tfsmTrace.States.tfsm.impl.TracedTimeFSMImpl#getLastStateChangeStepNumberSequence <em>Last State Change Step Number Sequence</em>}</li>
 *   <li>{@link tfsmTrace.States.tfsm.impl.TracedTimeFSMImpl#getOriginalObject <em>Original Object</em>}</li>
 *   <li>{@link tfsmTrace.States.tfsm.impl.TracedTimeFSMImpl#getStepNumberSequence <em>Step Number Sequence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TracedTimeFSMImpl extends TracedNamedElementImpl implements TracedTimeFSM {
	/**
	 * The cached value of the '{@link #getCurrentStateSequence() <em>Current State Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentStateSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeFSM_currentState_Value> currentStateSequence;

	/**
	 * The cached value of the '{@link #getLastStateChangeStepNumberSequence() <em>Last State Change Step Number Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastStateChangeStepNumberSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeFSM_lastStateChangeStepNumber_Value> lastStateChangeStepNumberSequence;

	/**
	 * The cached value of the '{@link #getOriginalObject() <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalObject()
	 * @generated
	 * @ordered
	 */
	protected TimeFSM originalObject;

	/**
	 * The cached value of the '{@link #getStepNumberSequence() <em>Step Number Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepNumberSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeFSM_stepNumber_Value> stepNumberSequence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedTimeFSMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmPackage.Literals.TRACED_TIME_FSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeFSM_currentState_Value> getCurrentStateSequence() {
		if (currentStateSequence == null) {
			currentStateSequence = new EObjectContainmentWithInverseEList<TimeFSM_currentState_Value>(TimeFSM_currentState_Value.class, this, TfsmPackage.TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE, StatesPackage.TIME_FSM_CURRENT_STATE_VALUE__PARENT);
		}
		return currentStateSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeFSM_lastStateChangeStepNumber_Value> getLastStateChangeStepNumberSequence() {
		if (lastStateChangeStepNumberSequence == null) {
			lastStateChangeStepNumberSequence = new EObjectContainmentWithInverseEList<TimeFSM_lastStateChangeStepNumber_Value>(TimeFSM_lastStateChangeStepNumber_Value.class, this, TfsmPackage.TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE, StatesPackage.TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__PARENT);
		}
		return lastStateChangeStepNumberSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeFSM getOriginalObject() {
		if (originalObject != null && originalObject.eIsProxy()) {
			InternalEObject oldOriginalObject = (InternalEObject)originalObject;
			originalObject = (TimeFSM)eResolveProxy(oldOriginalObject);
			if (originalObject != oldOriginalObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TfsmPackage.TRACED_TIME_FSM__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
			}
		}
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeFSM basicGetOriginalObject() {
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalObject(TimeFSM newOriginalObject) {
		TimeFSM oldOriginalObject = originalObject;
		originalObject = newOriginalObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmPackage.TRACED_TIME_FSM__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeFSM_stepNumber_Value> getStepNumberSequence() {
		if (stepNumberSequence == null) {
			stepNumberSequence = new EObjectContainmentWithInverseEList<TimeFSM_stepNumber_Value>(TimeFSM_stepNumber_Value.class, this, TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE, StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT);
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
			case TfsmPackage.TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCurrentStateSequence()).basicAdd(otherEnd, msgs);
			case TfsmPackage.TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLastStateChangeStepNumberSequence()).basicAdd(otherEnd, msgs);
			case TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE:
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
			case TfsmPackage.TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE:
				return ((InternalEList<?>)getCurrentStateSequence()).basicRemove(otherEnd, msgs);
			case TfsmPackage.TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				return ((InternalEList<?>)getLastStateChangeStepNumberSequence()).basicRemove(otherEnd, msgs);
			case TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE:
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
			case TfsmPackage.TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE:
				return getCurrentStateSequence();
			case TfsmPackage.TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				return getLastStateChangeStepNumberSequence();
			case TfsmPackage.TRACED_TIME_FSM__ORIGINAL_OBJECT:
				if (resolve) return getOriginalObject();
				return basicGetOriginalObject();
			case TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE:
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
			case TfsmPackage.TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE:
				getCurrentStateSequence().clear();
				getCurrentStateSequence().addAll((Collection<? extends TimeFSM_currentState_Value>)newValue);
				return;
			case TfsmPackage.TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				getLastStateChangeStepNumberSequence().clear();
				getLastStateChangeStepNumberSequence().addAll((Collection<? extends TimeFSM_lastStateChangeStepNumber_Value>)newValue);
				return;
			case TfsmPackage.TRACED_TIME_FSM__ORIGINAL_OBJECT:
				setOriginalObject((TimeFSM)newValue);
				return;
			case TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE:
				getStepNumberSequence().clear();
				getStepNumberSequence().addAll((Collection<? extends TimeFSM_stepNumber_Value>)newValue);
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
			case TfsmPackage.TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE:
				getCurrentStateSequence().clear();
				return;
			case TfsmPackage.TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				getLastStateChangeStepNumberSequence().clear();
				return;
			case TfsmPackage.TRACED_TIME_FSM__ORIGINAL_OBJECT:
				setOriginalObject((TimeFSM)null);
				return;
			case TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE:
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
			case TfsmPackage.TRACED_TIME_FSM__CURRENT_STATE_SEQUENCE:
				return currentStateSequence != null && !currentStateSequence.isEmpty();
			case TfsmPackage.TRACED_TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER_SEQUENCE:
				return lastStateChangeStepNumberSequence != null && !lastStateChangeStepNumberSequence.isEmpty();
			case TfsmPackage.TRACED_TIME_FSM__ORIGINAL_OBJECT:
				return originalObject != null;
			case TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE:
				return stepNumberSequence != null && !stepNumberSequence.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TracedTimeFSMImpl
