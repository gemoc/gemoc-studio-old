package org.gemoc.gemoc_language_workbench.api.extensions.frontends;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.ExecutionComponentExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.ExtensionPoint;

public class FrontendSpecificationExtensionPoint extends ExtensionPoint<FrontendSpecificationExtension>
{

	public static final String GEMOC_FRONTEND_EXTENSION_POINT = "org.gemoc.gemoc_language_workbench.frontends";
	public static final String GEMOC_FRONTEND_EXTENSION_POINT_NAME = ExecutionComponentExtension.NAME;
	public static final String GEMOC_FRONTEND_EXTENSION_POINT_CLASS = ExecutionComponentExtension.CLASS;

	protected FrontendSpecificationExtensionPoint() 
	{
		super(FrontendSpecificationExtension.class);
	}

	private static FrontendSpecificationExtensionPoint _singleton;
	
	private static FrontendSpecificationExtensionPoint getExtensionPoint()
	{
		if (_singleton == null)
		{
			_singleton = new FrontendSpecificationExtensionPoint();
		}
		return _singleton;
	}
		
	static public Collection<FrontendSpecificationExtension> getSpecifications()
	{
		return getExtensionPoint().internal_getSpecifications();
	}
	
	@Override
	protected String getExtensionPointName() 
	{
		return GEMOC_FRONTEND_EXTENSION_POINT;
	}
	

	
}
