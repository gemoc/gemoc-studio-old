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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;
import org.gemoc.gemoc_language_workbench.process.GemocLanguageProcessContext;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateNewGemocLanguageProject;

/**
 * Create a new Gemoc language project.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateNewGemocLanguageProjectTask extends AbstractProcessor {

	
	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 */
	public CreateNewGemocLanguageProjectTask(ActionTask task) {
		super(task);
	}



	public boolean checkIsDone(ProcessContext context, IChange<?> change) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		if (change instanceof AbstractResourceChange) {
			final IResource resource = ((AbstractResourceChange)change).getObject();
			final boolean isXDSMLFile = GemocProcessUtils.isXDSMLFile(resource);
			final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			if (isXDSMLFile && (change instanceof ResourceAdded)){
				return gContext.getXdsmlConfigModel() != null;
			}
		}
		return false;
	}
	
	public Object updateContextWhenDone(ProcessContext context, IChange<?> change) {
		GemocLanguageProcessContext gContext = (GemocLanguageProcessContext)context;
		if (change instanceof AbstractResourceChange) {
			final IFile resource = (IFile)((AbstractResourceChange)change).getObject(); // cast is safe due to the check in checkIsDone
			final URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			gContext.setXdsmlConfigURI(uri);;
			gContext.setXdsmlIFile(resource);
			return uri;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		// start the XDSML wizard
		WizardDialog wizardDialog = new WizardDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				new  CreateNewGemocLanguageProject());
		wizardDialog.open();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		// TODO remove the project ?

	}



	public String updateContextWhenUndone(ProcessContext context, IChange<?> change) {
		// should never happen for first task of a process because already removed by discovery
		return "No xdsml file";
	}

}
