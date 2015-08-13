package org.gemoc.gemoc_language_workbench.api.extensions.engine_addon_group;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.ExtensionPoint;

public class EngineAddonGroupSpecificationExtensionPoint extends ExtensionPoint<EngineAddonGroupSpecificationExtension>
{

	public static final String GEMOC_ENGINE_ADDON_GROUP_EXTENSION_POINT = "org.gemoc.gemoc_language_workbench.engine_addon_group";
	public static final String GEMOC_ENGINE_ADDON_GROUP_EXTENSION_POINT_ID = "id";
	public static final String GEMOC_ENGINE_ADDON_GROUP_EXTENSION_POINT_NAME = "Name";

	protected EngineAddonGroupSpecificationExtensionPoint() 
	{
		super(EngineAddonGroupSpecificationExtension.class);
	}

	private static EngineAddonGroupSpecificationExtensionPoint _singleton;
	
	private static EngineAddonGroupSpecificationExtensionPoint getExtensionPoint()
	{
		if (_singleton == null)
		{
			_singleton = new EngineAddonGroupSpecificationExtensionPoint();
		}
		return _singleton;
	}
		
	static public Collection<EngineAddonGroupSpecificationExtension> getSpecifications()
	{
		return getExtensionPoint().internal_getSpecifications();
	}
	
	@Override
	protected String getExtensionPointName() 
	{
		return GEMOC_ENGINE_ADDON_GROUP_EXTENSION_POINT;
	}
	

	
}
