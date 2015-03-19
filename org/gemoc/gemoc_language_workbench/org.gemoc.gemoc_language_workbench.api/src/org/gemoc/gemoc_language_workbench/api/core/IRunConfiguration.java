package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.api.extensions.engine_addon.EngineAddonSpecificationExtension;

public interface IRunConfiguration {

	String getLanguageName();

	URI getExecutedModelURI();
	
	URI getExecutedModelAsMelangeURI();
	
	String getMelangeQuery();
	
	URI getAnimatorURI();

	int getAnimationDelay();

	boolean isTraceActive();
	
	int getDeadlockDetectionDepth();

	Collection<EngineAddonSpecificationExtension> getEngineAddonExtensions();

	String getDeciderName();
		
	String getExecutionEntryPoint();
	
}
