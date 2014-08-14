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

import java.io.IOException;
import java.util.Map;

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
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.process.AbstractResourceActionProcessor;
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
public class SetDomainModelRootTask extends AbstractResourceActionProcessor {

	protected String undoneReason = "";

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
	public SetDomainModelRootTask(ActionTask task) {
		super(task, false);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#updateContexts(fr.obeo.dsl.process.IProcessRunner,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public Object updateContextWhenDone(GemocLanguageProcessContext context) {
		return lastEClassName;
	}

	public String updateContextWhenUndone(GemocLanguageProcessContext context) {
		return undoneReason;
	}

	/**
	 * tells if the Task is valid.
	 * 
	 * @param context
	 *            the {@link GemocLanguageProcessContext}
	 * @return
	 * 			true if the task is valid, false otherwise
	 */
	public boolean validate(GemocLanguageProcessContext context) {
		boolean result = false;
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		if (dmp != null && dmp instanceof EMFEcoreProject) {
			EMFEcoreProject eep = (EMFEcoreProject)dmp;
			if (eep.getEmfGenmodel() == null || eep.getEmfGenmodel().getLocationURI() == null
					|| eep.getEmfGenmodel().getLocationURI().length() == 0) {
				undoneReason = "no valid genmodel referenced in xdsml";
				result = false;
			} else {
				String genModelPath = eep.getEmfGenmodel().getLocationURI();
				final ResourceSet resourceSet = new ResourceSetImpl();
				final Resource r = resourceSet.getResource(URI.createPlatformResourceURI("/" + genModelPath,
						true), true);
				final String eClsName = eep.getDefaultRootEObjectQualifiedName();
				if (r.getContents().size() > 0 && r.getContents().get(0) instanceof GenModel
						&& hasClassifier((GenModel)r.getContents().get(0), eClsName)) {
					lastEClassName = eClsName;
					result = true;
				} else {
					result = false;
					undoneReason = "Root EObject doesn't exists.";
				}
			}
			result = false;
			undoneReason = "no EMF project referenced in xdsml";
		} else {
			undoneReason = "no EMF project referenced in xdsml";
		}
		return result;
	}

