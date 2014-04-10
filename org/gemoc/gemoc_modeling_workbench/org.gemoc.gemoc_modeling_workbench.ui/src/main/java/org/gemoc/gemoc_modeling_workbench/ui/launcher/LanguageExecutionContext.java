package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;

import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;
import fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI;


public class LanguageExecutionContext {

	private ILaunchConfiguration _launchConfiguration;
	
	private IPath _modelPath;
	private IPath _debuggerViewModelPath;
	private IPath _mocPath;
	
	private IPath _topPath;
	private IPath _executionPath;	
	private IPath _inputPath;
	private IPath _runtimePath;

	public LanguageExecutionContext(ILaunchConfiguration configuration) throws CoreException {
		_launchConfiguration = configuration;
		_topPath = _launchConfiguration.getFile().getParent().getParent().getFullPath().append("/gemoc-gen");
		_executionPath = _topPath.append(generateExecutionFolderName());	
		_inputPath = _executionPath.append("/input");
		_runtimePath = _executionPath.append("/runtime");
		_modelPath = new Path(getLaunchAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI));
		_debuggerViewModelPath = new Path(getLaunchAttribute(AbstractDSLLaunchConfigurationDelegateUI.SIRIUS_RESOURCE_URI));
		_mocPath = new Path(getLaunchAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_EXTENDEDCCSL_FILE_PATH));
	}

	private String generateExecutionFolderName() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "/execution-" + timeStamp;
	}

	private String getLaunchAttribute(String attributeName) throws CoreException {
		return _launchConfiguration.getAttribute(attributeName, "");
	}
	
	void CreateExecutionContext() throws CoreException {
		createExecutionFolders();
		generateInput();
		generateRuntime();
	}
	
	private void createExecutionFolders() throws CoreException {
		createFolder(_topPath);
		createFolder(_executionPath);
		createFolder(_inputPath);
		createFolder(_runtimePath);
	}

	private void createFolder(IPath folderPath) throws CoreException {
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(folderPath);
		if (!folder.exists()) {
			folder.create(true, true, null);
		}
	}

	private void generateInput() throws CoreException {
		copyFileToInputFolder(_modelPath);
		//copyFileToInputFolder(_debuggerViewModelPath);
	}

	private void copyFileToInputFolder(IPath path) throws CoreException {
		copyFileTo(path, _inputPath.append(path.lastSegment()));
	}

	private void generateRuntime() throws CoreException {
		copyFileToRuntimeFolder(_modelPath);
		copyFileToRuntimeFolder(_mocPath);
		// copy sirius animator		
	}

	private void copyFileToRuntimeFolder(IPath path) throws CoreException {
		copyFileTo(path, _runtimePath.append(path.lastSegment()));
	}

	private void copyFileTo(IPath path, IPath destinationPath) throws CoreException {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		//Path destination = new Path(_inputPath + "/" + path);
		file.copy(destinationPath, true, null);
	}

}
