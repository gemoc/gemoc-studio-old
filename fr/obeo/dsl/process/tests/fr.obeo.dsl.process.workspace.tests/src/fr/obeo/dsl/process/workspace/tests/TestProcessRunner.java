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
package fr.obeo.dsl.process.workspace.tests;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.IActionTaskProcessor;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.workspace.WorkspaceProcessRunner;

/**
 * A test implementation that does nothing more.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
final class TestProcessRunner extends WorkspaceProcessRunner {

	/**
	 * Number of times the
	 * {@link fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor#variableChanged(ProcessContext, ProcessVariable, Object, Object)
	 * variable changed} method has been called.
	 */
	int nbVariableChanged;

	/**
	 * Constructor.
	 * 
	 * @param processContext
	 *            the {@link ProcessContext}
	 */
	public TestProcessRunner(ProcessContext processContext) {
		super(processContext);
	}

	/**
	 * Tells if the given {@link ActionTask} is active.
	 * 
	 * @param task
	 *            the {@link ActionTask}
	 * @return <code>true</code> if the given {@link ActionTask} is active, <code>false</code> otherwise
	 */
	public boolean isActive(ActionTask task) {
		return getActiveProcessors().containsKey(task);
	}

	/**
	 * Gets the {@link IActionTaskProcessor} for the given {@link ActionTask}.
	 * 
	 * @param task
	 *            the {@link ActionTask}
	 * @return the {@link IActionTaskProcessor} for the given {@link ActionTask} if any, <code>null</code>
	 *         otherwise
	 */
	public IActionTaskProcessor getProcessor(ActionTask task) {
		return getProcessors().get(task);
	}

	@Override
	public void variableChanged(ProcessContext context, ProcessVariable variable, Object oldValue,
			Object newValue) {
		super.variableChanged(context, variable, oldValue, newValue);
		nbVariableChanged++;
	}

}
