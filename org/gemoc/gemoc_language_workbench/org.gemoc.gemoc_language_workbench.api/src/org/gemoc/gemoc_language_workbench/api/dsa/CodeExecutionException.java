package org.gemoc.gemoc_language_workbench.api.dsa;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;

public class CodeExecutionException extends Exception
{

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

}
