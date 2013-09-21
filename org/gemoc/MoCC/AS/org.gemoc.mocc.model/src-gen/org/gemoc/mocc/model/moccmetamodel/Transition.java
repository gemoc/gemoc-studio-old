/**
 */
package org.gemoc.mocc.model.moccmetamodel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BooleanExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.Transition#getGuard <em>Guard</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.Transition#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.gemoc.mocc.model.moccmetamodel.Transition#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.model.moccmetamodel.State#getOutputTransitions <em>Output Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(State)
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTransition_Source()
	 * @see org.gemoc.mocc.model.moccmetamodel.State#getOutputTransitions
	 * @model opposite="outputTransitions" required="true"
	 * @generated
	 */
	State getSource();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(State value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.model.moccmetamodel.State#getInputTransitions <em>Input Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTransition_Target()
	 * @see org.gemoc.mocc.model.moccmetamodel.State#getInputTransitions
	 * @model opposite="inputTransitions" required="true"
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' reference.
	 * @see #setGuard(BooleanExpression)
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTransition_Guard()
	 * @model
	 * @generated
	 */
	BooleanExpression getGuard();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getGuard <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(BooleanExpression value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' containment reference.
	 * @see #setTrigger(Trigger)
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTransition_Trigger()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Trigger getTrigger();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.model.moccmetamodel.Transition#getTrigger <em>Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' containment reference.
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(Trigger value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.model.moccmetamodel.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.gemoc.mocc.model.moccmetamodel.MoccmetamodelPackage#getTransition_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

} // Transition
