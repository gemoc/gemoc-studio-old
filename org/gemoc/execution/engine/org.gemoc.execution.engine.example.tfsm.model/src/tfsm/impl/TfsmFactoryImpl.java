/**
 */
package tfsm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsm.EvaluateGuard;
import tfsm.EventGuard;
import tfsm.NamedElement;
import tfsm.State;
import tfsm.TemporalGuard;
import tfsm.Tfsm;
import tfsm.TfsmClock;
import tfsm.TfsmEvent;
import tfsm.TfsmFactory;
import tfsm.TfsmPackage;
import tfsm.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TfsmFactoryImpl extends EFactoryImpl implements TfsmFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static TfsmFactory init() {
        try {
            TfsmFactory theTfsmFactory = (TfsmFactory)EPackage.Registry.INSTANCE.getEFactory(TfsmPackage.eNS_URI);
            if (theTfsmFactory != null) {
                return theTfsmFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new TfsmFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TfsmFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case TfsmPackage.TFSM: return createTfsm();
            case TfsmPackage.STATE: return createState();
            case TfsmPackage.TRANSITION: return createTransition();
            case TfsmPackage.NAMED_ELEMENT: return createNamedElement();
            case TfsmPackage.TEMPORAL_GUARD: return createTemporalGuard();
            case TfsmPackage.EVENT_GUARD: return createEventGuard();
            case TfsmPackage.TFSM_EVENT: return createTfsmEvent();
            case TfsmPackage.TFSM_CLOCK: return createTfsmClock();
            case TfsmPackage.SYSTEM: return createSystem();
            case TfsmPackage.EVALUATE_GUARD: return createEvaluateGuard();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Tfsm createTfsm() {
        TfsmImpl tfsm = new TfsmImpl();
        return tfsm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public State createState() {
        StateImpl state = new StateImpl();
        return state;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Transition createTransition() {
        TransitionImpl transition = new TransitionImpl();
        return transition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamedElement createNamedElement() {
        NamedElementImpl namedElement = new NamedElementImpl();
        return namedElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TemporalGuard createTemporalGuard() {
        TemporalGuardImpl temporalGuard = new TemporalGuardImpl();
        return temporalGuard;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventGuard createEventGuard() {
        EventGuardImpl eventGuard = new EventGuardImpl();
        return eventGuard;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TfsmEvent createTfsmEvent() {
        TfsmEventImpl tfsmEvent = new TfsmEventImpl();
        return tfsmEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TfsmClock createTfsmClock() {
        TfsmClockImpl tfsmClock = new TfsmClockImpl();
        return tfsmClock;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public tfsm.System createSystem() {
        SystemImpl system = new SystemImpl();
        return system;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EvaluateGuard createEvaluateGuard() {
        EvaluateGuardImpl evaluateGuard = new EvaluateGuardImpl();
        return evaluateGuard;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TfsmPackage getTfsmPackage() {
        return (TfsmPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static TfsmPackage getPackage() {
        return TfsmPackage.eINSTANCE;
    }

} //TfsmFactoryImpl
