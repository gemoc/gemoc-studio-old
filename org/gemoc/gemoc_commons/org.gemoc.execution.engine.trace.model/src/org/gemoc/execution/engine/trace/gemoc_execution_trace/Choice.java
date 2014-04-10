/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace;

import fr.inria.aoste.trace.LogicalStep;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getNextChoice <em>Next Choice</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getPossibleLogicalSteps <em>Possible Logical Steps</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getChosenLogicalStep <em>Chosen Logical Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends EObject {
	/**
	 * Returns the value of the '<em><b>Next Choice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Choice</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Choice</em>' reference.
	 * @see #setNextChoice(Choice)
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getChoice_NextChoice()
	 * @model
	 * @generated
	 */
	Choice getNextChoice();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getNextChoice <em>Next Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Choice</em>' reference.
	 * @see #getNextChoice()
	 * @generated
	 */
	void setNextChoice(Choice value);

	/**
	 * Returns the value of the '<em><b>Possible Logical Steps</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.aoste.trace.LogicalStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible Logical Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Logical Steps</em>' containment reference list.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getChoice_PossibleLogicalSteps()
	 * @model containment="true"
	 * @generated
	 */
	EList<LogicalStep> getPossibleLogicalSteps();

	/**
	 * Returns the value of the '<em><b>Chosen Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosen Logical Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Logical Step</em>' reference.
	 * @see #setChosenLogicalStep(LogicalStep)
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#getChoice_ChosenLogicalStep()
	 * @model
	 * @generated
	 */
	LogicalStep getChosenLogicalStep();

	/**
	 * Sets the value of the '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice#getChosenLogicalStep <em>Chosen Logical Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Logical Step</em>' reference.
	 * @see #getChosenLogicalStep()
	 * @generated
	 */
	void setChosenLogicalStep(LogicalStep value);

} // Choice
