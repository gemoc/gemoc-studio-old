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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFolder;

/**
 * {@link IFilter#keep(IChange) Keeps} an {@link Object} is in {@link SetFilter#getSet() objects}.
 * 
 * @param <T>
 *            the king of {@link Object} to filter
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SetFilter<T> implements IFilter {

	/**
	 * {@link IFolder} filter.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	public static final class FolderFilter extends SetFilter<IFolder> {

		@Override
		protected boolean keep(IFolder resource) {
			return super.keep(resource);
		}

	}

	/**
	 * {@link Object} to {@link IFilter#keep(IChange) keep}.
	 */
	private final Set<T> objects = new HashSet<T>();

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.filter.IFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	@SuppressWarnings("unchecked")
	public IChange<?> keep(IChange<?> change) {
		final IChange<?> res;

		if (keep((T)change.getObject())) {
			res = change;
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * Tells if we should {@link IFilter#keep(IChange) keep} the given {@link Object}.
	 * 
	 * @param object
	 *            the {@link Object} to check
	 * @return <code>true</code> if we should {@link IFilter#keep(IChange) keep} the given {@link Object},
	 *         <code>false</code> otherwise
	 */
	protected boolean keep(T object) {
		return getSet().contains(object);
	}

	/**
	 * Gets the {@link Set} of {@link org.eclipse.core.resources.T#getFullPath() full path} to
	 * {@link IFilter#keep(IChange) keep} .
	 * 
	 * @return the {@link Set} of {@link org.eclipse.core.resources.T#getFullPath() full path} to
	 *         {@link IFilter#keep(IChange) keep}
	 */
	public Set<T> getSet() {
		return objects;
	}
}
