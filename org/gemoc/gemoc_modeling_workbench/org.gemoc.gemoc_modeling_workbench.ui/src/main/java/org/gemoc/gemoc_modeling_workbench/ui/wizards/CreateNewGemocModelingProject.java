package org.gemoc.gemoc_modeling_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

public class CreateNewGemocModelingProject extends Wizard implements INewWizard {


	WizardNewProjectCreationPage mainPage;
	
	public CreateNewGemocModelingProject() {
		super();
		this.setWindowTitle("Create Domain Model");
		this.mainPage = new WizardNewProjectCreationPage("NewGemocModelingProject");
		this.mainPage.setTitle("Project");
		this.mainPage.setDescription("Create a new Gemoc Modeling Project");
		addPage(this.mainPage);
	}

	@Override
	public void addPages() {
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		
		try {
			final IProject createdProject = this.mainPage.getProjectHandle();
			IWorkspaceRunnable operation = new IWorkspaceRunnable() {
				 public void run(IProgressMonitor monitor) throws CoreException {
					 createdProject.create(monitor);
					 createdProject.open(monitor);
					 createdProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
				 }
			};
			ResourcesPlugin.getWorkspace().run(operation, null);
		} catch (CoreException exception) {
			Activator.error(exception.getMessage(), exception);
			return false;
		}
		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

}
