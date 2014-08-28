package org.gemoc.gemoc_language_workbench.api.extensions.backends;

import org.gemoc.gemoc_language_workbench.api.extensions.DataProcessingComponentExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.DataProcessingComponentType;

public class BackendSpecificationExtension extends DataProcessingComponentExtension<IBackend>
{

//	public IBackend instanciateBackend() throws CoreException 
//	{
//		return instanciateCastedComponent();
//	}

	@Override
	public DataProcessingComponentType getType() 
	{
		return DataProcessingComponentType.Backend;
	}

}
