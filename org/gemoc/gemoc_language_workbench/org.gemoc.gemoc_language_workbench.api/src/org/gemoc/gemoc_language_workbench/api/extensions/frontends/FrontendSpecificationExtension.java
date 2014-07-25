package org.gemoc.gemoc_language_workbench.api.extensions.frontends;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.extensions.ExecutionComponentExtension;

public class FrontendSpecificationExtension extends ExecutionComponentExtension<IFrontend>
{

	public IFrontend instanciateFrontend() throws CoreException 
	{
		return instanciateComponent();
	}

}
