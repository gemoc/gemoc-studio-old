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
package org.gemoc.gemoc_language_workbench.process.support;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.Task;

import org.eclipse.core.resources.IResource;

/**
 * Default task for incomplete Process.
 * 
 * @param <T>
 * @author <a href="mailto:didier.vojtisek@inria.fr">Didier Vojtisek</a>
 */
public class NotImplementedTask<T extends ProcessContext> extends AbstractActionProcessor<T> {

	public NotImplementedTask(ActionTask task) {
		super(task);
	}

	@Override
	protected Object internalUpdateContextWhenDone(ProcessContext context) {
		// cannot happen !
		return null;
	}

	@Override
	protected String internalUpdateContextWhenUndone(ProcessContext context) {
		return "Task isn't implemented. Please ask to the person in charge of the development of this Process";
	}

	@Override
	protected boolean internalValidate(ProcessContext context) {
		return false;
	}

	@Override
	protected void internalDoAction(ProcessContext context) {
	}

	@Override
	protected void internalUndoAction(ProcessContext context) {
	}

	@Override
	protected boolean acceptChangeVariableChanged(ProcessContext context, ProcessVariable variableChanged) {
		return false;
	}

	@Override
	protected boolean acceptChangeTaskChanged(ProcessContext context, Task changedTask) {
		return true;
	}

	@Override
	protected boolean internalAcceptRemovedResource(ProcessContext context, IResource resource) {
		return false;
	}

	@Override
	protected boolean internalAcceptAddedResource(ProcessContext context, IResource resource) {
		return false;
	}

	@Override
	protected boolean internalAcceptModifiedResource(ProcessContext context, IResource resource) {
		return false;
	}

}
