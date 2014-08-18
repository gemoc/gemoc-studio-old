package org.gemoc.gemoc_language_workbench.api.extensions;

import org.eclipse.core.runtime.CoreException;


public abstract class DataProcessingComponentExtension<T extends IDataProcessingComponent> extends Extension implements IDataProcessingComponentExtension
{
	
	public static final String NAME = "Name";
	public static final String CLASS = "Class";
	public static final String DEFAULT = "Default";

	public abstract DataProcessingComponentType getType();
	
	public String getName()
	{
		return getAttribute(NAME);
	}

	@Override
	public IDataProcessingComponent instanciateComponent() throws CoreException
	{
		return instanciateCastedComponent();
	}
	
	public T instanciateCastedComponent() throws CoreException
	{
		Object instance = instanciate(CLASS);
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
	
	public Boolean getDefaultActivationValue() 
	{
		return Boolean.parseBoolean(getAttribute(DEFAULT));
	}

}
