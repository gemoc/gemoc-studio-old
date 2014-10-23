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
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.gemoc.commons.eclipse.ui.WizardFinder;
import org.gemoc.gemoc_language_workbench.conf.MoCCProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectMoCIFileDialog;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;

public class CreateMoCWizardContextAction {

	public enum CreateMoCAction {
		CREATE_NEW_MOC_PROJECT, SELECT_EXISTING_MOC_PROJECT
	};

	public CreateMoCAction actionToExecute = CreateMoCAction.CREATE_NEW_MOC_PROJECT;

	// one of these must be set, depending on it it will work on the file or
	// directly in the model
	protected IProject gemocLanguageIProject = null;
	protected LanguageDefinition gemocLanguageModel = null; // What is it ????

	public CreateMoCWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}
	public CreateMoCWizardContextAction(IProject updatedGemocLanguageProject, LanguageDefinition rootModelElement) {
		gemocLanguageIProject = updatedGemocLanguageProject;
		gemocLanguageModel = rootModelElement;
	}
	

	public void execute() {
		switch (actionToExecute) {
		case CREATE_NEW_MOC_PROJECT:
			createNewMoCProject();
			break;
		case SELECT_EXISTING_MOC_PROJECT:
			selectExistingMoCProject();
			break;

		default:
			break;
		}
	}
	
	protected void createNewMoCProject() {
		final IWizardDescriptor descriptor = WizardFinder.findNewWizardDescriptor("org.gemoc.gemoc_language_workbench.ui.wizards.CreateNewMoCProject");
		// Then if we have a wizard, open it.
		if (descriptor != null) {				
			NewProjectWorkspaceListener workspaceListener = new NewProjectWorkspaceListener();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
			try {
				IWorkbenchWizard wizard;
				wizard = descriptor.createWizard();
				IWorkbench workbench = PlatformUI.getWorkbench();
				CreateNewMoCProject createNewMoCProjectWizard = (CreateNewMoCProject)wizard;
				// fine initialization
				LanguageDefinition languageDefinition = getLanguageDefinition();
				if(languageDefinition != null){ // Customize
					createNewMoCProjectWizard._askProjectNamePage.setInitialProjectName(gemocLanguageIProject.getName()+".mocc.lib");
					createNewMoCProjectWizard._askMoCInfoPage.initialTemplateMoCFileFieldValue = languageDefinition.getName();
					//if(languageDefinition.getDomainModelProject() != null){
					//	createNewMoCProjectWizard._askMoCInfoPage.initialRootContainerFieldValue = languageDefinition.getDomainModelProject().getDefaultRootEObjectQualifiedName();
					//}
				}
				wizard.init(workbench, null);
				WizardDialog wd = new WizardDialog(workbench.getActiveWorkbenchWindow().getShell(), wizard);
				wd.create();
				wd.setTitle(wizard.getWindowTitle());
				
				int res = wd.open();
				if(res == WizardDialog.OK){
					ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceListener);
					IProject createdProject = workspaceListener.getLastCreatedProject();
					// update the project configuration model					
					if(createdProject != null){
						
						
						addMoCFileToConf(createNewMoCProjectWizard.createdProjectName, 
									"/"+createNewMoCProjectWizard.createdProjectName+"/mocc/"+createNewMoCProjectWizard.createdTemplateMoCFile+".moccml"); 
					}
					// We should add a first description of the file content StateBasedRelationDef
					else{
						Activator.error("not able to detect which project was created by wizard", null);
					}
				}						
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			} finally {
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceListener);						
			}
		}
		else{
			Activator.error("wizard with id=org.eclipse.sirius.ui.specificationproject.wizard not found", null);
		}
	}

	protected void selectExistingMoCProject() {
		/*
		 * MessageDialog.openWarning(
		 * PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
		 * "Gemoc Language Workbench UI",
		 * "selectExistingMoCProject. Action not implemented yet");
		 */
		SelectMoCIFileDialog dialog = new SelectMoCIFileDialog();
		int res = dialog.open();
		if (res == WizardDialog.OK) {
			// update the project model
			addMoCFileToConf(((IResource) dialog.getResult()[0]).getProject()
					.getName(), ((IResource) dialog.getResult()[0])
					.getFullPath().toString());
		}
	}
	protected void addMoCFileToConf(String projectName, String mocFileURI) {
		
		if(this.gemocLanguageModel != null){
			addMoCFileToConf(projectName, mocFileURI, this.gemocLanguageModel);
		} else {
			addMoCFileToConf(projectName, mocFileURI, this.gemocLanguageIProject);
		}
	}
	protected void addMoCFileToConf(String projectName, String mocFileURI, IProject gemocLanguageIProject) {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION,
				new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		// get the resource
		IFile configFile = gemocLanguageIProject.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE));
		Resource resource = resSet
				.getResource(URI.createURI(configFile.getLocationURI()
						.toString()), true);
		LanguageDefinition gemocLanguageWorkbenchConfiguration = (LanguageDefinition) resource
				.getContents().get(0);
		
		addMoCFileToConf(projectName, mocFileURI, gemocLanguageWorkbenchConfiguration);
		
		try {
			resource.save(null);
		} catch (IOException e) {
			Activator.error(e.getMessage(), e);
		}
		if (configFile != null) {
			try {
				configFile.refreshLocal(IResource.DEPTH_ZERO,
						new NullProgressMonitor());
			} catch (CoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
	}
	
	protected void addMoCFileToConf(String projectName, String mocFileURI, LanguageDefinition languageDefinition) {
		MoCCProject mocProject = confFactoryImpl.eINSTANCE
				.createMoCCProject();
		mocProject.setProjectName(projectName);
		
		languageDefinition.setMoCProject(mocProject);
			
		
	}

	protected LanguageDefinition getLanguageDefinition(){
		if(this.gemocLanguageIProject != null){
			IFile configFile = gemocLanguageIProject.getFile(new Path(
					Activator.GEMOC_PROJECT_CONFIGURATION_FILE));
			if (configFile.exists()) {
				// Obtain a new resource set
				ResourceSet resSet = new ResourceSetImpl();
				// get the resource
				Resource resource = resSet
						.getResource(URI.createURI(configFile.getLocationURI()
								.toString()), true);
				
				
				return (LanguageDefinition) resource
						.getContents().get(0);
			}
		}
		if(this.gemocLanguageModel != null){
			return this.gemocLanguageModel;
		}
		return null;
	}
}
