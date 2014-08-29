/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Composed Task</b></em>'. <!--
 * end-user-doc --> <!-- begin-model-doc --> A {@link Task} composed of other {@link Task}. <!-- end-model-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.ComposedTask#getTasks <em>Tasks</em>}</li>
 * <li>{@link fr.obeo.dsl.process.ComposedTask#getInitialTasks <em>Initial Tasks</em>}</li>
 * <li>{@link fr.obeo.dsl.process.ComposedTask#getFinalTasks <em>Final Tasks</em>}</li>
 * <li>{@link fr.obeo.dsl.process.ComposedTask#getDoneExpression <em>Done Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getComposedTask()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='PathExistance'"
 * @generated
 */
public interface ComposedTask extends Task {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list. The list contents are of
	 * type {@link fr.obeo.dsl.process.Task}. It is bidirectional and its opposite is '
	 * {@link fr.obeo.dsl.process.Task#getParentTask <em>Parent Task</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> {@link Task Tasks} composing this {@link Task}. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getComposedTask_Tasks()
	 * @see fr.obeo.dsl.process.Task#getParentTask
	 * @model opposite="parentTask" containment="true" required="true"
	 * @generated
	 */
	EList<Task> getTasks();

	/**
	 * Returns the value of the '<em><b>Initial Tasks</b></em>' reference list. The list contents are of type
	 * {@link fr.obeo.dsl.process.Task}. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc
	 * --> Initial {@link Task} that can be used as starting point for this {@link ComposedTask}. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Initial Tasks</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getComposedTask_InitialTasks()
	 * @model required="true"
	 * @generated
	 */
	EList<Task> getInitialTasks();

	/**
	 * Returns the value of the '<em><b>Final Tasks</b></em>' reference list. The list contents are of type
	 * {@link fr.obeo.dsl.process.Task}. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc
	 * --> Final {@link Task} that can be used in {@link ComposedTask#getdoneExpresion() done expression} to
	 * mark this {@link ComposedTask} as {@link ComposedTask#isDone() done}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Final Tasks</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getComposedTask_FinalTasks()
	 * @model required="true"
	 * @generated
	 */
	EList<Task> getFinalTasks();

	/**
	 * Returns the value of the '<em><b>Done Expression</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc --> <!-- begin-model-doc --> An {@link Expression} telling when the
	 * {@link ComposedTask} can be considered {@link ComposedTask#isDone() done}. {@link Tasks} used in the
	 * {@link Expression} must be {@link ComposedTask#getfinalTasks() final tasks}. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Done Expression</em>' containment reference.
	 * @see #setDoneExpression(Expression)
	 * @see fr.obeo.dsl.process.ProcessPackage#getComposedTask_DoneExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getDoneExpression();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.ComposedTask#getDoneExpression
	 * <em>Done Expression</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Done Expression</em>' containment reference.
	 * @see #getDoneExpression()
	 * @generated
	 */
	void setDoneExpression(Expression value);

} // ComposedTask
