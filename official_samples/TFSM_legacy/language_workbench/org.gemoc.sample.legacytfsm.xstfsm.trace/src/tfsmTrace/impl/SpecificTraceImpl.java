/**
 */
package tfsmTrace.impl;

import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.impl.TraceImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tfsmTrace.SpecificTrace;

import tfsmTrace.States.State;

import tfsmTrace.States.tfsm.TracedEvaluateGuard;
import tfsmTrace.States.tfsm.TracedEventGuard;
import tfsmTrace.States.tfsm.TracedFSMClock;
import tfsmTrace.States.tfsm.TracedFSMEvent;
import tfsmTrace.States.tfsm.TracedState;
import tfsmTrace.States.tfsm.TracedTemporalGuard;
import tfsmTrace.States.tfsm.TracedTimeFSM;
import tfsmTrace.States.tfsm.TracedTimedSystem;
import tfsmTrace.States.tfsm.TracedTransition;

import tfsmTrace.Steps.SpecificStep;
import tfsmTrace.Steps.Tfsm_FSMClock_Ticks;
import tfsmTrace.Steps.Tfsm_FSMEvent_Trigger;
import tfsmTrace.Steps.Tfsm_FSMEvent_UnTrigger;
import tfsmTrace.Steps.Tfsm_State_Visit;
import tfsmTrace.Steps.Tfsm_TimeFSM_Init;
import tfsmTrace.Steps.Tfsm_Transition_Fire;
import tfsmTrace.Steps.Tfsm_Transition_Visit;

