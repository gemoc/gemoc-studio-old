package org.gemoc.gemoc_language_workbench.api.core;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.LogicalStep;


public class DefaultEngineHook implements IEngineHook {

	@Override
	public void engineAboutToStart(GemocExecutionEngine engine) 
	{
	}

	@Override
	public void engineStarted(GemocExecutionEngine executionEngine) 
	{
	}

	@Override
	public void preLogicalStepSelection(GemocExecutionEngine engine) 
	{
	}

	@Override
	public void postLogicalStepSelection(GemocExecutionEngine engine) 
	{
	}

	@Override
	public void postStopEngine(GemocExecutionEngine engine) 
	{
	}


	@Override
	public void aboutToExecuteLogicalStep(GemocExecutionEngine executionEngine, LogicalStep logicalStepToApply) 
	{
	}


	@Override
	public void aboutToExecuteMSE(GemocExecutionEngine executionEngine, ModelSpecificEvent mse) 
	{
	}

}
