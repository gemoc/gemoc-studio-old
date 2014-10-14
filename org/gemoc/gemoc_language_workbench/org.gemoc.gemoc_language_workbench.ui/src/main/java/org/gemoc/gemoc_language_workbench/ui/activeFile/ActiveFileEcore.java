package org.gemoc.gemoc_language_workbench.ui.activeFile;

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
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

public class ActiveFileEcore extends ActiveFile {

	public ActiveFileEcore(IProject gemocLanguageProject) {
		super(gemocLanguageProject);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public IFile getActiveFile() {
		IProject projectWithEcore = this.getProject(this.gemocLanguageProject);
		FileFinderVisitor ecoreFinder = new FileFinderVisitor("ecore");
		
		try {

			projectWithEcore.accept(ecoreFinder);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}

		if(ecoreFinder.getFiles().size() > 0){
			return ecoreFinder.getFiles().get(0);
		} else {
			return null;
		}
	}
	
	@Override
	protected IProject getProject(IProject gemocLanguageIProject) {
		IProject projectEcore = null; 
		IFile configFile = gemocLanguageIProject.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE)); 
		if(configFile.exists())
		{
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

		    // Obtain a new resource set
		    ResourceSet resSet = new ResourceSetImpl();

		    // get the resource
		    Resource resource = resSet.getResource(URI.createURI(configFile.getLocationURI().toString()),true);
		    
		    
		    // consider only one language :-/
		    LanguageDefinition langage = (LanguageDefinition) resource.getContents().get(0);
		    
		    // get the IProject
		    DomainModelProject emfEcoreProject = langage.getDomainModelProject();
		    projectEcore = ResourcesPlugin.getWorkspace().getRoot().getProject(emfEcoreProject.getProjectName());
			/*try {
				resource.save(null);
			} catch (IOException e) {
				Activator.error(e.getMessage(), e);
			}*/
		}
		try {
			configFile.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
		return projectEcore;
	}

}
