/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsm_plaink3Trace.States.tfsm_plaink3.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tfsm_plaink3FactoryImpl extends EFactoryImpl implements Tfsm_plaink3Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Tfsm_plaink3Factory init() {
		try {
			Tfsm_plaink3Factory theTfsm_plaink3Factory = (Tfsm_plaink3Factory)EPackage.Registry.INSTANCE.getEFactory(Tfsm_plaink3Package.eNS_URI);
			if (theTfsm_plaink3Factory != null) {
				return theTfsm_plaink3Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Tfsm_plaink3FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3FactoryImpl() {
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
			case Tfsm_plaink3Package.TRACED_EVALUATE_GUARD: return createTracedEvaluateGuard();
			case Tfsm_plaink3Package.TRACED_EVENT_GUARD: return createTracedEventGuard();
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK: return createTracedFSMClock();
			case Tfsm_plaink3Package.TRACED_FSM_EVENT: return createTracedFSMEvent();
			case Tfsm_plaink3Package.TRACED_STATE: return createTracedState();
			case Tfsm_plaink3Package.TRACED_TFSM: return createTracedTFSM();
			case Tfsm_plaink3Package.TRACED_TEMPORAL_GUARD: return createTracedTemporalGuard();
			case Tfsm_plaink3Package.TRACED_TIMED_SYSTEM: return createTracedTimedSystem();
			case Tfsm_plaink3Package.TRACED_TRANSITION: return createTracedTransition();
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
	public TracedTFSM createTracedTFSM() {
		TracedTFSMImpl tracedTFSM = new TracedTFSMImpl();
		return tracedTFSM;
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
	public Tfsm_plaink3Package getTfsm_plaink3Package() {
		return (Tfsm_plaink3Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Tfsm_plaink3Package getPackage() {
		return Tfsm_plaink3Package.eINSTANCE;
	}

} //Tfsm_plaink3FactoryImpl
