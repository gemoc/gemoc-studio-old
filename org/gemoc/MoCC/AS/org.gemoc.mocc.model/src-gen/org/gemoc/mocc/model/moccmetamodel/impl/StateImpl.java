/**
 */
package org.gemoc.mocc.model.moccmetamodel.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.impl.NamedElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage;
import org.gemoc.mocc.model.moccmetamodel.State;
import org.gemoc.mocc.model.moccmetamodel.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.impl.StateImpl#getOutputTransitions <em>Output Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.impl.StateImpl#getInputTransitions <em>Input Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends NamedElementImpl implements State {
	/**
	 * The cached value of the '{@link #getOutputTransitions() <em>Output Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outputTransitions;

	/**
	 * The cached value of the '{@link #getInputTransitions() <em>Input Transitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> inputTransitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoccmetamodelPackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutputTransitions() {
		if (outputTransitions == null) {
			outputTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, MoccmetamodelPackage.STATE__OUTPUT_TRANSITIONS, MoccmetamodelPackage.TRANSITION__SOURCE);
		}
		return outputTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getInputTransitions() {
		if (inputTransitions == null) {
			inputTransitions = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, MoccmetamodelPackage.STATE__INPUT_TRANSITIONS, MoccmetamodelPackage.TRANSITION__TARGET);
		}
		return inputTransitions;
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
			case MoccmetamodelPackage.STATE__OUTPUT_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputTransitions()).basicAdd(otherEnd, msgs);
			case MoccmetamodelPackage.STATE__INPUT_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputTransitions()).basicAdd(otherEnd, msgs);
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
			case MoccmetamodelPackage.STATE__OUTPUT_TRANSITIONS:
				return ((InternalEList<?>)getOutputTransitions()).basicRemove(otherEnd, msgs);
			case MoccmetamodelPackage.STATE__INPUT_TRANSITIONS:
				return ((InternalEList<?>)getInputTransitions()).basicRemove(otherEnd, msgs);
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
			case MoccmetamodelPackage.STATE__OUTPUT_TRANSITIONS:
				return getOutputTransitions();
			case MoccmetamodelPackage.STATE__INPUT_TRANSITIONS:
				return getInputTransitions();
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
			case MoccmetamodelPackage.STATE__OUTPUT_TRANSITIONS:
				getOutputTransitions().clear();
				getOutputTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case MoccmetamodelPackage.STATE__INPUT_TRANSITIONS:
				getInputTransitions().clear();
				getInputTransitions().addAll((Collection<? extends Transition>)newValue);
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
			case MoccmetamodelPackage.STATE__OUTPUT_TRANSITIONS:
				getOutputTransitions().clear();
				return;
			case MoccmetamodelPackage.STATE__INPUT_TRANSITIONS:
				getInputTransitions().clear();
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
			case MoccmetamodelPackage.STATE__OUTPUT_TRANSITIONS:
				return outputTransitions != null && !outputTransitions.isEmpty();
			case MoccmetamodelPackage.STATE__INPUT_TRANSITIONS:
				return inputTransitions != null && !inputTransitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateImpl
