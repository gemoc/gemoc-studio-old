package org.gemoc.gemoc_language_workbench.api.core;

import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.LogicalStep;


public interface IEngineHook {
	
	/**
	 * Operation called before the engine starts
	 */
	public void engineAboutToStart(IExecutionEngine engine);
	public void engineStarted(IExecutionEngine executionEngine);

	
	/**
	 * Operation called before the LogicalStep has been chosen
	 */
	public void preLogicalStepSelection(IExecutionEngine engine);
	
	/**
	 * Operation called after the LogicalStep has been chosen
	 * It also returns the chosen LogicalStep
	 */
	public void postLogicalStepSelection(IExecutionEngine engine);
	
	/**
	 * Operation called after the engine has been stopped
	 */
	public void postStopEngine(IExecutionEngine engine);


	public void aboutToExecuteLogicalStep(IExecutionEngine engine, LogicalStep logicalStepToApply);


	public void aboutToExecuteMSE(IExecutionEngine engine, ModelSpecificEvent mse);
	public void engineStatusHasChanged(IExecutionEngine engine, RunStatus newStatus);	
	

}
