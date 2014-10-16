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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.gemoc.commons.eclipse.ui.WizardFinder;
import org.gemoc.commons.eclipse.ui.dialogs.SelectAnyIProjectDialog;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.SiriusEditorProject;
import org.gemoc.gemoc_language_workbench.conf.TreeEditorProject;
import org.gemoc.gemoc_language_workbench.conf.XTextEditorProject;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectODesignIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectXtextIProjectDialog;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;

//import org.eclipse.emf.ecoretools.design.wizard.EcoreModelerWizard;


/**
 * This class is both a context for the wizard and a Command that will be executed
 * @author dvojtise
 *
 */
public class CreateEditorProjectWizardContextAction {

	public enum CreateEditorProjectAction {CREATE_NEW_EMFTREE_PROJECT, CREATE_NEW_XTEXT_PROJECT, CREATE_NEW_SIRIUS_PROJECT, SELECT_EXISTING_EMFTREE_PROJECT, SELECT_EXISTING_XTEXT_PROJECT, SELECT_EXISTING_OD_PROJECT};
	
	public CreateEditorProjectAction actionToExecute = CreateEditorProjectAction.CREATE_NEW_EMFTREE_PROJECT;
	
	// one of these must be set, depending on it it will work on the file or directly in the model 
	protected IProject gemocLanguageIProject = null;	
	protected LanguageDefinition gemocLanguageModel = null; 
	
