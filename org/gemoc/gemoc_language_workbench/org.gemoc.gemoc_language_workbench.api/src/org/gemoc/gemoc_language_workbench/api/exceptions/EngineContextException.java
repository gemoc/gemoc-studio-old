package org.gemoc.gemoc_language_workbench.api.exceptions;

public class EngineContextException extends Exception {

	public EngineContextException(String message) 
	{
		super(message);
	}

	public EngineContextException(String message, Exception innerException) 
	{
		super(message, innerException);
	}

}
