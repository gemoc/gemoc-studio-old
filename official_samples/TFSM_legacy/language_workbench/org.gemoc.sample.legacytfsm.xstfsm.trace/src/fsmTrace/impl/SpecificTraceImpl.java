/**
 */
package fsmTrace.impl;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;

import fr.inria.diverse.trace.commons.model.trace.impl.TraceImpl;

import fsmTrace.FsmTracePackage;
import fsmTrace.SpecificTrace;

import fsmTrace.States.State;

import fsmTrace.States.fsm.TracedEvaluateGuard;
import fsmTrace.States.fsm.TracedEventGuard;
import fsmTrace.States.fsm.TracedFSMClock;
import fsmTrace.States.fsm.TracedFSMEvent;
import fsmTrace.States.fsm.TracedState;
import fsmTrace.States.fsm.TracedTemporalGuard;
import fsmTrace.States.fsm.TracedTimeFSM;
import fsmTrace.States.fsm.TracedTimedSystem;
import fsmTrace.States.fsm.TracedTransition;

import fsmTrace.Steps.Fsm_FSMClock_Ticks;
import fsmTrace.Steps.Fsm_FSMEvent_Trigger;
import fsmTrace.Steps.Fsm_FSMEvent_UnTrigger;
import fsmTrace.Steps.Fsm_State_Visit;
import fsmTrace.Steps.Fsm_TimeFSM_Init;
import fsmTrace.Steps.Fsm_Transition_Fire;
import fsmTrace.Steps.Fsm_Transition_Visit;
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
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_FSMClock_Ticks_Sequence <em>Fsm FSM Clock Ticks Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_FSMEvent_Trigger_Sequence <em>Fsm FSM Event Trigger Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_FSMEvent_UnTrigger_Sequence <em>Fsm FSM Event Un Trigger Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_State_Visit_Sequence <em>Fsm State Visit Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_TimeFSM_Init_Sequence <em>Fsm Time FSM Init Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_Transition_Fire_Sequence <em>Fsm Transition Fire Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_Transition_Visit_Sequence <em>Fsm Transition Visit Sequence</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedEvaluateGuards <em>Fsm traced Evaluate Guards</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedEventGuards <em>Fsm traced Event Guards</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedFSMClocks <em>Fsm traced FSM Clocks</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedFSMEvents <em>Fsm traced FSM Events</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedStates <em>Fsm traced States</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedTemporalGuards <em>Fsm traced Temporal Guards</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedTimeFSMs <em>Fsm traced Time FS Ms</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedTimedSystems <em>Fsm traced Timed Systems</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getFsm_tracedTransitions <em>Fsm traced Transitions</em>}</li>
 *   <li>{@link fsmTrace.impl.SpecificTraceImpl#getStatesTrace <em>States Trace</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecificTraceImpl extends TraceImpl<SequentialStep<SpecificStep>> implements SpecificTrace {
	/**
	 * The cached value of the '{@link #getFsm_FSMClock_Ticks_Sequence() <em>Fsm FSM Clock Ticks Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_FSMClock_Ticks_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_FSMClock_Ticks> fsm_FSMClock_Ticks_Sequence;

	/**
	 * The cached value of the '{@link #getFsm_FSMEvent_Trigger_Sequence() <em>Fsm FSM Event Trigger Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_FSMEvent_Trigger_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_FSMEvent_Trigger> fsm_FSMEvent_Trigger_Sequence;

	/**
	 * The cached value of the '{@link #getFsm_FSMEvent_UnTrigger_Sequence() <em>Fsm FSM Event Un Trigger Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_FSMEvent_UnTrigger_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_FSMEvent_UnTrigger> fsm_FSMEvent_UnTrigger_Sequence;

	/**
	 * The cached value of the '{@link #getFsm_State_Visit_Sequence() <em>Fsm State Visit Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_State_Visit_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_State_Visit> fsm_State_Visit_Sequence;

	/**
	 * The cached value of the '{@link #getFsm_TimeFSM_Init_Sequence() <em>Fsm Time FSM Init Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_TimeFSM_Init_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_TimeFSM_Init> fsm_TimeFSM_Init_Sequence;

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
	 * The cached value of the '{@link #getFsm_Transition_Visit_Sequence() <em>Fsm Transition Visit Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_Transition_Visit_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Fsm_Transition_Visit> fsm_Transition_Visit_Sequence;

	/**
	 * The cached value of the '{@link #getFsm_tracedEvaluateGuards() <em>Fsm traced Evaluate Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedEvaluateGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedEvaluateGuard> fsm_tracedEvaluateGuards;

	/**
	 * The cached value of the '{@link #getFsm_tracedEventGuards() <em>Fsm traced Event Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedEventGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedEventGuard> fsm_tracedEventGuards;

	/**
	 * The cached value of the '{@link #getFsm_tracedFSMClocks() <em>Fsm traced FSM Clocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedFSMClocks()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedFSMClock> fsm_tracedFSMClocks;

	/**
	 * The cached value of the '{@link #getFsm_tracedFSMEvents() <em>Fsm traced FSM Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedFSMEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedFSMEvent> fsm_tracedFSMEvents;

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
	 * The cached value of the '{@link #getFsm_tracedTemporalGuards() <em>Fsm traced Temporal Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedTemporalGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTemporalGuard> fsm_tracedTemporalGuards;

	/**
	 * The cached value of the '{@link #getFsm_tracedTimeFSMs() <em>Fsm traced Time FS Ms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedTimeFSMs()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTimeFSM> fsm_tracedTimeFSMs;

	/**
	 * The cached value of the '{@link #getFsm_tracedTimedSystems() <em>Fsm traced Timed Systems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFsm_tracedTimedSystems()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTimedSystem> fsm_tracedTimedSystems;

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
	public EList<Fsm_FSMClock_Ticks> getFsm_FSMClock_Ticks_Sequence() {
		if (fsm_FSMClock_Ticks_Sequence == null) {
			fsm_FSMClock_Ticks_Sequence = new EObjectResolvingEList<Fsm_FSMClock_Ticks>(Fsm_FSMClock_Ticks.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_CLOCK_TICKS_SEQUENCE);
		}
		return fsm_FSMClock_Ticks_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fsm_FSMEvent_Trigger> getFsm_FSMEvent_Trigger_Sequence() {
		if (fsm_FSMEvent_Trigger_Sequence == null) {
			fsm_FSMEvent_Trigger_Sequence = new EObjectResolvingEList<Fsm_FSMEvent_Trigger>(Fsm_FSMEvent_Trigger.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_TRIGGER_SEQUENCE);
		}
		return fsm_FSMEvent_Trigger_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fsm_FSMEvent_UnTrigger> getFsm_FSMEvent_UnTrigger_Sequence() {
		if (fsm_FSMEvent_UnTrigger_Sequence == null) {
			fsm_FSMEvent_UnTrigger_Sequence = new EObjectResolvingEList<Fsm_FSMEvent_UnTrigger>(Fsm_FSMEvent_UnTrigger.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_UN_TRIGGER_SEQUENCE);
		}
		return fsm_FSMEvent_UnTrigger_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fsm_State_Visit> getFsm_State_Visit_Sequence() {
		if (fsm_State_Visit_Sequence == null) {
			fsm_State_Visit_Sequence = new EObjectResolvingEList<Fsm_State_Visit>(Fsm_State_Visit.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_VISIT_SEQUENCE);
		}
		return fsm_State_Visit_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Fsm_TimeFSM_Init> getFsm_TimeFSM_Init_Sequence() {
		if (fsm_TimeFSM_Init_Sequence == null) {
			fsm_TimeFSM_Init_Sequence = new EObjectResolvingEList<Fsm_TimeFSM_Init>(Fsm_TimeFSM_Init.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TIME_FSM_INIT_SEQUENCE);
		}
		return fsm_TimeFSM_Init_Sequence;
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
	public EList<Fsm_Transition_Visit> getFsm_Transition_Visit_Sequence() {
		if (fsm_Transition_Visit_Sequence == null) {
			fsm_Transition_Visit_Sequence = new EObjectResolvingEList<Fsm_Transition_Visit>(Fsm_Transition_Visit.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_VISIT_SEQUENCE);
		}
		return fsm_Transition_Visit_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedEvaluateGuard> getFsm_tracedEvaluateGuards() {
		if (fsm_tracedEvaluateGuards == null) {
			fsm_tracedEvaluateGuards = new EObjectContainmentEList<TracedEvaluateGuard>(TracedEvaluateGuard.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVALUATE_GUARDS);
		}
		return fsm_tracedEvaluateGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedEventGuard> getFsm_tracedEventGuards() {
		if (fsm_tracedEventGuards == null) {
			fsm_tracedEventGuards = new EObjectContainmentEList<TracedEventGuard>(TracedEventGuard.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVENT_GUARDS);
		}
		return fsm_tracedEventGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedFSMClock> getFsm_tracedFSMClocks() {
		if (fsm_tracedFSMClocks == null) {
			fsm_tracedFSMClocks = new EObjectContainmentEList<TracedFSMClock>(TracedFSMClock.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_CLOCKS);
		}
		return fsm_tracedFSMClocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedFSMEvent> getFsm_tracedFSMEvents() {
		if (fsm_tracedFSMEvents == null) {
			fsm_tracedFSMEvents = new EObjectContainmentEList<TracedFSMEvent>(TracedFSMEvent.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_EVENTS);
		}
		return fsm_tracedFSMEvents;
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
	public EList<TracedTemporalGuard> getFsm_tracedTemporalGuards() {
		if (fsm_tracedTemporalGuards == null) {
			fsm_tracedTemporalGuards = new EObjectContainmentEList<TracedTemporalGuard>(TracedTemporalGuard.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TEMPORAL_GUARDS);
		}
		return fsm_tracedTemporalGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTimeFSM> getFsm_tracedTimeFSMs() {
		if (fsm_tracedTimeFSMs == null) {
			fsm_tracedTimeFSMs = new EObjectContainmentEList<TracedTimeFSM>(TracedTimeFSM.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIME_FS_MS);
		}
		return fsm_tracedTimeFSMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTimedSystem> getFsm_tracedTimedSystems() {
		if (fsm_tracedTimedSystems == null) {
			fsm_tracedTimedSystems = new EObjectContainmentEList<TracedTimedSystem>(TracedTimedSystem.class, this, FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIMED_SYSTEMS);
		}
		return fsm_tracedTimedSystems;
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVALUATE_GUARDS:
				return ((InternalEList<?>)getFsm_tracedEvaluateGuards()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVENT_GUARDS:
				return ((InternalEList<?>)getFsm_tracedEventGuards()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_CLOCKS:
				return ((InternalEList<?>)getFsm_tracedFSMClocks()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_EVENTS:
				return ((InternalEList<?>)getFsm_tracedFSMEvents()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				return ((InternalEList<?>)getFsm_tracedStates()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TEMPORAL_GUARDS:
				return ((InternalEList<?>)getFsm_tracedTemporalGuards()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIME_FS_MS:
				return ((InternalEList<?>)getFsm_tracedTimeFSMs()).basicRemove(otherEnd, msgs);
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIMED_SYSTEMS:
				return ((InternalEList<?>)getFsm_tracedTimedSystems()).basicRemove(otherEnd, msgs);
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_CLOCK_TICKS_SEQUENCE:
				return getFsm_FSMClock_Ticks_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_TRIGGER_SEQUENCE:
				return getFsm_FSMEvent_Trigger_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				return getFsm_FSMEvent_UnTrigger_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_VISIT_SEQUENCE:
				return getFsm_State_Visit_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TIME_FSM_INIT_SEQUENCE:
				return getFsm_TimeFSM_Init_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE:
				return getFsm_Transition_Fire_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_VISIT_SEQUENCE:
				return getFsm_Transition_Visit_Sequence();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVALUATE_GUARDS:
				return getFsm_tracedEvaluateGuards();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVENT_GUARDS:
				return getFsm_tracedEventGuards();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_CLOCKS:
				return getFsm_tracedFSMClocks();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_EVENTS:
				return getFsm_tracedFSMEvents();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				return getFsm_tracedStates();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TEMPORAL_GUARDS:
				return getFsm_tracedTemporalGuards();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIME_FS_MS:
				return getFsm_tracedTimeFSMs();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIMED_SYSTEMS:
				return getFsm_tracedTimedSystems();
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_CLOCK_TICKS_SEQUENCE:
				getFsm_FSMClock_Ticks_Sequence().clear();
				getFsm_FSMClock_Ticks_Sequence().addAll((Collection<? extends Fsm_FSMClock_Ticks>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_TRIGGER_SEQUENCE:
				getFsm_FSMEvent_Trigger_Sequence().clear();
				getFsm_FSMEvent_Trigger_Sequence().addAll((Collection<? extends Fsm_FSMEvent_Trigger>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				getFsm_FSMEvent_UnTrigger_Sequence().clear();
				getFsm_FSMEvent_UnTrigger_Sequence().addAll((Collection<? extends Fsm_FSMEvent_UnTrigger>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_VISIT_SEQUENCE:
				getFsm_State_Visit_Sequence().clear();
				getFsm_State_Visit_Sequence().addAll((Collection<? extends Fsm_State_Visit>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TIME_FSM_INIT_SEQUENCE:
				getFsm_TimeFSM_Init_Sequence().clear();
				getFsm_TimeFSM_Init_Sequence().addAll((Collection<? extends Fsm_TimeFSM_Init>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE:
				getFsm_Transition_Fire_Sequence().clear();
				getFsm_Transition_Fire_Sequence().addAll((Collection<? extends Fsm_Transition_Fire>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_VISIT_SEQUENCE:
				getFsm_Transition_Visit_Sequence().clear();
				getFsm_Transition_Visit_Sequence().addAll((Collection<? extends Fsm_Transition_Visit>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVALUATE_GUARDS:
				getFsm_tracedEvaluateGuards().clear();
				getFsm_tracedEvaluateGuards().addAll((Collection<? extends TracedEvaluateGuard>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVENT_GUARDS:
				getFsm_tracedEventGuards().clear();
				getFsm_tracedEventGuards().addAll((Collection<? extends TracedEventGuard>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_CLOCKS:
				getFsm_tracedFSMClocks().clear();
				getFsm_tracedFSMClocks().addAll((Collection<? extends TracedFSMClock>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_EVENTS:
				getFsm_tracedFSMEvents().clear();
				getFsm_tracedFSMEvents().addAll((Collection<? extends TracedFSMEvent>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				getFsm_tracedStates().clear();
				getFsm_tracedStates().addAll((Collection<? extends TracedState>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TEMPORAL_GUARDS:
				getFsm_tracedTemporalGuards().clear();
				getFsm_tracedTemporalGuards().addAll((Collection<? extends TracedTemporalGuard>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIME_FS_MS:
				getFsm_tracedTimeFSMs().clear();
				getFsm_tracedTimeFSMs().addAll((Collection<? extends TracedTimeFSM>)newValue);
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIMED_SYSTEMS:
				getFsm_tracedTimedSystems().clear();
				getFsm_tracedTimedSystems().addAll((Collection<? extends TracedTimedSystem>)newValue);
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_CLOCK_TICKS_SEQUENCE:
				getFsm_FSMClock_Ticks_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_TRIGGER_SEQUENCE:
				getFsm_FSMEvent_Trigger_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				getFsm_FSMEvent_UnTrigger_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_VISIT_SEQUENCE:
				getFsm_State_Visit_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TIME_FSM_INIT_SEQUENCE:
				getFsm_TimeFSM_Init_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE:
				getFsm_Transition_Fire_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_VISIT_SEQUENCE:
				getFsm_Transition_Visit_Sequence().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVALUATE_GUARDS:
				getFsm_tracedEvaluateGuards().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVENT_GUARDS:
				getFsm_tracedEventGuards().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_CLOCKS:
				getFsm_tracedFSMClocks().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_EVENTS:
				getFsm_tracedFSMEvents().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				getFsm_tracedStates().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TEMPORAL_GUARDS:
				getFsm_tracedTemporalGuards().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIME_FS_MS:
				getFsm_tracedTimeFSMs().clear();
				return;
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIMED_SYSTEMS:
				getFsm_tracedTimedSystems().clear();
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
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_CLOCK_TICKS_SEQUENCE:
				return fsm_FSMClock_Ticks_Sequence != null && !fsm_FSMClock_Ticks_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_TRIGGER_SEQUENCE:
				return fsm_FSMEvent_Trigger_Sequence != null && !fsm_FSMEvent_Trigger_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				return fsm_FSMEvent_UnTrigger_Sequence != null && !fsm_FSMEvent_UnTrigger_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_STATE_VISIT_SEQUENCE:
				return fsm_State_Visit_Sequence != null && !fsm_State_Visit_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TIME_FSM_INIT_SEQUENCE:
				return fsm_TimeFSM_Init_Sequence != null && !fsm_TimeFSM_Init_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_FIRE_SEQUENCE:
				return fsm_Transition_Fire_Sequence != null && !fsm_Transition_Fire_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRANSITION_VISIT_SEQUENCE:
				return fsm_Transition_Visit_Sequence != null && !fsm_Transition_Visit_Sequence.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVALUATE_GUARDS:
				return fsm_tracedEvaluateGuards != null && !fsm_tracedEvaluateGuards.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_EVENT_GUARDS:
				return fsm_tracedEventGuards != null && !fsm_tracedEventGuards.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_CLOCKS:
				return fsm_tracedFSMClocks != null && !fsm_tracedFSMClocks.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_FSM_EVENTS:
				return fsm_tracedFSMEvents != null && !fsm_tracedFSMEvents.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_STATES:
				return fsm_tracedStates != null && !fsm_tracedStates.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TEMPORAL_GUARDS:
				return fsm_tracedTemporalGuards != null && !fsm_tracedTemporalGuards.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIME_FS_MS:
				return fsm_tracedTimeFSMs != null && !fsm_tracedTimeFSMs.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TIMED_SYSTEMS:
				return fsm_tracedTimedSystems != null && !fsm_tracedTimedSystems.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__FSM_TRACED_TRANSITIONS:
				return fsm_tracedTransitions != null && !fsm_tracedTransitions.isEmpty();
			case FsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return statesTrace != null && !statesTrace.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SpecificTraceImpl
