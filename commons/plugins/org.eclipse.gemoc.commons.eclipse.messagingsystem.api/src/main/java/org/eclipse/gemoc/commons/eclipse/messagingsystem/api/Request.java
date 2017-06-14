package org.eclipse.gemoc.commons.eclipse.messagingsystem.api;

import java.io.Serializable;

import org.eclipse.gemoc.commons.eclipse.messagingsystem.api.MessagingSystem.Kind;
import org.eclipse.gemoc.commons.messagingsystem.api.reference.Reference;

/*
 * This object is send through a socket as
 * a message between two JVM. It describes the remote
 * call to a MessagingSystem.
 * @see org.kermeta.utils.systemservices.api.messaging
 */
public class Request implements Serializable{

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	//TODO: logProblem not implemented yet
	public static enum Method {
		clearLog, log, logProblem, initProgress, progress, doneProgress 
	}
	
	/*
	 * Name of the called method
	 */
	public Method calledMethod;
	
	/*
	 * Parameters of the called method.
	 * 
	 * Some of them may be null, depends 
	 * of calledMethod
	 */
	public Kind msgKind;
	public String message;
	public String messageGroup;
	public String progressGroup;
	public Throwable senderTrace;
	public Reference causeObject;
	public int nbUnit;

}