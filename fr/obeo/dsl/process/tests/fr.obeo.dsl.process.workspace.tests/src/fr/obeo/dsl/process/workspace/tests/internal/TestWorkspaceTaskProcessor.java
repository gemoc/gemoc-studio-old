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
package fr.obeo.dsl.process.workspace.tests.internal;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.workspace.AbstractWorkspaceTaskProcessor;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.PageVariable;
import fr.obeo.dsl.processworkspace.PartVariable;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.processworkspace.WindowVariable;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * Test implementation of {@link AbstractWorkspaceTaskProcessor}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TestWorkspaceTaskProcessor extends AbstractWorkspaceTaskProcessor {

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileAdded(ProcessContext, IFile, FileVariable)}.
	 */
	private int knownFileAdded;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileClosed(ProcessContext, IFile, FileVariable)}.
	 */
	private int knownFileClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileContentChanged(ProcessContext, IFile, FileVariable)}.
	 */
	private int knownFileContentChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileDescriptionChanged(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	private int knownFileDescriptionChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileMoved(ProcessContext, IFile, FileVariable, IFile)}.
	 */
	private int knownFileMoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileOpened(ProcessContext, IFile, FileVariable)}.
	 */
	private int knownFileOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileRemoved(ProcessContext, IFile, FileVariable)}.
	 */
	private int knownFileRemoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderAdded(ProcessContext, IFolder, FolderVariable)}.
	 */
	private int knownFolderAdded;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileAdded(ProcessContext, IFile, FileVariable)}.
	 */
	private int unknownFileAdded;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileClosed(ProcessContext, IFile, FileVariable)}.
	 */
	private int unknownFileClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileContentChanged(ProcessContext, IFile, FileVariable)}.
	 */
	private int unknownFileContentChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileDescriptionChanged(ProcessContext, IFile, FileVariable)}
	 * .
	 */
	private int unknownFileDescriptionChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileMoved(ProcessContext, IFile, FileVariable, IFile)}.
	 */
	private int unknownFileMoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileOpened(ProcessContext, IFile, FileVariable)}.
	 */
	private int unknownFileOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileRemoved(ProcessContext, IFile, FileVariable)}.
	 */
	private int unknownFileRemoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderClosed(ProcessContext, IFolder, FolderVariable)}.
	 */
	private int knownFolderClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderContentChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	private int knownFolderContentChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderDescriptionChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	private int knownFolderDescriptionChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderMoved(ProcessContext, IFolder, FolderVariable, IFolder)}
	 * .
	 */
	private int knownFolderMoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderOpened(ProcessContext, IFolder, FolderVariable)}.
	 */
	private int knownFolderOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderRemoved(ProcessContext, IFolder, FolderVariable)}.
	 */
	private int knownFolderRemoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderAdded(ProcessContext, IFolder, FolderVariable)}.
	 */
	private int unknownFolderAdded;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderClosed(ProcessContext, IFolder, FolderVariable)}.
	 */
	private int unknownFolderClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderContentChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	private int unknownFolderContentChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderDescriptionChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 */
	private int unknownFolderDescriptionChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderMoved(ProcessContext, IFolder, FolderVariable, IFolder)}
	 * .
	 */
	private int unknownFolderMoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderOpened(ProcessContext, IFolder, FolderVariable)}.
	 */
	private int unknownFolderOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderRemoved(ProcessContext, IFolder, FolderVariable)}.
	 */
	private int unknownFolderRemoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectAdded(ProcessContext, IProject, ProjectVariable)}.
	 */
	private int knownProjectAdded;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectClosed(ProcessContext, IProject, ProjectVariable)}.
	 */
	private int knownProjectClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectContentChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	private int knownProjectContentChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectDescriptionChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	private int knownProjectDescriptionChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectMoved(ProcessContext, IProject, ProjectVariable, IProject)}
	 * .
	 */
	private int knownProjectMoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectOpened(ProcessContext, IProject, ProjectVariable)}.
	 */
	private int knownProjectOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectRemoved(ProcessContext, IProject, ProjectVariable)}.
	 */
	private int knownProjectRemoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectAdded(ProcessContext, IProject, ProjectVariable)}.
	 */
	private int unknownProjectAdded;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectClosed(ProcessContext, IProject, ProjectVariable)}.
	 */
	private int unknownProjectClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectContentChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	private int unknownProjectContentChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectDescriptionChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	private int unknownProjectDescriptionChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectMoved(ProcessContext, IProject, ProjectVariable, IProject)}
	 * .
	 */
	private int unknownProjectMoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectOpened(ProcessContext, IProject, ProjectVariable)}.
	 */
	private int unknownProjectOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectRemoved(ProcessContext, IProject, ProjectVariable)}
	 * .
	 */
	private int unknownProjectRemoved;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartActivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int knownPartActivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartBroughtToTop(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int knownPartBroughtToTop;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartClosed(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int knownPartClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartDeactivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int knownPartDeactivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartHidden(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int knownPartHidden;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartPartInputChanged(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int knownPartPartInputChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartOpened(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int knownPartOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartVisible(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int knownPartVisible;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartActivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int unknownPartActivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartBroughtToTop(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int unknownPartBroughtToTop;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartClosed(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int unknownPartClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartDeactivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int unknownPartDeactivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartHidden(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int unknownPartHidden;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartPartInputChanged(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int unknownPartPartInputChanged;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartOpened(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int unknownPartOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartVisible(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 */
	private int unknownPartVisible;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPageActivated(ProcessContext, IWorkbenchPage, PageVariable)}
	 * .
	 */
	private int knownPageActivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPageClosed(ProcessContext, IWorkbenchPage, PageVariable)}.
	 */
	private int knownPageClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPageOpened(ProcessContext, IWorkbenchPage, PageVariable)}.
	 */
	private int knownPageOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPageActivated(ProcessContext, IWorkbenchPage, PageVariable)}
	 * .
	 */
	private int unknownPageActivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPageClosed(ProcessContext, IWorkbenchPage, PageVariable)}.
	 */
	private int unknownPageClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPageOpened(ProcessContext, IWorkbenchPage, PageVariable)}.
	 */
	private int unknownPageOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownWindowActivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 */
	private int knownWindowActivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownWindowClosed(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 */
	private int knownWindowClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownWindowDeactivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 */
	private int knownWindowDeactivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownWindowOpened(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 */
	private int knownWindowOpened;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownWindowActivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 */
	private int unknownWindowActivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownWindowClosed(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 */
	private int unknownWindowClosed;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownWindowDeactivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 */
	private int unknownWindowDeactivated;

	/**
	 * The number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownWindowOpened(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 */
	private int unknownWindowOpened;

	/**
	 * Constructor.
	 * 
	 * @param actionTask
	 *            the {@link ActionTask} definition
	 */
	public TestWorkspaceTaskProcessor(ActionTask actionTask) {
		super(actionTask);
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
		// nothing to do here
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#undoAction(fr.obeo.dsl.process.ProcessContext)
	 */
	public void undoAction(ProcessContext context) {
		// nothing to do here
	}

	@Override
	protected void knownFileAdded(ProcessContext context, IFile file, FileVariable variable) {
		knownFileAdded++;
	}

	@Override
	protected void knownFileClosed(ProcessContext context, IFile file, FileVariable variable) {
		knownFileClosed++;
	}

	@Override
	protected void knownFileContentChanged(ProcessContext context, IFile file, FileVariable variable) {
		knownFileContentChanged++;
	}

	@Override
	protected void knownFileDescriptionChanged(ProcessContext context, IFile file, FileVariable variable) {
		knownFileDescriptionChanged++;
	}

	@Override
	protected void knownFileMoved(ProcessContext context, IFile file, FileVariable variable, IFile destination) {
		knownFileMoved++;
	}

	@Override
	protected void knownFileOpened(ProcessContext context, IFile file, FileVariable variable) {
		knownFileOpened++;
	}

	@Override
	protected void knownFileRemoved(ProcessContext context, IFile file, FileVariable variable) {
		knownFileRemoved++;
	}

	@Override
	protected void knownFolderAdded(ProcessContext context, IFolder folder, FolderVariable variable) {
		knownFolderAdded++;
	}

	@Override
	protected void unknownFileAdded(ProcessContext context, IFile file, FileVariable variable) {
		unknownFileAdded++;
	}

	@Override
	protected void unknownFileClosed(ProcessContext context, IFile file, FileVariable variable) {
		unknownFileClosed++;
	}

	@Override
	protected void unknownFileContentChanged(ProcessContext context, IFile file, FileVariable variable) {
		unknownFileContentChanged++;
	}

	@Override
	protected void unknownFileDescriptionChanged(ProcessContext context, IFile file, FileVariable variable) {
		unknownFileDescriptionChanged++;
	}

	@Override
	protected void unknownFileMoved(ProcessContext context, IFile file, FileVariable variable,
			IFile destination) {
		unknownFileMoved++;
	}

	@Override
	protected void unknownFileOpened(ProcessContext context, IFile file, FileVariable variable) {
		unknownFileOpened++;
	}

	@Override
	protected void unknownFileRemoved(ProcessContext context, IFile file, FileVariable variable) {
		unknownFileRemoved++;
	}

	@Override
	protected void knownFolderClosed(ProcessContext context, IFolder folder, FolderVariable variable) {
		knownFolderClosed++;
	}

	@Override
	protected void knownFolderContentChanged(ProcessContext context, IFolder folder, FolderVariable variable) {
		knownFolderContentChanged++;
	}

	@Override
	protected void knownFolderDescriptionChanged(ProcessContext context, IFolder folder,
			FolderVariable variable) {
		knownFolderDescriptionChanged++;
	}

	@Override
	protected void knownFolderMoved(ProcessContext context, IFolder folder, FolderVariable variable,
			IFolder destination) {
		knownFolderMoved++;
	}

	@Override
	protected void knownFolderOpened(ProcessContext context, IFolder folder, FolderVariable variable) {
		knownFolderOpened++;
	}

	@Override
	protected void knownFolderRemoved(ProcessContext context, IFolder folder, FolderVariable variable) {
		knownFolderRemoved++;
	}

	@Override
	protected void unknownFolderAdded(ProcessContext context, IFolder folder, FolderVariable variable) {
		unknownFolderAdded++;
	}

	@Override
	protected void unknownFolderClosed(ProcessContext context, IFolder folder, FolderVariable variable) {
		unknownFolderClosed++;
	}

	@Override
	protected void unknownFolderContentChanged(ProcessContext context, IFolder folder, FolderVariable variable) {
		unknownFolderContentChanged++;
	}

	@Override
	protected void unknownFolderDescriptionChanged(ProcessContext context, IFolder folder,
			FolderVariable variable) {
		unknownFolderDescriptionChanged++;
	}

	@Override
	protected void unknownFolderMoved(ProcessContext context, IFolder folder, FolderVariable variable,
			IFolder destination) {
		unknownFolderMoved++;
	}

	@Override
	protected void unknownFolderOpened(ProcessContext context, IFolder folder, FolderVariable variable) {
		unknownFolderOpened++;
	}

	@Override
	protected void unknownFolderRemoved(ProcessContext context, IFolder folder, FolderVariable variable) {
		unknownFolderRemoved++;
	}

	@Override
	protected void knownProjectAdded(ProcessContext context, IProject project, ProjectVariable variable) {
		knownProjectAdded++;
	}

	@Override
	protected void knownProjectClosed(ProcessContext context, IProject project, ProjectVariable variable) {
		knownProjectClosed++;
	}

	@Override
	protected void knownProjectContentChanged(ProcessContext context, IProject project,
			ProjectVariable variable) {
		knownProjectContentChanged++;
	}

	@Override
	protected void knownProjectDescriptionChanged(ProcessContext context, IProject project,
			ProjectVariable variable) {
		knownProjectDescriptionChanged++;
	}

	@Override
	protected void knownProjectMoved(ProcessContext context, IProject project, ProjectVariable variable,
			IProject destination) {
		knownProjectMoved++;
	}

	@Override
	protected void knownProjectOpened(ProcessContext context, IProject project, ProjectVariable variable) {
		knownProjectOpened++;
	}

	@Override
	protected void knownProjectRemoved(ProcessContext context, IProject project, ProjectVariable variable) {
		knownProjectRemoved++;
	}

	@Override
	protected void unknownProjectAdded(ProcessContext context, IProject project, ProjectVariable variable) {
		unknownProjectAdded++;
	}

	@Override
	protected void unknownProjectClosed(ProcessContext context, IProject project, ProjectVariable variable) {
		unknownProjectClosed++;
	}

	@Override
	protected void unknownProjectContentChanged(ProcessContext context, IProject project,
			ProjectVariable variable) {
		unknownProjectContentChanged++;
	}

	@Override
	protected void unknownProjectDescriptionChanged(ProcessContext context, IProject project,
			ProjectVariable variable) {
		unknownProjectDescriptionChanged++;
	}

	@Override
	protected void unknownProjectMoved(ProcessContext context, IProject project, ProjectVariable variable,
			IProject destination) {
		unknownProjectMoved++;
	}

	@Override
	protected void unknownProjectOpened(ProcessContext context, IProject project, ProjectVariable variable) {
		unknownProjectOpened++;
	}

	@Override
	protected void unknownProjectRemoved(ProcessContext context, IProject project, ProjectVariable variable) {
		unknownProjectRemoved++;
	}

	@Override
	protected void knownPartActivated(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		knownPartActivated++;
	}

	@Override
	protected void knownPartBroughtToTop(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		knownPartBroughtToTop++;
	}

	@Override
	protected void knownPartClosed(ProcessContext context, IWorkbenchPartReference part, PartVariable variable) {
		knownPartClosed++;
	}

	@Override
	protected void knownPartDeactivated(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		knownPartDeactivated++;
	}

	@Override
	protected void knownPartHidden(ProcessContext context, IWorkbenchPartReference part, PartVariable variable) {
		knownPartHidden++;
	}

	@Override
	protected void knownPartPartInputChanged(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		knownPartPartInputChanged++;
	}

	@Override
	protected void knownPartOpened(ProcessContext context, IWorkbenchPartReference part, PartVariable variable) {
		knownPartOpened++;
	}

	@Override
	protected void knownPartVisible(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		knownPartVisible++;
	}

	@Override
	protected void unknownPartActivated(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		unknownPartActivated++;
	}

	@Override
	protected void unknownPartBroughtToTop(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		unknownPartBroughtToTop++;
	}

	@Override
	protected void unknownPartClosed(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		unknownPartClosed++;
	}

	@Override
	protected void unknownPartDeactivated(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		unknownPartDeactivated++;
	}

	@Override
	protected void unknownPartHidden(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		unknownPartHidden++;
	}

	@Override
	protected void unknownPartPartInputChanged(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		unknownPartPartInputChanged++;
	}

	@Override
	protected void unknownPartOpened(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		unknownPartOpened++;
	}

	@Override
	protected void unknownPartVisible(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		unknownPartVisible++;
	}

	@Override
	protected void knownPageActivated(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		knownPageActivated++;
	}

	@Override
	protected void knownPageClosed(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		knownPageClosed++;
	}

	@Override
	protected void knownPageOpened(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		knownPageOpened++;
	}

	@Override
	protected void unknownPageActivated(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		unknownPageActivated++;
	}

	@Override
	protected void unknownPageClosed(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		unknownPageClosed++;
	}

	@Override
	protected void unknownPageOpened(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		unknownPageOpened++;
	}

	@Override
	protected void knownWindowActivated(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		knownWindowActivated++;
	}

	@Override
	protected void knownWindowClosed(ProcessContext context, IWorkbenchWindow window, WindowVariable variable) {
		knownWindowClosed++;
	}

	@Override
	protected void knownWindowDeactivated(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		knownWindowDeactivated++;
	}

	@Override
	protected void knownWindowOpened(ProcessContext context, IWorkbenchWindow window, WindowVariable variable) {
		knownWindowOpened++;
	}

	@Override
	protected void unknownWindowActivated(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		unknownWindowActivated++;
	}

	@Override
	protected void unknownWindowClosed(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		unknownWindowClosed++;
	}

	@Override
	protected void unknownWindowDeactivated(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		unknownWindowDeactivated++;
	}

	@Override
	protected void unknownWindowOpened(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		unknownWindowOpened++;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileAdded(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFileAdded(ProcessContext, IFile, FileVariable)}.
	 */
	public int getKnownFileAdded() {
		return knownFileAdded;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileClosed(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFileClosed(ProcessContext, IFile, FileVariable)}.
	 */
	public int getKnownFileClosed() {
		return knownFileClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileContentChanged(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFileContentChanged(ProcessContext, IFile, FileVariable)}
	 *         .
	 */
	public int getKnownFileContentChanged() {
		return knownFileContentChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileDescriptionChanged(ProcessContext, IFile, FileVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFileDescriptionChanged(ProcessContext, IFile, FileVariable)}
	 *         .
	 */
	public int getKnownFileDescriptionChanged() {
		return knownFileDescriptionChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileMoved(ProcessContext, IFile, FileVariable, IFile)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFileMoved(ProcessContext, IFile, FileVariable, IFile)}
	 *         .
	 */
	public int getKnownFileMoved() {
		return knownFileMoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileOpened(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFileOpened(ProcessContext, IFile, FileVariable)}.
	 */
	public int getKnownFileOpened() {
		return knownFileOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFileRemoved(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFileRemoved(ProcessContext, IFile, FileVariable)}.
	 */
	public int getKnownFileRemoved() {
		return knownFileRemoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderAdded(ProcessContext, IFolder, FolderVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFolderAdded(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getKnownFolderAdded() {
		return knownFolderAdded;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileAdded(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFileAdded(ProcessContext, IFile, FileVariable)}.
	 */
	public int getUnknownFileAdded() {
		return unknownFileAdded;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileClosed(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFileClosed(ProcessContext, IFile, FileVariable)}.
	 */
	public int getUnknownFileClosed() {
		return unknownFileClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileContentChanged(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFileContentChanged(ProcessContext, IFile, FileVariable)}
	 *         .
	 */
	public int getUnknownFileContentChanged() {
		return unknownFileContentChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileDescriptionChanged(ProcessContext, IFile, FileVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFileDescriptionChanged(ProcessContext, IFile, FileVariable)}
	 *         .
	 */
	public int getUnknownFileDescriptionChanged() {
		return unknownFileDescriptionChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileMoved(ProcessContext, IFile, FileVariable, IFile)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFileMoved(ProcessContext, IFile, FileVariable, IFile)}
	 *         .
	 */
	public int getUnknownFileMoved() {
		return unknownFileMoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileOpened(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFileOpened(ProcessContext, IFile, FileVariable)}.
	 */
	public int getUnknownFileOpened() {
		return unknownFileOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFileRemoved(ProcessContext, IFile, FileVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFileRemoved(ProcessContext, IFile, FileVariable)}.
	 */
	public int getUnknownFileRemoved() {
		return unknownFileRemoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderClosed(ProcessContext, IFolder, FolderVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFolderClosed(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getKnownFolderClosed() {
		return knownFolderClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderContentChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFolderContentChanged(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getKnownFolderContentChanged() {
		return knownFolderContentChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderDescriptionChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFolderDescriptionChanged(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getKnownFolderDescriptionChanged() {
		return knownFolderDescriptionChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderMoved(ProcessContext, IFolder, FolderVariable, IFolder)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFolderMoved(ProcessContext, IFolder, FolderVariable, IFolder)}
	 *         .
	 */
	public int getKnownFolderMoved() {
		return knownFolderMoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderOpened(ProcessContext, IFolder, FolderVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFolderOpened(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getKnownFolderOpened() {
		return knownFolderOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownFolderRemoved(ProcessContext, IFolder, FolderVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownFolderRemoved(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getKnownFolderRemoved() {
		return knownFolderRemoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderAdded(ProcessContext, IFolder, FolderVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFolderAdded(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getUnknownFolderAdded() {
		return unknownFolderAdded;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderClosed(ProcessContext, IFolder, FolderVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFolderClosed(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getUnknownFolderClosed() {
		return unknownFolderClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderContentChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFolderContentChanged(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getUnknownFolderContentChanged() {
		return unknownFolderContentChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderDescriptionChanged(ProcessContext, IFolder, FolderVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFolderDescriptionChanged(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getUnknownFolderDescriptionChanged() {
		return unknownFolderDescriptionChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderMoved(ProcessContext, IFolder, FolderVariable, IFolder)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFolderMoved(ProcessContext, IFolder, FolderVariable, IFolder)}
	 *         .
	 */
	public int getUnknownFolderMoved() {
		return unknownFolderMoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderOpened(ProcessContext, IFolder, FolderVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFolderOpened(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getUnknownFolderOpened() {
		return unknownFolderOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownFolderRemoved(ProcessContext, IFolder, FolderVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownFolderRemoved(ProcessContext, IFolder, FolderVariable)}
	 *         .
	 */
	public int getUnknownFolderRemoved() {
		return unknownFolderRemoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectAdded(ProcessContext, IProject, ProjectVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownProjectAdded(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getKnownProjectAdded() {
		return knownProjectAdded;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectClosed(ProcessContext, IProject, ProjectVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownProjectClosed(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getKnownProjectClosed() {
		return knownProjectClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectContentChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownProjectContentChanged(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getKnownProjectContentChanged() {
		return knownProjectContentChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectDescriptionChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownProjectDescriptionChanged(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getKnownProjectDescriptionChanged() {
		return knownProjectDescriptionChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectMoved(ProcessContext, IProject, ProjectVariable, IProject)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownProjectMoved(ProcessContext, IProject, ProjectVariable, IProject)}
	 *         .
	 */
	public int getKnownProjectMoved() {
		return knownProjectMoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectOpened(ProcessContext, IProject, ProjectVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownProjectOpened(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getKnownProjectOpened() {
		return knownProjectOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownProjectRemoved(ProcessContext, IProject, ProjectVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownProjectRemoved(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getKnownProjectRemoved() {
		return knownProjectRemoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectAdded(ProcessContext, IProject, ProjectVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownProjectAdded(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getUnknownProjectAdded() {
		return unknownProjectAdded;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectClosed(ProcessContext, IProject, ProjectVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownProjectClosed(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getUnknownProjectClosed() {
		return unknownProjectClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectContentChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownProjectContentChanged(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getUnknownProjectContentChanged() {
		return unknownProjectContentChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectDescriptionChanged(ProcessContext, IProject, ProjectVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownProjectDescriptionChanged(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getUnknownProjectDescriptionChanged() {
		return unknownProjectDescriptionChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectMoved(ProcessContext, IProject, ProjectVariable, IProject)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownProjectMoved(ProcessContext, IProject, ProjectVariable, IProject)}
	 *         .
	 */
	public int getUnknownProjectMoved() {
		return unknownProjectMoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectOpened(ProcessContext, IProject, ProjectVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownProjectOpened(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getUnknownProjectOpened() {
		return unknownProjectOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownProjectRemoved(ProcessContext, IProject, ProjectVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownProjectRemoved(ProcessContext, IProject, ProjectVariable)}
	 *         .
	 */
	public int getUnknownProjectRemoved() {
		return unknownProjectRemoved;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartActivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPartActivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getKnownPartActivated() {
		return knownPartActivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartBroughtToTop(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPartBroughtToTop(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getKnownPartBroughtToTop() {
		return knownPartBroughtToTop;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartClosed(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPartClosed(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getKnownPartClosed() {
		return knownPartClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartDeactivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPartDeactivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getKnownPartDeactivated() {
		return knownPartDeactivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartHidden(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPartHidden(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getKnownPartHidden() {
		return knownPartHidden;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartPartInputChanged(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPartPartInputChanged(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getKnownPartPartInputChanged() {
		return knownPartPartInputChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartOpened(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPartOpened(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getKnownPartOpened() {
		return knownPartOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPartVisible(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPartVisible(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getKnownPartVisible() {
		return knownPartVisible;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartActivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPartActivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getUnknownPartActivated() {
		return unknownPartActivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartBroughtToTop(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPartBroughtToTop(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getUnknownPartBroughtToTop() {
		return unknownPartBroughtToTop;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartClosed(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPartClosed(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getUnknownPartClosed() {
		return unknownPartClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartDeactivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPartDeactivated(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getUnknownPartDeactivated() {
		return unknownPartDeactivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartHidden(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPartHidden(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getUnknownPartHidden() {
		return unknownPartHidden;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartPartInputChanged(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPartPartInputChanged(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getUnknownPartPartInputChanged() {
		return unknownPartPartInputChanged;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartOpened(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPartOpened(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getUnknownPartOpened() {
		return unknownPartOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPartVisible(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPartVisible(ProcessContext, IWorkbenchPartReference, PartVariable)}
	 *         .
	 */
	public int getUnknownPartVisible() {
		return unknownPartVisible;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPageActivated(ProcessContext, IWorkbenchPage, PageVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPageActivated(ProcessContext, IWorkbenchPage, PageVariable)}
	 *         .
	 */
	public int getKnownPageActivated() {
		return knownPageActivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPageClosed(ProcessContext, IWorkbenchPage, PageVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPageClosed(ProcessContext, IWorkbenchPage, PageVariable)}
	 *         .
	 */
	public int getKnownPageClosed() {
		return knownPageClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownPageOpened(ProcessContext, IWorkbenchPage, PageVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownPageOpened(ProcessContext, IWorkbenchPage, PageVariable)}
	 *         .
	 */
	public int getKnownPageOpened() {
		return knownPageOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPageActivated(ProcessContext, IWorkbenchPage, PageVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPageActivated(ProcessContext, IWorkbenchPage, PageVariable)}
	 *         .
	 */
	public int getUnknownPageActivated() {
		return unknownPageActivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPageClosed(ProcessContext, IWorkbenchPage, PageVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPageClosed(ProcessContext, IWorkbenchPage, PageVariable)}
	 *         .
	 */
	public int getUnknownPageClosed() {
		return unknownPageClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownPageOpened(ProcessContext, IWorkbenchPage, PageVariable)}.
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownPageOpened(ProcessContext, IWorkbenchPage, PageVariable)}
	 *         .
	 */
	public int getUnknownPageOpened() {
		return unknownPageOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownWindowActivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownWindowActivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 *         .
	 */
	public int getKnownWindowActivated() {
		return knownWindowActivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownWindowClosed(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownWindowClosed(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 *         .
	 */
	public int getKnownWindowClosed() {
		return knownWindowClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownWindowDeactivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownWindowDeactivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 *         .
	 */
	public int getKnownWindowDeactivated() {
		return knownWindowDeactivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#knownWindowOpened(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#knownWindowOpened(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 *         .
	 */
	public int getKnownWindowOpened() {
		return knownWindowOpened;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownWindowActivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownWindowActivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 *         .
	 */
	public int getUnknownWindowActivated() {
		return unknownWindowActivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownWindowClosed(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownWindowClosed(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 *         .
	 */
	public int getUnknownWindowClosed() {
		return unknownWindowClosed;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownWindowDeactivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownWindowDeactivated(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 *         .
	 */
	public int getUnknownWindowDeactivated() {
		return unknownWindowDeactivated;
	}

	/**
	 * Gets the number of call to
	 * {@link AbstractWorkspaceTaskProcessor#unknownWindowOpened(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 * .
	 * 
	 * @return the number of call to
	 *         {@link AbstractWorkspaceTaskProcessor#unknownWindowOpened(ProcessContext, IWorkbenchWindow, WindowVariable)}
	 *         .
	 */
	public int getUnknownWindowOpened() {
		return unknownWindowOpened;
	}

	/**
	 * Gets the total number of calls.
	 * 
	 * @return the total number of calls
	 */
	public int getTotalCalls() {
		int res = 0;

		res += knownFileAdded + knownFileClosed + knownFileContentChanged + knownFileDescriptionChanged
				+ knownFileMoved + knownFileOpened + knownFileRemoved + knownFolderAdded + unknownFileAdded
				+ unknownFileClosed + unknownFileContentChanged + unknownFileDescriptionChanged
				+ unknownFileMoved + unknownFileOpened + unknownFileRemoved + knownFolderClosed
				+ knownFolderContentChanged + knownFolderDescriptionChanged + knownFolderMoved
				+ knownFolderOpened + knownFolderRemoved + unknownFolderAdded + unknownFolderClosed
				+ unknownFolderContentChanged + unknownFolderDescriptionChanged + unknownFolderMoved
				+ unknownFolderOpened + unknownFolderRemoved + knownProjectAdded + knownProjectClosed
				+ knownProjectContentChanged + knownProjectDescriptionChanged + knownProjectMoved
				+ knownProjectOpened + knownProjectRemoved + unknownProjectAdded + unknownProjectClosed
				+ unknownProjectContentChanged + unknownProjectDescriptionChanged + unknownProjectMoved
				+ unknownProjectOpened + unknownProjectRemoved + knownPartActivated + knownPartBroughtToTop
				+ knownPartClosed + knownPartDeactivated + knownPartHidden + knownPartPartInputChanged
				+ knownPartOpened + knownPartVisible + unknownPartActivated + unknownPartBroughtToTop
				+ unknownPartClosed + unknownPartDeactivated + unknownPartHidden
				+ unknownPartPartInputChanged + unknownPartOpened + unknownPartVisible + knownPageActivated
				+ knownPageClosed + knownPageOpened + unknownPageActivated + unknownPageClosed
				+ unknownPageOpened + knownWindowActivated + knownWindowClosed + knownWindowDeactivated
				+ knownWindowOpened + unknownWindowActivated + unknownWindowClosed + unknownWindowDeactivated
				+ unknownWindowOpened;

		return res;
	}

}
