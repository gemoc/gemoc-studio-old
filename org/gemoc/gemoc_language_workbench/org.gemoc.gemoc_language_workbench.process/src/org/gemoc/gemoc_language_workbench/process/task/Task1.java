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
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceContentChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;

/**
 * Create a new Gemoc language project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Task1 extends AbstractProcessor {

	/**
	 * Maps {@link URI} to {@link ProcessContext}.
	 */
	private final Map<URI, ProcessContext> contexts = new HashMap<URI, ProcessContext>();

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public Task1(ActionTask task) {
		super(task);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#updateContexts(fr.obeo.dsl.process.IProcessRunner,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void updateContexts(IProcessRunner runner, IChange<?> change) {
		if (change instanceof AbstractResourceChange) {
			final IResource resource = ((AbstractResourceChange)change).getObject();
			final boolean isXDSMLFile = GemocProcessUtils.isXDSMLFile(resource);
			final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			if (isXDSMLFile && (change instanceof ResourceAdded || change instanceof ResourceContentChanged)) {
				reloadConfig(runner, uri);
			} else if (change instanceof ResourceMoved) {
				final IResource dest = ((ResourceMoved)change).getDestination();
				if (isXDSMLFile) {
					moveConfig(runner, (ResourceMoved)change, uri);
				} else if (GemocProcessUtils.isXDSMLFile(dest)) {
					final URI destUri = URI.createPlatformResourceURI(dest.getFullPath().toString(), true);
					reloadConfig(runner, destUri);
				}
			} else if (isXDSMLFile && change instanceof ResourceRemoved) {
				final ProcessContext context = removeConfig(uri);
				if (context != null) {
					runner.stopContext(context);
				}
			}
		}
	}

	/**
	 * Moves the configuration for the given {@link URI} {@link ResourceMoved}.
	 * 
	 * @param runner
	 *            the {@link IProcessRunner}
	 * @param change
	 *            the {@link ResourceMoved}
	 * @param uri
	 *            the source config {@link URI}
	 */
	private void moveConfig(IProcessRunner runner, ResourceMoved change, final URI uri) {
		final ProcessContext context = removeConfig(uri);
		if (GemocProcessUtils.isXDSMLFile(change.getDestination())) {
			final IResource dest = change.getDestination();
			final URI destUri = URI.createPlatformResourceURI(dest.getFullPath().toString(), true);
			contexts.put(destUri, context);
			reloadConfig(runner, destUri);
		} else if (context != null) {
			runner.stopContext(context);
		}
	}

	/**
	 * Removes the configuration for the given {@link URI}.
	 * 
	 * @param uri
	 *            the {@link URI}
	 * @return the removed {@link ProcessContext} if any, <code>null</code> otherwise
	 */
	private ProcessContext removeConfig(final URI uri) {
		final ProcessContext context = contexts.remove(uri);
		if (context != null) {
			context.setUndone(getActionTask(), null);
		}
		return context;
	}

	/**
	 * Reloads the config at the given {@link URI}.
	 * 
	 * @param runner
	 *            the {@link IProcessRunner}
	 * @param uri
	 *            the {@link URI}
	 */
	private void reloadConfig(IProcessRunner runner, final URI uri) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource r = resourceSet.getResource(uri, true);
		final GemocLanguageWorkbenchConfiguration config = (GemocLanguageWorkbenchConfiguration)r
				.getContents().get(0);
		ProcessContext context = contexts.get(uri);
		if (context == null) {
			context = runner.startContext();
			contexts.put(uri, context);
		}
		if (config.getLanguageDefinition() != null) {
			context.setName(config.getLanguageDefinition().getName());
		}
		context.setDone(getActionTask(), config);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		// TODO start the XDSML wizard

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		// TODO remove the project ?

	}

}
