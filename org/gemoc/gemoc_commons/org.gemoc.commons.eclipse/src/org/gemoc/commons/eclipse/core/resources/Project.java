package org.gemoc.commons.eclipse.core.resources;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.JavaCore;

public class Project {

	
	public static IFolder createFolder(IProject project, String nameOrPath) throws CoreException {
		return createFolder(project, nameOrPath, new NullProgressMonitor());
	}

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
		if (!file.exists()) 
		{
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
	
	public static void addJavaNature(IProject project) throws CoreException, IOException 
	{
		if(!project.hasNature(JavaCore.NATURE_ID)){
			JavaCore.create(project);
			addNature(project, JavaCore.NATURE_ID);
			Project.createFolder(project, "src/main/java", new NullProgressMonitor());
			Project.createFolder(project, "src/main/xdsml-java-gen", new NullProgressMonitor());
			addJavaResources(project);
		}
	}
		
	public static final String CLASSPATH_TEMPLATE= "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
"<classpath>\n"+
"	<classpathentry kind=\"src\" path=\"src/main/java\"/>\n"+
"	<classpathentry kind=\"src\" path=\"src/main/xdsml-java-gen\"/>\n"+
"	<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6\"/>\n"+
"	<classpathentry kind=\"output\" path=\"bin\"/>\n"+
"</classpath>";
	
	private static void addJavaResources(IProject project) throws CoreException, IOException 
	{
		final IFile file = project.getFile(new Path(".classpath")); 
		InputStream stream = null;
		try 
			{
				stream = new ByteArrayInputStream(CLASSPATH_TEMPLATE.getBytes());
				if (file.exists()) 
				{
					file.setContents(stream, true, true, null);
				} 
				else 
				{
					file.create(stream, true, null);
				}
			} 
			finally
			{
				if (stream != null)
					stream.close();				
			}
	}
	
	public static void addNature(IProject project, String natureId) throws CoreException 
	{
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		if (!project.hasNature(natureId)) 
		{
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 1, natures.length);
			newNatures[0] = natureId;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		}
	}
	
	public static void removeNature(IProject project, String natureId) throws CoreException 
	{
		IProjectDescription description = project.getDescription();
		List<String> natures = Arrays.asList(description.getNatureIds());
		natures.remove(natureId);
		String[] newNatures = natures.toArray(new String[natures.size()]);
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}
	
	public static NatureToggling toggleNature(IProject project, String natureId) throws CoreException
	{
		if (!project.hasNature(natureId)) 
		{
			addNature(project, natureId);
			return NatureToggling.Added;
		}
		else 
		{
			removeNature(project, natureId);
			return NatureToggling.Removed;
		}
	}

}
