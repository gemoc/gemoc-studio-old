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
package org.gemoc.gemoc_language_workbench.process.specific;

import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.process.task.GemocProcessUtils;
import org.gemoc.gemoc_language_workbench.process.utils.EclipseResource;

public class GemocLanguageDiscovery implements IChangeProcessor {

	public void process(IChange<?> change) {
		if (change instanceof AbstractResourceChange) {
			final IResource resource = ((AbstractResourceChange)change).getObject();
			final boolean isXDSMLFile = GemocProcessUtils.isXDSMLFile(resource);
			final URI uri = EclipseResource.getUri(resource);
			if (isXDSMLFile && change instanceof ResourceAdded && !existProcessRunner(uri)) {
				createProcessRunner(uri);
			} else if (change instanceof ResourceMoved) {
				deleteProcessRunner(uri);
				final IResource dest = ((ResourceMoved)change).getDestination();
				final URI newUri = EclipseResource.getUri(dest);
				createProcessRunner(newUri);
			} else if (isXDSMLFile && change instanceof ResourceRemoved) {
				deleteProcessRunner(uri);
			}
		}
	}

	private boolean existProcessRunner(URI uri) {
		return getProcessRunner(uri) != null;
	}

	private GemocLanguageProcessRunner getProcessRunner(URI uri) {
		for (IProcessRunner runner : ProcessUtils.getRegisteredRunners()) {
			if (runner instanceof GemocLanguageProcessRunner) {
				GemocLanguageProcessRunner gRunner = (GemocLanguageProcessRunner)runner;
				if (gRunner.getCastedContext().getXdsmlURI() != null
						&& gRunner.getCastedContext().getXdsmlURI().equals(uri)) {
					return gRunner;
				}
			}
		}
		return null;
	}

	private GemocLanguageProcessRunner createProcessRunner(final URI uri) {
		return GemocProcessRunnerFactory.createProcessRunner(uri);
	}

	private void deleteProcessRunner(final URI uri) {
		GemocLanguageProcessRunner runner = getProcessRunner(uri);
		if (runner != null) {
			ProcessUtils.unregisterProcessRunner(runner);
			WorkspaceUtils.removeProcessor(runner);
		}
	}

	public void stop() {
		ArrayList<IProcessRunner> runners = new ArrayList<IProcessRunner>();
		runners.addAll(ProcessUtils.getRegisteredRunners());
		for (IProcessRunner runner : runners) {
			if (runner instanceof GemocLanguageProcessRunner) {
				GemocLanguageProcessRunner gRunner = (GemocLanguageProcessRunner)runner;
				ProcessUtils.unregisterProcessRunner(gRunner);
				WorkspaceUtils.removeProcessor(gRunner);
			}
		}
	}
}
