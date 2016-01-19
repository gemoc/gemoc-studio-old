/**
 */
package tfsm_plaink3Trace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tfsm_plaink3Trace.States.State;

import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTFSM;

import tfsm_plaink3Trace.Steps.Step;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMClock_Ticks;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_Trigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_FSMEvent_UnTrigger;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_State_Visit;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_TFSM_Init;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit;

import tfsm_plaink3Trace.Tfsm_plaink3TracePackage;
import tfsm_plaink3Trace.Trace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_FSMClock_Ticks_Sequence <em>Tfsm plaink3 FSM Clock Ticks Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_FSMEvent_Trigger_Sequence <em>Tfsm plaink3 FSM Event Trigger Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_FSMEvent_UnTrigger_Sequence <em>Tfsm plaink3 FSM Event Un Trigger Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_State_Visit_Sequence <em>Tfsm plaink3 State Visit Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_TFSM_Init_Sequence <em>Tfsm plaink3 TFSM Init Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_Transition_Fire_Sequence <em>Tfsm plaink3 Transition Fire Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_Transition_Visit_Sequence <em>Tfsm plaink3 Transition Visit Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getRootSteps <em>Root Steps</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getStatesTrace <em>States Trace</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_tracedFSMClocks <em>Tfsm plaink3 traced FSM Clocks</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_tracedFSMEvents <em>Tfsm plaink3 traced FSM Events</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_tracedNamedElements <em>Tfsm plaink3 traced Named Elements</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.impl.TraceImpl#getTfsm_plaink3_tracedTFSMs <em>Tfsm plaink3 traced TFS Ms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceImpl extends MinimalEObjectImpl.Container implements Trace {
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
	 * The cached value of the '{@link #getRootSteps() <em>Root Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<Step> rootSteps;

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
	 * The cached value of the '{@link #getTfsm_plaink3_tracedNamedElements() <em>Tfsm plaink3 traced Named Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTfsm_plaink3_tracedNamedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TracedNamedElement> tfsm_plaink3_tracedNamedElements;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tfsm_plaink3TracePackage.Literals.TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_plaink3_FSMClock_Ticks> getTfsm_plaink3_FSMClock_Ticks_Sequence() {
		if (tfsm_plaink3_FSMClock_Ticks_Sequence == null) {
			tfsm_plaink3_FSMClock_Ticks_Sequence = new EObjectResolvingEList<Tfsm_plaink3_FSMClock_Ticks>(Tfsm_plaink3_FSMClock_Ticks.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE);
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
			tfsm_plaink3_FSMEvent_Trigger_Sequence = new EObjectResolvingEList<Tfsm_plaink3_FSMEvent_Trigger>(Tfsm_plaink3_FSMEvent_Trigger.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE);
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
			tfsm_plaink3_FSMEvent_UnTrigger_Sequence = new EObjectResolvingEList<Tfsm_plaink3_FSMEvent_UnTrigger>(Tfsm_plaink3_FSMEvent_UnTrigger.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE);
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
			tfsm_plaink3_State_Visit_Sequence = new EObjectResolvingEList<Tfsm_plaink3_State_Visit>(Tfsm_plaink3_State_Visit.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE);
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
			tfsm_plaink3_TFSM_Init_Sequence = new EObjectResolvingEList<Tfsm_plaink3_TFSM_Init>(Tfsm_plaink3_TFSM_Init.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE);
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
			tfsm_plaink3_Transition_Fire_Sequence = new EObjectResolvingEList<Tfsm_plaink3_Transition_Fire>(Tfsm_plaink3_Transition_Fire.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE);
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
			tfsm_plaink3_Transition_Visit_Sequence = new EObjectResolvingEList<Tfsm_plaink3_Transition_Visit>(Tfsm_plaink3_Transition_Visit.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE);
		}
		return tfsm_plaink3_Transition_Visit_Sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Step> getRootSteps() {
		if (rootSteps == null) {
			rootSteps = new EObjectContainmentEList<Step>(Step.class, this, Tfsm_plaink3TracePackage.TRACE__ROOT_STEPS);
		}
		return rootSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStatesTrace() {
		if (statesTrace == null) {
			statesTrace = new EObjectContainmentEList<State>(State.class, this, Tfsm_plaink3TracePackage.TRACE__STATES_TRACE);
		}
		return statesTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedFSMClock> getTfsm_plaink3_tracedFSMClocks() {
		if (tfsm_plaink3_tracedFSMClocks == null) {
			tfsm_plaink3_tracedFSMClocks = new EObjectContainmentEList<TracedFSMClock>(TracedFSMClock.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS);
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
			tfsm_plaink3_tracedFSMEvents = new EObjectContainmentEList<TracedFSMEvent>(TracedFSMEvent.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS);
		}
		return tfsm_plaink3_tracedFSMEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedNamedElement> getTfsm_plaink3_tracedNamedElements() {
		if (tfsm_plaink3_tracedNamedElements == null) {
			tfsm_plaink3_tracedNamedElements = new EObjectContainmentEList<TracedNamedElement>(TracedNamedElement.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_NAMED_ELEMENTS);
		}
		return tfsm_plaink3_tracedNamedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TracedTFSM> getTfsm_plaink3_tracedTFSMs() {
		if (tfsm_plaink3_tracedTFSMs == null) {
			tfsm_plaink3_tracedTFSMs = new EObjectContainmentEList<TracedTFSM>(TracedTFSM.class, this, Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_TFS_MS);
		}
		return tfsm_plaink3_tracedTFSMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Tfsm_plaink3TracePackage.TRACE__ROOT_STEPS:
				return ((InternalEList<?>)getRootSteps()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.TRACE__STATES_TRACE:
				return ((InternalEList<?>)getStatesTrace()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedFSMClocks()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedFSMEvents()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_NAMED_ELEMENTS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedNamedElements()).basicRemove(otherEnd, msgs);
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				return ((InternalEList<?>)getTfsm_plaink3_tracedTFSMs()).basicRemove(otherEnd, msgs);
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
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE:
				return getTfsm_plaink3_FSMClock_Ticks_Sequence();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE:
				return getTfsm_plaink3_FSMEvent_Trigger_Sequence();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				return getTfsm_plaink3_FSMEvent_UnTrigger_Sequence();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE:
				return getTfsm_plaink3_State_Visit_Sequence();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE:
				return getTfsm_plaink3_TFSM_Init_Sequence();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE:
				return getTfsm_plaink3_Transition_Fire_Sequence();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE:
				return getTfsm_plaink3_Transition_Visit_Sequence();
			case Tfsm_plaink3TracePackage.TRACE__ROOT_STEPS:
				return getRootSteps();
			case Tfsm_plaink3TracePackage.TRACE__STATES_TRACE:
				return getStatesTrace();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				return getTfsm_plaink3_tracedFSMClocks();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				return getTfsm_plaink3_tracedFSMEvents();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_NAMED_ELEMENTS:
				return getTfsm_plaink3_tracedNamedElements();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				return getTfsm_plaink3_tracedTFSMs();
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
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE:
				getTfsm_plaink3_FSMClock_Ticks_Sequence().clear();
				getTfsm_plaink3_FSMClock_Ticks_Sequence().addAll((Collection<? extends Tfsm_plaink3_FSMClock_Ticks>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE:
				getTfsm_plaink3_FSMEvent_Trigger_Sequence().clear();
				getTfsm_plaink3_FSMEvent_Trigger_Sequence().addAll((Collection<? extends Tfsm_plaink3_FSMEvent_Trigger>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().clear();
				getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().addAll((Collection<? extends Tfsm_plaink3_FSMEvent_UnTrigger>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE:
				getTfsm_plaink3_State_Visit_Sequence().clear();
				getTfsm_plaink3_State_Visit_Sequence().addAll((Collection<? extends Tfsm_plaink3_State_Visit>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE:
				getTfsm_plaink3_TFSM_Init_Sequence().clear();
				getTfsm_plaink3_TFSM_Init_Sequence().addAll((Collection<? extends Tfsm_plaink3_TFSM_Init>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE:
				getTfsm_plaink3_Transition_Fire_Sequence().clear();
				getTfsm_plaink3_Transition_Fire_Sequence().addAll((Collection<? extends Tfsm_plaink3_Transition_Fire>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE:
				getTfsm_plaink3_Transition_Visit_Sequence().clear();
				getTfsm_plaink3_Transition_Visit_Sequence().addAll((Collection<? extends Tfsm_plaink3_Transition_Visit>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__ROOT_STEPS:
				getRootSteps().clear();
				getRootSteps().addAll((Collection<? extends Step>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__STATES_TRACE:
				getStatesTrace().clear();
				getStatesTrace().addAll((Collection<? extends State>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				getTfsm_plaink3_tracedFSMClocks().clear();
				getTfsm_plaink3_tracedFSMClocks().addAll((Collection<? extends TracedFSMClock>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				getTfsm_plaink3_tracedFSMEvents().clear();
				getTfsm_plaink3_tracedFSMEvents().addAll((Collection<? extends TracedFSMEvent>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_NAMED_ELEMENTS:
				getTfsm_plaink3_tracedNamedElements().clear();
				getTfsm_plaink3_tracedNamedElements().addAll((Collection<? extends TracedNamedElement>)newValue);
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				getTfsm_plaink3_tracedTFSMs().clear();
				getTfsm_plaink3_tracedTFSMs().addAll((Collection<? extends TracedTFSM>)newValue);
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
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE:
				getTfsm_plaink3_FSMClock_Ticks_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE:
				getTfsm_plaink3_FSMEvent_Trigger_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				getTfsm_plaink3_FSMEvent_UnTrigger_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE:
				getTfsm_plaink3_State_Visit_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE:
				getTfsm_plaink3_TFSM_Init_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE:
				getTfsm_plaink3_Transition_Fire_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE:
				getTfsm_plaink3_Transition_Visit_Sequence().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__ROOT_STEPS:
				getRootSteps().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__STATES_TRACE:
				getStatesTrace().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				getTfsm_plaink3_tracedFSMClocks().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				getTfsm_plaink3_tracedFSMEvents().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_NAMED_ELEMENTS:
				getTfsm_plaink3_tracedNamedElements().clear();
				return;
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				getTfsm_plaink3_tracedTFSMs().clear();
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
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_CLOCK_TICKS_SEQUENCE:
				return tfsm_plaink3_FSMClock_Ticks_Sequence != null && !tfsm_plaink3_FSMClock_Ticks_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_TRIGGER_SEQUENCE:
				return tfsm_plaink3_FSMEvent_Trigger_Sequence != null && !tfsm_plaink3_FSMEvent_Trigger_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_FSM_EVENT_UN_TRIGGER_SEQUENCE:
				return tfsm_plaink3_FSMEvent_UnTrigger_Sequence != null && !tfsm_plaink3_FSMEvent_UnTrigger_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_STATE_VISIT_SEQUENCE:
				return tfsm_plaink3_State_Visit_Sequence != null && !tfsm_plaink3_State_Visit_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TFSM_INIT_SEQUENCE:
				return tfsm_plaink3_TFSM_Init_Sequence != null && !tfsm_plaink3_TFSM_Init_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_FIRE_SEQUENCE:
				return tfsm_plaink3_Transition_Fire_Sequence != null && !tfsm_plaink3_Transition_Fire_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRANSITION_VISIT_SEQUENCE:
				return tfsm_plaink3_Transition_Visit_Sequence != null && !tfsm_plaink3_Transition_Visit_Sequence.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__ROOT_STEPS:
				return rootSteps != null && !rootSteps.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__STATES_TRACE:
				return statesTrace != null && !statesTrace.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_CLOCKS:
				return tfsm_plaink3_tracedFSMClocks != null && !tfsm_plaink3_tracedFSMClocks.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_FSM_EVENTS:
				return tfsm_plaink3_tracedFSMEvents != null && !tfsm_plaink3_tracedFSMEvents.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_NAMED_ELEMENTS:
				return tfsm_plaink3_tracedNamedElements != null && !tfsm_plaink3_tracedNamedElements.isEmpty();
			case Tfsm_plaink3TracePackage.TRACE__TFSM_PLAINK3_TRACED_TFS_MS:
				return tfsm_plaink3_tracedTFSMs != null && !tfsm_plaink3_tracedTFSMs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TraceImpl
