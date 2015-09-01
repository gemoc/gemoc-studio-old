package org.gemoc.execution.engine.commons;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.core.ExecutionWorkspace;
import org.gemoc.executionengine.ccsljava.api.core.IConcurrentExecutionContext;
import org.gemoc.executionengine.ccsljava.api.core.ILogicalStepDecider;
import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtensionPoint;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtensionPoint;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;

public class ModelExecutionContext implements IExecutionContext
{

	protected IRunConfiguration _runConfiguration;

	protected Resource _resourceModel;

	protected ExecutionMode _executionMode;

	protected LanguageDefinitionExtension _languageDefinition;
	
	public ModelExecutionContext(IRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException
	{
		_runConfiguration = runConfiguration;
		_executionMode = executionMode;
		try
		{
			_executionWorkspace = new ExecutionWorkspace(_runConfiguration.getExecutedModelURI());
			try
			{
				_executionWorkspace.copyFileToExecutionFolder(_executionWorkspace.getModelPath());
			} catch (CoreException e)
			{
				// TODO throw warning that we couldn't copy the model
			}
			_languageDefinition = getLanguageDefinition(_runConfiguration.getLanguageName());
			_executionPlatform = createExecutionPlatform(); //new DefaultExecutionPlatform(_languageDefinition, _runConfiguration);
			if(_runConfiguration.getAnimatorURI() != null) // TODO maybe add a toggle in the launcher tab to temporarily enable or disable the use of the animation
			{
				_resourceModel = _executionPlatform.getModelLoader().loadModelForAnimation(this);
			} else
			{
				_resourceModel = _executionPlatform.getModelLoader().loadModel(this);
			}
			
			setUpEditingDomain();
			
			setUpFeedbackModel();

			// check that the initial resource hasn't been loaded more than once
			// via melange

			int resPos = 0;
			for (Resource res : _resourceModel.getResourceSet().getResources())
			{
				if (resPos != 0 && res.getURI().path().equals(_runConfiguration.getExecutedModelURI().path()))
				{
					Activator.getDefault().error(
							"Error: found more than one resource in the resourceSet with the following path :"
									+ _runConfiguration.getExecutedModelURI().path());
					for (Resource r : _resourceModel.getResourceSet().getResources())
					{
						Activator.getDefault().info(r.getURI().toString());
					}
					break;
				}
				resPos++;
			}
		} catch (CoreException e)
		{
			EngineContextException exception = new EngineContextException(
					"Cannot initialize the execution context, see inner exception.", e);
			throw exception;
		}
	}

	protected IExecutionPlatform createExecutionPlatform() throws CoreException{
		return new DefaultExecutionPlatform(_languageDefinition, _runConfiguration);
	}
	
	protected LanguageDefinitionExtension getLanguageDefinition(String languageName) throws EngineContextException
	{
		ConcurrentLanguageDefinitionExtension languageDefinition = ConcurrentLanguageDefinitionExtensionPoint.findDefinition(_runConfiguration.getLanguageName());
		if (languageDefinition == null)
		{
			String message = "Cannot find xdsml definition for the language " + _runConfiguration.getLanguageName()
					+ ", please verify that is is correctly deployed.";
			EngineContextException exception = new EngineContextException(message);
			throw exception;
		}
		return languageDefinition;
	}

	private ResourceSet getResourceSet()
	{
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
		URI feedbackPlatformURI = URI.createPlatformResourceURI(_executionWorkspace.getFeedbackModelPath().toString(),
				true);
		try
		{
			Resource resource = getResourceSet().getResource(feedbackPlatformURI, true);
			_feedbackModel = (ActionModel) resource.getContents().get(0);
		} catch (Exception e)
		{
			// file will be created later
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
		//
	}

	private IExecutionWorkspace _executionWorkspace;

	@Override
	public IExecutionWorkspace getWorkspace()
	{
		return _executionWorkspace;
	}

	@Override
	public ExecutionMode getExecutionMode()
	{
		return _executionMode;
	}

	protected ActionModel _feedbackModel;

	@Override
	public ActionModel getFeedbackModel()
	{
		return _feedbackModel;
	}

	protected IExecutionPlatform _executionPlatform;

	@Override
	public IExecutionPlatform getExecutionPlatform()
	{
		return _executionPlatform;
	}

	@Override
	public LanguageDefinitionExtension getLanguageDefinitionExtension()
	{
		return _languageDefinition;
	}

	




}
