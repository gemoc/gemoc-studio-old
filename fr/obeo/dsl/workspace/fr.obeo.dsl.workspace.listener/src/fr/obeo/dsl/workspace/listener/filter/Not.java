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
 * Not {@link IFilter}. {@link IFilter#keep(IChange) Keeps} the given {@link IChange} if its {@link IFilter
 * operand} don't {@link IFilter#keep(IChange) keep} it unchanged and vis versa.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Not implements IFilter {

	/**
	 * The {@link IFilter} operand.
	 */
	private final IFilter filter;

	/**
	 * Constructor.
	 * 
	 * @param filter
	 *            the {@link IFilter} operand
	 */
	public Not(IFilter filter) {
		this.filter = filter;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.filter.IFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public IChange<?> keep(IChange<?> change) {
		final IChange<?> res;

		if (filter.keep(change) != change) {
			res = change;
		} else {
			res = null;
		}

		return res;
	}
}
