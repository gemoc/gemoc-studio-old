/**
 */
package fsmTrace.States.fsm.impl;

import fsmTrace.States.fsm.*;

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
			case FsmPackage.TRACED_EVALUATE_GUARD: return createTracedEvaluateGuard();
			case FsmPackage.TRACED_EVENT_GUARD: return createTracedEventGuard();
			case FsmPackage.TRACED_FSM_CLOCK: return createTracedFSMClock();
			case FsmPackage.TRACED_FSM_EVENT: return createTracedFSMEvent();
			case FsmPackage.TRACED_STATE: return createTracedState();
			case FsmPackage.TRACED_TEMPORAL_GUARD: return createTracedTemporalGuard();
			case FsmPackage.TRACED_TIME_FSM: return createTracedTimeFSM();
			case FsmPackage.TRACED_TIMED_SYSTEM: return createTracedTimedSystem();
			case FsmPackage.TRACED_TRANSITION: return createTracedTransition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedEvaluateGuard createTracedEvaluateGuard() {
		TracedEvaluateGuardImpl tracedEvaluateGuard = new TracedEvaluateGuardImpl();
		return tracedEvaluateGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedEventGuard createTracedEventGuard() {
		TracedEventGuardImpl tracedEventGuard = new TracedEventGuardImpl();
		return tracedEventGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedFSMClock createTracedFSMClock() {
		TracedFSMClockImpl tracedFSMClock = new TracedFSMClockImpl();
		return tracedFSMClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedFSMEvent createTracedFSMEvent() {
		TracedFSMEventImpl tracedFSMEvent = new TracedFSMEventImpl();
		return tracedFSMEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedState createTracedState() {
		TracedStateImpl tracedState = new TracedStateImpl();
		return tracedState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedTemporalGuard createTracedTemporalGuard() {
		TracedTemporalGuardImpl tracedTemporalGuard = new TracedTemporalGuardImpl();
		return tracedTemporalGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedTimeFSM createTracedTimeFSM() {
		TracedTimeFSMImpl tracedTimeFSM = new TracedTimeFSMImpl();
		return tracedTimeFSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedTimedSystem createTracedTimedSystem() {
		TracedTimedSystemImpl tracedTimedSystem = new TracedTimedSystemImpl();
		return tracedTimedSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedTransition createTracedTransition() {
		TracedTransitionImpl tracedTransition = new TracedTransitionImpl();
		return tracedTransition;
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
