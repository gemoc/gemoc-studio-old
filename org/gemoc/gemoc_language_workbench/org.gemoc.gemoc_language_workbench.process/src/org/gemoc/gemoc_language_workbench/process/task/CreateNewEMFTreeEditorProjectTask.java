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
import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.workspace.listener.change.IChange;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.design.wizard.EcoreModelerWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;
import org.gemoc.commons.eclipse.ui.WizardFinder;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EMFGenmodel;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.conf.TreeEditorProject;
import org.gemoc.gemoc_language_workbench.conf.impl.confFactoryImpl;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;
import org.gemoc.gemoc_language_workbench.process.AbstractResourceProcessor;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;
import org.gemoc.gemoc_language_workbench.ui.listeners.NewProjectWorkspaceListener;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizard;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateEditorProjectWizardContextAction.CreateEditorProjectAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateNewGemocLanguageProject;
import org.gemoc.gemoc_language_workbench.utils.resourcevisitors.FileFinderVisitor;

/**
 * Create a new EMF project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewEMFTreeEditorProjectTask extends AbstractResourceProcessor {

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewEMFTreeEditorProjectTask(ActionTask task) {
		super(task);
	}

	protected String undoneReason="";
	
	public boolean validate(ProcessContext context) {
		
		// it exists an EMF Tree editor project that is referenced by the xdsml
		// else setUndone 
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		
		EditorProject treeEditorProjet = findTreeEditorInXDSML(gContext.getXdsmlConfigModel());
		if(treeEditorProjet != null){
			IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			IProject iProject = myWorkspaceRoot.getProject(treeEditorProjet.getProjectName());
			if(iProject.exists()){
				return true;
			}
			else{
				undoneReason = "project "+treeEditorProjet.getProjectName()+" doesn't exist, check your xdsml file";
			}
			return true;
		}
		else{
			undoneReason = "no Tree editor project referenced in your xdsml file";
		}
		
		return false;
	}


	public Object updateContextWhenDone(ProcessContext context) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		EditorProject treeEditorProjet = findTreeEditorInXDSML(gContext.getXdsmlConfigModel());
		
		return treeEditorProjet;
	}
	 
	private EditorProject findTreeEditorInXDSML( GemocLanguageWorkbenchConfiguration  xdsmlModel){
		
		EList<EditorProject> editorsProjects = xdsmlModel.getLanguageDefinition().getEditorProjects();
		
		for(EditorProject editorProject : editorsProjects){
			if(editorProject instanceof TreeEditorProject) return editorProject;
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		IProject updatedGemocLanguageProject = gContext.getXdsmlIFile().getProject();
		CreateEditorProjectWizardContextAction createEditorProjectWizardContext = new CreateEditorProjectWizardContextAction(updatedGemocLanguageProject);
		createEditorProjectWizardContext.actionToExecute = CreateEditorProjectAction.CREATE_NEW_EMFTREE_PROJECT;
		createEditorProjectWizardContext.execute();	
	}
	
		
		
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		// nothing to do here
	}

	public String updateContextWhenUndone(ProcessContext context) {
		return undoneReason;
	}


	@Override
	public boolean acceptChangeForRemovedResource(ProcessContext context, IResource resource) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		// if the changed resource is an IProject referenced by the xdsml as TreeEditor
		if(resource instanceof IProject){
			EList<EditorProject> editorsProjects = gContext.getXdsmlConfigModel().getLanguageDefinition().getEditorProjects();
			
			for(EditorProject editorProject : editorsProjects){
				if(editorProject instanceof TreeEditorProject){
					if(resource.getName().equals(editorProject.getProjectName())){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean acceptChangeForAddedResource(ProcessContext context, IResource resource) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		// if xdsml of the process has changed
		final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		if(uri.equals(gContext.getXdsmlConfigURI())){
			return true;
		}
		
		// or if the changed resource is an IProject referenced by the xdsml as TreeEditor
		if(resource instanceof IProject){
			EList<EditorProject> editorsProjects = gContext.getXdsmlConfigModel().getLanguageDefinition().getEditorProjects();
			
			for(EditorProject editorProject : editorsProjects){
				if(editorProject instanceof TreeEditorProject){
					if(resource.getName().equals(editorProject.getProjectName())){
						return true;
					}
				}
			}
		}
		return false;
	}



	@Override
	public boolean acceptChangeForModifiedResource(ProcessContext context, IResource resource) {
		// if xdsml of the process has changed
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		if(uri.equals(gContext.getXdsmlConfigURI())){
			return true;
		}
		return false;
	}






	
}
