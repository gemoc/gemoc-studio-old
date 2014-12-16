/**
 */
package tfsmextended.tfsmextended.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tfsmextended.tfsmextended.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tfsmextended.tfsmextended.TfsmextendedPackage
 * @generated
 */
public class TfsmextendedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TfsmextendedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TfsmextendedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TfsmextendedPackage.eINSTANCE;
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
	protected TfsmextendedSwitch<Adapter> modelSwitch =
		new TfsmextendedSwitch<Adapter>() {
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
			public Adapter caseTimedSystem(TimedSystem object) {
				return createTimedSystemAdapter();
			}
			@Override
			public Adapter caseEvaluateGuard(EvaluateGuard object) {
				return createEvaluateGuardAdapter();
			}
			@Override
			public Adapter caseTfsm_NamedElement(org.gemoc.sample.tfsm.NamedElement object) {
				return createTfsm_NamedElementAdapter();
			}
			@Override
			public Adapter caseTfsm_TFSM(org.gemoc.sample.tfsm.TFSM object) {
				return createTfsm_TFSMAdapter();
			}
			@Override
			public Adapter caseTfsm_State(org.gemoc.sample.tfsm.State object) {
				return createTfsm_StateAdapter();
			}
			@Override
			public Adapter caseTfsm_Transition(org.gemoc.sample.tfsm.Transition object) {
				return createTfsm_TransitionAdapter();
			}
			@Override
			public Adapter caseTfsm_Guard(org.gemoc.sample.tfsm.Guard object) {
				return createTfsm_GuardAdapter();
			}
			@Override
			public Adapter caseTfsm_TemporalGuard(org.gemoc.sample.tfsm.TemporalGuard object) {
				return createTfsm_TemporalGuardAdapter();
			}
			@Override
			public Adapter caseTfsm_EventGuard(org.gemoc.sample.tfsm.EventGuard object) {
				return createTfsm_EventGuardAdapter();
			}
			@Override
			public Adapter caseTfsm_FSMEvent(org.gemoc.sample.tfsm.FSMEvent object) {
				return createTfsm_FSMEventAdapter();
			}
			@Override
			public Adapter caseTfsm_FSMClock(org.gemoc.sample.tfsm.FSMClock object) {
				return createTfsm_FSMClockAdapter();
			}
			@Override
			public Adapter caseTfsm_TimedSystem(org.gemoc.sample.tfsm.TimedSystem object) {
				return createTfsm_TimedSystemAdapter();
			}
			@Override
			public Adapter caseTfsm_EvaluateGuard(org.gemoc.sample.tfsm.EvaluateGuard object) {
				return createTfsm_EvaluateGuardAdapter();
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
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.TFSM <em>TFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.TFSM
	 * @generated
	 */
	public Adapter createTFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.Guard
	 * @generated
	 */
	public Adapter createGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.TemporalGuard <em>Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.TemporalGuard
	 * @generated
	 */
	public Adapter createTemporalGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.EventGuard <em>Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.EventGuard
	 * @generated
	 */
	public Adapter createEventGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.FSMEvent <em>FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.FSMEvent
	 * @generated
	 */
	public Adapter createFSMEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.FSMClock <em>FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.FSMClock
	 * @generated
	 */
	public Adapter createFSMClockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.TimedSystem <em>Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.TimedSystem
	 * @generated
	 */
	public Adapter createTimedSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsmextended.tfsmextended.EvaluateGuard <em>Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsmextended.tfsmextended.EvaluateGuard
	 * @generated
	 */
	public Adapter createEvaluateGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.NamedElement
	 * @generated
	 */
	public Adapter createTfsm_NamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.TFSM <em>TFSM</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.TFSM
	 * @generated
	 */
	public Adapter createTfsm_TFSMAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.State
	 * @generated
	 */
	public Adapter createTfsm_StateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.Transition
	 * @generated
	 */
	public Adapter createTfsm_TransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.Guard
	 * @generated
	 */
	public Adapter createTfsm_GuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.TemporalGuard <em>Temporal Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.TemporalGuard
	 * @generated
	 */
	public Adapter createTfsm_TemporalGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.EventGuard <em>Event Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.EventGuard
	 * @generated
	 */
	public Adapter createTfsm_EventGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.FSMEvent <em>FSM Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.FSMEvent
	 * @generated
	 */
	public Adapter createTfsm_FSMEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.FSMClock <em>FSM Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.FSMClock
	 * @generated
	 */
	public Adapter createTfsm_FSMClockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.TimedSystem <em>Timed System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.TimedSystem
	 * @generated
	 */
	public Adapter createTfsm_TimedSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sample.tfsm.EvaluateGuard <em>Evaluate Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sample.tfsm.EvaluateGuard
	 * @generated
	 */
	public Adapter createTfsm_EvaluateGuardAdapter() {
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

} //TfsmextendedAdapterFactory
