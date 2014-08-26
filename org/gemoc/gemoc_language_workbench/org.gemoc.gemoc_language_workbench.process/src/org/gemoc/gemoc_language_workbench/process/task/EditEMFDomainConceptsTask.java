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
import fr.obeo.dsl.process.ContextVariable;

import java.io.File;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.process.specific.AbstractActionProcessor2;
import org.gemoc.gemoc_language_workbench.process.specific.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.process.utils.EMFResource;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseResource;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseUI;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFileEcore;

/**
 * Set domain model root.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class EditEMFDomainConceptsTask extends AbstractActionProcessor2 {

	protected String lastEClassName = "";

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 * @param task1
	 *            the reference to the {@link ActionTask} corresponding to
	 *            {@link CreateNewGemocLanguageProjectTask}
	 * @param task2b
	 *            the reference to the {@link ActionTask} corresponding to {@link SelectEMFProjectTask}
	 */
	public EditEMFDomainConceptsTask(ActionTask task) {
		super(task, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#updateContexts(fr.obeo.dsl.process.IProcessRunner,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	@Override
	protected Object internalUpdateContextWhenDone(GemocLanguageProcessContext context) {
		return lastEClassName;
	}

	/**
	 * Updates the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	@Override
	protected boolean internalValidate(GemocLanguageProcessContext context) {
		boolean result = false;
		EMFEcoreProject eep = context.getEcoreProject();
		if (eep != null) {
			if (eep.getEmfGenmodel() == null 
				|| eep.getEmfGenmodel().getLocationURI() == null
				|| eep.getEmfGenmodel().getLocationURI().length() == 0) {
				undoneReason = "no valid genmodel referenced in xdsml";
				result = false;
			} else {
				String genModelURI =  eep.getEmfGenmodel().getLocationURI();				
				try {
					Object firstContent = EMFResource.getFirstContent(URI.createURI(genModelURI, true));
					if (firstContent instanceof GenModel
						&& hasClassifier((GenModel)firstContent)) {
						result = true;
					} else {
						undoneReason = "No classifier defined in Domain model.";
					}
					// CHECKSTYLE:OFF
				} catch (Exception e) {
					undoneReason = "problem getting genmodel content (check the uri in the xdsml ?)";
				} // CHECKSTYLE:ON
			}
			return result;
		}
		undoneReason = "no EMF project referenced in xdsml";
		return result;
	}

	/**
	 * Tells if the given {@link GenModel} contains at least one {@link org.eclipse.emf.ecore.EClassifier
	 * EClassifier}.
	 * 
	 * @param genModel
	 *            the {@link GenModel}
	 * @return <code>true</code> if the given {@link GenModel} contains at least one
	 *         {@link org.eclipse.emf.ecore.EClassifier EClassifier}, <code>false</code> otherwise
	 */
	private boolean hasClassifier(GenModel genModel) {
		boolean res = false;

		for (GenPackage genPkg : genModel.getAllGenPackagesWithClassifiers()) {
			final EPackage ePkg = genPkg.getEcorePackage();
			if (ePkg != null) {
				if (!ePkg.getEClassifiers().isEmpty()) {
					lastEClassName = ePkg.getEClassifiers().get(0).getName();
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
	@Override
	protected void internalDoAction(GemocLanguageProcessContext context) {
		IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		ActiveFile activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject);
		IFile ecoreFile = activeFileEcore.getActiveFile();
		if (ecoreFile != null) {
			File fileToOpen = new File(ecoreFile.getLocation().toOSString());
			if (fileToOpen.exists() && fileToOpen.isFile()) {
				IFileStore fileStore = EFS.getLocalFileSystem().getStore(fileToOpen.toURI());
				try {
					IDE.openEditorOnFileStore(EclipseUI.getActivePage(), fileStore);
				} catch (PartInitException e) {
					// Put your exception handler here if you wish to
				}
			} else {
				// Do something if the file does not exist
			}
		}

	}

	public boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		return
				EclipseResource.matches(resource, IProject.class, context.getEcoreProjectName())
				|| EclipseResource.matches(resource, IFile.class, context.getEcoreIFile())
				|| checkFileIsGenModel(context, resource);
	}

	public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) {
		return
				EclipseResource.matches(resource, IProject.class, context.getEcoreProjectName())
				|| EclipseResource.matches(resource, IFile.class, context.getEcoreIFile())
				|| checkFileIsGenModel(context, resource);
	}

	public boolean acceptChangeForModifiedResource(GemocLanguageProcessContext context, IResource resource) {
		return 
				EclipseResource.matches(resource, IFile.class, context.getEcoreIFile())
				|| checkFileIsGenModel(context, resource);
	}

	private boolean checkFileIsGenModel(GemocLanguageProcessContext context, IResource resource) {
		if (resource instanceof IFile) {
			// if the change happen on the genmodel referenced by the xdsml
			EMFEcoreProject eep = context.getEcoreProject();
			if (eep != null
				&& eep.getEmfGenmodel() != null
				&& EclipseResource.matches(resource, URI.createURI(eep.getEmfGenmodel().getLocationURI(), true))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean acceptChangeVariableChanged(GemocLanguageProcessContext context, ContextVariable variable) {
		// if the xdsml model has changed, need to reevaluate
		if (variable.getName().equals(GemocLanguageProcessContext.XDSML_MODEL_VAR)) {
			return true;
		}
		return false;
	}

}
