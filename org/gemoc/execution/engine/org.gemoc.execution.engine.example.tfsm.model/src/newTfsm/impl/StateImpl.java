/**
 */
package newTfsm.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import newTfsm.NewTfsmPackage;
import newTfsm.State;
import newTfsm.TFSM;
import newTfsm.Transition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link newTfsm.impl.StateImpl#getOwningFSM <em>Owning FSM</em>}</li>
 *   <li>{@link newTfsm.impl.StateImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link newTfsm.impl.StateImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends NamedElementImpl implements State {
    /**
     * The cached value of the '{@link #getOwningFSM() <em>Owning FSM</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOwningFSM()
     * @generated
     * @ordered
     */
    protected TFSM owningFSM;

    /**
     * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutgoingTransitions()
     * @generated
     * @ordered
     */
    protected EList<Transition> outgoingTransitions;

    /**
     * The cached value of the '{@link #getIncomingTransitions() <em>Incoming Transitions</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncomingTransitions()
     * @generated
     * @ordered
     */
    protected EList<Transition> incomingTransitions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return NewTfsmPackage.Literals.STATE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TFSM getOwningFSM() {
        if (owningFSM != null && owningFSM.eIsProxy()) {
            InternalEObject oldOwningFSM = (InternalEObject)owningFSM;
            owningFSM = (TFSM)eResolveProxy(oldOwningFSM);
            if (owningFSM != oldOwningFSM) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, NewTfsmPackage.STATE__OWNING_FSM, oldOwningFSM, owningFSM));
            }
        }
        return owningFSM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TFSM basicGetOwningFSM() {
        return owningFSM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOwningFSM(TFSM newOwningFSM) {
        TFSM oldOwningFSM = owningFSM;
        owningFSM = newOwningFSM;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, NewTfsmPackage.STATE__OWNING_FSM, oldOwningFSM, owningFSM));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Transition> getOutgoingTransitions() {
        if (outgoingTransitions == null) {
            outgoingTransitions = new EObjectResolvingEList<Transition>(Transition.class, this, NewTfsmPackage.STATE__OUTGOING_TRANSITIONS);
        }
        return outgoingTransitions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Transition> getIncomingTransitions() {
        if (incomingTransitions == null) {
            incomingTransitions = new EObjectResolvingEList<Transition>(Transition.class, this, NewTfsmPackage.STATE__INCOMING_TRANSITIONS);
        }
        return incomingTransitions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String onEnter() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String onLeave() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case NewTfsmPackage.STATE__OWNING_FSM:
                if (resolve) return getOwningFSM();
                return basicGetOwningFSM();
            case NewTfsmPackage.STATE__OUTGOING_TRANSITIONS:
                return getOutgoingTransitions();
            case NewTfsmPackage.STATE__INCOMING_TRANSITIONS:
                return getIncomingTransitions();
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
            case NewTfsmPackage.STATE__OWNING_FSM:
                setOwningFSM((TFSM)newValue);
                return;
            case NewTfsmPackage.STATE__OUTGOING_TRANSITIONS:
                getOutgoingTransitions().clear();
                getOutgoingTransitions().addAll((Collection<? extends Transition>)newValue);
                return;
            case NewTfsmPackage.STATE__INCOMING_TRANSITIONS:
                getIncomingTransitions().clear();
                getIncomingTransitions().addAll((Collection<? extends Transition>)newValue);
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
            case NewTfsmPackage.STATE__OWNING_FSM:
                setOwningFSM((TFSM)null);
                return;
            case NewTfsmPackage.STATE__OUTGOING_TRANSITIONS:
                getOutgoingTransitions().clear();
                return;
            case NewTfsmPackage.STATE__INCOMING_TRANSITIONS:
                getIncomingTransitions().clear();
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
            case NewTfsmPackage.STATE__OWNING_FSM:
                return owningFSM != null;
            case NewTfsmPackage.STATE__OUTGOING_TRANSITIONS:
                return outgoingTransitions != null && !outgoingTransitions.isEmpty();
            case NewTfsmPackage.STATE__INCOMING_TRANSITIONS:
                return incomingTransitions != null && !incomingTransitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case NewTfsmPackage.STATE___ON_ENTER:
                return onEnter();
            case NewTfsmPackage.STATE___ON_LEAVE:
                return onLeave();
        }
        return super.eInvoke(operationID, arguments);
    }

} //StateImpl
