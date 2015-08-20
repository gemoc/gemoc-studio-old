/**
 */
package org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.EventState#getState <em>State</em>}</li>
 *   <li>{@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.EventState#getMse <em>Mse</em>}</li>
 * </ul>
 *
 * @see org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ScenarioPackage#getEventState()
 * @model
 * @generated
 */
public interface EventState extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.Future}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.Future
	 * @see #setState(Future)
	 * @see org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ScenarioPackage#getEventState_State()
	 * @model
	 * @generated
	 */
	Future getState();

	/**
	 * Sets the value of the '{@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.EventState#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.Future
	 * @see #getState()
	 * @generated
	 */
	void setState(Future value);

	/**
	 * Returns the value of the '<em><b>Mse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mse</em>' reference.
	 * @see #setMse(ModelSpecificEvent)
	 * @see org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ScenarioPackage#getEventState_Mse()
	 * @model required="true"
	 * @generated
	 */
	ModelSpecificEvent getMse();

	/**
	 * Sets the value of the '{@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.EventState#getMse <em>Mse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mse</em>' reference.
	 * @see #getMse()
	 * @generated
	 */
	void setMse(ModelSpecificEvent value);

} // EventState
