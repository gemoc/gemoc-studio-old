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
import fr.obeo.dsl.process.IllegalVariableAccessException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.wizard.WizardDialog;
import org.gemoc.gemoc_language_workbench.guideline.process.specific.AbstractGemocActionProcessor;
import org.gemoc.gemoc_language_workbench.guideline.process.specific.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.guideline.process.utils.EclipseResource;
import org.gemoc.gemoc_language_workbench.guideline.process.utils.EclipseUI;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateNewGemocLanguageProject;

/**
 * Create a new Gemoc language project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewGemocLanguageProjectTask extends AbstractGemocActionProcessor {

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewGemocLanguageProjectTask(ActionTask task) {
		super(task);
	}

	@Override
	protected boolean internalValidate(GemocLanguageProcessContext context) {
		// it exists an xdsml IFile corresponding to the URI
		IResource iFile = EclipseResource.getFile(context.getXdsmlURI(getActionTask()));
		return iFile != null;
	}

	@Override
	protected Object internalUpdateContextWhenDone(GemocLanguageProcessContext context) {
		try {
			context.loadXdsmlConfigURI(this.getActionTask());
		} catch (IllegalVariableAccessException e) {
			org.gemoc.gemoc_language_workbench.guideline.process.Activator.getDefault().error(e);
		}
		return context.getXdsmlModel(getActionTask());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.guideline.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	@Override
	protected void internalDoAction(GemocLanguageProcessContext context) {
		CreateNewGemocLanguageProject createNewGemocLanguageProjectWizard = new CreateNewGemocLanguageProject();

		// start the XDSML wizard
		WizardDialog wizardDialog = EclipseUI.createWizardDialog(createNewGemocLanguageProjectWizard);
		int res = wizardDialog.open();
		if (res == WizardDialog.OK) {
			// update context, set the URI
			final URI uri = URI.createPlatformResourceURI("/"
					+ createNewGemocLanguageProjectWizard.getCreatedProject().getName() + "/"
					+ Activator.GEMOC_PROJECT_CONFIGURATION_FILE, true);
			context.setName("Gemoc process: " + uri.toString());
			try {
				context.setXdsmlConfigURI(uri, this.getActionTask());
			} catch (IllegalVariableAccessException e) {
				org.gemoc.gemoc_language_workbench.guideline.process.Activator.getDefault().error(e);
			}
			EclipseResource.touch(uri);
		}
	}

	@Override
	protected String internalUpdateContextWhenUndone(GemocLanguageProcessContext context) {
		// should never happen for first task of a process because already removed by discovery
		return "No xdsml file";
	}

	@Override
	protected boolean internalAcceptAddedResource(GemocLanguageProcessContext context, IResource resource) {
		return EclipseResource.matches(resource, IFile.class, context.getXdsmlURI(getActionTask()));
	}

	@Override
	protected boolean internalAcceptModifiedResource(GemocLanguageProcessContext context, IResource resource) {
		return EclipseResource.matches(resource, IFile.class, context.getXdsmlURI(getActionTask()));
	}

}
