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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.tfsm_plaink3.State;
import org.gemoc.sample.tfsm_plaink3.Transition;

import tfsm_plaink3Trace.States.StatesPackage;
import tfsm_plaink3Trace.States.TFSM_currentState_Value;

import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traced TFSM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getCurrentStateSequence <em>Current State Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getLocalClock <em>Local Clock</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getLocalEvents <em>Local Events</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedTFSMImpl#getOwnedTransitions <em>Owned Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TracedTFSMImpl extends TracedNamedElementImpl implements TracedTFSM {
	/**
	 * The cached value of the '{@link #getCurrentState() <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentState()
	 * @generated
	 * @ordered
	 */
	protected State currentState;

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
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected State initialState;

	/**
	 * The cached value of the '{@link #getLocalClock() <em>Local Clock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalClock()
	 * @generated
	 * @ordered
	 */
	protected TracedFSMClock localClock;

	/**
	 * The cached value of the '{@link #getLocalEvents() <em>Local Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedFSMEvent> localEvents;

	/**
	 * The cached value of the '{@link #getOwnedStates() <em>Owned States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> ownedStates;

	/**
	 * The cached value of the '{@link #getOwnedTransitions() <em>Owned Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> ownedTransitions;

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
	public State getCurrentState() {
		if (currentState != null && currentState.eIsProxy()) {
			InternalEObject oldCurrentState = (InternalEObject)currentState;
			currentState = (State)eResolveProxy(oldCurrentState);
			if (currentState != oldCurrentState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE, oldCurrentState, currentState));
			}
		}
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetCurrentState() {
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentState(State newCurrentState) {
		State oldCurrentState = currentState;
		currentState = newCurrentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE, oldCurrentState, currentState));
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
	public State getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject)initialState;
			initialState = (State)eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tfsm_plaink3Package.TRACED_TFSM__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(State newInitialState) {
		State oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRACED_TFSM__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedFSMClock getLocalClock() {
		if (localClock != null && localClock.eIsProxy()) {
			InternalEObject oldLocalClock = (InternalEObject)localClock;
			localClock = (TracedFSMClock)eResolveProxy(oldLocalClock);
			if (localClock != oldLocalClock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tfsm_plaink3Package.TRACED_TFSM__LOCAL_CLOCK, oldLocalClock, localClock));
			}
		}
		return localClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedFSMClock basicGetLocalClock() {
		return localClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalClock(TracedFSMClock newLocalClock) {
		TracedFSMClock oldLocalClock = localClock;
		localClock = newLocalClock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRACED_TFSM__LOCAL_CLOCK, oldLocalClock, localClock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedFSMEvent> getLocalEvents() {
		if (localEvents == null) {
			localEvents = new EObjectResolvingEList<TracedFSMEvent>(TracedFSMEvent.class, this, Tfsm_plaink3Package.TRACED_TFSM__LOCAL_EVENTS);
		}
		return localEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getOwnedStates() {
		if (ownedStates == null) {
			ownedStates = new EObjectResolvingEList<State>(State.class, this, Tfsm_plaink3Package.TRACED_TFSM__OWNED_STATES);
		}
		return ownedStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOwnedTransitions() {
		if (ownedTransitions == null) {
			ownedTransitions = new EObjectResolvingEList<Transition>(Transition.class, this, Tfsm_plaink3Package.TRACED_TFSM__OWNED_TRANSITIONS);
		}
		return ownedTransitions;
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE:
				if (resolve) return getCurrentState();
				return basicGetCurrentState();
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				return getCurrentStateSequence();
			case Tfsm_plaink3Package.TRACED_TFSM__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
			case Tfsm_plaink3Package.TRACED_TFSM__LOCAL_CLOCK:
				if (resolve) return getLocalClock();
				return basicGetLocalClock();
			case Tfsm_plaink3Package.TRACED_TFSM__LOCAL_EVENTS:
				return getLocalEvents();
			case Tfsm_plaink3Package.TRACED_TFSM__OWNED_STATES:
				return getOwnedStates();
			case Tfsm_plaink3Package.TRACED_TFSM__OWNED_TRANSITIONS:
				return getOwnedTransitions();
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE:
				setCurrentState((State)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				getCurrentStateSequence().clear();
				getCurrentStateSequence().addAll((Collection<? extends TFSM_currentState_Value>)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__LOCAL_CLOCK:
				setLocalClock((TracedFSMClock)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__LOCAL_EVENTS:
				getLocalEvents().clear();
				getLocalEvents().addAll((Collection<? extends TracedFSMEvent>)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__OWNED_STATES:
				getOwnedStates().clear();
				getOwnedStates().addAll((Collection<? extends State>)newValue);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__OWNED_TRANSITIONS:
				getOwnedTransitions().clear();
				getOwnedTransitions().addAll((Collection<? extends Transition>)newValue);
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE:
				setCurrentState((State)null);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				getCurrentStateSequence().clear();
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__LOCAL_CLOCK:
				setLocalClock((TracedFSMClock)null);
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__LOCAL_EVENTS:
				getLocalEvents().clear();
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__OWNED_STATES:
				getOwnedStates().clear();
				return;
			case Tfsm_plaink3Package.TRACED_TFSM__OWNED_TRANSITIONS:
				getOwnedTransitions().clear();
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
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE:
				return currentState != null;
			case Tfsm_plaink3Package.TRACED_TFSM__CURRENT_STATE_SEQUENCE:
				return currentStateSequence != null && !currentStateSequence.isEmpty();
			case Tfsm_plaink3Package.TRACED_TFSM__INITIAL_STATE:
				return initialState != null;
			case Tfsm_plaink3Package.TRACED_TFSM__LOCAL_CLOCK:
				return localClock != null;
			case Tfsm_plaink3Package.TRACED_TFSM__LOCAL_EVENTS:
				return localEvents != null && !localEvents.isEmpty();
			case Tfsm_plaink3Package.TRACED_TFSM__OWNED_STATES:
				return ownedStates != null && !ownedStates.isEmpty();
			case Tfsm_plaink3Package.TRACED_TFSM__OWNED_TRANSITIONS:
				return ownedTransitions != null && !ownedTransitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TracedTFSMImpl
