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
package org.gemoc.gemoc_language_workbench.process.task;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.workspace.listener.change.IChange;

import java.io.IOException;

import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.ProjectKind;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;
import org.gemoc.gemoc_language_workbench.process.Activator;

/**
 * Select project kind.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Task2c extends AbstractProcessor {

	/**
	 * The reference to the {@link ActionTask} corresponding to {@link Task1}.
	 */
	private final ActionTask task1;

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 * @param task1
	 *            the reference to the {@link ActionTask} corresponding to {@link Task1}
	 */
	public Task2c(ActionTask task, ActionTask task1) {
		super(task);
		this.task1 = task1;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#updateContexts(fr.obeo.dsl.process.IProcessRunner,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void updateContexts(IProcessRunner runner, IChange<?> change) {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		// TODO create a kind selection dialog

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)context
				.getResult(task1);
		if (config != null && config.getLanguageDefinition() != null
				&& config.getLanguageDefinition().getDomainModelProject() != null) {
			config.getLanguageDefinition().getDomainModelProject().setProjectKind(ProjectKind.get(0));
			try {
				config.eResource().save(null);
			} catch (IOException e) {
				Activator.getDefault().error(e);
			}
			context.setDone(getActionTask(), ProjectKind.get(0));
		}
	}
}
