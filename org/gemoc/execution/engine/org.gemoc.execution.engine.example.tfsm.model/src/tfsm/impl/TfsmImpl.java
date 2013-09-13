/**
 */
package tfsm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tfsm.State;
import tfsm.Tfsm;
import tfsm.TfsmClock;
import tfsm.TfsmEvent;
import tfsm.TfsmPackage;
import tfsm.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tfsm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tfsm.impl.TfsmImpl#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link tfsm.impl.TfsmImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link tfsm.impl.TfsmImpl#getOwnedEvents <em>Owned Events</em>}</li>
 *   <li>{@link tfsm.impl.TfsmImpl#getOwnedClock <em>Owned Clock</em>}</li>
 *   <li>{@link tfsm.impl.TfsmImpl#getOwnedTransitions <em>Owned Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TfsmImpl extends NamedElementImpl implements Tfsm {
    /**
     * The cached value of the '{@link #getOwnedStates() <em>Owned States</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwnedStates()
     * @generated
     * @ordered
     */
    protected EList<State> ownedStates;

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
     * The cached value of the '{@link #getOwnedEvents() <em>Owned Events</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwnedEvents()
     * @generated
     * @ordered
     */
    protected EList<TfsmEvent> ownedEvents;

    /**
     * The cached value of the '{@link #getOwnedClock() <em>Owned Clock</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwnedClock()
     * @generated
     * @ordered
     */
    protected TfsmClock ownedClock;

    /**
     * The cached value of the '{@link #getOwnedTransitions() <em>Owned Transitions</em>}' containment reference list.
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
    protected TfsmImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TfsmPackage.Literals.TFSM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<State> getOwnedStates() {
        if (ownedStates == null) {
            ownedStates = new EObjectContainmentEList<State>(State.class, this, TfsmPackage.TFSM__OWNED_STATES);
        }
        return ownedStates;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TfsmPackage.TFSM__INITIAL_STATE, oldInitialState, initialState));
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
            eNotify(new ENotificationImpl(this, Notification.SET, TfsmPackage.TFSM__INITIAL_STATE, oldInitialState, initialState));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TfsmEvent> getOwnedEvents() {
        if (ownedEvents == null) {
            ownedEvents = new EObjectContainmentEList<TfsmEvent>(TfsmEvent.class, this, TfsmPackage.TFSM__OWNED_EVENTS);
        }
        return ownedEvents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TfsmClock getOwnedClock() {
        return ownedClock;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOwnedClock(TfsmClock newOwnedClock, NotificationChain msgs) {
        TfsmClock oldOwnedClock = ownedClock;
        ownedClock = newOwnedClock;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TfsmPackage.TFSM__OWNED_CLOCK, oldOwnedClock, newOwnedClock);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOwnedClock(TfsmClock newOwnedClock) {
        if (newOwnedClock != ownedClock) {
            NotificationChain msgs = null;
            if (ownedClock != null)
                msgs = ((InternalEObject)ownedClock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TfsmPackage.TFSM__OWNED_CLOCK, null, msgs);
            if (newOwnedClock != null)
                msgs = ((InternalEObject)newOwnedClock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TfsmPackage.TFSM__OWNED_CLOCK, null, msgs);
            msgs = basicSetOwnedClock(newOwnedClock, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TfsmPackage.TFSM__OWNED_CLOCK, newOwnedClock, newOwnedClock));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Transition> getOwnedTransitions() {
        if (ownedTransitions == null) {
            ownedTransitions = new EObjectContainmentEList<Transition>(Transition.class, this, TfsmPackage.TFSM__OWNED_TRANSITIONS);
        }
        return ownedTransitions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TfsmPackage.TFSM__OWNED_STATES:
                return ((InternalEList<?>)getOwnedStates()).basicRemove(otherEnd, msgs);
            case TfsmPackage.TFSM__OWNED_EVENTS:
                return ((InternalEList<?>)getOwnedEvents()).basicRemove(otherEnd, msgs);
            case TfsmPackage.TFSM__OWNED_CLOCK:
                return basicSetOwnedClock(null, msgs);
            case TfsmPackage.TFSM__OWNED_TRANSITIONS:
                return ((InternalEList<?>)getOwnedTransitions()).basicRemove(otherEnd, msgs);
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
            case TfsmPackage.TFSM__OWNED_STATES:
                return getOwnedStates();
            case TfsmPackage.TFSM__INITIAL_STATE:
                if (resolve) return getInitialState();
                return basicGetInitialState();
            case TfsmPackage.TFSM__OWNED_EVENTS:
                return getOwnedEvents();
            case TfsmPackage.TFSM__OWNED_CLOCK:
                return getOwnedClock();
            case TfsmPackage.TFSM__OWNED_TRANSITIONS:
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
            case TfsmPackage.TFSM__OWNED_STATES:
                getOwnedStates().clear();
                getOwnedStates().addAll((Collection<? extends State>)newValue);
                return;
            case TfsmPackage.TFSM__INITIAL_STATE:
                setInitialState((State)newValue);
                return;
            case TfsmPackage.TFSM__OWNED_EVENTS:
                getOwnedEvents().clear();
                getOwnedEvents().addAll((Collection<? extends TfsmEvent>)newValue);
                return;
            case TfsmPackage.TFSM__OWNED_CLOCK:
                setOwnedClock((TfsmClock)newValue);
                return;
            case TfsmPackage.TFSM__OWNED_TRANSITIONS:
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
            case TfsmPackage.TFSM__OWNED_STATES:
                getOwnedStates().clear();
                return;
            case TfsmPackage.TFSM__INITIAL_STATE:
                setInitialState((State)null);
                return;
            case TfsmPackage.TFSM__OWNED_EVENTS:
                getOwnedEvents().clear();
                return;
            case TfsmPackage.TFSM__OWNED_CLOCK:
                setOwnedClock((TfsmClock)null);
                return;
            case TfsmPackage.TFSM__OWNED_TRANSITIONS:
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
            case TfsmPackage.TFSM__OWNED_STATES:
                return ownedStates != null && !ownedStates.isEmpty();
            case TfsmPackage.TFSM__INITIAL_STATE:
                return initialState != null;
            case TfsmPackage.TFSM__OWNED_EVENTS:
                return ownedEvents != null && !ownedEvents.isEmpty();
            case TfsmPackage.TFSM__OWNED_CLOCK:
                return ownedClock != null;
            case TfsmPackage.TFSM__OWNED_TRANSITIONS:
                return ownedTransitions != null && !ownedTransitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //TfsmImpl
