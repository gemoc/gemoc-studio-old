package org.gemoc.execution.engine.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTraceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.utils.ccsl.QvtoTransformationPerformer;


public class ModelExecutionContext {

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
	public IPath getRuntimePath() {
		return _runtimePath;
	}
	
	public ModelExecutionContext(IPath projectPath, IPath domainModelPath, IPath debuggerModelPath) throws CoreException {
		this(projectPath, domainModelPath, null, debuggerModelPath);
	}
	
	public ModelExecutionContext(IPath projectPath, IPath domainModelPath, IPath mocPath, IPath debuggerModelPath) throws CoreException {
		_topPath = projectPath.append("/gemoc-gen");
		_globalExecutionPath = _topPath.append("execution");
		_specificExecutionPath = _topPath.append(generateSpecificExecutionFolderName());	
		_inputPath = _specificExecutionPath.append("/input");
		_runtimePath = _specificExecutionPath.append("/runtime");
		_originalModelPath = domainModelPath;
		_debuggerViewModelPath = debuggerModelPath;
		//_originalMoCPath = new Path(getLaunchAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_EXTENDEDCCSL_FILE_PATH));
		_originalMoCPath = mocPath;
		if (_originalMoCPath == null)
			setMoCPath();
		createExecutionContext();
	}


	private void setMoCPath() {
		int numberOfCharToRemove = _originalModelPath.lastSegment().toString().length() - _originalModelPath.getFileExtension().length() -1;
		String path = _originalModelPath.lastSegment().toString().substring(0, numberOfCharToRemove) + "_executionModel.timemodel";
//		String path = _originalModelPath.lastSegment().toString().substring(0, numberOfCharToRemove) + "_executionModel.extendedCCSL";
		_originalMoCPath = new Path(path);
	}

	private String generateSpecificExecutionFolderName() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		return "/execution-" + timeStamp;
	}
	
	void createExecutionContext() throws CoreException {
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
			performer.run(
						"platform:/plugin" + transformationPath, 
						"platform:/resource" + getModelPath().toString(), 
						"platform:/resource" + getMoCPath().toString());			
		}		
	}
	
	
//	public void saveTraceModel(Resource traceResource, Resource modelUnderExecutionResource, Solver solver, long stepNumber) throws CoreException, IOException {
//		if (traceResource.getContents().size() > 0) {
//			
//			ResourceSet rs = new ResourceSetImpl();
//			URI modelURI = URI.createPlatformResourceURI(getModelPath().toOSString(), true);
//			Resource resource = rs.getResource(modelURI, true);
//			
//			// Configure EMF Compare
//			IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
//			IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
//			IMatchEngine matchEngine = new DefaultMatchEngine(matcher, comparisonFactory);
//			IMatchEngine.Factory.Registry matchEngineRegistry = EMFCompareRCPPlugin.getDefault().getMatchEngineFactoryRegistry();
//		    IPostProcessor.Descriptor.Registry<String> postProcessorRegistry = EMFCompareRCPPlugin.getDefault().getPostProcessorRegistry();
//			EMFCompare comparator = EMFCompare.builder()
//		                                           .setMatchEngineFactoryRegistry(matchEngineRegistry)
//		                                           .setPostProcessorRegistry(postProcessorRegistry)
//		                                           .build();
//			// Compare the two models
//	//		IComparisonScope scope = EMFCompare.createDefaultScope(rs, modelUnderExecutionResource.getResourceSet());
//			IComparisonScope scope = EMFCompare.createDefaultScope(resource, modelUnderExecutionResource);
//			Comparison comparison = comparator.compare(scope);
//			
//			
//			IPath folderPath = getStepFolder(stepNumber);	
//			IPath traceFilePath = new Path(traceResource.getURI().toPlatformString(true));
//			IPath modelPath = folderPath.append(modelUnderExecutionResource.getURI().lastSegment());
//			IFile modelFile = ResourcesPlugin.getWorkspace().getRoot().getFile(modelPath);
//			
////			// filing out the model
////			FileOutputStream fos = new FileOutputStream(modelFile.getLocation().toString());
////			try {
////				resource.save(fos, null);
////				//modelUnderExecutionResource.save(fos, null);				
////			} 
////			finally {
////				fos.close();
////			}
//			// reload the model
////			URI modelURI = URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
////			Resource modelResource = traceResource.getResourceSet().createResource(modelURI);
////			modelResource.load(null);
//			
//			ExecutionTraceModel traceModel = (ExecutionTraceModel)traceResource.getContents().get(0);				
//			if (traceModel.getChoices().size() > 0) {
//				// link it to the trace model
//				ModelState modelState = GemocExecutionEngineTraceFactory.eINSTANCE.createModelState();					
//				//modelState.setModel(modelResource.getContents().get(0));
//				traceResource.getContents().add(comparison);
//				modelState.setModel(comparison);
//				
//				SolverState solverState = GemocExecutionEngineTraceFactory.eINSTANCE.createSolverState();					
//				//EObject trueSolverState = includeSolverStateIntoResourceSet(traceResource, solver, modelFile.getFullPath().removeLastSegments(1));
//				//solverState.setModel(trueSolverState);
//				//trueSolverState.eResource().save(null);
//				
//				solverState.setSerializableModel(solver.getState());
//				Activator.debug("step" + stepNumber + ", saving solver state: " 
//						 + solverState.getSerializableModel());
//				
//				ContextState contextState = GemocExecutionEngineTraceFactory.eINSTANCE.createContextState();
//				contextState.setModelState(modelState);
//				contextState.setSolverState(solverState);
//				traceModel.getChoices().get(traceModel.getChoices().size()-1).setContextState(contextState);
//			}
//			
//			saveResource(traceResource, traceFilePath);			
//		}
//	}

//	private EObject includeSolverStateIntoResourceSet(Resource traceResource, Solver solver, IPath folderPath) {
//		IPath solverStatePath = folderPath.append("solverState.xmi");
//		URI solverStateURI = URI.createPlatformResourceURI(solverStatePath.toString(), true);
//		Resource resource = traceResource.getResourceSet().createResource(solverStateURI);
//		EObject solverState = solver.getState();
//		resource.getContents().add(solverState);
//		return solverState;
//	}

//	public void saveDomainModel(Resource resource, long stepNumber) throws CoreException, IOException {
//		if (resource.getContents().size() > 0) {
//			IPath folderPath = getStepFolder(stepNumber);	
//			IPath filePath = folderPath.append(resource.getURI().lastSegment());
//			saveResource(resource, filePath);			
//		}	
//	}
	
	private IPath getStepFolder(long stepNumber) throws CoreException {
		IPath folderPath = _runtimePath.append("step" + stepNumber);
		createFolder(folderPath);
		return folderPath;
	}


	
//	public URI getTraceModelURI(Resource domainModelResource, long stepNumber) {
//		int numberOfSegmentsToTrim = domainModelResource.getURI().segmentCount() > 2 ? domainModelResource.getURI().segmentCount() - 2 : 0;
//		return domainModelResource.getURI()
//										.trimSegments(numberOfSegmentsToTrim)
//										.appendSegment("gemoc-gen")
//										.appendSegment("execution")
//										.appendSegment("step" + stepNumber)
//										.appendSegment("trace.xmi");
//	}


}
