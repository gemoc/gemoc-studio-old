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
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceContentChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import org.eclipse.core.resources.IResource;
import org.gemoc.gemoc_language_workbench.process.IResourceActionProcessor;
import org.gemoc.gemoc_language_workbench.process.ITaskChangedActionProcessor;
import org.gemoc.gemoc_language_workbench.process.IVariableChangedActionProcessor;
import org.gemoc.gemoc_language_workbench.process.support.AbstractActionProcessor;

public abstract class AbstractActionProcessor2 extends AbstractActionProcessor<GemocLanguageProcessContext> implements IResourceActionProcessor, IVariableChangedActionProcessor, ITaskChangedActionProcessor {

	protected String undoneReason = "";
	
	public AbstractActionProcessor2(ActionTask task) {
		super(task);
	}

	private GemocLanguageProcessContext castContext(ProcessContext context) {
		return (GemocLanguageProcessContext)context;
	}
	
	@Override
	public final boolean acceptVariableChanged(ProcessContext processContext, ContextVariable variableChanged) {
		return acceptChangeVariableChanged(castContext(processContext), variableChanged);
	}

	protected boolean acceptChangeVariableChanged(GemocLanguageProcessContext context, ContextVariable variableChanged) {
		return false;
	}

	@Override
	public boolean acceptTaskChanged(ProcessContext processContext, Task changedTask) {
		return true;
	}
	

	@Override
	protected String internalUpdateContextWhenUndone(GemocLanguageProcessContext context) {
		return undoneReason;
	}

	@Override
	protected void internalUndoAction(GemocLanguageProcessContext context) {
	}

	@Override
	public final boolean acceptChange(ProcessContext context, IChange<?> change) {
		boolean result = false;
		if (change instanceof ResourceAdded) {
				result = acceptChangeForAddedResource(context, (IResource)change.getObject());
		} else if (change instanceof ResourceRemoved) {
			result = acceptChangeForRemovedResource(context, (IResource)change.getObject());
		} else if (change instanceof ResourceMoved) {
			result = acceptChangeForAddedResource(context, (IResource)((ResourceMoved)change)
					.getDestination())
					|| acceptChangeForRemovedResource(context, (IResource)change.getObject());
		} else if (change instanceof ResourceContentChanged) {
			result = acceptChangeForModifiedResource(context, (IResource)change.getObject());
		}
		return result;
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
}
