/**
 */
package fsmTrace.impl;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.impl.TraceImpl;

import fsmTrace.FsmTracePackage;
import fsmTrace.SpecificTrace;

import fsmTrace.States.State;

import fsmTrace.States.fsm.TracedState;
import fsmTrace.States.fsm.TracedStateMachine;
import fsmTrace.States.fsm.TracedTransition;

import fsmTrace.Steps.Fsm_StateMachine_InitializeModel;
import fsmTrace.Steps.Fsm_State_Step;
import fsmTrace.Steps.Fsm_Transition_Fire;

import fsmTrace.Steps.SpecificStep;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_StateMachine_InitializeModel_Sequence <em>Fsm State Machine Initialize Model Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_State_Step_Sequence <em>Fsm State Step Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_Transition_Fire_Sequence <em>Fsm Transition Fire Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedStateMachines <em>Fsm traced State Machines</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedStates <em>Fsm traced States</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedTransitions <em>Fsm traced Transitions</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getStatesTrace <em>States Trace</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecificTraceImpl extends TraceImpl<SequentialStep<SpecificStep>> implements SpecificTrace {
	/**
	 * The cached value of the '{@link #getFsm_StateMachine_InitializeModel_Sequence() <em>Fsm State Machine Initialize Model Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_StateMachine_InitializeModel_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_StateMachine_InitializeModel> fsm_StateMachine_InitializeModel_Sequence;

	/**
	 * The cached value of the '{@link #getFsm_State_Step_Sequence() <em>Fsm State Step Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_State_Step_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_State_Step> fsm_State_Step_Sequence;

	/**
	 * The cached value of the '{@link #getFsm_Transition_Fire_Sequence() <em>Fsm Transition Fire Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_Transition_Fire_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_Transition_Fire> fsm_Transition_Fire_Sequence;

	/**
	 * The cached value of the '{@link #getFsm_tracedStateMachines() <em>Fsm traced State Machines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedStateMachines()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedStateMachine> fsm_tracedStateMachines;

	/**
	 * The cached value of the '{@link #getFsm_tracedStates() <em>Fsm traced States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedStates()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedState> fsm_tracedStates;

	/**
	 * The cached value of the '{@link #getFsm_tracedTransitions() <em>Fsm traced Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTransition> fsm_tracedTransitions;

	/**
	 * The cached value of the '{@link #getStatesTrace() <em>States Trace</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatesTrace()
	 * @generated
	 * @ordered
	 */
	protected EList<State> statesTrace;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificTraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FsmTracePackage.Literals.SPECIFIC_TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public NotificationChain basicSetRootStep(SequentialStep<SpecificStep> newRootStep, NotificationChain msgs) {
		return super.basicSetRootStep(newRootStep, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fsm_StateMachine_InitializeModel> getFsm_StateMachine_InitializeModel_Sequence() {
		if (fsm_StateMachine_InitializeModel_Sequence == null) {
			fsm_StateMachine_InitializeModel_Sequence = new EObjectResolvingEList<Fsm_StateMachine_InitializeModel>(Fsm_StateMachine_InitializeModel.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_MACHINE_INITIALIZE_MODEL_SEQUENCE);
		}
		return fsm_StateMachine_InitializeModel_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fsm_State_Step> getFsm_State_Step_Sequence() {
		if (fsm_State_Step_Sequence == null) {
			fsm_State_Step_Sequence = new EObjectResolvingEList<Fsm_State_Step>(Fsm_State_Step.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_STEP_SEQUENCE);
		}
		return fsm_State_Step_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fsm_Transition_Fire> getFsm_Transition_Fire_Sequence() {
		if (fsm_Transition_Fire_Sequence == null) {
			fsm_Transition_Fire_Sequence = new EObjectResolvingEList<Fsm_Transition_Fire>(Fsm_Transition_Fire.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE);
		}
		return fsm_Transition_Fire_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedStateMachine> getFsm_tracedStateMachines() {
		if (fsm_tracedStateMachines == null) {
			fsm_tracedStateMachines = new EObjectContainmentEList<TracedStateMachine>(TracedStateMachine.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATE_MACHINES);
		}
		return fsm_tracedStateMachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedState> getFsm_tracedStates() {
		if (fsm_tracedStates == null) {
			fsm_tracedStates = new EObjectContainmentEList<TracedState>(TracedState.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES);
		}
		return fsm_tracedStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTransition> getFsm_tracedTransitions() {
		if (fsm_tracedTransitions == null) {
			fsm_tracedTransitions = new EObjectContainmentEList<TracedTransition>(TracedTransition.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS);
		}
		return fsm_tracedTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStatesTrace() {
		if (statesTrace == null) {
			statesTrace = new EObjectContainmentEList<State>(State.class, this, FsmTracePackage.SPECIFIC_TRACE__STATES_TRACE);
		}
		return statesTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATE_MACHINES:
				return ((InternalEList<?>)getFsm_tracedStateMachines()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				return ((InternalEList<?>)getFsm_tracedStates()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS:
				return ((InternalEList<?>)getFsm_tracedTransitions()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return ((InternalEList<?>)getStatesTrace()).basicRemove(otherEnd, msgs);
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_MACHINE_INITIALIZE_MODEL_SEQUENCE:
				return getFsm_StateMachine_InitializeModel_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_STEP_SEQUENCE:
				return getFsm_State_Step_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE:
				return getFsm_Transition_Fire_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATE_MACHINES:
				return getFsm_tracedStateMachines();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				return getFsm_tracedStates();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS:
				return getFsm_tracedTransitions();
			case FsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return getStatesTrace();
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_MACHINE_INITIALIZE_MODEL_SEQUENCE:
				getFsm_StateMachine_InitializeModel_Sequence().clear();
				getFsm_StateMachine_InitializeModel_Sequence().addAll((Collection<? extends Fsm_StateMachine_InitializeModel>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_STEP_SEQUENCE:
				getFsm_State_Step_Sequence().clear();
				getFsm_State_Step_Sequence().addAll((Collection<? extends Fsm_State_Step>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE:
				getFsm_Transition_Fire_Sequence().clear();
				getFsm_Transition_Fire_Sequence().addAll((Collection<? extends Fsm_Transition_Fire>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATE_MACHINES:
				getFsm_tracedStateMachines().clear();
				getFsm_tracedStateMachines().addAll((Collection<? extends TracedStateMachine>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				getFsm_tracedStates().clear();
				getFsm_tracedStates().addAll((Collection<? extends TracedState>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS:
				getFsm_tracedTransitions().clear();
				getFsm_tracedTransitions().addAll((Collection<? extends TracedTransition>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				getStatesTrace().clear();
				getStatesTrace().addAll((Collection<? extends State>)newValue);
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_MACHINE_INITIALIZE_MODEL_SEQUENCE:
				getFsm_StateMachine_InitializeModel_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_STEP_SEQUENCE:
				getFsm_State_Step_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE:
				getFsm_Transition_Fire_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATE_MACHINES:
				getFsm_tracedStateMachines().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				getFsm_tracedStates().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS:
				getFsm_tracedTransitions().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				getStatesTrace().clear();
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_MACHINE_INITIALIZE_MODEL_SEQUENCE:
				return fsm_StateMachine_InitializeModel_Sequence != null && !fsm_StateMachine_InitializeModel_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_STEP_SEQUENCE:
				return fsm_State_Step_Sequence != null && !fsm_State_Step_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE:
				return fsm_Transition_Fire_Sequence != null && !fsm_Transition_Fire_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATE_MACHINES:
				return fsm_tracedStateMachines != null && !fsm_tracedStateMachines.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				return fsm_tracedStates != null && !fsm_tracedStates.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS:
				return fsm_tracedTransitions != null && !fsm_tracedTransitions.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return statesTrace != null && !statesTrace.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SpecificTraceImpl
