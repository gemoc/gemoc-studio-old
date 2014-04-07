/**
 */
package GemocExecutionEngineTrace;

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
 *   <li>{@link GemocExecutionEngineTrace.Choice#getNextChoice <em>Next Choice</em>}</li>
 *   <li>{@link GemocExecutionEngineTrace.Choice#getPossibleLogicalSteps <em>Possible Logical Steps</em>}</li>
 *   <li>{@link GemocExecutionEngineTrace.Choice#getChosenLogicalStep <em>Chosen Logical Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see GemocExecutionEngineTrace.GemocExecutionEngineTracePackage#getChoice()
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
	 * @see GemocExecutionEngineTrace.GemocExecutionEngineTracePackage#getChoice_NextChoice()
	 * @model
	 * @generated
	 */
	Choice getNextChoice();

	/**
	 * Sets the value of the '{@link GemocExecutionEngineTrace.Choice#getNextChoice <em>Next Choice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Choice</em>' reference.
	 * @see #getNextChoice()
	 * @generated
	 */
	void setNextChoice(Choice value);

	/**
	 * Returns the value of the '<em><b>Possible Logical Steps</b></em>' containment reference list.
	 * The list contents are of type {@link GemocExecutionEngineTrace.ExecutionLogicalStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible Logical Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Logical Steps</em>' containment reference list.
	 * @see GemocExecutionEngineTrace.GemocExecutionEngineTracePackage#getChoice_PossibleLogicalSteps()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionLogicalStep> getPossibleLogicalSteps();

	/**
	 * Returns the value of the '<em><b>Chosen Logical Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chosen Logical Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chosen Logical Step</em>' reference.
	 * @see #setChosenLogicalStep(ExecutionLogicalStep)
	 * @see GemocExecutionEngineTrace.GemocExecutionEngineTracePackage#getChoice_ChosenLogicalStep()
	 * @model
	 * @generated
	 */
	ExecutionLogicalStep getChosenLogicalStep();

	/**
	 * Sets the value of the '{@link GemocExecutionEngineTrace.Choice#getChosenLogicalStep <em>Chosen Logical Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chosen Logical Step</em>' reference.
	 * @see #getChosenLogicalStep()
	 * @generated
	 */
	void setChosenLogicalStep(ExecutionLogicalStep value);

} // Choice
