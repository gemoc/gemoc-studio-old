package org.gemoc.gemoc_language_workbench.api.dsa;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

public class CodeExecutionException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9178319370796707893L;

	private MSEOccurrence _mseOccurrence;
	
	public CodeExecutionException(String message, MSEOccurrence mseOccurrence)
	{
		this(message, null, mseOccurrence);
	}

	public CodeExecutionException(String message, Exception innerException, MSEOccurrence mseOccurrence)
	{
		super(message, innerException);
		_mseOccurrence = mseOccurrence;
	}

	public MSEOccurrence getMseOccurrence()
	{		
		return _mseOccurrence;
	}
	
}
