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
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.util.ProcessValidator;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests {@link ProcessValidator}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ProcessValidatorTests {

	/**
	 * Registers {@link ProcessValidator}.
	 */
	@BeforeClass
	public static void beforeClass() {
		EValidator.Registry.INSTANCE.put(ProcessPackage.eINSTANCE, new ProcessValidator());
	}

	/**
	 * Unregisters {@link ProcessValidator}.
	 */
	@AfterClass
	public static void afterClass() {
		EValidator.Registry.INSTANCE.remove(ProcessPackage.eINSTANCE);
	}

	/**
	 * Tests <code>Reachable</code> constraint.
	 */
	@Test
	public void reachable() {
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.WARNING);
		assertTrue(diag.getChildren().get(0).getCode() == "Reachable".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ActionTask);
		assertEquals("task1", ((ActionTask)diag.getChildren().get(0).getData().get(0)).getName());
	}

	/**
	 * Tests <code>DeadEnd</code> constraint.
	 */
	@Test
	public void deadEnd() {
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(1).getSeverity() == Diagnostic.WARNING);
		assertTrue(diag.getChildren().get(1).getCode() == "DeadEnd".hashCode());
		assertTrue(diag.getChildren().get(1).getData().get(0) instanceof ActionTask);
		assertEquals("task1", ((ActionTask)diag.getChildren().get(1).getData().get(0)).getName());
	}

	/**
	 * Tests <code>PrecedingTasksAtSameLevel</code> constraint.
	 */
	@Test
	public void precedingTasksAtSameLevel() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		process.setTask(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task1.getTasks().add(task2);
		task1.getInitialTasks().add(task2);
		task1.getFinalTasks().add(task2);
		task1.getPrecedingTasks().add(task2);

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(0).getCode() == "PrecedingTasksAtSameLevel".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ComposedTask);
		assertEquals("task1", ((ComposedTask)diag.getChildren().get(0).getData().get(0)).getName());
	}

	/**
	 * Tests <code>FollowingTasksAtSameLevel</code> constraint.
	 */
	@Test
	public void followingTasksAtSameLevel() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		process.setTask(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task1.getTasks().add(task2);
		task1.getInitialTasks().add(task2);
		task1.getFinalTasks().add(task2);
		task1.getFollowingTasks().add(task2);

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(0).getCode() == "FollowingTasksAtSameLevel".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ComposedTask);
		assertEquals("task1", ((ComposedTask)diag.getChildren().get(0).getData().get(0)).getName());
	}

	/**
	 * Tests <code>PreconditionTasksArePreceding</code> constraint.
	 */
	@Test
	public void preconditionTasksArePreceding() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		process.setTask(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task3");
		task1.getTasks().add(task2);
		task1.getTasks().add(task3);
		task1.getInitialTasks().add(task2);
		task1.getInitialTasks().add(task3);
		task1.getFinalTasks().add(task3);
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		allDone.getTasks().add(task2);
		task1.setPrecondition(allDone);

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(0).getCode() == "PreconditionTasksArePreceding".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ComposedTask);
		assertEquals("task1", ((ComposedTask)diag.getChildren().get(0).getData().get(0)).getName());
	}

	/**
	 * Tests <code>PathExistance</code> constraint.
	 */
	@Test
	public void pathExistance() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		process.setTask(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task3");
		task1.getTasks().add(task2);
		task1.getTasks().add(task3);
		task1.getInitialTasks().add(task2);
		task1.getFinalTasks().add(task3);

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(3, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(0).getCode() == "PathExistance".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ComposedTask);
		assertEquals("task1", ((ComposedTask)diag.getChildren().get(0).getData().get(0)).getName());
	}

	/**
	 * Tests <code>InitialTasksAreContained</code> constraint.
	 */
	@Test
	public void initialTasksAreContained() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		process.setTask(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task3");
		task1.getTasks().add(task3);
		task1.getInitialTasks().add(task2);
		task1.getInitialTasks().add(task3);
		task1.getFinalTasks().add(task3);

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(1, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(0).getCode() == "InitialTasksAreContained".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ComposedTask);
		assertEquals("task1", ((ComposedTask)diag.getChildren().get(0).getData().get(0)).getName());
	}

	/**
	 * Tests <code>FinalTasksAreContained</code> constraint.
	 */
	@Test
	public void finalTasksAreContained() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		process.setTask(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task3");
		task1.getTasks().add(task3);
		task1.getInitialTasks().add(task3);
		task1.getFinalTasks().add(task2);
		task1.getFinalTasks().add(task3);

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(1, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(0).getCode() == "FinalTasksAreContained".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ComposedTask);
		assertEquals("task1", ((ComposedTask)diag.getChildren().get(0).getData().get(0)).getName());
	}

	/**
	 * Tests <code>DoneTasksAreFinal</code> constraint.
	 */
	@Test
	public void doneTasksAreFinal() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		final ComposedTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		task1.setName("task1");
		process.setTask(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task3");
		task1.getTasks().add(task2);
		task1.getTasks().add(task3);
		task1.getInitialTasks().add(task2);
		task1.getInitialTasks().add(task3);
		task1.getFinalTasks().add(task3);
		final AllDone allDone = ProcessPackage.eINSTANCE.getProcessFactory().createAllDone();
		allDone.getTasks().add(task2);
		task1.setDoneExpression(allDone);

		Diagnostic diag = Diagnostician.INSTANCE.validate(task1);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(0).getCode() == "DoneTasksAreFinal".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ComposedTask);
		assertEquals("task1", ((ComposedTask)diag.getChildren().get(0).getData().get(0)).getName());
	}

	/**
	 * Tests <code>VariableIsWrittenAtLeastOnce</code> constraint.
	 */
	@Test
	public void variableIsWrittenAtLeastOnce() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		composedTask.getTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		composedTask.getTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		composedTask.getInitialTasks().add(task1);
		composedTask.getFinalTasks().add(task2);
		final ProcessVariable variable1 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable1.setName("variable1");
		final ProcessVariable variable2 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable2.setName("variable2");

		process.getVariables().add(variable1);
		process.getVariables().add(variable2);
		task1.getWrittenVariables().add(variable2);
		task2.getObservedVariables().add(variable2);

		Diagnostic diag = Diagnostician.INSTANCE.validate(process);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.WARNING);
		assertTrue(diag.getChildren().get(0).getCode() == "VariableIsWrittenAtLeastOnce".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ProcessVariable);
		assertEquals("variable1", ((ProcessVariable)diag.getChildren().get(0).getData().get(0)).getName());

		task2.getObservedVariables().add(variable1);

		diag = Diagnostician.INSTANCE.validate(process);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(1).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(1).getCode() == "VariableIsWrittenAtLeastOnce".hashCode());
		assertTrue(diag.getChildren().get(1).getData().get(0) instanceof ProcessVariable);
		assertEquals("variable1", ((ProcessVariable)diag.getChildren().get(1).getData().get(0)).getName());
	}

	/**
	 * Tests <code>VariableIsObservedAtLeastOnce</code> constraint.
	 */
	@Test
	public void variableIsObservedAtLeastOnce() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		composedTask.getTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		composedTask.getTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		composedTask.getInitialTasks().add(task1);
		composedTask.getFinalTasks().add(task2);
		final ProcessVariable variable1 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable1.setName("variable1");
		final ProcessVariable variable2 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable2.setName("variable2");

		process.getVariables().add(variable1);
		process.getVariables().add(variable2);
		task1.getWrittenVariables().add(variable2);
		task2.getObservedVariables().add(variable2);

		Diagnostic diag = Diagnostician.INSTANCE.validate(process);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(1).getSeverity() == Diagnostic.WARNING);
		assertTrue(diag.getChildren().get(1).getCode() == "VariableIsObservedAtLeastOnce".hashCode());
		assertTrue(diag.getChildren().get(1).getData().get(0) instanceof ProcessVariable);
		assertEquals("variable1", ((ProcessVariable)diag.getChildren().get(1).getData().get(0)).getName());
	}

	/**
	 * Tests <code>ObservedVariableIsReachable</code> constraint.
	 */
	@Test
	public void observedVariableIsReachable() {
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask.setName("composedTask");
		process.setTask(composedTask);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		composedTask.getTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		composedTask.getTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		composedTask.getInitialTasks().add(task1);
		composedTask.getFinalTasks().add(task2);
		final ProcessVariable variable1 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable1.setName("variable1");
		final ProcessVariable variable2 = ProcessPackage.eINSTANCE.getProcessFactory()
				.createProcessVariable();
		variable2.setName("variable2");

		process.getVariables().add(variable1);
		process.getVariables().add(variable2);
		task1.getWrittenVariables().add(variable2);
		task2.getObservedVariables().add(variable2);
		task2.getObservedVariables().add(variable1);

		Diagnostic diag = Diagnostician.INSTANCE.validate(process);

		assertEquals(2, diag.getChildren().size());

		assertTrue(diag.getChildren().get(0).getSeverity() == Diagnostic.ERROR);
		assertTrue(diag.getChildren().get(0).getCode() == "ObservedVariableIsReachable".hashCode());
		assertTrue(diag.getChildren().get(0).getData().get(0) instanceof ActionTask);
		assertEquals("task2", ((ActionTask)diag.getChildren().get(0).getData().get(0)).getName());
		assertTrue(diag.getChildren().get(0).getData().get(1) instanceof List<?>);
		assertEquals(1, ((List<?>)diag.getChildren().get(0).getData().get(1)).size());
		assertEquals(variable1, ((List<?>)diag.getChildren().get(0).getData().get(1)).get(0));
	}

}
