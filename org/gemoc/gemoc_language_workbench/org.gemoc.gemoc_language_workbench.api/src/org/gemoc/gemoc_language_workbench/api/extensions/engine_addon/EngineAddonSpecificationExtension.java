package org.gemoc.gemoc_language_workbench.api.extensions.engine_addon;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.extensions.Extension;

public class EngineAddonSpecificationExtension extends Extension
{

	public static final String NAME = "Name";
	public static final String CLASS = "Class";
	public static final String DEFAULT = "Default";

	public String getName()
	{
		return getAttribute(NAME);
	}
	
	public IEngineAddon instanciateComponent() throws CoreException
	{
		Object instance = instanciate(CLASS);
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
		return Boolean.parseBoolean(getAttribute(DEFAULT));
	}
	
}
