package org.gemoc.gemoc_modeling_workbench.ui.launcher.tabs;

import java.util.ArrayList;
import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtensionPoint;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon_group.EngineAddonGroupSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon_group.EngineAddonGroupSpecificationExtensionPoint;

public class LaunchConfigurationBackendsTab extends LaunchConfigurationDataProcessingTab 
{

	@Override
	public String getName() 
	{
		return "Engine Addons";
	}
	
	@Override
	protected Collection<EngineAddonSpecificationExtension> getExtensionSpecifications() 
	{
		ArrayList<EngineAddonSpecificationExtension> result = new ArrayList<EngineAddonSpecificationExtension>();		
		result.addAll(EngineAddonSpecificationExtensionPoint.getSpecifications());
		return result;
	}
	
	@Override
	protected Collection<EngineAddonGroupSpecificationExtension> getGroupExtensionSpecifications() 
	{
		ArrayList<EngineAddonGroupSpecificationExtension> result = new ArrayList<EngineAddonGroupSpecificationExtension>();		
		result.addAll(EngineAddonGroupSpecificationExtensionPoint.getSpecifications());
		return result;
	}
		
}
