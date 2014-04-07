/**
 */
package GemocExecutionEngineTrace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Logical Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link GemocExecutionEngineTrace.ExecutionLogicalStep#getEventOccurences <em>Event Occurences</em>}</li>
 * </ul>
 * </p>
 *
 * @see GemocExecutionEngineTrace.GemocExecutionEngineTracePackage#getExecutionLogicalStep()
 * @model
 * @generated
 */
public interface ExecutionLogicalStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Occurences</b></em>' containment reference list.
	 * The list contents are of type {@link GemocExecutionEngineTrace.EventOccurence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Occurences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Occurences</em>' containment reference list.
	 * @see GemocExecutionEngineTrace.GemocExecutionEngineTracePackage#getExecutionLogicalStep_EventOccurences()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventOccurence> getEventOccurences();

} // ExecutionLogicalStep
