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

} // ActionTask
