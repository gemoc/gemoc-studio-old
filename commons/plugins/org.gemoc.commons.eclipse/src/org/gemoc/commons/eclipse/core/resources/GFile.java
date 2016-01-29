package org.gemoc.commons.eclipse.core.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

public class GFile {

	public static void writeFile(IFile file, String fileContent) throws CoreException{
		IProject project = file.getProject();
		if(file.exists()){
			Project.setFileContent(project, file, fileContent, new NullProgressMonitor());
		} else {
			Project.createFile(project, file, fileContent);
		}
	}
	
	public static void addMarker(IFile file, String markerType, String message, int severity) throws CoreException {
		IMarker marker = file.createMarker(markerType);
		marker.setAttribute(IMarker.MESSAGE, message);
		marker.setAttribute(IMarker.SEVERITY, severity);
		marker.setAttribute(IMarker.LINE_NUMBER, 1);
	}
}
