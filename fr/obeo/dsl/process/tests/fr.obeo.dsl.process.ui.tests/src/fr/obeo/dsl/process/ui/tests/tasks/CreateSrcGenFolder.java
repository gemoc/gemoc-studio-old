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
import fr.obeo.dsl.processworkspace.FolderVariable;

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

	@Override
	protected void knownFolderRemoved(ProcessContext context, IFolder folder, FolderVariable variable) {
		context.setVariableValue(variable, null, getActionTask());
		context.setUndone(getActionTask(), folder.getName() + " removed.");
	}

	@Override
	protected void knownFolderClosed(ProcessContext context, IFolder folder, FolderVariable variable) {
		context.setVariableValue(variable, null, getActionTask());
		context.setUndone(getActionTask(), folder.getName() + " closed.");
	}

	@Override
	protected void knownFolderMoved(ProcessContext context, IFolder folder, FolderVariable variable,
			IFolder destination) {
		context.setVariableValue(variable, null, getActionTask());
		context.setUndone(getActionTask(), folder.getName() + " moved to " + destination.getName() + ".");
	}

	@Override
	protected void unknownFolderAdded(ProcessContext context, IFolder folder, FolderVariable variable) {
		final ProcessVariable fileVariable = getActionTask().getObservedVariables().get(0);
		final IFile file = (IFile)context.getVariableValue(fileVariable, getActionTask());
		final String folderName = getFolderName(file);
		if (folder.getName().equals(folderName) && folder.getParent().equals(file.getParent())) {
			context.setVariableValue(variable, folder, getActionTask());
			context.setDone(getActionTask(), folder);
		}
	}

	@Override
	protected void unknownFolderOpened(ProcessContext context, IFolder folder, FolderVariable variable) {
		final ProcessVariable fileVariable = getActionTask().getObservedVariables().get(0);
		final IFile file = (IFile)context.getVariableValue(fileVariable, getActionTask());
		final String folderName = getFolderName(file);
		if (folder.getName().equals(folderName) && folder.getParent().equals(file.getParent())) {
			context.setVariableValue(variable, folder, getActionTask());
			context.setDone(getActionTask(), folder);
		}
	}

	@Override
	protected void unknownFolderMoved(ProcessContext context, IFolder folder, FolderVariable variable,
			IFolder destination) {
		final ProcessVariable fileVariable = getActionTask().getObservedVariables().get(0);
		final IFile file = (IFile)context.getVariableValue(fileVariable, getActionTask());
		final String folderName = getFolderName(file);
		if (destination.getName().equals(folderName) && folder.getParent().equals(file.getParent())) {
			context.setVariableValue(variable, destination, getActionTask());
			context.setDone(getActionTask(), destination);
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
