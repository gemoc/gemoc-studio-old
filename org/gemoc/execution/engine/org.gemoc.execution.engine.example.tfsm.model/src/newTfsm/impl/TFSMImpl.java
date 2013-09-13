/**
 */
package newTfsm.impl;

import java.util.Collection;

import newTfsm.FSMClock;
import newTfsm.FSMEvent;
import newTfsm.NewTfsmPackage;
import newTfsm.State;
import newTfsm.TFSM;
import newTfsm.Transition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TFSM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link newTfsm.impl.TFSMImpl#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link newTfsm.impl.TFSMImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link newTfsm.impl.TFSMImpl#getLocalEvents <em>Local Events</em>}</li>
 *   <li>{@link newTfsm.impl.TFSMImpl#getLocalClock <em>Local Clock</em>}</li>
 *   <li>{@link newTfsm.impl.TFSMImpl#getOwnedTransitions <em>Owned Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TFSMImpl extends NamedElementImpl implements TFSM {
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
     * The cached value of the '{@link #getLocalEvents() <em>Local Events</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalEvents()
     * @generated
     * @ordered
     */
    protected EList<FSMEvent> localEvents;

    /**
     * The cached value of the '{@link #getLocalClock() <em>Local Clock</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalClock()
     * @generated
     * @ordered
     */
    protected FSMClock localClock;

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
    protected TFSMImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return NewTfsmPackage.Literals.TFSM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<State> getOwnedStates() {
        if (ownedStates == null) {
            ownedStates = new EObjectContainmentEList<State>(State.class, this, NewTfsmPackage.TFSM__OWNED_STATES);
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, NewTfsmPackage.TFSM__INITIAL_STATE, oldInitialState, initialState));
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
            eNotify(new ENotificationImpl(this, Notification.SET, NewTfsmPackage.TFSM__INITIAL_STATE, oldInitialState, initialState));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FSMEvent> getLocalEvents() {
        if (localEvents == null) {
            localEvents = new EObjectContainmentEList<FSMEvent>(FSMEvent.class, this, NewTfsmPackage.TFSM__LOCAL_EVENTS);
        }
        return localEvents;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FSMClock getLocalClock() {
        return localClock;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLocalClock(FSMClock newLocalClock, NotificationChain msgs) {
        FSMClock oldLocalClock = localClock;
        localClock = newLocalClock;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NewTfsmPackage.TFSM__LOCAL_CLOCK, oldLocalClock, newLocalClock);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalClock(FSMClock newLocalClock) {
        if (newLocalClock != localClock) {
            NotificationChain msgs = null;
            if (localClock != null)
                msgs = ((InternalEObject)localClock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NewTfsmPackage.TFSM__LOCAL_CLOCK, null, msgs);
            if (newLocalClock != null)
                msgs = ((InternalEObject)newLocalClock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NewTfsmPackage.TFSM__LOCAL_CLOCK, null, msgs);
            msgs = basicSetLocalClock(newLocalClock, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, NewTfsmPackage.TFSM__LOCAL_CLOCK, newLocalClock, newLocalClock));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Transition> getOwnedTransitions() {
        if (ownedTransitions == null) {
            ownedTransitions = new EObjectContainmentEList<Transition>(Transition.class, this, NewTfsmPackage.TFSM__OWNED_TRANSITIONS);
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
            case NewTfsmPackage.TFSM__OWNED_STATES:
                return ((InternalEList<?>)getOwnedStates()).basicRemove(otherEnd, msgs);
            case NewTfsmPackage.TFSM__LOCAL_EVENTS:
                return ((InternalEList<?>)getLocalEvents()).basicRemove(otherEnd, msgs);
            case NewTfsmPackage.TFSM__LOCAL_CLOCK:
                return basicSetLocalClock(null, msgs);
            case NewTfsmPackage.TFSM__OWNED_TRANSITIONS:
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
            case NewTfsmPackage.TFSM__OWNED_STATES:
                return getOwnedStates();
            case NewTfsmPackage.TFSM__INITIAL_STATE:
                if (resolve) return getInitialState();
                return basicGetInitialState();
            case NewTfsmPackage.TFSM__LOCAL_EVENTS:
                return getLocalEvents();
            case NewTfsmPackage.TFSM__LOCAL_CLOCK:
                return getLocalClock();
            case NewTfsmPackage.TFSM__OWNED_TRANSITIONS:
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
            case NewTfsmPackage.TFSM__OWNED_STATES:
                getOwnedStates().clear();
                getOwnedStates().addAll((Collection<? extends State>)newValue);
                return;
            case NewTfsmPackage.TFSM__INITIAL_STATE:
                setInitialState((State)newValue);
                return;
            case NewTfsmPackage.TFSM__LOCAL_EVENTS:
                getLocalEvents().clear();
                getLocalEvents().addAll((Collection<? extends FSMEvent>)newValue);
                return;
            case NewTfsmPackage.TFSM__LOCAL_CLOCK:
                setLocalClock((FSMClock)newValue);
                return;
            case NewTfsmPackage.TFSM__OWNED_TRANSITIONS:
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
            case NewTfsmPackage.TFSM__OWNED_STATES:
                getOwnedStates().clear();
                return;
            case NewTfsmPackage.TFSM__INITIAL_STATE:
                setInitialState((State)null);
                return;
            case NewTfsmPackage.TFSM__LOCAL_EVENTS:
                getLocalEvents().clear();
                return;
            case NewTfsmPackage.TFSM__LOCAL_CLOCK:
                setLocalClock((FSMClock)null);
                return;
            case NewTfsmPackage.TFSM__OWNED_TRANSITIONS:
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
            case NewTfsmPackage.TFSM__OWNED_STATES:
                return ownedStates != null && !ownedStates.isEmpty();
            case NewTfsmPackage.TFSM__INITIAL_STATE:
                return initialState != null;
            case NewTfsmPackage.TFSM__LOCAL_EVENTS:
                return localEvents != null && !localEvents.isEmpty();
            case NewTfsmPackage.TFSM__LOCAL_CLOCK:
                return localClock != null;
            case NewTfsmPackage.TFSM__OWNED_TRANSITIONS:
                return ownedTransitions != null && !ownedTransitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //TFSMImpl
