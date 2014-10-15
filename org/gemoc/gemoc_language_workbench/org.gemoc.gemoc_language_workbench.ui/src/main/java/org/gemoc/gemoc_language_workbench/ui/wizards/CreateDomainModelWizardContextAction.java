package org.gemoc.gemoc_language_workbench.ui.wizards;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
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
import org.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
import org.gemoc.commons.eclipse.ui.WizardFinder;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectEMFIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;

//import org.eclipse.emf.ecoretools.design.wizard.EcoreModelerWizard;


/**
 * This class is both a context for the wizard and a Command that will be executed
 * @author dvojtise
 *
 */
public class CreateDomainModelWizardContextAction {

	public enum CreateDomainModelAction {CREATE_NEW_EMF_PROJECT, SELECT_EXISTING_EMF_PROJECT};
	
	public CreateDomainModelAction actionToExecute = CreateDomainModelAction.CREATE_NEW_EMF_PROJECT;
	

	// one of these must be set, depending on it it will work on the file or directly in the model 
	protected IProject gemocLanguageIProject = null;	
	protected LanguageDefinition gemocLanguageModel = null;
	
	public CreateDomainModelWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}

	public CreateDomainModelWizardContextAction(LanguageDefinition rootModelElement) {
		gemocLanguageModel = rootModelElement;
	}

	public void execute() {
		switch (actionToExecute) {
		case CREATE_NEW_EMF_PROJECT:
			createNewEMFProject();
			break;
		case SELECT_EXISTING_EMF_PROJECT:
			selectExistingEMFProject();
			break;

		default:
			break;
		}
		
	}

	protected void createNewEMFProject(){
		// launch the appropriate wizard
		
		// "org.eclipse.emf.importer.ui.EMFProjectWizard" = create EMFProject from existing Ecore file
		
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
						addEMFProjectToConf(createdProject);
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
	
	protected void selectExistingEMFProject(){
		// launch the appropriate wizard
		SelectEMFIProjectDialog dialog = new SelectEMFIProjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		int res = dialog.open();
		if(res == WizardDialog.OK){
			// update the project model
			addEMFProjectToConf(((IProject)dialog.getResult()[0]));
		}
	}
	
	protected void addEMFProjectToConf(IProject emfProject){
		if(gemocLanguageIProject != null){
			addEMFProjectToConf(emfProject, gemocLanguageIProject);
		}
		if(gemocLanguageModel != null){
			addEMFProjectToConf(emfProject, gemocLanguageModel);
		}
	}
	protected void addEMFProjectToConf(IProject emfProject,IProject gemocProject){
		IFile configFile = gemocProject.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)); 
		if(configFile.exists()){
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

		    // Obtain a new resource set
		    ResourceSet resSet = new ResourceSetImpl();

		    // get the resource
		    Resource resource = resSet.getResource(URI.createURI(configFile.getLocationURI().toString()),true);
		    
		    
		    LanguageDefinition gemocLanguageWorkbenchConfiguration = (LanguageDefinition) resource.getContents().get(0);
		    addEMFProjectToConf(emfProject, gemocLanguageWorkbenchConfiguration);
			
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
	
	protected void addEMFProjectToConf(IProject emfProject,LanguageDefinition langage){
		
	    
	    // create missing data
		DomainModelProject emfEcoreProject = confFactoryImpl.eINSTANCE.createDomainModelProject();
	    emfEcoreProject.setProjectName(emfProject.getName());
	    langage.setDomainModelProject(emfEcoreProject);
	    	
	    // also add the genmodel if present
	    FileFinderVisitor ecoreProjectVisitor = new FileFinderVisitor("genmodel");
		try {
			emfProject.accept(ecoreProjectVisitor);
			IFile genmodelIFile = ecoreProjectVisitor.getFile();
			if(genmodelIFile != null){
				emfEcoreProject.setGenmodeluri(genmodelIFile.getFullPath().toString());
			}
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}
	
}
