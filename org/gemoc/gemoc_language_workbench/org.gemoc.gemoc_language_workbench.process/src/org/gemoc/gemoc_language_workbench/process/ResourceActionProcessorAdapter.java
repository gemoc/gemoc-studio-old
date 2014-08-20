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

import fr.obeo.dsl.process.ProcessContext;

import org.eclipse.core.resources.IResource;

public class ResourceActionProcessorAdapter<T extends ProcessContext> implements IResourceActionProcessor<T>
{
	
	private IResourceActionProcessor<T> _realActionProcessor;

	@SuppressWarnings("unchecked")
	public ResourceActionProcessorAdapter(IActionProcessor<T> actionProcessor) {
		if (actionProcessor instanceof IResourceActionProcessor<?>)
		{
			_realActionProcessor = (IResourceActionProcessor<T>)actionProcessor;
		}
	}

	@Override
	public boolean acceptChangeForRemovedResource(T context, IResource resource) {
		boolean result = false;
		if (_realActionProcessor != null)
			_realActionProcessor.acceptChangeForRemovedResource(context, resource);
		return result;
	}

	@Override
	public boolean acceptChangeForAddedResource(T context, IResource resource) {
		boolean result = false;
		if (_realActionProcessor != null)
			_realActionProcessor.acceptChangeForRemovedResource(context, resource);
		return result;
	}

	@Override
	public boolean acceptChangeForModifiedResource(T context, IResource resource) {
		boolean result = false;
		if (_realActionProcessor != null)
			_realActionProcessor.acceptChangeForModifiedResource(context, resource);
		return result;
	}

}
