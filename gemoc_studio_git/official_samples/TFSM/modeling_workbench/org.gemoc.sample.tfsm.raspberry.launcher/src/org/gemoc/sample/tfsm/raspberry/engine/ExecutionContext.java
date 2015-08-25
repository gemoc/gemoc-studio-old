package org.gemoc.sample.tfsm.raspberry.engine;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.commons.deciders.RandomDecider;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;

public class ExecutionContext implements IExecutionContext
{

	private ResourceSet _resourceSet;
	private Resource _modelResource;
	
	public ExecutionContext(RunConfiguration runConfiguration) throws IOException 
	{
		_executionWorkspace = new ExecutionWorkspace(runConfiguration.getExecutedModelURI());
		_executionPlatform = new ExecutionPlatform();
		_runConfiguration = runConfiguration;
		createResourceSet();
		_modelResource = _resourceSet.getResource(runConfiguration.getExecutedModelURI(), true);
		EcoreUtil.resolveAll(_resourceSet);
		_executionPlatform.getSolver().setUp(this);
	}

	private void createResourceSet() 
	{
		_resourceSet = new ResourceSetImpl();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(_resourceSet);
		if (editingDomain == null)
		{
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(_resourceSet);			
		}
	}
	
	@Override
	public void dispose() 
	{
		_executionPlatform.dispose();
	}

	@Override
	public LanguageDefinitionExtension getLanguageDefinitionExtension() {
		// TODO Auto-generated method stub
		return null;
	}

	private ExecutionWorkspace _executionWorkspace;
	@Override
	public IExecutionWorkspace getWorkspace() 
	{
		return _executionWorkspace;
	}

	private ExecutionPlatform _executionPlatform;
	@Override
	public IExecutionPlatform getExecutionPlatform() 
	{
		return _executionPlatform;
	}

	private RunConfiguration _runConfiguration;
	@Override
	public IRunConfiguration getRunConfiguration() 
	{
		return _runConfiguration;
	}

	@Override
	public Resource getResourceModel() 
	{
		return _modelResource;
	}

	@Override
	public ExecutionMode getExecutionMode() 
	{
		return ExecutionMode.Run;
	}

	@Override
	public ActionModel getFeedbackModel() 
	{
		URI uri = URI.createPlatformPluginURI(_executionWorkspace.getFeedbackModelPath().toString(), true);
		Resource r = _resourceSet.getResource(uri, false);
		ActionModel model = null;
		if (r != null)
		{
			model = (ActionModel)r.getContents().get(0);
		}
		return model;
	}

	private ILogicalStepDecider _decider = new RandomDecider();
	@Override
	public ILogicalStepDecider getLogicalStepDecider() 
	{
		return _decider;
	}

	@Override
	public void changeLogicalStepDecider(ILogicalStepDecider newDecider) {
		// TODO Auto-generated method stub
		
	}

}
