package org.gemoc.gemoc_language_workbench.api.extensions.engine_addon;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.ExtensionPoint;

public class EngineAddonSpecificationExtensionPoint extends ExtensionPoint<EngineAddonSpecificationExtension>
{

	public static final String GEMOC_ENGINE_ADDON_EXTENSION_POINT = "org.gemoc.gemoc_language_workbench.engine_addon";
	public static final String GEMOC_ENGINE_ADDON_EXTENSION_POINT_ID = "id";
	public static final String GEMOC_ENGINE_ADDON_EXTENSION_POINT_NAME = "Name";
	public static final String GEMOC_ENGINE_ADDON_EXTENSION_POINT_SHORTDESCRIPTION = "ShortDescription";
	public static final String GEMOC_ENGINE_ADDON_EXTENSION_POINT_CLASS = "Class";
	public static final String GEMOC_ENGINE_ADDON_EXTENSION_POINT_DEFAULT = "Default";
	public static final String GEMOC_ENGINE_ADDON_EXTENSION_POINT_ADDONGROUPID = "AddonGroupId";

	protected EngineAddonSpecificationExtensionPoint() 
	{
		super(EngineAddonSpecificationExtension.class);
	}

	private static EngineAddonSpecificationExtensionPoint _singleton;
	
	private static EngineAddonSpecificationExtensionPoint getExtensionPoint()
	{
		if (_singleton == null)
		{
			_singleton = new EngineAddonSpecificationExtensionPoint();
		}
		return _singleton;
	}
		
	static public Collection<EngineAddonSpecificationExtension> getSpecifications()
	{
		return getExtensionPoint().internal_getSpecifications();
	}
	
	@Override
	protected String getExtensionPointName() 
	{
		return GEMOC_ENGINE_ADDON_EXTENSION_POINT;
	}
	

	
}
