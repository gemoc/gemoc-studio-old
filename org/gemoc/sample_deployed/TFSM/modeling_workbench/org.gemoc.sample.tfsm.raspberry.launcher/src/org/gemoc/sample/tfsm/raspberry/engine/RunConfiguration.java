package org.gemoc.sample.tfsm.raspberry.engine;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtension;

public class RunConfiguration implements IRunConfiguration 
{

	public RunConfiguration(URI modelURI)
	{
		_modelURI = modelURI;
	}
	
	@Override
	public String getLanguageName() 
	{
		return null;
	}

	private URI _modelURI;
	@Override
	public URI getExecutedModelURI() 
	{
		return _modelURI;
	}

	@Override
	public URI getAnimatorURI() 
	{
		return null;
	}

	@Override
	public int getAnimationDelay() 
	{
		return 0;
	}

	@Override
	public int getDeadlockDetectionDepth() 
	{
		return 10;
	}

	@Override
	public Collection<EngineAddonSpecificationExtension> getEngineAddonExtensions() 
	{
		return new ArrayList<EngineAddonSpecificationExtension>();
	}

	@Override
	public String getDeciderName() 
	{
		return null;
	}

	@Override
	public String getExecutionEntryPoint() 
	{
		return null;
	}

}
