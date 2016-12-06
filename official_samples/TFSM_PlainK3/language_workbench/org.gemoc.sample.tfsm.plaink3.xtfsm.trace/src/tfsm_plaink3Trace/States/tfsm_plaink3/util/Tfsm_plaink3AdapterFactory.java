/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tfsm_plaink3Trace.States.tfsm_plaink3.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package
 * @generated
 */
public class Tfsm_plaink3AdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Tfsm_plaink3Package modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Tfsm_plaink3Package.eINSTANCE;
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
	protected Tfsm_plaink3Switch<Adapter> modelSwitch =
		new Tfsm_plaink3Switch<Adapter>() {
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
			public Adapter caseTracedTFSM(TracedTFSM object) {
				return createTracedTFSMAdapter();
			}
			@Override
			public Adapter caseTracedTemporalGuard(TracedTemporalGuard object) {
				return createTracedTemporalGuardAdapter();
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
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard <em>Traced Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard
	 * @generated
	 */
	public Adapter createTracedEvaluateGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard <em>Traced Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard
	 * @generated
	 */
	public Adapter createTracedEventGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock <em>Traced FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock
	 * @generated
	 */
	public Adapter createTracedFSMClockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent <em>Traced FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent
	 * @generated
	 */
	public Adapter createTracedFSMEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedGuard <em>Traced Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedGuard
	 * @generated
	 */
	public Adapter createTracedGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement <em>Traced Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement
	 * @generated
	 */
	public Adapter createTracedNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedState <em>Traced State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedState
	 * @generated
	 */
	public Adapter createTracedStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM <em>Traced TFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM
	 * @generated
	 */
	public Adapter createTracedTFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard <em>Traced Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard
	 * @generated
	 */
	public Adapter createTracedTemporalGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem <em>Traced Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem
	 * @generated
	 */
	public Adapter createTracedTimedSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition <em>Traced Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition
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

} //Tfsm_plaink3AdapterFactory
