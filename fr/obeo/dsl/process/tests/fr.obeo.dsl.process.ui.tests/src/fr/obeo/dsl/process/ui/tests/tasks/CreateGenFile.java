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
package fr.obeo.dsl.process.ui.tests.tasks;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor;
import fr.obeo.dsl.processworkspace.FileVariable;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * The create project task implementation.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateGenFile extends AbstractWorkspaceTaskProcessor {

	/**
	 * The gen file extension.
	 */
	public static final String EXTENSION = ".gen";

	/**
	 * Constructor.
	 * 
	 * @param actionTask
	 *            the {@link ActionTask} definition
	 */
	public CreateGenFile(ActionTask actionTask) {
		super(actionTask);
	}

	@Override
	protected void knownFileRemoved(ProcessContext context, IFile file, FileVariable variable) {
		context.setVariableValue(variable, null, getActionTask());
		context.setUndone(getActionTask(), file.getName() + " removed.");
	}

	@Override
	protected void knownFileClosed(ProcessContext context, IFile file, FileVariable variable) {
		context.setVariableValue(variable, null, getActionTask());
		context.setUndone(getActionTask(), file.getName() + " closed.");
	}

	@Override
	protected void knownFileMoved(ProcessContext context, IFile file, FileVariable variable, IFile destination) {
		final ProcessVariable projectVariable = getActionTask().getObservedVariables().get(0);
		final IProject knownProject = (IProject)context.getVariableValue(projectVariable, getActionTask());
		if (destination.getName().endsWith(EXTENSION) && file.getProject().equals(knownProject)) {
			context.setVariableValue(variable, destination, getActionTask());
			context.setDone(getActionTask(), destination);
		} else {
			context.setVariableValue(variable, null, getActionTask());
			context.setUndone(getActionTask(), file.getFullPath() + " renamed to "
					+ destination.getFullPath() + " a non gen file.");
		}
	}

	@Override
	protected void unknownFileAdded(ProcessContext context, IFile file, FileVariable variable) {
		final ProcessVariable projectVariable = getActionTask().getObservedVariables().get(0);
		final IProject knownProject = (IProject)context.getVariableValue(projectVariable, getActionTask());
		if (file.getName().endsWith(EXTENSION) && file.getProject().equals(knownProject)) {
			context.setVariableValue(variable, file, getActionTask());
			context.setDone(getActionTask(), file);
		}
	}

	@Override
	protected void unknownFileOpened(ProcessContext context, IFile file, FileVariable variable) {
		final ProcessVariable projectVariable = getActionTask().getObservedVariables().get(0);
		final IProject knownProject = (IProject)context.getVariableValue(projectVariable, getActionTask());
		if (file.getName().endsWith(EXTENSION) && file.getProject().equals(knownProject)) {
			context.setVariableValue(variable, file, getActionTask());
			context.setDone(getActionTask(), file);
		}
	}

	@Override
	protected void unknownFileMoved(ProcessContext context, IFile file, FileVariable variable,
			IFile destination) {
		final ProcessVariable projectVariable = getActionTask().getObservedVariables().get(0);
		final IProject knownProject = (IProject)context.getVariableValue(projectVariable, getActionTask());
		if (destination.getName().endsWith(EXTENSION) && file.getProject().equals(knownProject)) {
			context.setVariableValue(variable, destination, getActionTask());
			context.setDone(getActionTask(), destination);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#variableChanged(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ProcessVariable, java.lang.Object, java.lang.Object)
	 */
	public void variableChanged(ProcessContext context, ProcessVariable variable, Object oldValue,
			Object newValue) {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		final ProcessVariable projectVariable = getActionTask().getObservedVariables().get(0);
		final IProject project = (IProject)context.getVariableValue(projectVariable, getActionTask());
		final IFile file = project.getFile("test" + EXTENSION);
		try {
			file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		final ProcessVariable fileVariable = getActionTask().getWrittenVariables().get(0);
		final IFile file = (IFile)context.getVariableValue(fileVariable, getActionTask());
		try {
			file.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
