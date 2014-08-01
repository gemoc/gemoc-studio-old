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

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.design.wizard.EcoreModelerWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.gemoc.commons.eclipse.ui.WizardFinder;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EMFGenmodel;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.process.ResourceActionProcessor;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseResource;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseUI;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction.CreateDomainModelAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction.CreateEditorProjectAction;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

/**
 * Create a new EMF project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewEMFProjectTask extends ResourceActionProcessor 
{

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewEMFProjectTask(ActionTask task) 
	{
		super(task, true);
	}

	protected String undoneReason="";
	
	public boolean validate(GemocLanguageProcessContext context) 
	{
		// it exists an EMF project that is referenced by the xdsml
		// else setUndone 
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		if (dmp != null 
			&& dmp instanceof EMFEcoreProject)
		{
			EMFEcoreProject eep = (EMFEcoreProject)dmp;
			String projectName = eep.getProjectName();
			if (EclipseResource.existProject(projectName))
			{
				return true;
			}
			else
			{
				undoneReason = "Project " + projectName + " doesn't exist, check your xdsml file.";
			}
		}
		else
		{
			undoneReason = "No Domain project referenced in your xdsml file.";
		}
		return false;
	}


	public Object updateContextWhenDone(GemocLanguageProcessContext context) 
	{
		// TODO Auto-generated method stub
		// return the emf project URI
		// setDone(void)
		// or setUndone(void)
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();		
		// update the cache pointing to the ecore file
		// Discussion, the ActiveFileEcore may not be the best way to retreive the ecore ?
		IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		ActiveFile activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject);
		context.setEcoreIFile(activeFileEcore.getActiveFile());				
		return dmp;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(GemocLanguageProcessContext context) 
	{		
		IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		CreateDomainModelWizardContextAction action = new CreateDomainModelWizardContextAction(updatedGemocLanguageProject);
		action.actionToExecute = CreateDomainModelAction.CREATE_NEW_EMF_PROJECT;
		action.execute();
	}
	
	
		
		
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(GemocLanguageProcessContext context) 
	{
		// nothing to do here
	}

	public String updateContextWhenUndone(GemocLanguageProcessContext context) 
	{
		return undoneReason;
	}


	@Override
	public boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context, IResource resource) 
	{
		// if the changed resource is an IProject referenced by the xdsml
		if (resource instanceof IProject)
		{
			DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
			if (dmp != null 
				&& dmp instanceof EMFEcoreProject)
			{
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				return resource.getName().equals(projectName);
			}
		}
		// if the change is about the ecoreFile
		if (resource instanceof IFile)
		{
			if (context.getEcoreIFile() !=  null)
			{
				return resource.getFullPath().toString().equals(context.getEcoreIFile().getFullPath().toString());
			}
		}
		return false;
	}

	@Override
	public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) 
	{
		// if xdsml of the process has changed
		final URI uri = EclipseResource.getUri(resource);
		if (uri.equals(context.getXdsmlURI()))
		{
			return true;
		}
		
		// or if the changed resource is an IProject referenced by the xdsml
		if (resource instanceof IProject)
		{
			DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
			if (dmp != null 
				&& dmp instanceof EMFEcoreProject)
			{
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				return resource.getName().equals(projectName);
			}
		}
		// if the change is about the ecoreFile
		if (resource instanceof IFile)
		{
			if (context.getEcoreIFile() !=  null)
			{
				return resource.getFullPath().toString().equals(context.getEcoreIFile().getFullPath().toString());
			}
		}
		return false;
	}

	@Override
	public boolean acceptChangeVariableChanged(GemocLanguageProcessContext context,  ContextVariable variable){
		// if the xdsml model has changed, need to reevaluate
		if(variable.getName().equals(GemocLanguageProcessContext.XDSML_MODEL_VAR)){
			return true;
		}
		return false;
	}
	
}
