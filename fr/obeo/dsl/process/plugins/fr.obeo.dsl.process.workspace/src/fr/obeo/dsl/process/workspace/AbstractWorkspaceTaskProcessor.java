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
package fr.obeo.dsl.process.workspace;

import fr.obeo.dsl.process.AbstractActionTaskProcessor;
import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.PageVariable;
import fr.obeo.dsl.processworkspace.PartVariable;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.processworkspace.WindowVariable;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceClosed;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceContentChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceDescriptionChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceOpened;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;
import fr.obeo.dsl.workspace.listener.change.workbench.AbstractPageChange;
import fr.obeo.dsl.workspace.listener.change.workbench.AbstractPartChange;
import fr.obeo.dsl.workspace.listener.change.workbench.AbstractWindowChange;
import fr.obeo.dsl.workspace.listener.change.workbench.PageActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PageClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.PageOpened;
import fr.obeo.dsl.workspace.listener.change.workbench.PartActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PartBroughtToTop;
import fr.obeo.dsl.workspace.listener.change.workbench.PartClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.PartDeactivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PartHidden;
import fr.obeo.dsl.workspace.listener.change.workbench.PartInputChanged;
import fr.obeo.dsl.workspace.listener.change.workbench.PartOpened;
import fr.obeo.dsl.workspace.listener.change.workbench.PartVisible;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowDeactivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowOpened;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * Abstract implementation of {@link fr.obeo.dsl.process.ActionTask ActionTask#getInstanceClassName()} for
 * workspace tasks.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractWorkspaceTaskProcessor extends AbstractActionTaskProcessor implements IWorkspaceTaskProcessor {

	/**
	 * Constructor.
	 * 
	 * @param actionTask
	 *            the {@link ActionTask} definition
	 */
	public AbstractWorkspaceTaskProcessor(ActionTask actionTask) {
		super(actionTask);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IActionTaskProcessor#validate(fr.obeo.dsl.process.ProcessContext)
	 * @see IWorkspaceTaskProcessor#validate(ProcessContext, fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void validate(ProcessContext context) {
		// nothing to do here.
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.workspace.IWorkspaceTaskProcessor#validate(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void validate(ProcessContext context, IChange<?> change) {
		for (ProcessVariable variable : getActionTask().getWrittenVariables()) {
			if (isFileMatch(change, variable)) {
				fileChanged(context, (AbstractResourceChange)change, (FileVariable)variable);
			} else if (isFolderMatch(change, variable)) {
				folderChanged(context, (AbstractResourceChange)change, (FolderVariable)variable);
			} else if (isProjectMatch(change, variable)) {
				projectChanged(context, (AbstractResourceChange)change, (ProjectVariable)variable);
			} else if (isPartMatch(change, variable)) {
				partChanged(context, (AbstractPartChange)change, (PartVariable)variable);
			} else if (isPageMatch(change, variable)) {
				pageChanged(context, (AbstractPageChange)change, (PageVariable)variable);
			} else if (isWindowMatch(change, variable)) {
				windowChanged(context, (AbstractWindowChange)change, (WindowVariable)variable);
			}
		}
	}

	/**
	 * Tells if the given {@link IChange} and {@link ProcessVariable} match a {@link IFile}.
	 * 
	 * @param change
	 *            the {@link IChange}
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @return <code>true</code> if the given {@link IChange} and {@link ProcessVariable} match a
	 *         {@link IFile}, <code>false</code> otherwise
	 */
	private boolean isFileMatch(IChange<?> change, ProcessVariable variable) {
		return variable instanceof FileVariable && change.getObject() instanceof IFile;
	}

	/**
	 * Tells if the given {@link IChange} and {@link ProcessVariable} match a {@link IFolder}.
	 * 
	 * @param change
	 *            the {@link IChange}
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @return <code>true</code> if the given {@link IChange} and {@link ProcessVariable} match a
	 *         {@link IFolder}, <code>false</code> otherwise
	 */
	private boolean isFolderMatch(IChange<?> change, ProcessVariable variable) {
		return variable instanceof FolderVariable && change.getObject() instanceof IFolder;
	}

	/**
	 * Tells if the given {@link IChange} and {@link ProcessVariable} match a {@link IProject}.
	 * 
	 * @param change
	 *            the {@link IChange}
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @return <code>true</code> if the given {@link IChange} and {@link ProcessVariable} match a
	 *         {@link IProject}, <code>false</code> otherwise
	 */
	private boolean isProjectMatch(IChange<?> change, ProcessVariable variable) {
		return variable instanceof ProjectVariable && change.getObject() instanceof IProject;
	}

	/**
	 * Tells if the given {@link IChange} and {@link ProcessVariable} match a
	 * {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart}.
	 * 
	 * @param change
	 *            the {@link IChange}
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @return <code>true</code> if the given {@link IChange} and {@link ProcessVariable} match a
	 *         {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart}, <code>false</code> otherwise
	 */
	private boolean isPartMatch(IChange<?> change, ProcessVariable variable) {
		return variable instanceof PartVariable && change instanceof AbstractPartChange;
	}

	/**
	 * Tells if the given {@link IChange} and {@link ProcessVariable} match a
	 * {@link org.eclipse.ui.IWorkbenchPage IWorkbenchPage}.
	 * 
	 * @param change
	 *            the {@link IChange}
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @return <code>true</code> if the given {@link IChange} and {@link ProcessVariable} match a
	 *         {@link org.eclipse.ui.IWorkbenchPage IWorkbenchPage}, <code>false</code> otherwise
	 */
	private boolean isPageMatch(IChange<?> change, ProcessVariable variable) {
		return variable instanceof PageVariable && change instanceof AbstractPageChange;
	}

	/**
	 * Tells if the given {@link IChange} and {@link ProcessVariable} match a
	 * {@link org.eclipse.ui.IWorkbenchWindow IWorkbenchWindow}.
	 * 
	 * @param change
	 *            the {@link IChange}
	 * @param variable
	 *            the {@link ProcessVariable}
	 * @return <code>true</code> if the given {@link IChange} and {@link ProcessVariable} match a
	 *         {@link org.eclipse.ui.IWorkbenchWindow IWorkbenchWindow}, <code>false</code> otherwise
	 */
	private boolean isWindowMatch(IChange<?> change, ProcessVariable variable) {
		return variable instanceof WindowVariable && change instanceof AbstractWindowChange;
	}

	/**
	 * Handles change for {@link IFile}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractResourceChange}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	private void fileChanged(ProcessContext context, AbstractResourceChange change, FileVariable variable) {
		if (change.getObject().equals(context.getVariableValue(variable, getActionTask()))) {
			knownFileChanged(context, change, variable);
		} else {
			unknownFileChanged(context, change, variable);
		}
	}

	/**
	 * Handles change for known {@link IFile}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPartChange}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	private void knownFileChanged(ProcessContext context, AbstractResourceChange change, FileVariable variable) {
		if (change instanceof ResourceAdded) {
			knownFileAdded(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceClosed) {
			knownFileClosed(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceContentChanged) {
			knownFileContentChanged(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceDescriptionChanged) {
			knownFileDescriptionChanged(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceMoved) {
			knownFileMoved(context, (IFile)change.getObject(), variable, (IFile)((ResourceMoved)change)
					.getDestination());
		} else if (change instanceof ResourceOpened) {
			knownFileOpened(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceRemoved) {
			knownFileRemoved(context, (IFile)change.getObject(), variable);
		}
	}

	/**
	 * A known {@link IFile} added.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void knownFileAdded(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFile} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void knownFileClosed(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFile} content changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void knownFileContentChanged(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFile} description changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void knownFileDescriptionChanged(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFile} moved.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 * @param destination
	 *            the {@link IFile} destination
	 */
	protected void knownFileMoved(ProcessContext context, IFile file, FileVariable variable, IFile destination) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFile} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void knownFileOpened(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFile} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void knownFileRemoved(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for unknown {@link IFile}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPartChange}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	private void unknownFileChanged(ProcessContext context, AbstractResourceChange change,
			FileVariable variable) {
		if (change instanceof ResourceAdded) {
			unknownFileAdded(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceClosed) {
			unknownFileClosed(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceContentChanged) {
			unknownFileContentChanged(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceDescriptionChanged) {
			unknownFileDescriptionChanged(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceMoved) {
			unknownFileMoved(context, (IFile)change.getObject(), variable, (IFile)((ResourceMoved)change)
					.getDestination());
		} else if (change instanceof ResourceOpened) {
			unknownFileOpened(context, (IFile)change.getObject(), variable);
		} else if (change instanceof ResourceRemoved) {
			unknownFileRemoved(context, (IFile)change.getObject(), variable);
		}
	}

	/**
	 * An unknown {@link IFile} added.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void unknownFileAdded(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFile} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void unknownFileClosed(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFile} content changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void unknownFileContentChanged(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFile} description changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void unknownFileDescriptionChanged(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFile} moved.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 * @param destination
	 *            the {@link IFile} destination
	 */
	protected void unknownFileMoved(ProcessContext context, IFile file, FileVariable variable,
			IFile destination) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFile} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void unknownFileOpened(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFile} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param file
	 *            the {@link IFile}
	 * @param variable
	 *            the {@link FileVariable}
	 */
	protected void unknownFileRemoved(ProcessContext context, IFile file, FileVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for {@link IFolder}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractResourceChange}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	private void folderChanged(ProcessContext context, AbstractResourceChange change, FolderVariable variable) {
		if (change.getObject().equals(context.getVariableValue(variable, getActionTask()))) {
			knownFolderChanged(context, change, variable);
		} else {
			unknownFolderChanged(context, change, variable);
		}
	}

	/**
	 * Handles change for known {@link IFolder}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPartChange}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	private void knownFolderChanged(ProcessContext context, AbstractResourceChange change,
			FolderVariable variable) {
		if (change instanceof ResourceAdded) {
			knownFolderAdded(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceClosed) {
			knownFolderClosed(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceContentChanged) {
			knownFolderContentChanged(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceDescriptionChanged) {
			knownFolderDescriptionChanged(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceMoved) {
			knownFolderMoved(context, (IFolder)change.getObject(), variable, (IFolder)((ResourceMoved)change)
					.getDestination());
		} else if (change instanceof ResourceOpened) {
			knownFolderOpened(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceRemoved) {
			knownFolderRemoved(context, (IFolder)change.getObject(), variable);
		}
	}

	/**
	 * A known {@link IFolder} added.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void knownFolderAdded(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFolder} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void knownFolderClosed(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFolder} content changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void knownFolderContentChanged(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFolder} description changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void knownFolderDescriptionChanged(ProcessContext context, IFolder folder,
			FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFolder} moved.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 * @param destination
	 *            the {@link IFolder} destination
	 */
	protected void knownFolderMoved(ProcessContext context, IFolder folder, FolderVariable variable,
			IFolder destination) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFolder} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void knownFolderOpened(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IFolder} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void knownFolderRemoved(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for unknown {@link IFolder}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPartChange}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	private void unknownFolderChanged(ProcessContext context, AbstractResourceChange change,
			FolderVariable variable) {
		if (change instanceof ResourceAdded) {
			unknownFolderAdded(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceClosed) {
			unknownFolderClosed(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceContentChanged) {
			unknownFolderContentChanged(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceDescriptionChanged) {
			unknownFolderDescriptionChanged(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceMoved) {
			unknownFolderMoved(context, (IFolder)change.getObject(), variable,
					(IFolder)((ResourceMoved)change).getDestination());
		} else if (change instanceof ResourceOpened) {
			unknownFolderOpened(context, (IFolder)change.getObject(), variable);
		} else if (change instanceof ResourceRemoved) {
			unknownFolderRemoved(context, (IFolder)change.getObject(), variable);
		}
	}

	/**
	 * An unknown {@link IFolder} added.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void unknownFolderAdded(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFolder} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void unknownFolderClosed(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFolder} content changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void unknownFolderContentChanged(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFolder} description changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void unknownFolderDescriptionChanged(ProcessContext context, IFolder folder,
			FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFolder} moved.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 * @param destination
	 *            the {@link IFolder} destination
	 */
	protected void unknownFolderMoved(ProcessContext context, IFolder folder, FolderVariable variable,
			IFolder destination) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFolder} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void unknownFolderOpened(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IFolder} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param folder
	 *            the {@link IFolder}
	 * @param variable
	 *            the {@link FolderVariable}
	 */
	protected void unknownFolderRemoved(ProcessContext context, IFolder folder, FolderVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for {@link IProject}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractResourceChange}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	private void projectChanged(ProcessContext context, AbstractResourceChange change,
			ProjectVariable variable) {
		if (change.getObject().equals(context.getVariableValue(variable, getActionTask()))) {
			knownProjectChanged(context, change, variable);
		} else {
			unknownProjectChanged(context, change, variable);
		}
	}

	/**
	 * Handles change for known {@link IProject}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPartChange}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	private void knownProjectChanged(ProcessContext context, AbstractResourceChange change,
			ProjectVariable variable) {
		if (change instanceof ResourceAdded) {
			knownProjectAdded(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceClosed) {
			knownProjectClosed(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceContentChanged) {
			knownProjectContentChanged(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceDescriptionChanged) {
			knownProjectDescriptionChanged(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceMoved) {
			knownProjectMoved(context, (IProject)change.getObject(), variable,
					(IProject)((ResourceMoved)change).getDestination());
		} else if (change instanceof ResourceOpened) {
			knownProjectOpened(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceRemoved) {
			knownProjectRemoved(context, (IProject)change.getObject(), variable);
		}
	}

	/**
	 * A known {@link IProject} added.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void knownProjectAdded(ProcessContext context, IProject project, ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IProject} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void knownProjectClosed(ProcessContext context, IProject project, ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IProject} content changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void knownProjectContentChanged(ProcessContext context, IProject project,
			ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IProject} description changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void knownProjectDescriptionChanged(ProcessContext context, IProject project,
			ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IProject} moved.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 * @param destination
	 *            the {@link IProject} destination
	 */
	protected void knownProjectMoved(ProcessContext context, IProject project, ProjectVariable variable,
			IProject destination) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IProject} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void knownProjectOpened(ProcessContext context, IProject project, ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IProject} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void knownProjectRemoved(ProcessContext context, IProject project, ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for unknown {@link IProject}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPartChange}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	private void unknownProjectChanged(ProcessContext context, AbstractResourceChange change,
			ProjectVariable variable) {
		if (change instanceof ResourceAdded) {
			unknownProjectAdded(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceClosed) {
			unknownProjectClosed(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceContentChanged) {
			unknownProjectContentChanged(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceDescriptionChanged) {
			unknownProjectDescriptionChanged(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceMoved) {
			unknownProjectMoved(context, (IProject)change.getObject(), variable,
					(IProject)((ResourceMoved)change).getDestination());
		} else if (change instanceof ResourceOpened) {
			unknownProjectOpened(context, (IProject)change.getObject(), variable);
		} else if (change instanceof ResourceRemoved) {
			unknownProjectRemoved(context, (IProject)change.getObject(), variable);
		}
	}

	/**
	 * An unknown {@link IProject} added.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void unknownProjectAdded(ProcessContext context, IProject project, ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IProject} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void unknownProjectClosed(ProcessContext context, IProject project, ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IProject} content changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void unknownProjectContentChanged(ProcessContext context, IProject project,
			ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IProject} description changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void unknownProjectDescriptionChanged(ProcessContext context, IProject project,
			ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IProject} moved.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 * @param destination
	 *            the {@link IProject} destination
	 */
	protected void unknownProjectMoved(ProcessContext context, IProject project, ProjectVariable variable,
			IProject destination) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IProject} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void unknownProjectOpened(ProcessContext context, IProject project, ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IProject} removed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param project
	 *            the {@link IProject}
	 * @param variable
	 *            the {@link ProjectVariable}
	 */
	protected void unknownProjectRemoved(ProcessContext context, IProject project, ProjectVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPageChange}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	private void partChanged(ProcessContext context, AbstractPartChange change, PartVariable variable) {
		if (change.getObject().equals(context.getVariableValue(variable, getActionTask()))) {
			knownPartChanged(context, change, variable);
		} else {
			unknownPartChanged(context, change, variable);
		}
	}

	/**
	 * Handles change for known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPartChange}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	private void knownPartChanged(ProcessContext context, AbstractPartChange change, PartVariable variable) {
		if (change instanceof PartActivated) {
			knownPartActivated(context, change.getObject(), variable);
		} else if (change instanceof PartBroughtToTop) {
			knownPartBroughtToTop(context, change.getObject(), variable);
		} else if (change instanceof PartClosed) {
			knownPartClosed(context, change.getObject(), variable);
		} else if (change instanceof PartDeactivated) {
			knownPartDeactivated(context, change.getObject(), variable);
		} else if (change instanceof PartHidden) {
			knownPartHidden(context, change.getObject(), variable);
		} else if (change instanceof PartInputChanged) {
			knownPartPartInputChanged(context, change.getObject(), variable);
		} else if (change instanceof PartOpened) {
			knownPartOpened(context, change.getObject(), variable);
		} else if (change instanceof PartVisible) {
			knownPartVisible(context, change.getObject(), variable);
		}
	}

	/**
	 * A known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} activated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void knownPartActivated(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} brought to top.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void knownPartBroughtToTop(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void knownPartClosed(ProcessContext context, IWorkbenchPartReference part, PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} deactivated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void knownPartDeactivated(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} hidden.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void knownPartHidden(ProcessContext context, IWorkbenchPartReference part, PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} input changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void knownPartPartInputChanged(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void knownPartOpened(ProcessContext context, IWorkbenchPartReference part, PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} is visible.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void knownPartVisible(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPartChange}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	private void unknownPartChanged(ProcessContext context, AbstractPartChange change, PartVariable variable) {
		if (change instanceof PartActivated) {
			unknownPartActivated(context, change.getObject(), variable);
		} else if (change instanceof PartBroughtToTop) {
			unknownPartBroughtToTop(context, change.getObject(), variable);
		} else if (change instanceof PartClosed) {
			unknownPartClosed(context, change.getObject(), variable);
		} else if (change instanceof PartDeactivated) {
			unknownPartDeactivated(context, change.getObject(), variable);
		} else if (change instanceof PartHidden) {
			unknownPartHidden(context, change.getObject(), variable);
		} else if (change instanceof PartInputChanged) {
			unknownPartPartInputChanged(context, change.getObject(), variable);
		} else if (change instanceof PartOpened) {
			unknownPartOpened(context, change.getObject(), variable);
		} else if (change instanceof PartVisible) {
			unknownPartVisible(context, change.getObject(), variable);
		}
	}

	/**
	 * An unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} activated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void unknownPartActivated(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} brought to top.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void unknownPartBroughtToTop(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void unknownPartClosed(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} deactivated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void unknownPartDeactivated(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} hidden.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void unknownPartHidden(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} input changed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void unknownPartPartInputChanged(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void unknownPartOpened(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link org.eclipse.ui.IWorkbenchPart IWorkbenchPart} is visible.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param part
	 *            the {@link IWorkbenchPartReference}
	 * @param variable
	 *            the {@link PartVariable}
	 */
	protected void unknownPartVisible(ProcessContext context, IWorkbenchPartReference part,
			PartVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for {@link org.eclipse.ui.IWorkbenchPage IWorkbenchPage}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPageChange}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	private void pageChanged(ProcessContext context, AbstractPageChange change, PageVariable variable) {
		if (change.getObject().equals(context.getVariableValue(variable, getActionTask()))) {
			knownPageChanged(context, change, variable);
		} else {
			unknownPageChanged(context, change, variable);
		}
	}

	/**
	 * Handles change for known {@link org.eclipse.ui.IWorkbenchPage IWorkbenchPage}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPageChange}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	private void knownPageChanged(ProcessContext context, AbstractPageChange change, PageVariable variable) {
		if (change instanceof PageActivated) {
			knownPageActivated(context, change.getObject(), variable);
		} else if (change instanceof PageClosed) {
			knownPageClosed(context, change.getObject(), variable);
		} else if (change instanceof PageOpened) {
			knownPageOpened(context, change.getObject(), variable);
		}
	}

	/**
	 * A known {@link IWorkbenchPage} activated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param page
	 *            the {@link IWorkbenchPage}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	protected void knownPageActivated(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IWorkbenchPage} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param page
	 *            the {@link IWorkbenchPage}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	protected void knownPageClosed(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IWorkbenchPage} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param page
	 *            the {@link IWorkbenchPage}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	protected void knownPageOpened(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for unknown {@link org.eclipse.ui.IWorkbenchPage IWorkbenchPage}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractPageChange}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	private void unknownPageChanged(ProcessContext context, AbstractPageChange change, PageVariable variable) {
		if (change instanceof PageActivated) {
			unknownPageActivated(context, change.getObject(), variable);
		} else if (change instanceof PageClosed) {
			unknownPageClosed(context, change.getObject(), variable);
		} else if (change instanceof PageOpened) {
			unknownPageOpened(context, change.getObject(), variable);
		}
	}

	/**
	 * An unknown {@link IWorkbenchPage} activated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param page
	 *            the {@link IWorkbenchPage}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	protected void unknownPageActivated(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IWorkbenchPage} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param page
	 *            the {@link IWorkbenchPage}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	protected void unknownPageClosed(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IWorkbenchPage} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param page
	 *            the {@link IWorkbenchPage}
	 * @param variable
	 *            the {@link PageVariable}
	 */
	protected void unknownPageOpened(ProcessContext context, IWorkbenchPage page, PageVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for {@link org.eclipse.ui.IWorkbenchWindow IWorkbenchWindow}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractWindowChange}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	private void windowChanged(ProcessContext context, AbstractWindowChange change, WindowVariable variable) {
		if (change.getObject().equals(context.getVariableValue(variable, getActionTask()))) {
			knownWindowChanged(context, change, variable);
		} else {
			unknownWindowChanged(context, change, variable);
		}
	}

	/**
	 * Handles change for known {@link org.eclipse.ui.IWorkbenchWindow IWorkbenchWindow}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractWindowChange}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	private void knownWindowChanged(ProcessContext context, AbstractWindowChange change,
			WindowVariable variable) {
		if (change instanceof WindowActivated) {
			knownWindowActivated(context, change.getObject(), variable);
		} else if (change instanceof WindowClosed) {
			knownWindowClosed(context, change.getObject(), variable);
		} else if (change instanceof WindowDeactivated) {
			knownWindowDeactivated(context, change.getObject(), variable);
		} else if (change instanceof WindowOpened) {
			knownWindowOpened(context, change.getObject(), variable);
		}
	}

	/**
	 * A known {@link IWorkbenchWindow} activated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	protected void knownWindowActivated(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IWorkbenchWindow} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	protected void knownWindowClosed(ProcessContext context, IWorkbenchWindow window, WindowVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IWorkbenchWindow} deactivated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	protected void knownWindowDeactivated(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * A known {@link IWorkbenchWindow} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	protected void knownWindowOpened(ProcessContext context, IWorkbenchWindow window, WindowVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * Handles change for unknown {@link org.eclipse.ui.IWorkbenchWindow IWorkbenchWindow}.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param change
	 *            the {@link AbstractWindowChange}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	private void unknownWindowChanged(ProcessContext context, AbstractWindowChange change,
			WindowVariable variable) {
		if (change instanceof WindowActivated) {
			unknownWindowActivated(context, change.getObject(), variable);
		} else if (change instanceof WindowClosed) {
			unknownWindowClosed(context, change.getObject(), variable);
		} else if (change instanceof WindowDeactivated) {
			unknownWindowDeactivated(context, change.getObject(), variable);
		} else if (change instanceof WindowOpened) {
			unknownWindowOpened(context, change.getObject(), variable);
		}
	}

	/**
	 * An unknown {@link IWorkbenchWindow} activated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	protected void unknownWindowActivated(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IWorkbenchWindow} closed.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	protected void unknownWindowClosed(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IWorkbenchWindow} deactivated.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	protected void unknownWindowDeactivated(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		// should be implemented by sub classes
	}

	/**
	 * An unknown {@link IWorkbenchWindow} opened.
	 * 
	 * @param context
	 *            the {@link ProcessContext}
	 * @param window
	 *            the {@link IWorkbenchWindow}
	 * @param variable
	 *            the {@link WindowVariable}
	 */
	protected void unknownWindowOpened(ProcessContext context, IWorkbenchWindow window,
			WindowVariable variable) {
		// should be implemented by sub classes
	}

}
