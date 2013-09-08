/**
 */
package org.gemoc.mocc.model.moccmetamodel.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.impl.ExternalRelationDefinitionImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage;
import org.gemoc.mocc.model.moccmetamodel.State;
import org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition;
import org.gemoc.mocc.model.moccmetamodel.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine Relation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl#getOwnedTransitions <em>Owned Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl#getFinalState <em>Final State</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl#getClassicalExpressions <em>Classical Expressions</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.impl.StateMachineRelationDefinitionImpl#getConcreteEntities <em>Concrete Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMachineRelationDefinitionImpl extends ExternalRelationDefinitionImpl implements StateMachineRelationDefinition {
	/**
	 * The cached value of the '{@link #getOwnedStates() <em>Owned States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> ownedStates;

	/**
	 * The cached value of the '{@link #getOwnedTransitions() <em>Owned Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> ownedTransitions;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected State initialState;

	/**
	 * The cached value of the '{@link #getFinalState() <em>Final State</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalState()
	 * @generated
	 * @ordered
	 */
	protected EList<State> finalState;

	/**
	 * The cached value of the '{@link #getClassicalExpressions() <em>Classical Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassicalExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassicalExpression> classicalExpressions;

	/**
	 * The cached value of the '{@link #getConcreteEntities() <em>Concrete Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConcreteEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<ConcreteEntity> concreteEntities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineRelationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MoccmetamodelPackage.Literals.STATE_MACHINE_RELATION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getOwnedStates() {
		if (ownedStates == null) {
			ownedStates = new EObjectContainmentEList<State>(State.class, this, MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES);
		}
		return ownedStates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOwnedTransitions() {
		if (ownedTransitions == null) {
			ownedTransitions = new EObjectContainmentEList<Transition>(Transition.class, this, MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS);
		}
		return ownedTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject)initialState;
			initialState = (State)eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(State newInitialState) {
		State oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getFinalState() {
		if (finalState == null) {
			finalState = new EObjectResolvingEList<State>(State.class, this, MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE);
		}
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassicalExpression> getClassicalExpressions() {
		if (classicalExpressions == null) {
			classicalExpressions = new EObjectContainmentEList<ClassicalExpression>(ClassicalExpression.class, this, MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS);
		}
		return classicalExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConcreteEntity> getConcreteEntities() {
		if (concreteEntities == null) {
			concreteEntities = new EObjectContainmentEList<ConcreteEntity>(ConcreteEntity.class, this, MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES);
		}
		return concreteEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES:
				return ((InternalEList<?>)getOwnedStates()).basicRemove(otherEnd, msgs);
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS:
				return ((InternalEList<?>)getOwnedTransitions()).basicRemove(otherEnd, msgs);
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				return ((InternalEList<?>)getClassicalExpressions()).basicRemove(otherEnd, msgs);
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				return ((InternalEList<?>)getConcreteEntities()).basicRemove(otherEnd, msgs);
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
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES:
				return getOwnedStates();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS:
				return getOwnedTransitions();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE:
				return getFinalState();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				return getClassicalExpressions();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				return getConcreteEntities();
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
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES:
				getOwnedStates().clear();
				getOwnedStates().addAll((Collection<? extends State>)newValue);
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS:
				getOwnedTransitions().clear();
				getOwnedTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE:
				setInitialState((State)newValue);
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE:
				getFinalState().clear();
				getFinalState().addAll((Collection<? extends State>)newValue);
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				getClassicalExpressions().clear();
				getClassicalExpressions().addAll((Collection<? extends ClassicalExpression>)newValue);
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				getConcreteEntities().clear();
				getConcreteEntities().addAll((Collection<? extends ConcreteEntity>)newValue);
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
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES:
				getOwnedStates().clear();
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS:
				getOwnedTransitions().clear();
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE:
				setInitialState((State)null);
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE:
				getFinalState().clear();
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				getClassicalExpressions().clear();
				return;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				getConcreteEntities().clear();
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
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_STATES:
				return ownedStates != null && !ownedStates.isEmpty();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__OWNED_TRANSITIONS:
				return ownedTransitions != null && !ownedTransitions.isEmpty();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__INITIAL_STATE:
				return initialState != null;
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__FINAL_STATE:
				return finalState != null && !finalState.isEmpty();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CLASSICAL_EXPRESSIONS:
				return classicalExpressions != null && !classicalExpressions.isEmpty();
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION__CONCRETE_ENTITIES:
				return concreteEntities != null && !concreteEntities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateMachineRelationDefinitionImpl
