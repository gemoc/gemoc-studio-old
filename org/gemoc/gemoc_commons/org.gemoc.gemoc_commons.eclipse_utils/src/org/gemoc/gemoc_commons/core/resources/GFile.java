package org.gemoc.gemoc_commons.core.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

public class GFile {

	public static void writeFile(IFile file, String fileContent) throws CoreException{
		IProject project = file.getProject();
		Project.createFile(project, file, fileContent);
	}
	
}
