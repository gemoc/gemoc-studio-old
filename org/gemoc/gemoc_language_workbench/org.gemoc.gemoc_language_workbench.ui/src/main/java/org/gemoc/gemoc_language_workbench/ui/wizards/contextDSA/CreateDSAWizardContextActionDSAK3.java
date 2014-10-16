package org.gemoc.gemoc_language_workbench.ui.wizards.contextDSA;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.gemoc.commons.eclipse.ui.WizardFinder;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;

import fr.inria.diverse.k3.ui.wizards.WizardNewProjectK3Plugin;

public class CreateDSAWizardContextActionDSAK3 extends CreateDSAWizardContextBase {

	public CreateDSAWizardContextActionDSAK3(IProject gemocLanguageIProject) {
		super(gemocLanguageIProject);
	}
	
	public CreateDSAWizardContextActionDSAK3(IProject gemocLanguageIProject, LanguageDefinition rootModelElement) {
		super(gemocLanguageIProject, rootModelElement);
	}

//	@Override
	public void createNewDSAProject() {
		// launch DSA Kermeta New wizard		
		IWizardDescriptor descriptor = WizardFinder.findNewWizardDescriptor("fr.inria.diverse.k3.ui.wizards.WizardNewProjectK3Plugin");
		
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
				ActiveFile activeFileEcore = new ActiveFileEcore(_gemocLanguageIProject);
				IFile ecoreFile = activeFileEcore.getActiveFile();
				if (ecoreFile != null) {
					((WizardNewProjectK3Plugin)wizard).getPageProject().setEcoreLoaded(ecoreFile);
				}
				((WizardNewProjectK3Plugin)wizard).getPageProject().setProjectName(_gemocLanguageIProject.getName()+".k3dsa");
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

}
