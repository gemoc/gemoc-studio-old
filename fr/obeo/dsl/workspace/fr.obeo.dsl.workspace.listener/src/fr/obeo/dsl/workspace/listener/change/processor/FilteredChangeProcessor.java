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
package fr.obeo.dsl.workspace.listener.change.processor;

import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.filter.IFilter;

/**
 * Filtered {@link IChangeProcessor}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class FilteredChangeProcessor implements IChangeProcessor {

	/**
	 * The {@link IChangeProcessor} to delegate to.
	 */
	private final IChangeProcessor processor;

	/**
	 * The {@link IFilter} to check.
	 */
	private final IFilter filter;

	/**
	 * Constructor.
	 * 
	 * @param processor
	 *            the {@link IChangeProcessor} to delegate to
	 * @param filter
	 *            the {@link IFilter} to check
	 */
	public FilteredChangeProcessor(IChangeProcessor processor, IFilter filter) {
		this.processor = processor;
		this.filter = filter;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor#process(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void process(IChange<?> change) {
		final IChange<?> filtered = filter.keep(change);
		if (filtered != null) {
			processor.process(filtered);
		}
	}

	IFilter getFilter() {
		return filter;
	}

	/**
	 * Gets the {@link IChangeProcessor} to delegate to.
	 * 
	 * @return the {@link IChangeProcessor} to delegate to
	 */
	IChangeProcessor getProcessor() {
		return processor;
	}

}
