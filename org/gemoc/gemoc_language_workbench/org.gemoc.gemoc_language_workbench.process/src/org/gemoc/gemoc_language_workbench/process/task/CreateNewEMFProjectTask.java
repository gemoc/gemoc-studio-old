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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizard;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateNewGemocLanguageProject;

/**
 * Create a new EMF project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewEMFProjectTask extends AbstractProcessor {

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewEMFProjectTask(ActionTask task) {
		super(task);
	}

	protected String undoneReason="";
	
	public boolean checkIsDone(ProcessContext context, IChange<?> change) {
		
		// filter as much as possible to return ASAP
		// no necessary because the current check is fast
		
		
		// it exists an EMF project that is referenced by the xdsml
		// else setUndone 
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		DomainModelProject dmp = gContext.getXdsmlConfigModel().getLanguageDefinition().getDomainModelProject();
		if(dmp != null && dmp instanceof EMFEcoreProject){
			EMFEcoreProject eep = (EMFEcoreProject)dmp;
			String projectName = eep.getProjectName();
			IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IProject iProject = myWorkspaceRoot.getProject(projectName);
			if(iProject.exists()){
				return true;
			}
			else{
				undoneReason = "project "+projectName+" doesn't exist, check your xdsml file";
			}
		}
		else{
			undoneReason = "no Domain project referenced in your xdsml file";
		}
		return false;
	}


	public Object updateContextWhenDone(ProcessContext context, IChange<?> change) {
		// TODO Auto-generated method stub
		// return the emf project URI
		// setDone(void)
		// or setUndone(void)
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		DomainModelProject dmp = gContext.getXdsmlConfigModel().getLanguageDefinition().getDomainModelProject();
		
		return dmp;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		// open Ecore creation wizard
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		WizardDialog wizardDialog = new WizardDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				new  CreateDomainModelWizard(gContext.getXdsmlIFile().getProject()));
		wizardDialog.open();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		// nothing to do here
	}

	public String updateContextWhenUndone(ProcessContext context, IChange<?> change) {
		return undoneReason;
	}






	
}
