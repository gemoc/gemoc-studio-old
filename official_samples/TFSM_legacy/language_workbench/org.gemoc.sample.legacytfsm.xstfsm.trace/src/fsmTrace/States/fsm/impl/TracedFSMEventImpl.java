/**
 */
package fsmTrace.States.fsm.impl;

import fsmTrace.States.FSMEvent_isTriggered_Value;
import fsmTrace.States.StatesPackage;

import fsmTrace.States.fsm.FsmPackage;
import fsmTrace.States.fsm.TracedFSMEvent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traced FSM Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.fsm.impl.TracedFSMEventImpl#getIsTriggeredSequence <em>Is Triggered Sequence</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.impl.TracedFSMEventImpl#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TracedFSMEventImpl extends TracedNamedElementImpl implements TracedFSMEvent {
	/**
	 * The cached value of the '{@link #getIsTriggeredSequence() <em>Is Triggered Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsTriggeredSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMEvent_isTriggered_Value> isTriggeredSequence;

	/**
	 * The cached value of the '{@link #getOriginalObject() <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalObject()
	 * @generated
	 * @ordered
	 */
	protected FSMEvent originalObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedFSMEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.TRACED_FSM_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSMEvent_isTriggered_Value> getIsTriggeredSequence() {
		if (isTriggeredSequence == null) {
			isTriggeredSequence = new EObjectContainmentWithInverseEList<FSMEvent_isTriggered_Value>(FSMEvent_isTriggered_Value.class, this, FsmPackage.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE, StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT);
		}
		return isTriggeredSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMEvent getOriginalObject() {
		if (originalObject != null && originalObject.eIsProxy()) {
			InternalEObject oldOriginalObject = (InternalEObject)originalObject;
			originalObject = (FSMEvent)eResolveProxy(oldOriginalObject);
			if (originalObject != oldOriginalObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.TRACED_FSM_EVENT__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
			}
		}
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMEvent basicGetOriginalObject() {
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalObject(FSMEvent newOriginalObject) {
		FSMEvent oldOriginalObject = originalObject;
		originalObject = newOriginalObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRACED_FSM_EVENT__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
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
			case FsmPackage.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsTriggeredSequence()).basicAdd(otherEnd, msgs);
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
			case FsmPackage.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE:
				return ((InternalEList<?>)getIsTriggeredSequence()).basicRemove(otherEnd, msgs);
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
			case FsmPackage.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE:
				return getIsTriggeredSequence();
			case FsmPackage.TRACED_FSM_EVENT__ORIGINAL_OBJECT:
				if (resolve) return getOriginalObject();
				return basicGetOriginalObject();
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
			case FsmPackage.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE:
				getIsTriggeredSequence().clear();
				getIsTriggeredSequence().addAll((Collection<? extends FSMEvent_isTriggered_Value>)newValue);
				return;
			case FsmPackage.TRACED_FSM_EVENT__ORIGINAL_OBJECT:
				setOriginalObject((FSMEvent)newValue);
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
			case FsmPackage.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE:
				getIsTriggeredSequence().clear();
				return;
			case FsmPackage.TRACED_FSM_EVENT__ORIGINAL_OBJECT:
				setOriginalObject((FSMEvent)null);
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
			case FsmPackage.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE:
				return isTriggeredSequence != null && !isTriggeredSequence.isEmpty();
			case FsmPackage.TRACED_FSM_EVENT__ORIGINAL_OBJECT:
				return originalObject != null;
		}
		return super.eIsSet(featureID);
	}

} //TracedFSMEventImpl
