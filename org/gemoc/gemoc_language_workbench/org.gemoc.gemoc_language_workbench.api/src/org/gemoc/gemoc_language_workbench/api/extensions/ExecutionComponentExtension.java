package org.gemoc.gemoc_language_workbench.api.extensions;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.extensions.backends.BackendSpecificationExtensionPoint;


public class ExecutionComponentExtension<T> extends Extension
{
	
	public static final String NAME = "Name";
	public static final String CLASS = "Class";

	public String getName()
	{
		return getAttribute(NAME);
	}

	protected T instanciateComponent() throws CoreException
	{
		Object instance = instanciate(BackendSpecificationExtensionPoint.GEMOC_BACKEND_EXTENSION_POINT_CLASS);
		try
		{
			@SuppressWarnings("unchecked")
			T castedInstance = (T)instance;			
			return castedInstance;
		}
		catch(Exception e)
		{
			throwInstanciationCoreException();			
		}
		return null;
	}
	
}
