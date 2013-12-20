package org.gemoc.gemoc_language_workbench.api.exceptions;

public class EventInjectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Throwable cause;
	private String message;

	public String getMessage() {
		return this.message;
	}

	public EventInjectionException(String s) {
		this.message = s;
	}

	public EventInjectionException(Throwable e) {
		this.cause = e;
		this.message = e.getMessage();
	}

	public Throwable getCause() {
		return this.cause;
	}

}
