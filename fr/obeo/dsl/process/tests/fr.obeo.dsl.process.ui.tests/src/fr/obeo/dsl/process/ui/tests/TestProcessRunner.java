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
package fr.obeo.dsl.process.ui.tests;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ui.tests.tasks.CreateGenFile;
import fr.obeo.dsl.process.ui.tests.tasks.CreateProject;
import fr.obeo.dsl.process.ui.tests.tasks.CreateSrcGenFolder;
import fr.obeo.dsl.process.workspace.WorkspaceProcessRunner;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.ProcessworkspacePackage;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.workspace.listener.IListener;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;

import org.eclipse.core.resources.ResourcesPlugin;

/**
 * A test implementation of {@link WorkspaceProcessRunner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TestProcessRunner extends WorkspaceProcessRunner {

	/**
	 * Constructor.
	 */
	public TestProcessRunner() {
		super(getProcessContext());
		final IListener listener = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());
		listener.addProcessor(this, true);
	}

	/**
	 * Gets the test {@link ProcessContext}.
	 * 
	 * @return the test {@link ProcessContext}
	 */
	private static ProcessContext getProcessContext() {
		final ProcessContext res = ProcessPackage.eINSTANCE.getProcessFactory().createProcessContext();
		res.setName("Test");

		final Process process = ProcessPackage.eINSTANCE.getProcessFactory().createProcess();
		process.setName("test process");
		res.setDefinition(process);
		final ComposedTask composedTask1 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask1.setName("Generate");
		process.setTask(composedTask1);
		final ComposedTask composedTask2 = ProcessPackage.eINSTANCE.getProcessFactory().createComposedTask();
		composedTask2.setName("Setup generation");
		composedTask1.getTasks().add(composedTask2);
		composedTask1.getInitialTasks().add(composedTask2);
		final ActionTask task1 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task1.setName("Create a project");
		task1.setDescription("Create a new project into the workspace");
		task1.setInstanceClassName(CreateProject.class.getCanonicalName());
		composedTask2.getTasks().add(task1);
		composedTask2.getInitialTasks().add(task1);
		final ActionTask task2 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task2.setName("Create a file with " + CreateGenFile.EXTENSION + " extension");
		task2.setDescription("Create a new file with " + CreateGenFile.EXTENSION + " extension");
		task2.setInstanceClassName(CreateGenFile.class.getCanonicalName());
		composedTask2.getTasks().add(task2);
		composedTask2.getFinalTasks().add(task2);
		task1.getFollowingTasks().add(task2);
		final ActionTask task3 = ProcessPackage.eINSTANCE.getProcessFactory().createActionTask();
		task3.setName("Create a folder src-gen after the name of the gen file");
		task3.setDescription("Create a new folder src-gen after the name of the gen file");
		task3.setInstanceClassName(CreateSrcGenFolder.class.getCanonicalName());
		composedTask1.getTasks().add(task3);
		composedTask2.getFollowingTasks().add(task3);
		composedTask1.getFinalTasks().add(task3);
		ProjectVariable projectVariable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createProjectVariable();
		projectVariable.setName("project");
		task1.getWrittenVariables().add(projectVariable);
		task2.getObservedVariables().add(projectVariable);
		FileVariable fileVariable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFileVariable();
		fileVariable.setName("file");
		task2.getWrittenVariables().add(fileVariable);
		task3.getObservedVariables().add(fileVariable);
		FolderVariable folderVariable = ProcessworkspacePackage.eINSTANCE.getProcessworkspaceFactory()
				.createFolderVariable();
		folderVariable.setName("folder");
		task3.getWrittenVariables().add(folderVariable);

		return res;
	}

	@Override
	public void dispose() {
		super.dispose();
		WorkspaceUtils.removeProcessor(this);
	}

}
