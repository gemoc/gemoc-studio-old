package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponentExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.backends.BackendSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.backends.BackendSpecificationExtensionPoint;
import org.gemoc.gemoc_language_workbench.api.extensions.frontends.FrontendSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.frontends.FrontendSpecificationExtensionPoint;

import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;

public class RunConfiguration implements IRunConfiguration
{
	
	// main launch parameters
	public static final String LAUNCH_MODEL_PATH = "GEMOC_LAUNCH_MODEL_PATH";
	public static final String LAUNCH_DELAY = "GEMOC_ANIMATE_DELAY";
	public static final String LAUNCH_SELECTED_LANGUAGE = "GEMOC_LAUNCH_SELECTED_LANGUAGE";
	public static final String LAUNCH_SELECTED_DECIDER = "GEMOC_LAUNCH_SELECTED_DECIDER";
	public static final String LAUNCH_ACTIVE_TRACE = "GEMOC_LAUNCH_ACTIVE_TRACE";
	
	// parameters that should be derived from the language in future version
	public static final String LAUNCH_DEADLOCK_DETECTION_DEPTH = "GEMOC_LAUNCH_DEADLOCK_DETECTION_DEPTH";
	public static final String DECIDER_SOLVER_PROPOSITION = "Solver proposition";
	public static final String DECIDER_RANDOM = "Random";
	public static final String DECIDER_ASKUSER = "Ask user";
	public static final String DECIDER_ASKUSER_STEP_BY_STEP = "Ask user (step by step)";
	
	
	private ILaunchConfiguration _launchConfiguration;
	
	public RunConfiguration(ILaunchConfiguration launchConfiguration) throws CoreException
	{
		_launchConfiguration = launchConfiguration;
		extractInformation();
	}


	private void extractInformation() throws CoreException 
	{
		_languageName = getAttribute(LAUNCH_SELECTED_LANGUAGE, "");
		_animationDelay = getAttribute(LAUNCH_DELAY, 0);
		_isTraceActive = getAttribute(LAUNCH_ACTIVE_TRACE, false);
		_deciderName = getAttribute(LAUNCH_SELECTED_DECIDER, "");
		_modelURIAsString = getAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, "");
		_animatorURIAsString = getAttribute("airdResource", "");
		_deadlockDetectionDepth = getAttribute(LAUNCH_DEADLOCK_DETECTION_DEPTH, 10);
		
		for (BackendSpecificationExtension extension : BackendSpecificationExtensionPoint.getSpecifications())
		{
			_backends.put(extension, getAttribute(extension.getName(), false));			
		}
		for (FrontendSpecificationExtension extension : FrontendSpecificationExtensionPoint.getSpecifications())
		{
			_frontends.put(extension, getAttribute(extension.getName(), false));			
		}
	}

	private String getAttribute(String attributeName, String defaultValue) throws CoreException
	{
		return _launchConfiguration.getAttribute(attributeName, defaultValue);
	}

	private Integer getAttribute(String attributeName, Integer defaultValue) throws CoreException
	{
		return _launchConfiguration.getAttribute(attributeName, defaultValue);
	}

	private Boolean getAttribute(String attributeName, Boolean defaultValue) throws CoreException
	{
		return _launchConfiguration.getAttribute(attributeName, defaultValue);
	}

	private String _languageName;
	public String getLanguageName() 
	{
		return _languageName;
	}
	
	private int _animationDelay = 0;
	public int getAnimationDelay() 
	{
		return _animationDelay;
	}
	
	private boolean _isTraceActive;
	public boolean isTraceActive() 
	{
		return _isTraceActive;
	}

	private String _deciderName;
	public String getDeciderName()
	{
		return _deciderName;
	}

	private String _modelURIAsString;
	public String getModelURIAsString() 
	{
		return _modelURIAsString;
	}

	private String _animatorURIAsString;
	public String getAnimatorURIAsString() 
	{
		return _animatorURIAsString;
	}
	
	private int _deadlockDetectionDepth = 10;
	@Override
	public int getDeadlockDetectionDepth() 
	{
		return _deadlockDetectionDepth;
	}

	private HashMap<BackendSpecificationExtension, Boolean> _backends = new HashMap<>();

	private HashMap<FrontendSpecificationExtension, Boolean> _frontends = new HashMap<>();

	@Override
	public Collection<IDataProcessingComponentExtension> getActivatedComponentExtensions() 
	{
		ArrayList<IDataProcessingComponentExtension> result = new ArrayList<IDataProcessingComponentExtension>();
		for (Entry<FrontendSpecificationExtension, Boolean> e : _frontends.entrySet())
		{
			if (e.getValue())
				result.add(e.getKey());
		}
		for (Entry<BackendSpecificationExtension, Boolean> e : _backends.entrySet())
		{
			if (e.getValue())
				result.add(e.getKey());
		}
		return result;	
	}

}
