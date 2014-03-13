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

import java.util.ArrayList;
import java.util.List;

/**
 * Recorder {@link IChangeProcessor}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class RecorderChangeListener implements IChangeProcessor {

	/**
	 * The {@link IChangeProcessor} to delegate to.
	 */
	private final IChangeProcessor processor;

	/**
	 * Recorded {@link IChange}.
	 */
	private List<IChange<?>> changes = new ArrayList<IChange<?>>();

	/**
	 * Constructor.
	 * 
	 * @param processor
	 *            the {@link IChangeProcessor} to delegate to
	 */
	public RecorderChangeListener(IChangeProcessor processor) {
		this.processor = processor;
	}

	/**
	 * Replays {@link IChange}.
	 */
	public void replay() {
		final List<IChange<?>> localChanges;
		synchronized(changes) {
			localChanges = changes;
			changes = new ArrayList<IChange<?>>();
		}
		for (IChange<?> change : localChanges) {
			processor.process(change);
		}
	}

	/**
	 * Gets the {@link IChangeProcessor} to delegate to.
	 * 
	 * @return the {@link IChangeProcessor} to delegate to
	 */
	IChangeProcessor getProcessor() {
		return processor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor#process(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void process(IChange<?> change) {
		// TODO optimize : ResourceAdded(r1), ... , ResourceRemoved(r1) -> remove ResourceAdded(r1) and don't
		// add ResourceRemoved(r1)
		synchronized(changes) {
			changes.add(change);
		}
	}

	@Override
	public String toString() {
		final StringBuilder res = new StringBuilder();

		for (IChange<?> change : changes) {
			res.append(change.toString());
			res.append("\n");
		}

		return res.toString();
	}
}
