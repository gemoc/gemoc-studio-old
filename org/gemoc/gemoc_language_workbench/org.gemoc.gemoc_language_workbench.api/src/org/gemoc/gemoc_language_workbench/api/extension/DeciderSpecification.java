package org.gemoc.gemoc_language_workbench.api.extension;

import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.osgi.framework.Bundle;

public class DeciderSpecification 
{
	
	private IConfigurationElement _configurationElement;

	public DeciderSpecification(IConfigurationElement configurationElement)
	{
		_configurationElement = configurationElement;
	}

	private String getIconPath()
	{
		return _configurationElement.getAttribute(DeciderSpecificationExtension.GEMOC_DECIDER_EXTENSION_POINT_ICONPATH);
	}
	
	public URL getIconURL() 
	{
		String bundleId = _configurationElement.getDeclaringExtension().getNamespaceIdentifier();
		Bundle bundle = Platform.getBundle(bundleId);
		return bundle.getResource(getIconPath());
	}

	public String getName() 
	{
		return _configurationElement.getAttribute(DeciderSpecificationExtension.GEMOC_DECIDER_EXTENSION_POINT_NAME);
	}

	public String getDescription() 
	{
		return _configurationElement.getAttribute(DeciderSpecificationExtension.GEMOC_DECIDER_EXTENSION_POINT_Description);
	}

	public String getDeciderClassName() 
	{
		return _configurationElement.getAttribute(DeciderSpecificationExtension.GEMOC_DECIDER_EXTENSION_POINT_CLASS);
	}

	public ILogicalStepDecider instanciateDecider() throws CoreException 
	{
		return (ILogicalStepDecider)_configurationElement.createExecutableExtension(DeciderSpecificationExtension.GEMOC_DECIDER_EXTENSION_POINT_CLASS);
	}
	
}
