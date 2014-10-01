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
package org.gemoc.gemoc_language_workbench.process.specific;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.Task;

import org.eclipse.core.resources.IResource;
import org.gemoc.gemoc_language_workbench.process.support.AbstractActionProcessor;

public abstract class AbstractGemocActionProcessor extends AbstractActionProcessor<GemocLanguageProcessContext> {

	protected String undoneReason = "";

	public AbstractGemocActionProcessor(ActionTask task) {
		super(task);
	}

	@Override
	protected String internalUpdateContextWhenUndone(GemocLanguageProcessContext context) {
		return undoneReason;
	}

	@Override
	protected void internalUndoAction(GemocLanguageProcessContext context) {
	}

	@Override
	protected boolean acceptChangeVariableChanged(GemocLanguageProcessContext context,
			ProcessVariable variableChanged) {
		return false;
	}

	@Override
	protected boolean acceptChangeTaskChanged(GemocLanguageProcessContext context, Task changedTask) {
		return true;
	}

	@Override
	protected boolean internalAcceptRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		return false;
	}

	@Override
	protected boolean internalAcceptAddedResource(GemocLanguageProcessContext context, IResource resource) {
		return false;
	}

	@Override
	protected boolean internalAcceptModifiedResource(GemocLanguageProcessContext context, IResource resource) {
		return false;
	}
}
