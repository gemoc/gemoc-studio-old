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
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceContentChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import org.eclipse.core.resources.IResource;

/**
 * 
 * A processor that deals exclusively with eclipse {@link IResource}.
 *
 * @author ftanguy
 */
public abstract class AbstractResourceActionProcessor extends AbstractActionProcessor {

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public AbstractResourceActionProcessor(ActionTask task) {
		super(task);
	}
	
	public boolean acceptChange(GemocLanguageProcessContext context, IChange<?> change) 
	{
		if (change instanceof ResourceAdded)
		{
			return acceptChangeForAddedResource(context, (IResource)change.getObject());
		} 
		else if (change instanceof ResourceRemoved)
		{
			return acceptChangeForRemovedResource(context, (IResource)change.getObject());
		}  
		else if(change instanceof ResourceMoved)
		{
			return acceptChangeForAddedResource(context, (IResource)((ResourceMoved)change).getDestination()) 
					|| acceptChangeForRemovedResource(context, (IResource)change.getObject());			
		}  
		else if(change instanceof ResourceContentChanged)
		{
			return acceptChangeForModifiedResource(context, (IResource)change.getObject());
		} 
		return false;
	}
		
	abstract public boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context,  IResource resource);
	abstract public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context,  IResource resource);
	abstract public boolean acceptChangeForModifiedResource(GemocLanguageProcessContext context,  IResource resource);

}
