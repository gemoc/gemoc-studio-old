package org.gemoc.gemoc_language_workbench.ui.commands;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.ProjectKind;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;
import org.gemoc.gemoc_language_workbench.utils.emf.ENamedElementQualifiedNameLabelProvider;
import org.gemoc.gemoc_language_workbench.utils.ui.dialogs.SelectAnyConcreteEClassDialog;
import org.gemoc.gemoc_language_workbench.utils.ui.dialogs.SelectAnyEObjectDialog;

public class SetRootEObjectHandler extends AbstractGemocLanguageProjectHandler implements
		IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the optional selection and eventually project data to preset the wizard
		IProject updatedGemocLanguageProject = getUpdateGemocLanguageProjectFromSelection(event);

		// launch the wizard that does the job
		
		ActiveFile activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject);
		IFile ecoreFile = activeFileEcore.getActiveFile();
		if (ecoreFile != null) {
			LabelProvider labelProvider = new ENamedElementQualifiedNameLabelProvider(); 
			ResourceSet resSet = new ResourceSetImpl();

		    // get the resource
		    Resource resource = resSet.getResource(URI.createURI(ecoreFile.getLocationURI().toString()),true);
			    
			SelectAnyEObjectDialog dialog = new SelectAnyConcreteEClassDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(),
					resource,
					labelProvider);
			int res = dialog.open();
			if(res == WizardDialog.OK){
				// update the project model
				setRootEObjectInConf(updatedGemocLanguageProject, labelProvider.getText(dialog.getFirstResult()));
			}
		}
		return null;
	}
	
	protected void setRootEObjectInConf(IProject gemocLanguageIProject, String rootEObjectName){
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
		    LanguageDefinition language = gemocLanguageWorkbenchConfiguration.getLanguageDefinitions().get(0);
		    
		    if(language.getDomainModelProject() instanceof EMFEcoreProject){
		    	((EMFEcoreProject)language.getDomainModelProject()).setDefaultRootEObjectQualifiedName(rootEObjectName);
		    }
		    
			
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

}
