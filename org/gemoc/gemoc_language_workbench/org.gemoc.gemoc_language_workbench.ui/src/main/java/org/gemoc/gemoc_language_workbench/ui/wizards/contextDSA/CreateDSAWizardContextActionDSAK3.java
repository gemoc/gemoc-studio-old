package org.gemoc.gemoc_language_workbench.ui.wizards.contextDSA;

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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.K3DSAProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;
import fr.inria.diverse.k3.ui.wizards.WizardNewProjectK3Plugin;

public class CreateDSAWizardContextActionDSAK3 extends CreateDSAWizardContextActionDSA {

	public CreateDSAWizardContextActionDSAK3(IProject gemocLanguageIProject) {
		super(gemocLanguageIProject);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createNewDSAProject() {
		// launch DSA Kermeta New wizard		
		IWizardDescriptor descriptor = PlatformUI
				.getWorkbench()
				.getNewWizardRegistry()
				.findWizard(
						"fr.inria.diverse.k3.ui.wizards.WizardNewProjectK3Plugin");
		
		// Then if we have a wizard, open it.
			if(descriptor == null) Activator.error("failled to find wizard descriptor with id = fr.inria.diverse.k3.ui.wizards.WizardNewProjectK3Plugin", null);
			if (descriptor != null) {
			// add a listener to capture the creation of the resulting project
			NewProjectWorkspaceListener workspaceListener = new NewProjectWorkspaceListener();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(workspaceListener);
			try {
				IWizard wizard;
				wizard = descriptor.createWizard();
				// this wizard need some dedicated initialization
				((WizardNewProjectK3Plugin)wizard).init(PlatformUI.getWorkbench(), (IStructuredSelection) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection());
				
				
				WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
				
				wd.create();
				// set field as much as possible
				ActiveFile activeFileEcore = new ActiveFileEcore(this.gemocLanguageIProject);
				IFile ecoreFile = activeFileEcore.getActiveFile();
				if (ecoreFile != null) {
					((WizardNewProjectK3Plugin)wizard).getPageProject().setEcoreLoaded(ecoreFile);
				}
				((WizardNewProjectK3Plugin)wizard).getPageProject().setProjectName(gemocLanguageIProject.getName()+".k3dsa");
				((WizardNewProjectK3Plugin)wizard).getPageProject().setProjectKind(fr.inria.diverse.k3.ui.tools.Context.KindsOfProject.PLUGIN);
				wd.setTitle("New Kermeta 3 project");
				
				
				int res = wd.open();
				if(res == WizardDialog.OK){
					//((KermetaProjectNewWizard )wizard).performFinish();
					ResourcesPlugin.getWorkspace().removeResourceChangeListener(workspaceListener);
					IProject createdProject = workspaceListener.getLastCreatedProject();
					// update the project configuration model
					if(createdProject != null){
						addDSAProjectToConf(createdProject.getName());
					}
					else{
						addDSAProjectToConf("");
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

	protected void addDSAProjectToConf(String projectName){
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
		    LanguageDefinition langage = gemocLanguageWorkbenchConfiguration.getLanguageDefinitions().get(0);
		    
			K3DSAProject DSAProject = confFactoryImpl.eINSTANCE.createK3DSAProject();
			DSAProject.setProjectName(projectName);
			langage.setDsaProject(DSAProject);
				
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
	
	protected void getEcoreFile(WizardNewProjectK3Plugin wizard) {
		ActiveFile activeFileEcore = new ActiveFileEcore(this.gemocLanguageIProject);
		IFile ecoreFile = activeFileEcore.getActiveFile();
		if (ecoreFile != null) {
			wizard.getPageProject().setEcoreLoaded(ecoreFile);
		}
	}
}
