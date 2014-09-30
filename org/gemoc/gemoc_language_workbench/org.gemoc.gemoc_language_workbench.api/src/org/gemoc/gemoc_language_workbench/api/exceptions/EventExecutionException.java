package org.gemoc.gemoc_language_workbench.api.exceptions;

/**
 * Exception that indicates an issue during the execution of a Domain/Model
 * -Specific Event.
 * 
 * @author flatombe
 * 
 */
public class EventExecutionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Throwable cause;

	public EventExecutionException(Throwable e) {
		this.cause = e;
	}
	
	public Throwable getCause() {
		return this.cause;
	}
}
