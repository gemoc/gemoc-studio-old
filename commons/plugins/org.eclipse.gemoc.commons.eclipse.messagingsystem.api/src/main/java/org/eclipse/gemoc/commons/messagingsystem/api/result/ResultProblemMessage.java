/*$Id: $
* Project : org.kermeta.language.api
* License : EPL
* Copyright : IRISA / INRIA / Universite de Rennes 1
* ----------------------------------------------------------------------------
* Creation date : 12/08/2010
* Authors : 
*			Didier Vojtisek <didier.vojtisek@inria.fr>
*/
package org.eclipse.gemoc.commons.messagingsystem.api.result;

import org.eclipse.gemoc.commons.messagingsystem.api.reference.Reference;




/**
 * Message for problem events
 */
public class ResultProblemMessage {
	
	/**
	 * Severity levels for ProblemMessage
	 */
	public enum Severity {WARNING, ERROR, FATAL, OK};
	
	/**
	 *  Message to transmit. 
	 */
	protected String message;
	
	/**
	 * Optional object that caused the problem
	 * A message processing component may use this information to enhance the display 
	 * (marking in the user interface, enhanced message, use of traceability, ...)
	 */
	protected Reference causeObject=null;
	
	/**
	 * severity of the problem
	 */
	protected Severity severity;

	/**
	 * An exception that allows to trace the sender of the message
	 */
	protected Throwable senderTrace = null;
	
	/**
	 * Constructor
	 * @param message the message content
	 * @param messageGroup the sender group of the message
	 * @param senderTrace the sender trace
	 * @param causeObject the object (resource) that cause the problem message
	 * @param severity the severity of the problem represented by the problemMessage
	 */
	public ResultProblemMessage(Severity severity, 
			String message,  
			Throwable senderTrace, 
			Reference causeObject
			) {
		//super(message, userLevel, messageGroup, senderTrace);
		this.causeObject = causeObject;
		this.severity = severity;
		this.message = message;
		this.senderTrace = senderTrace;
	}

	/**
	 * @return the causeObject
	 */
	public Object getCauseObject() {
		return causeObject;
	}

	/**
	 * @param causeObject the causeObject to set
	 */
	public void setCauseObject(Reference causeObject) {
		this.causeObject = causeObject;
	}

	/**
	 * @return the severity
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Throwable getSenderTrace() {
		return senderTrace;
	}

	public void setSenderTrace(Throwable senderTrace) {
		this.senderTrace = senderTrace;
	} 

	
}
