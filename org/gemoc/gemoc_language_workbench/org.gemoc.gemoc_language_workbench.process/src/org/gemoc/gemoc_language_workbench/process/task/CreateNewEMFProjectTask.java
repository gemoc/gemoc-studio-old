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
import fr.obeo.dsl.process.ContextVariable;
import fr.obeo.dsl.process.IllegalVariableAccessException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.process.AbstractResourceActionProcessor;
import org.gemoc.gemoc_language_workbench.process.Activator;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
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
public class CreateNewEMFProjectTask extends AbstractResourceActionProcessor {


	protected String undoneReason = "";
	
	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewEMFProjectTask(ActionTask task) {
		super(task, true);
	}


	public boolean validate(GemocLanguageProcessContext context) {
		// it exists an EMF project that is referenced by the xdsml
		// else setUndone
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		if (dmp != null && dmp instanceof EMFEcoreProject) {
			EMFEcoreProject eep = (EMFEcoreProject)dmp;
			String projectName = eep.getProjectName();
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

	public Object updateContextWhenDone(GemocLanguageProcessContext context) {
		// TODO Auto-generated method stub
		// return the emf project URI
		// setDone(void)
		// or setUndone(void)
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		// update the cache pointing to the ecore file
		// Discussion, the ActiveFileEcore may not be the best way to retreive the ecore ?
		IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		ActiveFile activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject);
		try {
			context.setEcoreIFile(activeFileEcore.getActiveFile(), this.getActionTask());
		} catch (IllegalVariableAccessException e) {
			Activator.getDefault().error(e);
		}
		return dmp;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(GemocLanguageProcessContext context) {
		IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		CreateDomainModelWizardContextAction action = new CreateDomainModelWizardContextAction(
				updatedGemocLanguageProject);
		action.actionToExecute = CreateDomainModelAction.CREATE_NEW_EMF_PROJECT;
		action.execute();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(GemocLanguageProcessContext context) {
		// nothing to do here
	}

	public String updateContextWhenUndone(GemocLanguageProcessContext context) {
		return undoneReason;
	}

	@Override
	public boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		boolean result = false;
		// if the changed resource is an IProject referenced by the xdsml
		if (resource instanceof IProject) {
			DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
			if (dmp != null && dmp instanceof EMFEcoreProject) {
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				result = resource.getName().equals(projectName);
			}
		} else	if (resource instanceof IFile) {
			// if the change is about the ecoreFile
			if (context.getEcoreIFile() != null) {
				result = resource.getFullPath().toString().equals(
						context.getEcoreIFile().getFullPath().toString());
			}
		}
		return result;
	}

	@Override
	public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) {
		boolean result = false;
		// if xdsml of the process has changed
		final URI uri = EclipseResource.getUri(resource);
		if (uri.equals(context.getXdsmlURI())) {
			result = true;
		} else if (resource instanceof IProject) {
			// or if the changed resource is an IProject referenced by the xdsml
			DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
			if (dmp != null && dmp instanceof EMFEcoreProject) {
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				result = resource.getName().equals(projectName);
			}
		} else if (resource instanceof IFile) {
			// if the change is about the ecoreFile
			if (context.getEcoreIFile() != null) {
				result = resource.getFullPath().toString().equals(
						context.getEcoreIFile().getFullPath().toString());
			}
		}
		return result;
	}

	@Override
	public boolean acceptChangeVariableChanged(GemocLanguageProcessContext context, ContextVariable variable) {
		// if the xdsml model has changed, need to reevaluate
		if (variable.getName().equals(GemocLanguageProcessContext.XDSML_MODEL_VAR)) {
			return true;
		}
		return false;
	}

}
