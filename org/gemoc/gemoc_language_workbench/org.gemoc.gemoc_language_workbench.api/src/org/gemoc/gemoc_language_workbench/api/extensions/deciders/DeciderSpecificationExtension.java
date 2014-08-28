package org.gemoc.gemoc_language_workbench.api.extensions.deciders;

import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.extensions.Extension;
import org.osgi.framework.Bundle;

public class DeciderSpecificationExtension extends Extension
{

	private String getIconPath()
	{
		return getAttribute(DeciderSpecificationExtensionPoint.GEMOC_DECIDER_EXTENSION_POINT_ICONPATH);
	}
	
	public URL getIconURL() 
	{
		String bundleId = _configurationElement.getDeclaringExtension().getNamespaceIdentifier();
		Bundle bundle = Platform.getBundle(bundleId);
		return bundle.getResource(getIconPath());
	}

	public String getName() 
	{
		return getAttribute(DeciderSpecificationExtensionPoint.GEMOC_DECIDER_EXTENSION_POINT_NAME);
	}

	public String getDescription() 
	{
		return getAttribute(DeciderSpecificationExtensionPoint.GEMOC_DECIDER_EXTENSION_POINT_Description);
	}

	public String getDeciderClassName() 
	{
		return getAttribute(DeciderSpecificationExtensionPoint.GEMOC_DECIDER_EXTENSION_POINT_CLASS);
	}

	public ILogicalStepDecider instanciateDecider() throws CoreException 
	{
		return (ILogicalStepDecider)_configurationElement.createExecutableExtension(DeciderSpecificationExtensionPoint.GEMOC_DECIDER_EXTENSION_POINT_CLASS);
	}
	
}
