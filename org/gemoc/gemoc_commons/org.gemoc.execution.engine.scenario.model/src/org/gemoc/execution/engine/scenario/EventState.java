/**
 */
package org.gemoc.execution.engine.scenario;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.scenario.EventState#isIsForced <em>Is Forced</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.scenario.EventState#getClock <em>Clock</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.scenario.ScenarioPackage#getEventState()
 * @model
 * @generated
 */
public interface EventState extends EObject {
	/**
	 * Returns the value of the '<em><b>Is Forced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Forced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Forced</em>' attribute.
	 * @see #setIsForced(boolean)
	 * @see org.gemoc.execution.engine.scenario.ScenarioPackage#getEventState_IsForced()
	 * @model
	 * @generated
	 */
	boolean isIsForced();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.scenario.EventState#isIsForced <em>Is Forced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Forced</em>' attribute.
	 * @see #isIsForced()
	 * @generated
	 */
	void setIsForced(boolean value);

	/**
	 * Returns the value of the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock</em>' reference.
	 * @see #setClock(Clock)
	 * @see org.gemoc.execution.engine.scenario.ScenarioPackage#getEventState_Clock()
	 * @model required="true"
	 * @generated
	 */
	Clock getClock();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.scenario.EventState#getClock <em>Clock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock</em>' reference.
	 * @see #getClock()
	 * @generated
	 */
	void setClock(Clock value);

} // EventState
