package org.gemoc.execution.engine.io.views;

public interface IClockController2 {

	public void tickInTheFuture(String clockQualifiedName);
	public void doNotTickInTheFuture(String clockQualifiedName);
	
}
