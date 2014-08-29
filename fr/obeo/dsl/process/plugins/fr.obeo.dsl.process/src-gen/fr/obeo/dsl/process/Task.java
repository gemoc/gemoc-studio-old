/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Task</b></em>'. <!-- end-user-doc -->
 * <!-- begin-model-doc --> A task represent a function to be performed. <!-- end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.Task#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.process.Task#getId <em>Id</em>}</li>
 * <li>{@link fr.obeo.dsl.process.Task#getDescription <em>Description</em>}</li>
 * <li>{@link fr.obeo.dsl.process.Task#getParentTask <em>Parent Task</em>}</li>
 * <li>{@link fr.obeo.dsl.process.Task#getPrecedingTasks <em>Preceding Tasks</em>}</li>
 * <li>{@link fr.obeo.dsl.process.Task#getFollowingTasks <em>Following Tasks</em>}</li>
 * <li>{@link fr.obeo.dsl.process.Task#getPrecondition <em>Precondition</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getTask()
 * @model interface="true" abstract="true" annotation=
 *        "http://www.eclipse.org/emf/2002/Ecore constraints='Reachable DeadEnd PrecedingTasksAtSameLevel FollowingTasksAtSameLevel PreconditionTasksArePreceding'"
 * @generated
 */
public interface Task extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. The default value is <code>""</code>. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> An human readable name for this
	 * {@link Task}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.process.ProcessPackage#getTask_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.Task#getName <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * <!-- begin-model-doc --> An identifier identifying the {@link Task} at its current level (not
	 * globally). <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see fr.obeo.dsl.process.ProcessPackage#getTask_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.Task#getId <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> An human readable description for this {@link Task}. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see fr.obeo.dsl.process.ProcessPackage#getTask_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.Task#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Parent Task</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link fr.obeo.dsl.process.ComposedTask#getTasks <em>Tasks</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The {@link ComposedTask} containing this {@link Task} if
	 * any, <code>null</code> otherwise. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Parent Task</em>' container reference.
	 * @see #setParentTask(ComposedTask)
	 * @see fr.obeo.dsl.process.ProcessPackage#getTask_ParentTask()
	 * @see fr.obeo.dsl.process.ComposedTask#getTasks
	 * @model opposite="tasks" transient="false"
	 * @generated
	 */
	ComposedTask getParentTask();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.Task#getParentTask <em>Parent Task</em>}' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Parent Task</em>' container reference.
	 * @see #getParentTask()
	 * @generated
	 */
	void setParentTask(ComposedTask value);

	/**
	 * Returns the value of the '<em><b>Preceding Tasks</b></em>' reference list. The list contents are of
	 * type {@link fr.obeo.dsl.process.Task}. It is bidirectional and its opposite is '
	 * {@link fr.obeo.dsl.process.Task#getFollowingTasks <em>Following Tasks</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> {@link Task Tasks} preceding this {@link Task}. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Preceding Tasks</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getTask_PrecedingTasks()
	 * @see fr.obeo.dsl.process.Task#getFollowingTasks
	 * @model opposite="followingTasks"
	 * @generated
	 */
	EList<Task> getPrecedingTasks();

	/**
	 * Returns the value of the '<em><b>Following Tasks</b></em>' reference list. The list contents are of
	 * type {@link fr.obeo.dsl.process.Task}. It is bidirectional and its opposite is '
	 * {@link fr.obeo.dsl.process.Task#getPrecedingTasks <em>Preceding Tasks</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> {@link Task Tasks} following this {@link Task}. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Following Tasks</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getTask_FollowingTasks()
	 * @see fr.obeo.dsl.process.Task#getPrecedingTasks
	 * @model opposite="precedingTasks"
	 * @generated
	 */
	EList<Task> getFollowingTasks();

	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> The precondition allowing this {@link Task} to start. If
	 * <code>null</code> the {@link Task} can be started. {@link Tasks} used in the {@link Expression} must be
	 * in the {@link Task#getprecedingTasks() preceding tasks} or this {@link Tasks} be in the
	 * {@link Task#getParent() parent task} {@link ComposedTask#getInitialTasks() initial tasks} and the
	 * {@link Task} in {@link Task#getprecedingTasks() preceding tasks} of the {@link Task#getParent() parent
	 * task}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Precondition</em>' containment reference.
	 * @see #setPrecondition(Expression)
	 * @see fr.obeo.dsl.process.ProcessPackage#getTask_Precondition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getPrecondition();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.Task#getPrecondition <em>Precondition</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Precondition</em>' containment reference.
	 * @see #getPrecondition()
	 * @generated
	 */
	void setPrecondition(Expression value);

} // Task
