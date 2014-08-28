package org.gemoc.gemoc_modeling_workbench.ui.launcher.tabs;

import java.util.ArrayList;
import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponentExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.frontends.FrontendSpecificationExtensionPoint;

public class ModelLauncherFrontendsTab extends ModelLauncherDataProcessingTab 
{

	@Override
	public String getName() 
	{
		return "Frontends";
	}
	
	@Override
	protected Collection<IDataProcessingComponentExtension> getExtensionSpecifications() 
	{
		ArrayList<IDataProcessingComponentExtension> result = new ArrayList<IDataProcessingComponentExtension>();
		result.addAll(FrontendSpecificationExtensionPoint.getSpecifications());
		return result;
	}
	
}
