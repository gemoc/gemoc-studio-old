package org.gemoc.executionengine.ccsljava.engine.dse;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.executionengine.ccsljava.api.core.INonDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;

public abstract class OperationExecution 
{

	private MSEOccurrence _mseOccurrence;
	private INonDeterministicExecutionEngine _engine;
	private Object _result;
	
	protected OperationExecution(MSEOccurrence mseOccurrence, INonDeterministicExecutionEngine engine)
	{
		_mseOccurrence = mseOccurrence;
		_engine = engine;
	}
	
	abstract public void run();
	
	protected IExecutionContext getExecutionContext() 
	{
		return _engine.getExecutionContext();
	}
	
	protected INonDeterministicExecutionEngine getEngine()
	{
		return _engine;
	}
	
	protected MSEOccurrence getMSEOccurrence()
	{
		return _mseOccurrence;
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
