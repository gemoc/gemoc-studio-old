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
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.process.ResourceActionProcessor;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;

/**
 * Create a new EMF project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewEMFProjectTask extends ResourceActionProcessor {

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
	
	public boolean validate(GemocLanguageProcessContext context) 
	{
		
		// filter as much as possible to return ASAP
		// no necessary because the current check is fast
		
		
		// it exists an EMF project that is referenced by the xdsml
		// else setUndone 
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
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


	public Object updateContextWhenDone(GemocLanguageProcessContext context) {
		// TODO Auto-generated method stub
		// return the emf project URI
		// setDone(void)
		// or setUndone(void)
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		
		return dmp;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(GemocLanguageProcessContext context) {
		// open Ecore creation wizard
		IWizardDescriptor descriptor = WizardFinder.findNewWizardDescriptor("org.eclipse.ecoretools.emf.design.wizardID");
		
		// Then if we have a wizard, open it.
		if (descriptor != null) {
			// add a listener to capture the creation of the resulting project
			NewProjectWorkspaceListener workspaceListener = new NewProjectWorkspaceListener();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
			try {
				IWizard wizard;
				wizard = descriptor.createWizard();
				// this wizard need some dedicated initialization
				((EcoreModelerWizard )wizard).init(PlatformUI.getWorkbench(), (IStructuredSelection) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection());
				//((EcoreModelWizard)wizard).init(PlatformUI.getWorkbench(), (IStructuredSelection) selection);
				WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
				wd.create();
				wd.setTitle(wizard.getWindowTitle());
				
				int res = wd.open();
				if(res == WizardDialog.OK){
					ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceListener);
					IProject createdProject = workspaceListener.getLastCreatedProject();
					// update the project configuration model
					if(createdProject != null){
						addEMFProjectToConf((GemocLanguageProcessContext)context, createdProject.getName());
					}
					else{
						addEMFProjectToConf((GemocLanguageProcessContext)context, "");
					}
				}
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
			finally{
				// make sure to remove listener in all situations
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceListener);
			}
		}
	}
	protected void addEMFProjectToConf(GemocLanguageProcessContext gContext, String projectName){
		IFile configFile = gContext.getXdsmlFile(); 
		if(configFile.exists()){
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

		    // Obtain a new resource set
		    ResourceSet resSet = new ResourceSetImpl();

		    // get the resource
		    Resource resource = resSet.getResource(URI.createURI(configFile.getLocationURI().toString()),true);
		    
		    
		    GemocLanguageWorkbenchConfiguration gemocLanguageWorkbenchConfiguration = (GemocLanguageWorkbenchConfiguration) resource.getContents().get(0);
		    // consider only one language :-/
		    LanguageDefinition langage = gemocLanguageWorkbenchConfiguration.getLanguageDefinition();
		    
		    // create missing data
		    EMFEcoreProject emfEcoreProject = confFactoryImpl.eINSTANCE.createEMFEcoreProject();
		    emfEcoreProject.setProjectName(projectName);
		    langage.setDomainModelProject(emfEcoreProject);
		    			
			
			try {
				resource.save(null);
			} catch (IOException e) {
				Activator.error(e.getMessage(), e);
			}
		}
		try {
			configFile.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
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
		// if the changed resource is an IProject referenced by the xdsml
		if(resource instanceof IProject){
			DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
			if(dmp != null && dmp instanceof EMFEcoreProject){
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				return resource.getName().equals(projectName);
			}
		}
		return false;
	}

	@Override
	public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) {
		// if xdsml of the process has changed
		final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		if(uri.equals(context.getXdsmlURI())){
			return true;
		}
		
		// or if the changed resource is an IProject referenced by the xdsml
		if(resource instanceof IProject){
			DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
			if(dmp != null && dmp instanceof EMFEcoreProject){
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				return resource.getName().equals(projectName);
			}
		}
		
		return false;
	}



	@Override
	public boolean acceptChangeForModifiedResource(GemocLanguageProcessContext context, IResource resource) {
		// if xdsml of the process has changed
		final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		if(uri.equals(context.getXdsmlURI())){
			return true;
		}
		return false;
	}






	
}
