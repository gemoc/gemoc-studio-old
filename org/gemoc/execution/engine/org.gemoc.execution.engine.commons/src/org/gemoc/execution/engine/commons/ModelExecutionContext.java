package org.gemoc.execution.engine.commons;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.core.ExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtensionPoint;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;


public class ModelExecutionContext implements IExecutionContext
{
	
	private IRunConfiguration _runConfiguration;
	
	private Resource _resourceModel;

	private ExecutionMode _executionMode;	
	
	private LanguageDefinitionExtension _languageDefinition;

	
	public ModelExecutionContext(IRunConfiguration runConfiguration, ExecutionMode executionMode) throws EngineContextException {
		_runConfiguration = runConfiguration;
		_executionMode = executionMode;
		try 
		{
			_executionWorkspace = new ExecutionWorkspace(_runConfiguration.getExecutedModelURI());
			_executionWorkspace.copyFileToExecutionFolder(_executionWorkspace.getModelPath());
			_languageDefinition = getLanguageDefinition(_runConfiguration.getLanguageName());
			_executionPlatform = new DefaultExecutionPlatform(_languageDefinition);
			_resourceModel = _executionPlatform.getModelLoader().loadModel(this);					
			_logicalStepDecider = LogicalStepDeciderFactory.createDecider(runConfiguration.getDeciderName(), executionMode);
			setUpEditingDomain();	
			_executionPlatform.getSolver().setUp(this);
			setUpFeedbackModel();
		} 
		catch (CoreException e)
		{
			EngineContextException exception = new EngineContextException("Cannot initialize the execution context, see inner exception.", e);
			throw exception;
		}
	}

	private LanguageDefinitionExtension getLanguageDefinition(String languageName) throws EngineContextException 
	{
		LanguageDefinitionExtension languageDefinition = LanguageDefinitionExtensionPoint.findDefinition(_runConfiguration.getLanguageName());
		if (languageDefinition == null)
		{			
			String message = "Cannot find xdsml definition for the language " + _runConfiguration.getLanguageName() + ", please verify that is is correctly deployed.";
			EngineContextException exception = new EngineContextException(message);
			throw exception;
		}		
		return languageDefinition;
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

	private void setUpFeedbackModel() 
	{
		URI feedbackURI = URI.createPlatformResourceURI(_executionWorkspace.getFeedbackModelPath().toString(), true);
		for (Resource r : getResourceSet().getResources())
		{
			if (r.getURI().equals(feedbackURI))
			{				
				_feedbackModel = (ActionModel)r.getContents().get(0);
				break;
			}
		}
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
		_executionPlatform.dispose();
		_logicalStepDecider.dispose();
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

	private IExecutionPlatform _executionPlatform;	
	@Override
	public IExecutionPlatform getExecutionPlatform() {
		return _executionPlatform;
	}

	@Override
	public LanguageDefinitionExtension getLanguageDefinitionExtension() 
	{
		return _languageDefinition;
	}

	protected ILogicalStepDecider _logicalStepDecider;
	@Override
	public ILogicalStepDecider getLogicalStepDecider() 
	{
		return _logicalStepDecider;
	}

	@Override
	public void changeLogicalStepDecider(ILogicalStepDecider newDecider) 
	{
		_logicalStepDecider = newDecider;
	}

}
