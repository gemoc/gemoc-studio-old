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
package fr.obeo.dsl.process.workspace.tests;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor;
import fr.obeo.dsl.process.workspace.WorkspaceProcessRunner;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.ProcessworkspacePackage;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceClosed;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceContentChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceDescriptionChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceOpened;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;
import fr.obeo.dsl.workspace.listener.change.workbench.PageActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PageClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.PageOpened;
import fr.obeo.dsl.workspace.listener.change.workbench.PartActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PartBroughtToTop;
import fr.obeo.dsl.workspace.listener.change.workbench.PartClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.PartDeactivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PartHidden;
import fr.obeo.dsl.workspace.listener.change.workbench.PartInputChanged;
import fr.obeo.dsl.workspace.listener.change.workbench.PartOpened;
import fr.obeo.dsl.workspace.listener.change.workbench.PartVisible;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowDeactivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowOpened;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link WorkspaceProcessRunner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkspaceProcessRunnerTests {

	/**
	 * {@link TestTask} class name.
	 */
	private static final String INSTANCE_CLASS_NAME = WorkspaceProcessRunnerTests.class.getCanonicalName()
			+ "$" + TestTask.class.getSimpleName();

	/**
	 * Test implementation of {@link AbstractWorkspaceTaskProcessor}.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static final class TestTask extends AbstractWorkspaceTaskProcessor {

		/**
		 * Number of times the {@link TestTask#validate(ProcessContext) validate} method has been called.
		 */
		private int nbValidations;

		/**
		 * Number of times the {@link TestTask#validate(ProcessContext, IChange)} method has been called.
		 */
		private int nbWorkspaceValidations;

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
		 * @see fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#validate(fr.obeo.dsl.process.ProcessContext)
		 */
		public void validate(ProcessContext context) {
			nbValidations++;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see fr.obeo.dsl.process.workspace.IWorkspaceTaskProcessor#validate(fr.obeo.dsl.process.ProcessContext,
		 *      fr.obeo.dsl.workspace.listener.change.IChange)
		 */
		public void validate(ProcessContext context, IChange<?> change) {
			nbWorkspaceValidations++;
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
	 * Tests the {@link ResourceAdded} with an {@link IFile}.
	 */
	@Test
	public void addedFileNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));

		runner.process(new ResourceAdded(file));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, file, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceAdded(file));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceRemoved} with an {@link IFile}.
	 */
	@Test
	public void removedFileNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));

		runner.process(new ResourceRemoved(file));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, file, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceRemoved(file));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceMoved} with an {@link IFile}.
	 */
	@Test
	public void movedFileNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFile origine = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test2.keep"));

		runner.process(new ResourceMoved(origine, destination));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, origine, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceMoved(origine, destination));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceContentChanged} with an {@link IFile}.
	 */
	@Test
	public void changedFileNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));

		runner.process(new ResourceContentChanged(file));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, file, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceContentChanged(file));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceAdded} with an {@link IFile}.
	 */
	@Test
	public void addedFileActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));
		context.setDone(task1, new Object());

		runner.process(new ResourceAdded(file));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, file, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceAdded(file));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceRemoved} with an {@link IFile}.
	 */
	@Test
	public void removedFileActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));
		context.setDone(task1, new Object());

		runner.process(new ResourceRemoved(file));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, file, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceRemoved(file));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceMoved} with an {@link IFile}.
	 */
	@Test
	public void movedFileActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFile origin = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test2.keep"));
		context.setDone(task1, new Object());

		runner.process(new ResourceMoved(origin, destination));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, origin, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceMoved(origin, destination));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceContentChanged} with an {@link IFile}.
	 */
	@Test
	public void changedFileActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));
		context.setDone(task1, new Object());

		runner.process(new ResourceContentChanged(file));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, file, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceContentChanged(file));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceAdded} with an {@link IFolder}.
	 */
	@Test
	public void addedFolderNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test.keep"));

		runner.process(new ResourceAdded(folder));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, folder, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceAdded(folder));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceRemoved} with an {@link IFolder}.
	 */
	@Test
	public void removedFolderNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test.keep"));

		runner.process(new ResourceRemoved(folder));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, folder, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceRemoved(folder));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceMoved} with an {@link IFolder}.
	 */
	@Test
	public void movedFolderNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFolder origine = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test.keep"));
		final IFolder destination = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test2.keep"));

		runner.process(new ResourceMoved(origine, destination));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, origine, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceMoved(origine, destination));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceContentChanged} with an {@link IFolder}.
	 */
	@Test
	public void changedFolderNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test.keep"));

		runner.process(new ResourceContentChanged(folder));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, folder, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceContentChanged(folder));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceAdded} with an {@link IFolder}.
	 */
	@Test
	public void addedFolderActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test.keep"));
		context.setDone(task1, new Object());

		runner.process(new ResourceAdded(folder));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, folder, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceAdded(folder));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceRemoved} with an {@link IFolder}.
	 */
	@Test
	public void removedFolderActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test.keep"));
		context.setDone(task1, new Object());

		runner.process(new ResourceRemoved(folder));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, folder, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceRemoved(folder));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceMoved} with an {@link IFolder}.
	 */
	@Test
	public void movedFolderActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFolder origin = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test.keep"));
		final IFolder destination = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test2.keep"));
		context.setDone(task1, new Object());

		runner.process(new ResourceMoved(origin, destination));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, origin, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceMoved(origin, destination));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceContentChanged} with an {@link IFolder}.
	 */
	@Test
	public void changedFolderActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder/test.keep"));
		context.setDone(task1, new Object());

		runner.process(new ResourceContentChanged(folder));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, folder, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceContentChanged(folder));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceAdded} with an {@link IProject}.
	 */
	@Test
	public void addedProjectNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");

		runner.process(new ResourceAdded(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceAdded(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceRemoved} with an {@link IProject}.
	 */
	@Test
	public void removedProjectNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");

		runner.process(new ResourceRemoved(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceRemoved(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceMoved} with an {@link IProject}.
	 */
	@Test
	public void movedProjectNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject origine = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");
		final IProject destination = ResourcesPlugin.getWorkspace().getRoot().getProject("keep2");

		runner.process(new ResourceMoved(origine, destination));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, origine, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceMoved(origine, destination));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceContentChanged} with an {@link IProject}.
	 */
	@Test
	public void changedProjectNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");

		runner.process(new ResourceContentChanged(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceContentChanged(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceDescriptionChanged} with an {@link IProject}.
	 */
	@Test
	public void resourceDescriptionChangedProjdectNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");

		runner.process(new ResourceDescriptionChanged(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceDescriptionChanged(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceOpened} with an {@link IProject}.
	 */
	@Test
	public void resourceOpenedProjdectNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");

		runner.process(new ResourceOpened(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceOpened(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceClosed} with an {@link IProject}.
	 */
	@Test
	public void resourceClosedProjdectNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");

		runner.process(new ResourceClosed(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceClosed(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link ResourceAdded} with an {@link IProject}.
	 */
	@Test
	public void addedProjectActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");
		context.setDone(task1, new Object());

		runner.process(new ResourceAdded(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceAdded(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceRemoved} with an {@link IProject}.
	 */
	@Test
	public void removedProjectActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");
		context.setDone(task1, new Object());

		runner.process(new ResourceRemoved(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceRemoved(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceMoved} with an {@link IProject}.
	 */
	@Test
	public void movedProjectActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject origin = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");
		final IProject destination = ResourcesPlugin.getWorkspace().getRoot().getProject("keep2");
		context.setDone(task1, new Object());

		runner.process(new ResourceMoved(origin, destination));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, origin, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceMoved(origin, destination));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceContentChanged} with an {@link IProject}.
	 */
	@Test
	public void changedProjectActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");
		context.setDone(task1, new Object());

		runner.process(new ResourceContentChanged(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceContentChanged(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceDescriptionChanged} with an {@link IProject}.
	 */
	@Test
	public void resourceDescriptionChangedProjectActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");
		context.setDone(task1, new Object());

		runner.process(new ResourceDescriptionChanged(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceDescriptionChanged(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceOpened} with an {@link IProject}.
	 */
	@Test
	public void resourceOpenedProjectActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");
		context.setDone(task1, new Object());

		runner.process(new ResourceOpened(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceOpened(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link ResourceClosed} with an {@link IProject}.
	 */
	@Test
	public void resourceClosedProjectActive() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("keep");
		context.setDone(task1, new Object());

		runner.process(new ResourceClosed(project));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, project, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new ResourceClosed(project));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link WindowOpened}.
	 */
	@Test
	public void windowOpenedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		runner.process(new WindowOpened(window));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, window, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new WindowOpened(window));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link WindowActivated}.
	 */
	@Test
	public void windowActivatedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		runner.process(new WindowActivated(window));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, window, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new WindowActivated(window));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link WindowDeactivated}.
	 */
	@Test
	public void windowDeactivatedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		runner.process(new WindowDeactivated(window));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, window, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new WindowDeactivated(window));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link WindowClosed}.
	 */
	@Test
	public void windowClosedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		runner.process(new WindowClosed(window));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, window, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new WindowClosed(window));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link WindowOpened}.
	 */
	@Test
	public void windowOpenedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		context.setDone(task1, new Object());

		runner.process(new WindowOpened(window));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, window, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new WindowOpened(window));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link WindowActivated}.
	 */
	@Test
	public void windowActivatedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		context.setDone(task1, new Object());

		runner.process(new WindowActivated(window));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, window, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new WindowActivated(window));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link WindowDeactivated}.
	 */
	@Test
	public void windowDeactivatedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		context.setDone(task1, new Object());

		runner.process(new WindowDeactivated(window));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, window, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new WindowDeactivated(window));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link WindowClosed}.
	 */
	@Test
	public void windowClosedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		context.setDone(task1, new Object());

		runner.process(new WindowClosed(window));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, window, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new WindowClosed(window));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PageOpened}.
	 */
	@Test
	public void pageOpenedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		runner.process(new PageOpened(page));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, page, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PageOpened(page));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PageActivated}.
	 */
	@Test
	public void pageActivatedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		runner.process(new PageActivated(page));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, page, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PageActivated(page));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PageClosed}.
	 */
	@Test
	public void pageClosedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		runner.process(new PageClosed(page));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, page, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PageClosed(page));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PageOpened}.
	 */
	@Test
	public void pageOpenedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		context.setDone(task1, new Object());

		runner.process(new PageOpened(page));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, page, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PageOpened(page));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PageActivated}.
	 */
	@Test
	public void pageActivatedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		context.setDone(task1, new Object());

		runner.process(new PageActivated(page));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, page, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PageActivated(page));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PageClosed}.
	 */
	@Test
	public void pageClosedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		context.setDone(task1, new Object());

		runner.process(new PageClosed(page));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, page, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PageClosed(page));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PartOpened}.
	 */
	@Test
	public void partOpenedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();

		runner.process(new PartOpened(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PartOpened(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PartActivated}.
	 */
	@Test
	public void partActivatedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();

		runner.process(new PartActivated(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PartActivated(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PartDeactivated}.
	 */
	@Test
	public void partDeactivatedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();

		runner.process(new PartDeactivated(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PartDeactivated(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PartBroughtToTop}.
	 */
	@Test
	public void partBroughtToTopNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();

		runner.process(new PartBroughtToTop(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PartBroughtToTop(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PartHidden}.
	 */
	@Test
	public void partHiddenNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();

		runner.process(new PartHidden(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PartHidden(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PartInputChanged}.
	 */
	@Test
	public void partInputChangedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();

		runner.process(new PartInputChanged(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PartInputChanged(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PartVisible}.
	 */
	@Test
	public void partVisibleNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();

		runner.process(new PartVisible(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PartVisible(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PartClosed}.
	 */
	@Test
	public void partClosedNotActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();

		runner.process(new PartClosed(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		runner.process(new PartClosed(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
	 * Tests the {@link PartOpened}.
	 */
	@Test
	public void partOpenedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		context.setDone(task1, new Object());

		runner.process(new PartOpened(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PartOpened(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PartActivated}.
	 */
	@Test
	public void partActivatedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		context.setDone(task1, new Object());

		runner.process(new PartActivated(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PartActivated(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PartDeactivated}.
	 */
	@Test
	public void partDeactivatedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		context.setDone(task1, new Object());

		runner.process(new PartDeactivated(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PartDeactivated(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PartBroughtToTop}.
	 */
	@Test
	public void partBroughtToTopActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		context.setDone(task1, new Object());

		runner.process(new PartBroughtToTop(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PartBroughtToTop(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PartHidden}.
	 */
	@Test
	public void partHiddenActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		context.setDone(task1, new Object());

		runner.process(new PartHidden(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PartHidden(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PartInputChanged}.
	 */
	@Test
	public void partInputChangedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		context.setDone(task1, new Object());

		runner.process(new PartInputChanged(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PartInputChanged(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PartVisible}.
	 */
	@Test
	public void partVisibleActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		context.setDone(task1, new Object());

		runner.process(new PartVisible(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PartVisible(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);
	}

	/**
	 * Tests the {@link PartClosed}.
	 */
	@Test
	public void partClosedActiveObserver() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("composedTask1");
		process.setTask(composedTask1);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("task1");
		task1.setInstanceClassName(INSTANCE_CLASS_NAME);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("task2");
		task2.setInstanceClassName(INSTANCE_CLASS_NAME);
		task1.getFollowingTasks().add(task2);
		composedTask1.getTasks().add(task1);
		composedTask1.getTasks().add(task2);
		composedTask1.getInitialTasks().add(task1);
		composedTask1.getFinalTasks().add(task2);
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		variable.setName("variable");
		process.getVariables().add(variable);
		task1.getWrittenVariables().add(variable);
		task2.getObservedVariables().add(variable);

		final TestProcessRunner runner = new TestProcessRunner(context);
		TestTask taskProcessor1 = (TestTask)runner.getProcessor(task1);
		TestTask taskProcessor2 = (TestTask)runner.getProcessor(task2);

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(0, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(false, runner.isActive(task2));
		assertEquals(0, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		context.setDone(task1, new Object());

		runner.process(new PartClosed(part));

		assertEquals(0, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(0, taskProcessor2.nbVariableChanged);

		context.setVariableValue(variable, part, task1);

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(1, taskProcessor1.nbWorkspaceValidations);
		assertEquals(0, taskProcessor1.nbDoActions);
		assertEquals(0, taskProcessor1.nbUndoActions);
		assertEquals(0, taskProcessor1.nbVariableChanged);

		assertEquals(true, runner.isActive(task2));
		assertEquals(1, taskProcessor2.nbValidations);
		assertEquals(0, taskProcessor2.nbDoActions);
		assertEquals(0, taskProcessor2.nbUndoActions);
		assertEquals(1, taskProcessor2.nbVariableChanged);

		runner.process(new PartClosed(part));

		assertEquals(1, runner.nbVariableChanged);

		assertEquals(true, runner.isActive(task1));
		assertEquals(1, taskProcessor1.nbValidations);
		assertEquals(2, taskProcessor1.nbWorkspaceValidations);
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
