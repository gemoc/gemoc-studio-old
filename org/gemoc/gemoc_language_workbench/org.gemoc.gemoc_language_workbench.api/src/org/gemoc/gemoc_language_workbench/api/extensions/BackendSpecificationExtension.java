package org.gemoc.gemoc_language_workbench.api.extensions;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.core.IBackend;

public class BackendSpecificationExtension extends Extension
{

	public String getName()
	{
		return getAttribute(DeciderSpecificationExtensionPoint.GEMOC_DECIDER_EXTENSION_POINT_NAME);
	}

	public IBackend instanciateBackend() throws CoreException 
	{
		Object instance = instanciate(DeciderSpecificationExtensionPoint.GEMOC_DECIDER_EXTENSION_POINT_CLASS);
		if (instance instanceof IBackend) {
			return(IBackend) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

}
