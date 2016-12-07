/**
 */
package org.gemoc.sample.legacyfsm.fsm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.legacyfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.fsm.FSMEvent;
import org.gemoc.sample.legacyfsm.fsm.FsmPackage;
import org.gemoc.sample.legacyfsm.fsm.TimeFSM;
import org.gemoc.sample.legacyfsm.fsm.TimedSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Timed System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.legacyfsm.fsm.impl.TimedSystemImpl#getFsms <em>Fsms</em>}</li>
 *   <li>{@link org.gemoc.sample.legacyfsm.fsm.impl.TimedSystemImpl#getGlobalClocks <em>Global Clocks</em>}</li>
 *   <li>{@link org.gemoc.sample.legacyfsm.fsm.impl.TimedSystemImpl#getGlobalEvents <em>Global Events</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimedSystemImpl extends NamedElementImpl implements TimedSystem {
	/**
	 * The cached value of the '{@link #getFsms() <em>Fsms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsms()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeFSM> fsms;

	/**
	 * The cached value of the '{@link #getGlobalClocks() <em>Global Clocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalClocks()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMClock> globalClocks;

	/**
	 * The cached value of the '{@link #getGlobalEvents() <em>Global Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMEvent> globalEvents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimedSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmPackage.Literals.TIMED_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeFSM> getFsms() {
		if (fsms == null) {
			fsms = new EObjectContainmentEList<TimeFSM>(TimeFSM.class, this, FsmPackage.TIMED_SYSTEM__FSMS);
		}
		return fsms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSMClock> getGlobalClocks() {
		if (globalClocks == null) {
			globalClocks = new EObjectContainmentEList<FSMClock>(FSMClock.class, this, FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS);
		}
		return globalClocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSMEvent> getGlobalEvents() {
		if (globalEvents == null) {
			globalEvents = new EObjectContainmentEList<FSMEvent>(FSMEvent.class, this, FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS);
		}
		return globalEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmPackage.TIMED_SYSTEM__FSMS:
				return ((InternalEList<?>)getFsms()).basicRemove(otherEnd, msgs);
			case FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
				return ((InternalEList<?>)getGlobalClocks()).basicRemove(otherEnd, msgs);
			case FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
				return ((InternalEList<?>)getGlobalEvents()).basicRemove(otherEnd, msgs);
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
			case FsmPackage.TIMED_SYSTEM__FSMS:
				return getFsms();
			case FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
				return getGlobalClocks();
			case FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
				return getGlobalEvents();
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
			case FsmPackage.TIMED_SYSTEM__FSMS:
				getFsms().clear();
				getFsms().addAll((Collection<? extends TimeFSM>)newValue);
				return;
			case FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
				getGlobalClocks().clear();
				getGlobalClocks().addAll((Collection<? extends FSMClock>)newValue);
				return;
			case FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
				getGlobalEvents().clear();
				getGlobalEvents().addAll((Collection<? extends FSMEvent>)newValue);
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
			case FsmPackage.TIMED_SYSTEM__FSMS:
				getFsms().clear();
				return;
			case FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
				getGlobalClocks().clear();
				return;
			case FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
				getGlobalEvents().clear();
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
			case FsmPackage.TIMED_SYSTEM__FSMS:
				return fsms != null && !fsms.isEmpty();
			case FsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
				return globalClocks != null && !globalClocks.isEmpty();
			case FsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
				return globalEvents != null && !globalEvents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TimedSystemImpl
