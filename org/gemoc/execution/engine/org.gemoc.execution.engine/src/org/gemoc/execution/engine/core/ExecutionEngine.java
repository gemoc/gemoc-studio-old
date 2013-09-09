package org.gemoc.execution.engine.core;

/**
 * The visible face of the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public interface ExecutionEngine extends Runnable {

	@Override
	public void run();

}