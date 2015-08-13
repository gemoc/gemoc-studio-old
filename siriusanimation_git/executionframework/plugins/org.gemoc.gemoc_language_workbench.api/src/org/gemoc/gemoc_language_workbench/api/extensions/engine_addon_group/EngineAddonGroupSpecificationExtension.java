package org.gemoc.gemoc_language_workbench.api.extensions.engine_addon_group;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.extensions.Extension;

public class EngineAddonGroupSpecificationExtension extends Extension
{

	public String getId()
	{
		return getAttribute(EngineAddonGroupSpecificationExtensionPoint.GEMOC_ENGINE_ADDON_GROUP_EXTENSION_POINT_ID);
	}

	public String getName()
	{
		return getAttribute(EngineAddonGroupSpecificationExtensionPoint.GEMOC_ENGINE_ADDON_GROUP_EXTENSION_POINT_NAME);
	}
	
}
