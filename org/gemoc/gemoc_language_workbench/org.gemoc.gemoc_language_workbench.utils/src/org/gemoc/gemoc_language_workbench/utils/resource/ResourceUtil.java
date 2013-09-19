package org.gemoc.gemoc_language_workbench.utils.resource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.gemoc.gemoc_language_workbench.utils.Activator;

public class ResourceUtil {

	/**
	 * Creates a folder and all parent folders if not existing.
	 * Project must exist.
	 * @param folder the folder to create
	 * @param force a flag controlling how to deal with resources that
	 *    are not in sync with the local file system
	 * @param local a flag controlling whether or not the folder will be local
	 *    after the creation
	 * @param monitor the progress monitor
	 * @throws CoreException thrown if the creation failed
	 */
	public static void createFolder(IFolder folder, boolean force, boolean local, IProgressMonitor monitor) throws CoreException {
		if (!folder.exists()) {
			IContainer parent= folder.getParent();
			if (parent instanceof IFolder) {
				createFolder((IFolder)parent, force, local, null);
			}
			folder.create(force, local, monitor);
		}
	}
	
	public static void writeFile(IFile file, String fileContent){

		try {
			InputStream stream = new ByteArrayInputStream(fileContent.getBytes());
			if (file.exists()) {
				file.setContents(stream, true, true, null);
			} else {
				if(!file.getParent().exists()){
					if(file.getParent() instanceof IFolder)
						createFolder((IFolder) file.getParent(), true, true, null);
				}
				file.create(stream, true, null);
			}
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
		
	}
}
