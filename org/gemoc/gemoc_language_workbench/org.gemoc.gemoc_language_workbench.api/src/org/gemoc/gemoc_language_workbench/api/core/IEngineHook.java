package org.gemoc.gemoc_language_workbench.api.core;


public interface IEngineHook {
	
	/**
	 * Operation called before the engine starts
	 */
	public void preStartEngine(GemocExecutionEngine engine);
	
	
	/**
	 * Operation called before the LogicalStep has been chosen
	 */
	public void preLogicalStepSelection(GemocExecutionEngine engine);
	
	/**
	 * Operation called after the LogicalStep has been chosen
	 * It also returns the chosen LogicalStep
	 */
	public void postLogicalStepSelection(GemocExecutionEngine engine);
	
	/**
	 * Operation called after the engine has been stopped
	 */
	public void postStopEngine(GemocExecutionEngine engine);
	
	

}
