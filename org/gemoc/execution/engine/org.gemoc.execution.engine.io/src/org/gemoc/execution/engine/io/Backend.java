package org.gemoc.execution.engine.io;

import java.util.Observer;

/**
 * A Backend is a configurable Observer... for now.
 * 
 * @author flatombe
 * 
 */
public interface Backend extends Observer {
	public void configure();
}
