package org.gemoc.execution.engine.core;

/**
 * The visible face of the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public interface ExecutionEngine {
    
    public void run();

	public void run(int numberOfSteps);
	
	public void runOneStep();

}