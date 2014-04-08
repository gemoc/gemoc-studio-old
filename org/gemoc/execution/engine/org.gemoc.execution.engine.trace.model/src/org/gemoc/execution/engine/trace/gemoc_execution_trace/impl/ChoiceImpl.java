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
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage;

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
	public EList<LogicalStep> getPossibleLogicalSteps() {
		if (possibleLogicalSteps == null) {
			possibleLogicalSteps = new EObjectContainmentEList<LogicalStep>(LogicalStep.class, this, GemocExecutionEngineTracePackage.CHOICE__POSSIBLE_LOGICAL_STEPS);
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
				getPossibleLogicalSteps().addAll((Collection<? extends LogicalStep>)newValue);
				return;
			case GemocExecutionEngineTracePackage.CHOICE__CHOSEN_LOGICAL_STEP:
				setChosenLogicalStep((LogicalStep)newValue);
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
				setChosenLogicalStep((LogicalStep)null);
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
