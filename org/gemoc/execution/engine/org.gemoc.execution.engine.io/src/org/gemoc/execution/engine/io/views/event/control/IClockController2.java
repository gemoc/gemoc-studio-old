package org.gemoc.execution.engine.io.views.event.control;

public interface IClockController2 {

	public void tickInTheFuture(String clockQualifiedName);
	public void doNotTickInTheFuture(String clockQualifiedName);
	
}
