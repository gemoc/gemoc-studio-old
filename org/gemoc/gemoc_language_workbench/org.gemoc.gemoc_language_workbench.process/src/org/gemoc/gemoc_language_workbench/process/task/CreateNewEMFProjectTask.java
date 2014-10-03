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
import fr.obeo.dsl.process.Activator;
import fr.obeo.dsl.process.IllegalVariableAccessException;
import fr.obeo.dsl.process.ProcessVariable;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.process.specific.AbstractGemocActionProcessor;
import org.gemoc.gemoc_language_workbench.process.specific.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseResource;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction.CreateDomainModelAction;

/**
 * Create a new EMF project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewEMFProjectTask extends AbstractGemocActionProcessor {

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewEMFProjectTask(ActionTask task) {
		super(task);
	}

	@Override
	protected boolean internalAcceptRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		return EclipseResource.matches(resource, IProject.class, context.getEcoreProjectName(getActionTask()))
				|| EclipseResource.matches(resource, IFile.class, context.getEcoreIFile(getActionTask()));
	}

	@Override
	protected boolean internalAcceptAddedResource(GemocLanguageProcessContext context, IResource resource) {
		return EclipseResource.matches(resource, IFile.class, context.getXdsmlURI(getActionTask()))
				|| EclipseResource.matches(resource, IProject.class, context.getEcoreProjectName(getActionTask()))
				|| EclipseResource.matches(resource, IFile.class, context.getEcoreIFile(getActionTask()));
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
		// TODO Auto-generated method stub
		// return the emf project URI
		// setDone(void)
		// or setUndone(void)
		EMFEcoreProject eep = context.getEcoreProject(getActionTask());
		// update the cache pointing to the ecore file
		// Discussion, the ActiveFileEcore may not be the best way to retreive the ecore ?
		IProject updatedGemocLanguageProject = context.getXdsmlFile(getActionTask()).getProject();
		ActiveFile activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject);
		try {
			context.setEcoreIFile(activeFileEcore.getActiveFile(), this.getActionTask());
		} catch (IllegalVariableAccessException e) {
			Activator.getDefault().error(e);
		}
		return eep;
	}

	@Override
	protected boolean internalValidate(GemocLanguageProcessContext context) {
		// it exists an EMF project that is referenced by the xdsml
		// else setUndone
		String projectName = context.getEcoreProjectName(getActionTask());
		if (projectName != null) {
			if (EclipseResource.existProject(projectName)) {
				return true;
			} else {
				undoneReason = "Project " + projectName + " doesn't exist, check your xdsml file.";
			}
		} else {
			undoneReason = "No Domain project referenced in your xdsml file.";
		}
		return false;
	}

	@Override
	protected void internalDoAction(GemocLanguageProcessContext context) {
		IProject updatedGemocLanguageProject = context.getXdsmlFile(getActionTask()).getProject();
		CreateDomainModelWizardContextAction action = new CreateDomainModelWizardContextAction(
				updatedGemocLanguageProject);
		action.actionToExecute = CreateDomainModelAction.CREATE_NEW_EMF_PROJECT;
		action.execute();
	}

}
