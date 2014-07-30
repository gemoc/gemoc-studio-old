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
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceContentChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;
import org.gemoc.gemoc_language_workbench.process.AbstractResourceProcessor;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateNewGemocLanguageProject;

/**
 * Create a new Gemoc language project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewGemocLanguageProjectTask extends AbstractResourceProcessor {

	
	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewGemocLanguageProjectTask(ActionTask task) {
		super(task);
	}



	public boolean validate(ProcessContext context) {
		
		// it exists an xdsml IFile corresponding to the URI
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource iFile = myWorkspaceRoot.findMember(gContext.getXdsmlConfigURI().toPlatformString(true));
		
		return iFile != null;
	}
	
	public Object updateContextWhenDone(ProcessContext context) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		
		// find the IFile for the URI
		
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IFile iFile = (IFile)myWorkspaceRoot.findMember(gContext.getXdsmlConfigURI().toPlatformString(true));
		gContext.setXdsmlIFile(iFile);
		
		return iFile;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		
		
		CreateNewGemocLanguageProject createNewGemocLanguageProjectWizard = new  CreateNewGemocLanguageProject();
		
		
		// start the XDSML wizard
		WizardDialog wizardDialog = new WizardDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				createNewGemocLanguageProjectWizard);
		int res = wizardDialog.open();
		if(res == WizardDialog.OK){
			// update context, set the URI 
			final URI uri = URI.createPlatformResourceURI("/"+createNewGemocLanguageProjectWizard.getCreatedProject().getName()+"/"+Activator.GEMOC_PROJECT_CONFIGURATION_FILE, true);
			gContext.setName(uri.toString());
			gContext.setXdsmlConfigURI(uri);
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		// TODO remove the project ?

	}



	public String updateContextWhenUndone(ProcessContext context) {
		// should never happen for first task of a process because already removed by discovery
		return "No xdsml file";
	}


	@Override
	public boolean acceptChangeForRemovedResource(ProcessContext context, IResource resource) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean acceptChangeForAddedResource(ProcessContext context, IResource resource) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		if(uri.equals(gContext.getXdsmlConfigURI())){
			return true;
		}
		return false;
	}

	@Override
	public boolean acceptChangeForModifiedResource(ProcessContext context, IResource resource) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		if(uri.equals(gContext.getXdsmlConfigURI())){
			return true;
		}
		return false;
	}

}
