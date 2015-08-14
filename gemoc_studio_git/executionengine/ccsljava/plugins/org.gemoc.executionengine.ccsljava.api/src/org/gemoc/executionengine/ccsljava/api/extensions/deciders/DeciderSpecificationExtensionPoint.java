package org.gemoc.executionengine.ccsljava.api.extensions.deciders;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.ExtensionPoint;

public class DeciderSpecificationExtensionPoint extends ExtensionPoint<DeciderSpecificationExtension>
{

	public static final String GEMOC_DECIDER_EXTENSION_POINT = "org.gemoc.gemoc_language_workbench.deciders";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_NAME = "Name";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_CLASS = "Class";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_Description = "Description";
	public static final String GEMOC_DECIDER_EXTENSION_POINT_ICONPATH = "Icon";


	protected DeciderSpecificationExtensionPoint() 
	{
		super(DeciderSpecificationExtension.class);
	}

	
	private static DeciderSpecificationExtensionPoint _singleton;
	
	private static DeciderSpecificationExtensionPoint getExtensionPoint()
	{
		if (_singleton == null)
		{
			_singleton = new DeciderSpecificationExtensionPoint();
		}
		return _singleton;
	}
		
	static public Collection<DeciderSpecificationExtension> getSpecifications() 
	{
		return getExtensionPoint().internal_getSpecifications();
	}


	@Override
	protected String getExtensionPointName()
	{
		return GEMOC_DECIDER_EXTENSION_POINT;
	}
	
	static public DeciderSpecificationExtension findDefinition(String deciderName)
	{
		for (DeciderSpecificationExtension extension : getSpecifications())
		{
			if (extension.getName().equals(deciderName))
			{
				return extension;
			}
		}
		return null;
	}
}
