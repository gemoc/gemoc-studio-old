package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.gemoc.commons.eclipse.ui.WizardFinder;
import org.gemoc.gemoc_language_workbench.conf.DSEProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.MoCCProject;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;

public class CreateMOCCWizardContextAction {

	public static final String MOCCWIZARD_ID = "org.gemoc.gemoc_language_workbench.ui.wizards.CreateNewMoCProject";
	
	public enum CreateMOCCAction {CREATE_NEW_MOCC_PROJECT, SELECT_EXISTING_MOCC_PROJECT};
	
	public CreateMOCCAction actionToExecute = CreateMOCCAction.CREATE_NEW_MOCC_PROJECT;
	
	// one of these must be set, depending on it it will work on the file or directly in the model 
	protected IProject gemocLanguageIProject = null;
	protected LanguageDefinition gemocLanguageModel = null; 
	
	public CreateMOCCWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}
	public CreateMOCCWizardContextAction(IProject updatedGemocLanguageProject, LanguageDefinition rootModelElement) {
		gemocLanguageIProject = updatedGemocLanguageProject;
		gemocLanguageModel = rootModelElement;
	}

	public void execute() {
		switch (actionToExecute) {
		case CREATE_NEW_MOCC_PROJECT:
			createNewMOCCProject();
			break;
		case SELECT_EXISTING_MOCC_PROJECT:
			selectExistingMOCCProject();
			break;

		default:
			break;
		}
	}

	protected void createNewMOCCProject(){
		final IWizardDescriptor descriptor = WizardFinder.findNewWizardDescriptor(MOCCWIZARD_ID);
		// Then if we have a wizard, open it.
		if (descriptor != null) {				
			NewProjectWorkspaceListener workspaceListener = new NewProjectWorkspaceListener();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
			try {
				IWorkbenchWizard wizard;
				wizard = descriptor.createWizard();
				IWorkbench workbench = PlatformUI.getWorkbench();
				CreateNewMoCProject createNewMoCCProjectWizard = (CreateNewMoCProject)wizard;
				// fine initialization
				LanguageDefinition languageDefinition = getLanguageDefinition();
				if(languageDefinition != null){
					createNewMoCCProjectWizard._askProjectNamePage.setInitialProjectName(gemocLanguageIProject.getName()+".mocc");
					createNewMoCCProjectWizard._askMoCInfoPage.initialTemplateMoCFileFieldValue = languageDefinition.getName().replaceAll(" ", "_");
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
						
						
						addMoccProjectToConf(createNewMoCCProjectWizard.createdProjectName, getLanguageDefinition());
					}
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
			Activator.error("wizard with id="+MOCCWIZARD_ID+" not found", null);
		}
	}
	
	protected void selectExistingMOCCProject(){
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"selectExistingMOCCProject. Action not implemented yet");
	}
	
	protected void addMOCCProjectToConf(String projectName){
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"addMOCCProjectToConf. Action not implemented yet");
	}
	
	protected void addMoccProjectToConf(String projectName, LanguageDefinition languageDefinition) {
		MoCCProject project;
		if(languageDefinition.getMoCCProject() == null){
			project = confFactoryImpl.eINSTANCE
				.createMoCCProject();
			languageDefinition.setMoCCProject(project);
		} else {
			project = languageDefinition.getMoCCProject();
		}
		project.setProjectName(projectName);
		
			
		
	}
	
	protected LanguageDefinition getLanguageDefinition(){

		if(this.gemocLanguageModel != null){
			return this.gemocLanguageModel;
		}
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
		return null;
	}


}
