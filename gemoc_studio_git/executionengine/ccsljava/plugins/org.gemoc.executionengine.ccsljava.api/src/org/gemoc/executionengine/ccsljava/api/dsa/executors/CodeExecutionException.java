package org.gemoc.executionengine.ccsljava.api.dsa.executors;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

public class CodeExecutionException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9178319370796707893L;

	private MSEOccurrence _mseOccurrence;
	
	private boolean codeExecutionApplicable = true;
	
	

	public CodeExecutionException(String message, MSEOccurrence mseOccurrence)
	{
		this(message, null, mseOccurrence);
	}
	
	public CodeExecutionException(String message, MSEOccurrence mseOccurrence, boolean codeExecutionApplicable)
	{
		this(message, null, mseOccurrence);
		this.codeExecutionApplicable = codeExecutionApplicable;
	}

	public CodeExecutionException(String message, Exception innerException, MSEOccurrence mseOccurrence)
	{
		super(message, innerException);
		_mseOccurrence = mseOccurrence;
	}
	
	public CodeExecutionException(String message, Exception innerException, MSEOccurrence mseOccurrence, boolean codeExecutionApplicable)
	{
		super(message, innerException);
		_mseOccurrence = mseOccurrence;
		this.codeExecutionApplicable = codeExecutionApplicable;
	}

	public MSEOccurrence getMseOccurrence()
	{		
		return _mseOccurrence;
	}
	
	public boolean isCodeExecutionApplicable() {
		return codeExecutionApplicable;
	}

	public void setCodeExecutionApplicable(boolean codeExecutionApplicable) {
		this.codeExecutionApplicable = codeExecutionApplicable;
	}
	
}
