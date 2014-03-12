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
package fr.obeo.dsl.workspace.listener.internal;

import fr.obeo.dsl.workspace.listener.Activator;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceClosed;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceContentChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceDescriptionChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceOpened;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import java.util.HashMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

/**
 * A listener for {@link org.eclipse.core.resources.IResource IResource}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkspaceListener extends AbstractListener<IWorkspace> implements IResourceChangeListener {

	/**
	 * Constructor.
	 * 
	 * @param workspace
	 *            the {@link IWorkspace} to observe.
	 */
	public WorkspaceListener(IWorkspace workspace) {
		super(workspace);
		workspace.addResourceChangeListener(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getDelta() != null) {
			walkDelta(event.getDelta(), new HashMap<IPath, IResource>());
		}
	}

	/**
	 * Walks the {@link IResourceDelta} tree.
	 * 
	 * @param delta
	 *            the root {@link IResourceDelta}
	 * @param movedResources
	 *            mapping of moved {@link IResource}
	 */
	private void walkDelta(IResourceDelta delta, HashMap<IPath, IResource> movedResources) {
		processDelta(delta, movedResources);
		for (IResourceDelta child : delta.getAffectedChildren()) {
			walkDelta(child, movedResources);
		}
	}

	/**
	 * Processes the given {@link IResourceDelta} by
	 * {@link WorkspaceListener#fireChange(fr.obeo.dsl.workspace.listener.change.IChange) firing}
	 * {@link fr.obeo.dsl.workspace.listener.change.IChange IChange}.
	 * 
	 * @param delta
	 *            the {@link IResourceDelta} to process
	 * @param movedResources
	 *            mapping of moved {@link IResource}
	 */
	private void processDelta(IResourceDelta delta, HashMap<IPath, IResource> movedResources) {
		switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				if ((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
					fireChange(new ResourceMoved(movedResources.get(delta.getMovedFromPath()), delta
							.getResource()));
				} else {
					fireChange(new ResourceAdded(delta.getResource()));
				}
				break;

			case IResourceDelta.REMOVED:
				if ((delta.getFlags() & IResourceDelta.MOVED_TO) != 0) {
					movedResources.put(delta.getResource().getFullPath(), delta.getResource());
				} else {
					fireChange(new ResourceRemoved(delta.getResource()));
				}
				break;

			case IResourceDelta.CHANGED:
				if ((delta.getFlags() & IResourceDelta.OPEN) != 0) {
					if (delta.getResource().isAccessible()) {
						fireChange(new ResourceOpened(delta.getResource()));
					} else {
						fireChange(new ResourceClosed(delta.getResource()));
					}
				} else if ((delta.getFlags() & IResourceDelta.DESCRIPTION) != 0) {
					fireChange(new ResourceDescriptionChanged(delta.getResource()));
				} else if ((delta.getFlags() & IResourceDelta.CONTENT) != 0) {
					fireChange(new ResourceContentChanged(delta.getResource()));
				}
				break;

			default:
				break;
		}
	}

	@Override
	protected void notifyCurrentState(IWorkspace observed2, IChangeProcessor processor) {
		try {
			for (IResource member : observed2.getRoot().members()) {
				walkResource(member, processor);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Walks the workspace and send {@link ResourceAdded} to the given {@link IChangeProcessor}.
	 * 
	 * @param resource
	 *            the {@link IResource} to walk
	 * @param processor
	 *            the {@link IChangeProcessor} to notify
	 */
	private void walkResource(IResource resource, IChangeProcessor processor) {
		processor.process(new ResourceAdded(resource));
		if (resource instanceof IContainer) {
			IResource[] members;
			try {
				members = ((IContainer)resource).members();
				for (IResource member : members) {
					walkResource(member, processor);
				}
			} catch (CoreException e) {
				Activator.getDefault().error(e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.IListener#dispose()
	 */
	public void dispose() {
		getObserved().removeResourceChangeListener(this);
	}

}
