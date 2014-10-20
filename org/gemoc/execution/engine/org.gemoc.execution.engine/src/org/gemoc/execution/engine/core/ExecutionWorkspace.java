package org.gemoc.execution.engine.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;

public class ExecutionWorkspace implements IExecutionWorkspace
{

	public ExecutionWorkspace(String modelURI) throws CoreException
	{
		_modelPath = new Path(modelURI);
		_projectPath = _modelPath.removeLastSegments(_modelPath.segmentCount() - 1);
		_executionTopParentPath = _projectPath.append("gemoc-gen");			
		_executionPath = _executionTopParentPath
							.append("execution")
							.append(generateSpecificExecutionFolderName());
		createExecutionContext();
	}

	private IPath _executionTopParentPath;
	
	private IPath _projectPath;
	public IPath getProjectPath() 
	{
		return _projectPath;
	}
	
	private IPath _executionPath;
	public IPath getExecutionPath() 
	{
		return _executionPath;
	}
	
	private IPath _modelPath;
	public IPath getModelPath() 
	{
		return _modelPath;
	}

	public IPath getMoCPath() 
	{
		IPath mocPath= new Path(getModelPath().removeFileExtension().lastSegment()).addFileExtension("timemodel");
		return _executionTopParentPath.append(mocPath);
	}
	
	private String generateSpecificExecutionFolderName() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "/execution-" + timeStamp;
	}
	
	private void createExecutionContext() throws CoreException {
		createExecutionFolders();
	}
	
	private void createExecutionFolders() throws CoreException {
		createFolder(_executionPath.removeLastSegments(2));
		createFolder(_executionPath.removeLastSegments(1));
		createFolder(_executionPath);		
	}
	
	private void createFolder(IPath folderPath) throws CoreException {
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(folderPath);
		if (!folder.exists()) {
			folder.create(true, true, null);
		}
	}
	
	public void copyFileTo(IPath sourceFilePath, IPath destinationFolderPath) throws CoreException 
	{
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(sourceFilePath);
		IPath destinationFilePath = destinationFolderPath.append(sourceFilePath.lastSegment());
		file.copy(destinationFilePath, true, null);
	}
	
	public void copyFileToExecutionFolder(IPath sourcePath) throws CoreException 
	{
		copyFileTo(sourcePath, _executionPath);
	}

	@Override
	public IPath getFeedbackModelPath() 
	{
		IPath mocPath= new Path(getModelPath().removeFileExtension().lastSegment()).addFileExtension("feedback");
		return _executionTopParentPath.append(mocPath);
	}
}
