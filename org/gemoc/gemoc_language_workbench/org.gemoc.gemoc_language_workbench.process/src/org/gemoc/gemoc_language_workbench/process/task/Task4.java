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

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.EditorPart;
import org.gemoc.gemoc_language_workbench.process.AbstractProcessor;

/**
 * Show domain model.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class Task4 extends AbstractProcessor {

	/**
	 * The reference to the {@link ActionTask} corresponding to {@link SelectEMFProjectTask}.
	 */
	private final ActionTask task2b;

	/**
	 * /** Constructor.
	 * 
	 * @param task
	 *            the corresponding {@link ActionTask}.
	 * @param task2b
	 *            the reference to the {@link ActionTask} corresponding to {@link SelectEMFProjectTask}
	 */
	public Task4(ActionTask task, ActionTask task2b) {
		super(task);
		this.task2b = task2b;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#updateContexts(fr.obeo.dsl.process.IProcessRunner,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void updateContexts(IProcessRunner runner, IChange<?> change) {
		// TODO
		// if (change instanceof PartOpened || change instanceof PartClosed) {
		// for (ProcessContext context : runner.getContexts()) {
		// final String genModelPath = (String)context.getProgress().get(task2b);
		// if (genModelPath != null) {
		// updateContext(change, context, genModelPath);
		// }
		// }
		// }
	}

	/**
	 * Updates the given {@link ProcessContext} according to the given {@link IChange} and ecore {@link URI}.
	 * 
	 * @param change
	 *            the {@link IChange}
	 * @param context
	 *            the {@link ProcessContext}
	 * @param genModelPath
	 *            the gen model path
	 */
	// TODO
	// private void updateContext(IChange<?> change, ProcessContext context, final String genModelPath) {
	// Set<IWorkbenchPartReference> partRefs = (Set<IWorkbenchPartReference>)context.getProgress().get(
	// getActionTask());
	// if (change instanceof PartOpened) {
	// final IWorkbenchPartReference partRef = ((PartOpened)change).getObject();
	// if (isEcoreEditPart(partRef, genModelPath)) {
	// if (partRefs == null) {
	// partRefs = new LinkedHashSet<IWorkbenchPartReference>();
	// context.getProgress().put(getActionTask(), partRefs);
	// }
	// partRefs.add(partRef);
	// }
	// } else if (change instanceof PartClosed) {
	// if (partRefs != null) {
	// partRefs.remove(change.getObject());
	// }
	// }
	// }

	/**
	 * Tells if the given {@link IWorkbenchPartReference} is editing one of our ecore files.
	 * 
	 * @param partRef
	 *            the {@link IWorkbenchPartReference}
	 * @param ecoreURIs
	 *            our ecore files
	 * @return <code>true</code> if the given {@link IWorkbenchPartReference} is editing one of our ecore
	 *         files, <code>false</code> otherwise
	 */
	private boolean isEcoreEditPart(IWorkbenchPartReference partRef, Set<URI> ecoreURIs) {
		boolean res = false;

		final IWorkbenchPart part = partRef.getPart(false);
		if (part instanceof EditorPart) {
			final IEditorInput input = ((EditorPart)part).getEditorInput();
			final IResource editedResource = ResourceUtil.getResource(input);
			if (editedResource instanceof IFile) {
				for (URI uri : ecoreURIs) {
					if (uri.path().equals(editedResource.getFullPath().toString())) {
						res = true;
						break;
					}
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
		// TODO open editor for all Ecore referenced by the genmodel

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.gemoc.gemoc_language_workbench.process.IActionProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		// TODO close all editors editing one on the referenced Ecore model.

	}

}
