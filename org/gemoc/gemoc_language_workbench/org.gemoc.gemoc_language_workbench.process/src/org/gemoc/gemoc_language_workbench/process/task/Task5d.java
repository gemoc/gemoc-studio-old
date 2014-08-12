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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.ODProject;
import org.gemoc.gemoc_language_workbench.conf.TreeEditorProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;
import org.gemoc.gemoc_language_workbench.process.Activator;

/**
 * Reference an editor project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Task5d extends AbstractProcessor {

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
	public Task5d(ActionTask task, ActionTask task1) {
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
		if (config != null && config.getLanguageDefinition() != null
				&& config.getLanguageDefinition().getEditorProjects().size() != 0) {
			final List<EditorProject> projects = config.getLanguageDefinition().getEditorProjects();
			for (EditorProject project : projects) {
				if (project instanceof ODProject) {
					checkODProject(context, (ODProject)project);
				} else if (project instanceof TreeEditorProject) {
					checkTreeEditorProject(context, (TreeEditorProject)project);
				} else if (project instanceof XTextEditorProject) {
					checkXTextEditorProject(context, (XTextEditorProject)project);
				} else if (project != null) {
					throw new IllegalStateException("don't know what to do with "
							+ project.getClass().getCanonicalName());
				}
			}
		} else {
			context.setUndone(getActionTask(), null);
		}
	}

	/**
	 * Checks Sirius project.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link ODProject}
	 */
	private void checkODProject(ProcessContext context, ODProject project) {
		final String projectName = project.getProjectName();
		if (projectName != null && projectName.length() > 0) {
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			try {
				if (p != null && p.exists() && p.hasNature(ModelingProject.NATURE_ID)) {
					addProjectName(context, projectName);
				} else {
					removeProjectName(context, projectName);
				}
			} catch (CoreException e) {
				Activator.getDefault().error(e);
			}
		}
	}

	/**
	 * Checks tree editor project.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link ODProject}
	 */
	private void checkTreeEditorProject(ProcessContext context, TreeEditorProject project) {
		final String projectName = project.getProjectName();
		if (projectName != null && projectName.length() > 0) {
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (p != null && p.exists()) {
				addProjectName(context, projectName);
			} else {
				removeProjectName(context, projectName);
			}
		}
	}

	/**
	 * Checks XText editor project.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link XTextEditorProject}
	 */
	private void checkXTextEditorProject(ProcessContext context, XTextEditorProject project) {
		final String projectName = project.getProjectName();
		if (projectName != null && projectName.length() > 0) {
			IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if (p != null && p.exists()) {
				addProjectName(context, projectName);
			} else {
				removeProjectName(context, projectName);
			}
		}
	}

	/**
	 * Tells if the given {@link ProcessContext} should be updated on the given {@link AbstractResourceChange}
	 * .
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractResourceChange}
	 * @return <code>true</code> if the given {@link ProcessContext} should be updated on the given
	 *         {@link AbstractResourceChange}, <code>false</code> otherwise
	 */
	private boolean shouldUpdate(ProcessContext context, AbstractResourceChange change) {
		boolean res = false;

		final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)context
				.getResult(task1);
		if (config != null && config.getLanguageDefinition() != null
				&& config.getLanguageDefinition().getEditorProjects().size() != 0) {
			final List<EditorProject> projects = config.getLanguageDefinition().getEditorProjects();
			for (EditorProject project : projects) {
				if (GemocProcessUtils.checkResourceChange("/" + project.getProjectName(), change)) {
					res = true;
					break;
				}
			}
		}

		return res;
	}

	public void doAction(ProcessContext context) {
		// TODO project selection wizard + analysis in order to create the editor reference in the XDSML
	}

	public void undoAction(ProcessContext context) {
		// TODO editor reference selection wizard

	}

	/**
	 * Adds the given project name from the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param projectName
	 *            the project name
	 */
	private void addProjectName(ProcessContext context, String projectName) {
		Set<String> projectNames = (Set<String>)context.getResult(getActionTask());
		if (projectNames == null) {
			projectNames = new HashSet<String>();
			context.setDone(getActionTask(), projectNames);
		}
		projectNames.add(projectName);
	}

	/**
	 * Removes the given project name from the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param projectName
	 *            the project name
	 */
	private void removeProjectName(ProcessContext context, String projectName) {
		Set<String> projectNames = (Set<String>)context.getResult(getActionTask());
		if (projectNames != null) {
			if (projectNames.remove(projectName) && projectNames.size() == 0) {
				context.setUndone(getActionTask(), null);
			}
		}
	}

}
