/**
 */
package fr.obeo.dsl.process;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Action Task</b></em>'. <!--
 * end-user-doc --> <!-- begin-model-doc --> A {@link Task} performing any action. The
 * {@link ActionTask#getValidation() validation expression} is used to tell when the {@link ActionTask}
 * {@link ActionTask#isDone() is done}. Optionally an {@link ActionTask#getAction() action} can be specified
 * to be {@link ActionTask#execute() executed} to meet the {@link ActionTask#getValidation() validation
 * expression}. <!-- end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.ActionTask#getValidation <em>Validation</em>}</li>
 * <li>{@link fr.obeo.dsl.process.ActionTask#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getActionTask()
 * @model
 * @generated
 */
public interface ActionTask extends Task {

	/**
	 * Returns the value of the '<em><b>Multiple Execution</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Tells if
	 * this {@link ActionTask} can be {@link IProcessRunner#doAction(ProcessContext, ActionTask) done} many
	 * times. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Multiple Execution</em>' attribute.
	 * @see #setMultipleExecution(boolean)
	 * @see fr.obeo.dsl.process.ProcessPackage#getActionTask_MultipleExecution()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isMultipleExecution();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.ActionTask#isMultipleExecution
	 * <em>Multiple Execution</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Multiple Execution</em>' attribute.
	 * @see #isMultipleExecution()
	 * @generated
	 */
	void setMultipleExecution(boolean value);

} // ActionTask
