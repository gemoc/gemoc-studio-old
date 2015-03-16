package org.gemoc.execution.engine.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.api.core.IRunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtensionPoint;

import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;

public class RunConfiguration implements IRunConfiguration
{
	
	// main launch parameters
	public static final String LAUNCH_MODEL_PATH = "GEMOC_LAUNCH_MODEL_PATH";
	public static final String LAUNCH_DELAY = "GEMOC_ANIMATE_DELAY";
	public static final String LAUNCH_SELECTED_LANGUAGE = "GEMOC_LAUNCH_SELECTED_LANGUAGE";
	public static final String LAUNCH_SELECTED_DECIDER = "GEMOC_LAUNCH_SELECTED_DECIDER";
	public static final String LAUNCH_ENTRY_POINT = "GEMOC_LAUNCH_ENTRY_POINT";
	
	// parameters that should be derived from the language in future version
	public static final String LAUNCH_DEADLOCK_DETECTION_DEPTH = "GEMOC_LAUNCH_DEADLOCK_DETECTION_DEPTH";
	public static final String DECIDER_SOLVER = "Solver decider";
	public static final String DECIDER_ASKUSER_STEP_BY_STEP = "Step by step user decider";
	
	
	private ILaunchConfiguration _launchConfiguration;
	
	public RunConfiguration(ILaunchConfiguration launchConfiguration) throws CoreException
	{
		_launchConfiguration = launchConfiguration;
		extractInformation();
	}


	private void extractInformation() throws CoreException 
	{
		_languageName = getAttribute(LAUNCH_SELECTED_LANGUAGE, "");
		_modelURI = URI.createPlatformResourceURI(
				getAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, ""),
				true);
		String animatorURIAsString = getAttribute("airdResource", "");
		if (animatorURIAsString != null
			&& !animatorURIAsString.equals(""))
		{
			_animatorURI = URI.createPlatformResourceURI(
					animatorURIAsString,
					true);
			_animationDelay = getAttribute(LAUNCH_DELAY, 0);
		}
		_deciderName = getAttribute(LAUNCH_SELECTED_DECIDER, "");
		_deadlockDetectionDepth = getAttribute(LAUNCH_DEADLOCK_DETECTION_DEPTH, 10);
		_entryPoint = getAttribute(LAUNCH_ENTRY_POINT, "");
		
		for (EngineAddonSpecificationExtension extension : EngineAddonSpecificationExtensionPoint.getSpecifications())
		{
			_engineAddonExtensions.put(extension, getAttribute(extension.getName(), false));			
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

	private String _deciderName;	
	@Override
	public String getDeciderName()
	{
		return _deciderName;
	}

	private URI _modelURI;
	@Override
	public URI getExecutedModelURI() 
	{
		return _modelURI;
	}

	private URI _animatorURI;
	@Override
	public URI getAnimatorURI() 
	{
		return _animatorURI;
	}
	
	private int _deadlockDetectionDepth = 10;
	@Override
	public int getDeadlockDetectionDepth() 
	{
		return _deadlockDetectionDepth;
	}

	private HashMap<EngineAddonSpecificationExtension, Boolean> _engineAddonExtensions = new HashMap<>();

	@Override
	public Collection<EngineAddonSpecificationExtension> getEngineAddonExtensions() 
	{
		ArrayList<EngineAddonSpecificationExtension> result = new ArrayList<EngineAddonSpecificationExtension>();
		for (Entry<EngineAddonSpecificationExtension, Boolean> e : _engineAddonExtensions.entrySet())
		{
			if (e.getValue())
				result.add(e.getKey());
		}
		return result;	
	}


	private String _entryPoint;
	@Override
	public String getExecutionEntryPoint() 
	{
		return _entryPoint;
	}

}
