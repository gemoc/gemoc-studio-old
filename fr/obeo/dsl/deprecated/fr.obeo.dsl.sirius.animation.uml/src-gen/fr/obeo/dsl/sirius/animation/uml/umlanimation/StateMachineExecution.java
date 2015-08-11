/**
 */
package fr.obeo.dsl.sirius.animation.uml.umlanimation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getCurrent <em>Current</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getCandidates <em>Candidates</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage#getStateMachineExecution()
 * @model
 * @generated
 */
public interface StateMachineExecution extends EObject {
	/**
	 * Returns the value of the '<em><b>Statemachine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statemachine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statemachine</em>' reference.
	 * @see #setStatemachine(StateMachine)
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage#getStateMachineExecution_Statemachine()
	 * @model required="true"
	 * @generated
	 */
	StateMachine getStatemachine();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getStatemachine <em>Statemachine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statemachine</em>' reference.
	 * @see #getStatemachine()
	 * @generated
	 */
	void setStatemachine(StateMachine value);

	/**
	 * Returns the value of the '<em><b>Current</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current</em>' reference.
	 * @see #setCurrent(State)
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage#getStateMachineExecution_Current()
	 * @model required="true"
	 * @generated
	 */
	State getCurrent();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution#getCurrent <em>Current</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current</em>' reference.
	 * @see #getCurrent()
	 * @generated
	 */
	void setCurrent(State value);

	/**
	 * Returns the value of the '<em><b>Candidates</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidates</em>' reference list.
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage#getStateMachineExecution_Candidates()
	 * @model
	 * @generated
	 */
	EList<State> getCandidates();

} // StateMachineExecution
