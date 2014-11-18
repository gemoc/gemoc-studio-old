package org.gemoc.gemoc_language_workbench.api.core;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.LogicalStep;


public class DefaultEngineHook implements IEngineHook {

	@Override
	public void engineAboutToStart(IExecutionEngine engine) 
	{
	}

	@Override
	public void engineStarted(IExecutionEngine executionEngine) 
	{
	}

	@Override
	public void preLogicalStepSelection(IExecutionEngine engine) 
	{
	}

	@Override
	public void postLogicalStepSelection(IExecutionEngine engine) 
	{
	}

	@Override
	public void postStopEngine(IExecutionEngine engine) 
	{
	}


	@Override
	public void aboutToExecuteLogicalStep(IExecutionEngine executionEngine, LogicalStep logicalStepToApply) 
	{
	}


	@Override
	public void aboutToExecuteMSE(IExecutionEngine executionEngine, ModelSpecificEvent mse) 
	{
	}

}
