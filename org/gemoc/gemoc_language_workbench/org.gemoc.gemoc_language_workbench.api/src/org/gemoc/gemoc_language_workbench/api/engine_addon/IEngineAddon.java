package org.gemoc.gemoc_language_workbench.api.engine_addon;

import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.LogicalStep;

public interface IEngineAddon {

	/**
	 * Operation called before the engine starts
	 */
	public void engineAboutToStart(IExecutionEngine engine);
	
	public void engineStarted(IExecutionEngine executionEngine);

	
	public void engineAboutToStop(IExecutionEngine engine);
	/**
	 * Operation called after the engine has been stopped
	 */
	public void engineStopped(IExecutionEngine engine);
	
	
	/**
	 * Operation called before the LogicalStep has been chosen
	 */
	public void aboutToSelectLogicalStep(IExecutionEngine engine);
	
	/**
	 * Operation called after the LogicalStep has been chosen
	 * It also returns the chosen LogicalStep
	 */
	public void logicalStepSelected(IExecutionEngine engine);
	

	public void aboutToExecuteLogicalStep(IExecutionEngine engine, LogicalStep logicalStepToExecute);
	public void logicalStepExecuted(IExecutionEngine engine, LogicalStep logicalStepExecuted);


	public void aboutToExecuteMSE(IExecutionEngine engine, ModelSpecificEvent mse);
	public void mseExecuted(IExecutionEngine engine, ModelSpecificEvent mse);

	public void engineStatusChanged(IExecutionEngine engine, RunStatus newStatus);	
	
}
