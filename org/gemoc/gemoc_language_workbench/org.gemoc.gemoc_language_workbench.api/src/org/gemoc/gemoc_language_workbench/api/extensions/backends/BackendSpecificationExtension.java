package org.gemoc.gemoc_language_workbench.api.extensions.backends;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.extensions.ExecutionComponentExtension;

public class BackendSpecificationExtension extends ExecutionComponentExtension<IBackend>
{

	public IBackend instanciateBackend() throws CoreException 
	{
		return instanciateComponent();
	}

}
