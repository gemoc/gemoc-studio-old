/**
 */
package newTfsm.impl;

import java.util.Collection;

import newTfsm.FSMEvent;
import newTfsm.NewTfsmPackage;
import newTfsm.Transition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link newTfsm.impl.FSMEventImpl#getSollicitingTransitions <em>Solliciting Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FSMEventImpl extends NamedElementImpl implements FSMEvent {
    /**
     * The cached value of the '{@link #getSollicitingTransitions() <em>Solliciting Transitions</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSollicitingTransitions()
     * @generated
     * @ordered
     */
    protected EList<Transition> sollicitingTransitions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FSMEventImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return NewTfsmPackage.Literals.FSM_EVENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Transition> getSollicitingTransitions() {
        if (sollicitingTransitions == null) {
            sollicitingTransitions = new EObjectResolvingEList<Transition>(Transition.class, this, NewTfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS);
        }
        return sollicitingTransitions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case NewTfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
                return getSollicitingTransitions();
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
            case NewTfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
                getSollicitingTransitions().clear();
                getSollicitingTransitions().addAll((Collection<? extends Transition>)newValue);
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
            case NewTfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
                getSollicitingTransitions().clear();
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
            case NewTfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
                return sollicitingTransitions != null && !sollicitingTransitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //FSMEventImpl
