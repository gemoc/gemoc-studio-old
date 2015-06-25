package org.gemoc.gemoc_language_workbench.api.extensions.engine_addon;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.extensions.Extension;

public class EngineAddonSpecificationExtension extends Extension
{

	public String getId()
	{
		return getAttribute(EngineAddonSpecificationExtensionPoint.GEMOC_ENGINE_ADDON_EXTENSION_POINT_ID);
	}

	public String getName()
	{
		return getAttribute(EngineAddonSpecificationExtensionPoint.GEMOC_ENGINE_ADDON_EXTENSION_POINT_NAME);
	}
	
	public String getShortDescription()
	{
		return getAttribute(EngineAddonSpecificationExtensionPoint.GEMOC_ENGINE_ADDON_EXTENSION_POINT_SHORTDESCRIPTION);
	}
	
	public String getAddonGroupId()
	{
		return getAttribute(EngineAddonSpecificationExtensionPoint.GEMOC_ENGINE_ADDON_EXTENSION_POINT_ADDONGROUPID);
	}
	
	public IEngineAddon instanciateComponent() throws CoreException
	{
		Object instance = instanciate(EngineAddonSpecificationExtensionPoint.GEMOC_ENGINE_ADDON_EXTENSION_POINT_CLASS);
		try
		{
			@SuppressWarnings("unchecked")
			IEngineAddon castedInstance = (IEngineAddon)instance;			
			return castedInstance;
		}
		catch(Exception e)
		{
			throwInstanciationCoreException();			
		}
		return null;
	}
	
	public Boolean getDefaultActivationValue() 
	{
		return Boolean.parseBoolean(getAttribute(EngineAddonSpecificationExtensionPoint.GEMOC_ENGINE_ADDON_EXTENSION_POINT_DEFAULT));
	}
	
	
	
}
