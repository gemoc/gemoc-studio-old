package org.gemoc.execution.engine.core;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.commons.solvers.ccsl.SolverMock;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.exceptions.EngineContextException;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtensionPoint;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;


public class ModelExecutionContext implements IExecutionContext
{
	
	private IRunConfiguration _runConfiguration;
	private Resource _resourceModel;
	private ExecutionMode _executionMode;	
	
	public ModelExecutionContext(IRunConfiguration runConfiguration, ExecutionMode executionMode) throws EngineContextException {
		_runConfiguration = runConfiguration;
		_executionMode = executionMode;
		
		try 
		{
			_executionWorkspace = new ExecutionWorkspace(_runConfiguration.getExecutedModelURI());
			_executionWorkspace.copyFileToExecutionFolder(_executionWorkspace.getModelPath());
			
			_languageDefinition = LanguageDefinitionExtensionPoint.findDefinition(_runConfiguration.getLanguageName());
			throwExceptionIfLanguageDefinitionNull();
			instantiateAgents();
			_resourceModel = _modelLoader.loadModel(this);					
			setUpEditingDomain();	
			setUpSolver();						
			setUpFeedbackModel();
		} 
		catch (CoreException e)
		{
			EngineContextException exception = new EngineContextException("Cannot initialize the execution context, see inner exception.", e);
			throw exception;
		}
	}

	private ResourceSet getResourceSet() {
		return _resourceModel.getResourceSet();
	}

	private void setUpEditingDomain() 
	{
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(getResourceSet());
		if (editingDomain == null)
		{
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(getResourceSet());			
		}
	}

	private void setUpSolver() 
	{
		getSolver().setUp(this);
	}

	private void setUpFeedbackModel() 
	{
		URI feedbackURI = URI.createPlatformResourceURI(_executionWorkspace.getFeedbackModelPath().toString(), true);
		Resource resource = getResourceSet().createResource(feedbackURI);
		try {
			resource.load(null);
			_feedbackModel = (ActionModel)resource.getContents().get(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Solver _solver;
	private ICodeExecutor _codeExecutor;
	private Collection<IEngineHook> _hooks;
	private Collection<IMSEStateController> _clockControllers;
	
	private void instantiateAgents() throws CoreException 
	{
		_modelLoader = _languageDefinition.instanciateModelLoader();
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
	
//	private void generateMoC() 
//	{
//		String transformationPath = _languageDefinition.getQVTOPath();
//		boolean mustGenerate = true;
//		IFile mocFile = ResourcesPlugin.getWorkspace().getRoot().getFile(_executionWorkspace.getMoCPath());
//		if (mocFile.exists()
//			&& _executionWorkspace.getModelPath().toFile().lastModified() > _executionWorkspace.getMoCPath().toFile().lastModified()) 
//		{
//			mustGenerate = true;
//		}
//		
//		if (mustGenerate)
//		{
//			QvtoTransformationPerformer performer = new QvtoTransformationPerformer();
//			performer.run(
//						"platform:/plugin" + transformationPath, 
//						"platform:/resource" + _executionWorkspace.getModelPath().toString(), 
//						"platform:/resource" + _executionWorkspace.getMoCPath().toString(),
//						"platform:/resource" + _executionWorkspace.getFeedbackModelPath().toString());			
//		}		
//	}
		
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

	@Override
	public IRunConfiguration getRunConfiguration() 
	{
		return _runConfiguration;
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

	public boolean isExecutionWithSolver() 
	{
		return _solver != null && !(_solver instanceof SolverMock);
	}


	private IModelLoader _modelLoader;
	@Override
	public IModelLoader getModelLoader() 
	{
		return _modelLoader;
	}

	@Override
	public String getQVTOPath() 
	{
		return _languageDefinition.getQVTOPath();
	}

}
