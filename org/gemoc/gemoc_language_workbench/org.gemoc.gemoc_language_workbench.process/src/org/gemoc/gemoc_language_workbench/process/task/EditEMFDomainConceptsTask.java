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
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EMFGenmodel;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;
import org.gemoc.gemoc_language_workbench.process.AbstractResourceProcessor;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;
import org.gemoc.gemoc_language_workbench.ui.commands.ENamedElementQualifiedNameLabelProvider;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyConcreteEClassDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyEObjectDialog;

/**
 * Set domain model root.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class EditEMFDomainConceptsTask extends AbstractResourceProcessor {


	protected String undoneReason="";
	protected String lastEClassName="";

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 * @param task1
	 *            the reference to the {@link ActionTask} corresponding to {@link CreateNewGemocLanguageProjectTask}
	 * @param task2b
	 *            the reference to the {@link ActionTask} corresponding to {@link SelectEMFProjectTask}
	 */
	public EditEMFDomainConceptsTask(ActionTask task) {
		super(task);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#updateContexts(fr.obeo.dsl.process.IProcessRunner,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public Object updateContextWhenDone(ProcessContext context) {
		return lastEClassName;
	}
	public String updateContextWhenUndone(ProcessContext context) {
		return undoneReason;
	}
	/**
	 * Updates the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	public boolean validate(ProcessContext context) {
		
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		
		DomainModelProject dmp = gContext.getXdsmlConfigModel().getLanguageDefinition().getDomainModelProject();
		if(dmp != null && dmp instanceof EMFEcoreProject){
			EMFEcoreProject eep = (EMFEcoreProject)dmp;
			if(eep.getEmfGenmodel() == null){
				undoneReason = "genmodel not referenced in xdsml";
				return false;
			}
			String genModelPath = eep.getEmfGenmodel().getLocationURI();
			if (genModelPath == null || genModelPath.length() == 0) {
				undoneReason = "referenced genmodel not valid";
			}
			final ResourceSet resourceSet = new ResourceSetImpl();
			final Resource r = resourceSet.getResource(URI.createPlatformResourceURI("/" + genModelPath, true),
					true);
			if (r.getContents().size() > 0 && r.getContents().get(0) instanceof GenModel
					&& hasClassifier((GenModel)r.getContents().get(0))) {
				return true;
			} else {
				undoneReason = "No classifier defined in Domain model.";
			}
			return false;
		}
		undoneReason = "no EMF project referenced in xdsml";
		return false;
	}

	

	/**
	 * Tells if the given {@link GenModel} contains at least one {@link org.eclipse.emf.ecore.EClassifier EClassifier}.
	 * 
	 * @param genModel
	 *            the {@link GenModel}
	 * @return <code>true</code> if the given {@link GenModel} contains at least one {@link org.eclipse.emf.ecore.EClassifier EClassifier}, <code>false</code> otherwise
	 */
	private boolean hasClassifier(GenModel genModel) {
		boolean res = false;

		for (GenPackage genPkg : genModel.getAllGenPackagesWithClassifiers()) {
			final EPackage ePkg = genPkg.getEcorePackage();
			if (ePkg != null) {
				if (!ePkg.getEClassifiers().isEmpty()) {
					res = true;
					break;
				}
			}
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		IProject updatedGemocLanguageProject = gContext.getXdsmlIFile().getProject();
		ActiveFile activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject);
		IFile ecoreFile = activeFileEcore.getActiveFile();
		if (ecoreFile != null) {
			File fileToOpen = new File(ecoreFile.getLocation().toOSString());
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
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		
	}
	
	@Override
	public boolean acceptChangeForRemovedResource(ProcessContext context, IResource resource) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		// if the changed resource is an IProject referenced by the xdsml
		if(resource instanceof IProject){
			DomainModelProject dmp = gContext.getXdsmlConfigModel().getLanguageDefinition().getDomainModelProject();
			if(dmp != null && dmp instanceof EMFEcoreProject){
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				if(resource.getName().equals(projectName)){
					return true;
				}
				
			}
		}
		// if the change is about the ecoreFile or genmodel
		if(resource instanceof IFile){
			if(gContext.getEcoreIFile() !=  null){
				return resource.getFullPath().toString().equals(gContext.getEcoreIFile().getFullPath().toString());
			}
			// if the change happen on the genmodel referenced by the xdsml
			DomainModelProject dmp = gContext.getXdsmlConfigModel().getLanguageDefinition().getDomainModelProject();
			if(dmp != null && dmp instanceof EMFEcoreProject){
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				if(eep.getEmfGenmodel() != null){
					if(resource.getLocationURI().toString().equals(eep.getEmfGenmodel().getLocationURI())){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean acceptChangeForAddedResource(ProcessContext context, IResource resource) {
		// if xdsml of the process has changed
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		if(uri.equals(gContext.getXdsmlConfigURI())){
			return true;
		}
		
		// or if the changed resource is an IProject referenced by the xdsml
		if(resource instanceof IProject){
			DomainModelProject dmp = gContext.getXdsmlConfigModel().getLanguageDefinition().getDomainModelProject();
			if(dmp != null && dmp instanceof EMFEcoreProject){
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				if(resource.getName().equals(projectName)){
					return true;
				}
			}
		}
		// if the change is about the ecoreFile or genmodel
		if(resource instanceof IFile){
			if(gContext.getEcoreIFile() !=  null){
				return resource.getFullPath().toString().equals(gContext.getEcoreIFile().getFullPath().toString());
			}
			// if the change happen on the genmodel referenced by the xdsml
			DomainModelProject dmp = gContext.getXdsmlConfigModel().getLanguageDefinition().getDomainModelProject();
			if(dmp != null && dmp instanceof EMFEcoreProject){
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				if(eep.getEmfGenmodel() != null){
					if(resource.getLocationURI().toString().equals(eep.getEmfGenmodel().getLocationURI())){
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
		// if the change is about the ecoreFile or genmodel
		if(resource instanceof IFile){
			if(gContext.getEcoreIFile() !=  null){
				return resource.getFullPath().toString().equals(gContext.getEcoreIFile().getFullPath().toString());
			}
			// if the change happen on the genmodel referenced by the xdsml
			DomainModelProject dmp = gContext.getXdsmlConfigModel().getLanguageDefinition().getDomainModelProject();
			if(dmp != null && dmp instanceof EMFEcoreProject){
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				if(eep.getEmfGenmodel() != null){
					if(resource.getLocationURI().toString().equals(eep.getEmfGenmodel().getLocationURI())){
						return true;
					}
				}
			}
		}
		return false;
	}

}
