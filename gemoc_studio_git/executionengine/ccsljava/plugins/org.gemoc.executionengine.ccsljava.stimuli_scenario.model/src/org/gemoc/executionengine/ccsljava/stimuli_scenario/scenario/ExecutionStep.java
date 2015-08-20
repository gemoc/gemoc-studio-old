/**
 */
package org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ExecutionStep#getEventList <em>Event List</em>}</li>
 * </ul>
 *
 * @see org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ScenarioPackage#getExecutionStep()
 * @model
 * @generated
 */
public interface ExecutionStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Event List</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.EventState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event List</em>' containment reference list.
	 * @see org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ScenarioPackage#getExecutionStep_EventList()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventState> getEventList();

} // ExecutionStep
