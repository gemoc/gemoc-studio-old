package org.gemoc.gemoc_language_workbench.api.engine_addon;

import java.util.Collection;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;


public class DefaultEngineAddon implements IEngineAddon {

	@Override
	public void engineAboutToStart(IExecutionEngine engine) 
	{
	}

	@Override
	public void engineStarted(IExecutionEngine executionEngine) 
	{
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) 
	{
	}

	@Override
	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) 
	{
	}

	@Override
	public void engineStopped(IExecutionEngine engine) 
	{
	}


	@Override
	public void aboutToExecuteLogicalStep(IExecutionEngine executionEngine, LogicalStep logicalStepToApply) 
	{
	}


	@Override
	public void aboutToExecuteMSEOccurrence(IExecutionEngine executionEngine, MSEOccurrence mseOccurrence) 
	{
	}

	@Override
	public void engineStatusChanged(IExecutionEngine engineRunnable, RunStatus newStatus) 
	{
	}

	@Override
	public void engineAboutToStop(IExecutionEngine engine) 
	{
	}

	@Override
	public void logicalStepExecuted(IExecutionEngine engine, LogicalStep logicalStepExecuted) 
	{
	}

	@Override
	public void mseOccurrenceExecuted(IExecutionEngine engine, MSEOccurrence mseOccurrence) 
	{
	}

	@Override
	public void proposedLogicalStepsChanged(IExecutionEngine engine,
			Collection<LogicalStep> logicalSteps) {
		// TODO Auto-generated method stub
		
	}

}
