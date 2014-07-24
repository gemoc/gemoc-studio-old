package org.gemoc.gemoc_language_workbench.api.extensions.frontends;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.extensions.Extension;

public class FrontendSpecificationExtension extends Extension
{

	public String getName()
	{
		return getAttribute(FrontendSpecificationExtensionPoint.GEMOC_FRONTEND_EXTENSION_POINT_NAME);
	}

	public IFrontend instanciateFrontend() throws CoreException 
	{
		Object instance = instanciate(FrontendSpecificationExtensionPoint.GEMOC_FRONTEND_EXTENSION_POINT_CLASS);
		if (instance instanceof IFrontend) {
			return(IFrontend) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

}
