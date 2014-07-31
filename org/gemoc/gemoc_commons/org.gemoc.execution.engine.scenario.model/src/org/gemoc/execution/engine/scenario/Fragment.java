/**
 */
package org.gemoc.execution.engine.scenario;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.scenario.Fragment#getStepList <em>Step List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.scenario.ScenarioPackage#getFragment()
 * @model
 * @generated
 */
public interface Fragment extends EObject {
	/**
	 * Returns the value of the '<em><b>Step List</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.execution.engine.scenario.ExecutionStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step List</em>' containment reference list.
	 * @see org.gemoc.execution.engine.scenario.ScenarioPackage#getFragment_StepList()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionStep> getStepList();

} // Fragment
