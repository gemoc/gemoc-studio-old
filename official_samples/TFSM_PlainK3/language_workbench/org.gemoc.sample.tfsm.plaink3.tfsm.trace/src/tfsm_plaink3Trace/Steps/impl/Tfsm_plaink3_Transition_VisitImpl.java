/**
 */
package tfsm_plaink3Trace.Steps.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.tfsm_plaink3.Transition;

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
 *   <li>{@link tfsm_plaink3Trace.Steps.impl.Tfsm_plaink3_Transition_VisitImpl#getSubSteps <em>Sub Steps</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Tfsm_plaink3_Transition_VisitImpl extends BigStepImpl implements Tfsm_plaink3_Transition_Visit {
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
	public Transition getCaller() {
		return (org.gemoc.sample.tfsm_plaink3.Transition) this.getMse().getCaller();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StepsPackage.TFSM_PLAINK3_TRANSITION_VISIT___GET_CALLER:
				return getCaller();
		}
		return super.eInvoke(operationID, arguments);
	}

} //Tfsm_plaink3_Transition_VisitImpl
