package org.gemoc.gemoc_commons.core.resources;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.internal.ui.wizards.tools.ConvertProjectToPluginOperation;

public class Project {

	
	/**
	 * Create a folder in the project.
	 * Do nothing if folder already exists.
	 * @param project
	 * @param nameOrPath
	 * @param monitor
	 * @return 
	 * @throws CoreException
	 */
	public static IFolder createFolder(IProject project, String nameOrPath, IProgressMonitor monitor) throws CoreException {
		return createFolder(project, new Path(nameOrPath), monitor);
	}

	public static IFolder createFolder(IProject project, IPath path, IProgressMonitor monitor) throws CoreException {
		IFolder folder = project.getFolder(path);
		if (!folder.exists()) {
			if (path.segmentCount() > 1) {
				IPath currentFolderPath = new Path("");
				for (int i=0; i<path.segmentCount()-1; i++) {
					currentFolderPath = currentFolderPath.append(path.segment(i));
					createFolder(project, currentFolderPath, monitor);
				}				
			}
			folder.create(true, true, monitor);
		}
		return folder;
	}

	/**
	 * Create a file in the project with default content.
	 * Do nothing if file already exists.
	 * @param project
	 * @param nameOrPath
	 * @param content
	 * @param monitor
	 * @return
	 * @throws CoreException
	 */
	public static IFile createFile(IProject project, String nameOrPath, String content, IProgressMonitor monitor) throws CoreException {
		ByteArrayInputStream contentStream = new ByteArrayInputStream(content.getBytes());
		return createFile(project, new Path(nameOrPath), contentStream, monitor);
	}
	
	/**
	 * Create a file in the project with default content.
	 * Do nothing if file already exists.
	 * @param project
	 * @param nameOrPath
	 * @param contentStream
	 * @param monitor
	 * @return
	 * @throws CoreException
	 */
	public static IFile createFile(IProject project, String nameOrPath, InputStream contentStream, IProgressMonitor monitor) throws CoreException {
		return createFile(project, new Path(nameOrPath), contentStream, monitor);
	}

	/**
	 * Create a file in the project with default content.
	 * Do nothing if file already exists.
	 * @param project
	 * @param path
	 * @param contentStream
	 * @param monitor
	 * @return
	 * @throws CoreException
	 */
	public static IFile createFile(IProject project, IPath path, InputStream contentStream, IProgressMonitor monitor) throws CoreException {
		IFile file = project.getFile(path);
		return createFile(project, file, contentStream, monitor);
	}
	
	public static IFile createFile(IProject project, IFile file, String content) throws CoreException {
		return createFile(project, file, content, new NullProgressMonitor());
	}

	public static IFile createFile(IProject project, IFile file, String content, IProgressMonitor monitor) throws CoreException {
		ByteArrayInputStream contentStream = new ByteArrayInputStream(content.getBytes());
		return createFile(project, file, contentStream, new NullProgressMonitor());
	}

	public static IFile createFile(IProject project, IFile file, InputStream contentStream, IProgressMonitor monitor) throws CoreException {
		if (!file.exists()) {
			IPath path = file.getProjectRelativePath();
			if (path.segmentCount() > 1) {
				IPath currentFolderPath = new Path("");
				for (int i=0; i<path.segmentCount()-1; i++) {
					currentFolderPath = currentFolderPath.append(path.segment(i));
					createFolder(project, currentFolderPath, monitor);
				}				
			}
			file.create(contentStream, true, monitor);
		}
		return file;
	}
	
	public static void convertToPlugin(IProject project) throws CoreException, InvocationTargetException, InterruptedException {
		IRunnableWithProgress convertOperation = new ConvertProjectToPluginOperation(new IProject[]{project}, false);
		convertOperation.run(new NullProgressMonitor());
	}	
	
	public static void addNature(IProject project, String natureId) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		if (!project.hasNature(natureId)) {
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 1, natures.length);
			newNatures[0] = natureId;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		}
	}


}
