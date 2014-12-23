package org.gemoc.execution.engine.core;

import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public abstract class OperationExecution 
{

	private ModelSpecificEvent _mse;
	private IExecutionEngine _engine;
	private Object _result;
	
	protected OperationExecution(ModelSpecificEvent mse, IExecutionEngine engine)
	{
		_mse = mse;
		_engine = engine;
	}
	
	abstract public void run();
	
	protected IExecutionContext getExecutionContext() 
	{
		return _engine.getExecutionContext();
	}
	
	protected IExecutionEngine getEngine()
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
