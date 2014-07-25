package org.gemoc.gemoc_language_workbench.api.extensions.backends;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.ExecutionComponentExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.ExtensionPoint;

public class BackendSpecificationExtensionPoint extends ExtensionPoint<BackendSpecificationExtension>
{

	public static final String GEMOC_BACKEND_EXTENSION_POINT = "org.gemoc.gemoc_language_workbench.backends";
	public static final String GEMOC_BACKEND_EXTENSION_POINT_NAME = ExecutionComponentExtension.NAME;
	public static final String GEMOC_BACKEND_EXTENSION_POINT_CLASS = ExecutionComponentExtension.CLASS;

	protected BackendSpecificationExtensionPoint() 
	{
		super(BackendSpecificationExtension.class);
	}

	private static BackendSpecificationExtensionPoint _singleton;
	
	private static BackendSpecificationExtensionPoint getExtensionPoint()
	{
		if (_singleton == null)
		{
			_singleton = new BackendSpecificationExtensionPoint();
		}
		return _singleton;
	}
		
	static public Collection<BackendSpecificationExtension> getSpecifications()
	{
		return getExtensionPoint().internal_getSpecifications();
	}
	
	@Override
	protected String getExtensionPointName() 
	{
		return GEMOC_BACKEND_EXTENSION_POINT;
	}
	

	
}