	public CreateEditorProjectWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}
	public CreateEditorProjectWizardContextAction(LanguageDefinition rootModelElement) {
		gemocLanguageModel = rootModelElement;
	}
	
	public void execute() {
		switch (actionToExecute) {
		case CREATE_NEW_EMFTREE_PROJECT:
			createNewEMFTreeProject();
			break;
		case CREATE_NEW_XTEXT_PROJECT:
			createNewXTextProject();
			break;

		case CREATE_NEW_SIRIUS_PROJECT:
			createNewODProject();
			break;
		case SELECT_EXISTING_EMFTREE_PROJECT:
			selectExistingEMFTreeProject();
			break;
		case SELECT_EXISTING_XTEXT_PROJECT:
			selectExistingXTextProject();
			break;
		case SELECT_EXISTING_OD_PROJECT:
			selectExistingSiriusProject();
			break;
		default:
			break;
		}
		
	}


	protected void createNewEMFTreeProject(){
		// launch the appropriate wizard
		
		// "org.eclipse.emf.importer.ui.EMFProjectWizard" = create EMFProject from existing Ecore file
		/*
		IWizardDescriptor descriptor = PlatformUI
				.getWorkbench()
				.getNewWizardRegistry()
				.findWizard(
						"fr.obeo.mda.pim.ecore.design.wizard");
		
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
						addEMFProjectToConf(createdProject.getName());
					}
					else{
						addEMFProjectToConf("");
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
		*/
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"Action not implemented yet");
	}

	protected void createNewXTextProject() {
		/*MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"Action not completly implemented yet");*/
		// create xtext project from existing ecore model
		// wizard id = org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.NewXtextProjectFromEcoreWizard
		// launch the appropriate wizard
					
		IWizardDescriptor descriptor = WizardFinder.findNewWizardDescriptor("org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.NewXtextProjectFromEcoreWizard");
		// Then if we have a wizard, open it.
		if (descriptor != null) {
			// add a listener to capture the creation of the resulting project
			NewProjectWorkspaceListener workspaceListener = new NewProjectWorkspaceListener();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
			try {
				IWizard wizard;
				wizard = descriptor.createWizard();
				// this wizard need some dedicated initialization
				//((EcoreModelerWizard )wizard).init(PlatformUI.getWorkbench(), (IStructuredSelection) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection());
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
						XTextEditorProject editorProject = confFactoryImpl.eINSTANCE.createXTextEditorProject();
						editorProject.setProjectName(createdProject.getName());
						addOrUpdateProjectToConf(editorProject);
					}
					else{
						Activator.error("not able to detect which project was created by wizard", null);
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
		else{
			Activator.error("wizard with id=org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.NewXtextProjectFromEcoreWizard not found", null);
		}
	}
	protected void createNewODProject() {
		final IWizardDescriptor descriptor = WizardFinder.findNewWizardDescriptor("org.eclipse.sirius.ui.specificationproject.wizard");
		// Then if we have a wizard, open it.
		if (descriptor != null) {				
			NewProjectWorkspaceListener workspaceListener = new NewProjectWorkspaceListener();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
			try {
				IWorkbenchWizard wizard;
				wizard = descriptor.createWizard();
				IWorkbench workbench = PlatformUI.getWorkbench();
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
						SiriusEditorProject editorProject = confFactoryImpl.eINSTANCE.createSiriusEditorProject();
						editorProject.setProjectName(createdProject.getName());
						addOrUpdateProjectToConf(editorProject);
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
			Activator.error("wizard with id=org.eclipse.sirius.ui.specificationproject.wizard not found", null);
		}
	}
	
	protected void selectExistingEMFTreeProject(){
		// launch the appropriate wizard
		// TODO filter only projects related to the current domain model
		SelectAnyIProjectDialog dialog = new SelectAnyIProjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		int res = dialog.open();
		if(res == WizardDialog.OK){
			// update the project model
			String projectName = ((IResource)dialog.getResult()[0]).getName();			
			TreeEditorProject editorProject = confFactoryImpl.eINSTANCE.createTreeEditorProject();
			editorProject.setProjectName(projectName);
			// TODO detection of the current extension
			addOrUpdateProjectToConf(editorProject);
		}
	}
	
	protected void selectExistingXTextProject(){
		// launch the appropriate wizard
		// TODO filter only projects related to the current domain model
		SelectXtextIProjectDialog dialog = new SelectXtextIProjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		int res = dialog.open();
		if(res == WizardDialog.OK){
			// update the project model
			String projectName = ((IResource)dialog.getResult()[0]).getName();
			EditorProject editorProject = confFactoryImpl.eINSTANCE.createXTextEditorProject();
			editorProject.setProjectName(projectName);
			// TODO detection of the current extension
			addOrUpdateProjectToConf(editorProject);
		}
	}
	protected void selectExistingSiriusProject(){
		// launch the appropriate wizard
		// TODO filter only projects related to the current domain model
		SelectAnyIProjectDialog dialog = new SelectODesignIProjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		int res = dialog.open();
		if(res == WizardDialog.OK){
			// update the project model
			String projectName = ((IResource)dialog.getResult()[0]).getName();
			EditorProject editorProject = confFactoryImpl.eINSTANCE.createSiriusEditorProject();
			editorProject.setProjectName(projectName);
			// TODO detection of the current extension
			addOrUpdateProjectToConf(editorProject);
			
		}
	}
	
	
	/**
	 * if an editor of the same concrete kind exist, then the new one will replace it
	 * Ie. only  one Sirius editor, one XtextEditor, etc
	 * @param editorProject
	 */
	protected void addOrUpdateProjectToConf(EditorProject editorProject){
		if(gemocLanguageIProject != null){
			addOrUpdateProjectToConf(editorProject, gemocLanguageIProject);
		}
		if(gemocLanguageModel != null){
			addOrUpdateProjectToConf(editorProject, gemocLanguageModel);
		}
	}
	protected void addOrUpdateProjectToConf(EditorProject editorProject,IProject gemocProject){
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
		    addOrUpdateProjectToConf(editorProject, gemocLanguageWorkbenchConfiguration);
			
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
	 * if an editor of the same concrete kind exist, then the new one will replace it
	 * Ie. only  one Sirius editor, one XtextEditor, etc
	 * @param editorProject
	 */
	protected void addOrUpdateProjectToConf( EditorProject editorProject, LanguageDefinition language){
		
		    
		    // add missing data to conf
		    EditorProject existingEditor= null;
		    String searchedClass = editorProject.getClass().getName();
		    // search first existing editor
		    for(EditorProject possibleExistingEditor: language.getEditorProjects()){
		    	if(possibleExistingEditor.getClass().getName().equals(searchedClass)){
		    		existingEditor = possibleExistingEditor;
		    		break;		
		    	}
		    }
		    if(existingEditor == null){
		    	// simply add the new editor		    
		    	language.getEditorProjects().add(editorProject);
		    }
		    else {
		    	// replace the existing editor
		    	int index = language.getEditorProjects().indexOf(existingEditor);
		    	language.getEditorProjects().set(index, editorProject);
		    }
	}
	
}
