package org.gemoc.gemoc_language_workbench.api.dsa;

import java.lang.reflect.InvocationTargetException;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;

/**
 * A blob containing all the informations of a method call : an object, a
 * method, a list of parameters.
 * 
 * TODO : What will we do with checked exceptions ?
 * 
 * @author dvojtise
 * @author flatombe
 * 
 */
public interface MethodCall 
{

	/**
	 * Invokes the method on the object with the given parameters. Returns the
	 * Object returned by the invoked method.
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Object invoke(ActionCall actionCall) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException;

}
