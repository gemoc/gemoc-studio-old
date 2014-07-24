package org.gemoc.gemoc_language_workbench.api.extensions.backends;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.extensions.Extension;

public class BackendSpecificationExtension extends Extension
{

	public String getName()
	{
		return getAttribute(BackendSpecificationExtensionPoint.GEMOC_BACKEND_EXTENSION_POINT_NAME);
	}

	public IBackend instanciateBackend() throws CoreException 
	{
		Object instance = instanciate(BackendSpecificationExtensionPoint.GEMOC_BACKEND_EXTENSION_POINT_CLASS);
		if (instance instanceof IBackend) {
			return(IBackend) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

}
