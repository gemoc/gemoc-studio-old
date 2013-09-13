/**
 */
package newTfsm.impl;

import newTfsm.EvaluateGuard;
import newTfsm.EventGuard;
import newTfsm.FSMClock;
import newTfsm.FSMEvent;
import newTfsm.NamedElement;
import newTfsm.NewTfsmFactory;
import newTfsm.NewTfsmPackage;
import newTfsm.State;
import newTfsm.TFSM;
import newTfsm.TemporalGuard;
import newTfsm.Transition;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NewTfsmFactoryImpl extends EFactoryImpl implements NewTfsmFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static NewTfsmFactory init() {
        try {
            NewTfsmFactory theNewTfsmFactory = (NewTfsmFactory)EPackage.Registry.INSTANCE.getEFactory(NewTfsmPackage.eNS_URI);
            if (theNewTfsmFactory != null) {
                return theNewTfsmFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new NewTfsmFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NewTfsmFactoryImpl() {
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
            case NewTfsmPackage.TFSM: return createTFSM();
            case NewTfsmPackage.STATE: return createState();
            case NewTfsmPackage.TRANSITION: return createTransition();
            case NewTfsmPackage.NAMED_ELEMENT: return createNamedElement();
            case NewTfsmPackage.TEMPORAL_GUARD: return createTemporalGuard();
            case NewTfsmPackage.EVENT_GUARD: return createEventGuard();
            case NewTfsmPackage.FSM_EVENT: return createFSMEvent();
            case NewTfsmPackage.FSM_CLOCK: return createFSMClock();
            case NewTfsmPackage.SYSTEM: return createSystem();
            case NewTfsmPackage.EVALUATE_GUARD: return createEvaluateGuard();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TFSM createTFSM() {
        TFSMImpl tfsm = new TFSMImpl();
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
    public FSMEvent createFSMEvent() {
        FSMEventImpl fsmEvent = new FSMEventImpl();
        return fsmEvent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FSMClock createFSMClock() {
        FSMClockImpl fsmClock = new FSMClockImpl();
        return fsmClock;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public newTfsm.System createSystem() {
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
    public NewTfsmPackage getNewTfsmPackage() {
        return (NewTfsmPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static NewTfsmPackage getPackage() {
        return NewTfsmPackage.eINSTANCE;
    }

} //NewTfsmFactoryImpl
