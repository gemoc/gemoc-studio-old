/**
 */
package tfsm_plaink3Trace.impl;

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

import tfsm_plaink3Trace.SpecificTrace;

import tfsm_plaink3Trace.States.State;

import tfsm_plaink3Trace.States.tfsm_plaink3.TracedEvaluateGuard;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedEventGuard;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedState;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTemporalGuard;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTimedSystem;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition;

import tfsm_plaink3Trace.Steps.SpecificStep;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit;

import tfsm_plaink3Trace.Tfsm_plaink3TracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_FSMClock_Ticks_Sequence <em>Tfsm plaink3 FSM Clock Ticks Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_FSMEvent_Trigger_Sequence <em>Tfsm plaink3 FSM Event Trigger Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_FSMEvent_UnTrigger_Sequence <em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_State_Visit_Sequence <em>Tfsm plaink3 State Visit Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_TFSM_Init_Sequence <em>Tfsm plaink3 TFSM Init Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_Transition_Fire_Sequence <em>Tfsm plaink3 Transition Fire Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_Transition_Visit_Sequence <em>Tfsm plaink3 Transition Visit Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getStatesTrace <em>States Trace</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedEvaluateGuards <em>Tfsm plaink3 traced Evaluate Guards</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedEventGuards <em>Tfsm plaink3 traced Event Guards</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedFSMClocks <em>Tfsm plaink3 traced FSM Clocks</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedFSMEvents <em>Tfsm plaink3 traced FSM Events</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedStates <em>Tfsm plaink3 traced States</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedTFSMs <em>Tfsm plaink3 traced TFS Ms</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedTemporalGuards <em>Tfsm plaink3 traced Temporal Guards</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedTimedSystems <em>Tfsm plaink3 traced Timed Systems</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.SpecificTraceImpl#getTfsm_plaink3_tracedTransitions <em>Tfsm plaink3 traced Transitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecificTraceImpl extends TraceImpl<SequentialStep<SpecificStep>> implements SpecificTrace {
	/**
	 * The cached value of the '{@link #getTfsm_plaink3_FSMClock_Ticks_Sequence() <em>Tfsm plaink3 FSM Clock Ticks Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_FSMClock_Ticks_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_plaink3_FSMClock_Ticks> tfsm_plaink3_FSMClock_Ticks_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_FSMEvent_Trigger_Sequence() <em>Tfsm plaink3 FSM Event Trigger Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_FSMEvent_Trigger_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_plaink3_FSMEvent_Trigger> tfsm_plaink3_FSMEvent_Trigger_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_FSMEvent_UnTrigger_Sequence() <em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_FSMEvent_UnTrigger_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_plaink3_FSMEvent_UnTrigger> tfsm_plaink3_FSMEvent_UnTrigger_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_State_Visit_Sequence() <em>Tfsm plaink3 State Visit Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_State_Visit_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_plaink3_State_Visit> tfsm_plaink3_State_Visit_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_TFSM_Init_Sequence() <em>Tfsm plaink3 TFSM Init Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_TFSM_Init_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_plaink3_TFSM_Init> tfsm_plaink3_TFSM_Init_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_Transition_Fire_Sequence() <em>Tfsm plaink3 Transition Fire Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_Transition_Fire_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_plaink3_Transition_Fire> tfsm_plaink3_Transition_Fire_Sequence;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_Transition_Visit_Sequence() <em>Tfsm plaink3 Transition Visit Sequence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_Transition_Visit_Sequence()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_plaink3_Transition_Visit> tfsm_plaink3_Transition_Visit_Sequence;

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
	 * The cached value of the '{@link #getTfsm_plaink3_tracedEvaluateGuards() <em>Tfsm plaink3 traced Evaluate Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedEvaluateGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedEvaluateGuard> tfsm_plaink3_tracedEvaluateGuards;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_tracedEventGuards() <em>Tfsm plaink3 traced Event Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedEventGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedEventGuard> tfsm_plaink3_tracedEventGuards;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_tracedFSMClocks() <em>Tfsm plaink3 traced FSM Clocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedFSMClocks()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedFSMClock> tfsm_plaink3_tracedFSMClocks;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_tracedFSMEvents() <em>Tfsm plaink3 traced FSM Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedFSMEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedFSMEvent> tfsm_plaink3_tracedFSMEvents;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_tracedStates() <em>Tfsm plaink3 traced States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedStates()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedState> tfsm_plaink3_tracedStates;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_tracedTFSMs() <em>Tfsm plaink3 traced TFS Ms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedTFSMs()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTFSM> tfsm_plaink3_tracedTFSMs;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_tracedTemporalGuards() <em>Tfsm plaink3 traced Temporal Guards</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedTemporalGuards()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTemporalGuard> tfsm_plaink3_tracedTemporalGuards;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_tracedTimedSystems() <em>Tfsm plaink3 traced Timed Systems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedTimedSystems()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTimedSystem> tfsm_plaink3_tracedTimedSystems;

	/**
	 * The cached value of the '{@link #getTfsm_plaink3_tracedTransitions() <em>Tfsm plaink3 traced Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedTransition> tfsm_plaink3_tracedTransitions;

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
		return Tfsm_plaink3TracePackage.Literals.SPECIFIC_TRACE;
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
	public EList<Tfsm_plaink3_FSMClock_Ticks> getTfsm_plaink3_FSMClock_Ticks_Sequence() {
		if (tfsm_plaink3_FSMClock_Ticks_Sequence == null) {
			tfsm_plaink3_FSMClock_Ticks_Sequence = new EObjectResolvingEList<Tfsm_plaink3_FSMClock_Ticks>(Tfsm_plaink3_FSMClock_Ticks.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE);
		}
		return tfsm_plaink3_FSMClock_Ticks_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_plaink3_FSMEvent_Trigger> getTfsm_plaink3_FSMEvent_Trigger_Sequence() {
		if (tfsm_plaink3_FSMEvent_Trigger_Sequence == null) {
			tfsm_plaink3_FSMEvent_Trigger_Sequence = new EObjectResolvingEList<Tfsm_plaink3_FSMEvent_Trigger>(Tfsm_plaink3_FSMEvent_Trigger.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE);
		}
		return tfsm_plaink3_FSMEvent_Trigger_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_plaink3_FSMEvent_UnTrigger> getTfsm_plaink3_FSMEvent_UnTrigger_Sequence() {
		if (tfsm_plaink3_FSMEvent_UnTrigger_Sequence == null) {
			tfsm_plaink3_FSMEvent_UnTrigger_Sequence = new EObjectResolvingEList<Tfsm_plaink3_FSMEvent_UnTrigger>(Tfsm_plaink3_FSMEvent_UnTrigger.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE);
		}
		return tfsm_plaink3_FSMEvent_UnTrigger_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_plaink3_State_Visit> getTfsm_plaink3_State_Visit_Sequence() {
		if (tfsm_plaink3_State_Visit_Sequence == null) {
			tfsm_plaink3_State_Visit_Sequence = new EObjectResolvingEList<Tfsm_plaink3_State_Visit>(Tfsm_plaink3_State_Visit.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE);
		}
		return tfsm_plaink3_State_Visit_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_plaink3_TFSM_Init> getTfsm_plaink3_TFSM_Init_Sequence() {
		if (tfsm_plaink3_TFSM_Init_Sequence == null) {
			tfsm_plaink3_TFSM_Init_Sequence = new EObjectResolvingEList<Tfsm_plaink3_TFSM_Init>(Tfsm_plaink3_TFSM_Init.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE);
		}
		return tfsm_plaink3_TFSM_Init_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_plaink3_Transition_Fire> getTfsm_plaink3_Transition_Fire_Sequence() {
		if (tfsm_plaink3_Transition_Fire_Sequence == null) {
			tfsm_plaink3_Transition_Fire_Sequence = new EObjectResolvingEList<Tfsm_plaink3_Transition_Fire>(Tfsm_plaink3_Transition_Fire.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE);
		}
		return tfsm_plaink3_Transition_Fire_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_plaink3_Transition_Visit> getTfsm_plaink3_Transition_Visit_Sequence() {
		if (tfsm_plaink3_Transition_Visit_Sequence == null) {
			tfsm_plaink3_Transition_Visit_Sequence = new EObjectResolvingEList<Tfsm_plaink3_Transition_Visit>(Tfsm_plaink3_Transition_Visit.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE);
		}
		return tfsm_plaink3_Transition_Visit_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStatesTrace() {
		if (statesTrace == null) {
			statesTrace = new EObjectContainmentEList<State>(State.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__STATES_TRACE);
		}
		return statesTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedEvaluateGuard> getTfsm_plaink3_tracedEvaluateGuards() {
		if (tfsm_plaink3_tracedEvaluateGuards == null) {
			tfsm_plaink3_tracedEvaluateGuards = new EObjectContainmentEList<TracedEvaluateGuard>(TracedEvaluateGuard.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS);
		}
		return tfsm_plaink3_tracedEvaluateGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedEventGuard> getTfsm_plaink3_tracedEventGuards() {
		if (tfsm_plaink3_tracedEventGuards == null) {
			tfsm_plaink3_tracedEventGuards = new EObjectContainmentEList<TracedEventGuard>(TracedEventGuard.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS);
		}
		return tfsm_plaink3_tracedEventGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedFSMClock> getTfsm_plaink3_tracedFSMClocks() {
		if (tfsm_plaink3_tracedFSMClocks == null) {
			tfsm_plaink3_tracedFSMClocks = new EObjectContainmentEList<TracedFSMClock>(TracedFSMClock.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS);
		}
		return tfsm_plaink3_tracedFSMClocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedFSMEvent> getTfsm_plaink3_tracedFSMEvents() {
		if (tfsm_plaink3_tracedFSMEvents == null) {
			tfsm_plaink3_tracedFSMEvents = new EObjectContainmentEList<TracedFSMEvent>(TracedFSMEvent.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS);
		}
		return tfsm_plaink3_tracedFSMEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedState> getTfsm_plaink3_tracedStates() {
		if (tfsm_plaink3_tracedStates == null) {
			tfsm_plaink3_tracedStates = new EObjectContainmentEList<TracedState>(TracedState.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES);
		}
		return tfsm_plaink3_tracedStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTFSM> getTfsm_plaink3_tracedTFSMs() {
		if (tfsm_plaink3_tracedTFSMs == null) {
			tfsm_plaink3_tracedTFSMs = new EObjectContainmentEList<TracedTFSM>(TracedTFSM.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS);
		}
		return tfsm_plaink3_tracedTFSMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTemporalGuard> getTfsm_plaink3_tracedTemporalGuards() {
		if (tfsm_plaink3_tracedTemporalGuards == null) {
			tfsm_plaink3_tracedTemporalGuards = new EObjectContainmentEList<TracedTemporalGuard>(TracedTemporalGuard.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS);
		}
		return tfsm_plaink3_tracedTemporalGuards;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTimedSystem> getTfsm_plaink3_tracedTimedSystems() {
		if (tfsm_plaink3_tracedTimedSystems == null) {
			tfsm_plaink3_tracedTimedSystems = new EObjectContainmentEList<TracedTimedSystem>(TracedTimedSystem.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS);
		}
		return tfsm_plaink3_tracedTimedSystems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTransition> getTfsm_plaink3_tracedTransitions() {
		if (tfsm_plaink3_tracedTransitions == null) {
			tfsm_plaink3_tracedTransitions = new EObjectContainmentEList<TracedTransition>(TracedTransition.class, this, Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS);
		}
		return tfsm_plaink3_tracedTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return ((InternalEList<?>)getStatesTrace()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedEvaluateGuards()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedEventGuards()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedFSMClocks()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedFSMEvents()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES:
				return ((InternalEList<?>)getTfsm_plaink3_tracedStates()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedTFSMs()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedTemporalGuards()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedTimedSystems()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedTransitions()).basicRemove(otherEnd, msgs);
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
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE:
				return getTfsm_plaink3_FSMClock_Ticks_Sequence();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE:
				return getTfsm_plaink3_FSMEvent_Trigger_Sequence();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				return getTfsm_plaink3_FSMEvent_UnTrigger_Sequence();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE:
				return getTfsm_plaink3_State_Visit_Sequence();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE:
				return getTfsm_plaink3_TFSM_Init_Sequence();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE:
				return getTfsm_plaink3_Transition_Fire_Sequence();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE:
				return getTfsm_plaink3_Transition_Visit_Sequence();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return getStatesTrace();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS:
				return getTfsm_plaink3_tracedEvaluateGuards();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS:
				return getTfsm_plaink3_tracedEventGuards();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				return getTfsm_plaink3_tracedFSMClocks();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				return getTfsm_plaink3_tracedFSMEvents();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES:
				return getTfsm_plaink3_tracedStates();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				return getTfsm_plaink3_tracedTFSMs();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS:
				return getTfsm_plaink3_tracedTemporalGuards();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS:
				return getTfsm_plaink3_tracedTimedSystems();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS:
				return getTfsm_plaink3_tracedTransitions();
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
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE:
				getTfsm_plaink3_FSMClock_Ticks_Sequence().clear();
				getTfsm_plaink3_FSMClock_Ticks_Sequence().addAll((Collection<? extends Tfsm_plaink3_FSMClock_Ticks>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE:
				getTfsm_plaink3_FSMEvent_Trigger_Sequence().clear();
				getTfsm_plaink3_FSMEvent_Trigger_Sequence().addAll((Collection<? extends Tfsm_plaink3_FSMEvent_Trigger>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().clear();
				getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().addAll((Collection<? extends Tfsm_plaink3_FSMEvent_UnTrigger>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE:
				getTfsm_plaink3_State_Visit_Sequence().clear();
				getTfsm_plaink3_State_Visit_Sequence().addAll((Collection<? extends Tfsm_plaink3_State_Visit>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE:
				getTfsm_plaink3_TFSM_Init_Sequence().clear();
				getTfsm_plaink3_TFSM_Init_Sequence().addAll((Collection<? extends Tfsm_plaink3_TFSM_Init>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE:
				getTfsm_plaink3_Transition_Fire_Sequence().clear();
				getTfsm_plaink3_Transition_Fire_Sequence().addAll((Collection<? extends Tfsm_plaink3_Transition_Fire>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE:
				getTfsm_plaink3_Transition_Visit_Sequence().clear();
				getTfsm_plaink3_Transition_Visit_Sequence().addAll((Collection<? extends Tfsm_plaink3_Transition_Visit>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__STATES_TRACE:
				getStatesTrace().clear();
				getStatesTrace().addAll((Collection<? extends State>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS:
				getTfsm_plaink3_tracedEvaluateGuards().clear();
				getTfsm_plaink3_tracedEvaluateGuards().addAll((Collection<? extends TracedEvaluateGuard>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS:
				getTfsm_plaink3_tracedEventGuards().clear();
				getTfsm_plaink3_tracedEventGuards().addAll((Collection<? extends TracedEventGuard>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				getTfsm_plaink3_tracedFSMClocks().clear();
				getTfsm_plaink3_tracedFSMClocks().addAll((Collection<? extends TracedFSMClock>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				getTfsm_plaink3_tracedFSMEvents().clear();
				getTfsm_plaink3_tracedFSMEvents().addAll((Collection<? extends TracedFSMEvent>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES:
				getTfsm_plaink3_tracedStates().clear();
				getTfsm_plaink3_tracedStates().addAll((Collection<? extends TracedState>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				getTfsm_plaink3_tracedTFSMs().clear();
				getTfsm_plaink3_tracedTFSMs().addAll((Collection<? extends TracedTFSM>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS:
				getTfsm_plaink3_tracedTemporalGuards().clear();
				getTfsm_plaink3_tracedTemporalGuards().addAll((Collection<? extends TracedTemporalGuard>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS:
				getTfsm_plaink3_tracedTimedSystems().clear();
				getTfsm_plaink3_tracedTimedSystems().addAll((Collection<? extends TracedTimedSystem>)newValue);
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS:
				getTfsm_plaink3_tracedTransitions().clear();
				getTfsm_plaink3_tracedTransitions().addAll((Collection<? extends TracedTransition>)newValue);
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
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE:
				getTfsm_plaink3_FSMClock_Ticks_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE:
				getTfsm_plaink3_FSMEvent_Trigger_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE:
				getTfsm_plaink3_State_Visit_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE:
				getTfsm_plaink3_TFSM_Init_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE:
				getTfsm_plaink3_Transition_Fire_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE:
				getTfsm_plaink3_Transition_Visit_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__STATES_TRACE:
				getStatesTrace().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS:
				getTfsm_plaink3_tracedEvaluateGuards().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS:
				getTfsm_plaink3_tracedEventGuards().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				getTfsm_plaink3_tracedFSMClocks().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				getTfsm_plaink3_tracedFSMEvents().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES:
				getTfsm_plaink3_tracedStates().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				getTfsm_plaink3_tracedTFSMs().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS:
				getTfsm_plaink3_tracedTemporalGuards().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS:
				getTfsm_plaink3_tracedTimedSystems().clear();
				return;
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS:
				getTfsm_plaink3_tracedTransitions().clear();
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
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE:
				return tfsm_plaink3_FSMClock_Ticks_Sequence != null && !tfsm_plaink3_FSMClock_Ticks_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE:
				return tfsm_plaink3_FSMEvent_Trigger_Sequence != null && !tfsm_plaink3_FSMEvent_Trigger_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				return tfsm_plaink3_FSMEvent_UnTrigger_Sequence != null && !tfsm_plaink3_FSMEvent_UnTrigger_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE:
				return tfsm_plaink3_State_Visit_Sequence != null && !tfsm_plaink3_State_Visit_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE:
				return tfsm_plaink3_TFSM_Init_Sequence != null && !tfsm_plaink3_TFSM_Init_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE:
				return tfsm_plaink3_Transition_Fire_Sequence != null && !tfsm_plaink3_Transition_Fire_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE:
				return tfsm_plaink3_Transition_Visit_Sequence != null && !tfsm_plaink3_Transition_Visit_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__STATES_TRACE:
				return statesTrace != null && !statesTrace.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVALUATE_GUARDS:
				return tfsm_plaink3_tracedEvaluateGuards != null && !tfsm_plaink3_tracedEvaluateGuards.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_EVENT_GUARDS:
				return tfsm_plaink3_tracedEventGuards != null && !tfsm_plaink3_tracedEventGuards.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				return tfsm_plaink3_tracedFSMClocks != null && !tfsm_plaink3_tracedFSMClocks.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				return tfsm_plaink3_tracedFSMEvents != null && !tfsm_plaink3_tracedFSMEvents.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_STATES:
				return tfsm_plaink3_tracedStates != null && !tfsm_plaink3_tracedStates.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				return tfsm_plaink3_tracedTFSMs != null && !tfsm_plaink3_tracedTFSMs.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TEMPORAL_GUARDS:
				return tfsm_plaink3_tracedTemporalGuards != null && !tfsm_plaink3_tracedTemporalGuards.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TIMED_SYSTEMS:
				return tfsm_plaink3_tracedTimedSystems != null && !tfsm_plaink3_tracedTimedSystems.isEmpty();
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE__TFSM_PLAINK3_TRACED_TRANSITIONS:
				return tfsm_plaink3_tracedTransitions != null && !tfsm_plaink3_tracedTransitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SpecificTraceImpl
