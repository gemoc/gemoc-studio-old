package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.Collection;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;

/**
 * A CodeExecutor is an entity responsible for being able to invoke a method on
 * an object and parameters, based on the method's name. It must have knowledge
 * about how the code is compiled into Java Bytecode, and if any particular
 * strategy must be used to locate the correct method.
 * 
 */
public interface ICodeExecutor 
{
	
	public Object execute(ActionCall call) throws CodeExecutionException;
	public Object execute(Object caller, String methodName, Collection<Object> parameters) throws CodeExecutionException;

}
