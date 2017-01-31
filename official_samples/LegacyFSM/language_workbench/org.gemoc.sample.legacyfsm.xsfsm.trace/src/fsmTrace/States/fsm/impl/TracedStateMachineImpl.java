/**
 */
package fsmTrace.States.fsm.impl;

import fsmTrace.States.StateMachine_consummedString_Value;
import fsmTrace.States.StateMachine_currentState_Value;
import fsmTrace.States.StateMachine_producedString_Value;
import fsmTrace.States.StateMachine_unprocessedString_Value;
import fsmTrace.States.StatesPackage;

import fsmTrace.States.fsm.FsmPackage;
import fsmTrace.States.fsm.TracedStateMachine;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.StateMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traced State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.fsm.impl.TracedStateMachineImpl#getConsummedStringSequence <em>Consummed String Sequence</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.impl.TracedStateMachineImpl#getCurrentStateSequence <em>Current State Sequence</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.impl.TracedStateMachineImpl#getOriginalObject <em>Original Object</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.impl.TracedStateMachineImpl#getProducedStringSequence <em>Produced String Sequence</em>}</li>
 *   <li>{@link fsmTrace.States.fsm.impl.TracedStateMachineImpl#getUnprocessedStringSequence <em>Unprocessed String Sequence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TracedStateMachineImpl extends TracedNamedElementImpl implements TracedStateMachine {
	/**
	 * The cached value of the '{@link #getConsummedStringSequence() <em>Consummed String Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsummedStringSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine_consummedString_Value> consummedStringSequence;

	/**
	 * The cached value of the '{@link #getCurrentStateSequence() <em>Current State Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentStateSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine_currentState_Value> currentStateSequence;

	/**
	 * The cached value of the '{@link #getOriginalObject() <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalObject()
	 * @generated
	 * @ordered
	 */
	protected StateMachine originalObject;

	/**
	 * The cached value of the '{@link #getProducedStringSequence() <em>Produced String Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProducedStringSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine_producedString_Value> producedStringSequence;

	/**
	 * The cached value of the '{@link #getUnprocessedStringSequence() <em>Unprocessed String Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnprocessedStringSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine_unprocessedString_Value> unprocessedStringSequence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedStateMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.TRACED_STATE_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine_consummedString_Value> getConsummedStringSequence() {
		if (consummedStringSequence == null) {
			consummedStringSequence = new EObjectContainmentWithInverseEList<StateMachine_consummedString_Value>(StateMachine_consummedString_Value.class, this, FsmPackage.TRACED_STATE_MACHINE__CONSUMMED_STRING_SEQUENCE, StatesPackage.STATE_MACHINE_CONSUMMED_STRING_VALUE__PARENT);
		}
		return consummedStringSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine_currentState_Value> getCurrentStateSequence() {
		if (currentStateSequence == null) {
			currentStateSequence = new EObjectContainmentWithInverseEList<StateMachine_currentState_Value>(StateMachine_currentState_Value.class, this, FsmPackage.TRACED_STATE_MACHINE__CURRENT_STATE_SEQUENCE, StatesPackage.STATE_MACHINE_CURRENT_STATE_VALUE__PARENT);
		}
		return currentStateSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getOriginalObject() {
		if (originalObject != null && originalObject.eIsProxy()) {
			InternalEObject oldOriginalObject = (InternalEObject)originalObject;
			originalObject = (StateMachine)eResolveProxy(oldOriginalObject);
			if (originalObject != oldOriginalObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FsmPackage.TRACED_STATE_MACHINE__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
			}
		}
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine basicGetOriginalObject() {
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalObject(StateMachine newOriginalObject) {
		StateMachine oldOriginalObject = originalObject;
		originalObject = newOriginalObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FsmPackage.TRACED_STATE_MACHINE__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine_producedString_Value> getProducedStringSequence() {
		if (producedStringSequence == null) {
			producedStringSequence = new EObjectContainmentWithInverseEList<StateMachine_producedString_Value>(StateMachine_producedString_Value.class, this, FsmPackage.TRACED_STATE_MACHINE__PRODUCED_STRING_SEQUENCE, StatesPackage.STATE_MACHINE_PRODUCED_STRING_VALUE__PARENT);
		}
		return producedStringSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine_unprocessedString_Value> getUnprocessedStringSequence() {
		if (unprocessedStringSequence == null) {
			unprocessedStringSequence = new EObjectContainmentWithInverseEList<StateMachine_unprocessedString_Value>(StateMachine_unprocessedString_Value.class, this, FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE, StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT);
		}
		return unprocessedStringSequence;
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
			case FsmPackage.TRACED_STATE_MACHINE__CONSUMMED_STRING_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConsummedStringSequence()).basicAdd(otherEnd, msgs);
			case FsmPackage.TRACED_STATE_MACHINE__CURRENT_STATE_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCurrentStateSequence()).basicAdd(otherEnd, msgs);
			case FsmPackage.TRACED_STATE_MACHINE__PRODUCED_STRING_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProducedStringSequence()).basicAdd(otherEnd, msgs);
			case FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUnprocessedStringSequence()).basicAdd(otherEnd, msgs);
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
			case FsmPackage.TRACED_STATE_MACHINE__CONSUMMED_STRING_SEQUENCE:
				return ((InternalEList<?>)getConsummedStringSequence()).basicRemove(otherEnd, msgs);
			case FsmPackage.TRACED_STATE_MACHINE__CURRENT_STATE_SEQUENCE:
				return ((InternalEList<?>)getCurrentStateSequence()).basicRemove(otherEnd, msgs);
			case FsmPackage.TRACED_STATE_MACHINE__PRODUCED_STRING_SEQUENCE:
				return ((InternalEList<?>)getProducedStringSequence()).basicRemove(otherEnd, msgs);
			case FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE:
				return ((InternalEList<?>)getUnprocessedStringSequence()).basicRemove(otherEnd, msgs);
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
			case FsmPackage.TRACED_STATE_MACHINE__CONSUMMED_STRING_SEQUENCE:
				return getConsummedStringSequence();
			case FsmPackage.TRACED_STATE_MACHINE__CURRENT_STATE_SEQUENCE:
				return getCurrentStateSequence();
			case FsmPackage.TRACED_STATE_MACHINE__ORIGINAL_OBJECT:
				if (resolve) return getOriginalObject();
				return basicGetOriginalObject();
			case FsmPackage.TRACED_STATE_MACHINE__PRODUCED_STRING_SEQUENCE:
				return getProducedStringSequence();
			case FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE:
				return getUnprocessedStringSequence();
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
			case FsmPackage.TRACED_STATE_MACHINE__CONSUMMED_STRING_SEQUENCE:
				getConsummedStringSequence().clear();
				getConsummedStringSequence().addAll((Collection<? extends StateMachine_consummedString_Value>)newValue);
				return;
			case FsmPackage.TRACED_STATE_MACHINE__CURRENT_STATE_SEQUENCE:
				getCurrentStateSequence().clear();
				getCurrentStateSequence().addAll((Collection<? extends StateMachine_currentState_Value>)newValue);
				return;
			case FsmPackage.TRACED_STATE_MACHINE__ORIGINAL_OBJECT:
				setOriginalObject((StateMachine)newValue);
				return;
			case FsmPackage.TRACED_STATE_MACHINE__PRODUCED_STRING_SEQUENCE:
				getProducedStringSequence().clear();
				getProducedStringSequence().addAll((Collection<? extends StateMachine_producedString_Value>)newValue);
				return;
			case FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE:
				getUnprocessedStringSequence().clear();
				getUnprocessedStringSequence().addAll((Collection<? extends StateMachine_unprocessedString_Value>)newValue);
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
			case FsmPackage.TRACED_STATE_MACHINE__CONSUMMED_STRING_SEQUENCE:
				getConsummedStringSequence().clear();
				return;
			case FsmPackage.TRACED_STATE_MACHINE__CURRENT_STATE_SEQUENCE:
				getCurrentStateSequence().clear();
				return;
			case FsmPackage.TRACED_STATE_MACHINE__ORIGINAL_OBJECT:
				setOriginalObject((StateMachine)null);
				return;
			case FsmPackage.TRACED_STATE_MACHINE__PRODUCED_STRING_SEQUENCE:
				getProducedStringSequence().clear();
				return;
			case FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE:
				getUnprocessedStringSequence().clear();
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
			case FsmPackage.TRACED_STATE_MACHINE__CONSUMMED_STRING_SEQUENCE:
				return consummedStringSequence != null && !consummedStringSequence.isEmpty();
			case FsmPackage.TRACED_STATE_MACHINE__CURRENT_STATE_SEQUENCE:
				return currentStateSequence != null && !currentStateSequence.isEmpty();
			case FsmPackage.TRACED_STATE_MACHINE__ORIGINAL_OBJECT:
				return originalObject != null;
			case FsmPackage.TRACED_STATE_MACHINE__PRODUCED_STRING_SEQUENCE:
				return producedStringSequence != null && !producedStringSequence.isEmpty();
			case FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE:
				return unprocessedStringSequence != null && !unprocessedStringSequence.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TracedStateMachineImpl
