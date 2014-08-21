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
import fr.obeo.dsl.process.ContextVariable;
import fr.obeo.dsl.process.ProcessContext;

import org.eclipse.core.resources.IResource;
import org.gemoc.gemoc_language_workbench.process.IResourceActionProcessor;
import org.gemoc.gemoc_language_workbench.process.IVariableActionProcessor;
import org.gemoc.gemoc_language_workbench.process.support.AbstractActionProcessor;
import org.gemoc.gemoc_language_workbench.process.support.PreviousTaskChangeAcceptanceStategy;
import org.gemoc.gemoc_language_workbench.process.support.ResourceChangeAcceptanceStrategy;
import org.gemoc.gemoc_language_workbench.process.support.VariableChangeAcceptanceStrategy;

public abstract class AbstractActionProcessor2 extends AbstractActionProcessor<GemocLanguageProcessContext> implements IResourceActionProcessor, IVariableActionProcessor {

	protected String undoneReason = "";
	
	public AbstractActionProcessor2(ActionTask task, boolean acceptChangeOnPrecedingInternalChange) {
		super(task);
		addCaller(new ResourceChangeAcceptanceStrategy());
		addCaller(new VariableChangeAcceptanceStrategy());
		if (acceptChangeOnPrecedingInternalChange) {
			addCaller(new PreviousTaskChangeAcceptanceStategy());
		}
	}

	private GemocLanguageProcessContext castContext(ProcessContext context) {
		return (GemocLanguageProcessContext)context;
	}

	public boolean acceptChangeVariableChanged(ProcessContext context, ContextVariable variable) {
		return acceptChangeVariableChanged(castContext(context), variable);
	}

	protected boolean acceptChangeVariableChanged(GemocLanguageProcessContext context, IResource resource) {
		return false;
	}

	public final boolean acceptChangeForRemovedResource(ProcessContext context, IResource resource) {
		return acceptChangeForRemovedResource(castContext(context), resource);
	}

	protected boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		return false;
	}

	public final boolean acceptChangeForAddedResource(ProcessContext context, IResource resource) {
		return acceptChangeForAddedResource(castContext(context), resource);
	}

	protected boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) {
		return false;
	}

	public final boolean acceptChangeForModifiedResource(ProcessContext context, IResource resource) {
		return acceptChangeForModifiedResource(castContext(context), resource);
	}

	protected boolean acceptChangeForModifiedResource(GemocLanguageProcessContext context, IResource resource) {
		return false;
	}

	@Override
	protected String internalUpdateContextWhenUndone(GemocLanguageProcessContext context) {
		return undoneReason;
	}

	@Override
	protected void internalUndoAction(GemocLanguageProcessContext context) {
	}

}
