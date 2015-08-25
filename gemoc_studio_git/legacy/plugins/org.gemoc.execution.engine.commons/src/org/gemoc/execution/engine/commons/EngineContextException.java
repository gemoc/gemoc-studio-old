package org.gemoc.execution.engine.commons;

public class EngineContextException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8964957013028069014L;

	public EngineContextException(String message) 
	{
		super(message);
	}

	public EngineContextException(String message, Exception innerException) 
	{
		super(message, innerException);
	}

}
