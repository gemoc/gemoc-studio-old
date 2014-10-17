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
package fr.obeo.dsl.process.ui.tests.tasks;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceClosed;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceOpened;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

/**
 * The create project task implementation.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class CreateSrcGenFolder extends AbstractWorkspaceTaskProcessor {

	/**
	 * The source folder suffix.
	 */
	public static final String SUFFIX = "-src-gen";

	/**
	 * Constructor.
	 * 
	 * @param actionTask
	 *            the {@link ActionTask} definition
	 */
	public CreateSrcGenFolder(ActionTask actionTask) {
		super(actionTask);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.workspace.IWorkspaceTaskProcessor#validate(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void validate(ProcessContext context, IChange<?> change) {
		final ProcessVariable folderVariable = getActionTask().getWrittenVariables().get(0);
		final IFolder knownFolder = (IFolder)context.getVariableValue(folderVariable, getActionTask());
		final ProcessVariable fileVariable = getActionTask().getObservedVariables().get(0);
		final IFile file = (IFile)context.getVariableValue(fileVariable, getActionTask());
		if (change.getObject() instanceof IFolder) {
			IFolder folder = (IFolder)change.getObject();
			if (folder.equals(knownFolder)) {
				if (change instanceof ResourceRemoved) {
					context.setVariableValue(folderVariable, null, getActionTask());
					context.setUndone(getActionTask(), knownFolder.getName() + " removed.");
				} else if (change instanceof ResourceClosed) {
					context.setVariableValue(folderVariable, null, getActionTask());
					context.setUndone(getActionTask(), knownFolder.getName() + " closed.");
				} else if (change instanceof ResourceMoved) {
					context.setVariableValue(folderVariable, null, getActionTask());
					context.setUndone(getActionTask(), knownFolder.getName() + " moved to "
							+ ((ResourceMoved)change).getDestination().getName() + ".");
				}
			} else if (knownFolder == null) {
				final String folderName = getFolderName(file);
				if ((change instanceof ResourceAdded || change instanceof ResourceOpened)
						&& folder.getName().equals(folderName)
						&& ((IFolder)change.getObject()).getParent().equals(file.getParent())) {
					context.setVariableValue(folderVariable, folder, getActionTask());
					context.setDone(getActionTask(), folder);
				} else if (change instanceof ResourceMoved
						&& ((ResourceMoved)change).getDestination().getName().equals(folderName)
						&& ((IFolder)change.getObject()).getParent().equals(file.getParent())) {
					context.setVariableValue(folderVariable, ((ResourceMoved)change).getDestination(),
							getActionTask());
					context.setDone(getActionTask(), ((ResourceMoved)change).getDestination());
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#variableChanged(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ProcessVariable, java.lang.Object, java.lang.Object)
	 */
	public void variableChanged(ProcessContext context, ProcessVariable variable, Object oldValue,
			Object newValue) {
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#doAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void doAction(ProcessContext context) {
		final ProcessVariable fileVariable = getActionTask().getObservedVariables().get(0);
		final IFile file = (IFile)context.getVariableValue(fileVariable, getActionTask());
		final IFolder folder = file.getParent().getFolder(new Path(getFolderName(file)));
		try {
			folder.create(true, true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the src-gen {@link IFolder} name according to the given gen {@link IFile}.
	 * 
	 * @param genFile
	 *            the gen {@link IFile}
	 * @return the src-gen {@link IFolder} name according to the given gen {@link IFile

	 */
	private String getFolderName(IFile genFile) {
		final String prefix = genFile.getName().substring(0,
				genFile.getName().length() - CreateGenFile.EXTENSION.length());
		return prefix + SUFFIX;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		final ProcessVariable folderVariable = getActionTask().getWrittenVariables().get(0);
		final IFolder folder = (IFolder)context.getVariableValue(folderVariable, getActionTask());
		try {
			folder.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
