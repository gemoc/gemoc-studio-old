package org.gemoc.gemoc_language_workbench.api.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public interface IExecutionWorkspace 
{

	public IPath getProjectPath();

	public IPath getModelPath();
	
	public IPath getMoCPath();

	public IPath getExecutionPath();

	public void copyFileToExecutionFolder(IPath filePath) throws CoreException;

}
