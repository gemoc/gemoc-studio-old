package org.gemoc.gemoc_language_workbench.api.exceptions;

/**
 * Exception that indicates an issue during the convertion into a FeedbackData
 * of the result of the execution of a Model-Specific Action.
 * 
 * @author flatombe
 * 
 */
public class InvokationResultConvertionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Throwable cause;

	public InvokationResultConvertionException(Throwable e) {
		this.cause = e;
	}

	public Throwable getCause() {
		return this.cause;
	}
}
