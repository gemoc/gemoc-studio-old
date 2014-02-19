package org.gemoc.gemoc_language_workbench.ui.wizards;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.conf.ECLFile;
import org.gemoc.gemoc_language_workbench.conf.ECLProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.utils.ui.dialogs.SelectDSAIprojectDialog;
import org.gemoc.gemoc_language_workbench.utils.ui.dialogs.SelectECLIFileDialog;

public class CreateDSEWizardContextAction {

	public enum CreateDSEAction {CREATE_NEW_DSE_PROJECT, SELECT_EXISTING_DSE_PROJECT};
	
	public CreateDSEAction actionToExecute = CreateDSEAction.CREATE_NEW_DSE_PROJECT;
	
	protected IProject gemocLanguageIProject; 
	
	public CreateDSEWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}

	public void execute() {
		switch (actionToExecute) {
		case CREATE_NEW_DSE_PROJECT:
			createNewDSEProject();
			break;
		case SELECT_EXISTING_DSE_PROJECT:
			selectExistingDSEProject();
			break;

		default:
			break;
		}
	}

	protected void createNewDSEProject(){
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"createNewDSEProject. Action not implemented yet");
	}
	
	protected void selectExistingDSEProject(){
		/*MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"selectExistingDSEProject. Action not implemented yet");*/
		SelectECLIFileDialog dialog = new SelectECLIFileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		int res = dialog.open();
		if(res == WizardDialog.OK){
			// update the project model
			addECLFileToConf(((IResource)dialog.getResult()[0]).getProject().getName(), ((IResource)dialog.getResult()[0]).getFullPath().toString());
		}
	}
	
	protected void addECLFileToConf(String projectName, String eclFileURI){
		IFile configFile = gemocLanguageIProject.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)); 
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
		    LanguageDefinition language = gemocLanguageWorkbenchConfiguration.getLanguageDefinition();
		    
		    ECLProject eclProject = confFactoryImpl.eINSTANCE.createECLProject();
		    eclProject.setProjectName(projectName);
		    ECLFile eclFile = confFactoryImpl.eINSTANCE.createECLFile();
		    eclFile.setLocationURI(eclFileURI);
		    eclProject.setEclFile(eclFile);
		    
		    language.setDSEProject(eclProject);
		    
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
	
	protected void addDSEProjectToConf(String projectName){
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"addDSEProjectToConf. Action not implemented yet");
	}
	


}