import tfsmTrace.TfsmTracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_FSMClock_Ticks_Sequence <em>Tfsm FSM Clock Ticks Sequence</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_FSMEvent_Trigger_Sequence <em>Tfsm FSM Event Trigger Sequence</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_FSMEvent_UnTrigger_Sequence <em>Tfsm FSM Event Un Trigger Sequence</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_State_Visit_Sequence <em>Tfsm State Visit Sequence</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_TimeFSM_Init_Sequence <em>Tfsm Time FSM Init Sequence</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_Transition_Fire_Sequence <em>Tfsm Transition Fire Sequence</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_Transition_Visit_Sequence <em>Tfsm Transition Visit Sequence</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getStatesTrace <em>States Trace</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedEvaluateGuards <em>Tfsm traced Evaluate Guards</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedEventGuards <em>Tfsm traced Event Guards</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedFSMClocks <em>Tfsm traced FSM Clocks</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedFSMEvents <em>Tfsm traced FSM Events</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedStates <em>Tfsm traced States</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedTemporalGuards <em>Tfsm traced Temporal Guards</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedTimeFSMs <em>Tfsm traced Time FS Ms</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedTimedSystems <em>Tfsm traced Timed Systems</em>}</li>
 *   <li>{@link tfsmTrace.impl.SpecificTraceImpl#getTfsm_tracedTransitions <em>Tfsm traced Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecificTraceImpl extends TraceImpl<SequentialStep<SpecificStep>> implements SpecificTrace {
	/**
	 * The cached value of the '{@link #getTfsm_FSMClock_Ticks_Sequence() <em>Tfsm FSM Clock Ticks Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_FSMClock_Ticks_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_FSMClock_Ticks> tfsm_FSMClock_Ticks_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_FSMEvent_Trigger_Sequence() <em>Tfsm FSM Event Trigger Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_FSMEvent_Trigger_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_FSMEvent_Trigger> tfsm_FSMEvent_Trigger_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_FSMEvent_UnTrigger_Sequence() <em>Tfsm FSM Event Un Trigger Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_FSMEvent_UnTrigger_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_FSMEvent_UnTrigger> tfsm_FSMEvent_UnTrigger_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_State_Visit_Sequence() <em>Tfsm State Visit Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_State_Visit_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_State_Visit> tfsm_State_Visit_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_TimeFSM_Init_Sequence() <em>Tfsm Time FSM Init Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_TimeFSM_Init_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_TimeFSM_Init> tfsm_TimeFSM_Init_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_Transition_Fire_Sequence() <em>Tfsm Transition Fire Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_Transition_Fire_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_Transition_Fire> tfsm_Transition_Fire_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_Transition_Visit_Sequence() <em>Tfsm Transition Visit Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_Transition_Visit_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_Transition_Visit> tfsm_Transition_Visit_Sequence;

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
	 * The cached value of the '{@link #getTfsm_tracedEvaluateGuards() <em>Tfsm traced Evaluate Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedEvaluateGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedEvaluateGuard> tfsm_tracedEvaluateGuards;

	/**
	 * The cached value of the '{@link #getTfsm_tracedEventGuards() <em>Tfsm traced Event Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedEventGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedEventGuard> tfsm_tracedEventGuards;

	/**
	 * The cached value of the '{@link #getTfsm_tracedFSMClocks() <em>Tfsm traced FSM Clocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedFSMClocks()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedFSMClock> tfsm_tracedFSMClocks;

	/**
	 * The cached value of the '{@link #getTfsm_tracedFSMEvents() <em>Tfsm traced FSM Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedFSMEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedFSMEvent> tfsm_tracedFSMEvents;

	/**
	 * The cached value of the '{@link #getTfsm_tracedStates() <em>Tfsm traced States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedStates()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedState> tfsm_tracedStates;

	/**
	 * The cached value of the '{@link #getTfsm_tracedTemporalGuards() <em>Tfsm traced Temporal Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedTemporalGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTemporalGuard> tfsm_tracedTemporalGuards;

	/**
	 * The cached value of the '{@link #getTfsm_tracedTimeFSMs() <em>Tfsm traced Time FS Ms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedTimeFSMs()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTimeFSM> tfsm_tracedTimeFSMs;

	/**
	 * The cached value of the '{@link #getTfsm_tracedTimedSystems() <em>Tfsm traced Timed Systems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedTimedSystems()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTimedSystem> tfsm_tracedTimedSystems;

	/**
	 * The cached value of the '{@link #getTfsm_tracedTransitions() <em>Tfsm traced Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_tracedTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTransition> tfsm_tracedTransitions;

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
		return TfsmTracePackage.Literals.SPECIFIC_TRACE;
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
	public EList<Tfsm_FSMClock_Ticks> getTfsm_FSMClock_Ticks_Sequence() {
		if (tfsm_FSMClock_Ticks_Sequence == null) {
			tfsm_FSMClock_Ticks_Sequence = new EObjectResolvingEList<Tfsm_FSMClock_Ticks>(Tfsm_FSMClock_Ticks.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_CLOCK_TICKS_SEQUENCE);
		}
		return tfsm_FSMClock_Ticks_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_FSMEvent_Trigger> getTfsm_FSMEvent_Trigger_Sequence() {
		if (tfsm_FSMEvent_Trigger_Sequence == null) {
			tfsm_FSMEvent_Trigger_Sequence = new EObjectResolvingEList<Tfsm_FSMEvent_Trigger>(Tfsm_FSMEvent_Trigger.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_TRIGGER_SEQUENCE);
		}
		return tfsm_FSMEvent_Trigger_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_FSMEvent_UnTrigger> getTfsm_FSMEvent_UnTrigger_Sequence() {
		if (tfsm_FSMEvent_UnTrigger_Sequence == null) {
			tfsm_FSMEvent_UnTrigger_Sequence = new EObjectResolvingEList<Tfsm_FSMEvent_UnTrigger>(Tfsm_FSMEvent_UnTrigger.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_UN_TRIGGER_SEQUENCE);
		}
		return tfsm_FSMEvent_UnTrigger_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_State_Visit> getTfsm_State_Visit_Sequence() {
		if (tfsm_State_Visit_Sequence == null) {
			tfsm_State_Visit_Sequence = new EObjectResolvingEList<Tfsm_State_Visit>(Tfsm_State_Visit.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_STATE_VISIT_SEQUENCE);
		}
		return tfsm_State_Visit_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_TimeFSM_Init> getTfsm_TimeFSM_Init_Sequence() {
		if (tfsm_TimeFSM_Init_Sequence == null) {
			tfsm_TimeFSM_Init_Sequence = new EObjectResolvingEList<Tfsm_TimeFSM_Init>(Tfsm_TimeFSM_Init.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TIME_FSM_INIT_SEQUENCE);
		}
		return tfsm_TimeFSM_Init_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_Transition_Fire> getTfsm_Transition_Fire_Sequence() {
		if (tfsm_Transition_Fire_Sequence == null) {
			tfsm_Transition_Fire_Sequence = new EObjectResolvingEList<Tfsm_Transition_Fire>(Tfsm_Transition_Fire.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_FIRE_SEQUENCE);
		}
		return tfsm_Transition_Fire_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_Transition_Visit> getTfsm_Transition_Visit_Sequence() {
		if (tfsm_Transition_Visit_Sequence == null) {
			tfsm_Transition_Visit_Sequence = new EObjectResolvingEList<Tfsm_Transition_Visit>(Tfsm_Transition_Visit.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_VISIT_SEQUENCE);
		}
		return tfsm_Transition_Visit_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStatesTrace() {
		if (statesTrace == null) {
			statesTrace = new EObjectContainmentEList<State>(State.class, this, TfsmTracePackage.SPECIFIC_TRACE__STATES_TRACE);
		}
		return statesTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedEvaluateGuard> getTfsm_tracedEvaluateGuards() {
		if (tfsm_tracedEvaluateGuards == null) {
			tfsm_tracedEvaluateGuards = new EObjectContainmentEList<TracedEvaluateGuard>(TracedEvaluateGuard.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS);
		}
		return tfsm_tracedEvaluateGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedEventGuard> getTfsm_tracedEventGuards() {
		if (tfsm_tracedEventGuards == null) {
			tfsm_tracedEventGuards = new EObjectContainmentEList<TracedEventGuard>(TracedEventGuard.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS);
		}
		return tfsm_tracedEventGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedFSMClock> getTfsm_tracedFSMClocks() {
		if (tfsm_tracedFSMClocks == null) {
			tfsm_tracedFSMClocks = new EObjectContainmentEList<TracedFSMClock>(TracedFSMClock.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS);
		}
		return tfsm_tracedFSMClocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedFSMEvent> getTfsm_tracedFSMEvents() {
		if (tfsm_tracedFSMEvents == null) {
			tfsm_tracedFSMEvents = new EObjectContainmentEList<TracedFSMEvent>(TracedFSMEvent.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS);
		}
		return tfsm_tracedFSMEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedState> getTfsm_tracedStates() {
		if (tfsm_tracedStates == null) {
			tfsm_tracedStates = new EObjectContainmentEList<TracedState>(TracedState.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_STATES);
		}
		return tfsm_tracedStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTemporalGuard> getTfsm_tracedTemporalGuards() {
		if (tfsm_tracedTemporalGuards == null) {
			tfsm_tracedTemporalGuards = new EObjectContainmentEList<TracedTemporalGuard>(TracedTemporalGuard.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS);
		}
		return tfsm_tracedTemporalGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTimeFSM> getTfsm_tracedTimeFSMs() {
		if (tfsm_tracedTimeFSMs == null) {
			tfsm_tracedTimeFSMs = new EObjectContainmentEList<TracedTimeFSM>(TracedTimeFSM.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS);
		}
		return tfsm_tracedTimeFSMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTimedSystem> getTfsm_tracedTimedSystems() {
		if (tfsm_tracedTimedSystems == null) {
			tfsm_tracedTimedSystems = new EObjectContainmentEList<TracedTimedSystem>(TracedTimedSystem.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS);
		}
		return tfsm_tracedTimedSystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTransition> getTfsm_tracedTransitions() {
		if (tfsm_tracedTransitions == null) {
			tfsm_tracedTransitions = new EObjectContainmentEList<TracedTransition>(TracedTransition.class, this, TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS);
		}
		return tfsm_tracedTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TfsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return ((InternalEList<?>)getStatesTrace()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS:
				return ((InternalEList<?>)getTfsm_tracedEvaluateGuards()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS:
				return ((InternalEList<?>)getTfsm_tracedEventGuards()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS:
				return ((InternalEList<?>)getTfsm_tracedFSMClocks()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS:
				return ((InternalEList<?>)getTfsm_tracedFSMEvents()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_STATES:
				return ((InternalEList<?>)getTfsm_tracedStates()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS:
				return ((InternalEList<?>)getTfsm_tracedTemporalGuards()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS:
				return ((InternalEList<?>)getTfsm_tracedTimeFSMs()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS:
				return ((InternalEList<?>)getTfsm_tracedTimedSystems()).basicRemove(otherEnd, msgs);
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS:
				return ((InternalEList<?>)getTfsm_tracedTransitions()).basicRemove(otherEnd, msgs);
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
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_CLOCK_TICKS_SEQUENCE:
				return getTfsm_FSMClock_Ticks_Sequence();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_TRIGGER_SEQUENCE:
				return getTfsm_FSMEvent_Trigger_Sequence();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				return getTfsm_FSMEvent_UnTrigger_Sequence();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_STATE_VISIT_SEQUENCE:
				return getTfsm_State_Visit_Sequence();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TIME_FSM_INIT_SEQUENCE:
				return getTfsm_TimeFSM_Init_Sequence();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_FIRE_SEQUENCE:
				return getTfsm_Transition_Fire_Sequence();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_VISIT_SEQUENCE:
				return getTfsm_Transition_Visit_Sequence();
			case TfsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return getStatesTrace();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS:
				return getTfsm_tracedEvaluateGuards();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS:
				return getTfsm_tracedEventGuards();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS:
				return getTfsm_tracedFSMClocks();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS:
				return getTfsm_tracedFSMEvents();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_STATES:
				return getTfsm_tracedStates();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS:
				return getTfsm_tracedTemporalGuards();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS:
				return getTfsm_tracedTimeFSMs();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS:
				return getTfsm_tracedTimedSystems();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS:
				return getTfsm_tracedTransitions();
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
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_CLOCK_TICKS_SEQUENCE:
				getTfsm_FSMClock_Ticks_Sequence().clear();
				getTfsm_FSMClock_Ticks_Sequence().addAll((Collection<? extends Tfsm_FSMClock_Ticks>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_TRIGGER_SEQUENCE:
				getTfsm_FSMEvent_Trigger_Sequence().clear();
				getTfsm_FSMEvent_Trigger_Sequence().addAll((Collection<? extends Tfsm_FSMEvent_Trigger>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				getTfsm_FSMEvent_UnTrigger_Sequence().clear();
				getTfsm_FSMEvent_UnTrigger_Sequence().addAll((Collection<? extends Tfsm_FSMEvent_UnTrigger>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_STATE_VISIT_SEQUENCE:
				getTfsm_State_Visit_Sequence().clear();
				getTfsm_State_Visit_Sequence().addAll((Collection<? extends Tfsm_State_Visit>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TIME_FSM_INIT_SEQUENCE:
				getTfsm_TimeFSM_Init_Sequence().clear();
				getTfsm_TimeFSM_Init_Sequence().addAll((Collection<? extends Tfsm_TimeFSM_Init>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_FIRE_SEQUENCE:
				getTfsm_Transition_Fire_Sequence().clear();
				getTfsm_Transition_Fire_Sequence().addAll((Collection<? extends Tfsm_Transition_Fire>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_VISIT_SEQUENCE:
				getTfsm_Transition_Visit_Sequence().clear();
				getTfsm_Transition_Visit_Sequence().addAll((Collection<? extends Tfsm_Transition_Visit>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				getStatesTrace().clear();
				getStatesTrace().addAll((Collection<? extends State>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS:
				getTfsm_tracedEvaluateGuards().clear();
				getTfsm_tracedEvaluateGuards().addAll((Collection<? extends TracedEvaluateGuard>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS:
				getTfsm_tracedEventGuards().clear();
				getTfsm_tracedEventGuards().addAll((Collection<? extends TracedEventGuard>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS:
				getTfsm_tracedFSMClocks().clear();
				getTfsm_tracedFSMClocks().addAll((Collection<? extends TracedFSMClock>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS:
				getTfsm_tracedFSMEvents().clear();
				getTfsm_tracedFSMEvents().addAll((Collection<? extends TracedFSMEvent>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_STATES:
				getTfsm_tracedStates().clear();
				getTfsm_tracedStates().addAll((Collection<? extends TracedState>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS:
				getTfsm_tracedTemporalGuards().clear();
				getTfsm_tracedTemporalGuards().addAll((Collection<? extends TracedTemporalGuard>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS:
				getTfsm_tracedTimeFSMs().clear();
				getTfsm_tracedTimeFSMs().addAll((Collection<? extends TracedTimeFSM>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS:
				getTfsm_tracedTimedSystems().clear();
				getTfsm_tracedTimedSystems().addAll((Collection<? extends TracedTimedSystem>)newValue);
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS:
				getTfsm_tracedTransitions().clear();
				getTfsm_tracedTransitions().addAll((Collection<? extends TracedTransition>)newValue);
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
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_CLOCK_TICKS_SEQUENCE:
				getTfsm_FSMClock_Ticks_Sequence().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_TRIGGER_SEQUENCE:
				getTfsm_FSMEvent_Trigger_Sequence().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				getTfsm_FSMEvent_UnTrigger_Sequence().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_STATE_VISIT_SEQUENCE:
				getTfsm_State_Visit_Sequence().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TIME_FSM_INIT_SEQUENCE:
				getTfsm_TimeFSM_Init_Sequence().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_FIRE_SEQUENCE:
				getTfsm_Transition_Fire_Sequence().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_VISIT_SEQUENCE:
				getTfsm_Transition_Visit_Sequence().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				getStatesTrace().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS:
				getTfsm_tracedEvaluateGuards().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS:
				getTfsm_tracedEventGuards().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS:
				getTfsm_tracedFSMClocks().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS:
				getTfsm_tracedFSMEvents().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_STATES:
				getTfsm_tracedStates().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS:
				getTfsm_tracedTemporalGuards().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS:
				getTfsm_tracedTimeFSMs().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS:
				getTfsm_tracedTimedSystems().clear();
				return;
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS:
				getTfsm_tracedTransitions().clear();
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
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_CLOCK_TICKS_SEQUENCE:
				return tfsm_FSMClock_Ticks_Sequence != null && !tfsm_FSMClock_Ticks_Sequence.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_TRIGGER_SEQUENCE:
				return tfsm_FSMEvent_Trigger_Sequence != null && !tfsm_FSMEvent_Trigger_Sequence.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				return tfsm_FSMEvent_UnTrigger_Sequence != null && !tfsm_FSMEvent_UnTrigger_Sequence.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_STATE_VISIT_SEQUENCE:
				return tfsm_State_Visit_Sequence != null && !tfsm_State_Visit_Sequence.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TIME_FSM_INIT_SEQUENCE:
				return tfsm_TimeFSM_Init_Sequence != null && !tfsm_TimeFSM_Init_Sequence.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_FIRE_SEQUENCE:
				return tfsm_Transition_Fire_Sequence != null && !tfsm_Transition_Fire_Sequence.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRANSITION_VISIT_SEQUENCE:
				return tfsm_Transition_Visit_Sequence != null && !tfsm_Transition_Visit_Sequence.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return statesTrace != null && !statesTrace.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVALUATE_GUARDS:
				return tfsm_tracedEvaluateGuards != null && !tfsm_tracedEvaluateGuards.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_EVENT_GUARDS:
				return tfsm_tracedEventGuards != null && !tfsm_tracedEventGuards.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_CLOCKS:
				return tfsm_tracedFSMClocks != null && !tfsm_tracedFSMClocks.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_FSM_EVENTS:
				return tfsm_tracedFSMEvents != null && !tfsm_tracedFSMEvents.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_STATES:
				return tfsm_tracedStates != null && !tfsm_tracedStates.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TEMPORAL_GUARDS:
				return tfsm_tracedTemporalGuards != null && !tfsm_tracedTemporalGuards.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIME_FS_MS:
				return tfsm_tracedTimeFSMs != null && !tfsm_tracedTimeFSMs.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TIMED_SYSTEMS:
				return tfsm_tracedTimedSystems != null && !tfsm_tracedTimedSystems.isEmpty();
			case TfsmTracePackage.SPECIFIC_TRACE__TFSM_TRACED_TRANSITIONS:
				return tfsm_tracedTransitions != null && !tfsm_tracedTransitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SpecificTraceImpl
