package org.gemoc.execution.engine.core;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public abstract class OperationExecution 
{

	private ModelSpecificEvent _mse;
	private GemocExecutionEngine _engine;
	private Object _result;
	
	protected OperationExecution(ModelSpecificEvent mse, GemocExecutionEngine engine)
	{
		_mse = mse;
		_engine = engine;
	}
	
	abstract public void run();
	
	protected IExecutionContext getExecutionContext() 
	{
		return _engine.getExecutionContext();
	}
	
	protected GemocExecutionEngine getEngine()
	{
		return _engine;
	}
	
	protected ModelSpecificEvent getMSE()
	{
		return _mse;
	}

	protected void setResult(Object result)
	{
		_result = result;
	}
	
	protected Object getResult()
	{
		return _result;
	}
}
