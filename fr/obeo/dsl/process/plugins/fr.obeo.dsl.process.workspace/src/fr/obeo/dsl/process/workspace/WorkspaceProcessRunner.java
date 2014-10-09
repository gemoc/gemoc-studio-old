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
package fr.obeo.dsl.process.workspace;

import fr.obeo.dsl.process.AbstractProcessRunner;
import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.IActionTaskProcessor;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.filter.IFilter;
import fr.obeo.dsl.workspace.listener.filter.Or;
import fr.obeo.dsl.workspace.listener.filter.ResourceFilter.FileFilter;
import fr.obeo.dsl.workspace.listener.filter.ResourceFilter.FolderFilter;
import fr.obeo.dsl.workspace.listener.filter.ResourceFilter.ProjectFilter;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;

/**
 * Runnes a {@link ProcessContext} according to {@link IChange}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkspaceProcessRunner extends AbstractProcessRunner implements IChangeProcessor {

	/**
	 * The {@link FileFilter}.
	 */
	private final FileFilter fileFilter = new FileFilter();

	/**
	 * The {@link FolderFilter}.
	 */
	private final FolderFilter folderFilter = new FolderFilter();

	/**
	 * The {@link ProjectFilter}.
	 */
	private final ProjectFilter projectFilter = new ProjectFilter();

	/**
	 * The global {@link IFilter}.
	 */
	private final IFilter filter = new Or(getFileFilter(), getFolderFilter(), getProjectFilter());

	/**
	 * Mapping from {@link ActionTask#getWrittenVariables() observed} {@link IResource} to {@link ActionTask}
	 * .
	 */
	private final Map<IResource, Set<ActionTask>> observedResources = new HashMap<IResource, Set<ActionTask>>();

	/**
	 * Constructor.
	 * 
	 * @param processContext
	 *            the {@link ProcessContext}
	 */
	public WorkspaceProcessRunner(ProcessContext processContext) {
		super(processContext, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor#process(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void process(IChange<?> change) {
		final IChange<?> filtered = filter.keep(change);
		final Collection<ActionTask> tasks;
		if (filtered != null) {
			tasks = getObservingTasks(filtered);
		} else {
			tasks = ProcessUtils.getInitialActionTasks(getContext().getDefinition());
		}
		for (ActionTask initialTask : tasks) {
			final IActionTaskProcessor processor = getActiveProcessors().get(initialTask);
			if (processor != null) {
				processor.validate(getContext());
			}
		}
	}

	/**
	 * Gets the {@link Set} of {@link ActionTask} {@link ActionTask#getWrittenVariables() observing} the given
	 * {@link IChange}.
	 * 
	 * @param change
	 *            the {@link IChange}
	 * @return the {@link Set} of {@link ActionTask} {@link ActionTask#getWrittenVariables() observing} the
	 *         given {@link IChange}
	 */
	protected Set<ActionTask> getObservingTasks(IChange<?> change) {
		final Set<ActionTask> res = new LinkedHashSet<ActionTask>();

		Set<ActionTask> tasks = observedResources.get(change.getObject());
		if (tasks != null) {
			res.addAll(tasks);
		}
		if (change instanceof ResourceMoved) {
			tasks = observedResources.get(((ResourceMoved)change).getDestination());
			if (tasks != null) {
				res.addAll(tasks);
			}
		}

		return res;
	}

	@Override
	protected void activate(ActionTask task) {
		for (ProcessVariable variable : task.getWrittenVariables()) {
			final Object value = getContext().getVariableValue(variable, task);
			if (value instanceof IResource) {
				final IResource resource = (IResource)value;
				if (variable instanceof FileVariable) {
					getFileFilter().getResources().add(resource);
					addObservedResources(resource, task);
				} else if (variable instanceof FolderVariable) {
					getFolderFilter().getResources().add(resource);
					addObservedResources(resource, task);
				} else if (variable instanceof ProjectVariable) {
					getProjectFilter().getResources().add(resource);
					addObservedResources(resource, task);
				}
			}
		}
		super.activate(task);
	}

	@Override
	protected void deactivate(ActionTask task) {
		super.deactivate(task);
		for (ProcessVariable variable : task.getWrittenVariables()) {
			final Object value = getContext().getVariableValue(variable, task);
			if (value instanceof IResource) {
				final IResource resource = (IResource)value;
				if (variable instanceof FileVariable) {
					getFileFilter().getResources().remove(resource);
					removeObservedResources(resource, task);
				} else if (variable instanceof FolderVariable) {
					getFolderFilter().getResources().remove(resource);
					removeObservedResources(resource, task);
				} else if (variable instanceof ProjectVariable) {
					getProjectFilter().getResources().remove(resource);
					removeObservedResources(resource, task);
				}
			}
		}
	}

	@Override
	public void variableChanged(ProcessContext context, ProcessVariable variable, Object oldValue,
			Object newValue) {
		if (oldValue instanceof IResource) {
			final IResource resource = (IResource)oldValue;
			if (oldValue instanceof IFile) {
				getFileFilter().getResources().remove(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					removeObservedResources(resource, task);
				}
			} else if (oldValue instanceof IFolder) {
				getFolderFilter().getResources().remove(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					removeObservedResources(resource, task);
				}
			} else if (oldValue instanceof IProject) {
				getProjectFilter().getResources().remove(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					removeObservedResources(resource, task);
				}
			}
		}
		if (newValue instanceof IResource) {
			final IResource resource = (IResource)newValue;
			if (newValue instanceof IFile) {
				getFileFilter().getResources().add(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					addObservedResources(resource, task);
				}
			} else if (newValue instanceof IFolder) {
				getFolderFilter().getResources().add(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					addObservedResources(resource, task);
				}
			} else if (newValue instanceof IProject) {
				getProjectFilter().getResources().add(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					addObservedResources(resource, task);
				}
			}
		}
	}

	/**
	 * Adds the given {@link ActionTask} as observing the given {@link IResource}.
	 * 
	 * @param resource
	 *            the {@link IResource}
	 * @param task
	 *            the {@link ActionTask}
	 */
	protected void addObservedResources(IResource resource, ActionTask task) {
		Set<ActionTask> tasks = observedResources.get(resource);
		if (tasks == null) {
			tasks = new HashSet<ActionTask>();
			observedResources.put(resource, tasks);
		}
		tasks.add(task);
	}

	/**
	 * Removes the given {@link ActionTask} as observing the given {@link IResource}.
	 * 
	 * @param resource
	 *            the {@link IResource}
	 * @param task
	 *            the {@link ActionTask}
	 */
	private void removeObservedResources(IResource resource, ActionTask task) {
		Set<ActionTask> tasks = observedResources.get(resource);
		if (tasks != null) {
			tasks.remove(task);
		}
	}

	/**
	 * The {@link FilePathFilter}.
	 * 
	 * @return the {@link FilePathFilter}
	 */
	public FileFilter getFileFilter() {
		return fileFilter;
	}

	/**
	 * The {@link FolderPathFilter}.
	 * 
	 * @return the {@link FolderPathFilter}
	 */
	public FolderFilter getFolderFilter() {
		return folderFilter;
	}

	/**
	 * The {@link ProjectPathFilter}.
	 * 
	 * @return the {@link ProjectPathFilter}
	 */
	public ProjectFilter getProjectFilter() {
		return projectFilter;
	}

}
