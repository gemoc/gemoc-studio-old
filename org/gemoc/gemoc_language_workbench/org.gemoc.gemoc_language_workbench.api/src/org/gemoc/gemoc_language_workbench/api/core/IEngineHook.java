package org.gemoc.gemoc_language_workbench.api.core;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.LogicalStep;


public interface IEngineHook {
	
	/**
	 * Operation called before the engine starts
	 */
	public void engineAboutToStart(GemocExecutionEngine engine);
	public void engineStarted(GemocExecutionEngine executionEngine);

	
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


	public void aboutToExecuteLogicalStep(GemocExecutionEngine executionEngine, LogicalStep logicalStepToApply);


	public void aboutToExecuteMSE(GemocExecutionEngine executionEngine, ModelSpecificEvent mse);	
	

}
