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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EMFGenmodel;
import org.gemoc.gemoc_language_workbench.conf.EditorProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.TreeEditorProject;
import org.gemoc.gemoc_language_workbench.process.specific.AbstractActionProcessor2;
import org.gemoc.gemoc_language_workbench.process.specific.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseResource;

/**
 * Set domain model root.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SetEMFTreeEditorFileExtensionTask extends AbstractActionProcessor2 {

	protected String lastExtensions = "";

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public SetEMFTreeEditorFileExtensionTask(ActionTask task) {
		super(task, false);
	}

	@Override
	protected Object internalUpdateContextWhenDone(GemocLanguageProcessContext context) {
		return lastExtensions;
	}

	@Override
	protected boolean internalValidate(GemocLanguageProcessContext context) {
		boolean result = false;
		// it exists an EMF Tree editor project that is referenced by the xdsml
		// search for the file extensions
		List<String> extensionsDefinedInDSML = new ArrayList<String>();
		EditorProject treeEditorProjet = findTreeEditorInXDSML(context.getXdsmlModel());
		if (treeEditorProjet != null) {
			extensionsDefinedInDSML.addAll(treeEditorProjet.getFileExtension());
		}

		List<String> extensionsDefinedInGenModel = new ArrayList<String>();

		GenModel genModel = getGenModel(context.getXdsmlModel());
		for (GenPackage genPkg : genModel.getAllGenPackagesWithClassifiers()) {
			extensionsDefinedInGenModel.addAll(genPkg.getFileExtensionList());
		}

		if (extensionsDefinedInDSML.containsAll(extensionsDefinedInGenModel)
				&& extensionsDefinedInGenModel.containsAll(extensionsDefinedInDSML)) {
			StringBuilder sb = new StringBuilder();
			for (String s : extensionsDefinedInDSML) {
				sb.append(s);
			}
			lastExtensions = sb.toString();
			result = true;
		} else if (!extensionsDefinedInDSML.containsAll(extensionsDefinedInGenModel)) {
			undoneReason = "file extensions defined in EMF Tree Editor genmodel aren't all referenced in xdsml";
		} else if (!extensionsDefinedInGenModel.containsAll(extensionsDefinedInDSML)) {
			undoneReason = "file extensions referenced in XDSML aren't all defined EMF Tree Editor genmodel";
		}
		return result;
	}

	@Override
	protected void internalDoAction(GemocLanguageProcessContext context) {
		/*
		 * IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject(); ActiveFile
		 * activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject); IFile ecoreFile =
		 * activeFileEcore.getActiveFile(); if (ecoreFile != null) { LabelProvider labelProvider = new
		 * ENamedElementQualifiedNameLabelProvider(); ResourceSet resSet = new ResourceSetImpl(); // get the
		 * resource Resource resource = resSet
		 * .getResource(URI.createURI(ecoreFile.getLocationURI().toString()), true); SelectAnyEObjectDialog
		 * dialog = new SelectAnyConcreteEClassDialog(PlatformUI.getWorkbench()
		 * .getActiveWorkbenchWindow().getShell(), resource, labelProvider); int res = dialog.open(); if (res
		 * == WizardDialog.OK) { // update the project model setRootEObjectInConf(updatedGemocLanguageProject,
		 * labelProvider.getText(dialog .getFirstResult())); } }
		 */
	}

	@Override
	protected void internalUndoAction(GemocLanguageProcessContext context) {
		/*
		 * DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		 * if (dmp instanceof EMFEcoreProject) {
		 * ((EMFEcoreProject)dmp).setDefaultRootEObjectQualifiedName(null); try {
		 * context.getXdsmlModel().eResource().save(null); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } }
		 */
	}

	public boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		return acceptChangeForResource(context, resource);
	}

	public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) {
		return acceptChangeForResource(context, resource);
	}

	private boolean acceptChangeForResource(GemocLanguageProcessContext context, IResource resource) {
		boolean result = false;
		String projectName = context.getEcoreProjectName();
		// if the changed resource is an IProject referenced by the xdsml as Domain model project
		if (resource instanceof IProject) {
			result = resource.getName().equals(projectName);
		} else if (resource instanceof IFile) {
			EMFGenmodel emfGenModelFromXDSML = getEMFGenModelDefinedInXDSML(context);
			// if the change happen on the genmodel referenced by the xdsml
			if (emfGenModelFromXDSML != null
					&& resource.getName().equals(emfGenModelFromXDSML.getLocationURI())) {
				result = true;

			}
		}
		return result;
	}

	public boolean acceptChangeForModifiedResource(GemocLanguageProcessContext context, IResource resource) {
		// if the changed resource is the genmodel referenced by the xdsml
		if (resource instanceof IFile) {
			EMFGenmodel emfGenModelFromXDSML = getEMFGenModelDefinedInXDSML(context);
			// if the change happen on the genmodel referenced by the xdsml
			if (emfGenModelFromXDSML != null
					&& EclipseResource.matches(resource, URI.createURI(emfGenModelFromXDSML.getLocationURI(),
							true))) {
				return true;
			}
		}
		return false;
	}

	protected EMFGenmodel getEMFGenModelDefinedInXDSML(GemocLanguageProcessContext context) {
		EMFEcoreProject eep = context.getEcoreProject();
		if (eep != null) {
			return eep.getEmfGenmodel();
		}
		return null;
	}

	public boolean acceptChangeVariableChanged(GemocLanguageProcessContext context, ContextVariable variable) {
		// if the xdsml model has changed, need to reevaluate
		if (variable.getName().equals(GemocLanguageProcessContext.XDSML_MODEL_VAR)) {
			return true;
		}
		return false;
	}

	private Resource getGenModelResource(GemocLanguageWorkbenchConfiguration xdsmlModel) {
		DomainModelProject dmp = xdsmlModel.getLanguageDefinition().getDomainModelProject();
		if (dmp != null && dmp instanceof EMFEcoreProject) {
			EMFEcoreProject eep = (EMFEcoreProject)dmp;
			if (eep.getEmfGenmodel() != null && eep.getEmfGenmodel().getLocationURI() != null
					&& eep.getEmfGenmodel().getLocationURI().length() != 0) {
				String genModelURI = eep.getEmfGenmodel().getLocationURI();
				final ResourceSet resourceSet = new ResourceSetImpl();
				return resourceSet.getResource(URI.createURI(genModelURI, true), true);
			}
		}
		return null;
	}

	private GenModel getGenModel(GemocLanguageWorkbenchConfiguration xdsmlModel) {
		Resource res = getGenModelResource(xdsmlModel);
		if (res != null) {
			return (GenModel)res.getContents().get(0);
		}
		return null;
	}

	private EditorProject findTreeEditorInXDSML(GemocLanguageWorkbenchConfiguration xdsmlModel) {
		EList<EditorProject> editorsProjects = xdsmlModel.getLanguageDefinition().getEditorProjects();
		for (EditorProject editorProject : editorsProjects) {
			if (editorProject instanceof TreeEditorProject) {
				return editorProject;
			}
		}
		return null;
	}
}
