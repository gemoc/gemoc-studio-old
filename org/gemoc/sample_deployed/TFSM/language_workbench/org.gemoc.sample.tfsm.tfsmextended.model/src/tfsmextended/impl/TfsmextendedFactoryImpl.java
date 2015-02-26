/**
 */
package tfsmextended.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsmextended.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TfsmextendedFactoryImpl extends EFactoryImpl implements TfsmextendedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TfsmextendedFactory init() {
		try {
			TfsmextendedFactory theTfsmextendedFactory = (TfsmextendedFactory)EPackage.Registry.INSTANCE.getEFactory(TfsmextendedPackage.eNS_URI);
			if (theTfsmextendedFactory != null) {
				return theTfsmextendedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TfsmextendedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TfsmextendedFactoryImpl() {
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
			case TfsmextendedPackage.TFSM: return createTFSM();
			case TfsmextendedPackage.STATE: return createState();
			case TfsmextendedPackage.TRANSITION: return createTransition();
			case TfsmextendedPackage.NAMED_ELEMENT: return createNamedElement();
			case TfsmextendedPackage.TEMPORAL_GUARD: return createTemporalGuard();
			case TfsmextendedPackage.EVENT_GUARD: return createEventGuard();
			case TfsmextendedPackage.FSM_EVENT: return createFSMEvent();
			case TfsmextendedPackage.FSM_CLOCK: return createFSMClock();
			case TfsmextendedPackage.TIMED_SYSTEM: return createTimedSystem();
			case TfsmextendedPackage.EVALUATE_GUARD: return createEvaluateGuard();
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
	public TimedSystem createTimedSystem() {
		TimedSystemImpl timedSystem = new TimedSystemImpl();
		return timedSystem;
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
	public TfsmextendedPackage getTfsmextendedPackage() {
		return (TfsmextendedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TfsmextendedPackage getPackage() {
		return TfsmextendedPackage.eINSTANCE;
	}

} //TfsmextendedFactoryImpl
