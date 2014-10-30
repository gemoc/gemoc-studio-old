package org.gemoc.execution.engine.core;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.exceptions.EngineContextException;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtensionPoint;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.utils.ccsl.QvtoTransformationPerformer;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;


public class ModelExecutionContext implements IExecutionContext
{
	
	private IPath _debuggerViewModelPath;
	public IPath getDebuggerViewModelPath() {
		return _debuggerViewModelPath;
	}
	
	private RunConfiguration _runConfiguration;
	private TransactionalEditingDomain _editingDomain;
	private Resource _resourceModel;
	private ExecutionMode _executionMode;	
	
	public ModelExecutionContext(RunConfiguration runConfiguration, ResourceSet resourceSet, ExecutionMode executionMode) throws EngineContextException {
		_runConfiguration = runConfiguration;
		_executionMode = executionMode;
		
		try 
		{
			_executionWorkspace = new ExecutionWorkspace(_runConfiguration.getModelURIAsString());
			_executionWorkspace.copyFileToExecutionFolder(_executionWorkspace.getModelPath());
			
			if (runConfiguration.getAnimatorURIAsString() != null)
				_debuggerViewModelPath = new Path(runConfiguration.getAnimatorURIAsString());
			_languageDefinition = LanguageDefinitionExtensionPoint.findDefinition(_runConfiguration.getLanguageName());
			throwExceptionIfLanguageDefinitionNull();
			instantiateAgents();
			generateMoC();

			_resourceModel = getModelResource(resourceSet, _executionWorkspace.getModelPath().toString());

			setUpEditingDomain(resourceSet);	
			setUpSolver(resourceSet);						
			setUpFeedbackModel(resourceSet);
		} 
		catch (CoreException e)
		{
			EngineContextException exception = new EngineContextException("Cannot initialize the execution context, see inner exception.", e);
			throw exception;
		}
	}

	private void setUpEditingDomain(ResourceSet resourceSet) 
	{
		_editingDomain = TransactionUtil.getEditingDomain(resourceSet);
		if (_editingDomain == null)
		{
			_editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);			
		}
	}

	private void setUpSolver(ResourceSet resourceSet) 
	{
		URI mocURI = URI.createPlatformResourceURI(_executionWorkspace.getMoCPath().toString(), true);
		getSolver().setSolverInputFile(resourceSet, mocURI);
	}

	private void setUpFeedbackModel(ResourceSet resourceSet) 
	{
		URI feedbackURI = URI.createPlatformResourceURI(_executionWorkspace.getFeedbackModelPath().toString(), true);
		Resource resource = resourceSet.createResource(feedbackURI);
		try {
			resource.load(null);
			_feedbackModel = (ActionModel)resource.getContents().get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected Resource getModelResource(ResourceSet resourceSet, String modelPath) throws CoreException {		
		return resourceSet.getResource(URI.createPlatformResourceURI(modelPath, true), true);
	}
	
	private Solver _solver;
	private ICodeExecutor _codeExecutor;
	private Collection<IEngineHook> _hooks;
	private Collection<IMSEStateController> _clockControllers;
	
	private void instantiateAgents() throws CoreException {
		_solver = _languageDefinition.instanciateSolver();
		_codeExecutor = _languageDefinition.instanciateCodeExecutor();
		_hooks = _languageDefinition.instanciateEngineHooks();
		_clockControllers = _languageDefinition.instanciateMSEStateControllers();
	}

	private LanguageDefinitionExtension _languageDefinition;

	private void throwExceptionIfLanguageDefinitionNull() throws EngineContextException {
		if (_languageDefinition == null)
		{			
			String message = "Cannot find xdsml definition for the language " + _runConfiguration.getLanguageName() + ", please verify that is is correctly deployed.";
			EngineContextException exception = new EngineContextException(message);
			throw exception;
		}
	}
	
	private void generateMoC() 
	{
		String transformationPath = _languageDefinition.getQVTOPath();
		boolean mustGenerate = true;
		IFile mocFile = ResourcesPlugin.getWorkspace().getRoot().getFile(_executionWorkspace.getMoCPath());
		if (mocFile.exists()
			&& _executionWorkspace.getModelPath().toFile().lastModified() > _executionWorkspace.getMoCPath().toFile().lastModified()) 
		{
			mustGenerate = true;
		}
		
		if (mustGenerate)
		{
			QvtoTransformationPerformer performer = new QvtoTransformationPerformer();
			performer.run(
						"platform:/plugin" + transformationPath, 
						"platform:/resource" + _executionWorkspace.getModelPath().toString(), 
						"platform:/resource" + _executionWorkspace.getMoCPath().toString(),
						"platform:/resource" + _executionWorkspace.getFeedbackModelPath().toString());			
		}		
	}
		
	@Override
	public Solver getSolver() 
	{
		return _solver;
	}

	@Override
	public ICodeExecutor getCodeExecutor() 
	{
		return _codeExecutor;
	}

	@Override
	public Collection<IEngineHook> getHooks() 
	{
		return _hooks;
	}

	@Override
	public Collection<IMSEStateController> getMSEStateControllers() 
	{
		return _clockControllers;
	}

	public RunConfiguration getRunConfiguration() 
	{
		return _runConfiguration;
	}

	@Override
	public TransactionalEditingDomain getEditingDomain() 
	{
		return _editingDomain;
	}

	@Override
	public Resource getResourceModel() 
	{
		return _resourceModel;
	}

	@Override
	public void dispose() 
	{
		_clockControllers.clear();
		_hooks.clear();
	}

	private IExecutionWorkspace _executionWorkspace;
	@Override
	public IExecutionWorkspace getWorkspace() 
	{
		return _executionWorkspace;
	}

	@Override
	public ExecutionMode getExecutionMode() {
		return _executionMode;
	}

	private ActionModel _feedbackModel;
	@Override
	public ActionModel getFeedbackModel() 
	{
		return _feedbackModel;
	}

}
