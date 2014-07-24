package org.gemoc.execution.engine.core;

@SuppressWarnings("serial")
public class EngineNotCorrectlyInitialized extends RuntimeException {
	public EngineNotCorrectlyInitialized(String msg, Throwable innerException)
	{
		super(msg, innerException);
	}
}
