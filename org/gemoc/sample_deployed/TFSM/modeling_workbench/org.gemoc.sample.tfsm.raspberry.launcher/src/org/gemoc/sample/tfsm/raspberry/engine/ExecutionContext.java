package org.gemoc.sample.tfsm.raspberry.engine;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.impl.CCSLModelPackageImpl;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;

public class ExecutionContext implements IExecutionContext
{

	public ExecutionContext(RunConfiguration runConfiguration) throws IOException 
	{
		_executionWorkspace = new ExecutionWorkspace();
		_executionPlatform = new ExecutionPlatform();
		_runConfiguration = runConfiguration;
		
		CCSLModelPackageImpl.init();
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(runConfiguration.getExecutedModelURI());
		resource.load(null);
		ClockConstraintSystem timeModel = (ClockConstraintSystem)resource.getContents().get(0);
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
	public Resource getResourceModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecutionMode getExecutionMode() 
	{
		return ExecutionMode.Run;
	}

	@Override
	public ActionModel getFeedbackModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILogicalStepDecider getLogicalStepDecider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLogicalStepDecider(ILogicalStepDecider newDecider) {
		// TODO Auto-generated method stub
		
	}

}
