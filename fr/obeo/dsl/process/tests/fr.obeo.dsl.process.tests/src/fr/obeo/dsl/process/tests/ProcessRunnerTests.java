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

import fr.obeo.dsl.process.AbstractActionTaskProcessor;
import fr.obeo.dsl.process.AbstractProcessRunner;
import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.IActionTaskProcessor;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessVariable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link AbstractProcessRunner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ProcessRunnerTests {

	/**
	 * {@link TestTask} class name.
	 */
	private static final String INSTANCE_CLASS_NAME = ProcessRunnerTests.class.getCanonicalName() + "$"
			+ TestTask.class.getSimpleName();

	/**
	 * A test implementation that does nothing more.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private static final class TestProcessRunner extends AbstractProcessRunner {

		/**
		 * Number of times the
		 * {@link TestTask#variableChanged(ProcessContext, ProcessVariable, Object, Object) variable changed}
		 * method has been called.
		 */
		private int nbVariableChanged;

		/**
		 * Constructor.
		 * 
		 * @param processContext
		 *            the {@link ProcessContext}
		 * @param listenToVariable
		 *            tells if we should listen to
		 *            {@link ProcessContext#setVariableValue(ProcessVariable, Object, ActionTask)} and
		 *            {@link ProcessContext#getVariableValue(ProcessVariable, ActionTask)}.
		 */
		public TestProcessRunner(ProcessContext processContext, boolean listenToVariable) {
			super(processContext, listenToVariable);
		}

		/**
		 * Tells if the given {@link ActionTask} is active.
		 * 
		 * @param task
		 *            the {@link ActionTask}
		 * @return <code>true</code> if the given {@link ActionTask} is active, <code>false</code> otherwise
		 */
		public boolean isActive(ActionTask task) {
			return getActiveProcessors().containsKey(task);
		}

		/**
		 * Gets the {@link IActionTaskProcessor} for the given {@link ActionTask}.
		 * 
		 * @param task
		 *            the {@link ActionTask}
		 * @return the {@link IActionTaskProcessor} for the given {@link ActionTask} if any, <code>null</code>
		 *         otherwise
		 */
		public IActionTaskProcessor getProcessor(ActionTask task) {
			return getProcessors().get(task);
		}

		@Override
		public void variableChanged(ProcessContext context, ProcessVariable variable, Object oldValue,
				Object newValue) {
			nbVariableChanged++;
		}

	}

	/**
	 * Test implementation of {@link AbstractActionTaskProcessor}.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static final class TestTask extends AbstractActionTaskProcessor {

		/**
		 * Number of times the {@link TestTask#validate(ProcessContext) validate} method has been called.
		 */
		private int nbValidations;

		/**
		 * Number of times the {@link TestTask#doAction(ProcessContext) do action} method has been called.
		 */
		private int nbDoActions;

		/**
		 * Number of times the {@link TestTask#undoAction(ProcessContext) undo action} method has been called.
		 */
		private int nbUndoActions;

		/**
		 * Number of times the
		 * {@link TestTask#variableChanged(ProcessContext, ProcessVariable, Object, Object) variable changed}
		 * method has been called.
		 */
		private int nbVariableChanged;

		/**
		 * Constructor.
		 * 
		 * @param task
		 *            the definition {@link ActionTask}
		 */
		public TestTask(ActionTask task) {
			super(task);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see fr.obeo.dsl.process.IActionTaskProcessor#validate(fr.obeo.dsl.process.ProcessContext)
		 */
		public void validate(ProcessContext context) {
			nbValidations++;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see fr.obeo.dsl.process.IActionTaskProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
		 */
		public void doAction(ProcessContext context) {
			nbDoActions++;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see fr.obeo.dsl.process.IActionTaskProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
		 */
		public void undoAction(ProcessContext context) {
			nbUndoActions++;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see fr.obeo.dsl.process.IActionTaskProcessor#variableChanged(fr.obeo.dsl.process.ProcessContext,
		 *      fr.obeo.dsl.process.ProcessVariable, java.lang.Object, java.lang.Object)
		 */
		public void variableChanged(ProcessContext context, ProcessVariable variable, Object oldValue,
				Object newValue) {
			nbVariableChanged++;
		}

	}

	/**
	 * Tests initial tasks activation.
	 */
	@Test
	public void testInitialProcessTaskActivates() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask1.getTasks().add(task1);
		composedTask1.getInitialTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask1.getTasks().add(task2);
		composedTask1.getFinalTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		context.setDefinition(process);

		TestProcessRunner runner = new TestProcessRunner(context, false);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests initial tasks activation.
	 */
	@Test
	public void testTaskActivatesWhenPreconditionIsTrue() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask2.setName("composedTask2");
		composedTask1.getTasks().add(composedTask2);
		composedTask1.getInitialTasks().add(composedTask2);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask2.getTasks().add(task1);
		composedTask2.getInitialTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask2.getTasks().add(task2);
		composedTask2.getFinalTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task3.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask1.getTasks().add(task3);
		composedTask2.getFollowingTasks().add(task3);
		composedTask1.getFinalTasks().add(task3);
		context.setDefinition(process);

		TestProcessRunner runner = new TestProcessRunner(context, false);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);
		TestTask taskProcessor3 = (TestTask)runner.getProcessor(task3);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		assertEquals(false, runner.isActive(task3));
		assertEquals(0, taskProcessor3.nbValidations);
		assertEquals(0, taskProcessor3.nbDoActions);
		assertEquals(0, taskProcessor3.nbUndoActions);
		assertEquals(0, taskProcessor3.nbVariableChanged);

		context.setDone(task1, this);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		assertEquals(false, runner.isActive(task3));
		assertEquals(0, taskProcessor3.nbValidations);
		assertEquals(0, taskProcessor3.nbDoActions);
		assertEquals(0, taskProcessor3.nbUndoActions);
		assertEquals(0, taskProcessor3.nbVariableChanged);

		context.setDone(task2, this);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task3));
		assertEquals(1, taskProcessor3.nbValidations);
		assertEquals(0, taskProcessor3.nbDoActions);
		assertEquals(0, taskProcessor3.nbUndoActions);
		assertEquals(0, taskProcessor3.nbVariableChanged);
	}

	/**
	 * Tests initial tasks activation.
	 */
	@Test
	public void testTaskDeactivatesWhenPreconditionIsFalse() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask2.setName("composedTask2");
		composedTask1.getTasks().add(composedTask2);
		composedTask1.getInitialTasks().add(composedTask2);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask2.getTasks().add(task1);
		composedTask2.getInitialTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask2.getTasks().add(task2);
		composedTask2.getFinalTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("task3");
		task3.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask1.getTasks().add(task3);
		composedTask2.getFollowingTasks().add(task3);
		composedTask1.getFinalTasks().add(task3);
		context.setDefinition(process);

		TestProcessRunner runner = new TestProcessRunner(context, false);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);
		TestTask taskProcessor3 = (TestTask)runner.getProcessor(task3);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		assertEquals(false, runner.isActive(task3));
		assertEquals(0, taskProcessor3.nbValidations);
		assertEquals(0, taskProcessor3.nbDoActions);
		assertEquals(0, taskProcessor3.nbUndoActions);
		assertEquals(0, taskProcessor3.nbVariableChanged);

		context.setDone(task1, this);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		assertEquals(false, runner.isActive(task3));
		assertEquals(0, taskProcessor3.nbValidations);
		assertEquals(0, taskProcessor3.nbDoActions);
		assertEquals(0, taskProcessor3.nbUndoActions);
		assertEquals(0, taskProcessor3.nbVariableChanged);

		context.setDone(task2, this);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task3));
		assertEquals(1, taskProcessor3.nbValidations);
		assertEquals(0, taskProcessor3.nbDoActions);
		assertEquals(0, taskProcessor3.nbUndoActions);
		assertEquals(0, taskProcessor3.nbVariableChanged);

		context.setUndone(task2, "Test");

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(false, runner.isActive(task3));
		assertEquals(1, taskProcessor3.nbValidations);
		assertEquals(0, taskProcessor3.nbDoActions);
		assertEquals(0, taskProcessor3.nbUndoActions);
		assertEquals(0, taskProcessor3.nbVariableChanged);

		context.setUndone(task1, "Test");

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests variable changes.
	 */
	@Test
	public void testVariableChangeNotListening() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask1.getTasks().add(task1);
		composedTask1.getInitialTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask1.getTasks().add(task2);
		composedTask1.getFinalTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		ProcessVariable variable1 = ProcessPackage.eINSTANCE.getProcessFactory().createProcessVariable();
		variable1.setName("variable1");
		process.getVariables().add(variable1);
		task1.getWrittenVariables().add(variable1);
		task2.getObservedVariables().add(variable1);
		context.setDefinition(process);

		TestProcessRunner runner = new TestProcessRunner(context, false);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable1, new Object(), task1);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setDone(task1, this);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable1, new Object(), task1);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests variable changes.
	 */
	@Test
	public void testVariableChangeListening() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask1.getTasks().add(task1);
		composedTask1.getInitialTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		composedTask1.getTasks().add(task2);
		composedTask1.getFinalTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		ProcessVariable variable1 = ProcessPackage.eINSTANCE.getProcessFactory().createProcessVariable();
		variable1.setName("variable1");
		process.getVariables().add(variable1);
		task1.getWrittenVariables().add(variable1);
		task2.getObservedVariables().add(variable1);
		context.setDefinition(process);

		TestProcessRunner runner = new TestProcessRunner(context, true);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable1, new Object(), task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setDone(task1, this);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable1, new Object(), task1);

		assertEquals(2, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

}
