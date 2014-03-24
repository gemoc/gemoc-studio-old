package org.gemoc.gemoc_language_workbench.api.core;


/**
 * Part of the engine API responsible for basic execution control
 * @author dvojtise
 *
 */
public interface GemocExecutionEngineRunControl {

	/**
	 * Starts the {@link GemocExecutionEngine}.
	 */
	public void start();
	
	/**
	 * Asks the engine to stop
	 */
	public void stop();
	
	public EngineStatus getEngineStatus();
	
}
