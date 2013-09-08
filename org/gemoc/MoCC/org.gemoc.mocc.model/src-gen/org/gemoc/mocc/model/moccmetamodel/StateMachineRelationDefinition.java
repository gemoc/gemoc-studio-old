/**
 */
package org.gemoc.mocc.model.moccmetamodel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ExternalRelationDefinition;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine Relation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getOwnedStates <em>Owned States</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getOwnedTransitions <em>Owned Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getFinalState <em>Final State</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getClassicalExpressions <em>Classical Expressions</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getConcreteEntities <em>Concrete Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getStateMachineRelationDefinition()
 * @model
 * @generated
 */
public interface StateMachineRelationDefinition extends ExternalRelationDefinition {
	/**
	 * Returns the value of the '<em><b>Owned States</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.model.moccmetamodel.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned States</em>' containment reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getStateMachineRelationDefinition_OwnedStates()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getOwnedStates();

	/**
	 * Returns the value of the '<em><b>Owned Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.model.moccmetamodel.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Transitions</em>' containment reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getStateMachineRelationDefinition_OwnedTransitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getOwnedTransitions();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getStateMachineRelationDefinition_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.model.moccmetamodel.StateMachineRelationDefinition#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Final State</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.model.moccmetamodel.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final State</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final State</em>' reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getStateMachineRelationDefinition_FinalState()
	 * @model
	 * @generated
	 */
	EList<State> getFinalState();

	/**
	 * Returns the value of the '<em><b>Classical Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classical Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classical Expressions</em>' containment reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getStateMachineRelationDefinition_ClassicalExpressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassicalExpression> getClassicalExpressions();

	/**
	 * Returns the value of the '<em><b>Concrete Entities</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Entities</em>' containment reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getStateMachineRelationDefinition_ConcreteEntities()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConcreteEntity> getConcreteEntities();

} // StateMachineRelationDefinition