	/**
	 * Tells if a {@link org.eclipse.emf.ecore.EClassifier EClassifier} with the given name exists in the
	 * given {@link GenModel}.
	 * 
	 * @param genModel
	 *            the {@link GenModel}
	 * @param eClsName
	 *            the {@link org.eclipse.emf.ecore.EClassifier EClassifier} name
	 * @return <code>true</code> if a {@link org.eclipse.emf.ecore.EClassifier EClassifier} with the given
	 *         name exists in the given {@link GenModel}, <code>false</code> otherwise
	 */
	private boolean hasClassifier(GenModel genModel, String eClsName) {
		boolean res = false;
		for (GenPackage genPkg : genModel.getAllGenPackagesWithClassifiers()) {
			final EPackage ePkg = genPkg.getEcorePackage();
			if (ePkg != null) {
				if (ePkg.getEClassifier(eClsName) != null) {
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
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(GemocLanguageProcessContext)
	 */
	public void doAction(GemocLanguageProcessContext context) {
		IProject updatedGemocLanguageProject = context.getXdsmlFile().getProject();
		ActiveFile activeFileEcore = new ActiveFileEcore(updatedGemocLanguageProject);
		IFile ecoreFile = activeFileEcore.getActiveFile();
		if (ecoreFile != null) {
			LabelProvider labelProvider = new ENamedElementQualifiedNameLabelProvider();
			ResourceSet resSet = new ResourceSetImpl();

			// get the resource
			Resource resource = resSet
					.getResource(URI.createURI(ecoreFile.getLocationURI().toString()), true);

			SelectAnyEObjectDialog dialog = new SelectAnyConcreteEClassDialog(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), resource, labelProvider);
			int res = dialog.open();
			if (res == WizardDialog.OK) {
				// update the project model
				setRootEObjectInConf(updatedGemocLanguageProject, labelProvider.getText(dialog
						.getFirstResult()));
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(GemocLanguageProcessContext)
	 */
	public void undoAction(GemocLanguageProcessContext context) {
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		if (dmp instanceof EMFEcoreProject) {
			((EMFEcoreProject)dmp).setDefaultRootEObjectQualifiedName(null);
			try {
				context.getXdsmlModel().eResource().save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void setRootEObjectInConf(IProject gemocLanguageIProject, String rootEObjectName) {
		IFile configFile = gemocLanguageIProject
				.getFile(new Path(Activator.GEMOC_PROJECT_CONFIGURATION_FILE));
		if (configFile.exists()) {
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put(Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION, new XMIResourceFactoryImpl());

			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();
			// get the resource
			Resource resource = resSet.getResource(URI.createURI(configFile.getLocationURI().toString()),
					true);

			GemocLanguageWorkbenchConfiguration gemocLanguageWorkbenchConfiguration = (GemocLanguageWorkbenchConfiguration)resource
					.getContents().get(0);
			// consider only one language :-/
			LanguageDefinition language = gemocLanguageWorkbenchConfiguration.getLanguageDefinition();

			if (language.getDomainModelProject() instanceof EMFEcoreProject) {
				((EMFEcoreProject)language.getDomainModelProject())
						.setDefaultRootEObjectQualifiedName(rootEObjectName);
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

	@Override
	public boolean acceptChangeForRemovedResource(GemocLanguageProcessContext context, IResource resource) {
		boolean result = false;
		// if the changed resource is an IProject referenced by the xdsml
		if (resource instanceof IProject) {
			DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
			if (dmp != null && dmp instanceof EMFEcoreProject) {
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				String projectName = eep.getProjectName();
				if (resource.getName().equals(projectName)) {
					result = true;
				} else
				// if the change happen on the genmodel referenced by the xdsml
				if (eep.getEmfGenmodel() != null
						&& resource.getName().equals(eep.getEmfGenmodel().getLocationURI())) {
					result = true;
				}
			}
		}
		return result;
	}

	@Override
	public boolean acceptChangeForAddedResource(GemocLanguageProcessContext context, IResource resource) {
		boolean result = false;
		DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
		// if the changed resource is an IProject referenced by the xdsml
		if (resource instanceof IProject && dmp != null && dmp instanceof EMFEcoreProject) {
			EMFEcoreProject eep = (EMFEcoreProject)dmp;
			String projectName = eep.getProjectName();
			if (resource.getName().equals(projectName)) {
				result = true;
			} else
			// if the change happen on the genmodel referenced by the xdsml
			if (eep.getEmfGenmodel() != null
					&& resource.getName().equals(eep.getEmfGenmodel().getLocationURI())) {
				result = true;

			}
		}

		return result;
	}

	@Override
	public boolean acceptChangeForModifiedResource(GemocLanguageProcessContext context, IResource resource) {
		// if the changed resource is the genmodel referenced by the xdsml
		if (resource instanceof IFile) {
			DomainModelProject dmp = context.getXdsmlModel().getLanguageDefinition().getDomainModelProject();
			if (dmp != null && dmp instanceof EMFEcoreProject) {
				EMFEcoreProject eep = (EMFEcoreProject)dmp;
				// if the change happen on the genmodel referenced by the xdsml
				if (eep.getEmfGenmodel() != null
						&& resource.getName().equals(eep.getEmfGenmodel().getLocationURI())) {
					return true;

				}
			}
		}
		return false;
	}

	@Override
	public boolean acceptChangeVariableChanged(GemocLanguageProcessContext context, ContextVariable variable) {
		// if the xdsml model has changed, need to reevaluate
		if (variable.getName().equals(GemocLanguageProcessContext.XDSML_MODEL_VAR)) {
			return true;
		}
		return false;
	}
}
