/**
 */
package fsmTrace.States.impl;

import fsmTrace.States.FSMClock_numberOfTicks_Value;
import fsmTrace.States.FSMEvent_isTriggered_Value;
import fsmTrace.States.State;
import fsmTrace.States.StatesPackage;
import fsmTrace.States.TimeFSM_currentState_Value;
import fsmTrace.States.TimeFSM_lastStateChangeStepNumber_Value;
import fsmTrace.States.TimeFSM_stepNumber_Value;

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
 *   <li>{@link fsmTrace.States.impl.StateImpl#getFSMClock_numberOfTicks_Values <em>FSM Clock number Of Ticks Values</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getFSMEvent_isTriggered_Values <em>FSM Event is Triggered Values</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getStartedSteps <em>Started Steps</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getTimeFSM_currentState_Values <em>Time FSM current State Values</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getTimeFSM_lastStateChangeStepNumber_Values <em>Time FSM last State Change Step Number Values</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateImpl#getTimeFSM_stepNumber_Values <em>Time FSM step Number Values</em>}</li>
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
	 * The cached value of the '{@link #getFSMClock_numberOfTicks_Values() <em>FSM Clock number Of Ticks Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFSMClock_numberOfTicks_Values()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMClock_numberOfTicks_Value> fSMClock_numberOfTicks_Values;

	/**
	 * The cached value of the '{@link #getFSMEvent_isTriggered_Values() <em>FSM Event is Triggered Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFSMEvent_isTriggered_Values()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMEvent_isTriggered_Value> fSMEvent_isTriggered_Values;

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
	 * The cached value of the '{@link #getTimeFSM_currentState_Values() <em>Time FSM current State Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFSM_currentState_Values()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeFSM_currentState_Value> timeFSM_currentState_Values;

	/**
	 * The cached value of the '{@link #getTimeFSM_lastStateChangeStepNumber_Values() <em>Time FSM last State Change Step Number Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFSM_lastStateChangeStepNumber_Values()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeFSM_lastStateChangeStepNumber_Value> timeFSM_lastStateChangeStepNumber_Values;

	/**
	 * The cached value of the '{@link #getTimeFSM_stepNumber_Values() <em>Time FSM step Number Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeFSM_stepNumber_Values()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeFSM_stepNumber_Value> timeFSM_stepNumber_Values;

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
	public EList<FSMClock_numberOfTicks_Value> getFSMClock_numberOfTicks_Values() {
		if (fSMClock_numberOfTicks_Values == null) {
			fSMClock_numberOfTicks_Values = new EObjectWithInverseResolvingEList.ManyInverse<FSMClock_numberOfTicks_Value>(FSMClock_numberOfTicks_Value.class, this, StatesPackage.STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES, StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES);
		}
		return fSMClock_numberOfTicks_Values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSMEvent_isTriggered_Value> getFSMEvent_isTriggered_Values() {
		if (fSMEvent_isTriggered_Values == null) {
			fSMEvent_isTriggered_Values = new EObjectWithInverseResolvingEList.ManyInverse<FSMEvent_isTriggered_Value>(FSMEvent_isTriggered_Value.class, this, StatesPackage.STATE__FSM_EVENT_IS_TRIGGERED_VALUES, StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES);
		}
		return fSMEvent_isTriggered_Values;
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
	public EList<TimeFSM_currentState_Value> getTimeFSM_currentState_Values() {
		if (timeFSM_currentState_Values == null) {
			timeFSM_currentState_Values = new EObjectWithInverseResolvingEList.ManyInverse<TimeFSM_currentState_Value>(TimeFSM_currentState_Value.class, this, StatesPackage.STATE__TIME_FSM_CURRENT_STATE_VALUES, StatesPackage.TIME_FSM_CURRENT_STATE_VALUE__STATES);
		}
		return timeFSM_currentState_Values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeFSM_lastStateChangeStepNumber_Value> getTimeFSM_lastStateChangeStepNumber_Values() {
		if (timeFSM_lastStateChangeStepNumber_Values == null) {
			timeFSM_lastStateChangeStepNumber_Values = new EObjectWithInverseResolvingEList.ManyInverse<TimeFSM_lastStateChangeStepNumber_Value>(TimeFSM_lastStateChangeStepNumber_Value.class, this, StatesPackage.STATE__TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES, StatesPackage.TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUE__STATES);
		}
		return timeFSM_lastStateChangeStepNumber_Values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeFSM_stepNumber_Value> getTimeFSM_stepNumber_Values() {
		if (timeFSM_stepNumber_Values == null) {
			timeFSM_stepNumber_Values = new EObjectWithInverseResolvingEList.ManyInverse<TimeFSM_stepNumber_Value>(TimeFSM_stepNumber_Value.class, this, StatesPackage.STATE__TIME_FSM_STEP_NUMBER_VALUES, StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES);
		}
		return timeFSM_stepNumber_Values;
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
			case StatesPackage.STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFSMClock_numberOfTicks_Values()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__FSM_EVENT_IS_TRIGGERED_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFSMEvent_isTriggered_Values()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__STARTED_STEPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStartedSteps()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__TIME_FSM_CURRENT_STATE_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTimeFSM_currentState_Values()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTimeFSM_lastStateChangeStepNumber_Values()).basicAdd(otherEnd, msgs);
			case StatesPackage.STATE__TIME_FSM_STEP_NUMBER_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTimeFSM_stepNumber_Values()).basicAdd(otherEnd, msgs);
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
			case StatesPackage.STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES:
				return ((InternalEList<?>)getFSMClock_numberOfTicks_Values()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__FSM_EVENT_IS_TRIGGERED_VALUES:
				return ((InternalEList<?>)getFSMEvent_isTriggered_Values()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__STARTED_STEPS:
				return ((InternalEList<?>)getStartedSteps()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__TIME_FSM_CURRENT_STATE_VALUES:
				return ((InternalEList<?>)getTimeFSM_currentState_Values()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES:
				return ((InternalEList<?>)getTimeFSM_lastStateChangeStepNumber_Values()).basicRemove(otherEnd, msgs);
			case StatesPackage.STATE__TIME_FSM_STEP_NUMBER_VALUES:
				return ((InternalEList<?>)getTimeFSM_stepNumber_Values()).basicRemove(otherEnd, msgs);
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
			case StatesPackage.STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES:
				return getFSMClock_numberOfTicks_Values();
			case StatesPackage.STATE__FSM_EVENT_IS_TRIGGERED_VALUES:
				return getFSMEvent_isTriggered_Values();
			case StatesPackage.STATE__STARTED_STEPS:
				return getStartedSteps();
			case StatesPackage.STATE__TIME_FSM_CURRENT_STATE_VALUES:
				return getTimeFSM_currentState_Values();
			case StatesPackage.STATE__TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES:
				return getTimeFSM_lastStateChangeStepNumber_Values();
			case StatesPackage.STATE__TIME_FSM_STEP_NUMBER_VALUES:
				return getTimeFSM_stepNumber_Values();
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
			case StatesPackage.STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES:
				getFSMClock_numberOfTicks_Values().clear();
				getFSMClock_numberOfTicks_Values().addAll((Collection<? extends FSMClock_numberOfTicks_Value>)newValue);
				return;
			case StatesPackage.STATE__FSM_EVENT_IS_TRIGGERED_VALUES:
				getFSMEvent_isTriggered_Values().clear();
				getFSMEvent_isTriggered_Values().addAll((Collection<? extends FSMEvent_isTriggered_Value>)newValue);
				return;
			case StatesPackage.STATE__STARTED_STEPS:
				getStartedSteps().clear();
				getStartedSteps().addAll((Collection<? extends SpecificStep>)newValue);
				return;
			case StatesPackage.STATE__TIME_FSM_CURRENT_STATE_VALUES:
				getTimeFSM_currentState_Values().clear();
				getTimeFSM_currentState_Values().addAll((Collection<? extends TimeFSM_currentState_Value>)newValue);
				return;
			case StatesPackage.STATE__TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES:
				getTimeFSM_lastStateChangeStepNumber_Values().clear();
				getTimeFSM_lastStateChangeStepNumber_Values().addAll((Collection<? extends TimeFSM_lastStateChangeStepNumber_Value>)newValue);
				return;
			case StatesPackage.STATE__TIME_FSM_STEP_NUMBER_VALUES:
				getTimeFSM_stepNumber_Values().clear();
				getTimeFSM_stepNumber_Values().addAll((Collection<? extends TimeFSM_stepNumber_Value>)newValue);
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
			case StatesPackage.STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES:
				getFSMClock_numberOfTicks_Values().clear();
				return;
			case StatesPackage.STATE__FSM_EVENT_IS_TRIGGERED_VALUES:
				getFSMEvent_isTriggered_Values().clear();
				return;
			case StatesPackage.STATE__STARTED_STEPS:
				getStartedSteps().clear();
				return;
			case StatesPackage.STATE__TIME_FSM_CURRENT_STATE_VALUES:
				getTimeFSM_currentState_Values().clear();
				return;
			case StatesPackage.STATE__TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES:
				getTimeFSM_lastStateChangeStepNumber_Values().clear();
				return;
			case StatesPackage.STATE__TIME_FSM_STEP_NUMBER_VALUES:
				getTimeFSM_stepNumber_Values().clear();
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
			case StatesPackage.STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES:
				return fSMClock_numberOfTicks_Values != null && !fSMClock_numberOfTicks_Values.isEmpty();
			case StatesPackage.STATE__FSM_EVENT_IS_TRIGGERED_VALUES:
				return fSMEvent_isTriggered_Values != null && !fSMEvent_isTriggered_Values.isEmpty();
			case StatesPackage.STATE__STARTED_STEPS:
				return startedSteps != null && !startedSteps.isEmpty();
			case StatesPackage.STATE__TIME_FSM_CURRENT_STATE_VALUES:
				return timeFSM_currentState_Values != null && !timeFSM_currentState_Values.isEmpty();
			case StatesPackage.STATE__TIME_FSM_LAST_STATE_CHANGE_STEP_NUMBER_VALUES:
				return timeFSM_lastStateChangeStepNumber_Values != null && !timeFSM_lastStateChangeStepNumber_Values.isEmpty();
			case StatesPackage.STATE__TIME_FSM_STEP_NUMBER_VALUES:
				return timeFSM_stepNumber_Values != null && !timeFSM_stepNumber_Values.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateImpl
