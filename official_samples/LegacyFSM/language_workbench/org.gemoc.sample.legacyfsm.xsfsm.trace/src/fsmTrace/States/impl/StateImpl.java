/**
 */
package fsmTrace.States.impl;

import fsmTrace.States.State;
import fsmTrace.States.StateMachine_actionsToProcess_Value;
import fsmTrace.States.StateMachine_currentState_Value;
import fsmTrace.States.StateMachine_producedString_Value;
import fsmTrace.States.StatesPackage;

import fsmTrace.Steps.SpecificStep;
import fsmTrace.Steps.StepsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getEndedSteps <em>Ended Steps</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getStartedSteps <em>Started Steps</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getStateMachine_actionsToProcess_Values <em>State Machine actions To Process Values</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getStateMachine_currentState_Values <em>State Machine current State Values</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getStateMachine_producedString_Values <em>State Machine produced String Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateImpl extends MinimalEObjectImpl.Container implements State {
	/**
	 * The cached value of the '{@link #getEndedSteps() <em>Ended Steps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndedSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecificStep> endedSteps;

	/**
	 * The cached value of the '{@link #getStartedSteps() <em>Started Steps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartedSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecificStep> startedSteps;

	/**
	 * The cached value of the '{@link #getStateMachine_actionsToProcess_Values() <em>State Machine actions To Process Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine_actionsToProcess_Values()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine_actionsToProcess_Value> stateMachine_actionsToProcess_Values;

	/**
	 * The cached value of the '{@link #getStateMachine_currentState_Values() <em>State Machine current State Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine_currentState_Values()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine_currentState_Value> stateMachine_currentState_Values;

	/**
	 * The cached value of the '{@link #getStateMachine_producedString_Values() <em>State Machine produced String Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine_producedString_Values()
	 * @generated
	 * @ordered
	 */
	protected EList<StateMachine_producedString_Value> stateMachine_producedString_Values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatesPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecificStep> getEndedSteps() {
		if (endedSteps == null) {
			endedSteps = new EObjectWithInverseResolvingEList<SpecificStep>(SpecificStep.class, this, StatesPackage.STATE__ENDED_STEPS, StepsPackage.SPECIFIC_STEP__ENDING_STATE);
		}
		return endedSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecificStep> getStartedSteps() {
		if (startedSteps == null) {
			startedSteps = new EObjectWithInverseResolvingEList<SpecificStep>(SpecificStep.class, this, StatesPackage.STATE__STARTED_STEPS, StepsPackage.SPECIFIC_STEP__STARTING_STATE);
		}
		return startedSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine_actionsToProcess_Value> getStateMachine_actionsToProcess_Values() {
		if (stateMachine_actionsToProcess_Values == null) {
			stateMachine_actionsToProcess_Values = new EObjectWithInverseResolvingEList.ManyInverse<StateMachine_actionsToProcess_Value>(StateMachine_actionsToProcess_Value.class, this, StatesPackage.STATE__STATE_MACHINE_ACTIONS_TO_PROCESS_VALUES, StatesPackage.STATE_MACHINE_ACTIONS_TO_PROCESS_VALUE__STATES);
		}
		return stateMachine_actionsToProcess_Values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine_currentState_Value> getStateMachine_currentState_Values() {
		if (stateMachine_currentState_Values == null) {
			stateMachine_currentState_Values = new EObjectWithInverseResolvingEList.ManyInverse<StateMachine_currentState_Value>(StateMachine_currentState_Value.class, this, StatesPackage.STATE__STATE_MACHINE_CURRENT_STATE_VALUES, StatesPackage.STATE_MACHINE_CURRENT_STATE_VALUE__STATES);
		}
		return stateMachine_currentState_Values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateMachine_producedString_Value> getStateMachine_producedString_Values() {
		if (stateMachine_producedString_Values == null) {
			stateMachine_producedString_Values = new EObjectWithInverseResolvingEList.ManyInverse<StateMachine_producedString_Value>(StateMachine_producedString_Value.class, this, StatesPackage.STATE__STATE_MACHINE_PRODUCED_STRING_VALUES, StatesPackage.STATE_MACHINE_PRODUCED_STRING_VALUE__STATES);
		}
		return stateMachine_producedString_Values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatesPackage.STATE__ENDED_STEPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndedSteps()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__STARTED_STEPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStartedSteps()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__STATE_MACHINE_ACTIONS_TO_PROCESS_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStateMachine_actionsToProcess_Values()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__STATE_MACHINE_CURRENT_STATE_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStateMachine_currentState_Values()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__STATE_MACHINE_PRODUCED_STRING_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStateMachine_producedString_Values()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatesPackage.STATE__ENDED_STEPS:
				return ((InternalEList<?>)getEndedSteps()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__STARTED_STEPS:
				return ((InternalEList<?>)getStartedSteps()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__STATE_MACHINE_ACTIONS_TO_PROCESS_VALUES:
				return ((InternalEList<?>)getStateMachine_actionsToProcess_Values()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__STATE_MACHINE_CURRENT_STATE_VALUES:
				return ((InternalEList<?>)getStateMachine_currentState_Values()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__STATE_MACHINE_PRODUCED_STRING_VALUES:
				return ((InternalEList<?>)getStateMachine_producedString_Values()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatesPackage.STATE__ENDED_STEPS:
				return getEndedSteps();
			case StatesPackage.STATE__STARTED_STEPS:
				return getStartedSteps();
			case StatesPackage.STATE__STATE_MACHINE_ACTIONS_TO_PROCESS_VALUES:
				return getStateMachine_actionsToProcess_Values();
			case StatesPackage.STATE__STATE_MACHINE_CURRENT_STATE_VALUES:
				return getStateMachine_currentState_Values();
			case StatesPackage.STATE__STATE_MACHINE_PRODUCED_STRING_VALUES:
				return getStateMachine_producedString_Values();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StatesPackage.STATE__ENDED_STEPS:
				getEndedSteps().clear();
				getEndedSteps().addAll((Collection<? extends SpecificStep>)newValue);
				return;
			case StatesPackage.STATE__STARTED_STEPS:
				getStartedSteps().clear();
				getStartedSteps().addAll((Collection<? extends SpecificStep>)newValue);
				return;
			case StatesPackage.STATE__STATE_MACHINE_ACTIONS_TO_PROCESS_VALUES:
				getStateMachine_actionsToProcess_Values().clear();
				getStateMachine_actionsToProcess_Values().addAll((Collection<? extends StateMachine_actionsToProcess_Value>)newValue);
				return;
			case StatesPackage.STATE__STATE_MACHINE_CURRENT_STATE_VALUES:
				getStateMachine_currentState_Values().clear();
				getStateMachine_currentState_Values().addAll((Collection<? extends StateMachine_currentState_Value>)newValue);
				return;
			case StatesPackage.STATE__STATE_MACHINE_PRODUCED_STRING_VALUES:
				getStateMachine_producedString_Values().clear();
				getStateMachine_producedString_Values().addAll((Collection<? extends StateMachine_producedString_Value>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StatesPackage.STATE__ENDED_STEPS:
				getEndedSteps().clear();
				return;
			case StatesPackage.STATE__STARTED_STEPS:
				getStartedSteps().clear();
				return;
			case StatesPackage.STATE__STATE_MACHINE_ACTIONS_TO_PROCESS_VALUES:
				getStateMachine_actionsToProcess_Values().clear();
				return;
			case StatesPackage.STATE__STATE_MACHINE_CURRENT_STATE_VALUES:
				getStateMachine_currentState_Values().clear();
				return;
			case StatesPackage.STATE__STATE_MACHINE_PRODUCED_STRING_VALUES:
				getStateMachine_producedString_Values().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StatesPackage.STATE__ENDED_STEPS:
				return endedSteps != null && !endedSteps.isEmpty();
			case StatesPackage.STATE__STARTED_STEPS:
				return startedSteps != null && !startedSteps.isEmpty();
			case StatesPackage.STATE__STATE_MACHINE_ACTIONS_TO_PROCESS_VALUES:
				return stateMachine_actionsToProcess_Values != null && !stateMachine_actionsToProcess_Values.isEmpty();
			case StatesPackage.STATE__STATE_MACHINE_CURRENT_STATE_VALUES:
				return stateMachine_currentState_Values != null && !stateMachine_currentState_Values.isEmpty();
			case StatesPackage.STATE__STATE_MACHINE_PRODUCED_STRING_VALUES:
				return stateMachine_producedString_Values != null && !stateMachine_producedString_Values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateImpl
