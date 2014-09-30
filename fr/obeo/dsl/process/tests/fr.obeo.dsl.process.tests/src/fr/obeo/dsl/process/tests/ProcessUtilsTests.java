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
package fr.obeo.dsl.process.tests;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.AllDone;
import fr.obeo.dsl.process.And;
import fr.obeo.dsl.process.AnyDone;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.Not;
import fr.obeo.dsl.process.OneDone;
import fr.obeo.dsl.process.Or;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.Task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the class {@link ProcessUtils}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ProcessUtilsTests {

	/**
	 * Tests {@link ProcessUtils#registerProcessRunner(fr.obeo.dsl.process.IProcessRunner)},
	 * {@link ProcessUtils#unregisterProcessRunner(fr.obeo.dsl.process.IProcessRunner)},
	 * {@link ProcessUtils#getRegisteredRunners()}.
	 */
	@Test
	public void processRunnerRegistration() {
		IProcessRunner runner = new TestProcessRunner();

		assertEquals(0, ProcessUtils.getRegisteredRunners().size());

		ProcessUtils.registerProcessRunner(runner);

		assertEquals(1, ProcessUtils.getRegisteredRunners().size());
		assertEquals(runner, ProcessUtils.getRegisteredRunners().get(0));

		ProcessUtils.unregisterProcessRunner(runner);

		assertEquals(0, ProcessUtils.getRegisteredRunners().size());
	}

	/**
	 * Tests {@link ProcessUtils#pathExists(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void pathExistsOneTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Set<Task> initialTasks = new HashSet<Task>();
		final Set<Task> finalTasks = new HashSet<Task>();
		initialTasks.add(task1);
		finalTasks.add(task1);

		assertEquals(true, ProcessUtils.pathExists(initialTasks, finalTasks));
	}

	/**
	 * Tests {@link ProcessUtils#pathExists(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void pathExistsTwoTasks() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);
		final Set<Task> initialTasks = new HashSet<Task>();
		final Set<Task> finalTasks = new HashSet<Task>();
		initialTasks.add(task1);
		finalTasks.add(task2);

		assertEquals(true, ProcessUtils.pathExists(initialTasks, finalTasks));
	}

	/**
	 * Tests {@link ProcessUtils#pathExists(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void pathExistsThreeTasks() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task1.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task3);
		final Set<Task> initialTasks = new HashSet<Task>();
		final Set<Task> finalTasks = new HashSet<Task>();
		initialTasks.add(task1);
		finalTasks.add(task3);

		assertEquals(true, ProcessUtils.pathExists(initialTasks, finalTasks));
	}

	/**
	 * Tests {@link ProcessUtils#pathExists(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void pathExistsThreeTasksNoPath() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task2.getFollowingTasks().add(task3);
		final Set<Task> initialTasks = new HashSet<Task>();
		final Set<Task> finalTasks = new HashSet<Task>();
		initialTasks.add(task1);
		finalTasks.add(task3);

		assertEquals(false, ProcessUtils.pathExists(initialTasks, finalTasks));
	}

	/**
	 * Tests {@link ProcessUtils#pathExists(java.util.Set, java.util.Set)}.
	 */
	@Test
	public void pathExistsFourTasksWithLoop() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final Task task4 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task4.setName("task4");
		task1.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task3);
		task3.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task4);
		final Set<Task> initialTasks = new HashSet<Task>();
		final Set<Task> finalTasks = new HashSet<Task>();
		initialTasks.add(task1);
		finalTasks.add(task4);

		assertEquals(true, ProcessUtils.pathExists(initialTasks, finalTasks));
	}

	/**
	 * Tests {@link ProcessUtils#getListOfTaskNames(java.util.List, String)}.
	 */
	@Test
	public void getListOfTaskNamesNoTask() {
		final ArrayList<Task> tasks = new ArrayList<Task>();

		assertEquals("", ProcessUtils.getListOfTaskNames(tasks, ", "));
	}

	/**
	 * Tests {@link ProcessUtils#getListOfTaskNames(java.util.List, String)}.
	 */
	@Test
	public void getListOfTaskNamesOneTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);

		assertEquals("\"task1\"", ProcessUtils.getListOfTaskNames(tasks, ", "));
	}

	/**
	 * Tests {@link ProcessUtils#getListOfTaskNames(java.util.List, String)}.
	 */
	@Test
	public void getListOfTaskNamesThreeTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");

		final ArrayList<Task> tasks = new ArrayList<Task>();
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		assertEquals("\"task1\", \"task2\", \"task3\"", ProcessUtils.getListOfTaskNames(tasks, ", "));
	}

	/**
	 * Tests {@link ProcessUtils#atSameLevel(Task, Task)}.
	 */
	@Test
	public void atSameLevelNoContainingTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");

		assertEquals(false, ProcessUtils.atSameLevel(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#atSameLevel(Task, Task)}.
	 */
	@Test
	public void atSameLevelDifferentContainingTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("composedTask1");
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("composedTask2");
		composedTask1.getTasks().add(task1);
		composedTask2.getTasks().add(task2);

		assertEquals(false, ProcessUtils.atSameLevel(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#atSameLevel(Task, Task)}.
	 */
	@Test
	public void atSameLevelSameContainingTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);

		assertEquals(true, ProcessUtils.atSameLevel(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#getSameLevelTasks(Task)}.
	 */
	@Test
	public void getSameLevelTasksNoContainingTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		final Set<Task> sameLevelTasks = ProcessUtils.getSameLevelTasks(task1);

		assertEquals(0, sameLevelTasks.size());
	}

	/**
	 * Tests {@link ProcessUtils#getSameLevelTasks(Task)}.
	 */
	@Test
	public void getSameLevelTasksContainingTaskNoSiblings() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);

		final Set<Task> sameLevelTasks = ProcessUtils.getSameLevelTasks(task1);

		assertEquals(1, sameLevelTasks.size());
		assertEquals(true, sameLevelTasks.contains(task1));
	}

	/**
	 * Tests {@link ProcessUtils#getSameLevelTasks(Task)}.
	 */
	@Test
	public void getSameLevelTasksContainingTaskSiblings() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);

		final Set<Task> sameLevelTasks = ProcessUtils.getSameLevelTasks(task1);

		assertEquals(2, sameLevelTasks.size());
		assertEquals(true, sameLevelTasks.contains(task1));
		assertEquals(true, sameLevelTasks.contains(task2));
	}

	/**
	 * Tests {@link ProcessUtils#isDone(fr.obeo.dsl.process.ProcessContext, Task)}.
	 */
	@Test
	public void isDoneActionTaskNotDone() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		assertEquals(false, ProcessUtils.isDone(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#isDone(fr.obeo.dsl.process.ProcessContext, Task)}.
	 */
	@Test
	public void isDoneActionTaskDone() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		context.setDone(task1, null);

		assertEquals(true, ProcessUtils.isDone(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#isDone(fr.obeo.dsl.process.ProcessContext, Task)}.
	 */
	@Test
	public void isDoneComposedTaskNotDone() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		allDone.getTasks().add(task1);
		composedTask.getTasks().add(task1);
		composedTask.getFinalTasks().add(task1);
		composedTask.setDoneExpression(allDone);

		assertEquals(false, ProcessUtils.isDone(context, task1));
		assertEquals(false, ProcessUtils.isDone(context, composedTask));
	}

	/**
	 * Tests {@link ProcessUtils#isDone(fr.obeo.dsl.process.ProcessContext, Task)}.
	 */
	@Test
	public void isDoneComposedTaskDone() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		allDone.getTasks().add(task1);
		composedTask.getTasks().add(task1);
		composedTask.getFinalTasks().add(task1);
		composedTask.setDoneExpression(allDone);

		context.setDone(task1, null);

		assertEquals(true, ProcessUtils.isDone(context, task1));
		assertEquals(true, ProcessUtils.isDone(context, composedTask));
	}

	/**
	 * Tests {@link ProcessUtils#isDone(fr.obeo.dsl.process.ProcessContext, Task)}.
	 */
	@Test
	public void isDoneComposedTaskNotDoneNoDoneExpression() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getFinalTasks().add(task1);

		assertEquals(false, ProcessUtils.isDone(context, task1));
		assertEquals(false, ProcessUtils.isDone(context, composedTask));
	}

	/**
	 * Tests {@link ProcessUtils#isDone(fr.obeo.dsl.process.ProcessContext, Task)}.
	 */
	@Test
	public void isDoneComposedTaskDoneNoDoneExpression() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getFinalTasks().add(task1);

		context.setDone(task1, null);

		assertEquals(true, ProcessUtils.isDone(context, task1));
		assertEquals(true, ProcessUtils.isDone(context, composedTask));
	}

	/**
	 * Tests {@link ProcessUtils#getContainingTask(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getContainingTaskNoContainingTask() {
		final Not exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final Not exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final Not exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		exp1.setExpression(exp2);
		exp2.setExpression(exp3);

		assertEquals(null, ProcessUtils.getContainingTask(exp1));
		assertEquals(null, ProcessUtils.getContainingTask(exp2));
		assertEquals(null, ProcessUtils.getContainingTask(exp3));
	}

	/**
	 * Tests {@link ProcessUtils#getContainingTask(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getContainingTaskContainingTaskPrecondition() {
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final Not exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final Not exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final Not exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		exp1.setExpression(exp2);
		exp2.setExpression(exp3);
		composedTask.setPrecondition(exp1);

		assertEquals(composedTask, ProcessUtils.getContainingTask(exp1));
		assertEquals(composedTask, ProcessUtils.getContainingTask(exp2));
		assertEquals(composedTask, ProcessUtils.getContainingTask(exp3));
	}

	/**
	 * Tests {@link ProcessUtils#getContainingTask(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getContainingTaskContainingTaskDoneExpression() {
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final Not exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final Not exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final Not exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		exp1.setExpression(exp2);
		exp2.setExpression(exp3);
		composedTask.setDoneExpression(exp1);

		assertEquals(composedTask, ProcessUtils.getContainingTask(exp1));
		assertEquals(composedTask, ProcessUtils.getContainingTask(exp2));
		assertEquals(composedTask, ProcessUtils.getContainingTask(exp3));
	}

	/**
	 * Tests {@link ProcessUtils#getPrecedingTasks(Task)}.
	 */
	@Test
	public void getPrecedingTasksNotContainedTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task1.getPrecedingTasks().add(task2);
		task1.getPrecedingTasks().add(task3);

		final Set<Task> precedingTasks = ProcessUtils.getPrecedingTasks(task1);

		assertEquals(2, precedingTasks.size());
		assertEquals(true, precedingTasks.contains(task2));
		assertEquals(true, precedingTasks.contains(task3));
	}

	/**
	 * Tests {@link ProcessUtils#getPrecedingTasks(Task)}.
	 */
	@Test
	public void getPrecedingTasksContainingTaskNotInitial() {
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask.getPrecedingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task3);
		task1.getPrecedingTasks().add(task3);

		final Set<Task> precedingTasks = ProcessUtils.getPrecedingTasks(task1);

		assertEquals(1, precedingTasks.size());
		assertEquals(true, precedingTasks.contains(task3));
	}

	/**
	 * Tests {@link ProcessUtils#getPrecedingTasks(Task)}.
	 */
	@Test
	public void getPrecedingTasksContainingTaskInitial() {
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask.getPrecedingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task3);
		composedTask.getInitialTasks().add(task1);
		task1.getPrecedingTasks().add(task3);

		final Set<Task> precedingTasks = ProcessUtils.getPrecedingTasks(task1);

		assertEquals(2, precedingTasks.size());
		assertEquals(true, precedingTasks.contains(task2));
		assertEquals(true, precedingTasks.contains(task3));
	}

	/**
	 * Tests {@link ProcessUtils#getPrecedingTasks(Task)}.
	 */
	@Test
	public void getPrecedingTasksManyContainingTask() {
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask2.setName("composedTask2");
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask1.getTasks().add(composedTask2);
		composedTask1.getInitialTasks().add(composedTask2);
		composedTask1.getPrecedingTasks().add(task3);
		composedTask2.getPrecedingTasks().add(task2);
		composedTask2.getTasks().add(task1);
		composedTask2.getTasks().add(task3);
		composedTask2.getInitialTasks().add(task1);

		final Set<Task> precedingTasks = ProcessUtils.getPrecedingTasks(task1);

		assertEquals(2, precedingTasks.size());
		assertEquals(true, precedingTasks.contains(task2));
		assertEquals(true, precedingTasks.contains(task3));
	}

	/**
	 * Tests {@link ProcessUtils#getFollowingTasks(Task)}.
	 */
	@Test
	public void getFollowingTasksNotContainedTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");

		task1.getFollowingTasks().add(task2);
		task1.getFollowingTasks().add(task3);

		final Set<Task> followingTasks = ProcessUtils.getFollowingTasks(task1);

		assertEquals(2, followingTasks.size());
		assertEquals(true, followingTasks.contains(task2));
		assertEquals(true, followingTasks.contains(task3));
	}

	/**
	 * Tests {@link ProcessUtils#getFollowingTasks(Task)}.
	 */
	@Test
	public void getFollowingTasksContainedTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");

		task1.getFollowingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getFollowingTasks().add(task3);

		final Set<Task> followingTasks = ProcessUtils.getFollowingTasks(task1);

		assertEquals(1, followingTasks.size());
		assertEquals(true, followingTasks.contains(task2));
	}

	/**
	 * Tests {@link ProcessUtils#getFollowingTasks(Task)}.
	 */
	@Test
	public void getFollowingTasksContainedFinalTask() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");

		task1.getFollowingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getFollowingTasks().add(task3);
		composedTask.getFinalTasks().add(task1);

		final Set<Task> followingTasks = ProcessUtils.getFollowingTasks(task1);

		assertEquals(2, followingTasks.size());
		assertEquals(true, followingTasks.contains(task2));
		assertEquals(true, followingTasks.contains(task3));
	}

	/**
	 * Tests {@link ProcessUtils#getReferencedTasks(fr.obeo.dsl.process.Expression)}.
	 */
	@Test(expected = NullPointerException.class)
	public void getReferencedTasksNull() {
		ProcessUtils.getReferencedTasks(null);
	}

	/**
	 * Tests {@link ProcessUtils#getReferencedTasks(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getReferencedTasksOneLevel() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final AllDone exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp1.getTasks().add(task1);
		exp1.getTasks().add(task2);
		exp1.getTasks().add(task3);

		final Set<Task> referencedTasks = ProcessUtils.getReferencedTasks(exp1);

		assertEquals(3, referencedTasks.size());
		assertEquals(true, referencedTasks.contains(task1));
		assertEquals(true, referencedTasks.contains(task2));
		assertEquals(true, referencedTasks.contains(task3));
	}

	/**
	 * Tests {@link ProcessUtils#getReferencedTasks(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getReferencedTasksThreeLevels() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final AllDone exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final AllDone exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final AllDone exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		final And and1 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And and2 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		exp1.getTasks().add(task1);
		exp2.getTasks().add(task2);
		exp3.getTasks().add(task3);
		and1.getExpressions().add(exp1);
		and1.getExpressions().add(and2);
		and2.getExpressions().add(exp2);
		and2.getExpressions().add(exp3);

		final Set<Task> referencedTasks = ProcessUtils.getReferencedTasks(and1);

		assertEquals(3, referencedTasks.size());
		assertEquals(true, referencedTasks.contains(task1));
		assertEquals(true, referencedTasks.contains(task2));
		assertEquals(true, referencedTasks.contains(task3));
	}

	/**
	 * Tests {@link ProcessUtils#isFinalTask(Task)}.
	 */
	@Test
	public void isFinalTaskNoContainingRule() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		assertEquals(false, ProcessUtils.isFinalTask(task1));
	}

	/**
	 * Tests {@link ProcessUtils#isFinalTask(Task)}.
	 */
	@Test
	public void isFinalTaskNotFinal() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);

		assertEquals(false, ProcessUtils.isFinalTask(task1));
	}

	/**
	 * Tests {@link ProcessUtils#isFinalTask(Task)}.
	 */
	@Test
	public void isFinalTaskFinal() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getFinalTasks().add(task1);

		assertEquals(true, ProcessUtils.isFinalTask(task1));
	}

	/**
	 * Tests {@link ProcessUtils#isInitialTask(Task)}.
	 */
	@Test
	public void isInitialTaskNoContainingRule() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		assertEquals(false, ProcessUtils.isInitialTask(task1));
	}

	/**
	 * Tests {@link ProcessUtils#isInitialTask(Task)}.
	 */
	@Test
	public void isInitialTaskNotFinal() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);

		assertEquals(false, ProcessUtils.isInitialTask(task1));
	}

	/**
	 * Tests {@link ProcessUtils#isInitialTask(Task)}.
	 */
	@Test
	public void isInitialTaskInitial() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getInitialTasks().add(task1);

		assertEquals(true, ProcessUtils.isInitialTask(task1));
	}

	/**
	 * Tests {@link ProcessUtils#getPossibleTasks(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getPossibleTasksNoContainingTask() {
		final And exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		exp1.getExpressions().add(exp2);
		exp2.getExpressions().add(exp3);

		final Set<Task> possibleTasks1 = ProcessUtils.getPossibleTasks(exp1);
		final Set<Task> possibleTasks2 = ProcessUtils.getPossibleTasks(exp2);
		final Set<Task> possibleTasks3 = ProcessUtils.getPossibleTasks(exp3);

		assertEquals(0, possibleTasks1.size());
		assertEquals(0, possibleTasks2.size());
		assertEquals(0, possibleTasks3.size());
	}

	/**
	 * Tests {@link ProcessUtils#getPossibleTasks(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getPossibleTasksDoneExpression() {
		final And exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		exp1.getExpressions().add(exp2);
		exp2.getExpressions().add(exp3);
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getTasks().add(task3);
		composedTask.getFinalTasks().add(task1);
		composedTask.getFinalTasks().add(task2);
		composedTask.setDoneExpression(exp1);

		final Set<Task> possibleTasks1 = ProcessUtils.getPossibleTasks(exp1);
		final Set<Task> possibleTasks2 = ProcessUtils.getPossibleTasks(exp2);
		final Set<Task> possibleTasks3 = ProcessUtils.getPossibleTasks(exp3);

		assertEquals(2, possibleTasks1.size());
		assertEquals(true, possibleTasks1.contains(task1));
		assertEquals(true, possibleTasks1.contains(task2));
		assertEquals(2, possibleTasks2.size());
		assertEquals(true, possibleTasks2.contains(task1));
		assertEquals(true, possibleTasks2.contains(task2));
		assertEquals(2, possibleTasks3.size());
		assertEquals(true, possibleTasks3.contains(task1));
		assertEquals(true, possibleTasks3.contains(task2));
	}

	/**
	 * Tests {@link ProcessUtils#getPossibleTasks(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getPossibleTasksPrecondition() {
		final And exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		exp1.getExpressions().add(exp2);
		exp2.getExpressions().add(exp3);
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task3);
		composedTask.getPrecedingTasks().add(task1);
		composedTask.getPrecedingTasks().add(task2);
		composedTask.setPrecondition(exp1);

		final Set<Task> possibleTasks1 = ProcessUtils.getPossibleTasks(exp1);
		final Set<Task> possibleTasks2 = ProcessUtils.getPossibleTasks(exp2);
		final Set<Task> possibleTasks3 = ProcessUtils.getPossibleTasks(exp3);

		assertEquals(2, possibleTasks1.size());
		assertEquals(true, possibleTasks1.contains(task1));
		assertEquals(true, possibleTasks1.contains(task2));
		assertEquals(2, possibleTasks2.size());
		assertEquals(true, possibleTasks2.contains(task1));
		assertEquals(true, possibleTasks2.contains(task2));
		assertEquals(2, possibleTasks3.size());
		assertEquals(true, possibleTasks3.contains(task1));
		assertEquals(true, possibleTasks3.contains(task2));
	}

	/**
	 * Tests {@link ProcessUtils#getPossibleTasks(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getPossibleTasksPreconditionManyContainingTasks() {
		final And exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		exp1.getExpressions().add(exp2);
		exp2.getExpressions().add(exp3);
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask2");
		composedTask2.getTasks().add(composedTask1);
		composedTask2.getPrecedingTasks().add(task2);
		composedTask2.getTasks().add(task3);
		composedTask2.getInitialTasks().add(composedTask1);
		composedTask1.getPrecedingTasks().add(task1);
		composedTask1.setPrecondition(exp1);

		final Set<Task> possibleTasks1 = ProcessUtils.getPossibleTasks(exp1);
		final Set<Task> possibleTasks2 = ProcessUtils.getPossibleTasks(exp2);
		final Set<Task> possibleTasks3 = ProcessUtils.getPossibleTasks(exp3);

		assertEquals(2, possibleTasks1.size());
		assertEquals(true, possibleTasks1.contains(task1));
		assertEquals(true, possibleTasks1.contains(task2));
		assertEquals(2, possibleTasks2.size());
		assertEquals(true, possibleTasks2.contains(task1));
		assertEquals(true, possibleTasks2.contains(task2));
		assertEquals(2, possibleTasks3.size());
		assertEquals(true, possibleTasks3.contains(task1));
		assertEquals(true, possibleTasks3.contains(task2));
	}

	/**
	 * Tests {@link ProcessUtils#getRootExpression(fr.obeo.dsl.process.Expression)}.
	 */
	@Test
	public void getRootExpression() {
		final And exp1 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp2 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final And exp3 = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		exp1.getExpressions().add(exp2);
		exp2.getExpressions().add(exp3);

		assertEquals(exp1, ProcessUtils.getRootExpression(exp1));
		assertEquals(exp1, ProcessUtils.getRootExpression(exp2));
		assertEquals(exp1, ProcessUtils.getRootExpression(exp3));
	}

	/**
	 * Tests {@link ProcessUtils#isReachable(Task)}.
	 */
	@Test
	public void isReachableRootTask() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);

		assertEquals(true, ProcessUtils.isReachable(composedTask));
	}

	/**
	 * Tests {@link ProcessUtils#isReachable(Task)}.
	 */
	@Test
	public void isReachableNotInitialToProcess() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getTasks().add(task3);
		task1.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task3);

		assertEquals(true, ProcessUtils.isReachable(composedTask));
		assertEquals(false, ProcessUtils.isReachable(task1));
		assertEquals(false, ProcessUtils.isReachable(task2));
		assertEquals(false, ProcessUtils.isReachable(task3));
	}

	/**
	 * Tests {@link ProcessUtils#isReachable(Task)}.
	 */
	@Test
	public void isReachableInitialToProcess() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getTasks().add(task3);
		task1.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task3);
		composedTask.getInitialTasks().add(task1);

		assertEquals(true, ProcessUtils.isReachable(composedTask));
		assertEquals(true, ProcessUtils.isReachable(task1));
		assertEquals(true, ProcessUtils.isReachable(task2));
		assertEquals(true, ProcessUtils.isReachable(task3));
	}

	/**
	 * Tests {@link ProcessUtils#isReachable(Task)}.
	 */
	@Test
	public void isReachableNotInProcess() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getTasks().add(task3);
		task1.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task3);
		composedTask.getInitialTasks().add(task1);

		assertEquals(false, ProcessUtils.isReachable(composedTask));
		assertEquals(false, ProcessUtils.isReachable(task1));
		assertEquals(false, ProcessUtils.isReachable(task2));
		assertEquals(false, ProcessUtils.isReachable(task3));
	}

	/**
	 * Tests {@link ProcessUtils#isDeadEnd(Task)}.
	 */
	@Test
	public void isDeadEndRootTask() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);

		assertEquals(false, ProcessUtils.isDeadEnd(composedTask));
	}

	/**
	 * Tests {@link ProcessUtils#isDeadEnd(Task)}.
	 */
	@Test
	public void isDeadEndNotFinalToProcess() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getTasks().add(task3);
		task1.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task3);

		assertEquals(false, ProcessUtils.isDeadEnd(composedTask));
		assertEquals(true, ProcessUtils.isDeadEnd(task1));
		assertEquals(true, ProcessUtils.isDeadEnd(task2));
		assertEquals(true, ProcessUtils.isDeadEnd(task3));
	}

	/**
	 * Tests {@link ProcessUtils#isDeadEnd(Task)}.
	 */
	@Test
	public void isDeadEndFinalToProcess() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getTasks().add(task3);
		task1.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task3);
		composedTask.getFinalTasks().add(task1);

		assertEquals(false, ProcessUtils.isDeadEnd(composedTask));
		assertEquals(false, ProcessUtils.isDeadEnd(task1));
		assertEquals(true, ProcessUtils.isDeadEnd(task2));
		assertEquals(true, ProcessUtils.isDeadEnd(task3));
	}

	/**
	 * Tests {@link ProcessUtils#isDeadEnd(Task)}.
	 */
	@Test
	public void isDeadEndNotInProcess() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final Task task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final Task task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task2);
		composedTask.getTasks().add(task3);
		task1.getFollowingTasks().add(task2);
		task2.getFollowingTasks().add(task3);
		composedTask.getFinalTasks().add(task1);

		assertEquals(true, ProcessUtils.isDeadEnd(composedTask));
		assertEquals(true, ProcessUtils.isDeadEnd(task1));
		assertEquals(true, ProcessUtils.isDeadEnd(task2));
		assertEquals(true, ProcessUtils.isDeadEnd(task3));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInPrecondition(Task, Task)}.
	 */
	@Test
	public void isMandatoryInPreconditionNullPrecondition() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		task1.getFollowingTasks().add(task2);

		assertEquals(true, ProcessUtils.isMandatoryInPrecondition(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInPrecondition(Task, Task)}.
	 */
	@Test
	public void isMandatoryInPreconditionInAllDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);

		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		task2.setPrecondition(exp);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		exp.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		exp.getTasks().add(task2);

		assertEquals(true, ProcessUtils.isMandatoryInPrecondition(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInPrecondition(Task, Task)}.
	 */
	@Test
	public void isMandatoryInPreconditionInAnyDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);

		final AnyDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAnyDone();
		task2.setPrecondition(exp);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		exp.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		exp.getTasks().add(task2);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInPrecondition(Task, Task)}.
	 */
	@Test
	public void isMandatoryInPreconditionInOneDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);

		final OneDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		task2.setPrecondition(exp);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		exp.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		exp.getTasks().add(task2);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInPrecondition(Task, Task)}.
	 */
	@Test
	public void isMandatoryInPreconditionInNotDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);

		final Not exp = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.setExpression(allDone);
		task2.setPrecondition(exp);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		allDone.getTasks().add(task1);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInPrecondition(Task, Task)}.
	 */
	@Test
	public void isMandatoryInPreconditionInAndDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);

		final And exp = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone);
		task2.setPrecondition(exp);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		allDone.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		final AllDone allDone2 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone2);

		assertEquals(true, ProcessUtils.isMandatoryInPrecondition(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInPrecondition(Task, Task)}.
	 */
	@Test
	public void isMandatoryInPreconditionInOrDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);

		final Or exp = ProcessPackage.eINSTANCE.getProcessFactory().createOr();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone);
		task2.setPrecondition(exp);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		allDone.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInPrecondition(task1, task2));

		final AllDone allDone2 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone2);

		assertEquals(false, ProcessUtils.isMandatoryInPrecondition(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInDoneExpression(Task, ComposedTask)}.
	 */
	@Test
	public void isMandatoryInDoneExpressionNullPrecondition() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInDoneExpression(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInDoneExpression(Task, ComposedTask)}.
	 */
	@Test
	public void isMandatoryInDoneExpressionInAllDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		task2.setDoneExpression(exp);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		exp.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		exp.getTasks().add(task2);

		assertEquals(true, ProcessUtils.isMandatoryInDoneExpression(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInDoneExpression(Task, ComposedTask)}.
	 */
	@Test
	public void isMandatoryInDoneExpressionInAnyDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final AnyDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAnyDone();
		task2.setDoneExpression(exp);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		exp.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		exp.getTasks().add(task2);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInDoneExpression(Task, ComposedTask)}.
	 */
	@Test
	public void isMandatoryInDoneExpressionInOneDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final OneDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		task2.setDoneExpression(exp);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		exp.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		exp.getTasks().add(task2);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInDoneExpression(Task, ComposedTask)}.
	 */
	@Test
	public void isMandatoryInDoneExpressionInNotDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final Not exp = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.setExpression(allDone);
		task2.setDoneExpression(exp);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		allDone.getTasks().add(task1);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInDoneExpression(Task, ComposedTask)}.
	 */
	@Test
	public void isMandatoryInDoneExpressionInAndDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final And exp = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone);
		task2.setDoneExpression(exp);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		allDone.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		final AllDone allDone2 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone2);

		assertEquals(true, ProcessUtils.isMandatoryInDoneExpression(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#isMandatoryInDoneExpression(Task, ComposedTask)}.
	 */
	@Test
	public void isMandatoryInDoneExpressionInOrDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final Or exp = ProcessPackage.eINSTANCE.getProcessFactory().createOr();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone);
		task2.setDoneExpression(exp);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		allDone.getTasks().add(task1);

		assertEquals(true, ProcessUtils.isMandatoryInDoneExpression(task1, task2));

		final AllDone allDone2 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone2);

		assertEquals(false, ProcessUtils.isMandatoryInDoneExpression(task1, task2));
	}

	/**
	 * Tests {@link ProcessUtils#getMantadoryTasks(Expression)}.
	 */
	@Test
	public void getMantadoryTasksNullPrecondition() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");

		final Set<Task> mantadoryTasks = ProcessUtils.getMantadoryTasks(null);
		assertEquals(0, mantadoryTasks.size());
	}

	/**
	 * Tests {@link ProcessUtils#getMantadoryTasks(Expression)}.
	 */
	@Test
	public void getMantadoryTasksInAllDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		task2.setDoneExpression(exp);

		Set<Task> mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());

		exp.getTasks().add(task1);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(1, mantadoryTasks.size());
		assertEquals(true, mantadoryTasks.contains(task1));

		exp.getTasks().add(task2);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(2, mantadoryTasks.size());
		assertEquals(true, mantadoryTasks.contains(task1));
		assertEquals(true, mantadoryTasks.contains(task2));
	}

	/**
	 * Tests {@link ProcessUtils#getMantadoryTasks(Expression)}.
	 */
	@Test
	public void getMantadoryTasksInAnyDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final AnyDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAnyDone();
		task2.setDoneExpression(exp);

		Set<Task> mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());

		exp.getTasks().add(task1);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(1, mantadoryTasks.size());
		assertEquals(true, mantadoryTasks.contains(task1));

		exp.getTasks().add(task2);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());
	}

	/**
	 * Tests {@link ProcessUtils#getMantadoryTasks(Expression)}.
	 */
	@Test
	public void getMantadoryTasksInOneDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final OneDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createOneDone();
		task2.setDoneExpression(exp);

		Set<Task> mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());

		exp.getTasks().add(task1);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(1, mantadoryTasks.size());
		assertEquals(true, mantadoryTasks.contains(task1));

		exp.getTasks().add(task2);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());
	}

	/**
	 * Tests {@link ProcessUtils#getMantadoryTasks(Expression)}.
	 */
	@Test
	public void getMantadoryTasksInNotDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final Not exp = ProcessPackage.eINSTANCE.getProcessFactory().createNot();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.setExpression(allDone);
		task2.setDoneExpression(exp);

		Set<Task> mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());

		allDone.getTasks().add(task1);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());
	}

	/**
	 * Tests {@link ProcessUtils#getMantadoryTasks(Expression)}.
	 */
	@Test
	public void getMantadoryTasksInAndDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final And exp = ProcessPackage.eINSTANCE.getProcessFactory().createAnd();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone);
		task2.setDoneExpression(exp);

		Set<Task> mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());

		allDone.getTasks().add(task1);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(1, mantadoryTasks.size());
		assertEquals(true, mantadoryTasks.contains(task1));

		final AllDone allDone2 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone2);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(1, mantadoryTasks.size());
		assertEquals(true, mantadoryTasks.contains(task1));
	}

	/**
	 * Tests {@link ProcessUtils#getMantadoryTasks(Expression)}.
	 */
	@Test
	public void getMantadoryTasksInOrDone() {
		final Task task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ComposedTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task2.setName("task2");
		task2.getTasks().add(task1);
		task2.getFinalTasks().add(task1);

		final Or exp = ProcessPackage.eINSTANCE.getProcessFactory().createOr();
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone);
		task2.setDoneExpression(exp);

		Set<Task> mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());

		allDone.getTasks().add(task1);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(1, mantadoryTasks.size());
		assertEquals(true, mantadoryTasks.contains(task1));

		final AllDone allDone2 = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getExpressions().add(allDone2);

		mantadoryTasks = ProcessUtils.getMantadoryTasks(exp);
		assertEquals(0, mantadoryTasks.size());
	}

	/**
	 * Tests {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task)}.
	 */
	@Test
	public void evaluatePreconditionNotContainedTaskNoPrecondition() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task1.getPrecedingTasks().add(task2);
		task1.getPrecedingTasks().add(task3);

		assertEquals(false, ProcessUtils.evaluatePrecondition(context, task1));

		context.setDone(task2, null);
		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluatePrecondition(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task)}.
	 */
	@Test
	public void evaluatePreconditionContainingTaskNotInitialNoPrecondition() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask.getPrecedingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task3);
		task1.getPrecedingTasks().add(task3);

		assertEquals(false, ProcessUtils.evaluatePrecondition(context, task1));

		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluatePrecondition(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task)}.
	 */
	@Test
	public void evaluatePreconditionContainingTaskInitialNoPrecondition() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask.getPrecedingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task3);
		composedTask.getInitialTasks().add(task1);
		task1.getPrecedingTasks().add(task3);

		assertEquals(false, ProcessUtils.evaluatePrecondition(context, task1));

		context.setDone(task2, null);
		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluatePrecondition(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task)}.
	 */
	@Test
	public void evaluatePreconditionManyContainingTaskNoPrecondition() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask2.setName("composedTask2");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask1.getTasks().add(composedTask2);
		composedTask1.getInitialTasks().add(composedTask2);
		composedTask1.getPrecedingTasks().add(task3);
		composedTask2.getPrecedingTasks().add(task2);
		composedTask2.getTasks().add(task1);
		composedTask2.getTasks().add(task3);
		composedTask2.getInitialTasks().add(task1);

		assertEquals(false, ProcessUtils.evaluatePrecondition(context, task1));

		context.setDone(task2, null);
		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluatePrecondition(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task)}.
	 */
	@Test
	public void evaluatePreconditionNotContainedTask() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task1.getPrecedingTasks().add(task2);
		task1.getPrecedingTasks().add(task3);
		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getTasks().add(task2);
		exp.getTasks().add(task3);
		task1.setPrecondition(exp);

		assertEquals(false, ProcessUtils.evaluatePrecondition(context, task1));

		context.setDone(task2, null);
		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluatePrecondition(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task)}.
	 */
	@Test
	public void evaluatePreconditionContainingTaskNotInitial() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask.getPrecedingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task3);
		task1.getPrecedingTasks().add(task3);
		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getTasks().add(task3);
		task1.setPrecondition(exp);

		assertEquals(false, ProcessUtils.evaluatePrecondition(context, task1));

		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluatePrecondition(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task)}.
	 */
	@Test
	public void evaluatePreconditionContainingTaskInitial() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask.getPrecedingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task3);
		composedTask.getInitialTasks().add(task1);
		task1.getPrecedingTasks().add(task3);
		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getTasks().add(task2);
		exp.getTasks().add(task3);
		task1.setPrecondition(exp);

		assertEquals(false, ProcessUtils.evaluatePrecondition(context, task1));

		context.setDone(task2, null);
		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluatePrecondition(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task)}.
	 */
	@Test
	public void evaluatePreconditionManyContainingTask() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask2.setName("composedTask2");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask1.getTasks().add(composedTask2);
		composedTask1.getInitialTasks().add(composedTask2);
		composedTask1.getPrecedingTasks().add(task3);
		composedTask2.getPrecedingTasks().add(task2);
		composedTask2.getTasks().add(task1);
		composedTask2.getTasks().add(task3);
		composedTask2.getInitialTasks().add(task1);
		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getTasks().add(task2);
		exp.getTasks().add(task3);
		task1.setPrecondition(exp);

		assertEquals(false, ProcessUtils.evaluatePrecondition(context, task1));

		context.setDone(task2, null);
		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluatePrecondition(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluateDoneExpression(ProcessContext, Task)}.
	 */
	@Test
	public void evaluateDoneExpressionTaskNoPrecondition() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task1.getTasks().add(task2);
		task1.getTasks().add(task3);
		task1.getFinalTasks().add(task2);
		task1.getFinalTasks().add(task3);

		assertEquals(false, ProcessUtils.evaluateDoneExpression(context, task1));

		context.setDone(task2, null);
		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluateDoneExpression(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#evaluateDoneExpression(ProcessContext, Task)}.
	 */
	@Test
	public void evaluateDoneExpressionTask() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task1.getTasks().add(task2);
		task1.getTasks().add(task3);
		final AllDone exp = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		exp.getTasks().add(task2);
		exp.getTasks().add(task3);
		task1.setDoneExpression(exp);

		assertEquals(false, ProcessUtils.evaluateDoneExpression(context, task1));

		context.setDone(task2, null);
		context.setDone(task3, null);

		assertEquals(true, ProcessUtils.evaluateDoneExpression(context, task1));
	}

	/**
	 * Tests {@link ProcessUtils#canDoAction(ProcessContext, ActionTask)}.
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void canDoActionNullActionTask() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();

		ProcessUtils.canDoAction(context, null);
	}

	/**
	 * Tests {@link ProcessUtils#canDoAction(ProcessContext, ActionTask)}.
	 */
	@Test
	public void canDoActionFalsePreconditionActionTask() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);

		assertEquals(false, ProcessUtils.canDoAction(context, task2));
	}

	/**
	 * Tests {@link ProcessUtils#canDoAction(ProcessContext, ActionTask)}.
	 */
	@Test
	public void canDoActionFalsePreconditionDoneActionTask() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task1.getFollowingTasks().add(task2);
		context.setDone(task2, new Object());

		assertEquals(false, ProcessUtils.canDoAction(context, task2));
	}

	/**
	 * Tests {@link ProcessUtils#canDoAction(ProcessContext, ActionTask)}.
	 */
	@Test
	public void canDoActionFalsePreconditionDoneActionTaskMultiple() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setMultipleExecution(true);
		task1.getFollowingTasks().add(task2);
		context.setDone(task2, new Object());

		assertEquals(false, ProcessUtils.canDoAction(context, task2));
	}

	/**
	 * Tests {@link ProcessUtils#canDoAction(ProcessContext, ActionTask)}.
	 */
	@Test
	public void canDoActionTruePreconditionActionTask() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");

		assertEquals(true, ProcessUtils.canDoAction(context, task2));
	}

	/**
	 * Tests {@link ProcessUtils#canDoAction(ProcessContext, ActionTask)}.
	 */
	@Test
	public void canDoActionTruePreconditionDoneActionTask() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		context.setDone(task2, new Object());

		assertEquals(false, ProcessUtils.canDoAction(context, task2));
	}

	/**
	 * Tests {@link ProcessUtils#canDoAction(ProcessContext, ActionTask)}.
	 */
	@Test
	public void canDoActionTruePreconditionDoneActionTaskMultiple() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setMultipleExecution(true);
		context.setDone(task2, new Object());

		assertEquals(true, ProcessUtils.canDoAction(context, task2));
	}

	/**
	 * Tests {@link ProcessUtils#getTaskByIDMap(Process)}.
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void getTaskByIDMapNullProcess() {
		ProcessUtils.getTaskByIDMap(null);
	}

	/**
	 * Tests {@link ProcessUtils#getTaskByIDMap(Process)}.
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void getTaskByIDMapNoTask() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");

		final Map<String, Task> map = ProcessUtils.getTaskByIDMap(process);

		assertEquals(0, map.size());
	}

	/**
	 * Tests {@link ProcessUtils#getTaskByIDMap(Process)}.
	 */
	@Test
	public void getTaskByIDMapActionTask() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setId("Task1");
		process.setTask(task1);

		final Map<String, Task> map = ProcessUtils.getTaskByIDMap(process);

		assertEquals(1, map.size());
		assertEquals(task1, map.get(task1.getId()));
	}

	/**
	 * Tests {@link ProcessUtils#getTaskByIDMap(Process)}.
	 */
	@Test
	public void getTaskByIDMapComposedTaskNoChildren() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		composedTask1.setId("ComposedTask1");
		process.setTask(composedTask1);

		final Map<String, Task> map = ProcessUtils.getTaskByIDMap(process);

		assertEquals(1, map.size());
		assertEquals(composedTask1, map.get(composedTask1.getId()));
	}

	/**
	 * Tests {@link ProcessUtils#getTaskByIDMap(Process)}.
	 */
	@Test
	public void getTaskByIDMapComposedTask() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		composedTask1.setId("ComposedTask1");
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask2.setName("composedTask2");
		composedTask2.setId("ComposedTask2");
		composedTask1.getTasks().add(composedTask2);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setId("Task1");
		composedTask1.getTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setId("Task2");
		composedTask2.getTasks().add(task2);
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task3.setId("Task3");
		composedTask2.getTasks().add(task3);
		process.setTask(composedTask1);

		final Map<String, Task> map = ProcessUtils.getTaskByIDMap(process);

		assertEquals(5, map.size());
		assertEquals(composedTask1, map.get(composedTask1.getId()));
		assertEquals(composedTask2, map.get(composedTask2.getId()));
		assertEquals(task1, map.get(task1.getId()));
		assertEquals(task2, map.get(task2.getId()));
		assertEquals(task3, map.get(task3.getId()));
	}

	/**
	 * Tests {@link ProcessUtils#getAvailableProcessVariables(ActionTask)}.
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void getAvailableProcessVariablesNoTask() {
		ProcessUtils.getAvailableProcessVariables(null);
	}

	/**
	 * Tests {@link ProcessUtils#getAvailableProcessVariables(ActionTask)}.
	 */
	@Test
	public void getAvailableProcessVariablesNoPrecedingTasks() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ProcessVariable variable1 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable1.setName("variable1");
		final ProcessVariable variable2 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable2.setName("variable2");
		process.getVariables().add(variable2);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setId("Task1");
		process.setTask(task1);

		List<ProcessVariable> variables = ProcessUtils.getAvailableProcessVariables(task1);

		assertEquals(0, variables.size());
	}

	/**
	 * Tests {@link ProcessUtils#getAvailableProcessVariables(ActionTask)}.
	 */
	@Test
	public void getAvailableProcessVariablesPrecedingTasks() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		composedTask.getPrecedingTasks().add(task2);
		composedTask.getTasks().add(task1);
		composedTask.getTasks().add(task3);
		composedTask.getInitialTasks().add(task1);
		task1.getPrecedingTasks().add(task3);
		final ProcessVariable variable1 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable1.setName("variable1");
		final ProcessVariable variable2 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable2.setName("variable2");
		final ProcessVariable variable3 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable3.setName("variable3");
		task2.getWrittenVariables().add(variable2);
		task3.getWrittenVariables().add(variable3);

		List<ProcessVariable> variables = ProcessUtils.getAvailableProcessVariables(task1);

		assertEquals(2, variables.size());
		assertEquals(variable3, variables.get(0));
		assertEquals(variable2, variables.get(1));
	}

}
