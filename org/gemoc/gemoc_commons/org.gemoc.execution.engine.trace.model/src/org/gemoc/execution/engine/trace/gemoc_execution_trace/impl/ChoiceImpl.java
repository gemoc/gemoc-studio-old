/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import fr.inria.aoste.trace.LogicalStep;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getNextChoice <em>Next Choice</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getPossibleLogicalSteps <em>Possible Logical Steps</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getChosenLogicalStep <em>Chosen Logical Step</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getContextState <em>Context State</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getPreviousChoice <em>Previous Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceImpl extends MinimalEObjectImpl.Container implements Choice {
	/**
	 * The cached value of the '{@link #getNextChoice() <em>Next Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextChoice()
	 * @generated
	 * @ordered
	 */
	protected Choice nextChoice;

	/**
	 * The cached value of the '{@link #getPossibleLogicalSteps() <em>Possible Logical Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossibleLogicalSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<LogicalStep> possibleLogicalSteps;

	/**
	 * The cached value of the '{@link #getChosenLogicalStep() <em>Chosen Logical Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenLogicalStep()
	 * @generated
	 * @ordered
	 */
	protected LogicalStep chosenLogicalStep;

	/**
	 * The cached value of the '{@link #getContextState() <em>Context State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextState()
	 * @generated
	 * @ordered
	 */
	protected ContextState contextState;

	/**
	 * The cached value of the '{@link #getPreviousChoice() <em>Previous Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousChoice()
	 * @generated
	 * @ordered
	 */
	protected Choice previousChoice;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChoiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gemoc_execution_tracePackage.Literals.CHOICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice getNextChoice() {
		if (nextChoice != null && nextChoice.eIsProxy()) {
			InternalEObject oldNextChoice = (InternalEObject)nextChoice;
			nextChoice = (Choice)eResolveProxy(oldNextChoice);
			if (nextChoice != oldNextChoice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE, oldNextChoice, nextChoice));
			}
		}
		return nextChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice basicGetNextChoice() {
		return nextChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNextChoice(Choice newNextChoice, NotificationChain msgs) {
		Choice oldNextChoice = nextChoice;
		nextChoice = newNextChoice;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE, oldNextChoice, newNextChoice);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextChoice(Choice newNextChoice) {
		if (newNextChoice != nextChoice) {
			NotificationChain msgs = null;
			if (nextChoice != null)
				msgs = ((InternalEObject)nextChoice).eInverseRemove(this, Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE, Choice.class, msgs);
			if (newNextChoice != null)
				msgs = ((InternalEObject)newNextChoice).eInverseAdd(this, Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE, Choice.class, msgs);
			msgs = basicSetNextChoice(newNextChoice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE, newNextChoice, newNextChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LogicalStep> getPossibleLogicalSteps() {
		if (possibleLogicalSteps == null) {
			possibleLogicalSteps = new EObjectContainmentEList<LogicalStep>(LogicalStep.class, this, Gemoc_execution_tracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS);
		}
		return possibleLogicalSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalStep getChosenLogicalStep() {
		if (chosenLogicalStep != null && chosenLogicalStep.eIsProxy()) {
			InternalEObject oldChosenLogicalStep = (InternalEObject)chosenLogicalStep;
			chosenLogicalStep = (LogicalStep)eResolveProxy(oldChosenLogicalStep);
			if (chosenLogicalStep != oldChosenLogicalStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gemoc_execution_tracePackage.CHOICE__CHOSEN_LOGICAL_STEP, oldChosenLogicalStep, chosenLogicalStep));
			}
		}
		return chosenLogicalStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalStep basicGetChosenLogicalStep() {
		return chosenLogicalStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenLogicalStep(LogicalStep newChosenLogicalStep) {
		LogicalStep oldChosenLogicalStep = chosenLogicalStep;
		chosenLogicalStep = newChosenLogicalStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__CHOSEN_LOGICAL_STEP, oldChosenLogicalStep, chosenLogicalStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextState getContextState() {
		return contextState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextState(ContextState newContextState, NotificationChain msgs) {
		ContextState oldContextState = contextState;
		contextState = newContextState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE, oldContextState, newContextState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextState(ContextState newContextState) {
		if (newContextState != contextState) {
			NotificationChain msgs = null;
			if (contextState != null)
				msgs = ((InternalEObject)contextState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE, null, msgs);
			if (newContextState != null)
				msgs = ((InternalEObject)newContextState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE, null, msgs);
			msgs = basicSetContextState(newContextState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE, newContextState, newContextState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice getPreviousChoice() {
		if (previousChoice != null && previousChoice.eIsProxy()) {
			InternalEObject oldPreviousChoice = (InternalEObject)previousChoice;
			previousChoice = (Choice)eResolveProxy(oldPreviousChoice);
			if (previousChoice != oldPreviousChoice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE, oldPreviousChoice, previousChoice));
			}
		}
		return previousChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice basicGetPreviousChoice() {
		return previousChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreviousChoice(Choice newPreviousChoice, NotificationChain msgs) {
		Choice oldPreviousChoice = previousChoice;
		previousChoice = newPreviousChoice;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE, oldPreviousChoice, newPreviousChoice);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousChoice(Choice newPreviousChoice) {
		if (newPreviousChoice != previousChoice) {
			NotificationChain msgs = null;
			if (previousChoice != null)
				msgs = ((InternalEObject)previousChoice).eInverseRemove(this, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE, Choice.class, msgs);
			if (newPreviousChoice != null)
				msgs = ((InternalEObject)newPreviousChoice).eInverseAdd(this, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE, Choice.class, msgs);
			msgs = basicSetPreviousChoice(newPreviousChoice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE, newPreviousChoice, newPreviousChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE:
				if (nextChoice != null)
					msgs = ((InternalEObject)nextChoice).eInverseRemove(this, Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE, Choice.class, msgs);
				return basicSetNextChoice((Choice)otherEnd, msgs);
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				if (previousChoice != null)
					msgs = ((InternalEObject)previousChoice).eInverseRemove(this, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE, Choice.class, msgs);
				return basicSetPreviousChoice((Choice)otherEnd, msgs);
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE:
				return basicSetNextChoice(null, msgs);
			case Gemoc_execution_tracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				return ((InternalEList<?>)getPossibleLogicalSteps()).basicRemove(otherEnd, msgs);
			case Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE:
				return basicSetContextState(null, msgs);
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				return basicSetPreviousChoice(null, msgs);
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE:
				if (resolve) return getNextChoice();
				return basicGetNextChoice();
			case Gemoc_execution_tracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				return getPossibleLogicalSteps();
			case Gemoc_execution_tracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				if (resolve) return getChosenLogicalStep();
				return basicGetChosenLogicalStep();
			case Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE:
				return getContextState();
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				if (resolve) return getPreviousChoice();
				return basicGetPreviousChoice();
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE:
				setNextChoice((Choice)newValue);
				return;
			case Gemoc_execution_tracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				getPossibleLogicalSteps().clear();
				getPossibleLogicalSteps().addAll((Collection<? extends LogicalStep>)newValue);
				return;
			case Gemoc_execution_tracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				setChosenLogicalStep((LogicalStep)newValue);
				return;
			case Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE:
				setContextState((ContextState)newValue);
				return;
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				setPreviousChoice((Choice)newValue);
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE:
				setNextChoice((Choice)null);
				return;
			case Gemoc_execution_tracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				getPossibleLogicalSteps().clear();
				return;
			case Gemoc_execution_tracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				setChosenLogicalStep((LogicalStep)null);
				return;
			case Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE:
				setContextState((ContextState)null);
				return;
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				setPreviousChoice((Choice)null);
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICE:
				return nextChoice != null;
			case Gemoc_execution_tracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				return possibleLogicalSteps != null && !possibleLogicalSteps.isEmpty();
			case Gemoc_execution_tracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				return chosenLogicalStep != null;
			case Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE:
				return contextState != null;
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				return previousChoice != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceImpl
