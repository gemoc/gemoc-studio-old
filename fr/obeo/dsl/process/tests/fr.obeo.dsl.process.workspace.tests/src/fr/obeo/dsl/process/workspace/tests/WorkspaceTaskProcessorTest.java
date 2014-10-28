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
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.workspace.tests.internal.TestWorkspaceTaskProcessor;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.PageVariable;
import fr.obeo.dsl.processworkspace.PartVariable;
import fr.obeo.dsl.processworkspace.ProcessworkspacePackage;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.processworkspace.WindowVariable;
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
 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor AbstractWorkspaceTaskProcessor}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkspaceTaskProcessorTest {

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFileAdded(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void knownFileAdded() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, file, task);

		runner.process(new ResourceAdded(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFileAdded());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFileClosed(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void knownFileClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, file, task);

		runner.process(new ResourceClosed(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFileClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFileContentChanged(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void knownFileContentChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, file, task);

		runner.process(new ResourceContentChanged(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFileContentChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFileDescriptionChanged(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void knownFileDescriptionChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, file, task);

		runner.process(new ResourceDescriptionChanged(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFileDescriptionChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFileMoved(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void knownFileMoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/test2.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, file, task);

		runner.process(new ResourceMoved(file, destination));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFileMoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFileOpened(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void knownFileOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, file, task);

		runner.process(new ResourceOpened(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFileOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFileRemoved(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void knownFileRemoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, file, task);

		runner.process(new ResourceRemoved(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFileRemoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFileAdded(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void unknownFileAdded() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceAdded(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFileAdded());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFileClosed(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void unknownFileClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceClosed(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFileClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFileContentChanged(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void unknownFileContentChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceContentChanged(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFileContentChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFileDescriptionChanged(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void unknownFileDescriptionChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceDescriptionChanged(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFileDescriptionChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFileMoved(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void unknownFileMoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/test2.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceMoved(file, destination));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFileMoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFileOpened(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void unknownFileOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceOpened(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFileOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFileRemoved(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	@Test
	public void unknownFileRemoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/test.txt"));
		final FileVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceRemoved(file));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFileRemoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFolderAdded(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void knownFolderAdded() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, folder, task);

		runner.process(new ResourceAdded(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFolderAdded());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFolderClosed(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void knownFolderClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, folder, task);

		runner.process(new ResourceClosed(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFolderClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFolderContentChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void knownFolderContentChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, folder, task);

		runner.process(new ResourceContentChanged(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFolderContentChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFolderDescriptionChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void knownFolderDescriptionChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, folder, task);

		runner.process(new ResourceDescriptionChanged(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFolderDescriptionChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFolderMoved(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void knownFolderMoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final IFolder destination = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/test2.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, folder, task);

		runner.process(new ResourceMoved(folder, destination));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFolderMoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFolderOpened(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void knownFolderOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, folder, task);

		runner.process(new ResourceOpened(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFolderOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownFolderRemoved(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void knownFolderRemoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, folder, task);

		runner.process(new ResourceRemoved(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownFolderRemoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFolderAdded(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void unknownFolderAdded() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceAdded(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFolderAdded());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFolderClosed(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void unknownFolderClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceClosed(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFolderClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFolderContentChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void unknownFolderContentChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceContentChanged(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFolderContentChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFolderDescriptionChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void unknownFolderDescriptionChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceDescriptionChanged(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFolderDescriptionChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFolderMoved(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void unknownFolderMoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final IFolder destination = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/test2.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceMoved(folder, destination));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFolderMoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFolderOpened(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void unknownFolderOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceOpened(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFolderOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownFolderRemoved(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	@Test
	public void unknownFolderRemoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path("/test/test.txt"));
		final FolderVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceRemoved(folder));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownFolderRemoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownProjectAdded(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void knownProjectAdded() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, project, task);

		runner.process(new ResourceAdded(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownProjectAdded());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownProjectClosed(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void knownProjectClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, project, task);

		runner.process(new ResourceClosed(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownProjectClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownProjectContentChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void knownProjectContentChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, project, task);

		runner.process(new ResourceContentChanged(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownProjectContentChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownProjectDescriptionChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void knownProjectDescriptionChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, project, task);

		runner.process(new ResourceDescriptionChanged(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownProjectDescriptionChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownProjectMoved(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void knownProjectMoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final IProject destination = ResourcesPlugin.getWorkspace().getRoot().getProject("test2");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, project, task);

		runner.process(new ResourceMoved(project, destination));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownProjectMoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownProjectOpened(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void knownProjectOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, project, task);

		runner.process(new ResourceOpened(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownProjectOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownProjectRemoved(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void knownProjectRemoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, project, task);

		runner.process(new ResourceRemoved(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownProjectRemoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownProjectAdded(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void unknownProjectAdded() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceAdded(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownProjectAdded());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownProjectClosed(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void unknownProjectClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceClosed(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownProjectClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownProjectContentChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void unknownProjectContentChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceContentChanged(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownProjectContentChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownProjectDescriptionChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void unknownProjectDescriptionChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceDescriptionChanged(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownProjectDescriptionChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownProjectMoved(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void unknownProjectMoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final IProject destination = ResourcesPlugin.getWorkspace().getRoot().getProject("test2");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceMoved(project, destination));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownProjectMoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownProjectOpened(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void unknownProjectOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceOpened(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownProjectOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownProjectRemoved(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	@Test
	public void unknownProjectRemoved() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final ProjectVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new ResourceRemoved(project));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownProjectRemoved());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPartActivated} .
	 */
	@Test
	public void knownPartActivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, part, task);

		runner.process(new PartActivated(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPartActivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPartBroughtToTop} .
	 */
	@Test
	public void knownPartBroughtToTop() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, part, task);

		runner.process(new PartBroughtToTop(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPartBroughtToTop());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPartClosed} .
	 */
	@Test
	public void knownPartClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, part, task);

		runner.process(new PartClosed(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPartClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPartDeactivated} .
	 */
	@Test
	public void knownPartDeactivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, part, task);

		runner.process(new PartDeactivated(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPartDeactivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPartHidden} .
	 */
	@Test
	public void knownPartHidden() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, part, task);

		runner.process(new PartHidden(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPartHidden());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPartPartInputChanged} .
	 */
	@Test
	public void knownPartPartInputChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, part, task);

		runner.process(new PartInputChanged(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPartPartInputChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPartOpened} .
	 */
	@Test
	public void knownPartOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, part, task);

		runner.process(new PartOpened(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPartOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPartVisible} .
	 */
	@Test
	public void knownPartVisible() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, part, task);

		runner.process(new PartVisible(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPartVisible());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPartActivated} .
	 */
	@Test
	public void unknownPartActivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PartActivated(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPartActivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPartBroughtToTop} .
	 */
	@Test
	public void unknownPartBroughtToTop() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PartBroughtToTop(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPartBroughtToTop());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPartClosed} .
	 */
	@Test
	public void unknownPartClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PartClosed(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPartClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPartDeactivated} .
	 */
	@Test
	public void unknownPartDeactivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PartDeactivated(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPartDeactivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPartHidden} .
	 */
	@Test
	public void unknownPartHidden() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PartHidden(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPartHidden());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPartPartInputChanged}
	 * .
	 */
	@Test
	public void unknownPartPartInputChanged() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PartInputChanged(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPartPartInputChanged());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPartOpened} .
	 */
	@Test
	public void unknownPartOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PartOpened(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPartOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPartVisible} .
	 */
	@Test
	public void unknownPartVisible() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPartReference part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActivePartReference();
		final PartVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPartVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PartVisible(part));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPartVisible());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPageActivated} .
	 */
	@Test
	public void knownPageActivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final PageVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPageVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, page, task);

		runner.process(new PageActivated(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPageActivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPageClosed} .
	 */
	@Test
	public void knownPageClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final PageVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPageVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, page, task);

		runner.process(new PageClosed(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPageClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownPageOpened} .
	 */
	@Test
	public void knownPageOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final PageVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPageVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, page, task);

		runner.process(new PageOpened(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownPageOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPageActivated} .
	 */
	@Test
	public void unknownPageActivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final PageVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPageVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PageActivated(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPageActivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPageClosed} .
	 */
	@Test
	public void unknownPageClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final PageVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPageVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PageClosed(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPageClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownPageOpened} .
	 */
	@Test
	public void unknownPageOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final PageVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createPageVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new PageOpened(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownPageOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownWindowActivated} .
	 */
	@Test
	public void knownWindowActivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final WindowVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createWindowVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, page, task);

		runner.process(new WindowActivated(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownWindowActivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownWindowClosed} .
	 */
	@Test
	public void knownWindowClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final WindowVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createWindowVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, page, task);

		runner.process(new WindowClosed(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownWindowClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownWindowDeactivated} .
	 */
	@Test
	public void knownWindowDeactivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final WindowVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createWindowVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, page, task);

		runner.process(new WindowDeactivated(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownWindowDeactivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#knownWindowOpened} .
	 */
	@Test
	public void knownWindowOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final WindowVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createWindowVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		context.setVariableValue(variable, page, task);

		runner.process(new WindowOpened(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getKnownWindowOpened());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownWindowActivated} .
	 */
	@Test
	public void unknownWindowActivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final WindowVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createWindowVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new WindowActivated(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownWindowActivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownWindowClosed} .
	 */
	@Test
	public void unknownWindowClosed() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final WindowVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createWindowVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new WindowClosed(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownWindowClosed());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownWindowDeactivated} .
	 */
	@Test
	public void unknownWindowDeactivated() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final WindowVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createWindowVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new WindowDeactivated(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownWindowDeactivated());
		assertEquals(1, processor.getTotalCalls());
	}

	/**
	 * Tests {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#unknownWindowOpened} .
	 */
	@Test
	public void unknownWindowOpened() {
		final ProcessContext context = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		context.setName("context");
		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("process");
		context.setDefinition(process);
		final IWorkbenchWindow page = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final WindowVariable variable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createWindowVariable();
		process.getVariables().add(variable);
		final ActionTask task = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task.setName("task");
		task.getWrittenVariables().add(variable);
		task.setInstanceClassName(TestWorkspaceTaskProcessor.class.getCanonicalName());
		process.setTask(task);
		final TestProcessRunner runner = new TestProcessRunner(context);

		runner.process(new WindowOpened(page));
		final TestWorkspaceTaskProcessor processor = (TestWorkspaceTaskProcessor)runner.getProcessor(task);

		assertEquals(1, processor.getUnknownWindowOpened());
		assertEquals(1, processor.getTotalCalls());
	}

}
