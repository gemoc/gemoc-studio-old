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
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceClosed;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceOpened;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.workspace.IWorkspaceTaskProcessor#validate(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void validate(ProcessContext context, IChange<?> change) {
		if (change.getObject() instanceof IFile) {
			final ProcessVariable projectVariable = getActionTask().getObservedVariables().get(0);
			final IProject knownProject = (IProject)context
					.getVariableValue(projectVariable, getActionTask());
			final ProcessVariable fileVariable = getActionTask().getWrittenVariables().get(0);
			final IFile knownFile = (IFile)context.getVariableValue(fileVariable, getActionTask());
			final IFile file = (IFile)change.getObject();

			if (file.equals(knownFile)) {
				if (change instanceof ResourceRemoved) {
					context.setVariableValue(fileVariable, null, getActionTask());
					context.setUndone(getActionTask(), knownFile.getName() + " removed.");
				} else if (change instanceof ResourceClosed) {
					context.setVariableValue(fileVariable, null, getActionTask());
					context.setUndone(getActionTask(), knownFile.getName() + " closed.");
				} else if (change instanceof ResourceMoved) {
					knownFileMoved(context, change, knownProject, fileVariable, knownFile, file);
				}
			} else if (knownFile == null) {
				if ((change instanceof ResourceAdded || change instanceof ResourceOpened)
						&& file.getName().endsWith(EXTENSION) && file.getProject().equals(knownProject)) {
					context.setVariableValue(fileVariable, file, getActionTask());
					context.setDone(getActionTask(), file);
				} else if (change instanceof ResourceMoved
						&& ((ResourceMoved)change).getDestination().getName().endsWith(EXTENSION)
						&& file.getProject().equals(knownProject)) {
					context.setVariableValue(fileVariable, ((ResourceMoved)change).getDestination(),
							getActionTask());
					context.setDone(getActionTask(), ((ResourceMoved)change).getDestination());
				}
			}
		}
	}

	/**
	 * The known {@link IFile} has been moved.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link IChange}
	 * @param knownProject
	 *            the known {@link IProject}
	 * @param fileVariable
	 *            the {@link IFile} {@link ProcessVariable}
	 * @param knownFile
	 *            the known {@link IFile}
	 * @param file
	 *            the changed {@link IFile}
	 */
	private void knownFileMoved(ProcessContext context, IChange<?> change, final IProject knownProject,
			final ProcessVariable fileVariable, final IFile knownFile, final IFile file) {
		IResource destination = ((ResourceMoved)change).getDestination();
		if (destination.getName().endsWith(EXTENSION) && file.getProject().equals(knownProject)) {
			context.setVariableValue(fileVariable, destination, getActionTask());
			context.setDone(getActionTask(), destination);
		} else {
			context.setVariableValue(fileVariable, null, getActionTask());
			context.setUndone(getActionTask(), knownFile.getFullPath() + " renamed to "
					+ destination.getFullPath() + " a non gen file.");
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
