package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.api.engine_addon.EngineAddonSpecificationExtension;

public interface IRunConfiguration {

	String getLanguageName();

	URI getExecutedModelURI();
	
	URI getAnimatorURI();

	int getAnimationDelay();

	boolean isTraceActive();
	
	int getDeadlockDetectionDepth();

	Collection<EngineAddonSpecificationExtension> getActivatedComponentExtensions();

	String getDeciderName();
		
	String getExecutionEntryPoint();

	Object instanciateJavaEntryPoint() throws CoreException;
	
}
