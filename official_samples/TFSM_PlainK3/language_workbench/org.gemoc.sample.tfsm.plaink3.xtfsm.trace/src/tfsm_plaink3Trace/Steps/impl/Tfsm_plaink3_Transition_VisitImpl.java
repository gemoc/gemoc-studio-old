/**
 */
package tfsm_plaink3Trace.Steps.impl;

import fr.inria.diverse.trace.commons.model.trace.BigStep;
import fr.inria.diverse.trace.commons.model.trace.SequentialStep;
import fr.inria.diverse.trace.commons.model.trace.TracePackage;

import fr.inria.diverse.trace.commons.model.trace.impl.StepImpl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tfsm_plaink3Trace.States.State;
import tfsm_plaink3Trace.States.StatesPackage;

import tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition;

import tfsm_plaink3Trace.Steps.StepsPackage;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Visit_AbstractSubStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tfsm plaink3 Transition Visit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl#getEndingState <em>Ending State</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl#getStartingState <em>Starting State</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl#getSubSteps <em>Sub Steps</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Tfsm_plaink3_Transition_VisitImpl extends StepImpl implements Tfsm_plaink3_Transition_Visit {
	/**
	 * The cached value of the '{@link #getEndingState() <em>Ending State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndingState()
	 * @generated
	 * @ordered
	 */
	protected State endingState;

	/**
	 * The cached value of the '{@link #getStartingState() <em>Starting State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingState()
	 * @generated
	 * @ordered
	 */
	protected State startingState;

	/**
	 * The cached value of the '{@link #getSubSteps() <em>Sub Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<Tfsm_plaink3_Transition_Visit_AbstractSubStep> subSteps;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Tfsm_plaink3_Transition_VisitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StepsPackage.Literals.TFSM_PLAINK3_TRANSITION_VISIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getEndingState() {
		if (endingState != null && endingState.eIsProxy()) {
			InternalEObject oldEndingState = (InternalEObject)endingState;
			endingState = (State)eResolveProxy(oldEndingState);
			if (endingState != oldEndingState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE, oldEndingState, endingState));
			}
		}
		return endingState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetEndingState() {
		return endingState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndingState(State newEndingState, NotificationChain msgs) {
		State oldEndingState = endingState;
		endingState = newEndingState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE, oldEndingState, newEndingState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndingState(State newEndingState) {
		if (newEndingState != endingState) {
			NotificationChain msgs = null;
			if (endingState != null)
				msgs = ((InternalEObject)endingState).eInverseRemove(this, StatesPackage.STATE__ENDED_STEPS, State.class, msgs);
			if (newEndingState != null)
				msgs = ((InternalEObject)newEndingState).eInverseAdd(this, StatesPackage.STATE__ENDED_STEPS, State.class, msgs);
			msgs = basicSetEndingState(newEndingState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE, newEndingState, newEndingState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getStartingState() {
		if (startingState != null && startingState.eIsProxy()) {
			InternalEObject oldStartingState = (InternalEObject)startingState;
			startingState = (State)eResolveProxy(oldStartingState);
			if (startingState != oldStartingState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE, oldStartingState, startingState));
			}
		}
		return startingState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetStartingState() {
		return startingState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartingState(State newStartingState, NotificationChain msgs) {
		State oldStartingState = startingState;
		startingState = newStartingState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE, oldStartingState, newStartingState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingState(State newStartingState) {
		if (newStartingState != startingState) {
			NotificationChain msgs = null;
			if (startingState != null)
				msgs = ((InternalEObject)startingState).eInverseRemove(this, StatesPackage.STATE__STARTED_STEPS, State.class, msgs);
			if (newStartingState != null)
				msgs = ((InternalEObject)newStartingState).eInverseAdd(this, StatesPackage.STATE__STARTED_STEPS, State.class, msgs);
			msgs = basicSetStartingState(newStartingState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE, newStartingState, newStartingState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tfsm_plaink3_Transition_Visit_AbstractSubStep> getSubSteps() {
		if (subSteps == null) {
			subSteps = new EObjectContainmentEList<Tfsm_plaink3_Transition_Visit_AbstractSubStep>(Tfsm_plaink3_Transition_Visit_AbstractSubStep.class, this, StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS);
		}
		return subSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedTransition getCaller() {
		return (tfsm_plaink3Trace.States.tfsm_plaink3.TracedTransition) this.getMseoccurrence().getMse().getCaller();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE:
				if (endingState != null)
					msgs = ((InternalEObject)endingState).eInverseRemove(this, StatesPackage.STATE__ENDED_STEPS, State.class, msgs);
				return basicSetEndingState((State)otherEnd, msgs);
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE:
				if (startingState != null)
					msgs = ((InternalEObject)startingState).eInverseRemove(this, StatesPackage.STATE__STARTED_STEPS, State.class, msgs);
				return basicSetStartingState((State)otherEnd, msgs);
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
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE:
				return basicSetEndingState(null, msgs);
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE:
				return basicSetStartingState(null, msgs);
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS:
				return ((InternalEList<?>)getSubSteps()).basicRemove(otherEnd, msgs);
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
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE:
				if (resolve) return getEndingState();
				return basicGetEndingState();
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE:
				if (resolve) return getStartingState();
				return basicGetStartingState();
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS:
				return getSubSteps();
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
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE:
				setEndingState((State)newValue);
				return;
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE:
				setStartingState((State)newValue);
				return;
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS:
				getSubSteps().clear();
				getSubSteps().addAll((Collection<? extends Tfsm_plaink3_Transition_Visit_AbstractSubStep>)newValue);
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
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE:
				setEndingState((State)null);
				return;
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE:
				setStartingState((State)null);
				return;
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS:
				getSubSteps().clear();
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
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__ENDING_STATE:
				return endingState != null;
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__STARTING_STATE:
				return startingState != null;
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS:
				return subSteps != null && !subSteps.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BigStep.class) {
			switch (derivedFeatureID) {
				case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS: return TracePackage.BIG_STEP__SUB_STEPS;
				default: return -1;
			}
		}
		if (baseClass == SequentialStep.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BigStep.class) {
			switch (baseFeatureID) {
				case TracePackage.BIG_STEP__SUB_STEPS: return StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT__SUB_STEPS;
				default: return -1;
			}
		}
		if (baseClass == SequentialStep.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT___GET_CALLER:
				return getCaller();
		}
		return super.eInvoke(operationID, arguments);
	}

} //Tfsm_plaink3_Transition_VisitImpl
