package org.gemoc.gemoc_modeling_workbench.ui.launcher.tabs;

import java.util.ArrayList;
import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponentExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.backends.BackendSpecificationExtensionPoint;

public class LaunchConfigurationBackendsTab extends LaunchConfigurationDataProcessingTab 
{

	@Override
	public String getName() 
	{
		return "Backends";
	}
	
	@Override
	protected Collection<IDataProcessingComponentExtension> getExtensionSpecifications() 
	{
		ArrayList<IDataProcessingComponentExtension> result = new ArrayList<IDataProcessingComponentExtension>();
		result.addAll(BackendSpecificationExtensionPoint.getSpecifications());
		return result;
	}
		
}
