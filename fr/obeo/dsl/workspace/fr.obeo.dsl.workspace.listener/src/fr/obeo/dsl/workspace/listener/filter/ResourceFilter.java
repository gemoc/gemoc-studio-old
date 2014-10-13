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

import org.eclipse.core.resources.IResource;

/**
 * {@link IFilter#keep(IChange) Keeps} an {@link IResource} is in {@link ResourceFilter#getResources()
 * resources}.
 * 
 * @param <T>
 *            the {@link IResource} kind
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ResourceFilter<T extends IResource> extends SetFilter<T> {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.filter.IFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	@SuppressWarnings("unchecked")
	public IChange<?> keep(IChange<?> change) {
		final boolean keep;
		final IChange<?> res;

		if (change instanceof AbstractResourceChange) {
			if (change instanceof ResourceMoved) {
				keep = keep((T)((AbstractResourceChange)change).getObject())
						|| keep((T)((ResourceMoved)change).getDestination());
			} else {
				keep = keep((T)((AbstractResourceChange)change).getObject());
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

}
