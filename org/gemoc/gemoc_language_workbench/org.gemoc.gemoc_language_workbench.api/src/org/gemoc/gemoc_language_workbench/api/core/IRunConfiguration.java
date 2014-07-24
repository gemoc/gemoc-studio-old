package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.backends.BackendSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.frontends.FrontendSpecificationExtension;

public interface IRunConfiguration {

	public String getModelURIAsString();
	
	public int getAnimationDelay();

	public boolean isTraceActive();
	
	public int getDeadlockDetectionDepth();

	public Collection<BackendSpecificationExtension> getActivatedBackendExtensions();

	public Collection<FrontendSpecificationExtension> getActivatedFrontendExtensions();

}
