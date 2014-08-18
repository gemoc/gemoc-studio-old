package org.gemoc.gemoc_language_workbench.api.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Status;
import org.gemoc.gemoc_language_workbench.api.Activator;

public class Extension 
{

	protected IConfigurationElement _configurationElement;

	void setSpecification(IConfigurationElement configurationElement) 
	{
		_configurationElement = configurationElement;
	}

	protected String getAttribute(String attributeName) {
		return _configurationElement.getAttribute(attributeName);
	}

	protected Object instanciate(String attributeName) throws CoreException {
		try
		{
			return _configurationElement.createExecutableExtension(attributeName);
		}
		catch(CoreException e)
		{
			String message = "Instanciation of one agent failed (see inner exception).";
			CoreException exception = new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message, e));
			throw exception;
		}
	}

	protected void throwInstanciationCoreException() throws CoreException {
		String message = "Instanciation succeeded but object is not of correct type.";
		CoreException exception = new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message));
		throw exception;
	}


}
