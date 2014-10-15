package org.gemoc.commons.eclipse.ui;

import java.io.File;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
import org.gemoc.commons.eclipse.ui.dialogs.SelectAnyIFileDialog;
import org.gemoc.commons.eclipse.ui.dialogs.SelectSpecificFileDialog;

public class OpenEditor {

	public static void openManifestForProject(IProject project) {
		File fileToOpen = new File(project.getFile("META-INF/MANIFEST.MF")
				.getLocation().toOSString());
		if (fileToOpen.exists() && fileToOpen.isFile()) {
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(
					fileToOpen.toURI());
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			try {
				IDE.openEditorOnFileStore(page, fileStore);
			} catch (PartInitException e) {
				// Put your exception handler here if you wish to
			}
		} else {
			// Do something if the file does not exist
		}
	}
	public static void openIFile(IFile iFile) {
		File fileToOpen = new File(iFile.getLocation().toOSString());
		if (fileToOpen.exists() && fileToOpen.isFile()) {
			IFileStore fileStore = EFS.getLocalFileSystem().getStore(
					fileToOpen.toURI());
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			try {
				IDE.openEditorOnFileStore(page, fileStore);
			} catch (PartInitException e) {
				// Put your exception handler here if you wish to
			}
		} else {
			// Do something if the file does not exist
		}
	}
	
	public static void openPossibleFileInProject(IProject project, String searchedFilePattern) {
		
		// search file to open in project
		SelectAnyIFileDialog fileFinderDialog = new SelectAnyIFileDialog(project);
		
		fileFinderDialog.setPattern(searchedFilePattern);
		if (fileFinderDialog.open() == Dialog.OK) {
			File fileToOpen = new File(((IFile) fileFinderDialog.getResult()[0]).getLocation().toOSString());
			if (fileToOpen.exists() && fileToOpen.isFile()) {
				IFileStore fileStore = EFS.getLocalFileSystem().getStore(
						fileToOpen.toURI());
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();

				try {
					IDE.openEditorOnFileStore(page, fileStore);
				} catch (PartInitException e) {
					// Put your exception handler here if you wish to
				}
			} else {
				// Do something if the file does not exist
			}
		}
		
		
		
	}
}
