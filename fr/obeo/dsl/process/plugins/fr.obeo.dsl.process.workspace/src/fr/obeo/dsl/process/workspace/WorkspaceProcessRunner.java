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
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.filter.IFilter;
import fr.obeo.dsl.workspace.listener.filter.Or;
import fr.obeo.dsl.workspace.listener.filter.ResourceFilter;
import fr.obeo.dsl.workspace.listener.filter.SetFilter;

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
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * Runnes a {@link ProcessContext} according to {@link IChange}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkspaceProcessRunner extends AbstractProcessRunner implements IChangeProcessor {

	/**
	 * The {@link ResourceFilter} filtering {@link IFile}.
	 */
	private final ResourceFilter<IFile> fileFilter = new ResourceFilter<IFile>();

	/**
	 * The {@link ResourceFilter} filtering {@link IFolder}.
	 */
	private final ResourceFilter<IFolder> folderFilter = new ResourceFilter<IFolder>();

	/**
	 * The {@link ResourceFilter} filtering {@link IProject}.
	 */
	private final ResourceFilter<IProject> projectFilter = new ResourceFilter<IProject>();

	/**
	 * The filter for {@link IWorkbenchWindow}.
	 */
	private final SetFilter<IWorkbenchWindow> windowFilter = new SetFilter<IWorkbenchWindow>();

	/**
	 * The filter for {@link IWorkbenchPage}.
	 */
	private final SetFilter<IWorkbenchPage> pageFilter = new SetFilter<IWorkbenchPage>();

	/**
	 * The filter for {@link IWorkbenchPart}.
	 */
	private final SetFilter<IWorkbenchPart> partFilter = new SetFilter<IWorkbenchPart>();

	/**
	 * The global {@link IFilter}.
	 */
	private final IFilter filter = new Or(getFileFilter(), getFolderFilter(), getProjectFilter(),
			getPartFilter(), getPageFilter(), getWindowFilter());

	/**
	 * Mapping from {@link ActionTask#getWrittenVariables() observed} eclipse {@link Object} to
	 * {@link ActionTask} .
	 */
	private final Map<Object, Set<ActionTask>> observedEclipseObject = new HashMap<Object, Set<ActionTask>>();

	/**
	 * Constructor.
	 * 
	 * @param processContext
	 *            the {@link ProcessContext}
	 */
	public WorkspaceProcessRunner(ProcessContext processContext) {
		super(processContext, true);
	}

	@Override
	protected IActionTaskProcessor instanciate(ActionTask task) {
		IActionTaskProcessor res = super.instanciate(task);
		assert res instanceof IWorkspaceTaskProcessor;
		return res;
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
			tasks = new LinkedHashSet<ActionTask>(getActiveProcessors().keySet());
		}
		for (ActionTask task : tasks) {
			final IWorkspaceTaskProcessor processor = (IWorkspaceTaskProcessor)getActiveProcessors()
					.get(task);
			if (processor != null) {
				processor.validate(getContext(), change);
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

		Set<ActionTask> tasks = observedEclipseObject.get(change.getObject());
		if (tasks != null) {
			res.addAll(tasks);
		}
		if (change instanceof ResourceMoved) {
			tasks = observedEclipseObject.get(((ResourceMoved)change).getDestination());
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
					getFileFilter().getSet().add((IFile)resource);
					addObservedEclipseObject(resource, task);
				} else if (variable instanceof FolderVariable) {
					getFolderFilter().getSet().add((IFolder)resource);
					addObservedEclipseObject(resource, task);
				} else if (variable instanceof ProjectVariable) {
					getProjectFilter().getSet().add((IProject)resource);
					addObservedEclipseObject(resource, task);
				}
			} else if (value instanceof IWorkbenchWindow) {
				getWindowFilter().getSet().add((IWorkbenchWindow)value);
				addObservedEclipseObject(value, task);
			} else if (value instanceof IWorkbenchPage) {
				getPageFilter().getSet().add((IWorkbenchPage)value);
				addObservedEclipseObject(value, task);
			} else if (value instanceof IWorkbenchPart) {
				getPartFilter().getSet().add((IWorkbenchPart)value);
				addObservedEclipseObject(value, task);
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
					getFileFilter().getSet().remove(resource);
					removeObservedEclipseObject(resource, task);
				} else if (variable instanceof FolderVariable) {
					getFolderFilter().getSet().remove(resource);
					removeObservedEclipseObject(resource, task);
				} else if (variable instanceof ProjectVariable) {
					getProjectFilter().getSet().remove(resource);
					removeObservedEclipseObject(resource, task);
				}
			} else if (value instanceof IWorkbenchWindow) {
				getWindowFilter().getSet().remove(value);
				removeObservedEclipseObject(value, task);
			} else if (value instanceof IWorkbenchPage) {
				getPageFilter().getSet().remove(value);
				removeObservedEclipseObject(value, task);
			} else if (value instanceof IWorkbenchPart) {
				getPartFilter().getSet().remove(value);
				removeObservedEclipseObject(value, task);
			}
		}
	}

	@Override
	public void variableChanged(ProcessContext context, ProcessVariable variable, Object oldValue,
			Object newValue) {
		removeOldValue(variable, oldValue);
		addNewValue(variable, newValue);
	}

	/**
	 * Registers the given new value for the given {@link ProcessVariable}.
	 * 
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @param newValue
	 *            the new value
	 */
	protected void addNewValue(ProcessVariable variable, Object newValue) {
		if (newValue instanceof IResource) {
			final IResource resource = (IResource)newValue;
			if (newValue instanceof IFile) {
				getFileFilter().getSet().add((IFile)resource);
				for (ActionTask task : variable.getWrittenBy()) {
					addObservedEclipseObject(resource, task);
				}
			} else if (newValue instanceof IFolder) {
				getFolderFilter().getSet().add((IFolder)resource);
				for (ActionTask task : variable.getWrittenBy()) {
					addObservedEclipseObject(resource, task);
				}
			} else if (newValue instanceof IProject) {
				getProjectFilter().getSet().add((IProject)resource);
				for (ActionTask task : variable.getWrittenBy()) {
					addObservedEclipseObject(resource, task);
				}
			}
		} else if (newValue instanceof IWorkbenchWindow) {
			getWindowFilter().getSet().add((IWorkbenchWindow)newValue);
			for (ActionTask task : variable.getWrittenBy()) {
				addObservedEclipseObject(newValue, task);
			}
		} else if (newValue instanceof IWorkbenchPage) {
			getPageFilter().getSet().add((IWorkbenchPage)newValue);
			for (ActionTask task : variable.getWrittenBy()) {
				addObservedEclipseObject(newValue, task);
			}
		} else if (newValue instanceof IWorkbenchPart) {
			getPartFilter().getSet().add((IWorkbenchPart)newValue);
			for (ActionTask task : variable.getWrittenBy()) {
				addObservedEclipseObject(newValue, task);
			}
		}
	}

	/**
	 * Unregisters the given new value for the given {@link ProcessVariable}.
	 * 
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @param oldValue
	 *            the old value
	 */
	protected void removeOldValue(ProcessVariable variable, Object oldValue) {
		if (oldValue instanceof IResource) {
			final IResource resource = (IResource)oldValue;
			if (oldValue instanceof IFile) {
				getFileFilter().getSet().remove(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					removeObservedEclipseObject(resource, task);
				}
			} else if (oldValue instanceof IFolder) {
				getFolderFilter().getSet().remove(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					removeObservedEclipseObject(resource, task);
				}
			} else if (oldValue instanceof IProject) {
				getProjectFilter().getSet().remove(resource);
				for (ActionTask task : variable.getWrittenBy()) {
					removeObservedEclipseObject(resource, task);
				}
			}
		} else if (oldValue instanceof IWorkbenchWindow) {
			getWindowFilter().getSet().remove(oldValue);
			for (ActionTask task : variable.getWrittenBy()) {
				removeObservedEclipseObject(oldValue, task);
			}
		} else if (oldValue instanceof IWorkbenchPage) {
			getPageFilter().getSet().remove(oldValue);
			for (ActionTask task : variable.getWrittenBy()) {
				removeObservedEclipseObject(oldValue, task);
			}
		} else if (oldValue instanceof IWorkbenchPart) {
			getPartFilter().getSet().remove(oldValue);
			for (ActionTask task : variable.getWrittenBy()) {
				removeObservedEclipseObject(oldValue, task);
			}
		}
	}

	/**
	 * Adds the given {@link ActionTask} as observing the given {@link IResource}.
	 * 
	 * @param eclipseObject
	 *            the eclipse {@link Object}
	 * @param task
	 *            the {@link ActionTask}
	 */
	protected void addObservedEclipseObject(Object eclipseObject, ActionTask task) {
		Set<ActionTask> tasks = observedEclipseObject.get(eclipseObject);
		if (tasks == null) {
			tasks = new HashSet<ActionTask>();
			observedEclipseObject.put(eclipseObject, tasks);
		}
		tasks.add(task);
	}

	/**
	 * Removes the given {@link ActionTask} as observing the given eclipse {@link Object}.
	 * 
	 * @param eclipseObject
	 *            the eclipse {@link Object}
	 * @param task
	 *            the {@link ActionTask}
	 */
	private void removeObservedEclipseObject(Object eclipseObject, ActionTask task) {
		Set<ActionTask> tasks = observedEclipseObject.get(eclipseObject);
		if (tasks != null) {
			tasks.remove(task);
		}
	}

	/**
	 * The {@link FilePathFilter}.
	 * 
	 * @return the {@link FilePathFilter}
	 */
	public ResourceFilter<IFile> getFileFilter() {
		return fileFilter;
	}

	/**
	 * The {@link FolderPathFilter}.
	 * 
	 * @return the {@link FolderPathFilter}
	 */
	public ResourceFilter<IFolder> getFolderFilter() {
		return folderFilter;
	}

	/**
	 * The {@link ProjectPathFilter}.
	 * 
	 * @return the {@link ProjectPathFilter}
	 */
	public ResourceFilter<IProject> getProjectFilter() {
		return projectFilter;
	}

	/**
	 * The filter for {@link IWorkbenchWindow}.
	 * 
	 * @return the filter for {@link IWorkbenchWindow}
	 */
	public SetFilter<IWorkbenchWindow> getWindowFilter() {
		return windowFilter;
	}

	/**
	 * The filter for {@link IWorkbenchPage}.
	 * 
	 * @return the filter for {@link IWorkbenchPage}
	 */
	public SetFilter<IWorkbenchPage> getPageFilter() {
		return pageFilter;
	}

	/**
	 * The filter for {@link IWorkbenchPart}.
	 * 
	 * @return the filter for {@link IWorkbenchPart}
	 */
	public SetFilter<IWorkbenchPart> getPartFilter() {
		return partFilter;
	}

}
