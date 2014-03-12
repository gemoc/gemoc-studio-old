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

/**
 * Or {@link IFilter}. {@link IFilter#keep(IChange) Keeps} the given {@link IChange} if one of its
 * {@link IFilter operands} {@link IFilter#keep(IChange) keeps} it unchanged.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Or implements IFilter {
	/**
	 * {@link IFilter} operands.
	 */
	private final IFilter[] filters;

	/**
	 * Constructor.
	 * 
	 * @param filters
	 *            {@link IFilter} operands.
	 */
	public Or(IFilter... filters) {
		this.filters = filters;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.filter.IFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public IChange<?> keep(IChange<?> change) {
		IChange<?> res = null;

		for (IFilter filter : filters) {
			if (filter.keep(change) == change) {
				res = change;
				break;
			}
		}

		return res;
	}

}
