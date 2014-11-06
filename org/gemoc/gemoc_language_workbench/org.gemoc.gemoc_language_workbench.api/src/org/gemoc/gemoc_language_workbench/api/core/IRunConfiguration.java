package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponentExtension;

public interface IRunConfiguration {

	public String getModelURIAsString();
	
	public int getAnimationDelay();

	public boolean isTraceActive();
	
	public int getDeadlockDetectionDepth();

	public Collection<IDataProcessingComponentExtension> getActivatedComponentExtensions();

	public String getAnimatorURIAsString();

	public String getLanguageName();
	
}
