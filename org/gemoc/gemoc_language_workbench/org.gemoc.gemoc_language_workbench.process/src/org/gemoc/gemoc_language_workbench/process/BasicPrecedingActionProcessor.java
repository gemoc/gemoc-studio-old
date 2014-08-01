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
import fr.obeo.dsl.process.ContextVariable;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.process.TaskChanged;
import fr.obeo.dsl.workspace.listener.change.process.VariableChanged;

public abstract class BasicPrecedingActionProcessor extends ActionProcessor {

	
	boolean acceptChangeOnPrecedingInternalChange= true;
	
	public BasicPrecedingActionProcessor(ActionTask task, boolean acceptChangeOnPrecedingInternalChange){
		super(task);
	}
		
	public boolean acceptChange(GemocLanguageProcessContext context, IChange<?> change) {
		if( change instanceof VariableChanged){
			return acceptChangeVariableChanged(context, (ContextVariable)change.getObject());
		}
		else if( change instanceof TaskChanged){
			return acceptChangeTaskChanged(context, (Task)change.getObject());
		}
		return false;
	}

	public boolean acceptChangeTaskChanged(GemocLanguageProcessContext context,  Task task){
		if(acceptChangeOnPrecedingInternalChange)
			return ProcessUtils.isTaskFollowing(getActionTask(), task);
		else return false;
	}
	
	public boolean acceptChangeVariableChanged(GemocLanguageProcessContext context,  ContextVariable variable){
		return false;
	}
}
