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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * The create project task implementation.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateProject extends AbstractWorkspaceTaskProcessor {

	/**
	 * Constructor.
	 * 
	 * @param actionTask
	 *            the {@link ActionTask} definition
	 */
	public CreateProject(ActionTask actionTask) {
		super(actionTask);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.workspace.IWorkspaceTaskProcessor#validate(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void validate(ProcessContext context, IChange<?> change) {
		if (change.getObject() instanceof IProject) {
			final ProcessVariable projectVariable = getActionTask().getWrittenVariables().get(0);
			final IProject knownProject = (IProject)context
					.getVariableValue(projectVariable, getActionTask());
			final IProject project = (IProject)change.getObject();
			if (project.equals(knownProject)) {
				if (change instanceof ResourceRemoved) {
					context.setVariableValue(projectVariable, null, getActionTask());
					context.setUndone(getActionTask(), "Project " + knownProject.getName() + " removed.");
				} else if (change instanceof ResourceClosed) {
					context.setVariableValue(projectVariable, null, getActionTask());
					context.setUndone(getActionTask(), "Project " + knownProject.getName() + " closed.");
				} else if (change instanceof ResourceMoved) {
					context.setVariableValue(projectVariable, ((ResourceMoved)change).getDestination(),
							getActionTask());
					context.setDone(getActionTask(), ((ResourceMoved)change).getDestination());
				}
			} else if (knownProject == null) {
				if (change instanceof ResourceAdded || change instanceof ResourceOpened) {
					context.setVariableValue(projectVariable, project, getActionTask());
					context.setDone(getActionTask(), project);
				}
			}
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
		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("project");
		try {
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.setVariableValue(getActionTask().getWrittenVariables().get(0), project, getActionTask());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		final ProcessVariable projectVariable = getActionTask().getWrittenVariables().get(0);
		IProject project = (IProject)context.getVariableValue(projectVariable, getActionTask());
		try {
			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
