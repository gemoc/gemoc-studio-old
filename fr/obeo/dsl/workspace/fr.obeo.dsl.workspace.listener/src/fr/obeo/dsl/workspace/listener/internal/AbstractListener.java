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

import fr.obeo.dsl.workspace.listener.IListener;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract {@link IListener}.
 * 
 * @param <T>
 *            the kind of observed {@link Object}
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractListener<T> implements IListener {

	/**
	 * The observed {@link Object}.
	 */
	private final T observed;

	/**
	 * The {@link List} of {@link IChangeProcessor}.
	 */
	private final List<IChangeProcessor> processors = new ArrayList<IChangeProcessor>();

	/**
	 * Constructor.
	 * 
	 * @param observed
	 *            the observed {@link Object}
	 */
	public AbstractListener(T observed) {
		this.observed = observed;
	}

	/**
	 * Gets the observed {@link Object}.
	 * 
	 * @return the observed {@link Object}
	 */
	protected T getObserved() {
		return observed;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.IListener#getProcessors()
	 */
	protected List<IChangeProcessor> getProcessors() {
		return processors;
	}

	/**
	 * Fires the given change to {@link IListener#getProcessors() processors}.
	 * 
	 * @param change
	 *            the {@link IChange} to fire
	 */
	protected void fireChange(IChange<?> change) {
		final List<IChangeProcessor> processorList = getProcessors();

		if (processorList.size() != 0) {
			// TODO should be asynchronous and ran in a single other thread
			for (IChangeProcessor processor : processorList) {
				processor.process(change);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.IListener#addProcessor(fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor,
	 *      boolean)
	 */
	public boolean addProcessor(IChangeProcessor processor, boolean notifyCurrentState) {
		if (notifyCurrentState) {
			notifyCurrentState(getObserved(), processor);
		}
		return getProcessors().add(processor);
	}

	/**
	 * Sends {@link fr.obeo.dsl.workspace.listener.change.IChange IChange} to reflect current state to the
	 * given {@link IChangeProcessor}.
	 * 
	 * @param observed2
	 *            the {@link AbstractListener#getObserved() observed} {@link Object}
	 * @param processor
	 *            the {@link IChangeProcessor} to notify
	 */
	protected abstract void notifyCurrentState(T observed2, IChangeProcessor processor);

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.IListener#removeProcessor(fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor)
	 */
	public boolean removeProcessor(IChangeProcessor processor) {
		return getProcessors().remove(processor);
	}

}
