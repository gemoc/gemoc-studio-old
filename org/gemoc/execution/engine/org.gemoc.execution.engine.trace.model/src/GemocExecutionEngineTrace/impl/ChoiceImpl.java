/**
 */
package GemocExecutionEngineTrace.impl;

import GemocExecutionEngineTrace.Choice;
import GemocExecutionEngineTrace.ExecutionLogicalStep;
import GemocExecutionEngineTrace.GemocExecutionEngineTracePackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link GemocExecutionEngineTrace.impl.ChoiceImpl#getNextChoice <em>Next Choice</em>}</li>
 *   <li>{@link GemocExecutionEngineTrace.impl.ChoiceImpl#getPossibleLogicalSteps <em>Possible Logical Steps</em>}</li>
 *   <li>{@link GemocExecutionEngineTrace.impl.ChoiceImpl#getChosenLogicalStep <em>Chosen Logical Step</em>}</li>
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
	protected EList<ExecutionLogicalStep> possibleLogicalSteps;

	/**
	 * The cached value of the '{@link #getChosenLogicalStep() <em>Chosen Logical Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChosenLogicalStep()
	 * @generated
	 * @ordered
	 */
	protected ExecutionLogicalStep chosenLogicalStep;

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
		return GemocExecutionEngineTracePackage.Literals.CHOICE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GemocExecutionEngineTracePackage.CHOICE__NEXT_CHOICE, oldNextChoice, nextChoice));
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
	public void setNextChoice(Choice newNextChoice) {
		Choice oldNextChoice = nextChoice;
		nextChoice = newNextChoice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GemocExecutionEngineTracePackage.CHOICE__NEXT_CHOICE, oldNextChoice, nextChoice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionLogicalStep> getPossibleLogicalSteps() {
		if (possibleLogicalSteps == null) {
			possibleLogicalSteps = new EObjectContainmentEList<ExecutionLogicalStep>(ExecutionLogicalStep.class, this, GemocExecutionEngineTracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS);
		}
		return possibleLogicalSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionLogicalStep getChosenLogicalStep() {
		if (chosenLogicalStep != null && chosenLogicalStep.eIsProxy()) {
			InternalEObject oldChosenLogicalStep = (InternalEObject)chosenLogicalStep;
			chosenLogicalStep = (ExecutionLogicalStep)eResolveProxy(oldChosenLogicalStep);
			if (chosenLogicalStep != oldChosenLogicalStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GemocExecutionEngineTracePackage.CHOICE__CHOSEN_LOGICAL_STEP, oldChosenLogicalStep, chosenLogicalStep));
			}
		}
		return chosenLogicalStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionLogicalStep basicGetChosenLogicalStep() {
		return chosenLogicalStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChosenLogicalStep(ExecutionLogicalStep newChosenLogicalStep) {
		ExecutionLogicalStep oldChosenLogicalStep = chosenLogicalStep;
		chosenLogicalStep = newChosenLogicalStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GemocExecutionEngineTracePackage.CHOICE__CHOSEN_LOGICAL_STEP, oldChosenLogicalStep, chosenLogicalStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				return ((InternalEList<?>)getPossibleLogicalSteps()).basicRemove(otherEnd, msgs);
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
			case GemocExecutionEngineTracePackage.CHOICE__NEXT_CHOICE:
				if (resolve) return getNextChoice();
				return basicGetNextChoice();
			case GemocExecutionEngineTracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				return getPossibleLogicalSteps();
			case GemocExecutionEngineTracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				if (resolve) return getChosenLogicalStep();
				return basicGetChosenLogicalStep();
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
			case GemocExecutionEngineTracePackage.CHOICE__NEXT_CHOICE:
				setNextChoice((Choice)newValue);
				return;
			case GemocExecutionEngineTracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				getPossibleLogicalSteps().clear();
				getPossibleLogicalSteps().addAll((Collection<? extends ExecutionLogicalStep>)newValue);
				return;
			case GemocExecutionEngineTracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				setChosenLogicalStep((ExecutionLogicalStep)newValue);
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
			case GemocExecutionEngineTracePackage.CHOICE__NEXT_CHOICE:
				setNextChoice((Choice)null);
				return;
			case GemocExecutionEngineTracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				getPossibleLogicalSteps().clear();
				return;
			case GemocExecutionEngineTracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				setChosenLogicalStep((ExecutionLogicalStep)null);
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
			case GemocExecutionEngineTracePackage.CHOICE__NEXT_CHOICE:
				return nextChoice != null;
			case GemocExecutionEngineTracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS:
				return possibleLogicalSteps != null && !possibleLogicalSteps.isEmpty();
			case GemocExecutionEngineTracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				return chosenLogicalStep != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceImpl
