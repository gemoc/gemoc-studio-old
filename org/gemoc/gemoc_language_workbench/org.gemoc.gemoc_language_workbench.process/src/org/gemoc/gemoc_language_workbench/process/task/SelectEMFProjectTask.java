/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package org.gemoc.gemoc_language_workbench.process.task;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.workspace.listener.change.IChange;

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
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectEMFIProjectDialog;

/**
 * Select an existing EMF project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SelectEMFProjectTask extends AbstractProcessor {


	protected String undoneReason="";

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 * @param task1
	 *            the reference to the {@link ActionTask} corresponding to {@link CreateNewGemocLanguageProjectTask}
	 */
	public SelectEMFProjectTask(ActionTask task) {
		super(task);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		// create a wizard to select a .genmodel file
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		SelectEMFIProjectDialog dialog = new SelectEMFIProjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		int res = dialog.open();
		if(res == WizardDialog.OK){
			// update the project model
			addEMFProjectToConf(gContext, ((IResource)dialog.getResult()[0]).getName());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		final GemocLanguageWorkbenchConfiguration config = gContext.getXdsmlConfigModel();
		if (config != null && config.getLanguageDefinition() != null
				&& config.getLanguageDefinition().getDomainModelProject() != null) {
			config.getLanguageDefinition().setDomainModelProject(null);
			try {
				config.eResource().save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Object updateContextWhenDone(ProcessContext context, IChange<?> change) {
		// all test for cast are done in checkIsDone 
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		final GemocLanguageWorkbenchConfiguration config = gContext.getXdsmlConfigModel();
		final DomainModelProject project = config.getLanguageDefinition().getDomainModelProject();
		EMFEcoreProject emfproject = (EMFEcoreProject)project;		
		return emfproject;
	}

	public String updateContextWhenUndone(ProcessContext context, IChange<?> change) {
		return undoneReason;
	}

	public boolean checkIsDone(ProcessContext context, IChange<?> change) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		final GemocLanguageWorkbenchConfiguration config = gContext.getXdsmlConfigModel();
		if (config != null && config.getLanguageDefinition() != null) {
			final DomainModelProject project = config.getLanguageDefinition().getDomainModelProject();
			if (project instanceof EMFEcoreProject) {
				//checkEMFEcoreProject(context, (EMFEcoreProject)project);
				EMFEcoreProject emfproject = (EMFEcoreProject)project;
				final String projectName = project.getProjectName();
				if (projectName != null && projectName.length() > 0) {
					IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
					if (p != null && p.exists()) {
						if (emfproject.getEmfGenmodel() != null && emfproject.getEmfGenmodel().getLocationURI() != null
								&& emfproject.getEmfGenmodel().getLocationURI().length() != 0) {
							IResource genModelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(
									new Path(emfproject.getEmfGenmodel().getLocationURI()));
							if (genModelFile.exists()) {
								return true;
							} else {
								undoneReason = "Genmodel is missing.";
								return false;
							}
						}
					} else {
						undoneReason = "Project is missing.";
						return false;
					}
				}
				
			} else {
				undoneReason = "No Domain project referenced in xdsml.";
				return false;
			}
		} else {
			undoneReason = "No Language dedined in xdsml.";
			return false;
		}
		return false;
	}
	
	protected void addEMFProjectToConf(GemocLanguageProcessContext gContext, String projectName){
		IFile configFile = gContext.getXdsmlIFile(); 
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
		    LanguageDefinition langage = gemocLanguageWorkbenchConfiguration.getLanguageDefinition();
		    
		    // create missing data
		    EMFEcoreProject emfEcoreProject = confFactoryImpl.eINSTANCE.createEMFEcoreProject();
		    emfEcoreProject.setProjectName(projectName);
		    langage.setDomainModelProject(emfEcoreProject);
		    			
			
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
