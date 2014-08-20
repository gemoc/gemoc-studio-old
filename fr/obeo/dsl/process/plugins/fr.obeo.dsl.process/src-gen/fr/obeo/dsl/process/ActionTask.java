/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.common.util.EList;

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
	 * Sets the value of the '{@link fr.obeo.dsl.process.ActionTask#isMultipleExecution <em>Multiple Execution</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiple Execution</em>' attribute.
	 * @see #isMultipleExecution()
	 * @generated
	 */
	void setMultipleExecution(boolean value);

	/**
	 * Returns the value of the '<em><b>Written Variables</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.process.ProcessVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of {@link ProcessVariable} whose values are modified  by this {@link Task}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Written Variables</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getActionTask_WrittenVariables()
	 * @model
	 * @generated
	 */
	EList<ProcessVariable> getWrittenVariables();

	/**
	 * Returns the value of the '<em><b>Observed Variables</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.process.ProcessVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of {@link ProcessVariable} that are read by this {@link Task}. If a change occurs on the ProcessVariable the Task is supposed to be interrested  by a notification of this change.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Observed Variables</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getActionTask_ObservedVariables()
	 * @model
	 * @generated
	 */
	EList<ProcessVariable> getObservedVariables();

	/**
	 * Returns the value of the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Class Name</em>' attribute.
	 * @see #setInstanceClassName(String)
	 * @see fr.obeo.dsl.process.ProcessPackage#getActionTask_InstanceClassName()
	 * @model
	 * @generated
	 */
	String getInstanceClassName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.ActionTask#getInstanceClassName <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Class Name</em>' attribute.
	 * @see #getInstanceClassName()
	 * @generated
	 */
	void setInstanceClassName(String value);

} // ActionTask
