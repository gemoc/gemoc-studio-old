package org.gemoc.gemoc_language_workbench.api.extensions.frontends;

import org.gemoc.gemoc_language_workbench.api.extensions.DataProcessingComponentExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.DataProcessingComponentType;

public class FrontendSpecificationExtension extends DataProcessingComponentExtension<IFrontend>
{

//	public IFrontend instanciateFrontend() throws CoreException 
//	{
//		return instanciateCastedComponent();
//	}

	@Override
	public DataProcessingComponentType getType() 
	{
		return DataProcessingComponentType.Frontend;
	}

}
