package org.gemoc.gemoc_language_workbench.ui.commands;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.resourcevisitors.EcoreFileFinderResourceVisitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ShowDomainModelProjectHandler extends AbstractHandler implements
		IHandler {

	private IProject gemocLanguageIProject;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		this.gemocLanguageIProject = getUpdateGemocLanguageProjectFromSelection(event);
		
		//File fileToOpen = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/Essai1/test1.xmi");
		File fileToOpen = new File(getFirstEcoreFile(getEcoreProject()).getLocation().toOSString());		
		if (fileToOpen.exists() && fileToOpen.isFile()) {
		    IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
		    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		 
		    try {
		        IDE.openEditorOnFileStore( page, fileStore );
		    } catch ( PartInitException e ) {
		        //Put your exception handler here if you wish to
		    }
		} else {
		    //Do something if the file does not exist
		}
		
		return null;
	}
	
	private IProject getEcoreProject() {
		
		IProject projectEcore = null; 
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
		    
		    // create missing data
		    EMFEcoreProject emfEcoreProject = (EMFEcoreProject) langage.getDomainModelProject();
		    projectEcore = ResourcesPlugin.getWorkspace().getRoot().getProject(emfEcoreProject.getProjectName());
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
		return projectEcore;
	}
	
	private IFile getFirstEcoreFile(IProject projectWithEcore) {

		EcoreFileFinderResourceVisitor ecoreFinder = new EcoreFileFinderResourceVisitor();
		
		try {

			projectWithEcore.accept(ecoreFinder);
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}

		if(ecoreFinder.ecoreFiles.size() > 0){
			return ecoreFinder.ecoreFiles.get(0);
		} else {
			return null;
		}
	}
	
	private IProject getUpdateGemocLanguageProjectFromSelection(ExecutionEvent event) {
		IProject updatedGemocLanguageProject = null;
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			for (@SuppressWarnings("unchecked")
				Iterator<Object> iterator = strucSelection.iterator(); 
				iterator.hasNext();) {
				
				Object element = iterator.next();

				if (element instanceof IResource) {
					updatedGemocLanguageProject = ((IResource) element)
							.getProject();

				}
				if (element instanceof IAdaptable) {
					IResource res = (IResource) ((IAdaptable) element)
							.getAdapter(IResource.class);
					if (res != null) {
						updatedGemocLanguageProject = res.getProject();
					}
				}

				// if still null look after the activeEditor
				if (updatedGemocLanguageProject == null) {

					IResource res = (IResource) HandlerUtil
							.getActiveWorkbenchWindow(event).getActivePage()
							.getActiveEditor().getEditorInput()
							.getAdapter(IResource.class);
					if (res != null) {
						updatedGemocLanguageProject = res.getProject();
					}
				}
			}
		}
		return updatedGemocLanguageProject;
	}
}
