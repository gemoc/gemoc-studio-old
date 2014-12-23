package org.gemoc.sample.tfsm.raspberry.engine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.gemoc.commons.eclipse.emf.URIHelper;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;

public class ExecutionWorkspace implements IExecutionWorkspace
{

	private IPath _modelPath;
	private IPath _projectPath;
	
	public ExecutionWorkspace(URI modelURI) 
	{
		_modelPath = new Path(URIHelper.removePlatformScheme(modelURI));
		_projectPath = _modelPath.removeLastSegments(_modelPath.segmentCount() - 1);
	}
	
	@Override
	public IPath getProjectPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPath getModelPath() {
		return _modelPath;
	}

	@Override
	public IPath getMoCPath() 
	{
		return getModelPath().removeFileExtension().addFileExtension("timemodel");
	}

	@Override
	public IPath getFeedbackModelPath() 
	{
		return getModelPath().removeFileExtension().addFileExtension("feedback");
	}

	@Override
	public IPath getExecutionPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void copyFileToExecutionFolder(IPath filePath) throws CoreException {
		// TODO Auto-generated method stub
		
	}

}
