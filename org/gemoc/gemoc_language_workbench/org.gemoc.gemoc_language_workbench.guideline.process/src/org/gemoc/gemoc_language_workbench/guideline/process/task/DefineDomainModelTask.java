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
package org.gemoc.gemoc_language_workbench.guideline.process.task;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessVariable;

import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.guideline.process.specific.AbstractGemocActionProcessor;
import org.gemoc.gemoc_language_workbench.guideline.process.specific.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.guideline.process.utils.EclipseResource;

/**
 * Create a new EMF project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DefineDomainModelTask extends AbstractGemocActionProcessor {

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public DefineDomainModelTask(ActionTask task) {
		super(task);
	}

	@Override
	protected boolean acceptChangeVariableChanged(GemocLanguageProcessContext context,
			ProcessVariable variable) {
		// if the xdsml model has changed, need to reevaluate
		if (variable.getName().equals(GemocLanguageProcessContext.XDSML_MODEL_VAR)) {
			return true;
		}
		return false;
	}

	@Override
	protected Object internalUpdateContextWhenDone(GemocLanguageProcessContext context) {

		DomainModelProject eep = context.getEcoreProject(getActionTask());

		return eep;
	}

	@Override
	protected boolean internalValidate(GemocLanguageProcessContext context) {
		// it exists an EMF project that is referenced by the xdsml
		// else setUndone
		DomainModelProject eep = context.getEcoreProject(getActionTask());
		if (eep != null) {
			if (EclipseResource.existProject(eep.getProjectName())) {
				return true;
			} else {
				undoneReason = "Project " + eep.getProjectName() + " doesn't exist, check your xdsml file.";
			}
		} else {
			undoneReason = "No Domain project referenced in your xdsml file.";
		}
		return false;
	}

	@Override
	protected void internalDoAction(GemocLanguageProcessContext context) {
		/*
		 * IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		 * CreateDomainModelWizardContextAction action = new CreateDomainModelWizardContextAction(
		 * updatedGemocLanguageProject); action.actionToExecute =
		 * CreateDomainModelAction.CREATE_NEW_EMF_PROJECT; action.execute();
		 */
		PlatformUI.getWorkbench().getHelpSystem().displayHelpResource(
				"/" + org.gemoc.gemoc_language_workbench.documentation.Activator.PLUGIN_ID
						+ "/eclipse_help/eclipse/ch01.html#_defining_abstract_syntax_or_domain_concepts");
	}

}
