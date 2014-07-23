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

import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.gemoc_language_workbench.conf.DomainModelProject;
import org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject;
import org.gemoc.gemoc_language_workbench.conf.EMFGenmodel;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;

/**
 * Set domain model root.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Task3a extends AbstractProcessor {

	/**
	 * The reference to the {@link ActionTask} corresponding to {@link Task1}.
	 */
	private final ActionTask task1;

	/**
	 * The reference to the {@link ActionTask} corresponding to {@link Task2b}.
	 */
	private final ActionTask task2b;

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 * @param task1
	 *            the reference to the {@link ActionTask} corresponding to {@link Task1}
	 * @param task2b
	 *            the reference to the {@link ActionTask} corresponding to {@link Task2b}
	 */
	public Task3a(ActionTask task, ActionTask task1, ActionTask task2b) {
		super(task);
		this.task1 = task1;
		this.task2b = task2b;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#updateContexts(fr.obeo.dsl.process.IProcessRunner,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void updateContexts(IProcessRunner runner, IChange<?> change) {
		if (change instanceof AbstractResourceChange) {
			final IResource resource = WorkspaceUtils.getResource((AbstractResourceChange)change);
			final boolean forceUpdate = GemocProcessUtils.isXDSMLFile(resource);
			for (ProcessContext context : runner.getContexts()) {
				if (forceUpdate || shouldUpdate(context, (AbstractResourceChange)change)) {
					updateContext(context);
				}
			}
		}
	}

	/**
	 * Updates the given {@link ProcessContext}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 */
	private void updateContext(ProcessContext context) {
		String genModelPath = (String)context.getResult(task2b);
		if (genModelPath != null && genModelPath.length() != 0) {
			final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)context
					.getResult(task1);
			if (config != null && config.getLanguageDefinition() != null
					&& config.getLanguageDefinition().getDomainModelProject() != null) {
				final DomainModelProject project = config.getLanguageDefinition().getDomainModelProject();
				if (project instanceof EMFEcoreProject) {
					checkEMFEcoreProject(context, genModelPath, (EMFEcoreProject)project);
				} else if (project != null) {
					new IllegalStateException("don't know what to do with "
							+ project.getClass().getCanonicalName());
				}
			} else {
				context.setUndone(getActionTask(), null);
			}
		}
	}

	/**
	 * Checks the given {@link EMFEcoreProject}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param genModelPath
	 *            the genmodel path
	 * @param project
	 *            the {@link EMFEcoreProject}
	 */
	private void checkEMFEcoreProject(ProcessContext context, String genModelPath,
			final EMFEcoreProject project) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource r = resourceSet.getResource(URI.createPlatformResourceURI("/" + genModelPath, true),
				true);
		final String eClsName = project.getDefaultRootEObjectQualifiedName();
		if (r.getContents().size() > 0 && r.getContents().get(0) instanceof GenModel
				&& hasClassifier((GenModel)r.getContents().get(0), eClsName)) {
			context.setDone(getActionTask(), eClsName);
		} else {
			context.setUndone(getActionTask(), "Root EObject doesn't exists.");
		}
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
	 * Tells if the given {@link ProcessContext} should be updated on the given {@link IResource} change.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractResourceChange}
	 * @return <code>true</code> if the given {@link ProcessContext} should be updated on the given
	 *         {@link IResource} change, <code>false</code> otherwise
	 */
	private boolean shouldUpdate(ProcessContext context, AbstractResourceChange change) {
		final boolean res;

		final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)context
				.getResult(task1);
		if (config != null
				&& config.getLanguageDefinition() != null
				&& config.getLanguageDefinition().getDomainModelProject() instanceof EMFEcoreProject
				&& ((EMFEcoreProject)config.getLanguageDefinition().getDomainModelProject()).getEmfGenmodel() != null) {
			EMFGenmodel genModel = ((EMFEcoreProject)config.getLanguageDefinition().getDomainModelProject())
					.getEmfGenmodel();
			res = GemocProcessUtils.checkResourceChange("/" + genModel.getLocationURI(), change);
		} else {
			res = false;
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		// TODO Eclassifier selection wizard

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)context
				.getResult(task1);
		if (config != null && config.getLanguageDefinition() != null
				&& config.getLanguageDefinition().getDomainModelProject() != null) {
			final DomainModelProject project = config.getLanguageDefinition().getDomainModelProject();
			if (project instanceof EMFEcoreProject) {
				((EMFEcoreProject)config.getLanguageDefinition().getDomainModelProject())
						.setDefaultRootEObjectQualifiedName(null);
			} else {
				new IllegalStateException("don't know what to do with "
						+ project.getClass().getCanonicalName());
			}
			try {
				config.eResource().save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			context.setUndone(getActionTask(), null);
		}
	}

}
