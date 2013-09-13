/**
 */
package newTfsm.util;

import newTfsm.EvaluateGuard;
import newTfsm.EventGuard;
import newTfsm.FSMClock;
import newTfsm.FSMEvent;
import newTfsm.Guard;
import newTfsm.NamedElement;
import newTfsm.NewTfsmPackage;
import newTfsm.State;
import newTfsm.TFSM;
import newTfsm.TemporalGuard;
import newTfsm.Transition;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see newTfsm.NewTfsmPackage
 * @generated
 */
public class NewTfsmAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static NewTfsmPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NewTfsmAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = NewTfsmPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NewTfsmSwitch<Adapter> modelSwitch =
        new NewTfsmSwitch<Adapter>() {
            @Override
            public Adapter caseTFSM(TFSM object) {
                return createTFSMAdapter();
            }
            @Override
            public Adapter caseState(State object) {
                return createStateAdapter();
            }
            @Override
            public Adapter caseTransition(Transition object) {
                return createTransitionAdapter();
            }
            @Override
            public Adapter caseNamedElement(NamedElement object) {
                return createNamedElementAdapter();
            }
            @Override
            public Adapter caseGuard(Guard object) {
                return createGuardAdapter();
            }
            @Override
            public Adapter caseTemporalGuard(TemporalGuard object) {
                return createTemporalGuardAdapter();
            }
            @Override
            public Adapter caseEventGuard(EventGuard object) {
                return createEventGuardAdapter();
            }
            @Override
            public Adapter caseFSMEvent(FSMEvent object) {
                return createFSMEventAdapter();
            }
            @Override
            public Adapter caseFSMClock(FSMClock object) {
                return createFSMClockAdapter();
            }
            @Override
            public Adapter caseSystem(newTfsm.System object) {
                return createSystemAdapter();
            }
            @Override
            public Adapter caseEvaluateGuard(EvaluateGuard object) {
                return createEvaluateGuardAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link newTfsm.TFSM <em>TFSM</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.TFSM
     * @generated
     */
    public Adapter createTFSMAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.State <em>State</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.State
     * @generated
     */
    public Adapter createStateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.Transition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.Transition
     * @generated
     */
    public Adapter createTransitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.Guard <em>Guard</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.Guard
     * @generated
     */
    public Adapter createGuardAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.TemporalGuard <em>Temporal Guard</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.TemporalGuard
     * @generated
     */
    public Adapter createTemporalGuardAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.EventGuard <em>Event Guard</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.EventGuard
     * @generated
     */
    public Adapter createEventGuardAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.FSMEvent <em>FSM Event</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.FSMEvent
     * @generated
     */
    public Adapter createFSMEventAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.FSMClock <em>FSM Clock</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.FSMClock
     * @generated
     */
    public Adapter createFSMClockAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.System <em>System</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.System
     * @generated
     */
    public Adapter createSystemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link newTfsm.EvaluateGuard <em>Evaluate Guard</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see newTfsm.EvaluateGuard
     * @generated
     */
    public Adapter createEvaluateGuardAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //NewTfsmAdapterFactory
