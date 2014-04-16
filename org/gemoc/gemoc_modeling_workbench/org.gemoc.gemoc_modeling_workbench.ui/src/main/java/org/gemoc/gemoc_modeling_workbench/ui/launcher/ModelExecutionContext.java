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
import org.gemoc.gemoc_language_workbench.utils.ccsl.QvtoTransformationPerformer;

import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;
import fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI;


public class ModelExecutionContext {

	private ILaunchConfiguration _launchConfiguration;
	
	private IPath _originalModelPath;
	public IPath getModelPath() {
		return _originalModelPath;
		//return _inputPath.append(_originalModelPath.lastSegment());
	}
	
	private IPath _debuggerViewModelPath;
	public IPath getDebuggerViewModelPath() {
		return _debuggerViewModelPath;
	}
	
	private IPath _originalMoCPath;
	public IPath getMoCPath() {
		//return new Path("");
		//return _originalMoCPath;
		return _globalExecutionPath.append(_originalMoCPath.lastSegment());
	}
	
	private IPath _topPath;
	private IPath _globalExecutionPath;	
	private IPath _specificExecutionPath;	
	private IPath _inputPath;
	private IPath _runtimePath;

	private String _languageName;
	public String getLanguageName() {
		return _languageName;
	}
	
	public ModelExecutionContext(ILaunchConfiguration configuration) throws CoreException {
		_launchConfiguration = configuration;
		_topPath = _launchConfiguration.getFile().getParent().getParent().getFullPath().append("/gemoc-gen");
		_globalExecutionPath = _topPath.append("execution");
		_specificExecutionPath = _topPath.append(generateSpecificExecutionFolderName());	
		_inputPath = _specificExecutionPath.append("/input");
		_runtimePath = _specificExecutionPath.append("/runtime");
		_originalModelPath = new Path(getLaunchAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI));
		_debuggerViewModelPath = new Path(getLaunchAttribute(AbstractDSLLaunchConfigurationDelegateUI.SIRIUS_RESOURCE_URI));
		//_originalMoCPath = new Path(getLaunchAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_EXTENDEDCCSL_FILE_PATH));
		setMoCPath();
		_languageName = configuration.getAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_SELECTED_LANGUAGE, "");
	}

	private void setMoCPath() {
		int numberOfCharToRemove = _originalModelPath.lastSegment().toString().length() - _originalModelPath.getFileExtension().length() -1;
		String path = _originalModelPath.lastSegment().toString().substring(0, numberOfCharToRemove) + "_executionModel.extendedCCSL";
		_originalMoCPath = new Path(path);
	}

	private String generateSpecificExecutionFolderName() {
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
		createFolder(_globalExecutionPath);
		createFolder(_specificExecutionPath);
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
		copyFileToInputFolder(_originalModelPath);
		//copyFileToInputFolder(_debuggerViewModelPath);
	}

	private void copyFileToInputFolder(IPath path) throws CoreException {
		copyFileTo(path, _inputPath.append(path.lastSegment()));
	}

	private void generateRuntime() throws CoreException {
		copyFileToRuntimeFolder(_originalModelPath);
		//copyFileToRuntimeFolder(_originalMoCPath);
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

	public void generateMoC(String transformationPath) {
		if (!ResourcesPlugin.getWorkspace().getRoot().getFile(getMoCPath()).exists()) {
			QvtoTransformationPerformer performer = new QvtoTransformationPerformer();
			performer.run(transformationPath, getModelPath().toString(), getMoCPath().toString());			
		}		
	}

}
