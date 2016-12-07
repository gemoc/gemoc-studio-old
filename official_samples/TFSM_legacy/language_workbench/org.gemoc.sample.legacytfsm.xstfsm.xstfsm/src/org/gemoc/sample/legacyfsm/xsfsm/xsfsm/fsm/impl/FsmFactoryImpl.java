/**
 */
package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FsmFactoryImpl extends EFactoryImpl implements FsmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FsmFactory init() {
		try {
			FsmFactory theFsmFactory = (FsmFactory)EPackage.Registry.INSTANCE.getEFactory(FsmPackage.eNS_URI);
			if (theFsmFactory != null) {
				return theFsmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FsmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmFactoryImpl() {
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
			case FsmPackage.TIME_FSM: return createTimeFSM();
			case FsmPackage.STATE: return createState();
			case FsmPackage.TRANSITION: return createTransition();
			case FsmPackage.TEMPORAL_GUARD: return createTemporalGuard();
			case FsmPackage.EVENT_GUARD: return createEventGuard();
			case FsmPackage.FSM_EVENT: return createFSMEvent();
			case FsmPackage.FSM_CLOCK: return createFSMClock();
			case FsmPackage.TIMED_SYSTEM: return createTimedSystem();
			case FsmPackage.EVALUATE_GUARD: return createEvaluateGuard();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeFSM createTimeFSM() {
		TimeFSMImpl timeFSM = new TimeFSMImpl();
		return timeFSM;
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
	public FsmPackage getFsmPackage() {
		return (FsmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FsmPackage getPackage() {
		return FsmPackage.eINSTANCE;
	}

} //FsmFactoryImpl
