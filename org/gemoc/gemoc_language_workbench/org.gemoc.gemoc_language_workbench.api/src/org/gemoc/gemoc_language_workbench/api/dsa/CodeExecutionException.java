package org.gemoc.gemoc_language_workbench.api.dsa;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;

public class CodeExecutionException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9178319370796707893L;

	private ActionCall _call;
	
	public CodeExecutionException(String message, ActionCall call)
	{
		this(message, null, call);
	}

	public CodeExecutionException(String message, Exception innerException, ActionCall call)
	{
		super(message, innerException);
		_call = call;
	}

	public ActionCall getActionCall()
	{
		return _call;
	}
	
}
