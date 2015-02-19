package org.gemoc.execution.engine.core;

import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public class PlainK3ExecutionEngine implements IExecutionEngine
{

	private IExecutionContext _executionContext;

	public PlainK3ExecutionEngine(IExecutionContext context) 
	{
		_executionContext = context;
	}
	
	@Override
	public void dispose() 
	{
	}

	@Override
	public void start() 
	{
	}

	@Override
	public void stop() 
	{
	}

	@Override
	public EngineStatus getEngineStatus() 
	{
		return null;
	}

	@Override
	public <T extends IEngineAddon> boolean hasAddon(Class<T> type) {
		for (IEngineAddon c : _executionContext.getExecutionPlatform().getEngineAddons()) {
			if (c.getClass().equals(type))
				return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("all")
	public <T extends IEngineAddon> T getAddon(Class<T> type) {
		for (IEngineAddon c : _executionContext.getExecutionPlatform().getEngineAddons()) {
			if (c.getClass().equals(type))
				return (T) c;
		}
		return null;
	}

	@Override
	public IExecutionContext getExecutionContext() 
	{
		return _executionContext;
	}

	@Override
	public List<LogicalStep> getPossibleLogicalSteps() 
	{
		return null;
	}

	@Override
	public LogicalStep getSelectedLogicalStep() 
	{
		return null;
	}

	@Override
	public void addFutureAction(IFutureAction action) 
	{
	}

	@Override
	public RunStatus getRunningStatus() 
	{
		return null;
	}

}
