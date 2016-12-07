/**
 */
package fsmTrace.States.fsm.util;

import fsmTrace.States.fsm.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fsmTrace.States.fsm.FsmPackage
 * @generated
 */
public class FsmAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FsmPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FsmAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FsmPackage.eINSTANCE;
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
	protected FsmSwitch<Adapter> modelSwitch =
		new FsmSwitch<Adapter>() {
			@Override
			public Adapter caseTracedEvaluateGuard(TracedEvaluateGuard object) {
				return createTracedEvaluateGuardAdapter();
			}
			@Override
			public Adapter caseTracedEventGuard(TracedEventGuard object) {
				return createTracedEventGuardAdapter();
			}
			@Override
			public Adapter caseTracedFSMClock(TracedFSMClock object) {
				return createTracedFSMClockAdapter();
			}
			@Override
			public Adapter caseTracedFSMEvent(TracedFSMEvent object) {
				return createTracedFSMEventAdapter();
			}
			@Override
			public Adapter caseTracedGuard(TracedGuard object) {
				return createTracedGuardAdapter();
			}
			@Override
			public Adapter caseTracedNamedElement(TracedNamedElement object) {
				return createTracedNamedElementAdapter();
			}
			@Override
			public Adapter caseTracedState(TracedState object) {
				return createTracedStateAdapter();
			}
			@Override
			public Adapter caseTracedTemporalGuard(TracedTemporalGuard object) {
				return createTracedTemporalGuardAdapter();
			}
			@Override
			public Adapter caseTracedTimeFSM(TracedTimeFSM object) {
				return createTracedTimeFSMAdapter();
			}
			@Override
			public Adapter caseTracedTimedSystem(TracedTimedSystem object) {
				return createTracedTimedSystemAdapter();
			}
			@Override
			public Adapter caseTracedTransition(TracedTransition object) {
				return createTracedTransitionAdapter();
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
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedEvaluateGuard <em>Traced Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedEvaluateGuard
	 * @generated
	 */
	public Adapter createTracedEvaluateGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedEventGuard <em>Traced Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedEventGuard
	 * @generated
	 */
	public Adapter createTracedEventGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedFSMClock <em>Traced FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedFSMClock
	 * @generated
	 */
	public Adapter createTracedFSMClockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedFSMEvent <em>Traced FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedFSMEvent
	 * @generated
	 */
	public Adapter createTracedFSMEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedGuard <em>Traced Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedGuard
	 * @generated
	 */
	public Adapter createTracedGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedNamedElement <em>Traced Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedNamedElement
	 * @generated
	 */
	public Adapter createTracedNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedState <em>Traced State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedState
	 * @generated
	 */
	public Adapter createTracedStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedTemporalGuard <em>Traced Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedTemporalGuard
	 * @generated
	 */
	public Adapter createTracedTemporalGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedTimeFSM <em>Traced Time FSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedTimeFSM
	 * @generated
	 */
	public Adapter createTracedTimeFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedTimedSystem <em>Traced Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedTimedSystem
	 * @generated
	 */
	public Adapter createTracedTimedSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fsmTrace.States.fsm.TracedTransition <em>Traced Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fsmTrace.States.fsm.TracedTransition
	 * @generated
	 */
	public Adapter createTracedTransitionAdapter() {
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

} //FsmAdapterFactory
