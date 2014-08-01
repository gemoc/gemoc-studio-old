/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.process;

import fr.obeo.dsl.process.internal.TaskUtilsAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Process utility class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public final class ProcessUtils {

	/**
	 * Message constant.
	 */
	private static final String DON_T_KNOW_WHAT_TO_DO_WITH = "don't know what to do with ";

	/**
	 * {@link List} of registered {@link IProcessRunner}.
	 */
	private static final List<IProcessRunner> RUNNERS = new ArrayList<IProcessRunner>();

	/**
	 * Constructor.
	 */
	private ProcessUtils() {
		// nothing to do here
	}

	/**
	 * Register the given {@link IProcessRunner}.
	 * 
	 * @param runner
	 *            the {@link IProcessRunner}
	 */
	public static void registerProcessRunner(IProcessRunner runner) {
		RUNNERS.add(runner);
	}

	/**
	 * Unregister the given {@link IProcessRunner}.
	 * 
	 * @param runner
	 *            the {@link IProcessRunner}
	 */
	public static void unregisterProcessRunner(IProcessRunner runner) {
		RUNNERS.remove(runner);
	}

	/**
	 * Gets the {@link List} of registered {@link IProcessRunner}.
	 * 
	 * @return the {@link List} of registered {@link IProcessRunner}
	 */
	public static List<IProcessRunner> getRegisteredRunners() {
		return RUNNERS;
	}

	/**
	 * Tells if there is at least one path (succession of {@link Task tasks}) between the given initial
	 * {@link Task tasks} and given final {@link Task tasks}.
	 * 
	 * @param initialTasks
	 *            the initial {@link Task tasks}
	 * @param finalTasks
	 *            the final {@link Task tasks}
	 * @return <code>true</code> if there is a succession of {@link Task tasks} from any of the initial
	 *         {@link Task tasks} to any final {@link Task tasks}, <code>false</code> otherwise
	 */
	public static boolean pathExists(Set<Task> initialTasks, Set<Task> finalTasks) {
		return internalPathExists(new LinkedHashSet<Task>(), new LinkedHashSet<Task>(initialTasks),
				new LinkedHashSet<Task>(finalTasks));
	}

	/**
	 * Tells if there is at least one path (succession of {@link Task tasks}) between the given initial
	 * {@link Task tasks} and given final {@link Task tasks}.
	 * 
	 * @param visitedTasks
	 *            the {@link Set} of already visited {@link Task tasks}
	 * @param initialTasks
	 *            the initial {@link Task tasks}
	 * @param finalTasks
	 *            the final {@link Task tasks}
	 * @return <code>true</code> if there is a succession of {@link Task tasks} from any of the initial
	 *         {@link Task tasks} to any final {@link Task tasks}, <code>false</code> otherwise
	 */
	private static boolean internalPathExists(LinkedHashSet<Task> visitedTasks,
			LinkedHashSet<Task> initialTasks, LinkedHashSet<Task> finalTasks) {
		boolean res = false;
		for (Task initialTask : initialTasks) {
			if (finalTasks.contains(initialTask)) {
				res = true;
				break;
			}
		}

		if (!res) {
			visitedTasks.addAll(initialTasks);
			final LinkedHashSet<Task> newInitialTasks = new LinkedHashSet<Task>();
			for (Task initialTask : initialTasks) {
				for (Task followingTask : initialTask.getFollowingTasks()) {
					if (!visitedTasks.contains(followingTask)) {
						newInitialTasks.add(followingTask);
					}
				}
			}
			if (newInitialTasks.size() != 0) {
				res = internalPathExists(visitedTasks, newInitialTasks, finalTasks);
			}
		}

		return res;
	}

	/**
	 * Gets the {@link String} representing {@link Task#getName() names} of the given {@link Task tasks}
	 * separated by the given separator.
	 * 
	 * @param tasks
	 *            the {@link List} of {@link Task}
	 * @param separator
	 *            the separator
	 * @return the {@link String} representing {@link Task#getName() names} of the given {@link Task tasks}
	 *         separated by the given separator
	 */
	public static String getListOfTaskNames(List<Task> tasks, String separator) {
		final StringBuilder builder = new StringBuilder();

		for (Task task : tasks) {
			builder.append("\"");
			builder.append(task.getName());
			builder.append("\"");
			builder.append(separator);
		}

		final String res;
		if (tasks.size() != 0) {
			res = builder.substring(0, builder.length() - separator.length());
		} else {
			res = "";
		}

		return res;

	}

	/**
	 * Tells if the given {@link Task tasks} are at the same level.
	 * 
	 * @param task1
	 *            the first {@link Task}
	 * @param task2
	 *            the second {@link Task}
	 * @return <code>true</code> if the given {@link Task tasks} are at the same level, <code>false</code>
	 *         otherwise
	 */
	public static boolean atSameLevel(Task task1, Task task2) {
		return task1.getParentTask() != null && task2.getParentTask() != null
				&& task1.getParentTask() == task2.getParentTask();
	}

	/**
	 * Gets the {@link Set} of {@link Task} at the same level as the given {@link Task}, the given
	 * {@link Task} is in the resulting {@link Set} if it has a {@link Task#getParentTask() parent task}.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return the {@link Set} of {@link Task} at the same level as the given {@link Task}, the given
	 *         {@link Task} is in the resulting {@link Set} if it has a {@link Task#getParentTask() parent
	 *         task}
	 */
	public static Set<Task> getSameLevelTasks(Task task) {
		Set<Task> res = new LinkedHashSet<Task>();

		if (task.getParentTask() != null) {
			res.addAll(task.getParentTask().getTasks());
		}

		return res;
	}

	/**
	 * Tells if the given {@link Task} is done under the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param task
	 *            the {@link Task}
	 * @return <code>true</code> if the given {@link Task} is done under the given {@link ProcessContext},
	 *         <code>false</code> otherwise
	 */
	public static boolean isDone(ProcessContext context, Task task) {
		final boolean res;

		if (task instanceof ActionTask) {
			res = context.isDone((ActionTask)task);
		} else if (task instanceof ComposedTask) {
			res = evaluateDoneExpression(context, (ComposedTask)task);
		} else {
			res = false;
			throw new IllegalStateException(DON_T_KNOW_WHAT_TO_DO_WITH + task.getClass().getSimpleName());
		}

		return res;
	}

	/**
	 * Gets the containing {@link Task} of the given {@link Expression}.
	 * 
	 * @param expression
	 *            the {@link Expression}
	 * @return the containing {@link Task} of the given {@link Expression} if any, <code>null</code> otherwise
	 */
	public static Task getContainingTask(Expression expression) {
		Task res = null;

		EObject current = expression.eContainer();
		while (current != null) {
			if (current instanceof Task) {
				res = (Task)current;
				break;
			} else {
				current = current.eContainer();
			}
		}

		return res;
	}

	/**
	 * Gets preceding {@link Task tasks} for the given {@link Task}.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return preceding {@link Task tasks} for the given {@link Task}
	 */
	public static Set<Task> getPrecedingTasks(Task task) {
		final Set<Task> res = new LinkedHashSet<Task>(task.getPrecedingTasks());

		Task currentTask = task;
		while (currentTask != null && isInitialTask(currentTask)) {
			res.addAll(currentTask.getParentTask().getPrecedingTasks());
			currentTask = currentTask.getParentTask();
		}

		return res;
	}

	/**
	 * tells if the possiblePreviousTask is part of the precedings task. For composite preceeding tasks, it
	 * check if the possible previous task is a final task of the composite
	 * 
	 * @param nextTask
	 * @param possiblePreviousTask
	 * @return
	 */
	public static boolean isTaskFollowing(Task nextTask, Task possiblePreviousTask) {
		Set<Task> precedingTasks = getPrecedingTasks(nextTask);
		if (precedingTasks.contains(possiblePreviousTask))
			return true;
		for (Task t : precedingTasks) {
			if (t instanceof ComposedTask) {
				if (getFinalActionTasks((ComposedTask)t).contains(possiblePreviousTask)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * recursively find the final ActionTask of the given ComposedTask
	 * 
	 * @param task
	 * @return
	 */
	public static Set<ActionTask> getFinalActionTasks(ComposedTask task) {
		final Set<ActionTask> res = new LinkedHashSet<ActionTask>();
		for (Task finalTask : task.getFinalTasks()) {
			if (finalTask instanceof ComposedTask) {
				res.addAll(getFinalActionTasks((ComposedTask)finalTask));
			} else {
				res.add((ActionTask)finalTask);
			}
		}

		return res;
	}

	/**
	 * Gets following {@link Task tasks} for the given {@link Task}.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return following {@link Task tasks} for the given {@link Task}
	 */
	public static Set<Task> getFollowingTasks(Task task) {
		final Set<Task> res = new LinkedHashSet<Task>(task.getFollowingTasks());

		Task currentTask = task;
		while (currentTask != null && isFinalTask(currentTask)) {
			res.addAll(currentTask.getParentTask().getFollowingTasks());
			currentTask = currentTask.getParentTask();
		}

		return res;
	}

	/**
	 * Gets {@link Task tasks} referenced in the given {@link Expression}.
	 * 
	 * @param expression
	 *            the {@link Expression}
	 * @return {@link Task tasks} referenced in the given {@link Expression}
	 */
	public static Set<Task> getReferencedTasks(Expression expression) {
		final Set<Task> res = new LinkedHashSet<Task>();

		if (expression instanceof TasksExpression) {
			res.addAll(((TasksExpression)expression).getTasks());
		} else {
			Iterator<EObject> it = expression.eAllContents();
			while (it.hasNext()) {
				EObject eObj = it.next();
				if (eObj instanceof TasksExpression) {
					res.addAll(((TasksExpression)eObj).getTasks());
				}
			}
		}

		return res;
	}

	/**
	 * Tells if the given {@link Task} is {@link ComposedTask#getFinalTasks() final}.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return <code>true</code> if the given {@link Task} is {@link ComposedTask#getFinalTasks() final},
	 *         <code>false</code> otherwise
	 */
	public static boolean isFinalTask(Task task) {
		final ComposedTask parentTask = task.getParentTask();
		return parentTask != null && parentTask.getFinalTasks().contains(task);
	}

	/**
	 * Tells if the given {@link Task} is {@link ComposedTask#getInitialTasks() initial}.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return <code>true</code> if the given {@link Task} is {@link ComposedTask#getFinalTasks() final},
	 *         <code>false</code> otherwise
	 */
	public static boolean isInitialTask(Task task) {
		final ComposedTask parentTask = task.getParentTask();
		return parentTask != null && parentTask.getInitialTasks().contains(task);
	}

	/**
	 * Gets the possible {@link Task tasks} that can be used in the given {@link Expression}.
	 * 
	 * @param expression
	 *            the {@link Expression}
	 * @return the possible {@link Task tasks} that can be used in the given {@link Expression}
	 */
	public static Set<Task> getPossibleTasks(Expression expression) {
		final Expression root = getRootExpression(expression);
		final Task task = (Task)root.eContainer();

		return getPossibleTasks(task, root.eContainmentFeature());
	}

	/**
	 * Gets the possible {@link Task tasks} that can be used in the given {@link Task} and {@link EReference}
	 * (either {@link ProcessPackage#getTask_Precondition() precondition} or
	 * {@link ProcessPackage#getComposedTask_DoneExpression() done expression}).
	 * 
	 * @param task
	 *            the {@link Task}
	 * @param eReference
	 *            the {@link EReference} (either {@link ProcessPackage#getTask_Precondition() precondition} or
	 *            {@link ProcessPackage#getComposedTask_DoneExpression() done expression})
	 * @return the possible {@link Task tasks} that can be used in the given {@link Task} and
	 *         {@link EReference} (either {@link ProcessPackage#getTask_Precondition() precondition} or
	 *         {@link ProcessPackage#getComposedTask_DoneExpression() done expression})
	 */
	public static Set<Task> getPossibleTasks(Task task, EReference eReference) {
		final Set<Task> res = new LinkedHashSet<Task>();

		if (eReference == ProcessPackage.eINSTANCE.getTask_Precondition()) {
			res.addAll(getPrecedingTasks(task));
		} else if (task instanceof ComposedTask
				&& eReference == ProcessPackage.eINSTANCE.getComposedTask_DoneExpression()) {
			res.addAll(((ComposedTask)task).getFinalTasks());
		} else if (eReference != null) {
			throw new IllegalStateException(DON_T_KNOW_WHAT_TO_DO_WITH + eReference.getName());
		}

		return res;
	}

	/**
	 * Gets the root {@link Expression} of the given {@link Expression} (the last transiently containing
	 * {@link Expression}).
	 * 
	 * @param expression
	 *            the {@link Expression}
	 * @return the root {@link Expression} of the given {@link Expression} (the last transiently containing
	 *         {@link Expression})
	 */
	public static Expression getRootExpression(Expression expression) {
		Expression res = expression;

		while (res.eContainer() instanceof Expression) {
			res = (Expression)res.eContainer();
		}

		return res;
	}

	/**
	 * Gets the {@link ITaskUtils} for the given {@link Task}.
	 * 
	 * @param task
	 *            the {@link Task} to adapt
	 * @return the {@link ITaskUtils} for the given {@link Task}
	 */
	public static ITaskUtils getTool(Task task) {
		ITaskUtils res = null;
		Iterator<Adapter> it = task.eAdapters().iterator();
		while (it.hasNext() && res == null) {
			Adapter adapter = it.next();
			if (adapter.isAdapterForType(ITaskUtils.class)) {
				res = (ITaskUtils)adapter;
			}
		}
		if (res == null) {
			res = new TaskUtilsAdapter();
			task.eAdapters().add((Adapter)res);
		}
		return res;
	}

	/**
	 * Tells if the given {@link Task} is reachable.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return <code>true</code> if the given {@link Task} is reachable, <code>false</code> otherwise
	 */
	public static boolean isReachable(Task task) {
		// TODO optimize with the TaskUtilsAdapter when implemented properly
		boolean res = false;

		if (isInitialToProcess(task)) {
			res = true;
		} else {
			for (Task preceding : getPrecedingTasks(task)) {
				if (isReachable(preceding)) {
					res = true;
					break;
				}
			}
		}

		return res;
	}

	/**
	 * Tells if the given {@link Task} is {@link ProcessUtils #isInitialTask(Task) initial} to the containing
	 * {@link Process}.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return <code>true</code> if the given {@link Task} is initial to the containing {@link Process},
	 *         <code>false</code> otherwise
	 */
	private static boolean isInitialToProcess(Task task) {
		Task currentTask = task;

		while (isInitialTask(currentTask)) {
			currentTask = currentTask.getParentTask();
		}

		return currentTask.eContainingFeature() == ProcessPackage.eINSTANCE.getProcess_Task();
	}

	/**
	 * Tells if the given {@link Task} is a dead end.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return <code>true</code> if the given {@link Task} is a dead end, <code>false</code> otherwise
	 */
	public static boolean isDeadEnd(Task task) {
		// TODO optimize with the TaskUtilsAdapter when implemented properly
		boolean res = true;

		if (isFinalToProcess(task)) {
			res = false;
		} else {
			for (Task following : getFollowingTasks(task)) {
				if (!isDeadEnd(following)) {
					res = false;
					break;
				}
			}
		}

		return res;
	}

	/**
	 * Tells if the given {@link Task} is {@link ProcessUtils#isFinalTask(Task) final} to the containing
	 * {@link Process}.
	 * 
	 * @param task
	 *            the {@link Task}
	 * @return <code>true</code> if the given {@link Task} is initial to the containing {@link Process},
	 *         <code>false</code> otherwise
	 */
	private static boolean isFinalToProcess(Task task) {
		Task currentTask = task;

		while (isFinalTask(currentTask)) {
			currentTask = currentTask.getParentTask();
		}

		return currentTask.eContainingFeature() == ProcessPackage.eINSTANCE.getProcess_Task();
	}

	/**
	 * Tells if the {@link Task preceding task} is mandatory in the {@link Task#getPrecondition()
	 * precondition} of the {@link Task following task}.
	 * 
	 * @param preceding
	 *            the preceding {@link Task}
	 * @param following
	 *            the following {@link Task}
	 * @return <code>true</code> if the {@link Task preceding task} is mandatory in the
	 *         {@link Task#getPrecondition() precondition} of the {@link Task following task},
	 *         <code>false</code> otherwise
	 */
	public static boolean isMandatoryInPrecondition(Task preceding, Task following) {
		final boolean res;

		if (following.getPrecondition() != null) {
			res = getMantadoryTasks(following.getPrecondition()).contains(preceding);
		} else {
			res = getPossibleTasks(following, ProcessPackage.eINSTANCE.getTask_Precondition()).contains(
					preceding);
		}

		return res;
	}

	/**
	 * Tells if the {@link Task final task} is mandatory in the {@link ComposedTask#getDoneExpression()
	 * precondition} of the {@link ComposedTask composed task}.
	 * 
	 * @param finalTask
	 *            the final {@link Task}
	 * @param composedTask
	 *            the {@link ComposedTask}
	 * @return <code>true</code> if the {@link Task final task} is mandatory in the
	 *         {@link ComposedTask#getDoneExpression() precondition} of the {@link ComposedTask composed task}
	 *         , <code>false</code> otherwise
	 */
	public static boolean isMandatoryInDoneExpression(Task finalTask, ComposedTask composedTask) {
		final boolean res;

		if (composedTask.getDoneExpression() != null) {
			res = getMantadoryTasks(composedTask.getDoneExpression()).contains(finalTask);
		} else {
			res = getPossibleTasks(composedTask, ProcessPackage.eINSTANCE.getComposedTask_DoneExpression())
					.contains(finalTask);
		}

		return res;
	}

	/**
	 * Gets the {@link Task tasks} that must be {@link ProcessUtils#isDone(ProcessContext, Task) done} in
	 * order to validate the given {@link Expression}.
	 * 
	 * @param expression
	 *            the {@link Expression}
	 * @return the {@link Task tasks} that must be {@link ProcessUtils#isDone(ProcessContext, Task) done} in
	 *         order to validate the given {@link Expression}
	 */
	public static Set<Task> getMantadoryTasks(Expression expression) {
		final Set<Task> res = new LinkedHashSet<Task>();

		getMantadoryTasks(expression, res);

		return res;
	}

	/**
	 * Gets the {@link Task tasks} that must be {@link ProcessUtils#isDone(ProcessContext, Task) done} in
	 * order to validate the given {@link Expression}.
	 * 
	 * @param expression
	 *            the {@link Expression}
	 * @param res
	 *            the resulting {@link Set} of {@link Task tasks}
	 */
	public static void getMantadoryTasks(Expression expression, Set<Task> res) {
		if (expression instanceof AllDone) {
			res.addAll(((AllDone)expression).getTasks());
		} else if (expression instanceof AnyDone) {
			if (((AnyDone)expression).getTasks().size() == 1) {
				res.add(((AnyDone)expression).getTasks().get(0));
			}
		} else if (expression instanceof OneDone) {
			if (((OneDone)expression).getTasks().size() == 1) {
				res.add(((OneDone)expression).getTasks().get(0));
			}
		} else if (expression instanceof Not) {
			// nothing to do here
		} else if (expression instanceof And) {
			for (Expression exp : ((And)expression).getExpressions()) {
				getMantadoryTasks(exp, res);
			}
		} else if (expression instanceof Or) {
			if (((Or)expression).getExpressions().size() == 1) {
				getMantadoryTasks(((Or)expression).getExpressions().get(0), res);
			}
		} else if (expression != null) {
			throw new IllegalStateException(DON_T_KNOW_WHAT_TO_DO_WITH + expression.eClass().getName());
		}
	}

	/**
	 * Evaluates the {@link Task#getPrecondition() precondition} of the given {@link Task} under the given
	 * {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param task
	 *            the {@link Task}
	 * @return <code>true</code> if {@link Task#getPrecondition() precondition} is set and is
	 *         {@link Expression#check(ProcessContext) checked} to <code>true</code>, or if the
	 *         {@link Task#getPrecondition() precondition} is not set and all
	 *         {@link ProcessUtils#getPrecedingTasks(Task) preceding tasks} are all
	 *         {@link ProcessUtils#isDone(ProcessContext, Task) done}, <code>false</code> otherwise
	 */
	public static boolean evaluatePrecondition(ProcessContext context, Task task) {
		final boolean res;

		final Expression precondition = task.getPrecondition();
		if (precondition == null) {
			res = allDone(context, getPrecedingTasks(task));
		} else {
			res = precondition.check(context);
		}

		return res;
	}

	/**
	 * Evaluates the {@link ComposedTask#getDoneExpression() done expression} of the given
	 * {@link ComposedTask} under the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param task
	 *            the {@link ComposedTask}
	 * @return <code>true</code> if {@link ComposedTask#getDoneExpression() done expression} is set and is
	 *         {@link Expression#check(ProcessContext) checked} to <code>true</code>, or if the
	 *         {@link ComposedTask#getDoneExpression() done expression} is not set and all
	 *         {@link ComposedTask#getFinalTasks() final tasks} are all
	 *         {@link ProcessUtils#isDone(ProcessContext, Task) done}, <code>false</code> otherwise
	 */
	public static boolean evaluateDoneExpression(ProcessContext context, ComposedTask task) {
		final boolean res;

		final Expression doneExpression = task.getDoneExpression();
		if (doneExpression == null) {
			res = allDone(context, task.getFinalTasks());
		} else {
			res = doneExpression.check(context);
		}

		return res;
	}

	/**
	 * Tells if given {@link Task tasks} are all {@link ProcessUtils#isDone(ProcessContext, Task) done} under
	 * the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param tasks
	 *            the {@link Collection} of {@link Task}
	 * @return <code>true</code> if given {@link Task tasks} are all
	 *         {@link ProcessUtils#isDone(ProcessContext, Task) done} under the given {@link ProcessContext},
	 *         <code>false</code> otherwise
	 */
	private static boolean allDone(ProcessContext context, Collection<Task> tasks) {
		boolean res = true;

		for (Task task : tasks) {
			if (!isDone(context, task)) {
				res = false;
				break;
			}
		}

		return res;
	}

	/**
	 * Tells if the given {@link ActionTask} can be
	 * {@link IProcessRunner#doAction(ProcessContext, ActionTask) done}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param task
	 *            the {@link ActionTask}
	 * @return <code>true</code> if the given {@link ActionTask} can be
	 *         {@link IProcessRunner#doAction(ProcessContext, ActionTask) done}, <code>false</code> otherwise
	 */
	public static boolean canDoAction(ProcessContext context, ActionTask task) {
		return ProcessUtils.evaluatePrecondition(context, task)
				&& (task.isMultipleExecution() || !ProcessUtils.isDone(context, task));
	}

	/**
	 * Gets the mapping from {@link Task#getId() task id} to the {@link Task} itself for the given
	 * {@link Process}.
	 * 
	 * @param process
	 *            the {@link Process}
	 * @return the mapping from {@link Task#getId() task id} to the {@link Task} itself for the given
	 *         {@link Process}
	 */
	public static Map<String, Task> getTaskByIDMap(Process process) {
		final Map<String, Task> res = new HashMap<String, Task>();

		populateMapping(res, process.getTask());

		return res;
	}

	/**
	 * Populates the given mapping with the given {@link Task} and its {@link ComposedTask#getTasks() owned
	 * tasks} if any.
	 * 
	 * @param map
	 *            the mapping to populate
	 * @param task
	 *            the {@link Task}
	 */
	private static void populateMapping(Map<String, Task> map, Task task) {
		if (task instanceof ComposedTask) {
			map.put(task.getId(), task);
			for (Task child : ((ComposedTask)task).getTasks()) {
				populateMapping(map, child);
			}
		} else if (task instanceof ActionTask) {
			map.put(task.getId(), task);
		} else {
			throw new IllegalStateException(DON_T_KNOW_WHAT_TO_DO_WITH + task.eClass().getName());
		}
	}

	/**
	 * Gets all {@link Task} contained in the given {@link Process}.
	 * 
	 * @param process
	 *            the {@link Process}
	 * @return all {@link Task} contained in the given {@link Process}
	 */
	public static List<Task> getAllTasks(Process process) {
		final List<Task> res;

		if (process != null && process.getTask() != null) {
			if (process.getTask() instanceof ComposedTask) {
				res = getAllTasks((ComposedTask)process.getTask());
			} else {
				res = new ArrayList<Task>();
				res.add(process.getTask());
			}
		} else {
			res = new ArrayList<Task>();
		}

		return res;
	}

	/**
	 * Gets all {@link Task} contained in the given {@link ComposedTask}.
	 * 
	 * @param task
	 *            the {@link ComposedTask}
	 * @return all {@link Task} contained in the given {@link ComposedTask}
	 */
	private static List<Task> getAllTasks(ComposedTask task) {
		final List<Task> res = new ArrayList<Task>();

		for (Task child : task.getTasks()) {
			res.add(child);
			if (child instanceof ComposedTask) {
				res.addAll(getAllTasks((ComposedTask)child));
			}
		}

		return res;
	}
}
