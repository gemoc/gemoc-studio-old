/**
 */
package tfsmTrace.States.tfsm.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsmTrace.States.tfsm.*;

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
			case TfsmPackage.TRACED_EVALUATE_GUARD: return createTracedEvaluateGuard();
			case TfsmPackage.TRACED_EVENT_GUARD: return createTracedEventGuard();
			case TfsmPackage.TRACED_FSM_CLOCK: return createTracedFSMClock();
			case TfsmPackage.TRACED_FSM_EVENT: return createTracedFSMEvent();
			case TfsmPackage.TRACED_STATE: return createTracedState();
			case TfsmPackage.TRACED_TFSM: return createTracedTFSM();
			case TfsmPackage.TRACED_TEMPORAL_GUARD: return createTracedTemporalGuard();
			case TfsmPackage.TRACED_TIMED_SYSTEM: return createTracedTimedSystem();
			case TfsmPackage.TRACED_TRANSITION: return createTracedTransition();
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
