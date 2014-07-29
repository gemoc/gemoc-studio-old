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
package org.gemoc.gemoc_language_workbench.process;

import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceContentChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.process.task.GemocProcessUtils;

public class GemocLanguageDiscovery implements IChangeProcessor {

	
	//Map<URI, GemocLanguageProcessRunner> runningProcessMap = new HashMap<URI, GemocLanguageProcessRunner>();

	public void process(IChange<?> change) {
		if (change instanceof AbstractResourceChange) {
			final IResource resource = ((AbstractResourceChange)change).getObject();
			final boolean isXDSMLFile = GemocProcessUtils.isXDSMLFile(resource);
			final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			if (isXDSMLFile && (change instanceof ResourceAdded) && getEquivalentRunner(uri) == null) {
				
				createProcessRunner(uri, (IFile)resource);
				//updateProcessRunner(uri);
			}
			/*if (isXDSMLFile && (change instanceof ResourceContentChanged)) {
				updateProcessRunner(uri);
			}*/ else if (change instanceof ResourceMoved) {
				deleteProcessRunner(uri);
				final IResource dest = ((ResourceMoved)change).getDestination();
				final URI destUri = URI.createPlatformResourceURI(dest.getFullPath().toString(), true);
				createProcessRunner(destUri, (IFile)resource);

			} else if (isXDSMLFile && change instanceof ResourceRemoved) {
				deleteProcessRunner(uri);
			}
		}

	}

	private GemocLanguageProcessRunner getEquivalentRunner(URI uri){
		for(IProcessRunner runner : ProcessUtils.getRegisteredRunners()){
			if(runner instanceof GemocLanguageProcessRunner){
				GemocLanguageProcessRunner gRunner = (GemocLanguageProcessRunner)runner;
				if(gRunner.getGemocLanguageProcessContext().getXdsmlConfigURI().equals(uri)){
					return gRunner;
				}
			}
		}
		return null;
		
	}
	
	
	private void createProcessRunner(final URI uri, IFile xdsmlFile) {
		GemocLanguageProcessRunner procRunner = new GemocLanguageProcessRunner(uri, xdsmlFile);
		//runningProcessMap.put(uri, procRunner);

		ProcessUtils.registerProcessRunner(procRunner);
		final IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		WorkspaceUtils.getListener(activeWorkbenchWindow.getActivePage()).addProcessor(procRunner, true);
		WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace()).addProcessor(procRunner, true);		
	}

	private void deleteProcessRunner(final URI uri) {
		GemocLanguageProcessRunner procRunner = getEquivalentRunner(uri);
		ProcessUtils.unregisterProcessRunner(procRunner);
		WorkspaceUtils.removeProcessor(procRunner);
		//runningProcessMap.remove(uri);
	}

	public void stop() {
		ArrayList<IProcessRunner> l = new ArrayList<IProcessRunner>();
		l.addAll(ProcessUtils.getRegisteredRunners());
		for(IProcessRunner runner :  l){
			if(runner instanceof GemocLanguageProcessRunner){
				GemocLanguageProcessRunner gRunner = (GemocLanguageProcessRunner)runner;
				ProcessUtils.unregisterProcessRunner(gRunner);
				WorkspaceUtils.removeProcessor(gRunner);
			}
		}
	}

	/**
	 * Reloads the config at the given {@link URI}.
	 * 
	 * @param runner
	 *            the {@link IProcessRunner}
	 * @param uri
	 *            the {@link URI}
	 */
	/*private void updateProcessRunner(final URI uri) {
		GemocLanguageProcessRunner runner = getEquivalentRunner(uri);
		if (runner != null) {
			runner.getGemocLanguageProcessContext().updateXdsmlConfigModel();
		}

	}*/

}
