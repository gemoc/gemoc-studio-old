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
package org.gemoc.gemoc_language_workbench.process.task;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.gemoc.gemoc_language_workbench.conf.DSAProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.K3DSAProject;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;

/**
 * Reference an existing project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Task6c extends AbstractProcessor {

	/**
	 * The reference to the {@link ActionTask} corresponding to {@link Task1}.
	 */
	private final ActionTask task1;

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 * @param task1
	 *            the reference to the {@link ActionTask} corresponding to {@link Task1}
	 */
	public Task6c(ActionTask task, ActionTask task1) {
		super(task);
		this.task1 = task1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#updateContexts(fr.obeo.dsl.process.IProcessRunner,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void updateContexts(IProcessRunner runner, IChange<?> change) {
		if (change instanceof AbstractResourceChange) {
			final IResource resource = WorkspaceUtils.getResource((AbstractResourceChange)change);
			final boolean forceUpdate = GemocProcessUtils.isXDSMLFile(resource);
			for (ProcessContext context : runner.getContexts()) {
				if (forceUpdate || shouldUpdate(context, (AbstractResourceChange)change)) {
					updateContext(context);
				}
			}
		}
	}

	/**
	 * Updates the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	private void updateContext(ProcessContext context) {
		final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)context
				.getResult(task1);
		if (config != null && config.getLanguageDefinition() != null) {
			final DSAProject project = config.getLanguageDefinition().getDsaProject();
			if (project instanceof K3DSAProject) {
				checkK3DSAProject(context, (K3DSAProject)project);
			} else if (project != null) {
				throw new IllegalStateException("don't know what to do with "
						+ project.getClass().getCanonicalName());
			}
		} else {
			context.setUndone(getActionTask(), null);
		}
	}

	/**
	 * Checks K3 editor project.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link K3DSAProject}
	 */
	private void checkK3DSAProject(ProcessContext context, K3DSAProject project) {
		final String projectName = project.getProjectName();
		if (projectName != null && projectName.length() > 0) {
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (p != null && p.exists()) {
				context.setDone(getActionTask(), projectName);
			} else {
				context.setUndone(getActionTask(), "Project doesn't exists.");
			}
		} else {
			context.setUndone(getActionTask(), "No project referenced.");
		}
	}

	/**
	 * Tells if the given {@link ProcessContext} should be updated on the given {@link IResource} change.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractResourceChange}
	 * @return <code>true</code> if the given {@link ProcessContext} should be updated on the given
	 *         {@link IResource} change, <code>false</code> otherwise
	 */
	private boolean shouldUpdate(ProcessContext context, AbstractResourceChange change) {
		final boolean res;

		final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)context
				.getResult(task1);
		if (config != null && config.getLanguageDefinition() != null
				&& config.getLanguageDefinition().getDsaProject() != null) {
			final String projectName = config.getLanguageDefinition().getDsaProject().getProjectName();

			res = GemocProcessUtils.checkResourceChange("/" + projectName, change);
		} else {
			res = false;
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		// TODO open a project selection wizard for K2/K3 projects
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)context
				.getResult(task1);
		if (config != null && config.getLanguageDefinition() != null) {
			config.getLanguageDefinition().setDsaProject(null);
			context.setUndone(getActionTask(), null);
		}
	}

}
