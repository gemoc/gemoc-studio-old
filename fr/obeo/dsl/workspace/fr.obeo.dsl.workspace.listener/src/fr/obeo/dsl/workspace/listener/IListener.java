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
package fr.obeo.dsl.workspace.listener;

import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;

/**
 * Listen to Eclipse changes (workspace, workbench, ...).
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IListener {

	/**
	 * Indicates the absence of {@link IListener}.
	 */
	IListener NO_LISTENER = new IListener() {

		public boolean addProcessor(IChangeProcessor processor, boolean notifyCurrentState) {
			return false;
		}

		public boolean removeProcessor(IChangeProcessor processor) {
			return false;
		}

		public void dispose() {
			// nothing to do here
		}

	};

	/**
	 * Adds the given {@link IChangeProcessor}.
	 * 
	 * @param processor
	 *            the {@link IChangeProcessor} to add
	 * @param notifyCurrentState
	 *            tells if we should send {@link fr.obeo.dsl.workspace.listener.change.IChange IChange} to
	 *            reflect current state
	 * @return <code>true</code> if the {@link IChangeProcessor} has been added as result of this call,
	 *         <code>false</code> otherwise
	 */
	boolean addProcessor(IChangeProcessor processor, boolean notifyCurrentState);

	/**
	 * Removes the given {@link IChangeProcessor}.
	 * 
	 * @param processor
	 *            the {@link IChangeProcessor} to remove
	 * @return <code>true</code> if the {@link IChangeProcessor} has been removed as result of this call,
	 *         <code>false</code> otherwise
	 */
	boolean removeProcessor(IChangeProcessor processor);

	/**
	 * Disposes the {@link IListener}.
	 */
	void dispose();

}
