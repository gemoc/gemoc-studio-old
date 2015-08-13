package org.gemoc.execution.engine.core;


/**
 * Exception thrown when the user stop the engine in plainK3 mode or if the engine is stopped normally
 * This allows to catch it and adapt the Engine response in this normal situation
 * @author dvojtise
 *
 */
public class EngineStoppedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8485492707115640348L;
	
	public EngineStoppedException(String message) {
		super(message);
	}

}
