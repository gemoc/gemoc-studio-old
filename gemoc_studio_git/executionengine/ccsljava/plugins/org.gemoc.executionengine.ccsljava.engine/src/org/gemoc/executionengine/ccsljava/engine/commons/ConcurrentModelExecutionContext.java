package org.gemoc.executionengine.ccsljava.engine.commons;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.execution.engine.commons.EngineContextException;
import org.gemoc.execution.engine.commons.LogicalStepDeciderFactory;
import org.gemoc.execution.engine.commons.ModelExecutionContext;
import org.gemoc.executionengine.ccsljava.api.core.IConcurrentExecutionContext;
import org.gemoc.executionengine.ccsljava.api.core.IConcurrentExecutionPlatform;
import org.gemoc.executionengine.ccsljava.api.core.ILogicalStepDecider;
import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;

public class ConcurrentModelExecutionContext extends ModelExecutionContext implements IConcurrentExecutionContext
{

	
	public ConcurrentModelExecutionContext(IRunConfiguration runConfiguration, ExecutionMode executionMode)
			throws EngineContextException
	{
		super(runConfiguration, executionMode);
		try
		{
			
			_logicalStepDecider = LogicalStepDeciderFactory.createDecider(runConfiguration.getDeciderName(),
					executionMode);
			
		} catch (CoreException e)
		{
			EngineContextException exception = new EngineContextException(
					"Cannot initialize the execution context, see inner exception.", e);
			throw exception;
		}
	}

	protected IExecutionPlatform createExecutionPlatform() throws CoreException{
		if(_languageDefinition instanceof  ConcurrentLanguageDefinitionExtension ){
			return new DefaultConcurrentExecutionPlatform((ConcurrentLanguageDefinitionExtension)_languageDefinition, _runConfiguration);
		} else {
			return super.createExecutionPlatform();
		}
	}
	
	

	@Override
	public void dispose()
	{
		super.dispose();
		_logicalStepDecider.dispose();
	}

	

	

	protected ILogicalStepDecider _logicalStepDecider;

	@Override
	public ILogicalStepDecider getLogicalStepDecider() {
		return _logicalStepDecider;
	}

	@Override
	public IConcurrentExecutionPlatform getConcurrentExecutionPlatform() {
		if(getExecutionPlatform() instanceof IConcurrentExecutionPlatform) return (IConcurrentExecutionPlatform) getExecutionPlatform();
		else return null;
	}

	@Override
	public ConcurrentLanguageDefinitionExtension getConcurrentLanguageDefinitionExtension() {
		if(getLanguageDefinitionExtension() instanceof ConcurrentLanguageDefinitionExtension) return (ConcurrentLanguageDefinitionExtension) getLanguageDefinitionExtension();
		return null;
	}




}
