package org.gemoc.gemoc_process.wizard.wizards;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.gemoc.gemoc_process.wizard.Activator;
import org.gemoc.gemoc_process.wizard.preferences.PreferenceConstants;

public class KermetaProjectNewWizard extends Wizard implements INewWizard {

	private ContextWizardNewProject context = new ContextWizardNewProject ();
	
	KermetaProjectNewWizardPage 		projectPage 		= new KermetaProjectNewWizardPage(context);
	KermetaProjectNewWizardPageCustom 	projectPageCustom	= new KermetaProjectNewWizardPageCustom(context);
	
	public KermetaProjectNewWizard() {}

	@Override
	public void addPages() {
		addPage(projectPage);
		addPage(projectPageCustom);
	}
	
	public static void addKermetaNatureToProject(IProject project) {
		IProjectDescription description;
		try {
			description = project.getDescription();				
			if (!description.hasNature(org.kermeta.language.texteditor.eclipse.nature.Activator.NATURE_ID)){
				String[] natures = description.getNatureIds();			
				String[] newNatures = new String[natures.length + 1];
				System.arraycopy(natures, 0, newNatures, 0, natures.length);
				newNatures[natures.length] = org.kermeta.language.texteditor.eclipse.nature.Activator.NATURE_ID;
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
				
			}
		} catch (CoreException e) {
			Activator.logErrorMessage(e.getMessage(), e);
		}
	}
	
	
	@Override
	public boolean performFinish() {
		try {
			 final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(this.context.nameProject);
			 IWorkspaceRunnable operation = new IWorkspaceRunnable() {
				 public void run(IProgressMonitor monitor) throws CoreException {
					 project.create(monitor);
					 project.open(monitor);
					 addKermetaNatureToProject(project);
					 IFile ecoreFile = context.ecoreIFile;
					 if(ecoreFile != null){
						 createKmtProjectWithEcore();
					 }
					 else {
						 createFolder(project, "src/main/kmt", monitor);
						 createDefaultKmt(project, "src/main/kmt/MainClass.kmt", monitor);
						 createDefaultKp(project, "project.kp", monitor);
					 }
					 project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					 
				 }
			};
			ResourcesPlugin.getWorkspace().run(operation, null);
		} catch (CoreException exception) {
			Activator.logErrorMessage(exception.getMessage(), exception);
			return false;
		}
		return true;
	}

	public void createKmtProjectWithEcore () {
		org.gemoc.gemoc_process.executable_metamodel_creator.KM2KMTexecutable_metamodel_creator creator = Activator.getKM2KMTexecutable_metamodel_creator();
		if (creator != null) {
			switch (this.context.indexTransfomation) {
			case 0:
				creator.generateNoneScala (this.context.nameProject,
											 "file:///" + this.context.locationProject,
											 "/" + this.context.ecoreIFile.getProjectRelativePath().toString(),
											 this.context.ecoreIFile.getProject().getName());
				break;
			case 1:
				creator.generateAspectProjectScala (this.context.nameProject,
													  "file:///" + this.context.locationProject,
						 							  "/" + this.context.ecoreIFile.getProjectRelativePath().toString(),
						 							  this.context.ecoreIFile.getProject().getName());
				break; 
			case 2:
				/*generator.generateCustomizeProjectScala (this.context.nameProject,
														 "file:///" + this.context.locationProject,
						 								 "/" + this.context.ecoreIFile.getProjectRelativePath().toString(),
						 								 this.context.ecoreIFile.getProject().getName(),
						 								 this.context.operationName,
						 								 this.context.operationReturnType,
						 								 this.context.operationParams,
						 								 this.context.listNewClass);*/
				
				System.out.println("generateDynamicAttributeScala launched");
				creator.generateDynamicAttributeScala (this.context.nameProject,
						 "file:///" + this.context.locationProject,
							 "/" + this.context.ecoreIFile.getProjectRelativePath().toString(),
							 this.context.ecoreIFile.getProject().getName(),
							 this.context.operationName,
							 this.context.operationReturnType,
							 this.context.operationParams,
							 this.context.listNewClass);
				System.out.println("generateDynamicAttributeScala ended");
				break;
			case 3:
				creator.generateVisitorProjectScala (this.context.nameProject,
													   "file:///" + this.context.locationProject,
						 							   "/" + this.context.ecoreIFile.getProjectRelativePath().toString(),
						 							   this.context.ecoreIFile.getProject().getName());
				break;
			}
		}
		else {
			Activator.logErrorMessage("Cannot call AspectGenerator because the service is unavailable", null);
		}
	}
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
	
	/**
	 * Creates folder hierarchically from a path relative to a project.
	 * @param project
	 * @param path
	 * @param monitor
	 * @throws CoreException
	 */
	private void createFolder(IProject project, String path, IProgressMonitor monitor) throws CoreException {
		String[] strings = path.split("/");
		IContainer currentContainer = project;
		for ( String s : strings ) {
			IFolder folder = currentContainer.getFolder( new Path(s) );
			folder.create(true, true, monitor);
			currentContainer = folder;
		}
	}
	
	public static IFile createDefaultKp(IProject project,String path,IProgressMonitor monitor) throws CoreException{
		IContainer currentContainer = project;
		IFile file = currentContainer.getFile(new Path(path));
		
		String contents = Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.P_NEW_KP_TEMPLATE_STRING);
		
		// replace variables with values from the user
		contents = contents.replaceAll(Pattern.quote("${project.name}"), project.getName().replaceAll(Pattern.quote("."), "_"));
		contents = contents.replaceAll(Pattern.quote("${class.name}"), "MainClass");
		contents = contents.replaceAll(Pattern.quote("${package.name}"), "mainPackage");
		contents = contents.replaceAll(Pattern.quote("${operation.name}"), "mainOperation");
		try {
			InputStream stream =  new ByteArrayInputStream(contents.getBytes());;
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		return file;
	}
	
	private void createDefaultKmt(IProject project,String path,IProgressMonitor monitor) throws CoreException{
		IContainer currentContainer = project;
		IFile file = currentContainer.getFile(new Path(path));
		
		String contents = Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.P_NEW_KMT_TEMPLATE_STRING);
		
		// replace variables with values from the user
		contents = contents.replaceAll(Pattern.quote("${class.name}"), "MainClass");
		contents = contents.replaceAll(Pattern.quote("${package.name}"), "mainPackage");
		contents = contents.replaceAll(Pattern.quote("${operation.name}"), "mainOperation");
		
		try {
			InputStream stream =  new ByteArrayInputStream(contents.getBytes());;
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) { }
	}
	
}
