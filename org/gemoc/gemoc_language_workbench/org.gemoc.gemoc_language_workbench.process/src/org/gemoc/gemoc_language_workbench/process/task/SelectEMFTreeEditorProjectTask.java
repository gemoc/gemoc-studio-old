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

import org.eclipse.core.resources.IProject;
import org.gemoc.gemoc_language_workbench.process.specific.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction.CreateEditorProjectAction;

/**
 * Create a new EMF project.
 * 
 * @author Didier Vojtisek</a>
 */
public class SelectEMFTreeEditorProjectTask extends CreateNewEMFTreeEditorProjectTask {

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public SelectEMFTreeEditorProjectTask(ActionTask task) {
		super(task);
	}

	@Override
	protected void internalDoAction(GemocLanguageProcessContext context) {
		IProject updatedGemocLanguageProject = context.getXdsmlFile(getActionTask()).getProject();
		CreateEditorProjectWizardContextAction action = new CreateEditorProjectWizardContextAction(updatedGemocLanguageProject);
		action.actionToExecute = CreateEditorProjectAction.SELECT_EXISTING_EMFTREE_PROJECT;
		action.execute();
	}


}
