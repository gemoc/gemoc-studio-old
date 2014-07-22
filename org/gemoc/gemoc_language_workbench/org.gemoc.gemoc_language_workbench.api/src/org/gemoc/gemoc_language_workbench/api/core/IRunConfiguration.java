package org.gemoc.gemoc_language_workbench.api.core;

public interface IRunConfiguration {

	public String getModelURIAsString();
	
	public int getAnimationDelay();

	public boolean isTraceActive();
	
	public int getDeadlockDetectionDepth();

}
