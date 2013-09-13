/**
 */
package tfsm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tfsm.Tfsm;
import tfsm.TfsmClock;
import tfsm.TfsmEvent;
import tfsm.TfsmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tfsm.impl.SystemImpl#getTfsms <em>Tfsms</em>}</li>
 *   <li>{@link tfsm.impl.SystemImpl#getGlobalClocks <em>Global Clocks</em>}</li>
 *   <li>{@link tfsm.impl.SystemImpl#getGlobalEvents <em>Global Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends NamedElementImpl implements tfsm.System {
    /**
     * The cached value of the '{@link #getTfsms() <em>Tfsms</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTfsms()
     * @generated
     * @ordered
     */
    protected EList<Tfsm> tfsms;

    /**
     * The cached value of the '{@link #getGlobalClocks() <em>Global Clocks</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGlobalClocks()
     * @generated
     * @ordered
     */
    protected EList<TfsmClock> globalClocks;

    /**
     * The cached value of the '{@link #getGlobalEvents() <em>Global Events</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGlobalEvents()
     * @generated
     * @ordered
     */
    protected EList<TfsmEvent> globalEvents;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TfsmPackage.Literals.SYSTEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Tfsm> getTfsms() {
        if (tfsms == null) {
            tfsms = new EObjectContainmentEList<Tfsm>(Tfsm.class, this, TfsmPackage.SYSTEM__TFSMS);
        }
        return tfsms;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TfsmClock> getGlobalClocks() {
        if (globalClocks == null) {
            globalClocks = new EObjectContainmentEList<TfsmClock>(TfsmClock.class, this, TfsmPackage.SYSTEM__GLOBAL_CLOCKS);
        }
        return globalClocks;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TfsmEvent> getGlobalEvents() {
        if (globalEvents == null) {
            globalEvents = new EObjectContainmentEList<TfsmEvent>(TfsmEvent.class, this, TfsmPackage.SYSTEM__GLOBAL_EVENTS);
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
            case TfsmPackage.SYSTEM__TFSMS:
                return ((InternalEList<?>)getTfsms()).basicRemove(otherEnd, msgs);
            case TfsmPackage.SYSTEM__GLOBAL_CLOCKS:
                return ((InternalEList<?>)getGlobalClocks()).basicRemove(otherEnd, msgs);
            case TfsmPackage.SYSTEM__GLOBAL_EVENTS:
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
            case TfsmPackage.SYSTEM__TFSMS:
                return getTfsms();
            case TfsmPackage.SYSTEM__GLOBAL_CLOCKS:
                return getGlobalClocks();
            case TfsmPackage.SYSTEM__GLOBAL_EVENTS:
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
            case TfsmPackage.SYSTEM__TFSMS:
                getTfsms().clear();
                getTfsms().addAll((Collection<? extends Tfsm>)newValue);
                return;
            case TfsmPackage.SYSTEM__GLOBAL_CLOCKS:
                getGlobalClocks().clear();
                getGlobalClocks().addAll((Collection<? extends TfsmClock>)newValue);
                return;
            case TfsmPackage.SYSTEM__GLOBAL_EVENTS:
                getGlobalEvents().clear();
                getGlobalEvents().addAll((Collection<? extends TfsmEvent>)newValue);
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
            case TfsmPackage.SYSTEM__TFSMS:
                getTfsms().clear();
                return;
            case TfsmPackage.SYSTEM__GLOBAL_CLOCKS:
                getGlobalClocks().clear();
                return;
            case TfsmPackage.SYSTEM__GLOBAL_EVENTS:
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
            case TfsmPackage.SYSTEM__TFSMS:
                return tfsms != null && !tfsms.isEmpty();
            case TfsmPackage.SYSTEM__GLOBAL_CLOCKS:
                return globalClocks != null && !globalClocks.isEmpty();
            case TfsmPackage.SYSTEM__GLOBAL_EVENTS:
                return globalEvents != null && !globalEvents.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SystemImpl
