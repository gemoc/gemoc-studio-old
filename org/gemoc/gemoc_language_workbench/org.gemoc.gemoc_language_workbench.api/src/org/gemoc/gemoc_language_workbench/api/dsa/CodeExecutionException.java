package org.gemoc.gemoc_language_workbench.api.dsa;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext;

public class CodeExecutionException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9178319370796707893L;

	private MSEExecutionContext _executionContext;
	
	public CodeExecutionException(String message, MSEExecutionContext call)
	{
		this(message, null, call);
	}

	public CodeExecutionException(String message, Exception innerException, MSEExecutionContext call)
	{
		super(message, innerException);
		_executionContext = call;
	}

	public MSEExecutionContext getExecutionContext()
	{
		return _executionContext;
	}
	
}
