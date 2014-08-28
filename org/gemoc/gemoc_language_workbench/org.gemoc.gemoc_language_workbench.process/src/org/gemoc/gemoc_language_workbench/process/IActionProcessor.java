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
package org.gemoc.gemoc_language_workbench.process;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.workspace.listener.change.IChange;

/**
 * Reacts to a {@link IChange change} by updating a {@link IProcessRunner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IActionProcessor {

	/**
	 * Updates the given {@link IProcessRunner runner} according to the given {@link IChange change}. Updates
	 * can be adding or removing {@link IProcessRunner#getContexts(fr.obeo.dsl.process.Process) contexts}, or
	 * update {@link ProcessContext#getProgress() progress}.
	 * 
	 * @param runner
	 *            the {@link IProcessRunner}
	 * @param change
	 *            the {@link IChange}
	 * @return an object been the result of the task, can be null
	 */
	Object updateContextWhenDone(ProcessContext context);

	/**
	 * reset the values in the context corresponding to this action, that is now considered as undone
	 * 
	 * @param context
	 * @param change
	 * @return the reason why it isn't done
	 */
	String updateContextWhenUndone(ProcessContext context);

	/**
	 * Verify in the environment that the Action can be considered as done
	 * 
	 * @param context
	 * @param change
	 * @return
	 */
	boolean validate(ProcessContext context);

	/**
	 * Verify in the environment that the change is relevant for the Action
	 * 
	 * @param context
	 * @param change
	 * @return true if the change must be processed
	 */
	boolean acceptChange(ProcessContext context, IChange<?> change);

	/**
	 * Executes the {@link ActionTask} in the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	void doAction(ProcessContext context);

	/**
	 * Undoes executes the {@link ActionTask} in the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	void undoAction(ProcessContext context);

	/**
	 * Gets the {@link ActionTask} associated with this processor.
	 * 
	 * @return the {@link ActionTask} associated with this processor
	 */
	ActionTask getActionTask();

}
