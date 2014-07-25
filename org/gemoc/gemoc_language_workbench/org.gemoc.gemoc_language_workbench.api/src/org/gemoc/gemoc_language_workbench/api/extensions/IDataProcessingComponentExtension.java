package org.gemoc.gemoc_language_workbench.api.extensions;

import org.eclipse.core.runtime.CoreException;

public interface IDataProcessingComponentExtension 
{

	IDataProcessingComponent instanciateComponent() throws CoreException;

	String getName();

	Boolean getDefaultActivationValue();

}
