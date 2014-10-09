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
package fr.obeo.dsl.workspace.listener.filter;

import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;

/**
 * {@link IFilter#keep(IChange) Keeps} an {@link IResource} is in {@link ResourceFilter#getResources()
 * resources}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ResourceFilter implements IFilter {

	/**
	 * {@link IFile} filter.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static final class FileFilter extends ResourceFilter {

		@Override
		protected boolean keep(IResource resource) {
			return resource instanceof IFile && super.keep(resource);
		}

	}

	/**
	 * {@link IProject} filter.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static final class ProjectFilter extends ResourceFilter {

		@Override
		protected boolean keep(IResource resource) {
			return resource instanceof IProject && super.keep(resource);
		}

	}

	/**
	 * {@link IFolder} filter.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static final class FolderFilter extends ResourceFilter {

		@Override
		protected boolean keep(IResource resource) {
			return resource instanceof IFolder && super.keep(resource);
		}

	}

	/**
	 * {@link IResource} to {@link IFilter#keep(IChange) keep}.
	 */
	private final Set<IResource> resources = new HashSet<IResource>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.filter.IFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public IChange<?> keep(IChange<?> change) {
		final boolean keep;
		final IChange<?> res;

		if (change instanceof AbstractResourceChange) {
			if (change instanceof ResourceMoved) {
				keep = keep(((AbstractResourceChange)change).getObject())
						|| keep(((ResourceMoved)change).getDestination());
			} else {
				keep = keep(((AbstractResourceChange)change).getObject());
			}
		} else {
			keep = false;
		}

		if (keep) {
			res = change;
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Tells if we should {@link IFilter#keep(IChange) keep} the given {@link IResource}.
	 * 
	 * @param resource
	 *            the {@link IResource} to check
	 * @return <code>true</code> if we should {@link IFilter#keep(IChange) keep} the given {@link IResource},
	 *         <code>false</code> otherwise
	 */
	protected boolean keep(IResource resource) {
		return getResources().contains(resource);
	}

	/**
	 * Gets the {@link Set} of {@link org.eclipse.core.resources.IResource#getFullPath() full path} to
	 * {@link IFilter#keep(IChange) keep} .
	 * 
	 * @return the {@link Set} of {@link org.eclipse.core.resources.IResource#getFullPath() full path} to
	 *         {@link IFilter#keep(IChange) keep}
	 */
	public Set<IResource> getResources() {
		return resources;
	}
}
