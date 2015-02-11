/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Branch;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getNextChoices <em>Next Choices</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getPossibleLogicalSteps <em>Possible Logical Steps</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getChosenLogicalStep <em>Chosen Logical Step</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getContextState <em>Context State</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getPreviousChoice <em>Previous Choice</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getSelectedNextChoice <em>Selected Next Choice</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ChoiceImpl#getBranch <em>Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceImpl extends MinimalEObjectImpl.Container implements Choice {
	/**
	 * The cached value of the '{@link #getNextChoices() <em>Next Choices</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextChoices()
	 * @generated
	 * @ordered
	 */
	protected EList<Choice> nextChoices;

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
	 * The cached value of the '{@link #getSelectedNextChoice() <em>Selected Next Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedNextChoice()
	 * @generated
	 * @ordered
	 */
	protected Choice selectedNextChoice;

	/**
	 * The cached value of the '{@link #getBranch() <em>Branch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranch()
	 * @generated
	 * @ordered
	 */
	protected Branch branch;

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
	public EList<Choice> getNextChoices() {
		if (nextChoices == null) {
			nextChoices = new EObjectWithInverseResolvingEList<Choice>(Choice.class, this, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES, Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE);
		}
		return nextChoices;
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
				msgs = ((InternalEObject)previousChoice).eInverseRemove(this, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES, Choice.class, msgs);
			if (newPreviousChoice != null)
				msgs = ((InternalEObject)newPreviousChoice).eInverseAdd(this, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES, Choice.class, msgs);
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
	public Choice getSelectedNextChoice() {
		if (selectedNextChoice != null && selectedNextChoice.eIsProxy()) {
			InternalEObject oldSelectedNextChoice = (InternalEObject)selectedNextChoice;
			selectedNextChoice = (Choice)eResolveProxy(oldSelectedNextChoice);
			if (selectedNextChoice != oldSelectedNextChoice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gemoc_execution_tracePackage.CHOICE__SELECTED_NEXT_CHOICE, oldSelectedNextChoice, selectedNextChoice));
			}
		}
		return selectedNextChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice basicGetSelectedNextChoice() {
		return selectedNextChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedNextChoice(Choice newSelectedNextChoice) {
		Choice oldSelectedNextChoice = selectedNextChoice;
		selectedNextChoice = newSelectedNextChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__SELECTED_NEXT_CHOICE, oldSelectedNextChoice, selectedNextChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch getBranch() {
		if (branch != null && branch.eIsProxy()) {
			InternalEObject oldBranch = (InternalEObject)branch;
			branch = (Branch)eResolveProxy(oldBranch);
			if (branch != oldBranch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gemoc_execution_tracePackage.CHOICE__BRANCH, oldBranch, branch));
			}
		}
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch basicGetBranch() {
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBranch(Branch newBranch, NotificationChain msgs) {
		Branch oldBranch = branch;
		branch = newBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__BRANCH, oldBranch, newBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranch(Branch newBranch) {
		if (newBranch != branch) {
			NotificationChain msgs = null;
			if (branch != null)
				msgs = ((InternalEObject)branch).eInverseRemove(this, Gemoc_execution_tracePackage.BRANCH__CHOICES, Branch.class, msgs);
			if (newBranch != null)
				msgs = ((InternalEObject)newBranch).eInverseAdd(this, Gemoc_execution_tracePackage.BRANCH__CHOICES, Branch.class, msgs);
			msgs = basicSetBranch(newBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.CHOICE__BRANCH, newBranch, newBranch));
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNextChoices()).basicAdd(otherEnd, msgs);
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				if (previousChoice != null)
					msgs = ((InternalEObject)previousChoice).eInverseRemove(this, Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES, Choice.class, msgs);
				return basicSetPreviousChoice((Choice)otherEnd, msgs);
			case Gemoc_execution_tracePackage.CHOICE__BRANCH:
				if (branch != null)
					msgs = ((InternalEObject)branch).eInverseRemove(this, Gemoc_execution_tracePackage.BRANCH__CHOICES, Branch.class, msgs);
				return basicSetBranch((Branch)otherEnd, msgs);
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES:
				return ((InternalEList<?>)getNextChoices()).basicRemove(otherEnd, msgs);
			case Gemoc_execution_tracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				return ((InternalEList<?>)getPossibleLogicalSteps()).basicRemove(otherEnd, msgs);
			case Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE:
				return basicSetContextState(null, msgs);
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				return basicSetPreviousChoice(null, msgs);
			case Gemoc_execution_tracePackage.CHOICE__BRANCH:
				return basicSetBranch(null, msgs);
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES:
				return getNextChoices();
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
			case Gemoc_execution_tracePackage.CHOICE__SELECTED_NEXT_CHOICE:
				if (resolve) return getSelectedNextChoice();
				return basicGetSelectedNextChoice();
			case Gemoc_execution_tracePackage.CHOICE__BRANCH:
				if (resolve) return getBranch();
				return basicGetBranch();
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES:
				getNextChoices().clear();
				getNextChoices().addAll((Collection<? extends Choice>)newValue);
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
			case Gemoc_execution_tracePackage.CHOICE__SELECTED_NEXT_CHOICE:
				setSelectedNextChoice((Choice)newValue);
				return;
			case Gemoc_execution_tracePackage.CHOICE__BRANCH:
				setBranch((Branch)newValue);
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES:
				getNextChoices().clear();
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
			case Gemoc_execution_tracePackage.CHOICE__SELECTED_NEXT_CHOICE:
				setSelectedNextChoice((Choice)null);
				return;
			case Gemoc_execution_tracePackage.CHOICE__BRANCH:
				setBranch((Branch)null);
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
			case Gemoc_execution_tracePackage.CHOICE__NEXT_CHOICES:
				return nextChoices != null && !nextChoices.isEmpty();
			case Gemoc_execution_tracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				return possibleLogicalSteps != null && !possibleLogicalSteps.isEmpty();
			case Gemoc_execution_tracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				return chosenLogicalStep != null;
			case Gemoc_execution_tracePackage.CHOICE__CONTEXT_STATE:
				return contextState != null;
			case Gemoc_execution_tracePackage.CHOICE__PREVIOUS_CHOICE:
				return previousChoice != null;
			case Gemoc_execution_tracePackage.CHOICE__SELECTED_NEXT_CHOICE:
				return selectedNextChoice != null;
			case Gemoc_execution_tracePackage.CHOICE__BRANCH:
				return branch != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceImpl
