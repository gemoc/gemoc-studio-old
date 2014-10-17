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
package fr.obeo.dsl.process.workspace;

import fr.obeo.dsl.process.IActionTaskProcessor;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.workspace.listener.change.IChange;

/**
 * Abstract implementation of {@link fr.obeo.dsl.process.ActionTask ActionTask#getInstanceClassName()} for
 * workspace tasks.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public interface IWorkspaceTaskProcessor extends IActionTaskProcessor {

	/**
	 * Validates it states in the given {@link ProcessContext} by calling
	 * {@link ProcessContext#setDone(fr.obeo.dsl.process.ActionTask, Object)},
	 * {@link ProcessContext#setUndone(fr.obeo.dsl.process.ActionTask, String)}. It can also manage
	 * {@link fr.obeo.dsl.process.ProcessVariable ProcessVariable} by calling
	 * {@link ProcessContext#setVariableValue(fr.obeo.dsl.process.ProcessVariable, Object, fr.obeo.dsl.process.ActionTask)}
	 * .
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link IChange}
	 */
	void validate(ProcessContext context, IChange<?> change);

}
