/**
 */
package fr.obeo.dsl.process.util;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.AllDone;
import fr.obeo.dsl.process.And;
import fr.obeo.dsl.process.AnyDone;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.Expression;
import fr.obeo.dsl.process.Not;
import fr.obeo.dsl.process.OneDone;
import fr.obeo.dsl.process.Or;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.process.TasksExpression;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the
 * model, starting with the actual class of the object and proceeding up the inheritance hierarchy until a
 * non-null result is returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.process.ProcessPackage
 * @generated
 */
public class ProcessSwitch<T> extends Switch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ProcessPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessSwitch() {
		if (modelPackage == null) {
			modelPackage = ProcessPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields
	 * that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ProcessPackage.PROCESS: {
				fr.obeo.dsl.process.Process process = (fr.obeo.dsl.process.Process)theEObject;
				T result = caseProcess(process);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TASK: {
				Task task = (Task)theEObject;
				T result = caseTask(task);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PROCESS_VARIABLE: {
				ProcessVariable processVariable = (ProcessVariable)theEObject;
				T result = caseProcessVariable(processVariable);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.COMPOSED_TASK: {
				ComposedTask composedTask = (ComposedTask)theEObject;
				T result = caseComposedTask(composedTask);
				if (result == null)
					result = caseTask(composedTask);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ACTION_TASK: {
				ActionTask actionTask = (ActionTask)theEObject;
				T result = caseActionTask(actionTask);
				if (result == null)
					result = caseTask(actionTask);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TASKS_EXPRESSION: {
				TasksExpression tasksExpression = (TasksExpression)theEObject;
				T result = caseTasksExpression(tasksExpression);
				if (result == null)
					result = caseExpression(tasksExpression);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ALL_DONE: {
				AllDone allDone = (AllDone)theEObject;
				T result = caseAllDone(allDone);
				if (result == null)
					result = caseTasksExpression(allDone);
				if (result == null)
					result = caseExpression(allDone);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ANY_DONE: {
				AnyDone anyDone = (AnyDone)theEObject;
				T result = caseAnyDone(anyDone);
				if (result == null)
					result = caseTasksExpression(anyDone);
				if (result == null)
					result = caseExpression(anyDone);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.ONE_DONE: {
				OneDone oneDone = (OneDone)theEObject;
				T result = caseOneDone(oneDone);
				if (result == null)
					result = caseTasksExpression(oneDone);
				if (result == null)
					result = caseExpression(oneDone);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.NOT: {
				Not not = (Not)theEObject;
				T result = caseNot(not);
				if (result == null)
					result = caseExpression(not);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.AND: {
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null)
					result = caseExpression(and);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.OR: {
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null)
					result = caseExpression(or);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PROCESS_CONTEXT: {
				ProcessContext processContext = (ProcessContext)theEObject;
				T result = caseProcessContext(processContext);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PROCESS_VARIABLE_TO_OBJECT_MAP: {
				@SuppressWarnings("unchecked")
				Map.Entry<ProcessVariable, Object> processVariableToObjectMap = (Map.Entry<ProcessVariable, Object>)theEObject;
				T result = caseProcessVariableToObjectMap(processVariableToObjectMap);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcess(fr.obeo.dsl.process.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTask(Task object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessVariable(ProcessVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composed Task</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composed Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComposedTask(ComposedTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Task</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionTask(ActionTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tasks Expression</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tasks Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTasksExpression(TasksExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Done</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Done</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllDone(AllDone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Done</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Done</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyDone(AnyDone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>One Done</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>One Done</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOneDone(OneDone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNot(Not object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnd(And object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOr(Or object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessContext(ProcessContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable To Object Map</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable To Object Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessVariableToObjectMap(Map.Entry<ProcessVariable, Object> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch, but this
	 * is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // ProcessSwitch
