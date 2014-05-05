/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tasks Expression</b></em>'. <!--
 * end-user-doc --> <!-- begin-model-doc --> {@link Expression} based on {@link Task}. <!-- end-model-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.TasksExpression#getTasks <em>Tasks</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getTasksExpression()
 * @model interface="true" abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='IsPrecedingTask'"
 * @generated
 */
public interface TasksExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' reference list. The list contents are of type
	 * {@link fr.obeo.dsl.process.Task}. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc
	 * --> {@link Task Tasks} used to {@link TasksExpression#check() check} this {@link TasksExpression}. <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Tasks</em>' reference list.
	 * @see fr.obeo.dsl.process.ProcessPackage#getTasksExpression_Tasks()
	 * @model required="true"
	 * @generated
	 */
	EList<Task> getTasks();

} // TasksExpression
