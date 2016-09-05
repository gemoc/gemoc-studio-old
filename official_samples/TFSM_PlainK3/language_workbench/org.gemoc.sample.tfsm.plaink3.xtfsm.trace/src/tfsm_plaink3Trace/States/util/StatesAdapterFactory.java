/**
 */
package tfsm_plaink3Trace.States.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tfsm_plaink3Trace.States.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tfsm_plaink3Trace.States.StatesPackage
 * @generated
 */
public class StatesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StatesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StatesPackage.eINSTANCE;
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
	protected StatesSwitch<Adapter> modelSwitch =
		new StatesSwitch<Adapter>() {
			@Override
			public Adapter caseFSMClock_numberOfTicks_Value(FSMClock_numberOfTicks_Value object) {
				return createFSMClock_numberOfTicks_ValueAdapter();
			}
			@Override
			public Adapter caseFSMEvent_isTriggered_Value(FSMEvent_isTriggered_Value object) {
				return createFSMEvent_isTriggered_ValueAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseTFSM_currentState_Value(TFSM_currentState_Value object) {
				return createTFSM_currentState_ValueAdapter();
			}
			@Override
			public Adapter caseTFSM_lastStateChangeStepNumber_Value(TFSM_lastStateChangeStepNumber_Value object) {
				return createTFSM_lastStateChangeStepNumber_ValueAdapter();
			}
			@Override
			public Adapter caseTFSM_stepNumber_Value(TFSM_stepNumber_Value object) {
				return createTFSM_stepNumber_ValueAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
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
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value <em>FSM Clock number Of Ticks Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value
	 * @generated
	 */
	public Adapter createFSMClock_numberOfTicks_ValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value <em>FSM Event is Triggered Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value
	 * @generated
	 */
	public Adapter createFSMEvent_isTriggered_ValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.TFSM_currentState_Value <em>TFSM current State Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.TFSM_currentState_Value
	 * @generated
	 */
	public Adapter createTFSM_currentState_ValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value <em>TFSM last State Change Step Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.TFSM_lastStateChangeStepNumber_Value
	 * @generated
	 */
	public Adapter createTFSM_lastStateChangeStepNumber_ValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.TFSM_stepNumber_Value <em>TFSM step Number Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.TFSM_stepNumber_Value
	 * @generated
	 */
	public Adapter createTFSM_stepNumber_ValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tfsm_plaink3Trace.States.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tfsm_plaink3Trace.States.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
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

} //StatesAdapterFactory
