package org.gemoc.gemoc_language_workbench.ui.wizards;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.gemoc.dse.ecl.moc2as.ui.builder.GemocDSENature;
import org.gemoc.gemoc_commons.core.resources.Project;
import org.gemoc.gemoc_language_workbench.conf.ECLFile;
import org.gemoc.gemoc_language_workbench.conf.ECLProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
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
		init();
	}

	private IFile configFile;
	private LanguageDefinition _languageDefinition;
	
	private void init() {
		configFile = gemocLanguageIProject.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)); 
		if(configFile.exists()){
		    // Obtain a new resource set
		    ResourceSet resSet = new ResourceSetImpl();
		    // get the resource
		    Resource resource = resSet.getResource(URI.createURI(configFile.getLocationURI().toString()),true);   	    
		    GemocLanguageWorkbenchConfiguration gemocLanguageWorkbenchConfiguration = (GemocLanguageWorkbenchConfiguration) resource.getContents().get(0);
		    // consider only one language :-/
		    _languageDefinition = gemocLanguageWorkbenchConfiguration.getLanguageDefinition();
		}
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

	protected void createNewDSEProject() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String suffixe = ".dse";
		
		String projectName = getDSEProjectName(suffixe);
		final IProject project = workspace.getRoot().getProject(projectName);
		
		final IProjectDescription description = workspace.newProjectDescription(projectName);
		if (!gemocLanguageIProject.getLocation().toOSString().equals(workspace.getRoot().getLocation().toOSString()))
			description.setLocation(new Path(gemocLanguageIProject.getLocation().toOSString() + suffixe));
		
		try {
			IWorkspaceRunnable operation = new IWorkspaceRunnable() {
				public void run(IProgressMonitor monitor) throws CoreException {
					project.create(description, monitor);
					project.open(monitor);
					Project.addNature(project, GemocDSENature.NATURE_ID);
					try {
						Project.convertToPlugin(project);
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					configureProject(project, monitor);
					project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
				}
			};
			ResourcesPlugin.getWorkspace().run(operation, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		MessageDialog.openWarning(
//				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
//				"Gemoc Language Workbench UI",
//				"createNewDSEProject. Action not implemented yet");
	}

	private String getDSEProjectName(String suffixe) {
		return gemocLanguageIProject.getName() + ".dse";
	}

	private void configureProject(IProject project, IProgressMonitor monitor) throws CoreException {
		Project.createFolder(project, "ecl", monitor);
		
		if (_languageDefinition != null
			&& _languageDefinition.getDomainModelProject() != null
			&& _languageDefinition.getDomainModelProject() instanceof EMFEcoreProject) {
			EMFEcoreProject ecoreProject = (EMFEcoreProject)_languageDefinition.getDomainModelProject();	
			String content = "rootElement = " + ecoreProject.getDefaultRootEObjectQualifiedName();
			Project.createFile(project, "moc2as.properties", content, monitor);
			String filePath = "ecl/" + _languageDefinition.getName() + ".ecl";
			IFile eclFile = Project.createFile(project, filePath, "", monitor);
			addECLFileToConf(project.getName(), eclFile.getFullPath().toString());
		}
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
		if (_languageDefinition != null) {
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

		    
		    ECLProject eclProject = confFactoryImpl.eINSTANCE.createECLProject();
		    eclProject.setProjectName(projectName);
		    ECLFile eclFile = confFactoryImpl.eINSTANCE.createECLFile();
		    eclFile.setLocationURI(eclFileURI);
		    eclProject.setEclFile(eclFile);
		    
		    _languageDefinition.setDSEProject(eclProject);
		    
		    try {
		    	_languageDefinition.eResource().save(null);
			} catch (IOException e) {
				Activator.error(e.getMessage(), e);
			}			
		    if (configFile != null) {
			    try {
					configFile.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
				} catch (CoreException e) {
					Activator.error(e.getMessage(), e);
				}		    	
		    }
		}
	}
	
	protected void addDSEProjectToConf(String projectName){
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"addDSEProjectToConf. Action not implemented yet");
	}
	


}
